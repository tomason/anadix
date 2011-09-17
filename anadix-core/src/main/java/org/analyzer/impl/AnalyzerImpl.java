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
package org.analyzer.impl;

import java.util.Collection;

import org.analyzer.Analyzer;
import org.analyzer.ConditionSet;
import org.analyzer.ElementFactory;
import org.analyzer.Parser;
import org.analyzer.Report;
import org.analyzer.Source;
import org.analyzer.exceptions.ParserException;
import org.analyzer.utils.DroolsResource;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class AnalyzerImpl implements Analyzer {
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

		/* TODO debug into log by default
		if (Boolean.getBoolean("debug")) {
			ksession.addEventListener(new DefaultAgendaEventListener());
			ksession.addEventListener(new DefaultWorkingMemoryEventListener());
		}
		 */

		ElementFactory ef = AbstractElementFactory.createFactory(
				conditions.getElementFactoryClass(),
				ksession
				);

		parser.setElementFactory(ef);

		try {
			parser.parse(source);
		} catch (ParserException ex) {
			// FIXME log the exception instead
			System.err.println(ex);
			ex.printStackTrace();
		}

		ksession.fireAllRules();

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
			//TODO log warning
		}

		if ((c = conditions.getDroolsResources()) != null) {
			for (DroolsResource res : c) {
				res.insertInto(kbuilder);
			}
			if (kbuilder.hasErrors()) {
				throw new RuntimeException("ConditionSet resources: " + kbuilder.getErrors().toString());
			}
		} else {
			//TODO log warning
		}

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		/* TODO debug info to log instead of console
		if (Boolean.getBoolean("debug")) {
			for (KnowledgePackage pkg : kbase.getKnowledgePackages()) {
				System.out.println(" > " + pkg.getName());
				for (Rule r : pkg.getRules()) {
					System.out.println("  |- " + r.getName());
				}
			}
		}
		 */

		return kbase;
	}
}
