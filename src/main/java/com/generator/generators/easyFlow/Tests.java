package com.generator.generators.easyFlow;

import com.generator.ProjectConstants;
import com.generator.generators.stringtemplate.GeneratedFile;
import org.junit.Test;

/**
 * Created 08.09.17.
 */
public class Tests {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);
   //@Test
   public void testEasyFlowGroup() {
      final EasyFlowGroup easyFlowGroup = new EasyFlowGroup();

      log.info(easyFlowGroup.neweasyFlow().
            setPackage(ProjectConstants.TEST_PACKAGE+".easyFlow").
            setName("TestFSM").toString());

      GeneratedFile.newJavaFile(ProjectConstants.TEST_ROOT,ProjectConstants.TEST_PACKAGE+".easyFlow", "TestFSM");
   }
}
