package com.generator.generators.vertx;

import au.com.ds.ef.err.ExecutionError;
import com.generator.util.VertxUtil;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetClient;
import io.vertx.ext.eventbus.bridge.tcp.impl.protocol.FrameParser;

/**
 * Created 17.12.17.
 */
public class DeployInstance extends DeployInstanceFSM {

   @Override
   protected void connect(DeployInstanceClientContext context) throws Exception {

      final NetClient client = context.vertx.createNetClient();

      client.connect(context.port, context.host, res -> {
         if (res.succeeded()) {
            log.info("connected");

            context.socket = res.result();
            context.socket.handler(new FrameParser(resultHandler -> handleMessage(context, resultHandler.result())));
            context.socket.closeHandler(aVoid -> {
               log.info("Closed");
            });
            context.trigger(Events.connected);

         } else {
            System.out.println("Failed to connect: " + res.cause().getMessage());
         }
      });
   }

   @Override
   protected void instantiationfailed(DeployInstanceClientContext context) throws Exception {
      log.info("error " + context.inbox.peek().toString());
      context.socket.close();
   }

   @Override
   protected void instantiationsuccess(DeployInstanceClientContext context) throws Exception {
      context.socket.close();
   }

   @Override
   protected void deployinstances(DeployInstanceClientContext context) throws Exception {
   }

   @Override
   protected void onERROR(ExecutionError error, DeployInstanceClientContext context) {
      log.info("Error " + error.getMessage(), error.getCause());
   }

   @Override
   protected void handleMessageInDEPLOYINSTANCESState(DeployInstanceClientContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message))
         context.trigger(Events.instanceDeployed);
      else
         context.trigger(Events.instanceFailed);
   }

   @Override
   protected void handleMessage(DeployInstanceClientContext context, JsonObject message) {
      context.inbox.push(message);
      super.handleMessage(context, message);
   }
}