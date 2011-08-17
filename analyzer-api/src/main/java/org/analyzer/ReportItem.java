package org.analyzer;

public interface ReportItem {
	ItemStatus getStatus();

	String getItemText();

	void setAdvice(String advice);

	String getAdvice();

	void setDescription(String description);

	String getDescription();
}
