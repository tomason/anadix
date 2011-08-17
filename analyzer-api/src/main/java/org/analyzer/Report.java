package org.analyzer;

import java.util.List;

/**
 * Class agregating ReportItem instances from analysis in collections
 * grouped by their status. Also enables to get simple textual report.
 * Please note that it should be used for debug purposes only!
 * 
 * @author tomason
 */
public interface Report {
	/**
	 * Lists all elements that are all right.
	 * Note that not all ConditionSets insert ReportItems without mistakes!
	 * 
	 * @return list of ReportItem tahat have OK status
	 */
	List<ReportItem> getOks();

	/**
	 * Lists all elements that have non-critical errors.
	 * Note that not all ConditionSets insert ReportItems with minor mistakes!
	 * 
	 * @return list of ReportItem tahat have WARNING status
	 */
	List<ReportItem> getWarnings();

	/**
	 * Lists all elements with critical errors.
	 * 
	 * @return list of ReportItem tahat have ERROR status
	 */
	List<ReportItem> getErrors();

	/**
	 * Creates a simple format String that lists all ReportItems
	 * resulting from single analysis.
	 * Please note that this format should be used for debugging only!
	 * 
	 * @return string representation of this instance
	 */
	String report();
}
