package com.generator.generators.stringtemplate.parser;

public class STBaseListener extends STParserBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
      }
   }

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public void enterElement(com.generator.generators.stringtemplate.parser.STParser.ElementContext arg) {
		 //System.out.println("Element");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Element", arg.getText(), arg.getStart().getText()));
	}

	public void exitElement(com.generator.generators.stringtemplate.parser.STParser.ElementContext arg) {
		 onExit();
	}

	@Override
	public void enterOption(com.generator.generators.stringtemplate.parser.STParser.OptionContext arg) {
		 //System.out.println("Option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Option", arg.getText(), arg.getStart().getText()));
	}

	public void exitOption(com.generator.generators.stringtemplate.parser.STParser.OptionContext arg) {
		 onExit();
	}

	@Override
	public void enterTemplate(com.generator.generators.stringtemplate.parser.STParser.TemplateContext arg) {
		 //System.out.println("Template");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Template", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplate(com.generator.generators.stringtemplate.parser.STParser.TemplateContext arg) {
		 onExit();
	}

	@Override
	public void enterElements(com.generator.generators.stringtemplate.parser.STParser.ElementsContext arg) {
		 //System.out.println("Elements");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Elements", arg.getText(), arg.getStart().getText()));
	}

	public void exitElements(com.generator.generators.stringtemplate.parser.STParser.ElementsContext arg) {
		 onExit();
	}

	@Override
	public void enterSingleElement(com.generator.generators.stringtemplate.parser.STParser.SingleElementContext arg) {
		 //System.out.println("SingleElement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SingleElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSingleElement(com.generator.generators.stringtemplate.parser.STParser.SingleElementContext arg) {
		 onExit();
	}

	@Override
	public void enterCompoundElement(com.generator.generators.stringtemplate.parser.STParser.CompoundElementContext arg) {
		 //System.out.println("CompoundElement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CompoundElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitCompoundElement(com.generator.generators.stringtemplate.parser.STParser.CompoundElementContext arg) {
		 onExit();
	}

	@Override
	public void enterExprTag(com.generator.generators.stringtemplate.parser.STParser.ExprTagContext arg) {
		 //System.out.println("ExprTag");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExprTag", arg.getText(), arg.getStart().getText()));
	}

	public void exitExprTag(com.generator.generators.stringtemplate.parser.STParser.ExprTagContext arg) {
		 onExit();
	}

	@Override
	public void enterRegion(com.generator.generators.stringtemplate.parser.STParser.RegionContext arg) {
		 //System.out.println("Region");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Region", arg.getText(), arg.getStart().getText()));
	}

	public void exitRegion(com.generator.generators.stringtemplate.parser.STParser.RegionContext arg) {
		 onExit();
	}

	@Override
	public void enterSubtemplate(com.generator.generators.stringtemplate.parser.STParser.SubtemplateContext arg) {
		 //System.out.println("Subtemplate");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Subtemplate", arg.getText(), arg.getStart().getText()));
	}

	public void exitSubtemplate(com.generator.generators.stringtemplate.parser.STParser.SubtemplateContext arg) {
		 onExit();
	}

	@Override
	public void enterIfstat(com.generator.generators.stringtemplate.parser.STParser.IfstatContext arg) {
		 //System.out.println("Ifstat");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Ifstat", arg.getText(), arg.getStart().getText()));
	}

	public void exitIfstat(com.generator.generators.stringtemplate.parser.STParser.IfstatContext arg) {
		 onExit();
	}

	@Override
	public void enterConditional(com.generator.generators.stringtemplate.parser.STParser.ConditionalContext arg) {
		 //System.out.println("Conditional");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Conditional", arg.getText(), arg.getStart().getText()));
	}

	public void exitConditional(com.generator.generators.stringtemplate.parser.STParser.ConditionalContext arg) {
		 onExit();
	}

	@Override
	public void enterAndConditional(com.generator.generators.stringtemplate.parser.STParser.AndConditionalContext arg) {
		 //System.out.println("AndConditional");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AndConditional", arg.getText(), arg.getStart().getText()));
	}

	public void exitAndConditional(com.generator.generators.stringtemplate.parser.STParser.AndConditionalContext arg) {
		 onExit();
	}

	@Override
	public void enterNotConditional(com.generator.generators.stringtemplate.parser.STParser.NotConditionalContext arg) {
		 //System.out.println("NotConditional");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NotConditional", arg.getText(), arg.getStart().getText()));
	}

	public void exitNotConditional(com.generator.generators.stringtemplate.parser.STParser.NotConditionalContext arg) {
		 onExit();
	}

	@Override
	public void enterNotConditionalExpr(com.generator.generators.stringtemplate.parser.STParser.NotConditionalExprContext arg) {
		 //System.out.println("NotConditionalExpr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NotConditionalExpr", arg.getText(), arg.getStart().getText()));
	}

	public void exitNotConditionalExpr(com.generator.generators.stringtemplate.parser.STParser.NotConditionalExprContext arg) {
		 onExit();
	}

	@Override
	public void enterExprOptions(com.generator.generators.stringtemplate.parser.STParser.ExprOptionsContext arg) {
		 //System.out.println("ExprOptions");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExprOptions", arg.getText(), arg.getStart().getText()));
	}

	public void exitExprOptions(com.generator.generators.stringtemplate.parser.STParser.ExprOptionsContext arg) {
		 onExit();
	}

	@Override
	public void enterExpr(com.generator.generators.stringtemplate.parser.STParser.ExprContext arg) {
		 //System.out.println("Expr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Expr", arg.getText(), arg.getStart().getText()));
	}

	public void exitExpr(com.generator.generators.stringtemplate.parser.STParser.ExprContext arg) {
		 onExit();
	}

	@Override
	public void enterMapExpr(com.generator.generators.stringtemplate.parser.STParser.MapExprContext arg) {
		 //System.out.println("MapExpr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MapExpr", arg.getText(), arg.getStart().getText()));
	}

	public void exitMapExpr(com.generator.generators.stringtemplate.parser.STParser.MapExprContext arg) {
		 onExit();
	}

	@Override
	public void enterMemberExpr(com.generator.generators.stringtemplate.parser.STParser.MemberExprContext arg) {
		 //System.out.println("MemberExpr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MemberExpr", arg.getText(), arg.getStart().getText()));
	}

	public void exitMemberExpr(com.generator.generators.stringtemplate.parser.STParser.MemberExprContext arg) {
		 onExit();
	}

	@Override
	public void enterMapTemplateRef(com.generator.generators.stringtemplate.parser.STParser.MapTemplateRefContext arg) {
		 //System.out.println("MapTemplateRef");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("MapTemplateRef", arg.getText(), arg.getStart().getText()));
	}

	public void exitMapTemplateRef(com.generator.generators.stringtemplate.parser.STParser.MapTemplateRefContext arg) {
		 onExit();
	}

	@Override
	public void enterIncludeExpr(com.generator.generators.stringtemplate.parser.STParser.IncludeExprContext arg) {
		 //System.out.println("IncludeExpr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IncludeExpr", arg.getText(), arg.getStart().getText()));
	}

	public void exitIncludeExpr(com.generator.generators.stringtemplate.parser.STParser.IncludeExprContext arg) {
		 onExit();
	}

	@Override
	public void enterPrimary(com.generator.generators.stringtemplate.parser.STParser.PrimaryContext arg) {
		 //System.out.println("Primary");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Primary", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrimary(com.generator.generators.stringtemplate.parser.STParser.PrimaryContext arg) {
		 onExit();
	}

	@Override
	public void enterList(com.generator.generators.stringtemplate.parser.STParser.ListContext arg) {
		 //System.out.println("List");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("List", arg.getText(), arg.getStart().getText()));
	}

	public void exitList(com.generator.generators.stringtemplate.parser.STParser.ListContext arg) {
		 onExit();
	}

	@Override
	public void enterArgs(com.generator.generators.stringtemplate.parser.STParser.ArgsContext arg) {
		 //System.out.println("Args");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Args", arg.getText(), arg.getStart().getText()));
	}

	public void exitArgs(com.generator.generators.stringtemplate.parser.STParser.ArgsContext arg) {
		 onExit();
	}

	@Override
	public void enterArgExprList(com.generator.generators.stringtemplate.parser.STParser.ArgExprListContext arg) {
		 //System.out.println("ArgExprList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ArgExprList", arg.getText(), arg.getStart().getText()));
	}

	public void exitArgExprList(com.generator.generators.stringtemplate.parser.STParser.ArgExprListContext arg) {
		 onExit();
	}

	@Override
	public void enterNamedArg(com.generator.generators.stringtemplate.parser.STParser.NamedArgContext arg) {
		 //System.out.println("NamedArg");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NamedArg", arg.getText(), arg.getStart().getText()));
	}

	public void exitNamedArg(com.generator.generators.stringtemplate.parser.STParser.NamedArgContext arg) {
		 onExit();
	}

}