package com.generator.generators.antlr.parser;

public class ANTLRv4NodeListener extends ANTLRv4ParserBaseListener {

	public static class Node {

      public final String name;
      public final String value;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value) {
         this.name = name;
         this.value = value;
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
	public void enterGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg0) {
		 //System.out.println("enterGrammarSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("GrammarSpec", arg0.getText()));
	}

	@Override
	public void exitGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg0) {
		 //System.out.println("exitGrammarSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg0) {
		 //System.out.println("enterGrammarType");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("GrammarType", arg0.getText()));
	}

	@Override
	public void exitGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg0) {
		 //System.out.println("exitGrammarType");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg0) {
		 //System.out.println("enterPrequelConstruct");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("PrequelConstruct", arg0.getText()));
	}

	@Override
	public void exitPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg0) {
		 //System.out.println("exitPrequelConstruct");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg0) {
		 //System.out.println("enterOptionsSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("OptionsSpec", arg0.getText()));
	}

	@Override
	public void exitOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg0) {
		 //System.out.println("exitOptionsSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg0) {
		 //System.out.println("enterOption");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Option", arg0.getText()));
	}

	@Override
	public void exitOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg0) {
		 //System.out.println("exitOption");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg0) {
		 //System.out.println("enterOptionValue");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("OptionValue", arg0.getText()));
	}

	@Override
	public void exitOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg0) {
		 //System.out.println("exitOptionValue");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg0) {
		 //System.out.println("enterDelegateGrammars");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("DelegateGrammars", arg0.getText()));
	}

	@Override
	public void exitDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg0) {
		 //System.out.println("exitDelegateGrammars");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg0) {
		 //System.out.println("enterDelegateGrammar");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("DelegateGrammar", arg0.getText()));
	}

	@Override
	public void exitDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg0) {
		 //System.out.println("exitDelegateGrammar");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg0) {
		 //System.out.println("enterTokensSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("TokensSpec", arg0.getText()));
	}

	@Override
	public void exitTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg0) {
		 //System.out.println("exitTokensSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg0) {
		 //System.out.println("enterChannelsSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ChannelsSpec", arg0.getText()));
	}

	@Override
	public void exitChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg0) {
		 //System.out.println("exitChannelsSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg0) {
		 //System.out.println("enterIdList");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("IdList", arg0.getText()));
	}

	@Override
	public void exitIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg0) {
		 //System.out.println("exitIdList");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg0) {
		 //System.out.println("enterAction");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Action", arg0.getText()));
	}

	@Override
	public void exitAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg0) {
		 //System.out.println("exitAction");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg0) {
		 //System.out.println("enterActionScopeName");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ActionScopeName", arg0.getText()));
	}

	@Override
	public void exitActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg0) {
		 //System.out.println("exitActionScopeName");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg0) {
		 //System.out.println("enterActionBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ActionBlock", arg0.getText()));
	}

	@Override
	public void exitActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg0) {
		 //System.out.println("exitActionBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg0) {
		 //System.out.println("enterArgActionBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ArgActionBlock", arg0.getText()));
	}

	@Override
	public void exitArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg0) {
		 //System.out.println("exitArgActionBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg0) {
		 //System.out.println("enterModeSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ModeSpec", arg0.getText()));
	}

	@Override
	public void exitModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg0) {
		 //System.out.println("exitModeSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg0) {
		 //System.out.println("enterRules");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Rules", arg0.getText()));
	}

	@Override
	public void exitRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg0) {
		 //System.out.println("exitRules");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg0) {
		 //System.out.println("enterRuleSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("RuleSpec", arg0.getText()));
	}

	@Override
	public void exitRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg0) {
		 //System.out.println("exitRuleSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg0) {
		 //System.out.println("enterParserRuleSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ParserRuleSpec", arg0.getText()));
	}

	@Override
	public void exitParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg0) {
		 //System.out.println("exitParserRuleSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg0) {
		 //System.out.println("enterExceptionGroup");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ExceptionGroup", arg0.getText()));
	}

	@Override
	public void exitExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg0) {
		 //System.out.println("exitExceptionGroup");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg0) {
		 //System.out.println("enterExceptionHandler");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ExceptionHandler", arg0.getText()));
	}

	@Override
	public void exitExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg0) {
		 //System.out.println("exitExceptionHandler");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg0) {
		 //System.out.println("enterFinallyClause");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("FinallyClause", arg0.getText()));
	}

	@Override
	public void exitFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg0) {
		 //System.out.println("exitFinallyClause");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg0) {
		 //System.out.println("enterRulePrequel");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("RulePrequel", arg0.getText()));
	}

	@Override
	public void exitRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg0) {
		 //System.out.println("exitRulePrequel");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg0) {
		 //System.out.println("enterRuleReturns");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("RuleReturns", arg0.getText()));
	}

	@Override
	public void exitRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg0) {
		 //System.out.println("exitRuleReturns");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg0) {
		 //System.out.println("enterThrowsSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ThrowsSpec", arg0.getText()));
	}

	@Override
	public void exitThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg0) {
		 //System.out.println("exitThrowsSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg0) {
		 //System.out.println("enterLocalsSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LocalsSpec", arg0.getText()));
	}

	@Override
	public void exitLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg0) {
		 //System.out.println("exitLocalsSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg0) {
		 //System.out.println("enterRuleAction");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("RuleAction", arg0.getText()));
	}

	@Override
	public void exitRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg0) {
		 //System.out.println("exitRuleAction");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg0) {
		 //System.out.println("enterRuleModifiers");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("RuleModifiers", arg0.getText()));
	}

	@Override
	public void exitRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg0) {
		 //System.out.println("exitRuleModifiers");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg0) {
		 //System.out.println("enterRuleModifier");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("RuleModifier", arg0.getText()));
	}

	@Override
	public void exitRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg0) {
		 //System.out.println("exitRuleModifier");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg0) {
		 //System.out.println("enterRuleBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("RuleBlock", arg0.getText()));
	}

	@Override
	public void exitRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg0) {
		 //System.out.println("exitRuleBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg0) {
		 //System.out.println("enterRuleAltList");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("RuleAltList", arg0.getText()));
	}

	@Override
	public void exitRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg0) {
		 //System.out.println("exitRuleAltList");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg0) {
		 //System.out.println("enterLabeledAlt");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LabeledAlt", arg0.getText()));
	}

	@Override
	public void exitLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg0) {
		 //System.out.println("exitLabeledAlt");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg0) {
		 //System.out.println("enterLexerRuleSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerRuleSpec", arg0.getText()));
	}

	@Override
	public void exitLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg0) {
		 //System.out.println("exitLexerRuleSpec");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg0) {
		 //System.out.println("enterLexerRuleBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerRuleBlock", arg0.getText()));
	}

	@Override
	public void exitLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg0) {
		 //System.out.println("exitLexerRuleBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg0) {
		 //System.out.println("enterLexerAltList");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerAltList", arg0.getText()));
	}

	@Override
	public void exitLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg0) {
		 //System.out.println("exitLexerAltList");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg0) {
		 //System.out.println("enterLexerAlt");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerAlt", arg0.getText()));
	}

	@Override
	public void exitLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg0) {
		 //System.out.println("exitLexerAlt");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg0) {
		 //System.out.println("enterLexerElements");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerElements", arg0.getText()));
	}

	@Override
	public void exitLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg0) {
		 //System.out.println("exitLexerElements");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg0) {
		 //System.out.println("enterLexerElement");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerElement", arg0.getText()));
	}

	@Override
	public void exitLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg0) {
		 //System.out.println("exitLexerElement");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg0) {
		 //System.out.println("enterLabeledLexerElement");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LabeledLexerElement", arg0.getText()));
	}

	@Override
	public void exitLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg0) {
		 //System.out.println("exitLabeledLexerElement");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg0) {
		 //System.out.println("enterLexerBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerBlock", arg0.getText()));
	}

	@Override
	public void exitLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg0) {
		 //System.out.println("exitLexerBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg0) {
		 //System.out.println("enterLexerCommands");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerCommands", arg0.getText()));
	}

	@Override
	public void exitLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg0) {
		 //System.out.println("exitLexerCommands");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg0) {
		 //System.out.println("enterLexerCommand");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerCommand", arg0.getText()));
	}

	@Override
	public void exitLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg0) {
		 //System.out.println("exitLexerCommand");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg0) {
		 //System.out.println("enterLexerCommandName");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerCommandName", arg0.getText()));
	}

	@Override
	public void exitLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg0) {
		 //System.out.println("exitLexerCommandName");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg0) {
		 //System.out.println("enterLexerCommandExpr");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerCommandExpr", arg0.getText()));
	}

	@Override
	public void exitLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg0) {
		 //System.out.println("exitLexerCommandExpr");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg0) {
		 //System.out.println("enterAltList");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("AltList", arg0.getText()));
	}

	@Override
	public void exitAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg0) {
		 //System.out.println("exitAltList");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg0) {
		 //System.out.println("enterAlternative");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Alternative", arg0.getText()));
	}

	@Override
	public void exitAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg0) {
		 //System.out.println("exitAlternative");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg0) {
		 //System.out.println("enterElement");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Element", arg0.getText()));
	}

	@Override
	public void exitElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg0) {
		 //System.out.println("exitElement");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg0) {
		 //System.out.println("enterLabeledElement");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LabeledElement", arg0.getText()));
	}

	@Override
	public void exitLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg0) {
		 //System.out.println("exitLabeledElement");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg0) {
		 //System.out.println("enterEbnf");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Ebnf", arg0.getText()));
	}

	@Override
	public void exitEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg0) {
		 //System.out.println("exitEbnf");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg0) {
		 //System.out.println("enterBlockSuffix");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("BlockSuffix", arg0.getText()));
	}

	@Override
	public void exitBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg0) {
		 //System.out.println("exitBlockSuffix");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg0) {
		 //System.out.println("enterEbnfSuffix");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("EbnfSuffix", arg0.getText()));
	}

	@Override
	public void exitEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg0) {
		 //System.out.println("exitEbnfSuffix");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg0) {
		 //System.out.println("enterLexerAtom");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("LexerAtom", arg0.getText()));
	}

	@Override
	public void exitLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg0) {
		 //System.out.println("exitLexerAtom");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg0) {
		 //System.out.println("enterAtom");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Atom", arg0.getText()));
	}

	@Override
	public void exitAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg0) {
		 //System.out.println("exitAtom");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg0) {
		 //System.out.println("enterNotSet");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("NotSet", arg0.getText()));
	}

	@Override
	public void exitNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg0) {
		 //System.out.println("exitNotSet");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg0) {
		 //System.out.println("enterBlockSet");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("BlockSet", arg0.getText()));
	}

	@Override
	public void exitBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg0) {
		 //System.out.println("exitBlockSet");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg0) {
		 //System.out.println("enterSetElement");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("SetElement", arg0.getText()));
	}

	@Override
	public void exitSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg0) {
		 //System.out.println("exitSetElement");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg0) {
		 //System.out.println("enterBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Block", arg0.getText()));
	}

	@Override
	public void exitBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg0) {
		 //System.out.println("exitBlock");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg0) {
		 //System.out.println("enterRuleref");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Ruleref", arg0.getText()));
	}

	@Override
	public void exitRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg0) {
		 //System.out.println("exitRuleref");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg0) {
		 //System.out.println("enterCharacterRange");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("CharacterRange", arg0.getText()));
	}

	@Override
	public void exitCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg0) {
		 //System.out.println("exitCharacterRange");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg0) {
		 //System.out.println("enterTerminal");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Terminal", arg0.getText()));
	}

	@Override
	public void exitTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg0) {
		 //System.out.println("exitTerminal");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg0) {
		 //System.out.println("enterElementOptions");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ElementOptions", arg0.getText()));
	}

	@Override
	public void exitElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg0) {
		 //System.out.println("exitElementOptions");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg0) {
		 //System.out.println("enterElementOption");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("ElementOption", arg0.getText()));
	}

	@Override
	public void exitElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg0) {
		 //System.out.println("exitElementOption");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}

	@Override
	public void enterIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg0) {
		 //System.out.println("enterIdentifier");
		 //System.out.println("\t"+ arg0.getText());
		 onEnter(new Node("Identifier", arg0.getText()));
	}

	@Override
	public void exitIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg0) {
		 //System.out.println("exitIdentifier");
		 //System.out.println("\t"+ arg0.getText());
		 onExit();
	}
}