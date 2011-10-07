package org.anadix.section508.report;

import org.anadix.ItemStatus;

public class DocumentMissingNoscript extends Section508ReportItem {
	public static final String KEY = "document.missing.noscript";

	public DocumentMissingNoscript() {
		super(ItemStatus.ERROR, KEY);

		setAdvice(formatAdviceString(KEY));
		setDescription(formatDescriptionString(KEY));
	}
}
