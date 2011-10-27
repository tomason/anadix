package org.anadix.section508.rules;

import java.util.Collection;
import java.util.Properties;

import org.anadix.ReportItem;
import org.anadix.html.HtmlElement;
import org.anadix.section508.report.CellMissingAssociation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class ParagraphHTest extends RulesetTest {
	private HtmlElement table1;
	private HtmlElement row11;
	private HtmlElement cell111;
	private HtmlElement cell112;

	private HtmlElement table2;
	private HtmlElement row21;
	private HtmlElement cell211;
	private HtmlElement cell212;

	private static final String cell111Source = "<cel111 source>";
	private static final String cell112Source = "<cell112 source>";
	private static final String cell211Source = "<cell211 source>";
	private static final String cell212Source = "<cell212 source>";

	public ParagraphHTest() {
		super("paragraph-h.drl");
	}

	@BeforeMethod(alwaysRun = true)
	public void prepareVariables() {
		table1 = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table1.setSource(dummySource);
		row11 = factory.createTrTag(getUniqueId(), table1, dummyAttributes);
		row11.setSource(dummySource);
		cell111 = factory.createTdTag(getUniqueId(), row11, dummyAttributes);
		cell111.setSource(cell111Source);
		cell112 = factory.createTdTag(getUniqueId(), row11, dummyAttributes);
		cell112.setSource(cell112Source);
		cell112.setTextContent("some text content:");

		table2 = factory.createTableTag(getUniqueId(), cell112, dummyAttributes);
		table2.setSource(dummySource);
		row21 = factory.createTrTag(getUniqueId(), table2, dummyAttributes);
		row21.setSource(dummySource);
		cell211 = factory.createTdTag(getUniqueId(), row21, dummyAttributes);
		cell211.setTextContent("data:");
		cell211.setSource(cell211Source);
		cell212 = factory.createTdTag(getUniqueId(), row21, dummyAttributes);
		cell212.setSource(cell212Source);
	}

	public void testRule2_1() {
		Collection<ReportItem> result = evaluate(table1, row11, cell111, cell112,
				table2, row21, cell211, cell212);

		assertReportContains(result, CellMissingAssociation.class, cell111Source);
		assertReportContains(result, CellMissingAssociation.class, cell112Source);
		assertReportContains(result, CellMissingAssociation.class, cell211Source);
		assertReportContains(result, CellMissingAssociation.class, cell212Source);
	}

	public void testRule2_2() {
		Properties attributes = new Properties();
		attributes.setProperty("axis", "dummy");

		cell111 = factory.createTdTag(getUniqueId(), row11, attributes);
		cell111.setSource(cell111Source);

		Collection<ReportItem> result = evaluate(table1, row11, cell111, cell112,
				table2, row21, cell211, cell212);

		assertReportNotContains(result, CellMissingAssociation.class, cell111Source);
		assertReportContains(result, CellMissingAssociation.class, cell112Source);
		assertReportContains(result, CellMissingAssociation.class, cell211Source);
		assertReportContains(result, CellMissingAssociation.class, cell212Source);
	}

	public void testRule2_3() {
		Properties attributes = new Properties();
		attributes.setProperty("axis", "dummy");

		cell212 = factory.createTdTag(getUniqueId(), row21, attributes);
		cell212.setSource(cell212Source);

		Collection<ReportItem> result = evaluate(table1, row11, cell111, cell112,
				table2, row21, cell211, cell212);

		assertReportContains(result, CellMissingAssociation.class, cell111Source);
		assertReportContains(result, CellMissingAssociation.class, cell112Source);
		assertReportContains(result, CellMissingAssociation.class, cell211Source);
		assertReportNotContains(result, CellMissingAssociation.class, cell212Source);
	}

	public void testRule2_4() {
		Properties attributes = new Properties();
		attributes.setProperty("headers", "dummy");

		cell111 = factory.createTdTag(getUniqueId(), row11, attributes);
		cell111.setSource(cell111Source);

		Collection<ReportItem> result = evaluate(table1, row11, cell111, cell112,
				table2, row21, cell211, cell212);

		assertReportNotContains(result, CellMissingAssociation.class, cell111Source);
		assertReportContains(result, CellMissingAssociation.class, cell112Source);
		assertReportContains(result, CellMissingAssociation.class, cell211Source);
		assertReportContains(result, CellMissingAssociation.class, cell212Source);
	}

	public void testRule2_5() {
		Properties attributes = new Properties();
		attributes.setProperty("headers", "dummy");

		cell212 = factory.createTdTag(getUniqueId(), row21, attributes);
		cell212.setSource(cell212Source);

		Collection<ReportItem> result = evaluate(table1, row11, cell111, cell112,
				table2, row21, cell211, cell212);

		assertReportContains(result, CellMissingAssociation.class, cell111Source);
		assertReportContains(result, CellMissingAssociation.class, cell112Source);
		assertReportContains(result, CellMissingAssociation.class, cell211Source);
		assertReportNotContains(result, CellMissingAssociation.class, cell212Source);
	}

	public void testRule2_6() {
		Properties attributes = new Properties();
		attributes.setProperty("headers", "dummy");
		attributes.setProperty("axis", "whatever");

		cell111 = factory.createTdTag(getUniqueId(), row11, attributes);
		cell111.setSource(cell111Source);

		Collection<ReportItem> result = evaluate(table1, row11, cell111, cell112,
				table2, row21, cell211, cell212);

		assertReportNotContains(result, CellMissingAssociation.class, cell111Source);
		assertReportContains(result, CellMissingAssociation.class, cell112Source);
		assertReportContains(result, CellMissingAssociation.class, cell211Source);
		assertReportContains(result, CellMissingAssociation.class, cell212Source);
	}

	public void testRule2_7() {
		Properties attributes = new Properties();
		attributes.setProperty("headers", "dummy");
		attributes.setProperty("axis", "whatever");

		cell212 = factory.createTdTag(getUniqueId(), row21, attributes);
		cell212.setSource(cell212Source);

		Collection<ReportItem> result = evaluate(table1, row11, cell111, cell112,
				table2, row21, cell211, cell212);

		assertReportContains(result, CellMissingAssociation.class, cell111Source);
		assertReportContains(result, CellMissingAssociation.class, cell112Source);
		assertReportContains(result, CellMissingAssociation.class, cell211Source);
		assertReportNotContains(result, CellMissingAssociation.class, cell212Source);
	}

}
