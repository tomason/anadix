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

import org.anadix.exceptions.ParserException;
import org.anadix.utils.DroolsResource;

/**
 * Class used to parse the source.
 * The class has a few purposes:
 * <ul>
 *   <li>defines used fact model by parser - by returning class of
 *   		ElementFactory by method getElementFactoryClass()</li>
 *   <li>defines Drools resources - by returning collection of them by
 *   		method getDroolsResources</li>
 *   <li>actualy parses given sources - by implementing method
 *   		parse</li>
 * </ul>where
 * 
 * @author tomason
 */
public interface Parser {

	/**
	 * Parses given source and inserts Elements through ElementFactory
	 * 
	 * @param source - source to parse
	 * @throws ParserException - when something goes wrong during parsing
	 */
	void parse(Source source) throws ParserException;

	/**
	 * Returns resources (typically DRL files) used by Drools engine
	 * to process parser output. If no such resources are used this method
	 * returns empty collection
	 * 
	 * @return collection of DroolsResources
	 */
	Collection<DroolsResource> getDroolsResources();

	/**
	 * Returns class implementing ElementFactory that is used to insert
	 * elements into Drools working memory
	 * 
	 * @return instance of Class<? extends ElementFactory>
	 */
	Class<? extends ElementFactory> getElementFactoryClass();

	/**
	 * Inserts the instance of Element factory of a class defined by method
	 * getElementFactoryClass
	 * 
	 * @param factory - instance of ElementFactory
	 */
	void setElementFactory(ElementFactory factory);

	/**
	 * @return root package in which all the rules are located
	 */
	String getRulesPackage();
}
