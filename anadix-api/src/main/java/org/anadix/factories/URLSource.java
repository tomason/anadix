package org.anadix.factories;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.anadix.exceptions.SourceException;
import org.jboss.logging.Logger;

class URLSource extends AbstractSource {
	private static final Logger logger = Logger.getLogger(URLSource.class);
	private final URL url;

	public URLSource(URL url) throws SourceException {
		super(url.toExternalForm());
		this.url = url;

		try {
			url.openStream();
		} catch (IOException ex) {
			logger.error("Unable to open stream", ex);
			throw new SourceException("Unable to open stream " + url, ex);
		}
	}

	@Override
	public InputStream getStream() {
		try {
			return url.openStream();
		} catch (IOException ex) {
			logger.fatal("Unable to open stream", ex);
			throw new RuntimeException("Unable to open stream on " + url);
		}
	}

}
