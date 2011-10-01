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

public class InputTag extends CommonAttributes {

	InputTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "input", parent, attributes);
	}

	public String getType() {
		return getAttribute("type");
	}

	public String getNameAttribute() {
		return getAttribute("name");
	}

	public String getValue() {
		return getAttribute("value");
	}

	public String getChecked() {
		return getAttribute("checked");
	}

	public String getDisabled() {
		return getAttribute("disabled");
	}

	public String getReadonly() {
		return getAttribute("readonly");
	}

	public String getSize() {
		return getAttribute("size");
	}

	public String getMaxlength() {
		return getAttribute("maxlength");
	}

	public String getSrc() {
		return getAttribute("src");
	}

	public String getAlt() {
		return getAttribute("alt");
	}

	public String getUsemap() {
		return getAttribute("usemap");
	}

	public String getIsmap() {
		return getAttribute("ismap");
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

	public String getOnselect() {
		return getAttribute("onselect");
	}

	public String getOnchange() {
		return getAttribute("onchange");
	}

	public String getAccept() {
		return getAttribute("accept");
	}

	public String getAlign() {
		return getAttribute("align");
	}

}
