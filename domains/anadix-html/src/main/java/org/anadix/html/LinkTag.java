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
 * Defines the relationship between a document and an external resource
 *
 * @author tomason
 * @version $Id: $
 */
public class LinkTag extends CommonAttributes {
	LinkTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "link", parent, attributes);
	}

	/**
	 * Specifies the character encoding of the linked document
	 *
	 * @return encoding of document
	 */
	public String getCharset() {
		return getAttribute("charset");
	}

	/**
	 * Specifies the location of the linked document
	 *
	 * @return URL of the document
	 */
	public String getHref() {
		return getAttribute("href");
	}

	/**
	 * Specifies the language of the text in the linked document
	 *
	 * @return language code
	 */
	public String getHreflang() {
		return getAttribute("hreflang");
	}

	/**
	 * Specifies the MIME type of the linked document
	 *
	 * @return MIME type
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * Specifies the relationship between the current document and the linked document
	 *
	 * @return type of relationship
	 */
	public String getRel() {
		return getAttribute("rel");
	}

	/**
	 * Specifies the relationship between the linked document and the current document
	 *
	 * @return type of relationship
	 */
	public String getRev() {
		return getAttribute("rev");
	}

	/**
	 * Specifies on what device the linked document will be displayed
	 *
	 * @return device to display document on
	 */
	public String getMedia() {
		return getAttribute("media");
	}

	/**
	 * Specifies where the linked document is to be loaded
	 *
	 * @return where to load the linked document
	 */
	public String getTarget() {
		return getAttribute("target");
	}

}
