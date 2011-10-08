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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.anadix.exceptions.SourceException;
import org.jboss.logging.Logger;

class URLSource extends AbstractSource {
	private static final Logger logger = Logger.getLogger(URLSource.class);
	private final URL url;

	public URLSource(URL url) throws SourceException {
		super(url.toExternalForm());
		this.url = url;

		try {
			url.openStream();
		} catch (IOException ex) {
			logger.error("Unable to open stream", ex);
			throw new SourceException("Unable to open stream " + url, ex);
		}
	}

	@Override
	public InputStream getStream() {
		try {
			return url.openStream();
		} catch (IOException ex) {
			logger.fatal("Unable to open stream", ex);
			throw new RuntimeException("Unable to open stream on " + url);
		}
	}

}
