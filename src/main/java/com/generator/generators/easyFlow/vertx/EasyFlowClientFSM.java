package com.generator.generators.easyFlow.vertx;

import au.com.ds.ef.*;
import au.com.ds.ef.call.ContextHandler;
import au.com.ds.ef.call.StateHandler;
import au.com.ds.ef.err.ExecutionError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static au.com.ds.ef.FlowBuilder.*;

import static com.generator.generators.easyFlow.vertx.EasyFlowClientFSM.States.*;
import static com.generator.generators.easyFlow.vertx.EasyFlowClientFSM.Events.*;

/**
 * http://datasymphony.com.au/open-source/easyflow/
 */
public abstract class EasyFlowClientFSM {

    protected static final Logger log = LoggerFactory.getLogger(EasyFlowClientFSM.class);

    public static class EasyFlowClientFSMContext extends StatefulContext {
        public com.generator.generators.easyFlow.EasyFlowFacade facade;
        public io.vertx.core.net.NetSocket socket;
        public String clientID = java.util.UUID.randomUUID().toString();
        public String host = "localhost";
        public Integer port = 7000;
        public io.vertx.core.Vertx vertx;
        public java.util.Stack<io.vertx.core.json.JsonObject> inbox = new java.util.Stack<>();
        public String domainAddress;
    }

    public enum States implements StateEnum {
        CONNECT,
        FAILED,
        INSPECTCONTEXTPROPERTY,
        INSPECTFLOW,
        LINKFLOWWITHCONTEXTPROPERTY,
        LISTFLOWS,
        NEWCONTEXTPROPERTY,
        REMOVECONTEXTPROPERTY,
        REMOVEFLOW,
        SENDNEWFLOW,
        SUCCESS,
        TESTVISITOR,
        UNLINK,
        UPDATEFLOW
    }

    enum Events implements EventEnum {
        connected,
        contextInspectSucccess,
        contextPropertyFailed,
        contextPropertySuccess,
        inspectFailed,
        inspectSuccess,
        linkFailed,
        linkedSuccess,
        listFailed,
        listSuccess,
        newFlowCreated,
        newFlowFailed,
        removeContextProperty,
        removeFailed,
        removeSuccess,
        testVisitorFailed,
        testVisitorSuccess,
        unlinkFailed,
        unlinkSuccess,
        updateFailed,
        updateSuccess
    }

    /** EasyFlowClientFSMListener  **/
    public interface EasyFlowClientFSMListener {
        void onEnter(States state, EasyFlowClientFSMContext context);
        void onError(ExecutionError error, StatefulContext context);
		  void onCompleted(EasyFlowClientFSMContext context);
    }

    private final EasyFlow<EasyFlowClientFSMContext> fsm;
    protected EasyFlowClientFSMListener listener;

    public EasyFlowClientFSM() {
        super();

        // states and transitions:
        this.fsm = from(CONNECT).transit(
on(connected).to(SENDNEWFLOW).transit(
on(newFlowCreated).to(TESTVISITOR).transit(
on(testVisitorFailed).finish(FAILED),
on(testVisitorSuccess).to(UPDATEFLOW).transit(
on(updateSuccess).to(LISTFLOWS).transit(
on(listSuccess).to(NEWCONTEXTPROPERTY).transit(
on(contextPropertySuccess).to(LINKFLOWWITHCONTEXTPROPERTY).transit(
on(linkFailed).to(FAILED),
on(linkedSuccess).to(INSPECTFLOW).transit(
on(inspectSuccess).to(INSPECTCONTEXTPROPERTY).transit(
on(inspectFailed).to(FAILED),
on(contextInspectSucccess).to(UNLINK).transit(
on(unlinkFailed).to(FAILED),
on(unlinkSuccess).to(REMOVEFLOW).transit(
on(removeSuccess).to(REMOVECONTEXTPROPERTY).transit(
on(removeFailed).to(FAILED),
on(removeContextProperty).finish(SUCCESS)
),
on(removeFailed).to(FAILED)
)
)
),
on(inspectFailed).to(FAILED)
)
),
on(contextPropertyFailed).to(FAILED)
),
on(listFailed).to(FAILED)
),
on(updateFailed).to(FAILED)
)
),
on(newFlowFailed).to(FAILED)
)
);

        // binding:
        this.fsm
            .executor(new SyncExecutor())
            .whenEnter(CONNECT, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("CONNECT");
               if (listener != null) listener.onEnter(CONNECT, context);
               connect(context);
            })
            .whenEnter(FAILED, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("FAILED");
               if (listener != null) listener.onEnter(FAILED, context);
               failed(context);
            })
            .whenEnter(INSPECTCONTEXTPROPERTY, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("INSPECTCONTEXTPROPERTY");
               if (listener != null) listener.onEnter(INSPECTCONTEXTPROPERTY, context);
               inspectcontextproperty(context);
            })
            .whenEnter(INSPECTFLOW, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("INSPECTFLOW");
               if (listener != null) listener.onEnter(INSPECTFLOW, context);
               inspectflow(context);
            })
            .whenEnter(LINKFLOWWITHCONTEXTPROPERTY, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("LINKFLOWWITHCONTEXTPROPERTY");
               if (listener != null) listener.onEnter(LINKFLOWWITHCONTEXTPROPERTY, context);
               linkflowwithcontextproperty(context);
            })
            .whenEnter(LISTFLOWS, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("LISTFLOWS");
               if (listener != null) listener.onEnter(LISTFLOWS, context);
               listflows(context);
            })
            .whenEnter(NEWCONTEXTPROPERTY, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("NEWCONTEXTPROPERTY");
               if (listener != null) listener.onEnter(NEWCONTEXTPROPERTY, context);
               newcontextproperty(context);
            })
            .whenEnter(REMOVECONTEXTPROPERTY, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("REMOVECONTEXTPROPERTY");
               if (listener != null) listener.onEnter(REMOVECONTEXTPROPERTY, context);
               removecontextproperty(context);
            })
            .whenEnter(REMOVEFLOW, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("REMOVEFLOW");
               if (listener != null) listener.onEnter(REMOVEFLOW, context);
               removeflow(context);
            })
            .whenEnter(SENDNEWFLOW, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("SENDNEWFLOW");
               if (listener != null) listener.onEnter(SENDNEWFLOW, context);
               sendnewflow(context);
            })
            .whenEnter(SUCCESS, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("SUCCESS");
               if (listener != null) listener.onEnter(SUCCESS, context);
               success(context);
            })
            .whenEnter(TESTVISITOR, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("TESTVISITOR");
               if (listener != null) listener.onEnter(TESTVISITOR, context);
               testvisitor(context);
            })
            .whenEnter(UNLINK, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("UNLINK");
               if (listener != null) listener.onEnter(UNLINK, context);
               unlink(context);
            })
            .whenEnter(UPDATEFLOW, (ContextHandler<EasyFlowClientFSMContext>) context -> {
            	//log.debug("UPDATEFLOW");
               if (listener != null) listener.onEnter(UPDATEFLOW, context);
               updateflow(context);
            }).
            whenFinalState((StateHandler<EasyFlowClientFSMContext>) (stateEnum, context) -> {
               log.info("completed");
					if (listener != null) listener.onCompleted(context);
            }).
				whenError((error, context) -> {
					if (listener == null) log.error("ERROR in " + context.getState() + " : " + error.getMessage(), error);
               else listener.onError(error, context);
               onERROR(error, (EasyFlowClientFSMContext) context);
            });
    }

    public void start(final EasyFlowClientFSMContext context) {
        this.fsm.start(context);
    }

    public void start(final EasyFlowClientFSMContext context, EasyFlowClientFSMListener listener) {
        this.listener = listener;
        this.fsm.start(context);
    }

    protected abstract void connect(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void failed(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void inspectcontextproperty(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void inspectflow(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void linkflowwithcontextproperty(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void listflows(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void newcontextproperty(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void removecontextproperty(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void removeflow(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void sendnewflow(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void success(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void testvisitor(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void unlink(final EasyFlowClientFSMContext context) throws Exception;
    protected abstract void updateflow(final EasyFlowClientFSMContext context) throws Exception;

    protected abstract void onERROR(final ExecutionError error, final EasyFlowClientFSMContext context);

	// Json-message handler
	protected void handleMessage(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) {
		log.info("message received in state " + context.getState().name() + " : " + message.toString());

	   switch (States.valueOf(context.getState().name())) {
			case CONNECT:
				handleMessageInCONNECTState(context, message);
				break;
			case FAILED:
				handleMessageInFAILEDState(context, message);
				break;
			case INSPECTCONTEXTPROPERTY:
				handleMessageInINSPECTCONTEXTPROPERTYState(context, message);
				break;
			case INSPECTFLOW:
				handleMessageInINSPECTFLOWState(context, message);
				break;
			case LINKFLOWWITHCONTEXTPROPERTY:
				handleMessageInLINKFLOWWITHCONTEXTPROPERTYState(context, message);
				break;
			case LISTFLOWS:
				handleMessageInLISTFLOWSState(context, message);
				break;
			case NEWCONTEXTPROPERTY:
				handleMessageInNEWCONTEXTPROPERTYState(context, message);
				break;
			case REMOVECONTEXTPROPERTY:
				handleMessageInREMOVECONTEXTPROPERTYState(context, message);
				break;
			case REMOVEFLOW:
				handleMessageInREMOVEFLOWState(context, message);
				break;
			case SENDNEWFLOW:
				handleMessageInSENDNEWFLOWState(context, message);
				break;
			case SUCCESS:
				handleMessageInSUCCESSState(context, message);
				break;
			case TESTVISITOR:
				handleMessageInTESTVISITORState(context, message);
				break;
			case UNLINK:
				handleMessageInUNLINKState(context, message);
				break;
			case UPDATEFLOW:
				handleMessageInUPDATEFLOWState(context, message);
				break;
	    }
	}

	protected void handleMessageInCONNECTState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in CONNECT state"); }
	protected void handleMessageInFAILEDState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in FAILED state"); }
	protected void handleMessageInINSPECTCONTEXTPROPERTYState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in INSPECTCONTEXTPROPERTY state"); }
	protected void handleMessageInINSPECTFLOWState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in INSPECTFLOW state"); }
	protected void handleMessageInLINKFLOWWITHCONTEXTPROPERTYState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in LINKFLOWWITHCONTEXTPROPERTY state"); }
	protected void handleMessageInLISTFLOWSState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in LISTFLOWS state"); }
	protected void handleMessageInNEWCONTEXTPROPERTYState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in NEWCONTEXTPROPERTY state"); }
	protected void handleMessageInREMOVECONTEXTPROPERTYState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in REMOVECONTEXTPROPERTY state"); }
	protected void handleMessageInREMOVEFLOWState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in REMOVEFLOW state"); }
	protected void handleMessageInSENDNEWFLOWState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in SENDNEWFLOW state"); }
	protected void handleMessageInSUCCESSState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in SUCCESS state"); }
	protected void handleMessageInTESTVISITORState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in TESTVISITOR state"); }
	protected void handleMessageInUNLINKState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in UNLINK state"); }
	protected void handleMessageInUPDATEFLOWState(EasyFlowClientFSMContext context, io.vertx.core.json.JsonObject message) { log.info("ignoring " + message.toString() + " in UPDATEFLOW state"); }

}