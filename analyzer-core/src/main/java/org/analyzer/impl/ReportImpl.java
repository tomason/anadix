package org.analyzer.impl;

import java.util.ArrayList;
import java.util.List;

import org.analyzer.Report;
import org.analyzer.ReportItem;
import org.drools.runtime.ClassObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;

public class ReportImpl implements Report {
	private final List<ReportItem> errors = new ArrayList<ReportItem>();
	private final List<ReportItem> warnings = new ArrayList<ReportItem>();
	private final List<ReportItem> oks = new ArrayList<ReportItem>();

	public ReportImpl(StatefulKnowledgeSession ksession) {
		for (Object i : ksession.getObjects(new ClassObjectFilter(ReportItem.class))) {
			ReportItem item = (ReportItem)i;
			switch (item.getStatus()) {
			case OK:
				oks.add(item);
				break;
			case WARNING:
				warnings.add(item);
				break;
			case ERROR:
				errors.add(item);
				break;
			}
		}
	}

	public List<ReportItem> getOks() {
		return oks;
	}

	public List<ReportItem> getWarnings() {
		return warnings;
	}

	public List<ReportItem> getErrors() {
		return errors;
	}

	public String report() {
		StringBuilder sb = new StringBuilder();

		sb.append("*******************************************************").append("\n");
		sb.append("*                 Drools report                       *").append("\n");
		sb.append("*******************************************************").append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("ERROR:").append("\n");
		sb.append("-------").append("\n");
		for (ReportItem i : errors) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}
		sb.append("\n");

		sb.append("WARNING:").append("\n");
		sb.append("---------").append("\n");
		for (ReportItem i : warnings) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}

		sb.append("\n");

		sb.append("OK:").append("\n");
		sb.append("---").append("\n");
		for (ReportItem i : oks) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}


		sb.append("\n");
		sb.append("*******************************************************").append("\n");
		sb.append(String.format("* Errors: % 9d | Warnings: % 9d             *",
				errors.size(), warnings.size())).append("\n");
		sb.append("*******************************************************").append("\n");

		return sb.toString();
	}

	@Override
	public String toString() {
		return report();
	}
}
