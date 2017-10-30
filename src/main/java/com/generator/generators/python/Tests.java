package com.generator.generators.python;

import com.generator.ProjectConstants;
import com.generator.generators.python.parser.Python3Lexer;
import com.generator.generators.python.parser.Python3NodeListener;
import com.generator.generators.python.parser.Python3Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 29.10.17.
 */
public class Tests {

   @Test
   public void testParser() throws IOException {
      final Python3Parser parser = new Python3Parser(new CommonTokenStream(new Python3Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT+"python/portscanner.py"))));
      final Python3NodeListener listener = new Python3NodeListener(true);
      new ParseTreeWalker().walk(listener, parser.file_input());
   }

}
