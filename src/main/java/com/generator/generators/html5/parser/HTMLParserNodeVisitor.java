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

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public HTMLParserNodeVisitor() {
		this(false);
	}

	public HTMLParserNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " '" + node.value + "'");
		delim.append("\t");
   }

   protected void onExit() {
      if (nodeStack.size() > 1) {
         nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
      }
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		final Node node = new Node("HtmlDocument", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		final Node node = new Node("HtmlElements", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		final Node node = new Node("HtmlElement", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		final Node node = new Node("HtmlContent", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		final Node node = new Node("HtmlAttribute", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		final Node node = new Node("HtmlAttributeName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		final Node node = new Node("HtmlAttributeValue", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		final Node node = new Node("HtmlTagName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		final Node node = new Node("HtmlChardata", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		final Node node = new Node("HtmlMisc", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		final Node node = new Node("HtmlComment", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		final Node node = new Node("XhtmlCDATA", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		final Node node = new Node("Dtd", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		final Node node = new Node("Xml", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		final Node node = new Node("Scriptlet", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		final Node node = new Node("Script", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		final Node node = new Node("Style", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}