package org.analyzer.factories;

import java.lang.reflect.Constructor;

import org.analyzer.Analyzer;
import org.analyzer.ConditionSet;
import org.analyzer.ElementFactory;
import org.analyzer.Parser;
import org.analyzer.exceptions.InstantiationException;

public abstract class ObjectFactory {
	public static Parser newParser(String className) throws Exception {
		return (Parser)Class.forName(className).newInstance();
	}

	public static ConditionSet newConditionSet(String className) throws Exception {
		return (ConditionSet)Class.forName(className).newInstance();
	}

	@SuppressWarnings("unchecked")
	public static <T extends ElementFactory>
	Class<T> getElementFactoryClass(String className) throws InstantiationException {
		if (className == null || className.length() == 0) {
			className = "org.analyzer.html.HTMLElementFactory";
		}
		try {
			return (Class<T>)Class.forName(className);
		} catch (ClassNotFoundException ex) {
			throw new InstantiationException("Could not instantiate ElementFactory", ex);
		}
	}

	@SuppressWarnings("unchecked")
	public static Analyzer newAnalyzer(String parserClassName, String conditionClassName)
			throws Exception {
		Class<Analyzer> clazz = (Class<Analyzer>)Class.forName("org.analyzer.impl.AnalyzerImpl");
		Constructor<Analyzer> c = clazz.getConstructor(
				Parser.class, ConditionSet.class);

		return c.newInstance(
				newParser(parserClassName),
				newConditionSet(conditionClassName));
	}
}
