package com.generator.generators.templateGroup;

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
public class TemplateGroupVerticles {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TemplateGroupVerticles.class);

	private final Vertx vertx;

	public TemplateGroupVerticles(Vertx vertx) {
		this.vertx = vertx;
	}

	public void newAttributeRendererDeclarationVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, AttributeRendererDeclarationVerticle.class.getName(), log, handler);
	} 

	public void newGroupClassDeclarationVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, GroupClassDeclarationVerticle.class.getName(), log, handler);
	} 

	public void newNewGroupInstanceVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, NewGroupInstanceVerticle.class.getName(), log, handler);
	} 

	public void newNewStatementDeclarationVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, NewStatementDeclarationVerticle.class.getName(), log, handler);
	} 

	public void newNewStatementInstanceVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, NewStatementInstanceVerticle.class.getName(), log, handler);
	} 

	public void newStatementKeyValueListPropertySetterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StatementKeyValueListPropertySetterVerticle.class.getName(), log, handler);
	} 

	public void newStatementListPropertySetterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StatementListPropertySetterVerticle.class.getName(), log, handler);
	} 

	public void newStatementStringPropertySetterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StatementStringPropertySetterVerticle.class.getName(), log, handler);
	} 

	public void newBugfixVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, BugfixVerticle.class.getName(), log, handler);
	} 

	public static final class AttributeRendererDeclarationVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.AttributeRendererDeclarationST template = templateGroup.newAttributeRendererDeclaration();


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

	public static final class GroupClassDeclarationVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.GroupClassDeclarationST template = templateGroup.newGroupClassDeclaration();

			// string property domain
			consume(vertx, "GroupClassDeclaration_" + deploymentID(), deploymentID() + ".domain", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setDomain(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "GroupClassDeclaration_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property packageName
			consume(vertx, "GroupClassDeclaration_" + deploymentID(), deploymentID() + ".packageName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackageName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property statements
			consume(vertx, "GroupClassDeclaration_" + deploymentID(), deploymentID() + ".statements", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addStatementsValue(message.body().getString("declaration"),message.body().getString("newInstance"));
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


		 public static void sendDomainMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".domain", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendDomainMessage " + id + ".domain failed", t);
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
		public static void sendAddStatements(Vertx vertx, java.util.UUID id, Object content, String declaration, String newInstance, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
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

	public static final class NewGroupInstanceVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.NewGroupInstanceST template = templateGroup.newNewGroupInstance();

			// string property filename
			consume(vertx, "NewGroupInstance_" + deploymentID(), deploymentID() + ".filename", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setFilename(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "NewGroupInstance_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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


		 public static void sendFilenameMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".filename", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendFilenameMessage " + id + ".filename failed", t);
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

	public static final class NewStatementDeclarationVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.NewStatementDeclarationST template = templateGroup.newNewStatementDeclaration();

			// string property name
			consume(vertx, "NewStatementDeclaration_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property properties
			consume(vertx, "NewStatementDeclaration_" + deploymentID(), deploymentID() + ".properties", log, new Handler<Message<JsonObject> >() {
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

	public static final class NewStatementInstanceVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.NewStatementInstanceST template = templateGroup.newNewStatementInstance();

			// string property name
			consume(vertx, "NewStatementInstance_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

	public static final class StatementKeyValueListPropertySetterVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.StatementKeyValueListPropertySetterST template = templateGroup.newStatementKeyValueListPropertySetter();

			// list property kvNames
			consume(vertx, "StatementKeyValueListPropertySetter_" + deploymentID(), deploymentID() + ".kvNames", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addKvNamesValue(message.body());
				}
			}); 
			// string property propertyName
			consume(vertx, "StatementKeyValueListPropertySetter_" + deploymentID(), deploymentID() + ".propertyName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPropertyName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property statementName
			consume(vertx, "StatementKeyValueListPropertySetter_" + deploymentID(), deploymentID() + ".statementName", log, new Handler<Message<String> >() {
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

	public static final class StatementListPropertySetterVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.StatementListPropertySetterST template = templateGroup.newStatementListPropertySetter();

			// string property propertyName
			consume(vertx, "StatementListPropertySetter_" + deploymentID(), deploymentID() + ".propertyName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPropertyName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property statementName
			consume(vertx, "StatementListPropertySetter_" + deploymentID(), deploymentID() + ".statementName", log, new Handler<Message<String> >() {
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

	public static final class StatementStringPropertySetterVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.StatementStringPropertySetterST template = templateGroup.newStatementStringPropertySetter();

			// string property propertyName
			consume(vertx, "StatementStringPropertySetter_" + deploymentID(), deploymentID() + ".propertyName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPropertyName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property statementName
			consume(vertx, "StatementStringPropertySetter_" + deploymentID(), deploymentID() + ".statementName", log, new Handler<Message<String> >() {
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

	public static final class BugfixVerticle extends AbstractVerticle {

		private final TemplateGroupGroup templateGroup = new TemplateGroupGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplateGroupGroup.bugfixST template = templateGroup.newbugfix();


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

	public static void main(String[] args) {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		Vertx vertx = Vertx.vertx();

		final TemplateGroupVerticles verticles = new TemplateGroupVerticles(vertx);
		verticles.newAttributeRendererDeclarationVerticle(loggingHandler(vertx));
		verticles.newGroupClassDeclarationVerticle(loggingHandler(vertx));
		verticles.newNewGroupInstanceVerticle(loggingHandler(vertx));
		verticles.newNewStatementDeclarationVerticle(loggingHandler(vertx));
		verticles.newNewStatementInstanceVerticle(loggingHandler(vertx));
		verticles.newStatementKeyValueListPropertySetterVerticle(loggingHandler(vertx));
		verticles.newStatementListPropertySetterVerticle(loggingHandler(vertx));
		verticles.newStatementStringPropertySetterVerticle(loggingHandler(vertx));
		verticles.newBugfixVerticle(loggingHandler(vertx));		
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