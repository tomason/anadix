package org.analyzer.swingparser;

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
