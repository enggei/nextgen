package com.generator.generators.html5.parser;

public class HTMLParserNodeVisitor extends HTMLParserBaseVisitor<HTMLParserNodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		System.out.println("HtmlMisc");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		System.out.println("Scriptlet");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		System.out.println("Style");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		System.out.println("Script");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		System.out.println("HtmlAttribute");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		System.out.println("HtmlAttributeName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		System.out.println("HtmlAttributeValue");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		System.out.println("HtmlChardata");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		System.out.println("Xml");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		System.out.println("HtmlDocument");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		System.out.println("HtmlComment");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		System.out.println("HtmlElements");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		System.out.println("HtmlElement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		System.out.println("Dtd");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		System.out.println("HtmlContent");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		System.out.println("HtmlTagName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		System.out.println("XhtmlCDATA");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}