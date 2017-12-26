package com.generator.generators.vertx;

import com.generator.ProjectConstants;
import com.generator.generators.java.JavaGroup;
import com.generator.util.VertxUtil;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;
import io.vertx.ext.eventbus.bridge.tcp.impl.protocol.FrameHelper;
import io.vertx.ext.eventbus.bridge.tcp.impl.protocol.FrameParser;

import java.util.UUID;

/**
 * Created 08.09.17.
 */
public class Tests {

   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Tests.class);

   //@Test
   public void testBaseVerticle() {

      final VertxGroup vertxGroup = new VertxGroup();
      log.info(vertxGroup.newBaseRouterVerticle().
            setPackageName(ProjectConstants.TEST_PACKAGE + ".vertx").
            setName("TestBaseVerticle").
            addEndpointsValue("get", "getUser", "user"));
   }

   public static void main(String[] args) {

      final NetClient client = Vertx.vertx().createNetClient();

      client.connect(7000, "192.168.1.13", res -> {
         if (res.succeeded()) {
            log.info("connected");

            NetSocket socket = res.result();
            socket.handler(new FrameParser(resultHandler -> handleMessage(resultHandler.result())));
            socket.closeHandler(aVoid -> {
               log.info("Closed");
            });

            VertxUtil.sendFrame(log, "java.compile", UUID.randomUUID().toString(), new JsonObject().put("canonicalName", "com.test.HelloWorld").put("source", new JavaGroup().newBean().setPackage("com.test").setName("HelloWorld").toString()), socket);

         } else {
            System.out.println("Failed to connect: " + res.cause().getMessage());
         }
      });

   }

   private static void handleMessage(JsonObject result) {
      log.info("message " + result.toString());
   }
}
