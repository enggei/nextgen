package com.generator.generators.java;

import com.generator.generators.java.parser.JavaLexer;
import com.generator.generators.java.parser.JavaParserNodeListener;
import com.generator.generators.java.parser.JavaParser;
import com.generator.util.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Tests {


   @Test
   public void testParseJava() throws IOException {
      for (File file : FileUtil.findAllFilesWhichEndsWith("/home/goe/projects/nextgen/src/main/java", ".java")) {
         System.out.println(file.getAbsolutePath());
         parseFile(file);
      }
   }

   private static void parseFile(File file) throws IOException {
      final JavaParser parser = new JavaParser(new CommonTokenStream(new JavaLexer(CharStreams.fromFileName(file.getAbsolutePath()))));

      final JavaParserNodeListener listener = new JavaParserNodeListener();
      new ParseTreeWalker().walk(listener, parser.compilationUnit());
//         visit("", listener.getRoot());
   }

   private void visit(String delim, JavaParserNodeListener.Node node) {
      System.out.println(delim + node.name + " (" + node.value + ")");
      for (JavaParserNodeListener.Node child : node.children) {
         visit(delim + "\t", child);
      }
   }

   @Test
   public void testJavaGroup() {
      final JavaGroup group = new JavaGroup();
      System.out.println(group.newBean().
            setPackage("com.test.java").
            setName("User").
            addPropertiesValue(null,"id","Long").
            addPropertiesValue(null,"firstName","String").
            addPropertiesValue(null,"lastName","String").
            addPropertiesValue(null,"password","String").
            addLexicalValue("lastName").
            addLexicalValue("firstName").
            addEqhaValue("id"));

      // todo add JavaGroup- tests here;
   }
}