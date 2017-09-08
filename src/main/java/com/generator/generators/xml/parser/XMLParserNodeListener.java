package com.generator.generators.xml.parser;

public class XMLParserNodeListener extends XMLParserBaseListener {

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
	public void enterElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		 //System.out.println("Element");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Element", arg.getText(), arg.getStart().getText()));
	}

	public void exitElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		 onExit();
	}

	@Override
	public void enterAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		 //System.out.println("Attribute");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Attribute", arg.getText(), arg.getStart().getText()));
	}

	public void exitAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		 onExit();
	}

	@Override
	public void enterDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		 //System.out.println("Document");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Document", arg.getText(), arg.getStart().getText()));
	}

	public void exitDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		 onExit();
	}

	@Override
	public void enterProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		 //System.out.println("Prolog");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Prolog", arg.getText(), arg.getStart().getText()));
	}

	public void exitProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		 onExit();
	}

	@Override
	public void enterContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		 //System.out.println("Content");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Content", arg.getText(), arg.getStart().getText()));
	}

	public void exitContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		 onExit();
	}

	@Override
	public void enterReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		 //System.out.println("Reference");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Reference", arg.getText(), arg.getStart().getText()));
	}

	public void exitReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		 onExit();
	}

	@Override
	public void enterChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		 //System.out.println("Chardata");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Chardata", arg.getText(), arg.getStart().getText()));
	}

	public void exitChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		 onExit();
	}

	@Override
	public void enterMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		 //System.out.println("Misc");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Misc", arg.getText(), arg.getStart().getText()));
	}

	public void exitMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		 onExit();
	}

}