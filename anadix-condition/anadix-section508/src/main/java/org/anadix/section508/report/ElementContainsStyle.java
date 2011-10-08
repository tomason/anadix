package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.CoreAttributes;

public class ElementContainsStyle extends Section508ReportItem {
	public static final String KEY = "element.contains.style";

	public ElementContainsStyle(CoreAttributes cause) {
		super(ItemStatus.WARNING, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}

}
