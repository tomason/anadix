package org.analyzer.html;

import java.math.BigInteger;

public class TableTag extends HtmlElement {

	TableTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "table", parent, attributes);
	}


}
