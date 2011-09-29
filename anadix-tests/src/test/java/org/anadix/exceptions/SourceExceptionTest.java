package org.anadix.exceptions;

import static org.mockito.Mockito.*;

import org.testng.annotations.Test;

@Test
public class SourceExceptionTest {
	private String message = "some string";
	private Throwable cause = mock(Throwable.class);

	public void testConstructor1() {
		new SourceException();
	}

	public void testConstructor2() {
		new SourceException((String)null);
	}

	public void testConstructor3() {
		new SourceException(message);
	}

	public void testConstructor4() {
		new SourceException((Throwable)null);
	}

	public void testConstructor5() {
		new SourceException(cause);
	}

	public void testConstructor6() {
		new SourceException(null, null);
	}

	public void testConstructor7() {
		new SourceException(message, null);
	}

	public void testConstructor8() {
		new SourceException(null, cause);
	}

	public void testConstructor9() {
		new SourceException(message, cause);
	}
}
