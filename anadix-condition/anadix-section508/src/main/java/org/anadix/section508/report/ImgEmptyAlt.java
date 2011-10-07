package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.ImgTag;

public class ImgEmptyAlt extends Section508ReportItem {
	private static final String KEY = "img.empty.alt";

	public ImgEmptyAlt(ImgTag cause) {
		super(ItemStatus.MANUAL, KEY, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(KEY));
		setAdvice(formatAdviceString(KEY));
	}

}
