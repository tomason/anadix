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
