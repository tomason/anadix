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
import org.anadix.html.LinkTag;
import org.anadix.section508.report.DocumentContainsStyle;
import org.anadix.section508.report.ElementContainsStyle;
import org.testng.annotations.Test;

@Test
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
		LinkTag tag = factory.createLinkTag(getUniqueId(), html, attributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, DocumentContainsStyle.class);
	}

	public void testRule1_2() {
		LinkTag tag = factory.createLinkTag(getUniqueId(), html, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, DocumentContainsStyle.class);
	}

	public void testRule1_3() {
		Properties attributes = new Properties();
		attributes.setProperty("style", "color: #FFFFFF");
		HtmlElement tag = factory.createH1Tag(getUniqueId(), body, attributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, DocumentContainsStyle.class);
	}

	public void testRule1_4() {
		HtmlElement tag = factory.createH1Tag(getUniqueId(), body, dummyAttributes);
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
		HtmlElement tag = factory.createH1Tag(getUniqueId(), body, attributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, ElementContainsStyle.class, tag.getSource());
	}

	public void testRule2_2() {
		HtmlElement tag = factory.createH1Tag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, ElementContainsStyle.class, tag.getSource());
	}
}
