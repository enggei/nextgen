package com.generator.generators.mysql;

import com.generator.ProjectConstants;
import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
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
public class Tests {

   @Test
   public void testTablesToJavaPojos() throws Exception {

      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      final Set<String> tables = session.getTables();

      final MySqlToPojoGenerator generator = new MySqlToPojoGenerator(false);
      for (String table : tables) new ParseTreeWalker().walk(generator, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).sql_statements());
      generator.done(ProjectConstants.TEST_ROOT, "com.ud.tr");

      final StringBuilder selects = new StringBuilder();
      while (!currentSelects.isEmpty()) {
         final MysqlGroup.selectST selectST = currentSelects.pop();
         selects.append(selectST.toString()).append("\n");
      }
      System.out.println(selects);
   }

   final MysqlGroup mysqlGroup = new MysqlGroup();
   private final Stack<MysqlGroup.selectST> currentSelects = new Stack<>();

   @Test
   public void testMysqlGroup() {

      final MysqlGroup mysqlGroup = new MysqlGroup();

      System.out.println(mysqlGroup.newcreateDatabase().
            setName("TestDB").
            setScript(mysqlGroup.newcreateTable().
                  setName("TableOne").
                  addColumnsValue(mysqlGroup.newcreateColumn().
                        setName("ColOne").
                        setType("bigint(20)")).
                  addColumnsValue(mysqlGroup.newcreateColumn().
                        setName("ColTwo").
                        setType("varchar(255)"))));

   }

   @Test
   public void testMySqlParser() throws Exception {

      MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      final Set<String> tables = session.getTables();

      for (String table : tables) {
         final MySqlParser parser = new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table))));

         final MySqlParserNodeListener listener = new MySqlParserNodeListener();
         new ParseTreeWalker().walk(listener, parser.root());
         visit("", listener.getRoot());
      }
   }

   private void visit(String delim, MySqlParserNodeListener.Node node) {
      System.out.println(delim + node.name + " (" + node.value + ")");
      for (MySqlParserNodeListener.Node child : node.children)
         visit(delim + "\t", child);
   }
}