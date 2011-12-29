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
import org.testng.annotations.Test;

@Test
public class SimpleTagEventTest {
	private static final BigInteger id = new BigInteger("14");
	private static final String tagName = "img";
	private static final Properties attributes = new Properties();
	private static final Position position = new Position(42);
	private static final String source = "<img />";

	public void testConstructor1() {
		new SimpleTagEvent(id, tagName, attributes, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new SimpleTagEvent(null, tagName, attributes, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new SimpleTagEvent(id, null, attributes, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor4() {
		new SimpleTagEvent(id, "", attributes, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor5() {
		new SimpleTagEvent(id, tagName, null, position);
	}

	public void testConstructor6() {
		new SimpleTagEvent(id, tagName, attributes, null);
	}


	public void testConstructor7() {
		new SimpleTagEvent(id, tagName, attributes, position, source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor8() {
		new SimpleTagEvent(null, tagName, attributes, position, source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor9() {
		new SimpleTagEvent(id, null, attributes, position, source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor10() {
		new SimpleTagEvent(id, "", attributes, position, source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor11() {
		new SimpleTagEvent(id, tagName, null, position, source);
	}

	public void testConstructor12() {
		new SimpleTagEvent(id, tagName, attributes, null, source);
	}

	public void testConstructor13() {
		new SimpleTagEvent(id, tagName, attributes, position, null);
	}

	public void testConstructor14() {
		new SimpleTagEvent(id, tagName, attributes, position, "");
	}
}
