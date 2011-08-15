package org.analyzer.html;

import java.math.BigInteger;


public class ImgTag extends HtmlElement {

	ImgTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "img", parent, attributes);
	}

	public String getAlt() {
		return getAttributes().getAttribute("alt");
	}

	public String getLongdesc() {
		return getAttributes().getAttribute("longdesc");
	}

	public int getWidth() {
		return Integer.parseInt(getAttributes().getAttribute("width"));
	}

	public int getHeight() {
		return Integer.parseInt(getAttributes().getAttribute("height"));
	}
}
