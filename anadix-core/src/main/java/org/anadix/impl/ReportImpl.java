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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.anadix.Report;
import org.anadix.ReportItem;
import org.anadix.Source;
import org.drools.runtime.ClassObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;

public class ReportImpl implements Report {
	private final List<ReportItem> errors = new ArrayList<ReportItem>();
	private final List<ReportItem> warnings = new ArrayList<ReportItem>();
	private final List<ReportItem> oks = new ArrayList<ReportItem>();
	private final List<ReportItem> manuals = new ArrayList<ReportItem>();
	private final List<ReportItem> infos = new ArrayList<ReportItem>();

	private final Source source;

	public ReportImpl(StatefulKnowledgeSession ksession, Source source) {
		if (source == null) {
			throw new NullPointerException("source must not be null");
		}
		if (ksession == null) {
			throw new NullPointerException("ksession must not be null");
		}
		this.source = source;

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
			case MANUAL:
				manuals.add(item);
				break;
			case INFO:
				infos.add(item);
				break;
			default:
				throw new RuntimeException("Unexpected enum value " + item.getStatus());
			}
		}
	}

	public Source getSource() {
		return source;
	}

	public List<ReportItem> getOks() {
		return Collections.unmodifiableList(oks);
	}

	public List<ReportItem> getWarnings() {
		return Collections.unmodifiableList(warnings);
	}

	public List<ReportItem> getErrors() {
		return Collections.unmodifiableList(errors);
	}

	public List<ReportItem> getManuals() {
		return manuals;
	}

	public List<ReportItem> getInfos() {
		return infos;
	}

	public String report() {
		return new SimpleReportFormatter().format(this);
	}

	@Override
	public String toString() {
		return report();
	}
}
