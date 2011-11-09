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
import org.anadix.html.ImgTag;

/**
 * Manual check requiring the &lt;IMG&gt; to be checked that it is only decorative
 *
 * @author tomason
 * @version $Id: $
 */
public class ImgEmptyAlt extends Section508ReportItem {
	private static final String KEY = "img.empty.alt";

	/**
	 * Constructor
	 *
	 * @param cause &lt;IMG&gt; tag with empty alt attribute
	 */
	public ImgEmptyAlt(ImgTag cause) {
		super(ItemStatus.MANUAL, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}

}
