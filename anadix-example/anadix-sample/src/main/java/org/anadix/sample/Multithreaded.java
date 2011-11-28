package org.anadix.sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.anadix.Anadix;
import org.anadix.Analyzer;
import org.anadix.Report;
import org.anadix.Source;
import org.anadix.exceptions.SourceException;
import org.anadix.factories.SourceFactory;
import org.anadix.impl.XHTMLReportFormatter;
import org.anadix.section508.Section508;

public class Multithreaded {
	private static final ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	public static void main(String[] args) throws InstantiationException, SourceException {
		String[] filenames = new String[] {
				"Drools-5.2.0.html",
				"google.com.html",
				"idnes.cz.html",
				"seznam.cz.html",
				"redhat.com.html"
		};
		Anadix.setDefaultFormatter(XHTMLReportFormatter.class);
		
		List<Source> sources = new ArrayList<Source>();
		try {
			for (String filename: filenames) {
				sources.add(SourceFactory.newClassPathSource("/" + filename));
			}
			sources.add(SourceFactory.newURLSource(new URL("http://section508.gov")));
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
		
		Analyzer a = Anadix.newAnalyzer(new Section508());
		
		List<Future<Report>> reports = new ArrayList<Future<Report>>();
		
		System.out.println("Submitting...");
		for (Source s : sources) {
			reports.add(e.submit(new SourceAnalyzer(s, a)));	
		}
		
		System.out.println("Waiting for results...");
		Iterator<Future<Report>> it;
		Future<Report> f;
		Report r;
		while (reports.size() > 0) {
			it = reports.iterator();
			while (it.hasNext()) {
				f = it.next();
				try {
					r = f.get(1, TimeUnit.SECONDS);
					System.out.println("Received report: " + r.getSource().getDescription());
					it.remove();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				} catch (ExecutionException ex) {
					ex.printStackTrace();
					it.remove();
				} catch (TimeoutException e) {
					// fairly OK
				}
				//System.out.println(String.format("Remaining %s tasks.", reports.size()));
			}
		}
		
		e.shutdown();
		try {
			if (!e.awaitTermination(5, TimeUnit.SECONDS)) {
				e.shutdownNow();
			}
		} catch (InterruptedException e1) {
			System.exit(1);
		}
		System.out.println("Finished...");
	}	

	private static final class SourceAnalyzer implements Callable<Report> {
		private final Source s;
		private final Analyzer a;
		
		public SourceAnalyzer(Source s, Analyzer a) {
			this.s = s;
			this.a = a;
		}
		
		public Report call() throws Exception {
			double time = System.nanoTime();
			Report r = a.analyze(s);
			time = System.nanoTime() - time;
			time /= 1000.0; // microseconds
			time /= 1000.0; // miliseconds
			time /= 1000.0; // seconds
			System.out.println(String.format("Finished %s in %.3f s", s.getDescription(), time));
			return r;
		}
	}
}
