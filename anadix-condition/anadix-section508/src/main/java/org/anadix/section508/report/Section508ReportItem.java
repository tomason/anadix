package org.anadix.section508.report;

import java.util.ResourceBundle;

import org.anadix.ItemStatus;
import org.anadix.impl.AbstractReportItem;

public abstract class Section508ReportItem extends AbstractReportItem {
	private static final ResourceBundle itemStatuses = ResourceBundle.getBundle("org.anadix.section508.reports.ItemText");
	private static final ResourceBundle descriptions = ResourceBundle.getBundle("org.anadix.section508.reports.Description");
	private static final ResourceBundle advices = ResourceBundle.getBundle("org.anadix.section508.reports.Advice");

	public Section508ReportItem(ItemStatus status, String key, Object... args) {
		super(status, formatFromBundle(itemStatuses, key, args));
	}

	protected static String formatAdviceString(String key, Object... args) {
		return formatFromBundle(advices, key, args);
	}

	protected static String formatDescriptionString(String key, Object... args) {
		return formatFromBundle(descriptions, key, args);
	}

	private static String formatFromBundle(ResourceBundle bundle, String key, Object... args) {
		if (!bundle.containsKey(key)) {
			throw new IllegalArgumentException("Key " + key + " doesn't exist!");
		}

		String text = bundle.getString(key);
		if (args.length > 0) {
			text = String.format(text, args);
		}

		return text;
	}
}
