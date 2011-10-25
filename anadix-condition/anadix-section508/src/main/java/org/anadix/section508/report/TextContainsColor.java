package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.HtmlElement;

public class TextContainsColor extends Section508ReportItem {
	private static final String KEY = "text.contains.color";

	public TextContainsColor(HtmlElement cause, String color) {
		super(ItemStatus.MANUAL, KEY, cause.getSource(), cause.getPosition(), color);

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
