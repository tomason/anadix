package org.analyzer.html;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.math.BigInteger;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class FrameTagTest {
	private static final BigInteger id = new BigInteger("12");
	private static final HtmlElement parent = mock(HtmlElement.class);
	private static final String title = "Some title";
	private Attributes noTitle;
	private Attributes withTitle;

	@BeforeTest
	public void prepareAttributes() {
		Properties p = new Properties();
		p.setProperty("width", "100px;");
		noTitle = new Attributes(p);

		p.setProperty("title", title);
		withTitle = new Attributes(p);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new FrameTag(null, null, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor2() {
		new FrameTag(id, null, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new FrameTag(null, parent, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor4() {
		new FrameTag(null, null, noTitle);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor5() {
		new FrameTag(id, parent, null);
	}

	public void testConstructor6() {
		new FrameTag(id, null, noTitle);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor7() {
		new FrameTag(null, parent, noTitle);
	}

	public void testConstructor8() {
		new FrameTag(id, parent, noTitle);
	}

	public void testGetAttributes1() {
		FrameTag ft = new FrameTag(id, parent, noTitle);
		assertEquals(ft.getAttributes(), noTitle);
	}

	public void testGetAttributes2() {
		FrameTag ft = new FrameTag(id, parent, withTitle);
		assertEquals(ft.getAttributes(), withTitle);
	}

	public void testGetId() {
		FrameTag ft = new FrameTag(id, parent, withTitle);
		assertEquals(ft.getId(), id);
	}

	public void testGetName() {
		FrameTag ft = new FrameTag(id, parent, noTitle);
		assertEquals(ft.getName(), "frame");
	}

	public void testGetParent() {
		FrameTag ft = new FrameTag(id, parent, noTitle);
		assertEquals(ft.getParent(), parent);
	}

	public void testPosition() {
		int position = 42;
		FrameTag ft = new FrameTag(id, parent, noTitle);
		assertEquals(ft.getPosition(), 0);

		ft.setPosition(position);
		assertEquals(ft.getPosition(), position);
	}

	public void testSource() {
		String source = "<html><head></head><body><img /></body></html>";
		FrameTag ft = new FrameTag(id, parent, noTitle);
		assertNull(ft.getSource());

		ft.setSource(source);
		assertEquals(ft.getSource(), source);
	}

	public void testTextContent() {
		String textContent = "<html><head></head><body><img /></body></html>";
		FrameTag ft = new FrameTag(id, parent, noTitle);
		assertEquals(ft.getTextContent(), "");

		ft.setTextContent(textContent);
		assertEquals(ft.getTextContent(), textContent);
	}

	public void testGetTitle1() {
		FrameTag ft = new FrameTag(id, parent, noTitle);
		assertNull(ft.getTitle());
	}

	public void testGetTitle2() {
		FrameTag ft = new FrameTag(id, parent, withTitle);
		assertEquals(ft.getTitle(), title);
	}

}
