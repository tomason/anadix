package org.anadix.section508.report;

import org.anadix.ItemStatus;

public class DocumentRequiresTime extends Section508ReportItem {
	private static final String KEY = "document.requires.time";

	public DocumentRequiresTime() {
		super(ItemStatus.MANUAL, KEY);

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}

}
