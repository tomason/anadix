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
 * <p>ImgTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class ImgTag extends CommonAttributes {

	ImgTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "img", parent, attributes);
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
	 * <p>getAlt.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAlt() {
		return getAttribute("alt");
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

	/**
	 * <p>getUsemap.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getUsemap() {
		return getAttribute("usemap");
	}

	/**
	 * <p>getIsmap.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getIsmap() {
		return getAttribute("ismap");
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
	 * <p>getBorder.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getBorder() {
		return getAttribute("border");
	}

	/**
	 * <p>getHspace.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHspace() {
		return getAttribute("hspace");
	}

	/**
	 * <p>getVspace.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getVspace() {
		return getAttribute("vspace");
	}

}
