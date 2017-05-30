package com.generator.generators.regexp;

import au.com.ds.ef.StatefulContext;
import au.com.ds.ef.err.ExecutionError;

import static com.generator.generators.regexp.RegexpUtils.randomString;

/**
 * Created 28.05.17.
 */
public class RegexpGenericImpl extends RegexpGeneric {

   @Override
   protected void createsamples(RegexpGenericContext context) throws Exception {
      for (int i = 0; i < context.sampleCount; i++)
         context.changeSupport.firePropertyChange("samples", "sample", randomString(20));
      context.trigger(Events.onSamplesCreated);
   }

   @Override
   protected void init(RegexpGenericContext context) throws Exception {
      context.trigger(Events.onCreateSamples);
   }

   @Override
   protected void samplescreated(RegexpGenericContext context) throws Exception {
      context.changeSupport.firePropertyChange("samples", "status", "DONE");
   }

   @Override
   protected void onERROR(ExecutionError error, StatefulContext context) {

   }
}