package com.generator.generators.stringtemplate.parserg4;

public class STParserNodeVisitor extends STParserBaseVisitor<STParserNodeVisitor.Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STParserNodeVisitor.class);

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

	public STParserNodeVisitor() {
		this(false);
	}

	public STParserNodeVisitor(boolean debug) {
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
	public Node visitArgs(com.generator.generators.stringtemplate.parserg4.STParser.ArgsContext arg) {
		final Node node = new Node("Args", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOption(com.generator.generators.stringtemplate.parserg4.STParser.OptionContext arg) {
		final Node node = new Node("Option", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElement(com.generator.generators.stringtemplate.parserg4.STParser.ElementContext arg) {
		final Node node = new Node("Element", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitList(com.generator.generators.stringtemplate.parserg4.STParser.ListContext arg) {
		final Node node = new Node("List", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.stringtemplate.parserg4.STParser.ExprContext arg) {
		final Node node = new Node("Expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimary(com.generator.generators.stringtemplate.parserg4.STParser.PrimaryContext arg) {
		final Node node = new Node("Primary", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplate(com.generator.generators.stringtemplate.parserg4.STParser.TemplateContext arg) {
		final Node node = new Node("Template", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElements(com.generator.generators.stringtemplate.parserg4.STParser.ElementsContext arg) {
		final Node node = new Node("Elements", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingleElement(com.generator.generators.stringtemplate.parserg4.STParser.SingleElementContext arg) {
		final Node node = new Node("SingleElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompoundElement(com.generator.generators.stringtemplate.parserg4.STParser.CompoundElementContext arg) {
		final Node node = new Node("CompoundElement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprTag(com.generator.generators.stringtemplate.parserg4.STParser.ExprTagContext arg) {
		final Node node = new Node("ExprTag", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegion(com.generator.generators.stringtemplate.parserg4.STParser.RegionContext arg) {
		final Node node = new Node("Region", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubtemplate(com.generator.generators.stringtemplate.parserg4.STParser.SubtemplateContext arg) {
		final Node node = new Node("Subtemplate", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIfstat(com.generator.generators.stringtemplate.parserg4.STParser.IfstatContext arg) {
		final Node node = new Node("Ifstat", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConditional(com.generator.generators.stringtemplate.parserg4.STParser.ConditionalContext arg) {
		final Node node = new Node("Conditional", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAndConditional(com.generator.generators.stringtemplate.parserg4.STParser.AndConditionalContext arg) {
		final Node node = new Node("AndConditional", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotConditional(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalContext arg) {
		final Node node = new Node("NotConditional", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotConditionalExpr(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalExprContext arg) {
		final Node node = new Node("NotConditionalExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprOptions(com.generator.generators.stringtemplate.parserg4.STParser.ExprOptionsContext arg) {
		final Node node = new Node("ExprOptions", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapExpr(com.generator.generators.stringtemplate.parserg4.STParser.MapExprContext arg) {
		final Node node = new Node("MapExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberExpr(com.generator.generators.stringtemplate.parserg4.STParser.MemberExprContext arg) {
		final Node node = new Node("MemberExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapTemplateRef(com.generator.generators.stringtemplate.parserg4.STParser.MapTemplateRefContext arg) {
		final Node node = new Node("MapTemplateRef", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIncludeExpr(com.generator.generators.stringtemplate.parserg4.STParser.IncludeExprContext arg) {
		final Node node = new Node("IncludeExpr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgExprList(com.generator.generators.stringtemplate.parserg4.STParser.ArgExprListContext arg) {
		final Node node = new Node("ArgExprList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamedArg(com.generator.generators.stringtemplate.parserg4.STParser.NamedArgContext arg) {
		final Node node = new Node("NamedArg", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}