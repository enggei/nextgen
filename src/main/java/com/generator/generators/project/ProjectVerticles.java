package com.generator.generators.project;

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
public class ProjectVerticles {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ProjectVerticles.class);

	private final Vertx vertx;

	public ProjectVerticles(Vertx vertx) {
		this.vertx = vertx;
	}

	public void newAspectVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, AspectVerticle.class.getName(), log, handler);
	} 

	public void newBugfixVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, BugfixVerticle.class.getName(), log, handler);
	} 

	public void newProjectVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, ProjectVerticle.class.getName(), log, handler);
	} 

	public void newStringValueVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, StringValueVerticle.class.getName(), log, handler);
	} 

	public void newWriteFileVerticle(VertxUtil.SuccessHandler<String> handler) {
		deploy(vertx, WriteFileVerticle.class.getName(), log, handler);
	} 

	public static final class AspectVerticle extends AbstractVerticle {

		private final ProjectGroup templateGroup = new ProjectGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProjectGroup.aspectST template = templateGroup.newaspect();

			// string property name
			consume(vertx, "aspect_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// list property tasks
			consume(vertx, "aspect_" + deploymentID(), deploymentID() + ".tasks", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addTasksValue(message.body());
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
		public static void sendAddTasks(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".tasks", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendTasksMessage " + id + ".tasks " + parameters.encode() + " failed", t);
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

		private final ProjectGroup templateGroup = new ProjectGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProjectGroup.bugfixST template = templateGroup.newbugfix();


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

	public static final class ProjectVerticle extends AbstractVerticle {

		private final ProjectGroup templateGroup = new ProjectGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProjectGroup.projectST template = templateGroup.newproject();

			// list property aspects
			consume(vertx, "project_" + deploymentID(), deploymentID() + ".aspects", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.addAspectsValue(message.body());
				}
			}); 
			// string property comments
			consume(vertx, "project_" + deploymentID(), deploymentID() + ".comments", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setComments(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property groups
			consume(vertx, "project_" + deploymentID(), deploymentID() + ".groups", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addGroupsValue(message.body().getString("name"),message.body().getString("packageName"),message.body().getString("path"),message.body().getString("reference"));
				}
			}); 
			// string property name
			consume(vertx, "project_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setName(message.body());
					message.reply(message.body());
				}
			}); 
			// string property packageName
			consume(vertx, "project_" + deploymentID(), deploymentID() + ".packageName", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setPackageName(message.body());
					message.reply(message.body());
				}
			}); 
			// key-value list property roots
			consume(vertx, "project_" + deploymentID(), deploymentID() + ".roots", log, new Handler<Message<JsonObject> >() {
				@Override
				public void handle(Message<JsonObject> message) {
					template.addRootsValue(message.body().getString("path"),message.body().getString("reference"));
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

		public static void sendAddAspects(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject();

			sendMessage(vertx, id + ".aspects", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendAspectsMessage " + id + ".aspects " + parameters.encode() + " failed", t);
				}
			});
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
		public static void sendAddGroups(Vertx vertx, java.util.UUID id, Object content, String name, String packageName, String path, String reference, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("name", name)
				.put("packageName", packageName)
				.put("path", path)
				.put("reference", reference);

			sendMessage(vertx, id + ".groups", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendGroupsMessage " + id + ".groups " + parameters.encode() + " failed", t);
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
		public static void sendAddRoots(Vertx vertx, java.util.UUID id, Object content, String path, String reference, Handler<String> instanceHandler) {

			final JsonObject parameters = new JsonObject().put("path", path)
				.put("reference", reference);

			sendMessage(vertx, id + ".roots", parameters, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendRootsMessage " + id + ".roots " + parameters.encode() + " failed", t);
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

	public static final class StringValueVerticle extends AbstractVerticle {

		private final ProjectGroup templateGroup = new ProjectGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProjectGroup.stringValueST template = templateGroup.newstringValue();

			// string property value
			consume(vertx, "stringValue_" + deploymentID(), deploymentID() + ".value", log, new Handler<Message<String> >() {
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

	public static final class WriteFileVerticle extends AbstractVerticle {

		private final ProjectGroup templateGroup = new ProjectGroup();

		@Override
		public void start(Future<Void> startFuture) throws Exception {

			// todo: make dependent of any arbitrary object, so one can instantiate any object parsed from java ...

			// new instance of template
			final ProjectGroup.writeFileST template = templateGroup.newwriteFile();

			// string property comment
			consume(vertx, "writeFile_" + deploymentID(), deploymentID() + ".comment", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setComment(message.body());
					message.reply(message.body());
				}
			}); 
			// string property content
			consume(vertx, "writeFile_" + deploymentID(), deploymentID() + ".content", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setContent(message.body());
					message.reply(message.body());
				}
			}); 
			// string property dir
			consume(vertx, "writeFile_" + deploymentID(), deploymentID() + ".dir", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setDir(message.body());
					message.reply(message.body());
				}
			}); 
			// string property filetype
			consume(vertx, "writeFile_" + deploymentID(), deploymentID() + ".filetype", log, new Handler<Message<String> >() {
				@Override
				public void handle(Message<String> message) {
					template.setFiletype(message.body());
					message.reply(message.body());
				}
			}); 
			// string property name
			consume(vertx, "writeFile_" + deploymentID(), deploymentID() + ".name", log, new Handler<Message<String> >() {
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

		 public static void sendContentMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".content", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendContentMessage " + id + ".content failed", t);
				}
			});
		}  

		 public static void sendDirMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".dir", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendDirMessage " + id + ".dir failed", t);
				}
			});
		}  

		 public static void sendFiletypeMessage(Vertx vertx, java.util.UUID id, Object content, Handler<String> instanceHandler) {
			sendMessage(vertx, id + ".filetype", content, log, new VertxUtil.SuccessHandler<Message<String> >() {
				@Override
				public void onSuccess(Message<String> result) {
					instanceHandler.handle(result.body());
				}

				@Override
				public void onFail(Throwable t) {
					log.error("sendFiletypeMessage " + id + ".filetype failed", t);
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

	public static void main(String[] args) {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		Vertx vertx = Vertx.vertx();

		final ProjectVerticles verticles = new ProjectVerticles(vertx);
		verticles.newAspectVerticle(loggingHandler(vertx));
		verticles.newBugfixVerticle(loggingHandler(vertx));
		verticles.newProjectVerticle(loggingHandler(vertx));
		verticles.newStringValueVerticle(loggingHandler(vertx));
		verticles.newWriteFileVerticle(loggingHandler(vertx));		
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