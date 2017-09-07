package com.generator.generators.javareflection;

import com.generator.generators.antlr.AntlrGroup;
import com.generator.generators.antlr.parser.ANTLRv4ParserListener;
import com.generator.generators.java.parser.JavaParserListener;
import com.generator.generators.mysql.parser.MySqlParserListener;
import com.generator.generators.stringtemplate.parser.STGParserListener;
import com.generator.generators.stringtemplate.parser.STParser;
import com.generator.generators.stringtemplate.parser.STParserListener;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.generators.xml.parser.XMLParserListener;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created 24.08.17.
 */
public class ParserNodeListenerGenerator extends BaseClassVisitor {

   private final String packageName;
   private final String baseVisitorName;

   private final AntlrGroup.BaseParserListenerST baseParserListenerST;

   public ParserNodeListenerGenerator(String packageName, String parserName) {
      this.packageName = packageName;
      this.baseVisitorName = parserName + "BaseListener";

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
         GeneratedFile.newJavaFile("/home/goe/projects/nextgen/src/main/java", packageName, baseVisitorName).write(baseParserListenerST);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new ParserNodeListenerGenerator("com.generator.generators.mysql.parser", "MySql").visit(MySqlParserListener.class);
      new ParserNodeListenerGenerator("com.generator.generators.antlr.parser", "ANTLRv4").visit(ANTLRv4ParserListener.class);
      new ParserNodeListenerGenerator("com.generator.generators.java.parser", "Java").visit(JavaParserListener.class);
      new ParserNodeListenerGenerator("com.generator.generators.xml.parser", "XML").visit(XMLParserListener.class);
   }
}