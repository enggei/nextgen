package com.generator.generators.java;

import com.generator.generators.java.parser.JavaBaseVisitor;
import com.generator.generators.java.parser.JavaLexer;
import com.generator.generators.java.parser.JavaParser;
import com.generator.util.FileUtil;
import com.github.javaparser.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.BitSet;

public class JavaTests {


   @Test
   public void testParseJava() throws IOException {

      for (File file : FileUtil.findAllFilesWhichEndsWith("/home/goe/projects/nextgen/src/main/java", ".java")) {
         System.out.println(file.getAbsolutePath());

         final JavaLexer markupLexer = new JavaLexer(CharStreams.fromFileName(file.getAbsolutePath()));
         final JavaParser markupParser = new JavaParser(new CommonTokenStream(markupLexer));

//         markupParser.addErrorListener(new ANTLRErrorListener() {
//            @Override
//            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
//               System.out.println("syntax fuck");
//            }
//
//            @Override
//            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
//               System.out.println("syntax ambigious as fuck");
//            }
//
//            @Override
//            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
//               System.out.println("reatempting fuck");
//            }
//
//            @Override
//            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
//               System.out.println("sensitive as fuck");
//            }
//         });

         JavaBaseVisitor visitor = new JavaBaseVisitor() {
            @Override
            public Object visitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
               return super.visitClassDeclaration(ctx);
            }
         };

         visitor.visit(markupParser.compilationUnit());
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