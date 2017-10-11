package com.generator.generators.antlr;

import com.generator.generators.antlr.parser.ANTLRv4ParserListener;
import com.generator.generators.antlr.parser.ANTLRv4ParserVisitor;
import com.generator.generators.domain.NeoVisitorGroup;
import com.generator.generators.java.BaseClassVisitor;
import com.generator.generators.scala.parser.ScalaListener;
import com.generator.generators.scala.parser.ScalaVisitor;
import com.generator.generators.stringtemplate.domain.GeneratedFile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static com.generator.ProjectConstants.GENERATORS_PACKAGE;
import static com.generator.ProjectConstants.MAIN_ROOT;

/**
 * Created 08.09.17.
 */
public class AntlrGenerator {

   public static void main(String[] args) {
      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".antlr.parser", "ANTLRv4Parser", ANTLRv4ParserVisitor.class, ANTLRv4ParserListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".clojure.parser", "Clojure", ClojureVisitor.class, ClojureListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".cpp.parser", "CPP14", CPP14Visitor.class, CPP14Listener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".css.parser", "css3", css3Visitor.class, css3Listener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".csv.parser", "CSV", CSVVisitor.class, CSVListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".cypher.parser", "Cypher", CypherVisitor.class, CypherListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".ecmascript.parser", "ECMAScript", ECMAScriptVisitor.class, ECMAScriptListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".go.parser", "Golang", GolangVisitor.class, GolangListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".html5.parser", "HTMLParser", HTMLParserVisitor.class, HTMLParserListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".java.parser", "JavaParser", JavaParserVisitor.class, JavaParserListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".json.parser", "JSON", JSONVisitor.class, JSONListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".lua.parser", "Lua", LuaVisitor.class, LuaListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".mysql.parser", "MySqlParser", MySqlParserVisitor.class, MySqlParserListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".properties.parser", "properties", propertiesVisitor.class, propertiesListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".protobuf.parser", "Protobuf", ProtobufVisitor.class, ProtobufListener.class);
      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".scala.parser", "Scala", ScalaVisitor.class, ScalaListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".stacktrace.parser", "StackTrace", StackTraceVisitor.class, StackTraceListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".stringtemplate.parserg4", "STParser", STParserVisitor.class, STParserListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".stringtemplate.parserg4", "STGParser", STGParserVisitor.class, STGParserListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".url.parser", "url", urlVisitor.class, urlListener.class);
//      AntlrGenerator.generateVisitorAndListener(MAIN_ROOT, GENERATORS_PACKAGE + ".xml.parser", "XMLParser", XMLParserVisitor.class, XMLParserListener.class);
   }

   private static void generateVisitorAndListener(String root, String packageName, String g4Name, Class visitorInterface, Class listenerInterface) {
      new ParserNodeVisitorGenerator(root, packageName, g4Name).visit(visitorInterface);
      new ParserNodeListenerGenerator(root, packageName, g4Name).visit(listenerInterface);
      new NeoVisitorGenerator(root, packageName, g4Name).visit(listenerInterface);
      new ParserDomainGenerator(root, packageName, g4Name).visit(listenerInterface);
   }

   private static final class ParserDomainGenerator extends BaseClassVisitor {

      private final String root;
      private final String packageName;
      private final String visitorName;

      private final AntlrGroup antlrGroup = new AntlrGroup();
      private final AntlrGroup.AntlrDomainST antlrDomainST;

      ParserDomainGenerator(String root, String packageName, String parserName) {
         this.root = root;
         this.packageName = packageName;
         this.visitorName = parserName + "Domain";

         antlrDomainST = antlrGroup.newAntlrDomain().
               setPackage(packageName).
               setName(visitorName);
      }

      @Override
      public void onPublicMethod(Method method) {

         // only has one parameter
         final Parameter parameter = method.getParameters()[0];

         if (method.getName().startsWith("enter")) {

            final AntlrGroup.AntlrNodeST antlrNodeST = antlrGroup.newAntlrNode().
                  setName(method.getName().substring(5));
            antlrDomainST.addNodesValue(antlrNodeST, method.getName().substring(5));
         }
      }

      @Override
      public void done() {
         try {
            GeneratedFile.newJavaFile(root, packageName, visitorName).write(antlrDomainST);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   private static final class NeoVisitorGenerator extends BaseClassVisitor {

      private final String root;
      private final String packageName;
      private final String visitorName;

      private final NeoVisitorGroup neoVisitorGroup = new NeoVisitorGroup();
      private final NeoVisitorGroup.DomainVisitorST domainVisitorST;

      NeoVisitorGenerator(String root, String packageName, String parserName) {
         this.root = root;
         this.packageName = packageName;
         this.visitorName = parserName + "DomainVisitor";

         domainVisitorST = neoVisitorGroup.newDomainVisitor().
               setPackageName(packageName).
               setName(visitorName);
      }

      @Override
      public void onPublicMethod(Method method) {

         // only has one parameter
         final Parameter parameter = method.getParameters()[0];

         if (method.getName().startsWith("enter")) {
            domainVisitorST.addEntitiesValue(method.getName().substring(5), neoVisitorGroup.newentityVisit().setName(method.getName().substring(5)));
         }
      }

      @Override
      public void done() {
         try {
            GeneratedFile.newJavaFile(root, packageName, visitorName).write(domainVisitorST);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   private static final class ParserNodeListenerGenerator extends BaseClassVisitor {

      private final String root;
      private final String packageName;
      private final String neoListenerName;
      private final String baseListenerName;

      private final AntlrGroup.BaseNodeListenerST baseParserListenerST;
      private final AntlrGroup.NeoListenerST neoListenerST;

      ParserNodeListenerGenerator(String root, String packageName, String parserName) {
         this.root = root;
         this.packageName = packageName;
         this.baseListenerName = parserName + "NodeListener";
         this.neoListenerName = parserName + "NeoListener";

         final AntlrGroup antlrGroup = new AntlrGroup();

         this.neoListenerST = antlrGroup.newNeoListener().
               setPackageName(packageName).
               setName(neoListenerName).
               setParser(parserName);

         this.baseParserListenerST = antlrGroup.newBaseNodeListener().
               setPackageName(packageName).
               setName(baseListenerName).
               setParser(parserName);
      }

      @Override
      public void onPublicMethod(Method method) {

         // only has one parameter
         final Parameter parameter = method.getParameters()[0];
         final String param = parameter.getType().getCanonicalName();

         if (method.getName().startsWith("enter")) {
            baseParserListenerST.addMethodsValue(param, method.getName().substring(5));
            neoListenerST.addMethodsValue(method.getName().substring(5), param);
         }
      }

      @Override
      public void done() {
         try {
            GeneratedFile.newJavaFile(root, packageName, neoListenerName).write(neoListenerST);
            GeneratedFile.newJavaFile(root, packageName, baseListenerName).write(baseParserListenerST);
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
         // remove 'visit' from method-name ('visit' is in template):
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