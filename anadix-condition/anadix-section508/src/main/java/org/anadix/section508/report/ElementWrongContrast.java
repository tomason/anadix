package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.HtmlElement;

public class ElementWrongContrast extends Section508ReportItem {
	public static final String KEY = "element.wrong.contrast";

	public ElementWrongContrast(HtmlElement cause) {
		super(ItemStatus.ERROR, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
