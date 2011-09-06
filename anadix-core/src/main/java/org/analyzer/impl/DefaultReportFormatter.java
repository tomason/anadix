package org.analyzer.impl;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import org.analyzer.Report;
import org.analyzer.ReportFormatter;

public abstract class DefaultReportFormatter implements ReportFormatter {

	public void formatAndStore(Report report, OutputStream os) {
		if (os == null) {
			throw new NullPointerException("os cannot be null");
		}
		formatAndStore(report, new OutputStreamWriter(os));
	}

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
}
