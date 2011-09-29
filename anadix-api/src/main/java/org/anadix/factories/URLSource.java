package org.anadix.factories;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

class URLSource extends AbstractSource {
	private final URL url;

	public URLSource(URL url) throws IOException {
		super(url.toExternalForm());
		this.url = url;

		url.openStream();
	}

	@Override
	public InputStream getStream() {
		try {
			return url.openStream();
		} catch (IOException ex) {
			throw new RuntimeException("Unable to open stream on " + url);
		}
	}

}
