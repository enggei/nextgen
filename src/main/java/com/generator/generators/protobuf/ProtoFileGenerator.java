package com.generator.generators.protobuf;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.awt.*;
import java.io.File;
import java.util.*;

import static com.generator.generators.protobuf.ProtobufDomain.ENTITIES.*;
import static com.generator.generators.protobuf.ProtobufDomain.RELATIONS.*;

/**
 * goe on 4/23/15.
 * <p/>
 * Builds a .proto file
 */
public class ProtoFileGenerator extends ProtobufDomainVisitor {

    private final ProtobufGroup group = new ProtobufGroup();

    public ProtoFileGenerator(Component component) {
        super(component, ".proto file Generator");
    }

    @Override
    <T> T visitFile(Node node) {

		 if (has(node, "targetFile")) this.targetFile = new File(get(node, "targetFile").toString());

        final StringBuilder fileContent = new StringBuilder();

        for (Relationship packages : outgoing(node, PACKAGE))
            fileContent.append((String)visitPackage(packages.getOtherNode(node)));

        return (T) fileContent.toString();
    }

    @Override
    <T> T visitPackage(Node node) {

        final ProtobufGroup.protobufPackageST packageST = group.newprotobufPackage().
                setPackage(get(node, "name"));

        for (Relationship relationship : outgoing(node, OPTIONS)) {
            final Node optionNode = other(node, relationship);
            if (has(optionNode, "java_package"))
                packageST.addOptionsValue("java_package", get(optionNode, "java_package"));
            if (has(optionNode, "optimize_for"))
                packageST.addOptionsValue("optimize_for", get(optionNode, "optimize_for"));
        }

        for (Relationship relationship : outgoing(node, IMPORT)) {
            final Node packageNode = other(node, relationship);
            packageST.addImportsValue(get(packageNode, "package"));
        }

        for (Relationship relationship : outgoing(node, MESSAGE)) {
            if (isType(relationship, Message)) {
                packageST.addDeliverablesValue(visitMessage(other(node, relationship)));
            } else if (isType(relationship, Extend)) {
                packageST.addDeliverablesValue(visitExtend(other(node, relationship)));
            } else if (isType(relationship, Enum)) {
                packageST.addDeliverablesValue(visitEnum(other(node, relationship)));
            }
        }

        return (T) packageST.toString();
    }

    @Override
    <T> T visitMessage(Node node) {

        final ProtobufGroup.messageST messageST = group.newmessage().
                setName(get(node, "name")).
                setComments(get(node, "comment"));

        for (Relationship relationship : outgoing(node, MESSAGE)) {
            if (isType(relationship, Message)) {
                messageST.addPropertiesValue(visitMessage(other(node, relationship)));
            } else if (isType(relationship, Extend)) {
                messageST.addPropertiesValue(visitExtend(other(node, relationship)));
            } else if (isType(relationship, Enum)) {
                messageST.addPropertiesValue(visitEnum(other(node, relationship)));
            }
        }

        for (Relationship relationship : outgoing(node, FIELD)) {
            if (isType(relationship, Property)) {
                messageST.addPropertiesValue(visitProperty(other(node, relationship)));
            } else if (isType(relationship, Extensions)) {
                messageST.addPropertiesValue(visitExtensions(other(node, relationship)));
            } else if (isType(relationship, Enum)) {
                messageST.addPropertiesValue(visitEnum(other(node, relationship)));
            } else if (isType(relationship, Message)) {
                messageST.addPropertiesValue(visitMessage(other(node, relationship)));
            }
        }

        return (T) messageST.toString();
    }

    @Override
    <T> T visitProperty(Node node) {

        final ProtobufGroup.messageFieldST messageFieldST = group.newmessageField().
                setOrdinal(get(node, "ordinal")).
                setDefaultValue(node.hasProperty("defaultValue") ? get(node, "defaultValue") : null).
                setComments(node.hasProperty("comment") ? get(node, "comment") : null).
                setName(node.hasProperty("name") ? get(node, "name") : null);

        messageFieldST.setFieldConstraint(getOtherProperty(node, FIELDRULE, "name"));

        final Node fieldTypeNode = otherIncoming(node, FIELDTYPE);
        final java.util.List<String> qualifiedName = new ArrayList<>();
        qualifiedName.add(get(fieldTypeNode, "name", ""));

        final Node message = otherIncoming(node, FIELD);
        final Node messageParent = otherIncoming(message, MESSAGE);

        Node current = fieldTypeNode;
        while (hasIncoming(current, MESSAGE)) {
            final Relationship relationship = singleIncoming(current, MESSAGE);
            if (getOtherProperty(current, relationship, "name").equals(messageParent.getProperty("name"))) break;

            boolean isChildMessage = false;
            for (Relationship childrenMessages : outgoing(message, MESSAGE)) {
                if (getOtherProperty(message, childrenMessages, "name").equals(current.getProperty("name"))) {
                    isChildMessage = true;
                    break;
                }
            }

            if (isChildMessage) break;

            qualifiedName.add(other(current, relationship).getProperty("name").toString());
            current = other(current, relationship);
        }

        messageFieldST.setType(reverseString(new ArrayList<>(qualifiedName)));

        return (T) messageFieldST.toString();
    }

    @Override
    <T> T visitExtend(Node node) {

        final ProtobufGroup.extendST extendST = group.newextend().
                setName(node.hasProperty("name") ? get(node, "name") : null).
                setComments(node.hasProperty("comment") ? get(node, "comment") : null);

        for (Relationship relationship : outgoing(node, FIELD))
            extendST.addPropertiesValue(visitProperty(other(node, relationship)));

        return (T) extendST.toString();
    }

    @Override
    <T> T visitEnum(Node node) {

        final ProtobufGroup.enumST enumST = group.newenum().
                setName(node.hasProperty("name") ? get(node, "name") : null).
                setComments(node.hasProperty("comment") ? get(node, "comment") : null);

        for (Relationship relationship : outgoing(node, ENUMVALUE))
            enumST.addPropertiesValue(visitEnumValue(other(node, relationship)));

        return (T) enumST.toString();
    }

    @Override
    <T> T visitEnumValue(Node node) {
        return (T) get(node, "name");
    }

    @Override
    <T> T visitExtensions(Node node) {
        return (T) group.newextensions().
                setMin(get(node, "min")).
                setMax(get(node, "max")).toString();
    }

    @Override
    public <T> void done(T result) {
        showOutput(result);
    }
}