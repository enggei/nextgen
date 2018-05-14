package com.generator.generators.project;

import com.generator.ProjectConstants;
import com.generator.util.GeneratedFile;

import java.io.IOException;


public class Tests {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);
   //@Test
   public void testProjectGroup() throws IOException {

      final ProjectGroup projectGroup = new ProjectGroup();

      final ProjectGroup.ProjectST projectST = projectGroup.newProject().
            setName("TestProject").
            setArtifactId("artifactId").
            setGroupId("groupId").
            setVersion("0.1").
            setComments("Test project").
            setPackageName(ProjectConstants.TEST_PACKAGE + ".project").
            //setRoot(ProjectConstants.TEST_ROOT).
            addGeneratorsValue("Java", ProjectConstants.GENERATORS_PACKAGE + ".java").
            addGeneratorsValue("Maven", ProjectConstants.GENERATORS_PACKAGE + ".maven").
            addGeneratorsValue("BerkeleyDB", ProjectConstants.GENERATORS_PACKAGE + ".berkeleyDB").
            addGeneratorsValue("Html5", ProjectConstants.GENERATORS_PACKAGE + ".html5");
      log.info(projectST.toString());
      GeneratedFile.newJavaFile(ProjectConstants.TEST_ROOT, ProjectConstants.TEST_PACKAGE + ".project", "TestProject").write(projectST);
   }
}