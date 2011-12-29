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
 * Defines an inline frame
 *
 * @author tomason
 * @version $Id: $
 */
public class IframeTag extends CommonAttributes {

	IframeTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "iframe", parent, attributes);
	}

	/**
	 * Specifies a page that contains a long description of the content of an element
	 *
	 * @return URL of long description
	 */
	public String getLongdesc() {
		return getAttribute("longdesc");
	}

	/**
	 * Specifies the name of an element
	 *
	 * @return name of the frame
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Specifies the address of the document to embed in the element
	 *
	 * @return URL of the source
	 */
	public String getSrc() {
		return getAttribute("src");
	}

	/**
	 * Specifies whether or not to display a border around an element
	 *
	 * @return whether to display border
	 */
	public String getFrameborder() {
		return getAttribute("frameborder");
	}

	/**
	 * Specifies the left and right margins of the content of an element
	 *
	 * @return horizontal margin
	 */
	public String getMarginwidth() {
		return getAttribute("marginwidth");
	}

	/**
	 * Specifies the top and bottom margins of the content of an element
	 *
	 * @return vertical margin
	 */
	public String getMarginheight() {
		return getAttribute("marginheight");
	}

	/**
	 * Specifies whether or not to display scrollbars in an element
	 *
	 * @return whether to display scrolling
	 */
	public String getScrolling() {
		return getAttribute("scrolling");
	}

	/**
	 * Specifies the alignment of an according to surrounding elements
	 *
	 * @return align of the frame
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Specifies the height of an element
	 *
	 * @return height of frame
	 */
	public String getHeight() {
		return getAttribute("height");
	}

	/**
	 * Specifies the width of an element
	 *
	 * @return width of the frame
	 */
	public String getWidth() {
		return getAttribute("width");
	}

}
