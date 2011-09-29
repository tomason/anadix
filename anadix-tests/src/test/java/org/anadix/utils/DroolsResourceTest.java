package org.anadix.utils;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.ResourceConfiguration;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class DroolsResourceTest {
	private Resource r;
	private ResourceType rt;
	private ResourceConfiguration rc;

	@BeforeMethod(alwaysRun = true)
	public void prepareMocks() {
		r = mock(Resource.class);
		rt = mock(ResourceType.class);
		rc = mock(ResourceConfiguration.class);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new DroolsResource(null, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new DroolsResource(null, rt);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new DroolsResource(r, null);
	}

	public void testConstructor4() {
		new DroolsResource(r, rt);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor5() {
		new DroolsResource(null, null, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor6() {
		new DroolsResource(r, null, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor7() {
		new DroolsResource(null, rt, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor8() {
		new DroolsResource(null, null, rc);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor9() {
		new DroolsResource(null, rt, rc);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor10() {
		new DroolsResource(r, null, rc);
	}

	public void testConstructor11() {
		new DroolsResource(r, rt, null);
	}

	public void testConstructor12() {
		new DroolsResource(r, rt, rc);
	}

	public void testGetResource() {
		DroolsResource dr = new DroolsResource(r, rt, rc);

		assertNotNull(dr);
		assertEquals(dr.getResource(), r);
	}

	public void testGetType() {
		DroolsResource dr = new DroolsResource(r, rt, rc);

		assertNotNull(dr);
		assertEquals(dr.getType(), rt);
	}

	public void testGetConfiguration() {
		DroolsResource dr = new DroolsResource(r, rt, rc);

		assertNotNull(dr);
		assertEquals(dr.getConfiguration(), rc);
	}

	public void testInsertInto1() {
		DroolsResource dr = new DroolsResource(r, rt);
		KnowledgeBuilder kbuilder = mock(KnowledgeBuilder.class);

		dr.insertInto(kbuilder);

		verify(kbuilder).add(r, rt);
		verify(kbuilder, never()).add(r, rt, null);
		verify(kbuilder, never()).add(r, rt, rc);
	}

	public void testInsertInto2() {
		DroolsResource dr = new DroolsResource(r, rt, rc);
		KnowledgeBuilder kbuilder = mock(KnowledgeBuilder.class);

		dr.insertInto(kbuilder);

		verify(kbuilder, never()).add(r, rt);
		verify(kbuilder, never()).add(r, rt, null);
		verify(kbuilder).add(r, rt, rc);
	}
}
