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
 * Defines a table
 *
 * @author tomason
 * @version $Id: $
 */
public class TableTag extends CommonAttributes {

	TableTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "table", parent, attributes);
	}

	/**
	 * Specifies a summary of the content of a table
	 *
	 * @return text
	 */
	public String getSummary() {
		return getAttribute("summary");
	}

	/**
	 * Specifies the width of a table
	 *
	 * @return width of the table
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * Specifies the width of the borders around a table
	 *
	 * @return number
	 */
	public String getBorder() {
		return getAttribute("border");
	}

	/**
	 * Specifies which parts of the outside borders that should be visible
	 *
	 * @return list of outside border parts
	 */
	public String getFrame() {
		return getAttribute("frame");
	}

	/**
	 * Specifies which parts of the inside borders that should be visible
	 *
	 * @return list of inside border parts
	 */
	public String getRules() {
		return getAttribute("rules");
	}

	/**
	 * Specifies the space between cells
	 *
	 * @return number
	 */
	public String getCellspacing() {
		return getAttribute("cellspacing");
	}

	/**
	 * Specifies the space between the cell wall and the cell content
	 *
	 * @return number
	 */
	public String getCellpadding() {
		return getAttribute("cellpadding");
	}

	/**
	 * Specifies the alignment of a table according to surrounding text
	 *
	 * @return alignment
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Specifies the background color for a table
	 *
	 * @return color
	 */
	public String getBgcolor() {
		return getAttribute("bgcolor");
	}

	/**
	 * <p>getDatapagesize.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDatapagesize() {
		return getAttribute("datapagesize");
	}

}
