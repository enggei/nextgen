package com.generator.generators.stringtemplate.parserg4;

public class STParserNodeListener extends STParserBaseListener {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(STParserNodeListener.class);

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

	public STParserNodeListener() {
		this(false);
	}

	public STParserNodeListener(boolean debug) {
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

	protected java.util.Stack<Boolean> inArgs = new java.util.Stack<>();

	@Override
	public void enterArgs(com.generator.generators.stringtemplate.parserg4.STParser.ArgsContext arg) {
		onEnter(new Node("Args", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inArgs.push(true);
	}

	public void exitArgs(com.generator.generators.stringtemplate.parserg4.STParser.ArgsContext arg) {
		onExit();
		this.inArgs.pop();
	}

	public boolean inArgs() {
      return !inArgs.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOption = new java.util.Stack<>();

	@Override
	public void enterOption(com.generator.generators.stringtemplate.parserg4.STParser.OptionContext arg) {
		onEnter(new Node("Option", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inOption.push(true);
	}

	public void exitOption(com.generator.generators.stringtemplate.parserg4.STParser.OptionContext arg) {
		onExit();
		this.inOption.pop();
	}

	public boolean inOption() {
      return !inOption.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElement = new java.util.Stack<>();

	@Override
	public void enterElement(com.generator.generators.stringtemplate.parserg4.STParser.ElementContext arg) {
		onEnter(new Node("Element", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inElement.push(true);
	}

	public void exitElement(com.generator.generators.stringtemplate.parserg4.STParser.ElementContext arg) {
		onExit();
		this.inElement.pop();
	}

	public boolean inElement() {
      return !inElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inList = new java.util.Stack<>();

	@Override
	public void enterList(com.generator.generators.stringtemplate.parserg4.STParser.ListContext arg) {
		onEnter(new Node("List", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inList.push(true);
	}

	public void exitList(com.generator.generators.stringtemplate.parserg4.STParser.ListContext arg) {
		onExit();
		this.inList.pop();
	}

	public boolean inList() {
      return !inList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpr = new java.util.Stack<>();

	@Override
	public void enterExpr(com.generator.generators.stringtemplate.parserg4.STParser.ExprContext arg) {
		onEnter(new Node("Expr", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inExpr.push(true);
	}

	public void exitExpr(com.generator.generators.stringtemplate.parserg4.STParser.ExprContext arg) {
		onExit();
		this.inExpr.pop();
	}

	public boolean inExpr() {
      return !inExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrimary = new java.util.Stack<>();

	@Override
	public void enterPrimary(com.generator.generators.stringtemplate.parserg4.STParser.PrimaryContext arg) {
		onEnter(new Node("Primary", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inPrimary.push(true);
	}

	public void exitPrimary(com.generator.generators.stringtemplate.parserg4.STParser.PrimaryContext arg) {
		onExit();
		this.inPrimary.pop();
	}

	public boolean inPrimary() {
      return !inPrimary.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplate = new java.util.Stack<>();

	@Override
	public void enterTemplate(com.generator.generators.stringtemplate.parserg4.STParser.TemplateContext arg) {
		onEnter(new Node("Template", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inTemplate.push(true);
	}

	public void exitTemplate(com.generator.generators.stringtemplate.parserg4.STParser.TemplateContext arg) {
		onExit();
		this.inTemplate.pop();
	}

	public boolean inTemplate() {
      return !inTemplate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElements = new java.util.Stack<>();

	@Override
	public void enterElements(com.generator.generators.stringtemplate.parserg4.STParser.ElementsContext arg) {
		onEnter(new Node("Elements", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inElements.push(true);
	}

	public void exitElements(com.generator.generators.stringtemplate.parserg4.STParser.ElementsContext arg) {
		onExit();
		this.inElements.pop();
	}

	public boolean inElements() {
      return !inElements.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSingleElement = new java.util.Stack<>();

	@Override
	public void enterSingleElement(com.generator.generators.stringtemplate.parserg4.STParser.SingleElementContext arg) {
		onEnter(new Node("SingleElement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inSingleElement.push(true);
	}

	public void exitSingleElement(com.generator.generators.stringtemplate.parserg4.STParser.SingleElementContext arg) {
		onExit();
		this.inSingleElement.pop();
	}

	public boolean inSingleElement() {
      return !inSingleElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCompoundElement = new java.util.Stack<>();

	@Override
	public void enterCompoundElement(com.generator.generators.stringtemplate.parserg4.STParser.CompoundElementContext arg) {
		onEnter(new Node("CompoundElement", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inCompoundElement.push(true);
	}

	public void exitCompoundElement(com.generator.generators.stringtemplate.parserg4.STParser.CompoundElementContext arg) {
		onExit();
		this.inCompoundElement.pop();
	}

	public boolean inCompoundElement() {
      return !inCompoundElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprTag = new java.util.Stack<>();

	@Override
	public void enterExprTag(com.generator.generators.stringtemplate.parserg4.STParser.ExprTagContext arg) {
		onEnter(new Node("ExprTag", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inExprTag.push(true);
	}

	public void exitExprTag(com.generator.generators.stringtemplate.parserg4.STParser.ExprTagContext arg) {
		onExit();
		this.inExprTag.pop();
	}

	public boolean inExprTag() {
      return !inExprTag.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inRegion = new java.util.Stack<>();

	@Override
	public void enterRegion(com.generator.generators.stringtemplate.parserg4.STParser.RegionContext arg) {
		onEnter(new Node("Region", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inRegion.push(true);
	}

	public void exitRegion(com.generator.generators.stringtemplate.parserg4.STParser.RegionContext arg) {
		onExit();
		this.inRegion.pop();
	}

	public boolean inRegion() {
      return !inRegion.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSubtemplate = new java.util.Stack<>();

	@Override
	public void enterSubtemplate(com.generator.generators.stringtemplate.parserg4.STParser.SubtemplateContext arg) {
		onEnter(new Node("Subtemplate", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inSubtemplate.push(true);
	}

	public void exitSubtemplate(com.generator.generators.stringtemplate.parserg4.STParser.SubtemplateContext arg) {
		onExit();
		this.inSubtemplate.pop();
	}

	public boolean inSubtemplate() {
      return !inSubtemplate.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIfstat = new java.util.Stack<>();

	@Override
	public void enterIfstat(com.generator.generators.stringtemplate.parserg4.STParser.IfstatContext arg) {
		onEnter(new Node("Ifstat", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inIfstat.push(true);
	}

	public void exitIfstat(com.generator.generators.stringtemplate.parserg4.STParser.IfstatContext arg) {
		onExit();
		this.inIfstat.pop();
	}

	public boolean inIfstat() {
      return !inIfstat.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inConditional = new java.util.Stack<>();

	@Override
	public void enterConditional(com.generator.generators.stringtemplate.parserg4.STParser.ConditionalContext arg) {
		onEnter(new Node("Conditional", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inConditional.push(true);
	}

	public void exitConditional(com.generator.generators.stringtemplate.parserg4.STParser.ConditionalContext arg) {
		onExit();
		this.inConditional.pop();
	}

	public boolean inConditional() {
      return !inConditional.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAndConditional = new java.util.Stack<>();

	@Override
	public void enterAndConditional(com.generator.generators.stringtemplate.parserg4.STParser.AndConditionalContext arg) {
		onEnter(new Node("AndConditional", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inAndConditional.push(true);
	}

	public void exitAndConditional(com.generator.generators.stringtemplate.parserg4.STParser.AndConditionalContext arg) {
		onExit();
		this.inAndConditional.pop();
	}

	public boolean inAndConditional() {
      return !inAndConditional.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNotConditional = new java.util.Stack<>();

	@Override
	public void enterNotConditional(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalContext arg) {
		onEnter(new Node("NotConditional", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNotConditional.push(true);
	}

	public void exitNotConditional(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalContext arg) {
		onExit();
		this.inNotConditional.pop();
	}

	public boolean inNotConditional() {
      return !inNotConditional.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNotConditionalExpr = new java.util.Stack<>();

	@Override
	public void enterNotConditionalExpr(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalExprContext arg) {
		onEnter(new Node("NotConditionalExpr", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNotConditionalExpr.push(true);
	}

	public void exitNotConditionalExpr(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalExprContext arg) {
		onExit();
		this.inNotConditionalExpr.pop();
	}

	public boolean inNotConditionalExpr() {
      return !inNotConditionalExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExprOptions = new java.util.Stack<>();

	@Override
	public void enterExprOptions(com.generator.generators.stringtemplate.parserg4.STParser.ExprOptionsContext arg) {
		onEnter(new Node("ExprOptions", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inExprOptions.push(true);
	}

	public void exitExprOptions(com.generator.generators.stringtemplate.parserg4.STParser.ExprOptionsContext arg) {
		onExit();
		this.inExprOptions.pop();
	}

	public boolean inExprOptions() {
      return !inExprOptions.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMapExpr = new java.util.Stack<>();

	@Override
	public void enterMapExpr(com.generator.generators.stringtemplate.parserg4.STParser.MapExprContext arg) {
		onEnter(new Node("MapExpr", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inMapExpr.push(true);
	}

	public void exitMapExpr(com.generator.generators.stringtemplate.parserg4.STParser.MapExprContext arg) {
		onExit();
		this.inMapExpr.pop();
	}

	public boolean inMapExpr() {
      return !inMapExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMemberExpr = new java.util.Stack<>();

	@Override
	public void enterMemberExpr(com.generator.generators.stringtemplate.parserg4.STParser.MemberExprContext arg) {
		onEnter(new Node("MemberExpr", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inMemberExpr.push(true);
	}

	public void exitMemberExpr(com.generator.generators.stringtemplate.parserg4.STParser.MemberExprContext arg) {
		onExit();
		this.inMemberExpr.pop();
	}

	public boolean inMemberExpr() {
      return !inMemberExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMapTemplateRef = new java.util.Stack<>();

	@Override
	public void enterMapTemplateRef(com.generator.generators.stringtemplate.parserg4.STParser.MapTemplateRefContext arg) {
		onEnter(new Node("MapTemplateRef", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inMapTemplateRef.push(true);
	}

	public void exitMapTemplateRef(com.generator.generators.stringtemplate.parserg4.STParser.MapTemplateRefContext arg) {
		onExit();
		this.inMapTemplateRef.pop();
	}

	public boolean inMapTemplateRef() {
      return !inMapTemplateRef.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIncludeExpr = new java.util.Stack<>();

	@Override
	public void enterIncludeExpr(com.generator.generators.stringtemplate.parserg4.STParser.IncludeExprContext arg) {
		onEnter(new Node("IncludeExpr", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inIncludeExpr.push(true);
	}

	public void exitIncludeExpr(com.generator.generators.stringtemplate.parserg4.STParser.IncludeExprContext arg) {
		onExit();
		this.inIncludeExpr.pop();
	}

	public boolean inIncludeExpr() {
      return !inIncludeExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgExprList = new java.util.Stack<>();

	@Override
	public void enterArgExprList(com.generator.generators.stringtemplate.parserg4.STParser.ArgExprListContext arg) {
		onEnter(new Node("ArgExprList", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inArgExprList.push(true);
	}

	public void exitArgExprList(com.generator.generators.stringtemplate.parserg4.STParser.ArgExprListContext arg) {
		onExit();
		this.inArgExprList.pop();
	}

	public boolean inArgExprList() {
      return !inArgExprList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamedArg = new java.util.Stack<>();

	@Override
	public void enterNamedArg(com.generator.generators.stringtemplate.parserg4.STParser.NamedArgContext arg) {
		onEnter(new Node("NamedArg", arg.getText(), arg.getStart().getText(), arg.getStop() == null ? "" : arg.getStop().getText()));
		this.inNamedArg.push(true);
	}

	public void exitNamedArg(com.generator.generators.stringtemplate.parserg4.STParser.NamedArgContext arg) {
		onExit();
		this.inNamedArg.pop();
	}

	public boolean inNamedArg() {
      return !inNamedArg.isEmpty(); 
   }

}