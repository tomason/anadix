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
package org.anadix.html;

import java.util.Collection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		this.attributes = new Properties();

		for (String key : attributes.stringPropertyNames()) {
			this.attributes.setProperty(key, attributes.getProperty(key));
		}

		if (hasAttribute("style")) {
			Properties style = parseStyle(getAttribute("style"));
			for (String key : style.stringPropertyNames()) {
				this.attributes.setProperty(key, style.getProperty(key));
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
		return attributes.containsKey(key);
	}

	public Collection<String> getAvaliableAttributes() {
		return attributes.stringPropertyNames();
	}

	public static Properties parseStyle(String style) {
		Properties result = new Properties();

		style = style.replace("\r", "").replace("\n", "").replace("\t", "");
		Pattern p = Pattern.compile("[^:;]+:([^;\"]|\"[^\"]+\")*;?");
		Matcher m = p.matcher(style);

		while (m.find()) {
			String prop = m.group().trim();
			if (prop.endsWith(";")) {
				prop = prop.substring(0, prop.length() - 1);
			}

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

