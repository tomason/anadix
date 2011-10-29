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
package org.anadix.impl;

import static org.mockito.Mockito.*;

import java.io.OutputStream;
import java.io.Writer;

import org.anadix.Report;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
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
