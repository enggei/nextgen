package com.generator.generators.antlr;

import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserNodeListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 25.08.17.
 */
public class Tests {

   @Test
   public void testAntlrGroup() {
      System.out.println(new AntlrGroup().newBaseNodeVisitor().setPackageName("com.").setName("nam").setParser("Parser"));
   }

   @Test
   public void testParser() throws IOException {

      final String[] filenames = new String[]{
//            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/antlr/parserg4/ANTLRv4Parser.g4",
//            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/mysql/parserg4/MySqlParser.g4",
//            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/protobuf/parserg4/Protobuf.g4",
            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/java/parserg4/JavaParser.g4"
      };

      for (String fileName : filenames) {
         final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(fileName))));
         final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true);
         new ParseTreeWalker().walk(listener, parser.grammarSpec());
      }
   }
}