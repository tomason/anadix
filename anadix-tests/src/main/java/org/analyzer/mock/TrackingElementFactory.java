package org.analyzer.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.analyzer.Element;
import org.analyzer.html.HTMLElementFactory;
import org.analyzer.html.HtmlElement;
import org.drools.runtime.StatefulKnowledgeSession;

public class TrackingElementFactory extends HTMLElementFactory {
	private final List<Element> elements = new ArrayList<Element>();
	private final Map<String, List<Object>> events = new HashMap<String, List<Object>>();

	public TrackingElementFactory() {
		super(org.mockito.Mockito.mock(StatefulKnowledgeSession.class));
	}

	@Override
	public void insertElement(Element element) {
		elements.add(element);
	}

	@Override
	public void insertElement(HtmlElement element) {
		elements.add(element);
	}

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

	@Override
	public Collection<Element> getElements() {
		return Collections.unmodifiableCollection(elements);
	}

	public Collection<Object> getEvents(String entrypoint) {
		Collection<Object> result = events.get(entrypoint);
		return result == null ? null : Collections.unmodifiableCollection(result);
	}

	@Override
	public void setGlobal(String name, Object instance) {
		// no need
	}

	@Override
	public void setAsGlobal(String name) {
		// no need
	}
}
