package com.generator.generators.mysql;

import com.generator.generators.mysql.parser.*;
import com.generator.util.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created 24.03.17.
 */
public class MysqlTests {

   private final Map<String, ClassBuilder> classBuilderMap = new LinkedHashMap<>();

   @Test
   public void testMySqlParser() throws Exception {

      MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      final Set<String> tables = session.getTables();

      for (String table : tables) {
         final MySqlParser parser = new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table))));

//         final MySqlNodeVisitor visitor = new MySqlNodeVisitor();
//         visitor.visit(parser.root());
//         visit("", visitor.getRoot());

         final MySqlNodeListener listener = new MySqlNodeListener();
         new ParseTreeWalker().walk(listener, parser.root());
         visit("", listener.getRoot());
      }

      for (StringBuilder stringBuilder : output) {
         System.out.println(stringBuilder.toString());
      }

      writeNodeParserListener();
   }

   private void writeNodeParserListener() throws IOException {

      final StringBuilder classDeclaration = new StringBuilder("package com.generator.generators.mysql.parser;\n" +
            "\n" +
            "import java.util.Iterator;\n" +
            "import java.util.Stack;\n" +
            "\n" +
            "public class NodeParserListener extends MySqlParserBaseListener {\n" +
            "\n" +
            "   public static class Node {\n" +
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
            "   private final Stack<Node> nodeStack = new Stack<>();\n" +
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
            "   }");

      for (ClassBuilder classBuilder : classBuilderMap.values()) {
         classDeclaration.append(classBuilder);
      }

      classDeclaration.append("\n}");
//      FileUtil.writeString(classDeclaration.toString(), new File("/home/goe/projects/nextgen/src/main/java/com/generator/generators/mysql/parser/NodeParserListener.java"));
   }

   private final Stack<StringBuilder> output = new Stack<>();

   private void visit(String delim, MySqlNodeListener.Node node) {
      System.out.println(delim + node.name + " (" + node.value + ")");

      if ("ColCreateTable".equals(node.name)) {
         output.push(new StringBuilder("CREATE TABLE "));
      } else if ("Table_name".equals(node.name)) {
         output.peek().append(node.children.iterator().next().value).append(" {");
      } else if("ColumnDefinition".equals(node.name)) {
         output.peek().append("\n\t").append(node.children.iterator().next().value);
      } else if("Column_definition".equals(node.name)) {
         for (MySqlNodeListener.Node child : node.children) {
            if("DimensionDatatype".equals(child.name)) {
               output.peek().append(child.value);
            }
         }
         output.peek().append(" ");
      }

      for (MySqlNodeListener.Node child : node.children) {
         visit(delim + "\t", child);
      }
   }

   private void visit(String delim, MySqlNodeVisitor.Node node) {
      System.out.println(delim + node.name + " (" + node.value + ")");
      for (MySqlNodeVisitor.Node child : node.children) {
         visit(delim + "\t", child);
      }
   }

   private final class ClassBuilder {

      private final String name;
      private final Set<String> children = new LinkedHashSet<>();

      private ClassBuilder(String name) {
         this.name = name;
      }

      @Override
      public String toString() {
         final StringBuilder classDeclaration = new StringBuilder("\npublic static final class " + name + " {\n" +
               "\n" +
               "      private final Node node;\n" +
               "\n" +
               "      public " + name + "(Node node) {\n" +
               "         this.node = node;\n" +
               "      }\n");

         classDeclaration.append("\n      public String value() {\n" +
               "         return node.value;\n" +
               "      }");

         if (children.size() == 1) {
            final String child = children.iterator().next();
            classDeclaration.append("\n\tpublic " + child + " get" + child + "() { return new " + child + "(node.children.iterator().next()); }");
         } else {
            for (String child : children) {
               classDeclaration.append("\n\tpublic Iterable<" + child + "> get" + child + "() {\n" +
                     "         return () -> {\n" +
                     "            final Iterator<Node> iterator = node.children.iterator();\n" +
                     "            return new Iterator<" + child + ">() {\n" +
                     "\n" +
                     "               Node next = null;\n" +
                     "\n" +
                     "               @Override\n" +
                     "               public boolean hasNext() {\n" +
                     "                  while (iterator.hasNext()) {\n" +
                     "                     next = iterator.next();\n" +
                     "                     if (\"" + child + "\".equals(next.name)) return true;\n" +
                     "                  }\n" +
                     "                  return false;\n" +
                     "               }\n" +
                     "\n" +
                     "               @Override\n" +
                     "               public " + child + " next() {\n" +
                     "                  return next == null ? null : new " + child + "(next);\n" +
                     "               }\n" +
                     "            };\n" +
                     "         };\n" +
                     "      }");
            }
         }
         classDeclaration.append("\n}");

         return classDeclaration.toString();
      }
   }


}