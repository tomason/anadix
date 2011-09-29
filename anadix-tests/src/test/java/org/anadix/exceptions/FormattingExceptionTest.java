package org.anadix.exceptions;

import static org.mockito.Mockito.*;

import org.testng.annotations.Test;

@Test
public class FormattingExceptionTest {
	private String message = "some string";
	private Throwable cause = mock(Throwable.class);

	public void testConstructor1() {
		new FormattingException();
	}

	public void testConstructor2() {
		new FormattingException((String)null);
	}

	public void testConstructor3() {
		new FormattingException(message);
	}

	public void testConstructor4() {
		new FormattingException((Throwable)null);
	}

	public void testConstructor5() {
		new FormattingException(cause);
	}

	public void testConstructor6() {
		new FormattingException(null, null);
	}

	public void testConstructor7() {
		new FormattingException(message, null);
	}

	public void testConstructor8() {
		new FormattingException(null, cause);
	}

	public void testConstructor9() {
		new FormattingException(message, cause);
	}
}
