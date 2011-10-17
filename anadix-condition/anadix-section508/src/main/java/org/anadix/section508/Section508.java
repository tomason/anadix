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
package org.anadix.section508;

import java.util.ArrayList;
import java.util.Collection;

import org.anadix.ConditionSet;
import org.anadix.ElementFactory;
import org.anadix.Parser;
import org.anadix.html.HTMLElementFactory;
import org.anadix.swingparser.SwingParser;
import org.anadix.utils.DroolsResource;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;


public class Section508 implements ConditionSet {
	public String getName() {
		return "Section 508";
	}

	public Collection<DroolsResource> getDroolsResources() {
		Collection<DroolsResource> result = new ArrayList<DroolsResource>();

		String[] resources = new String[] {
				"commons.drl",
				"paragraph-a.drl",
				"paragraph-b.drl",
				"paragraph-c.drl",
				"paragraph-d.drl",
				"paragraph-e.drl",
				"paragraph-f.drl",
				"paragraph-g.drl",
				"paragraph-h.drl",
				"paragraph-i.drl",
				"paragraph-j.drl",
				"paragraph-k.drl",
				"paragraph-l.drl",
				"paragraph-m.drl",
				"paragraph-n.drl",
				"paragraph-o.drl",
				"paragraph-p.drl"
		};

		for (String resource : resources) {
			result.add(new DroolsResource(
					ResourceFactory.newClassPathResource(resource, getClass()),
					ResourceType.DRL));
		}


		return result;
	}

	public Class<? extends ElementFactory> getElementFactoryClass() {
		return HTMLElementFactory.class;
	}

	public Class<? extends Parser> getDefaultParser() {
		return SwingParser.class;
	}

	public String getRulesPackage() {
		return "org.anadix.section508";
	}
}
