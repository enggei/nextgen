package com.generator.generators.antlr;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserNodeListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created 25.08.17.
 */
public class Tests {

   @Test
   public void testAntlrGroup() {
      System.out.println(new AntlrGroup().newBaseNodeVisitor().
            setPackageName("com.").
            setName("nam").
            setParser("Parser"));
   }

   @Test
   public void testParser() throws IOException {

      final String[] grammarFiles = new String[]{
            "properties/parser/properties.g4"
      };

      for (String fileName : grammarFiles) {
         final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + fileName))));
         final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true);
         new ParseTreeWalker().walk(listener, parser.grammarSpec());
      }
   }
}