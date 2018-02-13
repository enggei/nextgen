package com.generator.generators.easyFlow;

import com.generator.util.VertxUtil;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

// Domain: EasyFlow
public class EasyFlowDomainVerticle extends AbstractVerticle {

   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EasyFlowDomainVerticle.class);

	private String neoAddress;

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("Starting EasyFlowDomainVerticle");

		neoAddress = config().getString("neo.instance");

		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
			@Override
			public JsonObject execute() throws Throwable {
				return onStart();
			}

			@Override
			public void onSuccess(JsonObject result) {
				log.info("EasyFlowDomainVerticle started : " + result.toString());
				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject>>) message -> handleInstanceMessage(message));

				vertx.eventBus().consumer(deploymentID() + ".new.Flow", (Handler<Message<JsonObject>>) message -> newFlow(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Flow", (Handler<Message<JsonObject>>) message -> updateFlow(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Flow", (Handler<Message<JsonObject>>) message -> getFlow(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Flow", (Handler<Message<JsonObject>>) message -> listFlow(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Flow", (Handler<Message<JsonObject>>) message -> removeFlow(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.State", (Handler<Message<JsonObject>>) message -> newState(message));
				vertx.eventBus().consumer(deploymentID() + ".update.State", (Handler<Message<JsonObject>>) message -> updateState(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.State", (Handler<Message<JsonObject>>) message -> getState(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.State", (Handler<Message<JsonObject>>) message -> listState(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.State", (Handler<Message<JsonObject>>) message -> removeState(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.Event", (Handler<Message<JsonObject>>) message -> newEvent(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Event", (Handler<Message<JsonObject>>) message -> updateEvent(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Event", (Handler<Message<JsonObject>>) message -> getEvent(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Event", (Handler<Message<JsonObject>>) message -> listEvent(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Event", (Handler<Message<JsonObject>>) message -> removeEvent(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.ContextProperty", (Handler<Message<JsonObject>>) message -> newContextProperty(message));
				vertx.eventBus().consumer(deploymentID() + ".update.ContextProperty", (Handler<Message<JsonObject>>) message -> updateContextProperty(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.ContextProperty", (Handler<Message<JsonObject>>) message -> getContextProperty(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.ContextProperty", (Handler<Message<JsonObject>>) message -> listContextProperty(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.ContextProperty", (Handler<Message<JsonObject>>) message -> removeContextProperty(message)); 

				vertx.eventBus().consumer(deploymentID() + ".relate.Flow.FROM.State", (Handler<Message<JsonObject>>) message -> relateFlow_FROM_State(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Flow.FROM.State", (Handler<Message<JsonObject>>) message -> unrelateFlow_FROM_State(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Flow.CONTEXT_PROPERTY.ContextProperty", (Handler<Message<JsonObject>>) message -> relateFlow_CONTEXT_PROPERTY_ContextProperty(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Flow.CONTEXT_PROPERTY.ContextProperty", (Handler<Message<JsonObject>>) message -> unrelateFlow_CONTEXT_PROPERTY_ContextProperty(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.State.ON.Event", (Handler<Message<JsonObject>>) message -> relateState_ON_Event(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.State.ON.Event", (Handler<Message<JsonObject>>) message -> unrelateState_ON_Event(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Event.TO.State", (Handler<Message<JsonObject>>) message -> relateEvent_TO_State(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Event.TO.State", (Handler<Message<JsonObject>>) message -> unrelateEvent_TO_State(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Event.FINISH.State", (Handler<Message<JsonObject>>) message -> relateEvent_FINISH_State(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Event.FINISH.State", (Handler<Message<JsonObject>>) message -> unrelateEvent_FINISH_State(message));

				vertx.eventBus().consumer(deploymentID() + ".visitor.test", (Handler<Message<JsonObject>>) message -> visittest(message));

				startFuture.complete();
			}

			@Override
			public void onFail(Throwable t) {
				log.error("EasyFlowDomainVerticle failed to start : ", t);
				startFuture.fail(t);
			}
		});
	}

	protected JsonObject onStart() throws Exception { return new JsonObject(); } 

	private void newFlow(Message<JsonObject> message) {
	   log.info(deploymentID() + ".new.Flow " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Flow");

	   // todo add constraints - which properties are required for new Flow

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("name") != null) properties.add(new JsonObject().put("name", "name").put("value", message.body().getString("name")));
		if (message.body().getString("extending") != null) properties.add(new JsonObject().put("name", "extending").put("value", message.body().getString("extending")));
		if (message.body().getBoolean("isHandlingJsonMessages") != null) properties.add(new JsonObject().put("name", "isHandlingJsonMessages").put("value", message.body().getBoolean("isHandlingJsonMessages")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateFlow(Message<JsonObject> message) {
	   log.info(deploymentID() + ".update.Flow " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("name") != null) properties.add(new JsonObject().put("name", "name").put("value", message.body().getString("name")));
		if (message.body().getString("extending") != null) properties.add(new JsonObject().put("name", "extending").put("value", message.body().getString("extending")));
		if (message.body().getBoolean("isHandlingJsonMessages") != null) properties.add(new JsonObject().put("name", "isHandlingJsonMessages").put("value", message.body().getBoolean("isHandlingJsonMessages")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getFlow(Message<JsonObject> message) {
	   log.info(deploymentID() + ".get.Flow " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listFlow(Message<JsonObject> message) {
	   log.info(deploymentID() + ".list.Flow " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Flow");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeFlow(Message<JsonObject> message) {
	   log.info(deploymentID() + ".remove.Flow " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newState(Message<JsonObject> message) {
	   log.info(deploymentID() + ".new.State " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "State");

	   // todo add constraints - which properties are required for new State

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("name") != null) properties.add(new JsonObject().put("name", "name").put("value", message.body().getString("name")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateState(Message<JsonObject> message) {
	   log.info(deploymentID() + ".update.State " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("name") != null) properties.add(new JsonObject().put("name", "name").put("value", message.body().getString("name")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getState(Message<JsonObject> message) {
	   log.info(deploymentID() + ".get.State " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listState(Message<JsonObject> message) {
	   log.info(deploymentID() + ".list.State " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "State");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeState(Message<JsonObject> message) {
	   log.info(deploymentID() + ".remove.State " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newEvent(Message<JsonObject> message) {
	   log.info(deploymentID() + ".new.Event " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Event");

	   // todo add constraints - which properties are required for new Event

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("name") != null) properties.add(new JsonObject().put("name", "name").put("value", message.body().getString("name")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateEvent(Message<JsonObject> message) {
	   log.info(deploymentID() + ".update.Event " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("name") != null) properties.add(new JsonObject().put("name", "name").put("value", message.body().getString("name")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getEvent(Message<JsonObject> message) {
	   log.info(deploymentID() + ".get.Event " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listEvent(Message<JsonObject> message) {
	   log.info(deploymentID() + ".list.Event " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Event");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeEvent(Message<JsonObject> message) {
	   log.info(deploymentID() + ".remove.Event " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newContextProperty(Message<JsonObject> message) {
	   log.info(deploymentID() + ".new.ContextProperty " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "ContextProperty");

	   // todo add constraints - which properties are required for new ContextProperty

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("name") != null) properties.add(new JsonObject().put("name", "name").put("value", message.body().getString("name")));
		if (message.body().getString("modifier") != null) properties.add(new JsonObject().put("name", "modifier").put("value", message.body().getString("modifier")));
		if (message.body().getString("comment") != null) properties.add(new JsonObject().put("name", "comment").put("value", message.body().getString("comment")));
		if (message.body().getString("type") != null) properties.add(new JsonObject().put("name", "type").put("value", message.body().getString("type")));
		if (message.body().getString("value") != null) properties.add(new JsonObject().put("name", "value").put("value", message.body().getString("value")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateContextProperty(Message<JsonObject> message) {
	   log.info(deploymentID() + ".update.ContextProperty " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("name") != null) properties.add(new JsonObject().put("name", "name").put("value", message.body().getString("name")));
		if (message.body().getString("modifier") != null) properties.add(new JsonObject().put("name", "modifier").put("value", message.body().getString("modifier")));
		if (message.body().getString("comment") != null) properties.add(new JsonObject().put("name", "comment").put("value", message.body().getString("comment")));
		if (message.body().getString("type") != null) properties.add(new JsonObject().put("name", "type").put("value", message.body().getString("type")));
		if (message.body().getString("value") != null) properties.add(new JsonObject().put("name", "value").put("value", message.body().getString("value")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getContextProperty(Message<JsonObject> message) {
	   log.info(deploymentID() + ".get.ContextProperty " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listContextProperty(Message<JsonObject> message) {
	   log.info(deploymentID() + ".list.ContextProperty " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "ContextProperty");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeContextProperty(Message<JsonObject> message) {
	   log.info(deploymentID() + ".remove.ContextProperty " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}


	protected void relateFlow_FROM_State(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Flow.FROM.State -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "FROM");
		// todo add properties

		sendNeoMessage(message, request);
	}

	protected void unrelateFlow_FROM_State(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Flow.FROM.State -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "FROM");

		sendNeoMessage(message, request);
	}

	protected void relateFlow_CONTEXT_PROPERTY_ContextProperty(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Flow.CONTEXT_PROPERTY.ContextProperty -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "CONTEXT_PROPERTY");
		// todo add properties

		sendNeoMessage(message, request);
	}

	protected void unrelateFlow_CONTEXT_PROPERTY_ContextProperty(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Flow.CONTEXT_PROPERTY.ContextProperty -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "CONTEXT_PROPERTY");

		sendNeoMessage(message, request);
	}

	protected void relateState_ON_Event(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.State.ON.Event -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "ON");
		// todo add properties

		sendNeoMessage(message, request);
	}

	protected void unrelateState_ON_Event(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.State.ON.Event -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "ON");

		sendNeoMessage(message, request);
	}

	protected void relateEvent_TO_State(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Event.TO.State -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "TO");
		// todo add properties

		sendNeoMessage(message, request);
	}

	protected void unrelateEvent_TO_State(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Event.TO.State -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "TO");

		sendNeoMessage(message, request);
	}

	protected void relateEvent_FINISH_State(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Event.FINISH.State -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "FINISH");
		// todo add properties

		sendNeoMessage(message, request);
	}

	protected void unrelateEvent_FINISH_State(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Event.FINISH.State -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "FINISH");

		sendNeoMessage(message, request);
	}


	private void visittest(Message<JsonObject> message) {
   	log.info(deploymentID() + " -> visitor.test -> " + message.body().toString());

		final JsonObject request = new JsonObject();
		request.put("action", "visitor");
		request.put("className", com.generator.generators.easyFlow.vertx.EasyFlowDomainVisitor.class.getCanonicalName());
		request.put("params", message.body());

		sendNeoMessage(message, request);
	}


	protected void handleInstanceMessage(Message<JsonObject> message) { log.info("instance message " + deploymentID() + " -> " + message.body().toString()); }

	protected void sendNeoMessage(Message<JsonObject> message, JsonObject request) {
		VertxUtil.sendMessage(vertx, neoAddress, request, log, new VertxUtil.SuccessHandler<Message<JsonObject>>() {
			@Override
			public void onSuccess(Message<JsonObject> result) {
				message.reply(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				message.reply(VertxUtil.newFail(t.getMessage()));
			}
		});
	}
}