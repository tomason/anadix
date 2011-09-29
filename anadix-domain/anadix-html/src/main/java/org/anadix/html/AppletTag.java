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
 * APPLET is deprecated (with all its attributes) in favor of OBJECT.
 * 
 * @author tomason
 */
public class AppletTag extends HtmlElement {

	public AppletTag(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	/**
	 * This attribute specifies the base URI for the applet. If this attribute is not specified, then it defaults the same base URI as for the current document. Values for this attribute may only refer to subdirectories of the directory containing the current document. Note. While the restriction on subdirectories is a departure from common practice and the HTML 3.2 specification, the HTML Working Group has chosen to leave the restriction in this version of the specification for security reasons.
	 */
	public String getCodebase() {
		return getAttribute("codebase");
	}

	/**
	 * This attribute specifies either the name of the class file that contains the applet's compiled applet subclass or the path to get the class, including the class file itself. It is interpreted with respect to the applet's codebase. One of code or object must be present.
	 */
	public String getCode() {
		return getAttribute("code");
	}

	/**
	 * This attribute specifies a name for the applet instance, which makes it possible for applets on the same page to find (and communicate with) each other.
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * This attribute specifies a comma-separated list of URIs for archives containing classes and other resources that will be "preloaded". The classes are loaded using an instance of an AppletClassLoader with the given codebase. Relative URIs for archives are interpreted with respect to the applet's codebase. Preloading resources can significantly improve the performance of applets.
	 */
	public String getArchive() {
		return getAttribute("archive");
	}

	/**
	 * This attribute names a resource containing a serialized representation of an applet's state. It is interpreted relative to the applet's codebase. The serialized data contains the applet's class name but not the implementation. The class name is used to retrieve the implementation from a class file or archive.

When the applet is "deserialized" the start() method is invoked but not the init() method. Attributes valid when the original object was serialized are not restored. Any attributes passed to this APPLET instance will be available to the applet. Authors should use this feature with extreme caution. An applet should be stopped before it is serialized.

Either code or object must be present. If both code and object are given, it is an error if they provide different class names.
	 */
	public String getObject() {
		return getAttribute("object");
	}

	/**
	 * This attribute specifies the initial width of the applet's display area (excluding any windows or dialogs that the applet creates).
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * This attribute specifies the initial height of the applet's display area (excluding any windows or dialogs that the applet creates).
	 */
	public String getHeight() {
		return getAttribute("height");
	}

	public String getIdAttribute() {
		return getAttribute("id");
	}

	public String getTitle() {
		return getAttribute("title");
	}

	public String getStyle() {
		return getAttribute("style");
	}

	public String getAlt() {
		return getAttribute("alt");
	}

	public String getAlign() {
		return getAttribute("align");
	}

	public String getHspace() {
		return getAttribute("hspace");
	}

	public String getVspace() {
		return getAttribute("vspace");
	}
}
