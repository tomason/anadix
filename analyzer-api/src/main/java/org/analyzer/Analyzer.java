package org.analyzer;

/**
 * Heart of the analyzing API. Analyzer holds all the information neccessary
 * to analyze any source - it holds instances of parser and condition sets.
 * For help with creating instance of Analyzer see ObjectFactory.
 * 
 * @see org.analyzer.factories.ObjectFactory
 * @author tomason
 */
public interface Analyzer {

	/**
	 * Analyzes give source using parser and condition set
	 * instances given to analyzer when it was created
	 * 
	 * @param source - source to analyze
	 * @return instance of Report that holds the results of analysis
	 */
	Report analyze(Source source);
}
