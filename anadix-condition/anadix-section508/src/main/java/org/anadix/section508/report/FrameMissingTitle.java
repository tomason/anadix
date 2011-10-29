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
