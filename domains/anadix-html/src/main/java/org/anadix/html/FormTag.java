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
 * Defines an HTML form for user input
 *
 * @author tomason
 * @version $Id: $
 */
public class FormTag extends CommonAttributes {

	FormTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "form", parent, attributes);
	}

	/**
	 * Specifies where to send the form-data when a form is submitted
	 *
	 * @return where to send data
	 */
	public String getAction() {
		return getAttribute("action");
	}

	/**
	 * Specifies the HTTP method to use when sending form-data
	 *
	 * @return HTTP method to send data
	 */
	public String getMethod() {
		return getAttribute("method");
	}

	/**
	 * Specifies how the form-data should be encoded when submitting it to the server (only for method="post")
	 *
	 * @return data encoding
	 */
	public String getEnctype() {
		return getAttribute("enctype");
	}

	/**
	 * Specifies the types of files that the server accepts (that can be submitted through a file upload)
	 *
	 * @return type of files accepted
	 */
	public String getAccept() {
		return getAttribute("accept");
	}

	/**
	 * Specifies the name of a form
	 *
	 * @return name of the form
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * Script to be run when a form is submitted
	 *
	 * @return script to be run when submitting
	 */
	public String getOnsubmit() {
		return getAttribute("onsubmit");
	}

	/**
	 * Script to be run when a form is reset
	 *
	 * @return script to be run when resetting
	 */
	public String getOnreset() {
		return getAttribute("onreset");
	}

	/**
	 * Specifies where to display the response that is received after submitting the form
	 *
	 * @return where to show response
	 */
	public String getTarget() {
		return getAttribute("target");
	}

	/**
	 * Specifies a list of character encodings that the server accepts
	 *
	 * @return list of accepted charsets
	 */
	public String getAcceptCharset() {
		return getAttribute("accept-charset");
	}

}
