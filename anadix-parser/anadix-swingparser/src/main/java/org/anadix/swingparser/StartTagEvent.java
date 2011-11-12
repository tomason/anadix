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
package org.anadix.swingparser;

import java.math.BigInteger;
import java.util.Properties;

/**
 * Event representing start of the pair tag (eg. &lt;h1&gt;)
 *
 * @author tomason
 * @version $Id: $
 */
public class StartTagEvent extends TagEvent {
	private static final long serialVersionUID = -4954582531613018733L;

	/**
	 * Constructor
	 *
	 * @param id if of a tag
	 * @param tagName name of he tag
	 * @param attributes attributes of the tag
	 * @param position position in document
	 */
	public StartTagEvent(BigInteger ID, String name, Properties attributes, int position) {
		super(ID, name, attributes, position);
	}

	/**
	 * Constructor
	 *
	 * @param id if of a tag
	 * @param tagName name of he tag
	 * @param attributes attributes of the tag
	 * @param position position in document
	 * @param source source code of the tag
	 */
	public StartTagEvent(BigInteger ID, String name, Properties attributes, int position, String source) {
		super(ID, name, attributes, position, source);
	}
}
