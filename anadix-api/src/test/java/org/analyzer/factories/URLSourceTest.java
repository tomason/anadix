package org.analyzer.factories;

import static org.testng.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import org.analyzer.Source;
import org.analyzer.exceptions.SourceException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class URLSourceTest extends SourceTestTemplate {
	private URL url;
	private File f;

	@BeforeMethod(alwaysRun = true)
	public void prepareFile() throws Exception {
		try {
			f = File.createTempFile("SourceFactoryTestFile", ".htlm");
		} catch (IOException ex) {
			f = new File("SourceFactoryTestFile.htlm");
		}

		f.deleteOnExit();

		PrintWriter pw = new PrintWriter(f);
		pw.print(sourceText);
		pw.flush();
		pw.close();

		try {
			url = new URL("file://" + f.getAbsolutePath());
		} catch (IOException ex) {
			throw new Exception("Unable to instantiate URL: ", ex);
		}
	}



	@Test(groups = "constructor", dataProvider = "booleans", expectedExceptions = NullPointerException.class)
	public void testNewURLSource1(Boolean cache) throws Exception {
		if (cache == null) {
			SourceFactory.newURLSource((URL)null);
		} else {
			SourceFactory.newURLSource((URL)null, cache);
		}
	}

	@Test(groups = "constructor", dataProvider = "booleans", expectedExceptions = SourceException.class)
	public void testNewURLSource2(Boolean cache) throws Exception {
		if (!f.delete()) {
			fail("can't delete file!");
		}

		if (cache == null) {
			SourceFactory.newURLSource(url);
		} else {
			SourceFactory.newURLSource(url, cache);
		}
	}

	@Test(groups = "constructor", dataProvider = "booleans", expectedExceptions = SourceException.class)
	public void testNewURLSource3(Boolean cache) throws Exception {
		if (!f.setReadable(false)) {
			fail("cannot set file as unreadable!");
		}

		if (cache == null) {
			SourceFactory.newURLSource(url);
		} else {
			SourceFactory.newURLSource(url, cache);
		}
	}

	@Test(groups = "constructor", dataProvider = "booleans")
	public void testNewURLSource4(Boolean cache) throws Exception {
		if (cache == null) {
			SourceFactory.newURLSource(url);
		} else {
			SourceFactory.newURLSource(url, cache);
		}
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = RuntimeException.class)
	public void testGetStream1() throws Exception {
		Source s = SourceFactory.newURLSource(url, false);

		if (!f.delete()) {
			fail("can't delete file!");
		}

		System.out.println(s.getStream());
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetStream2() throws Exception {
		Source s = SourceFactory.newURLSource(url, false);

		InputStream is = s.getStream();

		assertNotNull(is);
		String content = readStream(is);
		assertNotNull(content);
		assertEquals(content, sourceText);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetStream3() throws Exception {
		Source s = SourceFactory.newURLSource(url, true);
		if (!f.delete()) {
			throw new Exception("Could not delete " + url.getPath());
		}

		InputStream is = s.getStream();

		assertNotNull(is);
		String content = readStream(is);
		assertNotNull(content);
		assertEquals(content, sourceText);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetText() throws Exception {
		Source s = SourceFactory.newURLSource(url, false);
		String content = s.getText();

		assertNotNull(content);
		assertEquals(content, sourceText);
	}
}
