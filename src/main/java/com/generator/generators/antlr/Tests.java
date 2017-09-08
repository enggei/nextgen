package com.generator.generators.antlr;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.*;
import com.generator.generators.cpp.parser.CPP14Listener;
import com.generator.generators.cpp.parser.CPP14Visitor;
import com.generator.generators.ecmascript.parser.ECMAScriptListener;
import com.generator.generators.ecmascript.parser.ECMAScriptVisitor;
import com.generator.generators.html5.parser.HTMLParserListener;
import com.generator.generators.html5.parser.HTMLParserVisitor;
import com.generator.generators.java.parser.JavaParserListener;
import com.generator.generators.java.parser.JavaParserVisitor;
import com.generator.generators.json.parser.JSONListener;
import com.generator.generators.json.parser.JSONVisitor;
import com.generator.generators.mysql.parser.MySqlParserListener;
import com.generator.generators.mysql.parser.MySqlParserVisitor;
import com.generator.generators.protobuf.parser.ProtobufListener;
import com.generator.generators.protobuf.parser.ProtobufVisitor;
import com.generator.generators.xml.parser.XMLParserListener;
import com.generator.generators.xml.parser.XMLParserVisitor;
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

         final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener();
         new ParseTreeWalker().walk(listener, parser.grammarSpec());

         visitAll("", listener.getRoot());
      }
   }

   private void visitAll(String delim, ANTLRv4ParserNodeListener.Node node) {
      System.out.println(delim + node.name + " (" + node.startToken + ")");
      for (ANTLRv4ParserNodeListener.Node child : node.children) {
         visitAll(delim + "\t", child);
      }
   }
}