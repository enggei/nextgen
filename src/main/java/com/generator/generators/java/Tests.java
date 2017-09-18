package com.generator.generators.java;

import com.generator.ProjectConstants;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.java.parser.JavaLexer;
import com.generator.generators.java.parser.JavaParser;
import com.generator.generators.java.parser.JavaParserNodeListener;
import com.generator.util.ClasspathUtil;
import com.generator.util.CompilerUtil;
import com.generator.util.FileUtil;
import com.generator.util.Reflect;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.reflections.Reflections;

import javax.tools.DiagnosticCollector;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.reflections.ReflectionUtils.*;

public class Tests {

   @Test
   public void testParser() {

      final JavaGroup javaGroup = new JavaGroup();

      final JavaGroup.BeanST beanST = javaGroup.newBean().
            setPackage("com.test").
            setName("Hello").
            addPropertiesValue(null, "name", "String").
            addLexicalValue("name");
      beanST.addMethodsValue(javaGroup.newmethod().
            setReturnValue("void").
            setName("add").
            addParametersValue("one", "Integer").
            addParametersValue("two", "Integer").
            addStatementsValue("Integer three = one + two;").
            addStatementsValue("System.out.println(\"three = \" + three);"));
      beanST.addMethodsValue(javaGroup.newBean().
            setName("InnerBean").
            setScope("private").
            addMethodsValue(javaGroup.newmethod().
                  setName("calculate").
                  addParametersValue("test", "Integer").
                  addStatementsValue("test++;")));

      final JavaGroup.BeanST newBean = javaGroup.newBean();

      final JavaParser parser = new JavaParser(new CommonTokenStream(new JavaLexer(CharStreams.fromString(beanST.toString()))));
      final JavaParserNodeListener listener = new JavaParserNodeListener(true) {

         private String init;
         private String propertyName;
         private String propertyType;

         @Override
         public void enterQualifiedName(JavaParser.QualifiedNameContext arg) {
            super.enterQualifiedName(arg);
            if (inPackageDeclaration())
               newBean.setPackage(arg.getText());
         }

         @Override
         public void enterClassDeclaration(JavaParser.ClassDeclarationContext arg) {
            super.enterClassDeclaration(arg);
            newBean.setName(arg.IDENTIFIER());
         }

         @Override
         public void enterClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext arg) {
            super.enterClassOrInterfaceType(arg);
            if (inMemberDeclaration() && inFieldDeclaration() && inTypeType()) propertyType = arg.getText();
         }

         @Override
         public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext arg) {
            super.enterVariableDeclaratorId(arg);
            if(inMemberDeclaration()) propertyName = arg.getText();
         }

         @Override
         public void exitMemberDeclaration(JavaParser.MemberDeclarationContext arg) {
            super.exitMemberDeclaration(arg);
         }

         @Override
         public void exitFieldDeclaration(JavaParser.FieldDeclarationContext arg) {
            super.exitFieldDeclaration(arg);
            newBean.addPropertiesValue(init, propertyName, propertyType);
         }
      };
      new ParseTreeWalker().walk(listener, parser.compilationUnit());

      System.out.println(beanST.toString());
      System.out.println(newBean.toString());
   }

   @Test
   public void testCompile() {

      final JavaGroup.PojoST pojoST = new JavaGroup().newPojo().
            setPackage("com.test").
            setName("Hello").
            addPropertiesValue(null, "String", "name").
            addPropertiesValue(null, "String", "yolo").
            addLexicalValue("name").
            addLexicalValue("yolo");

      final Object instance = new CompilerUtil().newInstance("com.test.Hello", pojoST, new DiagnosticCollector<>());
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


      testReflections();

   }

   @Test
   public void testReflections() {
      Reflections reflections = new Reflections("com.generator");

      Set<Class<? extends DomainPlugin>> subTypes = reflections.getSubTypesOf(DomainPlugin.class);
      System.out.println("classes extending DomainPlugin:");
      for (Class<? extends DomainPlugin> subType : subTypes) {
         System.out.println(subType.getName());
      }

      Set<Method> getters = getAllMethods(DomainPlugin.class, withModifier(Modifier.PUBLIC), withPrefix("get"), withParametersCount(0));
      for (Method getter : getters) {
         System.out.println(getter.getName());
      }
      Set<Method> listMethodsFromCollectionToBoolean = getAllMethods(List.class, withParametersAssignableTo(Collection.class), withReturnType(boolean.class));
      for (Method method : listMethodsFromCollectionToBoolean) {
         System.out.println(method.getName());
      }

      final Set<Field> allFields = getAllFields(DomainPlugin.class);
      for (Field allField : allFields) {
         System.out.println(allField.getName());
      }

   }

   @Test
   public void writeSTG() throws IOException {

      JavaGroup.toSTGFile(new File(ProjectConstants.GENERATORS_ROOT + "java"));
   }

   @Test
   public void testParseJava() throws IOException {
      for (File file : FileUtil.findAllFilesWhichEndsWith(ProjectConstants.MAIN_ROOT, ".java")) {
         System.out.println(file.getAbsolutePath());
         parseFile(file);
      }
   }

   private static void parseFile(File file) throws IOException {
      final JavaParser parser = new JavaParser(new CommonTokenStream(new JavaLexer(CharStreams.fromFileName(file.getAbsolutePath()))));
      final JavaParserNodeListener listener = new JavaParserNodeListener(true);
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