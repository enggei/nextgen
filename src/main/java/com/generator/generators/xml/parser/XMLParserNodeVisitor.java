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
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public XMLParserNodeVisitor() {
		this(false);
	}

	public XMLParserNodeVisitor(boolean debug) {
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

	@Override
	public Node visitContent(com.generator.generators.xml.parser.XMLParser.ContentContext arg) {
		final Node node = new Node("Content", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitReference(com.generator.generators.xml.parser.XMLParser.ReferenceContext arg) {
		final Node node = new Node("Reference", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChardata(com.generator.generators.xml.parser.XMLParser.ChardataContext arg) {
		final Node node = new Node("Chardata", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMisc(com.generator.generators.xml.parser.XMLParser.MiscContext arg) {
		final Node node = new Node("Misc", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElement(com.generator.generators.xml.parser.XMLParser.ElementContext arg) {
		final Node node = new Node("Element", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttribute(com.generator.generators.xml.parser.XMLParser.AttributeContext arg) {
		final Node node = new Node("Attribute", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDocument(com.generator.generators.xml.parser.XMLParser.DocumentContext arg) {
		final Node node = new Node("Document", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitProlog(com.generator.generators.xml.parser.XMLParser.PrologContext arg) {
		final Node node = new Node("Prolog", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}