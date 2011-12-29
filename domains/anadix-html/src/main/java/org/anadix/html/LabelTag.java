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
 * Defines a label for an &lt;input&gt; element
 *
 * @author tomason
 * @version $Id: $
 */
public class LabelTag extends CommonAttributes {

	LabelTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "label", parent, attributes);
	}

	/**
	 * 	Specifies which form element a label is bound to
	 *
	 * @return id of the element
	 */
	public String getFor() {
		return getAttribute("for");
	}

	/**
	 * Specifies a keyboard shortcut to access an element
	 *
	 * @return keybord shortcut
	 */
	public String getAccesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * Script to be run when an element gets focus
	 *
	 * @return script when the element gets focus
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

}
