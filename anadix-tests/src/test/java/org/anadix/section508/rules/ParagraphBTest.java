package org.anadix.section508.rules;

import java.util.Collection;

import org.anadix.ReportItem;
import org.anadix.html.AppletTag;
import org.anadix.html.HtmlElement;
import org.anadix.html.ObjectTag;
import org.anadix.html.ParamTag;
import org.anadix.section508.report.MultimediaNeedAlternative;

public class ParagraphBTest extends RulesetTest {

	public ParagraphBTest() throws IllegalStateException {
		super("paragraph-b.drl");
	}

	/*
	 * rule "multimedia applet"
	 */
	public void testRule1_1() {
		AppletTag tag = factory.createAppletTag(dummyId, body, dummyPropeties);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}

	/*
	 * rule "multimedia object"
	 */
	public void testRule2_1() {
		ObjectTag tag = factory.createObjectTag(dummyId, body, dummyPropeties);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}

	/*
	 * rule "multimedia param"
	 */
	public void testRule3_1() {
		ParamTag tag = factory.createParamTag(dummyId, body, dummyPropeties);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}

	/*
	 * rule "multimedia embed"
	 */
	public void testRule4_1() {
		HtmlElement tag = factory.createTag(dummyId, "embed", body, dummyPropeties);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}

	public void testRule4_2() {
		HtmlElement tag = factory.createTag(dummyId, "table", body, dummyPropeties);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}
}
