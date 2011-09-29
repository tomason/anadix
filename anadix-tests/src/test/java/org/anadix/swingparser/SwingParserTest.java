package org.anadix.swingparser;

import static org.mockito.Mockito.*;

import org.anadix.ElementFactory;
import org.anadix.Source;
import org.anadix.factories.SourceFactory;
import org.anadix.html.HTMLElementFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class SwingParserTest {
	private HTMLElementFactory factory;
	private SwingParser parser;

	@BeforeMethod(alwaysRun = true)
	public void prepareInstances() {
		factory = mock(HTMLElementFactory.class);
		parser = new SwingParser();
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void testParse1() throws Exception {
		parser.parse(null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testParse2() throws Exception {
		parser.setElementFactory(factory);
		parser.parse(null);
	}

	public void testParse3() throws Exception {
		parser.setElementFactory(factory);
		Source s = SourceFactory.newStringSource("<html><head></head><body></body></html>");

		parser.parse(s);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testSetElementFactory1() {
		parser.setElementFactory(null);
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void testSetElementFactory2() {
		parser.setElementFactory(mock(ElementFactory.class));
	}

	public void testSetElementFactory3() {
		parser.setElementFactory(factory);
	}
}
