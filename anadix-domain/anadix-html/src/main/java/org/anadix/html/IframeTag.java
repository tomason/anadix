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

public class IframeTag extends CommonAttributes {

	IframeTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "iframe", parent, attributes);
	}

	public String getLongdesc() {
		return getAttribute("longdesc");
	}

	public String getNameAttribute() {
		return getAttribute("name");
	}

	public String getSrc() {
		return getAttribute("src");
	}

	public String getFrameborder() {
		return getAttribute("frameborder");
	}

	public String getMarginwidth() {
		return getAttribute("marginwidth");
	}

	public String getMarginheight() {
		return getAttribute("marginheight");
	}

	public String getScrolling() {
		return getAttribute("scrolling");
	}

	public String getAlign() {
		return getAttribute("align");
	}

	public String getHeight() {
		return getAttribute("height");
	}

	public String getWidth() {
		return getAttribute("width");
	}

}
