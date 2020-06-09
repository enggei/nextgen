package com.generator.generators.css.parser;

public class css3NodeVisitor extends css3BaseVisitor<css3NodeVisitor.Node> {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(css3NodeVisitor.class);

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

	public css3NodeVisitor() {
		this(false);
	}

	public css3NodeVisitor(boolean debug) {
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

	@Override
	public Node visitBlock(com.generator.generators.css.parser.css3Parser.BlockContext arg) {
		final Node node = new Node("Block", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNumber(com.generator.generators.css.parser.css3Parser.NumberContext arg) {
		final Node node = new Node("Number", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitStylesheet(com.generator.generators.css.parser.css3Parser.StylesheetContext arg) {
		final Node node = new Node("Stylesheet", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodCharset(com.generator.generators.css.parser.css3Parser.GoodCharsetContext arg) {
		final Node node = new Node("GoodCharset", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadCharset(com.generator.generators.css.parser.css3Parser.BadCharsetContext arg) {
		final Node node = new Node("BadCharset", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodImport(com.generator.generators.css.parser.css3Parser.GoodImportContext arg) {
		final Node node = new Node("GoodImport", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadImport(com.generator.generators.css.parser.css3Parser.BadImportContext arg) {
		final Node node = new Node("BadImport", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodNamespace(com.generator.generators.css.parser.css3Parser.GoodNamespaceContext arg) {
		final Node node = new Node("GoodNamespace", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadNamespace(com.generator.generators.css.parser.css3Parser.BadNamespaceContext arg) {
		final Node node = new Node("BadNamespace", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNamespacePrefix(com.generator.generators.css.parser.css3Parser.NamespacePrefixContext arg) {
		final Node node = new Node("NamespacePrefix", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMedia(com.generator.generators.css.parser.css3Parser.MediaContext arg) {
		final Node node = new Node("Media", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaQueryList(com.generator.generators.css.parser.css3Parser.MediaQueryListContext arg) {
		final Node node = new Node("MediaQueryList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpression(com.generator.generators.css.parser.css3Parser.ExpressionContext arg) {
		final Node node = new Node("Expression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsDeclarationCondition(com.generator.generators.css.parser.css3Parser.SupportsDeclarationConditionContext arg) {
		final Node node = new Node("SupportsDeclarationCondition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaQuery(com.generator.generators.css.parser.css3Parser.MediaQueryContext arg) {
		final Node node = new Node("MediaQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaType(com.generator.generators.css.parser.css3Parser.MediaTypeContext arg) {
		final Node node = new Node("MediaType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaExpression(com.generator.generators.css.parser.css3Parser.MediaExpressionContext arg) {
		final Node node = new Node("MediaExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitMediaFeature(com.generator.generators.css.parser.css3Parser.MediaFeatureContext arg) {
		final Node node = new Node("MediaFeature", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPage(com.generator.generators.css.parser.css3Parser.PageContext arg) {
		final Node node = new Node("Page", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudoPage(com.generator.generators.css.parser.css3Parser.PseudoPageContext arg) {
		final Node node = new Node("PseudoPage", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelectorGroup(com.generator.generators.css.parser.css3Parser.SelectorGroupContext arg) {
		final Node node = new Node("SelectorGroup", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSelector(com.generator.generators.css.parser.css3Parser.SelectorContext arg) {
		final Node node = new Node("Selector", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCombinator(com.generator.generators.css.parser.css3Parser.CombinatorContext arg) {
		final Node node = new Node("Combinator", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSimpleSelectorSequence(com.generator.generators.css.parser.css3Parser.SimpleSelectorSequenceContext arg) {
		final Node node = new Node("SimpleSelectorSequence", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeSelector(com.generator.generators.css.parser.css3Parser.TypeSelectorContext arg) {
		final Node node = new Node("TypeSelector", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTypeNamespacePrefix(com.generator.generators.css.parser.css3Parser.TypeNamespacePrefixContext arg) {
		final Node node = new Node("TypeNamespacePrefix", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementName(com.generator.generators.css.parser.css3Parser.ElementNameContext arg) {
		final Node node = new Node("ElementName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUniversal(com.generator.generators.css.parser.css3Parser.UniversalContext arg) {
		final Node node = new Node("Universal", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitClassName(com.generator.generators.css.parser.css3Parser.ClassNameContext arg) {
		final Node node = new Node("ClassName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAttrib(com.generator.generators.css.parser.css3Parser.AttribContext arg) {
		final Node node = new Node("Attrib", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPseudo(com.generator.generators.css.parser.css3Parser.PseudoContext arg) {
		final Node node = new Node("Pseudo", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunctionalPseudo(com.generator.generators.css.parser.css3Parser.FunctionalPseudoContext arg) {
		final Node node = new Node("FunctionalPseudo", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNegation(com.generator.generators.css.parser.css3Parser.NegationContext arg) {
		final Node node = new Node("Negation", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNegationArg(com.generator.generators.css.parser.css3Parser.NegationArgContext arg) {
		final Node node = new Node("NegationArg", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodOperator(com.generator.generators.css.parser.css3Parser.GoodOperatorContext arg) {
		final Node node = new Node("GoodOperator", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadOperator(com.generator.generators.css.parser.css3Parser.BadOperatorContext arg) {
		final Node node = new Node("BadOperator", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGoodProperty(com.generator.generators.css.parser.css3Parser.GoodPropertyContext arg) {
		final Node node = new Node("GoodProperty", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadProperty(com.generator.generators.css.parser.css3Parser.BadPropertyContext arg) {
		final Node node = new Node("BadProperty", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownRuleset(com.generator.generators.css.parser.css3Parser.KnownRulesetContext arg) {
		final Node node = new Node("KnownRuleset", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownRuleset(com.generator.generators.css.parser.css3Parser.UnknownRulesetContext arg) {
		final Node node = new Node("UnknownRuleset", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDeclarationList(com.generator.generators.css.parser.css3Parser.DeclarationListContext arg) {
		final Node node = new Node("DeclarationList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownDeclaration(com.generator.generators.css.parser.css3Parser.KnownDeclarationContext arg) {
		final Node node = new Node("KnownDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownDeclaration(com.generator.generators.css.parser.css3Parser.UnknownDeclarationContext arg) {
		final Node node = new Node("UnknownDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrio(com.generator.generators.css.parser.css3Parser.PrioContext arg) {
		final Node node = new Node("Prio", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitValue(com.generator.generators.css.parser.css3Parser.ValueContext arg) {
		final Node node = new Node("Value", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExpr(com.generator.generators.css.parser.css3Parser.ExprContext arg) {
		final Node node = new Node("Expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownTerm(com.generator.generators.css.parser.css3Parser.KnownTermContext arg) {
		final Node node = new Node("KnownTerm", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownTerm(com.generator.generators.css.parser.css3Parser.UnknownTermContext arg) {
		final Node node = new Node("UnknownTerm", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBadTerm(com.generator.generators.css.parser.css3Parser.BadTermContext arg) {
		final Node node = new Node("BadTerm", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFunction(com.generator.generators.css.parser.css3Parser.FunctionContext arg) {
		final Node node = new Node("Function", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDxImageTransform(com.generator.generators.css.parser.css3Parser.DxImageTransformContext arg) {
		final Node node = new Node("DxImageTransform", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitHexcolor(com.generator.generators.css.parser.css3Parser.HexcolorContext arg) {
		final Node node = new Node("Hexcolor", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPercentage(com.generator.generators.css.parser.css3Parser.PercentageContext arg) {
		final Node node = new Node("Percentage", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDimension(com.generator.generators.css.parser.css3Parser.DimensionContext arg) {
		final Node node = new Node("Dimension", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownDimension(com.generator.generators.css.parser.css3Parser.UnknownDimensionContext arg) {
		final Node node = new Node("UnknownDimension", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAny(com.generator.generators.css.parser.css3Parser.AnyContext arg) {
		final Node node = new Node("Any", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownAtRule(com.generator.generators.css.parser.css3Parser.UnknownAtRuleContext arg) {
		final Node node = new Node("UnknownAtRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtKeyword(com.generator.generators.css.parser.css3Parser.AtKeywordContext arg) {
		final Node node = new Node("AtKeyword", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnused(com.generator.generators.css.parser.css3Parser.UnusedContext arg) {
		final Node node = new Node("Unused", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNestedStatement(com.generator.generators.css.parser.css3Parser.NestedStatementContext arg) {
		final Node node = new Node("NestedStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGroupRuleBody(com.generator.generators.css.parser.css3Parser.GroupRuleBodyContext arg) {
		final Node node = new Node("GroupRuleBody", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsRule(com.generator.generators.css.parser.css3Parser.SupportsRuleContext arg) {
		final Node node = new Node("SupportsRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsCondition(com.generator.generators.css.parser.css3Parser.SupportsConditionContext arg) {
		final Node node = new Node("SupportsCondition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsConditionInParens(com.generator.generators.css.parser.css3Parser.SupportsConditionInParensContext arg) {
		final Node node = new Node("SupportsConditionInParens", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsNegation(com.generator.generators.css.parser.css3Parser.SupportsNegationContext arg) {
		final Node node = new Node("SupportsNegation", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsConjunction(com.generator.generators.css.parser.css3Parser.SupportsConjunctionContext arg) {
		final Node node = new Node("SupportsConjunction", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSupportsDisjunction(com.generator.generators.css.parser.css3Parser.SupportsDisjunctionContext arg) {
		final Node node = new Node("SupportsDisjunction", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGeneralEnclosed(com.generator.generators.css.parser.css3Parser.GeneralEnclosedContext arg) {
		final Node node = new Node("GeneralEnclosed", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitVar(com.generator.generators.css.parser.css3Parser.VarContext arg) {
		final Node node = new Node("Var", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalc(com.generator.generators.css.parser.css3Parser.CalcContext arg) {
		final Node node = new Node("Calc", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcSum(com.generator.generators.css.parser.css3Parser.CalcSumContext arg) {
		final Node node = new Node("CalcSum", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcProduct(com.generator.generators.css.parser.css3Parser.CalcProductContext arg) {
		final Node node = new Node("CalcProduct", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCalcValue(com.generator.generators.css.parser.css3Parser.CalcValueContext arg) {
		final Node node = new Node("CalcValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFaceRule(com.generator.generators.css.parser.css3Parser.FontFaceRuleContext arg) {
		final Node node = new Node("FontFaceRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKnownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.KnownFontFaceDeclarationContext arg) {
		final Node node = new Node("KnownFontFaceDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitUnknownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.UnknownFontFaceDeclarationContext arg) {
		final Node node = new Node("UnknownFontFaceDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframesRule(com.generator.generators.css.parser.css3Parser.KeyframesRuleContext arg) {
		final Node node = new Node("KeyframesRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframesBlocks(com.generator.generators.css.parser.css3Parser.KeyframesBlocksContext arg) {
		final Node node = new Node("KeyframesBlocks", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitKeyframeSelector(com.generator.generators.css.parser.css3Parser.KeyframeSelectorContext arg) {
		final Node node = new Node("KeyframeSelector", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitViewport(com.generator.generators.css.parser.css3Parser.ViewportContext arg) {
		final Node node = new Node("Viewport", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCounterStyle(com.generator.generators.css.parser.css3Parser.CounterStyleContext arg) {
		final Node node = new Node("CounterStyle", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFeatureValuesRule(com.generator.generators.css.parser.css3Parser.FontFeatureValuesRuleContext arg) {
		final Node node = new Node("FontFeatureValuesRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFamilyNameList(com.generator.generators.css.parser.css3Parser.FontFamilyNameListContext arg) {
		final Node node = new Node("FontFamilyNameList", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFontFamilyName(com.generator.generators.css.parser.css3Parser.FontFamilyNameContext arg) {
		final Node node = new Node("FontFamilyName", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureValueBlock(com.generator.generators.css.parser.css3Parser.FeatureValueBlockContext arg) {
		final Node node = new Node("FeatureValueBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureType(com.generator.generators.css.parser.css3Parser.FeatureTypeContext arg) {
		final Node node = new Node("FeatureType", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFeatureValueDefinition(com.generator.generators.css.parser.css3Parser.FeatureValueDefinitionContext arg) {
		final Node node = new Node("FeatureValueDefinition", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdent(com.generator.generators.css.parser.css3Parser.IdentContext arg) {
		final Node node = new Node("Ident", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitWs(com.generator.generators.css.parser.css3Parser.WsContext arg) {
		final Node node = new Node("Ws", arg.getText(), arg.getStart().getText(), arg.getStop().getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}