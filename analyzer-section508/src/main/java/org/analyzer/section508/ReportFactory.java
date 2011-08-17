package org.analyzer.section508;

import java.util.ResourceBundle;

import org.analyzer.ItemStatus;
import org.analyzer.ReportItem;
import org.analyzer.html.FrameTag;
import org.analyzer.html.HtmlElement;
import org.analyzer.html.ImgTag;
import org.analyzer.impl.AbstractReportItem;

public class ReportFactory {
	private static final ResourceBundle i18n = ResourceBundle.getBundle("org.analyzer.section508.reports");

	private static ReportItem newReportItem(ItemStatus status, String key, HtmlElement cause) {
		return new AbstractReportItem(status, String.format(i18n.getString(key), cause.getSource(), cause.getPosition())) {};
	}

	public static ReportItem newAltMissingReport(ImgTag cause) {
		return newReportItem(ItemStatus.ERROR, "img.alt.missing", cause);
	}

	public static ReportItem newAltEmptyReport(ImgTag cause) {
		return newReportItem(ItemStatus.WARNING, "img.alt.empty", cause);
	}

	public static ReportItem newTitleMissing(FrameTag cause) {
		return newReportItem(ItemStatus.ERROR, "frame.title.missing", cause);
	}
}
