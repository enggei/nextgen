package com.generator.generators.html5.parser;

public class HTMLParserNodeListener extends HTMLParserBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public HTMLParserNodeListener() {
		this(false);
	}

	public HTMLParserNodeListener(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name);
		delim.append("\t");
   }

   private void onExit() {
      if (nodeStack.size() > 1) {
			nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
		}
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	protected boolean inHtmlDocument = false;

	@Override
	public void enterHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		onEnter(new Node("HtmlDocument", arg.getText(), arg.getStart().getText()));
		this.inHtmlDocument = true;
	}

	public void exitHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		onExit();
		this.inHtmlDocument = false;
	}

	protected boolean inHtmlElements = false;

	@Override
	public void enterHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		onEnter(new Node("HtmlElements", arg.getText(), arg.getStart().getText()));
		this.inHtmlElements = true;
	}

	public void exitHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		onExit();
		this.inHtmlElements = false;
	}

	protected boolean inHtmlElement = false;

	@Override
	public void enterHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		onEnter(new Node("HtmlElement", arg.getText(), arg.getStart().getText()));
		this.inHtmlElement = true;
	}

	public void exitHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		onExit();
		this.inHtmlElement = false;
	}

	protected boolean inHtmlContent = false;

	@Override
	public void enterHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		onEnter(new Node("HtmlContent", arg.getText(), arg.getStart().getText()));
		this.inHtmlContent = true;
	}

	public void exitHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		onExit();
		this.inHtmlContent = false;
	}

	protected boolean inHtmlAttribute = false;

	@Override
	public void enterHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		onEnter(new Node("HtmlAttribute", arg.getText(), arg.getStart().getText()));
		this.inHtmlAttribute = true;
	}

	public void exitHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		onExit();
		this.inHtmlAttribute = false;
	}

	protected boolean inHtmlAttributeName = false;

	@Override
	public void enterHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		onEnter(new Node("HtmlAttributeName", arg.getText(), arg.getStart().getText()));
		this.inHtmlAttributeName = true;
	}

	public void exitHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		onExit();
		this.inHtmlAttributeName = false;
	}

	protected boolean inHtmlAttributeValue = false;

	@Override
	public void enterHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		onEnter(new Node("HtmlAttributeValue", arg.getText(), arg.getStart().getText()));
		this.inHtmlAttributeValue = true;
	}

	public void exitHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		onExit();
		this.inHtmlAttributeValue = false;
	}

	protected boolean inHtmlTagName = false;

	@Override
	public void enterHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		onEnter(new Node("HtmlTagName", arg.getText(), arg.getStart().getText()));
		this.inHtmlTagName = true;
	}

	public void exitHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		onExit();
		this.inHtmlTagName = false;
	}

	protected boolean inHtmlChardata = false;

	@Override
	public void enterHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		onEnter(new Node("HtmlChardata", arg.getText(), arg.getStart().getText()));
		this.inHtmlChardata = true;
	}

	public void exitHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		onExit();
		this.inHtmlChardata = false;
	}

	protected boolean inHtmlMisc = false;

	@Override
	public void enterHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		onEnter(new Node("HtmlMisc", arg.getText(), arg.getStart().getText()));
		this.inHtmlMisc = true;
	}

	public void exitHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		onExit();
		this.inHtmlMisc = false;
	}

	protected boolean inHtmlComment = false;

	@Override
	public void enterHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		onEnter(new Node("HtmlComment", arg.getText(), arg.getStart().getText()));
		this.inHtmlComment = true;
	}

	public void exitHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		onExit();
		this.inHtmlComment = false;
	}

	protected boolean inXhtmlCDATA = false;

	@Override
	public void enterXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		onEnter(new Node("XhtmlCDATA", arg.getText(), arg.getStart().getText()));
		this.inXhtmlCDATA = true;
	}

	public void exitXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		onExit();
		this.inXhtmlCDATA = false;
	}

	protected boolean inDtd = false;

	@Override
	public void enterDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		onEnter(new Node("Dtd", arg.getText(), arg.getStart().getText()));
		this.inDtd = true;
	}

	public void exitDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		onExit();
		this.inDtd = false;
	}

	protected boolean inXml = false;

	@Override
	public void enterXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		onEnter(new Node("Xml", arg.getText(), arg.getStart().getText()));
		this.inXml = true;
	}

	public void exitXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		onExit();
		this.inXml = false;
	}

	protected boolean inScriptlet = false;

	@Override
	public void enterScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		onEnter(new Node("Scriptlet", arg.getText(), arg.getStart().getText()));
		this.inScriptlet = true;
	}

	public void exitScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		onExit();
		this.inScriptlet = false;
	}

	protected boolean inScript = false;

	@Override
	public void enterScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		onEnter(new Node("Script", arg.getText(), arg.getStart().getText()));
		this.inScript = true;
	}

	public void exitScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		onExit();
		this.inScript = false;
	}

	protected boolean inStyle = false;

	@Override
	public void enterStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		onEnter(new Node("Style", arg.getText(), arg.getStart().getText()));
		this.inStyle = true;
	}

	public void exitStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		onExit();
		this.inStyle = false;
	}

}