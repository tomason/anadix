package org.analyzer.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public abstract class PropertiesUtils {
	private static final Properties properties;

	static {
		properties = new Properties(System.getProperties());
		properties.putAll(System.getenv());

		if (properties.containsKey("analyzer.properties")) {
			File props = new File(properties.getProperty("analyzer.properties"));
			try {
				properties.load(new FileReader(props));
			} catch (Exception e) {
				System.err.println("Unable to load file specified by 'analyzer.properties': " + props);
			}
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}
}
