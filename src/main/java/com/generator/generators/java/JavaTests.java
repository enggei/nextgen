package com.generator.generators.java;

import com.generator.generators.java.parser.JavaBaseListener;
import com.generator.generators.java.parser.JavaBaseVisitor;
import com.generator.generators.java.parser.JavaLexer;
import com.generator.generators.java.parser.JavaParser;
import com.generator.util.FileUtil;
import com.github.javaparser.ParseException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JavaTests {


   @Test
   public void testParseJava() throws IOException {
      for (File file : FileUtil.findAllFilesWhichEndsWith("/home/goe/projects/nextgen/src/main/java", ".java")) {
         System.out.println(file.getAbsolutePath());
         parseFile(file);
      }
   }

   private static void parseFile(File file) throws IOException {
      final JavaParser parser = new JavaParser(new CommonTokenStream(new JavaLexer(CharStreams.fromFileName(file.getAbsolutePath()))));

      final JavaBaseListener listener = new JavaBaseListener();
      new ParseTreeWalker().walk(listener, parser.compilationUnit());
//         visit("", listener.getRoot());
   }

   private void visit(String delim, JavaBaseListener.Node node) {
      System.out.println(delim + node.name + " (" + node.value + ")");
      for (JavaBaseListener.Node child : node.children) {
         visit(delim + "\t", child);
      }
   }

   @Test
   public void testJavaGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final JavaGroup group = new JavaGroup();

      // todo add JavaGroup- tests here;

   }

   @Test
   public void testJavaParsingVisitor() throws IOException, ParseException {

      File[] list = FileUtil.list("/home/goe/udc/trailer-report/src/main/java/com/ud/tr/domain", ".java");

      for (int i = 0; i < list.length; i++) {
         File file = list[i];
         System.out.println(file);

      }
   }
}