package com.generator.generators.templatesNeo;

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
public class TemplatesNeoVerticles {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TemplatesNeoVerticles.class);

	private final Vertx vertx;

	public TemplatesNeoVerticles(Vertx vertx) {
		this.vertx = vertx;
	}

	public void newNeoGroupClassDeclarationVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, NeoGroupClassDeclarationVerticle.class.getName(), log, handler);
	} 

	public void newBugfix2Verticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, Bugfix2Verticle.class.getName(), log, handler);
	} 

	public void newDeclarationVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, DeclarationVerticle.class.getName(), log, handler);
	} 

	public void newDefaultNodeTypesVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, DefaultNodeTypesVerticle.class.getName(), log, handler);
	} 

	public void newKeyValueListSetterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, KeyValueListSetterVerticle.class.getName(), log, handler);
	} 

	public void newListSetterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, ListSetterVerticle.class.getName(), log, handler);
	} 

	public void newNewInstanceVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, NewInstanceVerticle.class.getName(), log, handler);
	} 

	public void newStringSetterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StringSetterVerticle.class.getName(), log, handler);
	} 

	public static final class NeoGroupClassDeclarationVerticle extends AbstractVerticle {

		private final TemplatesNeoGroup templateGroup = new TemplatesNeoGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesNeoGroup.NeoGroupClassDeclarationST template = templateGroup.newNeoGroupClassDeclaration();

			// list property comments
			consume(vertx, "NeoGroupClassDeclaration_" + deploymentID(), deploymentID() + ".comments", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addCommentsValue(message.body());
				}
			}); 
			// string property name
			consume(vertx, "NeoGroupClassDeclaration_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property packageName
			consume(vertx, "NeoGroupClassDeclaration_" + deploymentID(), deploymentID() + ".packageName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackageName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property statements
			consume(vertx, "NeoGroupClassDeclaration_" + deploymentID(), deploymentID() + ".statements", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addStatementsValue(message.body().getString("declaration"),message.body().getString("name"),message.body().getString("newInstance"));
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

		public static void sendAddComments(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".comments", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendCommentsMessage " + id + ".comments " + parameters.encode() + " failed", t);
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
		public static void sendAddStatements(Vertx vertx, java.util.UUID id, Object content, String declaration, String name, String newInstance, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("name", name)
				.put("newInstance", newInstance);

			sendMessage(vertx, id + ".statements", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStatementsMessage " + id + ".statements " + parameters.encode() + " failed", t);
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

	public static final class Bugfix2Verticle extends AbstractVerticle {

		private final TemplatesNeoGroup templateGroup = new TemplatesNeoGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesNeoGroup.bugfix2ST template = templateGroup.newbugfix2();


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

	public static final class DeclarationVerticle extends AbstractVerticle {

		private final TemplatesNeoGroup templateGroup = new TemplatesNeoGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesNeoGroup.declarationST template = templateGroup.newdeclaration();

			// string property groupName
			consume(vertx, "declaration_" + deploymentID(), deploymentID() + ".groupName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setGroupName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "declaration_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property properties
			consume(vertx, "declaration_" + deploymentID(), deploymentID() + ".properties", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addPropertiesValue(message.body().getString("name"),message.body().getString("setter"));
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
		public static void sendAddProperties(Vertx vertx, java.util.UUID id, Object content, String name, String setter, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("name", name)
				.put("setter", setter);

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

	public static final class DefaultNodeTypesVerticle extends AbstractVerticle {

		private final TemplatesNeoGroup templateGroup = new TemplatesNeoGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesNeoGroup.defaultNodeTypesST template = templateGroup.newdefaultNodeTypes();

			// string property name
			consume(vertx, "defaultNodeTypes_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

	public static final class KeyValueListSetterVerticle extends AbstractVerticle {

		private final TemplatesNeoGroup templateGroup = new TemplatesNeoGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesNeoGroup.keyValueListSetterST template = templateGroup.newkeyValueListSetter();

			// list property kvNames
			consume(vertx, "keyValueListSetter_" + deploymentID(), deploymentID() + ".kvNames", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addKvNamesValue(message.body());
				}
			}); 
			// string property propertyName
			consume(vertx, "keyValueListSetter_" + deploymentID(), deploymentID() + ".propertyName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPropertyName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property statementName
			consume(vertx, "keyValueListSetter_" + deploymentID(), deploymentID() + ".statementName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setStatementName(message.body());
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

		public static void sendAddKvNames(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".kvNames", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendKvNamesMessage " + id + ".kvNames " + parameters.encode() + " failed", t);
				}
			});
		} 

		 public static void sendPropertyNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".propertyName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendPropertyNameMessage " + id + ".propertyName failed", t);
				}
			});
		}  

		 public static void sendStatementNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".statementName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStatementNameMessage " + id + ".statementName failed", t);
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

	public static final class ListSetterVerticle extends AbstractVerticle {

		private final TemplatesNeoGroup templateGroup = new TemplatesNeoGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesNeoGroup.listSetterST template = templateGroup.newlistSetter();

			// string property propertyName
			consume(vertx, "listSetter_" + deploymentID(), deploymentID() + ".propertyName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPropertyName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property statementName
			consume(vertx, "listSetter_" + deploymentID(), deploymentID() + ".statementName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setStatementName(message.body());
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


		 public static void sendPropertyNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".propertyName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendPropertyNameMessage " + id + ".propertyName failed", t);
				}
			});
		}  

		 public static void sendStatementNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".statementName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStatementNameMessage " + id + ".statementName failed", t);
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

	public static final class NewInstanceVerticle extends AbstractVerticle {

		private final TemplatesNeoGroup templateGroup = new TemplatesNeoGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesNeoGroup.newInstanceST template = templateGroup.newnewInstance();

			// string property groupName
			consume(vertx, "newInstance_" + deploymentID(), deploymentID() + ".groupName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setGroupName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "newInstance_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

	public static final class StringSetterVerticle extends AbstractVerticle {

		private final TemplatesNeoGroup templateGroup = new TemplatesNeoGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesNeoGroup.stringSetterST template = templateGroup.newstringSetter();

			// string property propertyName
			consume(vertx, "stringSetter_" + deploymentID(), deploymentID() + ".propertyName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPropertyName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property statementName
			consume(vertx, "stringSetter_" + deploymentID(), deploymentID() + ".statementName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setStatementName(message.body());
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


		 public static void sendPropertyNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".propertyName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendPropertyNameMessage " + id + ".propertyName failed", t);
				}
			});
		}  

		 public static void sendStatementNameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".statementName", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendStatementNameMessage " + id + ".statementName failed", t);
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

		final TemplatesNeoVerticles verticles = new TemplatesNeoVerticles(vertx);
		verticles.newNeoGroupClassDeclarationVerticle(loggingHandler(vertx));
		verticles.newBugfix2Verticle(loggingHandler(vertx));
		verticles.newDeclarationVerticle(loggingHandler(vertx));
		verticles.newDefaultNodeTypesVerticle(loggingHandler(vertx));
		verticles.newKeyValueListSetterVerticle(loggingHandler(vertx));
		verticles.newListSetterVerticle(loggingHandler(vertx));
		verticles.newNewInstanceVerticle(loggingHandler(vertx));
		verticles.newStringSetterVerticle(loggingHandler(vertx));		
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