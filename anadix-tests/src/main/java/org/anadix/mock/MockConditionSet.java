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
