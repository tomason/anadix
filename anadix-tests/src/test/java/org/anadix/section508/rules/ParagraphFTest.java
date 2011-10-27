package org.anadix.section508.rules;

import java.util.Collection;
import java.util.Properties;

import org.anadix.ItemStatus;
import org.anadix.ReportItem;
import org.anadix.html.ImgTag;
import org.anadix.section508.report.ImgIsMap;

public class ParagraphFTest extends RulesetTest {
	public ParagraphFTest() {
		super("paragraph-f.drl");
	}

	/*
	 * rule "server side map warning"
	 */
	public void testRule1_1() {
		Properties attributes = new Properties();
		attributes.setProperty("ismap", "ismap");
		ImgTag tag = factory.createImgTag(getUniqueId(), body, attributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, ImgIsMap.class, ItemStatus.WARNING, tag.getSource());
	}

	public void testRule1_2() {
		ImgTag tag = factory.createImgTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, ImgIsMap.class, ItemStatus.WARNING, tag.getSource());
	}
}
