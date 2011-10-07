package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.FrameTag;
import org.anadix.html.FramesetTag;
import org.anadix.html.HtmlElement;
import org.anadix.html.IframeTag;

public class FrameMissingTitle extends Section508ReportItem {
	private static final String KEY = "frame.missing.title";

	public FrameMissingTitle(FrameTag cause) {
		this((HtmlElement)cause);

		setDescription(formatDescriptionString(KEY, "Frame"));
	}

	public FrameMissingTitle(IframeTag cause) {
		this((HtmlElement)cause);

		setDescription(formatDescriptionString(KEY, "Inline frame (<iframe>)"));
	}

	public FrameMissingTitle(FramesetTag cause) {
		this((HtmlElement)cause);

		setDescription(formatDescriptionString(KEY, "Frameset"));
	}

	private FrameMissingTitle(HtmlElement cause) {
		super(ItemStatus.ERROR, KEY, cause.getSource(), cause.getPosition());

		setAdvice(formatAdviceString(KEY));
	}

}
