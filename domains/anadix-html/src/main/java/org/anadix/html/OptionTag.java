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
 * Defines an option in a drop-down list
 *
 * @author tomason
 * @version $Id: $
 */
public class OptionTag extends CommonAttributes {

	OptionTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "option", parent, attributes);
	}

	/**
	 * Specifies that an option should be pre-selected when the page loads
	 *
	 * @return whether option is selected
	 */
	public String getSelected() {
		return getAttribute("selected");
	}

	/**
	 * Specifies that an option should be disabled
	 *
	 * @return whether the option should be disabled
	 */
	public String getDisabled() {
		return getAttribute("disabled");
	}

	/**
	 * Specifies a shorter label for an option
	 *
	 * @return label for the option
	 */
	public String getLabel() {
		return getAttribute("label");
	}

	/**
	 * Specifies the value to be sent to a server
	 *
	 * @return value sent to server
	 */
	public String getValue() {
		return getAttribute("value");
	}

}
