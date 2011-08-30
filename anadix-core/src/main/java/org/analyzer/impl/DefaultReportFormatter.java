package org.analyzer.impl;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import org.analyzer.Report;
import org.analyzer.ReportFormatter;

public abstract class DefaultReportFormatter implements ReportFormatter {

	public void formatAndStore(Report report, OutputStream os) {
		formatAndStore(report, new OutputStreamWriter(os));
	}

	public void formatAndStore(Report report, Writer w) {
		PrintWriter pw = new PrintWriter(w);

		pw.println(format(report));

		pw.flush();
	}
}
