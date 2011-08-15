package org.analyzer.exceptions;

public class InstantiationException extends Exception {
	private static final long serialVersionUID = 1L;

	public InstantiationException(String message) {
		super(message);
	}

	public InstantiationException(Throwable cause) {
		super(cause);
	}

	public InstantiationException(String message, Throwable cause) {
		super(message, cause);
	}

}
