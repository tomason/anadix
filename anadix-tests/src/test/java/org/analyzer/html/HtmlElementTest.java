package org.analyzer.html;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.math.BigInteger;
import java.util.Properties;

import org.testng.annotations.Test;

public class HtmlElementTest {
	private static final BigInteger id = new BigInteger("42");
	private static final HtmlElement parent = mock(HtmlElement.class);
	private static final Attributes attributes = new Attributes(new Properties());
	private static final String name = "html";
	private static final int position = 42;
	private static final String source = "<html><head></head><body><img /></body></html>";
	private static final String textContent = "some text content";

	private HtmlElement ft;

	public void prepareInstance() {
		ft = new MockHtmlElement(id, name, parent, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new MockHtmlElement(null, name, parent, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new MockHtmlElement(id, null, parent, attributes);
	}

	@Test(enabled = false, expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		// FIXME null parent is allowed (for HtmlTag class as it has no parent)
		new MockHtmlElement(id, name, null, attributes);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor4() {
		new MockHtmlElement(id, name, parent, null);
	}

	public void testGetAttributes() {
		assertEquals(ft.getAttributes(), attributes);
	}

	public void testGetId() {
		assertEquals(ft.getId(), id);
	}

	public void testGetName() {
		assertEquals(ft.getName(), name);
	}

	public void testGetParent() {
		assertEquals(ft.getParent(), parent);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testPosition1() {
		ft.setPosition(-position);
	}

	public void testPosition2() {
		assertEquals(ft.getPosition(), 0);

		ft.setPosition(position);
		assertEquals(ft.getPosition(), position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testSource1() {
		ft.setSource(null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testSource2() {
		ft.setSource("");
	}

	public void testSource3() {
		assertNull(ft.getSource());

		ft.setSource(source);
		assertEquals(ft.getSource(), source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testTextContent1() {
		ft.setTextContent(null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testTextContent2() {
		ft.setTextContent("");
	}

	public void testTextContent3() {
		assertNull(ft.getTextContent());

		ft.setTextContent(textContent);
		assertEquals(ft.getTextContent(), textContent);
	}

	private class MockHtmlElement extends HtmlElement {
		public MockHtmlElement(BigInteger id, String name, HtmlElement parent,
				Attributes attributes) {
			super(id, name, parent, attributes);
		}
	}
}
