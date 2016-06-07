package textanalysis;

import java.util.List;

import org.apache.lucene.analysis.Analyzer;

public interface IRTextAnalysisAlgorithm {

	public List<String> analyzeTextInput(Analyzer analyzer, String inputText);

}
