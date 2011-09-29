package org.anadix.impl;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.io.StringReader;
import java.util.Arrays;

import org.anadix.ConditionSet;
import org.anadix.ElementFactory;
import org.anadix.Parser;
import org.anadix.Source;
import org.anadix.exceptions.ParserException;
import org.anadix.factories.SourceFactory;
import org.anadix.utils.DroolsResource;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnalyzerImplTest {
	private Parser p;
	private ConditionSet c;
	private Source s;
	private ElementFactory ef;

	@BeforeMethod(alwaysRun = true)
	public void prepareMocks() {
		p = mock(Parser.class);
		c = mock(ConditionSet.class);
		s = mock(Source.class);
		ef = mock(AbstractElementFactory.class);

		when(p.getElementFactoryClass()).thenAnswer(new ElementFactoryAnswer(ef));
		when(c.getElementFactoryClass()).thenAnswer(new ElementFactoryAnswer(ef));
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void testConstructor1() {
		new AnalyzerImpl(null, null);
	}
	@Test(expectedExceptions = { NullPointerException.class })
	public void testConstructor2() {
		new AnalyzerImpl(null, c);
	}
	@Test(expectedExceptions = { NullPointerException.class })
	public void testConstructor3() {
		new AnalyzerImpl(p, null);
	}

	@Test(expectedExceptions = { IllegalStateException.class })
	public void testConstructor4() {
		Parser parser = mock(Parser.class);
		ConditionSet conditions = mock(ConditionSet.class);

		ElementFactory ef1 = mock(AbstractElementFactory.class);
		ElementFactory ef2 = mock(ElementFactory.class);

		when(parser.getElementFactoryClass()).thenAnswer(new ElementFactoryAnswer(ef1));
		when(conditions.getElementFactoryClass()).thenAnswer(new ElementFactoryAnswer(ef2));

		new AnalyzerImpl(parser, conditions);
	}

	@Test
	public void testConstructor5() {
		new AnalyzerImpl(p, c);
	}

	@Test(expectedExceptions = { RuntimeException.class })
	public void testAnalyze1() throws Exception {
		Parser parser = mock(Parser.class);
		ConditionSet conditions = mock(ConditionSet.class);
		ElementFactory ef = mock(ElementFactory.class);

		when(parser.getElementFactoryClass()).thenAnswer(new ElementFactoryAnswer(ef));
		when(conditions.getElementFactoryClass()).thenAnswer(new ElementFactoryAnswer(ef));

		AnalyzerImpl analyzer = new AnalyzerImpl(parser, conditions);
		analyzer.analyze(s);

		verify(parser).setElementFactory(ef);
		verify(parser).parse(s);
	}

	@Test
	public void testAnalyze2() throws Exception {
		AnalyzerImpl a = new AnalyzerImpl(p, c);

		try {
			a.analyze(null);
			fail("analyzed null source");
		} catch (NullPointerException ex) {
			//ok
		}

		assertNotNull(a.analyze(SourceFactory.newStringSource("")));
		assertNotNull(a.analyze(s));

		verify(p).parse(s);
	}

	@Test
	public void testAnalyze3() throws Exception {
		doThrow(new ParserException()).when(p).parse(s);

		AnalyzerImpl a = new AnalyzerImpl(p, c);
		a.analyze(s);
	}

	@Test
	public void testCreateKnowledgeBuilder1() {
		when(p.getDroolsResources()).thenReturn(null);
		when(c.getDroolsResources()).thenReturn(null);

		new AnalyzerImpl(p, c);
	}

	@Test
	public void testCreateKnowledgeBuilder2() {
		DroolsResource dr1 = mock(DroolsResource.class);
		DroolsResource dr2 = mock(DroolsResource.class);
		DroolsResource dr3 = mock(DroolsResource.class);

		when(p.getDroolsResources()).thenReturn(Arrays.asList(dr1, dr2));
		when(c.getDroolsResources()).thenReturn(Arrays.asList(dr3));

		new AnalyzerImpl(p, c);

		verify(dr1).insertInto(any(KnowledgeBuilder.class));
		verify(dr2).insertInto(any(KnowledgeBuilder.class));
		verify(dr3).insertInto(any(KnowledgeBuilder.class));
	}

	@Test(expectedExceptions = { RuntimeException.class })
	public void testCreateKnowledgeBuilder3() {
		String drl = "package org.sample\nrule nonsense\nwhen\nn : Nonsense( )\nthen\nend\n";
		DroolsResource resource = new DroolsResource(ResourceFactory.newReaderResource(new StringReader(drl)), ResourceType.DRL);

		when(p.getDroolsResources()).thenReturn(Arrays.asList(resource));

		new AnalyzerImpl(p, c);
	}

	@Test(expectedExceptions = { RuntimeException.class })
	public void testCreateKnowledgeBuilder4() {
		String drl = "package org.sample\nrule nonsense\nwhen\nn : Nonsense( )\nthen\nend\n";
		DroolsResource resource = new DroolsResource(ResourceFactory.newReaderResource(new StringReader(drl)), ResourceType.DRL);

		when(c.getDroolsResources()).thenReturn(Arrays.asList(resource));

		new AnalyzerImpl(p, c);
	}

	public static class ElementFactoryAnswer implements Answer<Object> {
		private final ElementFactory ef;

		public ElementFactoryAnswer(ElementFactory ef) {
			this.ef = ef;
		}

		public Object answer(InvocationOnMock invocation) throws Throwable {
			return ef.getClass();
		}
	}
}
