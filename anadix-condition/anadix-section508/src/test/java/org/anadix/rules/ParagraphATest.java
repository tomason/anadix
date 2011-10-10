package org.anadix.rules;

import static org.testng.Assert.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Properties;

import org.anadix.ItemStatus;
import org.anadix.ReportItem;
import org.anadix.html.AppletTag;
import org.anadix.html.AreaTag;
import org.anadix.html.IframeTag;
import org.anadix.html.ImgTag;
import org.anadix.html.InputTag;
import org.anadix.html.LabelTag;
import org.anadix.html.ObjectTag;
import org.anadix.section508.report.ImgEmptyAlt;
import org.anadix.section508.report.MissingAlt;


public class ParagraphATest extends RulesetTest {
	public ParagraphATest() {
		super("paragraph-a.drl");
	}

	/*
	 * rule "img without alt and longdesc"
	 */
	public void testRule1_1() {
		ImgTag tag = factory.createImgTag(new BigInteger("10101"), body, new Properties());
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule1_2() {
		Properties attributes = new Properties();
		attributes.setProperty("alt", "Some alternative text");
		ImgTag tag = factory.createImgTag(new BigInteger("10101"), body, attributes);
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule1_3() {
		Properties attributes = new Properties();
		attributes.setProperty("longdesc", "londesc.html");
		ImgTag tag = factory.createImgTag(new BigInteger("10101"), body, attributes);
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule1_4() {
		Properties attributes = new Properties();
		attributes.setProperty("longdesc", "londesc.html");
		attributes.setProperty("alt", "Some alternative text");
		ImgTag tag = factory.createImgTag(new BigInteger("10101"), body, attributes);
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	/*
	 * rule "input without alt or label"
	 */
	public void testRule2_1() {
		InputTag tag = factory.createInputTag(new BigInteger("10102"), body, new Properties());
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule2_2() {
		Properties attributes = new Properties();
		attributes.setProperty("alt", "Some alternative text");
		InputTag tag = factory.createInputTag(new BigInteger("10102"), body, attributes);
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule2_3() {
		String name = "testInputTag";

		Properties inputAttributes = new Properties();
		inputAttributes.setProperty("name", name);
		InputTag tag = factory.createInputTag(new BigInteger("10102"), body, inputAttributes);
		tag.setSource("dummy source");

		Properties labelAttributes = new Properties();
		labelAttributes.setProperty("for", name);
		LabelTag label = factory.createLabelTag(new BigInteger("10101"), body, labelAttributes);
		label.setSource("dummy2 source");
		Collection<ReportItem> items = evaluate(label, tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule2_4() {
		String name = "testInputTag";

		Properties inputAttributes = new Properties();
		inputAttributes.setProperty("name", name);
		inputAttributes.setProperty("alt", "Some alternative text");
		InputTag tag = factory.createInputTag(new BigInteger("10102"), body, inputAttributes);
		tag.setSource("dummy source");

		Properties labelAttributes = new Properties();
		labelAttributes.setProperty("for", name);
		LabelTag label = factory.createLabelTag(new BigInteger("10101"), body, labelAttributes);
		label.setSource("dummy2 source");
		Collection<ReportItem> items = evaluate(label, tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	/*
	 * rule "object without text content"
	 */
	public void testRule3_1() {
		ObjectTag tag = factory.createObjectTag(new BigInteger("10101"), body, new Properties());
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule3_2() {
		ObjectTag tag = factory.createObjectTag(new BigInteger("10101"), body, new Properties());
		tag.setTextContent("text content explaining puropse of the object");
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	/*
	 * rule "applet without alt and text content"
	 */
	public void testRule4_1() {
		AppletTag tag = factory.createAppletTag(new BigInteger("10101"), body, new Properties());
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule4_2() {
		Properties attributes = new Properties();
		attributes.setProperty("alt", "alternative text with some meaning");
		AppletTag tag = factory.createAppletTag(new BigInteger("10101"), body, attributes);
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule4_3() {
		AppletTag tag = factory.createAppletTag(new BigInteger("10101"), body, new Properties());
		tag.setTextContent("text content explaining puropse of the applet");
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule4_4() {
		Properties attributes = new Properties();
		attributes.setProperty("alt", "alternative text with some meaning");
		AppletTag tag = factory.createAppletTag(new BigInteger("10101"), body, attributes);
		tag.setTextContent("text content explaining puropse of the applet");
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	/*
	 * rule "iframe without text content"
	 */
	public void testRule5_1() {
		IframeTag tag = factory.createIframeTag(new BigInteger("10101"), body, new Properties());
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule5_2() {
		IframeTag tag = factory.createIframeTag(new BigInteger("10101"), body, new Properties());
		tag.setTextContent("text content explaining puropse of the applet");
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	/*
	 * rule "area without alt"
	 */
	public void testRule6_1() {
		AreaTag tag = factory.createAreaTag(new BigInteger("10101"), body, new Properties());
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MissingAlt.class, tag.getSource());
	}

	public void testRule6_2() {
		Properties attributes = new Properties();
		attributes.setProperty("alt", "alternative text with some meaning");
		AreaTag tag = factory.createAreaTag(new BigInteger("10101"), body, attributes);
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MissingAlt.class, tag.getSource());
	}

	/**
	 * rule "decorative img"
	 */
	public void testRule7_1() {
		ImgTag tag = factory.createImgTag(new BigInteger("10101"), body, new Properties());
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, ImgEmptyAlt.class, tag.getSource());
	}

	public void testRule7_2() {
		Properties attributes = new Properties();
		attributes.setProperty("alt", "");
		ImgTag tag = factory.createImgTag(new BigInteger("10101"), body, attributes);
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		ReportItem i = assertReportContains(items, ImgEmptyAlt.class, tag.getSource());
		assertEquals(i.getStatus(), ItemStatus.MANUAL);
	}

	public void testRule7_3() {
		Properties attributes = new Properties();
		attributes.setProperty("alt", "some value");
		ImgTag tag = factory.createImgTag(new BigInteger("10101"), body, attributes);
		tag.setSource("dummy source");
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, ImgEmptyAlt.class, tag.getSource());
	}
}
