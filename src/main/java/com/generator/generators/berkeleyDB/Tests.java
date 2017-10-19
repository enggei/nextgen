package com.generator.generators.berkeleyDB;

import com.generator.ProjectConstants;
import com.generator.generators.stringtemplate.GeneratedFile;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 08.09.17.
 */
public class Tests {

   @Test
   public void testBerkeleyDB() throws IOException {

      final BerkeleyDBGroup berkeleyDBGroup = new BerkeleyDBGroup();

      final BerkeleyDBGroup.BerkeleyDBST berkeleyDBST = berkeleyDBGroup.newBerkeleyDB().
            setPackageName(ProjectConstants.TEST_PACKAGE + ".berkeleyDB").
            setName("TestDB");
      System.out.println(berkeleyDBST);

      GeneratedFile.newJavaFile(ProjectConstants.TEST_ROOT, ProjectConstants.TEST_PACKAGE+".berkeleyDB","TestDB").write(berkeleyDBST);
   }
}