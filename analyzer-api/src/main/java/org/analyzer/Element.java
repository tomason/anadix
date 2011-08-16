package org.analyzer;

/**
 * Class representing the smallest units of Source.
 * 
 * @author tomason
 */
public interface Element {

	/**
	 * Gets the name of the element
	 * @return name of the element
	 */
	String getName();

	/**
	 * Gets the source of the element
	 * (could be source code, location, etc.)
	 * @return source of the element
	 */
	String getSource();
}
