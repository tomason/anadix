package org.analyzer.impl;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import org.analyzer.ConditionSet;
import org.analyzer.ElementFactory;
import org.analyzer.Parser;
import org.analyzer.Report;
import org.analyzer.Source;
import org.analyzer.factories.SourceFactory;
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

		Answer<?> a = new Answer() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				return ef.getClass();
			}
		};

		when(p.getElementFactoryClass()).thenAnswer(a);
		when(c.getElementFactoryUsed()).thenAnswer(a);
	}

	@Test
	public void AnalyzerImpl() {
		try {
			new AnalyzerImpl(null, null);
			fail("Accepted null Parser and ConditionSet");
		} catch (NullPointerException ex) {
			//ok
		}
		try {
			new AnalyzerImpl(null, c);
			fail("Accepted null Parser");
		} catch (NullPointerException ex) {
			//ok
		}
		try {
			new AnalyzerImpl(p, null);
			fail("Accepted null ConditionSet");
		} catch (NullPointerException ex) {
			//ok
		}

		new AnalyzerImpl(p, c);
	}

	@Test
	public void analyze() throws Exception {
		AnalyzerImpl a = new AnalyzerImpl(p, c);

		Report r;

		try {
			a.analyze(null);
			fail("analyzed null source");
		} catch (NullPointerException ex) {
			//ok
		}

		assertNotNull(r = a.analyze(SourceFactory.newStringSource("")));
		System.out.println(r);

		assertNotNull(r = a.analyze(s));
		System.out.println(r);

		verify(p).parse(s);
	}
}
