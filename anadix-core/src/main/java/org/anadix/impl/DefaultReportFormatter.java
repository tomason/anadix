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

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import org.anadix.Report;
import org.anadix.ReportFormatter;

/**
 * Abstract class for ReportFormatter
 *
 * @author tomason
 * @version $Id: $
 */
public abstract class DefaultReportFormatter implements ReportFormatter {

	/** {@inheritDoc} */
	public void formatAndStore(Report report, OutputStream os) {
		if (os == null) {
			throw new NullPointerException("os cannot be null");
		}
		formatAndStore(report, new OutputStreamWriter(os));
	}

	/** {@inheritDoc} */
	public void formatAndStore(Report report, Writer w) {
		if (report == null) {
			throw new NullPointerException("report cannot be null");
		}
		if (w == null) {
			throw new NullPointerException("w cannot be null");
		}
		PrintWriter pw = new PrintWriter(w);

		pw.println(format(report));

		pw.flush();
	}

	/** {@inheritDoc} */
	public String getReportFileExtension() {
		return null;
	}
}
