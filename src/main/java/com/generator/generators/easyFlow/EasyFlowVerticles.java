package com.generator.generators.easyFlow;

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
public class EasyFlowVerticles {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(EasyFlowVerticles.class);

	private final Vertx vertx;

	public EasyFlowVerticles(Vertx vertx) {
		this.vertx = vertx;
	}

	public void newDeclarationVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, DeclarationVerticle.class.getName(), log, handler);
	} 

	public void newEasyFlowVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, EasyFlowVerticle.class.getName(), log, handler);
	} 

	public void newEventsVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, EventsVerticle.class.getName(), log, handler);
	} 

	public void newImplVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, ImplVerticle.class.getName(), log, handler);
	} 

	public void newMvnVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, MvnVerticle.class.getName(), log, handler);
	} 

	public void newStateDeclarationVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StateDeclarationVerticle.class.getName(), log, handler);
	} 

	public void newStatefulContextVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StatefulContextVerticle.class.getName(), log, handler);
	} 

	public void newStatesVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StatesVerticle.class.getName(), log, handler);
	} 

	public void newTransitVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, TransitVerticle.class.getName(), log, handler);
	} 

	public static final class DeclarationVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.declarationST template = templateGroup.newdeclaration();

			// string property name
			consume(vertx, "declaration_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property state
			consume(vertx, "declaration_" + deploymentID(), deploymentID() + ".state", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setState(message.body());
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

		 public static void sendStateMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".state", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStateMessage " + id + ".state failed", t);
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

	public static final class EasyFlowVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.easyFlowST template = templateGroup.neweasyFlow();

			// key-value list property bindings
			consume(vertx, deploymentID(), deploymentID() + ".bindings", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addBindingsValue(message.body().getString("declaration"),message.body().getString("impl"));
				}
			}); 
			// string property context
			consume(vertx, "easyFlow_" + deploymentID(), deploymentID() + ".context", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setContext(message.body());
					message.reply(message.body());
				}
			}); 
			// string property events
			consume(vertx, "easyFlow_" + deploymentID(), deploymentID() + ".events", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setEvents(message.body());
					message.reply(message.body());
				}
			}); 
			// string property extends
			consume(vertx, "easyFlow_" + deploymentID(), deploymentID() + ".extends", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setExtends(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "easyFlow_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property package
			consume(vertx, "easyFlow_" + deploymentID(), deploymentID() + ".package", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackage(message.body());
					message.reply(message.body());
				}
			}); 
			// string property states
			consume(vertx, "easyFlow_" + deploymentID(), deploymentID() + ".states", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setStates(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property superParams
			consume(vertx, deploymentID(), deploymentID() + ".superParams", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addSuperParamsValue(message.body().getString("name"),message.body().getString("type"));
				}
			}); 
			// string property transit
			consume(vertx, "easyFlow_" + deploymentID(), deploymentID() + ".transit", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setTransit(message.body());
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

		public static void sendAddBindings(Vertx vertx, java.util.UUID id, Object content, String declaration, String impl, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("impl", impl);

			sendMessage(vertx, id + ".bindings", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendBindingsMessage " + id + ".bindings " + parameters.encode() + " failed", t);
				}
			});
		} 

		 public static void sendContextMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".context", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendContextMessage " + id + ".context failed", t);
				}
			});
		}  

		 public static void sendEventsMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".events", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendEventsMessage " + id + ".events failed", t);
				}
			});
		}  

		 public static void sendExtendsMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".extends", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendExtendsMessage " + id + ".extends failed", t);
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

		 public static void sendStatesMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".states", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStatesMessage " + id + ".states failed", t);
				}
			});
		}  
		public static void sendAddSuperParams(Vertx vertx, java.util.UUID id, Object content, String name, String type, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("name", name)
				.put("type", type);

			sendMessage(vertx, id + ".superParams", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendSuperParamsMessage " + id + ".superParams " + parameters.encode() + " failed", t);
				}
			});
		} 

		 public static void sendTransitMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".transit", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendTransitMessage " + id + ".transit failed", t);
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

	public static final class EventsVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.eventsST template = templateGroup.newevents();

			// list property events
			consume(vertx, deploymentID(), deploymentID() + ".events", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addEventsValue(message.body());
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

		public static void sendAddEvents(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".events", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendEventsMessage " + id + ".events " + parameters.encode() + " failed", t);
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

	public static final class ImplVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.implST template = templateGroup.newimpl();

			// string property name
			consume(vertx, "impl_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property state
			consume(vertx, "impl_" + deploymentID(), deploymentID() + ".state", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setState(message.body());
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

		 public static void sendStateMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".state", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStateMessage " + id + ".state failed", t);
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

	public static final class MvnVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.mvnST template = templateGroup.newmvn();


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

	public static final class StateDeclarationVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.stateDeclarationST template = templateGroup.newstateDeclaration();

			// string property comment
			consume(vertx, "stateDeclaration_" + deploymentID(), deploymentID() + ".comment", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setComment(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "stateDeclaration_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
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


		 public static void sendCommentMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".comment", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendCommentMessage " + id + ".comment failed", t);
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

	public static final class StatefulContextVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.statefulContextST template = templateGroup.newstatefulContext();

			// string property contextGeneric
			consume(vertx, "statefulContext_" + deploymentID(), deploymentID() + ".contextGeneric", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setContextGeneric(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "statefulContext_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property properties
			consume(vertx, deploymentID(), deploymentID() + ".properties", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addPropertiesValue(message.body().getString("comment"),message.body().getString("modifier"),message.body().getString("name"),message.body().getString("type"),message.body().getString("value"));
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


		 public static void sendContextGenericMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".contextGeneric", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendContextGenericMessage " + id + ".contextGeneric failed", t);
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
		public static void sendAddProperties(Vertx vertx, java.util.UUID id, Object content, String comment, String modifier, String name, String type, String value, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("comment", comment)
				.put("modifier", modifier)
				.put("name", name)
				.put("type", type)
				.put("value", value);

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

	public static final class StatesVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.statesST template = templateGroup.newstates();

			// list property states
			consume(vertx, deploymentID(), deploymentID() + ".states", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addStatesValue(message.body());
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

		public static void sendAddStates(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".states", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStatesMessage " + id + ".states " + parameters.encode() + " failed", t);
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

	public static final class TransitVerticle extends AbstractVerticle {

		private final EasyFlowGroup templateGroup = new EasyFlowGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final EasyFlowGroup.transitST template = templateGroup.newtransit();

			// string property event
			consume(vertx, "transit_" + deploymentID(), deploymentID() + ".event", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setEvent(message.body());
					message.reply(message.body());
				}
			}); 
			// string property isFinish
			consume(vertx, "transit_" + deploymentID(), deploymentID() + ".isFinish", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setIsFinish(message.body());
					message.reply(message.body());
				}
			}); 
			// string property isInit
			consume(vertx, "transit_" + deploymentID(), deploymentID() + ".isInit", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setIsInit(message.body());
					message.reply(message.body());
				}
			}); 
			// string property state
			consume(vertx, "transit_" + deploymentID(), deploymentID() + ".state", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setState(message.body());
					message.reply(message.body());
				}
			}); 
			// list property transits
			consume(vertx, deploymentID(), deploymentID() + ".transits", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addTransitsValue(message.body());
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


		 public static void sendEventMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".event", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendEventMessage " + id + ".event failed", t);
				}
			});
		}  

		 public static void sendIsFinishMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".isFinish", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendIsFinishMessage " + id + ".isFinish failed", t);
				}
			});
		}  

		 public static void sendIsInitMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".isInit", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendIsInitMessage " + id + ".isInit failed", t);
				}
			});
		}  

		 public static void sendStateMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".state", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStateMessage " + id + ".state failed", t);
				}
			});
		}  
		public static void sendAddTransits(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".transits", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendTransitsMessage " + id + ".transits " + parameters.encode() + " failed", t);
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

		final EasyFlowVerticles verticles = new EasyFlowVerticles(vertx);
		verticles.newDeclarationVerticle(loggingHandler(vertx));
		verticles.newEasyFlowVerticle(loggingHandler(vertx));
		verticles.newEventsVerticle(loggingHandler(vertx));
		verticles.newImplVerticle(loggingHandler(vertx));
		verticles.newMvnVerticle(loggingHandler(vertx));
		verticles.newStateDeclarationVerticle(loggingHandler(vertx));
		verticles.newStatefulContextVerticle(loggingHandler(vertx));
		verticles.newStatesVerticle(loggingHandler(vertx));
		verticles.newTransitVerticle(loggingHandler(vertx));		
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