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
 * Defines attribute values for one or more columns in a table
 *
 * @author tomason
 * @version $Id: $
 */
public class ColTag extends CommonAttributes {

	ColTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "col", parent, attributes);
	}

	/**
	 * Specifies the number of columns a &lt;col&gt; element should span
	 *
	 * @return number of columns this should span
	 */
	public String getSpan() {
		return getAttribute("span");
	}

	/**
	 * Specifies the width of a &lt;col&gt; element
	 *
	 * @return width of the element
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * Specifies the alignment of the content related to a &lt;col&gt; element
	 *
	 * @return alignment of the content
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Specifies the alignment of the content related to a &lt;col&gt; element to a character
	 *
	 * @return alignment of the content
	 */
	public String getChar() {
		return getAttribute("char");
	}

	/**
	 * Specifies the number of characters the content will be aligned from the character specified by the char attribute
	 *
	 * @return number of characters to by aligned with char attribute
	 */
	public String getCharoff() {
		return getAttribute("charoff");
	}

	/**
	 * Specifies the vertical alignment of the content related to a &lt;col&gt; element
	 *
	 * @return vertical alignment of content
	 */
	public String getValign() {
		return getAttribute("valign");
	}

}
