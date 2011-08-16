package org.analyzer.factories;

import java.lang.reflect.Constructor;

import org.analyzer.Analyzer;
import org.analyzer.ConditionSet;
import org.analyzer.ElementFactory;
import org.analyzer.Parser;
import org.analyzer.exceptions.InstantiationException;

public abstract class ObjectFactory {
	private static final String defaultParser = "org.analyzer.swingparser.SwingParser";
	private static final String defaultConditions = "org.analyzer.section508.Section508";
	private static final String defaultAnalyzer = "org.analyzer.impl.AnalyzerImpl";
	private static final String defaultElementFactory = "org.analyzer.html.HTMLElementFactory";

	private static final String errorMessaageFormat = "Could not instantiate %s: %s";

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

	public static ConditionSet newConditionSet(String className) throws InstantiationException {
		if (className == null) {
			className = defaultConditions;
		}
		try {
			return (ConditionSet)Class.forName(className).newInstance();
		} catch (Exception ex) {
			throw newInstantiationException("ConditionSet", className, ex);
		}
	}

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

	public static Analyzer newAnalyzer() throws InstantiationException {
		return newAnalyzer(null, null);
	}

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
