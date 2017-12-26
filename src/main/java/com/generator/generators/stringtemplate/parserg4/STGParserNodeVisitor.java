package com.generator.generators.stringtemplate.parserg4;

public class STGParserNodeVisitor extends STGParserBaseVisitor<STGParserNodeVisitor.Node> {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(STGParserNodeVisitor.class);

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

	public STGParserNodeVisitor() {
		this(false);
	}

	public STGParserNodeVisitor(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
				if (debug) log.debug(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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

	@Override
	public Node visitImports(com.generator.generators.stringtemplate.parserg4.STGParser.ImportsContext arg) {
		final Node node = new Node("Imports", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplate(com.generator.generators.stringtemplate.parserg4.STGParser.TemplateContext arg) {
		final Node node = new Node("Template", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroup(com.generator.generators.stringtemplate.parserg4.STGParser.GroupContext arg) {
		final Node node = new Node("Group", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelimiters(com.generator.generators.stringtemplate.parserg4.STGParser.DelimitersContext arg) {
		final Node node = new Node("Delimiters", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalArgs(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgsContext arg) {
		final Node node = new Node("FormalArgs", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFormalArg(com.generator.generators.stringtemplate.parserg4.STGParser.FormalArgContext arg) {
		final Node node = new Node("FormalArg", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDict(com.generator.generators.stringtemplate.parserg4.STGParser.DictContext arg) {
		final Node node = new Node("Dict", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDictPairs(com.generator.generators.stringtemplate.parserg4.STGParser.DictPairsContext arg) {
		final Node node = new Node("DictPairs", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValuePairContext arg) {
		final Node node = new Node("KeyValuePair", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDefaultValuePair(com.generator.generators.stringtemplate.parserg4.STGParser.DefaultValuePairContext arg) {
		final Node node = new Node("DefaultValuePair", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyValue(com.generator.generators.stringtemplate.parserg4.STGParser.KeyValueContext arg) {
		final Node node = new Node("KeyValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}