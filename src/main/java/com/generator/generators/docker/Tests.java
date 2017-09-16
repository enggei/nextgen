package com.generator.generators.docker;

import org.junit.Test;

/**
 * Created 15.09.17.
 */
public class Tests {

   @Test
   public void testDockerGroup() {
      final DockerGroup dockerGroup = new DockerGroup();

      final DockerGroup.DockerfileST dockerfileST = dockerGroup.newDockerfile().
            setFrom("java:8-jre");

      dockerfileST.addInstructionsValue(dockerGroup.newENVSingle().
            setName("VERTICLE_FILE").
            setValue("Reacttest-0.1-fat.jar"), null);

      dockerfileST.addInstructionsValue(dockerGroup.newENVSingle().
            setName("VERTICLE_HOME").
            setValue("/opt/verticles"), null);

      dockerfileST.setExpose("8080");

      dockerfileST.addInstructionsValue(dockerGroup.newCOPY().
            addSrcValue("target/$VERTICLE_FILE").
            addSrcValue("src/main/resources").
            addSrcValue("src/main/react/index.html").
            addSrcValue("src/main/react/index.js").
            addSrcValue("src/main/react/app.js").
            setDest("$VERTICLE_HOME/"), null);

      dockerfileST.
            addEntrypointValue("sh").
            addEntrypointValue("-c");

      dockerfileST.addInstructionsValue(dockerGroup.newWORKDIR().
            setPath("$VERTICLE_HOME"), null);

      dockerfileST.
            addCmdValue("java -Dlog4j.configuration=log4j.properties -jar $VERTICLE_FILE -conf docker.json");

      System.out.println(dockerfileST);
   }
}