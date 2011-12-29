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
 * Defines information about the document
 *
 * @author tomason
 * @version $Id: $
 */
public class HeadTag extends HtmlElement {

	HeadTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "head", parent, attributes);
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
	 * Specifies a URL to a document that contains a set of rules. The rules can be read by browsers to clearly understand the information in the <meta> tag's content attribute
	 *
	 * @return URL of a profile
	 */
	public String getProfile() {
		return getAttribute("profile");
	}

}
