package org.analyzer.factories;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import org.analyzer.Source;

class StringSource implements Source {
	private final String source;

	public StringSource(String source) {
		this.source = source;
	}

	public String getText() {
		return source;
	}

	public Reader getReader() {
		return new StringReader(source);
	}

	public InputStream getStream() {
		return new ByteArrayInputStream(source.getBytes());
	}

}
