package org.anadix.rules;

import java.util.Collection;
import java.util.Properties;

import org.anadix.ReportItem;
import org.anadix.html.ImgTag;
import org.anadix.section508.report.ImgIsMap;

public class ParagraphETest extends RulesetTest {

	public ParagraphETest() {
		super("paragraph-e.drl");
	}

	/*
	 * rule "server side map manual check"
	 */
	public void testRule1_1() {
		Properties attributes = new Properties();
		attributes.setProperty("ismap", "ismap");
		ImgTag tag = factory.createImgTag(dummyId, body, attributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, ImgIsMap.class, tag.getSource());
	}

	public void testRule1_2() {
		ImgTag tag = factory.createImgTag(dummyId, body, dummyPropeties);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, ImgIsMap.class, tag.getSource());
	}
}