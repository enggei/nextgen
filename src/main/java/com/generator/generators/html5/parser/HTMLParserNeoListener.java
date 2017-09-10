package com.generator.generators.html5.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class HTMLParserNeoListener extends HTMLParserBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public HTMLParserNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public HTMLParserNeoListener(com.generator.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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
		final Node node = model.findOrCreate(Label.label("HtmlDocument"), "text", arg.getText());
		onEnter(node);
		this.inHtmlDocument = true;
	}

	public void exitHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		onExit();
		this.inHtmlDocument = false;
	}

	protected boolean inHtmlElements = false;

	@Override
	public void enterHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlElements"), "text", arg.getText());
		onEnter(node);
		this.inHtmlElements = true;
	}

	public void exitHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		onExit();
		this.inHtmlElements = false;
	}

	protected boolean inHtmlElement = false;

	@Override
	public void enterHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlElement"), "text", arg.getText());
		onEnter(node);
		this.inHtmlElement = true;
	}

	public void exitHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		onExit();
		this.inHtmlElement = false;
	}

	protected boolean inHtmlContent = false;

	@Override
	public void enterHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlContent"), "text", arg.getText());
		onEnter(node);
		this.inHtmlContent = true;
	}

	public void exitHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		onExit();
		this.inHtmlContent = false;
	}

	protected boolean inHtmlAttribute = false;

	@Override
	public void enterHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlAttribute"), "text", arg.getText());
		onEnter(node);
		this.inHtmlAttribute = true;
	}

	public void exitHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		onExit();
		this.inHtmlAttribute = false;
	}

	protected boolean inHtmlAttributeName = false;

	@Override
	public void enterHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlAttributeName"), "text", arg.getText());
		onEnter(node);
		this.inHtmlAttributeName = true;
	}

	public void exitHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		onExit();
		this.inHtmlAttributeName = false;
	}

	protected boolean inHtmlAttributeValue = false;

	@Override
	public void enterHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlAttributeValue"), "text", arg.getText());
		onEnter(node);
		this.inHtmlAttributeValue = true;
	}

	public void exitHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		onExit();
		this.inHtmlAttributeValue = false;
	}

	protected boolean inHtmlTagName = false;

	@Override
	public void enterHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlTagName"), "text", arg.getText());
		onEnter(node);
		this.inHtmlTagName = true;
	}

	public void exitHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		onExit();
		this.inHtmlTagName = false;
	}

	protected boolean inHtmlChardata = false;

	@Override
	public void enterHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlChardata"), "text", arg.getText());
		onEnter(node);
		this.inHtmlChardata = true;
	}

	public void exitHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		onExit();
		this.inHtmlChardata = false;
	}

	protected boolean inHtmlMisc = false;

	@Override
	public void enterHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlMisc"), "text", arg.getText());
		onEnter(node);
		this.inHtmlMisc = true;
	}

	public void exitHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		onExit();
		this.inHtmlMisc = false;
	}

	protected boolean inHtmlComment = false;

	@Override
	public void enterHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		final Node node = model.findOrCreate(Label.label("HtmlComment"), "text", arg.getText());
		onEnter(node);
		this.inHtmlComment = true;
	}

	public void exitHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		onExit();
		this.inHtmlComment = false;
	}

	protected boolean inXhtmlCDATA = false;

	@Override
	public void enterXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		final Node node = model.findOrCreate(Label.label("XhtmlCDATA"), "text", arg.getText());
		onEnter(node);
		this.inXhtmlCDATA = true;
	}

	public void exitXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		onExit();
		this.inXhtmlCDATA = false;
	}

	protected boolean inDtd = false;

	@Override
	public void enterDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		final Node node = model.findOrCreate(Label.label("Dtd"), "text", arg.getText());
		onEnter(node);
		this.inDtd = true;
	}

	public void exitDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		onExit();
		this.inDtd = false;
	}

	protected boolean inXml = false;

	@Override
	public void enterXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		final Node node = model.findOrCreate(Label.label("Xml"), "text", arg.getText());
		onEnter(node);
		this.inXml = true;
	}

	public void exitXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		onExit();
		this.inXml = false;
	}

	protected boolean inScriptlet = false;

	@Override
	public void enterScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		final Node node = model.findOrCreate(Label.label("Scriptlet"), "text", arg.getText());
		onEnter(node);
		this.inScriptlet = true;
	}

	public void exitScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		onExit();
		this.inScriptlet = false;
	}

	protected boolean inScript = false;

	@Override
	public void enterScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		final Node node = model.findOrCreate(Label.label("Script"), "text", arg.getText());
		onEnter(node);
		this.inScript = true;
	}

	public void exitScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		onExit();
		this.inScript = false;
	}

	protected boolean inStyle = false;

	@Override
	public void enterStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		final Node node = model.findOrCreate(Label.label("Style"), "text", arg.getText());
		onEnter(node);
		this.inStyle = true;
	}

	public void exitStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		onExit();
		this.inStyle = false;
	}

}