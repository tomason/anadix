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
package org.anadix.mock;

/**
 * Represents an invocation of a method
 *
 * @author tomason
 * @version $Id: $
 */
public class Invocation {
	private final String name;
	private final Object[] arguments;

	/**
	 * Constructor
	 *
	 * @param name name of a method that was invoked
	 * @param arguments arguments which the method was invoked with
	 */
	public Invocation(String name, Object... arguments) {
		if (name == null || arguments == null) {
			throw new NullPointerException();
		}
		this.name = name;
		this.arguments = arguments;
	}

	/**
	 * Gets the invocation arguments
	 *
	 * @return an array of objects passed as arguments
	 */
	public Object[] getArguments() {
		return arguments;
	}

	/**
	 * Gets the name of the method invoked
	 *
	 * @return name of invoked method
	 */
	public String getName() {
		return name;
	}
}
