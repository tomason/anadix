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

import static org.testng.Assert.*;

import java.math.BigInteger;
import java.util.Properties;

import org.testng.annotations.Test;

@Test
public class HtmlTagTest {
	private static final BigInteger id = new BigInteger("14");
	private static final Attributes attributes = new Attributes(new Properties());

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new HtmlTag(null, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new HtmlTag(null, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new HtmlTag(id, null);
	}

	public void testGetParent() {
		HtmlTag tag = new HtmlTag(id, attributes);

		assertEquals(tag.getParent(), tag);
	}
}
