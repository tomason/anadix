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
package org.anadix.html;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.math.BigInteger;
import java.util.Properties;

import org.anadix.Element;
import org.drools.runtime.StatefulKnowledgeSession;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class HTMLElementFactoryTest {

	@Test(groups = "constructor", expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new HTMLElementFactory(null);
	}

	@Test(groups = "constructor")
	public void testConstructor2() {
		new HTMLElementFactory(mock(StatefulKnowledgeSession.class));
	}

	private StatefulKnowledgeSession ksession;
	private HTMLElementFactory factory;

	@BeforeMethod(dependsOnGroups = "constructor")
	public void prepareMocks() {
		ksession = mock(StatefulKnowledgeSession.class);
		factory = new HTMLElementFactory(ksession);
	}

	@Test(dependsOnGroups = "constructor")
	public void testInsertElement1() {
		factory.insertElement((HtmlElement)null);

		verify(ksession).insert(any());
	}

	@Test(dependsOnGroups = "constructor")
	public void testInsertElement2() {
		factory.insertElement((Element)null);

		verify(ksession).insert(any());
		verifyNoMoreInteractions(ksession);
	}

	@Test(dependsOnGroups = "constructor")
	public void testInsertElement3() {
		HtmlElement e = mock(HtmlElement.class);
		factory.insertElement(e);

		verify(ksession).insert(e);
		verifyNoMoreInteractions(ksession);
	}

	@Test(dependsOnGroups = "constructor")
	public void testInsertElement4() {
		Element e = mock(Element.class);
		factory.insertElement(e);

		verify(ksession).insert(e);
		verifyNoMoreInteractions(ksession);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateFrameTag1() {
		factory.createFrameTag(null, null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateFrameTag2() {
		factory.createFrameTag(new BigInteger("1"), null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateFrameTag3() {
		factory.createFrameTag(null, mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateFrameTag4() {
		factory.createFrameTag(null, null, new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateFrameTag5() {
		factory.createFrameTag(new BigInteger("1"), mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateFrameTag6() {
		// parent can be null
		factory.createFrameTag(new BigInteger("1"), null, new Properties());
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateFrameTag7() {
		factory.createFrameTag(
				new BigInteger("1"),
				mock(HtmlElement.class),
				new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateImgTag1() {
		factory.createImgTag(null, null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateImgTag2() {
		factory.createImgTag(new BigInteger("1"), null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateImgTag3() {
		factory.createImgTag(null, mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateImgTag4() {
		factory.createImgTag(null, null, new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateImgTag5() {
		factory.createImgTag(new BigInteger("1"), mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateImgTag6() {
		// parent can be null
		factory.createImgTag(new BigInteger("1"), null, new Properties());
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateImgTag7() {
		factory.createImgTag(
				new BigInteger("1"),
				mock(HtmlElement.class),
				new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTableTag1() {
		factory.createTableTag(null, null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTableTag2() {
		factory.createTableTag(new BigInteger("1"), null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTableTag3() {
		factory.createTableTag(null, mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTableTag4() {
		factory.createTableTag(null, null, new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTableTag5() {
		factory.createTableTag(new BigInteger("1"), mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateTableTag6() {
		// parent can be null
		factory.createTableTag(new BigInteger("1"), null, new Properties());
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateTableTag7() {
		factory.createTableTag(
				new BigInteger("1"),
				mock(HtmlElement.class),
				new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateHtmlTag1() {
		factory.createHtmlTag(null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateHtmlTag2() {
		factory.createHtmlTag(new BigInteger("1"), null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateHtmlTag3() {
		factory.createHtmlTag(null, new Properties());
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateHtmlTag4() {
		factory.createHtmlTag(new BigInteger("1"), new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag1() {
		factory.createTag(null, null, null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag2() {
		factory.createTag(new BigInteger("1"), null, null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag3() {
		factory.createTag(null, "string", null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag4() {
		factory.createTag(null, null, mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag5() {
		factory.createTag(null, null, null, new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag6() {
		factory.createTag(new BigInteger("1"), "string", null, null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag7() {
		factory.createTag(new BigInteger("1"), null, mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag8() {
		factory.createTag(new BigInteger("1"), null, null, new Properties());
	}

	@Test(dependsOnGroups = "constructor", expectedExceptions = NullPointerException.class)
	public void testCreateTag9() {
		factory.createTag(new BigInteger("1"), "string", mock(HtmlElement.class), null);
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateTag10() {
		// parent can be null
		factory.createTag(new BigInteger("1"), "string", null, new Properties());
	}

	@Test(dependsOnGroups = "constructor")
	public void testCreateTag11() {
		factory.createTag(new BigInteger("1"), "string", mock(HtmlElement.class), new Properties());
	}
}
