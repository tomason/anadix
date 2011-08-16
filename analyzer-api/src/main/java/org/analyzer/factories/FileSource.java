package org.analyzer.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class FileSource extends AbstractSource {
	private final File source;

	public FileSource(File source) throws FileNotFoundException {
		if (!source.exists()) {
			throw new FileNotFoundException(source.getName());
		}
		this.source = source;
	}

	public InputStream getStream() {
		try {
			return new FileInputStream(source);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("This should not have happened", e);
		}
	}
}
