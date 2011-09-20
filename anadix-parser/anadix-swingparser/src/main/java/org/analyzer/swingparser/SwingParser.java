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
package org.analyzer.swingparser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.text.html.parser.ParserDelegator;

import org.analyzer.ElementFactory;
import org.analyzer.Parser;
import org.analyzer.Source;
import org.analyzer.exceptions.ParserException;
import org.analyzer.html.HTMLElementFactory;
import org.analyzer.utils.DroolsResource;
import org.apache.log4j.Logger;
import org.drools.builder.ResourceType;
import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.drools.decisiontable.InputType;
import org.drools.io.ResourceFactory;


public class SwingParser implements Parser {
	private static final Logger logger = Logger.getLogger(SwingParser.class);

	private final ParserDelegator parser;
	private HTMLElementFactory factory;

	public SwingParser() {
		parser = new ParserDelegator();
	}

	public void parse(Source source) throws ParserException {
		if (factory != null) {
			try {
				parser.parse(source.getReader(), new StatefulParserCallback(factory, source.getText()), true);
			} catch (IOException e) {
				logger.fatal("Exception during parsing", e);
				throw new ParserException("Unable to parse source", e);
			}
		} else {
			logger.fatal("Factory '" + getElementFactoryClass().getName() + "' is uninitialised!");
			throw new RuntimeException("Uninitialised factory");
		}
	}

	public Collection<DroolsResource> getDroolsResources() {
		Collection<DroolsResource> result = new ArrayList<DroolsResource>();

		ExternalSpreadsheetCompiler compiler = new ExternalSpreadsheetCompiler();
		// FIXME unclosed streams!
		InputStream csvStream = SwingParser.class.getResourceAsStream("tags.csv");
		InputStream templateStream = SwingParser.class.getResourceAsStream("rule-template.drt");

		String generated = compiler.compile(csvStream, templateStream, InputType.CSV, 2, 1);
		logger.debug(generated);

		// add expanded template
		result.add(new DroolsResource(
				ResourceFactory.newReaderResource(new StringReader(generated)),
				ResourceType.DRL));

		// add common rules - to insert <html>
		result.add(new DroolsResource(
				ResourceFactory.newInputStreamResource(SwingParser.class.getResourceAsStream("swingparser.drl")),
				ResourceType.DRL));

		return result;
	}

	public Class<? extends ElementFactory> getElementFactoryClass() {
		return HTMLElementFactory.class;
	}

	public void setElementFactory(ElementFactory factory) {
		if (getElementFactoryClass().isAssignableFrom(factory.getClass())) {
			this.factory = (HTMLElementFactory)factory;
			this.factory.setAsGlobal("elementFactory");
		} else {
			logger.fatal(String.format("Wrong element factory given: expected '%s' and got '%s'",
					getElementFactoryClass().getName(), factory.getClass().getName()));
			throw new RuntimeException("Can't assign " + factory.getClass() + " to " + getClass());
		}
	}
}
