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
 * Superclass with definition of core attributes
 *
 * @author tomason
 * @version $Id: $
 */
public abstract class CoreAttributes extends HtmlElement {

	/**
	 * Constructor
	 *
	 * @param id id of element (not the attribute)
	 * @param name name of the element (tag name)
	 * @param parent parent element
	 * @param attributes attributes of the element
	 */
	public CoreAttributes(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	/**
	 * Specifies a unique id for an element
	 *
	 * @return unique id of the element
	 */
	public String getIdAttribute() {
		return getAttribute("id");
	}

	/**
	 * Specifies a classname for an element
	 *
	 * @return classname of the element
	 */
	public String getClassAttribute() {
		return getAttribute("class");
	}

	/**
	 * Specifies an inline style for an element
	 *
	 * @return style of the element
	 */
	public String getStyle() {
		return getAttribute("style");
	}

	/**
	 * Specifies extra information about an element
	 *
	 * @return extra information about the element
	 */
	public String getTitle() {
		return getAttribute("title");
	}
}
