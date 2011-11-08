package org.anadix.exceptions;

/**
 * Represents the exception during formatting.
 *
 * @author tomason
 * @version $Id: $
 */
public class FormattingException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public FormattingException() {
		super();
	}

	/**
	 * Constructor
	 *
	 * @param message - message to pass
	 * @param cause - cause of the exception
	 */
	public FormattingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 *
	 * @param message - message to pass
	 */
	public FormattingException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause - cause of the exception
	 */
	public FormattingException(Throwable cause) {
		super(cause);
	}
}
