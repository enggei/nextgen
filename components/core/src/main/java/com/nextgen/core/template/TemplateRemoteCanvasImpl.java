package com.nextgen.core.template;

import io.vertx.core.Vertx;

public class TemplateRemoteCanvasImpl extends TemplateRemoteCanvas {
    public TemplateRemoteCanvasImpl(Vertx vertx, Integer port, String host) {
        super(vertx, port, host);
    }
}
