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
 * Defines a cell in a table
 *
 * @author tomason
 * @version $Id: $
 */
public class TdTag extends CommonAttributes {

	TdTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "td", parent, attributes);
	}

	/**
	 * Specifies an abbreviated version of the content in a cell
	 *
	 * @return text
	 */
	public String getAbbr() {
		return getAttribute("abbr");
	}

	/**
	 * Categorizes cells
	 *
	 * @return category name
	 */
	public String getAxis() {
		return getAttribute("axis");
	}

	/**
	 * Specifies one or more header cells a cell is related to
	 *
	 * @return list of header id
	 */
	public String getHeaders() {
		return getAttribute("headers");
	}

	/**
	 * Defines a way to associate header cells and data cells in a table
	 *
	 * @return scope of cell
	 */
	public String getScope() {
		return getAttribute("scope");
	}

	/**
	 * Sets the number of rows a cell should span
	 *
	 * @return number
	 */
	public String getRowspan() {
		return getAttribute("rowspan");
	}

	/**
	 * Specifies the number of columns a cell should span
	 *
	 * @return number
	 */
	public String getColspan() {
		return getAttribute("colspan");
	}

	/**
	 * Aligns the content in a cell
	 *
	 * @return alignment
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Aligns the content in a cell to a character
	 *
	 * @return character
	 */
	public String getChar() {
		return getAttribute("char");
	}

	/**
	 * Sets the number of characters the content will be aligned from the character specified by the char attribute
	 *
	 * @return number
	 */
	public String getCharoff() {
		return getAttribute("charoff");
	}

	/**
	 * Vertical aligns the content in a cell
	 *
	 * @return vertical alignment
	 */
	public String getValign() {
		return getAttribute("valign");
	}

	/**
	 * Specifies that the content inside a cell should not wrap
	 *
	 * @return nowrap or null
	 */
	public String getNowrap() {
		return getAttribute("nowrap");
	}

	/**
	 * Specifies the background color of a cell
	 *
	 * @return color
	 */
	public String getBgcolor() {
		return getAttribute("bgcolor");
	}

	/**
	 * Specifies the width of a cell
	 *
	 * @return width of the cell
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * Sets the height of a cell
	 *
	 * @return height of the cell
	 */
	public String getHeight() {
		return getAttribute("height");
	}

}
