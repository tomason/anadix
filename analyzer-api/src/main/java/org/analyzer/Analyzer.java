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
