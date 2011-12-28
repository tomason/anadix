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
 * <p>LinkTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class LinkTag extends CommonAttributes {
	LinkTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "link", parent, attributes);
	}

	/**
	 * <p>getCharset.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCharset() {
		return getAttribute("charset");
	}

	/**
	 * <p>getHref.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHref() {
		return getAttribute("href");
	}

	/**
	 * <p>getHreflang.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHreflang() {
		return getAttribute("hreflang");
	}

	/**
	 * <p>getType.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * <p>getRel.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRel() {
		return getAttribute("rel");
	}

	/**
	 * <p>getRev.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRev() {
		return getAttribute("rev");
	}

	/**
	 * <p>getMedia.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getMedia() {
		return getAttribute("media");
	}

	/**
	 * <p>getTarget.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTarget() {
		return getAttribute("target");
	}

}
