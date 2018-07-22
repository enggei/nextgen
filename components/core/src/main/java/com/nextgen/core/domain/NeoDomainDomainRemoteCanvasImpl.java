package com.nextgen.core.domain;

import io.vertx.core.Vertx;

public class NeoDomainDomainRemoteCanvasImpl extends NeoDomainDomainRemoteCanvas {
    public NeoDomainDomainRemoteCanvasImpl(Vertx vertx, Integer port, String host) {
        super(vertx, port, host);
    }
}
