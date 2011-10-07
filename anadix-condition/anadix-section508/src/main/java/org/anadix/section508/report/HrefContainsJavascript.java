package org.anadix.section508.report;

import org.anadix.ItemStatus;
import org.anadix.html.ATag;
import org.anadix.html.AreaTag;
import org.anadix.html.HtmlElement;

public class HrefContainsJavascript extends Section508ReportItem {
	private static final String KEY = "href.contains.javascript";

	public HrefContainsJavascript(ATag cause) {
		this((HtmlElement)cause);

		setDescription(formatDescriptionString(KEY, "Anchor (<a>)"));
	}

	public HrefContainsJavascript(AreaTag cause) {
		this((HtmlElement)cause);

		setDescription(formatDescriptionString(KEY, "Area"));
	}

	private HrefContainsJavascript(HtmlElement cause) {
		super(ItemStatus.WARNING, KEY, cause.getSource(), cause.getPosition());

		setAdvice(formatAdviceString(KEY));
	}

}
