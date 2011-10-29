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

import java.util.ResourceBundle;

import org.anadix.ItemStatus;
import org.anadix.impl.AbstractReportItem;

public abstract class Section508ReportItem extends AbstractReportItem {
	private static final ResourceBundle itemStatuses = ResourceBundle.getBundle("org.anadix.section508.report.ItemText");
	private static final ResourceBundle descriptions = ResourceBundle.getBundle("org.anadix.section508.report.Description");
	private static final ResourceBundle advices = ResourceBundle.getBundle("org.anadix.section508.report.Advice");

	public Section508ReportItem(ItemStatus status, String key, Object... args) {
		super(status, formatFromBundle(itemStatuses, key, args));
	}

	protected static String formatAdviceString(String key, Object... args) {
		return formatFromBundle(advices, key, args);
	}

	protected static String formatDescriptionString(String key, Object... args) {
		return formatFromBundle(descriptions, key, args);
	}

	private static String formatFromBundle(ResourceBundle bundle, String key, Object... args) {
		if (!bundle.containsKey(key)) {
			throw new IllegalArgumentException("Key " + key + " doesn't exist!");
		}

		String text = bundle.getString(key);
		if (args.length > 0) {
			text = String.format(text, args);
		}

		return text;
	}
}
