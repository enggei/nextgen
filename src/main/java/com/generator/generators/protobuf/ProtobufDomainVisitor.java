package com.generator.generators.protobuf;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.MetaNode;
import org.neo4j.graphdb.Node;

import java.awt.*;

public abstract class ProtobufDomainVisitor extends BaseDomainVisitor<ProtobufDomain.ENTITIES> {

    protected ProtobufDomainVisitor(Component component, String name) {
        super(component, name);
    }

    @Override
    public <T> T visit(Node node, MetaNode<ProtobufDomain.ENTITIES> entity) {

        if (entity == null) return null;

        switch (entity.getLabel()) {
            case Property:
                return visitProperty(node);
            case FieldRule:
                return visitFieldRule(node);
            case FieldType:
                return visitFieldType(node);
            case EnumValue:
                return visitEnumValue(node);
            case Enum:
                return visitEnum(node);
            case Extensions:
                return visitExtensions(node);
            case Extend:
                return visitExtend(node);
            case Message:
                return visitMessage(node);
            case Import:
                return visitImport(node);
            case Option:
                return visitOption(node);
            case Package:
                return visitPackage(node);
            case File:
                return visitFile(node);
        }

        return null;
    }
    <T> T visitProperty(Node node) {
        return null;
    }
    <T> T visitFieldRule(Node node) {
        return null;
    }
    <T> T visitFieldType(Node node) {
        return null;
    }
    <T> T visitEnumValue(Node node) {
        return null;
    }
    <T> T visitEnum(Node node) {
        return null;
    }
    <T> T visitExtensions(Node node) {
        return null;
    }
    <T> T visitExtend(Node node) {
        return null;
    }
    <T> T visitMessage(Node node) {
        return null;
    }
    <T> T visitImport(Node node) {
        return null;
    }
    <T> T visitOption(Node node) {
        return null;
    }
    <T> T visitPackage(Node node) {
        return null;
    }
    <T> T visitFile(Node node) {
        return null;
    }
}