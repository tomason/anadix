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
package org.analyzer;

import java.io.OutputStream;
import java.io.Writer;

/**
 * Class used to format results of analysis stored in Report class.
 * 
 * @author tomason
 */
public interface ReportFormatter {

	/**
	 * Most important method that returns String containing formatted results.
	 * The content of the String depends on implementation of this method, it
	 * may be simple text as well as XML, HTML or any other format.
	 * 
	 * @param report - report to create output from
	 * @return formatted Report as a String
	 */
	String format(Report report);

	/**
	 * Formats the Report and stores the results of formatting to given OutputStream
	 * 
	 * @param report - report to format
	 * @param os - stream to store the formatted report to
	 */
	void formatAndStore(Report report, OutputStream stream);

	/**
	 * Formats the Report and stores the results of formatting to given Writer
	 * 
	 * @param report - report to format
	 * @param w - writer to store the formatted report to
	 */
	void formatAndStore(Report report, Writer writer);
}
