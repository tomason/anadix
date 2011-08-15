package org.analyzer;

import java.io.InputStream;
import java.io.Reader;

public interface Source {
	String getText();

	Reader getReader();

	InputStream getStream();
}
