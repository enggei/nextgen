package com.generator.generators.json.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class JSONNeoVisitor extends JSONBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public JSONNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		System.out.println("Value");
		final Node node = model.findOrCreate(Label.label("Value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitJson(com.generator.generators.json.parser.JSONParser.JsonContext arg) {
		System.out.println("Json");
		final Node node = model.findOrCreate(Label.label("Json"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObj(com.generator.generators.json.parser.JSONParser.ObjContext arg) {
		System.out.println("Obj");
		final Node node = model.findOrCreate(Label.label("Obj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPair(com.generator.generators.json.parser.JSONParser.PairContext arg) {
		System.out.println("Pair");
		final Node node = model.findOrCreate(Label.label("Pair"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArray(com.generator.generators.json.parser.JSONParser.ArrayContext arg) {
		System.out.println("Array");
		final Node node = model.findOrCreate(Label.label("Array"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}