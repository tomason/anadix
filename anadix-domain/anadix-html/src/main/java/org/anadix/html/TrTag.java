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

public class TrTag extends CommonAttributes {

	public TrTag(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	public String getAlign() {
		return getAttribute("align");
	}

	public String getChar() {
		return getAttribute("char");
	}

	public String getCharoff() {
		return getAttribute("charoff");
	}

	public String getValign() {
		return getAttribute("valign");
	}

	public String getBgcolor() {
		return getAttribute("bgcolor");
	}

}
