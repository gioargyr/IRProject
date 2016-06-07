package processing;

import java.io.File;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;

import output.Output;
import textanalysis.IRTextAnalysisAlgorithm;

public interface Processor {

	public List<String> process(File f, IRTextAnalysisAlgorithm textAnalysisAlgorithm, Analyzer textAnalyzer,
			Output output);

}
