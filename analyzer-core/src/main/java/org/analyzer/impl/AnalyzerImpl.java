package org.analyzer.impl;


import org.analyzer.Analyzer;
import org.analyzer.ConditionSet;
import org.analyzer.ElementFactory;
import org.analyzer.Parser;
import org.analyzer.Report;
import org.analyzer.Source;
import org.analyzer.factories.ObjectFactory;
import org.analyzer.utils.DroolsResource;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.rule.Rule;
import org.drools.event.rule.DefaultAgendaEventListener;
import org.drools.event.rule.DefaultWorkingMemoryEventListener;
import org.drools.runtime.StatefulKnowledgeSession;

public class AnalyzerImpl implements Analyzer {
	private final Parser parser;
	private final ConditionSet conditions;
	private final KnowledgeBase kbase;

	public AnalyzerImpl(Parser parser, ConditionSet conditions) {
		this.parser = parser;
		this.conditions = conditions;

		if (!parser.getElementFactoryClass().isAssignableFrom(conditions.getElementFactoryUsed())) {
			throw new IllegalStateException("Parser " + parser.getClass() + " and condition set " + conditions.getClass() + " don't match");
		}

		kbase = createKnowledgeBase();
	}

	public Report analyze(Source source) {
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

		if (Boolean.getBoolean("debug")) {
			ksession.addEventListener(new DefaultAgendaEventListener());
			ksession.addEventListener(new DefaultWorkingMemoryEventListener());
		}

		try {
			ElementFactory ef = ElementFactory.createFactory(
					ObjectFactory.getElementFactoryClass(null),
					ksession
					);

			parser.setElementFactory(ef);

			parser.parse(source);
		} catch (Exception ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}

		ksession.fireAllRules();

		Report report = new Report(ksession);

		ksession.dispose();

		return report;
	}

	private KnowledgeBase createKnowledgeBase() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		for (DroolsResource res : parser.getDroolsResources()) {
			res.insertInto(kbuilder);
		}

		if (kbuilder.hasErrors()) {
			throw new RuntimeException("Parser resources: " + kbuilder.getErrors().toString());
		}

		for (DroolsResource res : conditions.getDroolsResources()) {
			res.insertInto(kbuilder);
		}
		if (kbuilder.hasErrors()) {
			throw new RuntimeException("ConditionSet resources: " + kbuilder.getErrors().toString());
		}

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		if (Boolean.getBoolean("debug")) {
			for (KnowledgePackage pkg : kbase.getKnowledgePackages()) {
				System.out.println(" > " + pkg.getName());
				for (Rule r : pkg.getRules()) {
					System.out.println("  |- " + r.getName());
				}
			}
		}

		return kbase;
	}
}
