package org.analyzer.impl;

import static org.testng.Assert.*;

import org.analyzer.ItemStatus;
import org.analyzer.ReportItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AbstractReportItemTest {

	@Test(groups = "constructor", expectedExceptions = { NullPointerException.class })
	public void testConstructor1() {
		new MockReportItem(null, null);
	}

	@Test(groups = "constructor", expectedExceptions = { NullPointerException.class })
	public void testConstructor2() {
		new MockReportItem(ItemStatus.OK, null);
	}

	@Test(groups = "constructor", expectedExceptions = { NullPointerException.class })
	public void testConstructor3() {
		new MockReportItem(null, "itemText");
	}

	@Test(groups = "constructor")
	public void testConstructor4() {
		String itemText = "";
		new MockReportItem(ItemStatus.ERROR, itemText);
		new MockReportItem(ItemStatus.OK, itemText);
		new MockReportItem(ItemStatus.WARNING, itemText);
	}

	private ReportItem ri;
	private final String itemText = "item text";
	private final ItemStatus status = ItemStatus.OK;

	@BeforeMethod(dependsOnGroups = "constructor")
	public void prepareInstance() {
		ri = new MockReportItem(status, itemText);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetStatus() {
		assertEquals(ri.getStatus(), status);
	}

	@Test(dependsOnGroups = "constructor")
	public void testGetItemText() {
		assertEquals(ri.getItemText(), itemText);
	}

	@Test(dependsOnGroups = "constructor")
	public void testAdvice() {
		assertNull(ri.getAdvice());

		String advice = "text with some advice";

		ri.setAdvice(advice);
		assertEquals(ri.getAdvice(), advice);

		ri.setAdvice(null);
		assertNull(ri.getAdvice());
	}

	@Test(dependsOnGroups = "constructor")
	public void testDescription() {
		assertNull(ri.getDescription());

		String description = "text of description";

		ri.setDescription(description);
		assertEquals(ri.getDescription(), description);

		ri.setDescription(null);
		assertNull(ri.getDescription());
	}

	@Test(dependsOnGroups = "constructor")
	public void testToString() {
		assertEquals(ri.toString(), status + " - " + itemText);
	}

	private static class MockReportItem extends AbstractReportItem {
		public MockReportItem(ItemStatus status, String itemText) {
			super(status, itemText);
		}
	}
}
