/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix.section508;

import java.util.ResourceBundle;

import org.anadix.ItemStatus;
import org.anadix.ReportItem;
import org.anadix.html.AppletTag;
import org.anadix.html.AreaTag;
import org.anadix.html.HtmlElement;
import org.anadix.html.IframeTag;
import org.anadix.html.ImgTag;
import org.anadix.html.InputTag;
import org.anadix.html.ObjectTag;
import org.anadix.impl.AbstractReportItem;

/**
 * FIXME JBoss Logging 3.0 provides support for everything you are trying to do
 * with this class. It supports message internationalization, message bundle
 * classes, message types (ERROR, WARNING, ...) etc. It would be good to re-use
 * what's already implemented elsewhere - although I must admit I am not sure if
 * that would be proper use of a logging framework. If you decide to use
 * jblogging, the following Github repo has some examples:
 * https://github.com/jamezp/jboss-logging-example
 */
public class ReportFactory {
	// FIXME this class should not be used and will be removed soon
	// use classes from package org.anadix.section508.reports instead
	private static final ResourceBundle i18n = ResourceBundle.getBundle("org.anadix.section508.reports");

	private static ReportItem newReportItem(ItemStatus status, String key, HtmlElement cause) {
		String text = i18n.getString(key);
		if (cause != null) {
			text = String.format(text, cause.getSource(), cause.getPosition());
		}

		return new AbstractReportItem(status, text) {};
	}

	public static ReportItem newAltMissingReport(ImgTag cause) {
		return newReportItem(ItemStatus.ERROR, "img.alt.missing", cause);
	}

	public static ReportItem newAltEmptyReport(ImgTag cause) {
		return newReportItem(ItemStatus.WARNING, "img.alt.empty", cause);
	}

	public static ReportItem newAltMissingReport(InputTag cause) {
		return newReportItem(ItemStatus.ERROR, "input.alt.missing", cause);
	}

	public static ReportItem newContentMissingReport(ObjectTag cause) {
		return newReportItem(ItemStatus.ERROR, "object.content.missing", cause);
	}

	public static ReportItem newAltMissingReport(AppletTag cause) {
		return newReportItem(ItemStatus.ERROR, "applet.alt.missing", cause);
	}

	public static ReportItem newContentMissingReport(IframeTag cause) {
		return newReportItem(ItemStatus.ERROR, "iframe.content.missing", cause);
	}

	public static ReportItem newAltMissingReport(AreaTag cause) {
		return newReportItem(ItemStatus.ERROR, "area.alt.missing", cause);
	}

}
