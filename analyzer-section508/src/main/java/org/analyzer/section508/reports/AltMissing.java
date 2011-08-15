package org.analyzer.section508.reports;

import org.analyzer.ItemStatus;
import org.analyzer.ReportItem;
import org.analyzer.html.ImgTag;

public class AltMissing extends ReportItem {
	private static final String FORMAT =
			"Tag <IMG> starting on %s is missing an alt attribute!";

	public AltMissing(ImgTag cause) {
		super(ItemStatus.ERROR, createReport(cause));
	}

	private static String createReport(ImgTag cause) {
		return String.format(FORMAT, cause.getPosition());
	}
}
