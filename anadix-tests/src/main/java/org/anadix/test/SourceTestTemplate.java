/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;

/**
 * Default superclass for tests
 *
 * @author tomason
 * @version $Id: $
 */
public abstract class SourceTestTemplate {
	/** Path to the test resource file */
	protected static final String resourcePath = "/SourceTestFile.html";
	/** Text of the resource file */
	protected static final String sourceText =
			readStream(SourceTestTemplate.class.getResourceAsStream(resourcePath));

	/**
	 * Data provider preparing Boolean values - null, true and false
	 *
	 * @return data provider (Iterator<Object[]>)
	 */
	@DataProvider(name = "booleans")
	public Iterator<Object[]> prepareBooleans() {
		Set<Object[]> s = new HashSet<Object[]>();
		s.add(new Object[]{null});
		s.add(new Object[]{true});
		s.add(new Object[]{false});

		return s.iterator();
	}

	/**
	 * Reads the whole stream and returns the text in it
	 *
	 * @param InputStream to read
	 * @return text in the stream
	 */
	protected static String readStream(InputStream is) {
		return readReader(new InputStreamReader(is));
	}

	/**
	 * Reads the whole reader and returns the text in it
	 *
	 * @param r Reader to read
	 * @return text in reader
	 */
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
