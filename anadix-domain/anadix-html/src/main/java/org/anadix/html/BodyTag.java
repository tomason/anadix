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

public class BodyTag extends CommonAttributes {

	public BodyTag(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	/**
	 * Deprecated. The value of this attribute is a URI that designates an image
	 * resource. The image generally tiles the background (for visual browsers).
	 */
	public String getBackground() {
		return getAttribute("background");
	}

	/**
	 * Deprecated. This attribute sets the foreground color for text (for visual
	 * browsers).
	 */
	public String getText() {
		return getAttribute("text");
	}

	/**
	 * Deprecated. This attribute sets the color of text marking unvisited
	 * hypertext links (for visual browsers).
	 */
	public String getLink() {
		return getAttribute("link");
	}

	/**
	 * Deprecated. This attribute sets the color of text marking visited
	 * hypertext links (for visual browsers).
	 */
	public String getVlink() {
		return getAttribute("vlink");
	}

	/**
	 * Deprecated. This attribute sets the color of text marking hypertext links
	 * when selected by the user (for visual browsers).
	 */
	public String getAlink() {
		return getAttribute("alink");
	}

	public String getOnload() {
		return getAttribute("onload");
	}

	public String getOnunload() {
		return getAttribute("onunload");
	}
}
