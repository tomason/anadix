package org.anadix.section508.rules;

import java.util.Collection;

import org.anadix.ReportItem;
import org.anadix.html.HtmlElement;
import org.anadix.section508.report.DocumentSkipNavigation;
import org.testng.annotations.Test;

@Test
public class ParagraphOTest extends RulesetTest {
	public ParagraphOTest() {
		super("paragraph-o.drl");
	}

	public void testRule1_1() {
		HtmlElement a = factory.createATag(getUniqueId(), body, dummyAttributes);

		Collection<ReportItem> report = evaluate(a);

		assertReportContains(report, DocumentSkipNavigation.class);
	}

	public void testRule1_2() {
		Collection<ReportItem> report = evaluate();

		assertReportNotContains(report, DocumentSkipNavigation.class);
	}
}
