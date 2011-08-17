package org.analyzer;

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
