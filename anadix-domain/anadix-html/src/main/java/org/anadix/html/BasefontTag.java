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
 * FONT and BASEFONT are deprecated.
 * 
 * @author tomason
 */
public class BasefontTag extends HtmlElement {

	BasefontTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "basefont", parent, attributes);
	}

	public String getIdAttribute() {
		return getAttribute("id");
	}

	/**
	 * size = cdata [CN] Deprecated. This attribute sets the size of the font.
	 * Possible values:
	 * 
	 * An integer between 1 and 7. This sets the font to some fixed size, whose
	 * rendering depends on the user agent. Not all user agents may render all
	 * seven sizes. A relative increase in font size. The value "+1" means one
	 * size larger. The value "-3" means three sizes smaller. All sizes belong
	 * to the scale of 1 to 7.
	 */
	public String getSize() {
		return getAttribute("size");
	}

	/**
	 * Deprecated. This attribute sets the text color.
	 */
	public String getColor() {
		return getAttribute("color");
	}

	/**
	 * Deprecated. This attribute defines a comma-separated list of font names
	 * the user agent should search for in order of preference.
	 */
	public String getFace() {
		return getAttribute("face");
	}

}
