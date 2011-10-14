package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.TableTag;

public class ColumnMissingHeader extends Section508ReportItem {
	private static final String KEY = "column.missing.header";

	public ColumnMissingHeader(TableTag cause) {
		super(ItemStatus.ERROR, KEY, cause.getSource(), cause.getPosition());
	}
}
