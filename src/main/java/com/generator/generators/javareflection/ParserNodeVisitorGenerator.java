package com.generator.generators.javareflection;

import com.generator.generators.antlr.AntlrGroup;
import com.generator.generators.antlr.parser.ANTLRv4ParserVisitor;
import com.generator.generators.java.parser.JavaParserVisitor;
import com.generator.generators.mysql.parser.MySqlParserVisitor;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.generators.xml.parser.XMLParserVisitor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created 26.08.17.
 */
public class ParserNodeVisitorGenerator extends BaseClassVisitor {

   private final String packageName;
   private final String neoVisitorName;
   private final String baseVisitorName;

   private final AntlrGroup.NeoVisitorST neoVisitorST;
   private final AntlrGroup.BaseNodeVisitorST baseVisitorST;

   ParserNodeVisitorGenerator(String packageName, String parserName) {
      this.packageName = packageName;
      this.neoVisitorName = parserName + "NeoVisitor";
      this.baseVisitorName = parserName + "BaseVisitor";

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
         GeneratedFile.newJavaFile("/home/goe/projects/nextgen/src/main/java", packageName, neoVisitorName).write(this.neoVisitorST);
         GeneratedFile.newJavaFile("/home/goe/projects/nextgen/src/main/java", packageName, baseVisitorName).write(this.baseVisitorST);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new ParserNodeVisitorGenerator("com.generator.generators.mysql.parser", "MySql").visit(MySqlParserVisitor.class);
      new ParserNodeVisitorGenerator("com.generator.generators.antlr.parser", "ANTLRv4").visit(ANTLRv4ParserVisitor.class);
      new ParserNodeVisitorGenerator("com.generator.generators.java.parser", "Java").visit(JavaParserVisitor.class);
      new ParserNodeVisitorGenerator("com.generator.generators.xml.parser", "XML").visit(XMLParserVisitor.class);
   }
}