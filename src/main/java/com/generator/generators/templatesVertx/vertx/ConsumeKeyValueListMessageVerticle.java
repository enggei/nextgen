

 package com.generator.generators.templatesVertx.vertx;

import com.generator.util.VertxUtil;
import com.generator.generators.templatesVertx.TemplatesVertxGroup;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

import static com.generator.util.VertxUtil.*;

/**
 * goe on 5/20/16.
 */
public class ConsumeKeyValueListMessageVerticle extends AbstractVerticle {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ConsumeKeyValueListMessageVerticle.class);

	public static void sendInstanceMessage(Vertx vertx, java.util.UUID instanceId, Handler<String> instanceHandler) {
		sendMessage(vertx, "new.TemplatesVertxGroup.ConsumeKeyValueListMessage", instanceId.toString(), log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendConsumeKeyValueListMessageMessage failed");
			}
		});
	}

	public static void sendToStringMessage(Vertx vertx, java.util.UUID id, Handler<String> instanceHandler) {
		sendMessage(vertx, id + ".toString", id.toString(), log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendToStringMessage " + id + ".toString failed", t);
			}
	});
}      


	 public static void sendNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
		sendMessage(vertx, id + ".name", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendNameMessage " + id + ".name failed", t);
			}
		});
	}  
	 public static void sendAddParameters(Vertx vertx, java.util.UUID id, Object content, String name, Handler<String> instanceHandler) {

		final JsonObject parameters = new JsonObject().put("name", name);

		sendMessage(vertx, id + ".parameters", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendParametersMessage " + id + ".parameters " + parameters.encode() + " failed", t);
			}
		});
	} 

	@Override
	public void start(Future<Void> startFuture) throws Exception {

		final TemplatesVertxGroup templateGroup = new TemplatesVertxGroup();

		consume(vertx, deploymentID(), "new.TemplatesVertxGroup.ConsumeKeyValueListMessage", log, new Handler<Message<String> >() {
			@Override
			public void handle(Message<String> idMessage) {

				// new instance of template
				final TemplatesVertxGroup.ConsumeKeyValueListMessageST template = templateGroup.newConsumeKeyValueListMessage();





				 // string property name
				consume(vertx, deploymentID(), idMessage.body() + ".name", log, new Handler<Message<String> >() {
					@Override
					public void handle(Message<String> message) {
						template.setName(message.body());
						message.reply(message.body());
					}
				});     



				 // key-value list property parameters
				consume(vertx, deploymentID(), idMessage.body() + ".parameters", log, new Handler<Message<JsonObject> >() {
					@Override
					public void handle(Message<JsonObject> message) {
						template.addParametersValue(message.body().getString("name"));
					}
				});    

				// toString
				consume(vertx, deploymentID(), idMessage.body() + ".toString", log, new Handler<Message<String> >() {
					@Override
					public void handle(Message<String> message) {
						message.reply(template.toString());
					}
				});

				// other convenience methods here

				idMessage.reply(idMessage.body());
			}
		});

		startFuture.complete();
	}

	@Override
	public void stop(Future<Void> stopFuture) throws Exception {
		super.stop(stopFuture);
	}
}   