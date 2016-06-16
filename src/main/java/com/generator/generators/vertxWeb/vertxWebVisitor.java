package com.generator.generators.vertxWeb;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.MetaNode;
import org.neo4j.graphdb.Node;

import java.awt.*;

public abstract class vertxWebVisitor extends BaseDomainVisitor<vertxWeb.ENTITIES> {

    protected vertxWebVisitor(Component component, String name) {
        super(component, name);
    }

    @Override
    public <T> T visit(Node node, MetaNode<vertxWeb.ENTITIES> entity) {

        if (entity == null) return null;

        switch (entity.getLabel()) {
            case HTTPServer:
                return visitHTTPServer(node);
            case Router:
                return visitRouter(node);
            case HandlerThrowable:
                return visitHandlerThrowable(node);
            case Route:
                return visitRoute(node);
            case RequestHandler:
                return visitRequestHandler(node);
            case StaticHandler:
                return visitStaticHandler(node);
        }

        return null;
    }
    <T> T visitHTTPServer(Node node) {
        return null;
    }
    <T> T visitRouter(Node node) {
        return null;
    }
    <T> T visitHandlerThrowable(Node node) {
        return null;
    }
    <T> T visitRoute(Node node) {
        return null;
    }
    <T> T visitRequestHandler(Node node) {
        return null;
    }
    <T> T visitStaticHandler(Node node) {
        return null;
    }
}