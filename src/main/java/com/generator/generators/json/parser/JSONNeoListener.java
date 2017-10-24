package com.generator.generators.json.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class JSONNeoListener extends JSONBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public JSONNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public JSONNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   protected void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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

	protected java.util.Stack<Boolean> inValue = new java.util.Stack<>();

	@Override
	public void enterValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		final Node node = model.findOrCreate(Label.label("Value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Json"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Obj"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Pair"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Array"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", (arg.getStop() == null ? "" : arg.getStop().getText()));
		onEnter(node);
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