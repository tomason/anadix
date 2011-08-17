package org.analyzer;

import java.io.InputStream;
import java.io.Reader;

/**
 * Represents a source for analysis
 * 
 * @author tomason
 */
public interface Source {
	/**
	 * @return source as a String
	 */
	String getText();

	/**
	 * @return source as a Reader
	 */
	Reader getReader();

	/**
	 * @return source as a Stream
	 */
	InputStream getStream();
}
