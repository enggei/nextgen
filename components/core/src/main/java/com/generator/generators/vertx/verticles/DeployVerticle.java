package com.generator.generators.vertx.verticles;

import com.generator.generators.vertx.verticles.BaseDeployVerticle;
import com.generator.util.VertxUtil;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

/**
 * Created 14.12.17.
 */
public class DeployVerticle extends BaseDeployVerticle {

   @Override
   protected void handleDeployVerticle(Message<JsonObject> message) {
      super.handleDeployVerticle(message);

      final String verticle = message.body().getString("verticle");

      final DeploymentOptions deploymentOptions = new DeploymentOptions().
            setConfig(message.body().getJsonObject("config"));

      VertxUtil.deploy(vertx, verticle, deploymentOptions, log, new VertxUtil.SuccessHandler<String>() {
         @Override
         public void onSuccess(String result) {
            message.reply(VertxUtil.newSuccess(result));
         }

         @Override
         public void onFail(Throwable t) {
            message.reply(VertxUtil.newFail(t));
         }
      });
   }
}