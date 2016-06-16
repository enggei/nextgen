package com.generator.generators.generatorDomain;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.MetaNode;
import org.neo4j.graphdb.Node;

import java.awt.*;

public abstract class GeneratorDomainVisitor extends BaseDomainVisitor<GeneratorDomain.ENTITIES> {

    protected GeneratorDomainVisitor(Component component, String name) {
        super(component, name);
    }

    @Override
    public <T> T visit(Node node, MetaNode<GeneratorDomain.ENTITIES> entity) {

        if (entity == null) return null;

        switch (entity.getLabel()) {
            case ENTITY:
                return visitENTITY(node);
            case DOMAIN:
                return visitDOMAIN(node);
            case RELATION:
                return visitRELATION(node);
            case PROPERTY:
                return visitPROPERTY(node);
            case STATEMENTPARAMETER:
                return visitSTATEMENTPARAMETER(node);
            case TEMPLATEGROUP:
                return visitTEMPLATEGROUP(node);
            case STATEMENT:
                return visitSTATEMENT(node);
        }

        return null;
    }

    <T> T visitENTITY(Node node) {
        return null;
    }

    <T> T visitDOMAIN(Node node) {
        return null;
    }

    <T> T visitRELATION(Node node) {
        return null;
    }

    <T> T visitPROPERTY(Node node) {
        return null;
    }

    <T> T visitSTATEMENTPARAMETER(Node node) {
        return null;
    }

    <T> T visitTEMPLATEGROUP(Node node) {
        return null;
    }

    <T> T visitSTATEMENT(Node node) {
        return null;
    }
}