package com.generator.generators.css.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class css3NeoVisitor extends css3BaseVisitor<Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(css3NeoVisitor.class);

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final com.generator.neo.NeoModel model;

	public css3NeoVisitor(com.generator.neo.NeoModel model) {
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
	public Node visitBlock(com.generator.generators.css.parser.css3Parser.BlockContext arg) {
		log.info("Block");
		final Node node = model.newNode(Label.label("Block"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.css.parser.css3Parser.NumberContext arg) {
		log.info("Number");
		final Node node = model.newNode(Label.label("Number"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStylesheet(com.generator.generators.css.parser.css3Parser.StylesheetContext arg) {
		log.info("Stylesheet");
		final Node node = model.newNode(Label.label("Stylesheet"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodCharset(com.generator.generators.css.parser.css3Parser.GoodCharsetContext arg) {
		log.info("GoodCharset");
		final Node node = model.newNode(Label.label("GoodCharset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadCharset(com.generator.generators.css.parser.css3Parser.BadCharsetContext arg) {
		log.info("BadCharset");
		final Node node = model.newNode(Label.label("BadCharset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodImport(com.generator.generators.css.parser.css3Parser.GoodImportContext arg) {
		log.info("GoodImport");
		final Node node = model.newNode(Label.label("GoodImport"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadImport(com.generator.generators.css.parser.css3Parser.BadImportContext arg) {
		log.info("BadImport");
		final Node node = model.newNode(Label.label("BadImport"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodNamespace(com.generator.generators.css.parser.css3Parser.GoodNamespaceContext arg) {
		log.info("GoodNamespace");
		final Node node = model.newNode(Label.label("GoodNamespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadNamespace(com.generator.generators.css.parser.css3Parser.BadNamespaceContext arg) {
		log.info("BadNamespace");
		final Node node = model.newNode(Label.label("BadNamespace"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespacePrefix(com.generator.generators.css.parser.css3Parser.NamespacePrefixContext arg) {
		log.info("NamespacePrefix");
		final Node node = model.newNode(Label.label("NamespacePrefix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMedia(com.generator.generators.css.parser.css3Parser.MediaContext arg) {
		log.info("Media");
		final Node node = model.newNode(Label.label("Media"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaQueryList(com.generator.generators.css.parser.css3Parser.MediaQueryListContext arg) {
		log.info("MediaQueryList");
		final Node node = model.newNode(Label.label("MediaQueryList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.css.parser.css3Parser.ExpressionContext arg) {
		log.info("Expression");
		final Node node = model.newNode(Label.label("Expression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsDeclarationCondition(com.generator.generators.css.parser.css3Parser.SupportsDeclarationConditionContext arg) {
		log.info("SupportsDeclarationCondition");
		final Node node = model.newNode(Label.label("SupportsDeclarationCondition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaQuery(com.generator.generators.css.parser.css3Parser.MediaQueryContext arg) {
		log.info("MediaQuery");
		final Node node = model.newNode(Label.label("MediaQuery"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaType(com.generator.generators.css.parser.css3Parser.MediaTypeContext arg) {
		log.info("MediaType");
		final Node node = model.newNode(Label.label("MediaType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaExpression(com.generator.generators.css.parser.css3Parser.MediaExpressionContext arg) {
		log.info("MediaExpression");
		final Node node = model.newNode(Label.label("MediaExpression"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaFeature(com.generator.generators.css.parser.css3Parser.MediaFeatureContext arg) {
		log.info("MediaFeature");
		final Node node = model.newNode(Label.label("MediaFeature"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPage(com.generator.generators.css.parser.css3Parser.PageContext arg) {
		log.info("Page");
		final Node node = model.newNode(Label.label("Page"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudoPage(com.generator.generators.css.parser.css3Parser.PseudoPageContext arg) {
		log.info("PseudoPage");
		final Node node = model.newNode(Label.label("PseudoPage"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectorGroup(com.generator.generators.css.parser.css3Parser.SelectorGroupContext arg) {
		log.info("SelectorGroup");
		final Node node = model.newNode(Label.label("SelectorGroup"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelector(com.generator.generators.css.parser.css3Parser.SelectorContext arg) {
		log.info("Selector");
		final Node node = model.newNode(Label.label("Selector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCombinator(com.generator.generators.css.parser.css3Parser.CombinatorContext arg) {
		log.info("Combinator");
		final Node node = model.newNode(Label.label("Combinator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleSelectorSequence(com.generator.generators.css.parser.css3Parser.SimpleSelectorSequenceContext arg) {
		log.info("SimpleSelectorSequence");
		final Node node = model.newNode(Label.label("SimpleSelectorSequence"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSelector(com.generator.generators.css.parser.css3Parser.TypeSelectorContext arg) {
		log.info("TypeSelector");
		final Node node = model.newNode(Label.label("TypeSelector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeNamespacePrefix(com.generator.generators.css.parser.css3Parser.TypeNamespacePrefixContext arg) {
		log.info("TypeNamespacePrefix");
		final Node node = model.newNode(Label.label("TypeNamespacePrefix"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementName(com.generator.generators.css.parser.css3Parser.ElementNameContext arg) {
		log.info("ElementName");
		final Node node = model.newNode(Label.label("ElementName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUniversal(com.generator.generators.css.parser.css3Parser.UniversalContext arg) {
		log.info("Universal");
		final Node node = model.newNode(Label.label("Universal"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassName(com.generator.generators.css.parser.css3Parser.ClassNameContext arg) {
		log.info("ClassName");
		final Node node = model.newNode(Label.label("ClassName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttrib(com.generator.generators.css.parser.css3Parser.AttribContext arg) {
		log.info("Attrib");
		final Node node = model.newNode(Label.label("Attrib"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudo(com.generator.generators.css.parser.css3Parser.PseudoContext arg) {
		log.info("Pseudo");
		final Node node = model.newNode(Label.label("Pseudo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionalPseudo(com.generator.generators.css.parser.css3Parser.FunctionalPseudoContext arg) {
		log.info("FunctionalPseudo");
		final Node node = model.newNode(Label.label("FunctionalPseudo"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNegation(com.generator.generators.css.parser.css3Parser.NegationContext arg) {
		log.info("Negation");
		final Node node = model.newNode(Label.label("Negation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNegationArg(com.generator.generators.css.parser.css3Parser.NegationArgContext arg) {
		log.info("NegationArg");
		final Node node = model.newNode(Label.label("NegationArg"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodOperator(com.generator.generators.css.parser.css3Parser.GoodOperatorContext arg) {
		log.info("GoodOperator");
		final Node node = model.newNode(Label.label("GoodOperator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadOperator(com.generator.generators.css.parser.css3Parser.BadOperatorContext arg) {
		log.info("BadOperator");
		final Node node = model.newNode(Label.label("BadOperator"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodProperty(com.generator.generators.css.parser.css3Parser.GoodPropertyContext arg) {
		log.info("GoodProperty");
		final Node node = model.newNode(Label.label("GoodProperty"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadProperty(com.generator.generators.css.parser.css3Parser.BadPropertyContext arg) {
		log.info("BadProperty");
		final Node node = model.newNode(Label.label("BadProperty"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownRuleset(com.generator.generators.css.parser.css3Parser.KnownRulesetContext arg) {
		log.info("KnownRuleset");
		final Node node = model.newNode(Label.label("KnownRuleset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownRuleset(com.generator.generators.css.parser.css3Parser.UnknownRulesetContext arg) {
		log.info("UnknownRuleset");
		final Node node = model.newNode(Label.label("UnknownRuleset"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclarationList(com.generator.generators.css.parser.css3Parser.DeclarationListContext arg) {
		log.info("DeclarationList");
		final Node node = model.newNode(Label.label("DeclarationList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownDeclaration(com.generator.generators.css.parser.css3Parser.KnownDeclarationContext arg) {
		log.info("KnownDeclaration");
		final Node node = model.newNode(Label.label("KnownDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownDeclaration(com.generator.generators.css.parser.css3Parser.UnknownDeclarationContext arg) {
		log.info("UnknownDeclaration");
		final Node node = model.newNode(Label.label("UnknownDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrio(com.generator.generators.css.parser.css3Parser.PrioContext arg) {
		log.info("Prio");
		final Node node = model.newNode(Label.label("Prio"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValue(com.generator.generators.css.parser.css3Parser.ValueContext arg) {
		log.info("Value");
		final Node node = model.newNode(Label.label("Value"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.css.parser.css3Parser.ExprContext arg) {
		log.info("Expr");
		final Node node = model.newNode(Label.label("Expr"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownTerm(com.generator.generators.css.parser.css3Parser.KnownTermContext arg) {
		log.info("KnownTerm");
		final Node node = model.newNode(Label.label("KnownTerm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownTerm(com.generator.generators.css.parser.css3Parser.UnknownTermContext arg) {
		log.info("UnknownTerm");
		final Node node = model.newNode(Label.label("UnknownTerm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadTerm(com.generator.generators.css.parser.css3Parser.BadTermContext arg) {
		log.info("BadTerm");
		final Node node = model.newNode(Label.label("BadTerm"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction(com.generator.generators.css.parser.css3Parser.FunctionContext arg) {
		log.info("Function");
		final Node node = model.newNode(Label.label("Function"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDxImageTransform(com.generator.generators.css.parser.css3Parser.DxImageTransformContext arg) {
		log.info("DxImageTransform");
		final Node node = model.newNode(Label.label("DxImageTransform"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHexcolor(com.generator.generators.css.parser.css3Parser.HexcolorContext arg) {
		log.info("Hexcolor");
		final Node node = model.newNode(Label.label("Hexcolor"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPercentage(com.generator.generators.css.parser.css3Parser.PercentageContext arg) {
		log.info("Percentage");
		final Node node = model.newNode(Label.label("Percentage"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDimension(com.generator.generators.css.parser.css3Parser.DimensionContext arg) {
		log.info("Dimension");
		final Node node = model.newNode(Label.label("Dimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownDimension(com.generator.generators.css.parser.css3Parser.UnknownDimensionContext arg) {
		log.info("UnknownDimension");
		final Node node = model.newNode(Label.label("UnknownDimension"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAny(com.generator.generators.css.parser.css3Parser.AnyContext arg) {
		log.info("Any");
		final Node node = model.newNode(Label.label("Any"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownAtRule(com.generator.generators.css.parser.css3Parser.UnknownAtRuleContext arg) {
		log.info("UnknownAtRule");
		final Node node = model.newNode(Label.label("UnknownAtRule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtKeyword(com.generator.generators.css.parser.css3Parser.AtKeywordContext arg) {
		log.info("AtKeyword");
		final Node node = model.newNode(Label.label("AtKeyword"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnused(com.generator.generators.css.parser.css3Parser.UnusedContext arg) {
		log.info("Unused");
		final Node node = model.newNode(Label.label("Unused"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNestedStatement(com.generator.generators.css.parser.css3Parser.NestedStatementContext arg) {
		log.info("NestedStatement");
		final Node node = model.newNode(Label.label("NestedStatement"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroupRuleBody(com.generator.generators.css.parser.css3Parser.GroupRuleBodyContext arg) {
		log.info("GroupRuleBody");
		final Node node = model.newNode(Label.label("GroupRuleBody"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsRule(com.generator.generators.css.parser.css3Parser.SupportsRuleContext arg) {
		log.info("SupportsRule");
		final Node node = model.newNode(Label.label("SupportsRule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsCondition(com.generator.generators.css.parser.css3Parser.SupportsConditionContext arg) {
		log.info("SupportsCondition");
		final Node node = model.newNode(Label.label("SupportsCondition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsConditionInParens(com.generator.generators.css.parser.css3Parser.SupportsConditionInParensContext arg) {
		log.info("SupportsConditionInParens");
		final Node node = model.newNode(Label.label("SupportsConditionInParens"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsNegation(com.generator.generators.css.parser.css3Parser.SupportsNegationContext arg) {
		log.info("SupportsNegation");
		final Node node = model.newNode(Label.label("SupportsNegation"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsConjunction(com.generator.generators.css.parser.css3Parser.SupportsConjunctionContext arg) {
		log.info("SupportsConjunction");
		final Node node = model.newNode(Label.label("SupportsConjunction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsDisjunction(com.generator.generators.css.parser.css3Parser.SupportsDisjunctionContext arg) {
		log.info("SupportsDisjunction");
		final Node node = model.newNode(Label.label("SupportsDisjunction"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGeneralEnclosed(com.generator.generators.css.parser.css3Parser.GeneralEnclosedContext arg) {
		log.info("GeneralEnclosed");
		final Node node = model.newNode(Label.label("GeneralEnclosed"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.css.parser.css3Parser.VarContext arg) {
		log.info("Var");
		final Node node = model.newNode(Label.label("Var"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalc(com.generator.generators.css.parser.css3Parser.CalcContext arg) {
		log.info("Calc");
		final Node node = model.newNode(Label.label("Calc"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcSum(com.generator.generators.css.parser.css3Parser.CalcSumContext arg) {
		log.info("CalcSum");
		final Node node = model.newNode(Label.label("CalcSum"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcProduct(com.generator.generators.css.parser.css3Parser.CalcProductContext arg) {
		log.info("CalcProduct");
		final Node node = model.newNode(Label.label("CalcProduct"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcValue(com.generator.generators.css.parser.css3Parser.CalcValueContext arg) {
		log.info("CalcValue");
		final Node node = model.newNode(Label.label("CalcValue"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFaceRule(com.generator.generators.css.parser.css3Parser.FontFaceRuleContext arg) {
		log.info("FontFaceRule");
		final Node node = model.newNode(Label.label("FontFaceRule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.KnownFontFaceDeclarationContext arg) {
		log.info("KnownFontFaceDeclaration");
		final Node node = model.newNode(Label.label("KnownFontFaceDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.UnknownFontFaceDeclarationContext arg) {
		log.info("UnknownFontFaceDeclaration");
		final Node node = model.newNode(Label.label("UnknownFontFaceDeclaration"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframesRule(com.generator.generators.css.parser.css3Parser.KeyframesRuleContext arg) {
		log.info("KeyframesRule");
		final Node node = model.newNode(Label.label("KeyframesRule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframesBlocks(com.generator.generators.css.parser.css3Parser.KeyframesBlocksContext arg) {
		log.info("KeyframesBlocks");
		final Node node = model.newNode(Label.label("KeyframesBlocks"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframeSelector(com.generator.generators.css.parser.css3Parser.KeyframeSelectorContext arg) {
		log.info("KeyframeSelector");
		final Node node = model.newNode(Label.label("KeyframeSelector"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitViewport(com.generator.generators.css.parser.css3Parser.ViewportContext arg) {
		log.info("Viewport");
		final Node node = model.newNode(Label.label("Viewport"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCounterStyle(com.generator.generators.css.parser.css3Parser.CounterStyleContext arg) {
		log.info("CounterStyle");
		final Node node = model.newNode(Label.label("CounterStyle"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFeatureValuesRule(com.generator.generators.css.parser.css3Parser.FontFeatureValuesRuleContext arg) {
		log.info("FontFeatureValuesRule");
		final Node node = model.newNode(Label.label("FontFeatureValuesRule"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFamilyNameList(com.generator.generators.css.parser.css3Parser.FontFamilyNameListContext arg) {
		log.info("FontFamilyNameList");
		final Node node = model.newNode(Label.label("FontFamilyNameList"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFamilyName(com.generator.generators.css.parser.css3Parser.FontFamilyNameContext arg) {
		log.info("FontFamilyName");
		final Node node = model.newNode(Label.label("FontFamilyName"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureValueBlock(com.generator.generators.css.parser.css3Parser.FeatureValueBlockContext arg) {
		log.info("FeatureValueBlock");
		final Node node = model.newNode(Label.label("FeatureValueBlock"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureType(com.generator.generators.css.parser.css3Parser.FeatureTypeContext arg) {
		log.info("FeatureType");
		final Node node = model.newNode(Label.label("FeatureType"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureValueDefinition(com.generator.generators.css.parser.css3Parser.FeatureValueDefinitionContext arg) {
		log.info("FeatureValueDefinition");
		final Node node = model.newNode(Label.label("FeatureValueDefinition"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdent(com.generator.generators.css.parser.css3Parser.IdentContext arg) {
		log.info("Ident");
		final Node node = model.newNode(Label.label("Ident"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWs(com.generator.generators.css.parser.css3Parser.WsContext arg) {
		log.info("Ws");
		final Node node = model.newNode(Label.label("Ws"), "text", arg.getText(), "startToken", arg.getStart().getText(), "endToken", arg.getStop().getText());
      onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}