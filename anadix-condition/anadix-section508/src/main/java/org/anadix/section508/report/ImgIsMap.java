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
 * Report item indicating that &lt;IMG&gt; has ismap attribute defined
 *
 * @author tomason
 * @version $Id: $
 */
public class ImgIsMap extends Section508ReportItem {
	private static final String KEY_MANUAL = "img.has.textlinks";
	private static final String KEY_WARNING = "img.is.map";

	/**
	 * Constructor
	 *
	 * @param cause &lt;IMG&gt; tag that has ismap attribute defined
	 */
	public ImgIsMap(ImgTag cause) {
		this(cause, false);
	}

	/**
	 * Constructor
	 *
	 * @param cause &lt;IMG&gt; tag that has ismap attribute defined
	 * @param warning mark as warning (true) or as manual check (false)
	 */
	public ImgIsMap(ImgTag cause, boolean warning) {
		super((warning ? ItemStatus.WARNING : ItemStatus.MANUAL),
				(warning ? KEY_WARNING : KEY_MANUAL),
				cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(warning ? KEY_WARNING : KEY_MANUAL));
		setAdvice(formatAdviceString(warning ? KEY_WARNING : KEY_MANUAL));
	}
}
