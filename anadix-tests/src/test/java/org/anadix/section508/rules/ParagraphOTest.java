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
import org.anadix.html.HtmlElement;
import org.anadix.section508.report.DocumentSkipNavigation;
import org.testng.annotations.Test;

@Test
public class ParagraphOTest extends RulesetTest {
	public ParagraphOTest() {
		super("paragraph-o.drl");
	}

	public void testRule1_1() {
		HtmlElement a = factory.createATag(getUniqueId(), body, dummyAttributes);

		Collection<ReportItem> report = evaluate(a);

		assertReportContains(report, DocumentSkipNavigation.class);
	}

	public void testRule1_2() {
		Collection<ReportItem> report = evaluate();

		assertReportNotContains(report, DocumentSkipNavigation.class);
	}
}
