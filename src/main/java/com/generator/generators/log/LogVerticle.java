package com.generator.generators.log;

import com.generator.util.VertxUtil;
import io.vertx.core.Future;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import org.apache.log4j.spi.LoggingEvent;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created 20.12.17.
 */
public class LogVerticle extends BaseLogVerticle {

   private final AtomicBoolean isRunning = new AtomicBoolean(true);
   private Thread socketThread;

   private final Map<String, Set<String>> loggerNameListeners = new ConcurrentHashMap<>();

   @Override
   protected JsonObject onStart() throws Exception {

      final ServerSocket serverSocket = new ServerSocket(config().getInteger("log.port"));

      socketThread = new Thread(() -> {
         while (isRunning.get()) {
            try {
               new Thread(new SocketNode(serverSocket.accept())).start();
            } catch (IOException e) {
               System.out.println("Could not start socket-node " + e.getMessage());
               e.printStackTrace();
            }
         }
      });

      socketThread.start();

      return new JsonObject().
            put("host", config().getString("host")).
            put("log.port", config().getInteger("log.port"));
   }

   @Override
   public void stop(Future<Void> stopFuture) throws Exception {
      System.out.println("stopping log verticle");
      isRunning.set(false);
      loggerNameListeners.clear();
      Thread.sleep(1500L);
      socketThread = null;
      super.stop(stopFuture);
   }

   @Override
   protected void handleaddLoggerNameListener(Message<JsonObject> message) {
      super.handleaddLoggerNameListener(message);
      final Set<String> loggerListeners = loggerNameListeners.computeIfAbsent(message.body().getString("loggerName"), k -> new ConcurrentSkipListSet<>());
      loggerListeners.add(message.body().getString("address"));
   }

   private final class SocketNode implements Runnable {

      private final Socket socket;
      private final ObjectInputStream ois;

      SocketNode(Socket socket) throws IOException {
         this.socket = socket;
         this.ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
      }

      @Override
      public void run() {
         try {
            if (this.ois != null)
               while (isRunning.get()) {
                  final LoggingEvent logEvent = (LoggingEvent) this.ois.readObject();
                  final JsonObject jsonObject = new JsonObject().
                        put("timestamp", logEvent.getTimeStamp()).
                        put("level", toLevel(logEvent.getLevel().toInt())).
                        put("loggerName", logEvent.getLoggerName()).
                        put("message", logEvent.getMessage());

                  final Set<String> listeners = loggerNameListeners.get(logEvent.getLoggerName());
                  if (listeners != null) {
                     for (String listener : listeners)
                        VertxUtil.sendMessage(vertx, listener, jsonObject, log);
                     System.out.println(jsonObject);
                  }
               }

         } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("Socket node exception " + t.getMessage());
         }
      }

      private String toLevel(int val) {
         switch (val) {
            case -2147483648:
               return "ALL";
            case 5000:
               return "TRACE";
            case 10000:
               return "DEBUG";
            case 20000:
               return "INFO";
            case 30000:
               return "WARN";
            case 40000:
               return "ERROR";
            case 50000:
               return "FATAL";
            case 2147483647:
               return "OFF";
            default:
               return "DEFAULT";
         }
      }
   }
}