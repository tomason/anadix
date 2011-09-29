package org.anadix.mock;

public class Invocation {
	private final String name;
	private final Object[] arguments;

	public Invocation(String name, Object... arguments) {
		if (name == null || arguments == null) {
			throw new NullPointerException();
		}
		this.name = name;
		this.arguments = arguments;
	}

	public Object[] getArguments() {
		return arguments;
	}

	public String getName() {
		return name;
	}
}
