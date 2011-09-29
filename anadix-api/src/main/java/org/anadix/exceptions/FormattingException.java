package org.anadix.exceptions;

public class FormattingException extends Exception {
	private static final long serialVersionUID = 1L;

	public FormattingException() {
		super();
	}

	public FormattingException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormattingException(String message) {
		super(message);
	}

	public FormattingException(Throwable cause) {
		super(cause);
	}
}
