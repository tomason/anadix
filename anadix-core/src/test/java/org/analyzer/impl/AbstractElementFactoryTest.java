package org.analyzer.impl;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.analyzer.Analyzer;
import org.analyzer.Element;
import org.analyzer.ElementFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AbstractElementFactoryTest {
	private ElementFactory ef;
	private StatefulKnowledgeSession ksession;

	@Test(groups = { "constructor" })
	public void AbstractElementFactory() {
		new AbstractElementFactory(mock(StatefulKnowledgeSession.class)) {};

		try {
			new AbstractElementFactory(null) {};
			fail("Accepted null ksession");
		} catch (NullPointerException ex) {
			// ok
		}
	}

	@Test(groups = { "constructor" })
	public void createFactory() {
		Class<? extends ElementFactory> cls = mock(AbstractElementFactory.class).getClass();

		try {
			AbstractElementFactory.createFactory(cls, null);
			fail("accepted null session");
		} catch (NullPointerException ex) {
			//ok
		}

		try {
			AbstractElementFactory.createFactory(null, ksession);
			fail("accepted null class");
		} catch (NullPointerException ex) {
			//ok
		}

		AbstractElementFactory.createFactory(cls, ksession);
	}

	@BeforeMethod(dependsOnGroups = { "constructor" })
	public void prepareMocks() {
		//ElementFactory ef = mock(AbstractElementFactory.class);
		Class<? extends ElementFactory> cls = mock(AbstractElementFactory.class).getClass();
		ksession = mock(StatefulKnowledgeSession.class);

		ef = AbstractElementFactory.createFactory(cls, ksession);
	}

	@Test(dependsOnGroups = { "constructor" })
	public void getElements() {
		Element e1 = mock(Element.class);
		Element e2 = mock(Element.class);
		when(ksession.getObjects()).thenReturn(Arrays.asList(e1, e2, new Object()));

		Collection<Element> elements = ef.getElements();
		assertNotNull(elements);
		assertEquals(elements.size(), 2);
		assertTrue(elements.contains(e1));
		assertTrue(elements.contains(e2));
	}

	@Test(dependsOnGroups = { "constructor" })
	public void insertElement() {
		Element e = mock(Element.class);
		ef.insertElement(e);

		verify(ksession).insert(e);
	}

	@Test(dependsOnGroups = { "constructor" })
	public void insertEvent() {
		String entryPoint = "test";
		Object event = mock(Element.class);
		WorkingMemoryEntryPoint ep = mock(WorkingMemoryEntryPoint.class);

		when(ksession.getWorkingMemoryEntryPoint(entryPoint)).thenReturn(ep);

		try {
			ef.insertEvent(null, null);
			fail("accepted null entrypoint and event");
		} catch (NullPointerException ex) {
			//ok
		}

		try {
			ef.insertEvent(entryPoint, null);
			fail("accepted null event");
		} catch (NullPointerException ex) {
			//ok
		}

		try {
			ef.insertEvent(null, event);
			fail("accepted null entrypoint");
		} catch (NullPointerException ex) {
			//ok
		}

		try {
			ef.insertEvent("nonsense entry point", event);
			fail("accepted null nonexisting entrypoint");
		} catch (IllegalArgumentException ex) {
			//ok
		}

		ef.insertEvent(entryPoint, event);

		verify(ksession).getWorkingMemoryEntryPoint(entryPoint);
		verify(ep).insert(event);
	}

	@Test(dependsOnGroups = { "constructor" })
	public void setAsGlobal() {
		String identifier = "global";
		try {
			ef.setAsGlobal(null);
			fail("accepted null identifier");
		} catch (NullPointerException ex) {
			//ok
		}

		ef.setAsGlobal(identifier);

		verify(ksession).setGlobal(identifier, ef);
	}

	@Test(dependsOnGroups = { "constructor" })
	public void setGlobal() {
		String identifier = "global";
		Object global = mock(Analyzer.class);

		try {
			ef.setGlobal(null, null);
			fail("accepted null identifier and instance");
		} catch (NullPointerException ex) {
			//ok
		}
		try {
			ef.setGlobal(identifier, null);
			fail("accepted null instance");
		} catch (NullPointerException ex) {
			//ok
		}
		try {
			ef.setGlobal(null, global);
			fail("accepted null identifier");
		} catch (NullPointerException ex) {
			//ok
		}

		ef.setGlobal(identifier, global);

		verify(ksession).setGlobal(identifier, global);
	}
}
