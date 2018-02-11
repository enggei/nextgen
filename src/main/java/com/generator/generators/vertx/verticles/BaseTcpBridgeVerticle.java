package com.generator.generators.vertx.verticles;

import com.generator.util.VertxUtil;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTcpBridgeVerticle extends AbstractVerticle {

   protected final static Logger log = LoggerFactory.getLogger(BaseTcpBridgeVerticle.class);

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("starting BaseTcpBridgeVerticle");

		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
			@Override
			public JsonObject execute() throws Throwable {
				return onStart();
			}

			@Override
			public void onSuccess(JsonObject result) {
				log.info("started BaseTcpBridgeVerticle successfully : " + result.toString());
				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject>>) message -> handleInstanceMessage(message));
				startFuture.complete();
			}

			@Override
			public void onFail(Throwable t) {
				log.error("failed to start BaseTcpBridgeVerticle : ", t);
				startFuture.fail(t);
			}
		});
	}

	protected JsonObject onStart() throws Exception { return new JsonObject(); } 



	protected void handleInstanceMessage(Message<JsonObject> message) { log.info("handle instance message " + deploymentID() + " " + message.body().toString()); }
}