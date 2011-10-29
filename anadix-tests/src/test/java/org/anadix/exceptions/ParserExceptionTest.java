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

import static org.mockito.Mockito.*;

import org.testng.annotations.Test;

@Test
public class ParserExceptionTest {
	private String message = "some string";
	private Throwable cause = mock(Throwable.class);

	public void testConstructor1() {
		new ParserException();
	}

	public void testConstructor2() {
		new ParserException((String)null);
	}

	public void testConstructor3() {
		new ParserException(message);
	}

	public void testConstructor4() {
		new ParserException((Throwable)null);
	}

	public void testConstructor5() {
		new ParserException(cause);
	}

	public void testConstructor6() {
		new ParserException(null, null);
	}

	public void testConstructor7() {
		new ParserException(message, null);
	}

	public void testConstructor8() {
		new ParserException(null, cause);
	}

	public void testConstructor9() {
		new ParserException(message, cause);
	}
}
