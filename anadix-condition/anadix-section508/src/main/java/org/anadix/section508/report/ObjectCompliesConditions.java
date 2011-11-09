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
import org.anadix.html.HtmlElement;

/**
 * Manual check requiring the objects on page to comply to Section 508 (applets, plugins, etc.)
 *
 * @author tomason
 * @version $Id: $
 */
public class ObjectCompliesConditions extends Section508ReportItem {
	private static final String KEY = "object.complies.conditions";

	/**
	 * Constructor
	 *
	 * @param cause element that needs to be checked
	 */
	public ObjectCompliesConditions(HtmlElement cause) {
		super(ItemStatus.MANUAL, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}

}
