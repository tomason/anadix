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
		return new DefaultElement(id, name, parent, new Attributes(attributes));
	}

	public static class DefaultElement extends HtmlElement {
		public DefaultElement(BigInteger id, String name, HtmlElement parent, Attributes attributes) {
			super(id, name, parent, attributes);
		}
	}
}
