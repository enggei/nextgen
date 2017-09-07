package com.generator.generators.antlr;

import com.generator.generators.antlr.parser.ANTLRv4BaseListener;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created 25.08.17.
 */
public class AntlrTests {

   @Test
   public void testParser() throws IOException {

      final String[] filenames = new String[]{
//            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/antlr/parser/ANTLRv4Parser.g4",
//            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/mysql/parser/MySqlParser.g4",
//            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/protobuf/parser/Protobuf.g4",
            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/java/parser/JavaParser.g4"
      };

      for (String fileName : filenames) {
         final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(fileName))));

         final ANTLRv4BaseListener listener = new ANTLRv4BaseListener();
         new ParseTreeWalker().walk(listener, parser.grammarSpec());

         visitAll("", listener.getRoot());
      }
   }

   private void visitAll(String delim, ANTLRv4BaseListener.Node node) {
      System.out.println(delim + node.name + " (" + node.startToken + ")");
      for (ANTLRv4BaseListener.Node child : node.children) {
         visitAll(delim + "\t", child);
      }
   }
}