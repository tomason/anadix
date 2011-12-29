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

import org.anadix.html.Position;

/**
 * Event representing end of the tag (eg. &lt;/h1&gt;)
 *
 * @author tomason
 * @version $Id: $
 */
public class EndTagEvent extends TagEvent {
	private static final long serialVersionUID = -5227752432914046430L;

	/**
	 * Constructor
	 *
	 * @param ID in of the tag
	 * @param tagName name of the tag
	 * @param position position in document
	 */
	public EndTagEvent(BigInteger ID, String tagName, Position position) {
		super(ID, tagName, new Properties(), position);
	}
}
