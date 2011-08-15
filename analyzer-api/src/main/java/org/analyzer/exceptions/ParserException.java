package org.analyzer.exceptions;

public class ParserException extends Exception {
	private static final long serialVersionUID = -5499359537494913863L;

	public ParserException() {
	}

	public ParserException(String message) {
		super(message);
	}

	public ParserException(Throwable cause) {
		super(cause);
	}

	public ParserException(String message, Throwable cause) {
		super(message, cause);
	}
}
