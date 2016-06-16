package com.generator.generators.protobuf;

import com.generator.editors.domain.NeoModel;
import com.generator.editors.domain.*;

import org.neo4j.graphdb.*;

import static com.generator.editors.domain.MetaRelation.Cardinality.*;
import static com.generator.editors.domain.MetaRelation.Direction.*;

import java.util.*;

import static com.generator.generators.protobuf.ProtobufDomainTest.ENTITIES.*;
import static com.generator.generators.protobuf.ProtobufDomainTest.RELATIONS.*;

/**
 * 
 */
public class ProtobufDomainTest extends MetaDomain<ProtobufDomainTest.ENTITIES, ProtobufDomainTest.RELATIONS> {

    public enum ENTITIES {
        Enum, Extend, Extensions, GroupMessagesModel, Message, MessageField, ProtobufPackage
    }

    public enum RELATIONS implements RelationshipType {
    }

    public ProtobufDomainTest(final NeoModel model) {
        super(model, "ProtobufDomainTest");

        try (Transaction tx = model.beginTx()) {

            addMetaNode(ENTITIES.Enum, UUID.randomUUID())
                    .addProperty(new MetaProperty("comments").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.Extend, UUID.randomUUID())
                    .addProperty(new MetaProperty("comments").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.Extensions, UUID.randomUUID())
                    .addProperty(new MetaProperty("max").setType("String"))
                    .addProperty(new MetaProperty("min").setType("String"));
            addMetaNode(ENTITIES.GroupMessagesModel, UUID.randomUUID())
                    .addProperty(new MetaProperty("groupName").setType("String"))
                    .addProperty(new MetaProperty("packageName").setType("String"));
            addMetaNode(ENTITIES.Message, UUID.randomUUID())
                    .addProperty(new MetaProperty("comments").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.MessageField, UUID.randomUUID())
                    .addProperty(new MetaProperty("comments").setType("String"))
                    .addProperty(new MetaProperty("defaultValue").setType("String"))
                    .addProperty(new MetaProperty("fieldConstraint").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"))
                    .addProperty(new MetaProperty("ordinal").setType("String"))
                    .addProperty(new MetaProperty("type").setType("String"));
            addMetaNode(ENTITIES.ProtobufPackage, UUID.randomUUID())
                    .addProperty(new MetaProperty("package").setType("String"));


            validate();

            tx.success();
        }
    }

    @Override
    protected final ENTITIES entity(String s) {
        return ENTITIES.valueOf(s);
    }

    @Override
    protected final RELATIONS relation(String s) {
        return RELATIONS.valueOf(s);
    }

    @Override
    public final MetaNode<ENTITIES> getRootNode() {
        return getNode(ProtobufPackage);
    }

    @Override
    public final boolean isConstrained(Node node) {
        return super.isConstrained(node);
    }

    public Node addEnum(UUID uuid, String _comments, String _name, String _properties) {
        return newNode(ENTITIES.Enum, uuid, "comments", (_comments == null || _comments.trim().length()==0) ? "[]" : _comments, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name, "properties", (_properties == null || _properties.trim().length()==0) ? "[]" : _properties);
    }

    public Node addExtend(UUID uuid, String _comments, String _name, String _properties) {
        return newNode(ENTITIES.Extend, uuid, "comments", (_comments == null || _comments.trim().length()==0) ? "[]" : _comments, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name, "properties", (_properties == null || _properties.trim().length()==0) ? "[]" : _properties);
    }

    public Node addExtensions(UUID uuid, String _max, String _min) {
        return newNode(ENTITIES.Extensions, uuid, "max", (_max == null || _max.trim().length()==0) ? "[]" : _max, "min", (_min == null || _min.trim().length()==0) ? "[]" : _min);
    }

    public Node addGroupMessagesModel(UUID uuid, String _groupName, String _messages, String _packageName) {
        return newNode(ENTITIES.GroupMessagesModel, uuid, "groupName", (_groupName == null || _groupName.trim().length()==0) ? "[]" : _groupName, "messages", (_messages == null || _messages.trim().length()==0) ? "[]" : _messages, "packageName", (_packageName == null || _packageName.trim().length()==0) ? "[]" : _packageName);
    }

    public Node addMessage(UUID uuid, String _comments, String _name, String _properties) {
        return newNode(ENTITIES.Message, uuid, "comments", (_comments == null || _comments.trim().length()==0) ? "[]" : _comments, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name, "properties", (_properties == null || _properties.trim().length()==0) ? "[]" : _properties);
    }

    public Node addMessageField(UUID uuid, String _comments, String _defaultValue, String _fieldConstraint, String _name, String _ordinal, String _type) {
        return newNode(ENTITIES.MessageField, uuid, "comments", (_comments == null || _comments.trim().length()==0) ? "[]" : _comments, "defaultValue", (_defaultValue == null || _defaultValue.trim().length()==0) ? "[]" : _defaultValue, "fieldConstraint", (_fieldConstraint == null || _fieldConstraint.trim().length()==0) ? "[]" : _fieldConstraint, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name, "ordinal", (_ordinal == null || _ordinal.trim().length()==0) ? "[]" : _ordinal, "type", (_type == null || _type.trim().length()==0) ? "[]" : _type);
    }

    public Node addProtobufPackage(UUID uuid, String _deliverables, String _imports, String _options, String _package) {
        return newNode(ENTITIES.ProtobufPackage, uuid, "deliverables", (_deliverables == null || _deliverables.trim().length()==0) ? "[]" : _deliverables, "imports", (_imports == null || _imports.trim().length()==0) ? "[]" : _imports, "options", (_options == null || _options.trim().length()==0) ? "[]" : _options, "package", (_package == null || _package.trim().length()==0) ? "[]" : _package);
    }
}