package com.generator.generators.javareflection;

import com.generator.generators.antlr.parser.ANTLRv4ParserListener;
import com.generator.generators.mysql.parser.MySqlParserListener;
import com.generator.generators.templates.domain.GeneratedFile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created 24.08.17.
 */
public class ParserNodeListenerGenerator extends BaseClassVisitor {

   private final StringBuilder out = new StringBuilder();
   private final String packageName;
   private final String name;

   public ParserNodeListenerGenerator(String packageName, String parserName) {
      this.packageName = packageName;
      this.name = parserName + "NodeListener";
      out.append("package ").append(packageName).append(";\n\n");
      out.append("public class ").append(name).append(" extends ").append(parserName).append("ParserBaseListener {\n");

      out.append("\n\tpublic static class Node {\n" +
            "\n" +
            "      public final String name;\n" +
            "      public final String value;\n" +
            "      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();\n" +
            "\n" +
            "      public Node(String name, String value) {\n" +
            "         this.name = name;\n" +
            "         this.value = value;\n" +
            "      }\n" +
            "   }\n" +
            "\n" +
            "   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();\n" +
            "\n" +
            "   void onEnter(Node node) {\n" +
            "      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);\n" +
            "      nodeStack.push(node);\n" +
            "   }\n" +
            "\n" +
            "   void onExit() {\n" +
            "      if (nodeStack.size() > 1) nodeStack.pop();\n" +
            "   }\n" +
            "\n" +
            "   public Node getRoot() {\n" +
            "      return nodeStack.peek();\n" +
            "   }\n");

   }

   @Override
   public void onPublicMethod(Method method) {

      // only has one parameter
      final Parameter parameter = method.getParameters()[0];
      final String param = parameter.getType().getCanonicalName() + " " + parameter.getName();

      out.append("\n\t@Override\n");
      out.append("\tpublic ").append(method.getReturnType().getSimpleName()).append(" ").append(method.getName()).append("(").append(param).append(") {\n");
      out.append("\t\t //System.out.println(\"").append(method.getName()).append("\");\n");
      out.append("\t\t //System.out.println(\"\\t\"" + "+ " + parameter.getName() + ".getText());\n");
      if (method.getName().startsWith("enter"))
         out.append("\t\t onEnter(new Node(\"").append(method.getName().substring(5)).append("\", " + parameter.getName() + ".getText()));\n");
      else if (method.getName().startsWith("exit"))
         out.append("\t\t onExit();\n");
      out.append("\t}\n");
   }

   @Override
   public void done() {
      out.append("}");
      System.out.println(out.toString());
      try {
         GeneratedFile.newJavaFile("/home/goe/projects/nextgen/src/main/java", packageName, name).write(out.toString());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new ParserNodeListenerGenerator("com.generator.generators.mysql.parser", "MySql").visit(MySqlParserListener.class);
      new ParserNodeListenerGenerator("com.generator.generators.antlr.parser", "ANTLRv4").visit(ANTLRv4ParserListener.class);
   }
}