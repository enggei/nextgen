package com.generator.generators.java;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.MetaNode;
import org.neo4j.graphdb.Node;

import java.awt.*;

public abstract class JavaDomainVisitor extends BaseDomainVisitor<JavaDomain.ENTITIES> {

    protected JavaDomainVisitor(Component component, String name) {
        super(component, name);
    }

    @Override
    public <T> T visit(Node node, MetaNode<JavaDomain.ENTITIES> entity) {

        if (entity == null) return null;

        switch (entity.getLabel()) {
            case PACKAGE:
                return visitPACKAGE(node);
            case CLASS:
                return visitCLASS(node);
            case INTERFACE:
                return visitINTERFACE(node);
            case METHOD:
                return visitMETHOD(node);
            case ENUM_VALUE:
                return visitENUM_VALUE(node);
            case ENUM:
                return visitENUM(node);
            case FILE:
                return visitFILE(node);
        }

        return null;
    }

    <T> T visitPACKAGE(Node node) {
        return null;
    }

    <T> T visitCLASS(Node node) {
        return null;
    }

    <T> T visitINTERFACE(Node node) {
        return null;
    }

    <T> T visitMETHOD(Node node) {
        return null;
    }

    <T> T visitENUM_VALUE(Node node) {
        return null;
    }

    <T> T visitENUM(Node node) {
        return null;
    }

    <T> T visitFILE(Node node) {
        return null;
    }
}