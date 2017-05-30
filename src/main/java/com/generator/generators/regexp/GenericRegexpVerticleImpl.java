package com.generator.generators.regexp;

import io.vertx.ext.web.RoutingContext;

/**
 * Created 28.05.17.
 */
public class GenericRegexpVerticleImpl extends GenericRegexpVerticle {

   @Override
   protected void onStart(RoutingContext routingContext) {
      log.info("onStart : " + routingContext.getAcceptableContentType());
   }
}