package org.analyzer.swingparser;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;

import org.analyzer.html.HTMLElementFactory;


public class StatefulParserCallback extends ParserCallback {
	private static final BigInteger JUMP = BigInteger.valueOf(100L);
	private static final String ENTRY_POINT = "parser";

	private final HTMLElementFactory factory;
	private final String source;

	private BigInteger ID = BigInteger.ZERO;

	public StatefulParserCallback(HTMLElementFactory factory) {
		this(factory, null);
	}

	public StatefulParserCallback(HTMLElementFactory factory, String source) {
		this.factory = factory;
		this.source = source;
	}

	@Override
	public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
		ID = ID.add(BigInteger.ONE);

		TagEvent e = new SimpleTagEvent(
				ID, t.toString(), parseAttributes(a), pos,
				getSource(t.toString(), pos));

		if (e.getSource().replace(" ", "").length() == e.getTagName().length() + 3) {
			System.err.println("end simple tag: " + e.getSource());
		} else {
			factory.insertEvent(ENTRY_POINT, e);
		}
	}

	@Override
	public void handleStartTag(Tag t, MutableAttributeSet a, int pos) {
		ID = ID.add(BigInteger.ONE);

		TagEvent e = new StartTagEvent(
				ID, t.toString(), parseAttributes(a), pos,
				getSource(t.toString(), pos));

		if (e.getSource().replace(" ", "").length() == e.getTagName().length() + 3) {
			System.err.println("end start tag: " + e.getSource());
		} else {
			factory.insertEvent(ENTRY_POINT, e);
		}

		ID = ID.multiply(JUMP);
	}

	@Override
	public void handleEndTag(Tag t, int pos) {
		ID = ID.divide(JUMP);

		TagEvent e = new EndTagEvent(ID, t.toString().toLowerCase(), pos);

		factory.insertEvent(ENTRY_POINT, e);
	}

	private Properties parseAttributes(MutableAttributeSet attributes) {
		Properties result = new Properties();
		Enumeration<?> names = attributes.getAttributeNames();

		Object name;
		while (names.hasMoreElements()) {
			name = names.nextElement();

			result.setProperty(
					name.toString().toLowerCase(),
					attributes.getAttribute(name).toString().toLowerCase()
					);
		}

		return result;
	}

	private String getSource(String tagName, int position) {
		if (source == null) {
			return null;
		}

		int beginIndex = source.substring(0, position + tagName.length()).lastIndexOf("<"/* + tagName*/);
		int endIndex = source.indexOf(">", beginIndex);

		if (Boolean.getBoolean("debug")) {
			System.err.println("document length: " + source.length());
			System.out.println(
					String.format(
							"Searching for %s from %s got positions (%s,%s)",
							tagName, position, beginIndex, endIndex));
		}

		if (beginIndex > -1 && endIndex > -1) {
			String result = source.substring(beginIndex, endIndex + 1);
			result = result.replace("\r", "\n");
			result = result.replace("\n", " ");
			result = result.replace("\t", " ");

			while (result.contains("  ")) {
				result = result.replace("  ", " ");
			}

			return result;
		}

		return "!" + tagName + "(" + beginIndex + "," + endIndex + ") - " + source.substring(position, position + 50);
	}
}
