package org.analyzer;

public abstract class ReportItem {
	private final ItemStatus status;
	//private String shortText;
	private String description;
	private String advice;
	private final String itemText;

	public ReportItem(ItemStatus status, String itemText) {
		this.status = status;
		this.itemText = itemText;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public String getItemText() {
		return itemText;
	}

	public String getAdvice() {
		return advice;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return getStatus() + " - " + getItemText();
	}
}
