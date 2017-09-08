package com.generator.generators.antlr;

import com.generator.generators.javareflection.BaseClassVisitor;
import com.generator.generators.templates.domain.GeneratedFile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created 08.09.17.
 */
public class AntlrGenerator {

   public static void generateVisitorAndListener(String root, String packageName, String parserName, Class visitorInterface, Class listenerInterface) {
      new ParserNodeVisitorGenerator(root, packageName, parserName).visit(visitorInterface);
      new ParserNodeListenerGenerator(root, packageName, parserName).visit(listenerInterface);
   }

   private static final class ParserNodeListenerGenerator extends BaseClassVisitor {

      private final String root;
      private final String packageName;
      private final String baseVisitorName;

      private final AntlrGroup.BaseParserListenerST baseParserListenerST;

      ParserNodeListenerGenerator(String root, String packageName, String parserName) {
         this.root = root;
         this.packageName = packageName;
         this.baseVisitorName = parserName + "NodeListener";

         final AntlrGroup antlrGroup = new AntlrGroup();

         this.baseParserListenerST = antlrGroup.newBaseParserListener().
               setPackageName(packageName).
               setName(baseVisitorName).
               setParser(parserName);
      }

      @Override
      public void onPublicMethod(Method method) {

         // only has one parameter
         final Parameter parameter = method.getParameters()[0];
         final String param = parameter.getType().getCanonicalName();

         if (method.getName().startsWith("enter"))
            baseParserListenerST.addMethodsValue(param, method.getName().substring(5));
      }

      @Override
      public void done() {
         try {
            GeneratedFile.newJavaFile(root, packageName, baseVisitorName).write(baseParserListenerST);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   private static final class ParserNodeVisitorGenerator extends BaseClassVisitor {

      private final String root;
      private final String packageName;
      private final String neoVisitorName;
      private final String baseVisitorName;

      private final AntlrGroup.NeoVisitorST neoVisitorST;
      private final AntlrGroup.BaseNodeVisitorST baseVisitorST;

      ParserNodeVisitorGenerator(String root, String packageName, String parserName) {
         this.root = root;
         this.packageName = packageName;
         this.neoVisitorName = parserName + "NeoVisitor";
         this.baseVisitorName = parserName + "NodeVisitor";

         final AntlrGroup antlrGroup = new AntlrGroup();

         this.neoVisitorST = antlrGroup.newNeoVisitor().
               setPackageName(packageName).
               setName(neoVisitorName).
               setParser(parserName);

         this.baseVisitorST = antlrGroup.newBaseNodeVisitor().
               setPackageName(packageName).
               setName(baseVisitorName).
               setParser(parserName);
      }

      @Override
      public void onPublicMethod(Method method) {
         // only has one parameter (Context)
         final Parameter parameter = method.getParameters()[0];
         final String param = parameter.getType().getCanonicalName();
         // remove 'visit' from method-name (its added for overridden method in template:
         this.neoVisitorST.addMethodsValue(method.getName().substring(5), param);
         this.baseVisitorST.addMethodsValue(method.getName().substring(5), param);
      }

      @Override
      public void done() {
         try {
            GeneratedFile.newJavaFile(root, packageName, neoVisitorName).write(this.neoVisitorST);
            GeneratedFile.newJavaFile(root, packageName, baseVisitorName).write(this.baseVisitorST);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}