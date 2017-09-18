package com.generator.generators.properties.parser;

public class propertiesNodeVisitor extends propertiesBaseVisitor<propertiesNodeVisitor.Node> {

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

	public propertiesNodeVisitor() {
		this(false);
	}

	public propertiesNodeVisitor(boolean debug) {
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
	public Node visitValue(com.generator.generators.properties.parser.propertiesParser.ValueContext arg) {
		final Node node = new Node("Value", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRow(com.generator.generators.properties.parser.propertiesParser.RowContext arg) {
		final Node node = new Node("Row", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPropertiesFile(com.generator.generators.properties.parser.propertiesParser.PropertiesFileContext arg) {
		final Node node = new Node("PropertiesFile", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKey(com.generator.generators.properties.parser.propertiesParser.KeyContext arg) {
		final Node node = new Node("Key", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitComment(com.generator.generators.properties.parser.propertiesParser.CommentContext arg) {
		final Node node = new Node("Comment", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDecl(com.generator.generators.properties.parser.propertiesParser.DeclContext arg) {
		final Node node = new Node("Decl", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}