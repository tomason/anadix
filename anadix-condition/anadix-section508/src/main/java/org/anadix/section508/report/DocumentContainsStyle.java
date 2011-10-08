package org.anadix.section508.report;

import org.anadix.ItemStatus;

public class DocumentContainsStyle extends Section508ReportItem {
	public static final String KEY = "document.contains.style";

	public DocumentContainsStyle() {
		super(ItemStatus.MANUAL, KEY);

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}

}
