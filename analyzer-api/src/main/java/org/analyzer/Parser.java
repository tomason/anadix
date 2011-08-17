package org.analyzer;

import java.util.Collection;

import org.analyzer.exceptions.ParserException;
import org.analyzer.utils.DroolsResource;

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
	<T extends ElementFactory> Class<T> getElementFactoryClass();

	/**
	 * Inserts the instance of Element factory of a class defined by method
	 * getElementFactoryClass
	 * 
	 * @param factory - instance of ElementFactory
	 */
	<T extends ElementFactory> void setElementFactory(T factory);
}
