package com.generator.generators.antlr;

import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4NodeListener;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 25.08.17.
 */
public class AntlrTests {

   @Test
   public void testParser() throws IOException {

      final String[] filenames = new String[]{
            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/antlr/parser/ANTLRv4Parser.g4",
//            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/mysql/parser/MySqlParser.g4",
//            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/java/parser/Java.g4"
      };

      for (String fileName : filenames) {
         final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(fileName))));

         final ANTLRv4NodeListener listener = new ANTLRv4NodeListener();
         new ParseTreeWalker().walk(listener, parser.grammarSpec());

         visit("", listener.getRoot());
      }
   }

   private void visit(String delim, ANTLRv4NodeListener.Node node) {
      System.out.println(delim + node.name + " (" + node.value + ")");

      for (ANTLRv4NodeListener.Node child : node.children) {
         visit(delim + "\t", child);
      }
   }
}
