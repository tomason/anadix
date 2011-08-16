package org.analyzer;

import java.util.Collection;

import org.analyzer.utils.DroolsResource;

/**
 * Represents a set of conditions to feed into analyzer.
 * To ensure compatibility with parser the ElementFactory used for this
 * condition set has to be of a same class or subclass of ElementFactory used
 * in parser. This is checked during creation of analyzer.
 * 
 * @author tomason
 */
public interface ConditionSet {

	/**
	 * @return name of this condition set
	 */
	String getName();

	/**
	 * The most important method - returns resources (typically DRL files)
	 * used by Drools engine to analyze requested sources
	 * 
	 * @return collection of DroolsResources
	 */
	Collection<DroolsResource> getDroolsResources();

	/**
	 * @return class of used implementation of ElementFactory
	 */
	Class<? extends ElementFactory> getElementFactoryUsed();
}
