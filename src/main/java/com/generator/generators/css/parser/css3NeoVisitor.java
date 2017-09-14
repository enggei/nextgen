package com.generator.generators.css.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class css3NeoVisitor extends css3BaseVisitor<Node> {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.NeoModel model;

	public css3NeoVisitor(com.generator.NeoModel model) {
		this.model = model;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty())
         com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
   }

   protected void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public Node visitBlock(com.generator.generators.css.parser.css3Parser.BlockContext arg) {
		System.out.println("Block");
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadImport(com.generator.generators.css.parser.css3Parser.BadImportContext arg) {
		System.out.println("BadImport");
		final Node node = model.findOrCreate(Label.label("BadImport"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMedia(com.generator.generators.css.parser.css3Parser.MediaContext arg) {
		System.out.println("Media");
		final Node node = model.findOrCreate(Label.label("Media"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.css.parser.css3Parser.ExpressionContext arg) {
		System.out.println("Expression");
		final Node node = model.findOrCreate(Label.label("Expression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.css.parser.css3Parser.NumberContext arg) {
		System.out.println("Number");
		final Node node = model.findOrCreate(Label.label("Number"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStylesheet(com.generator.generators.css.parser.css3Parser.StylesheetContext arg) {
		System.out.println("Stylesheet");
		final Node node = model.findOrCreate(Label.label("Stylesheet"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodCharset(com.generator.generators.css.parser.css3Parser.GoodCharsetContext arg) {
		System.out.println("GoodCharset");
		final Node node = model.findOrCreate(Label.label("GoodCharset"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodNamespace(com.generator.generators.css.parser.css3Parser.GoodNamespaceContext arg) {
		System.out.println("GoodNamespace");
		final Node node = model.findOrCreate(Label.label("GoodNamespace"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadNamespace(com.generator.generators.css.parser.css3Parser.BadNamespaceContext arg) {
		System.out.println("BadNamespace");
		final Node node = model.findOrCreate(Label.label("BadNamespace"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespacePrefix(com.generator.generators.css.parser.css3Parser.NamespacePrefixContext arg) {
		System.out.println("NamespacePrefix");
		final Node node = model.findOrCreate(Label.label("NamespacePrefix"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaQueryList(com.generator.generators.css.parser.css3Parser.MediaQueryListContext arg) {
		System.out.println("MediaQueryList");
		final Node node = model.findOrCreate(Label.label("MediaQueryList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaQuery(com.generator.generators.css.parser.css3Parser.MediaQueryContext arg) {
		System.out.println("MediaQuery");
		final Node node = model.findOrCreate(Label.label("MediaQuery"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaType(com.generator.generators.css.parser.css3Parser.MediaTypeContext arg) {
		System.out.println("MediaType");
		final Node node = model.findOrCreate(Label.label("MediaType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaExpression(com.generator.generators.css.parser.css3Parser.MediaExpressionContext arg) {
		System.out.println("MediaExpression");
		final Node node = model.findOrCreate(Label.label("MediaExpression"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaFeature(com.generator.generators.css.parser.css3Parser.MediaFeatureContext arg) {
		System.out.println("MediaFeature");
		final Node node = model.findOrCreate(Label.label("MediaFeature"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPage(com.generator.generators.css.parser.css3Parser.PageContext arg) {
		System.out.println("Page");
		final Node node = model.findOrCreate(Label.label("Page"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudoPage(com.generator.generators.css.parser.css3Parser.PseudoPageContext arg) {
		System.out.println("PseudoPage");
		final Node node = model.findOrCreate(Label.label("PseudoPage"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectorGroup(com.generator.generators.css.parser.css3Parser.SelectorGroupContext arg) {
		System.out.println("SelectorGroup");
		final Node node = model.findOrCreate(Label.label("SelectorGroup"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsDeclarationCondition(com.generator.generators.css.parser.css3Parser.SupportsDeclarationConditionContext arg) {
		System.out.println("SupportsDeclarationCondition");
		final Node node = model.findOrCreate(Label.label("SupportsDeclarationCondition"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCombinator(com.generator.generators.css.parser.css3Parser.CombinatorContext arg) {
		System.out.println("Combinator");
		final Node node = model.findOrCreate(Label.label("Combinator"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleSelectorSequence(com.generator.generators.css.parser.css3Parser.SimpleSelectorSequenceContext arg) {
		System.out.println("SimpleSelectorSequence");
		final Node node = model.findOrCreate(Label.label("SimpleSelectorSequence"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSelector(com.generator.generators.css.parser.css3Parser.TypeSelectorContext arg) {
		System.out.println("TypeSelector");
		final Node node = model.findOrCreate(Label.label("TypeSelector"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeNamespacePrefix(com.generator.generators.css.parser.css3Parser.TypeNamespacePrefixContext arg) {
		System.out.println("TypeNamespacePrefix");
		final Node node = model.findOrCreate(Label.label("TypeNamespacePrefix"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementName(com.generator.generators.css.parser.css3Parser.ElementNameContext arg) {
		System.out.println("ElementName");
		final Node node = model.findOrCreate(Label.label("ElementName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUniversal(com.generator.generators.css.parser.css3Parser.UniversalContext arg) {
		System.out.println("Universal");
		final Node node = model.findOrCreate(Label.label("Universal"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassName(com.generator.generators.css.parser.css3Parser.ClassNameContext arg) {
		System.out.println("ClassName");
		final Node node = model.findOrCreate(Label.label("ClassName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttrib(com.generator.generators.css.parser.css3Parser.AttribContext arg) {
		System.out.println("Attrib");
		final Node node = model.findOrCreate(Label.label("Attrib"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudo(com.generator.generators.css.parser.css3Parser.PseudoContext arg) {
		System.out.println("Pseudo");
		final Node node = model.findOrCreate(Label.label("Pseudo"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionalPseudo(com.generator.generators.css.parser.css3Parser.FunctionalPseudoContext arg) {
		System.out.println("FunctionalPseudo");
		final Node node = model.findOrCreate(Label.label("FunctionalPseudo"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNegation(com.generator.generators.css.parser.css3Parser.NegationContext arg) {
		System.out.println("Negation");
		final Node node = model.findOrCreate(Label.label("Negation"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNegationArg(com.generator.generators.css.parser.css3Parser.NegationArgContext arg) {
		System.out.println("NegationArg");
		final Node node = model.findOrCreate(Label.label("NegationArg"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodOperator(com.generator.generators.css.parser.css3Parser.GoodOperatorContext arg) {
		System.out.println("GoodOperator");
		final Node node = model.findOrCreate(Label.label("GoodOperator"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadOperator(com.generator.generators.css.parser.css3Parser.BadOperatorContext arg) {
		System.out.println("BadOperator");
		final Node node = model.findOrCreate(Label.label("BadOperator"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodProperty(com.generator.generators.css.parser.css3Parser.GoodPropertyContext arg) {
		System.out.println("GoodProperty");
		final Node node = model.findOrCreate(Label.label("GoodProperty"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadProperty(com.generator.generators.css.parser.css3Parser.BadPropertyContext arg) {
		System.out.println("BadProperty");
		final Node node = model.findOrCreate(Label.label("BadProperty"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownRuleset(com.generator.generators.css.parser.css3Parser.KnownRulesetContext arg) {
		System.out.println("KnownRuleset");
		final Node node = model.findOrCreate(Label.label("KnownRuleset"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownRuleset(com.generator.generators.css.parser.css3Parser.UnknownRulesetContext arg) {
		System.out.println("UnknownRuleset");
		final Node node = model.findOrCreate(Label.label("UnknownRuleset"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclarationList(com.generator.generators.css.parser.css3Parser.DeclarationListContext arg) {
		System.out.println("DeclarationList");
		final Node node = model.findOrCreate(Label.label("DeclarationList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownDeclaration(com.generator.generators.css.parser.css3Parser.KnownDeclarationContext arg) {
		System.out.println("KnownDeclaration");
		final Node node = model.findOrCreate(Label.label("KnownDeclaration"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownDeclaration(com.generator.generators.css.parser.css3Parser.UnknownDeclarationContext arg) {
		System.out.println("UnknownDeclaration");
		final Node node = model.findOrCreate(Label.label("UnknownDeclaration"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrio(com.generator.generators.css.parser.css3Parser.PrioContext arg) {
		System.out.println("Prio");
		final Node node = model.findOrCreate(Label.label("Prio"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValue(com.generator.generators.css.parser.css3Parser.ValueContext arg) {
		System.out.println("Value");
		final Node node = model.findOrCreate(Label.label("Value"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.css.parser.css3Parser.ExprContext arg) {
		System.out.println("Expr");
		final Node node = model.findOrCreate(Label.label("Expr"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownTerm(com.generator.generators.css.parser.css3Parser.KnownTermContext arg) {
		System.out.println("KnownTerm");
		final Node node = model.findOrCreate(Label.label("KnownTerm"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownTerm(com.generator.generators.css.parser.css3Parser.UnknownTermContext arg) {
		System.out.println("UnknownTerm");
		final Node node = model.findOrCreate(Label.label("UnknownTerm"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadTerm(com.generator.generators.css.parser.css3Parser.BadTermContext arg) {
		System.out.println("BadTerm");
		final Node node = model.findOrCreate(Label.label("BadTerm"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction(com.generator.generators.css.parser.css3Parser.FunctionContext arg) {
		System.out.println("Function");
		final Node node = model.findOrCreate(Label.label("Function"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDxImageTransform(com.generator.generators.css.parser.css3Parser.DxImageTransformContext arg) {
		System.out.println("DxImageTransform");
		final Node node = model.findOrCreate(Label.label("DxImageTransform"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHexcolor(com.generator.generators.css.parser.css3Parser.HexcolorContext arg) {
		System.out.println("Hexcolor");
		final Node node = model.findOrCreate(Label.label("Hexcolor"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPercentage(com.generator.generators.css.parser.css3Parser.PercentageContext arg) {
		System.out.println("Percentage");
		final Node node = model.findOrCreate(Label.label("Percentage"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDimension(com.generator.generators.css.parser.css3Parser.DimensionContext arg) {
		System.out.println("Dimension");
		final Node node = model.findOrCreate(Label.label("Dimension"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownDimension(com.generator.generators.css.parser.css3Parser.UnknownDimensionContext arg) {
		System.out.println("UnknownDimension");
		final Node node = model.findOrCreate(Label.label("UnknownDimension"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAny(com.generator.generators.css.parser.css3Parser.AnyContext arg) {
		System.out.println("Any");
		final Node node = model.findOrCreate(Label.label("Any"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownAtRule(com.generator.generators.css.parser.css3Parser.UnknownAtRuleContext arg) {
		System.out.println("UnknownAtRule");
		final Node node = model.findOrCreate(Label.label("UnknownAtRule"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtKeyword(com.generator.generators.css.parser.css3Parser.AtKeywordContext arg) {
		System.out.println("AtKeyword");
		final Node node = model.findOrCreate(Label.label("AtKeyword"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnused(com.generator.generators.css.parser.css3Parser.UnusedContext arg) {
		System.out.println("Unused");
		final Node node = model.findOrCreate(Label.label("Unused"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNestedStatement(com.generator.generators.css.parser.css3Parser.NestedStatementContext arg) {
		System.out.println("NestedStatement");
		final Node node = model.findOrCreate(Label.label("NestedStatement"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroupRuleBody(com.generator.generators.css.parser.css3Parser.GroupRuleBodyContext arg) {
		System.out.println("GroupRuleBody");
		final Node node = model.findOrCreate(Label.label("GroupRuleBody"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsRule(com.generator.generators.css.parser.css3Parser.SupportsRuleContext arg) {
		System.out.println("SupportsRule");
		final Node node = model.findOrCreate(Label.label("SupportsRule"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsCondition(com.generator.generators.css.parser.css3Parser.SupportsConditionContext arg) {
		System.out.println("SupportsCondition");
		final Node node = model.findOrCreate(Label.label("SupportsCondition"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsConditionInParens(com.generator.generators.css.parser.css3Parser.SupportsConditionInParensContext arg) {
		System.out.println("SupportsConditionInParens");
		final Node node = model.findOrCreate(Label.label("SupportsConditionInParens"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsNegation(com.generator.generators.css.parser.css3Parser.SupportsNegationContext arg) {
		System.out.println("SupportsNegation");
		final Node node = model.findOrCreate(Label.label("SupportsNegation"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsConjunction(com.generator.generators.css.parser.css3Parser.SupportsConjunctionContext arg) {
		System.out.println("SupportsConjunction");
		final Node node = model.findOrCreate(Label.label("SupportsConjunction"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsDisjunction(com.generator.generators.css.parser.css3Parser.SupportsDisjunctionContext arg) {
		System.out.println("SupportsDisjunction");
		final Node node = model.findOrCreate(Label.label("SupportsDisjunction"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGeneralEnclosed(com.generator.generators.css.parser.css3Parser.GeneralEnclosedContext arg) {
		System.out.println("GeneralEnclosed");
		final Node node = model.findOrCreate(Label.label("GeneralEnclosed"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.css.parser.css3Parser.VarContext arg) {
		System.out.println("Var");
		final Node node = model.findOrCreate(Label.label("Var"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalc(com.generator.generators.css.parser.css3Parser.CalcContext arg) {
		System.out.println("Calc");
		final Node node = model.findOrCreate(Label.label("Calc"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcSum(com.generator.generators.css.parser.css3Parser.CalcSumContext arg) {
		System.out.println("CalcSum");
		final Node node = model.findOrCreate(Label.label("CalcSum"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcProduct(com.generator.generators.css.parser.css3Parser.CalcProductContext arg) {
		System.out.println("CalcProduct");
		final Node node = model.findOrCreate(Label.label("CalcProduct"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcValue(com.generator.generators.css.parser.css3Parser.CalcValueContext arg) {
		System.out.println("CalcValue");
		final Node node = model.findOrCreate(Label.label("CalcValue"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFaceRule(com.generator.generators.css.parser.css3Parser.FontFaceRuleContext arg) {
		System.out.println("FontFaceRule");
		final Node node = model.findOrCreate(Label.label("FontFaceRule"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.KnownFontFaceDeclarationContext arg) {
		System.out.println("KnownFontFaceDeclaration");
		final Node node = model.findOrCreate(Label.label("KnownFontFaceDeclaration"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.UnknownFontFaceDeclarationContext arg) {
		System.out.println("UnknownFontFaceDeclaration");
		final Node node = model.findOrCreate(Label.label("UnknownFontFaceDeclaration"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframesRule(com.generator.generators.css.parser.css3Parser.KeyframesRuleContext arg) {
		System.out.println("KeyframesRule");
		final Node node = model.findOrCreate(Label.label("KeyframesRule"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframesBlocks(com.generator.generators.css.parser.css3Parser.KeyframesBlocksContext arg) {
		System.out.println("KeyframesBlocks");
		final Node node = model.findOrCreate(Label.label("KeyframesBlocks"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframeSelector(com.generator.generators.css.parser.css3Parser.KeyframeSelectorContext arg) {
		System.out.println("KeyframeSelector");
		final Node node = model.findOrCreate(Label.label("KeyframeSelector"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitViewport(com.generator.generators.css.parser.css3Parser.ViewportContext arg) {
		System.out.println("Viewport");
		final Node node = model.findOrCreate(Label.label("Viewport"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCounterStyle(com.generator.generators.css.parser.css3Parser.CounterStyleContext arg) {
		System.out.println("CounterStyle");
		final Node node = model.findOrCreate(Label.label("CounterStyle"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFeatureValuesRule(com.generator.generators.css.parser.css3Parser.FontFeatureValuesRuleContext arg) {
		System.out.println("FontFeatureValuesRule");
		final Node node = model.findOrCreate(Label.label("FontFeatureValuesRule"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFamilyNameList(com.generator.generators.css.parser.css3Parser.FontFamilyNameListContext arg) {
		System.out.println("FontFamilyNameList");
		final Node node = model.findOrCreate(Label.label("FontFamilyNameList"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadCharset(com.generator.generators.css.parser.css3Parser.BadCharsetContext arg) {
		System.out.println("BadCharset");
		final Node node = model.findOrCreate(Label.label("BadCharset"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelector(com.generator.generators.css.parser.css3Parser.SelectorContext arg) {
		System.out.println("Selector");
		final Node node = model.findOrCreate(Label.label("Selector"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodImport(com.generator.generators.css.parser.css3Parser.GoodImportContext arg) {
		System.out.println("GoodImport");
		final Node node = model.findOrCreate(Label.label("GoodImport"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFamilyName(com.generator.generators.css.parser.css3Parser.FontFamilyNameContext arg) {
		System.out.println("FontFamilyName");
		final Node node = model.findOrCreate(Label.label("FontFamilyName"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureValueBlock(com.generator.generators.css.parser.css3Parser.FeatureValueBlockContext arg) {
		System.out.println("FeatureValueBlock");
		final Node node = model.findOrCreate(Label.label("FeatureValueBlock"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureType(com.generator.generators.css.parser.css3Parser.FeatureTypeContext arg) {
		System.out.println("FeatureType");
		final Node node = model.findOrCreate(Label.label("FeatureType"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureValueDefinition(com.generator.generators.css.parser.css3Parser.FeatureValueDefinitionContext arg) {
		System.out.println("FeatureValueDefinition");
		final Node node = model.findOrCreate(Label.label("FeatureValueDefinition"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdent(com.generator.generators.css.parser.css3Parser.IdentContext arg) {
		System.out.println("Ident");
		final Node node = model.findOrCreate(Label.label("Ident"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWs(com.generator.generators.css.parser.css3Parser.WsContext arg) {
		System.out.println("Ws");
		final Node node = model.findOrCreate(Label.label("Ws"), "text", arg.getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}