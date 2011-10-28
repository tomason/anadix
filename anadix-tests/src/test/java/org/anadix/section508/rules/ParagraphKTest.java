package org.anadix.section508.rules;

import java.util.Collection;

import org.anadix.ItemStatus;
import org.anadix.ReportItem;
import org.anadix.impl.AbstractReportItem;
import org.anadix.section508.report.DocumentHasErrors;
import org.testng.annotations.Test;

@Test
public class ParagraphKTest extends RulesetTest {
	public ParagraphKTest() {
		super("paragraph-k.drl");
	}

	public void testRule1_1() {
		ReportItem item = new AbstractReportItem(ItemStatus.ERROR, "") {};

		Collection<ReportItem> result = evaluate(item);

		assertReportContains(result, DocumentHasErrors.class);
	}

	public void testRule1_2() {
		ReportItem item = new AbstractReportItem(ItemStatus.WARNING, "") {};

		Collection<ReportItem> result = evaluate(item);

		assertReportNotContains(result, DocumentHasErrors.class);
	}

	public void testRule1_3() {
		ReportItem item = new AbstractReportItem(ItemStatus.MANUAL, "") {};

		Collection<ReportItem> result = evaluate(item);

		assertReportNotContains(result, DocumentHasErrors.class);
	}

	public void testRule1_4() {
		ReportItem item = new AbstractReportItem(ItemStatus.INFO, "") {};

		Collection<ReportItem> result = evaluate(item);

		assertReportNotContains(result, DocumentHasErrors.class);
	}

	public void testRule1_5() {
		ReportItem item = new AbstractReportItem(ItemStatus.OK, "") {};

		Collection<ReportItem> result = evaluate(item);

		assertReportNotContains(result, DocumentHasErrors.class);
	}

}
