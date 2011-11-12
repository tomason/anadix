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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anadix.Element;
import org.anadix.html.HTMLElementFactory;
import org.anadix.html.HtmlElement;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * <p>TrackingElementFactory class.</p>
 *
 * @author tomason
 * @version $Id: $
 */
public class TrackingElementFactory extends HTMLElementFactory {
	private final List<Element> elements = new ArrayList<Element>();
	private final Map<String, List<Object>> events = new HashMap<String, List<Object>>();

	/**
	 * <p>Constructor for TrackingElementFactory.</p>
	 */
	public TrackingElementFactory() {
		super(org.mockito.Mockito.mock(StatefulKnowledgeSession.class));
	}

	/** {@inheritDoc} */
	@Override
	public void insertElement(Element element) {
		elements.add(element);
	}

	/** {@inheritDoc} */
	@Override
	public void insertElement(HtmlElement element) {
		elements.add(element);
	}

	/** {@inheritDoc} */
	@Override
	public void insertEvent(String entrypoint, Object event) {
		List<Object> entrypointList = events.get(entrypoint);
		if (entrypointList != null) {
			entrypointList.add(event);
		} else {
			entrypointList = new ArrayList<Object>();
			entrypointList.add(event);
			events.put(entrypoint, entrypointList);
		}
	}

	/** {@inheritDoc} */
	@Override
	public Collection<Element> getElements() {
		return Collections.unmodifiableCollection(elements);
	}

	/**
	 * Gets the collection of events inserted through this ElementFactory to specified entry point.
	 *
	 * @param entrypoint entry point name
	 * @return collection of events inserted
	 */
	public Collection<Object> getEvents(String entrypoint) {
		Collection<Object> result = events.get(entrypoint);
		return result == null ? null : Collections.unmodifiableCollection(result);
	}

	/** {@inheritDoc} */
	@Override
	public void setGlobal(String name, Object instance) {
		// no need
	}

	/** {@inheritDoc} */
	@Override
	public void setAsGlobal(String name) {
		// no need
	}
}
