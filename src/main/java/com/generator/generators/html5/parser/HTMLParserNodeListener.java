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
	public void enterHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		 //System.out.println("HtmlDocument");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlDocument", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlDocument(com.generator.generators.html5.parser.HTMLParser.HtmlDocumentContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		 //System.out.println("HtmlElements");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlElements", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlElements(com.generator.generators.html5.parser.HTMLParser.HtmlElementsContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		 //System.out.println("HtmlElement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlElement(com.generator.generators.html5.parser.HTMLParser.HtmlElementContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		 //System.out.println("HtmlContent");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlContent", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlContent(com.generator.generators.html5.parser.HTMLParser.HtmlContentContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		 //System.out.println("HtmlAttribute");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlAttribute", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlAttribute(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		 //System.out.println("HtmlAttributeName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlAttributeName", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlAttributeName(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeNameContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		 //System.out.println("HtmlAttributeValue");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlAttributeValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlAttributeValue(com.generator.generators.html5.parser.HTMLParser.HtmlAttributeValueContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		 //System.out.println("HtmlComment");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlComment", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlComment(com.generator.generators.html5.parser.HTMLParser.HtmlCommentContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		 //System.out.println("HtmlMisc");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlMisc", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlMisc(com.generator.generators.html5.parser.HTMLParser.HtmlMiscContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		 //System.out.println("HtmlTagName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlTagName", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlTagName(com.generator.generators.html5.parser.HTMLParser.HtmlTagNameContext arg) {
		 onExit();
	}

	@Override
	public void enterHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		 //System.out.println("HtmlChardata");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("HtmlChardata", arg.getText(), arg.getStart().getText()));
	}

	public void exitHtmlChardata(com.generator.generators.html5.parser.HTMLParser.HtmlChardataContext arg) {
		 onExit();
	}

	@Override
	public void enterXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		 //System.out.println("XhtmlCDATA");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("XhtmlCDATA", arg.getText(), arg.getStart().getText()));
	}

	public void exitXhtmlCDATA(com.generator.generators.html5.parser.HTMLParser.XhtmlCDATAContext arg) {
		 onExit();
	}

	@Override
	public void enterDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		 //System.out.println("Dtd");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Dtd", arg.getText(), arg.getStart().getText()));
	}

	public void exitDtd(com.generator.generators.html5.parser.HTMLParser.DtdContext arg) {
		 onExit();
	}

	@Override
	public void enterXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		 //System.out.println("Xml");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Xml", arg.getText(), arg.getStart().getText()));
	}

	public void exitXml(com.generator.generators.html5.parser.HTMLParser.XmlContext arg) {
		 onExit();
	}

	@Override
	public void enterScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		 //System.out.println("Scriptlet");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Scriptlet", arg.getText(), arg.getStart().getText()));
	}

	public void exitScriptlet(com.generator.generators.html5.parser.HTMLParser.ScriptletContext arg) {
		 onExit();
	}

	@Override
	public void enterScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		 //System.out.println("Script");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Script", arg.getText(), arg.getStart().getText()));
	}

	public void exitScript(com.generator.generators.html5.parser.HTMLParser.ScriptContext arg) {
		 onExit();
	}

	@Override
	public void enterStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		 //System.out.println("Style");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Style", arg.getText(), arg.getStart().getText()));
	}

	public void exitStyle(com.generator.generators.html5.parser.HTMLParser.StyleContext arg) {
		 onExit();
	}

}