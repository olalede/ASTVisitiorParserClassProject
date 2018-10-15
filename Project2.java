import java.io.File;

import ast.*;

import blaise.parser.BlaiseLexer;

import org.antlr.v4.runtime.ANTLRFileStream;

public class Project2 
{
    public static void main(final String[] args) throws Exception
    {
        final BlaiseLexer lexer = new BlaiseLexer(new ANTLRFileStream(new File(args[0]).getAbsolutePath()));
		final BlaiseParser parser = new BlaiseParser(lexer);
        final Program p = parser.parseProgram();

		p.accept(new Project2Visitor(), null);
	}
}