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
package org.analyzer.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.analyzer.Analyzer;
import org.analyzer.Report;
import org.analyzer.ReportFormatter;
import org.analyzer.Source;
import org.analyzer.exceptions.InstantiationException;
import org.analyzer.exceptions.SourceException;
import org.analyzer.factories.ObjectFactory;
import org.analyzer.factories.SourceFactory;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.MatchingTask;

public class AnalyzerAntTask extends MatchingTask {
	private String parserClass;
	private String conditionSetClass;
	private String formatterClass;
	private File sourcesDir;
	private File reportsDir;

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
		try {
			log("Starting...", Project.MSG_INFO);
			Analyzer a = ObjectFactory.newAnalyzer(parserClass, conditionSetClass);
			log("Created an instance of analyzer", Project.MSG_INFO);
			Map<String, Report> results = analyze(a, sourcesDir);

			if (!reportsDir.exists()) {
				reportsDir.mkdirs();
			}
			for (String path : results.keySet()) {
				File result = new File(reportsDir, path);
				if (result.exists()) {
					result.delete();
				}
				result.getParentFile().mkdirs();

				PrintWriter pw = null;
				try {
					pw = new PrintWriter(result);

					// TODO add formatting
					ReportFormatter formatter = ObjectFactory.newFormatter(formatterClass);
					formatter.formatAndStore(results.get(path), pw);
				} catch (IOException ex) {
					throw new BuildException("Unable to save report " + result, ex);
				} finally {
					if (pw != null) {
						pw.flush();
						pw.close();
					}
				}
			}
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
					getRelativePath(sourcesDir, file),
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
