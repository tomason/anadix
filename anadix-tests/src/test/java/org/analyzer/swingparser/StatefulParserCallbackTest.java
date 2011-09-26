package org.analyzer.swingparser;

import static org.testng.Assert.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTML.Tag;

import org.analyzer.html.HTMLElementFactory;
import org.analyzer.mock.TrackingElementFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class StatefulParserCallbackTest {
	private HTMLElementFactory factory;
	private static final String iframeTitle = "frame title";
	private static final String h1Style = "width: 100px; background-color: #FFFFFF;";
	private static final String imgSrc = "img/pic.png";
	private static final String source =
			"<html>\n" +
					"  <head>\n" +
					"  </head>\n" +
					"  <body>\n" +
					"    <iframe title=\"" + iframeTitle + "\">\n" +
					"      <h1 style=\"" + h1Style + "\">Hello world</h1>\n" +
					"      <img src=\"" + imgSrc + "\" />\n" +
					"    </iframe>\n" +
					"  </body>\n" +
					"</html>\n";
	private static final int iframePosition = source.indexOf("<iframe");
	private static final int h1Position = source.indexOf("<h1");
	private static final int imgPosition = source.indexOf("<img");
	//private static final int iframeEndPosition = source.indexOf("</iframe>");
	private static final int h1EndPosition = source.indexOf("</h1>");
	private static final String ENTRY_POINT = "parser";

	@BeforeMethod(alwaysRun = true)
	public void prepareFactory() {
		factory = new TrackingElementFactory();
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor1() {
		new StatefulParserCallback(null);
	}

	public void testConstructor2() {
		new StatefulParserCallback(factory);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor3() {
		new StatefulParserCallback(null, source);
	}

	public void testConstructor4() {
		new StatefulParserCallback(factory, null);
	}

	public void testConstructor5() {
		new StatefulParserCallback(factory, "");
	}

	@DataProvider(name = "simple")
	public Object[][] prepareSimpleTag() {
		MutableAttributeSet a = new SimpleAttributeSet();
		a.addAttribute("src", imgSrc);

		return new Object[][] { new Object[] { Tag.IMG, a, imgPosition } };
	}

	@DataProvider(name = "start")
	public Object[][] prepareStartTag() {
		MutableAttributeSet a = new SimpleAttributeSet();
		a.addAttribute("style", h1Style);

		return new Object[][] { new Object[] { Tag.H1, a, h1Position } };
	}

	@DataProvider(name = "end")
	public Object[][] prepareEndTag() {
		MutableAttributeSet a = new SimpleAttributeSet();
		a.addAttribute("style", h1Style);

		return new Object[][] { new Object[] { Tag.H1, a, h1EndPosition } };
	}

	@Test(dataProvider = "simple")
	public void testHandleSimpleTag1(Tag t, MutableAttributeSet a, int pos) {
		StatefulParserCallback spc = new StatefulParserCallback(factory);

		spc.handleSimpleTag(t, a, pos);

		Collection<Object> elements = ((TrackingElementFactory)factory).getEvents(ENTRY_POINT);
		assertNotNull(elements);
		assertEquals(elements.size(), 1);

		Object element = elements.iterator().next();
		assertEquals(element.getClass(), SimpleTagEvent.class);
		SimpleTagEvent event = (SimpleTagEvent)element;

		assertEquals(event.getId(), BigInteger.ONE);
		assertEquals(event.getTagName(), "img");
		assertEquals(event.getPosition(), imgPosition);
		assertNull(event.getSource());

		Properties attributes = event.getAttributes();
		assertNotNull(attributes);
		assertEquals(attributes.size(), 1);
		assertEquals(attributes.get("src"), imgSrc);
	}

	@Test(dataProvider = "simple")
	public void testHandleSimpleTag2(Tag t, MutableAttributeSet a, int pos) {
		StatefulParserCallback spc = new StatefulParserCallback(factory, source);

		spc.handleSimpleTag(t, a, pos);

		Collection<Object> elements = ((TrackingElementFactory)factory).getEvents(ENTRY_POINT);
		assertNotNull(elements);
		assertEquals(elements.size(), 1);

		Object element = elements.iterator().next();
		assertEquals(element.getClass(), SimpleTagEvent.class);
		SimpleTagEvent event = (SimpleTagEvent)element;

		assertEquals(event.getId(), BigInteger.ONE);
		assertEquals(event.getTagName(), "img");
		assertEquals(event.getPosition(), imgPosition);
		assertEquals(event.getSource(), "<img src=\"" + imgSrc + "\" />");

		Properties attributes = event.getAttributes();
		assertNotNull(attributes);
		assertEquals(attributes.size(), 1);
		assertEquals(attributes.get("src"), imgSrc);
	}

	@Test(dataProvider = "end")
	public void testHandleSimpleTag3(Tag t, MutableAttributeSet a, int pos) {
		StatefulParserCallback spc = new StatefulParserCallback(factory, source);

		spc.handleSimpleTag(t, a, pos);

		Collection<Object> elements = ((TrackingElementFactory)factory).getEvents(ENTRY_POINT);
		assertNull(elements);
	}

	@Test(dataProvider = "start")
	public void testHandleStartTag1(Tag t, MutableAttributeSet a, int pos) {
		StatefulParserCallback spc = new StatefulParserCallback(factory);

		spc.handleStartTag(t, a, pos);

		Collection<Object> elements = ((TrackingElementFactory)factory).getEvents(ENTRY_POINT);
		assertNotNull(elements);
		assertEquals(elements.size(), 1);

		Object element = elements.iterator().next();
		assertEquals(element.getClass(), StartTagEvent.class);
		StartTagEvent event = (StartTagEvent)element;

		assertEquals(event.getId(), BigInteger.ONE);
		assertEquals(event.getTagName(), "h1");
		assertEquals(event.getPosition(), h1Position);
		assertNull(event.getSource());

		Properties attributes = event.getAttributes();
		assertNotNull(attributes);
		assertEquals(attributes.size(), 1);
		assertEquals(attributes.get("style"), h1Style.toLowerCase());
	}

	@Test(dataProvider = "start")
	public void testHandleStartTag2(Tag t, MutableAttributeSet a, int pos) {
		StatefulParserCallback spc = new StatefulParserCallback(factory, source);

		spc.handleStartTag(t, a, pos);

		Collection<Object> elements = ((TrackingElementFactory)factory).getEvents(ENTRY_POINT);
		assertNotNull(elements);
		assertEquals(elements.size(), 1);

		Object element = elements.iterator().next();
		assertEquals(element.getClass(), StartTagEvent.class);
		StartTagEvent event = (StartTagEvent)element;

		assertEquals(event.getId(), BigInteger.ONE);
		assertEquals(event.getTagName(), "h1");
		assertEquals(event.getPosition(), h1Position);
		assertEquals(event.getSource(), "<h1 style=\"" + h1Style + "\">");

		Properties attributes = event.getAttributes();
		assertNotNull(attributes);
		assertEquals(attributes.size(), 1);
		assertEquals(attributes.get("style"), h1Style.toLowerCase());
	}

	@Test(dataProvider = "end")
	public void testHandleStartTag3(Tag t, MutableAttributeSet a, int pos) {
		StatefulParserCallback spc = new StatefulParserCallback(factory, source);

		spc.handleStartTag(t, a, pos);

		Collection<Object> elements = ((TrackingElementFactory)factory).getEvents(ENTRY_POINT);
		assertNull(elements);
	}

	@Test(dataProvider = "end")
	public void testHandleEndTag(Tag t, MutableAttributeSet a, int pos) {
		StatefulParserCallback spc = new StatefulParserCallback(factory);

		spc.handleStartTag(t, a, 0);
		spc.handleEndTag(t, pos);

		Collection<Object> elements = ((TrackingElementFactory)factory).getEvents(ENTRY_POINT);
		assertNotNull(elements);
		assertEquals(elements.size(), 2);

		Iterator<Object> it = elements.iterator();
		// skip the start tag
		it.next();

		Object element = it.next();
		assertEquals(element.getClass(), EndTagEvent.class);
		EndTagEvent event = (EndTagEvent)element;

		assertEquals(event.getId(), BigInteger.ONE);
		assertEquals(event.getTagName(), "h1");
		assertEquals(event.getPosition(), h1EndPosition);
		assertNull(event.getSource());
	}

	public void testHandleError() {
		StatefulParserCallback spc = new StatefulParserCallback(factory);

		spc.handleError("iframe is invalid tag name", iframePosition);
	}
}
