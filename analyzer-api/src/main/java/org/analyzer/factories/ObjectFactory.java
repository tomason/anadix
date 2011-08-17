package org.analyzer.factories;

import java.lang.reflect.Constructor;

import org.analyzer.Analyzer;
import org.analyzer.ConditionSet;
import org.analyzer.ElementFactory;
import org.analyzer.Parser;
import org.analyzer.exceptions.InstantiationException;

/**
 * Creates instances of various objects used by analyzer
 * 
 * @author tomason
 */
public abstract class ObjectFactory {
	private static final String defaultParser = "org.analyzer.swingparser.SwingParser";
	private static final String defaultConditions = "org.analyzer.section508.Section508";
	private static final String defaultAnalyzer = "org.analyzer.impl.AnalyzerImpl";
	private static final String defaultElementFactory = "org.analyzer.html.HTMLElementFactory";

	private static final String errorMessaageFormat = "Could not instantiate %s: %s";

	/**
	 * Creates new instance of Parser by invoking default constructor in
	 * class defined by given class name. If null is given as a parameter
	 * default Parser is constructed.
	 * 
	 * @param className - name of the class to be constructed
	 * @return new instance of Parser
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static Parser newParser(String className) throws InstantiationException {
		if (className == null || className.length() == 0) {
			className = defaultParser;
		}

		try {
			return (Parser)Class.forName(className).newInstance();
		} catch (Exception ex) {
			throw newInstantiationException("Parser", className, ex);
		}
	}

	/**
	 * Creates new instance of ConditionSet by invoking default constructor in
	 * class defined by given class name. If null is given as a parameter
	 * default ConditionSet is constructed.
	 * 
	 * @param className - name of the class to be constructed
	 * @return new instance of ConditionSet
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static ConditionSet newConditionSet(String className) throws InstantiationException {
		if (className == null || className.length() == 0) {
			className = defaultConditions;
		}
		try {
			return (ConditionSet)Class.forName(className).newInstance();
		} catch (Exception ex) {
			throw newInstantiationException("ConditionSet", className, ex);
		}
	}

	/**
	 * Creates instance of Class<? extends ElementFactory> defined by
	 * given class name. If null is given as a parameter default
	 * Class<? extends ElementFactory> is returned
	 * 
	 * @param className - name of the class to be constructed
	 * @return instance of Class<? extends ElementFactory>
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ElementFactory>
	Class<T> getElementFactoryClass(String className) throws InstantiationException {
		if (className == null || className.length() == 0) {
			className = defaultElementFactory;
		}
		try {
			return (Class<T>)Class.forName(className);
		} catch (Exception ex) {
			throw newInstantiationException("ElementFactory", className, ex);
		}
	}

	/**
	 * Creates a new instance of analyzer using default Parser and default
	 * ConditionSet
	 * 
	 * @return new instance of Analyzer
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static Analyzer newAnalyzer() throws InstantiationException {
		return newAnalyzer(null, null);
	}

	/**
	 * Creates a new instance of analyzer using given Parser and given
	 * ConditionSet
	 * 
	 * @param parserClassName - name of the Parser class to be used
	 * @param conditionClassName - name of the ConditionSet class to be used
	 * @return new instance of Analyzer
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	@SuppressWarnings("unchecked")
	public static Analyzer newAnalyzer(String parserClassName, String conditionClassName)
			throws InstantiationException {
		try {
			Class<Analyzer> clazz = (Class<Analyzer>)Class.forName(defaultAnalyzer);
			Constructor<Analyzer> c = clazz.getConstructor(
					Parser.class, ConditionSet.class);

			return c.newInstance(
					newParser(parserClassName),
					newConditionSet(conditionClassName));
		} catch (Exception ex) {
			throw newInstantiationException("Analyzer", defaultAnalyzer, ex);
		}
	}

	private static InstantiationException newInstantiationException(String type, String className,
			Throwable cause) {
		return new InstantiationException(
				String.format(errorMessaageFormat, type, className), cause);
	}
}
