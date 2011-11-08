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

import java.util.List;

/**
 * Class aggregating ReportItem instances from analysis in collections
 * grouped by their status. Also enables to get simple textual report.
 * Please note that it should be used for debug purposes only!
 *
 * @author tomason
 * @version $Id: $
 */
public interface Report {
	/**
	 * Lists all elements that are all right.
	 * Note that not all ConditionSets insert ReportItems without mistakes!
	 *
	 * @return list of ReportItem that have OK status
	 */
	List<ReportItem> getOks();

	/**
	 * Lists all elements that have non-critical errors.
	 * Note that not all ConditionSets insert ReportItems with minor mistakes!
	 *
	 * @return list of ReportItem that have WARNING status
	 */
	List<ReportItem> getWarnings();

	/**
	 * Lists all elements with critical errors.
	 *
	 * @return list of ReportItem that have ERROR status
	 */
	List<ReportItem> getErrors();

	/**
	 * Lists all elements that require manual check
	 *
	 * @return list of ReportItems that have MANUAL status
	 */
	List<ReportItem> getManuals();

	/**
	 * Lists all information items
	 *
	 * @return list of ReportItems that have INFO status
	 */
	List<ReportItem> getInfos();

	/**
	 * Creates a simple format String that lists all ReportItems
	 * resulting from single analysis.
	 * Please note that this format should be used for debugging only!
	 *
	 * @return string representation of this instance
	 */
	String report();

	/**
	 * Gets the Source this report was generated for
	 *
	 * @return Source this Report was generated from
	 */
	Source getSource();
}
