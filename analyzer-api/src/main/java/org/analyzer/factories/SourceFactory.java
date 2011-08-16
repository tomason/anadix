package org.analyzer.factories;

import java.io.File;
import java.io.FileNotFoundException;

import org.analyzer.Source;
import org.analyzer.exceptions.SourceException;

public abstract class SourceFactory {

	public static Source newFileSource(File file) throws SourceException {
		try {
			return new FileSource(file);
		} catch (FileNotFoundException ex) {
			throw new SourceException("Unable to create source", ex);
		}
	}

	public static Source newFileSource(String filename) throws SourceException {
		return newFileSource(new File(filename));
	}

	public static Source newStringSource(String source) {
		return new StringSource(source);
	}

	public static Source newClassPathSource(String resource) {
		return new ClassPathSource(resource);
	}
}
