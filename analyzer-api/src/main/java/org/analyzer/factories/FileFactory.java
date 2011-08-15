package org.analyzer.factories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

import org.analyzer.utils.PropertiesUtils;

public abstract class FileFactory {
	private static final File sourcesDir;

	static {
		sourcesDir = new File(PropertiesUtils.getProperty("sources.saveDir", "html-sources"));
		if (!sourcesDir.exists()) {
			sourcesDir.mkdirs();
		}
	}

	public static File saveSource(String source) {
		File f = getSourceFile();

		try {
			saveSource(source, f);
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("This should not have happened", ex);
		}

		return f;
	}

	public static void saveSource(String source, File file) throws FileNotFoundException {
		saveText(source, file);
	}

	private static File getSourceFile() {
		File result;
		String filename = String.format("html_%1$td%1$tm-%1$tH%1$tM%1$tS", Calendar.getInstance());

		while ((result = new File(sourcesDir, filename)).exists()) {
			filename = String.format("html_%1$td%1$tm-%1$tH%1$tM%1$tS", Calendar.getInstance());
		}

		return result;
	}

	public static void saveText(String text, File file) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(file);

		pw.println(text);

		pw.flush();
		pw.close();
	}

	public static void saveBinary(Object o, File file) throws FileNotFoundException {
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));

			oos.writeObject(o);

			oos.flush();
		} catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				throw (FileNotFoundException)e;
			}
			// TODO Auto-generated catch block
			System.err.println("Unable to write tot file");
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException ex) {
					System.err.println(ex);
					ex.printStackTrace();
				}
			}
		}
	}
}
