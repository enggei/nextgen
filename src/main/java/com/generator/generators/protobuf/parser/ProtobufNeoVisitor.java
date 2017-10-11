package com.generator.generators.protobuf.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ProtobufNeoVisitor extends ProtobufBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public ProtobufNeoVisitor(com.generator.neo.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitPropertyType(com.generator.generators.protobuf.parser.ProtobufParser.PropertyTypeContext arg) {
		System.out.println("PropertyType");
		final Node node = model.newNode(Label.label("PropertyType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtensionMax(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionMaxContext arg) {
		System.out.println("ExtensionMax");
		final Node node = model.newNode(Label.label("ExtensionMax"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMessageContent(com.generator.generators.protobuf.parser.ProtobufParser.MessageContentContext arg) {
		System.out.println("MessageContent");
		final Node node = model.newNode(Label.label("MessageContent"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOption(com.generator.generators.protobuf.parser.ProtobufParser.OptionContext arg) {
		System.out.println("Option");
		final Node node = model.newNode(Label.label("Option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageDecl(com.generator.generators.protobuf.parser.ProtobufParser.PackageDeclContext arg) {
		System.out.println("PackageDecl");
		final Node node = model.newNode(Label.label("PackageDecl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFile(com.generator.generators.protobuf.parser.ProtobufParser.FileContext arg) {
		System.out.println("File");
		final Node node = model.newNode(Label.label("File"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageName(com.generator.generators.protobuf.parser.ProtobufParser.PackageNameContext arg) {
		System.out.println("PackageName");
		final Node node = model.newNode(Label.label("PackageName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertyName(com.generator.generators.protobuf.parser.ProtobufParser.PropertyNameContext arg) {
		System.out.println("PropertyName");
		final Node node = model.newNode(Label.label("PropertyName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValue(com.generator.generators.protobuf.parser.ProtobufParser.DefaultValueContext arg) {
		System.out.println("DefaultValue");
		final Node node = model.newNode(Label.label("DefaultValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProperty(com.generator.generators.protobuf.parser.ProtobufParser.PropertyContext arg) {
		System.out.println("Property");
		final Node node = model.newNode(Label.label("Property"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackedValue(com.generator.generators.protobuf.parser.ProtobufParser.PackedValueContext arg) {
		System.out.println("PackedValue");
		final Node node = model.newNode(Label.label("PackedValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExtensions(com.generator.generators.protobuf.parser.ProtobufParser.ExtensionsContext arg) {
		System.out.println("Extensions");
		final Node node = model.newNode(Label.label("Extensions"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImports(com.generator.generators.protobuf.parser.ProtobufParser.ImportsContext arg) {
		System.out.println("Imports");
		final Node node = model.newNode(Label.label("Imports"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMessage(com.generator.generators.protobuf.parser.ProtobufParser.MessageContext arg) {
		System.out.println("Message");
		final Node node = model.newNode(Label.label("Message"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumName(com.generator.generators.protobuf.parser.ProtobufParser.EnumNameContext arg) {
		System.out.println("EnumName");
		final Node node = model.newNode(Label.label("EnumName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}