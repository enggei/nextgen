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

	protected boolean inLexerElement = false;

	@Override
	public void enterLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		onEnter(new Node("LexerElement", arg.getText(), arg.getStart().getText()));
		this.inLexerElement = true;
	}

	public void exitLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		onExit();
		this.inLexerElement = false;
	}

	protected boolean inLabeledLexerElement = false;

	@Override
	public void enterLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		onEnter(new Node("LabeledLexerElement", arg.getText(), arg.getStart().getText()));
		this.inLabeledLexerElement = true;
	}

	public void exitLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		onExit();
		this.inLabeledLexerElement = false;
	}

	protected boolean inLexerBlock = false;

	@Override
	public void enterLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		onEnter(new Node("LexerBlock", arg.getText(), arg.getStart().getText()));
		this.inLexerBlock = true;
	}

	public void exitLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		onExit();
		this.inLexerBlock = false;
	}

	protected boolean inLexerCommands = false;

	@Override
	public void enterLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		onEnter(new Node("LexerCommands", arg.getText(), arg.getStart().getText()));
		this.inLexerCommands = true;
	}

	public void exitLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		onExit();
		this.inLexerCommands = false;
	}

	protected boolean inLexerCommand = false;

	@Override
	public void enterLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		onEnter(new Node("LexerCommand", arg.getText(), arg.getStart().getText()));
		this.inLexerCommand = true;
	}

	public void exitLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		onExit();
		this.inLexerCommand = false;
	}

	protected boolean inLexerCommandName = false;

	@Override
	public void enterLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		onEnter(new Node("LexerCommandName", arg.getText(), arg.getStart().getText()));
		this.inLexerCommandName = true;
	}

	public void exitLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		onExit();
		this.inLexerCommandName = false;
	}

	protected boolean inLexerCommandExpr = false;

	@Override
	public void enterLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		onEnter(new Node("LexerCommandExpr", arg.getText(), arg.getStart().getText()));
		this.inLexerCommandExpr = true;
	}

	public void exitLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		onExit();
		this.inLexerCommandExpr = false;
	}

	protected boolean inAltList = false;

	@Override
	public void enterAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		onEnter(new Node("AltList", arg.getText(), arg.getStart().getText()));
		this.inAltList = true;
	}

	public void exitAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		onExit();
		this.inAltList = false;
	}

	protected boolean inAlternative = false;

	@Override
	public void enterAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		onEnter(new Node("Alternative", arg.getText(), arg.getStart().getText()));
		this.inAlternative = true;
	}

	public void exitAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		onExit();
		this.inAlternative = false;
	}

	protected boolean inElement = false;

	@Override
	public void enterElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		onEnter(new Node("Element", arg.getText(), arg.getStart().getText()));
		this.inElement = true;
	}

	public void exitElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		onExit();
		this.inElement = false;
	}

	protected boolean inLabeledElement = false;

	@Override
	public void enterLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		onEnter(new Node("LabeledElement", arg.getText(), arg.getStart().getText()));
		this.inLabeledElement = true;
	}

	public void exitLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		onExit();
		this.inLabeledElement = false;
	}

	protected boolean inEbnf = false;

	@Override
	public void enterEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		onEnter(new Node("Ebnf", arg.getText(), arg.getStart().getText()));
		this.inEbnf = true;
	}

	public void exitEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		onExit();
		this.inEbnf = false;
	}

	protected boolean inBlockSuffix = false;

	@Override
	public void enterBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		onEnter(new Node("BlockSuffix", arg.getText(), arg.getStart().getText()));
		this.inBlockSuffix = true;
	}

	public void exitBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		onExit();
		this.inBlockSuffix = false;
	}

	protected boolean inEbnfSuffix = false;

	@Override
	public void enterEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		onEnter(new Node("EbnfSuffix", arg.getText(), arg.getStart().getText()));
		this.inEbnfSuffix = true;
	}

	public void exitEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		onExit();
		this.inEbnfSuffix = false;
	}

	protected boolean inLexerAtom = false;

	@Override
	public void enterLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		onEnter(new Node("LexerAtom", arg.getText(), arg.getStart().getText()));
		this.inLexerAtom = true;
	}

	public void exitLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		onExit();
		this.inLexerAtom = false;
	}

	protected boolean inAtom = false;

	@Override
	public void enterAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		onEnter(new Node("Atom", arg.getText(), arg.getStart().getText()));
		this.inAtom = true;
	}

	public void exitAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		onExit();
		this.inAtom = false;
	}

	protected boolean inNotSet = false;

	@Override
	public void enterNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		onEnter(new Node("NotSet", arg.getText(), arg.getStart().getText()));
		this.inNotSet = true;
	}

	public void exitNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		onExit();
		this.inNotSet = false;
	}

	protected boolean inBlockSet = false;

	@Override
	public void enterBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		onEnter(new Node("BlockSet", arg.getText(), arg.getStart().getText()));
		this.inBlockSet = true;
	}

	public void exitBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		onExit();
		this.inBlockSet = false;
	}

	protected boolean inSetElement = false;

	@Override
	public void enterSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		onEnter(new Node("SetElement", arg.getText(), arg.getStart().getText()));
		this.inSetElement = true;
	}

	public void exitSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		onExit();
		this.inSetElement = false;
	}

	protected boolean inBlock = false;

	@Override
	public void enterBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		onEnter(new Node("Block", arg.getText(), arg.getStart().getText()));
		this.inBlock = true;
	}

	public void exitBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		onExit();
		this.inBlock = false;
	}

	protected boolean inRuleref = false;

	@Override
	public void enterRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		onEnter(new Node("Ruleref", arg.getText(), arg.getStart().getText()));
		this.inRuleref = true;
	}

	public void exitRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		onExit();
		this.inRuleref = false;
	}

	protected boolean inCharacterRange = false;

	@Override
	public void enterCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		onEnter(new Node("CharacterRange", arg.getText(), arg.getStart().getText()));
		this.inCharacterRange = true;
	}

	public void exitCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		onExit();
		this.inCharacterRange = false;
	}

	protected boolean inTerminal = false;

	@Override
	public void enterTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		onEnter(new Node("Terminal", arg.getText(), arg.getStart().getText()));
		this.inTerminal = true;
	}

	public void exitTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		onExit();
		this.inTerminal = false;
	}

	protected boolean inElementOptions = false;

	@Override
	public void enterElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		onEnter(new Node("ElementOptions", arg.getText(), arg.getStart().getText()));
		this.inElementOptions = true;
	}

	public void exitElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		onExit();
		this.inElementOptions = false;
	}

	protected boolean inElementOption = false;

	@Override
	public void enterElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		onEnter(new Node("ElementOption", arg.getText(), arg.getStart().getText()));
		this.inElementOption = true;
	}

	public void exitElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		onExit();
		this.inElementOption = false;
	}

	protected boolean inIdentifier = false;

	@Override
	public void enterIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		onEnter(new Node("Identifier", arg.getText(), arg.getStart().getText()));
		this.inIdentifier = true;
	}

	public void exitIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		onExit();
		this.inIdentifier = false;
	}

	protected boolean inTokensSpec = false;

	@Override
	public void enterTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		onEnter(new Node("TokensSpec", arg.getText(), arg.getStart().getText()));
		this.inTokensSpec = true;
	}

	public void exitTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		onExit();
		this.inTokensSpec = false;
	}

	protected boolean inChannelsSpec = false;

	@Override
	public void enterChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		onEnter(new Node("ChannelsSpec", arg.getText(), arg.getStart().getText()));
		this.inChannelsSpec = true;
	}

	public void exitChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		onExit();
		this.inChannelsSpec = false;
	}

	protected boolean inIdList = false;

	@Override
	public void enterIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		onEnter(new Node("IdList", arg.getText(), arg.getStart().getText()));
		this.inIdList = true;
	}

	public void exitIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		onExit();
		this.inIdList = false;
	}

	protected boolean inAction = false;

	@Override
	public void enterAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		onEnter(new Node("Action", arg.getText(), arg.getStart().getText()));
		this.inAction = true;
	}

	public void exitAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		onExit();
		this.inAction = false;
	}

	protected boolean inActionScopeName = false;

	@Override
	public void enterActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		onEnter(new Node("ActionScopeName", arg.getText(), arg.getStart().getText()));
		this.inActionScopeName = true;
	}

	public void exitActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		onExit();
		this.inActionScopeName = false;
	}

	protected boolean inActionBlock = false;

	@Override
	public void enterActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		onEnter(new Node("ActionBlock", arg.getText(), arg.getStart().getText()));
		this.inActionBlock = true;
	}

	public void exitActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		onExit();
		this.inActionBlock = false;
	}

	protected boolean inArgActionBlock = false;

	@Override
	public void enterArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		onEnter(new Node("ArgActionBlock", arg.getText(), arg.getStart().getText()));
		this.inArgActionBlock = true;
	}

	public void exitArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		onExit();
		this.inArgActionBlock = false;
	}

	protected boolean inModeSpec = false;

	@Override
	public void enterModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		onEnter(new Node("ModeSpec", arg.getText(), arg.getStart().getText()));
		this.inModeSpec = true;
	}

	public void exitModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		onExit();
		this.inModeSpec = false;
	}

	protected boolean inRules = false;

	@Override
	public void enterRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		onEnter(new Node("Rules", arg.getText(), arg.getStart().getText()));
		this.inRules = true;
	}

	public void exitRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		onExit();
		this.inRules = false;
	}

	protected boolean inRuleSpec = false;

	@Override
	public void enterRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		onEnter(new Node("RuleSpec", arg.getText(), arg.getStart().getText()));
		this.inRuleSpec = true;
	}

	public void exitRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		onExit();
		this.inRuleSpec = false;
	}

	protected boolean inParserRuleSpec = false;

	@Override
	public void enterParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		onEnter(new Node("ParserRuleSpec", arg.getText(), arg.getStart().getText()));
		this.inParserRuleSpec = true;
	}

	public void exitParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		onExit();
		this.inParserRuleSpec = false;
	}

	protected boolean inExceptionGroup = false;

	@Override
	public void enterExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		onEnter(new Node("ExceptionGroup", arg.getText(), arg.getStart().getText()));
		this.inExceptionGroup = true;
	}

	public void exitExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		onExit();
		this.inExceptionGroup = false;
	}

	protected boolean inExceptionHandler = false;

	@Override
	public void enterExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		onEnter(new Node("ExceptionHandler", arg.getText(), arg.getStart().getText()));
		this.inExceptionHandler = true;
	}

	public void exitExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		onExit();
		this.inExceptionHandler = false;
	}

	protected boolean inFinallyClause = false;

	@Override
	public void enterFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		onEnter(new Node("FinallyClause", arg.getText(), arg.getStart().getText()));
		this.inFinallyClause = true;
	}

	public void exitFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		onExit();
		this.inFinallyClause = false;
	}

	protected boolean inRulePrequel = false;

	@Override
	public void enterRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		onEnter(new Node("RulePrequel", arg.getText(), arg.getStart().getText()));
		this.inRulePrequel = true;
	}

	public void exitRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		onExit();
		this.inRulePrequel = false;
	}

	protected boolean inRuleReturns = false;

	@Override
	public void enterRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		onEnter(new Node("RuleReturns", arg.getText(), arg.getStart().getText()));
		this.inRuleReturns = true;
	}

	public void exitRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		onExit();
		this.inRuleReturns = false;
	}

	protected boolean inThrowsSpec = false;

	@Override
	public void enterThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		onEnter(new Node("ThrowsSpec", arg.getText(), arg.getStart().getText()));
		this.inThrowsSpec = true;
	}

	public void exitThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		onExit();
		this.inThrowsSpec = false;
	}

	protected boolean inLocalsSpec = false;

	@Override
	public void enterLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		onEnter(new Node("LocalsSpec", arg.getText(), arg.getStart().getText()));
		this.inLocalsSpec = true;
	}

	public void exitLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		onExit();
		this.inLocalsSpec = false;
	}

	protected boolean inRuleAction = false;

	@Override
	public void enterRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		onEnter(new Node("RuleAction", arg.getText(), arg.getStart().getText()));
		this.inRuleAction = true;
	}

	public void exitRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		onExit();
		this.inRuleAction = false;
	}

	protected boolean inRuleModifiers = false;

	@Override
	public void enterRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		onEnter(new Node("RuleModifiers", arg.getText(), arg.getStart().getText()));
		this.inRuleModifiers = true;
	}

	public void exitRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		onExit();
		this.inRuleModifiers = false;
	}

	protected boolean inRuleModifier = false;

	@Override
	public void enterRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		onEnter(new Node("RuleModifier", arg.getText(), arg.getStart().getText()));
		this.inRuleModifier = true;
	}

	public void exitRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		onExit();
		this.inRuleModifier = false;
	}

	protected boolean inRuleBlock = false;

	@Override
	public void enterRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		onEnter(new Node("RuleBlock", arg.getText(), arg.getStart().getText()));
		this.inRuleBlock = true;
	}

	public void exitRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		onExit();
		this.inRuleBlock = false;
	}

	protected boolean inRuleAltList = false;

	@Override
	public void enterRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		onEnter(new Node("RuleAltList", arg.getText(), arg.getStart().getText()));
		this.inRuleAltList = true;
	}

	public void exitRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		onExit();
		this.inRuleAltList = false;
	}

	protected boolean inLabeledAlt = false;

	@Override
	public void enterLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		onEnter(new Node("LabeledAlt", arg.getText(), arg.getStart().getText()));
		this.inLabeledAlt = true;
	}

	public void exitLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		onExit();
		this.inLabeledAlt = false;
	}

	protected boolean inLexerRuleSpec = false;

	@Override
	public void enterLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		onEnter(new Node("LexerRuleSpec", arg.getText(), arg.getStart().getText()));
		this.inLexerRuleSpec = true;
	}

	public void exitLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		onExit();
		this.inLexerRuleSpec = false;
	}

	protected boolean inLexerRuleBlock = false;

	@Override
	public void enterLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		onEnter(new Node("LexerRuleBlock", arg.getText(), arg.getStart().getText()));
		this.inLexerRuleBlock = true;
	}

	public void exitLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		onExit();
		this.inLexerRuleBlock = false;
	}

	protected boolean inLexerAltList = false;

	@Override
	public void enterLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		onEnter(new Node("LexerAltList", arg.getText(), arg.getStart().getText()));
		this.inLexerAltList = true;
	}

	public void exitLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		onExit();
		this.inLexerAltList = false;
	}

	protected boolean inLexerAlt = false;

	@Override
	public void enterLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		onEnter(new Node("LexerAlt", arg.getText(), arg.getStart().getText()));
		this.inLexerAlt = true;
	}

	public void exitLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		onExit();
		this.inLexerAlt = false;
	}

	protected boolean inLexerElements = false;

	@Override
	public void enterLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		onEnter(new Node("LexerElements", arg.getText(), arg.getStart().getText()));
		this.inLexerElements = true;
	}

	public void exitLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		onExit();
		this.inLexerElements = false;
	}

	protected boolean inGrammarSpec = false;

	@Override
	public void enterGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		onEnter(new Node("GrammarSpec", arg.getText(), arg.getStart().getText()));
		this.inGrammarSpec = true;
	}

	public void exitGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		onExit();
		this.inGrammarSpec = false;
	}

	protected boolean inGrammarType = false;

	@Override
	public void enterGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		onEnter(new Node("GrammarType", arg.getText(), arg.getStart().getText()));
		this.inGrammarType = true;
	}

	public void exitGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		onExit();
		this.inGrammarType = false;
	}

	protected boolean inPrequelConstruct = false;

	@Override
	public void enterPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		onEnter(new Node("PrequelConstruct", arg.getText(), arg.getStart().getText()));
		this.inPrequelConstruct = true;
	}

	public void exitPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		onExit();
		this.inPrequelConstruct = false;
	}

	protected boolean inOptionsSpec = false;

	@Override
	public void enterOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		onEnter(new Node("OptionsSpec", arg.getText(), arg.getStart().getText()));
		this.inOptionsSpec = true;
	}

	public void exitOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		onExit();
		this.inOptionsSpec = false;
	}

	protected boolean inOption = false;

	@Override
	public void enterOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		onEnter(new Node("Option", arg.getText(), arg.getStart().getText()));
		this.inOption = true;
	}

	public void exitOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		onExit();
		this.inOption = false;
	}

	protected boolean inOptionValue = false;

	@Override
	public void enterOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		onEnter(new Node("OptionValue", arg.getText(), arg.getStart().getText()));
		this.inOptionValue = true;
	}

	public void exitOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		onExit();
		this.inOptionValue = false;
	}

	protected boolean inDelegateGrammars = false;

	@Override
	public void enterDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		onEnter(new Node("DelegateGrammars", arg.getText(), arg.getStart().getText()));
		this.inDelegateGrammars = true;
	}

	public void exitDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		onExit();
		this.inDelegateGrammars = false;
	}

	protected boolean inDelegateGrammar = false;

	@Override
	public void enterDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		onEnter(new Node("DelegateGrammar", arg.getText(), arg.getStart().getText()));
		this.inDelegateGrammar = true;
	}

	public void exitDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		onExit();
		this.inDelegateGrammar = false;
	}

}