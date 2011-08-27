package org.analyzer.sample;

import org.analyzer.Report;

import org.analyzer.factories.SourceFactory;

import org.analyzer.Analyzer;

import org.analyzer.exceptions.InstantiationException;

import org.analyzer.factories.ObjectFactory;

public class App {
    /*
     * FIXME In the pom file for this module, I had to specify that I need
     * Section 508 AND SwingParser modules. It would be great if I could just
     * request Section 508 analysis and the dependencies would all get figured
     * out for me.
     * FIXME ^^^ This might also be a useful enhancement to the 
     * ObjectFactory.newAnalyzer() method - just specifying WHAT I want to do 
     * (Section 508) instead of specifying WHAT and HOW (Section 508, 
     * SwingParser). This would make the API much more user-friendly - my 
     * assumption being that the users doesn't care how you parse HTML, they
     * just want their analysis done. 
     */
    public static void main( String[] args ) {
        String[] filenames = new String[] {
                "google.com.html",
                "idnes.cz.html",
                "seznam.cz.html",
                "redhat.com.html"
        };
        try {
            Analyzer a = ObjectFactory.newAnalyzer("org.analyzer.swingparser.SwingParser", "org.analyzer.section508.Section508");
            for (String filename: filenames) {
                Report r = a.analyze(SourceFactory.newClassPathSource("/" + filename));
                System.out.println(r.report());
            }
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
