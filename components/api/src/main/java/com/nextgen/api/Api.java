package com.nextgen.api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Launcher;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.bridge.BridgeEventType;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;

public class Api extends AbstractVerticle {

   private static final Logger log = LoggerFactory.getLogger(Api.class);

   static final String UUID_PATTERN = "[0-9a-zA-Z]{8}(-[0-9a-zA-Z]{4}){3}-[0-9a-zA-Z]{12}";

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("Starting API using config " + config().encode());

      final Router router = Router.router(vertx);

      final BridgeOptions options = new BridgeOptions()
//         .addInboundPermitted(new PermittedOptions().setAddress("test"))
         .addOutboundPermitted(new PermittedOptions().setAddress("test"))
         .addOutboundPermitted(new PermittedOptions().setAddressRegex("test\\." + UUID_PATTERN))
         ;

      router.route("/eventbus/*").handler(SockJSHandler.create(vertx).bridge(options, event -> {
         if (event.type() == BridgeEventType.SOCKET_CREATED)
            log.debug("A socket was created");

         event.complete(true);
      }));

      router.route().handler(BodyHandler.create());

      router.get("/v1/test").handler(routingContext -> forward(routingContext, ""));

      // fallback handler (400 - BAD REQUEST)
      router.route().last().handler(routingContext -> routingContext.put(BAD_REQUEST.reasonPhrase(), routingContext.request().path()).
         fail(BAD_REQUEST.code()));

      vertx.createHttpServer(new HttpServerOptions()).
         requestHandler(router::accept).
         listen(config().getInteger("http.port"));

      // TEST
      vertx.eventBus().consumer("ping.address", message -> {
         log.debug("Received from \"" + message.address() + "\": " + message.body().toString());
         message.reply("PONG!");
      });

      log.info("Started");

      startFuture.complete();
   }

   private void forward(RoutingContext routingContext, String address) {
      log.info(debug(routingContext) + " => " + address);

      routingContext.response().setStatusCode(200).end("YAY");
/*
      VertxUtil.sendJsonMessage(vertx, address, new JsonObject(), log, new VertxUtil.SuccessHandler<Message<JsonObject>>() {
         @Override
         public void onSuccess(Message<JsonObject> result) {
            VertxWebUtil.newJsonResponse(routingContext, HttpResponseStatus.OK, result.body());
         }

         @Override
         public void onFail(Throwable t) {
            VertxWebUtil.newErrorResponse(routingContext, HttpResponseStatus.INTERNAL_SERVER_ERROR, t.getMessage());
         }
      });
*/
   }

   private static String debug(RoutingContext request) {
      final StringBuilder out = new StringBuilder();
      for (Map.Entry<String, String> param : request.request().params())
         out.append(param.getKey()).append("=").append(param.getValue()).append("\n");
      return request.request().uri() + " " + out.toString().trim();
   }

   public static void main(String[] args) {
      Launcher.executeCommand("run", Api.class.getName());
   }
}
