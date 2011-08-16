package org.analyzer.html;

import java.math.BigInteger;
import java.util.Properties;

import org.analyzer.impl.AbstractElementFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class HTMLElementFactory extends AbstractElementFactory {

	public HTMLElementFactory(StatefulKnowledgeSession ksession) {
		super(ksession);
	}

	public void insertElement(HtmlElement element) {
		super.insertElement(element);
	}

	public HtmlTag createHtmlTag(BigInteger id, Properties attributes) {
		return new HtmlTag(id, new Attributes(attributes));
	}

	public FrameTag createFrameTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new FrameTag(id, parent, new Attributes(attributes));
	}

	public ImgTag createImgTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new ImgTag(id, parent, new Attributes(attributes));
	}

	public TableTag createTableTag(BigInteger id, HtmlElement parent, Properties attributes) {
		return new TableTag(id, parent, new Attributes(attributes));
	}

	public HtmlElement createTag(BigInteger id, String name, HtmlElement parent, Properties attributes) {
		if (Boolean.getBoolean("debug")) {
			System.out.println(
					String.format("new HtmlElement(%s, %s, %s, %s, null, 0",
							id, name, parent, new Attributes(attributes)));
		}

		return new HtmlElement(id, name, parent, new Attributes(attributes)) {};
	}
}
