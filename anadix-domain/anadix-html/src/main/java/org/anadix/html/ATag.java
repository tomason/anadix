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

/**
 * Defines an anchor. See <a href="http://www.w3schools.com/tags/tag_a.asp">w3schools</a>.
 *
 * @author tomason
 * @version $Id: $
 */
public class ATag extends CommonAttributes {

	ATag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "a", parent, attributes);
	}

	/**
	 * Specifies a keyboard shortcut to access an element
	 *
	 * @return a keyboard shortcut to access an element
	 */
	public String getAccesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * 	Specifies the character-set of a linked document
	 *
	 * @return the character-set of a linked document
	 */
	public String getCharset() {
		return getAttribute("charset");
	}
	
	/**
	 * Specifies the coordinates of a link
	 *
	 * @return the coordinates of a link
	 */
	public String getCoords() {
		return getAttribute("coords");
	}

	/**
	 * 	Specifies the destination of a link
	 *
	 * @return the destination of a link
	 */
	public String getHref() {
		return getAttribute("href");
	}

	/**
	 * Specifies the language of a linked document
	 *
	 * @return the language of a linked document
	 */
	public String getHreflang() {
		return getAttribute("hreflang");
	}

	/**
	 * 	Specifies the name of an anchor
	 *
	 * @return 	the name of an anchor
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Script to be run when an element loses focus
	 * @return script to be run when an element loses focus
	 *
	 */
	public String getOnblur() {
		return getAttribute("onblur");
	}

	/**
	 * Script to be run when an element gets focus
	 *
	 * @return script to be run when an element gets focus
	 */
	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	/**
	 * Specifies the relationship between the current document and the linked document
	 *
	 * @return the relationship between the current document and the linked document
	 */
	public String getRel() {
		return getAttribute("rel");
	}

	/**
	 * Specifies the relationship between the linked document and the current document
	 *
	 * @return the relationship between the linked document and the current document
	 */
	public String getRev() {
		return getAttribute("rev");
	}

	/**
	 * Specifies the shape of a link
	 *
	 * @return the shape of a link
	 */
	public String getShape() {
		return getAttribute("shape");
	}

	

	/**
	 * Specifies the tab order of an element
	 *
	 * @return the tab order of an element
	 */
	public String getTabindex() {
		return getAttribute("tabindex");
	}

	/**
	 * Specifies where to open the linked document
	 *
	 * @return where to open the linked document
	 */
	public String getTarget() {
		return getAttribute("target");
	}

}
