package textanalysis;

import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypicalAlgotrithmTest {
	private static final Logger logger = LoggerFactory.getLogger(TypicalAlgotrithmTest.class);

	@Test
	public void testTokenizeInputAnalyzerString() {
		IRTextAnalysisAlgorithm algotrithm = new TypicalAlgorithm();

		Analyzer analyzer = new StandardAnalyzer();
		
		List<String> processInput = algotrithm.analyzeTextInput(analyzer, "terminal/terminator,- ??!terminate");

		logger.info(processInput.toString());

	}

}
