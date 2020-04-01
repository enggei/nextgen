package com.generator.generators.easyFlow;

import com.generator.util.VertxUtil;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetSocket;

/**
 * EasyFlow- Facade
 */
public class EasyFlowFacade {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EasyFlowFacade.class);

   private final String address;
   private final String replyAddress;
   private final NetSocket socket;

   public EasyFlowFacade(String address, String replyAddress, NetSocket socket) {
      this.address = address;
      this.replyAddress = replyAddress;
      this.socket = socket;
   }

	public JsonObject newFlow(String name, String extending, Boolean isHandlingJsonMessages) {

	   final JsonObject parameters = new JsonObject().
				put("name", name).
				put("extending", extending).
				put("isHandlingJsonMessages", isHandlingJsonMessages);

		return parameters;
	}

	public JsonObject updateFlow(String uuid, String name, String extending, Boolean isHandlingJsonMessages) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid).
				put("name", name).
				put("extending", extending).
				put("isHandlingJsonMessages", isHandlingJsonMessages);

		return parameters;
	}

	public JsonObject getFlow(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

		return parameters;
	}

	public JsonObject listFlows(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

		return parameters;
	}

	public JsonObject removeFlow(String uuid, boolean force, boolean cascade) {

	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   return parameter;
	}

	public void sendNewFlowFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".new.Flow", replyAddress, parameters, socket);
	}

	public void sendNewFlowMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".new.Flow", parameters, log, handler);
	}

	public void sendUpdateFlowFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".update.Flow", replyAddress, parameters, socket);
	}

	public void sendUpdateFlowMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".update.Flow", parameters, log, handler);
	}

	public void sendGetFlowFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".get.Flow", replyAddress, parameters, socket);
	}

	public void sendGetFlowMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".get.Flow", parameters, log, handler);
	}

	public void sendListFlowFrame(JsonObject parameters) {
	   VertxUtil.sendFrame(log, address + ".list.Flow", replyAddress, parameters, socket);
	}

	public void sendListFlowMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".list.Flow", parameters, log, handler);
	}

	public void sendRemoveFlowFrame(JsonObject parameters) {
	   VertxUtil.sendFrame(log, address + ".remove.Flow", replyAddress, parameters, socket);
	}

	public void sendRemoveFlowMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".remove.Flow", parameters, log, handler);
	}

	public JsonObject newState(String name) {

	   final JsonObject parameters = new JsonObject().
				put("name", name);

		return parameters;
	}

	public JsonObject updateState(String uuid, String name) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid).
				put("name", name);

		return parameters;
	}

	public JsonObject getState(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

		return parameters;
	}

	public JsonObject listStates(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

		return parameters;
	}

	public JsonObject removeState(String uuid, boolean force, boolean cascade) {

	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   return parameter;
	}

	public void sendNewStateFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".new.State", replyAddress, parameters, socket);
	}

	public void sendNewStateMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".new.State", parameters, log, handler);
	}

	public void sendUpdateStateFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".update.State", replyAddress, parameters, socket);
	}

	public void sendUpdateStateMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".update.State", parameters, log, handler);
	}

	public void sendGetStateFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".get.State", replyAddress, parameters, socket);
	}

	public void sendGetStateMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".get.State", parameters, log, handler);
	}

	public void sendListStateFrame(JsonObject parameters) {
	   VertxUtil.sendFrame(log, address + ".list.State", replyAddress, parameters, socket);
	}

	public void sendListStateMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".list.State", parameters, log, handler);
	}

	public void sendRemoveStateFrame(JsonObject parameters) {
	   VertxUtil.sendFrame(log, address + ".remove.State", replyAddress, parameters, socket);
	}

	public void sendRemoveStateMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".remove.State", parameters, log, handler);
	}

	public JsonObject newEvent(String name) {

	   final JsonObject parameters = new JsonObject().
				put("name", name);

		return parameters;
	}

	public JsonObject updateEvent(String uuid, String name) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid).
				put("name", name);

		return parameters;
	}

	public JsonObject getEvent(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

		return parameters;
	}

	public JsonObject listEvents(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

		return parameters;
	}

	public JsonObject removeEvent(String uuid, boolean force, boolean cascade) {

	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   return parameter;
	}

	public void sendNewEventFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".new.Event", replyAddress, parameters, socket);
	}

	public void sendNewEventMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".new.Event", parameters, log, handler);
	}

	public void sendUpdateEventFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".update.Event", replyAddress, parameters, socket);
	}

	public void sendUpdateEventMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".update.Event", parameters, log, handler);
	}

	public void sendGetEventFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".get.Event", replyAddress, parameters, socket);
	}

	public void sendGetEventMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".get.Event", parameters, log, handler);
	}

	public void sendListEventFrame(JsonObject parameters) {
	   VertxUtil.sendFrame(log, address + ".list.Event", replyAddress, parameters, socket);
	}

	public void sendListEventMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".list.Event", parameters, log, handler);
	}

	public void sendRemoveEventFrame(JsonObject parameters) {
	   VertxUtil.sendFrame(log, address + ".remove.Event", replyAddress, parameters, socket);
	}

	public void sendRemoveEventMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".remove.Event", parameters, log, handler);
	}

	public JsonObject newContextProperty(String name, String modifier, String comment, String type, String value) {

	   final JsonObject parameters = new JsonObject().
				put("name", name).
				put("modifier", modifier).
				put("comment", comment).
				put("type", type).
				put("value", value);

		return parameters;
	}

	public JsonObject updateContextProperty(String uuid, String name, String modifier, String comment, String type, String value) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid).
				put("name", name).
				put("modifier", modifier).
				put("comment", comment).
				put("type", type).
				put("value", value);

		return parameters;
	}

	public JsonObject getContextProperty(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

		return parameters;
	}

	public JsonObject listContextPropertys(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

		return parameters;
	}

	public JsonObject removeContextProperty(String uuid, boolean force, boolean cascade) {

	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   return parameter;
	}

	public void sendNewContextPropertyFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".new.ContextProperty", replyAddress, parameters, socket);
	}

	public void sendNewContextPropertyMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".new.ContextProperty", parameters, log, handler);
	}

	public void sendUpdateContextPropertyFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".update.ContextProperty", replyAddress, parameters, socket);
	}

	public void sendUpdateContextPropertyMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".update.ContextProperty", parameters, log, handler);
	}

	public void sendGetContextPropertyFrame(JsonObject parameters) {
		VertxUtil.sendFrame(log, address + ".get.ContextProperty", replyAddress, parameters, socket);
	}

	public void sendGetContextPropertyMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".get.ContextProperty", parameters, log, handler);
	}

	public void sendListContextPropertyFrame(JsonObject parameters) {
	   VertxUtil.sendFrame(log, address + ".list.ContextProperty", replyAddress, parameters, socket);
	}

	public void sendListContextPropertyMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".list.ContextProperty", parameters, log, handler);
	}

	public void sendRemoveContextPropertyFrame(JsonObject parameters) {
	   VertxUtil.sendFrame(log, address + ".remove.ContextProperty", replyAddress, parameters, socket);
	}

	public void sendRemoveContextPropertyMessage(Vertx vertx, JsonObject parameters, VertxUtil.SuccessHandler<Message<JsonObject>> handler) {
	  	VertxUtil.sendMessage(vertx, address + ".remove.ContextProperty", parameters, log, handler);
	}


   public void relateFlow_FROM_State(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Flow.FROM.State", replyAddress, parameters, socket);
   }

   public void unrelateFlow_FROM_State(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Flow.FROM.State", replyAddress, parameters, socket);
   }

   public void relateFlow_CONTEXT_PROPERTY_ContextProperty(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Flow.CONTEXT_PROPERTY.ContextProperty", replyAddress, parameters, socket);
   }

   public void unrelateFlow_CONTEXT_PROPERTY_ContextProperty(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Flow.CONTEXT_PROPERTY.ContextProperty", replyAddress, parameters, socket);
   }

   public void relateState_ON_Event(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.State.ON.Event", replyAddress, parameters, socket);
   }

   public void unrelateState_ON_Event(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.State.ON.Event", replyAddress, parameters, socket);
   }

   public void relateEvent_TO_State(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Event.TO.State", replyAddress, parameters, socket);
   }

   public void unrelateEvent_TO_State(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Event.TO.State", replyAddress, parameters, socket);
   }

   public void relateEvent_FINISH_State(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Event.FINISH.State", replyAddress, parameters, socket);
   }

   public void unrelateEvent_FINISH_State(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Event.FINISH.State", replyAddress, parameters, socket);
   }

}