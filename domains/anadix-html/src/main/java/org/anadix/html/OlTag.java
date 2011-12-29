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
 * Defines an ordered list
 *
 * @author tomason
 * @version $Id: $
 */
public class OlTag extends CommonAttributes {

	OlTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "ol", parent, attributes);
	}

	/**
	 * Specifies the kind of marker to use in the list
	 *
	 * @return type of marker
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * Specifies that the list should render smaller than normal
	 *
	 * @return whether the list is smaller
	 */
	public String getCompact() {
		return getAttribute("compact");
	}

	/**
	 * Specifies the start value of an ordered list
	 *
	 * @return start value
	 */
	public String getStart() {
		return getAttribute("start");
	}

}
