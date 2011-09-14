package org.analyzer.factories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;

public abstract class SourceTestTemplate {
	protected static final String resourcePath = "/SourceTestFile.html";
	protected static final String sourceText =
			readStream(FileSourceTest.class.getResourceAsStream(resourcePath));

	@DataProvider(name = "booleans")
	public Iterator<Object[]> prepareBooleans() {
		Set<Object[]> s = new HashSet<Object[]>();
		s.add(new Object[]{null});
		s.add(new Object[]{true});
		s.add(new Object[]{false});

		return s.iterator();
	}

	protected static String readStream(InputStream is) {
		return readReader(new InputStreamReader(is));
	}

	protected static String readReader(Reader r) {
		try {
			BufferedReader br = new BufferedReader(r);

			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}

			return sb.toString();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
