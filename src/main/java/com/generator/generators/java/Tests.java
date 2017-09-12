package com.generator.generators.java;

import com.generator.generators.java.parser.JavaLexer;
import com.generator.generators.java.parser.JavaParser;
import com.generator.generators.java.parser.JavaParserNodeListener;
import com.generator.util.ClasspathUtil;
import com.generator.util.FileUtil;
import com.generator.util.Reflect;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import javax.tools.DiagnosticCollector;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class Tests {

   @Test
   public void testCompile() {

      final JavaGroup.PojoST pojoST = new JavaGroup().newPojo().
            setPackage("com.test").
            setName("Hello").
            addPropertiesValue(null, "String", "name").
            addPropertiesValue(null, "String", "yolo").
            addLexicalValue("name").
            addLexicalValue("yolo");

      final Object instance = new SourceToInstanceGenerator().newInstance("com.test.Hello", pojoST, new DiagnosticCollector<>());
      System.out.println("instance " + instance.toString());

      final Reflect pojoInstance = Reflect.on(instance);
      pojoInstance.call("setName", "NICE Gary!");
      pojoInstance.call("setYolo", "DONE");

      System.out.println("instance " + instance.toString());
   }

   @Test
   public void testReflection() throws IOException {

      ClasspathUtil.findClasses(s -> {
         try {
            new BaseClassVisitor() {
               @Override
               public void onClass(Package classPackage, String className, Class superClass) {
                  System.out.println(classPackage.getName() + "\n\t" + className);
               }

               @Override
               public void onPublicMethod(Method method) {
                  System.out.println("\t\t" + method.getName());
               }
            }.visit(Class.forName(s));
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         return true;
      });
   }

   @Test
   public void writeSTG() throws IOException {

      JavaGroup.toSTGFile(new File("/home/goe/projects/nextgen/src/main/java/com/generator/generators/java"));
   }

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