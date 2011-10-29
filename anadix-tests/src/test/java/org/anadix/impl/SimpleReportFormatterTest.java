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
import static org.testng.Assert.*;

import java.util.Arrays;

import org.anadix.ItemStatus;
import org.anadix.Report;
import org.anadix.ReportItem;
import org.anadix.Source;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class SimpleReportFormatterTest {
	private Report r;
	private SimpleReportFormatter srf;

	@BeforeClass
	public void prepareMock() {
		r = mock(Report.class);
		srf = new SimpleReportFormatter();

		when(r.getSource()).thenReturn(mock(Source.class));
	}

	@Test
	public void testFormat1() {
		ReportItem ri = mock(ReportItem.class);
		String itemText = "this is OK";
		when(ri.getStatus()).thenReturn(ItemStatus.OK);
		when(ri.getItemText()).thenReturn(itemText);

		when(r.getOks()).thenReturn(Arrays.asList(ri));

		String report = srf.format(r);
		assertNotNull(report);
		assertTrue(report.length() > 0);
		assertTrue(report.contains(itemText));
	}

	@Test
	public void testFormat2() {
		ReportItem ri = mock(ReportItem.class);
		String itemText = "this is WARNING";
		when(ri.getStatus()).thenReturn(ItemStatus.WARNING);
		when(ri.getItemText()).thenReturn(itemText);

		when(r.getWarnings()).thenReturn(Arrays.asList(ri));

		String report = srf.format(r);
		assertNotNull(report);
		assertTrue(report.length() > 0);
		assertTrue(report.contains(itemText));
	}

	@Test
	public void testFormat3() {
		ReportItem ri = mock(ReportItem.class);
		String itemText = "this is ERROR";
		when(ri.getStatus()).thenReturn(ItemStatus.ERROR);
		when(ri.getItemText()).thenReturn(itemText);

		when(r.getErrors()).thenReturn(Arrays.asList(ri));

		String report = srf.format(r);
		assertNotNull(report);
		assertTrue(report.length() > 0);
		assertTrue(report.contains(itemText));
	}
}
