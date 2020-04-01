package com.generator.neo.vertx;

import com.generator.util.VertxUtil;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public class BaseNeoVerticle extends AbstractVerticle {

   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BaseNeoVerticle.class);

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("starting BaseNeoVerticle");

		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
			@Override
			public JsonObject execute() throws Throwable {
				return onStart();
			}

			@Override
			public void onSuccess(JsonObject result) {
				log.info("started BaseNeoVerticle successfully : " + result.toString());
				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject>>) message -> handleInstanceMessage(message));
				startFuture.complete();
			}

			@Override
			public void onFail(Throwable t) {
				log.error("failed to start BaseNeoVerticle : ", t);
				startFuture.fail(t);
			}
		});
	}

	protected JsonObject onStart() throws Exception { return new JsonObject(); } 

	protected void publishToNeoInstance(JsonObject jsonObject) { log.info("publish to neo.instance " + jsonObject.toString()); vertx.eventBus().publish("neo.instance", jsonObject); }


	protected void handleInstanceMessage(Message<JsonObject> message) { log.info("handle instance message " + deploymentID() + " " + message.body().toString()); }
}