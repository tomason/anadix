package org.anadix.swingparser;

import java.math.BigInteger;
import java.util.Properties;

import org.testng.annotations.Test;

@Test
public class SimpleTagEventTest {
	private static final BigInteger id = new BigInteger("14");
	private static final String tagName = "img";
	private static final Properties attributes = new Properties();
	private static final int position = 42;
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

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testConstructor6() {
		new SimpleTagEvent(id, tagName, attributes, -1);
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

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testConstructor12() {
		new SimpleTagEvent(id, tagName, attributes, -1, source);
	}

	public void testConstructor13() {
		new SimpleTagEvent(id, tagName, attributes, position, null);
	}

	public void testConstructor14() {
		new SimpleTagEvent(id, tagName, attributes, position, "");
	}
}
