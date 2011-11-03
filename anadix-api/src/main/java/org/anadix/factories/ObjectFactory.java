/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix.factories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.anadix.Analyzer;
import org.anadix.ConditionSet;
import org.anadix.Parser;
import org.anadix.ReportFormatter;
import org.jboss.logging.Logger;


/**
 * Creates instances of various objects used by analyzer
 * 
 * @author tomason
 */
public final class ObjectFactory {
	private static final Logger logger = Logger.getLogger(ObjectFactory.class);
	// FIXME allow configuring default classes (or at the very least the defaultConditions)
	// FIXME think about making this 'org.anadix.Anadix' class as it's
	// practically the main thing Anadix offers. When redoing this enhance capabilities
	private static final String defaultConditions = "org.anadix.section508.Section508";
	private static final String defaultAnalyzer = "org.anadix.impl.AnalyzerImpl";
	private static final String defaultFormatter = "org.anadix.impl.SimpleReportFormatter";

	private static final String errorMessageFormat = "Could not instantiate %s";

	private ObjectFactory() {}

	/**
	 * Creates new instance of Parser by invoking default constructor in
	 * class defined by given class name.
	 * 
	 * @param className - name of the class to be constructed
	 * @return new instance of Parser
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static Parser newParser(String className) throws InstantiationException {
		if (className == null || className.length() == 0) {
			throw new NullPointerException("className");
		}

		return instantiate(Parser.class, className);
	}

	/**
	 * Creates new instance of Parser by invoking default constructor in
	 * given class.
	 * 
	 * @param clazz - class to be constructed
	 * @return new instance of Parser
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static Parser newParser(Class<? extends Parser> clazz) throws InstantiationException {
		return instantiate(clazz);
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
			throw new NullPointerException("className");
		}

		return instantiate(ConditionSet.class, className);
	}

	/**
	 * Creates new instance of ConditionSet by invoking default constructor in
	 * given class.
	 * 
	 * @param clazz - class to be constructed
	 * @return new instance of ConditionSet
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static ConditionSet newConditionSet(Class<? extends ConditionSet> clazz) throws InstantiationException {
		return instantiate(clazz);
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
		ConditionSet cs = newConditionSet(defaultConditions);
		Parser p = newParser(cs.getDefaultParser());

		return newAnalyzer(p, cs);
	}

	/**
	 * Creates a new instance of analyzer using given condition set and
	 * default Parser
	 * 
	 * @param conditionsClass - conditions to use
	 * @return new instance of Analyzer
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static Analyzer newAnalyzer(Class<? extends ConditionSet> conditionsClass) throws InstantiationException {
		ConditionSet cs = newConditionSet(conditionsClass);
		Parser p = newParser(cs.getDefaultParser());

		return newAnalyzer(p, cs);
	}

	/**
	 * Creates a new instance of analyzer using given condition set and
	 * parser
	 * 
	 * @param parserClass - parser to use
	 * @param conditionsClass - conditions to use
	 * @return new instance of Analyzer
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static Analyzer newAnalyzer(
			Class<? extends Parser> parserClass,
			Class<? extends ConditionSet> conditionsClass) throws InstantiationException {
		ConditionSet c = newConditionSet(conditionsClass);
		Parser p = newParser(parserClass);

		return newAnalyzer(p, c);
	}

	/**
	 * Creates a new instance of analyzer using given Parser and ConditionSet
	 * 
	 * @param p - Parser to use
	 * @param c - ConditionSet to use
	 * @return new instance of Analyzer
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static Analyzer newAnalyzer(Parser p, ConditionSet c) throws InstantiationException {
		if (c == null) {
			throw new NullPointerException("ConditionSet can't be null");
		}
		if (p == null) {
			throw new NullPointerException("Parser can't be null");
		}

		return instantiate(Analyzer.class, defaultAnalyzer, new Object[] { p, c });
	}

	/**
	 * Creates a new instance of default ReportFormatter.
	 * 
	 * @return new instance of ReportFormatter
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static ReportFormatter newFormatter() throws InstantiationException {
		return newFormatter(defaultFormatter);
	}

	/**
	 * Creates a new instance of ReportFormatter by invoking default constructor in
	 * class defined by given class name.
	 * 
	 * @param className - name of the class to be constructed
	 * @return new instance of ReportFormatter
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static ReportFormatter newFormatter(String className) throws InstantiationException {
		if (className == null || className.length() == 0) {
			throw new NullPointerException("className can't be null");
		}

		return instantiate(ReportFormatter.class, className);
	}

	/**
	 * Creates a new instance of ReportFormatter by invoking default constructor in
	 * class defined by given class.
	 * 
	 * @param clazz - class to be constructed
	 * @return new instance of ReportFormatter
	 * @throws InstantiationException - when exception occurs during creating
	 * new instance
	 */
	public static ReportFormatter newFormatter(Class<? extends ReportFormatter> clazz) throws InstantiationException {
		if (clazz == null) {
			throw new NullPointerException("clazz can't be null");
		}

		return instantiate(clazz);
	}

	/**
	 * Creates a new instance of class given by name and casts it to
	 * given superclass
	 */
	private static <T> T instantiate(
			Class<T> clazz, String className, Object... initargs) throws InstantiationException {

		try {
			Class<?> c = Class.forName(className);
			if (clazz.isAssignableFrom(c)) {
				Object o = instantiate(c, initargs);

				return clazz.cast(o);
			} else {
				throw new IllegalArgumentException("Class " + className + " is not extending " + clazz.getName());
			}
		} catch (ClassNotFoundException ex) {
			throw newInstantiationException(clazz.getName(), ex);
		}
	}

	/**
	 * Creates a new instance of given class using constructor accepting
	 * given parameters
	 * 
	 * @param clazz - class to create a new instance of
	 * @param initargs - arguments to constructor
	 * @return new instance of given class
	 * @throws Exception - if anything goes wrong
	 */
	private static <T> T instantiate(Class<T> clazz, Object... initargs) throws InstantiationException {
		try {
			Object o = getConstructor(clazz, initargs).newInstance(initargs);

			return clazz.cast(o);
		} catch (IllegalAccessException ex) {
			throw newInstantiationException(clazz.getName(), ex);
		} catch (IllegalArgumentException ex) {
			throw newInstantiationException(clazz.getName(), ex);
		} catch (InvocationTargetException ex) {
			throw newInstantiationException(clazz.getName(), ex);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> Constructor<T> getConstructor(Class<T> clazz, Object... initargs) throws InstantiationException {
		// try to find constructor matching exactly to given args
		try {
			Class<?>[] parameterTypes = new Class<?>[initargs.length];

			int i = 0;
			for (Object arg : initargs) {
				parameterTypes[i++] = arg.getClass();
			}

			return clazz.getConstructor(parameterTypes);
		} catch (NoSuchMethodException ex) {
			logger.info("Didn't find appropriate constructor", ex);
		}

		// try to find constructor which has params assignable from initargs
		constructorLoop : for (Constructor<?> c : clazz.getConstructors()) {
			Class<?>[] paramTypes = c.getParameterTypes();
			if (paramTypes.length != initargs.length) {
				continue constructorLoop;
			}

			for (int i = 0; i < paramTypes.length; i++) {
				if (!paramTypes[i].isAssignableFrom(initargs[i].getClass())) {
					continue constructorLoop;
				}
			}

			return (Constructor<T>)c;
		}

		throw newInstantiationException(clazz.getName(), null);
	}

	private static InstantiationException newInstantiationException(String className, Throwable cause) {
		if (cause != null) {
			logger.error("Exception during instantiation", cause);
		}

		return new InstantiationException(
				String.format(errorMessageFormat, className));
	}
}
