package org.analyzer.sample;

import org.analyzer.Report;

import org.analyzer.factories.SourceFactory;

import org.analyzer.Analyzer;

import org.analyzer.exceptions.InstantiationException;

import org.analyzer.factories.ObjectFactory;

public class App {
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
