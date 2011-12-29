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
 * Defines an input control
 *
 * @author tomason
 * @version $Id: $
 */
public class InputTag extends CommonAttributes {

	InputTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "input", parent, attributes);
	}

	/**
	 * Specifies the type of an element
	 *
	 * @return type of the element
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * Specifies the name of an element
	 *
	 * @return name of the element
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * 	Specifies the value of an element
	 *
	 * @return value of the element
	 */
	public String getValue() {
		return getAttribute("value");
	}

	/**
	 * Specifies that an <input> element should be preselected when the page loads (for type="checkbox" or type="radio")
	 *
	 * @return whether the element should be checked
	 */
	public String getChecked() {
		return getAttribute("checked");
	}

	/**
	 * Specifies that an <input> element should be disabled
	 *
	 * @return whether the element should be disabled
	 */
	public String getDisabled() {
		return getAttribute("disabled");
	}

	/**
	 * Specifies that an input field should be read-only
	 *
	 * @return whether the element is read-only
	 */
	public String getReadonly() {
		return getAttribute("readonly");
	}

	/**
	 * Specifies the width, in characters, of an element
	 *
	 * @return width of the element
	 */
	public String getSize() {
		return getAttribute("size");
	}

	/**
	 * Specifies the maximum number of characters allowed in an <input> element
	 *
	 * @return maximum number of characters
	 */
	public String getMaxlength() {
		return getAttribute("maxlength");
	}

	/**
	 * Specifies the URL of the image to use as a submit button (only for type="image")
	 *
	 * @return URL of image
	 */
	public String getSrc() {
		return getAttribute("src");
	}

	/**
	 * Specifies an alternate text for an image (only for type="image")
	 *
	 * @return alternative text
	 */
	public String getAlt() {
		return getAttribute("alt");
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
	 * Specifies the tab order of an element
	 *
	 * @return tab order of the element
	 */
	public String getTabindex() {
		return getAttribute("tabindex");
	}

	/**
	 * Specifies a keyboard shortcut to access an element
	 *
	 * @return shortcut for the element
	 */
	public String getAccesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * Script to be run when an element gets focus
	 *
	 * @return script when element gets focus
	 */
	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	/**
	 * Script to be run when an element loses focus
	 *
	 * @return script when element looses focus
	 */
	public String getOnblur() {
		return getAttribute("onblur");
	}

	/**
	 * Script to be run when an element is selected
	 *
	 * @return script when element is selected
	 */
	public String getOnselect() {
		return getAttribute("onselect");
	}

	/**
	 * Script to be run when an element change
	 *
	 * @return script when the element is changed
	 */
	public String getOnchange() {
		return getAttribute("onchange");
	}

	/**
	 * Specifies the types of files that the server accepts (only for type="file")
	 *
	 * @return type of files the server accepts
	 */
	public String getAccept() {
		return getAttribute("accept");
	}

	/**
	 * Specifies the alignment of an image input (only for type="image")
	 *
	 * @return alignment of input
	 */
	public String getAlign() {
		return getAttribute("align");
	}

}
