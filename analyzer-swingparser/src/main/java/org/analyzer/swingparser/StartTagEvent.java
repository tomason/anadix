package org.analyzer.swingparser;

import java.math.BigInteger;
import java.util.Properties;

public class StartTagEvent extends TagEvent {
	private static final long serialVersionUID = -4954582531613018733L;

	public StartTagEvent(BigInteger ID, String name, Properties attributes, int position) {
		super(ID, name, attributes, position);
	}

	public StartTagEvent(BigInteger ID, String name, Properties attributes, int position, String source) {
		super(ID, name, attributes, position, source);
	}
}
