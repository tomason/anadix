/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix;

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
	 * Sets a global variable with given name with given value
	 * 
	 * @param name - name of the global to set
	 * @param instance -value of the global to set
	 */
	void setGlobal(String name, Object instance);

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