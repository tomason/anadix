package org.anadix.impl;

import java.io.StringWriter;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.anadix.Report;
import org.anadix.ReportItem;
import org.jboss.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XHTMLReportFormatter extends DefaultReportFormatter {
	private static Logger logger = Logger.getLogger(XHTMLReportFormatter.class);
	
	@Override
	public String getReportFileExtension() {
		return "html";
	}
	
	@Override
	public String format(Report report) {
		String result = "<couldn't generate output>";
		Document doc = null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Node body = createXHTMLHeading(report, doc);
			
			body.appendChild(doc.createElement("h1")).setTextContent("Overal status");
			body.appendChild(createSummaryTable(report, doc));
			
			if (report.getManuals().size() > 0) {
				body.appendChild(doc.createElement("h1")).setTextContent("Manual check required");
				body.appendChild(createResultTable(report.getManuals(), doc));
			}
			
			if (report.getErrors().size() > 0) {
				body.appendChild(doc.createElement("h1")).setTextContent("Errors");
				body.appendChild(createResultTable(report.getErrors(), doc));
			}
			
			if (report.getWarnings().size() > 0) {
				body.appendChild(doc.createElement("h1")).setTextContent("Warnings");
				body.appendChild(createResultTable(report.getWarnings(), doc));
			}
			
			if (report.getOks().size() > 0) {
				body.appendChild(doc.createElement("h1")).setTextContent("Things without error");
				body.appendChild(createResultTable(report.getOks(), doc));
			}
			
			if (report.getInfos().size() > 0) {
				body.appendChild(doc.createElement("h1")).setTextContent("Additional information");
				body.appendChild(createResultTable(report.getInfos(), doc));
			}
		} catch (ParserConfigurationException ex) {
			logger.fatal("Unable to create document", ex);
		}
		
		try {
			StringWriter sw = new StringWriter();
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.transform(new DOMSource(doc), new StreamResult(sw));
			
			result = sw.toString();
		} catch (TransformerConfigurationException ex) {
			logger.fatal("Unable to create transformer", ex);
		} catch (TransformerFactoryConfigurationError ex) {
			logger.fatal("Unable to create transformer", ex);
		} catch (TransformerException ex) {
			logger.fatal("Unable to transform document", ex);
		}
		
		return result;
	}
	
	private static Node createXHTMLHeading(Report report, Document doc) {
		Node html = doc.appendChild(doc.createElement("html"));
		Node head = html.appendChild(doc.createElement("head"));
		Node title = head.appendChild(doc.createElement("title"));
		title.setTextContent(String.format("Anadix report for '%s'", report.getSource().getDescription()));
		Node style = head.appendChild(doc.createElement("style"));
		style.setTextContent(STYLE);

		return html.appendChild(doc.createElement("body"));
	}
	
	private static Node createSummaryTable(Report report, Document doc) {
		String[] headers = new String[] {
				"", "MANUAL", "ERROR", "WARNING", "OK", "Total"
		};
		Object[] values = new Object[] {
				"Report items",
				report.getManuals().size(),
				report.getErrors().size(),
				report.getWarnings().size(),
				report.getOks().size(),
				
				report.getOks().size() + report.getManuals().size() +
				report.getWarnings().size() + report.getErrors().size() +
				report.getInfos().size()
		};
		String[] classes = new String[] {
			null, "manual", "error", "warning", "ok", "info"	
		};
		
		Element summaryTable = doc.createElement("table");
		Element colgroup = doc.createElement("colgroup");
		colgroup.setAttribute("span", "6");
		colgroup.setAttribute("style", "width: 16%;");
		summaryTable.appendChild(colgroup);
		Node headersRow = summaryTable.appendChild(doc.createElement("tr"));
		Node valuesRow = summaryTable.appendChild(doc.createElement("tr"));
		
		for (String header : headers) {
			headersRow.appendChild(
					doc.createElement("th")
			).setTextContent(header);
		}
		
		Element td;
		for (int i = 0; i < values.length; i++) {
			td = doc.createElement("td");
			td.setAttribute("class", classes[i]);
			td.setTextContent(values[i].toString());
			
			valuesRow.appendChild(td);
		}
		
		return summaryTable;
	}
	
	private static Node createResultTable(Collection<ReportItem> items, Document doc) {
		Element resultTable = doc.createElement("table");
		resultTable.setAttribute("style", "border-collapse: separate; border-spacin: 5px 20px;");
		
		for (ReportItem item : items) {
			resultTable.appendChild(createResultRow(item, doc));
		}
		
		return resultTable;
	}
	
	private static Node createResultRow(ReportItem item, Document doc) {
		Element resultRow = doc.createElement("tr");
		Node resultTable = resultRow.appendChild(doc.createElement("td"))
				.appendChild(doc.createElement("table"));
		
		Element header = doc.createElement("th");
		header.setAttribute("colspan", "2");
		header.setAttribute("class", item.getStatus().toString().toLowerCase());
		header.setTextContent(item.getItemText());
		resultTable.appendChild(doc.createElement("tr")).appendChild(header);
		
		Node row1 = resultTable.appendChild(doc.createElement("tr"));
		row1.appendChild(doc.createElement("th")).setTextContent("Description");
		row1.appendChild(doc.createElement("td")).setTextContent(item.getDescription());
		
		Node row2 = resultTable.appendChild(doc.createElement("tr"));
		row2.appendChild(doc.createElement("th")).setTextContent("Advice");
		row2.appendChild(doc.createElement("td")).setTextContent(item.getAdvice());
		
		return resultRow;
	}
	
	private static final String STYLE =
			"table {\n" +
			"    border: 1px solid black;\n" +
			"    border-collapse: collapse;\n" +
			"    width: 100%;" +
			"}\n" +
			"th, td {\n" +
			"    border: 1px solid black;\n" +
			"}\n" +
			".error {\n" +
			"    background-color: red;\n" +
			"}\n" +
			".warning {\n" +
			"    background-color: yellow;\n" +
			"}\n" +
			".ok {\n" +
			"    background-color: green;\n" +
			"}\n";
}
