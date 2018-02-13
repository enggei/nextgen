package com.generator.generators.easyFlow.vertx;

import au.com.ds.ef.StatefulContext;
import au.com.ds.ef.err.ExecutionError;
import com.generator.generators.easyFlow.EasyFlowDomainVerticle;
import com.generator.generators.vertx.DeployInstanceFSM;
import com.generator.generators.vertx.DeployInstance;
import com.generator.neo.vertx.NeoVerticle;
import com.generator.util.VertxUtil;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Created 17.12.17.
 */
public class DeployAndTestEasyFlow extends AbstractDeployAndTestEasyFlow {

   private static final Vertx vertx = Vertx.vertx();

   public static void main(String[] args) {
      new DeployAndTestEasyFlow().start(new AbstractDeployAndTestEasyFlowContext());
   }

   @Override
   protected void connect(AbstractDeployAndTestEasyFlowContext myContext) throws Exception {
      myContext.trigger(Events.connected);
   }

   @Override
   protected void failed(AbstractDeployAndTestEasyFlowContext context) throws Exception {
      log.error("Failed");
   }

   @Override
   protected void completed(AbstractDeployAndTestEasyFlowContext context) throws Exception {
      log.info("COMPLETED");
   }

   @Override
   protected void deployeasyflow(AbstractDeployAndTestEasyFlowContext myContext) throws Exception {
      final DeployInstance deployer = new DeployInstance() {
         @Override
         protected void deployinstances(DeployInstanceFSM.DeployInstanceClientContext context) throws Exception {
            super.deployinstances(context);

            final JsonObject parameters = new JsonObject().
                  put("verticle", EasyFlowDomainVerticle.class.getCanonicalName()).
                  put("config", new JsonObject().put("neo.instance", myContext.inbox.peek().getJsonObject("body").getString("content")));

            VertxUtil.sendFrame(log, "deploy.verticle", context.clientID, parameters, context.socket);
         }
      };

      final DeployInstanceFSM.DeployInstanceClientContext context = new DeployInstanceFSM.DeployInstanceClientContext();
      context.vertx = vertx;

      deployer.start(context, new DeployInstanceFSM.DeployInstanceClientListener() {
         @Override
         public void onEnter(String state, DeployInstanceFSM.DeployInstanceClientContext context) {
         }

         @Override
         public void onError(ExecutionError error, StatefulContext context) {

         }

         @Override
         public void onCompleted(DeployInstanceFSM.DeployInstanceClientContext context) {
            myContext.inbox.push(context.inbox.peek());
            myContext.trigger(Events.easyFlowDeployed);
         }
      });


   }

   @Override
   protected void failedneodeployment(AbstractDeployAndTestEasyFlowContext context) throws Exception {
      log.error("Could not deploy neo");
   }

   @Override
   protected void deployneo(AbstractDeployAndTestEasyFlowContext myContext) throws Exception {
      final DeployInstance deployer = new DeployInstance() {
         @Override
         protected void deployinstances(DeployInstanceFSM.DeployInstanceClientContext context) throws Exception {
            super.deployinstances(context);

            final JsonObject parameters = new JsonObject().
                  put("verticle", NeoVerticle.class.getCanonicalName()).
                  put("config", new JsonObject().put("neo.path", "testDB"));

            VertxUtil.sendFrame(log, "deploy.verticle", context.clientID, parameters, context.socket);
         }
      };

      final DeployInstanceFSM.DeployInstanceClientContext context = new DeployInstanceFSM.DeployInstanceClientContext();
      context.vertx = vertx;

      deployer.start(context, new DeployInstanceFSM.DeployInstanceClientListener() {
         @Override
         public void onEnter(String state, DeployInstanceFSM.DeployInstanceClientContext context) {
         }

         @Override
         public void onError(ExecutionError error, StatefulContext context) {

         }

         @Override
         public void onCompleted(DeployInstanceFSM.DeployInstanceClientContext context) {

            if(context.getState().equals(DeployInstanceFSM.States.INSTANTIATIONFAILED)) {
               myContext.trigger(Events.neoNotDeployed);
            } else {
               myContext.inbox.push(context.inbox.peek());
               myContext.trigger(Events.neoDeployed);
            }
         }
      });
   }

   @Override
   protected void testeasyflow(AbstractDeployAndTestEasyFlowContext myContext) throws Exception {

      final EasyFlowClientTest clientTest = new EasyFlowClientTest();
      final EasyFlowClientFSM.EasyFlowClientFSMContext context = new EasyFlowClientFSM.EasyFlowClientFSMContext();
      context.domainAddress = myContext.inbox.peek().getJsonObject("body").getString("content");
      context.vertx = vertx;

      clientTest.start(context, new EasyFlowClientFSM.EasyFlowClientFSMListener() {
         @Override
         public void onEnter(EasyFlowClientFSM.States state, EasyFlowClientFSM.EasyFlowClientFSMContext context) {

         }

         @Override
         public void onError(ExecutionError error, StatefulContext context) {

         }

         @Override
         public void onCompleted(EasyFlowClientFSM.EasyFlowClientFSMContext context) {

            if(context.getState().equals(EasyFlowClientFSM.States.FAILED)) {
               log.error("EasyFlow test failed ");
            } else {
               myContext.trigger(Events.testComplete);
            }
         }
      });
   }

   @Override
   protected void onERROR(ExecutionError error, AbstractDeployAndTestEasyFlowContext context) {

   }
}
