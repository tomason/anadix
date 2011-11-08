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

import org.anadix.utils.DroolsResource;

/**
 * Represents a set of conditions to feed into analyzer.
 * To ensure compatibility with parser the ElementFactory used for this
 * condition set has to be of a same class or subclass of ElementFactory used
 * in parser. This is checked during creation of analyzer.
 *
 * @author tomason
 * @version $Id: $
 */
public interface ConditionSet {

	/**
	 * Gets the name of this condition set
	 *
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
	 * Gets class of used implementation of ElementFactory. The element factory class must be subclass or same class as the one used in Parser.
	 *
	 * @return class of used implementation of ElementFactory
	 */
	Class<? extends ElementFactory> getElementFactoryClass();

	/**
	 * Gets class of the default Parser. This is important in situation when no parser is specified.
	 *
	 * @return class used as a default parser
	 */
	Class<? extends Parser> getDefaultParser();
}
