package org.analyzer.swingparser;

import java.math.BigInteger;
import java.util.Properties;

public class SimpleTagEvent extends TagEvent {
	private static final long serialVersionUID = -1334268142511377077L;

	public SimpleTagEvent(BigInteger ID, String tagName, Properties attributes, int position) {
		super(ID, tagName, attributes, position);
	}

	public SimpleTagEvent(BigInteger ID, String tagName, Properties attributes, int position, String source) {
		super(ID, tagName, attributes, position, source);
	}
}
