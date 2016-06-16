

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
public class GroupVerticleVerticle extends AbstractVerticle {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(GroupVerticleVerticle.class);

	public static void sendInstanceMessage(Vertx vertx, java.util.UUID instanceId, Handler<String> instanceHandler) {
		sendMessage(vertx, "new.TemplatesVertxGroup.GroupVerticle", instanceId.toString(), log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendGroupVerticleMessage failed");
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


	 public static void sendGroupNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
		sendMessage(vertx, id + ".groupName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendGroupNameMessage " + id + ".groupName failed", t);
			}
		});
	}  

	 public static void sendGroupPackageMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
		sendMessage(vertx, id + ".groupPackage", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendGroupPackageMessage " + id + ".groupPackage failed", t);
			}
		});
	}  
	 public static void sendAddMessages(Vertx vertx, java.util.UUID id, Object content, String consumeMessage, String sendToMessage, Handler<String> instanceHandler) {

		final JsonObject parameters = new JsonObject().put("consumeMessage", consumeMessage)
			.put("sendToMessage", sendToMessage);

		sendMessage(vertx, id + ".messages", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendMessagesMessage " + id + ".messages " + parameters.encode() + " failed", t);
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

	 public static void sendPackageMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
		sendMessage(vertx, id + ".package", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
			@Override
			public void onSuccess(Message<String> result) {
				instanceHandler.handle(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				log.error("sendPackageMessage " + id + ".package failed", t);
			}
		});
	}  

	@Override
	public void start(Future<Void> startFuture) throws Exception {

		final TemplatesVertxGroup templateGroup = new TemplatesVertxGroup();

		consume(vertx, deploymentID(), "new.TemplatesVertxGroup.GroupVerticle", log, new Handler<Message<String> >() {
			@Override
			public void handle(Message<String> idMessage) {

				// new instance of template
				final TemplatesVertxGroup.GroupVerticleST template = templateGroup.newGroupVerticle();





				 // string property groupName
				consume(vertx, deploymentID(), idMessage.body() + ".groupName", log, new Handler<Message<String> >() {
					@Override
					public void handle(Message<String> message) {
						template.setGroupName(message.body());
						message.reply(message.body());
					}
				});     




				 // string property groupPackage
				consume(vertx, deploymentID(), idMessage.body() + ".groupPackage", log, new Handler<Message<String> >() {
					@Override
					public void handle(Message<String> message) {
						template.setGroupPackage(message.body());
						message.reply(message.body());
					}
				});     



				 // key-value list property messages
				consume(vertx, deploymentID(), idMessage.body() + ".messages", log, new Handler<Message<JsonObject> >() {
					@Override
					public void handle(Message<JsonObject> message) {
						template.addMessagesValue(message.body().getString("consumeMessage"),message.body().getString("sendToMessage"));
					}
				});    




				 // string property name
				consume(vertx, deploymentID(), idMessage.body() + ".name", log, new Handler<Message<String> >() {
					@Override
					public void handle(Message<String> message) {
						template.setName(message.body());
						message.reply(message.body());
					}
				});     




				 // string property package
				consume(vertx, deploymentID(), idMessage.body() + ".package", log, new Handler<Message<String> >() {
					@Override
					public void handle(Message<String> message) {
						template.setPackage(message.body());
						message.reply(message.body());
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