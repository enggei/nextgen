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
   public void testAntlrGenerator() {

      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".antlr.parser", "ANTLRv4Parser", ANTLRv4ParserVisitor.class, ANTLRv4ParserListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".cpp.parser", "CPP14", CPP14Visitor.class, CPP14Listener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".ecmascript.parser", "ECMAScript", ECMAScriptVisitor.class, ECMAScriptListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".html5.parser", "HTMLParser", HTMLParserVisitor.class, HTMLParserListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".java.parser", "JavaParser", JavaParserVisitor.class, JavaParserListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".json.parser", "JSON", JSONVisitor.class, JSONListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".mysql.parser", "MySqlParser", MySqlParserVisitor.class, MySqlParserListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".protobuf.parser", "Protobuf", ProtobufVisitor.class, ProtobufListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".xml.parser", "XMLParser", XMLParserVisitor.class, XMLParserListener.class);

   }

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