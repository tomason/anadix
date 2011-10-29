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

public class Mock {
	private List<Invocation> invocations = new ArrayList<Invocation>();
	private boolean doThrow= false;

	protected void methodInvoked(Invocation method) {
		invocations.add(method);
	}

	protected boolean doThrow() {
		return doThrow;
	}

	public void throwExceptions(boolean doThrow) {
		this.doThrow = doThrow;
	}

	public boolean wasInvoked(String method) {
		for (Invocation i : invocations) {
			if (i.getName().equals(method)) {
				return true;
			}
		}

		return false;
	}

	public int invocationCount() {
		return invocations.size();
	}

	public int invocationCount(String method) {
		int result = 0;

		for (Invocation i : invocations) {
			if (i.getName().equals(method)) {
				result++;
			}
		}

		return result;
	}

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
