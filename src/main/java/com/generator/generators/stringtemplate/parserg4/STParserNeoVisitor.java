package com.generator.generators.stringtemplate.parserg4;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class STParserNeoVisitor extends STParserBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public STParserNeoVisitor(com.generator.neo.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.util.NeoUtil.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitTemplate(com.generator.generators.stringtemplate.parserg4.STParser.TemplateContext arg) {
		System.out.println("Template");
		final Node node = model.findOrCreate(Label.label("Template"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElements(com.generator.generators.stringtemplate.parserg4.STParser.ElementsContext arg) {
		System.out.println("Elements");
		final Node node = model.findOrCreate(Label.label("Elements"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingleElement(com.generator.generators.stringtemplate.parserg4.STParser.SingleElementContext arg) {
		System.out.println("SingleElement");
		final Node node = model.findOrCreate(Label.label("SingleElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompoundElement(com.generator.generators.stringtemplate.parserg4.STParser.CompoundElementContext arg) {
		System.out.println("CompoundElement");
		final Node node = model.findOrCreate(Label.label("CompoundElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprTag(com.generator.generators.stringtemplate.parserg4.STParser.ExprTagContext arg) {
		System.out.println("ExprTag");
		final Node node = model.findOrCreate(Label.label("ExprTag"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegion(com.generator.generators.stringtemplate.parserg4.STParser.RegionContext arg) {
		System.out.println("Region");
		final Node node = model.findOrCreate(Label.label("Region"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubtemplate(com.generator.generators.stringtemplate.parserg4.STParser.SubtemplateContext arg) {
		System.out.println("Subtemplate");
		final Node node = model.findOrCreate(Label.label("Subtemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIfstat(com.generator.generators.stringtemplate.parserg4.STParser.IfstatContext arg) {
		System.out.println("Ifstat");
		final Node node = model.findOrCreate(Label.label("Ifstat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConditional(com.generator.generators.stringtemplate.parserg4.STParser.ConditionalContext arg) {
		System.out.println("Conditional");
		final Node node = model.findOrCreate(Label.label("Conditional"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAndConditional(com.generator.generators.stringtemplate.parserg4.STParser.AndConditionalContext arg) {
		System.out.println("AndConditional");
		final Node node = model.findOrCreate(Label.label("AndConditional"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotConditional(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalContext arg) {
		System.out.println("NotConditional");
		final Node node = model.findOrCreate(Label.label("NotConditional"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotConditionalExpr(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalExprContext arg) {
		System.out.println("NotConditionalExpr");
		final Node node = model.findOrCreate(Label.label("NotConditionalExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprOptions(com.generator.generators.stringtemplate.parserg4.STParser.ExprOptionsContext arg) {
		System.out.println("ExprOptions");
		final Node node = model.findOrCreate(Label.label("ExprOptions"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapExpr(com.generator.generators.stringtemplate.parserg4.STParser.MapExprContext arg) {
		System.out.println("MapExpr");
		final Node node = model.findOrCreate(Label.label("MapExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberExpr(com.generator.generators.stringtemplate.parserg4.STParser.MemberExprContext arg) {
		System.out.println("MemberExpr");
		final Node node = model.findOrCreate(Label.label("MemberExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapTemplateRef(com.generator.generators.stringtemplate.parserg4.STParser.MapTemplateRefContext arg) {
		System.out.println("MapTemplateRef");
		final Node node = model.findOrCreate(Label.label("MapTemplateRef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIncludeExpr(com.generator.generators.stringtemplate.parserg4.STParser.IncludeExprContext arg) {
		System.out.println("IncludeExpr");
		final Node node = model.findOrCreate(Label.label("IncludeExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgExprList(com.generator.generators.stringtemplate.parserg4.STParser.ArgExprListContext arg) {
		System.out.println("ArgExprList");
		final Node node = model.findOrCreate(Label.label("ArgExprList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamedArg(com.generator.generators.stringtemplate.parserg4.STParser.NamedArgContext arg) {
		System.out.println("NamedArg");
		final Node node = model.findOrCreate(Label.label("NamedArg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOption(com.generator.generators.stringtemplate.parserg4.STParser.OptionContext arg) {
		System.out.println("Option");
		final Node node = model.findOrCreate(Label.label("Option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElement(com.generator.generators.stringtemplate.parserg4.STParser.ElementContext arg) {
		System.out.println("Element");
		final Node node = model.findOrCreate(Label.label("Element"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitList(com.generator.generators.stringtemplate.parserg4.STParser.ListContext arg) {
		System.out.println("List");
		final Node node = model.findOrCreate(Label.label("List"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.stringtemplate.parserg4.STParser.ExprContext arg) {
		System.out.println("Expr");
		final Node node = model.findOrCreate(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimary(com.generator.generators.stringtemplate.parserg4.STParser.PrimaryContext arg) {
		System.out.println("Primary");
		final Node node = model.findOrCreate(Label.label("Primary"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgs(com.generator.generators.stringtemplate.parserg4.STParser.ArgsContext arg) {
		System.out.println("Args");
		final Node node = model.findOrCreate(Label.label("Args"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}