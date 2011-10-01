package org.anadix.html;

import java.math.BigInteger;

/**
 * %coreattrs
 * 
 * @author tomason
 */
public abstract class CoreAttributes extends HtmlElement {

	public CoreAttributes(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	/**
	 * This attribute assigns a name to an element. This name must be unique in
	 * a document.
	 */
	public String getIdAttribute() {
		return getAttribute("id");
	}

	/**
	 * This attribute assigns a class name or set of class names to an element.
	 * Any number of elements may be assigned the same class name or names.
	 * Multiple class names must be separated by white space characters.
	 */
	public String getClassAttribute() {
		return getAttribute("class");
	}

	/**
	 * This attribute specifies style information for the current element.
	 */
	public String getStyle() {
		return getAttribute("style");
	}

	/**
	 * This attribute offers advisory information about the element for which it
	 * is set.
	 */
	public String getTitle() {
		return getAttribute("title");
	}
}
