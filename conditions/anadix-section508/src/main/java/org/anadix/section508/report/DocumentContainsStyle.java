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

/**
 * Manual ReportItem that indicates that style is used in document and it needs to be checked whether the document is readable without the stylesheet.
 *
 * @author tomason
 * @version $Id: $
 */
public class DocumentContainsStyle extends Section508ReportItem {
	private static final String KEY = "document.contains.style";

	/**
	 * Constructor
	 */
	public DocumentContainsStyle() {
		super(ItemStatus.MANUAL, KEY);

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}

}
