package org.analyzer.html;

import java.math.BigInteger;

public class HtmlTag extends HtmlElement {
	HtmlTag(BigInteger id, Attributes attributes) {
		super(id, "html", null, attributes);
	}

	@Override
	public HtmlTag getParent() {
		return this;
	}
}
