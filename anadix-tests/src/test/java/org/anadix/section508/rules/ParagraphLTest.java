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
import java.util.Properties;

import org.anadix.ReportItem;
import org.anadix.html.HtmlElement;
import org.anadix.section508.report.DocumentMissingNoscript;
import org.anadix.section508.report.HrefContainsJavascript;
import org.testng.annotations.Test;

@Test
public class ParagraphLTest extends RulesetTest {
	public ParagraphLTest() {
		super("paragraph-l.drl");
	}

	public void testRule1_1() {
		HtmlElement script = factory.createScriptTag(getUniqueId(), body, dummyAttributes);
		script.setSource(dummySource);

		Collection<ReportItem> report = evaluate(script);

		assertReportContains(report, DocumentMissingNoscript.class);
	}

	public void testRule1_2() {
		HtmlElement script = factory.createScriptTag(getUniqueId(), body, dummyAttributes);
		script.setSource(dummySource);
		HtmlElement script2 = factory.createScriptTag(getUniqueId(), body, dummyAttributes);
		script.setSource(dummySource);

		Collection<ReportItem> report = evaluate(script, script2);

		assertReportContains(report, DocumentMissingNoscript.class);
	}

	public void testRule1_3() {
		HtmlElement script = factory.createScriptTag(getUniqueId(), body, dummyAttributes);
		script.setSource(dummySource);
		HtmlElement noscript = factory.createNoscriptTag(getUniqueId(), body, dummyAttributes);
		noscript.setSource(dummySource);

		Collection<ReportItem> report = evaluate(script, noscript);

		assertReportContains(report, DocumentMissingNoscript.class);
	}

	public void testRule1_4() {
		HtmlElement script = factory.createScriptTag(getUniqueId(), body, dummyAttributes);
		script.setSource(dummySource);
		HtmlElement noscript = factory.createNoscriptTag(getUniqueId(), body, dummyAttributes);
		noscript.setSource(dummySource);
		noscript.setTextContent("dummy text content");

		Collection<ReportItem> report = evaluate(script, noscript);

		assertReportNotContains(report, DocumentMissingNoscript.class);
	}

	public void testRule2_1() {
		Properties attributes = new Properties();
		attributes.setProperty("href", "javascript:void()");
		HtmlElement a = factory.createATag(getUniqueId(), body, attributes);
		a.setSource(dummySource);

		Collection<ReportItem> report = evaluate(a);

		assertReportContains(report, HrefContainsJavascript.class, a.getSource());
	}

	public void testRule2_2() {
		Properties attributes = new Properties();
		attributes.setProperty("href", "dummy.html");
		HtmlElement a = factory.createATag(getUniqueId(), body, attributes);
		a.setSource(dummySource);

		Collection<ReportItem> report = evaluate(a);

		assertReportNotContains(report, HrefContainsJavascript.class, a.getSource());
	}

	public void testRule2_3() {
		HtmlElement a = factory.createATag(getUniqueId(), body, dummyAttributes);
		a.setSource(dummySource);

		Collection<ReportItem> report = evaluate(a);

		assertReportNotContains(report, HrefContainsJavascript.class, a.getSource());
	}

	public void testRule3_1() {
		Properties attributes = new Properties();
		attributes.setProperty("href", "javascript:void()");
		HtmlElement a = factory.createAreaTag(getUniqueId(), body, attributes);
		a.setSource(dummySource);

		Collection<ReportItem> report = evaluate(a);

		assertReportContains(report, HrefContainsJavascript.class, a.getSource());
	}

	public void testRule3_2() {
		Properties attributes = new Properties();
		attributes.setProperty("href", "dummy.html");
		HtmlElement a = factory.createAreaTag(getUniqueId(), body, attributes);
		a.setSource(dummySource);

		Collection<ReportItem> report = evaluate(a);

		assertReportNotContains(report, HrefContainsJavascript.class, a.getSource());
	}

	public void testRule3_3() {
		HtmlElement a = factory.createAreaTag(getUniqueId(), body, dummyAttributes);
		a.setSource(dummySource);

		Collection<ReportItem> report = evaluate(a);

		assertReportNotContains(report, HrefContainsJavascript.class, a.getSource());
	}

}
