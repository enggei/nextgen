package com.generator.util;

import com.jcraft.jsch.*;

import java.io.*;

/**
 * Created 18.10.17.
 */
public class JschUtil {

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
            System.out.println("io update " + formatBytes(total, true));
         }

         @Override
         public boolean cancel() {
            return false;
         }

         @Override
         public void completed(Session session, long total) {
            System.out.println("io update " + formatBytes(total, true) + " in " + formatTime(System.currentTimeMillis() - startTime));
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

   public static void upload(Session session, String lfile, String rfile, IOListener ioListener) throws Exception {

      new Thread(() -> {

         try {
            final ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("scp -t " + rfile);

            final OutputStream out = channel.getOutputStream();
            final InputStream in = channel.getInputStream();

            channel.connect();
            if (checkAck(in) != 0) throw new Exception("Connect Ack error");

            final File _lfile = new File(lfile);
            out.write(("C0644 " + _lfile.length() + " " + (lfile.lastIndexOf('/') > 0 ? lfile.substring(lfile.lastIndexOf('/') + 1) : lfile) + "\n").getBytes("UTF-8"));
            out.flush();
            if (checkAck(in) != 0) throw new Exception("Scp Ack error");

            // send a content of lfile
            final FileInputStream fis = new FileInputStream(lfile);
            long total = 0L;
            byte[] buf = new byte[1024];
            while (true) {

               int len = fis.read(buf, 0, buf.length);
               if (len <= 0) break;
               out.write(buf, 0, len);
               total += len;

               if (total % (1024 * 1024) == 0) {
                  ioListener.update(total);
                  System.out.println("Uploaded " + total + "B");
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

   public static void download(Session session, String lfile, String rfile, IOListener ioListener) throws Exception {
      new Thread(() -> {

         try {
            final String prefix = new File(lfile).isDirectory() ? (lfile + File.separator) : null;

            final ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("scp -f " + rfile);

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

               // read content of lfile
               final FileOutputStream fos = new FileOutputStream(prefix == null ? lfile : prefix + file);
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

   private static String formatBytes(long bytes, boolean si) {
      int unit = si ? 1000 : 1024;
      if (bytes < unit) return bytes + " B";
      int exp = (int) (Math.log(bytes) / Math.log(unit));
      String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
      return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
   }

   private static final long SECONDms = 1000;
   private static final long MINUTEms = SECONDms * 60L;
   private static final long HOURms = MINUTEms * 60L;
   private static final long DAYms = HOURms * 24L;

   private static String formatTime(long runningTime) {

      final boolean negative = runningTime < 0;

      runningTime = Math.abs(runningTime);

      final StringBuilder t = new StringBuilder();
      final long d = runningTime / DAYms;
      if (d > 0L) {
         t.append(" ").append(d).append(" day").append(d == 1 ? "" : "s");
         runningTime %= DAYms;
      }
      final long h = runningTime / HOURms;
      if (h > 0L) {
         t.append(" ").append(h).append(" hour").append(h == 1 ? "" : "s");
         runningTime %= HOURms;
      }
      final long m = runningTime / MINUTEms;
      if (m > 0L) {
         t.append(" ").append(m).append(" minute").append(m == 1 ? "" : "s");
         runningTime %= MINUTEms;
      }
      final long s = runningTime / SECONDms;
      if (s > 0L) {
         t.append(" ").append(s).append(" second").append(s == 1 ? "" : "s");
         runningTime %= SECONDms;
      }

      final String x = t.toString().trim();
      return (negative ? "-" : "") + (x.length() == 0 ? (runningTime + " ms") : x);
   }
}