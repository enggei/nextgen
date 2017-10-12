package com.generator.generators.properties.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class propertiesNeoListener extends propertiesBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public propertiesNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public propertiesNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inPropertiesFile = new java.util.Stack<>();

	@Override
	public void enterPropertiesFile(com.generator.generators.properties.parser.propertiesParser.PropertiesFileContext arg) {
		final Node node = model.findOrCreate(Label.label("PropertiesFile"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inPropertiesFile.push(true);
	}

	public void exitPropertiesFile(com.generator.generators.properties.parser.propertiesParser.PropertiesFileContext arg) {
		onExit();
		this.inPropertiesFile.pop();
	}

	public boolean inPropertiesFile() {
      return !inPropertiesFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDecl = new java.util.Stack<>();

	@Override
	public void enterDecl(com.generator.generators.properties.parser.propertiesParser.DeclContext arg) {
		final Node node = model.findOrCreate(Label.label("Decl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDecl.push(true);
	}

	public void exitDecl(com.generator.generators.properties.parser.propertiesParser.DeclContext arg) {
		onExit();
		this.inDecl.pop();
	}

	public boolean inDecl() {
      return !inDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComment = new java.util.Stack<>();

	@Override
	public void enterComment(com.generator.generators.properties.parser.propertiesParser.CommentContext arg) {
		final Node node = model.findOrCreate(Label.label("Comment"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inComment.push(true);
	}

	public void exitComment(com.generator.generators.properties.parser.propertiesParser.CommentContext arg) {
		onExit();
		this.inComment.pop();
	}

	public boolean inComment() {
      return !inComment.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inValue = new java.util.Stack<>();

	@Override
	public void enterValue(com.generator.generators.properties.parser.propertiesParser.ValueContext arg) {
		final Node node = model.findOrCreate(Label.label("Value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inValue.push(true);
	}

	public void exitValue(com.generator.generators.properties.parser.propertiesParser.ValueContext arg) {
		onExit();
		this.inValue.pop();
	}

	public boolean inValue() {
      return !inValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRow = new java.util.Stack<>();

	@Override
	public void enterRow(com.generator.generators.properties.parser.propertiesParser.RowContext arg) {
		final Node node = model.findOrCreate(Label.label("Row"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inRow.push(true);
	}

	public void exitRow(com.generator.generators.properties.parser.propertiesParser.RowContext arg) {
		onExit();
		this.inRow.pop();
	}

	public boolean inRow() {
      return !inRow.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKey = new java.util.Stack<>();

	@Override
	public void enterKey(com.generator.generators.properties.parser.propertiesParser.KeyContext arg) {
		final Node node = model.findOrCreate(Label.label("Key"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inKey.push(true);
	}

	public void exitKey(com.generator.generators.properties.parser.propertiesParser.KeyContext arg) {
		onExit();
		this.inKey.pop();
	}

	public boolean inKey() {
      return !inKey.isEmpty(); 
   }

}