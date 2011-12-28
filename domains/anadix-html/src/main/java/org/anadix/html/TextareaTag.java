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
 * <p>TextareaTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class TextareaTag extends CommonAttributes {

	TextareaTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "textarea", parent, attributes);
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
	 * <p>getRows.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRows() {
		return getAttribute("rows");
	}

	/**
	 * <p>getCols.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCols() {
		return getAttribute("cols");
	}

	/**
	 * <p>getDisabled.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDisabled() {
		return getAttribute("disabled");
	}

	/**
	 * <p>getReadonly.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getReadonly() {
		return getAttribute("readonly");
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
	 * <p>getAccesskey.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAccesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * <p>getOnfocus.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	/**
	 * <p>getOnblur.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getOnblur() {
		return getAttribute("onblur");
	}

	/**
	 * <p>getOnselect.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getOnselect() {
		return getAttribute("onselect");
	}

	/**
	 * <p>getOnchange.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getOnchange() {
		return getAttribute("onchange");
	}

}
