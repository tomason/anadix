package org.anadix.utils;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import org.anadix.Anadix;
import org.anadix.Analyzer;
import org.anadix.Report;
import org.anadix.Source;

public class MultithreadedAnalyzer {
	private ExecutorService exec;
	private final Analyzer analyzer;
	private final Map<Integer, Future<Report>> results;
	private final AtomicInteger count = new AtomicInteger(1);

	public MultithreadedAnalyzer() throws InstantiationException {
		this(Anadix.newAnalyzer(), Runtime.getRuntime().availableProcessors());
	}

	public MultithreadedAnalyzer(Analyzer analyzer) {
		this(analyzer, Runtime.getRuntime().availableProcessors());
	}

	public MultithreadedAnalyzer(Analyzer analyzer, int threads) {
		if (analyzer == null) {
			throw new NullPointerException("analyzer can't be null");
		}
		if (threads < 1) {
			throw new IllegalArgumentException("thread count must be greater than or equal to 1");
		}

		this.analyzer = analyzer;
		exec = Executors.newFixedThreadPool(threads);
		results = new ConcurrentHashMap<Integer, Future<Report>>();
	}

	public int submittAnalysis(Source source) {
		int id = count.getAndIncrement();
		results.put(id, exec.submit(new AnalysisTask(analyzer, source)));

		return id;
	}

	public Report getResult(int id) throws ResultException {
		return getResult(id, true);
	}

	public Report getResult(int id, boolean block) throws ResultException {
		Future<Report> future = results.get(id);
		try {
			if (future != null) {
				if (block) {
					return future.get();
				} else {
					try {
						return future.get(1, TimeUnit.MILLISECONDS);
					} catch (TimeoutException ex) {
						// ok
					}
				}
			}
		} catch (InterruptedException ex) {
			throw new ResultException("Interrupted", ex);
		} catch (ExecutionException ex) {
			throw new ResultException("Error during execution", ex.getCause());
		}

		return null;
	}

	public boolean dispose() {
		return dispose(30, TimeUnit.SECONDS);
	}

	public boolean dispose(long timeout, TimeUnit unit) {
		exec.shutdown();
		try {
			if (!exec.awaitTermination(timeout, unit)) {
				exec.shutdownNow();
			} else {
				return true;
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private static class AnalysisTask implements Callable<Report> {
		private final Analyzer a;
		private final Source s;

		public AnalysisTask(Analyzer a, Source s) {
			this.a = a;
			this.s = s;
		}

		public Report call() throws Exception {
			return a.analyze(s);
		}
	}
}
