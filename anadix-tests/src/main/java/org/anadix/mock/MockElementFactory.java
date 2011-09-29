package org.anadix.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.anadix.Element;
import org.anadix.ElementFactory;


public class MockElementFactory extends Mock implements ElementFactory {
	public Collection<Element> getElements() {
		methodInvoked(new Invocation("getElements"));

		return new ArrayList<Element>();
	}

	public void setGlobal(String name, Object instance) {
		methodInvoked(new Invocation("setGlobal", name, instance));

	}

	public void setAsGlobal(String name) {
		methodInvoked(new Invocation("setAsGlobal", name));
	}

	public void insertElement(Element element) {
		methodInvoked(new Invocation("insertElement", element));
	}

	public void insertEvent(String entrypoint, Object event) {
		methodInvoked(new Invocation("insertEvent", entrypoint, event));
	}

}
