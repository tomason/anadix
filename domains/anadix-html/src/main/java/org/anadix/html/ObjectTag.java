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
 * <p>ObjectTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class ObjectTag extends CommonAttributes {

	ObjectTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "object", parent, attributes);
	}

	/**
	 * <p>getDeclare.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDeclare() {
		return getAttribute("declare");
	}

	/**
	 * <p>getClassid.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getClassid() {
		return getAttribute("classid");
	}

	/**
	 * <p>getCodebase.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCodebase() {
		return getAttribute("codebase");
	}

	/**
	 * <p>getData.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getData() {
		return getAttribute("data");
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
	 * <p>getCodetype.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCodetype() {
		return getAttribute("codetype");
	}

	/**
	 * <p>getArchive.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getArchive() {
		return getAttribute("archive");
	}

	/**
	 * <p>getStandby.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getStandby() {
		return getAttribute("standby");
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
	 * <p>getNameAttribute.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * <p>getTabindex.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTabindex() {
		return getAttribute("tabindex");
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
