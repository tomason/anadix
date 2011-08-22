package org.analyzer.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.analyzer.Element;
import org.analyzer.ElementFactory;
import org.drools.runtime.ClassObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;


public abstract class AbstractElementFactory implements ElementFactory {
	private final StatefulKnowledgeSession ksession;

	public static <T extends ElementFactory> T createFactory(Class<T> clazz, StatefulKnowledgeSession session) {
		try {
			return clazz.getConstructor(StatefulKnowledgeSession.class).newInstance(session);
		} catch (Exception ex) {
			throw new RuntimeException("Unable to instantiate ElementFactory", ex);
		}
	}

	protected AbstractElementFactory(StatefulKnowledgeSession ksession) {
		if (ksession == null) {
			throw new NullPointerException("ksession can't be null");
		}

		this.ksession = ksession;
	}

	protected StatefulKnowledgeSession getSession() {
		return ksession;
	}

	public void insertElement(Element element) {
		getSession().insert(element);
	}

	public Collection<Element> getElements() {
		Collection<Element> result = new ArrayList<Element>();

		for (Object o : getSession().getObjects(new ClassObjectFilter(Element.class))) {
			result.add( (Element)o );
		}

		return result;
	}

	protected void setGlobal(String name, Object instance) {
		getSession().setGlobal(name, instance);
	}

	public void setAsGlobal(String name) {
		setGlobal(name, this);
	}

	public void insertEvent(String entrypoint, Object event) {
		WorkingMemoryEntryPoint ep = getSession().getWorkingMemoryEntryPoint(entrypoint);
		if (ep != null) {
			ep.insert(event);
		} else {
			throw new IllegalArgumentException("Entry point " + entrypoint + " is not defined");
		}

	}
}
