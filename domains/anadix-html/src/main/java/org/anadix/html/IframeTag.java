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
 * <p>IframeTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class IframeTag extends CommonAttributes {

	IframeTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "iframe", parent, attributes);
	}

	/**
	 * <p>getLongdesc.</p>
	 *
	 * @return a {@link java.lang.String} object.
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
	 * <p>getSrc.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSrc() {
		return getAttribute("src");
	}

	/**
	 * <p>getFrameborder.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getFrameborder() {
		return getAttribute("frameborder");
	}

	/**
	 * <p>getMarginwidth.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getMarginwidth() {
		return getAttribute("marginwidth");
	}

	/**
	 * <p>getMarginheight.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getMarginheight() {
		return getAttribute("marginheight");
	}

	/**
	 * <p>getScrolling.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getScrolling() {
		return getAttribute("scrolling");
	}

	/**
	 * <p>getAlign.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * <p>getHeight.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHeight() {
		return getAttribute("height");
	}

	/**
	 * <p>getWidth.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getWidth() {
		return getAttribute("width");
	}

}
