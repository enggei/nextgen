package com.generator.generators.docker;

import org.junit.Test;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * Created 15.09.17.
 */
public class Tests {

   @Test
   public void testBuild() throws InterruptedException, TimeoutException, IOException {

      final InputStream stream = new ByteArrayInputStream("bnt2st2\n" .getBytes(StandardCharsets.UTF_8.name()));

      final File directory = new File("/home/goe/projects/nextgen/src/test/java");

      new ProcessExecutor().
            directory(directory).
            command("sudo", "-S", "docker", "build", "-t", "reacttest", "-f", "Dockerfile", ".").
            redirectOutput(new LogOutputStream() {
               @Override
               protected void processLine(String line) {
                  System.out.println(line);
               }
            }).
            redirectInput(stream).
            execute();
   }

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