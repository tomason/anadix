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
package org.anadix.swingparser;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Properties;

import org.anadix.html.Position;


/**
 * Abstract class for events from parser to the Drools engine
 *
 * @author tomason
 * @version $Id: $
 */
public abstract class TagEvent implements Serializable {
	private static final long serialVersionUID = -2820923796385117574L;

	private final BigInteger id;
	private final String tagName;
	private final Properties attributes;
	private final Position position;
	private final String source;

	/**
	 * Constructor
	 *
	 * @param id if of a tag
	 * @param tagName name of he tag
	 * @param attributes attributes of the tag
	 * @param position position in document
	 */
	public TagEvent(BigInteger id, String tagName, Properties attributes, Position position) {
		this(id, tagName, attributes, position, null);
	}

	/**
	 * Constructor
	 *
	 * @param id if of a tag
	 * @param tagName name of he tag
	 * @param attributes attributes of the tag
	 * @param position position in document
	 * @param source source code of the tag
	 */
	public TagEvent(BigInteger id, String tagName, Properties attributes, Position position, String source) {
		if (id == null) {
			throw new NullPointerException("id can't be null");
		}
		if (tagName == null || tagName.length() == 0) {
			throw new NullPointerException("tagName can't be null");
		}
		if (attributes == null) {
			throw new NullPointerException("attributes can't be null");
		}
		this.id = id;
		this.tagName = tagName.toLowerCase();
		this.attributes = attributes;
		this.position = position;
		this.source = source;
	}

	/**
	 * Gets the id of the tag
	 *
	 * @return id of the tag
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Gets the name of the tag
	 *
	 * @return name of the tag
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * Gets the attributes of the tag
	 *
	 * @return attributes of the tag
	 */
	public Properties getAttributes() {
		return attributes;
	}

	/**
	 * Gets the position of the tag
	 *
	 * @return position of the tag
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Gets the source code ot the tag
	 *
	 * @return source code of the tag
	 */
	public String getSource() {
		return source;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id.hashCode();
		return result;
	}

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
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
