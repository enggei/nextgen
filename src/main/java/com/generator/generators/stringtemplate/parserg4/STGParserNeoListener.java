package com.generator.generators.stringtemplate.parserg4;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class STGParserNeoListener extends STGParserBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public STGParserNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public STGParserNeoListener(com.generator.neo.NeoModel model, boolean debug) {
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

	protected java.util.Stack<Boolean> inImports = new java.util.Stack<>();

	@Override
	public void enterImports(com.generator.generators.stringtemplate.parserg4.STGParser.ImportsContext arg) {
		final Node node = model.findOrCreate(Label.label("Imports"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inImports.push(true);
	}

	public void exitImports(com.generator.generators.stringtemplate.parserg4.STGParser.ImportsContext arg) {
		onExit();
		this.inImports.pop();
	}

	public boolean inImports() {
      return !inImports.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplate = new java.util.Stack<>();

	@Override
	public void enterTemplate(com.generator.generators.stringtemplate.parserg4.STGParser.TemplateContext arg) {
		final Node node = model.findOrCreate(Label.label("Template"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("DictPairs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("KeyValuePair"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("DefaultValuePair"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("KeyValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inKeyValue.push(true);
	}

	public void exitKeyValue(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValueContext arg) {
		onExit();
		this.inKeyValue.pop();
	}

	public boolean inKeyValue() {
      return !inKeyValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGroup = new java.util.Stack<>();

	@Override
	public void enterGroup(com.generator.generators.stringtemplate.parserg4.STGParser.GroupContext arg) {
		final Node node = model.findOrCreate(Label.label("Group"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inGroup.push(true);
	}

	public void exitGroup(com.generator.generators.stringtemplate.parserg4.STGParser.GroupContext arg) {
		onExit();
		this.inGroup.pop();
	}

	public boolean inGroup() {
      return !inGroup.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDelimiters = new java.util.Stack<>();

	@Override
	public void enterDelimiters(com.generator.generators.stringtemplate.parserg4.STGParser.DelimitersContext arg) {
		final Node node = model.findOrCreate(Label.label("Delimiters"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("FormalArgs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("FormalArg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Dict"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
		onEnter(node);
		this.inDict.push(true);
	}

	public void exitDict(com.generator.generators.stringtemplate.parserg4.STGParser.DictContext arg) {
		onExit();
		this.inDict.pop();
	}

	public boolean inDict() {
      return !inDict.isEmpty(); 
   }

}