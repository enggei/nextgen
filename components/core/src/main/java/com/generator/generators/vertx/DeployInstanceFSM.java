package com.generator.generators.vertx;

import au.com.ds.ef.*;
import au.com.ds.ef.call.ContextHandler;
import au.com.ds.ef.call.StateHandler;
import au.com.ds.ef.err.ExecutionError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static au.com.ds.ef.FlowBuilder.*;
import io.vertx.core.json.JsonObject;

import static com.generator.generators.vertx.DeployInstanceFSM.States.*;
import static com.generator.generators.vertx.DeployInstanceFSM.Events.*;

/**
 * http://datasymphony.com.au/open-source/easyflow/
 */
public abstract class DeployInstanceFSM {

    protected static final Logger log = LoggerFactory.getLogger(DeployInstanceFSM.class);

    public static class DeployInstanceClientContext extends StatefulContext {
        public io.vertx.core.net.NetSocket socket;
        public String clientID = java.util.UUID.randomUUID().toString();
        public String host = "localhost";
        public Integer port = 7000;
        public io.vertx.core.Vertx vertx;
        public java.util.Stack<io.vertx.core.json.JsonObject> inbox = new java.util.Stack<io.vertx.core.json.JsonObject>();
    }

    public enum States implements StateEnum {
        CONNECT,
        DEPLOYINSTANCES,
        INSTANTIATIONFAILED,
        INSTANTIATIONSUCCESS
    }

    enum Events implements EventEnum {
        connected,
        instanceDeployed,
        instanceFailed
    }

    /** DeployInstanceClientListener  **/
    public interface DeployInstanceClientListener {
        void onEnter(String state, DeployInstanceClientContext context);
        void onError(ExecutionError error, StatefulContext context);
		  void onCompleted(DeployInstanceClientContext context);
    }

    private final EasyFlow<DeployInstanceClientContext> fsm;
    protected DeployInstanceClientListener listener;

    public DeployInstanceFSM() {
        super();

        // states and transitions:
        this.fsm = from(CONNECT).transit(
on(connected).to(DEPLOYINSTANCES).transit(
on(instanceDeployed).finish(INSTANTIATIONSUCCESS),
on(instanceFailed).finish(INSTANTIATIONFAILED)
)
);

        // binding:
        this.fsm
            .executor(new SyncExecutor())
            .whenEnter(CONNECT, (ContextHandler<DeployInstanceClientContext>) context -> {
            	//log.debug("CONNECT");
               if (listener != null) listener.onEnter("CONNECT", context);
               connect(context);
            })
            .whenEnter(DEPLOYINSTANCES, (ContextHandler<DeployInstanceClientContext>) context -> {
            	//log.debug("DEPLOYINSTANCES");
               if (listener != null) listener.onEnter("DEPLOYINSTANCES", context);
               deployinstances(context);
            })
            .whenEnter(INSTANTIATIONFAILED, (ContextHandler<DeployInstanceClientContext>) context -> {
            	//log.debug("INSTANTIATIONFAILED");
               if (listener != null) listener.onEnter("INSTANTIATIONFAILED", context);
               instantiationfailed(context);
            })
            .whenEnter(INSTANTIATIONSUCCESS, (ContextHandler<DeployInstanceClientContext>) context -> {
            	//log.debug("INSTANTIATIONSUCCESS");
               if (listener != null) listener.onEnter("INSTANTIATIONSUCCESS", context);
               instantiationsuccess(context);
            }).
            whenFinalState((StateHandler<DeployInstanceClientContext>) (stateEnum, context) -> {
               log.info("completed");
					if (listener != null) listener.onCompleted(context);
            }).
				whenError((error, context) -> {
					if (listener == null) log.error("ERROR in " + context.getState() + " : " + error.getMessage(), error);
               else listener.onError(error, context);
               onERROR(error, (DeployInstanceClientContext) context);
            });
    }

    public void start(final DeployInstanceClientContext context) {
        this.fsm.start(context);
    }

    public void start(final DeployInstanceClientContext context, DeployInstanceClientListener listener) {
        this.listener = listener;
        this.fsm.start(context);
    }

    protected abstract void connect(final DeployInstanceClientContext context) throws Exception;
    protected abstract void deployinstances(final DeployInstanceClientContext context) throws Exception;
    protected abstract void instantiationfailed(final DeployInstanceClientContext context) throws Exception;
    protected abstract void instantiationsuccess(final DeployInstanceClientContext context) throws Exception;

    protected abstract void onERROR(final ExecutionError error, final DeployInstanceClientContext context);

	// Json-message handler
	protected void handleMessage(DeployInstanceClientContext context, JsonObject message) {
		log.info("message received in state " + context.getState().name() + " : " + message.toString());

	   switch (States.valueOf(context.getState().name())) {
			case CONNECT:
				handleMessageInCONNECTState(context, message);
				break;
			case DEPLOYINSTANCES:
				handleMessageInDEPLOYINSTANCESState(context, message);
				break;
			case INSTANTIATIONFAILED:
				handleMessageInINSTANTIATIONFAILEDState(context, message);
				break;
			case INSTANTIATIONSUCCESS:
				handleMessageInINSTANTIATIONSUCCESSState(context, message);
				break;
	    }
	}

	protected void handleMessageInCONNECTState(DeployInstanceClientContext context, JsonObject message) { log.info("ignoring " + message.toString() + " in CONNECT state"); }
	protected void handleMessageInDEPLOYINSTANCESState(DeployInstanceClientContext context, JsonObject message) { log.info("ignoring " + message.toString() + " in DEPLOYINSTANCES state"); }
	protected void handleMessageInINSTANTIATIONFAILEDState(DeployInstanceClientContext context, JsonObject message) { log.info("ignoring " + message.toString() + " in INSTANTIATIONFAILED state"); }
	protected void handleMessageInINSTANTIATIONSUCCESSState(DeployInstanceClientContext context, JsonObject message) { log.info("ignoring " + message.toString() + " in INSTANTIATIONSUCCESS state"); }

}