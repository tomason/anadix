package org.anadix.section508.report;

import org.anadix.ItemStatus;

public class DocumentSkipNavigation extends Section508ReportItem {
	private static final String KEY = "document.skip.navigation";

	public DocumentSkipNavigation() {
		super(ItemStatus.MANUAL, KEY);

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
