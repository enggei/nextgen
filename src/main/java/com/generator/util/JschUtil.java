package com.generator.util;

import com.jcraft.jsch.*;

import javax.swing.text.BadLocationException;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.generator.util.FormatUtil.formatBytes;
import static com.generator.util.FormatUtil.formatTime;

/**
 * Created 18.10.17.
 */
public class JschUtil {

   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(JschUtil.class);

   public interface IOListener {

      void update(long total);

      boolean cancel();

      void completed(Session session, long total);
   }

   public static IOListener defaultIOListener(boolean disconnectAfter) {
      return new IOListener() {

         final long startTime = System.currentTimeMillis();

         @Override
         public void update(long total) {
            log.info("io update " + formatBytes(total, true));
         }

         @Override
         public boolean cancel() {
            return false;
         }

         @Override
         public void completed(Session session, long total) {
            log.info("io update " + formatBytes(total, true) + " in " + formatTime(System.currentTimeMillis() - startTime));
            if (disconnectAfter) session.disconnect();
         }
      };
   }

   public static Session getSessionUsingPassword(String username, String host, Integer port, String password) throws JSchException {
      final JSch jSch = new JSch();

      final Session session = jSch.getSession(username, host, port);
      session.setUserInfo(new ChannelUserInfo(password));
      session.setPassword(password);

      return connect(session);
   }

   public static Session getSessionUsingPrivateKey(String username, String host, Integer port, String privateKeyPath) throws JSchException {
      final JSch jSch = new JSch();

      final Session session = jSch.getSession(username, host, port);
      jSch.addIdentity(privateKeyPath);

      return connect(session);
   }

   public static abstract class SSHHandler implements Runnable {

      private final DataInputStream dataIn;
      private final DataOutputStream dataOut;
      private final StringBuilder cache = new StringBuilder();
      private final Thread thread;
      private final String installText = "You can install it by typing:\r\n";

      protected boolean isActive = true;

      private final AtomicInteger textBufferLength = new AtomicInteger(5000);
      private String sudoPassword = null;

      public SSHHandler(DataInputStream dataIn, DataOutputStream dataOut) {
         this.dataIn = dataIn;
         this.dataOut = dataOut;
         this.thread = new Thread(this);
         this.thread.start();
      }

      public SSHHandler(Channel channel) throws IOException {

         ((ChannelShell) channel).setPtyType("dumb");
         try {
            channel.connect();
         } catch (JSchException e) {
            throw new IOException("Could not connect to channel");
         }

         this.dataIn = new DataInputStream(channel.getInputStream());
         this.dataOut = new DataOutputStream(channel.getOutputStream());
         this.thread = new Thread(this);
         this.thread.start();
      }

      @Override
      public void run() {
         try {

            byte[] bytes = new byte[1024];
            while (isActive) {

               if (dataIn.available() > 0) {
                  final int read = dataIn.read(bytes);
                  cache.append(new String(bytes, 0, read, "UTF-8"));

                  final String s = cache.toString();
                  if (s.contains("[sudo] password for ") && sudoPassword == null) {
                     checkCache();

                     // todo check for erroneous-password (retry-password)
                     sudoPassword = getSudoPassword();
                     runCommand(dataOut, sudoPassword, false);

                  } else if (s.endsWith("Do you want to continue? [Y/n] ")) {

                     checkCache();

                     runCommand(dataOut, handleContinue(s) + "\n", false);

                  } else if (s.contains(installText)) {
                     checkCache();

                     final int beginIndex = s.indexOf(installText) + installText.length();
                     handleInstall(s.substring(beginIndex, s.indexOf("\r\n", beginIndex)));

                  } else {
                     checkCache();
                     handle(s);
                  }

               } else {

                  onPromptReady();
               }

               Thread.sleep(100L);
            }
         } catch (Throwable t) {
            handleException(cache.toString(), t);
         }
      }

      public void checkCache() {
         if (cache.length() > textBufferLength.get())
            cache.delete(0, cache.length() - textBufferLength.get());
      }

      protected abstract void onPromptReady();

      protected abstract void handleInstall(String installCommand);

      protected abstract String getSudoPassword();

      protected abstract void handle(String cache);

      protected abstract void handleException(String cache, Throwable t);

      protected abstract String handleContinue(String cache);

      protected void write(String command) {
         write(command, false);
      }

      protected void write(String command, boolean asSudeo) {
         runCommand(dataOut, command.endsWith("\n") ? command : (command + "\n"), asSudeo);
      }

      protected void runCommand(DataOutputStream dataOut, String command, boolean asSudo) {
         try {
            dataOut.writeBytes((asSudo ? "sudo " : "") + command + "\n");
            dataOut.flush();
         } catch (Exception e1) {
            e1.printStackTrace();
         }
      }

      public void clearCache() {
         cache.delete(0, cache.length());
      }

      public void close() {
         isActive = false;
      }
   }

   public static void upload(Session session, String localFile, String remoteFile, IOListener ioListener) throws Exception {

      new Thread(() -> {

         try {
            final ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("scp -t " + remoteFile);

            final OutputStream out = channel.getOutputStream();
            final InputStream in = channel.getInputStream();

            channel.connect();
            if (checkAck(in) != 0) throw new Exception("Connect Ack error");

            final File _lfile = new File(localFile);
            out.write(("C0644 " + _lfile.length() + " " + (localFile.lastIndexOf('/') > 0 ? localFile.substring(localFile.lastIndexOf('/') + 1) : localFile) + "\n").getBytes("UTF-8"));
            out.flush();
            if (checkAck(in) != 0) throw new Exception("Scp Ack error");

            // send a content of localFile
            final FileInputStream fis = new FileInputStream(localFile);
            long total = 0L;
            byte[] buf = new byte[1024];
            while (true) {

               int len = fis.read(buf, 0, buf.length);
               if (len <= 0) break;
               out.write(buf, 0, len);
               total += len;

               if (total % (1024 * 1024) == 0) {
                  ioListener.update(total);
                  log.info("Uploaded " + total + "B");
                  if (ioListener.cancel()) break;
               }
            }
            fis.close();

            // send '\0'
            buf[0] = 0;
            out.write(buf, 0, 1);
            out.flush();

            if (checkAck(in) != 0) throw new Exception("File complete Ack error");
            out.close();

            channel.disconnect();

            ioListener.completed(session, total);

         } catch (Exception e) {
            e.printStackTrace();
         }

      }).start();
   }

   public static void download(Session session, String localFile, String remoteFile, IOListener ioListener) throws Exception {
      new Thread(() -> {

         try {
            final String prefix = new File(localFile).isDirectory() ? (localFile + File.separator) : null;

            final ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("scp -f " + remoteFile);

            final OutputStream out = channel.getOutputStream();
            final InputStream in = channel.getInputStream();

            channel.connect();
            byte[] buf = new byte[1024];

            // send '\0'
            buf[0] = 0;
            out.write(buf, 0, 1);
            out.flush();

            long total = 0L;
            while (true) {

               int c = checkAck(in);
               if (c != 'C') break;

               // read '0644 '
               in.read(buf, 0, 5);

               long filesize = 0L;
               while (true) {
                  if (in.read(buf, 0, 1) < 0) break;
                  if (buf[0] == ' ') break;
                  filesize = filesize * 10L + (long) (buf[0] - '0');
               }

               String file;
               for (int i = 0; ; i++) {
                  in.read(buf, i, 1);
                  if (buf[i] == (byte) 0x0a) {
                     file = new String(buf, 0, i);
                     break;
                  }
               }

               // send '\0'
               buf[0] = 0;
               out.write(buf, 0, 1);
               out.flush();

               // read content of localFile
               final FileOutputStream fos = new FileOutputStream(prefix == null ? localFile : prefix + file);
               int foo;
               while (true) {

                  if (buf.length < filesize)
                     foo = buf.length;
                  else
                     foo = (int) filesize;

                  foo = in.read(buf, 0, foo);
                  if (foo < 0) break;

                  total += foo;

                  if (total % (1024 * 1024) == 0) {
                     ioListener.update(total);

                     if (ioListener.cancel()) break;
                  }

                  fos.write(buf, 0, foo);
                  filesize -= foo;

                  if (filesize == 0L) break;
               }
               fos.close();

               if (checkAck(in) != 0) throw new Exception("Error after file transfer");

               // send '\0'
               buf[0] = 0;
               out.write(buf, 0, 1);
               out.flush();
            }

            channel.disconnect();

            ioListener.completed(session, total);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }).start();
   }

   private static Session connect(Session session) throws JSchException {
      java.util.Properties config = new java.util.Properties();
      config.put("StrictHostKeyChecking", "no");
      config.put("TCPKeepAlive", "yes");

      session.setServerAliveInterval(120 * 1000);
      session.setServerAliveCountMax(1000);
      session.setConfig(config);

      session.connect();
      return session;
   }

   private static int checkAck(InputStream in) throws IOException {

      int b = in.read();

      if (b == 0) return b;
      if (b == -1) return b;

      if (b == 1 || b == 2) {
         final StringBuilder sb = new StringBuilder();
         int c;
         do {
            c = in.read();
            sb.append((char) c);
         } while (c != '\n');

         throw new IOException("Ack error " + sb.toString());
      }

      return b;
   }

   private static final class ChannelUserInfo implements UserInfo {

      private final String password;

      private ChannelUserInfo(String password) {
         this.password = password;
      }

      @Override
      public String getPassphrase() {
         return null;
      }

      @Override
      public String getPassword() {
         return password;
      }

      @Override
      public boolean promptPassphrase(String message) {
         return false;
      }

      @Override
      public boolean promptPassword(String message) {
         return false;
      }

      @Override
      public boolean promptYesNo(String message) {
         return true;
      }

      @Override
      public void showMessage(String message) {
      }
   }
}