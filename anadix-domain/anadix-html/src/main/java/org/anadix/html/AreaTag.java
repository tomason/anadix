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
 * 
 * 
 * @author tomason
 */
public class AreaTag extends CommonAttributes {

	public AreaTag(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	/**
	 * 
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * 
	 */
	public String getShape() {
		return getAttribute("shape");
	}

	/**
	 * 
	 */
	public String getCoord() {
		return getAttribute("coord");
	}

	/**
	 * 
	 */
	public String getNohref() {
		return getAttribute("nohref");
	}

	/**
	 * 
	 */
	public String getUsemap() {
		return getAttribute("usemap");
	}

	/**
	 * 
	 */
	public String getHref() {
		return getAttribute("href");
	}

	/**
	 * 
	 */
	public String getAlt() {
		return getAttribute("alt");
	}

	/**
	 * 
	 */
	public int getTabindex() {
		String value = getAttribute("tabindex");

		return (value == null) ? -1 : Integer.parseInt(value);
	}

	/**
	 * 
	 */
	public String getAcesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * 
	 */
	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	/**
	 * 
	 */
	public String getOnblur() {
		return getAttribute("onblur");
	}
}
