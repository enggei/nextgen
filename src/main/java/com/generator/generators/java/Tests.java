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
import java.util.Map;

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

   @Test
   public void testJavaGroup() {
      final JavaGroup group = new JavaGroup();
      final JavaGroup.BeanST beanST = group.newBean().
            setPackage("com.test.java").
            setName("User").
            addPropertiesValue(null, "id", "Long").
            addPropertiesValue(null, "firstName", "String").
            addPropertiesValue(null, "lastName", "String").
            addPropertiesValue(null, "password", "String").
            addLexicalValue("lastName").
            addLexicalValue("firstName").
            addEqhaValue("id");
      System.out.println(beanST);

      System.out.println(beanST.getPackage() + " " + beanST.getName());
      for (Object o : beanST.getLexicalValues()) {
         System.out.println("lexical " + o);
      }

      for (Map<String, Object> map : beanST.getProperties()) {
         System.out.println("property ");
         for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("\t" + entry.getKey() + " " + entry.getValue());
         }
      }

      final JavaParser parser = new JavaParser(new CommonTokenStream(new JavaLexer(CharStreams.fromString(beanST.toString()))));

      final JavaParserNodeListener listener = new JavaParserNodeListener(true);
      new ParseTreeWalker().walk(listener, parser.compilationUnit());
   }
}