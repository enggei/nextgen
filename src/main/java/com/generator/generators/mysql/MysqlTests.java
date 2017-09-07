package com.generator.generators.mysql;

import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlNodeListener;
import com.generator.generators.mysql.parser.MySqlNodeVisitor;
import com.generator.generators.mysql.parser.MySqlParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.util.Set;
import java.util.Stack;

/**
 * Created 24.03.17.
 */
public class MysqlTests {

   private final Stack<StringBuilder> output = new Stack<>();

   @Test
   public void testMySqlParser() throws Exception {

      MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      final Set<String> tables = session.getTables();

      for (String table : tables) {
         final MySqlParser parser = new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table))));

         final MySqlNodeListener listener = new MySqlNodeListener();
         new ParseTreeWalker().walk(listener, parser.root());
         visit("", listener.getRoot());
      }

      for (StringBuilder stringBuilder : output) {
         System.out.println(stringBuilder.toString());
      }
   }

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
}