package com.generator.generators.vertx.verticles;

import com.generator.generators.vertx.verticles.BaseTcpBridgeVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.bridge.BridgeOptions;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge;

/**
 * Created 12.12.17.
 */
public class TcpBridgeVerticle extends BaseTcpBridgeVerticle {

   @Override
   protected JsonObject onStart() throws Exception {

      final TcpEventBusBridge bridge = TcpEventBusBridge.create(
            vertx,
            new BridgeOptions()
                  .addInboundPermitted(new PermittedOptions().setAddressRegex("(.*?)"))
                  .addOutboundPermitted(new PermittedOptions().setAddress("(.*?)")));

      final String tcpAddress = config().getString("host");
      final Integer tcpPort = config().getInteger("vertx.tcp.bridge.port");

      bridge.listen(tcpPort, tcpAddress, res -> {
         if (res.succeeded()) {
            log.info("Listening for TCP connections on " + tcpAddress + ":" + tcpPort);
         } else {
            log.error("Could NOT listen for TCP connections on " + tcpAddress + ":" + tcpPort + " : " + res.cause().getMessage(), res.cause());
         }
      });

      return super.onStart();
   }
}