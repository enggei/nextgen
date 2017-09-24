package com.generator.generators.html5.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class HTMLParserNeoVisitor extends HTMLParserBaseVisitor<Node> {

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
	public Node visitHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		System.out.println("HtmlTagName");
		final Node node = model.findOrCreate(Label.label("HtmlTagName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		System.out.println("HtmlElement");
		final Node node = model.findOrCreate(Label.label("HtmlElement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		System.out.println("HtmlContent");
		final Node node = model.findOrCreate(Label.label("HtmlContent"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		System.out.println("HtmlMisc");
		final Node node = model.findOrCreate(Label.label("HtmlMisc"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		System.out.println("HtmlComment");
		final Node node = model.findOrCreate(Label.label("HtmlComment"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		System.out.println("HtmlDocument");
		final Node node = model.findOrCreate(Label.label("HtmlDocument"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		System.out.println("HtmlElements");
		final Node node = model.findOrCreate(Label.label("HtmlElements"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		System.out.println("HtmlAttribute");
		final Node node = model.findOrCreate(Label.label("HtmlAttribute"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		System.out.println("HtmlAttributeName");
		final Node node = model.findOrCreate(Label.label("HtmlAttributeName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		System.out.println("HtmlAttributeValue");
		final Node node = model.findOrCreate(Label.label("HtmlAttributeValue"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		System.out.println("HtmlChardata");
		final Node node = model.findOrCreate(Label.label("HtmlChardata"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		System.out.println("XhtmlCDATA");
		final Node node = model.findOrCreate(Label.label("XhtmlCDATA"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		System.out.println("Dtd");
		final Node node = model.findOrCreate(Label.label("Dtd"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		System.out.println("Xml");
		final Node node = model.findOrCreate(Label.label("Xml"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		System.out.println("Scriptlet");
		final Node node = model.findOrCreate(Label.label("Scriptlet"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		System.out.println("Script");
		final Node node = model.findOrCreate(Label.label("Script"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		System.out.println("Style");
		final Node node = model.findOrCreate(Label.label("Style"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}