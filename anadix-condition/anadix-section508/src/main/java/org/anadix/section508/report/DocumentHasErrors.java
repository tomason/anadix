package org.anadix.section508.report;

import org.anadix.ItemStatus;

public class DocumentHasErrors extends Section508ReportItem {
	public static final String KEY = "document.has.error";

	public DocumentHasErrors() {
		super(ItemStatus.INFO, KEY);

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
