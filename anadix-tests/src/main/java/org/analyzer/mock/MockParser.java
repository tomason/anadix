package org.analyzer.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.analyzer.ElementFactory;
import org.analyzer.Parser;
import org.analyzer.Source;
import org.analyzer.exceptions.ParserException;
import org.analyzer.utils.DroolsResource;

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
