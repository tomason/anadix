package org.anadix.section508.rules;

import java.util.Collection;
import java.util.Properties;

import org.anadix.ReportItem;
import org.anadix.html.HtmlElement;
import org.anadix.html.LinkTag;
import org.anadix.section508.report.DocumentContainsStyle;
import org.anadix.section508.report.ElementContainsStyle;

public class ParagraphDTest extends RulesetTest {
	public ParagraphDTest() {
		super("paragraph-d.drl");
	}

	/*
	 * rule "stylesheets present"
	 */
	public void testRule1_1() {
		Properties attributes = new Properties();
		attributes.setProperty("rel", "stylesheet");
		LinkTag tag = factory.createLinkTag(dummyId, html, attributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, DocumentContainsStyle.class);
	}

	public void testRule1_2() {
		LinkTag tag = factory.createLinkTag(dummyId, html, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, DocumentContainsStyle.class);
	}

	public void testRule1_3() {
		Properties attributes = new Properties();
		attributes.setProperty("style", "color: #FFFFFF");
		HtmlElement tag = factory.createH1Tag(dummyId, body, attributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, DocumentContainsStyle.class);
	}

	public void testRule1_4() {
		HtmlElement tag = factory.createH1Tag(dummyId, body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, DocumentContainsStyle.class);
	}

	/*
	 * rule "styles in tags"
	 */
	public void testRule2_1() {
		Properties attributes = new Properties();
		attributes.setProperty("style", "color: #FFFFFF");
		HtmlElement tag = factory.createH1Tag(dummyId, body, attributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, ElementContainsStyle.class, tag.getSource());
	}

	public void testRule2_2() {
		HtmlElement tag = factory.createH1Tag(dummyId, body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, ElementContainsStyle.class, tag.getSource());
	}
}
