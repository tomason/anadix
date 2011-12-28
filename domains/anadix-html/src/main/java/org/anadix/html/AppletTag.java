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
 * Deprecated. Defines an embedded applet. See <a href="http://www.w3schools.com/tags/tag_applet.asp">w3schools</a>.
 *
 * @author tomason
 * @version $Id: $
 */
public class AppletTag extends CoreAttributes {

	AppletTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "applet", parent, attributes);
	}

	/**
	 * Specifies a relative base URL for applets specified in the code attribute
	 *
	 * @return a relative base URL for applets specified in the code attribute
	 */
	public String getCodebase() {
		return getAttribute("codebase");
	}

	/**
	 * Specifies the location of an archive file
	 *
	 * @return the location of an archive file
	 */
	public String getArchive() {
		return getAttribute("archive");
	}

	/**
	 * Specifies the file name of a Java applet
	 *
	 * @return the file name of a Java applet
	 */
	public String getCode() {
		return getAttribute("code");
	}

	/**
	 * Specifies a reference to a serialized representation of an applet
	 *
	 * @return a reference to a serialized representation of an applet
	 */
	public String getObject() {
		return getAttribute("object");
	}

	/**
	 * Specifies an alternate text for an applet
	 *
	 * @return an alternate text for an applet
	 */
	public String getAlt() {
		return getAttribute("alt");
	}

	/**
	 * Defines the name for an applet (to use in scripts)
	 *
	 * @return the name for an applet
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Specifies the width of an applet
	 *
	 * @return the width of an applet
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * Specifies the height of an applet
	 *
	 * @return the height of an applet
	 */
	public String getHeight() {
		return getAttribute("height");
	}

	/**
	 * Specifies the alignment of an applet according to surrounding elements
	 *
	 * @return the alignment of an applet according to surrounding elements
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Defines the horizontal spacing around an applet
	 *
	 * @return the horizontal spacing around an applet
	 */
	public String getHspace() {
		return getAttribute("hspace");
	}

	/**
	 * Defines the vertical spacing around an applet
	 *
	 * @return the vertical spacing around an applet
	 */
	public String getVspace() {
		return getAttribute("vspace");
	}
}
