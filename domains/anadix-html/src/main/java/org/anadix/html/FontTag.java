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
 * Defines font, color, and size for text
 *
 * @author tomason
 * @version $Id: $
 */
public class FontTag extends CoreAttributes {

	FontTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "font", parent, attributes);
	}

	/**
	 * Specifies a language code for the content in an element
	 *
	 * @return language code
	 */
	public String getLang() {
		return getAttribute("lang");
	}

	/**
	 * Specifies the text direction for the content in an element
	 *
	 * @return text direction
	 */
	public String getDir() {
		return getAttribute("dir");
	}

	/**
	 * Specifies the size of text
	 *
	 * @return size of text
	 */
	public String getSize() {
		return getAttribute("size");
	}

	/**
	 * Specifies the color of text
	 *
	 * @return color of text
	 */
	public String getColor() {
		return getAttribute("color");
	}

	/**
	 * Specifies the font of text
	 *
	 * @return font of text
	 */
	public String getFace() {
		return getAttribute("face");
	}

}
