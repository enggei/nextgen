package com.generator.generators.vertx.verticles;

import com.generator.util.VertxUtil;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public class BaseDeployVerticle extends AbstractVerticle {

   protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(BaseDeployVerticle.class);

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("starting BaseDeployVerticle");

		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
			@Override
			public JsonObject execute() throws Throwable {
				return onStart();
			}

			@Override
			public void onSuccess(JsonObject result) {
				log.info("started BaseDeployVerticle successfully : " + result.toString());
				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject>>) message -> handleInstanceMessage(message));
				vertx.eventBus().consumer("deploy.verticle", (Handler<Message<JsonObject>>) message -> handleDeployVerticle(message)); 
				startFuture.complete();
			}

			@Override
			public void onFail(Throwable t) {
				log.error("failed to start BaseDeployVerticle : ", t);
				startFuture.fail(t);
			}
		});
	}

	protected JsonObject onStart() throws Exception { return new JsonObject(); } 


	protected void handleDeployVerticle(Message<JsonObject> message) { log.info("handle message deploy.verticle " + message.body().toString()); } 

	protected void handleInstanceMessage(Message<JsonObject> message) { log.info("handle instance message " + deploymentID() + " " + message.body().toString()); }
}