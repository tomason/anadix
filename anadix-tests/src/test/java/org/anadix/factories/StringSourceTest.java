package org.anadix.factories;

import static org.testng.Assert.*;

import java.io.InputStream;
import java.io.Reader;

import org.anadix.Source;
import org.anadix.test.SourceTestTemplate;
import org.testng.annotations.Test;


public class StringSourceTest extends SourceTestTemplate {
	private final String description = "test description";

	@Test(groups = "constructor", expectedExceptions = NullPointerException.class)
	public void testNewStringSource1() throws Exception {
		SourceFactory.newStringSource(null);
	}

	@Test(groups = "constructor", expectedExceptions = NullPointerException.class)
	public void testNewStringSource2() throws Exception {
		SourceFactory.newStringSource(null, null);
	}

	@Test(groups = "constructor", expectedExceptions = NullPointerException.class)
	public void testNewStringSource3() throws Exception {
		SourceFactory.newStringSource(null, description);
	}

	@Test(groups = "constructor")
	public void testNewStringSource4() throws Exception {
		SourceFactory.newStringSource(sourceText, null);
	}

	@Test(groups = "constructor")
	public void testNewStringSource5() throws Exception {
		SourceFactory.newStringSource(sourceText, description);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetDescription() throws Exception {
		Source s = SourceFactory.newStringSource(sourceText, description);

		assertEquals(s.getDescription(), description);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetStream() throws Exception {
		Source s = SourceFactory.newStringSource(sourceText);

		InputStream is = s.getStream();

		assertNotNull(is);
		String content = readStream(is);
		assertNotNull(content);
		assertEquals(content, sourceText);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetReader() throws Exception {
		Source s = SourceFactory.newStringSource(sourceText);

		Reader r = s.getReader();

		assertNotNull(r);
		String content = readReader(r);
		assertNotNull(content);
		assertEquals(content, sourceText);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetText() throws Exception {
		Source s = SourceFactory.newStringSource(sourceText);
		String content = s.getText();

		assertNotNull(content);
		assertEquals(content, sourceText);
	}
}
