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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.anadix.exceptions.SourceException;
import org.slf4j.LoggerFactory;

class FileSource extends AbstractSource {
	private final File source;

	/**
	 * Constructor
	 *
	 * @param source - a file this source can be read from
	 * @throws org.anadix.exceptions.SourceException if the file doesn't exist
	 */
	public FileSource(File source) throws SourceException {
		super(source.getAbsolutePath());
		if (!source.exists()) {
			throw new SourceException("Unable to locate file");
		}
		this.source = source;
	}

	/**
	 * {@inheritDoc}
	 */
	public InputStream getStream() {
		try {
			return new FileInputStream(source);
		} catch (FileNotFoundException e) {
			LoggerFactory.getLogger(getClass()).error("Unable to find file", e);
			throw new RuntimeException("Unable to find file", e);
		}
	}
}
