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
 * Defines a window (a frame) in a frameset
 *
 * @author tomason
 * @version $Id: $
 */
public class FrameTag extends CoreAttributes {

	FrameTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "frame", parent, attributes);
	}

	/**
	 * Specifies a page that contains a long description of the content of a frame
	 *
	 * @return URL of page with long description
	 */
	public String getLongdesc() {
		return getAttribute("longdesc");
	}

	/**
	 * Specifies the name of a frame
	 *
	 * @return name of the frame
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Specifies the URL of the document to show in a frame
	 *
	 * @return url of content
	 */
	public String getSrc() {
		return getAttribute("src");
	}

	/**
	 * Specifies whether or not to display a border around a frame
	 *
	 * @return display a border
	 */
	public String getFrameborder() {
		return getAttribute("frameborder");
	}

	/**
	 * Specifies the left and right margins of a frame
	 *
	 * @return horizontal margin
	 */
	public String getMarginwidth() {
		return getAttribute("marginwidth");
	}

	/**
	 * Specifies the top and bottom margins of a frame
	 *
	 * @return vertical margin
	 */
	public String getMarginheight() {
		return getAttribute("marginheight");
	}

	/**
	 * Specifies that a frame is not resizable
	 *
	 * @return whether the frame is resizable
	 */
	public String getNoresize() {
		return getAttribute("noresize");
	}

	/**
	 * Specifies whether or not to display scrollbars in a frame
	 *
	 * @return whether the frame has scrolling visible
	 */
	public String getScrolling() {
		return getAttribute("scrolling");
	}

}
