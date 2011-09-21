package org.analyzer.swingparser;

import org.analyzer.html.HTMLElementFactory;
import org.testng.annotations.Test;

@Test
public class StatefulParserCallbackTest {
	private HTMLElementFactory factory;
	private String source = "<html><head></head><body><h1 style=\"\">Hello world</h1><img src=\"img/pic.png\" /></body></html>";

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new StatefulParserCallback(null);
	}

	public void testConstructor2() {
		new StatefulParserCallback(factory);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new StatefulParserCallback(null, source);
	}

	public void testConstructor4() {
		new StatefulParserCallback(factory, null);
	}

	public void testConstructor5() {
		new StatefulParserCallback(factory, "");
	}

	// the rest of the methods should be tested with integration tests
}
