package org.analyzer;

/**
 * Enumeration of statuses for report items
 * 
 * @author tomason
 */
public enum ItemStatus {
	/**
	 * Report item is an error
	 */
	ERROR,
	/**
	 * Report item is a warning
	 */
	WARNING,
	/**
	 * Report item that is fine
	 */
	OK;
}
