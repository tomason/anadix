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
import org.drools.builder.ResourceType;
import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.drools.decisiontable.InputType;
import org.drools.io.ResourceFactory;


public class SwingParser implements Parser {
	private final ParserDelegator parser;
	private HTMLElementFactory factory;

	public SwingParser() {
		parser = new ParserDelegator();
	}

	@Override
	public void parse(Source source) throws ParserException {
		if (factory != null) {
			try {
				parser.parse(source.getReader(), new StatefulParserCallback(factory, source.getText()), true);
			} catch (IOException e) {
				throw new ParserException("Unable to parse source", e);
			}
		} else {
			throw new RuntimeException("Uninitialised factory");
		}
	}

	@Override
	public Collection<DroolsResource> getDroolsResources() {
		Collection<DroolsResource> result = new ArrayList<DroolsResource>();

		ExternalSpreadsheetCompiler compiler = new ExternalSpreadsheetCompiler();
		InputStream csvStream = getClass().getResourceAsStream("tags.csv");
		InputStream templateStream = getClass().getResourceAsStream("rule-template.drt");

		String generated = compiler.compile(csvStream, templateStream, InputType.CSV, 2, 1);
		/*
		DecisionTableConfiguration conf = KnowledgeBuilderFactory.newDecisionTableConfiguration();
		conf.setInputType(DecisionTableInputType.XLS);
		 */

		if (Boolean.getBoolean("debug")) {
			/*
			System.out.println(DecisionTableFactory.loadFromInputStream(
					getClass().getResourceAsStream("HtmlTagDT.xls"),
					conf));
			 */
			System.out.println(generated);
		}


		// add expanded template
		result.add(new DroolsResource(
				ResourceFactory.newReaderResource(new StringReader(generated)),
				ResourceType.DRL));
		/*
		// add decision table?
		result.add(new DroolsResource(
				ResourceFactory.newClassPathResource("org/jboss/qa/analyzer/swingparser/HtmlTagDT.xls"),
				ResourceType.DTABLE, conf));

		 */
		// add common things
		result.add(new DroolsResource(
				ResourceFactory.newClassPathResource("org/analyzer/swingparser/swingparser.drl"),
				ResourceType.DRL));

		return result;
	}

	@Override
	public Class<HTMLElementFactory> getElementFactoryClass() {
		return HTMLElementFactory.class;
	}

	@Override
	public <T extends ElementFactory> void setElementFactory(T factory) {
		if (getElementFactoryClass().isAssignableFrom(factory.getClass())) {
			this.factory = (HTMLElementFactory)factory;
			this.factory.setAsGlobal("elementFactory");
		} else {
			throw new RuntimeException("Can't assign " + factory.getClass() + " to " + getClass());
		}
	}
}
