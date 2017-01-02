package com.generator.generators.templates;

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
public class TemplatesVerticles {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TemplatesVerticles.class);

	private final Vertx vertx;

	public TemplatesVerticles(Vertx vertx) {
		this.vertx = vertx;
	}

	public void newBooleanTemplateParameterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, BooleanTemplateParameterVerticle.class.getName(), log, handler);
	} 

	public void newKeyValueListTemplateParameterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, KeyValueListTemplateParameterVerticle.class.getName(), log, handler);
	} 

	public void newListTemplateParameterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, ListTemplateParameterVerticle.class.getName(), log, handler);
	} 

	public void newStatementVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StatementVerticle.class.getName(), log, handler);
	} 

	public void newStatementTemplateParameterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StatementTemplateParameterVerticle.class.getName(), log, handler);
	} 

	public void newStringTemplateParameterVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StringTemplateParameterVerticle.class.getName(), log, handler);
	} 

	public void newTemplateGroupVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, TemplateGroupVerticle.class.getName(), log, handler);
	} 

	public void newTemplateGroupVisitorVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, TemplateGroupVisitorVerticle.class.getName(), log, handler);
	} 

	public void newTemplateImportVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, TemplateImportVerticle.class.getName(), log, handler);
	} 

	public void newTemplateStatementVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, TemplateStatementVerticle.class.getName(), log, handler);
	} 

	public static final class BooleanTemplateParameterVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.BooleanTemplateParameterST template = templateGroup.newBooleanTemplateParameter();

			// string property name
			consume(vertx, "BooleanTemplateParameter_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

	public static final class KeyValueListTemplateParameterVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.KeyValueListTemplateParameterST template = templateGroup.newKeyValueListTemplateParameter();

			// list property kvNames
			consume(vertx, "KeyValueListTemplateParameter_" + deploymentID(), deploymentID() + ".kvNames", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addKvNamesValue(message.body());
				}
			}); 
			// string property name
			consume(vertx, "KeyValueListTemplateParameter_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

	public static final class ListTemplateParameterVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.ListTemplateParameterST template = templateGroup.newListTemplateParameter();

			// key-value list property elements
			consume(vertx, "ListTemplateParameter_" + deploymentID(), deploymentID() + ".elements", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addElementsValue(message.body().getString("type"));
				}
			}); 
			// string property name
			consume(vertx, "ListTemplateParameter_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

		public static void sendAddElements(Vertx vertx, java.util.UUID id, Object content, String type, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("type", type);

			sendMessage(vertx, id + ".elements", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendElementsMessage " + id + ".elements " + parameters.encode() + " failed", t);
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

	public static final class StatementVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.StatementST template = templateGroup.newStatement();

			// key-value list property parameters
			consume(vertx, "Statement_" + deploymentID(), deploymentID() + ".parameters", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addParametersValue(message.body().getString("templateParameter"),message.body().getString("value"));
				}
			}); 
			// string property templateStatement
			consume(vertx, "Statement_" + deploymentID(), deploymentID() + ".templateStatement", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setTemplateStatement(message.body());
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

		public static void sendAddParameters(Vertx vertx, java.util.UUID id, Object content, String templateParameter, String value, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("templateParameter", templateParameter)
				.put("value", value);

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

		 public static void sendTemplateStatementMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".templateStatement", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendTemplateStatementMessage " + id + ".templateStatement failed", t);
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

	public static final class StatementTemplateParameterVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.StatementTemplateParameterST template = templateGroup.newStatementTemplateParameter();

			// string property name
			consume(vertx, "StatementTemplateParameter_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

	public static final class StringTemplateParameterVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.StringTemplateParameterST template = templateGroup.newStringTemplateParameter();

			// string property name
			consume(vertx, "StringTemplateParameter_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property value
			consume(vertx, "StringTemplateParameter_" + deploymentID(), deploymentID() + ".value", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setValue(message.body());
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

		 public static void sendValueMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".value", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendValueMessage " + id + ".value failed", t);
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

	public static final class TemplateGroupVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.TemplateGroupST template = templateGroup.newTemplateGroup();

			// string property delimiter
			consume(vertx, "TemplateGroup_" + deploymentID(), deploymentID() + ".delimiter", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setDelimiter(message.body());
					message.reply(message.body());
				}
			}); 
			// list property imports
			consume(vertx, "TemplateGroup_" + deploymentID(), deploymentID() + ".imports", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addImportsValue(message.body());
				}
			}); 
			// string property name
			consume(vertx, "TemplateGroup_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property package
			consume(vertx, "TemplateGroup_" + deploymentID(), deploymentID() + ".package", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackage(message.body());
					message.reply(message.body());
				}
			}); 
			// list property templateStatements
			consume(vertx, "TemplateGroup_" + deploymentID(), deploymentID() + ".templateStatements", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addTemplateStatementsValue(message.body());
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


		 public static void sendDelimiterMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".delimiter", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendDelimiterMessage " + id + ".delimiter failed", t);
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
		public static void sendAddTemplateStatements(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".templateStatements", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendTemplateStatementsMessage " + id + ".templateStatements " + parameters.encode() + " failed", t);
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

	public static final class TemplateGroupVisitorVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.TemplateGroupVisitorST template = templateGroup.newTemplateGroupVisitor();

			// string property name
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property onBooleanTemplateParameter
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onBooleanTemplateParameter", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnBooleanTemplateParameterValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// key-value list property onKeyValueListTemplateParameter
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onKeyValueListTemplateParameter", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnKeyValueListTemplateParameterValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// key-value list property onListTemplateParameter
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onListTemplateParameter", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnListTemplateParameterValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// key-value list property onStatementTemplateParameter
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onStatementTemplateParameter", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnStatementTemplateParameterValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// key-value list property onStringTemplateParameter
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onStringTemplateParameter", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnStringTemplateParameterValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// key-value list property onTemplateGroup
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onTemplateGroup", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnTemplateGroupValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// key-value list property onTemplateGroupEnd
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onTemplateGroupEnd", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnTemplateGroupEndValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// key-value list property onTemplateStatement
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onTemplateStatement", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnTemplateStatementValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// key-value list property onTemplateStatementEnd
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".onTemplateStatementEnd", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addOnTemplateStatementEndValue(message.body().getString("declaration"),message.body().getString("statements"));
				}
			}); 
			// string property packageName
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".packageName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackageName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property returnProperty
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".returnProperty", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setReturnProperty(message.body());
					message.reply(message.body());
				}
			}); 
			// string property returnType
			consume(vertx, "TemplateGroupVisitor_" + deploymentID(), deploymentID() + ".returnType", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setReturnType(message.body());
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
		public static void sendAddOnBooleanTemplateParameter(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onBooleanTemplateParameter", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnBooleanTemplateParameterMessage " + id + ".onBooleanTemplateParameter " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOnKeyValueListTemplateParameter(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onKeyValueListTemplateParameter", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnKeyValueListTemplateParameterMessage " + id + ".onKeyValueListTemplateParameter " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOnListTemplateParameter(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onListTemplateParameter", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnListTemplateParameterMessage " + id + ".onListTemplateParameter " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOnStatementTemplateParameter(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onStatementTemplateParameter", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnStatementTemplateParameterMessage " + id + ".onStatementTemplateParameter " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOnStringTemplateParameter(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onStringTemplateParameter", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnStringTemplateParameterMessage " + id + ".onStringTemplateParameter " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOnTemplateGroup(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onTemplateGroup", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnTemplateGroupMessage " + id + ".onTemplateGroup " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOnTemplateGroupEnd(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onTemplateGroupEnd", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnTemplateGroupEndMessage " + id + ".onTemplateGroupEnd " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOnTemplateStatement(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onTemplateStatement", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnTemplateStatementMessage " + id + ".onTemplateStatement " + parameters.encode() + " failed", t);
				}
			});
		} 
		public static void sendAddOnTemplateStatementEnd(Vertx vertx, java.util.UUID id, Object content, String declaration, String statements, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("declaration", declaration)
				.put("statements", statements);

			sendMessage(vertx, id + ".onTemplateStatementEnd", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendOnTemplateStatementEndMessage " + id + ".onTemplateStatementEnd " + parameters.encode() + " failed", t);
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

		 public static void sendReturnPropertyMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".returnProperty", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendReturnPropertyMessage " + id + ".returnProperty failed", t);
				}
			});
		}  

		 public static void sendReturnTypeMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".returnType", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendReturnTypeMessage " + id + ".returnType failed", t);
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

	public static final class TemplateImportVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.TemplateImportST template = templateGroup.newTemplateImport();

			// string property name
			consume(vertx, "TemplateImport_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

	public static final class TemplateStatementVerticle extends AbstractVerticle {

		private final TemplatesGroup templateGroup = new TemplatesGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final TemplatesGroup.TemplateStatementST template = templateGroup.newTemplateStatement();

			// string property name
			consume(vertx, "TemplateStatement_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// list property templateParameters
			consume(vertx, "TemplateStatement_" + deploymentID(), deploymentID() + ".templateParameters", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addTemplateParametersValue(message.body());
				}
			}); 
			// string property text
			consume(vertx, "TemplateStatement_" + deploymentID(), deploymentID() + ".text", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setText(message.body());
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
		public static void sendAddTemplateParameters(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".templateParameters", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendTemplateParametersMessage " + id + ".templateParameters " + parameters.encode() + " failed", t);
				}
			});
		} 

		 public static void sendTextMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".text", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendTextMessage " + id + ".text failed", t);
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

		final TemplatesVerticles verticles = new TemplatesVerticles(vertx);
		verticles.newBooleanTemplateParameterVerticle(loggingHandler(vertx));
		verticles.newKeyValueListTemplateParameterVerticle(loggingHandler(vertx));
		verticles.newListTemplateParameterVerticle(loggingHandler(vertx));
		verticles.newStatementVerticle(loggingHandler(vertx));
		verticles.newStatementTemplateParameterVerticle(loggingHandler(vertx));
		verticles.newStringTemplateParameterVerticle(loggingHandler(vertx));
		verticles.newTemplateGroupVerticle(loggingHandler(vertx));
		verticles.newTemplateGroupVisitorVerticle(loggingHandler(vertx));
		verticles.newTemplateImportVerticle(loggingHandler(vertx));
		verticles.newTemplateStatementVerticle(loggingHandler(vertx));		
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