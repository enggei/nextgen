package com.generator.generators.java.verticles;

import com.generator.util.VertxUtil;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public class BaseJavaCompileVerticle extends AbstractVerticle {

   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BaseJavaCompileVerticle.class);

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("starting BaseJavaCompileVerticle");

		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
			@Override
			public JsonObject execute() throws Throwable {
				return onStart();
			}

			@Override
			public void onSuccess(JsonObject result) {
				log.info("started BaseJavaCompileVerticle successfully : " + result.toString());
				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject>>) message -> handleInstanceMessage(message));
				vertx.eventBus().consumer("java.compile", (Handler<Message<JsonObject>>) message -> handleCompile(message)); 
				startFuture.complete();
			}

			@Override
			public void onFail(Throwable t) {
				log.error("failed to start BaseJavaCompileVerticle : ", t);
				startFuture.fail(t);
			}
		});
	}

	protected JsonObject onStart() throws Exception { return new JsonObject(); } 


	protected void handleCompile(Message<JsonObject> message) { log.info("handle message java.compile " + message.body().toString()); } 

	protected void handleInstanceMessage(Message<JsonObject> message) { log.info("handle instance message " + deploymentID() + " " + message.body().toString()); }
}