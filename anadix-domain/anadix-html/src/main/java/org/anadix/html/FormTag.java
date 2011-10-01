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

public class FormTag extends CommonAttributes {

	public FormTag(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	public String getAction() {
		return getAttribute("action");
	}

	public String getMethod() {
		return getAttribute("method");
	}

	public String getEnctype() {
		return getAttribute("enctype");
	}

	public String getAccept() {
		return getAttribute("accept");
	}

	public String getNameAttribute() {
		return getAttribute("name");
	}

	public String getOnsubmit() {
		return getAttribute("onsubmit");
	}

	public String getOnreset() {
		return getAttribute("onreset");
	}

	public String getTarget() {
		return getAttribute("target");
	}

	public String getAcceptCharset() {
		return getAttribute("accept-charset");
	}

}
