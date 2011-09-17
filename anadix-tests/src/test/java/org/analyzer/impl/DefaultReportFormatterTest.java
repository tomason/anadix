package org.analyzer.impl;

import static org.mockito.Mockito.*;

import java.io.OutputStream;
import java.io.Writer;

import org.analyzer.Report;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DefaultReportFormatterTest {
	private DefaultReportFormatter drf;
	private Report r;
	private OutputStream os;
	private Writer w;

	@BeforeMethod
	public void prepareMock() {
		drf = new DefaultReportFormatter() {
			public String format(Report report) {
				return "formatted report!!!";
			}
		};
		r = mock(Report.class);
		os = mock(OutputStream.class);
		w = mock(Writer.class);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testFormatAndStore1() {
		drf.formatAndStore(null, (OutputStream)null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testFormatAndStore2() {
		drf.formatAndStore(null, (Writer)null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testFormatAndStore3() {
		drf.formatAndStore(r, (OutputStream)null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testFormatAndStore4() {
		drf.formatAndStore(r, (Writer)null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testFormatAndStore5() {
		drf.formatAndStore(null, os);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testFormatAndStore6() {
		drf.formatAndStore(null, w);
	}

	@Test
	public void testFormatAndStore7() throws Exception {
		drf.formatAndStore(r, os);

		verify(os, atLeastOnce()).flush();
	}

	@Test
	public void testFormatAndStore8() throws Exception {
		drf.formatAndStore(r, w);

		verify(w, atLeastOnce()).flush();
	}
}
