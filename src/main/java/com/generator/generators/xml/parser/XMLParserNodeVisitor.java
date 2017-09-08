package com.generator.generators.xml.parser;

public class XMLParserNodeVisitor extends XMLParserBaseVisitor<XMLParserNodeVisitor.Node> {

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
	public Node visitElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		System.out.println("Element");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		System.out.println("Attribute");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		System.out.println("Document");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		System.out.println("Prolog");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		System.out.println("Content");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		System.out.println("Reference");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		System.out.println("Chardata");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		System.out.println("Misc");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}