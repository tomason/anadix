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
 * Defines an embedded object
 *
 * @author tomason
 * @version $Id: $
 */
public class ObjectTag extends CommonAttributes {

	ObjectTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "object", parent, attributes);
	}

	/**
	 * Defines that the object should only be declared, not created or instantiated until needed
	 *
	 * @return whether to instantiate lazily
	 */
	public String getDeclare() {
		return getAttribute("declare");
	}

	/**
	 * Defines a class ID value as set in the Windows Registry or a URL
	 *
	 * @return class id
	 */
	public String getClassid() {
		return getAttribute("classid");
	}

	/**
	 * Defines where to find the code for the object
	 *
	 * @return URL with code base
	 */
	public String getCodebase() {
		return getAttribute("codebase");
	}

	/**
	 * Specifies the URL of the resource to be used by the object
	 *
	 * @return URL of data
	 */
	public String getData() {
		return getAttribute("data");
	}

	/**
	 * Specifies the MIME type of data specified in the data attribute
	 *
	 * @return MIME type of data
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * The internet media type of the code referred to by the classid attribute
	 *
	 * @return MIME type of media
	 */
	public String getCodetype() {
		return getAttribute("codetype");
	}

	/**
	 * A space separated list of URL's to archives. The archives contains resources relevant to the object
	 *
	 * @return list of resources
	 */
	public String getArchive() {
		return getAttribute("archive");
	}

	/**
	 * Defines a text to display while the object is loading
	 *
	 * @return text to be displayed while loading
	 */
	public String getStandby() {
		return getAttribute("standby");
	}

	/**
	 * Specifies the height of the object
	 *
	 * @return height of the object
	 */
	public String getHeight() {
		return getAttribute("height");
	}

	/**
	 * Specifies the width of the object
	 *
	 * @return width of the object
	 */
	public String getWidth() {
		return getAttribute("width");
	}

	/**
	 * Specifies the name of a client-side image map to be used with the object
	 *
	 * @return name of the map
	 */
	public String getUsemap() {
		return getAttribute("usemap");
	}

	/**
	 * Specifies a name for the object
	 *
	 * @return name of the object
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Specifies the tab order of an element
	 *
	 * @return tab indedx
	 */
	public String getTabindex() {
		return getAttribute("tabindex");
	}

	/**
	 * Specifies the alignment of the element according to surrounding elements
	 *
	 * @return alignment of the element
	 */
	public String getAlign() {
		return getAttribute("align");
	}

	/**
	 * Specifies the width of the border around an element
	 *
	 * @return width of the border
	 */
	public String getBorder() {
		return getAttribute("border");
	}

	/**
	 * Specifies the whitespace on left and right side of an object
	 *
	 * @return horizontal whitespace
	 */
	public String getHspace() {
		return getAttribute("hspace");
	}

	/**
	 * Specifies the whitespace on top and bottom of an object
	 *
	 * @return vertical whitespace
	 */
	public String getVspace() {
		return getAttribute("vspace");
	}

}
