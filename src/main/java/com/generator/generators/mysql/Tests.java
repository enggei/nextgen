package com.generator.generators.mysql;

import com.generator.ProjectConstants;
import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.util.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;
import java.util.Stack;

/**
 * Created 24.03.17.
 */
public class Tests {

   @Test
   public void testTablesToQueries() throws Exception {

      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");
      final Set<String> tables = session.getTables();
      final MySqlToQueriesGenerator queriesGenerator = new MySqlToQueriesGenerator(true);
      for (String table : tables) new ParseTreeWalker().walk(queriesGenerator, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).root());
      final Stack<MysqlGroup.selectST> selectSTStack = queriesGenerator.done();

      final BufferedWriter sql = new BufferedWriter(new FileWriter(FileUtil.tryToCreateFileIfNotExists(new File(ProjectConstants.TEST_ROOT, "mysql/queries.sql"))));
      while (!selectSTStack.isEmpty()) {
         final String query = selectSTStack.pop().toString();
         sql.write(query.toString());
         sql.newLine();
         new ParseTreeWalker().walk(new MySqlParserNodeListener(false), new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(query.toUpperCase())))).root());
      }
      sql.close();
   }

   @Test
   public void testTablesToJavaPojos() throws Exception {

      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      final Set<String> tables = session.getTables();
      final MySqlToPojoGenerator javaGenerator = new MySqlToPojoGenerator(false);
      for (String table : tables) new ParseTreeWalker().walk(javaGenerator, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).sql_statements());
      javaGenerator.done(ProjectConstants.TEST_ROOT, "com.ud.tr");
   }

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