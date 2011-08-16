package org.analyzer.factories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.analyzer.Source;

abstract class AbstractSource implements Source {
	public String getText() {
		String result = "";
		BufferedReader br = null;

		try {
			br = new BufferedReader(getReader());
			String line;

			while ((line = br.readLine()) != null) {
				result += line + "\n";
			}
		} catch (IOException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.err.println(e);
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public Reader getReader() {
		return new InputStreamReader(getStream());
	}
}
