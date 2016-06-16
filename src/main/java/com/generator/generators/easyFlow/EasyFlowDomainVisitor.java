package com.generator.generators.easyFlow;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.MetaNode;
import org.neo4j.graphdb.Node;

import java.awt.*;

public abstract class EasyFlowDomainVisitor extends BaseDomainVisitor<EasyFlowDomain.ENTITIES> {

    protected EasyFlowDomainVisitor(Component component, String name) {
        super(component, name);
    }

    @Override
    public <T> T visit(Node node, MetaNode<EasyFlowDomain.ENTITIES> entity) {

        if (entity == null) return null;

        switch (entity.getLabel()) {
            case Flow:
                return visitFlow(node);
            case ContextProperty:
                return visitContextProperty(node);
            case State:
                return visitState(node);
            case Event:
                return visitEvent(node);
            case SuperParameter:
                return visitSuperParameter(node);
        }

        return null;
    }

    <T> T visitFlow(Node node) {
        return null;
    }

    <T> T visitContextProperty(Node node) {
        return null;
    }

    <T> T visitState(Node node) {
        return null;
    }

    <T> T visitEvent(Node node) {
        return null;
    }

    <T> T visitSuperParameter(Node node) {
        return null;
    }
}