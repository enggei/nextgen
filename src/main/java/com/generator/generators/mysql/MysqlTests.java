package com.generator.generators.mysql;

import com.generator.generators.mysql.parser.MySQLParser;
import com.generator.util.FileUtil;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.generator.generators.mysql.parser.MySQLParser.createLexer;

/**
 * Created 24.03.17.
 */
public class MysqlTests {

   @Test
   public void testMysqlDomainGroup() throws IOException {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final MysqlDomainGroup group = new MysqlDomainGroup();

      System.out.println(group.newcreateDatabase().setName("TrailerReports"));
   }

   @Test
   public void testMysql() throws IOException {
      load(new File("/media/goe/VERBATIM HD/code/mt-server/server/src/main/sql"));
   }

   private static void load(File dir) throws IOException {

      final File[] list = FileUtil.list(dir.getAbsolutePath());
      for (File file : list) {
         if (file.isDirectory()) load(file);
         if (!file.getName().endsWith(".sql")) continue;

         System.out.println(file.getAbsolutePath());

         final MySQLParser parser = new MySQLParser(createLexer(new FileReader(file))) {

            @Override
            public void createTable(String name) {

               System.out.println("\t\ttable: " + name);
            }

            @Override
            public void newColumn(String name) {

               System.out.println("\t\t\t" + name);
            }

            @Override
            public void procedure(String name) {
               System.out.println("\n--------------------------------------\n" + name + "\n--------------------------------------\n");
            }
         };

         // begin parsing at init rule
         ParseTree tree = parser.database();

         // print LISP-style tree
//         System.out.println("\t" + tree.toStringTree(parser));
      }
   }
}
