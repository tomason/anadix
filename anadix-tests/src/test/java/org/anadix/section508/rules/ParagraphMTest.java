package org.anadix.section508.rules;

import java.util.Collection;

import org.anadix.ReportItem;
import org.anadix.html.HtmlElement;
import org.anadix.section508.report.ObjectCompliesConditions;
import org.testng.annotations.Test;

@Test
public class ParagraphMTest extends RulesetTest {

	public ParagraphMTest() {
		super("paragraph-m.drl");
	}

	public void testRule1_1() {
		HtmlElement tag = factory.createObjectTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);

		assertReportContains(report, ObjectCompliesConditions.class, tag.getSource());
	}

	public void testRule2_1() {
		HtmlElement tag = factory.createAppletTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);

		assertReportContains(report, ObjectCompliesConditions.class, tag.getSource());
	}

	public void testRule3_1() {
		HtmlElement tag = factory.createTag(getUniqueId(), "embed", body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);

		assertReportContains(report, ObjectCompliesConditions.class, tag.getSource());
	}
}
