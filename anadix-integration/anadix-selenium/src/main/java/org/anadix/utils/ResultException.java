package org.anadix.utils;

public class ResultException extends Exception {
	private static final long serialVersionUID = -5547309430027614500L;

	public ResultException() {
	}

	public ResultException(String message) {
		super(message);
	}

	public ResultException(Throwable cause) {
		super(cause);
	}

	public ResultException(String message, Throwable cause) {
		super(message, cause);
	}

}
