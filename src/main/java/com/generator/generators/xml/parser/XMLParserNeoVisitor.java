package com.generator.generators.xml.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class XMLParserNeoVisitor extends XMLParserBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.NeoModel model;

	public XMLParserNeoVisitor(com.generator.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		System.out.println("Element");
		final Node node = model.findOrCreate(Label.label("Element"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		System.out.println("Attribute");
		final Node node = model.findOrCreate(Label.label("Attribute"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		System.out.println("Reference");
		final Node node = model.findOrCreate(Label.label("Reference"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		System.out.println("Chardata");
		final Node node = model.findOrCreate(Label.label("Chardata"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		System.out.println("Misc");
		final Node node = model.findOrCreate(Label.label("Misc"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		System.out.println("Document");
		final Node node = model.findOrCreate(Label.label("Document"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		System.out.println("Prolog");
		final Node node = model.findOrCreate(Label.label("Prolog"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		System.out.println("Content");
		final Node node = model.findOrCreate(Label.label("Content"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}