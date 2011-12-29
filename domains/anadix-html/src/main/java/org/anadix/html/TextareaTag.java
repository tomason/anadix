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
 * Defines a multiline input control (text area)
 *
 * @author tomason
 * @version $Id: $
 */
public class TextareaTag extends CommonAttributes {

	TextareaTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "textarea", parent, attributes);
	}

	/**
	 * Specifies the name for a text area
	 *
	 * @return name of the element
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Specifies the visible number of lines in a text area
	 *
	 * @return number
	 */
	public String getRows() {
		return getAttribute("rows");
	}

	/**
	 * Specifies the visible width of a text area
	 *
	 * @return number
	 */
	public String getCols() {
		return getAttribute("cols");
	}

	/**
	 * Specifies that a text area should be disabled
	 *
	 * @return "disabled" or null
	 */
	public String getDisabled() {
		return getAttribute("disabled");
	}

	/**
	 * Specifies that a text area should be read-only
	 *
	 * @return "readonly" or null
	 */
	public String getReadonly() {
		return getAttribute("readonly");
	}

	/**
	 * Specifies the tab order of an element
	 *
	 * @return number
	 */
	public String getTabindex() {
		return getAttribute("tabindex");
	}

	/**
	 * Specifies a keyboard shortcut to access an element
	 *
	 * @return character
	 */
	public String getAccesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * Script to be run when an element gets focus
	 *
	 * @return script
	 */
	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	/**
	 * Script to be run when an element loses focus
	 *
	 * @return script
	 */
	public String getOnblur() {
		return getAttribute("onblur");
	}

	/**
	 * Script to be run when an element is selected
	 *
	 * @return script
	 */
	public String getOnselect() {
		return getAttribute("onselect");
	}

	/**
	 * Script to be run when an element change
	 *
	 * @return script
	 */
	public String getOnchange() {
		return getAttribute("onchange");
	}

}
