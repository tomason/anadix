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

import org.anadix.ItemStatus;
import org.anadix.ReportItem;
import org.anadix.html.ImgTag;
import org.anadix.section508.report.ImgIsMap;
import org.testng.annotations.Test;

@Test
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
