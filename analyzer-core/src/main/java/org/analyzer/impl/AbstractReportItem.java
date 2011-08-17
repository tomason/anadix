package org.analyzer.impl;

import org.analyzer.ItemStatus;
import org.analyzer.ReportItem;

public abstract class AbstractReportItem implements ReportItem {
	private final ItemStatus status;
	private final String itemText;
	private String description;
	private String advice;

	public AbstractReportItem(ItemStatus status, String itemText) {
		this.status = status;
		this.itemText = itemText;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public String getItemText() {
		return itemText;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getAdvice() {
		return advice;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return getStatus() + " - " + getItemText();
	}
}
