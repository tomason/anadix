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
 * <p>FormTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class FormTag extends CommonAttributes {

	FormTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "form", parent, attributes);
	}

	/**
	 * <p>getAction.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAction() {
		return getAttribute("action");
	}

	/**
	 * <p>getMethod.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getMethod() {
		return getAttribute("method");
	}

	/**
	 * <p>getEnctype.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getEnctype() {
		return getAttribute("enctype");
	}

	/**
	 * <p>getAccept.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAccept() {
		return getAttribute("accept");
	}

	/**
	 * <p>getNameAttribute.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * <p>getOnsubmit.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getOnsubmit() {
		return getAttribute("onsubmit");
	}

	/**
	 * <p>getOnreset.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getOnreset() {
		return getAttribute("onreset");
	}

	/**
	 * <p>getTarget.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTarget() {
		return getAttribute("target");
	}

	/**
	 * <p>getAcceptCharset.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAcceptCharset() {
		return getAttribute("accept-charset");
	}

}
