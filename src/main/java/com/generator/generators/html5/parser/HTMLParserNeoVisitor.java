package com.generator.generators.html5.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class HTMLParserNeoVisitor extends HTMLParserBaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HTMLParserNeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public HTMLParserNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		log.info("HtmlElement");
		final Node node = model.newNode(Label.label("HtmlElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		log.info("HtmlDocument");
		final Node node = model.newNode(Label.label("HtmlDocument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		log.info("HtmlElements");
		final Node node = model.newNode(Label.label("HtmlElements"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		log.info("HtmlContent");
		final Node node = model.newNode(Label.label("HtmlContent"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		log.info("HtmlAttribute");
		final Node node = model.newNode(Label.label("HtmlAttribute"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		log.info("HtmlAttributeName");
		final Node node = model.newNode(Label.label("HtmlAttributeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		log.info("HtmlAttributeValue");
		final Node node = model.newNode(Label.label("HtmlAttributeValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		log.info("HtmlTagName");
		final Node node = model.newNode(Label.label("HtmlTagName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		log.info("HtmlChardata");
		final Node node = model.newNode(Label.label("HtmlChardata"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		log.info("HtmlMisc");
		final Node node = model.newNode(Label.label("HtmlMisc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		log.info("HtmlComment");
		final Node node = model.newNode(Label.label("HtmlComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		log.info("XhtmlCDATA");
		final Node node = model.newNode(Label.label("XhtmlCDATA"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		log.info("Dtd");
		final Node node = model.newNode(Label.label("Dtd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		log.info("Xml");
		final Node node = model.newNode(Label.label("Xml"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		log.info("Scriptlet");
		final Node node = model.newNode(Label.label("Scriptlet"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		log.info("Script");
		final Node node = model.newNode(Label.label("Script"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		log.info("Style");
		final Node node = model.newNode(Label.label("Style"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}