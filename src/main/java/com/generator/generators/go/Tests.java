package com.generator.generators.go;

import com.generator.ProjectConstants;
import com.generator.generators.go.parser.GolangLexer;
import com.generator.generators.go.parser.GolangNodeListener;
import com.generator.generators.go.parser.GolangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 15.09.17.
 */
public class Tests {

   @Test
   public void testParser() throws IOException {
      final GolangNodeListener listener = new GolangNodeListener(true);
      new ParseTreeWalker().walk(listener, new GolangParser(new CommonTokenStream(new GolangLexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/go/Test.go")))).sourceFile());
   }
}
