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
 * <p>TableTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class TableTag extends CommonAttributes {

	TableTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "table", parent, attributes);
	}

	/**
	 * <p>getSummary.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSummary() {
		return getAttribute("summary");
	}

	/**
	 * <p>getWidth.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * <p>getBorder.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getBorder() {
		return getAttribute("border");
	}

	/**
	 * <p>getFrame.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getFrame() {
		return getAttribute("frame");
	}

	/**
	 * <p>getRules.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRules() {
		return getAttribute("rules");
	}

	/**
	 * <p>getCellspacing.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCellspacing() {
		return getAttribute("cellspacing");
	}

	/**
	 * <p>getCellpadding.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCellpadding() {
		return getAttribute("cellpadding");
	}

	/**
	 * <p>getAlign.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * <p>getBgcolor.</p>
	 *
	 * @return a {@link java.lang.String} object.
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
