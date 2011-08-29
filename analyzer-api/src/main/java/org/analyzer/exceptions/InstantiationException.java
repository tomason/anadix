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
package org.analyzer.exceptions;


/**
 * Exception during creation of a new instance.
 * FIXME Consider removing this class and using java.lang.InstantiationException
 * 
 * @author tomason
 */
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
