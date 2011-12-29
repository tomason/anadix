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
 * Defines an image
 *
 * @author tomason
 * @version $Id: $
 */
public class ImgTag extends CommonAttributes {

	ImgTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "img", parent, attributes);
	}

	/**
	 * Specifies the URL of an image
	 *
	 * @return URL of the image
	 */
	public String getSrc() {
		return getAttribute("src");
	}

	/**
	 * Specifies an alternate text for an image
	 *
	 * @return alternative text
	 */
	public String getAlt() {
		return getAttribute("alt");
	}

	/**
	 * Specifies the URL to a document that contains a long description of an image
	 *
	 * @return URL with long description
	 */
	public String getLongdesc() {
		return getAttribute("longdesc");
	}

	/**
	 * <p>getNameAttribute.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Specifies the height of an image
	 *
	 * @return height of image
	 */
	public String getHeight() {
		return getAttribute("height");
	}

	/**
	 * Specifies the width of an image
	 *
	 * @return width of the image
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * Specifies an image as a client-side image-map
	 *
	 * @return whether the image is client-side map
	 */
	public String getUsemap() {
		return getAttribute("usemap");
	}

	/**
	 * Specifies an image as a server-side image-map
	 *
	 * @return whether image is server-side map
	 */
	public String getIsmap() {
		return getAttribute("ismap");
	}

	/**
	 * Specifies the alignment of an image according to surrounding elements
	 *
	 * @return alignment of an image
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Specifies the width of the border around an image
	 *
	 * @return width of the border
	 */
	public String getBorder() {
		return getAttribute("border");
	}

	/**
	 * Specifies the whitespace on left and right side of an image
	 *
	 * @return horizontal whitespace width
	 */
	public String getHspace() {
		return getAttribute("hspace");
	}

	/**
	 * Specifies the whitespace on top and bottom of an image
	 *
	 * @return vertical whitespace height
	 */
	public String getVspace() {
		return getAttribute("vspace");
	}

}
