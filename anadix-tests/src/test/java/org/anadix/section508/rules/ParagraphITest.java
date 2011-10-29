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
import org.anadix.section508.report.FrameMissingTitle;
import org.testng.annotations.Test;

@Test
public class ParagraphITest extends RulesetTest {
	public ParagraphITest() {
		super("paragraph-i.drl");
	}

	public void testRule1_1() {
		HtmlElement tag = factory.createFramesetTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> result = evaluate(tag);

		assertReportContains(result, FrameMissingTitle.class, tag.getSource());
	}

	public void testRule1_2() {
		Properties attributes = new Properties();
		attributes.setProperty("title", "nonsense title");
		HtmlElement tag = factory.createFramesetTag(getUniqueId(), body, attributes);
		tag.setSource(dummySource);

		Collection<ReportItem> result = evaluate(tag);

		assertReportNotContains(result, FrameMissingTitle.class, tag.getSource());
	}

	public void testRule2_1() {
		HtmlElement tag = factory.createFrameTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> result = evaluate(tag);

		assertReportContains(result, FrameMissingTitle.class, tag.getSource());
	}

	public void testRule2_2() {
		Properties attributes = new Properties();
		attributes.setProperty("title", "nonsense title");
		HtmlElement tag = factory.createFrameTag(getUniqueId(), body, attributes);
		tag.setSource(dummySource);

		Collection<ReportItem> result = evaluate(tag);

		assertReportNotContains(result, FrameMissingTitle.class, tag.getSource());
	}

	public void testRule3_1() {
		HtmlElement tag = factory.createIframeTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);

		Collection<ReportItem> result = evaluate(tag);

		assertReportContains(result, FrameMissingTitle.class, tag.getSource());
	}

	public void testRule3_2() {
		Properties attributes = new Properties();
		attributes.setProperty("title", "nonsense title");
		HtmlElement tag = factory.createIframeTag(getUniqueId(), body, attributes);
		tag.setSource(dummySource);

		Collection<ReportItem> result = evaluate(tag);

		assertReportNotContains(result, FrameMissingTitle.class, tag.getSource());
	}
}
