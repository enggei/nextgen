package com.generator.generators.easyFlow.vertx;

import au.com.ds.ef.*;
import au.com.ds.ef.call.ContextHandler;
import au.com.ds.ef.call.StateHandler;
import au.com.ds.ef.err.ExecutionError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static au.com.ds.ef.FlowBuilder.*;

import static com.generator.generators.easyFlow.vertx.AbstractDeployAndTestEasyFlow.States.*;
import static com.generator.generators.easyFlow.vertx.AbstractDeployAndTestEasyFlow.Events.*;

/**
 * http://datasymphony.com.au/open-source/easyflow/
 */
public abstract class AbstractDeployAndTestEasyFlow {

    protected static final Logger log = LoggerFactory.getLogger(AbstractDeployAndTestEasyFlow.class);

    public static class AbstractDeployAndTestEasyFlowContext extends StatefulContext {
        public java.util.Stack<io.vertx.core.json.JsonObject> inbox = new java.util.Stack<>();
    }

    public enum States implements StateEnum {
        COMPLETED,
        CONNECT,
        DEPLOYEASYFLOW,
        DEPLOYNEO,
        FAILED,
        FAILEDNEODEPLOYMENT,
        TESTEASYFLOW
    }

    enum Events implements EventEnum {
        connected,
        easyFlowDeployed,
        neoDeployed,
        neoNotDeployed,
        testComplete,
        testFailed
    }

    /** AbstractDeployAndTestEasyFlowListener  **/
    public interface AbstractDeployAndTestEasyFlowListener {
        void onEnter(States state, AbstractDeployAndTestEasyFlowContext context);
        void onError(ExecutionError error, StatefulContext context);
		  void onCompleted(AbstractDeployAndTestEasyFlowContext context);
    }

    private final EasyFlow<AbstractDeployAndTestEasyFlowContext> fsm;
    protected AbstractDeployAndTestEasyFlowListener listener;

    public AbstractDeployAndTestEasyFlow() {
        super();

        // states and transitions:
        this.fsm = from(CONNECT).transit(
on(connected).to(DEPLOYNEO).transit(
on(neoDeployed).to(DEPLOYEASYFLOW).transit(
on(easyFlowDeployed).to(TESTEASYFLOW).transit(
on(testComplete).finish(COMPLETED),
on(testFailed).finish(FAILED)
)
),
on(neoNotDeployed).finish(FAILEDNEODEPLOYMENT)
)
);

        // binding:
        this.fsm
            .executor(new SyncExecutor())
            .whenEnter(COMPLETED, (ContextHandler<AbstractDeployAndTestEasyFlowContext>) context -> {
            	//log.debug("COMPLETED");
               if (listener != null) listener.onEnter(COMPLETED, context);
               completed(context);
            })
            .whenEnter(CONNECT, (ContextHandler<AbstractDeployAndTestEasyFlowContext>) context -> {
            	//log.debug("CONNECT");
               if (listener != null) listener.onEnter(CONNECT, context);
               connect(context);
            })
            .whenEnter(DEPLOYEASYFLOW, (ContextHandler<AbstractDeployAndTestEasyFlowContext>) context -> {
            	//log.debug("DEPLOYEASYFLOW");
               if (listener != null) listener.onEnter(DEPLOYEASYFLOW, context);
               deployeasyflow(context);
            })
            .whenEnter(DEPLOYNEO, (ContextHandler<AbstractDeployAndTestEasyFlowContext>) context -> {
            	//log.debug("DEPLOYNEO");
               if (listener != null) listener.onEnter(DEPLOYNEO, context);
               deployneo(context);
            })
            .whenEnter(FAILED, (ContextHandler<AbstractDeployAndTestEasyFlowContext>) context -> {
            	//log.debug("FAILED");
               if (listener != null) listener.onEnter(FAILED, context);
               failed(context);
            })
            .whenEnter(FAILEDNEODEPLOYMENT, (ContextHandler<AbstractDeployAndTestEasyFlowContext>) context -> {
            	//log.debug("FAILEDNEODEPLOYMENT");
               if (listener != null) listener.onEnter(FAILEDNEODEPLOYMENT, context);
               failedneodeployment(context);
            })
            .whenEnter(TESTEASYFLOW, (ContextHandler<AbstractDeployAndTestEasyFlowContext>) context -> {
            	//log.debug("TESTEASYFLOW");
               if (listener != null) listener.onEnter(TESTEASYFLOW, context);
               testeasyflow(context);
            }).
            whenFinalState((StateHandler<AbstractDeployAndTestEasyFlowContext>) (stateEnum, context) -> {
               log.info("completed");
					if (listener != null) listener.onCompleted(context);
            }).
				whenError((error, context) -> {
					if (listener == null) log.error("ERROR in " + context.getState() + " : " + error.getMessage(), error);
               else listener.onError(error, context);
               onERROR(error, (AbstractDeployAndTestEasyFlowContext) context);
            });
    }

    public void start(final AbstractDeployAndTestEasyFlowContext context) {
        this.fsm.start(context);
    }

    public void start(final AbstractDeployAndTestEasyFlowContext context, AbstractDeployAndTestEasyFlowListener listener) {
        this.listener = listener;
        this.fsm.start(context);
    }

    protected abstract void completed(final AbstractDeployAndTestEasyFlowContext context) throws Exception;
    protected abstract void connect(final AbstractDeployAndTestEasyFlowContext context) throws Exception;
    protected abstract void deployeasyflow(final AbstractDeployAndTestEasyFlowContext context) throws Exception;
    protected abstract void deployneo(final AbstractDeployAndTestEasyFlowContext context) throws Exception;
    protected abstract void failed(final AbstractDeployAndTestEasyFlowContext context) throws Exception;
    protected abstract void failedneodeployment(final AbstractDeployAndTestEasyFlowContext context) throws Exception;
    protected abstract void testeasyflow(final AbstractDeployAndTestEasyFlowContext context) throws Exception;

    protected abstract void onERROR(final ExecutionError error, final AbstractDeployAndTestEasyFlowContext context);


}