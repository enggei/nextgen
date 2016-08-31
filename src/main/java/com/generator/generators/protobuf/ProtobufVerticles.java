package com.generator.generators.protobuf;

import com.generator.util.VertxUtil;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

import static com.generator.util.VertxUtil.*;

/**
 * Facade for creating verticles (currently supports generator verticles, but will add neo-verticles.
 */
public class ProtobufVerticles {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ProtobufVerticles.class);

	private final Vertx vertx;

	public ProtobufVerticles(Vertx vertx) {
		this.vertx = vertx;
	}

	public void newEnumVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, EnumVerticle.class.getName(), log, handler);
	} 

	public void newExtendVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, ExtendVerticle.class.getName(), log, handler);
	} 

	public void newExtensionsVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, ExtensionsVerticle.class.getName(), log, handler);
	} 

	public void newGroupMessagesModelVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, GroupMessagesModelVerticle.class.getName(), log, handler);
	} 

	public void newMessageVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, MessageVerticle.class.getName(), log, handler);
	} 

	public void newMessageFieldVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, MessageFieldVerticle.class.getName(), log, handler);
	} 

	public void newProtobufPackageVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, ProtobufPackageVerticle.class.getName(), log, handler);
	} 

	public static final class EnumVerticle extends AbstractVerticle {

		private final ProtobufGroup templateGroup = new ProtobufGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProtobufGroup.enumST template = templateGroup.newenum();

			// string property comments
			consume(vertx, "enum_" + deploymentID(), deploymentID() + ".comments", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setComments(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "enum_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// list property properties
			consume(vertx, "enum_" + deploymentID(), deploymentID() + ".properties", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addPropertiesValue(message.body());
				}
			}); 

			// toString method. todo: add all Object methods, for convenience...
			consume(vertx, deploymentID(), deploymentID() + ".toString", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					message.reply(template.toString());
				}
			});

			startFuture.complete();
		}


		 public static void sendCommentsMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".comments", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendCommentsMessage " + id + ".comments failed", t);
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
		public static void sendAddProperties(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".properties", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendPropertiesMessage " + id + ".properties " + parameters.encode() + " failed", t);
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
	} 

	public static final class ExtendVerticle extends AbstractVerticle {

		private final ProtobufGroup templateGroup = new ProtobufGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProtobufGroup.extendST template = templateGroup.newextend();

			// string property comments
			consume(vertx, "extend_" + deploymentID(), deploymentID() + ".comments", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setComments(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "extend_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// list property properties
			consume(vertx, "extend_" + deploymentID(), deploymentID() + ".properties", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addPropertiesValue(message.body());
				}
			}); 

			// toString method. todo: add all Object methods, for convenience...
			consume(vertx, deploymentID(), deploymentID() + ".toString", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					message.reply(template.toString());
				}
			});

			startFuture.complete();
		}


		 public static void sendCommentsMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".comments", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendCommentsMessage " + id + ".comments failed", t);
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
		public static void sendAddProperties(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".properties", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendPropertiesMessage " + id + ".properties " + parameters.encode() + " failed", t);
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
	} 

	public static final class ExtensionsVerticle extends AbstractVerticle {

		private final ProtobufGroup templateGroup = new ProtobufGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProtobufGroup.extensionsST template = templateGroup.newextensions();

			// string property max
			consume(vertx, "extensions_" + deploymentID(), deploymentID() + ".max", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setMax(message.body());
					message.reply(message.body());
				}
			}); 
			// string property min
			consume(vertx, "extensions_" + deploymentID(), deploymentID() + ".min", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setMin(message.body());
					message.reply(message.body());
				}
			}); 

			// toString method. todo: add all Object methods, for convenience...
			consume(vertx, deploymentID(), deploymentID() + ".toString", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					message.reply(template.toString());
				}
			});

			startFuture.complete();
		}


		 public static void sendMaxMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".max", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendMaxMessage " + id + ".max failed", t);
				}
			});
		}  

		 public static void sendMinMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".min", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendMinMessage " + id + ".min failed", t);
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
	} 

	public static final class GroupMessagesModelVerticle extends AbstractVerticle {

		private final ProtobufGroup templateGroup = new ProtobufGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProtobufGroup.groupMessagesModelST template = templateGroup.newgroupMessagesModel();

			// string property groupName
			consume(vertx, "groupMessagesModel_" + deploymentID(), deploymentID() + ".groupName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setGroupName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property messages
			consume(vertx, "groupMessagesModel_" + deploymentID(), deploymentID() + ".messages", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addMessagesValue(message.body().getString("name"));
				}
			}); 
			// string property packageName
			consume(vertx, "groupMessagesModel_" + deploymentID(), deploymentID() + ".packageName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackageName(message.body());
					message.reply(message.body());
				}
			}); 

			// toString method. todo: add all Object methods, for convenience...
			consume(vertx, deploymentID(), deploymentID() + ".toString", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					message.reply(template.toString());
				}
			});

			startFuture.complete();
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
		public static void sendAddMessages(Vertx vertx, java.util.UUID id, Object content, String name, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("name", name);

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

		 public static void sendPackageNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".packageName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendPackageNameMessage " + id + ".packageName failed", t);
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
	} 

	public static final class MessageVerticle extends AbstractVerticle {

		private final ProtobufGroup templateGroup = new ProtobufGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProtobufGroup.messageST template = templateGroup.newmessage();

			// string property comments
			consume(vertx, "message_" + deploymentID(), deploymentID() + ".comments", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setComments(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "message_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// list property properties
			consume(vertx, "message_" + deploymentID(), deploymentID() + ".properties", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addPropertiesValue(message.body());
				}
			}); 

			// toString method. todo: add all Object methods, for convenience...
			consume(vertx, deploymentID(), deploymentID() + ".toString", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					message.reply(template.toString());
				}
			});

			startFuture.complete();
		}


		 public static void sendCommentsMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".comments", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendCommentsMessage " + id + ".comments failed", t);
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
		public static void sendAddProperties(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".properties", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendPropertiesMessage " + id + ".properties " + parameters.encode() + " failed", t);
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
	} 

	public static final class MessageFieldVerticle extends AbstractVerticle {

		private final ProtobufGroup templateGroup = new ProtobufGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProtobufGroup.messageFieldST template = templateGroup.newmessageField();

			// string property comments
			consume(vertx, "messageField_" + deploymentID(), deploymentID() + ".comments", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setComments(message.body());
					message.reply(message.body());
				}
			}); 
			// string property defaultValue
			consume(vertx, "messageField_" + deploymentID(), deploymentID() + ".defaultValue", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setDefaultValue(message.body());
					message.reply(message.body());
				}
			}); 
			// string property fieldConstraint
			consume(vertx, "messageField_" + deploymentID(), deploymentID() + ".fieldConstraint", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setFieldConstraint(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "messageField_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property ordinal
			consume(vertx, "messageField_" + deploymentID(), deploymentID() + ".ordinal", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setOrdinal(message.body());
					message.reply(message.body());
				}
			}); 
			// string property packedValue
			consume(vertx, "messageField_" + deploymentID(), deploymentID() + ".packedValue", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackedValue(message.body());
					message.reply(message.body());
				}
			}); 
			// string property type
			consume(vertx, "messageField_" + deploymentID(), deploymentID() + ".type", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setType(message.body());
					message.reply(message.body());
				}
			}); 

			// toString method. todo: add all Object methods, for convenience...
			consume(vertx, deploymentID(), deploymentID() + ".toString", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					message.reply(template.toString());
				}
			});

			startFuture.complete();
		}


		 public static void sendCommentsMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".comments", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendCommentsMessage " + id + ".comments failed", t);
				}
			});
		}  

		 public static void sendDefaultValueMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".defaultValue", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendDefaultValueMessage " + id + ".defaultValue failed", t);
				}
			});
		}  

		 public static void sendFieldConstraintMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".fieldConstraint", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendFieldConstraintMessage " + id + ".fieldConstraint failed", t);
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

		 public static void sendOrdinalMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".ordinal", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOrdinalMessage " + id + ".ordinal failed", t);
				}
			});
		}  

		 public static void sendPackedValueMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".packedValue", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendPackedValueMessage " + id + ".packedValue failed", t);
				}
			});
		}  

		 public static void sendTypeMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".type", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendTypeMessage " + id + ".type failed", t);
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
	} 

	public static final class ProtobufPackageVerticle extends AbstractVerticle {

		private final ProtobufGroup templateGroup = new ProtobufGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProtobufGroup.protobufPackageST template = templateGroup.newprotobufPackage();

			// list property deliverables
			consume(vertx, "protobufPackage_" + deploymentID(), deploymentID() + ".deliverables", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addDeliverablesValue(message.body());
				}
			}); 
			// list property imports
			consume(vertx, "protobufPackage_" + deploymentID(), deploymentID() + ".imports", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addImportsValue(message.body());
				}
			}); 
			// key-value list property options
			consume(vertx, "protobufPackage_" + deploymentID(), deploymentID() + ".options", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOptionsValue(message.body().getString("name"),message.body().getString("value"));
				}
			}); 
			// string property package
			consume(vertx, "protobufPackage_" + deploymentID(), deploymentID() + ".package", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackage(message.body());
					message.reply(message.body());
				}
			}); 

			// toString method. todo: add all Object methods, for convenience...
			consume(vertx, deploymentID(), deploymentID() + ".toString", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					message.reply(template.toString());
				}
			});

			startFuture.complete();
		}

		public static void sendAddDeliverables(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".deliverables", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendDeliverablesMessage " + id + ".deliverables " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddImports(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".imports", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendImportsMessage " + id + ".imports " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOptions(Vertx vertx, java.util.UUID id, Object content, String name, String value, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("name", name)
				.put("value", value);

			sendMessage(vertx, id + ".options", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOptionsMessage " + id + ".options " + parameters.encode() + " failed", t);
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
	} 

	public static void main(String[] args) {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		Vertx vertx = Vertx.vertx();

		final ProtobufVerticles verticles = new ProtobufVerticles(vertx);
		verticles.newEnumVerticle(loggingHandler(vertx));
		verticles.newExtendVerticle(loggingHandler(vertx));
		verticles.newExtensionsVerticle(loggingHandler(vertx));
		verticles.newGroupMessagesModelVerticle(loggingHandler(vertx));
		verticles.newMessageVerticle(loggingHandler(vertx));
		verticles.newMessageFieldVerticle(loggingHandler(vertx));
		verticles.newProtobufPackageVerticle(loggingHandler(vertx));		
	}

	private static VertxUtil.SuccessHandler<String> loggingHandler(Vertx vertx) {
		return new VertxUtil.SuccessHandler<String>() {
			@Override
			public void onSuccess(String id) {
				log.info(" deployed " + id);

				sendMessage(vertx, id + ".toString", id, log, new VertxUtil.SuccessHandler<Message<String> >() {
					@Override
					public void onSuccess(Message<String> result) {
						log.info("sendToStringMessage " + id + ".toString: " + result.body());
					}

					@Override
					public void onFail(Throwable t) {
						log.error("sendToStringMessage " + id + ".toString failed", t);
					}
				});
			}

			@Override
			public void onFail(Throwable t) {
				log.error(" not deployed: " + t.getMessage(), t);
			}
		};
	}
} 