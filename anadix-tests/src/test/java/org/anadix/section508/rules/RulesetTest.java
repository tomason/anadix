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
package org.anadix.section508.rules;

import static org.testng.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.anadix.ItemStatus;
import org.anadix.ReportItem;
import org.anadix.html.BodyTag;
import org.anadix.html.HTMLElementFactory;
import org.anadix.html.HtmlTag;
import org.anadix.section508.Section508;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.command.Command;
import org.drools.command.CommandFactory;
import org.drools.io.ResourceFactory;
import org.drools.runtime.ExecutionResults;
import org.drools.runtime.StatelessKnowledgeSession;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;
import org.testng.annotations.Test;

@Test
public abstract class RulesetTest {
	private final KnowledgeBase kbase;
	protected final HTMLElementFactory factory;
	protected final HtmlTag html;
	protected final BodyTag body;

	protected static final String dummySource = "dummy source";
	protected static final Properties dummyAttributes = new Properties();

	public RulesetTest(String source) throws IllegalStateException {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("commons.drl", Section508.class), ResourceType.DRL);
		kbuilder.add(ResourceFactory.newClassPathResource(source, Section508.class), ResourceType.DRL);
		kbuilder.add(ResourceFactory.newClassPathResource("query.drl", getClass()), ResourceType.DRL);

		if (kbuilder.hasErrors()) {
			throw new IllegalStateException(kbuilder.getErrors().toString());
		}

		kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		factory = new HTMLElementFactory(KnowledgeBaseFactory.newKnowledgeBase().newStatefulKnowledgeSession());
		html = factory.createHtmlTag(new BigInteger("1"), new Properties());
		body = factory.createBodyTag(new BigInteger("101"), html, new Properties());
		id = BigInteger.ONE;
	}

	private static BigInteger id;
	protected static synchronized BigInteger getUniqueId() {
		id = id.add(BigInteger.ONE);

		return id;
	}

	protected Collection<ReportItem> evaluate(Object... elements) {
		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
		Collection<ReportItem> reportItems = new ArrayList<ReportItem>();

		List<Command<?>> commands = new ArrayList<Command<?>>();
		for (Object o : elements) {
			commands.add(CommandFactory.newInsert(o));
		}
		commands.add(CommandFactory.newFireAllRules());
		commands.add(CommandFactory.newQuery("reports", "getReports"));

		ExecutionResults results = ksession.execute(CommandFactory.newBatchExecution(commands));
		//System.out.println(results.getIdentifiers());

		QueryResults queryResults = (QueryResults) results.getValue("reports");
		for (QueryResultsRow result : queryResults) {
			reportItems.add((ReportItem)result.get("item"));
		}

		return reportItems;

	}

	protected static ReportItem assertReportContains(Collection<ReportItem> report, Class<? extends ReportItem> clazz) {
		return assertReportContains(report, clazz, "");
	}

	protected static ReportItem assertReportContains(Collection<ReportItem> report, Class<? extends ReportItem> clazz, String text) {
		return assertReportContains(report, clazz, null, text);
	}

	protected static ReportItem assertReportContains(Collection<ReportItem> report, Class<? extends ReportItem> clazz, ItemStatus status, String text) {
		ReportItem i = loopItems(report.iterator(), clazz, status, text);
		assertNotNull(i, "Didn't find report of class " + clazz.getSimpleName());

		return i;
	}

	protected static void assertReportNotContains(Collection<ReportItem> report, Class<? extends ReportItem> clazz) {
		assertReportNotContains(report, clazz, null, "");
	}

	protected static void assertReportNotContains(Collection<ReportItem> report, Class<? extends ReportItem> clazz, String text) {
		assertReportNotContains(report, clazz, null, text);
	}

	protected static void assertReportNotContains(Collection<ReportItem> report, Class<? extends ReportItem> clazz, ItemStatus status, String text) {
		ReportItem i = loopItems(report.iterator(), clazz, status, text);
		assertNull(i, "Found an error report " + i);
	}

	private static ReportItem loopItems(Iterator<ReportItem> iterator, Class<? extends ReportItem> clazz, ItemStatus status, String text) {
		if (!iterator.hasNext()) {
			return null;
		}

		ReportItem item = iterator.next();
		if (
				item.getClass() == clazz &&
				item.getItemText().contains(text) &&
				(status == null || item.getStatus() == status)) {
			return item;
		}

		return loopItems(iterator, clazz, status, text);
	}
}
