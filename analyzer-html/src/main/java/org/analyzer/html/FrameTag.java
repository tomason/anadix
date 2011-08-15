package org.analyzer.html;

import java.math.BigInteger;


public class FrameTag extends HtmlElement {
	FrameTag(
			BigInteger id,
			HtmlElement parent,
			Attributes attributes) {
		super(id, "frame", parent, attributes);
	}

	public String getTitle() {
		return getAttributes().getAttribute("title");
	}
}
