package org.anadix.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.anadix.Anadix;
import org.anadix.Analyzer;
import org.anadix.Report;
import org.anadix.exceptions.SourceException;
import org.anadix.factories.SourceFactory;
import org.anadix.impl.XHTMLReportFormatter;
import org.anadix.section508.Section508;


public class App {

	public static void main( String[] args ) {
		String[] filenames = new String[] {
				//"Drools-5.2.0.html",	//commented out as it takes the longest
				"google.com.html",
				"idnes.cz.html",
				"seznam.cz.html",
				"redhat.com.html"
		};

		Anadix.setDefaultFormatter(XHTMLReportFormatter.class);

		try {
			Analyzer a = Anadix.newAnalyzer(new Section508());
			for (String filename: filenames) {
				Report r = a.analyze(SourceFactory.newClassPathSource("/" + filename));
				Anadix.formatReport(r);
				System.out.println(r.report());
			}

			Report r = a.analyze(SourceFactory.newURLSource(new URL("http://section508.gov")));
			Anadix.formatReport(r);
			System.out.println(r.report());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SourceException e) {
			e.printStackTrace();
		}
	}
}
