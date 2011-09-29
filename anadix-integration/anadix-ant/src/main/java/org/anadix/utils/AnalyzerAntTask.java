/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.anadix.Analyzer;
import org.anadix.Report;
import org.anadix.ReportFormatter;
import org.anadix.Source;
import org.anadix.exceptions.SourceException;
import org.anadix.factories.ObjectFactory;
import org.anadix.factories.SourceFactory;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.MatchingTask;

public class AnalyzerAntTask extends MatchingTask {
	private String parserClass = null;
	private String conditionSetClass = null;
	private String formatterClass = null;
	private File sourcesDir = new File("src");
	private File reportsDir = new File("report");

	public void setParserClass(String parserClass) {
		this.parserClass = parserClass;
	}

	public void setConditionSetClass(String conditionSetClass) {
		this.conditionSetClass = conditionSetClass;
	}

	public void setFormatterClass(String formatterClass) {
		this.formatterClass = formatterClass;
	}

	public void setSourcesDir(File dir) {
		this.sourcesDir = dir;
	}

	public void setReportsDir(File reportsDir) {
		this.reportsDir = reportsDir;
	}

	@Override
	public void execute() throws BuildException {
		log("Starting...", Project.MSG_INFO);
		Analyzer a = createAnalyzer();
		log("Created an instance of analyzer", Project.MSG_INFO);
		Map<String, Report> results = analyze(a, sourcesDir);

		if (!reportsDir.exists()) {
			if (!reportsDir.mkdirs()) {
				throw new BuildException("Could not create directory structure for " + reportsDir);
			}
		}
		for (Entry<String, Report> entry : results.entrySet()) {
			File result = new File(reportsDir, entry.getKey());
			if (result.exists()) {
				if (!result.delete()) {
					throw new BuildException("Could not delete " + result);
				}
			}
			if (!result.getParentFile().mkdirs()) {
				throw new BuildException("Could not create directory structure for " + result);
			}

			PrintWriter pw = null;
			try {
				pw = new PrintWriter(result);

				ReportFormatter formatter = ObjectFactory.newFormatter(formatterClass);
				formatter.formatAndStore(entry.getValue(), pw);
			} catch (InstantiationException ex) {
				throw new BuildException("Unable to instantiate formatter", ex);
			} catch (IOException ex) {
				throw new BuildException("Unable to save report " + result, ex);
			} finally {
				if (pw != null) {
					pw.flush();
					pw.close();
				}
			}
		}
	}

	private Analyzer createAnalyzer() throws BuildException {
		try {
			Analyzer a;
			if (parserClass != null && parserClass.length() > 0) {
				a = ObjectFactory.newAnalyzer(
						ObjectFactory.newParser(parserClass),
						ObjectFactory.newConditionSet(conditionSetClass));
			} else {
				a = ObjectFactory.newAnalyzer(null, ObjectFactory.newConditionSet(conditionSetClass));
			}

			return a;
		} catch (InstantiationException ex) {
			throw new BuildException("Unable to istantiate Analyzer " + ex, ex);
		}
	}

	private Map<String, Report> analyze(Analyzer analyzer, File file) {
		Map<String, Report> result = new HashMap<String, Report>();

		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				result.putAll(analyze(analyzer, child));
			}
		} else {
			log("Starting analysis of " + file, Project.MSG_VERBOSE);
			String fileName = getRelativePath(sourcesDir, file);
			if (fileName.contains(".") && fileName.lastIndexOf('.') > 0) {
				fileName = fileName.substring(0, fileName.lastIndexOf('.'));
			}
			result.put(
					fileName,
					analyzeFile(analyzer, file));
			log("Finished analysis of " + file, Project.MSG_VERBOSE);
		}

		return result;
	}

	private Report analyzeFile(Analyzer analyzer, File file) {
		try {
			Source s =  SourceFactory.newFileSource(file);

			return analyzer.analyze(s);
		} catch (SourceException ex) {
			throw new BuildException("Unable to create source", ex);
		}
	}

	private static String getRelativePath(File basedir, File file) {
		if (file.getAbsolutePath().contains(basedir.getAbsolutePath())) {
			return file.getAbsolutePath().substring(basedir.getAbsolutePath().length());
		} else {
			throw new RuntimeException(String.format("File %s not child of %s", file, basedir));
		}
	}
}
