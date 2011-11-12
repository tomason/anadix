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

import org.anadix.Element;
import org.anadix.ElementFactory;


/**
 * Mock implementation of ElementFactory
 *
 * @author tomason
 * @version $Id: $
 */
public class MockElementFactory extends Mock implements ElementFactory {
	/** {@inheritDoc} */
	public Collection<Element> getElements() {
		methodInvoked(new Invocation("getElements"));

		return new ArrayList<Element>();
	}

	/** {@inheritDoc} */
	public void setGlobal(String name, Object instance) {
		methodInvoked(new Invocation("setGlobal", name, instance));

	}

	/** {@inheritDoc} */
	public void setAsGlobal(String name) {
		methodInvoked(new Invocation("setAsGlobal", name));
	}

	/** {@inheritDoc} */
	public void insertElement(Element element) {
		methodInvoked(new Invocation("insertElement", element));
	}

	/** {@inheritDoc} */
	public void insertEvent(String entrypoint, Object event) {
		methodInvoked(new Invocation("insertEvent", entrypoint, event));
	}

}
