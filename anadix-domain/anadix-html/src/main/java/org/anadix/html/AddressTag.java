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
 * The ADDRESS element may be used by authors to supply contact information for
 * a document or a major part of a document such as a form. This element often
 * appears at the beginning or end of a document.
 * 
 * @author tomason
 */
public class AddressTag extends CommonAttributes {

	AddressTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "address", parent, attributes);
	}

}
