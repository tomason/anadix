package org.analyzer.swingparser;

import java.math.BigInteger;

public class EndTagEvent extends TagEvent {
	private static final long serialVersionUID = -5227752432914046430L;

	public EndTagEvent(BigInteger ID, String tagName, int position) {
		super(ID, tagName, null, position);
	}
}
