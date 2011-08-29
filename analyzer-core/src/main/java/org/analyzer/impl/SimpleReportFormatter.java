package org.analyzer.impl;

import org.analyzer.Report;
import org.analyzer.ReportItem;

public class SimpleReportFormatter extends DefaultReportFormatter {

	public String format(Report report) {
		StringBuilder sb = new StringBuilder();

		sb.append("*******************************************************").append("\n");
		sb.append("*                 Drools report                       *").append("\n");
		sb.append("*******************************************************").append("\n");
		sb.append(report.getSource().getDescription()).append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("ERROR:").append("\n");
		sb.append("-------").append("\n");
		for (ReportItem i : report.getErrors()) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}
		sb.append("\n");

		sb.append("WARNING:").append("\n");
		sb.append("---------").append("\n");
		for (ReportItem i : report.getWarnings()) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}

		sb.append("\n");

		sb.append("OK:").append("\n");
		sb.append("---").append("\n");
		for (ReportItem i : report.getOks()) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}


		sb.append("\n");
		sb.append("*******************************************************").append("\n");
		sb.append(String.format("* Errors: % 9d | Warnings: % 9d             *",
				report.getErrors().size(), report.getWarnings().size())).append("\n");
		sb.append("*******************************************************").append("\n");

		return sb.toString();
	}

}
