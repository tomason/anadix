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

import java.io.InputStream;

import org.analyzer.exceptions.SourceException;

class ClassPathSource extends AbstractSource {
	private final String resourceName;

	public ClassPathSource(String resource) throws SourceException {
		super(resource);
		if (getClass().getResource(resource) == null) {
			throw new SourceException("Resource not found " + resource);
		}
		this.resourceName = resource;
	}

	public InputStream getStream() {
		return getClass().getResourceAsStream(resourceName);
	}
}
