package org.anadix.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.anadix.Anadix;
import org.anadix.Analyzer;
import org.anadix.Report;
import org.anadix.ReportFormatter;
import org.anadix.Source;
import org.anadix.exceptions.SourceException;
import org.anadix.factories.SourceFactory;

import com.thoughtworks.selenium.CommandProcessor;
import com.thoughtworks.selenium.DefaultSelenium;

public class AnadixSelenium extends DefaultSelenium {
	private List<Source> sources = new ArrayList<Source>();
	private List<Report> reports = new ArrayList<Report>();
	private List<Throwable> exceptions = new ArrayList<Throwable>();
	private File sourcesDir = new File("sources");
	private File reportsDir = new File("reports");
	private MultithreadedAnalyzer analyzer;

	public AnadixSelenium(CommandProcessor processor) {
		super(processor);
	}

	public AnadixSelenium(String serverHost, int serverPort, String browserStartCommand, String browserURL) {
		super(serverHost, serverPort, browserStartCommand, browserURL);
	}

	@Override
	public void click(String locator) {
		analyzeCurrentPage();
		super.click(locator);
	}

	@Override
	public void clickAt(String locator, String coordString) {
		analyzeCurrentPage();
		super.clickAt(locator, coordString);
	}

	@Override
	public void submit(String formLocator) {
		analyzeCurrentPage();
		super.submit(formLocator);
	}

	private void analyzeCurrentPage() {
		if (analyzer != null) {
			int id = analyzer.submittAnalysis(SourceFactory.newStringSource(getHtmlSource(), getTitle()));
			try {
				reports.add(analyzer.getResult(id));
			} catch (ResultException ex) {
				throw new RuntimeException("Error durring analysis", ex);
			}
		} else {
			File f = storeHtml(sourcesDir, getTitle(), getHtmlSource());
			try {
				sources.add(SourceFactory.newFileSource(f, false));
			} catch (SourceException ex) {
				throw new RuntimeException("Error during source creation", ex);
			}
		}
	}

	public void analyzeStoredPages() throws InstantiationException {
		analyzeStoredPages(Anadix.newAnalyzer());
	}

	public void analyzeStoredPages(Analyzer analyzer) {
		MultithreadedAnalyzer ma = new MultithreadedAnalyzer(analyzer);
		try {
			List<Integer> ids = new ArrayList<Integer>();

			for (Source s : getStoredSources()) {
				ids.add(ma.submittAnalysis(s));
			}

			Iterator<Integer> it;
			int id;
			Report r;
			while (ids.size() > 0) {
				for (it = ids.iterator(); it.hasNext();) {
					id = it.next();
					try {
						if ((r = ma.getResult(id, false)) != null) {
							reports.add(r);
							it.remove();
						}
					} catch (ResultException ex) {
						exceptions.add(ex);
						it.remove();
					}
				}
			}
		} finally {
			ma.dispose();
		}
	}

	public Collection<Source> getStoredSources() {
		return Collections.unmodifiableCollection(sources);
	}

	public Collection<Report> getStoredReports() {
		return Collections.unmodifiableCollection(reports);
	}

	public Collection<Throwable> getExceptions() {
		return Collections.unmodifiableCollection(exceptions);
	}

	public void dumpReports() {
		File f;
		for (Report report : getStoredReports()) {
			f = storeHtml(reportsDir, report.getSource().getDescription(), "");
			try {
				Anadix.serializeReport(report, f);
			} catch (FileNotFoundException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	public void dumpReports(ReportFormatter formatter) {
		for (Report report : getStoredReports()) {
			storeHtml(reportsDir, report.getSource().getDescription(), formatter.format(report));
		}
	}

	public File getSourcesDir() {
		return sourcesDir;
	}

	public void setSourcesDir(File sourcesDir) {
		this.sourcesDir = sourcesDir;
	}

	public File getReportsDir() {
		return reportsDir;
	}

	public void setReportsDir(File reportsDir) {
		this.reportsDir = reportsDir;
	}

	public MultithreadedAnalyzer getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(Analyzer analyzer) {
		if (this.analyzer != null) {
			this.analyzer.dispose();
		}
		if (analyzer == null) {
			this.analyzer = null;
		} else {
			this.analyzer = new MultithreadedAnalyzer(analyzer);
		}
	}

	public void dispose() {
		analyzer.dispose();
	}

	private static File storeHtml(File directory, String name, String source) {
		int i = 0;
		File resultFile;

		name = name.replace("http://", "").replace("/", "_");

		while ((resultFile = new File(directory, String.format("%s_%s.html", name, i++))).exists());

		try {
			resultFile.createNewFile();
		} catch (IOException e) {
			// retry
			return storeHtml(directory, name, source);
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(resultFile);
			pw.println(source);
			pw.flush();
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("This ought to not happen", ex);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

		return resultFile;
	}
}
