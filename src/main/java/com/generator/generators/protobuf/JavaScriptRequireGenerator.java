package com.generator.generators.protobuf;

import com.generator.editors.domain.MetaNode;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.awt.*;
import java.io.File;

import static com.generator.generators.protobuf.ProtobufDomain.ENTITIES.*;
import static com.generator.generators.protobuf.ProtobufDomain.RELATIONS.MESSAGE;
import static com.generator.generators.protobuf.ProtobufDomain.RELATIONS.PACKAGE;

/**
 * goe on 4/24/15.
 * todo: consider refactoring this template-group into a separate javascript-protobuf.stg file (e.g. a
 * https://github.com/dcodeIO/ProtoBuf.js/ template-group.
 */
public class JavaScriptRequireGenerator extends ProtobufDomainVisitor {

	private final ProtobufGroup group = new ProtobufGroup();

	private ProtobufGroup.groupMessagesModelST groupMessagesModelST;

	public JavaScriptRequireGenerator(Component component) {
		super(component, "Javascript require generator");
	}

	@Override
	public <T> T visit(Node node, MetaNode<ProtobufDomain.ENTITIES> entity) {

		if (ProtobufDomain.ENTITIES.File.equals(entity.getLabel()))
			return visitFile(node);

		return null;
	}

	@Override
	<T> T visitFile(Node node) {

		if (has(node, "targetFile")) this.targetFile = new File(get(node, "targetFile").toString());

		if (!has(node, "name"))
			throw new IllegalStateException(File + " must have a name");

		groupMessagesModelST = group.newgroupMessagesModel().
			setGroupName(get(node, "name", "").replaceAll(".proto", ""));

		for (Relationship packages : node.getRelationships(PACKAGE, Direction.OUTGOING))
			visitPackage(other(node, packages));

		return (T) groupMessagesModelST.toString();
	}

	@Override
	<T> T visitPackage(Node node) {

		if (!has(node, "name"))
			throw new IllegalStateException(ProtobufDomain.ENTITIES.Package + " must have a name");

		groupMessagesModelST.setPackageName(get(node, "name"));

		for (Relationship relationship : outgoing(node, MESSAGE)) {
			if (isType(relationship, Message))
				groupMessagesModelST.addMessagesValue(getOtherProperty(node, relationship, "name"));
			else if (isType(relationship, Extend))
				groupMessagesModelST.addMessagesValue(getOtherProperty(node, relationship, "name"));
			else if (isType(relationship, Enum))
				groupMessagesModelST.addMessagesValue(getOtherProperty(node, relationship, "name"));
		}

		return null;
	}

	@Override
	public <T> void done(T result) {
		showOutput(result);
	}
}