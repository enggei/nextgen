package com.generator.generators.easyFlow.vertx;

import au.com.ds.ef.StatefulContext;
import au.com.ds.ef.err.ExecutionError;
import com.generator.generators.easyFlow.EasyFlowFacade;
import com.generator.util.VertxUtil;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetClient;
import io.vertx.ext.eventbus.bridge.tcp.impl.protocol.FrameParser;

/**
 * Created 17.12.17.
 */
public class EasyFlowClientTest extends EasyFlowClientFSM {

   private String flowUUID;
   private String contextUUID;

   @Override
   protected void failed(EasyFlowClientFSMContext context) throws Exception {
      log.error("Failed : " + context.inbox.peek().toString());
      context.socket.close();
   }

   @Override
   protected void connect(EasyFlowClientFSMContext context) throws Exception {

      final NetClient client = context.vertx.createNetClient();

      client.connect(context.port, context.host, res -> {
         if (res.succeeded()) {
            log.info("connected");
            context.socket = res.result();
            context.socket.handler(new FrameParser(resultHandler -> handleMessage(context, resultHandler.result())));
            context.socket.closeHandler(aVoid -> log.info("Closed"));

            context.facade = new EasyFlowFacade(context.domainAddress, context.clientID, context.socket);
            context.trigger(Events.connected);

         } else {
            System.out.println("Failed to connect: " + res.cause().getMessage());
         }
      });
   }

   @Override
   protected void handleMessageInLISTFLOWSState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.listSuccess);
      else context.trigger(Events.listFailed);
   }

   @Override
   protected void handleMessageInSENDNEWFLOWState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) {
         flowUUID = message.getJsonObject("body").getString("content");
         context.trigger(Events.newFlowCreated);
      } else context.trigger(Events.newFlowFailed);
   }

   @Override
   protected void handleMessageInTESTVISITORState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.testVisitorSuccess);
      else context.trigger(Events.testVisitorFailed);
   }

   @Override
   protected void handleMessageInUPDATEFLOWState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.updateSuccess);
      else context.trigger(Events.updateFailed);
   }

   @Override
   protected void handleMessageInREMOVEFLOWState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.removeSuccess);
      else context.trigger(Events.removeFailed);
   }

   @Override
   protected void handleMessageInREMOVECONTEXTPROPERTYState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.removeContextProperty);
      else context.trigger(Events.removeFailed);
   }

   @Override
   protected void handleMessageInNEWCONTEXTPROPERTYState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) {
         contextUUID = message.getJsonObject("body").getString("content");
         context.trigger(Events.contextPropertySuccess);
      } else context.trigger(Events.contextPropertyFailed);
   }

   @Override
   protected void handleMessageInLINKFLOWWITHCONTEXTPROPERTYState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.linkedSuccess);
      else context.trigger(Events.linkFailed);
   }

   @Override
   protected void handleMessageInUNLINKState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.unlinkSuccess);
      else context.trigger(Events.unlinkFailed);
   }

   @Override
   protected void handleMessage(EasyFlowClientFSMContext context, JsonObject message) {
      // capture all messages, even unhandled ones:
      context.inbox.push(message);
      super.handleMessage(context, message);
   }

   @Override
   protected void handleMessageInINSPECTFLOWState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.inspectSuccess);
      else context.trigger(Events.inspectFailed);
   }

   @Override
   protected void handleMessageInINSPECTCONTEXTPROPERTYState(EasyFlowClientFSMContext context, JsonObject message) {
      if (VertxUtil.isSuccess(message)) context.trigger(Events.contextInspectSucccess);
      else context.trigger(Events.inspectFailed);
   }

   @Override
   protected void sendnewflow(EasyFlowClientFSMContext context) throws Exception {
      context.facade.newFlow("First flow", null, false);
   }

   @Override
   protected void testvisitor(EasyFlowClientFSMContext context) throws Exception {

      final JsonObject parameters = new JsonObject().
            put("uuid", flowUUID);

      VertxUtil.sendFrame(log, context.domainAddress + ".visitor.test", context.clientID, parameters, context.socket);
//      context.facade.testVisitor(flowUUID);
   }

   @Override
   protected void removeflow(EasyFlowClientFSMContext context) throws Exception {
      context.facade.removeFlow(flowUUID, false, false);
   }

   @Override
   protected void removecontextproperty(EasyFlowClientFSMContext context) throws Exception {
      context.facade.removeContextProperty(contextUUID, false, false);
   }

   @Override
   protected void listflows(EasyFlowClientFSMContext context) throws Exception {
      context.facade.listFlows("name");
   }

   @Override
   protected void success(EasyFlowClientFSMContext context) throws Exception {
      log.info("SUCCESS");
      context.socket.close();
   }

   @Override
   protected void updateflow(EasyFlowClientFSMContext context) throws Exception {
      context.facade.updateFlow(flowUUID, "UPDATED FLOW-name", "", false);
   }

   @Override
   protected void linkflowwithcontextproperty(EasyFlowClientFSMContext context) throws Exception {
      context.facade.relateFlow_CONTEXT_PROPERTY_ContextProperty(flowUUID, contextUUID);
   }

   @Override
   protected void newcontextproperty(EasyFlowClientFSMContext context) throws Exception {
      context.facade.newContextProperty("New contextProperty", "", "", "", "");
   }

   @Override
   protected void inspectflow(EasyFlowClientFSMContext context) throws Exception {
      context.facade.getFlow(flowUUID);
   }

   @Override
   protected void inspectcontextproperty(EasyFlowClientFSMContext context) throws Exception {
      context.facade.getContextProperty(contextUUID);
   }

   @Override
   protected void unlink(EasyFlowClientFSMContext context) throws Exception {
      context.facade.unrelateFlow_CONTEXT_PROPERTY_ContextProperty(flowUUID, contextUUID);
   }

   @Override
   protected void onERROR(ExecutionError error, EasyFlowClientFSMContext context) {
      log.error("ERROR in state " + context.getState() + " : " + error.getMessage(), error.getCause());
   }

   public static void main(String[] args) {

      final EasyFlowClientFSMContext context = new EasyFlowClientFSMContext();
      context.domainAddress = "";

      final EasyFlowClientTest clientTest = new EasyFlowClientTest();
      clientTest.start(context, new EasyFlowClientFSMListener() {
         @Override
         public void onEnter(States state, EasyFlowClientFSMContext context) {
            log.info("entering " + state);
         }

         @Override
         public void onError(ExecutionError error, StatefulContext context) {

         }

         @Override
         public void onCompleted(EasyFlowClientFSMContext context) {

         }
      });

   }
}
