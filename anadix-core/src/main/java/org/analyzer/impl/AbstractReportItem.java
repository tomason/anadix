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
package org.analyzer.impl;

import org.analyzer.ItemStatus;
import org.analyzer.ReportItem;

public abstract class AbstractReportItem implements ReportItem {
	private final ItemStatus status;
	private final String itemText;
	private String description;
	private String advice;

	public AbstractReportItem(ItemStatus status, String itemText) {
		this.status = status;
		this.itemText = itemText;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public String getItemText() {
		return itemText;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getAdvice() {
		return advice;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return getStatus() + " - " + getItemText();
	}
}
