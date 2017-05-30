package com.generator.generators.regexp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import static com.generator.util.VertxWebUtil.debug;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;

/**
 * Created 28.05.17.
 */
public abstract class GenericRegexpVerticle extends AbstractVerticle {

   protected static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(GenericRegexpVerticle.class);

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("Starting GenericRegexpVerticle using config " + config().encode());

      final Router router = Router.router(vertx);
      router.route().handler(BodyHandler.create());

      router.get("/genericRegexp/start").handler(routingContext -> {
         log.debug(debug(routingContext));

         onStart(routingContext);
      });

      router.route().handler(StaticHandler.create().
            setWebRoot(config().getString("web.root")).
            setIndexPage("/genericRegexp/index.html"));

      // fallback handler (400 - BAD REQUEST)
      router.route().last().handler(routingContext -> routingContext.put(BAD_REQUEST.reasonPhrase(), routingContext.request().path()).
            fail(BAD_REQUEST.code()));

      vertx.createHttpServer(new HttpServerOptions()).
            requestHandler(router::accept).
            listen(config().getInteger("content.port"));

      startFuture.complete();
   }

   protected abstract void onStart(RoutingContext routingContext);
}