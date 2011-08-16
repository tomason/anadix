package org.analyzer.factories;

import java.io.InputStream;

class ClassPathSource extends AbstractSource {
	private final String resourceName;

	public ClassPathSource(String resource) {
		this.resourceName = resource;
	}

	public InputStream getStream() {
		return getClass().getResourceAsStream(resourceName);
	}
}
