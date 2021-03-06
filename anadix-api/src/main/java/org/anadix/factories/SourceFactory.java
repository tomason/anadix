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
package org.anadix.factories;

import java.io.File;
import java.net.URL;

import org.anadix.Source;
import org.anadix.exceptions.SourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates instances of Source for different types of sources
 *
 * @author tomason
 * @version $Id: $
 */
public final class SourceFactory {
	private static final Logger logger = LoggerFactory.getLogger(SourceFactory.class);
	// FIXME add some settings to change caching policy
	private static final boolean cacheByDefault = true;
	private SourceFactory() {}

	/**
	 * Creates a new source pointing at a file
	 *
	 * @param file - file to read a source from
	 * @return instance of Source
	 * @throws org.anadix.exceptions.SourceException - if any error occurs during creation of new Source
	 */
	public static Source newFileSource(File file) throws SourceException {
		return newFileSource(file, cacheByDefault);
	}

	/**
	 * Creates a new source pointing at a file
	 *
	 * @param file - file to read a source from
	 * @param cache - whether to cache the result in memory
	 * @return instance of Source
	 * @throws org.anadix.exceptions.SourceException - if any error occurs during creation of new Source
	 */
	public static Source newFileSource(File file, boolean cache) throws SourceException {
		if (!file.canRead()) {
			throw new SourceException("Can't read file " + file.getPath());
		}
		Source s = new FileSource(file);
		if (cache) {
			logger.debug("Caching file source from '{}'", file.getAbsoluteFile());
			return newStringSource(s.getText(), s.getDescription());
		} else {
			return s;
		}
	}

	/**
	 * Creates a new source pointing at a file
	 *
	 * @param filename - path to file to read a source from
	 * @return instance of Source
	 * @throws org.anadix.exceptions.SourceException - if any error occurs during creation of new Source
	 */
	public static Source newFileSource(String filename) throws SourceException {
		return newFileSource(filename, cacheByDefault);
	}

	/**
	 * Creates a new source pointing at a file
	 *
	 * @param filename - path to file to read a source from
	 * @param cache - whether to cache the result in memory
	 * @return instance of Source
	 * @throws org.anadix.exceptions.SourceException - if any error occurs during creation of new Source
	 */
	public static Source newFileSource(String filename, boolean cache) throws SourceException {
		return newFileSource(new File(filename), cache);
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
	 * Creates a new source from a String
	 *
	 * @param source - String containing the actual source
	 * @param description - descripton of the Source
	 * @return instance of Source
	 */
	public static Source newStringSource(String source, String description) {
		return new StringSource(source, description);
	}

	/**
	 * Creates a new Source from a classpath resource.
	 * The resource must be on classpath and reachable by default classloader!
	 *
	 * @param resource - path to the resource
	 * @return instance of Source
	 * @throws org.anadix.exceptions.SourceException - if any error occurs during creation of new Source
	 */
	public static Source newClassPathSource(String resource) throws SourceException {
		return newClassPathSource(resource, cacheByDefault);
	}

	/**
	 * Creates a new Source from a classpath resource.
	 * The resource must be on classpath and reachable by default classloader!
	 *
	 * @param resource - path to the resource
	 * @param cache - whether to cache the result in memory
	 * @return instance of Source
	 * @throws org.anadix.exceptions.SourceException - if any error occurs during creation of new Source
	 */
	public static Source newClassPathSource(String resource, boolean cache) throws SourceException {
		Source s = new ClassPathSource(resource);
		if (cache) {
			logger.debug("Caching classpath source from '{}'", resource);
			return newStringSource(s.getText(), s.getDescription());
		} else {
			return s;
		}
	}

	/**
	 * Creates a new Source from an URL resource.
	 * The URL must exist and be valid!
	 *
	 * @param url - URL to get resource from
	 * @return instance of Source
	 * @throws org.anadix.exceptions.SourceException - if any error occurs during creation of new Source
	 */
	public static Source newURLSource(URL url) throws SourceException {
		return newURLSource(url, cacheByDefault);
	}

	/**
	 * Creates a new Source from an URL resource.
	 * The URL must exist and be valid!
	 *
	 * @param url - URL to get resource from
	 * @param cache - whether to cache the result in memory
	 * @return instance of Source
	 * @throws org.anadix.exceptions.SourceException - if any error occurs during creation of new Source
	 */
	public static Source newURLSource(URL url, boolean cache) throws SourceException {
		Source s = new URLSource(url);
		if (cache) {
			logger.debug("Caching URL source from '{}'", url.toExternalForm());
			return newStringSource(s.getText(), s.getDescription());
		} else {
			return s;
		}
	}
}
