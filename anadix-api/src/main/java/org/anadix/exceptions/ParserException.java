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
package org.anadix.exceptions;

/**
 * Represents the exception during parsing.
 *
 * @author tomason
 * @version $Id: $
 */
public class ParserException extends Exception {
	private static final long serialVersionUID = -5499359537494913863L;

	/**
	 * Constructor
	 */
	public ParserException() {
	}

	/**
	 * Constructor
	 *
	 * @param message - message to pass
	 */
	public ParserException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause - cause of the exception
	 */
	public ParserException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor
	 *
	 * @param message - message to pass
	 * @param cause - cause of the exception
	 */
	public ParserException(String message, Throwable cause) {
		super(message, cause);
	}
}
