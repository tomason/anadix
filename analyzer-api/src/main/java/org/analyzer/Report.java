package org.analyzer;

import java.util.List;

public interface Report {

	List<ReportItem> getOks();

	List<ReportItem> getWarnings();

	List<ReportItem> getErrors();

	String report();
}
