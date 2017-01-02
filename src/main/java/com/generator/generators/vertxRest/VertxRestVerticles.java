package com.generator.generators.vertxRest;

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
public class VertxRestVerticles {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(VertxRestVerticles.class);

	private final Vertx vertx;

	public VertxRestVerticles(Vertx vertx) {
		this.vertx = vertx;
	}

	public void newAPIVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, APIVerticle.class.getName(), log, handler);
	} 

	public void newEndMethodFixVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, EndMethodFixVerticle.class.getName(), log, handler);
	} 

	public void newValidatingNeoHandlerVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, ValidatingNeoHandlerVerticle.class.getName(), log, handler);
	} 

	public static final class APIVerticle extends AbstractVerticle {

		private final VertxRestGroup templateGroup = new VertxRestGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final VertxRestGroup.APIST template = templateGroup.newAPI();

			// string property comments
			consume(vertx, "API_" + deploymentID(), deploymentID() + ".comments", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setComments(message.body());
					message.reply(message.body());
				}
			}); 
			// list property endpoints
			consume(vertx, "API_" + deploymentID(), deploymentID() + ".endpoints", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addEndpointsValue(message.body());
				}
			}); 
			// key-value list property entities
			consume(vertx, "API_" + deploymentID(), deploymentID() + ".entities", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addEntitiesValue(message.body().getString("name"));
				}
			}); 
			// string property name
			consume(vertx, "API_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property packageName
			consume(vertx, "API_" + deploymentID(), deploymentID() + ".packageName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackageName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property properties
			consume(vertx, "API_" + deploymentID(), deploymentID() + ".properties", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addPropertiesValue(message.body().getString("name"));
				}
			}); 
			// key-value list property visitors
			consume(vertx, "API_" + deploymentID(), deploymentID() + ".visitors", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addVisitorsValue(message.body().getString("impl"),message.body().getString("name"));
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
		public static void sendAddEndpoints(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".endpoints", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendEndpointsMessage " + id + ".endpoints " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddEntities(Vertx vertx, java.util.UUID id, Object content, String name, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("name", name);

			sendMessage(vertx, id + ".entities", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendEntitiesMessage " + id + ".entities " + parameters.encode() + " failed", t);
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
		public static void sendAddProperties(Vertx vertx, java.util.UUID id, Object content, String name, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("name", name);

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
		public static void sendAddVisitors(Vertx vertx, java.util.UUID id, Object content, String impl, String name, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("impl", impl)
				.put("name", name);

			sendMessage(vertx, id + ".visitors", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendVisitorsMessage " + id + ".visitors " + parameters.encode() + " failed", t);
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

	public static final class EndMethodFixVerticle extends AbstractVerticle {

		private final VertxRestGroup templateGroup = new VertxRestGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final VertxRestGroup.endMethodFixST template = templateGroup.newendMethodFix();


			// toString method. todo: add all Object methods, for convenience...
			consume(vertx, deploymentID(), deploymentID() + ".toString", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					message.reply(template.toString());
				}
			});

			startFuture.complete();
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

	public static final class ValidatingNeoHandlerVerticle extends AbstractVerticle {

		private final VertxRestGroup templateGroup = new VertxRestGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final VertxRestGroup.validatingNeoHandlerST template = templateGroup.newvalidatingNeoHandler();

			// string property action
			consume(vertx, "validatingNeoHandler_" + deploymentID(), deploymentID() + ".action", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setAction(message.body());
					message.reply(message.body());
				}
			}); 
			// string property apiName
			consume(vertx, "validatingNeoHandler_" + deploymentID(), deploymentID() + ".apiName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setApiName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property uri
			consume(vertx, "validatingNeoHandler_" + deploymentID(), deploymentID() + ".uri", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setUri(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property validations
			consume(vertx, "validatingNeoHandler_" + deploymentID(), deploymentID() + ".validations", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addValidationsValue(message.body().getString("property"),message.body().getString("validationType"));
				}
			}); 
			// string property visitor
			consume(vertx, "validatingNeoHandler_" + deploymentID(), deploymentID() + ".visitor", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setVisitor(message.body());
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


		 public static void sendActionMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".action", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendActionMessage " + id + ".action failed", t);
				}
			});
		}  

		 public static void sendApiNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".apiName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendApiNameMessage " + id + ".apiName failed", t);
				}
			});
		}  

		 public static void sendUriMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".uri", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendUriMessage " + id + ".uri failed", t);
				}
			});
		}  
		public static void sendAddValidations(Vertx vertx, java.util.UUID id, Object content, String property, String validationType, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("property", property)
				.put("validationType", validationType);

			sendMessage(vertx, id + ".validations", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendValidationsMessage " + id + ".validations " + parameters.encode() + " failed", t);
				}
			});
		} 

		 public static void sendVisitorMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".visitor", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendVisitorMessage " + id + ".visitor failed", t);
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

		final VertxRestVerticles verticles = new VertxRestVerticles(vertx);
		verticles.newAPIVerticle(loggingHandler(vertx));
		verticles.newEndMethodFixVerticle(loggingHandler(vertx));
		verticles.newValidatingNeoHandlerVerticle(loggingHandler(vertx));		
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