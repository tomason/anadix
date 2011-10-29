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
package org.anadix.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.anadix.ConditionSet;
import org.anadix.ElementFactory;
import org.anadix.Parser;
import org.anadix.utils.DroolsResource;

public class MockConditionSet extends Mock implements ConditionSet {
	public String getName() {
		methodInvoked(new Invocation("getName"));

		return "";
	}

	public Collection<DroolsResource> getDroolsResources() {
		methodInvoked(new Invocation("getDroolsResources"));

		return new ArrayList<DroolsResource>();
	}

	public Class<? extends ElementFactory> getElementFactoryClass() {
		methodInvoked(new Invocation("getElementFactoryClass"));

		return MockElementFactory.class;
	}

	public Class<? extends Parser> getDefaultParser() {
		methodInvoked(new Invocation("getDefaultParser"));

		return MockParser.class;
	}
}
