package processing;

import java.io.File;
import java.util.HashMap;

import org.apache.lucene.analysis.Analyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entry.IRP;
import hashing.HashDistance;
import hashing.SimHash;
import output.Output;
import textanalysis.IRTextAnalysisAlgorithm;

public abstract class Processor {
	private static final Logger logger = LoggerFactory.getLogger(IRP.class);

	File inputFile;
	IRTextAnalysisAlgorithm textAnalysisAlgorithm;
	Analyzer textAnalyzer;
	SimHash hashingAlgorithm;
	HashDistance hashDistanceAlgorithm;

	private void setup(File inputFile, IRTextAnalysisAlgorithm textAnalysisAlgorithm, Analyzer textAnalyzer,
			SimHash hashingAlgorithm, HashDistance hashDistanceAlgorithm) {
		this.inputFile = inputFile;
		this.textAnalysisAlgorithm = textAnalysisAlgorithm;
		this.textAnalyzer = textAnalyzer;
		this.hashingAlgorithm = hashingAlgorithm;
		this.hashDistanceAlgorithm = hashDistanceAlgorithm;
	}

	private boolean checkInput(File inputFile, IRTextAnalysisAlgorithm textAnalysisAlgorithm, Analyzer textAnalyzer,
			SimHash hashingAlgorithm, HashDistance hashDistanceAlgorithm) {

		return true;
	}

	public final Output process(File inputFile, IRTextAnalysisAlgorithm textAnalysisAlgorithm, Analyzer textAnalyzer,
			SimHash hashingAlgorithm, HashDistance hashDistanceAlgorithm) {
		if (this.checkInput(inputFile, textAnalysisAlgorithm, textAnalyzer, hashingAlgorithm, hashDistanceAlgorithm))
			this.setup(inputFile, textAnalysisAlgorithm, textAnalyzer, hashingAlgorithm, hashDistanceAlgorithm);
		else {
			logger.error("Input parameters are wrong, fix and re-run");
			System.exit(-1);
		}
		this.createFingerprintMatrix();
		///etc

		return null;
	}

	abstract HashMap<String, String> createFingerprintMatrix();

	public HashDistance getHashDistanceAlgorithm() {
		return hashDistanceAlgorithm;
	}

	public SimHash getHashingAlgorithm() {
		return hashingAlgorithm;
	}

	public File getInputFile() {
		return inputFile;
	}

	public IRTextAnalysisAlgorithm getTextAnalysisAlgorithm() {
		return textAnalysisAlgorithm;
	}

	public Analyzer getTextAnalyzer() {
		return textAnalyzer;
	}

}
