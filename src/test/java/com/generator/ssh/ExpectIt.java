package com.generator.ssh;

import com.jcraft.jsch.*;
import net.sf.expectit.Expect;
import net.sf.expectit.ExpectBuilder;
import org.junit.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static net.sf.expectit.matcher.Matchers.*;

/**
 * Created by Ernst Sognnes on 07.01.17.
 */
public class ExpectIt {

   @Test
   public void testExpectIt() throws Exception {
      Process process = Runtime.getRuntime().exec("/bin/sh");

      Expect expect = new ExpectBuilder()
            .withInputs(process.getInputStream())
            .withOutput(process.getOutputStream())
            .withTimeout(1, TimeUnit.SECONDS)
            .withExceptionOnFailure()
            .build();
      // try-with-resources is omitted for simplicity
      expect.sendLine("ls -lh");
      // capture the total
      String total = expect.expect(regexp("^total (.*)")).group(1);
      System.out.println("Size: " + total);
      // capture file list
      String list = expect.expect(regexp("\n$")).getBefore();
      // print the result
      System.out.println("List: " + list);
      expect.sendLine("exit");
      // expect the process to finish
      expect.expect(eof());
      // finally is omitted
      process.waitFor();
      expect.close();
   }

   @Test
   public void testExpectItSsh() throws Exception {
      JSch jSch = new JSch();
      Session session = jSch.getSession("new", "sdf.org");
      Properties config = new Properties();
      config.put("StrictHostKeyChecking", "no");
      session.setConfig(config);
      session.connect();
      Channel channel = session.openChannel("shell");
      channel.connect();

      Expect expect = new ExpectBuilder()
            .withOutput(channel.getOutputStream())
            .withInputs(channel.getInputStream(), channel.getExtInputStream())
            .withEchoOutput(System.out)
            .withEchoInput(System.err)
//			.withInputFilters(removeColors(), removeNonPrintable())
            .withExceptionOnFailure()
            .build();
      try {
         expect.expect(contains("[RETURN]"));
         expect.sendLine();
         String ipAddress = expect.expect(regexp("Trying (.*)\\.\\.\\.")).group(1);
         System.out.println("Captured IP: " + ipAddress);
         expect.expect(contains("login:"));
         expect.sendLine("new");
//			expect.expect(contains("(Y/N)"));
         expect.expect(contains("new"));
         expect.expect(contains("BACKSPACE"));
         expect.send("\b");
         expect.expect(regexp(": $"));
      } finally {
         expect.close();
         channel.disconnect();
         session.disconnect();
      }
   }

   @Test
   public void testExpectItSshPKI() throws Exception {
      JSch jSch = new JSch();
      jSch.addIdentity("/home/goe/.ssh/id_rsa");
      Session session = jSch.getSession("sogern", "osiris.itware.no");
      Properties config = new Properties();
      config.put("StrictHostKeyChecking", "no");
      session.setConfig(config);
      session.connect();
      Channel channel = session.openChannel("shell");
      channel.connect();

      Expect expect = new ExpectBuilder()
            .withOutput(channel.getOutputStream())
            .withInputs(channel.getInputStream(), channel.getExtInputStream())
            .withEchoOutput(System.out)
            .withEchoInput(System.err)
//			.withInputFilters(removeColors(), removeNonPrintable())
            .withExceptionOnFailure()
            .build();

      try {
         expect.expect(contains("isis"));
      } finally {
         expect.close();
         channel.disconnect();
         session.disconnect();
      }
   }

   @Test
   public void testJSch() throws Exception {
      JSch jSch = new JSch();
      jSch.addIdentity("/home/sogern/.ssh/id_rsa");
      Session session = jSch.getSession("sogern", "osiris.itware.no");
      Properties config = new Properties();
      config.put("StrictHostKeyChecking", "no");
      session.setConfig(config);
      session.connect();

      ChannelSftp channel = (ChannelSftp)session.openChannel("sftp");
      channel.connect();

      channel.lcd("/home/sogern/Nedlastingar/"); 	// testRun.png
//		channel.mkdir("upload");

      channel.cd("upload");
      channel.put("testRun.png", "testRun.png", new SftpProgressMonitor() {
         @Override
         public void init(int i, String s, String s1, long l) {
            System.out.println("init i:" + i + ", s: " + s + ", s1: " + s1 + ", l: " + l);
         }

         @Override
         public boolean count(long l) {
            System.out.println("count: " + l);
            return true;
         }

         @Override
         public void end() {
            System.out.println("end");
         }
      }, ChannelSftp.OVERWRITE);

      System.out.println("Waiting");

      Thread.sleep(5000);

      System.out.println("Exiting");
      channel.exit();

      channel.disconnect();
      session.disconnect();
   }
}
