package org.analyzer.impl;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.analyzer.ItemStatus;
import org.analyzer.ReportItem;
import org.analyzer.Source;
import org.drools.runtime.ObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportImplTest {
	private StatefulKnowledgeSession ksession;
	private Source source;

	@BeforeMethod(alwaysRun = true)
	public void prepareMocks() {
		ksession = mock(StatefulKnowledgeSession.class);
		source = mock(Source.class);
	}

	@Test(groups = "constructor", expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new ReportImpl(null, null);
	}

	@Test(groups = "constructor", expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new ReportImpl(ksession, null);
	}

	@Test(groups = "constructor", expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new ReportImpl(null, source);
	}

	@Test(groups = "constructor")
	public void testConstructor4() {
		new ReportImpl(ksession, source);
	}

	/* TODO find a way to set another value to ItemStatus
	@Test(groups = "constructor", expectedExceptions = RuntimeException.class)
	public void testConstructor5() {
		ReportItem ri1 = mock(ReportItem.class);
		ItemStatus is = ItemStatus.valueOf("something");
		when(ri1.getStatus()).thenReturn(is);

		new ReportImpl(ksession, source);
	}
	 */

	@Test(dependsOnGroups = "constructor")
	public void testGetSource() {
		ReportImpl ri = new ReportImpl(ksession, source);

		assertEquals(ri.getSource(), source);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetOks() {
		ReportItem ri1 = mock(ReportItem.class);
		when(ri1.getStatus()).thenReturn(ItemStatus.OK);
		ReportItem ri2 = mock(ReportItem.class);
		when(ri2.getStatus()).thenReturn(ItemStatus.OK);
		ReportItem ri3 = mock(ReportItem.class);
		when(ri3.getStatus()).thenReturn(ItemStatus.OK);

		when(ksession.getObjects(any(ObjectFilter.class))).thenReturn(
				Arrays.asList((Object)ri1, ri2, ri3 ));

		ReportImpl ri = new ReportImpl(ksession, source);

		List<ReportItem> list = ri.getOks();

		assertNotNull(list);
		assertTrue(list.contains(ri1));
		assertTrue(list.contains(ri2));
		assertTrue(list.contains(ri3));
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetWarnings() {
		ReportItem ri1 = mock(ReportItem.class);
		when(ri1.getStatus()).thenReturn(ItemStatus.WARNING);
		ReportItem ri2 = mock(ReportItem.class);
		when(ri2.getStatus()).thenReturn(ItemStatus.WARNING);
		ReportItem ri3 = mock(ReportItem.class);
		when(ri3.getStatus()).thenReturn(ItemStatus.WARNING);

		when(ksession.getObjects(any(ObjectFilter.class))).thenReturn(
				Arrays.asList((Object)ri1, ri2, ri3 ));

		ReportImpl ri = new ReportImpl(ksession, source);

		List<ReportItem> list = ri.getWarnings();

		assertNotNull(list);
		assertTrue(list.contains(ri1));
		assertTrue(list.contains(ri2));
		assertTrue(list.contains(ri3));
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetErrors() {
		ReportItem ri1 = mock(ReportItem.class);
		when(ri1.getStatus()).thenReturn(ItemStatus.ERROR);
		ReportItem ri2 = mock(ReportItem.class);
		when(ri2.getStatus()).thenReturn(ItemStatus.ERROR);
		ReportItem ri3 = mock(ReportItem.class);
		when(ri3.getStatus()).thenReturn(ItemStatus.ERROR);

		when(ksession.getObjects(any(ObjectFilter.class))).thenReturn(
				Arrays.asList((Object)ri1, ri2, ri3 ));

		ReportImpl ri = new ReportImpl(ksession, source);

		List<ReportItem> list = ri.getErrors();

		assertNotNull(list);
		assertTrue(list.contains(ri1));
		assertTrue(list.contains(ri2));
		assertTrue(list.contains(ri3));
	}

	@Test
	public void testReport() {
		ReportImpl ri = new ReportImpl(ksession, source);

		String report = ri.report();

		assertNotNull(report);
		assertTrue(report.length() > 0);
	}

	@Test
	public void testToString() {
		ReportImpl ri = new ReportImpl(ksession, source);
		String report = ri.toString();

		assertNotNull(report);
		assertTrue(report.length() > 0);
	}
}
