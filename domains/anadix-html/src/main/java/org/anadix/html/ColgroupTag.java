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
 * Specifies a group of one or more columns in a table for formatting
 *
 * @author tomason
 * @version $Id: $
 */
public class ColgroupTag extends CommonAttributes {

	ColgroupTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "colgroup", parent, attributes);
	}

	/**
	 * Specifies the number of columns a column group should span
	 *
	 * @return number of columns this group spans
	 */
	public String getSpan() {
		return getAttribute("span");
	}

	/**
	 * Specifies the width of a column group
	 *
	 * @return width of columns
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * Aligns the content in a column group
	 *
	 * @return align of the content
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Aligns the content in a column group to a character
	 *
	 * @return align of the content to a character
	 */
	public String getChar() {
		return getAttribute("char");
	}

	/**
	 * Sets the number of characters the content will be aligned from the character specified by the char attribute
	 *
	 * @return number of characters to by aligned with char attribute
	 */
	public String getCharoff() {
		return getAttribute("charoff");
	}

	/**
	 * Vertical aligns the content in a column group
	 *
	 * @return vertical align of content
	 */
	public String getValign() {
		return getAttribute("valign");
	}

}
