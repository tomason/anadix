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
 * Most common attributes are defined here (%attrs)
 * 
 * @author tomason
 */
abstract class CommonAttributes extends CoreAttributes {

	public CommonAttributes(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	// //////////////////////// % i18n
	/**
	 * This attribute specifies the base language of an element's attribute
	 * values and text content. The default value of this attribute is unknown.
	 */
	public String getLang() {
		return getAttribute("lang");
	}

	/**
	 * This attribute specifies the base direction of directionally neutral text
	 * (i.e., text that doesn't have inherent directionality as defined in
	 * [UNICODE]) in an element's content and attribute values. It also
	 * specifies the directionality of tables.
	 */
	public String getDir() {
		return getAttribute("dir");
	}

	// //////////////////////// % events
	/**
	 * The onclick event occurs when the pointing device button is clicked over
	 * an element. This attribute may be used with most elements.
	 */
	public String getOnclick() {
		return getAttribute("onclick");
	}

	/**
	 * The ondblclick event occurs when the pointing device button is double
	 * clicked over an element. This attribute may be used with most elements.
	 */
	public String getOndblclick() {
		return getAttribute("ondblclick");
	}

	/**
	 * The onmousedown event occurs when the pointing device button is pressed
	 * over an element. This attribute may be used with most elements.
	 */
	public String getOnmousedown() {
		return getAttribute("onmousedown");
	}

	/**
	 * The onmouseup event occurs when the pointing device button is released
	 * over an element. This attribute may be used with most elements.
	 */
	public String getOnmouseup() {
		return getAttribute("onmouseup");
	}

	/**
	 * The onmouseover event occurs when the pointing device is moved onto an
	 * element. This attribute may be used with most elements.
	 */
	public String getOnmouseover() {
		return getAttribute("onmouseover");
	}

	/**
	 * The onmousemove event occurs when the pointing device is moved while it
	 * is over an element. This attribute may be used with most elements.
	 */
	public String getOnmousemove() {
		return getAttribute("onmousemove");
	}

	/**
	 * The onmouseout event occurs when the pointing device is moved away from
	 * an element. This attribute may be used with most elements.
	 */
	public String getOnmouseout() {
		return getAttribute("onmouseout");
	}

	/**
	 * The onkeypress event occurs when a key is pressed and released over an
	 * element. This attribute may be used with most elements.
	 */
	public String getOnkeypress() {
		return getAttribute("onkeypress");
	}

	/**
	 * The onkeydown event occurs when a key is pressed down over an element.
	 * This attribute may be used with most elements.
	 */
	public String getOnkeydown() {
		return getAttribute("onkeydown");
	}

	/**
	 * The onkeyup event occurs when a key is released over an element. This
	 * attribute may be used with most elements.
	 */
	public String getOnkeyup() {
		return getAttribute("onkeyup");
	}
}
