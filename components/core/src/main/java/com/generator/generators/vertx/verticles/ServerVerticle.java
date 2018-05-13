package com.generator.generators.vertx.verticles;

import com.generator.generators.vertx.verticles.BaseServerVerticle;
import com.generator.generators.vertx.verticles.DeployVerticle;
import com.generator.generators.vertx.verticles.TcpBridgeVerticle;
import com.generator.util.VertxUtil;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

/**
 * Created 14.12.17.
 */
public class ServerVerticle extends BaseServerVerticle {

   @Override
   protected JsonObject onStart() throws Exception {

      final DeploymentOptions deploymentOptions = new DeploymentOptions().setConfig(config());

      VertxUtil.deploy(vertx, TcpBridgeVerticle.class.getCanonicalName(), deploymentOptions, log, new VertxUtil.SuccessHandler<String>() {

         @Override
         public void onSuccess(String result) {
            VertxUtil.deploy(vertx, DeployVerticle.class.getCanonicalName(), deploymentOptions, log, new VertxUtil.SuccessHandler<String>() {
               @Override
               public void onSuccess(String result) {
                  log.info(result);
               }

               @Override
               public void onFail(Throwable t) {
                  log.error("Failed to deploy", t);
               }
            });
         }

         @Override
         public void onFail(Throwable t) {
            log.error("Server not started successfully", t);
         }
      });

      return super.onStart();
   }

   @Override
   protected void handleShutdown(Message<JsonObject> message) {
      log.warn("Shutdown server !!");
      System.exit(0);
   }
}