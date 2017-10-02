package com.generator.generators.css.parser;

public class css3NodeListener extends css3BaseListener {

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

	public css3NodeListener() {
		this(false);
	}

	public css3NodeListener(boolean debug) {
		this.debug = debug;
	}

   protected void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.name + " : (" + nodeStack.peek().startToken + ") (" + node.value + ") (" + nodeStack.peek().endToken + ")");
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

	protected java.util.Stack<Boolean> inBlock = new java.util.Stack<>();

	@Override
	public void enterBlock(com.generator.generators.css.parser.css3Parser.BlockContext arg) {
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBlock.push(true);
	}

	public void exitBlock(com.generator.generators.css.parser.css3Parser.BlockContext arg) {
		onExit();
		this.inBlock.pop();
	}

	public boolean inBlock() {
      return !inBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpression = new java.util.Stack<>();

	@Override
	public void enterExpression(com.generator.generators.css.parser.css3Parser.ExpressionContext arg) {
		onEnter(new Node("Expression", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inExpression.push(true);
	}

	public void exitExpression(com.generator.generators.css.parser.css3Parser.ExpressionContext arg) {
		onExit();
		this.inExpression.pop();
	}

	public boolean inExpression() {
      return !inExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNumber = new java.util.Stack<>();

	@Override
	public void enterNumber(com.generator.generators.css.parser.css3Parser.NumberContext arg) {
		onEnter(new Node("Number", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inNumber.push(true);
	}

	public void exitNumber(com.generator.generators.css.parser.css3Parser.NumberContext arg) {
		onExit();
		this.inNumber.pop();
	}

	public boolean inNumber() {
      return !inNumber.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inStylesheet = new java.util.Stack<>();

	@Override
	public void enterStylesheet(com.generator.generators.css.parser.css3Parser.StylesheetContext arg) {
		onEnter(new Node("Stylesheet", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inStylesheet.push(true);
	}

	public void exitStylesheet(com.generator.generators.css.parser.css3Parser.StylesheetContext arg) {
		onExit();
		this.inStylesheet.pop();
	}

	public boolean inStylesheet() {
      return !inStylesheet.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGoodCharset = new java.util.Stack<>();

	@Override
	public void enterGoodCharset(com.generator.generators.css.parser.css3Parser.GoodCharsetContext arg) {
		onEnter(new Node("GoodCharset", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGoodCharset.push(true);
	}

	public void exitGoodCharset(com.generator.generators.css.parser.css3Parser.GoodCharsetContext arg) {
		onExit();
		this.inGoodCharset.pop();
	}

	public boolean inGoodCharset() {
      return !inGoodCharset.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBadCharset = new java.util.Stack<>();

	@Override
	public void enterBadCharset(com.generator.generators.css.parser.css3Parser.BadCharsetContext arg) {
		onEnter(new Node("BadCharset", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBadCharset.push(true);
	}

	public void exitBadCharset(com.generator.generators.css.parser.css3Parser.BadCharsetContext arg) {
		onExit();
		this.inBadCharset.pop();
	}

	public boolean inBadCharset() {
      return !inBadCharset.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGoodImport = new java.util.Stack<>();

	@Override
	public void enterGoodImport(com.generator.generators.css.parser.css3Parser.GoodImportContext arg) {
		onEnter(new Node("GoodImport", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGoodImport.push(true);
	}

	public void exitGoodImport(com.generator.generators.css.parser.css3Parser.GoodImportContext arg) {
		onExit();
		this.inGoodImport.pop();
	}

	public boolean inGoodImport() {
      return !inGoodImport.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBadImport = new java.util.Stack<>();

	@Override
	public void enterBadImport(com.generator.generators.css.parser.css3Parser.BadImportContext arg) {
		onEnter(new Node("BadImport", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBadImport.push(true);
	}

	public void exitBadImport(com.generator.generators.css.parser.css3Parser.BadImportContext arg) {
		onExit();
		this.inBadImport.pop();
	}

	public boolean inBadImport() {
      return !inBadImport.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGoodNamespace = new java.util.Stack<>();

	@Override
	public void enterGoodNamespace(com.generator.generators.css.parser.css3Parser.GoodNamespaceContext arg) {
		onEnter(new Node("GoodNamespace", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGoodNamespace.push(true);
	}

	public void exitGoodNamespace(com.generator.generators.css.parser.css3Parser.GoodNamespaceContext arg) {
		onExit();
		this.inGoodNamespace.pop();
	}

	public boolean inGoodNamespace() {
      return !inGoodNamespace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBadNamespace = new java.util.Stack<>();

	@Override
	public void enterBadNamespace(com.generator.generators.css.parser.css3Parser.BadNamespaceContext arg) {
		onEnter(new Node("BadNamespace", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBadNamespace.push(true);
	}

	public void exitBadNamespace(com.generator.generators.css.parser.css3Parser.BadNamespaceContext arg) {
		onExit();
		this.inBadNamespace.pop();
	}

	public boolean inBadNamespace() {
      return !inBadNamespace.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNamespacePrefix = new java.util.Stack<>();

	@Override
	public void enterNamespacePrefix(com.generator.generators.css.parser.css3Parser.NamespacePrefixContext arg) {
		onEnter(new Node("NamespacePrefix", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inNamespacePrefix.push(true);
	}

	public void exitNamespacePrefix(com.generator.generators.css.parser.css3Parser.NamespacePrefixContext arg) {
		onExit();
		this.inNamespacePrefix.pop();
	}

	public boolean inNamespacePrefix() {
      return !inNamespacePrefix.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMedia = new java.util.Stack<>();

	@Override
	public void enterMedia(com.generator.generators.css.parser.css3Parser.MediaContext arg) {
		onEnter(new Node("Media", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inMedia.push(true);
	}

	public void exitMedia(com.generator.generators.css.parser.css3Parser.MediaContext arg) {
		onExit();
		this.inMedia.pop();
	}

	public boolean inMedia() {
      return !inMedia.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMediaQueryList = new java.util.Stack<>();

	@Override
	public void enterMediaQueryList(com.generator.generators.css.parser.css3Parser.MediaQueryListContext arg) {
		onEnter(new Node("MediaQueryList", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inMediaQueryList.push(true);
	}

	public void exitMediaQueryList(com.generator.generators.css.parser.css3Parser.MediaQueryListContext arg) {
		onExit();
		this.inMediaQueryList.pop();
	}

	public boolean inMediaQueryList() {
      return !inMediaQueryList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMediaQuery = new java.util.Stack<>();

	@Override
	public void enterMediaQuery(com.generator.generators.css.parser.css3Parser.MediaQueryContext arg) {
		onEnter(new Node("MediaQuery", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inMediaQuery.push(true);
	}

	public void exitMediaQuery(com.generator.generators.css.parser.css3Parser.MediaQueryContext arg) {
		onExit();
		this.inMediaQuery.pop();
	}

	public boolean inMediaQuery() {
      return !inMediaQuery.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMediaType = new java.util.Stack<>();

	@Override
	public void enterMediaType(com.generator.generators.css.parser.css3Parser.MediaTypeContext arg) {
		onEnter(new Node("MediaType", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inMediaType.push(true);
	}

	public void exitMediaType(com.generator.generators.css.parser.css3Parser.MediaTypeContext arg) {
		onExit();
		this.inMediaType.pop();
	}

	public boolean inMediaType() {
      return !inMediaType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMediaExpression = new java.util.Stack<>();

	@Override
	public void enterMediaExpression(com.generator.generators.css.parser.css3Parser.MediaExpressionContext arg) {
		onEnter(new Node("MediaExpression", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inMediaExpression.push(true);
	}

	public void exitMediaExpression(com.generator.generators.css.parser.css3Parser.MediaExpressionContext arg) {
		onExit();
		this.inMediaExpression.pop();
	}

	public boolean inMediaExpression() {
      return !inMediaExpression.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inMediaFeature = new java.util.Stack<>();

	@Override
	public void enterMediaFeature(com.generator.generators.css.parser.css3Parser.MediaFeatureContext arg) {
		onEnter(new Node("MediaFeature", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inMediaFeature.push(true);
	}

	public void exitMediaFeature(com.generator.generators.css.parser.css3Parser.MediaFeatureContext arg) {
		onExit();
		this.inMediaFeature.pop();
	}

	public boolean inMediaFeature() {
      return !inMediaFeature.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPage = new java.util.Stack<>();

	@Override
	public void enterPage(com.generator.generators.css.parser.css3Parser.PageContext arg) {
		onEnter(new Node("Page", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inPage.push(true);
	}

	public void exitPage(com.generator.generators.css.parser.css3Parser.PageContext arg) {
		onExit();
		this.inPage.pop();
	}

	public boolean inPage() {
      return !inPage.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPseudoPage = new java.util.Stack<>();

	@Override
	public void enterPseudoPage(com.generator.generators.css.parser.css3Parser.PseudoPageContext arg) {
		onEnter(new Node("PseudoPage", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inPseudoPage.push(true);
	}

	public void exitPseudoPage(com.generator.generators.css.parser.css3Parser.PseudoPageContext arg) {
		onExit();
		this.inPseudoPage.pop();
	}

	public boolean inPseudoPage() {
      return !inPseudoPage.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelectorGroup = new java.util.Stack<>();

	@Override
	public void enterSelectorGroup(com.generator.generators.css.parser.css3Parser.SelectorGroupContext arg) {
		onEnter(new Node("SelectorGroup", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSelectorGroup.push(true);
	}

	public void exitSelectorGroup(com.generator.generators.css.parser.css3Parser.SelectorGroupContext arg) {
		onExit();
		this.inSelectorGroup.pop();
	}

	public boolean inSelectorGroup() {
      return !inSelectorGroup.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSelector = new java.util.Stack<>();

	@Override
	public void enterSelector(com.generator.generators.css.parser.css3Parser.SelectorContext arg) {
		onEnter(new Node("Selector", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSelector.push(true);
	}

	public void exitSelector(com.generator.generators.css.parser.css3Parser.SelectorContext arg) {
		onExit();
		this.inSelector.pop();
	}

	public boolean inSelector() {
      return !inSelector.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCombinator = new java.util.Stack<>();

	@Override
	public void enterCombinator(com.generator.generators.css.parser.css3Parser.CombinatorContext arg) {
		onEnter(new Node("Combinator", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inCombinator.push(true);
	}

	public void exitCombinator(com.generator.generators.css.parser.css3Parser.CombinatorContext arg) {
		onExit();
		this.inCombinator.pop();
	}

	public boolean inCombinator() {
      return !inCombinator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSimpleSelectorSequence = new java.util.Stack<>();

	@Override
	public void enterSimpleSelectorSequence(com.generator.generators.css.parser.css3Parser.SimpleSelectorSequenceContext arg) {
		onEnter(new Node("SimpleSelectorSequence", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSimpleSelectorSequence.push(true);
	}

	public void exitSimpleSelectorSequence(com.generator.generators.css.parser.css3Parser.SimpleSelectorSequenceContext arg) {
		onExit();
		this.inSimpleSelectorSequence.pop();
	}

	public boolean inSimpleSelectorSequence() {
      return !inSimpleSelectorSequence.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeSelector = new java.util.Stack<>();

	@Override
	public void enterTypeSelector(com.generator.generators.css.parser.css3Parser.TypeSelectorContext arg) {
		onEnter(new Node("TypeSelector", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inTypeSelector.push(true);
	}

	public void exitTypeSelector(com.generator.generators.css.parser.css3Parser.TypeSelectorContext arg) {
		onExit();
		this.inTypeSelector.pop();
	}

	public boolean inTypeSelector() {
      return !inTypeSelector.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inTypeNamespacePrefix = new java.util.Stack<>();

	@Override
	public void enterTypeNamespacePrefix(com.generator.generators.css.parser.css3Parser.TypeNamespacePrefixContext arg) {
		onEnter(new Node("TypeNamespacePrefix", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inTypeNamespacePrefix.push(true);
	}

	public void exitTypeNamespacePrefix(com.generator.generators.css.parser.css3Parser.TypeNamespacePrefixContext arg) {
		onExit();
		this.inTypeNamespacePrefix.pop();
	}

	public boolean inTypeNamespacePrefix() {
      return !inTypeNamespacePrefix.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inElementName = new java.util.Stack<>();

	@Override
	public void enterElementName(com.generator.generators.css.parser.css3Parser.ElementNameContext arg) {
		onEnter(new Node("ElementName", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inElementName.push(true);
	}

	public void exitElementName(com.generator.generators.css.parser.css3Parser.ElementNameContext arg) {
		onExit();
		this.inElementName.pop();
	}

	public boolean inElementName() {
      return !inElementName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUniversal = new java.util.Stack<>();

	@Override
	public void enterUniversal(com.generator.generators.css.parser.css3Parser.UniversalContext arg) {
		onEnter(new Node("Universal", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inUniversal.push(true);
	}

	public void exitUniversal(com.generator.generators.css.parser.css3Parser.UniversalContext arg) {
		onExit();
		this.inUniversal.pop();
	}

	public boolean inUniversal() {
      return !inUniversal.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inClassName = new java.util.Stack<>();

	@Override
	public void enterClassName(com.generator.generators.css.parser.css3Parser.ClassNameContext arg) {
		onEnter(new Node("ClassName", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inClassName.push(true);
	}

	public void exitClassName(com.generator.generators.css.parser.css3Parser.ClassNameContext arg) {
		onExit();
		this.inClassName.pop();
	}

	public boolean inClassName() {
      return !inClassName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAttrib = new java.util.Stack<>();

	@Override
	public void enterAttrib(com.generator.generators.css.parser.css3Parser.AttribContext arg) {
		onEnter(new Node("Attrib", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inAttrib.push(true);
	}

	public void exitAttrib(com.generator.generators.css.parser.css3Parser.AttribContext arg) {
		onExit();
		this.inAttrib.pop();
	}

	public boolean inAttrib() {
      return !inAttrib.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPseudo = new java.util.Stack<>();

	@Override
	public void enterPseudo(com.generator.generators.css.parser.css3Parser.PseudoContext arg) {
		onEnter(new Node("Pseudo", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inPseudo.push(true);
	}

	public void exitPseudo(com.generator.generators.css.parser.css3Parser.PseudoContext arg) {
		onExit();
		this.inPseudo.pop();
	}

	public boolean inPseudo() {
      return !inPseudo.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunctionalPseudo = new java.util.Stack<>();

	@Override
	public void enterFunctionalPseudo(com.generator.generators.css.parser.css3Parser.FunctionalPseudoContext arg) {
		onEnter(new Node("FunctionalPseudo", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFunctionalPseudo.push(true);
	}

	public void exitFunctionalPseudo(com.generator.generators.css.parser.css3Parser.FunctionalPseudoContext arg) {
		onExit();
		this.inFunctionalPseudo.pop();
	}

	public boolean inFunctionalPseudo() {
      return !inFunctionalPseudo.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNegation = new java.util.Stack<>();

	@Override
	public void enterNegation(com.generator.generators.css.parser.css3Parser.NegationContext arg) {
		onEnter(new Node("Negation", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inNegation.push(true);
	}

	public void exitNegation(com.generator.generators.css.parser.css3Parser.NegationContext arg) {
		onExit();
		this.inNegation.pop();
	}

	public boolean inNegation() {
      return !inNegation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNegationArg = new java.util.Stack<>();

	@Override
	public void enterNegationArg(com.generator.generators.css.parser.css3Parser.NegationArgContext arg) {
		onEnter(new Node("NegationArg", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inNegationArg.push(true);
	}

	public void exitNegationArg(com.generator.generators.css.parser.css3Parser.NegationArgContext arg) {
		onExit();
		this.inNegationArg.pop();
	}

	public boolean inNegationArg() {
      return !inNegationArg.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGoodOperator = new java.util.Stack<>();

	@Override
	public void enterGoodOperator(com.generator.generators.css.parser.css3Parser.GoodOperatorContext arg) {
		onEnter(new Node("GoodOperator", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGoodOperator.push(true);
	}

	public void exitGoodOperator(com.generator.generators.css.parser.css3Parser.GoodOperatorContext arg) {
		onExit();
		this.inGoodOperator.pop();
	}

	public boolean inGoodOperator() {
      return !inGoodOperator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBadOperator = new java.util.Stack<>();

	@Override
	public void enterBadOperator(com.generator.generators.css.parser.css3Parser.BadOperatorContext arg) {
		onEnter(new Node("BadOperator", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBadOperator.push(true);
	}

	public void exitBadOperator(com.generator.generators.css.parser.css3Parser.BadOperatorContext arg) {
		onExit();
		this.inBadOperator.pop();
	}

	public boolean inBadOperator() {
      return !inBadOperator.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGoodProperty = new java.util.Stack<>();

	@Override
	public void enterGoodProperty(com.generator.generators.css.parser.css3Parser.GoodPropertyContext arg) {
		onEnter(new Node("GoodProperty", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGoodProperty.push(true);
	}

	public void exitGoodProperty(com.generator.generators.css.parser.css3Parser.GoodPropertyContext arg) {
		onExit();
		this.inGoodProperty.pop();
	}

	public boolean inGoodProperty() {
      return !inGoodProperty.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBadProperty = new java.util.Stack<>();

	@Override
	public void enterBadProperty(com.generator.generators.css.parser.css3Parser.BadPropertyContext arg) {
		onEnter(new Node("BadProperty", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBadProperty.push(true);
	}

	public void exitBadProperty(com.generator.generators.css.parser.css3Parser.BadPropertyContext arg) {
		onExit();
		this.inBadProperty.pop();
	}

	public boolean inBadProperty() {
      return !inBadProperty.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKnownRuleset = new java.util.Stack<>();

	@Override
	public void enterKnownRuleset(com.generator.generators.css.parser.css3Parser.KnownRulesetContext arg) {
		onEnter(new Node("KnownRuleset", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inKnownRuleset.push(true);
	}

	public void exitKnownRuleset(com.generator.generators.css.parser.css3Parser.KnownRulesetContext arg) {
		onExit();
		this.inKnownRuleset.pop();
	}

	public boolean inKnownRuleset() {
      return !inKnownRuleset.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnknownRuleset = new java.util.Stack<>();

	@Override
	public void enterUnknownRuleset(com.generator.generators.css.parser.css3Parser.UnknownRulesetContext arg) {
		onEnter(new Node("UnknownRuleset", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inUnknownRuleset.push(true);
	}

	public void exitUnknownRuleset(com.generator.generators.css.parser.css3Parser.UnknownRulesetContext arg) {
		onExit();
		this.inUnknownRuleset.pop();
	}

	public boolean inUnknownRuleset() {
      return !inUnknownRuleset.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDeclarationList = new java.util.Stack<>();

	@Override
	public void enterDeclarationList(com.generator.generators.css.parser.css3Parser.DeclarationListContext arg) {
		onEnter(new Node("DeclarationList", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inDeclarationList.push(true);
	}

	public void exitDeclarationList(com.generator.generators.css.parser.css3Parser.DeclarationListContext arg) {
		onExit();
		this.inDeclarationList.pop();
	}

	public boolean inDeclarationList() {
      return !inDeclarationList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKnownDeclaration = new java.util.Stack<>();

	@Override
	public void enterKnownDeclaration(com.generator.generators.css.parser.css3Parser.KnownDeclarationContext arg) {
		onEnter(new Node("KnownDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inKnownDeclaration.push(true);
	}

	public void exitKnownDeclaration(com.generator.generators.css.parser.css3Parser.KnownDeclarationContext arg) {
		onExit();
		this.inKnownDeclaration.pop();
	}

	public boolean inKnownDeclaration() {
      return !inKnownDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnknownDeclaration = new java.util.Stack<>();

	@Override
	public void enterUnknownDeclaration(com.generator.generators.css.parser.css3Parser.UnknownDeclarationContext arg) {
		onEnter(new Node("UnknownDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inUnknownDeclaration.push(true);
	}

	public void exitUnknownDeclaration(com.generator.generators.css.parser.css3Parser.UnknownDeclarationContext arg) {
		onExit();
		this.inUnknownDeclaration.pop();
	}

	public boolean inUnknownDeclaration() {
      return !inUnknownDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPrio = new java.util.Stack<>();

	@Override
	public void enterPrio(com.generator.generators.css.parser.css3Parser.PrioContext arg) {
		onEnter(new Node("Prio", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inPrio.push(true);
	}

	public void exitPrio(com.generator.generators.css.parser.css3Parser.PrioContext arg) {
		onExit();
		this.inPrio.pop();
	}

	public boolean inPrio() {
      return !inPrio.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inValue = new java.util.Stack<>();

	@Override
	public void enterValue(com.generator.generators.css.parser.css3Parser.ValueContext arg) {
		onEnter(new Node("Value", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inValue.push(true);
	}

	public void exitValue(com.generator.generators.css.parser.css3Parser.ValueContext arg) {
		onExit();
		this.inValue.pop();
	}

	public boolean inValue() {
      return !inValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inExpr = new java.util.Stack<>();

	@Override
	public void enterExpr(com.generator.generators.css.parser.css3Parser.ExprContext arg) {
		onEnter(new Node("Expr", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inExpr.push(true);
	}

	public void exitExpr(com.generator.generators.css.parser.css3Parser.ExprContext arg) {
		onExit();
		this.inExpr.pop();
	}

	public boolean inExpr() {
      return !inExpr.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKnownTerm = new java.util.Stack<>();

	@Override
	public void enterKnownTerm(com.generator.generators.css.parser.css3Parser.KnownTermContext arg) {
		onEnter(new Node("KnownTerm", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inKnownTerm.push(true);
	}

	public void exitKnownTerm(com.generator.generators.css.parser.css3Parser.KnownTermContext arg) {
		onExit();
		this.inKnownTerm.pop();
	}

	public boolean inKnownTerm() {
      return !inKnownTerm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnknownTerm = new java.util.Stack<>();

	@Override
	public void enterUnknownTerm(com.generator.generators.css.parser.css3Parser.UnknownTermContext arg) {
		onEnter(new Node("UnknownTerm", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inUnknownTerm.push(true);
	}

	public void exitUnknownTerm(com.generator.generators.css.parser.css3Parser.UnknownTermContext arg) {
		onExit();
		this.inUnknownTerm.pop();
	}

	public boolean inUnknownTerm() {
      return !inUnknownTerm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inBadTerm = new java.util.Stack<>();

	@Override
	public void enterBadTerm(com.generator.generators.css.parser.css3Parser.BadTermContext arg) {
		onEnter(new Node("BadTerm", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inBadTerm.push(true);
	}

	public void exitBadTerm(com.generator.generators.css.parser.css3Parser.BadTermContext arg) {
		onExit();
		this.inBadTerm.pop();
	}

	public boolean inBadTerm() {
      return !inBadTerm.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFunction = new java.util.Stack<>();

	@Override
	public void enterFunction(com.generator.generators.css.parser.css3Parser.FunctionContext arg) {
		onEnter(new Node("Function", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFunction.push(true);
	}

	public void exitFunction(com.generator.generators.css.parser.css3Parser.FunctionContext arg) {
		onExit();
		this.inFunction.pop();
	}

	public boolean inFunction() {
      return !inFunction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDxImageTransform = new java.util.Stack<>();

	@Override
	public void enterDxImageTransform(com.generator.generators.css.parser.css3Parser.DxImageTransformContext arg) {
		onEnter(new Node("DxImageTransform", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inDxImageTransform.push(true);
	}

	public void exitDxImageTransform(com.generator.generators.css.parser.css3Parser.DxImageTransformContext arg) {
		onExit();
		this.inDxImageTransform.pop();
	}

	public boolean inDxImageTransform() {
      return !inDxImageTransform.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inHexcolor = new java.util.Stack<>();

	@Override
	public void enterHexcolor(com.generator.generators.css.parser.css3Parser.HexcolorContext arg) {
		onEnter(new Node("Hexcolor", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inHexcolor.push(true);
	}

	public void exitHexcolor(com.generator.generators.css.parser.css3Parser.HexcolorContext arg) {
		onExit();
		this.inHexcolor.pop();
	}

	public boolean inHexcolor() {
      return !inHexcolor.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inPercentage = new java.util.Stack<>();

	@Override
	public void enterPercentage(com.generator.generators.css.parser.css3Parser.PercentageContext arg) {
		onEnter(new Node("Percentage", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inPercentage.push(true);
	}

	public void exitPercentage(com.generator.generators.css.parser.css3Parser.PercentageContext arg) {
		onExit();
		this.inPercentage.pop();
	}

	public boolean inPercentage() {
      return !inPercentage.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inDimension = new java.util.Stack<>();

	@Override
	public void enterDimension(com.generator.generators.css.parser.css3Parser.DimensionContext arg) {
		onEnter(new Node("Dimension", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inDimension.push(true);
	}

	public void exitDimension(com.generator.generators.css.parser.css3Parser.DimensionContext arg) {
		onExit();
		this.inDimension.pop();
	}

	public boolean inDimension() {
      return !inDimension.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnknownDimension = new java.util.Stack<>();

	@Override
	public void enterUnknownDimension(com.generator.generators.css.parser.css3Parser.UnknownDimensionContext arg) {
		onEnter(new Node("UnknownDimension", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inUnknownDimension.push(true);
	}

	public void exitUnknownDimension(com.generator.generators.css.parser.css3Parser.UnknownDimensionContext arg) {
		onExit();
		this.inUnknownDimension.pop();
	}

	public boolean inUnknownDimension() {
      return !inUnknownDimension.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAny = new java.util.Stack<>();

	@Override
	public void enterAny(com.generator.generators.css.parser.css3Parser.AnyContext arg) {
		onEnter(new Node("Any", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inAny.push(true);
	}

	public void exitAny(com.generator.generators.css.parser.css3Parser.AnyContext arg) {
		onExit();
		this.inAny.pop();
	}

	public boolean inAny() {
      return !inAny.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnknownAtRule = new java.util.Stack<>();

	@Override
	public void enterUnknownAtRule(com.generator.generators.css.parser.css3Parser.UnknownAtRuleContext arg) {
		onEnter(new Node("UnknownAtRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inUnknownAtRule.push(true);
	}

	public void exitUnknownAtRule(com.generator.generators.css.parser.css3Parser.UnknownAtRuleContext arg) {
		onExit();
		this.inUnknownAtRule.pop();
	}

	public boolean inUnknownAtRule() {
      return !inUnknownAtRule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inAtKeyword = new java.util.Stack<>();

	@Override
	public void enterAtKeyword(com.generator.generators.css.parser.css3Parser.AtKeywordContext arg) {
		onEnter(new Node("AtKeyword", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inAtKeyword.push(true);
	}

	public void exitAtKeyword(com.generator.generators.css.parser.css3Parser.AtKeywordContext arg) {
		onExit();
		this.inAtKeyword.pop();
	}

	public boolean inAtKeyword() {
      return !inAtKeyword.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnused = new java.util.Stack<>();

	@Override
	public void enterUnused(com.generator.generators.css.parser.css3Parser.UnusedContext arg) {
		onEnter(new Node("Unused", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inUnused.push(true);
	}

	public void exitUnused(com.generator.generators.css.parser.css3Parser.UnusedContext arg) {
		onExit();
		this.inUnused.pop();
	}

	public boolean inUnused() {
      return !inUnused.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inNestedStatement = new java.util.Stack<>();

	@Override
	public void enterNestedStatement(com.generator.generators.css.parser.css3Parser.NestedStatementContext arg) {
		onEnter(new Node("NestedStatement", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inNestedStatement.push(true);
	}

	public void exitNestedStatement(com.generator.generators.css.parser.css3Parser.NestedStatementContext arg) {
		onExit();
		this.inNestedStatement.pop();
	}

	public boolean inNestedStatement() {
      return !inNestedStatement.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGroupRuleBody = new java.util.Stack<>();

	@Override
	public void enterGroupRuleBody(com.generator.generators.css.parser.css3Parser.GroupRuleBodyContext arg) {
		onEnter(new Node("GroupRuleBody", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGroupRuleBody.push(true);
	}

	public void exitGroupRuleBody(com.generator.generators.css.parser.css3Parser.GroupRuleBodyContext arg) {
		onExit();
		this.inGroupRuleBody.pop();
	}

	public boolean inGroupRuleBody() {
      return !inGroupRuleBody.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSupportsRule = new java.util.Stack<>();

	@Override
	public void enterSupportsRule(com.generator.generators.css.parser.css3Parser.SupportsRuleContext arg) {
		onEnter(new Node("SupportsRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSupportsRule.push(true);
	}

	public void exitSupportsRule(com.generator.generators.css.parser.css3Parser.SupportsRuleContext arg) {
		onExit();
		this.inSupportsRule.pop();
	}

	public boolean inSupportsRule() {
      return !inSupportsRule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSupportsCondition = new java.util.Stack<>();

	@Override
	public void enterSupportsCondition(com.generator.generators.css.parser.css3Parser.SupportsConditionContext arg) {
		onEnter(new Node("SupportsCondition", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSupportsCondition.push(true);
	}

	public void exitSupportsCondition(com.generator.generators.css.parser.css3Parser.SupportsConditionContext arg) {
		onExit();
		this.inSupportsCondition.pop();
	}

	public boolean inSupportsCondition() {
      return !inSupportsCondition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSupportsConditionInParens = new java.util.Stack<>();

	@Override
	public void enterSupportsConditionInParens(com.generator.generators.css.parser.css3Parser.SupportsConditionInParensContext arg) {
		onEnter(new Node("SupportsConditionInParens", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSupportsConditionInParens.push(true);
	}

	public void exitSupportsConditionInParens(com.generator.generators.css.parser.css3Parser.SupportsConditionInParensContext arg) {
		onExit();
		this.inSupportsConditionInParens.pop();
	}

	public boolean inSupportsConditionInParens() {
      return !inSupportsConditionInParens.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSupportsNegation = new java.util.Stack<>();

	@Override
	public void enterSupportsNegation(com.generator.generators.css.parser.css3Parser.SupportsNegationContext arg) {
		onEnter(new Node("SupportsNegation", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSupportsNegation.push(true);
	}

	public void exitSupportsNegation(com.generator.generators.css.parser.css3Parser.SupportsNegationContext arg) {
		onExit();
		this.inSupportsNegation.pop();
	}

	public boolean inSupportsNegation() {
      return !inSupportsNegation.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSupportsConjunction = new java.util.Stack<>();

	@Override
	public void enterSupportsConjunction(com.generator.generators.css.parser.css3Parser.SupportsConjunctionContext arg) {
		onEnter(new Node("SupportsConjunction", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSupportsConjunction.push(true);
	}

	public void exitSupportsConjunction(com.generator.generators.css.parser.css3Parser.SupportsConjunctionContext arg) {
		onExit();
		this.inSupportsConjunction.pop();
	}

	public boolean inSupportsConjunction() {
      return !inSupportsConjunction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSupportsDisjunction = new java.util.Stack<>();

	@Override
	public void enterSupportsDisjunction(com.generator.generators.css.parser.css3Parser.SupportsDisjunctionContext arg) {
		onEnter(new Node("SupportsDisjunction", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSupportsDisjunction.push(true);
	}

	public void exitSupportsDisjunction(com.generator.generators.css.parser.css3Parser.SupportsDisjunctionContext arg) {
		onExit();
		this.inSupportsDisjunction.pop();
	}

	public boolean inSupportsDisjunction() {
      return !inSupportsDisjunction.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inSupportsDeclarationCondition = new java.util.Stack<>();

	@Override
	public void enterSupportsDeclarationCondition(com.generator.generators.css.parser.css3Parser.SupportsDeclarationConditionContext arg) {
		onEnter(new Node("SupportsDeclarationCondition", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inSupportsDeclarationCondition.push(true);
	}

	public void exitSupportsDeclarationCondition(com.generator.generators.css.parser.css3Parser.SupportsDeclarationConditionContext arg) {
		onExit();
		this.inSupportsDeclarationCondition.pop();
	}

	public boolean inSupportsDeclarationCondition() {
      return !inSupportsDeclarationCondition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inGeneralEnclosed = new java.util.Stack<>();

	@Override
	public void enterGeneralEnclosed(com.generator.generators.css.parser.css3Parser.GeneralEnclosedContext arg) {
		onEnter(new Node("GeneralEnclosed", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inGeneralEnclosed.push(true);
	}

	public void exitGeneralEnclosed(com.generator.generators.css.parser.css3Parser.GeneralEnclosedContext arg) {
		onExit();
		this.inGeneralEnclosed.pop();
	}

	public boolean inGeneralEnclosed() {
      return !inGeneralEnclosed.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inVar = new java.util.Stack<>();

	@Override
	public void enterVar(com.generator.generators.css.parser.css3Parser.VarContext arg) {
		onEnter(new Node("Var", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inVar.push(true);
	}

	public void exitVar(com.generator.generators.css.parser.css3Parser.VarContext arg) {
		onExit();
		this.inVar.pop();
	}

	public boolean inVar() {
      return !inVar.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCalc = new java.util.Stack<>();

	@Override
	public void enterCalc(com.generator.generators.css.parser.css3Parser.CalcContext arg) {
		onEnter(new Node("Calc", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inCalc.push(true);
	}

	public void exitCalc(com.generator.generators.css.parser.css3Parser.CalcContext arg) {
		onExit();
		this.inCalc.pop();
	}

	public boolean inCalc() {
      return !inCalc.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCalcSum = new java.util.Stack<>();

	@Override
	public void enterCalcSum(com.generator.generators.css.parser.css3Parser.CalcSumContext arg) {
		onEnter(new Node("CalcSum", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inCalcSum.push(true);
	}

	public void exitCalcSum(com.generator.generators.css.parser.css3Parser.CalcSumContext arg) {
		onExit();
		this.inCalcSum.pop();
	}

	public boolean inCalcSum() {
      return !inCalcSum.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCalcProduct = new java.util.Stack<>();

	@Override
	public void enterCalcProduct(com.generator.generators.css.parser.css3Parser.CalcProductContext arg) {
		onEnter(new Node("CalcProduct", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inCalcProduct.push(true);
	}

	public void exitCalcProduct(com.generator.generators.css.parser.css3Parser.CalcProductContext arg) {
		onExit();
		this.inCalcProduct.pop();
	}

	public boolean inCalcProduct() {
      return !inCalcProduct.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCalcValue = new java.util.Stack<>();

	@Override
	public void enterCalcValue(com.generator.generators.css.parser.css3Parser.CalcValueContext arg) {
		onEnter(new Node("CalcValue", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inCalcValue.push(true);
	}

	public void exitCalcValue(com.generator.generators.css.parser.css3Parser.CalcValueContext arg) {
		onExit();
		this.inCalcValue.pop();
	}

	public boolean inCalcValue() {
      return !inCalcValue.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFontFaceRule = new java.util.Stack<>();

	@Override
	public void enterFontFaceRule(com.generator.generators.css.parser.css3Parser.FontFaceRuleContext arg) {
		onEnter(new Node("FontFaceRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFontFaceRule.push(true);
	}

	public void exitFontFaceRule(com.generator.generators.css.parser.css3Parser.FontFaceRuleContext arg) {
		onExit();
		this.inFontFaceRule.pop();
	}

	public boolean inFontFaceRule() {
      return !inFontFaceRule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKnownFontFaceDeclaration = new java.util.Stack<>();

	@Override
	public void enterKnownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.KnownFontFaceDeclarationContext arg) {
		onEnter(new Node("KnownFontFaceDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inKnownFontFaceDeclaration.push(true);
	}

	public void exitKnownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.KnownFontFaceDeclarationContext arg) {
		onExit();
		this.inKnownFontFaceDeclaration.pop();
	}

	public boolean inKnownFontFaceDeclaration() {
      return !inKnownFontFaceDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inUnknownFontFaceDeclaration = new java.util.Stack<>();

	@Override
	public void enterUnknownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.UnknownFontFaceDeclarationContext arg) {
		onEnter(new Node("UnknownFontFaceDeclaration", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inUnknownFontFaceDeclaration.push(true);
	}

	public void exitUnknownFontFaceDeclaration(com.generator.generators.css.parser.css3Parser.UnknownFontFaceDeclarationContext arg) {
		onExit();
		this.inUnknownFontFaceDeclaration.pop();
	}

	public boolean inUnknownFontFaceDeclaration() {
      return !inUnknownFontFaceDeclaration.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyframesRule = new java.util.Stack<>();

	@Override
	public void enterKeyframesRule(com.generator.generators.css.parser.css3Parser.KeyframesRuleContext arg) {
		onEnter(new Node("KeyframesRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inKeyframesRule.push(true);
	}

	public void exitKeyframesRule(com.generator.generators.css.parser.css3Parser.KeyframesRuleContext arg) {
		onExit();
		this.inKeyframesRule.pop();
	}

	public boolean inKeyframesRule() {
      return !inKeyframesRule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyframesBlocks = new java.util.Stack<>();

	@Override
	public void enterKeyframesBlocks(com.generator.generators.css.parser.css3Parser.KeyframesBlocksContext arg) {
		onEnter(new Node("KeyframesBlocks", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inKeyframesBlocks.push(true);
	}

	public void exitKeyframesBlocks(com.generator.generators.css.parser.css3Parser.KeyframesBlocksContext arg) {
		onExit();
		this.inKeyframesBlocks.pop();
	}

	public boolean inKeyframesBlocks() {
      return !inKeyframesBlocks.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inKeyframeSelector = new java.util.Stack<>();

	@Override
	public void enterKeyframeSelector(com.generator.generators.css.parser.css3Parser.KeyframeSelectorContext arg) {
		onEnter(new Node("KeyframeSelector", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inKeyframeSelector.push(true);
	}

	public void exitKeyframeSelector(com.generator.generators.css.parser.css3Parser.KeyframeSelectorContext arg) {
		onExit();
		this.inKeyframeSelector.pop();
	}

	public boolean inKeyframeSelector() {
      return !inKeyframeSelector.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inViewport = new java.util.Stack<>();

	@Override
	public void enterViewport(com.generator.generators.css.parser.css3Parser.ViewportContext arg) {
		onEnter(new Node("Viewport", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inViewport.push(true);
	}

	public void exitViewport(com.generator.generators.css.parser.css3Parser.ViewportContext arg) {
		onExit();
		this.inViewport.pop();
	}

	public boolean inViewport() {
      return !inViewport.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inCounterStyle = new java.util.Stack<>();

	@Override
	public void enterCounterStyle(com.generator.generators.css.parser.css3Parser.CounterStyleContext arg) {
		onEnter(new Node("CounterStyle", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inCounterStyle.push(true);
	}

	public void exitCounterStyle(com.generator.generators.css.parser.css3Parser.CounterStyleContext arg) {
		onExit();
		this.inCounterStyle.pop();
	}

	public boolean inCounterStyle() {
      return !inCounterStyle.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFontFeatureValuesRule = new java.util.Stack<>();

	@Override
	public void enterFontFeatureValuesRule(com.generator.generators.css.parser.css3Parser.FontFeatureValuesRuleContext arg) {
		onEnter(new Node("FontFeatureValuesRule", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFontFeatureValuesRule.push(true);
	}

	public void exitFontFeatureValuesRule(com.generator.generators.css.parser.css3Parser.FontFeatureValuesRuleContext arg) {
		onExit();
		this.inFontFeatureValuesRule.pop();
	}

	public boolean inFontFeatureValuesRule() {
      return !inFontFeatureValuesRule.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFontFamilyNameList = new java.util.Stack<>();

	@Override
	public void enterFontFamilyNameList(com.generator.generators.css.parser.css3Parser.FontFamilyNameListContext arg) {
		onEnter(new Node("FontFamilyNameList", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFontFamilyNameList.push(true);
	}

	public void exitFontFamilyNameList(com.generator.generators.css.parser.css3Parser.FontFamilyNameListContext arg) {
		onExit();
		this.inFontFamilyNameList.pop();
	}

	public boolean inFontFamilyNameList() {
      return !inFontFamilyNameList.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFontFamilyName = new java.util.Stack<>();

	@Override
	public void enterFontFamilyName(com.generator.generators.css.parser.css3Parser.FontFamilyNameContext arg) {
		onEnter(new Node("FontFamilyName", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFontFamilyName.push(true);
	}

	public void exitFontFamilyName(com.generator.generators.css.parser.css3Parser.FontFamilyNameContext arg) {
		onExit();
		this.inFontFamilyName.pop();
	}

	public boolean inFontFamilyName() {
      return !inFontFamilyName.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFeatureValueBlock = new java.util.Stack<>();

	@Override
	public void enterFeatureValueBlock(com.generator.generators.css.parser.css3Parser.FeatureValueBlockContext arg) {
		onEnter(new Node("FeatureValueBlock", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFeatureValueBlock.push(true);
	}

	public void exitFeatureValueBlock(com.generator.generators.css.parser.css3Parser.FeatureValueBlockContext arg) {
		onExit();
		this.inFeatureValueBlock.pop();
	}

	public boolean inFeatureValueBlock() {
      return !inFeatureValueBlock.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFeatureType = new java.util.Stack<>();

	@Override
	public void enterFeatureType(com.generator.generators.css.parser.css3Parser.FeatureTypeContext arg) {
		onEnter(new Node("FeatureType", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFeatureType.push(true);
	}

	public void exitFeatureType(com.generator.generators.css.parser.css3Parser.FeatureTypeContext arg) {
		onExit();
		this.inFeatureType.pop();
	}

	public boolean inFeatureType() {
      return !inFeatureType.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inFeatureValueDefinition = new java.util.Stack<>();

	@Override
	public void enterFeatureValueDefinition(com.generator.generators.css.parser.css3Parser.FeatureValueDefinitionContext arg) {
		onEnter(new Node("FeatureValueDefinition", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inFeatureValueDefinition.push(true);
	}

	public void exitFeatureValueDefinition(com.generator.generators.css.parser.css3Parser.FeatureValueDefinitionContext arg) {
		onExit();
		this.inFeatureValueDefinition.pop();
	}

	public boolean inFeatureValueDefinition() {
      return !inFeatureValueDefinition.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inIdent = new java.util.Stack<>();

	@Override
	public void enterIdent(com.generator.generators.css.parser.css3Parser.IdentContext arg) {
		onEnter(new Node("Ident", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inIdent.push(true);
	}

	public void exitIdent(com.generator.generators.css.parser.css3Parser.IdentContext arg) {
		onExit();
		this.inIdent.pop();
	}

	public boolean inIdent() {
      return !inIdent.isEmpty(); 
   }

	protected java.util.Stack<Boolean> inWs = new java.util.Stack<>();

	@Override
	public void enterWs(com.generator.generators.css.parser.css3Parser.WsContext arg) {
		onEnter(new Node("Ws", arg.getText(), arg.getStart().getText(), arg.getStop().getText()));
		this.inWs.push(true);
	}

	public void exitWs(com.generator.generators.css.parser.css3Parser.WsContext arg) {
		onExit();
		this.inWs.pop();
	}

	public boolean inWs() {
      return !inWs.isEmpty(); 
   }

}