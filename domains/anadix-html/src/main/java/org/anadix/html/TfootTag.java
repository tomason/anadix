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
 * Groups the footer content in a table
 *
 * @author tomason
 * @version $Id: $
 */
public class TfootTag extends CommonAttributes {

	TfootTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "tfoot", parent, attributes);
	}


	/**
	 * Aligns the content inside the <thead> element
	 *
	 * @return alignment of content
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Aligns the content inside the element to a character
	 *
	 * @return character
	 */
	public String getChar() {
		return getAttribute("char");
	}

	/**
	 * Sets the number of characters the content inside the element will be aligned from the character specified by the char attribute
	 *
	 * @return number
	 */
	public String getCharoff() {
		return getAttribute("charoff");
	}

	/**
	 * Vertical aligns the content inside the element
	 *
	 * @return vertical alignment
	 */
	public String getValign() {
		return getAttribute("valign");
	}

}
