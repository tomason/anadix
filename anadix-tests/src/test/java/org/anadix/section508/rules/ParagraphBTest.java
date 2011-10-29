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

import org.anadix.ReportItem;
import org.anadix.html.AppletTag;
import org.anadix.html.HtmlElement;
import org.anadix.html.ObjectTag;
import org.anadix.html.ParamTag;
import org.anadix.section508.report.MultimediaNeedAlternative;
import org.testng.annotations.Test;

@Test
public class ParagraphBTest extends RulesetTest {

	public ParagraphBTest() throws IllegalStateException {
		super("paragraph-b.drl");
	}

	/*
	 * rule "multimedia applet"
	 */
	public void testRule1_1() {
		AppletTag tag = factory.createAppletTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}

	/*
	 * rule "multimedia object"
	 */
	public void testRule2_1() {
		ObjectTag tag = factory.createObjectTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}

	/*
	 * rule "multimedia param"
	 */
	public void testRule3_1() {
		ParamTag tag = factory.createParamTag(getUniqueId(), body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}

	/*
	 * rule "multimedia embed"
	 */
	public void testRule4_1() {
		HtmlElement tag = factory.createTag(getUniqueId(), "embed", body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}

	public void testRule4_2() {
		HtmlElement tag = factory.createTag(getUniqueId(), "table", body, dummyAttributes);
		tag.setSource(dummySource);
		Collection<ReportItem> items = evaluate(tag);

		assertReportNotContains(items, MultimediaNeedAlternative.class, tag.getSource());
	}
}
