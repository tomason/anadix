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
 * <p>InsTag class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class InsTag extends CommonAttributes {

	InsTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "ins", parent, attributes);
	}

	/**
	 * The value of this attribute is a URI that designates a source document or
	 * message. This attribute is intended to point to information explaining
	 * why a document was changed.
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCite() {
		return getAttribute("cite");
	}

	/**
	 * The value of this attribute specifies the date and time when the change
	 * was made.
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDatetime() {
		return getAttribute("datetime");
	}

}
