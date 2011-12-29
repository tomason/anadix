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
 * Defines metadata about an HTML document
 *
 * @author tomason
 * @version $Id: $
 */
public class MetaTag extends HtmlElement {

	MetaTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "meta", parent, attributes);
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
	 * Provides an HTTP header for the information/value of the content attribute
	 *
	 * @return HTTP header
	 */
	public String getHttpEquiv() {
		return getAttribute("http-equiv");
	}

	/**
	 * Provides a name for the information in the content attribute
	 *
	 * @return name for the information
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Gives the value associated with the http-equiv or name attribute
	 *
	 * @return value of meta information
	 */
	public String getContent() {
		return getAttributes().getAttribute("content");
	}

	/**
	 * Specifies a scheme to be used to interpret the value of the content attribute
	 *
	 * @return scheme to interpret the value
	 */
	public String getScheme() {
		return getAttribute("scheme");
	}

}
