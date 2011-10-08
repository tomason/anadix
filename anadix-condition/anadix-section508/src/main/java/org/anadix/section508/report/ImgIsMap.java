package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.ImgTag;

public class ImgIsMap extends Section508ReportItem {
	private static final String KEY_MANUAL = "img.has.textlinks";
	private static final String KEY_WARNING = "img.is.map";

	public ImgIsMap(ImgTag cause) {
		this(cause, false);
	}

	public ImgIsMap(ImgTag cause, boolean warning) {
		super((warning ? ItemStatus.WARNING : ItemStatus.MANUAL),
				(warning ? KEY_WARNING : KEY_MANUAL),
				cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(warning ? KEY_WARNING : KEY_MANUAL));
		setAdvice(formatAdviceString(warning ? KEY_WARNING : KEY_MANUAL));
	}
}
