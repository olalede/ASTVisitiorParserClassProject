import java.io.File;

import blaise.parser.BlaiseLexer;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

/**
 * Reference solution for Project 1.
 *
 * @author rdyer
 */
public class Project1 {
	public static void main(final String[] args) throws Exception {
		final BlaiseLexer lexer = new BlaiseLexer(new ANTLRFileStream(new File(args[0]).getAbsolutePath()));
		final Vocabulary vocabulary = lexer.getVocabulary();

		while (true) {
			final Token token = lexer.nextToken();
			if (token.getType() == Token.EOF)
				break;

			System.out.print(vocabulary.getSymbolicName(token.getType()) + "\n");
		}
	}
}
