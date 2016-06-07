package processing;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;

import output.Output;
import textanalysis.IRTextAnalysisAlgorithm;

public interface Processor {

	public Output process(File f, IRTextAnalysisAlgorithm textAnalysisAlgorithm, Analyzer textAnalyzer);

}
