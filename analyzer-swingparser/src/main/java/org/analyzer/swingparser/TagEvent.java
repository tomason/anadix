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
