package org.anadix.html;

import static org.testng.Assert.*;

import java.util.Collection;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class AttributesTest {
	private static final String ALT = "alt";
	private static final String WIDTH = "width";
	private static final String STYLE = "style";
	private static final String HEIGHT = "height";

	private Properties properties;
	private static final String alt = "alternative text";
	private static final String width = "25";
	private static final String heightStyle = "1.3em";
	private static final String widthStyle = "100px";
	private static final String style = HEIGHT + ": " + heightStyle + "; "+ WIDTH + ": " + widthStyle + ";";

	@BeforeMethod(alwaysRun = true)
	public void prepareProperties() {
		properties = new Properties();

		properties.setProperty(ALT, alt);
		properties.setProperty(WIDTH, width);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new Attributes(null);
	}

	public void testConstructor2() {
		new Attributes(properties);
	}

	public void testConstructor3() {
		properties.setProperty(STYLE, style);
		new Attributes(properties);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testGetAttribute1() {
		new Attributes(properties).getAttribute(null);
	}

	public void testGetAttribute2() {
		String a = new Attributes(properties).getAttribute(ALT);
		assertEquals(a, alt);
	}

	public void testGetAttribute3() {
		String a = new Attributes(properties).getAttribute(WIDTH);
		assertEquals(a, width);
	}

	public void testGetAttribute4() {
		String a = new Attributes(properties).getAttribute(HEIGHT);
		assertNull(a);
	}

	public void testGetAttribute5() {
		properties.setProperty(STYLE, style);
		String a = new Attributes(properties).getAttribute(ALT);
		assertEquals(a, alt);
	}

	public void testGetAttribute6() {
		properties.setProperty(STYLE, style);
		String a = new Attributes(properties).getAttribute(WIDTH);
		assertEquals(a, widthStyle);
	}
	public void testGetAttribute7() {
		properties.setProperty(STYLE, style);
		String a = new Attributes(properties).getAttribute(HEIGHT);
		assertEquals(a, heightStyle);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testGetAttribute8() {
		new Attributes(properties).getAttribute(null, null);
	}

	public void testGetAttribute9() {
		new Attributes(properties).getAttribute(ALT, null);
	}

	public void testGetAttribute10() {
		new Attributes(properties).getAttribute("nonexistent", null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testGetAttribute11() {
		new Attributes(properties).getAttribute(null, alt);
	}

	public void testGetAttribute12() {
		String a = new Attributes(properties).getAttribute(ALT, heightStyle);
		assertEquals(a, alt);
	}

	public void testGetAttribute13() {
		String a = new Attributes(properties).getAttribute(WIDTH, heightStyle);
		assertEquals(a, width);
	}

	public void testGetAttribute14() {
		String a = new Attributes(properties).getAttribute(HEIGHT, widthStyle);
		assertEquals(a, widthStyle);
	}

	public void testGetAttribute15() {
		String a = new Attributes(properties).getAttribute("nonexistent", widthStyle);
		assertEquals(a, widthStyle);
	}

	public void testGetAttribute16() {
		properties.setProperty(STYLE, style);
		String a = new Attributes(properties).getAttribute(ALT, widthStyle);
		assertEquals(a, alt);
	}

	public void testGetAttribute17() {
		properties.setProperty(STYLE, style);
		String a = new Attributes(properties).getAttribute(WIDTH, heightStyle);
		assertEquals(a, widthStyle);
	}
	public void testGetAttribute18() {
		properties.setProperty(STYLE, style);
		String a = new Attributes(properties).getAttribute(HEIGHT, widthStyle);
		assertEquals(a, heightStyle);
	}

	public void testGetAttribute19() {
		properties.setProperty(STYLE, style);
		String a = new Attributes(properties).getAttribute("nonexistent", widthStyle);
		assertEquals(a, widthStyle);
	}

	public void testGetAvaliableAttributes1() {
		Collection<String> available = new Attributes(properties).getAvaliableAttributes();

		assertTrue(available.contains(ALT));
		assertTrue(available.contains(WIDTH));
		assertFalse(available.contains(STYLE));
		assertFalse(available.contains(HEIGHT));
	}

	public void testGetAvaliableAttributes2() {
		properties.setProperty(STYLE, style);
		Collection<String> available = new Attributes(properties).getAvaliableAttributes();

		assertTrue(available.contains(ALT));
		assertTrue(available.contains(WIDTH));
		assertTrue(available.contains(STYLE));
		assertTrue(available.contains(HEIGHT));
	}

	public void testToString1() {
		String s = new Attributes(properties).toString();

		assertEquals(s, properties.toString());
	}

	@Test(enabled = false)
	public void testToString2() {
		// FIXME
		properties.setProperty(STYLE, style);
		String s = new Attributes(properties).toString();

		assertEquals(s, properties.toString());
	}
}
