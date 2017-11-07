package com.generator.generators.stringtemplate.parserg4;

public class STGParserNodeListener extends STGParserBaseListener {

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

	public STGParserNodeListener() {
		this(false);
	}

	public STGParserNodeListener(boolean debug) {
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

	protected java.util.Stack<Boolean> inImports = new java.util.Stack<>();

	@Override
	public void enterImports(com.generator.generators.stringtemplate.parserg4.STGParser.ImportsContext arg) {
		onEnter(new Node("Imports", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inImports.push(true);
	}

	public void exitImports(com.generator.generators.stringtemplate.parserg4.STGParser.ImportsContext arg) {
		onExit();
		this.inImports.pop();
	}

	public boolean inImports() {
      return !inImports.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDelimiters = new java.util.Stack<>();

	@Override
	public void enterDelimiters(com.generator.generators.stringtemplate.parserg4.STGParser.DelimitersContext arg) {
		onEnter(new Node("Delimiters", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDelimiters.push(true);
	}

	public void exitDelimiters(com.generator.generators.stringtemplate.parserg4.STGParser.DelimitersContext arg) {
		onExit();
		this.inDelimiters.pop();
	}

	public boolean inDelimiters() {
      return !inDelimiters.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFormalArgs = new java.util.Stack<>();

	@Override
	public void enterFormalArgs(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgsContext arg) {
		onEnter(new Node("FormalArgs", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inFormalArgs.push(true);
	}

	public void exitFormalArgs(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgsContext arg) {
		onExit();
		this.inFormalArgs.pop();
	}

	public boolean inFormalArgs() {
      return !inFormalArgs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFormalArg = new java.util.Stack<>();

	@Override
	public void enterFormalArg(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgContext arg) {
		onEnter(new Node("FormalArg", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inFormalArg.push(true);
	}

	public void exitFormalArg(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgContext arg) {
		onExit();
		this.inFormalArg.pop();
	}

	public boolean inFormalArg() {
      return !inFormalArg.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDict = new java.util.Stack<>();

	@Override
	public void enterDict(com.generator.generators.stringtemplate.parserg4.STGParser.DictContext arg) {
		onEnter(new Node("Dict", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDict.push(true);
	}

	public void exitDict(com.generator.generators.stringtemplate.parserg4.STGParser.DictContext arg) {
		onExit();
		this.inDict.pop();
	}

	public boolean inDict() {
      return !inDict.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGroup = new java.util.Stack<>();

	@Override
	public void enterGroup(com.generator.generators.stringtemplate.parserg4.STGParser.GroupContext arg) {
		onEnter(new Node("Group", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inGroup.push(true);
	}

	public void exitGroup(com.generator.generators.stringtemplate.parserg4.STGParser.GroupContext arg) {
		onExit();
		this.inGroup.pop();
	}

	public boolean inGroup() {
      return !inGroup.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplate = new java.util.Stack<>();

	@Override
	public void enterTemplate(com.generator.generators.stringtemplate.parserg4.STGParser.TemplateContext arg) {
		onEnter(new Node("Template", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inTemplate.push(true);
	}

	public void exitTemplate(com.generator.generators.stringtemplate.parserg4.STGParser.TemplateContext arg) {
		onExit();
		this.inTemplate.pop();
	}

	public boolean inTemplate() {
      return !inTemplate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDictPairs = new java.util.Stack<>();

	@Override
	public void enterDictPairs(com.generator.generators.stringtemplate.parserg4.STGParser.DictPairsContext arg) {
		onEnter(new Node("DictPairs", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDictPairs.push(true);
	}

	public void exitDictPairs(com.generator.generators.stringtemplate.parserg4.STGParser.DictPairsContext arg) {
		onExit();
		this.inDictPairs.pop();
	}

	public boolean inDictPairs() {
      return !inDictPairs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyValuePair = new java.util.Stack<>();

	@Override
	public void enterKeyValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValuePairContext arg) {
		onEnter(new Node("KeyValuePair", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inKeyValuePair.push(true);
	}

	public void exitKeyValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValuePairContext arg) {
		onExit();
		this.inKeyValuePair.pop();
	}

	public boolean inKeyValuePair() {
      return !inKeyValuePair.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDefaultValuePair = new java.util.Stack<>();

	@Override
	public void enterDefaultValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.DefaultValuePairContext arg) {
		onEnter(new Node("DefaultValuePair", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inDefaultValuePair.push(true);
	}

	public void exitDefaultValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.DefaultValuePairContext arg) {
		onExit();
		this.inDefaultValuePair.pop();
	}

	public boolean inDefaultValuePair() {
      return !inDefaultValuePair.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyValue = new java.util.Stack<>();

	@Override
	public void enterKeyValue(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValueContext arg) {
		onEnter(new Node("KeyValue", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inKeyValue.push(true);
	}

	public void exitKeyValue(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValueContext arg) {
		onExit();
		this.inKeyValue.pop();
	}

	public boolean inKeyValue() {
      return !inKeyValue.isEmpty(); 
   }

}