package textanalysis;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.charfilter.HTMLStripCharFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class TypicalAlgorithm implements IRTextAnalysisAlgorithm {
	

	@Override
	public List<String> analyzeTextInput(Analyzer analyzer, String inputText) {

		List<String> result = new ArrayList<String>();
		try {
			TokenStream stream = analyzer.tokenStream(null, new HTMLStripCharFilter(new StringReader(inputText)));

			stream.reset();
			while (stream.incrementToken()) {
				result.add(stream.getAttribute(CharTermAttribute.class).toString());
			}
			return result;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
