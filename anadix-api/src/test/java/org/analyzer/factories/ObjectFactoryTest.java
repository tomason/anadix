package org.analyzer.factories;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import org.analyzer.ConditionSet;
import org.analyzer.Parser;
import org.testng.annotations.Test;

@Test
public class ObjectFactoryTest {
	@Test(groups = "parser", expectedExceptions = NullPointerException.class)
	public void testNewParser1() throws Exception {
		ObjectFactory.newParser((String)null);
	}

	@Test(groups = "parser", expectedExceptions = NullPointerException.class)
	public void testNewParser2() throws Exception {
		ObjectFactory.newParser("");
	}

	@Test(groups = "parser", expectedExceptions = InstantiationException.class)
	public void testNewParser3() throws Exception {
		ObjectFactory.newParser("non.existent.Class");
	}

	@Test(groups = "parser")
	public void testNewParser4() throws Exception {
		Parser expected = mock(Parser.class);
		Parser p = ObjectFactory.newParser(expected.getClass().getCanonicalName());

		assertNotNull(p);
		assertEquals(p.getClass(), expected.getClass());
	}

	@Test(groups = "parser", expectedExceptions = NullPointerException.class)
	public void testNewParser5() throws Exception {
		ObjectFactory.newParser((Class<? extends Parser>)null);
	}

	@Test(groups = "parser")
	public void testNewParser6() throws Exception {
		Parser expected = mock(Parser.class);
		Parser p = ObjectFactory.newParser(expected.getClass());

		assertNotNull(p);
		assertEquals(p.getClass(), expected.getClass());
	}

	@Test(groups = "conditions", expectedExceptions = NullPointerException.class)
	public void testNewConditionSet1() throws Exception {
		ObjectFactory.newConditionSet((String)null);
	}

	@Test(groups = "conditions", expectedExceptions = NullPointerException.class)
	public void testNewConditionSet2() throws Exception {
		ObjectFactory.newConditionSet("");
	}

	@Test(groups = "conditions", expectedExceptions = InstantiationException.class)
	public void testNewConditionSet3() throws Exception {
		ObjectFactory.newConditionSet("non.existent.Class");
	}

	@Test(groups = "conditions")
	public void testNewConditionSet4() throws Exception {
		ConditionSet expected = mock(ConditionSet.class);
		ConditionSet cs = ObjectFactory.newConditionSet(expected.getClass().getCanonicalName());

		assertNotNull(cs);
		assertEquals(cs.getClass(), expected.getClass());
	}

	@Test(groups = "conditions", expectedExceptions = NullPointerException.class)
	public void testNewConditionSet5() throws Exception {
		ObjectFactory.newConditionSet((Class<? extends ConditionSet>)null);
	}

	@Test(groups = "conditions")
	public void testNewConditionSet6() throws Exception {
		ConditionSet expected = mock(ConditionSet.class);
		ConditionSet cs = ObjectFactory.newConditionSet(expected.getClass());

		assertNotNull(cs);
		assertEquals(cs.getClass(), expected.getClass());
	}

	/* FIXME the rest of the tests should go to integration tests
	 * as this module doesn't contain the necessary dependencies
	@Test(dependsOnGroups = { "parser", "conditions" })
	public void testNewAnalyzer1() {
		try {
			ObjectFactory.newAnalyzer();
		} catch (InstantiationException ex) {
			// this will happen as we don't have the correct implementation
		}
	}

	@Test(dependsOnGroups = { "parser", "conditions" }, expectedExceptions = NullPointerException.class)
	public void testNewAnalyzer2() throws Exception {
		ObjectFactory.newAnalyzer(null);
	}

	@Test(dependsOnGroups = { "parser", "conditions" }, expectedExceptions = NullPointerException.class)
	public void testNewAnalyzer3() throws Exception {
		ConditionSet cs = mock(ConditionSet.class);
		when(cs.getDefaultParser()).thenAnswer(null);

		ObjectFactory.newAnalyzer(cs.getClass());
	}

	@Test(dependsOnGroups = { "parser", "conditions" })
	public void testNewAnalyzer4() throws Exception {
		ObjectFactory.newAnalyzer((Parser)null, null);
	}
	 */
}
