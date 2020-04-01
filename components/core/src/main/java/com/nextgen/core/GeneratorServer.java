package com.nextgen.core;

import com.nextgen.core.domain.NeoDomainDomainVerticle;
import com.nextgen.core.template.TemplateVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class GeneratorServer extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        runServer(vertx, 8090);

        NeoDomainDomainVerticle.deploy("/data/domain", vertx, s -> System.out.println("deployed DomainDomainVerticle " + s));
        TemplateVerticle.deploy("/data/template", vertx, s -> System.out.println("deployed TemplateVerticle " + s));
    }

    public static void runServer(Vertx vertx, int port) {

        final io.vertx.ext.web.Router router = io.vertx.ext.web.Router.router(vertx);
        router.route().handler(io.vertx.ext.web.handler.BodyHandler.create());

        final io.vertx.ext.web.handler.sockjs.BridgeOptions options = new io.vertx.ext.web.handler.sockjs.BridgeOptions().
                addInboundPermitted(new io.vertx.ext.bridge.PermittedOptions().setAddressRegex(".*")).
                addOutboundPermitted(new io.vertx.ext.bridge.PermittedOptions().setAddressRegex(".*"));

        router.route("/eventbus/*").handler(io.vertx.ext.web.handler.sockjs.SockJSHandler.create(vertx).bridge(options, event -> {
            if (event.type() == io.vertx.ext.bridge.BridgeEventType.SOCKET_CREATED)
                System.out.println("A socket was created");
            System.out.println(event.type() + " " + event.socket().localAddress());
            event.complete(true);
        }));

        vertx.createHttpServer(new io.vertx.core.http.HttpServerOptions()).
                requestHandler(router::accept).
                listen(port);
    }
}