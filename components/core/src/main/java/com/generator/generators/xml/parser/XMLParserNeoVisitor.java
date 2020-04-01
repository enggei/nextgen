package com.generator.generators.xml.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class XMLParserNeoVisitor extends XMLParserBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(XMLParserNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public XMLParserNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		log.info("Element");
		final Node node = model.newNode(Label.label("Element"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		log.info("Attribute");
		final Node node = model.newNode(Label.label("Attribute"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		log.info("Document");
		final Node node = model.newNode(Label.label("Document"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		log.info("Prolog");
		final Node node = model.newNode(Label.label("Prolog"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		log.info("Content");
		final Node node = model.newNode(Label.label("Content"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		log.info("Reference");
		final Node node = model.newNode(Label.label("Reference"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		log.info("Chardata");
		final Node node = model.newNode(Label.label("Chardata"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		log.info("Misc");
		final Node node = model.newNode(Label.label("Misc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}