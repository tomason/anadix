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
 * Defines a client-side script
 *
 * @author tomason
 * @version $Id: $
 */
public class ScriptTag extends HtmlElement {

	ScriptTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "script", parent, attributes);
	}

	/**
	 * Specifies the character encoding used in an external script file
	 *
	 * @return charset of script
	 */
	public String getCharset() {
		return getAttribute("charset");
	}

	/**
	 * Specifies the MIME type of the script
	 *
	 * @return MIME type of the script
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * <p>getLanguage.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLanguage() {
		return getAttribute("language");
	}

	/**
	 * Specifies the URL of an external script file
	 *
	 * @return URL of external script
	 */
	public String getSrc() {
		return getAttribute("src");
	}

	/**
	 * Specifies that the script is executed when the page has finished parsing (only for external scripts)
	 *
	 * @return whether to run script after page parsing
	 */
	public String getDefer() {
		return getAttribute("defer");
	}

	/**
	 * <p>getEvent.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getEvent() {
		return getAttribute("event");
	}

	/**
	 * <p>getFor.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getFor() {
		return getAttribute("for");
	}

}
