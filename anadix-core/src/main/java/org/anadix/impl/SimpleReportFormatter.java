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

import org.anadix.Report;
import org.anadix.ReportItem;

public class SimpleReportFormatter extends DefaultReportFormatter {

	public String format(Report report) {
		StringBuilder sb = new StringBuilder();

		sb.append("*******************************************************").append("\n");
		sb.append("*                 Drools report                       *").append("\n");
		sb.append("*******************************************************").append("\n");
		sb.append("Analyzing: ").append(report.getSource().getDescription()).append("\n");
		sb.append("\n");
		sb.append("\n");

		sb.append("MANUAL:").append("\n");
		sb.append("-------").append("\n");
		for (ReportItem i : report.getManuals()) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}
		sb.append("\n");

		sb.append("ERROR:").append("\n");
		sb.append("-------").append("\n");
		for (ReportItem i : report.getErrors()) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}
		sb.append("\n");

		sb.append("WARNING:").append("\n");
		sb.append("---------").append("\n");
		for (ReportItem i : report.getWarnings()) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}

		sb.append("\n");

		sb.append("INFO:").append("\n");
		sb.append("-------").append("\n");
		for (ReportItem i : report.getInfos()) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}
		sb.append("\n");

		sb.append("OK:").append("\n");
		sb.append("---").append("\n");
		for (ReportItem i : report.getOks()) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}


		sb.append("\n");
		sb.append("*******************************************************").append("\n");
		sb.append(String.format("* Errors: % 9d | Warnings: % 9d             *",
				report.getErrors().size(), report.getWarnings().size())).append("\n");
		sb.append("*******************************************************").append("\n");

		return sb.toString();
	}

}
