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

import org.testng.annotations.Test;

@Test
public class EndTagEventTest {
	private static final BigInteger id = new BigInteger("14");
	private static final String tagName = "html";
	private static final int position = 42;

	public void testConstructor1() {
		new EndTagEvent(id, tagName, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new EndTagEvent(null, tagName, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new EndTagEvent(id, null, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor4() {
		new EndTagEvent(id, "", position);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testConstructor5() {
		new EndTagEvent(id, tagName, -1);
	}
}
