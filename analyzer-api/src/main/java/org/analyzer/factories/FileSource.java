package org.analyzer.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.analyzer.Source;
import org.analyzer.utils.FileHelper;

class FileSource implements Source {
	private final File source;

	public FileSource(File source) throws FileNotFoundException {
		if (!source.exists()) {
			throw new FileNotFoundException(source.getName());
		}
		this.source = source;
	}

	public String getText() {
		try {
			return FileHelper.readSource(source);
		} catch (IOException ex) {
			throw new RuntimeException("Unable to read file", ex);
		}
	}

	public Reader getReader() {
		try {
			return new FileReader(source);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("This should not have happened", e);
		}
	}

	public InputStream getStream() {
		try {
			return new FileInputStream(source);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("This should not have happened", e);
		}
	}
}
