package org.anadix.html;

import java.math.BigInteger;

abstract class HTag extends CoreAttributes {
	HTag(BigInteger id, String level, HtmlElement parent, Attributes attributes) {
		super(id, level, parent, attributes);
	}

	public String getAlign() {
		return getAttribute("align");
	}
}
