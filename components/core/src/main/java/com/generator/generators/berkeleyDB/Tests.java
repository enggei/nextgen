package com.generator.generators.berkeleyDB;

import com.generator.ProjectConstants;
import com.generator.util.GeneratedFile;

import java.io.IOException;

/**
 * Created 08.09.17.
 */
public class Tests {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);

   //@Test
   public void testBerkeleyDB() throws IOException {

      final BerkeleyDBGroup berkeleyDBGroup = new BerkeleyDBGroup();

      final BerkeleyDBGroup.BerkeleyDBST berkeleyDBST = berkeleyDBGroup.newBerkeleyDB().
            setPackageName(ProjectConstants.TEST_PACKAGE + ".berkeleyDB").
            setName("TestDB");
      log.info(berkeleyDBST.toString());

      GeneratedFile.newJavaFile(ProjectConstants.TEST_ROOT, ProjectConstants.TEST_PACKAGE+".berkeleyDB","TestDB").write(berkeleyDBST);
   }
}