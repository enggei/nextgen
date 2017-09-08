package com.generator.generators.antlr;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.ANTLRv4ParserListener;
import com.generator.generators.antlr.parser.ANTLRv4ParserVisitor;
import com.generator.generators.cpp.parser.CPP14Listener;
import com.generator.generators.cpp.parser.CPP14Visitor;
import com.generator.generators.ecmascript.parser.ECMAScriptListener;
import com.generator.generators.ecmascript.parser.ECMAScriptVisitor;
import com.generator.generators.html5.parser.HTMLParserListener;
import com.generator.generators.html5.parser.HTMLParserVisitor;
import com.generator.generators.java.parser.JavaParserListener;
import com.generator.generators.java.parser.JavaParserVisitor;
import com.generator.generators.javareflection.BaseClassVisitor;
import com.generator.generators.json.parser.JSONListener;
import com.generator.generators.json.parser.JSONVisitor;
import com.generator.generators.mysql.parser.MySqlParserListener;
import com.generator.generators.mysql.parser.MySqlParserVisitor;
import com.generator.generators.protobuf.parser.ProtobufListener;
import com.generator.generators.protobuf.parser.ProtobufVisitor;
import com.generator.generators.stringtemplate.domain.GeneratedFile;
import com.generator.generators.xml.parser.XMLParserListener;
import com.generator.generators.xml.parser.XMLParserVisitor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created 08.09.17.
 */
public class AntlrGenerator {

   public static void main(String[] args) {
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".antlr.parserg4", "ANTLRv4Parser", ANTLRv4ParserVisitor.class, ANTLRv4ParserListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".cpp.parserg4", "CPP14", CPP14Visitor.class, CPP14Listener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".ecmascript.parserg4", "ECMAScript", ECMAScriptVisitor.class, ECMAScriptListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".html5.parserg4", "HTMLParser", HTMLParserVisitor.class, HTMLParserListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".java.parserg4", "JavaParser", JavaParserVisitor.class, JavaParserListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".json.parserg4", "JSON", JSONVisitor.class, JSONListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".mysql.parserg4", "MySqlParser", MySqlParserVisitor.class, MySqlParserListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".protobuf.parserg4", "Protobuf", ProtobufVisitor.class, ProtobufListener.class);
      AntlrGenerator.generateVisitorAndListener(ProjectConstants.MAIN_ROOT, ProjectConstants.GENERATORS_PACKAGE + ".xml.parserg4", "XMLParser", XMLParserVisitor.class, XMLParserListener.class);

   }

   private static void generateVisitorAndListener(String root, String packageName, String parserName, Class visitorInterface, Class listenerInterface) {
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

         this.baseParserListenerST = new AntlrGroup().newBaseParserListener().
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