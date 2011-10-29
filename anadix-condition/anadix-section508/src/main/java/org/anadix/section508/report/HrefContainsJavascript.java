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
package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.ATag;
import org.anadix.html.AreaTag;
import org.anadix.html.HtmlElement;

public class HrefContainsJavascript extends Section508ReportItem {
	private static final String KEY = "href.contains.javascript";

	public HrefContainsJavascript(ATag cause) {
		this((HtmlElement)cause);

		setDescription(formatDescriptionString(KEY, "Anchor (<a>)"));
	}

	public HrefContainsJavascript(AreaTag cause) {
		this((HtmlElement)cause);

		setDescription(formatDescriptionString(KEY, "Area"));
	}

	private HrefContainsJavascript(HtmlElement cause) {
		super(ItemStatus.WARNING, KEY, cause.getSource(), cause.getPosition());

		setAdvice(formatAdviceString(KEY));
	}

}
