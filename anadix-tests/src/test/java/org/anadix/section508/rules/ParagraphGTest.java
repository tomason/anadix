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
package org.anadix.section508.rules;

import java.util.Collection;

import org.anadix.ReportItem;
import org.anadix.html.HtmlElement;
import org.anadix.section508.report.ColumnMissingHeader;
import org.anadix.section508.report.RowMissingHeader;
import org.testng.annotations.Test;

@Test
public class ParagraphGTest extends RulesetTest {
	private static final String tableSource = "<data table>";
	private static final String rowSource = "<row in data table>";
	private static final String cellText = "some text to make a data table";

	public ParagraphGTest() {
		super("paragraph-g.drl");
	}

	public void testRule2_1() {
		HtmlElement table = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table.setSource(dummySource);
		HtmlElement row = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row.setSource(rowSource);
		HtmlElement cell = factory.createTdTag(getUniqueId(), row, dummyAttributes);
		cell.setSource(dummySource);
		cell.setTextContent(cellText);

		Collection<ReportItem> result = evaluate(table, row, cell);

		assertReportContains(result, RowMissingHeader.class, row.getSource());
	}

	public void testRule2_2() {
		HtmlElement table = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table.setSource(dummySource);
		HtmlElement row = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row.setSource(rowSource);
		HtmlElement cell = factory.createTdTag(getUniqueId(), row, dummyAttributes);
		cell.setSource(dummySource);

		Collection<ReportItem> result = evaluate(table, row, cell);

		assertReportNotContains(result, RowMissingHeader.class, row.getSource());
	}

	public void testRule2_3() {
		HtmlElement table = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table.setSource(dummySource);
		HtmlElement row = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row.setSource(rowSource);
		HtmlElement header = factory.createThTag(getUniqueId(), row, dummyAttributes);
		header.setSource(dummySource);
		HtmlElement cell = factory.createTdTag(getUniqueId(), row, dummyAttributes);
		cell.setSource(dummySource);
		cell.setTextContent(cellText);

		Collection<ReportItem> result = evaluate(table, row, header, cell);

		assertReportNotContains(result, RowMissingHeader.class, row.getSource());
	}

	public void testRule2_4() {
		HtmlElement table = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table.setSource(dummySource);
		HtmlElement row = factory.createTrTag(getUniqueId(), body, dummyAttributes);
		row.setSource(rowSource);
		HtmlElement cell = factory.createTdTag(getUniqueId(), row, dummyAttributes);
		cell.setSource(dummySource);
		cell.setTextContent(cellText);

		Collection<ReportItem> result = evaluate(table, row, cell);

		assertReportNotContains(result, RowMissingHeader.class, row.getSource());
	}

	public void testRule9_1() {
		HtmlElement table = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table.setSource(tableSource);

		HtmlElement row1 = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row1.setSource(dummySource);
		HtmlElement cell11 = factory.createThTag(getUniqueId(), row1, dummyAttributes);
		cell11.setSource(dummySource);
		HtmlElement cell12 = factory.createThTag(getUniqueId(), row1, dummyAttributes);
		cell12.setSource(dummySource);

		HtmlElement row2 = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row2.setSource("source source");
		HtmlElement cell21 = factory.createThTag(getUniqueId(), row2, dummyAttributes);
		cell21.setSource(dummySource);
		HtmlElement cell22 = factory.createTdTag(getUniqueId(), row2, dummyAttributes);
		cell22.setSource(dummySource);
		cell22.setTextContent(cellText);
		HtmlElement cell23 = factory.createTdTag(getUniqueId(), row2, dummyAttributes);
		cell23.setSource(dummySource);

		Collection<ReportItem> result = evaluate(table, row1, row2, cell11, cell12, cell21, cell22, cell23);

		assertReportContains(result, ColumnMissingHeader.class, table.getSource());
	}

	public void testRule9_2() {
		System.out.println("rule9_2");
		// <table>
		HtmlElement table = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table.setSource(tableSource);

		//     <tr>
		HtmlElement row1 = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row1.setSource(dummySource);
		//         <th>
		HtmlElement cell11 = factory.createThTag(getUniqueId(), row1, dummyAttributes);
		cell11.setSource(dummySource);
		//         </th>
		//         <th>
		HtmlElement cell12 = factory.createThTag(getUniqueId(), row1, dummyAttributes);
		cell12.setSource(dummySource);
		//         </th>
		//     </tr>
		//     <tr>
		HtmlElement row2 = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row2.setSource(dummySource);
		//         <th>
		HtmlElement cell21 = factory.createThTag(getUniqueId(), row2, dummyAttributes);
		cell21.setSource(dummySource);
		//         </th>
		//         <td>
		HtmlElement cell22 = factory.createTdTag(getUniqueId(), row2, dummyAttributes);
		cell22.setSource(dummySource);
		cell22.setTextContent(cellText);
		//         </td>
		//     <tr>
		// </table>
		Collection<ReportItem> result = evaluate(table, row1, cell11, cell12, row2, cell21, cell22);

		assertReportNotContains(result, ColumnMissingHeader.class, table.getSource());
	}

	public void testRule9_3() {
		HtmlElement table = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table.setSource(tableSource);

		HtmlElement row1 = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row1.setSource(dummySource);
		HtmlElement cell11 = factory.createThTag(getUniqueId(), row1, dummyAttributes);
		cell11.setSource(dummySource);
		HtmlElement cell12 = factory.createThTag(getUniqueId(), row1, dummyAttributes);
		cell12.setSource(dummySource);

		HtmlElement row2 = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row2.setSource(dummySource);
		HtmlElement cell21 = factory.createThTag(getUniqueId(), row2, dummyAttributes);
		cell21.setSource(dummySource);
		cell21.setTextContent(cellText);

		Collection<ReportItem> result = evaluate(table, row1, row2, cell11, cell12, cell21);

		assertReportNotContains(result, ColumnMissingHeader.class, table.getSource());
	}

	public void testRule9_4() {
		HtmlElement table = factory.createTableTag(getUniqueId(), body, dummyAttributes);
		table.setSource(tableSource);

		HtmlElement row1 = factory.createTrTag(getUniqueId(), table, dummyAttributes);
		row1.setSource(dummySource);
		HtmlElement cell11 = factory.createThTag(getUniqueId(), row1, dummyAttributes);
		cell11.setSource(dummySource);
		HtmlElement cell12 = factory.createThTag(getUniqueId(), row1, dummyAttributes);
		cell12.setSource(dummySource);
		cell12.setTextContent(cellText);

		Collection<ReportItem> result = evaluate(table, row1, cell11, cell12);

		assertReportNotContains(result, ColumnMissingHeader.class, table.getSource());
	}
}
