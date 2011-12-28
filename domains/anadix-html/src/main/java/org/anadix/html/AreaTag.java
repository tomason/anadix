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
 * Defines an area inside an image-map. See <a href="http://www.w3schools.com/tags/tag_area.asp">w3schools</a>.
 *
 * @author tomason
 * @version $Id: $
 */
public class AreaTag extends CommonAttributes {

	AreaTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "area", parent, attributes);
	}

	/**
	 * Specifies the shape of an area
	 *
	 * @return the shape of an area
	 */
	public String getShape() {
		return getAttribute("shape");
	}

	/**
	 * 	Specifies the coordinates of an area
	 *
	 * @return the coordinates of an area
	 */
	public String getCoords() {
		return getAttribute("coords");
	}

	/**
	 * Specifies the destination of a link in an area
	 *
	 * @return the destination of a link in an area
	 */
	public String getHref() {
		return getAttribute("href");
	}

	/**
	 * Specifies where to open the linked page specified in the href attribute
	 *
	 * @return where to open the linked page specified in the href attribute
	 */
	public String getTarget() {
		return getAttribute("target");
	}

	/**
	 * Specifies that an area has no associated link
	 *
	 * @return whether an area has no associated link
	 */
	public String getNohref() {
		return getAttribute("nohref");
	}

	/**
	 * Specifies an alternate text for an area
	 *
	 * @return an alternate text for an area
	 */
	public String getAlt() {
		return getAttribute("alt");
	}

	/**
	 * Specifies the tab order of an element
	 *
	 * @return the tab order of an element
	 */
	public String getTabindex() {
		String value = getAttribute("tabindex");

		// return (value == null) ? -1 : Integer.parseInt(value);
		return value;
	}

	/**
	 * Specifies a keyboard shortcut to access an element
	 *
	 * @return a keyboard shortcut to access an element
	 */
	public String getAcesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * Script to be run when an element gets focus
	 *
	 * @return script to be run when an element gets focus
	 */
	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	/**
	 * Script to be run when an element loses focus
	 *
	 * @return script to be run when an element loses focus
	 */
	public String getOnblur() {
		return getAttribute("onblur");
	}

}
