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
package org.anadix;

/**
 * Represents single item in report. Otherwise it is a simple object.
 * It has two mandatory attributes - status and itemText. Optional attributes
 * provide more detailed information in final report file.
 * 
 * @author tomason
 */
public interface ReportItem {
	/**
	 * @return item status
	 */
	ItemStatus getStatus();

	/**
	 * @return basic item text
	 */
	String getItemText();

	/**
	 * Sets the advice - advice should contain some suggestion how to fix
	 * the problem. Therefore it makes sense only for ReportItems with status
	 * ERROR or WARNING.
	 * 
	 * @param advice - advice how to fix a reported problem
	 */
	void setAdvice(String advice);

	/**
	 * @return advice how to fix a reported problem
	 */
	String getAdvice();

	/**
	 * Sets the more detailed description of the ReportItem
	 * 
	 * @param description - detailed description of ReportItem
	 */
	void setDescription(String description);

	/**
	 * @return detailed description of ReportItem
	 */
	String getDescription();
}
