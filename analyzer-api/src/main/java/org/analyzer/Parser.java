package org.analyzer;

import java.util.Collection;

import org.analyzer.exceptions.ParserException;
import org.analyzer.utils.DroolsResource;

public interface Parser {

	void parse(Source source) throws ParserException;

	/**
	 * Returns resources (typically DRL files) used by Drools engine
	 * to process parser output. If no such resources are used this method
	 * returns empty collection
	 * 
	 * @return collection of DroolsResources
	 */
	Collection<DroolsResource> getDroolsResources();

	Class<? extends ElementFactory> getElementFactoryClass();

	<T extends ElementFactory> void setElementFactory(T factory);
}
