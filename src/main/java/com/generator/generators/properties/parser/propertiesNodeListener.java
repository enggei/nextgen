package com.generator.generators.properties.parser;

public class propertiesNodeListener extends propertiesBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final String endToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken, String endToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
			this.endToken = endToken;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public propertiesNodeListener() {
		this(false);
	}

	public propertiesNodeListener(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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

	protected java.util.Stack<Boolean> inDecl = new java.util.Stack<>();

	@Override
	public void enterDecl(com.generator.generators.properties.parser.propertiesParser.DeclContext arg) {
		onEnter(new Node("Decl", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDecl.push(true);
	}

	public void exitDecl(com.generator.generators.properties.parser.propertiesParser.DeclContext arg) {
		onExit();
		this.inDecl.pop();
	}

	public boolean inDecl() {
      return !inDecl.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPropertiesFile = new java.util.Stack<>();

	@Override
	public void enterPropertiesFile(com.generator.generators.properties.parser.propertiesParser.PropertiesFileContext arg) {
		onEnter(new Node("PropertiesFile", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inPropertiesFile.push(true);
	}

	public void exitPropertiesFile(com.generator.generators.properties.parser.propertiesParser.PropertiesFileContext arg) {
		onExit();
		this.inPropertiesFile.pop();
	}

	public boolean inPropertiesFile() {
      return !inPropertiesFile.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inComment = new java.util.Stack<>();

	@Override
	public void enterComment(com.generator.generators.properties.parser.propertiesParser.CommentContext arg) {
		onEnter(new Node("Comment", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Value", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Row", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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
		onEnter(new Node("Key", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
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