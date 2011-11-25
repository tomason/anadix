package org.anadix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;

import org.jboss.logging.Logger;

import com.thoughtworks.xstream.XStream;

/**
 * Main class to interact with Anadix analyzing engine. The basic methods are
 * provided for creation of analyzer, report formatting and setting the
 * implementations of Parser, ConditionSet and ReportFormatter used.
 * All operations are done either with default implementations (Section508, Swingparser
 * and SimpleRepportFormatter) or with the implementations provided.
 *
 * @author tomason
 * @version $Id: $
 * @since 0.4.0
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
	
	private final XStream xstream;

	static {
		try {
			analyzer = Class.forName("org.anadix.impl.AnalyzerImpl");
		} catch (ClassNotFoundException ex) {
			logger.fatal(ex);
			throw new RuntimeException("Unable to find AnalyzerImpl class", ex);
		}
	}

	private static final Anadix INSTANCE = new Anadix();

	private Anadix() {
		xstream = new XStream();
	}

	/////////////////////////////// public API /////////////////////////////////////
	/**
	 * Creates a new Analyzer instance.
	 * For creation of Analyzer are used ConditionSet and Parser classes that were
	 * set before of the default ones (Section508, Swingparser).
	 *
	 * @return new instance of Analyzer
	 * @throws java.lang.InstantiationException when problem occurs during Analyzer creation
	 */
	public static Analyzer newAnalyzer() throws InstantiationException {
		return INSTANCE.createAnalyzer(null, null);
	}

	/**
	 * Creates a new Analyzer instance.
	 * For creation of Analyzer is used ConditionSet instance passed as a parameter
	 * and Parser class that was set before or the default one defined in
	 * ConditionSet in method getDefaultParser.
	 *
	 * @param conditions - instance of ConditionSet used to analyze parsed sources
	 * @return new instance of Analyzer
	 * @throws java.lang.InstantiationException when problem occurs during Analyzer creation
	 */
	public static Analyzer newAnalyzer(ConditionSet conditions) throws InstantiationException {
		return INSTANCE.createAnalyzer(conditions, null);
	}

	/**
	 * Creates a new Analyzer instance.
	 * For creation of Analyzer are used ConditionSet and Parser instances passed
	 * as parameters.
	 *
	 * @param conditions - instance of ConditionSet used to analyze parsed sources
	 * @param parser - instance of Parser used to parse sources
	 * @return new instance of Analyzer
	 * @throws java.lang.InstantiationException when problem occurs during Analyzer creation
	 */
	public static Analyzer newAnalyzer(ConditionSet conditions, Parser parser) throws InstantiationException {
		return INSTANCE.createAnalyzer(conditions, parser);
	}

	/**
	 * Tries to format given report and store it in report directory.
	 * ReportFormatter class used is the one set before or the default one
	 * (SimpleReportFormatter). Reports are stored either to directory set before via
	 * setReportDirectory method or to the default one (./reports). The default name
	 * is report_{counter}.{formatter.getDefaultExtension}.
	 *
	 * @param report - instance of Report received upon successful analysis
	 * @return true if the Report was formatted and saved, false otherwise
	 */
	public static boolean formatReport(Report report) {
		return formatReport(report, "report");
	}

	/**
	 * Tries to format given report and store it in the report directory under
	 * specified name. The name is appended with _{counter} so if the file with given
	 * name already exists it is not replaced.
	 * ReportFormatter class used is the one set before or the default one
	 * (SimpleReportFormatter). Reports are stored either to directory set before via
	 * setReportDirectory method or to the default one (./reports).
	 *
	 * @param report - instance of Report received upon successful analysis
	 * @param fileName - name of the file to store results to
	 * @return true if the Report was formatted and saved, false otherwise
	 */
	public static boolean formatReport(Report report, String fileName) {
		ReportFormatter formatter;
		try {
			formatter = INSTANCE.createFormatter();
		} catch (InstantiationException ex) {
			return false;
		}

		File output = createFile(INSTANCE.getReportDir(), fileName, formatter.getReportFileExtension());
		Writer writer;
		try {
			writer = new FileWriter(output);
		} catch (IOException ex) {
			logger.error("Unable to create FileWriter", ex);
			return false;
		}

		formatter.formatAndStore(report, writer);

		try {
			writer.close();
		} catch (IOException ex) {
			logger.error("Unable to close FileWriter", ex);
			return false;
		}

		return true;
	}

	/**
	 * Sets the Parser class that is to be used by default
	 *
	 * @param clazz Parser class
	 * @return true if the default Parser was changed, false otherwise
	 */
	public static synchronized boolean setDefaultParser(String clazz) {
		Class<? extends Parser> parserClass = null;
		try {
			parserClass = Anadix.<Parser>createClass(clazz);
		} catch (InstantiationException ex) {
			logger.warn("Unable to set Parser " + clazz, ex);
			return false;
		}

		return setDefaultParser(parserClass);
	}

	/**
	 * Sets the Parser class that is to be used by default
	 *
	 * @param clazz instance of class extending Parser
	 * @return true if the default Parser was changed, false otherwise
	 */
	public static synchronized boolean setDefaultParser(Class<? extends Parser> clazz) {
		if (!checkClass(clazz)) {
			return false;
		}

		parser = clazz;
		return true;
	}

	/**
	 * Sets the ConditionSet class that is to be used by default
	 *
	 * @param clazz ConditionSet class
	 * @return true if the default ConditionSet was changed, false otherwise
	 */
	public static synchronized boolean setDefaultConditionSet(String clazz) {
		Class<? extends ConditionSet> conditionsClass = null;
		try {
			conditionsClass = Anadix.<ConditionSet>createClass(clazz);
		} catch (InstantiationException ex) {
			logger.warn("Unable to set ConditionSet " + clazz, ex);
			return false;
		}

		return setDefaultConditionSet(conditionsClass);
	}
	
	/**
	 * Sets the ConditionSet class that is to be used by default
	 *
	 * @param clazz - instance of class extending ConditionSet
	 * @return true if the default ConditionSet was changed, false otherwise
	 */
	public static synchronized boolean setDefaultConditionSet(Class<? extends ConditionSet> clazz) {
		if (!checkClass(clazz)) {
			return false;
		}

		conditions = clazz;
		return true;
	}

	/**
	 * Sets the ReportFormatter class that is to be used by default
	 *
	 * @param clazz - instance of class extending ReportFormatter
	 * @return true if the default ReportFormatter was changed, false otherwise
	 */
	public static synchronized boolean setDefaultFormatter(String clazz) {
		Class<? extends ReportFormatter> formatterClass = null;
		try {
			formatterClass = Anadix.<ReportFormatter>createClass(clazz);
		} catch (InstantiationException ex) {
			logger.warn("Unable to set ConditionSet " + clazz, ex);
			return false;
		}

		return setDefaultFormatter(formatterClass);
	}
	
	/**
	 * Sets the ReportFormatter class that is to be used by default
	 *
	 * @param clazz - instance of class extending ReportFormatter
	 * @return true if the default ReportFormatter was changed, false otherwise
	 */
	public static synchronized boolean setDefaultFormatter(Class<? extends ReportFormatter> clazz) {
		if (!checkClass(clazz)) {
			return false;
		}

		formatter = clazz;
		return true;
	}

	/**
	 * Sets the directory where all reports are stored
	 *
	 * @param path - instance of File pointing to a directory
	 * @return true if the directory was changed, false otherwise
	 */
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

	/**
	 * Serializes the report to a file for later use.
	 * 
	 * @param report Report to serialize
	 * @param target file to store report to
	 * @throws FileNotFoundException if the file exists but is a directory rather than a
	 * regular file, does not exist but cannot be created, or cannot be opened for any
	 * other reason
	 */
	public static void serializeReport(Report report, File target) throws FileNotFoundException {
		INSTANCE.xstream.toXML(report, new FileOutputStream(target));
	}
	
	/**
	 * Deserializes the serialized report from a file.
	 * 
	 * @param source file from which the report should be deserialized
	 * @return instance of Report
	 */
	public static Report deserializeReport(File source) {
		return (Report)INSTANCE.xstream.fromXML(source);
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

	private static synchronized File createFile(File directory, String name, String extension) {
		String pattern;
		if (extension == null) {
			pattern = String.format("%s_%s", name, "%03d");
		} else {
			pattern = String.format("%s_%s.%s", name, "%03d", extension);
		}

		return createFile(directory, pattern, 0);
	}

	private static synchronized File createFile(File dir, String pattern, int counter) {
		File f = new File(dir, String.format(pattern, counter));

		try {
			if (f.createNewFile()) {
				return f;
			} else {
				return createFile(dir, pattern, ++counter);
			}
		} catch (IOException ex) {
			logger.warn("Error creating report file", ex);
			return createFile(dir, pattern, ++counter);
		}

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
