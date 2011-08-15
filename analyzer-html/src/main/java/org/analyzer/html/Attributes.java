package org.analyzer.html;

import java.util.Collection;
import java.util.Properties;

/**
 * Class representing set of element's attributes. Contains both the attributes
 * contained in tag and contained in style.
 * 
 * @author tomason
 *
 */
public class Attributes {
	private final Properties attributes;

	public Attributes(Properties attributes) {
		if (attributes == null) {
			throw new NullPointerException("attributes can't be null");
		}
		this.attributes =  new Properties(attributes);

		if (hasAttribute("style")) {
			Properties style = parseStyle(getAttribute("style"));
			for (String key : style.stringPropertyNames()) {
				attributes.setProperty(key, style.getProperty(key));
			}
		}
	}

	public String getAttribute(String key) {
		return attributes.getProperty(key);
	}

	public String getAttribute(String key, String defaultValue) {
		return attributes.getProperty(key, defaultValue);
	}

	public boolean hasAttribute(String key) {
		return attributes.contains(key);
	}

	public Collection<String> getAvaliableAttributes() {
		return attributes.stringPropertyNames();
	}

	public static Properties parseStyle(String style) {
		Properties result = new Properties();

		String[] props = style.split(";");

		for (String prop : props) {
			String[] split = prop.split(":");

			result.setProperty(split[0].trim(), split[1].trim());
		}

		return result;
	}

	@Override
	public String toString() {
		return attributes.toString();
	}
}

