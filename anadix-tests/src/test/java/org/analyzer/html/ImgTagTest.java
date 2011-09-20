package org.analyzer.html;

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
	private static final int width = 100;
	private static final int height = 50;

	private Attributes attributes;

	@BeforeTest
	public void prepareAttributes() {
		Properties p = new Properties();
		p.setProperty("alt", alt);
		p.setProperty("longdesc", longdesc);
		p.setProperty("style", "width: " + width + "px; height: " + height + "%;");

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
		assertEquals(it.getWidth(), -1);
	}

	public void testGetWidth2() {
		ImgTag it = new ImgTag(id, parent, attributes);
		assertEquals(it.getWidth(), width);
	}

	public void testGetWidth3() {
		Properties p = new Properties();
		int w = 100;
		p.setProperty("width", Integer.toString(w));
		Attributes a = new Attributes(p);

		ImgTag it = new ImgTag(id, parent, a);
		assertEquals(it.getWidth(), w);
	}

	public void testGetHeight1() {
		ImgTag it = new ImgTag(id, parent, new Attributes(new Properties()));
		assertEquals(it.getHeight(), -1);
	}

	public void testGetHeight2() {
		ImgTag it = new ImgTag(id, parent, attributes);
		assertEquals(it.getHeight(), height);
	}

	public void testGetHeight3() {
		Properties p = new Properties();
		int h = 50;
		p.setProperty("height", Integer.toString(h));
		Attributes a = new Attributes(p);

		ImgTag it = new ImgTag(id, parent, a);
		assertEquals(it.getHeight(), h);
	}
}
