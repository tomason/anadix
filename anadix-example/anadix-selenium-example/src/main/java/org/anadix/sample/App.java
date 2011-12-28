package org.anadix.sample;

import java.io.File;

import org.anadix.Anadix;
import org.anadix.impl.XHTMLReportFormatter;
import org.anadix.utils.AnadixSelenium;
import org.openqa.selenium.server.SeleniumServer;

public class App {
	private static final File sourcesDir = new File("sources");
	private static final File reportsDir = new File("reports");

	public static void main( String[] args ) throws Exception {
		// prepare SeleniumServer
		SeleniumServer server = new SeleniumServer();

		try {
			// start server
			server.start();

			// create AnadixSelenium
			AnadixSelenium selenium = new AnadixSelenium(
					"localhost", server.getPort(), "firefox", "http://www.redhat.com");
			try {
				selenium.start();

				// set up AnadixSelenium
				if (!sourcesDir.exists()) {
					sourcesDir.mkdir();
				}
				selenium.setSourcesDir(sourcesDir);
				if (!reportsDir.exists()) {
					reportsDir.mkdir();
				}
				selenium.setReportsDir(reportsDir);

				// perform some browsing with later analysis
				selenium.setAnalyzer(null);	// stores pages sources
				selenium.open("http://www.redhat.com");
				selenium.click("link=JBoss Enterprise Middleware");
				selenium.waitForPageToLoad("30000");
				selenium.click("//div[@id='contentColRight_v2']/div/map/area[9]");
				selenium.waitForPageToLoad("30000");


				// perform some browsing with immediate analysis
				selenium.setAnalyzer(Anadix.newAnalyzer());
				selenium.open("http://www.jboss.org/drools");
				selenium.click("link=Drools Fusion");
				selenium.waitForPageToLoad("30000");
				selenium.click("link=Mailing Lists");
				selenium.waitForPageToLoad("30000");
				selenium.click("link=Documentation");
				selenium.waitForPageToLoad("30000");



				// analyze previous
				selenium.analyzeStoredPages();


				// dump all reports
				selenium.dumpReports(new XHTMLReportFormatter());

			} finally {
				selenium.stop();
				selenium.dispose();
			}
		} finally {
			server.stop();
		}

		System.out.println("finished");
	}
}
