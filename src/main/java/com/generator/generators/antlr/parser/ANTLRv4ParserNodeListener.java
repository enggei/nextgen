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

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public void enterOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		 //System.out.println("OptionValue");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("OptionValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		 onExit();
	}

	@Override
	public void enterDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		 //System.out.println("DelegateGrammars");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DelegateGrammars", arg.getText(), arg.getStart().getText()));
	}

	public void exitDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		 onExit();
	}

	@Override
	public void enterDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		 //System.out.println("DelegateGrammar");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DelegateGrammar", arg.getText(), arg.getStart().getText()));
	}

	public void exitDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		 onExit();
	}

	@Override
	public void enterTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		 //System.out.println("TokensSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("TokensSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		 //System.out.println("ChannelsSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ChannelsSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		 //System.out.println("IdList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("IdList", arg.getText(), arg.getStart().getText()));
	}

	public void exitIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		 onExit();
	}

	@Override
	public void enterAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		 //System.out.println("Action");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Action", arg.getText(), arg.getStart().getText()));
	}

	public void exitAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		 onExit();
	}

	@Override
	public void enterActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		 //System.out.println("ActionScopeName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ActionScopeName", arg.getText(), arg.getStart().getText()));
	}

	public void exitActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		 onExit();
	}

	@Override
	public void enterActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		 //System.out.println("ActionBlock");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ActionBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		 //System.out.println("ArgActionBlock");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ArgActionBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		 //System.out.println("ModeSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ModeSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		 //System.out.println("Rules");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Rules", arg.getText(), arg.getStart().getText()));
	}

	public void exitRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		 //System.out.println("RuleSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RuleSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		 //System.out.println("ParserRuleSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ParserRuleSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		 //System.out.println("ExceptionGroup");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExceptionGroup", arg.getText(), arg.getStart().getText()));
	}

	public void exitExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		 onExit();
	}

	@Override
	public void enterExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		 //System.out.println("ExceptionHandler");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ExceptionHandler", arg.getText(), arg.getStart().getText()));
	}

	public void exitExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		 onExit();
	}

	@Override
	public void enterFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		 //System.out.println("FinallyClause");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FinallyClause", arg.getText(), arg.getStart().getText()));
	}

	public void exitFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		 onExit();
	}

	@Override
	public void enterRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		 //System.out.println("RulePrequel");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RulePrequel", arg.getText(), arg.getStart().getText()));
	}

	public void exitRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		 //System.out.println("RuleReturns");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RuleReturns", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		 onExit();
	}

	@Override
	public void enterThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		 //System.out.println("ThrowsSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ThrowsSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		 //System.out.println("LocalsSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LocalsSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		 //System.out.println("RuleAction");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RuleAction", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		 //System.out.println("RuleModifiers");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RuleModifiers", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		 //System.out.println("RuleModifier");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RuleModifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		 //System.out.println("RuleBlock");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RuleBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		 //System.out.println("RuleAltList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("RuleAltList", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		 onExit();
	}

	@Override
	public void enterLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		 //System.out.println("LabeledAlt");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LabeledAlt", arg.getText(), arg.getStart().getText()));
	}

	public void exitLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		 //System.out.println("LexerRuleSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerRuleSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		 //System.out.println("LexerRuleBlock");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerRuleBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		 //System.out.println("LexerAltList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerAltList", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		 onExit();
	}

	@Override
	public void enterGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		 //System.out.println("GrammarSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("GrammarSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		 //System.out.println("GrammarType");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("GrammarType", arg.getText(), arg.getStart().getText()));
	}

	public void exitGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		 onExit();
	}

	@Override
	public void enterPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		 //System.out.println("PrequelConstruct");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("PrequelConstruct", arg.getText(), arg.getStart().getText()));
	}

	public void exitPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		 onExit();
	}

	@Override
	public void enterOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		 //System.out.println("OptionsSpec");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("OptionsSpec", arg.getText(), arg.getStart().getText()));
	}

	public void exitOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		 onExit();
	}

	@Override
	public void enterOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		 //System.out.println("Option");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Option", arg.getText(), arg.getStart().getText()));
	}

	public void exitOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		 //System.out.println("LexerAlt");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerAlt", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		 //System.out.println("LexerElements");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerElements", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		 //System.out.println("LexerElement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		 onExit();
	}

	@Override
	public void enterLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		 //System.out.println("LabeledLexerElement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LabeledLexerElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		 //System.out.println("LexerBlock");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerBlock", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		 //System.out.println("LexerCommands");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerCommands", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		 //System.out.println("LexerCommand");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerCommand", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		 //System.out.println("LexerCommandName");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerCommandName", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		 //System.out.println("LexerCommandExpr");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerCommandExpr", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		 onExit();
	}

	@Override
	public void enterAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		 //System.out.println("AltList");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("AltList", arg.getText(), arg.getStart().getText()));
	}

	public void exitAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		 onExit();
	}

	@Override
	public void enterAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		 //System.out.println("Alternative");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Alternative", arg.getText(), arg.getStart().getText()));
	}

	public void exitAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		 onExit();
	}

	@Override
	public void enterElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		 //System.out.println("Element");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Element", arg.getText(), arg.getStart().getText()));
	}

	public void exitElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		 onExit();
	}

	@Override
	public void enterLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		 //System.out.println("LabeledElement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LabeledElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		 onExit();
	}

	@Override
	public void enterEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		 //System.out.println("Ebnf");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Ebnf", arg.getText(), arg.getStart().getText()));
	}

	public void exitEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		 onExit();
	}

	@Override
	public void enterBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		 //System.out.println("BlockSuffix");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BlockSuffix", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		 onExit();
	}

	@Override
	public void enterEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		 //System.out.println("EbnfSuffix");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("EbnfSuffix", arg.getText(), arg.getStart().getText()));
	}

	public void exitEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		 onExit();
	}

	@Override
	public void enterLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		 //System.out.println("LexerAtom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("LexerAtom", arg.getText(), arg.getStart().getText()));
	}

	public void exitLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		 onExit();
	}

	@Override
	public void enterAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		 //System.out.println("Atom");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Atom", arg.getText(), arg.getStart().getText()));
	}

	public void exitAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		 onExit();
	}

	@Override
	public void enterNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		 //System.out.println("NotSet");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("NotSet", arg.getText(), arg.getStart().getText()));
	}

	public void exitNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		 onExit();
	}

	@Override
	public void enterBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		 //System.out.println("BlockSet");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("BlockSet", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		 onExit();
	}

	@Override
	public void enterSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		 //System.out.println("SetElement");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("SetElement", arg.getText(), arg.getStart().getText()));
	}

	public void exitSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		 onExit();
	}

	@Override
	public void enterBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		 //System.out.println("Block");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
	}

	public void exitBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		 onExit();
	}

	@Override
	public void enterRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		 //System.out.println("Ruleref");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Ruleref", arg.getText(), arg.getStart().getText()));
	}

	public void exitRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		 onExit();
	}

	@Override
	public void enterCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		 //System.out.println("CharacterRange");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("CharacterRange", arg.getText(), arg.getStart().getText()));
	}

	public void exitCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		 onExit();
	}

	@Override
	public void enterTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		 //System.out.println("Terminal");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Terminal", arg.getText(), arg.getStart().getText()));
	}

	public void exitTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		 onExit();
	}

	@Override
	public void enterElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		 //System.out.println("ElementOptions");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ElementOptions", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		 onExit();
	}

	@Override
	public void enterElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		 //System.out.println("ElementOption");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("ElementOption", arg.getText(), arg.getStart().getText()));
	}

	public void exitElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		 onExit();
	}

	@Override
	public void enterIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		 //System.out.println("Identifier");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Identifier", arg.getText(), arg.getStart().getText()));
	}

	public void exitIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		 onExit();
	}

}