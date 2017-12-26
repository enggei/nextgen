package com.generator.generators.log;

import com.generator.util.VertxUtil;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public class BaseLogVerticle extends AbstractVerticle {

   protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(BaseLogVerticle.class);

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("starting BaseLogVerticle");

		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
			@Override
			public JsonObject execute() throws Throwable {
				return onStart();
			}

			@Override
			public void onSuccess(JsonObject result) {
				log.info("started BaseLogVerticle successfully : " + result.toString());
				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject>>) message -> handleInstanceMessage(message));
				vertx.eventBus().consumer("log.add.loggerName.listener", (Handler<Message<JsonObject>>) message -> handleaddLoggerNameListener(message)); 
				vertx.eventBus().consumer("log.remove.loggerName.listener", (Handler<Message<JsonObject>>) message -> handleremoveLoggerNameListener(message)); 
				startFuture.complete();
			}

			@Override
			public void onFail(Throwable t) {
				log.error("failed to start BaseLogVerticle : ", t);
				startFuture.fail(t);
			}
		});
	}

	protected JsonObject onStart() throws Exception { return new JsonObject(); } 


	protected void handleaddLoggerNameListener(Message<JsonObject> message) { log.info("handle message log.add.loggerName.listener " + message.body().toString()); } 
	protected void handleremoveLoggerNameListener(Message<JsonObject> message) { log.info("handle message log.remove.loggerName.listener " + message.body().toString()); } 

	protected void handleInstanceMessage(Message<JsonObject> message) { log.info("handle instance message " + deploymentID() + " " + message.body().toString()); }
}