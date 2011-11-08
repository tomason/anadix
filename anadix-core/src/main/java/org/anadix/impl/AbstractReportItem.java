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
package org.anadix.impl;

import org.anadix.ItemStatus;
import org.anadix.ReportItem;

/**
 * Abstract implementation of ReportItem
 *
 * @author tomason
 * @version $Id: $
 */
public abstract class AbstractReportItem implements ReportItem {
	private final ItemStatus status;
	private final String itemText;
	private String description;
	private String advice;

	/**
	 * Constructor
	 *
	 * @param status - item status
	 * @param itemText - basic description of report item
	 */
	public AbstractReportItem(ItemStatus status, String itemText) {
		if (status == null) {
			throw new NullPointerException("status must not be null");
		}
		if (itemText == null) {
			throw new NullPointerException("itemText must not be null");
		}
		this.status = status;
		this.itemText = itemText;
	}

	/** {@inheritDoc} */
	public ItemStatus getStatus() {
		return status;
	}

	/** {@inheritDoc} */
	public String getItemText() {
		return itemText;
	}

	/** {@inheritDoc} */
	public void setAdvice(String advice) {
		this.advice = advice;
	}

	/** {@inheritDoc} */
	public String getAdvice() {
		return advice;
	}

	/** {@inheritDoc} */
	public void setDescription(String description) {
		this.description = description;
	}

	/** {@inheritDoc} */
	public String getDescription() {
		return description;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return getStatus() + " - " + getItemText();
	}
}
