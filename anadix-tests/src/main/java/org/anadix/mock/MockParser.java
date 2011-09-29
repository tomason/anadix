package org.anadix.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.anadix.ElementFactory;
import org.anadix.Parser;
import org.anadix.Source;
import org.anadix.exceptions.ParserException;
import org.anadix.utils.DroolsResource;

public class MockParser extends Mock implements Parser {
	public void parse(Source source) throws ParserException {
		methodInvoked(new Invocation("parse", source));

		if (doThrow()) {
			throw new ParserException();
		}
	}

	public Collection<DroolsResource> getDroolsResources() {
		methodInvoked(new Invocation("getDroolsResources"));

		return new ArrayList<DroolsResource>();
	}

	public Class<? extends ElementFactory> getElementFactoryClass() {
		return MockElementFactory.class;
	}

	public void setElementFactory(ElementFactory factory) {
		methodInvoked(new Invocation("setElementFactory", factory));
	}
}
