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
 * Defines a set of frames
 *
 * @author tomason
 * @version $Id: $
 */
public class FramesetTag extends CoreAttributes {

	FramesetTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "frameset", parent, attributes);
	}

	/**
	 * Specifies the number and size of rows in a frameset
	 *
	 * @return number of rows
	 */
	public String getRows() {
		return getAttribute("rows");
	}

	/**
	 * Specifies the number and size of columns in a frameset
	 *
	 * @return number of columns
	 */
	public String getCols() {
		return getAttribute("cols");
	}

	/**
	 * Script to be run when a document load
	 *
	 * @return script when document is loaded
	 */
	public String getOnload() {
		return getAttribute("onload");
	}

	/**
	 * Script to be run when a document unload
	 *
	 * @return script when document is unloaded
	 */
	public String getOnunload() {
		return getAttribute("onunload");
	}

}
