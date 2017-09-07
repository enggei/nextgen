package com.generator.generators.antlr.parser;

public class ANTLRv4BaseVisitor extends ANTLRv4ParserBaseVisitor<ANTLRv4BaseVisitor.Node> {

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
	public Node visitOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		System.out.println("OptionsSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		System.out.println("Option");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		System.out.println("OptionValue");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		System.out.println("DelegateGrammars");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		System.out.println("DelegateGrammar");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		System.out.println("TokensSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		System.out.println("ChannelsSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		System.out.println("IdList");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		System.out.println("Action");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		System.out.println("ActionScopeName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		System.out.println("GrammarSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		System.out.println("GrammarType");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		System.out.println("PrequelConstruct");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		System.out.println("ActionBlock");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		System.out.println("ArgActionBlock");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		System.out.println("ModeSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		System.out.println("Rules");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		System.out.println("RuleSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		System.out.println("ParserRuleSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		System.out.println("ExceptionGroup");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		System.out.println("ExceptionHandler");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		System.out.println("FinallyClause");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		System.out.println("RulePrequel");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		System.out.println("RuleReturns");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		System.out.println("ThrowsSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		System.out.println("LocalsSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		System.out.println("RuleAction");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		System.out.println("RuleModifiers");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		System.out.println("Terminal");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		System.out.println("LexerCommands");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		System.out.println("LexerCommand");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		System.out.println("LexerCommandName");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		System.out.println("LexerCommandExpr");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		System.out.println("AltList");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		System.out.println("Alternative");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		System.out.println("Element");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		System.out.println("LabeledElement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		System.out.println("Ebnf");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		System.out.println("BlockSuffix");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		System.out.println("EbnfSuffix");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		System.out.println("LexerAtom");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		System.out.println("Atom");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		System.out.println("NotSet");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		System.out.println("BlockSet");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		System.out.println("SetElement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		System.out.println("Block");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		System.out.println("Ruleref");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		System.out.println("CharacterRange");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		System.out.println("ElementOptions");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		System.out.println("ElementOption");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		System.out.println("Identifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		System.out.println("RuleModifier");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		System.out.println("RuleBlock");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		System.out.println("RuleAltList");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		System.out.println("LabeledAlt");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		System.out.println("LexerRuleSpec");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		System.out.println("LexerRuleBlock");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		System.out.println("LexerAltList");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		System.out.println("LexerAlt");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		System.out.println("LexerElements");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		System.out.println("LexerElement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		System.out.println("LabeledLexerElement");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

	@Override
	public Node visitLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		System.out.println("LexerBlock");
		final Node node = new Node("GrammarSpec", arg.getText());
		onEnter(node);
      visitChildren(arg);
      onExit();
      return node;
	}

}