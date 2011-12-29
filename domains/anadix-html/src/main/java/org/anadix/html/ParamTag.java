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
 * Defines a parameter for an object
 *
 * @author tomason
 * @version $Id: $
 */
public class ParamTag extends HtmlElement {

	ParamTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "param", parent, attributes);
	}

	/**
	 * Specifies a unique id for an element
	 *
	 * @return unique element id
	 */
	public String getIdAttribute() {
		return getAttribute("id");
	}

	/**
	 * Specifies the name of a parameter
	 *
	 * @return name of the element
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Specifies the value of the parameter
	 *
	 * @return value of the parameter
	 */
	public String getValue() {
		return getAttribute("value");
	}

	/**
	 * Specifies the type of the value
	 *
	 * @return type of the value
	 */
	public String getValuetype() {
		return getAttribute("valuetype");
	}

	/**
	 * Specifies the MIME type of the parameter
	 *
	 * @return MIME type of the parameter
	 */
	public String getType() {
		return getAttribute("type");
	}

}
