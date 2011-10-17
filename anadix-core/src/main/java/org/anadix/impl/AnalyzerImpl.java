/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix.impl;

import java.util.Collection;

import org.anadix.Analyzer;
import org.anadix.ConditionSet;
import org.anadix.ElementFactory;
import org.anadix.Parser;
import org.anadix.Report;
import org.anadix.Source;
import org.anadix.exceptions.ParserException;
import org.anadix.utils.DebugAgendaEventListener;
import org.anadix.utils.DebugWorkingMemoryEventListener;
import org.anadix.utils.DroolsResource;
import org.anadix.utils.PackageAgendaFilter;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.rule.Rule;
import org.drools.runtime.StatefulKnowledgeSession;
import org.jboss.logging.Logger;

public class AnalyzerImpl implements Analyzer {
	private static final Logger logger = Logger.getLogger(Analyzer.class);

	private final Parser parser;
	private final ConditionSet conditions;
	private final KnowledgeBase kbase;

	public AnalyzerImpl(Parser parser, ConditionSet conditions) {
		this.parser = parser;
		this.conditions = conditions;

		if (!parser.getElementFactoryClass().isAssignableFrom(conditions.getElementFactoryClass())) {
			throw new IllegalStateException("Parser " + parser.getClass() + " and condition set " + conditions.getClass() + " don't match");
		}

		kbase = createKnowledgeBase();
	}

	public Report analyze(Source source) {
		if (source == null) {
			throw new NullPointerException("source must not be null");
		}
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

		ksession.addEventListener(new DebugAgendaEventListener(logger));
		ksession.addEventListener(new DebugWorkingMemoryEventListener(logger));


		ElementFactory ef = AbstractElementFactory.createFactory(
				conditions.getElementFactoryClass(),
				ksession
				);

		parser.setElementFactory(ef);

		try {
			parser.parse(source);
			ksession.fireAllRules(new PackageAgendaFilter(parser.getRulesPackage()));
		} catch (ParserException ex) {
			logger.error(ex);
		}

		ksession.fireAllRules(new PackageAgendaFilter(conditions.getRulesPackage()));

		Report report = new ReportImpl(ksession, source);

		ksession.dispose();

		return report;
	}

	private KnowledgeBase createKnowledgeBase() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		Collection<DroolsResource> c;
		if ((c = parser.getDroolsResources()) != null) {
			for (DroolsResource res : c) {
				res.insertInto(kbuilder);
			}
			if (kbuilder.hasErrors()) {
				throw new RuntimeException("Parser resources: " + kbuilder.getErrors().toString());
			}
		} else {
			logger.warnf("Parser %s returned null resources!", parser.getClass().getName());
		}

		if ((c = conditions.getDroolsResources()) != null) {
			for (DroolsResource res : c) {
				res.insertInto(kbuilder);
			}
			if (kbuilder.hasErrors()) {
				throw new RuntimeException("ConditionSet resources: " + kbuilder.getErrors().toString());
			}
		} else {
			logger.warnf("Condition set %s returned null resources!", conditions.getClass().getName());
		}

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		for (KnowledgePackage pkg : kbase.getKnowledgePackages()) {
			logger.tracef(" > %s", pkg.getName());
			for (Rule r : pkg.getRules()) {
				logger.tracef("  |- %s", r.getName());
			}
		}

		return kbase;
	}
}
