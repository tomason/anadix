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
public class FrameTagTest {
	private static final BigInteger id = new BigInteger("12");
	private static final HtmlElement parent = mock(HtmlElement.class);
	private static final String title = "Some title";
	private Attributes noTitle;
	private Attributes withTitle;
	private FrameTag ft;

	@BeforeTest
	public void prepareAttributes() {
		Properties p = new Properties();
		p.setProperty("width", "100px;");
		noTitle = new Attributes(p);

		p.setProperty("title", title);
		withTitle = new Attributes(p);

		ft = new FrameTag(id, parent, noTitle);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new FrameTag(null, parent, noTitle);
	}

	@Test(enabled = false, expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		// FIXME accepts null parent
		new FrameTag(id, null, noTitle);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new FrameTag(id, parent, null);
	}

	public void testGetName() {
		assertEquals(ft.getName(), "frame");
	}

	public void testGetTitle1() {
		FrameTag ft = new FrameTag(id, parent, noTitle);
		assertNull(ft.getTitle());
	}

	public void testGetTitle2() {
		FrameTag ft = new FrameTag(id, parent, withTitle);
		assertEquals(ft.getTitle(), title);
	}

}
