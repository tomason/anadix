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

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.math.BigInteger;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class HtmlElementTest {
	private static final BigInteger id = new BigInteger("42");
	private static final HtmlElement parent = mock(HtmlElement.class);
	private static final Attributes attributes = new Attributes(new Properties());
	private static final String name = "html";
	private static final int position = 42;
	private static final String source = "<html><head></head><body><img /></body></html>";
	private static final String textContent = "some text content";

	private HtmlElement mock;

	@BeforeMethod
	public void prepareInstance() {
		mock = new MockHtmlElement(id, name, parent, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new MockHtmlElement(null, name, parent, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new MockHtmlElement(id, null, parent, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new MockHtmlElement(id, "", parent, attributes);
	}

	@Test(enabled = false, expectedExceptions = NullPointerException.class)
	public void testConstructor4() {
		// FIXME null parent is allowed (for HtmlTag class as it has no parent)
		new MockHtmlElement(id, name, null, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor5() {
		new MockHtmlElement(id, name, parent, null);
	}

	public void testGetAttributes() {
		assertEquals(mock.getAttributes(), attributes);
	}

	public void testGetId() {
		assertEquals(mock.getId(), id);
	}

	public void testGetName() {
		assertEquals(mock.getName(), name);
	}

	public void testGetParent() {
		assertEquals(mock.getParent(), parent);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testPosition1() {
		mock.setPosition(-position);
	}

	public void testPosition2() {
		assertEquals(mock.getPosition(), 0);

		mock.setPosition(position);
		assertEquals(mock.getPosition(), position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testSource1() {
		mock.setSource(null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testSource2() {
		mock.setSource("");
	}

	public void testSource3() {
		assertNull(mock.getSource());

		mock.setSource(source);
		assertEquals(mock.getSource(), source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testTextContent1() {
		mock.setTextContent(null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testTextContent2() {
		mock.setTextContent("");
	}

	public void testTextContent3() {
		assertNull(mock.getTextContent());

		mock.setTextContent(textContent);
		assertEquals(mock.getTextContent(), textContent);
	}

	public void testToString() {
		String toString = mock.toString();

		assertTrue(toString.startsWith(name));
		assertTrue(toString.contains(id.toString()));
		assertTrue(toString.contains(Integer.toString(position)));
		assertTrue(toString.contains(attributes.toString()));
	}

	private class MockHtmlElement extends HtmlElement {
		public MockHtmlElement(BigInteger id, String name, HtmlElement parent,
				Attributes attributes) {
			super(id, name, parent, attributes);
		}
	}
}
