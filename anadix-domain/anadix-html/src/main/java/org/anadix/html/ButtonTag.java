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
 * Defines a push button. See <a href="http://www.w3schools.com/tags/tag_button.asp">w3schools</a>.
 *
 * @author tomason
 * @version $Id: $
 */
public class ButtonTag extends CommonAttributes {

	ButtonTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "button", parent, attributes);
	}

	/**
	 * Specifies the name for a button
	 *
	 * @return the name for a button
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Specifies the underlying value of a button
	 *
	 * @return the underlying value of a button
	 */
	public String getValue() {
		return getAttribute("value");
	}

	/**
	 * Specifies the type of a button
	 *
	 * @return the type of a button
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * Specifies that a button should be disabled
	 *
	 * @return whether a button should be disabled
	 */
	public String getDisabled() {
		return getAttribute("disabled");
	}

	/**
	 * Specifies the tab order of an element
	 *
	 * @return the tab order of an element
	 */
	public String getTabindex() {
		return getAttribute("tabindex");
	}

	/**
	 * Specifies a keyboard shortcut to access an element
	 *
	 * @return a keyboard shortcut to access an element
	 */
	public String getAccesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * Script to be run when an element gets focus
	 *
	 * @return script to be run when an element gets focus
	 */
	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	/**
	 * Script to be run when an element loses focus
	 *
	 * @return script to be run when an element loses focus
	 */
	public String getOnblur() {
		return getAttribute("onblur");
	}

}
