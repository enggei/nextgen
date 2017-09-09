package com.generator.generators.json.parser;

public class JSONNodeVisitor extends JSONBaseVisitor<JSONNodeVisitor.Node> {

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

	public JSONNodeVisitor() {
		this(false);
	}

	public JSONNodeVisitor(boolean debug) {
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
	public Node visitJson(com.generator.generators.json.parser.JSONParser.JsonContext arg) {
		final Node node = new Node("Json", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObj(com.generator.generators.json.parser.JSONParser.ObjContext arg) {
		final Node node = new Node("Obj", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPair(com.generator.generators.json.parser.JSONParser.PairContext arg) {
		final Node node = new Node("Pair", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArray(com.generator.generators.json.parser.JSONParser.ArrayContext arg) {
		final Node node = new Node("Array", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		final Node node = new Node("Value", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}