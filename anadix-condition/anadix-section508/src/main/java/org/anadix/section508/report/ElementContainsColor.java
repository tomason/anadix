package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.HtmlElement;

public class ElementContainsColor extends Section508ReportItem {
	public static final String KEY = "element.contains.color";

	public ElementContainsColor(HtmlElement cause) {
		super(ItemStatus.MANUAL, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
