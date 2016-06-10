package textanalysis;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.CharTokenizer;
import org.apache.lucene.util.AttributeFactory;

public class CommaTokenizer extends CharTokenizer {

	/**
	 * Construct a new WhitespaceTokenizer.
	 */
	public CommaTokenizer() {
	}

	/**
	 * Construct a new WhitespaceTokenizer using a given
	 * {@link org.apache.lucene.util.AttributeFactory}.
	 *
	 * @param factory
	 *            the attribute factory to use for this {@link Tokenizer}
	 */
	public CommaTokenizer(AttributeFactory factory) {
		super(factory);
	}

	/**
	 * Collects only characters which do not satisfy
	 * {@link Character#isWhitespace(int)}.
	 */
	@Override
	protected boolean isTokenChar(int c) {
		
		//comma c value equals to 44
		if (c == 44)
			return false;

		return true;
	}

}
