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
 * Superclass defining most common attributes
 * 
 * @author tomason
 */
abstract class CommonAttributes extends CoreAttributes {

	/**
	 * Constructor
	 *
	 * @param id id of the element (not id attribute)
	 * @param name name of the element (tag name)
	 * @param parent parent tag
	 * @param attributes list of attributes
	 */
	public CommonAttributes(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	// //////////////////////// % i18n
	/**
	 * Specifies a language code for the content in an element
	 *
	 * @return language code for content of the element
	 */
	public String getLang() {
		return getAttribute("lang");
	}

	/**
	 * Specifies the text direction for the content in an element
	 *
	 * @return text direction for the content of the element
	 */
	public String getDir() {
		return getAttribute("dir");
	}

	// //////////////////////// % events
	/**
	 * Script to be run on a mouse click
	 *
	 * @return script on mouse click
	 */
	public String getOnclick() {
		return getAttribute("onclick");
	}

	/**
	 * Script to be run on a mouse double-click
	 *
	 * @return script on double-click
	 */
	public String getOndblclick() {
		return getAttribute("ondblclick");
	}

	/**
	 * Script to be run when mouse button is pressed
	 *
	 * @return script on mouse button press
	 */
	public String getOnmousedown() {
		return getAttribute("onmousedown");
	}

	/**
	 * Script to be run when mouse button is released
	 *
	 * @return script on mouse button release
	 */
	public String getOnmouseup() {
		return getAttribute("onmouseup");
	}

	/**
	 * Script to be run when mouse pointer moves over an element
	 *
	 * @return script on mouse over element
	 */
	public String getOnmouseover() {
		return getAttribute("onmouseover");
	}

	/**
	 * Script to be run when mouse pointer moves
	 *
	 * @return script on mouse move within the element
	 */
	public String getOnmousemove() {
		return getAttribute("onmousemove");
	}

	/**
	 * Script to be run when mouse pointer moves out of an element
	 *
	 * @return script on mouse moving out of the element
	 */
	public String getOnmouseout() {
		return getAttribute("onmouseout");
	}

	/**
	 * 	Script to be run when a key is pressed and released
	 *
	 * @return script on key press and release
	 */
	public String getOnkeypress() {
		return getAttribute("onkeypress");
	}

	/**
	 * Script to be run when a key is pressed
	 *
	 * @return script on key press
	 */
	public String getOnkeydown() {
		return getAttribute("onkeydown");
	}

	/**
	 * Script to be run when a key is released
	 *
	 * @return script on key release
	 */
	public String getOnkeyup() {
		return getAttribute("onkeyup");
	}
}
