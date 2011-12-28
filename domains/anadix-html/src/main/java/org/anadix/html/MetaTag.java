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
 * <p>MetaTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class MetaTag extends HtmlElement {

	MetaTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "meta", parent, attributes);
	}

	/**
	 * <p>getLang.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLang() {
		return getAttribute("lang");
	}

	/**
	 * <p>getDir.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDir() {
		return getAttribute("dir");
	}

	/**
	 * <p>getHttpEquiv.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHttpEquiv() {
		return getAttribute("http-equiv");
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
	 * <p>getContent.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getContent() {
		return getAttributes().getAttribute("content");
	}

	/**
	 * <p>getScheme.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getScheme() {
		return getAttribute("scheme");
	}

}
