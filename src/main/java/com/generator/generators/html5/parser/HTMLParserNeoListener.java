package com.generator.generators.html5.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class HTMLParserNeoListener extends HTMLParserBaseListener {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HTMLParserNeoListener.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public HTMLParserNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public HTMLParserNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   protected void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) log.debug(delim.toString() + node.getProperty("text"));
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

	protected java.util.Stack<Boolean> inHtmlDocument = new java.util.Stack<>();

	@Override
	public void enterHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		final Node node = model.newNode(Label.label("HtmlDocument"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlDocument.push(true);
	}

	public void exitHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		onExit();
		this.inHtmlDocument.pop();
	}

	public boolean inHtmlDocument() {
      return !inHtmlDocument.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlElements = new java.util.Stack<>();

	@Override
	public void enterHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		final Node node = model.newNode(Label.label("HtmlElements"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlElements.push(true);
	}

	public void exitHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		onExit();
		this.inHtmlElements.pop();
	}

	public boolean inHtmlElements() {
      return !inHtmlElements.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlElement = new java.util.Stack<>();

	@Override
	public void enterHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		final Node node = model.newNode(Label.label("HtmlElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlElement.push(true);
	}

	public void exitHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		onExit();
		this.inHtmlElement.pop();
	}

	public boolean inHtmlElement() {
      return !inHtmlElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlContent = new java.util.Stack<>();

	@Override
	public void enterHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		final Node node = model.newNode(Label.label("HtmlContent"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlContent.push(true);
	}

	public void exitHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		onExit();
		this.inHtmlContent.pop();
	}

	public boolean inHtmlContent() {
      return !inHtmlContent.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlAttribute = new java.util.Stack<>();

	@Override
	public void enterHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		final Node node = model.newNode(Label.label("HtmlAttribute"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlAttribute.push(true);
	}

	public void exitHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		onExit();
		this.inHtmlAttribute.pop();
	}

	public boolean inHtmlAttribute() {
      return !inHtmlAttribute.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlAttributeName = new java.util.Stack<>();

	@Override
	public void enterHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		final Node node = model.newNode(Label.label("HtmlAttributeName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlAttributeName.push(true);
	}

	public void exitHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		onExit();
		this.inHtmlAttributeName.pop();
	}

	public boolean inHtmlAttributeName() {
      return !inHtmlAttributeName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlAttributeValue = new java.util.Stack<>();

	@Override
	public void enterHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		final Node node = model.newNode(Label.label("HtmlAttributeValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlAttributeValue.push(true);
	}

	public void exitHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		onExit();
		this.inHtmlAttributeValue.pop();
	}

	public boolean inHtmlAttributeValue() {
      return !inHtmlAttributeValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlTagName = new java.util.Stack<>();

	@Override
	public void enterHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		final Node node = model.newNode(Label.label("HtmlTagName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlTagName.push(true);
	}

	public void exitHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		onExit();
		this.inHtmlTagName.pop();
	}

	public boolean inHtmlTagName() {
      return !inHtmlTagName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlChardata = new java.util.Stack<>();

	@Override
	public void enterHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		final Node node = model.newNode(Label.label("HtmlChardata"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlChardata.push(true);
	}

	public void exitHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		onExit();
		this.inHtmlChardata.pop();
	}

	public boolean inHtmlChardata() {
      return !inHtmlChardata.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlMisc = new java.util.Stack<>();

	@Override
	public void enterHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		final Node node = model.newNode(Label.label("HtmlMisc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlMisc.push(true);
	}

	public void exitHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		onExit();
		this.inHtmlMisc.pop();
	}

	public boolean inHtmlMisc() {
      return !inHtmlMisc.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHtmlComment = new java.util.Stack<>();

	@Override
	public void enterHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		final Node node = model.newNode(Label.label("HtmlComment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inHtmlComment.push(true);
	}

	public void exitHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		onExit();
		this.inHtmlComment.pop();
	}

	public boolean inHtmlComment() {
      return !inHtmlComment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXhtmlCDATA = new java.util.Stack<>();

	@Override
	public void enterXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		final Node node = model.newNode(Label.label("XhtmlCDATA"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXhtmlCDATA.push(true);
	}

	public void exitXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		onExit();
		this.inXhtmlCDATA.pop();
	}

	public boolean inXhtmlCDATA() {
      return !inXhtmlCDATA.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDtd = new java.util.Stack<>();

	@Override
	public void enterDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		final Node node = model.newNode(Label.label("Dtd"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inDtd.push(true);
	}

	public void exitDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		onExit();
		this.inDtd.pop();
	}

	public boolean inDtd() {
      return !inDtd.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inXml = new java.util.Stack<>();

	@Override
	public void enterXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		final Node node = model.newNode(Label.label("Xml"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inXml.push(true);
	}

	public void exitXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		onExit();
		this.inXml.pop();
	}

	public boolean inXml() {
      return !inXml.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inScriptlet = new java.util.Stack<>();

	@Override
	public void enterScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		final Node node = model.newNode(Label.label("Scriptlet"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inScriptlet.push(true);
	}

	public void exitScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		onExit();
		this.inScriptlet.pop();
	}

	public boolean inScriptlet() {
      return !inScriptlet.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inScript = new java.util.Stack<>();

	@Override
	public void enterScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		final Node node = model.newNode(Label.label("Script"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inScript.push(true);
	}

	public void exitScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		onExit();
		this.inScript.pop();
	}

	public boolean inScript() {
      return !inScript.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStyle = new java.util.Stack<>();

	@Override
	public void enterStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		final Node node = model.newNode(Label.label("Style"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
		this.inStyle.push(true);
	}

	public void exitStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		onExit();
		this.inStyle.pop();
	}

	public boolean inStyle() {
      return !inStyle.isEmpty(); 
   }

}