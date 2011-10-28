package org.anadix.section508.rules;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.anadix.ReportItem;
import org.anadix.html.HtmlElement;
import org.anadix.section508.report.InputMissingLabel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParagraphNTest extends RulesetTest {
	private HtmlElement form;

	public ParagraphNTest() {
		super("paragraph-n.drl");
	}

	public void prepareVariables() {
		form = factory.createFormTag(getUniqueId(), body, dummyAttributes);
		form.setSource(dummySource);
	}

	@DataProvider(name = "error")
	public Iterator<Object[]> getErrorTypes() {
		Set<Object[]> result = new HashSet<Object[]>();

		result.add(new Object[] { "checkbox" });
		result.add(new Object[] { "file" });
		result.add(new Object[] { "password" });
		result.add(new Object[] { "radio" });
		result.add(new Object[] { "text" });

		return result.iterator();
	}

	@DataProvider(name = "ok")
	public Iterator<Object[]> getOkTypes() {
		Set<Object[]> result = new HashSet<Object[]>();

		result.add(new Object[] { "button" });
		result.add(new Object[] { "submit" });
		result.add(new Object[] { "reset" });
		result.add(new Object[] { "hidden" });
		result.add(new Object[] { "image" });

		return result.iterator();
	}

	@DataProvider(name = "all")
	public Iterator<Object[]> getAllTypes() {
		Set<Object[]> result = new HashSet<Object[]>();

		result.add(new Object[] { "checkbox" });
		result.add(new Object[] { "file" });
		result.add(new Object[] { "password" });
		result.add(new Object[] { "radio" });
		result.add(new Object[] { "text" });
		result.add(new Object[] { "button" });
		result.add(new Object[] { "submit" });
		result.add(new Object[] { "reset" });
		result.add(new Object[] { "hidden" });
		result.add(new Object[] { "image" });

		return result.iterator();
	}

	@Test(dataProvider = "error")
	public void testRule2_1(String type) {
		Properties attributes = new Properties();
		attributes.setProperty("type", type);
		HtmlElement input = factory.createInputTag(getUniqueId(), form, attributes);
		input.setSource(dummySource);

		Collection<ReportItem> report = evaluate(form, input);

		assertReportContains(report, InputMissingLabel.class, input.getSource());
	}

	@Test(dataProvider = "ok")
	public void testRule2_2(String type) {
		Properties attributes = new Properties();
		attributes.setProperty("type", type);
		HtmlElement input = factory.createInputTag(getUniqueId(), form, attributes);
		input.setSource(dummySource);

		Collection<ReportItem> report = evaluate(form, input);

		assertReportNotContains(report, InputMissingLabel.class, input.getSource());
	}

	@Test(dataProvider = "error")
	public void testRule2_3(String type) {
		String inputId = "test-input";
		Properties attributes = new Properties();
		attributes.setProperty("type", type);
		attributes.setProperty("id", inputId);

		HtmlElement label = factory.createLabelTag(getUniqueId(), form, dummyAttributes);
		label.setSource(dummySource);
		HtmlElement input = factory.createInputTag(getUniqueId(), form, attributes);
		input.setSource(dummySource);


		Collection<ReportItem> report = evaluate(form, input);

		assertReportContains(report, InputMissingLabel.class, input.getSource());
	}

	@Test(dataProvider = "error")
	public void testRule2_4(String type) {
		String inputId = "test-input";
		Properties inputAttributes = new Properties();
		inputAttributes.setProperty("type", type);
		inputAttributes.setProperty("id", inputId);

		Properties labelAttributes = new Properties();
		inputAttributes.setProperty("for", inputId);

		HtmlElement label = factory.createLabelTag(getUniqueId(), body, labelAttributes);
		label.setSource(dummySource);
		HtmlElement input = factory.createInputTag(getUniqueId(), form, inputAttributes);
		input.setSource(dummySource);


		Collection<ReportItem> report = evaluate(form, label, input);

		assertReportContains(report, InputMissingLabel.class, input.getSource());
	}

	@Test(dataProvider = "all")
	public void testRule2_5(String type) {
		String inputId = "test-input";
		Properties inputAttributes = new Properties();
		inputAttributes.setProperty("id", inputId);
		inputAttributes.setProperty("type", type);

		Properties labelAttributes = new Properties();
		labelAttributes.setProperty("for", inputId);

		HtmlElement label = factory.createLabelTag(getUniqueId(), form, labelAttributes);
		label.setSource(dummySource);
		HtmlElement input = factory.createInputTag(getUniqueId(), form, inputAttributes);
		input.setSource(dummySource);


		Collection<ReportItem> report = evaluate(form, label, input);

		assertReportNotContains(report, InputMissingLabel.class, input.getSource());
	}

	@Test(dataProvider = "all")
	public void testRule2_6(String type) {
		Properties inputAttributes = new Properties();
		inputAttributes.setProperty("type", type);

		HtmlElement input = factory.createInputTag(getUniqueId(), body, inputAttributes);
		input.setSource(dummySource);

		Collection<ReportItem> report = evaluate(input);

		assertReportNotContains(report, InputMissingLabel.class, input.getSource());
	}

}
