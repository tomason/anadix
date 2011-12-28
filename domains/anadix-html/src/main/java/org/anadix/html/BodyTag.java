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
 * Defines the document's body. See <a href="http://www.w3schools.com/tags/tag_body.asp">w3schools</a>.
 *
 * @author tomason
 * @version $Id: $
 */
public class BodyTag extends CommonAttributes {

	BodyTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "body", parent, attributes);
	}

	/**
	 * Script to be run when a document load
	 *
	 * @return script to be run when a document load
	 */
	public String getOnload() {
		return getAttribute("onload");
	}

	/**
	 * Script to be run when a document unload
	 *
	 * @return script to be run when a document unload
	 */
	public String getOnunload() {
		return getAttribute("onunload");
	}

	/**
	 * Deprecated. Use styles instead. Specifies a background image for a document
	 *
	 * @return a background image for a document
	 */
	public String getBackground() {
		return getAttribute("background");
	}

	/**
	 * Deprecated. Use styles instead. Specifies the background color of a document
	 *
	 * @return the background color of a document
	 */
	public String getBgcolor() {
		return getAttribute("bgcolor");
	}

	/**
	 * Deprecated. Use styles instead. Specifies the color of the text in a document
	 *
	 * @return the color of the text in a document
	 */
	public String getText() {
		return getAttribute("text");
	}

	/**
	 * Deprecated. Use styles instead. Specifies the default color of unvisited links in a document
	 *
	 * @return the default color of unvisited links in a document
	 */
	public String getLink() {
		return getAttribute("link");
	}

	/**
	 * Deprecated. Use styles instead. Specifies the color of the visited links in a document
	 *
	 * @return the color of the visited links in a document
	 */
	public String getVlink() {
		return getAttribute("vlink");
	}

	/**
	 * Deprecated. Use styles instead. Specifies the color of an active link in a document
	 *
	 * @return the color of an active link in a document
	 */
	public String getAlink() {
		return getAttribute("alink");
	}

}
