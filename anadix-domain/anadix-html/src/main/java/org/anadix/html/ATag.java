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


/**
 * http://www.w3.org/TR/1999/REC-html401-19991224/struct/links.html#edef-A
 * 
 * @author tomason
 */
public class ATag extends CommonAttributes {

	public ATag(BigInteger id, String name, HtmlElement parent,
			Attributes attributes) {
		super(id, name, parent, attributes);
	}

	/**
	 * This attribute specifies the character encoding of the resource
	 * designated by the link. Please consult the section on character encodings
	 * for more details.
	 */
	public String getCharset() {
		return getAttribute("charset");
	}

	/**
	 * This attribute gives an advisory hint as to the content type of the
	 * content available at the link target address. It allows user agents to
	 * opt to use a fallback mechanism rather than fetch the content if they are
	 * advised that they will get content in a content type they do not support.
	 * Authors who use this attribute take responsibility to manage the risk
	 * that it may become inconsistent with the content available at the link
	 * target address.
	 */
	public String getType() {
		return getAttribute("type");
	}

	/**
	 * This attribute names the current anchor so that it may be the destination
	 * of another link. The value of this attribute must be a unique anchor
	 * name. The scope of this name is the current document. Note that this
	 * attribute shares the same name space as the id attribute.
	 */
	public String getNameAttribute() {
		return getAttribute("name");
	}

	/**
	 * This attribute specifies the location of a Web resource, thus defining a
	 * link between the current element (the source anchor) and the destination
	 * anchor defined by this attribute.
	 */
	public String getHref() {
		return getAttribute("href");
	}

	/**
	 * This attribute specifies the base language of the resource designated by
	 * href and may only be used when href is specified.
	 */
	public String getHreflang() {
		return getAttribute("hreflang");
	}

	public String getTarget() {
		return getAttribute("target");
	}

	/**
	 * This attribute describes the relationship from the current document to
	 * the anchor specified by the href attribute. The value of this attribute
	 * is a space-separated list of link types.
	 */
	public String getRel() {
		return getAttribute("rel");
	}

	/**
	 * This attribute is used to describe a reverse link from the anchor
	 * specified by the href attribute to the current document. The value of
	 * this attribute is a space-separated list of link types.
	 */
	public String getRev() {
		return getAttribute("rev");
	}

	/**
	 * This attribute assigns an access key to an element. An access key is a
	 * single character from the document character set. Note. Authors should
	 * consider the input method of the expected reader when specifying an
	 * accesskey.
	 */
	public String getAccesskey() {
		return getAttribute("accesskey");
	}

	/**
	 * This attribute specifies the shape of a region. Possible values:
	 * 
	 * default: Specifies the entire region.
	 * rect: Define a rectangular region.
	 * circle: Define a circular region.
	 * poly: Define a polygonal region.
	 */
	public String getShape() {
		return getAttribute("shape");
	}

	/**
	 * This attribute specifies the position and shape on the screen. The number
	 * and order of values depends on the shape being defined. Possible
	 * combinations:
	 * 
	 * rect: left-x, top-y, right-x, bottom-y. circle: center-x, center-y,
	 * radius. Note. When the radius value is a percentage value, user agents
	 * should calculate the final radius value based on the associated object's
	 * width and height. The radius should be the smaller value of the two.
	 * poly: x1, y1, x2, y2, ..., xN, yN. The first x and y coordinate pair and
	 * the last should be the same to close the polygon. When these coordinate
	 * values are not the same, user agents should infer an additional
	 * coordinate pair to close the polygon.
	 * 
	 * Coordinates are relative to the top, left corner of the object. All
	 * values are lengths. All values are separated by commas.
	 */
	public String getCoords() {
		return getAttribute("coords");
	}

	/**
	 * This attribute specifies the position of the current element in the
	 * tabbing order for the current document. This value must be a number
	 * between 0 and 32767. User agents should ignore leading zeros.
	 */
	public int getTabindex() {
		String value = getAttribute("tabindex");

		return value == null ? -1 : Integer.parseInt(value);
	}

	/**
	 * The onfocus event occurs when an element receives focus either by the
	 * pointing device or by tabbing navigation.
	 */
	public String getOnfocus() {
		return getAttribute("onfocus");
	}

	/**
	 * The onblur event occurs when an element loses focus either by the
	 * pointing device or by tabbing navigation. It may be used with the same
	 * elements as onfocus.
	 */
	public String getOnblur() {
		return getAttribute("onblur");
	}
}
