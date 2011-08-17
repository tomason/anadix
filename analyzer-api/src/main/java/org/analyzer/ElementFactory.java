package org.analyzer;

import java.util.Collection;

/**
 * ElementFactory is a class representing domain objects for use by parser and
 * conditions. All elements should be inserted using ElementFactory.
 * Importatnt note - the implementing classes MUST have constructor with parameter
 * StatefulKnowledgeSession as it's the constructor analyzer is looking for!
 * This will be a subject to further improvements.
 * 
 * @author tomason
 */
public interface ElementFactory {

	/**
	 * Gets all elements inserted through this ElementFactory
	 * 
	 * @return Collection of Elements
	 */
	Collection<Element> getElements();

	/**
	 * Sets this instance of ElementFactory as a global variable with given name
	 * 
	 * @param name - name of the global to set with this instance
	 */
	void setAsGlobal(String name);

	/**
	 * Inserts element using this ElementFactory
	 * 
	 * @param element - element to insert
	 */
	void insertElement(Element element);

	/**
	 * Inserts an object using specific entry point using this ElementFactory
	 * 
	 * @param entrypoint - entry point to insert the object through
	 * @param event - object to insert
	 */
	void insertEvent(String entrypoint, Object event);

}