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

import java.math.BigInteger;

import org.anadix.Element;

/**
 * Abstract class representing any HTML element. It has generic method to retrieve element's
 * attribute by name. It also stores id of an element, name of the tag it represents and
 * parent element. The optional attributes are position of the element in document, source
 * and text content.
 * The mandatory attributes are unmodifiable as they define the element. The optional ones
 * ones can be assigned and changed as necessary. The only constructor is package protected
 * as instances of HTML element should only be created through {@link HTMLElementFactory}.
 *
 * @author tomason
 * @version $Id: $
 */
public abstract class HtmlElement implements Element, Comparable<HtmlElement> {
	private final BigInteger id;
	private final String name;
	private final HtmlElement parent;
	private final Attributes attributes;

	private Position position;
	private String source;
	private String textContent;

	HtmlElement(
			BigInteger id,
			String name,
			HtmlElement parent,
			Attributes attributes) {
		this(id, name, parent, attributes, null, null, null);
	}

	private HtmlElement(
			BigInteger id,
			String name,
			HtmlElement parent,
			Attributes attributes,
			String source,
			Position position,
			String textContent) {
		if (id == null) {
			throw new NullPointerException("id can't be null");
		}
		if (name == null || name.length() < 1) {
			throw new NullPointerException("name can't be null");
		}
		if (attributes == null) {
			throw new NullPointerException("atributes can't be null");
		}

		this.id = id;
		this.name = name;
		this.parent = parent;
		this.attributes = attributes;

		this.source = source;
		this.position = position;
		this.textContent = textContent;
	}

	/**
	 * Gets the id of the element (not the attribute id but the id as assigned by pasrser)
	 *
	 * @return id of the element
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Gets the name of the element (not the attribute name but the name of the tag)
	 *
	 * @return name of the element
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the parent of the element
	 *
	 * @return enclosing HtmlElement
	 */
	public HtmlElement getParent() {
		return parent;
	}


	/**
	 * Gets the list of attributes of the element
	 *
	 * @return list of attributes of the element
	 */
	public Attributes getAttributes() {
		return attributes;
	}


	/**
	 * Gets value of attribute by name
	 *
	 * @param name attribute which value should be returned
	 * @return value of requested attribute or null if attribute is not set
	 */
	public String getAttribute(String name) {
		return getAttributes().getAttribute(name);
	}


	/**
	 * Sets the source of the element
	 *
	 * @param source source of the element
	 */
	public void setSource(String source) {
		if (source == null || source.length() == 0) {
			throw new NullPointerException("source can't be null");
		}
		this.source = source;
	}

	/**
	 * Gets the source of the element
	 *
	 * @return source of the element
	 */
	public String getSource() {
		return source;
	}


	/**
	 * Sets the position of the element
	 *
	 * @param position position of the element
	 */
	public void setPosition(Position position) {
		if (position == null) {
			throw new NullPointerException("position can't be null");
		}
		this.position = position;
	}

	/**
	 * Gets the position of the element
	 *
	 * @return position of the element
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Gets the text content of the element
	 *
	 * @return text content of the element
	 */
	public String getTextContent() {
		return textContent;
	}

	/**
	 * Sets the text content of the element
	 *
	 * @param textContent text content of the element
	 */
	public void setTextContent(String textContent) {
		if (textContent == null || textContent.length() == 0) {
			throw new NullPointerException("text content can't be null");
		}

		this.textContent = textContent;
	}

	/**
	 * Compares this object with the specified object for order.
	 *
	 * @param o HtmlElement to compare this with
	 * @return negative integer if this object is less than, zero if this object is equal
	 * to, or a positive integer if this object is greater than the specified object
	 */
	public int compareTo(HtmlElement o) {
		return getId().compareTo(o.getId());
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		HtmlElement other = (HtmlElement) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return String.format("%s[id='%s', position='%s', attributes='%s', source='%s']",
				name, id, position, attributes, source);
	}
}
