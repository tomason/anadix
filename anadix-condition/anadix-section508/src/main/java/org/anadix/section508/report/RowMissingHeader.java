package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.TrTag;

public class RowMissingHeader extends Section508ReportItem {
	private static final String KEY = "row.missing.header";

	public RowMissingHeader(TrTag row) {
		super(ItemStatus.ERROR, KEY, row.getSource());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
