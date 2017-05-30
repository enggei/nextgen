package com.generator.generators.regexp;

import au.com.ds.ef.*;
import au.com.ds.ef.call.ContextHandler;
import au.com.ds.ef.call.ExecutionErrorHandler;
import au.com.ds.ef.err.ExecutionError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static au.com.ds.ef.FlowBuilder.*;
import static com.generator.generators.regexp.RegexpGeneric.States.*;
import static com.generator.generators.regexp.RegexpGeneric.Events.*;

/**
 * http://datasymphony.com.au/open-source/easyflow/
 */
public abstract class RegexpGeneric {

    protected static final Logger log = LoggerFactory.getLogger(RegexpGeneric.class);

    static class RegexpGenericContext extends StatefulContext {
        Integer sampleCount;
        java.beans.PropertyChangeSupport changeSupport = new java.beans.PropertyChangeSupport(this);;
    }

    enum States implements StateEnum {
        CREATESAMPLES,
        INIT,
        SAMPLESCREATED
    }

    enum Events implements EventEnum {
        onCreateSamples,
        onSamplesCreated
    }

    /** RegexpGenericListener  **/
    public interface RegexpGenericListener {
        void onEnter(String state, RegexpGenericContext context);
        void onError(ExecutionError error, StatefulContext context);
    }

    private final EasyFlow<RegexpGenericContext> fsm;
    protected RegexpGenericListener listener;

    public RegexpGeneric() {
        super();

        // states and transitions:
        this.fsm =  from(INIT).transit(
 on(onCreateSamples).to(CREATESAMPLES).transit(
 on(onSamplesCreated).finish(SAMPLESCREATED)
)
);

        // binding:
        this.fsm
            .executor(new SyncExecutor())
            .whenEnter(CREATESAMPLES, new ContextHandler<RegexpGenericContext>() {
                @Override
                public void call(final RegexpGenericContext context) throws Exception {
                    //log.debug("CREATESAMPLES");
                    if (listener != null) listener.onEnter("CREATESAMPLES", context);
                    createsamples(context);
                }
            })
            .whenEnter(INIT, new ContextHandler<RegexpGenericContext>() {
                @Override
                public void call(final RegexpGenericContext context) throws Exception {
                    //log.debug("INIT");
                    if (listener != null) listener.onEnter("INIT", context);
                    init(context);
                }
            })
            .whenEnter(SAMPLESCREATED, new ContextHandler<RegexpGenericContext>() {
                @Override
                public void call(final RegexpGenericContext context) throws Exception {
                    //log.debug("SAMPLESCREATED");
                    if (listener != null) listener.onEnter("SAMPLESCREATED", context);
                    samplescreated(context);
                }
            }).
            whenError(new ExecutionErrorHandler<StatefulContext>() {
                @Override
                public void call(ExecutionError error, StatefulContext context) {
                    log.info("ERROR");
                    if (listener != null) listener.onError(error, context);
                    onERROR(error,context);
                    }
                });
    }

    public void start(final RegexpGenericContext context) {
        this.fsm.start(context);
    }

    public void start(final RegexpGenericContext context, RegexpGenericListener listener) {
        this.listener = listener;
        this.fsm.start(context);
    }

    protected abstract void createsamples(final RegexpGenericContext context) throws Exception;
    protected abstract void init(final RegexpGenericContext context) throws Exception;
    protected abstract void samplescreated(final RegexpGenericContext context) throws Exception;

    protected abstract void onERROR(final ExecutionError error, final StatefulContext context);
}