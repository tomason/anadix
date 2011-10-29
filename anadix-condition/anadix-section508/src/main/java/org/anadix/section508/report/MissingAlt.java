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
import org.anadix.html.AppletTag;
import org.anadix.html.AreaTag;
import org.anadix.html.HtmlElement;
import org.anadix.html.IframeTag;
import org.anadix.html.ImgTag;
import org.anadix.html.InputTag;
import org.anadix.html.ObjectTag;

public class MissingAlt extends Section508ReportItem {

	public MissingAlt(AppletTag cause) {
		this(cause, "applet.missing.alt");
	}

	public MissingAlt(AreaTag cause) {
		this(cause, "area.missing.alt");
	}

	public MissingAlt(IframeTag cause) {
		this(cause, "iframe.missing.content");
	}

	public MissingAlt(ImgTag cause) {
		this(cause, "img.missing.alt");
	}

	public MissingAlt(InputTag cause) {
		this(cause, "input.missing.alt");
	}

	public MissingAlt(ObjectTag cause) {
		this(cause, "object.missing.content");
	}

	private MissingAlt(HtmlElement cause, String key) {
		super(ItemStatus.ERROR, key, cause.getSource(), cause.getPosition());

		setDescription(formatDescriptionString(key));
		setAdvice(formatAdviceString(key));
	}
}
