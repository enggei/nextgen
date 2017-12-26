package com.generator.generators.scala.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ScalaNeoVisitor extends ScalaBaseVisitor<Node> {

	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ScalaNeoVisitor.class);

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
	public Node visitBlock(com.generator.generators.scala.parser.ScalaParser.BlockContext arg) {
		log.info("Block");
		final Node node = model.newNode(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLiteral(com.generator.generators.scala.parser.ScalaParser.LiteralContext arg) {
		log.info("Literal");
		final Node node = model.newNode(Label.label("Literal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.scala.parser.ScalaParser.ExprContext arg) {
		log.info("Expr");
		final Node node = model.newNode(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern(com.generator.generators.scala.parser.ScalaParser.PatternContext arg) {
		log.info("Pattern");
		final Node node = model.newNode(Label.label("Pattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClauses(com.generator.generators.scala.parser.ScalaParser.CaseClausesContext arg) {
		log.info("CaseClauses");
		final Node node = model.newNode(Label.label("CaseClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCaseClause(com.generator.generators.scala.parser.ScalaParser.CaseClauseContext arg) {
		log.info("CaseClause");
		final Node node = model.newNode(Label.label("CaseClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitType(com.generator.generators.scala.parser.ScalaParser.TypeContext arg) {
		log.info("Type");
		final Node node = model.newNode(Label.label("Type"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotation(com.generator.generators.scala.parser.ScalaParser.AnnotationContext arg) {
		log.info("Annotation");
		final Node node = model.newNode(Label.label("Annotation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompilationUnit(com.generator.generators.scala.parser.ScalaParser.CompilationUnitContext arg) {
		log.info("CompilationUnit");
		final Node node = model.newNode(Label.label("CompilationUnit"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitModifier(com.generator.generators.scala.parser.ScalaParser.ModifierContext arg) {
		log.info("Modifier");
		final Node node = model.newNode(Label.label("Modifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassQualifier(com.generator.generators.scala.parser.ScalaParser.ClassQualifierContext arg) {
		log.info("ClassQualifier");
		final Node node = model.newNode(Label.label("ClassQualifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitQualId(com.generator.generators.scala.parser.ScalaParser.QualIdContext arg) {
		log.info("QualId");
		final Node node = model.newNode(Label.label("QualId"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIds(com.generator.generators.scala.parser.ScalaParser.IdsContext arg) {
		log.info("Ids");
		final Node node = model.newNode(Label.label("Ids"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStableId(com.generator.generators.scala.parser.ScalaParser.StableIdContext arg) {
		log.info("StableId");
		final Node node = model.newNode(Label.label("StableId"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionArgTypes(com.generator.generators.scala.parser.ScalaParser.FunctionArgTypesContext arg) {
		log.info("FunctionArgTypes");
		final Node node = model.newNode(Label.label("FunctionArgTypes"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExistentialClause(com.generator.generators.scala.parser.ScalaParser.ExistentialClauseContext arg) {
		log.info("ExistentialClause");
		final Node node = model.newNode(Label.label("ExistentialClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExistentialDcl(com.generator.generators.scala.parser.ScalaParser.ExistentialDclContext arg) {
		log.info("ExistentialDcl");
		final Node node = model.newNode(Label.label("ExistentialDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInfixType(com.generator.generators.scala.parser.ScalaParser.InfixTypeContext arg) {
		log.info("InfixType");
		final Node node = model.newNode(Label.label("InfixType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCompoundType(com.generator.generators.scala.parser.ScalaParser.CompoundTypeContext arg) {
		log.info("CompoundType");
		final Node node = model.newNode(Label.label("CompoundType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAnnotType(com.generator.generators.scala.parser.ScalaParser.AnnotTypeContext arg) {
		log.info("AnnotType");
		final Node node = model.newNode(Label.label("AnnotType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleType(com.generator.generators.scala.parser.ScalaParser.SimpleTypeContext arg) {
		log.info("SimpleType");
		final Node node = model.newNode(Label.label("SimpleType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeArgs(com.generator.generators.scala.parser.ScalaParser.TypeArgsContext arg) {
		log.info("TypeArgs");
		final Node node = model.newNode(Label.label("TypeArgs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypes(com.generator.generators.scala.parser.ScalaParser.TypesContext arg) {
		log.info("Types");
		final Node node = model.newNode(Label.label("Types"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRefinement(com.generator.generators.scala.parser.ScalaParser.RefinementContext arg) {
		log.info("Refinement");
		final Node node = model.newNode(Label.label("Refinement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRefineStat(com.generator.generators.scala.parser.ScalaParser.RefineStatContext arg) {
		log.info("RefineStat");
		final Node node = model.newNode(Label.label("RefineStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypePat(com.generator.generators.scala.parser.ScalaParser.TypePatContext arg) {
		log.info("TypePat");
		final Node node = model.newNode(Label.label("TypePat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAscription(com.generator.generators.scala.parser.ScalaParser.AscriptionContext arg) {
		log.info("Ascription");
		final Node node = model.newNode(Label.label("Ascription"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr1(com.generator.generators.scala.parser.ScalaParser.Expr1Context arg) {
		log.info("Expr1");
		final Node node = model.newNode(Label.label("Expr1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPostfixExpr(com.generator.generators.scala.parser.ScalaParser.PostfixExprContext arg) {
		log.info("PostfixExpr");
		final Node node = model.newNode(Label.label("PostfixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitInfixExpr(com.generator.generators.scala.parser.ScalaParser.InfixExprContext arg) {
		log.info("InfixExpr");
		final Node node = model.newNode(Label.label("InfixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrefixExpr(com.generator.generators.scala.parser.ScalaParser.PrefixExprContext arg) {
		log.info("PrefixExpr");
		final Node node = model.newNode(Label.label("PrefixExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr(com.generator.generators.scala.parser.ScalaParser.SimpleExprContext arg) {
		log.info("SimpleExpr");
		final Node node = model.newNode(Label.label("SimpleExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr1(com.generator.generators.scala.parser.ScalaParser.SimpleExpr1Context arg) {
		log.info("SimpleExpr1");
		final Node node = model.newNode(Label.label("SimpleExpr1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleExpr2(com.generator.generators.scala.parser.ScalaParser.SimpleExpr2Context arg) {
		log.info("SimpleExpr2");
		final Node node = model.newNode(Label.label("SimpleExpr2"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExprs(com.generator.generators.scala.parser.ScalaParser.ExprsContext arg) {
		log.info("Exprs");
		final Node node = model.newNode(Label.label("Exprs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgumentExprs(com.generator.generators.scala.parser.ScalaParser.ArgumentExprsContext arg) {
		log.info("ArgumentExprs");
		final Node node = model.newNode(Label.label("ArgumentExprs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockExpr(com.generator.generators.scala.parser.ScalaParser.BlockExprContext arg) {
		log.info("BlockExpr");
		final Node node = model.newNode(Label.label("BlockExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockStat(com.generator.generators.scala.parser.ScalaParser.BlockStatContext arg) {
		log.info("BlockStat");
		final Node node = model.newNode(Label.label("BlockStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitResultExpr(com.generator.generators.scala.parser.ScalaParser.ResultExprContext arg) {
		log.info("ResultExpr");
		final Node node = model.newNode(Label.label("ResultExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEnumerators(com.generator.generators.scala.parser.ScalaParser.EnumeratorsContext arg) {
		log.info("Enumerators");
		final Node node = model.newNode(Label.label("Enumerators"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGenerator(com.generator.generators.scala.parser.ScalaParser.GeneratorContext arg) {
		log.info("Generator");
		final Node node = model.newNode(Label.label("Generator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGuard(com.generator.generators.scala.parser.ScalaParser.GuardContext arg) {
		log.info("Guard");
		final Node node = model.newNode(Label.label("Guard"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern1(com.generator.generators.scala.parser.ScalaParser.Pattern1Context arg) {
		log.info("Pattern1");
		final Node node = model.newNode(Label.label("Pattern1"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern2(com.generator.generators.scala.parser.ScalaParser.Pattern2Context arg) {
		log.info("Pattern2");
		final Node node = model.newNode(Label.label("Pattern2"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPattern3(com.generator.generators.scala.parser.ScalaParser.Pattern3Context arg) {
		log.info("Pattern3");
		final Node node = model.newNode(Label.label("Pattern3"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimplePattern(com.generator.generators.scala.parser.ScalaParser.SimplePatternContext arg) {
		log.info("SimplePattern");
		final Node node = model.newNode(Label.label("SimplePattern"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatterns(com.generator.generators.scala.parser.ScalaParser.PatternsContext arg) {
		log.info("Patterns");
		final Node node = model.newNode(Label.label("Patterns"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParamClause(com.generator.generators.scala.parser.ScalaParser.TypeParamClauseContext arg) {
		log.info("TypeParamClause");
		final Node node = model.newNode(Label.label("TypeParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunTypeParamClause(com.generator.generators.scala.parser.ScalaParser.FunTypeParamClauseContext arg) {
		log.info("FunTypeParamClause");
		final Node node = model.newNode(Label.label("FunTypeParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVariantTypeParam(com.generator.generators.scala.parser.ScalaParser.VariantTypeParamContext arg) {
		log.info("VariantTypeParam");
		final Node node = model.newNode(Label.label("VariantTypeParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeParam(com.generator.generators.scala.parser.ScalaParser.TypeParamContext arg) {
		log.info("TypeParam");
		final Node node = model.newNode(Label.label("TypeParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamClauses(com.generator.generators.scala.parser.ScalaParser.ParamClausesContext arg) {
		log.info("ParamClauses");
		final Node node = model.newNode(Label.label("ParamClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamClause(com.generator.generators.scala.parser.ScalaParser.ParamClauseContext arg) {
		log.info("ParamClause");
		final Node node = model.newNode(Label.label("ParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParams(com.generator.generators.scala.parser.ScalaParser.ParamsContext arg) {
		log.info("Params");
		final Node node = model.newNode(Label.label("Params"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParam(com.generator.generators.scala.parser.ScalaParser.ParamContext arg) {
		log.info("Param");
		final Node node = model.newNode(Label.label("Param"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParamType(com.generator.generators.scala.parser.ScalaParser.ParamTypeContext arg) {
		log.info("ParamType");
		final Node node = model.newNode(Label.label("ParamType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParamClauses(com.generator.generators.scala.parser.ScalaParser.ClassParamClausesContext arg) {
		log.info("ClassParamClauses");
		final Node node = model.newNode(Label.label("ClassParamClauses"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParamClause(com.generator.generators.scala.parser.ScalaParser.ClassParamClauseContext arg) {
		log.info("ClassParamClause");
		final Node node = model.newNode(Label.label("ClassParamClause"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParams(com.generator.generators.scala.parser.ScalaParser.ClassParamsContext arg) {
		log.info("ClassParams");
		final Node node = model.newNode(Label.label("ClassParams"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParam(com.generator.generators.scala.parser.ScalaParser.ClassParamContext arg) {
		log.info("ClassParam");
		final Node node = model.newNode(Label.label("ClassParam"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBindings(com.generator.generators.scala.parser.ScalaParser.BindingsContext arg) {
		log.info("Bindings");
		final Node node = model.newNode(Label.label("Bindings"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBinding(com.generator.generators.scala.parser.ScalaParser.BindingContext arg) {
		log.info("Binding");
		final Node node = model.newNode(Label.label("Binding"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLocalModifier(com.generator.generators.scala.parser.ScalaParser.LocalModifierContext arg) {
		log.info("LocalModifier");
		final Node node = model.newNode(Label.label("LocalModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAccessModifier(com.generator.generators.scala.parser.ScalaParser.AccessModifierContext arg) {
		log.info("AccessModifier");
		final Node node = model.newNode(Label.label("AccessModifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAccessQualifier(com.generator.generators.scala.parser.ScalaParser.AccessQualifierContext arg) {
		log.info("AccessQualifier");
		final Node node = model.newNode(Label.label("AccessQualifier"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrAnnotation(com.generator.generators.scala.parser.ScalaParser.ConstrAnnotationContext arg) {
		log.info("ConstrAnnotation");
		final Node node = model.newNode(Label.label("ConstrAnnotation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateBody(com.generator.generators.scala.parser.ScalaParser.TemplateBodyContext arg) {
		log.info("TemplateBody");
		final Node node = model.newNode(Label.label("TemplateBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTemplateStat(com.generator.generators.scala.parser.ScalaParser.TemplateStatContext arg) {
		log.info("TemplateStat");
		final Node node = model.newNode(Label.label("TemplateStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelfType(com.generator.generators.scala.parser.ScalaParser.SelfTypeContext arg) {
		log.info("SelfType");
		final Node node = model.newNode(Label.label("SelfType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImport_(com.generator.generators.scala.parser.ScalaParser.Import_Context arg) {
		log.info("Import_");
		final Node node = model.newNode(Label.label("Import_"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportExpr(com.generator.generators.scala.parser.ScalaParser.ImportExprContext arg) {
		log.info("ImportExpr");
		final Node node = model.newNode(Label.label("ImportExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSelectors(com.generator.generators.scala.parser.ScalaParser.ImportSelectorsContext arg) {
		log.info("ImportSelectors");
		final Node node = model.newNode(Label.label("ImportSelectors"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitImportSelector(com.generator.generators.scala.parser.ScalaParser.ImportSelectorContext arg) {
		log.info("ImportSelector");
		final Node node = model.newNode(Label.label("ImportSelector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDcl(com.generator.generators.scala.parser.ScalaParser.DclContext arg) {
		log.info("Dcl");
		final Node node = model.newNode(Label.label("Dcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValDcl(com.generator.generators.scala.parser.ScalaParser.ValDclContext arg) {
		log.info("ValDcl");
		final Node node = model.newNode(Label.label("ValDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDcl(com.generator.generators.scala.parser.ScalaParser.VarDclContext arg) {
		log.info("VarDcl");
		final Node node = model.newNode(Label.label("VarDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunDcl(com.generator.generators.scala.parser.ScalaParser.FunDclContext arg) {
		log.info("FunDcl");
		final Node node = model.newNode(Label.label("FunDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunSig(com.generator.generators.scala.parser.ScalaParser.FunSigContext arg) {
		log.info("FunSig");
		final Node node = model.newNode(Label.label("FunSig"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDcl(com.generator.generators.scala.parser.ScalaParser.TypeDclContext arg) {
		log.info("TypeDcl");
		final Node node = model.newNode(Label.label("TypeDcl"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatVarDef(com.generator.generators.scala.parser.ScalaParser.PatVarDefContext arg) {
		log.info("PatVarDef");
		final Node node = model.newNode(Label.label("PatVarDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDef(com.generator.generators.scala.parser.ScalaParser.DefContext arg) {
		log.info("Def");
		final Node node = model.newNode(Label.label("Def"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPatDef(com.generator.generators.scala.parser.ScalaParser.PatDefContext arg) {
		log.info("PatDef");
		final Node node = model.newNode(Label.label("PatDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVarDef(com.generator.generators.scala.parser.ScalaParser.VarDefContext arg) {
		log.info("VarDef");
		final Node node = model.newNode(Label.label("VarDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunDef(com.generator.generators.scala.parser.ScalaParser.FunDefContext arg) {
		log.info("FunDef");
		final Node node = model.newNode(Label.label("FunDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeDef(com.generator.generators.scala.parser.ScalaParser.TypeDefContext arg) {
		log.info("TypeDef");
		final Node node = model.newNode(Label.label("TypeDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTmplDef(com.generator.generators.scala.parser.ScalaParser.TmplDefContext arg) {
		log.info("TmplDef");
		final Node node = model.newNode(Label.label("TmplDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassDef(com.generator.generators.scala.parser.ScalaParser.ClassDefContext arg) {
		log.info("ClassDef");
		final Node node = model.newNode(Label.label("ClassDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitDef(com.generator.generators.scala.parser.ScalaParser.TraitDefContext arg) {
		log.info("TraitDef");
		final Node node = model.newNode(Label.label("TraitDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitObjectDef(com.generator.generators.scala.parser.ScalaParser.ObjectDefContext arg) {
		log.info("ObjectDef");
		final Node node = model.newNode(Label.label("ObjectDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassTemplateOpt(com.generator.generators.scala.parser.ScalaParser.ClassTemplateOptContext arg) {
		log.info("ClassTemplateOpt");
		final Node node = model.newNode(Label.label("ClassTemplateOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitTemplateOpt(com.generator.generators.scala.parser.ScalaParser.TraitTemplateOptContext arg) {
		log.info("TraitTemplateOpt");
		final Node node = model.newNode(Label.label("TraitTemplateOpt"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassTemplate(com.generator.generators.scala.parser.ScalaParser.ClassTemplateContext arg) {
		log.info("ClassTemplate");
		final Node node = model.newNode(Label.label("ClassTemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitTemplate(com.generator.generators.scala.parser.ScalaParser.TraitTemplateContext arg) {
		log.info("TraitTemplate");
		final Node node = model.newNode(Label.label("TraitTemplate"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassParents(com.generator.generators.scala.parser.ScalaParser.ClassParentsContext arg) {
		log.info("ClassParents");
		final Node node = model.newNode(Label.label("ClassParents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTraitParents(com.generator.generators.scala.parser.ScalaParser.TraitParentsContext arg) {
		log.info("TraitParents");
		final Node node = model.newNode(Label.label("TraitParents"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstr(com.generator.generators.scala.parser.ScalaParser.ConstrContext arg) {
		log.info("Constr");
		final Node node = model.newNode(Label.label("Constr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEarlyDefs(com.generator.generators.scala.parser.ScalaParser.EarlyDefsContext arg) {
		log.info("EarlyDefs");
		final Node node = model.newNode(Label.label("EarlyDefs"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEarlyDef(com.generator.generators.scala.parser.ScalaParser.EarlyDefContext arg) {
		log.info("EarlyDef");
		final Node node = model.newNode(Label.label("EarlyDef"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrExpr(com.generator.generators.scala.parser.ScalaParser.ConstrExprContext arg) {
		log.info("ConstrExpr");
		final Node node = model.newNode(Label.label("ConstrExpr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitConstrBlock(com.generator.generators.scala.parser.ScalaParser.ConstrBlockContext arg) {
		log.info("ConstrBlock");
		final Node node = model.newNode(Label.label("ConstrBlock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelfInvocation(com.generator.generators.scala.parser.ScalaParser.SelfInvocationContext arg) {
		log.info("SelfInvocation");
		final Node node = model.newNode(Label.label("SelfInvocation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopStatSeq(com.generator.generators.scala.parser.ScalaParser.TopStatSeqContext arg) {
		log.info("TopStatSeq");
		final Node node = model.newNode(Label.label("TopStatSeq"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTopStat(com.generator.generators.scala.parser.ScalaParser.TopStatContext arg) {
		log.info("TopStat");
		final Node node = model.newNode(Label.label("TopStat"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackaging(com.generator.generators.scala.parser.ScalaParser.PackagingContext arg) {
		log.info("Packaging");
		final Node node = model.newNode(Label.label("Packaging"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPackageObject(com.generator.generators.scala.parser.ScalaParser.PackageObjectContext arg) {
		log.info("PackageObject");
		final Node node = model.newNode(Label.label("PackageObject"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}