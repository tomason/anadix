package org.anadix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;

import org.jboss.logging.Logger;

/**
 * Main class to interact with Anadix analyzing engine. The basic methods are
 * provided for creation of analyzer, setting the implementations of Parser,
 * ConditionSet and ReportFormatter used and finally report formatting.
 * All operations are done either with default implementations (Section508, Swingparser
 * and SimpleRepportFormatter) or with the implementations provided.
 * 
 * @author tomason
 */
public final class Anadix {
	private static final String DEFAULT_CONDITIONS = "org.anadix.section508.Section508";
	private static final String DEFAULT_FORMATTER = "org.anadix.impl.SimpleReportFormatter";
	private static final String DEFAULT_REPORT_DIR = "reports";

	private static final Class<?> analyzer;
	private static final Logger logger = Logger.getLogger(Anadix.class);

	private static Class<? extends Parser> parser;
	private static Class<? extends ConditionSet> conditions;
	private static Class<? extends ReportFormatter> formatter;
	private static File reportDir;

	static {
		try {
			analyzer = Class.forName("org.anadix.impl.AnalyzerImpl");
		} catch (ClassNotFoundException ex) {
			logger.fatal(ex);
			throw new RuntimeException("Unable to find AnalyzerImpl class", ex);
		}
	}

	private static final Anadix INSTANCE = new Anadix();

	private Anadix() {}

	/////////////////////////////// public API /////////////////////////////////////
	public static Analyzer newAnalyzer() throws InstantiationException {
		return INSTANCE.createAnalyzer(null, null);
	}

	public static Analyzer newAnalyzer(ConditionSet conditions) throws InstantiationException {
		return INSTANCE.createAnalyzer(conditions, null);
	}

	public static Analyzer newAnalyzer(ConditionSet conditions, Parser parser) throws InstantiationException {
		return INSTANCE.createAnalyzer(conditions, parser);
	}

	public static boolean formatReport(Report report) {
		File output = new File(INSTANCE.getReportDir(), "report");

		return formatReport(report, output);
	}

	public static boolean formatReport(Report report, File output) {
		Writer writer;
		try {
			writer = new FileWriter(output);
		} catch (IOException ex) {
			logger.error("Unable to create FileWriter", ex);
			return false;
		}

		try {
			INSTANCE.createFormatter().formatAndStore(report, writer);
		} catch (InstantiationException ex) {
			return false;
		}

		try {
			writer.close();
		} catch (IOException ex) {
			logger.error("Unable to close FileWriter", ex);
			return false;
		}

		return true;
	}

	public static synchronized boolean setDefaultParser(Class<? extends Parser> clazz) {
		if (!checkClass(clazz)) {
			return false;
		}

		parser = clazz;
		return true;
	}

	public static synchronized boolean setDefaultConditionSet(Class<? extends ConditionSet> clazz) {
		if (!checkClass(clazz)) {
			return false;
		}

		conditions = clazz;
		return true;
	}

	public static synchronized boolean setDefaultFormatter(Class<? extends ReportFormatter> clazz) {
		if (!checkClass(clazz)) {
			return false;
		}

		formatter = clazz;
		return true;
	}

	public static synchronized boolean setReportDirectory(File path) {
		if (!path.exists()) {
			if (!path.mkdirs()) {
				logger.warn("Unable to create report directory");
				return false;
			}
		}
		if (!path.isDirectory()) {
			logger.warn("Path is not a directory");
			return false;
		}
		if (!path.canRead() || !path.canWrite()) {
			logger.warn("Unable to access the directory");
			return false;
		}

		reportDir = path;
		return true;
	}

	/////////////////////////////// private methods ////////////////////////////////
	private static boolean checkClass(Class<?> clazz) {
		try {
			createInstance(clazz);
			return true;
		} catch (InstantiationException e) {
			return false;
		}
	}

	private ConditionSet createConditionSet() throws InstantiationException {
		if (conditions == null) {
			conditions = Anadix.<ConditionSet>createClass(DEFAULT_CONDITIONS);
		}

		return createInstance(conditions);
	}

	private Parser createParser(ConditionSet conditions) throws InstantiationException {
		if (parser == null) {
			parser = conditions.getDefaultParser();
		}

		return createInstance(parser);
	}

	private Analyzer createAnalyzer(ConditionSet conditions, Parser parser) throws InstantiationException {
		if (conditions == null) {
			conditions = createConditionSet();
		}
		if (parser == null) {
			parser = createParser(conditions);
		}

		try {
			Constructor<?> constructor = analyzer.getConstructor(Parser.class, ConditionSet.class);
			Object instance = constructor.newInstance(parser, conditions);

			return Analyzer.class.cast(instance);
		} catch (RuntimeException ex) {
			throw ex;
		} catch (Exception ex) {
			logger.fatal(ex);
			throw new RuntimeException("Unable to instantiate AnalyzerImpl", ex);
		}
	}

	private ReportFormatter createFormatter() throws InstantiationException {
		if (formatter == null) {
			formatter = Anadix.<ReportFormatter>createClass(DEFAULT_FORMATTER);
		}

		return createInstance(formatter);
	}

	private File getReportDir() {
		if (reportDir == null) {
			setReportDirectory(new File(DEFAULT_REPORT_DIR));
		}

		return reportDir;
	}


	@SuppressWarnings("unchecked")
	private static <T> Class<? extends T> createClass(String clazz) throws InstantiationException {
		try {
			return ClassPool.getDefault().get(clazz).toClass();
		} catch (NotFoundException ex) {
			logger.error(ex);
			throw new InstantiationException(clazz);
		} catch (CannotCompileException ex) {
			logger.error(ex);
			throw new InstantiationException(clazz);
		}
	}

	private static <T> T createInstance(Class<? extends T> clazz) throws InstantiationException {
		try {
			return clazz.newInstance();
		} catch (InstantiationException ex) {
			logger.error(ex);
			throw new InstantiationException(conditions.getName());
		} catch (IllegalAccessException ex) {
			logger.error(ex);
			throw new InstantiationException(conditions.getName());
		}
	}
}
