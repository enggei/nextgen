package com.generator.generators.mysql;

import com.generator.ProjectConstants;
import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.util.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Stack;

/**
 * Created 24.03.17.
 */
public class Tests {

   @Test
   public void testTablesToJavaPojos() throws Exception {
      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");
      final MySqlToPojoGenerator javaGenerator = new MySqlToPojoGenerator(false);
      for (String table : session.getTables()) new ParseTreeWalker().walk(javaGenerator, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).root());
      javaGenerator.done(ProjectConstants.TEST_ROOT, "com.ud.tr");
   }

   @Test
   public void testTablesToQueries() throws Exception {
      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      final MySqlToQueriesGenerator queriesGenerator = new MySqlToQueriesGenerator(true);
      for (String table : session.getTables()) new ParseTreeWalker().walk(queriesGenerator, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).root());
      final Stack<MysqlGroup.selectST> selectSTStack = queriesGenerator.done();

      // write all generated queries to file
      final BufferedWriter sql = new BufferedWriter(new FileWriter(FileUtil.tryToCreateFileIfNotExists(new File(ProjectConstants.TEST_ROOT, "mysql/queries.sql"))));
      while (!selectSTStack.isEmpty()) {
         final String query = selectSTStack.pop().toString();
         sql.write(query);
         sql.newLine();
         // try to parse each query, to ensure its valid
         new ParseTreeWalker().walk(new MySqlParserNodeListener(false), new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(query.toUpperCase())))).root());
      }
      sql.close();
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
      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");
      for (String table : session.getTables())
         new ParseTreeWalker().walk(new MySqlParserNodeListener(true), new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).root());
   }
}