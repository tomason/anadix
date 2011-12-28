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
 * <p>TdTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class TdTag extends CommonAttributes {

	TdTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "td", parent, attributes);
	}

	/**
	 * <p>getAbbr.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAbbr() {
		return getAttribute("abbr");
	}

	/**
	 * <p>getAxis.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAxis() {
		return getAttribute("axis");
	}

	/**
	 * <p>getHeaders.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHeaders() {
		return getAttribute("headers");
	}

	/**
	 * <p>getScope.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getScope() {
		return getAttribute("scope");
	}

	/**
	 * <p>getRowspan.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRowspan() {
		return getAttribute("rowspan");
	}

	/**
	 * <p>getColspan.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getColspan() {
		return getAttribute("colspan");
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
	 * <p>getChar.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getChar() {
		return getAttribute("char");
	}

	/**
	 * <p>getCharoff.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCharoff() {
		return getAttribute("charoff");
	}

	/**
	 * <p>getValign.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getValign() {
		return getAttribute("valign");
	}

	/**
	 * <p>getNowrap.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getNowrap() {
		return getAttribute("nowrap");
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
	 * <p>getWidth.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * <p>getHeight.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHeight() {
		return getAttribute("height");
	}

}
