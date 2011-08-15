package org.analyzer.exceptions;

public class SourceException extends Exception {
	private static final long serialVersionUID = -2279894355884568950L;

	public SourceException() {
	}

	public SourceException(String message) {
		super(message);
	}

	public SourceException(Throwable cause) {
		super(cause);
	}

	public SourceException(String message, Throwable cause) {
		super(message, cause);
	}
}
