package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.HtmlElement;

public class ObjectCompliesConditions extends Section508ReportItem {
	private static final String KEY = "object.complies.conditions";

	public ObjectCompliesConditions(HtmlElement cause) {
		super(ItemStatus.MANUAL, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}

}
