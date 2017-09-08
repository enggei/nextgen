package com.generator.generators.easyFlow;

import com.generator.ProjectConstants;
import com.generator.generators.templates.domain.GeneratedFile;
import org.junit.Test;

/**
 * Created 08.09.17.
 */
public class Tests {

   @Test
   public void testEasyFlowGroup() {
      final EasyFlowGroup easyFlowGroup = new EasyFlowGroup();

      System.out.println(easyFlowGroup.neweasyFlow().
            setPackage(ProjectConstants.TEST_PACKAGE+".easyFlow").
            setName("TestFSM"));

      GeneratedFile.newJavaFile(ProjectConstants.TEST_ROOT,ProjectConstants.TEST_PACKAGE+".easyFlow", "TestFSM");
   }
}
