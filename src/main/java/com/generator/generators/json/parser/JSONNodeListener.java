package com.generator.generators.json.parser;

public class JSONNodeListener extends JSONBaseListener {

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

	public JSONNodeListener() {
		this(false);
	}

	public JSONNodeListener(boolean debug) {
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

	protected java.util.Stack<Boolean> inValue = new java.util.Stack<>();

	@Override
	public void enterValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		onEnter(new Node("Value", arg.getText(), arg.getStart().getText()));
		this.inValue.push(true);
	}

	public void exitValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		onExit();
		this.inValue.pop();
	}

	public boolean inValue() {
      return !inValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inJson = new java.util.Stack<>();

	@Override
	public void enterJson(com.generator.generators.json.parser.JSONParser.JsonContext arg) {
		onEnter(new Node("Json", arg.getText(), arg.getStart().getText()));
		this.inJson.push(true);
	}

	public void exitJson(com.generator.generators.json.parser.JSONParser.JsonContext arg) {
		onExit();
		this.inJson.pop();
	}

	public boolean inJson() {
      return !inJson.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inObj = new java.util.Stack<>();

	@Override
	public void enterObj(com.generator.generators.json.parser.JSONParser.ObjContext arg) {
		onEnter(new Node("Obj", arg.getText(), arg.getStart().getText()));
		this.inObj.push(true);
	}

	public void exitObj(com.generator.generators.json.parser.JSONParser.ObjContext arg) {
		onExit();
		this.inObj.pop();
	}

	public boolean inObj() {
      return !inObj.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPair = new java.util.Stack<>();

	@Override
	public void enterPair(com.generator.generators.json.parser.JSONParser.PairContext arg) {
		onEnter(new Node("Pair", arg.getText(), arg.getStart().getText()));
		this.inPair.push(true);
	}

	public void exitPair(com.generator.generators.json.parser.JSONParser.PairContext arg) {
		onExit();
		this.inPair.pop();
	}

	public boolean inPair() {
      return !inPair.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArray = new java.util.Stack<>();

	@Override
	public void enterArray(com.generator.generators.json.parser.JSONParser.ArrayContext arg) {
		onEnter(new Node("Array", arg.getText(), arg.getStart().getText()));
		this.inArray.push(true);
	}

	public void exitArray(com.generator.generators.json.parser.JSONParser.ArrayContext arg) {
		onExit();
		this.inArray.pop();
	}

	public boolean inArray() {
      return !inArray.isEmpty(); 
   }

}