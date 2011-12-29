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
 * Defines a list item
 *
 * @author tomason
 * @version $Id: $
 */
public class LiTag extends CommonAttributes {

	LiTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "li", parent, attributes);
	}

	/**
	 * Specifies which kind of bullet point will be used
	 *
	 * @return type of bullet
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * Specifies the value of a list item. The following list items will increment from that number (only for &lt;ol&gt; lists)
	 *
	 * @return value of item
	 */
	public String getValue() {
		return getAttribute("value");
	}

}
