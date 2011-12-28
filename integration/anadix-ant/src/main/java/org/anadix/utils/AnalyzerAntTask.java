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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.anadix.Anadix;
import org.anadix.Analyzer;
import org.anadix.Report;
import org.anadix.Source;
import org.anadix.exceptions.SourceException;
import org.anadix.factories.SourceFactory;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.MatchingTask;

/**
 * Ant task for analyzing files in source directory.
 * All attributes are optional since they have the default values set.
 * Default values:
 * <ul>
 *   <li>parserClass - defined in org.anadix.Anadix</li>
 *   <li>conditionSetClass - defined in org.anadix.Anadix</li>
 *   <li>formatterClass - defined in org.anadix.Anadix</li>
 *   <li>sourcesDir - 'src'</li>
 *   <li>reportsDir - defined in org.anadix.Anadix</li>
 * </ul>
 *
 * @see org.anadix.Anadix
 * @author tomason
 * @version $Id: $
 */
public class AnalyzerAntTask extends MatchingTask {
	private File sourcesDir = new File("src");

	/**
	 * Sets the parser used
	 *
	 * @param parserClass parser class name
	 */
	public void setParserClass(String parserClass) {
		if (!Anadix.setDefaultParser(parserClass)) {
			log("Unable to set parser class " + parserClass, Project.MSG_ERR);
		}
	}

	/**
	 * Sets the condition set used
	 *
	 * @param conditionSetClass condition set class name
	 */
	public void setConditionSetClass(String conditionSetClass) {
		if (!Anadix.setDefaultParser(conditionSetClass)) {
			log("Unable to set condition set class " + conditionSetClass, Project.MSG_ERR);
		}
	}

	/**
	 * Sets the formatter used
	 *
	 * @param formatterClass formatter class name
	 */
	public void setFormatterClass(String formatterClass) {
		if (!Anadix.setDefaultParser(formatterClass)) {
			log("Unable to set formatter class " + formatterClass, Project.MSG_ERR);
		}
	}

	/**
	 * Sets the directory to load source files from
	 *
	 * @param dir instance of File denoting the directory
	 */
	public void setSourcesDir(File dir) {
		this.sourcesDir = dir;
	}

	/**
	 * Sets the directory to store reports
	 *
	 * @param reportsDir instance of File denoting the directory
	 */
	public void setReportsDir(File reportsDir) {
		if (!Anadix.setReportDirectory(reportsDir)) {
			log("Unable to set reports dir", Project.MSG_ERR);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void execute() throws BuildException {
		log("Starting...", Project.MSG_INFO);
		Analyzer a = createAnalyzer();
		log("Created an instance of analyzer", Project.MSG_INFO);
		Map<String, Report> results = analyze(a, sourcesDir);

		for (Entry<String, Report> entry : results.entrySet()) {
			Anadix.formatReport(entry.getValue(), entry.getKey());
		}
	}

	private Analyzer createAnalyzer() throws BuildException {
		try {
			return Anadix.newAnalyzer();
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
			if (fileName.contains(".") && fileName.lastIndexOf('.') > fileName.lastIndexOf(System.getProperty("path.separator"))) {
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
