package org.anadix.factories;

import static org.testng.Assert.*;

import java.io.InputStream;
import java.io.Reader;

import org.anadix.Source;
import org.anadix.exceptions.SourceException;
import org.anadix.test.SourceTestTemplate;
import org.testng.annotations.Test;

public class ClassPathSourceTest extends SourceTestTemplate {

	@Test(groups = "constructor", dataProvider = "booleans", expectedExceptions = NullPointerException.class)
	public void testNewClassPathSource1(Boolean cache) throws Exception {
		if (cache == null) {
			SourceFactory.newClassPathSource((String)null);
		} else {
			SourceFactory.newClassPathSource((String)null, cache);
		}
	}

	@Test(groups = "constructor", dataProvider = "booleans", expectedExceptions = SourceException.class)
	public void testNewClassPathSource2(Boolean cache) throws Exception {
		String nonsense = "/nonsense/package/and/non/existent.resource";

		if (cache == null) {
			SourceFactory.newClassPathSource(nonsense);
		} else {
			SourceFactory.newClassPathSource(nonsense, cache);
		}
	}

	@Test(groups = "constructor", dataProvider = "booleans")
	public void testNewClassPathSource3(Boolean cache) throws Exception {
		if (cache == null) {
			SourceFactory.newClassPathSource(resourcePath);
		} else {
			SourceFactory.newClassPathSource(resourcePath, cache);
		}
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetDescription() throws Exception {
		Source s = SourceFactory.newClassPathSource(resourcePath);

		assertEquals(s.getDescription(), resourcePath);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetStream() throws Exception {
		Source s = SourceFactory.newClassPathSource(resourcePath, false);

		InputStream is = s.getStream();

		assertNotNull(is);
		String content = readStream(is);
		assertNotNull(content);
		assertEquals(content, sourceText);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetReader() throws Exception {
		Source s = SourceFactory.newClassPathSource(resourcePath, false);

		Reader r = s.getReader();

		assertNotNull(r);
		String content = readReader(r);
		assertNotNull(content);
		assertEquals(content, sourceText);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetText() throws Exception {
		Source s = SourceFactory.newClassPathSource(resourcePath, false);

		String content = s.getText();
		assertNotNull(content);
		assertEquals(content, sourceText);
	}
}
