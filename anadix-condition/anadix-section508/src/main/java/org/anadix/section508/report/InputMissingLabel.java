package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.InputTag;

public class InputMissingLabel extends Section508ReportItem {
	private static final String KEY = "input.missing.label";

	public InputMissingLabel(InputTag cause) {
		super(ItemStatus.ERROR, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}
}
