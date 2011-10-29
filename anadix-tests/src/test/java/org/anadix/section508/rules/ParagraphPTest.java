package org.anadix.section508.rules;

import java.util.Collection;

import org.anadix.ReportItem;
import org.anadix.section508.report.DocumentRequiresTime;
import org.testng.annotations.Test;

@Test
public class ParagraphPTest extends RulesetTest {
	public ParagraphPTest() {
		super("paragraph-p.drl");
	}

	public void testRule1_1() {
		Collection<ReportItem> report = evaluate();

		assertReportContains(report, DocumentRequiresTime.class);
	}
}
