package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.TdTag;

public class CellMissingAssociation extends Section508ReportItem {
	private static final String KEY = "cell.missing.association";

	public CellMissingAssociation(TdTag cause) {
		super(ItemStatus.ERROR, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
