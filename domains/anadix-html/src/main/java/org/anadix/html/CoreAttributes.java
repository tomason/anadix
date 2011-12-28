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
 * %coreattrs
 *
 * @author tomason
 * @version $Id: $
 */
public abstract class CoreAttributes extends HtmlElement {

	/**
	 * <p>Constructor for CoreAttributes.</p>
	 *
	 * @param id a {@link java.math.BigInteger} object.
	 * @param name a {@link java.lang.String} object.
	 * @param parent a {@link org.anadix.html.HtmlElement} object.
	 * @param attributes a {@link org.anadix.html.Attributes} object.
	 */
	public CoreAttributes(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	/**
	 * This attribute assigns a name to an element. This name must be unique in
	 * a document.
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getIdAttribute() {
		return getAttribute("id");
	}

	/**
	 * This attribute assigns a class name or set of class names to an element.
	 * Any number of elements may be assigned the same class name or names.
	 * Multiple class names must be separated by white space characters.
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getClassAttribute() {
		return getAttribute("class");
	}

	/**
	 * This attribute specifies style information for the current element.
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getStyle() {
		return getAttribute("style");
	}

	/**
	 * This attribute offers advisory information about the element for which it
	 * is set.
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTitle() {
		return getAttribute("title");
	}
}
