package org.analyzer.mock;

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
