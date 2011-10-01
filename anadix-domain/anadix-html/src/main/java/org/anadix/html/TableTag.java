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

public class TableTag extends CommonAttributes {

	TableTag(BigInteger id, HtmlElement parent, Attributes attributes) {
		super(id, "table", parent, attributes);
	}

	public String getSummary() {
		return getAttribute("summary");
	}

	public String getWidth() {
		return getAttribute("width");
	}

	public String getBorder() {
		return getAttribute("border");
	}

	public String getFrame() {
		return getAttribute("frame");
	}

	public String getRules() {
		return getAttribute("rules");
	}

	public String getCellspacing() {
		return getAttribute("cellspacing");
	}

	public String getCellpadding() {
		return getAttribute("cellpadding");
	}

	public String getAlign() {
		return getAttribute("align");
	}

	public String getBgcolor() {
		return getAttribute("bgcolor");
	}

	public String getDatapagesize() {
		return getAttribute("datapagesize");
	}

}
