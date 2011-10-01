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

public class ButtonTag extends HtmlElement {

	public ButtonTag(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	/**
	 * 
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * 
	 */
	public String getValue() {
		return getAttribute("value");
	}

	/**
	 * 
	 */
	public String getType() {
		return getAttribute("type");
	}

	public String getDisabled() {
		return getAttribute("disabled");
	}

	public String getTabindex() {
		return getAttribute("tabindex");
	}

	public String getAccesskey() {
		return getAttribute("accesskey");
	}

	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	public String getOnblur() {
		return getAttribute("onblur");
	}
}