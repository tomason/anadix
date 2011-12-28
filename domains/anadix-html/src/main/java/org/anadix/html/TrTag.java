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
 * <p>TrTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class TrTag extends CommonAttributes {

	TrTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "tr", parent, attributes);
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
	 * <p>getBgcolor.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getBgcolor() {
		return getAttribute("bgcolor");
	}

}
