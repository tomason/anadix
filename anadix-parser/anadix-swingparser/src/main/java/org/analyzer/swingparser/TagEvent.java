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
package org.analyzer.swingparser;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Properties;


public abstract class TagEvent implements Serializable {
	private static final long serialVersionUID = -2820923796385117574L;

	private final BigInteger id;
	private final String tagName;
	private final Properties attributes;
	private final int position;
	private final String source;

	public TagEvent(BigInteger id, String tagName, Properties attributes, int position) {
		this(id, tagName, attributes, position, null);
	}

	public TagEvent(BigInteger id, String tagName, Properties attributes, int position, String source) {
		if (id == null) {
			throw new NullPointerException("id can't be null");
		}
		if (tagName == null || tagName.length() == 0) {
			throw new NullPointerException("tagName can't be null");
		}
		if (attributes == null) {
			throw new NullPointerException("attributes can't be null");
		}
		if (position < 0) {
			throw new IllegalArgumentException("position must be greater than or equal to 0");
		}
		this.id = id;
		this.tagName = tagName.toLowerCase();
		this.attributes = attributes;
		this.position = position;
		this.source = source;
	}

	public BigInteger getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public Properties getAttributes() {
		return attributes;
	}

	public int getPosition() {
		return position;
	}

	public String getSource() {
		return source;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TagEvent other = (TagEvent) obj;
		return id.equals(other.getId());
	}

	@Override
	public String toString() {
		return String.format(
				"%s[ID='%s', tagName='%s', position='%s', properties='%s']",
				getClass().getName(),
				getId(),
				getTagName(),
				getPosition(),
				getAttributes()
				);
	}
}
