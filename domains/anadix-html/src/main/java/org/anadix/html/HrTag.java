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
 * Defines a horizontal line
 *
 * @author tomason
 * @version $Id: $
 */
public class HrTag extends CommonAttributes {

	HrTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "hr", parent, attributes);
	}

	/**
	 * Specifies the alignment of an element
	 *
	 * @return alignment of the element
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Specifies that a element should render in one solid color (noshaded), instead of a shaded color
	 *
	 * @return whether to be shaded
	 */
	public String getNoshade() {
		return getAttribute("noshade");
	}

	/**
	 * Specifies the height of a <hr> element
	 *
	 * @return height of element
	 */
	public String getSize() {
		return getAttribute("size");
	}

	/**
	 * Specifies the width of a <hr> element
	 *
	 * @return width of element
	 */
	public String getWidth() {
		return getAttribute("width");
	}

}
