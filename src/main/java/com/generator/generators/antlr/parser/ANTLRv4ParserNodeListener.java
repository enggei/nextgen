package com.generator.generators.antlr.parser;

public class ANTLRv4ParserNodeListener extends ANTLRv4ParserBaseListener {

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
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;

	public ANTLRv4ParserNodeListener() {
		this(false);
	}

	public ANTLRv4ParserNodeListener(boolean debug) {
		this.debug = debug;
	}

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
		delim.append("\t");
		if (debug) System.out.println(delim.toString() + node.name);
   }

   void onExit() {
      if (nodeStack.size() > 1) {
			nodeStack.pop();
         delim.deleteCharAt(delim.length() - 1);
		}
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public void enterGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		 onEnter(new Node("GrammarType", arg.getText(), arg.getStart().getText()));
	}

	public void exitGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		 onEnter(new Node("PrequelConstruct", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		 onExit();
	}

	@Override
	public void enterOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		 onEnter(new Node("OptionsSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		 onEnter(new Node("Option", arg.getText(), arg.getStart().getText()));
	}

	public void exitOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		 onExit();
	}

	@Override
	public void enterOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		 onEnter(new Node("OptionValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		 onExit();
	}

	@Override
	public void enterDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		 onEnter(new Node("DelegateGrammars", arg.getText(), arg.getStart().getText()));
	}

	public void exitDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		 onExit();
	}

	@Override
	public void enterDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		 onEnter(new Node("DelegateGrammar", arg.getText(), arg.getStart().getText()));
	}

	public void exitDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		 onExit();
	}

	@Override
	public void enterTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		 onEnter(new Node("TokensSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		 onEnter(new Node("ChannelsSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		 onEnter(new Node("IdList", arg.getText(), arg.getStart().getText()));
	}

	public void exitIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		 onExit();
	}

	@Override
	public void enterAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		 onEnter(new Node("Action", arg.getText(), arg.getStart().getText()));
	}

	public void exitAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		 onExit();
	}

	@Override
	public void enterActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		 onEnter(new Node("ActionScopeName", arg.getText(), arg.getStart().getText()));
	}

	public void exitActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		 onExit();
	}

	@Override
	public void enterActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		 onEnter(new Node("ActionBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		 onEnter(new Node("ArgActionBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		 onEnter(new Node("ModeSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		 onEnter(new Node("Rules", arg.getText(), arg.getStart().getText()));
	}

	public void exitRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		 onEnter(new Node("RuleSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		 onEnter(new Node("ParserRuleSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		 onEnter(new Node("ExceptionGroup", arg.getText(), arg.getStart().getText()));
	}

	public void exitExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		 onExit();
	}

	@Override
	public void enterExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		 onEnter(new Node("ExceptionHandler", arg.getText(), arg.getStart().getText()));
	}

	public void exitExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		 onExit();
	}

	@Override
	public void enterFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		 onEnter(new Node("FinallyClause", arg.getText(), arg.getStart().getText()));
	}

	public void exitFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		 onExit();
	}

	@Override
	public void enterRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		 onEnter(new Node("RulePrequel", arg.getText(), arg.getStart().getText()));
	}

	public void exitRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		 onEnter(new Node("RuleReturns", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		 onExit();
	}

	@Override
	public void enterThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		 onEnter(new Node("ThrowsSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		 onEnter(new Node("LocalsSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		 onEnter(new Node("RuleAction", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		 onEnter(new Node("RuleModifiers", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		 onEnter(new Node("RuleModifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		 onEnter(new Node("RuleBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		 onEnter(new Node("RuleAltList", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		 onExit();
	}

	@Override
	public void enterLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		 onEnter(new Node("LabeledAlt", arg.getText(), arg.getStart().getText()));
	}

	public void exitLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		 onExit();
	}

	@Override
	public void enterGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		 onEnter(new Node("GrammarSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		 onEnter(new Node("LexerRuleSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		 onEnter(new Node("LexerRuleBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		 onEnter(new Node("LexerAltList", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		 onEnter(new Node("LexerAlt", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		 onEnter(new Node("LexerElements", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		 onEnter(new Node("LexerElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		 onExit();
	}

	@Override
	public void enterLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		 onEnter(new Node("LabeledLexerElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		 onEnter(new Node("LexerBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		 onEnter(new Node("LexerCommands", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		 onEnter(new Node("LexerCommand", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		 onEnter(new Node("LexerCommandName", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		 onEnter(new Node("LexerCommandExpr", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		 onExit();
	}

	@Override
	public void enterAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		 onEnter(new Node("AltList", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		 onExit();
	}

	@Override
	public void enterAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		 onEnter(new Node("Alternative", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		 onExit();
	}

	@Override
	public void enterElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		 onEnter(new Node("Element", arg.getText(), arg.getStart().getText()));
	}

	public void exitElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		 onExit();
	}

	@Override
	public void enterLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		 onEnter(new Node("LabeledElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		 onExit();
	}

	@Override
	public void enterEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		 onEnter(new Node("Ebnf", arg.getText(), arg.getStart().getText()));
	}

	public void exitEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		 onExit();
	}

	@Override
	public void enterBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		 onEnter(new Node("BlockSuffix", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		 onExit();
	}

	@Override
	public void enterEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		 onEnter(new Node("EbnfSuffix", arg.getText(), arg.getStart().getText()));
	}

	public void exitEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		 onEnter(new Node("LexerAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		 onEnter(new Node("Atom", arg.getText(), arg.getStart().getText()));
	}

	public void exitAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		 onExit();
	}

	@Override
	public void enterNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		 onEnter(new Node("NotSet", arg.getText(), arg.getStart().getText()));
	}

	public void exitNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		 onExit();
	}

	@Override
	public void enterBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		 onEnter(new Node("BlockSet", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		 onExit();
	}

	@Override
	public void enterSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		 onEnter(new Node("SetElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		 onExit();
	}

	@Override
	public void enterBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		 onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		 onEnter(new Node("Ruleref", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		 onExit();
	}

	@Override
	public void enterCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		 onEnter(new Node("CharacterRange", arg.getText(), arg.getStart().getText()));
	}

	public void exitCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		 onExit();
	}

	@Override
	public void enterTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		 onEnter(new Node("Terminal", arg.getText(), arg.getStart().getText()));
	}

	public void exitTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		 onExit();
	}

	@Override
	public void enterElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		 onEnter(new Node("ElementOptions", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		 onExit();
	}

	@Override
	public void enterElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		 onEnter(new Node("ElementOption", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		 onExit();
	}

	@Override
	public void enterIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		 onEnter(new Node("Identifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		 onExit();
	}

}