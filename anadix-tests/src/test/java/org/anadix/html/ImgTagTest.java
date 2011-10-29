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

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class ImgTagTest {
	private static final BigInteger id = new BigInteger("14");
	private static final HtmlElement parent = mock(HtmlElement.class);
	private static final String alt = "alternative text";
	private static final String longdesc = "some longer description";
	private static final String width = "100px";
	private static final String height = "50%";

	private Attributes attributes;

	@BeforeTest
	public void prepareAttributes() {
		Properties p = new Properties();
		p.setProperty("alt", alt);
		p.setProperty("longdesc", longdesc);
		p.setProperty("style", "width: " + width + "; height: " + height + ";");

		attributes = new Attributes(p);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new ImgTag(null, null, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new ImgTag(null, parent, attributes);
	}

	@Test(enabled = false, expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		// FIXME parent can be null!
		new ImgTag(id, null, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor4() {
		new ImgTag(id, parent, null);
	}

	public void testGetAlt1() {
		ImgTag it = new ImgTag(id, parent, new Attributes(new Properties()));
		assertNull(it.getAlt());
	}

	public void testGetAlt2() {
		ImgTag it = new ImgTag(id, parent, attributes);
		assertEquals(it.getAlt(), alt);
	}

	public void testGetLongdesc1() {
		ImgTag it = new ImgTag(id, parent, new Attributes(new Properties()));
		assertNull(it.getAlt());
	}

	public void testGetLongdesc2() {
		ImgTag it = new ImgTag(id, parent, attributes);
		assertEquals(it.getLongdesc(), longdesc);
	}

	public void testGetWidth1() {
		ImgTag it = new ImgTag(id, parent, new Attributes(new Properties()));
		assertNull(it.getWidth());
	}

	public void testGetWidth2() {
		ImgTag it = new ImgTag(id, parent, attributes);
		assertEquals(it.getWidth(), width);
	}

	public void testGetWidth3() {
		Properties p = new Properties();
		String w = "100px";
		p.setProperty("width", w);
		Attributes a = new Attributes(p);

		ImgTag it = new ImgTag(id, parent, a);
		assertEquals(it.getWidth(), w);
	}

	public void testGetHeight1() {
		ImgTag it = new ImgTag(id, parent, new Attributes(new Properties()));
		assertNull(it.getHeight());
	}

	public void testGetHeight2() {
		ImgTag it = new ImgTag(id, parent, attributes);
		assertEquals(it.getHeight(), height);
	}

	public void testGetHeight3() {
		Properties p = new Properties();
		String h = "50px;";
		p.setProperty("height", h);
		Attributes a = new Attributes(p);

		ImgTag it = new ImgTag(id, parent, a);
		assertEquals(it.getHeight(), h);
	}
}
