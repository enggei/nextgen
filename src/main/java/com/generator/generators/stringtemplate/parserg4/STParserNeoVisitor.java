package com.generator.generators.stringtemplate.parserg4;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class STParserNeoVisitor extends STParserBaseVisitor<Node> {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(STParserNeoVisitor.class);

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
	public Node visitArgs(com.generator.generators.stringtemplate.parserg4.STParser.ArgsContext arg) {
		log.info("Args");
		final Node node = model.newNode(Label.label("Args"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOption(com.generator.generators.stringtemplate.parserg4.STParser.OptionContext arg) {
		log.info("Option");
		final Node node = model.newNode(Label.label("Option"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElement(com.generator.generators.stringtemplate.parserg4.STParser.ElementContext arg) {
		log.info("Element");
		final Node node = model.newNode(Label.label("Element"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitList(com.generator.generators.stringtemplate.parserg4.STParser.ListContext arg) {
		log.info("List");
		final Node node = model.newNode(Label.label("List"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.stringtemplate.parserg4.STParser.ExprContext arg) {
		log.info("Expr");
		final Node node = model.newNode(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrimary(com.generator.generators.stringtemplate.parserg4.STParser.PrimaryContext arg) {
		log.info("Primary");
		final Node node = model.newNode(Label.label("Primary"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplate(com.generator.generators.stringtemplate.parserg4.STParser.TemplateContext arg) {
		log.info("Template");
		final Node node = model.newNode(Label.label("Template"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElements(com.generator.generators.stringtemplate.parserg4.STParser.ElementsContext arg) {
		log.info("Elements");
		final Node node = model.newNode(Label.label("Elements"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSingleElement(com.generator.generators.stringtemplate.parserg4.STParser.SingleElementContext arg) {
		log.info("SingleElement");
		final Node node = model.newNode(Label.label("SingleElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompoundElement(com.generator.generators.stringtemplate.parserg4.STParser.CompoundElementContext arg) {
		log.info("CompoundElement");
		final Node node = model.newNode(Label.label("CompoundElement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprTag(com.generator.generators.stringtemplate.parserg4.STParser.ExprTagContext arg) {
		log.info("ExprTag");
		final Node node = model.newNode(Label.label("ExprTag"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRegion(com.generator.generators.stringtemplate.parserg4.STParser.RegionContext arg) {
		log.info("Region");
		final Node node = model.newNode(Label.label("Region"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSubtemplate(com.generator.generators.stringtemplate.parserg4.STParser.SubtemplateContext arg) {
		log.info("Subtemplate");
		final Node node = model.newNode(Label.label("Subtemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIfstat(com.generator.generators.stringtemplate.parserg4.STParser.IfstatContext arg) {
		log.info("Ifstat");
		final Node node = model.newNode(Label.label("Ifstat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConditional(com.generator.generators.stringtemplate.parserg4.STParser.ConditionalContext arg) {
		log.info("Conditional");
		final Node node = model.newNode(Label.label("Conditional"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAndConditional(com.generator.generators.stringtemplate.parserg4.STParser.AndConditionalContext arg) {
		log.info("AndConditional");
		final Node node = model.newNode(Label.label("AndConditional"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotConditional(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalContext arg) {
		log.info("NotConditional");
		final Node node = model.newNode(Label.label("NotConditional"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotConditionalExpr(com.generator.generators.stringtemplate.parserg4.STParser.NotConditionalExprContext arg) {
		log.info("NotConditionalExpr");
		final Node node = model.newNode(Label.label("NotConditionalExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprOptions(com.generator.generators.stringtemplate.parserg4.STParser.ExprOptionsContext arg) {
		log.info("ExprOptions");
		final Node node = model.newNode(Label.label("ExprOptions"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapExpr(com.generator.generators.stringtemplate.parserg4.STParser.MapExprContext arg) {
		log.info("MapExpr");
		final Node node = model.newNode(Label.label("MapExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMemberExpr(com.generator.generators.stringtemplate.parserg4.STParser.MemberExprContext arg) {
		log.info("MemberExpr");
		final Node node = model.newNode(Label.label("MemberExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMapTemplateRef(com.generator.generators.stringtemplate.parserg4.STParser.MapTemplateRefContext arg) {
		log.info("MapTemplateRef");
		final Node node = model.newNode(Label.label("MapTemplateRef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIncludeExpr(com.generator.generators.stringtemplate.parserg4.STParser.IncludeExprContext arg) {
		log.info("IncludeExpr");
		final Node node = model.newNode(Label.label("IncludeExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgExprList(com.generator.generators.stringtemplate.parserg4.STParser.ArgExprListContext arg) {
		log.info("ArgExprList");
		final Node node = model.newNode(Label.label("ArgExprList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamedArg(com.generator.generators.stringtemplate.parserg4.STParser.NamedArgContext arg) {
		log.info("NamedArg");
		final Node node = model.newNode(Label.label("NamedArg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}