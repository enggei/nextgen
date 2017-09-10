package com.generator.generators.json.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class JSONNeoListener extends JSONBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public JSONNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public JSONNeoListener(com.generator.NeoModel model, boolean debug) {
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

	protected boolean inJson = false;

	@Override
	public void enterJson(com.generator.generators.json.parser.JSONParser.JsonContext arg) {
		final Node node = model.findOrCreate(Label.label("Json"), "text", arg.getText());
		onEnter(node);
		this.inJson = true;
	}

	public void exitJson(com.generator.generators.json.parser.JSONParser.JsonContext arg) {
		onExit();
		this.inJson = false;
	}

	protected boolean inObj = false;

	@Override
	public void enterObj(com.generator.generators.json.parser.JSONParser.ObjContext arg) {
		final Node node = model.findOrCreate(Label.label("Obj"), "text", arg.getText());
		onEnter(node);
		this.inObj = true;
	}

	public void exitObj(com.generator.generators.json.parser.JSONParser.ObjContext arg) {
		onExit();
		this.inObj = false;
	}

	protected boolean inPair = false;

	@Override
	public void enterPair(com.generator.generators.json.parser.JSONParser.PairContext arg) {
		final Node node = model.findOrCreate(Label.label("Pair"), "text", arg.getText());
		onEnter(node);
		this.inPair = true;
	}

	public void exitPair(com.generator.generators.json.parser.JSONParser.PairContext arg) {
		onExit();
		this.inPair = false;
	}

	protected boolean inArray = false;

	@Override
	public void enterArray(com.generator.generators.json.parser.JSONParser.ArrayContext arg) {
		final Node node = model.findOrCreate(Label.label("Array"), "text", arg.getText());
		onEnter(node);
		this.inArray = true;
	}

	public void exitArray(com.generator.generators.json.parser.JSONParser.ArrayContext arg) {
		onExit();
		this.inArray = false;
	}

	protected boolean inValue = false;

	@Override
	public void enterValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		final Node node = model.findOrCreate(Label.label("Value"), "text", arg.getText());
		onEnter(node);
		this.inValue = true;
	}

	public void exitValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		onExit();
		this.inValue = false;
	}

}