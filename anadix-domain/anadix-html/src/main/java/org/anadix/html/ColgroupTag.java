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

public class ColgroupTag extends CommonAttributes {

	ColgroupTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "colgroup", parent, attributes);
	}

	/**
	 * This attribute, whose value must be an integer > 0, specifies the number
	 * of columns "spanned" by the COL element; the COL element shares its
	 * attributes with all the columns it spans. The default value for this
	 * attribute is 1 (i.e., the COL element refers to a single column). If the
	 * span attribute is set to N > 1, the current COL element shares its
	 * attributes with the next N-1 columns.
	 */
	public int getSpan() {
		String value = getAttribute("span");

		return (value == null) ? 1 : Integer.parseInt(value);
	}

	/**
	 * This attribute specifies a default width for each column spanned by the
	 * current COL element. It has the same meaning as the width attribute for
	 * the COLGROUP element and overrides it.
	 */
	public String getWidth() {
		return getAttribute("width");
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

}
