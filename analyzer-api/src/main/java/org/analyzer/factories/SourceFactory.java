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
package org.analyzer.factories;

import java.io.File;
import java.io.FileNotFoundException;

import org.analyzer.Source;
import org.analyzer.exceptions.SourceException;

/**
 * Creates instances of Source for different types of sources
 * 
 * @author tomason
 */
public abstract class SourceFactory {

	/**
	 * Creates a new source pointing at a file
	 * 
	 * @param file - file to read a source from
	 * @return instance of Source
	 * @throws SourceException - if any error occurs during creation of new Source
	 */
	public static Source newFileSource(File file) throws SourceException {
		try {
			return new FileSource(file);
		} catch (FileNotFoundException ex) {
			throw new SourceException("Unable to create source", ex);
		}
	}

	/**
	 * Creates a new source pointing at a file
	 * 
	 * @param filename - path to file to read a source from
	 * @return instance of Source
	 * @throws SourceException - if any error occurs during creation of new Source
	 */
	public static Source newFileSource(String filename) throws SourceException {
		return newFileSource(new File(filename));
	}

	/**
	 * Creates a new source from a String
	 * 
	 * @param source - String containing the actual source
	 * @return instance of Source
	 */
	public static Source newStringSource(String source) {
		return new StringSource(source);
	}

	/**
	 * Creates a new Source from a classpath resource.
	 * The resource must be on classpath and reachable by default classloader!
	 * 
	 * @param resource - path to the resource
	 * @return instance of Source
	 */
	public static Source newClassPathSource(String resource) {
		return new ClassPathSource(resource);
	}
}
