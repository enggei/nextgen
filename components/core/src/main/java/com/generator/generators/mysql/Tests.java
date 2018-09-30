package com.generator.generators.mysql;

import com.generator.ProjectConstants;
import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.generators.mysql.parser.MySqlParserNodeVisitor;
import com.generator.util.FileUtil;
import com.generator.util.MySQLUtil;
import com.generator.util.StringUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created 24.03.17.
 */
public class Tests {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);

   @Test
   public void tmp() throws IOException {
      new MysqlGroup().toSTGFile(new File("/home/goe/projects/nextgen/components/core/src/main/java/com/generator/generators/mysql/"));
   }


   //@Test
   public void testParseSQLQuery() {

      String sql = MySQLUtil.preprocessSQL("select * FROM 'filmweb_admissions' whERE 'screenId'=1 AND 'cinemaCompId'=15;");
      new ParseTreeWalker().walk(new MySqlParserNodeListener(true) { }, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(sql)))).root());

      sql = MySQLUtil.preprocessSQL("select * FROM 'filmweb_admissions', 'screens' whERE 'screenId'=1 AND 'cinemaCompId'=15;");
      new ParseTreeWalker().walk(new MySqlParserNodeListener(true) { }, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(sql)))).root());

      sql = MySQLUtil.preprocessSQL("select * FROM 'filmweb_admissions' adm, 'screens' scr whERE 'screenId'=1 AND 'cinemaCompId'=15 and adm.id=scr.id;");
      new ParseTreeWalker().walk(new MySqlParserNodeListener(true) { }, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(sql)))).root());
   }

   //@Test
   public void testMysqlWithForeignKeys() throws Exception {
      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      final StringBuilder output = new StringBuilder();
      for (String table : session.getTables()) {
         final MySqlParser mySqlParser = new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table))));
         final MySqlParserNodeListener nodeListener = new MySqlParserNodeListener(true) {

            @Override
            public void enterId_(MySqlParser.Id_Context arg) {
               super.enterId_(arg);

               if (inConstraintDefinition() && inTblConstrFK() && inIndex_colname_list() && inIndex_col_name()) {
                  output.append(" column ").append(arg.getText());

               } else if (inConstraintDefinition() && inReference_definition() && inTable_name()) {
                  output.append(" reference table ").append(arg.getText());

               } else if (inConstraintDefinition() && inTblConstrFK()) {
                  output.append("\n\tforeign key ").append(arg.getText());
               } else if (!inConstraintDefinition() && inColCreateTable() && inTable_name()) {
                  output.append("\n").append(arg.getText());
               } else if (inTblConstrPK() && inIndex_col_name()) {
                  output.append("\n\tprimary key ").append(arg.getText());
               } else if (inColumnDefinition()) {
                  output.append("\n\tcolumn ").append(arg.getText());
               }
            }

            @Override
            public void enterDimensionDatatype(MySqlParser.DimensionDatatypeContext arg) {
               super.enterDimensionDatatype(arg);
               output.append(" type ").append(arg.getText());
            }

            @Override
            public void enterCharDatatype(MySqlParser.CharDatatypeContext arg) {
               super.enterCharDatatype(arg);
               output.append(" type ").append(arg.getText());
            }

            @Override
            public void enterSimpleDatatype(MySqlParser.SimpleDatatypeContext arg) {
               super.enterSimpleDatatype(arg);
               output.append(" type ").append(arg.getText());
            }

            @Override
            public void enterColConstrAuInc(MySqlParser.ColConstrAuIncContext arg) {
               super.enterColConstrAuInc(arg);
               output.append(" autoincrement ");
            }

            @Override
            public void enterEngine_name(MySqlParser.Engine_nameContext arg) {
               super.enterEngine_name(arg);
               output.append("\n\tEngine ").append(arg.getText());
            }

            @Override
            public void enterCharset_name_base(MySqlParser.Charset_name_baseContext arg) {
               super.enterCharset_name_base(arg);
               output.append("\n\tCharset ").append(arg.getText());
            }
         };
         new ParseTreeWalker().walk(nodeListener, mySqlParser.root());
      }

      log.info(output.toString());
   }

   //@Test
   public void testTablesToJavaPojos() throws Exception {
      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");
      final MySqlToPojoGenerator javaGenerator = new MySqlToPojoGenerator(false);
      for (String table : session.getTables())
         new ParseTreeWalker().walk(javaGenerator, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).root());
      javaGenerator.done(ProjectConstants.TEST_ROOT, "com.ud.tr");
   }

   //@Test
   public void testTablesToQueries() throws Exception {
      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      final MySqlToQueriesGenerator queriesGenerator = new MySqlToQueriesGenerator(true);
      for (String table : session.getTables())
         new ParseTreeWalker().walk(queriesGenerator, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).root());
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

   //@Test
   public void testMysqlGroup() {

      final MysqlGroup mysqlGroup = new MysqlGroup();

      log.info(mysqlGroup.newcreateDatabase().
            setName("TestDB").
            setScript(mysqlGroup.newcreateTable().
                  setName("TableOne").
                  addColumnsValue(mysqlGroup.newcreateColumn().
                        setName("ColOne").
                        setType("bigint(20)")).
                  addColumnsValue(mysqlGroup.newcreateColumn().
                        setName("ColTwo").
                        setType("varchar(255)"))).toString());

   }

   @Test
   public void testMySqlParser() throws Exception {
      final MySQLSession session = new MySQLSession("127.0.0.1", "tr", "root", "root");

      for (String table : session.getTables()) {
         final MySqlParserNodeListener listener = new MySqlParserNodeListener(true) {
         };
         new ParseTreeWalker().walk(listener, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table.replaceAll(" DEFAULT `0`",""))))).root());
      }
   }
}