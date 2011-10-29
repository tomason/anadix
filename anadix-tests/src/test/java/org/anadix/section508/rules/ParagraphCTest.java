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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.anadix.ReportItem;
import org.anadix.html.HtmlElement;
import org.anadix.section508.report.ElementContainsColor;
import org.anadix.section508.report.ElementWrongContrast;
import org.anadix.section508.report.TextContainsColor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class ParagraphCTest extends RulesetTest {
	public ParagraphCTest() {
		super("paragraph-c.drl");
	}

	public void testRule2_1() {
		Properties attributes = new Properties();
		attributes.setProperty("style", "color: #0F0F0F;");
		HtmlElement e = factory.createDivTag(getUniqueId(), body, attributes);
		e.setSource(dummySource);
		Collection<ReportItem> report = evaluate(e);

		assertReportContains(report, ElementContainsColor.class, dummySource);
	}

	public void testRule2_2() {
		Properties attributes = new Properties();
		attributes.setProperty("style", "background-color: #0F0F0F;");
		HtmlElement e = factory.createDivTag(getUniqueId(), body, attributes);
		e.setSource(dummySource);
		Collection<ReportItem> report = evaluate(e);

		assertReportContains(report, ElementContainsColor.class, dummySource);
	}

	public void testRule2_3() {
		HtmlElement e = factory.createDivTag(getUniqueId(), body, dummyAttributes);
		e.setSource(dummySource);
		Collection<ReportItem> report = evaluate(e);

		assertReportNotContains(report, ElementContainsColor.class, dummySource);
	}

	public void testRule3_1() {
		Properties attributes = new Properties();
		attributes.setProperty("style", "color: #0F0F0F; background-color: #0E0E0E;");
		HtmlElement e = factory.createDivTag(getUniqueId(), body, attributes);
		e.setSource(dummySource);
		Collection<ReportItem> report = evaluate(e);

		assertReportContains(report, ElementWrongContrast.class, dummySource);
	}

	public void testRule3_2() {
		Properties attributes = new Properties();
		attributes.setProperty("style", "color: #0E0E0E; background-color: #0F0F0F;");
		HtmlElement e = factory.createDivTag(getUniqueId(), body, attributes);
		e.setSource(dummySource);
		Collection<ReportItem> report = evaluate(e);

		assertReportContains(report, ElementWrongContrast.class, dummySource);
	}

	public void testRule3_3() {
		Properties attributes = new Properties();
		attributes.setProperty("style", "color: #000000; background-color: #FFFFFF;");
		HtmlElement e = factory.createDivTag(getUniqueId(), body, attributes);
		e.setSource(dummySource);
		Collection<ReportItem> report = evaluate(e);

		assertReportNotContains(report, ElementWrongContrast.class, dummySource);
	}

	public void testRule3_4() {
		HtmlElement e = factory.createDivTag(getUniqueId(), body, dummyAttributes);
		e.setSource(dummySource);
		Collection<ReportItem> report = evaluate(e);

		assertReportNotContains(report, ElementWrongContrast.class, dummySource);
	}

	@DataProvider(name = "colors")
	public Iterator<Object[]> getColors() {
		Set<Object[]> result = new HashSet<Object[]>();

		result.add(new Object[] { "black" });
		result.add(new Object[] { "silver" });
		result.add(new Object[] { "gray" });
		result.add(new Object[] { "white" });
		result.add(new Object[] { "maroon" });
		result.add(new Object[] { "red" });
		result.add(new Object[] { "purple" });
		result.add(new Object[] { "fuchsia" });
		result.add(new Object[] { "green" });
		result.add(new Object[] { "lime" });
		result.add(new Object[] { "olive" });
		result.add(new Object[] { "yellow" });
		result.add(new Object[] { "navy" });
		result.add(new Object[] { "blue" });
		result.add(new Object[] { "teal" });
		result.add(new Object[] { "aqua" });

		return result.iterator();
	}

	@Test(dataProvider = "colors")
	public void testColorRules1(String color) {
		final String textContent = "some talking about " + color + " and so on...";
		HtmlElement e = factory.createPTag(getUniqueId(), body, dummyAttributes);
		e.setSource(dummySource);
		e.setTextContent(textContent);

		Collection<ReportItem> result = evaluate(e);

		assertReportContains(result, TextContainsColor.class, dummySource);
		assertReportContains(result, TextContainsColor.class, color.toLowerCase());
	}

	@Test(dataProvider = "colors")
	public void testColorRules2(String color) {
		final String textContent = "some talking about fraking-" + color + "ish and so on...";
		HtmlElement e = factory.createPTag(getUniqueId(), body, dummyAttributes);
		e.setSource(dummySource);
		e.setTextContent(textContent);

		Collection<ReportItem> result = evaluate(e);

		assertReportContains(result, TextContainsColor.class, dummySource);
		assertReportContains(result, TextContainsColor.class, color.toLowerCase());
	}

	@Test(dataProvider = "colors")
	public void testColorRules3(String color) {
		HtmlElement e = factory.createPTag(getUniqueId(), body, dummyAttributes);
		e.setSource(dummySource);
		e.setTextContent(color);

		Collection<ReportItem> result = evaluate(e);

		assertReportContains(result, TextContainsColor.class, dummySource);
		assertReportContains(result, TextContainsColor.class, color.toLowerCase());
	}

	@Test(dataProvider = "colors")
	public void testColorRules4(String color) {
		final String textContent = "some talking about " + color.toUpperCase() + " and so on...";
		HtmlElement e = factory.createPTag(getUniqueId(), body, dummyAttributes);
		e.setSource(dummySource);
		e.setTextContent(textContent);

		Collection<ReportItem> result = evaluate(e);

		assertReportContains(result, TextContainsColor.class, dummySource);
		assertReportContains(result, TextContainsColor.class, color.toLowerCase());
	}

	@Test(dataProvider = "colors")
	public void testColorRules5(String color) {
		Random r = new Random();
		char[] chars = color.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = r.nextBoolean() ? Character.toLowerCase(chars[i]) : Character.toUpperCase(chars[i]);
		}
		color = new String(chars);

		final String textContent = "some talking about " + color + " and so on...";
		HtmlElement e = factory.createPTag(getUniqueId(), body, dummyAttributes);
		e.setSource(dummySource);
		e.setTextContent(textContent);

		Collection<ReportItem> result = evaluate(e);

		assertReportContains(result, TextContainsColor.class, dummySource);
		assertReportContains(result, TextContainsColor.class, color.toLowerCase());
	}

	@Test(dataProvider = "colors")
	public void testColorRules6(String color) {
		Random r = new Random();
		char[] chars = color.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = r.nextBoolean() ? Character.toLowerCase(chars[i]) : Character.toUpperCase(chars[i]);
		}
		color = new String(chars);

		final String textContent = "some talking about fraking-" + color + "ish and so on...";
		HtmlElement e = factory.createPTag(getUniqueId(), body, dummyAttributes);
		e.setSource(dummySource);
		e.setTextContent(textContent);

		Collection<ReportItem> result = evaluate(e);

		assertReportContains(result, TextContainsColor.class, dummySource);
		assertReportContains(result, TextContainsColor.class, color.toLowerCase());
	}
}
