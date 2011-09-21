package org.analyzer.swingparser;

import static org.testng.Assert.*;

import java.math.BigInteger;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TagEventTest {
	private static final BigInteger id = new BigInteger("14");
	private static final String tagName = "img";
	private static final Properties attributes = new Properties();
	private static final int position = 42;
	private static final String source = "<img />";

	public void testConstructor1() {
		new MockTagEvent(id, tagName, attributes, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new MockTagEvent(null, tagName, attributes, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new MockTagEvent(id, null, attributes, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor4() {
		new MockTagEvent(id, "", attributes, position);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor5() {
		new MockTagEvent(id, tagName, null, position);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testConstructor6() {
		new MockTagEvent(id, tagName, attributes, -1);
	}


	public void testConstructor7() {
		new MockTagEvent(id, tagName, attributes, position, source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor8() {
		new MockTagEvent(null, tagName, attributes, position, source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor9() {
		new MockTagEvent(id, null, attributes, position, source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor10() {
		new MockTagEvent(id, "", attributes, position, source);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor11() {
		new MockTagEvent(id, tagName, null, position, source);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testConstructor12() {
		new MockTagEvent(id, tagName, attributes, -1, source);
	}

	public void testConstructor13() {
		new MockTagEvent(id, tagName, attributes, position, null);
	}

	public void testConstructor14() {
		new MockTagEvent(id, tagName, attributes, position, "");
	}

	private TagEvent mock;
	@BeforeMethod
	public void prepareTagEvent() {
		mock = new MockTagEvent(id, tagName, attributes, position, source);
	}

	public void testGetId() {
		assertEquals(mock.getId(), id);
	}

	public void testGetTagName() {
		assertEquals(mock.getTagName(), tagName);
	}

	public void testGetAttributes() {
		assertEquals(mock.getAttributes(), attributes);
	}

	public void testGetPosition() {
		assertEquals(mock.getPosition(), position);
	}

	public void testGetSource1() {
		mock = new MockTagEvent(id, tagName, attributes, position, source);

		assertEquals(mock.getSource(), source);
	}

	public void testGetSource2() {
		mock = new MockTagEvent(id, tagName, attributes, position);

		assertNull(mock.getSource());
	}

	public void testHashCode() {
		TagEvent e1 = mock;
		TagEvent e2 = new MockTagEvent(id, "html", new Properties(), 0);
		TagEvent e3 = new MockTagEvent(new BigInteger("15"), tagName, attributes, position);

		assertEquals(e1.hashCode(), e1.hashCode());
		assertEquals(e1.hashCode(), e2.hashCode());
		assertNotEquals(e1.hashCode(), e3.hashCode());
		assertNotEquals(e2.hashCode(), e3.hashCode());
	}

	public void testEquals() {
		TagEvent e1 = mock;
		TagEvent e2 = new MockTagEvent(id, "html", new Properties(), 0);
		TagEvent e3 = new MockTagEvent(new BigInteger("15"), tagName, attributes, position);

		assertTrue(e1.equals(e1));
		assertFalse(e1.equals(null));
		assertFalse(e1.equals("some event"));
		assertTrue(e1.equals(e2));
		assertTrue(e2.equals(e1));
		assertFalse(e1.equals(e3));
		assertFalse(e3.equals(e1));
	}

	public void testToString() {
		String toString = mock.toString();

		assertTrue(toString.contains(id.toString()));
		assertTrue(toString.contains(tagName));
		assertTrue(toString.contains(Integer.toString(position)));
		assertTrue(toString.contains(attributes.toString()));
		assertFalse(toString.contains(source));
	}

	private class MockTagEvent extends TagEvent {
		private static final long serialVersionUID = -646381465297639866L;

		public MockTagEvent(BigInteger id, String tagName, Properties attributes, int position, String source) {
			super(id, tagName, attributes, position, source);
		}

		public MockTagEvent(BigInteger id, String tagName, Properties attributes, int position) {
			super(id, tagName, attributes, position);
		}
	}
}