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
package org.anadix.html;

import java.math.BigInteger;

/**
 * Defines text that has been deleted from a document
 *
 * @author tomason
 * @version $Id: $
 */
public class DelTag extends CommonAttributes {

	DelTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "del", parent, attributes);
	}

	/**
	 * Specifies a URL to a document which explains why the text was deleted
	 *
	 * @return URL of explaining element
	 */
	public String getCite() {
		return getAttribute("cite");
	}

	/**
	 * Specifies the date and time when the text was deleted
	 *
	 * @return date and time the text was deleted
	 */
	public String getDatetime() {
		return getAttribute("datetime");
	}

}
