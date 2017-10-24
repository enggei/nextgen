package com.generator.generators.scala.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ScalaNeoVisitor extends ScalaBaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public ScalaNeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitIds(com.generator.generators.scala.parser.ScalaParser.IdsContext arg) {
		System.out.println("Ids");
		final Node node = model.newNode(Label.label("Ids"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.scala.parser.ScalaParser.LiteralContext arg) {
		System.out.println("Literal");
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualId(com.generator.generators.scala.parser.ScalaParser.QualIdContext arg) {
		System.out.println("QualId");
		final Node node = model.newNode(Label.label("QualId"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStableId(com.generator.generators.scala.parser.ScalaParser.StableIdContext arg) {
		System.out.println("StableId");
		final Node node = model.newNode(Label.label("StableId"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassQualifier(com.generator.generators.scala.parser.ScalaParser.ClassQualifierContext arg) {
		System.out.println("ClassQualifier");
		final Node node = model.newNode(Label.label("ClassQualifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitType(com.generator.generators.scala.parser.ScalaParser.TypeContext arg) {
		System.out.println("Type");
		final Node node = model.newNode(Label.label("Type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionArgTypes(com.generator.generators.scala.parser.ScalaParser.FunctionArgTypesContext arg) {
		System.out.println("FunctionArgTypes");
		final Node node = model.newNode(Label.label("FunctionArgTypes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExistentialClause(com.generator.generators.scala.parser.ScalaParser.ExistentialClauseContext arg) {
		System.out.println("ExistentialClause");
		final Node node = model.newNode(Label.label("ExistentialClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExistentialDcl(com.generator.generators.scala.parser.ScalaParser.ExistentialDclContext arg) {
		System.out.println("ExistentialDcl");
		final Node node = model.newNode(Label.label("ExistentialDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInfixType(com.generator.generators.scala.parser.ScalaParser.InfixTypeContext arg) {
		System.out.println("InfixType");
		final Node node = model.newNode(Label.label("InfixType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompoundType(com.generator.generators.scala.parser.ScalaParser.CompoundTypeContext arg) {
		System.out.println("CompoundType");
		final Node node = model.newNode(Label.label("CompoundType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotType(com.generator.generators.scala.parser.ScalaParser.AnnotTypeContext arg) {
		System.out.println("AnnotType");
		final Node node = model.newNode(Label.label("AnnotType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleType(com.generator.generators.scala.parser.ScalaParser.SimpleTypeContext arg) {
		System.out.println("SimpleType");
		final Node node = model.newNode(Label.label("SimpleType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArgs(com.generator.generators.scala.parser.ScalaParser.TypeArgsContext arg) {
		System.out.println("TypeArgs");
		final Node node = model.newNode(Label.label("TypeArgs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypes(com.generator.generators.scala.parser.ScalaParser.TypesContext arg) {
		System.out.println("Types");
		final Node node = model.newNode(Label.label("Types"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRefinement(com.generator.generators.scala.parser.ScalaParser.RefinementContext arg) {
		System.out.println("Refinement");
		final Node node = model.newNode(Label.label("Refinement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRefineStat(com.generator.generators.scala.parser.ScalaParser.RefineStatContext arg) {
		System.out.println("RefineStat");
		final Node node = model.newNode(Label.label("RefineStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypePat(com.generator.generators.scala.parser.ScalaParser.TypePatContext arg) {
		System.out.println("TypePat");
		final Node node = model.newNode(Label.label("TypePat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAscription(com.generator.generators.scala.parser.ScalaParser.AscriptionContext arg) {
		System.out.println("Ascription");
		final Node node = model.newNode(Label.label("Ascription"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.scala.parser.ScalaParser.ExprContext arg) {
		System.out.println("Expr");
		final Node node = model.newNode(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr1(com.generator.generators.scala.parser.ScalaParser.Expr1Context arg) {
		System.out.println("Expr1");
		final Node node = model.newNode(Label.label("Expr1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPostfixExpr(com.generator.generators.scala.parser.ScalaParser.PostfixExprContext arg) {
		System.out.println("PostfixExpr");
		final Node node = model.newNode(Label.label("PostfixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInfixExpr(com.generator.generators.scala.parser.ScalaParser.InfixExprContext arg) {
		System.out.println("InfixExpr");
		final Node node = model.newNode(Label.label("InfixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixExpr(com.generator.generators.scala.parser.ScalaParser.PrefixExprContext arg) {
		System.out.println("PrefixExpr");
		final Node node = model.newNode(Label.label("PrefixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr(com.generator.generators.scala.parser.ScalaParser.SimpleExprContext arg) {
		System.out.println("SimpleExpr");
		final Node node = model.newNode(Label.label("SimpleExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr1(com.generator.generators.scala.parser.ScalaParser.SimpleExpr1Context arg) {
		System.out.println("SimpleExpr1");
		final Node node = model.newNode(Label.label("SimpleExpr1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr2(com.generator.generators.scala.parser.ScalaParser.SimpleExpr2Context arg) {
		System.out.println("SimpleExpr2");
		final Node node = model.newNode(Label.label("SimpleExpr2"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprs(com.generator.generators.scala.parser.ScalaParser.ExprsContext arg) {
		System.out.println("Exprs");
		final Node node = model.newNode(Label.label("Exprs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgumentExprs(com.generator.generators.scala.parser.ScalaParser.ArgumentExprsContext arg) {
		System.out.println("ArgumentExprs");
		final Node node = model.newNode(Label.label("ArgumentExprs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockExpr(com.generator.generators.scala.parser.ScalaParser.BlockExprContext arg) {
		System.out.println("BlockExpr");
		final Node node = model.newNode(Label.label("BlockExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock(com.generator.generators.scala.parser.ScalaParser.BlockContext arg) {
		System.out.println("Block");
		final Node node = model.newNode(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockStat(com.generator.generators.scala.parser.ScalaParser.BlockStatContext arg) {
		System.out.println("BlockStat");
		final Node node = model.newNode(Label.label("BlockStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResultExpr(com.generator.generators.scala.parser.ScalaParser.ResultExprContext arg) {
		System.out.println("ResultExpr");
		final Node node = model.newNode(Label.label("ResultExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumerators(com.generator.generators.scala.parser.ScalaParser.EnumeratorsContext arg) {
		System.out.println("Enumerators");
		final Node node = model.newNode(Label.label("Enumerators"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenerator(com.generator.generators.scala.parser.ScalaParser.GeneratorContext arg) {
		System.out.println("Generator");
		final Node node = model.newNode(Label.label("Generator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClauses(com.generator.generators.scala.parser.ScalaParser.CaseClausesContext arg) {
		System.out.println("CaseClauses");
		final Node node = model.newNode(Label.label("CaseClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClause(com.generator.generators.scala.parser.ScalaParser.CaseClauseContext arg) {
		System.out.println("CaseClause");
		final Node node = model.newNode(Label.label("CaseClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGuard(com.generator.generators.scala.parser.ScalaParser.GuardContext arg) {
		System.out.println("Guard");
		final Node node = model.newNode(Label.label("Guard"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern(com.generator.generators.scala.parser.ScalaParser.PatternContext arg) {
		System.out.println("Pattern");
		final Node node = model.newNode(Label.label("Pattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern1(com.generator.generators.scala.parser.ScalaParser.Pattern1Context arg) {
		System.out.println("Pattern1");
		final Node node = model.newNode(Label.label("Pattern1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern2(com.generator.generators.scala.parser.ScalaParser.Pattern2Context arg) {
		System.out.println("Pattern2");
		final Node node = model.newNode(Label.label("Pattern2"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern3(com.generator.generators.scala.parser.ScalaParser.Pattern3Context arg) {
		System.out.println("Pattern3");
		final Node node = model.newNode(Label.label("Pattern3"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimplePattern(com.generator.generators.scala.parser.ScalaParser.SimplePatternContext arg) {
		System.out.println("SimplePattern");
		final Node node = model.newNode(Label.label("SimplePattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatterns(com.generator.generators.scala.parser.ScalaParser.PatternsContext arg) {
		System.out.println("Patterns");
		final Node node = model.newNode(Label.label("Patterns"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParamClause(com.generator.generators.scala.parser.ScalaParser.TypeParamClauseContext arg) {
		System.out.println("TypeParamClause");
		final Node node = model.newNode(Label.label("TypeParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunTypeParamClause(com.generator.generators.scala.parser.ScalaParser.FunTypeParamClauseContext arg) {
		System.out.println("FunTypeParamClause");
		final Node node = model.newNode(Label.label("FunTypeParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariantTypeParam(com.generator.generators.scala.parser.ScalaParser.VariantTypeParamContext arg) {
		System.out.println("VariantTypeParam");
		final Node node = model.newNode(Label.label("VariantTypeParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParam(com.generator.generators.scala.parser.ScalaParser.TypeParamContext arg) {
		System.out.println("TypeParam");
		final Node node = model.newNode(Label.label("TypeParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamClauses(com.generator.generators.scala.parser.ScalaParser.ParamClausesContext arg) {
		System.out.println("ParamClauses");
		final Node node = model.newNode(Label.label("ParamClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamClause(com.generator.generators.scala.parser.ScalaParser.ParamClauseContext arg) {
		System.out.println("ParamClause");
		final Node node = model.newNode(Label.label("ParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParams(com.generator.generators.scala.parser.ScalaParser.ParamsContext arg) {
		System.out.println("Params");
		final Node node = model.newNode(Label.label("Params"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParam(com.generator.generators.scala.parser.ScalaParser.ParamContext arg) {
		System.out.println("Param");
		final Node node = model.newNode(Label.label("Param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamType(com.generator.generators.scala.parser.ScalaParser.ParamTypeContext arg) {
		System.out.println("ParamType");
		final Node node = model.newNode(Label.label("ParamType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParamClauses(com.generator.generators.scala.parser.ScalaParser.ClassParamClausesContext arg) {
		System.out.println("ClassParamClauses");
		final Node node = model.newNode(Label.label("ClassParamClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParamClause(com.generator.generators.scala.parser.ScalaParser.ClassParamClauseContext arg) {
		System.out.println("ClassParamClause");
		final Node node = model.newNode(Label.label("ClassParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParams(com.generator.generators.scala.parser.ScalaParser.ClassParamsContext arg) {
		System.out.println("ClassParams");
		final Node node = model.newNode(Label.label("ClassParams"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParam(com.generator.generators.scala.parser.ScalaParser.ClassParamContext arg) {
		System.out.println("ClassParam");
		final Node node = model.newNode(Label.label("ClassParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBindings(com.generator.generators.scala.parser.ScalaParser.BindingsContext arg) {
		System.out.println("Bindings");
		final Node node = model.newNode(Label.label("Bindings"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinding(com.generator.generators.scala.parser.ScalaParser.BindingContext arg) {
		System.out.println("Binding");
		final Node node = model.newNode(Label.label("Binding"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitModifier(com.generator.generators.scala.parser.ScalaParser.ModifierContext arg) {
		System.out.println("Modifier");
		final Node node = model.newNode(Label.label("Modifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLocalModifier(com.generator.generators.scala.parser.ScalaParser.LocalModifierContext arg) {
		System.out.println("LocalModifier");
		final Node node = model.newNode(Label.label("LocalModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAccessModifier(com.generator.generators.scala.parser.ScalaParser.AccessModifierContext arg) {
		System.out.println("AccessModifier");
		final Node node = model.newNode(Label.label("AccessModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAccessQualifier(com.generator.generators.scala.parser.ScalaParser.AccessQualifierContext arg) {
		System.out.println("AccessQualifier");
		final Node node = model.newNode(Label.label("AccessQualifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotation(com.generator.generators.scala.parser.ScalaParser.AnnotationContext arg) {
		System.out.println("Annotation");
		final Node node = model.newNode(Label.label("Annotation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrAnnotation(com.generator.generators.scala.parser.ScalaParser.ConstrAnnotationContext arg) {
		System.out.println("ConstrAnnotation");
		final Node node = model.newNode(Label.label("ConstrAnnotation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateBody(com.generator.generators.scala.parser.ScalaParser.TemplateBodyContext arg) {
		System.out.println("TemplateBody");
		final Node node = model.newNode(Label.label("TemplateBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateStat(com.generator.generators.scala.parser.ScalaParser.TemplateStatContext arg) {
		System.out.println("TemplateStat");
		final Node node = model.newNode(Label.label("TemplateStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelfType(com.generator.generators.scala.parser.ScalaParser.SelfTypeContext arg) {
		System.out.println("SelfType");
		final Node node = model.newNode(Label.label("SelfType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_(com.generator.generators.scala.parser.ScalaParser.Import_Context arg) {
		System.out.println("Import_");
		final Node node = model.newNode(Label.label("Import_"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportExpr(com.generator.generators.scala.parser.ScalaParser.ImportExprContext arg) {
		System.out.println("ImportExpr");
		final Node node = model.newNode(Label.label("ImportExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSelectors(com.generator.generators.scala.parser.ScalaParser.ImportSelectorsContext arg) {
		System.out.println("ImportSelectors");
		final Node node = model.newNode(Label.label("ImportSelectors"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSelector(com.generator.generators.scala.parser.ScalaParser.ImportSelectorContext arg) {
		System.out.println("ImportSelector");
		final Node node = model.newNode(Label.label("ImportSelector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDcl(com.generator.generators.scala.parser.ScalaParser.DclContext arg) {
		System.out.println("Dcl");
		final Node node = model.newNode(Label.label("Dcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValDcl(com.generator.generators.scala.parser.ScalaParser.ValDclContext arg) {
		System.out.println("ValDcl");
		final Node node = model.newNode(Label.label("ValDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDcl(com.generator.generators.scala.parser.ScalaParser.VarDclContext arg) {
		System.out.println("VarDcl");
		final Node node = model.newNode(Label.label("VarDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunDcl(com.generator.generators.scala.parser.ScalaParser.FunDclContext arg) {
		System.out.println("FunDcl");
		final Node node = model.newNode(Label.label("FunDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunSig(com.generator.generators.scala.parser.ScalaParser.FunSigContext arg) {
		System.out.println("FunSig");
		final Node node = model.newNode(Label.label("FunSig"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDcl(com.generator.generators.scala.parser.ScalaParser.TypeDclContext arg) {
		System.out.println("TypeDcl");
		final Node node = model.newNode(Label.label("TypeDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatVarDef(com.generator.generators.scala.parser.ScalaParser.PatVarDefContext arg) {
		System.out.println("PatVarDef");
		final Node node = model.newNode(Label.label("PatVarDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDef(com.generator.generators.scala.parser.ScalaParser.DefContext arg) {
		System.out.println("Def");
		final Node node = model.newNode(Label.label("Def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatDef(com.generator.generators.scala.parser.ScalaParser.PatDefContext arg) {
		System.out.println("PatDef");
		final Node node = model.newNode(Label.label("PatDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDef(com.generator.generators.scala.parser.ScalaParser.VarDefContext arg) {
		System.out.println("VarDef");
		final Node node = model.newNode(Label.label("VarDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunDef(com.generator.generators.scala.parser.ScalaParser.FunDefContext arg) {
		System.out.println("FunDef");
		final Node node = model.newNode(Label.label("FunDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDef(com.generator.generators.scala.parser.ScalaParser.TypeDefContext arg) {
		System.out.println("TypeDef");
		final Node node = model.newNode(Label.label("TypeDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTmplDef(com.generator.generators.scala.parser.ScalaParser.TmplDefContext arg) {
		System.out.println("TmplDef");
		final Node node = model.newNode(Label.label("TmplDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassDef(com.generator.generators.scala.parser.ScalaParser.ClassDefContext arg) {
		System.out.println("ClassDef");
		final Node node = model.newNode(Label.label("ClassDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitDef(com.generator.generators.scala.parser.ScalaParser.TraitDefContext arg) {
		System.out.println("TraitDef");
		final Node node = model.newNode(Label.label("TraitDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectDef(com.generator.generators.scala.parser.ScalaParser.ObjectDefContext arg) {
		System.out.println("ObjectDef");
		final Node node = model.newNode(Label.label("ObjectDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassTemplateOpt(com.generator.generators.scala.parser.ScalaParser.ClassTemplateOptContext arg) {
		System.out.println("ClassTemplateOpt");
		final Node node = model.newNode(Label.label("ClassTemplateOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitTemplateOpt(com.generator.generators.scala.parser.ScalaParser.TraitTemplateOptContext arg) {
		System.out.println("TraitTemplateOpt");
		final Node node = model.newNode(Label.label("TraitTemplateOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassTemplate(com.generator.generators.scala.parser.ScalaParser.ClassTemplateContext arg) {
		System.out.println("ClassTemplate");
		final Node node = model.newNode(Label.label("ClassTemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitTemplate(com.generator.generators.scala.parser.ScalaParser.TraitTemplateContext arg) {
		System.out.println("TraitTemplate");
		final Node node = model.newNode(Label.label("TraitTemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParents(com.generator.generators.scala.parser.ScalaParser.ClassParentsContext arg) {
		System.out.println("ClassParents");
		final Node node = model.newNode(Label.label("ClassParents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitParents(com.generator.generators.scala.parser.ScalaParser.TraitParentsContext arg) {
		System.out.println("TraitParents");
		final Node node = model.newNode(Label.label("TraitParents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstr(com.generator.generators.scala.parser.ScalaParser.ConstrContext arg) {
		System.out.println("Constr");
		final Node node = model.newNode(Label.label("Constr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEarlyDefs(com.generator.generators.scala.parser.ScalaParser.EarlyDefsContext arg) {
		System.out.println("EarlyDefs");
		final Node node = model.newNode(Label.label("EarlyDefs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEarlyDef(com.generator.generators.scala.parser.ScalaParser.EarlyDefContext arg) {
		System.out.println("EarlyDef");
		final Node node = model.newNode(Label.label("EarlyDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrExpr(com.generator.generators.scala.parser.ScalaParser.ConstrExprContext arg) {
		System.out.println("ConstrExpr");
		final Node node = model.newNode(Label.label("ConstrExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrBlock(com.generator.generators.scala.parser.ScalaParser.ConstrBlockContext arg) {
		System.out.println("ConstrBlock");
		final Node node = model.newNode(Label.label("ConstrBlock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelfInvocation(com.generator.generators.scala.parser.ScalaParser.SelfInvocationContext arg) {
		System.out.println("SelfInvocation");
		final Node node = model.newNode(Label.label("SelfInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopStatSeq(com.generator.generators.scala.parser.ScalaParser.TopStatSeqContext arg) {
		System.out.println("TopStatSeq");
		final Node node = model.newNode(Label.label("TopStatSeq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopStat(com.generator.generators.scala.parser.ScalaParser.TopStatContext arg) {
		System.out.println("TopStat");
		final Node node = model.newNode(Label.label("TopStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackaging(com.generator.generators.scala.parser.ScalaParser.PackagingContext arg) {
		System.out.println("Packaging");
		final Node node = model.newNode(Label.label("Packaging"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageObject(com.generator.generators.scala.parser.ScalaParser.PackageObjectContext arg) {
		System.out.println("PackageObject");
		final Node node = model.newNode(Label.label("PackageObject"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompilationUnit(com.generator.generators.scala.parser.ScalaParser.CompilationUnitContext arg) {
		System.out.println("CompilationUnit");
		final Node node = model.newNode(Label.label("CompilationUnit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}