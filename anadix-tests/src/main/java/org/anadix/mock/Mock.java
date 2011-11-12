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

import java.util.ArrayList;
import java.util.List;

/**
 * Superclass for all mocked classes. Keeps track of invoked methods and indicates whether the method shall throw an exception.
 *
 * @author tomason
 * @version $Id: $
 */
public abstract class Mock {
	private List<Invocation> invocations = new ArrayList<Invocation>();
	private boolean doThrow = false;

	/**
	 * Called by subclasses when method is invoked and is used to track method invocation.
	 *
	 * @param method method and arguments it was invoked with
	 */
	protected void methodInvoked(Invocation method) {
		invocations.add(method);
	}

	/**
	 * Gets the flag indicating whether an exception shall be thrown
	 *
	 * @return a boolean
	 */
	protected boolean doThrow() {
		return doThrow;
	}

	/**
	 * Sets the flag indicating whether an exception shall be thrown
	 *
	 * @param doThrow a boolean.
	 */
	public void throwExceptions(boolean doThrow) {
		this.doThrow = doThrow;
	}

	/**
	 * Gets the information whether the method with given name was invoked
	 *
	 * @param method name of the method
	 * @return true if the method was invoked, false otherwise
	 */
	public boolean wasInvoked(String method) {
		for (Invocation i : invocations) {
			if (i.getName().equals(method)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Gets the total number of invocations
	 *
	 * @return number of invocations
	 */
	public int invocationCount() {
		return invocations.size();
	}

	/**
	 * Gets the number of invocations of given method
	 *
	 * @param method name of the method
	 * @return number of invocations
	 */
	public int invocationCount(String method) {
		int result = 0;

		for (Invocation i : invocations) {
			if (i.getName().equals(method)) {
				result++;
			}
		}

		return result;
	}

	/**
	 * Gets the number of invocations of given method with given arguments
	 *
	 * @param method name of the methods
	 * @param arguments arguments
	 * @return number of invocations
	 */
	public int invocationCount(String method, Object... arguments) {
		int result = 0;

		invocations : for (Invocation i : invocations) {
			if (i.getName().equals(method) && i.getArguments().length == arguments.length) {
				for (int j = 0; j < arguments.length; j++) {
					if (!i.getArguments()[j].equals(arguments[j])) {
						break invocations;
					}
				}
				result++;
			}
		}

		return result;
	}
}
