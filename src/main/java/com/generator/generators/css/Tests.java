package com.generator.generators.css;

import com.generator.ProjectConstants;
import com.generator.generators.css.parser.css3Lexer;
import com.generator.generators.css.parser.css3NodeListener;
import com.generator.generators.css.parser.css3Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 14.09.17.
 */
public class Tests {

   @Test
   public void testCss() throws IOException {
      final css3NodeListener listener = new css3NodeListener(true);
      new ParseTreeWalker().walk(listener, new css3Parser(new CommonTokenStream(new css3Lexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/css/test.css")))).stylesheet());
   }
}