package org.analyzer.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {
	private static final File sources = new File("test-sources");
	private static final File log = new File("log", "test.log");

	public static void saveSource(String name, String source) throws Exception {
		saveSource(new File(sources, name + ".html"), source);
	}

	public static void saveSource(File file, String source) throws Exception {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));

			bw.write(source);
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}

	public static String readSource(String name) throws FileNotFoundException, IOException {
		return readSource(new File(sources, name));
	}

	public static String readSource(File f) throws FileNotFoundException, IOException {
		StringBuilder result = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String ln;
			String separator = System.getProperty("line.separator");

			while ((ln = br.readLine()) != null) {
				result.append(ln).append(separator);
			}

			return result.toString();
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	public static void appendLog(String content) throws Exception {
		if (!log.exists()) {
			log.createNewFile();
		}

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(log, true));

			bw.write(content);
			bw.newLine();
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}
}
