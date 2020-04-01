package com.generator.generators.properties.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class propertiesNeoVisitor extends propertiesBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(propertiesNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public propertiesNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitDecl(com.generator.generators.properties.parser.propertiesParser.DeclContext arg) {
		log.info("Decl");
		final Node node = model.newNode(Label.label("Decl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComment(com.generator.generators.properties.parser.propertiesParser.CommentContext arg) {
		log.info("Comment");
		final Node node = model.newNode(Label.label("Comment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertiesFile(com.generator.generators.properties.parser.propertiesParser.PropertiesFileContext arg) {
		log.info("PropertiesFile");
		final Node node = model.newNode(Label.label("PropertiesFile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValue(com.generator.generators.properties.parser.propertiesParser.ValueContext arg) {
		log.info("Value");
		final Node node = model.newNode(Label.label("Value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRow(com.generator.generators.properties.parser.propertiesParser.RowContext arg) {
		log.info("Row");
		final Node node = model.newNode(Label.label("Row"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKey(com.generator.generators.properties.parser.propertiesParser.KeyContext arg) {
		log.info("Key");
		final Node node = model.newNode(Label.label("Key"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}