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
import org.anadix.section508.report.ElementCauseFlickering;
import org.testng.annotations.Test;

@Test
public class ParagraphJTest extends RulesetTest {
	public ParagraphJTest() {
		super("paragraph-j.drl");
	}

	public void testRule1_1() {
		HtmlElement tag = factory.createObjectTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);
		assertReportContains(report, ElementCauseFlickering.class, tag.getSource());
	}

	public void testRule2_1() {
		HtmlElement tag = factory.createAppletTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);
		assertReportContains(report, ElementCauseFlickering.class, tag.getSource());
	}

	public void testRule3_1() {
		Properties attributes = new Properties();
		attributes.setProperty("src", "dummy.gif");
		HtmlElement tag = factory.createImgTag(getUniqueId(), body, attributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);
		assertReportContains(report, ElementCauseFlickering.class, tag.getSource());
	}

	public void testRule3_2() {
		Properties attributes = new Properties();
		attributes.setProperty("src", "dummy.png");
		HtmlElement tag = factory.createImgTag(getUniqueId(), body, attributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);
		assertReportNotContains(report, ElementCauseFlickering.class, tag.getSource());
	}

	public void testRule3_3() {
		HtmlElement tag = factory.createImgTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);
		assertReportNotContains(report, ElementCauseFlickering.class, tag.getSource());
	}

	public void testRule4_1() {
		HtmlElement tag = factory.createTag(getUniqueId(), "blink", body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);
		assertReportContains(report, ElementCauseFlickering.class, tag.getSource());
	}

	public void testRule4_2() {
		HtmlElement tag = factory.createTag(getUniqueId(), "marquee", body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> report = evaluate(tag);
		assertReportContains(report, ElementCauseFlickering.class, tag.getSource());
	}

	public void testRule5() {
		Collection<ReportItem> report = evaluate();
		assertReportContains(report, ElementCauseFlickering.class);
	}
}
