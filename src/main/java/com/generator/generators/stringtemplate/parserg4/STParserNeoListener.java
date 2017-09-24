package com.generator.generators.stringtemplate.parserg4;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class STParserNeoListener extends STParserBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.neo.NeoModel model;

	public STParserNeoListener(com.generator.neo.NeoModel model) {
		this(model, false);
	}

	public STParserNeoListener(com.generator.neo.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
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

	protected java.util.Stack<Boolean> inSingleElement = new java.util.Stack<>();

	@Override
	public void enterSingleElement(com.generator.generators.stringtemplate.parserg4.STParser.SingleElementContext arg) {
		final Node node = model.findOrCreate(Label.label("SingleElement"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("CompoundElement"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ExprTag"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Region"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Subtemplate"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Ifstat"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Conditional"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("AndConditional"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NotConditional"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NotConditionalExpr"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ExprOptions"), "text", arg.getText());
		onEnter(node);
		this.inExprOptions.push(true);
	}

	public void exitExprOptions(com.generator.generators.stringtemplate.parserg4.STParser.ExprOptionsContext arg) {
		onExit();
		this.inExprOptions.pop();
	}

	public boolean inExprOptions() {
      return !inExprOptions.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTemplate = new java.util.Stack<>();

	@Override
	public void enterTemplate(com.generator.generators.stringtemplate.parserg4.STParser.TemplateContext arg) {
		final Node node = model.findOrCreate(Label.label("Template"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Elements"), "text", arg.getText());
		onEnter(node);
		this.inElements.push(true);
	}

	public void exitElements(com.generator.generators.stringtemplate.parserg4.STParser.ElementsContext arg) {
		onExit();
		this.inElements.pop();
	}

	public boolean inElements() {
      return !inElements.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inOption = new java.util.Stack<>();

	@Override
	public void enterOption(com.generator.generators.stringtemplate.parserg4.STParser.OptionContext arg) {
		final Node node = model.findOrCreate(Label.label("Option"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Element"), "text", arg.getText());
		onEnter(node);
		this.inElement.push(true);
	}

	public void exitElement(com.generator.generators.stringtemplate.parserg4.STParser.ElementContext arg) {
		onExit();
		this.inElement.pop();
	}

	public boolean inElement() {
      return !inElement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMapExpr = new java.util.Stack<>();

	@Override
	public void enterMapExpr(com.generator.generators.stringtemplate.parserg4.STParser.MapExprContext arg) {
		final Node node = model.findOrCreate(Label.label("MapExpr"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("MemberExpr"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("MapTemplateRef"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("IncludeExpr"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("ArgExprList"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("NamedArg"), "text", arg.getText());
		onEnter(node);
		this.inNamedArg.push(true);
	}

	public void exitNamedArg(com.generator.generators.stringtemplate.parserg4.STParser.NamedArgContext arg) {
		onExit();
		this.inNamedArg.pop();
	}

	public boolean inNamedArg() {
      return !inNamedArg.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inList = new java.util.Stack<>();

	@Override
	public void enterList(com.generator.generators.stringtemplate.parserg4.STParser.ListContext arg) {
		final Node node = model.findOrCreate(Label.label("List"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Expr"), "text", arg.getText());
		onEnter(node);
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
		final Node node = model.findOrCreate(Label.label("Primary"), "text", arg.getText());
		onEnter(node);
		this.inPrimary.push(true);
	}

	public void exitPrimary(com.generator.generators.stringtemplate.parserg4.STParser.PrimaryContext arg) {
		onExit();
		this.inPrimary.pop();
	}

	public boolean inPrimary() {
      return !inPrimary.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inArgs = new java.util.Stack<>();

	@Override
	public void enterArgs(com.generator.generators.stringtemplate.parserg4.STParser.ArgsContext arg) {
		final Node node = model.findOrCreate(Label.label("Args"), "text", arg.getText());
		onEnter(node);
		this.inArgs.push(true);
	}

	public void exitArgs(com.generator.generators.stringtemplate.parserg4.STParser.ArgsContext arg) {
		onExit();
		this.inArgs.pop();
	}

	public boolean inArgs() {
      return !inArgs.isEmpty(); 
   }

}