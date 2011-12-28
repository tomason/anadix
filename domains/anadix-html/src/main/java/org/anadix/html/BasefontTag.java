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
 * Deprecated. Defines a default font, color, or size for the text in a page. See <a href="http://www.w3schools.com/tags/tag_basefont.asp">w3schools</a>.
 *
 * @author tomason
 * @version $Id: $
 */
public class BasefontTag extends HtmlElement {

	BasefontTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "basefont", parent, attributes);
	}

	/**
	 * Specifies a unique id for an element
	 *
	 * @return a unique id for an element
	 */
	public String getIdAttribute() {
		return getAttribute("id");
	}

	/**
	 * Deprecated. Use styles instead. Specifies the default size of text in a document
	 *
	 * @return the default size of text in a document
	 */
	public String getSize() {
		return getAttribute("size");
	}

	/**
	 * Deprecated. Use styles instead. Specifies the default color for text in a document
	 *
	 * @return the default color for text in a document
	 */
	public String getColor() {
		return getAttribute("color");
	}

	/**
	 * Deprecated. Use styles instead. Specifies the default font for text in a document
	 *
	 * @return the default font for text in a document
	 */
	public String getFace() {
		return getAttribute("face");
	}

}
