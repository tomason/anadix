package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.AppletTag;
import org.anadix.html.HtmlElement;
import org.anadix.html.ImgTag;
import org.anadix.html.ObjectTag;

public class ElementCauseFlickering extends Section508ReportItem {
	private static final String KEY_SUFFIX = ".cause.flickering";

	public ElementCauseFlickering() {
		this(ItemStatus.MANUAL, "document" + KEY_SUFFIX, null);
	}

	public ElementCauseFlickering(ObjectTag cause) {
		this(ItemStatus.MANUAL, "object" + KEY_SUFFIX, cause);
	}

	public ElementCauseFlickering(AppletTag cause) {
		this(ItemStatus.MANUAL, "applet" + KEY_SUFFIX, cause);
	}

	public ElementCauseFlickering(ImgTag cause) {
		this(ItemStatus.MANUAL, "img" + KEY_SUFFIX, cause);
	}

	public ElementCauseFlickering(ItemStatus status, String key, HtmlElement cause) {
		super(status, key,
				cause == null ? new Object[0] : new Object[] { cause.getSource(), cause.getPosition() }
				);

		setDescription(formatDescriptionString(key));
		setAdvice(formatAdviceString(key));
	}
}
