package org.analyzer.factories;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.analyzer.test.SourceTestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AbstractSourceTest extends SourceTestTemplate {
	private InputStream is;
	private AbstractSource as;
	private final String description = "some description";

	@BeforeMethod
	public void prepareMocks() {
		is = mock(InputStream.class);
		as =  new AbstractSource(description) {
			public InputStream getStream() {
				return is;
			}
		};
	}


	@Test
	public void testGetDescription() {
		assertNotNull(as.getDescription());
		assertEquals(as.getDescription(), description);
	}

	@Test
	public void testGetText1() throws Exception {
		IOException e = new IOException("test exception");
		when(is.read()).thenThrow(e);

		String text = as.getText();

		verify(is).close();
		assertNotNull(text);
		assertEquals(text, "");
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testGetText2() throws Exception {
		as = new AbstractSource(description) {
			public InputStream getStream() {
				return null;
			}
		};

		as.getText();
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void testGetText3() throws Exception {
		IOException e = new IOException("test exception");
		when(is.read()).thenThrow(e);
		doThrow(e).when(is).close();

		as.getText();
	}
}
