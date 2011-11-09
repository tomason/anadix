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
import org.anadix.html.TrTag;

/**
 * Error report indicating that row in data table is missing header
 *
 * @author tomason
 * @version $Id: $
 */
public class RowMissingHeader extends Section508ReportItem {
	private static final String KEY = "row.missing.header";

	/**
	 * Constructor
	 *
	 * @param row &lt;TR&gt; tag that is not starting with &lt;TH&gt;
	 */
	public RowMissingHeader(TrTag row) {
		super(ItemStatus.ERROR, KEY, row.getSource());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
