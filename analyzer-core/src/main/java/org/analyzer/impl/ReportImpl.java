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

import java.util.ArrayList;
import java.util.List;

import org.analyzer.Report;
import org.analyzer.ReportItem;
import org.drools.runtime.ClassObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;

public class ReportImpl implements Report {
	private final List<ReportItem> errors = new ArrayList<ReportItem>();
	private final List<ReportItem> warnings = new ArrayList<ReportItem>();
	private final List<ReportItem> oks = new ArrayList<ReportItem>();

	public ReportImpl(StatefulKnowledgeSession ksession) {
		for (Object i : ksession.getObjects(new ClassObjectFilter(ReportItem.class))) {
			ReportItem item = (ReportItem)i;
			switch (item.getStatus()) {
			case OK:
				oks.add(item);
				break;
			case WARNING:
				warnings.add(item);
				break;
			case ERROR:
				errors.add(item);
				break;
			}
		}
	}

	public List<ReportItem> getOks() {
		return oks;
	}

	public List<ReportItem> getWarnings() {
		return warnings;
	}

	public List<ReportItem> getErrors() {
		return errors;
	}

	public String report() {
		StringBuilder sb = new StringBuilder();

		sb.append("*******************************************************").append("\n");
		sb.append("*                 Drools report                       *").append("\n");
		sb.append("*******************************************************").append("\n");
		sb.append("\n");
		sb.append("\n");
		sb.append("ERROR:").append("\n");
		sb.append("-------").append("\n");
		for (ReportItem i : errors) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}
		sb.append("\n");

		sb.append("WARNING:").append("\n");
		sb.append("---------").append("\n");
		for (ReportItem i : warnings) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}

		sb.append("\n");

		sb.append("OK:").append("\n");
		sb.append("---").append("\n");
		for (ReportItem i : oks) {
			sb.append(" > ").append(i.getItemText()).append("\n");
		}


		sb.append("\n");
		sb.append("*******************************************************").append("\n");
		sb.append(String.format("* Errors: % 9d | Warnings: % 9d             *",
				errors.size(), warnings.size())).append("\n");
		sb.append("*******************************************************").append("\n");

		return sb.toString();
	}

	@Override
	public String toString() {
		return report();
	}
}
