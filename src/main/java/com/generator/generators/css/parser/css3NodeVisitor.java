package com.generator.generators.css.parser;

public class css3NodeVisitor extends css3BaseVisitor<css3NodeVisitor.Node> {

   public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
      }
   }

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public css3NodeVisitor() {
		this(false);
	}

	public css3NodeVisitor(boolean debug) {
		this.debug = debug;
	}

   private void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name);
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

	@Override
	public Node visitBlock(com.generator.generators.css.parser.css3Parser.BlockContext arg) {
		final Node node = new Node("Block", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadImport(com.generator.generators.css.parser.css3Parser.BadImportContext arg) {
		final Node node = new Node("BadImport", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMedia(com.generator.generators.css.parser.css3Parser.MediaContext arg) {
		final Node node = new Node("Media", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.css.parser.css3Parser.ExpressionContext arg) {
		final Node node = new Node("Expression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.css.parser.css3Parser.NumberContext arg) {
		final Node node = new Node("Number", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStylesheet(com.generator.generators.css.parser.css3Parser.StylesheetContext arg) {
		final Node node = new Node("Stylesheet", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodCharset(com.generator.generators.css.parser.css3Parser.GoodCharsetContext arg) {
		final Node node = new Node("GoodCharset", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodNamespace(com.generator.generators.css.parser.css3Parser.GoodNamespaceContext arg) {
		final Node node = new Node("GoodNamespace", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadNamespace(com.generator.generators.css.parser.css3Parser.BadNamespaceContext arg) {
		final Node node = new Node("BadNamespace", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespacePrefix(com.generator.generators.css.parser.css3Parser.NamespacePrefixContext arg) {
		final Node node = new Node("NamespacePrefix", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaQueryList(com.generator.generators.css.parser.css3Parser.MediaQueryListContext arg) {
		final Node node = new Node("MediaQueryList", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaQuery(com.generator.generators.css.parser.css3Parser.MediaQueryContext arg) {
		final Node node = new Node("MediaQuery", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaType(com.generator.generators.css.parser.css3Parser.MediaTypeContext arg) {
		final Node node = new Node("MediaType", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaExpression(com.generator.generators.css.parser.css3Parser.MediaExpressionContext arg) {
		final Node node = new Node("MediaExpression", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaFeature(com.generator.generators.css.parser.css3Parser.MediaFeatureContext arg) {
		final Node node = new Node("MediaFeature", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPage(com.generator.generators.css.parser.css3Parser.PageContext arg) {
		final Node node = new Node("Page", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudoPage(com.generator.generators.css.parser.css3Parser.PseudoPageContext arg) {
		final Node node = new Node("PseudoPage", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectorGroup(com.generator.generators.css.parser.css3Parser.SelectorGroupContext arg) {
		final Node node = new Node("SelectorGroup", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsDeclarationCondition(com.generator.generators.css.parser.css3Parser.SupportsDeclarationConditionContext arg) {
		final Node node = new Node("SupportsDeclarationCondition", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCombinator(com.generator.generators.css.parser.css3Parser.CombinatorContext arg) {
		final Node node = new Node("Combinator", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleSelectorSequence(com.generator.generators.css.parser.css3Parser.SimpleSelectorSequenceContext arg) {
		final Node node = new Node("SimpleSelectorSequence", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSelector(com.generator.generators.css.parser.css3Parser.TypeSelectorContext arg) {
		final Node node = new Node("TypeSelector", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeNamespacePrefix(com.generator.generators.css.parser.css3Parser.TypeNamespacePrefixContext arg) {
		final Node node = new Node("TypeNamespacePrefix", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementName(com.generator.generators.css.parser.css3Parser.ElementNameContext arg) {
		final Node node = new Node("ElementName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUniversal(com.generator.generators.css.parser.css3Parser.UniversalContext arg) {
		final Node node = new Node("Universal", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassName(com.generator.generators.css.parser.css3Parser.ClassNameContext arg) {
		final Node node = new Node("ClassName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttrib(com.generator.generators.css.parser.css3Parser.AttribContext arg) {
		final Node node = new Node("Attrib", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudo(com.generator.generators.css.parser.css3Parser.PseudoContext arg) {
		final Node node = new Node("Pseudo", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionalPseudo(com.generator.generators.css.parser.css3Parser.FunctionalPseudoContext arg) {
		final Node node = new Node("FunctionalPseudo", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNegation(com.generator.generators.css.parser.css3Parser.NegationContext arg) {
		final Node node = new Node("Negation", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNegationArg(com.generator.generators.css.parser.css3Parser.NegationArgContext arg) {
		final Node node = new Node("NegationArg", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodOperator(com.generator.generators.css.parser.css3Parser.GoodOperatorContext arg) {
		final Node node = new Node("GoodOperator", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadOperator(com.generator.generators.css.parser.css3Parser.BadOperatorContext arg) {
		final Node node = new Node("BadOperator", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodProperty(com.generator.generators.css.parser.css3Parser.GoodPropertyContext arg) {
		final Node node = new Node("GoodProperty", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadProperty(com.generator.generators.css.parser.css3Parser.BadPropertyContext arg) {
		final Node node = new Node("BadProperty", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownRuleset(com.generator.generators.css.parser.css3Parser.KnownRulesetContext arg) {
		final Node node = new Node("KnownRuleset", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownRuleset(com.generator.generators.css.parser.css3Parser.UnknownRulesetContext arg) {
		final Node node = new Node("UnknownRuleset", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclarationList(com.generator.generators.css.parser.css3Parser.DeclarationListContext arg) {
		final Node node = new Node("DeclarationList", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownDeclaration(com.generator.generators.css.parser.css3Parser.KnownDeclarationContext arg) {
		final Node node = new Node("KnownDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownDeclaration(com.generator.generators.css.parser.css3Parser.UnknownDeclarationContext arg) {
		final Node node = new Node("UnknownDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrio(com.generator.generators.css.parser.css3Parser.PrioContext arg) {
		final Node node = new Node("Prio", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValue(com.generator.generators.css.parser.css3Parser.ValueContext arg) {
		final Node node = new Node("Value", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.css.parser.css3Parser.ExprContext arg) {
		final Node node = new Node("Expr", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownTerm(com.generator.generators.css.parser.css3Parser.KnownTermContext arg) {
		final Node node = new Node("KnownTerm", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownTerm(com.generator.generators.css.parser.css3Parser.UnknownTermContext arg) {
		final Node node = new Node("UnknownTerm", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadTerm(com.generator.generators.css.parser.css3Parser.BadTermContext arg) {
		final Node node = new Node("BadTerm", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction(com.generator.generators.css.parser.css3Parser.FunctionContext arg) {
		final Node node = new Node("Function", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDxImageTransform(com.generator.generators.css.parser.css3Parser.DxImageTransformContext arg) {
		final Node node = new Node("DxImageTransform", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHexcolor(com.generator.generators.css.parser.css3Parser.HexcolorContext arg) {
		final Node node = new Node("Hexcolor", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPercentage(com.generator.generators.css.parser.css3Parser.PercentageContext arg) {
		final Node node = new Node("Percentage", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDimension(com.generator.generators.css.parser.css3Parser.DimensionContext arg) {
		final Node node = new Node("Dimension", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownDimension(com.generator.generators.css.parser.css3Parser.UnknownDimensionContext arg) {
		final Node node = new Node("UnknownDimension", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAny(com.generator.generators.css.parser.css3Parser.AnyContext arg) {
		final Node node = new Node("Any", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownAtRule(com.generator.generators.css.parser.css3Parser.UnknownAtRuleContext arg) {
		final Node node = new Node("UnknownAtRule", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtKeyword(com.generator.generators.css.parser.css3Parser.AtKeywordContext arg) {
		final Node node = new Node("AtKeyword", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnused(com.generator.generators.css.parser.css3Parser.UnusedContext arg) {
		final Node node = new Node("Unused", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNestedStatement(com.generator.generators.css.parser.css3Parser.NestedStatementContext arg) {
		final Node node = new Node("NestedStatement", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroupRuleBody(com.generator.generators.css.parser.css3Parser.GroupRuleBodyContext arg) {
		final Node node = new Node("GroupRuleBody", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsRule(com.generator.generators.css.parser.css3Parser.SupportsRuleContext arg) {
		final Node node = new Node("SupportsRule", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsCondition(com.generator.generators.css.parser.css3Parser.SupportsConditionContext arg) {
		final Node node = new Node("SupportsCondition", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsConditionInParens(com.generator.generators.css.parser.css3Parser.SupportsConditionInParensContext arg) {
		final Node node = new Node("SupportsConditionInParens", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsNegation(com.generator.generators.css.parser.css3Parser.SupportsNegationContext arg) {
		final Node node = new Node("SupportsNegation", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsConjunction(com.generator.generators.css.parser.css3Parser.SupportsConjunctionContext arg) {
		final Node node = new Node("SupportsConjunction", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsDisjunction(com.generator.generators.css.parser.css3Parser.SupportsDisjunctionContext arg) {
		final Node node = new Node("SupportsDisjunction", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGeneralEnclosed(com.generator.generators.css.parser.css3Parser.GeneralEnclosedContext arg) {
		final Node node = new Node("GeneralEnclosed", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.css.parser.css3Parser.VarContext arg) {
		final Node node = new Node("Var", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalc(com.generator.generators.css.parser.css3Parser.CalcContext arg) {
		final Node node = new Node("Calc", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcSum(com.generator.generators.css.parser.css3Parser.CalcSumContext arg) {
		final Node node = new Node("CalcSum", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcProduct(com.generator.generators.css.parser.css3Parser.CalcProductContext arg) {
		final Node node = new Node("CalcProduct", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcValue(com.generator.generators.css.parser.css3Parser.CalcValueContext arg) {
		final Node node = new Node("CalcValue", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFaceRule(com.generator.generators.css.parser.css3Parser.FontFaceRuleContext arg) {
		final Node node = new Node("FontFaceRule", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.KnownFontFaceDeclarationContext arg) {
		final Node node = new Node("KnownFontFaceDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.UnknownFontFaceDeclarationContext arg) {
		final Node node = new Node("UnknownFontFaceDeclaration", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframesRule(com.generator.generators.css.parser.css3Parser.KeyframesRuleContext arg) {
		final Node node = new Node("KeyframesRule", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframesBlocks(com.generator.generators.css.parser.css3Parser.KeyframesBlocksContext arg) {
		final Node node = new Node("KeyframesBlocks", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframeSelector(com.generator.generators.css.parser.css3Parser.KeyframeSelectorContext arg) {
		final Node node = new Node("KeyframeSelector", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitViewport(com.generator.generators.css.parser.css3Parser.ViewportContext arg) {
		final Node node = new Node("Viewport", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCounterStyle(com.generator.generators.css.parser.css3Parser.CounterStyleContext arg) {
		final Node node = new Node("CounterStyle", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFeatureValuesRule(com.generator.generators.css.parser.css3Parser.FontFeatureValuesRuleContext arg) {
		final Node node = new Node("FontFeatureValuesRule", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFamilyNameList(com.generator.generators.css.parser.css3Parser.FontFamilyNameListContext arg) {
		final Node node = new Node("FontFamilyNameList", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadCharset(com.generator.generators.css.parser.css3Parser.BadCharsetContext arg) {
		final Node node = new Node("BadCharset", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelector(com.generator.generators.css.parser.css3Parser.SelectorContext arg) {
		final Node node = new Node("Selector", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodImport(com.generator.generators.css.parser.css3Parser.GoodImportContext arg) {
		final Node node = new Node("GoodImport", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFamilyName(com.generator.generators.css.parser.css3Parser.FontFamilyNameContext arg) {
		final Node node = new Node("FontFamilyName", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureValueBlock(com.generator.generators.css.parser.css3Parser.FeatureValueBlockContext arg) {
		final Node node = new Node("FeatureValueBlock", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureType(com.generator.generators.css.parser.css3Parser.FeatureTypeContext arg) {
		final Node node = new Node("FeatureType", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureValueDefinition(com.generator.generators.css.parser.css3Parser.FeatureValueDefinitionContext arg) {
		final Node node = new Node("FeatureValueDefinition", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdent(com.generator.generators.css.parser.css3Parser.IdentContext arg) {
		final Node node = new Node("Ident", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWs(com.generator.generators.css.parser.css3Parser.WsContext arg) {
		final Node node = new Node("Ws", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}