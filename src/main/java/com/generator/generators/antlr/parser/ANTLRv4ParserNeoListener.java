package com.generator.generators.antlr.parser;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

public class ANTLRv4ParserNeoListener extends ANTLRv4ParserBaseListener {

   protected final java.util.Stack<Node> nodeStack = new java.util.Stack<>();
	protected final StringBuilder delim = new StringBuilder("");
	protected final boolean debug;
	private final com.generator.NeoModel model;

	public ANTLRv4ParserNeoListener(com.generator.NeoModel model) {
		this(model, false);
	}

	public ANTLRv4ParserNeoListener(com.generator.NeoModel model, boolean debug) {
		this.model = model;
		this.debug = debug;
	}

   private void onEnter(Node node) {
		if (!nodeStack.isEmpty())
      	com.generator.NeoModel.relate(nodeStack.peek(), node, RelationshipType.withName("child"));
      nodeStack.push(node);
		if (debug) System.out.println(delim.toString() + node.getProperty("text"));
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

	protected boolean inGrammarType = false;

	@Override
	public void enterGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		final Node node = model.findOrCreate(Label.label("GrammarType"), "text", arg.getText());
		onEnter(node);
		this.inGrammarType = true;
	}

	public void exitGrammarType(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarTypeContext arg) {
		onExit();
		this.inGrammarType = false;
	}

	protected boolean inPrequelConstruct = false;

	@Override
	public void enterPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		final Node node = model.findOrCreate(Label.label("PrequelConstruct"), "text", arg.getText());
		onEnter(node);
		this.inPrequelConstruct = true;
	}

	public void exitPrequelConstruct(com.generator.generators.antlr.parser.ANTLRv4Parser.PrequelConstructContext arg) {
		onExit();
		this.inPrequelConstruct = false;
	}

	protected boolean inOptionsSpec = false;

	@Override
	public void enterOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("OptionsSpec"), "text", arg.getText());
		onEnter(node);
		this.inOptionsSpec = true;
	}

	public void exitOptionsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionsSpecContext arg) {
		onExit();
		this.inOptionsSpec = false;
	}

	protected boolean inOption = false;

	@Override
	public void enterOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		final Node node = model.findOrCreate(Label.label("Option"), "text", arg.getText());
		onEnter(node);
		this.inOption = true;
	}

	public void exitOption(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionContext arg) {
		onExit();
		this.inOption = false;
	}

	protected boolean inOptionValue = false;

	@Override
	public void enterOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		final Node node = model.findOrCreate(Label.label("OptionValue"), "text", arg.getText());
		onEnter(node);
		this.inOptionValue = true;
	}

	public void exitOptionValue(com.generator.generators.antlr.parser.ANTLRv4Parser.OptionValueContext arg) {
		onExit();
		this.inOptionValue = false;
	}

	protected boolean inDelegateGrammars = false;

	@Override
	public void enterDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		final Node node = model.findOrCreate(Label.label("DelegateGrammars"), "text", arg.getText());
		onEnter(node);
		this.inDelegateGrammars = true;
	}

	public void exitDelegateGrammars(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarsContext arg) {
		onExit();
		this.inDelegateGrammars = false;
	}

	protected boolean inDelegateGrammar = false;

	@Override
	public void enterDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		final Node node = model.findOrCreate(Label.label("DelegateGrammar"), "text", arg.getText());
		onEnter(node);
		this.inDelegateGrammar = true;
	}

	public void exitDelegateGrammar(com.generator.generators.antlr.parser.ANTLRv4Parser.DelegateGrammarContext arg) {
		onExit();
		this.inDelegateGrammar = false;
	}

	protected boolean inTokensSpec = false;

	@Override
	public void enterTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("TokensSpec"), "text", arg.getText());
		onEnter(node);
		this.inTokensSpec = true;
	}

	public void exitTokensSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.TokensSpecContext arg) {
		onExit();
		this.inTokensSpec = false;
	}

	protected boolean inChannelsSpec = false;

	@Override
	public void enterChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("ChannelsSpec"), "text", arg.getText());
		onEnter(node);
		this.inChannelsSpec = true;
	}

	public void exitChannelsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ChannelsSpecContext arg) {
		onExit();
		this.inChannelsSpec = false;
	}

	protected boolean inIdList = false;

	@Override
	public void enterIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		final Node node = model.findOrCreate(Label.label("IdList"), "text", arg.getText());
		onEnter(node);
		this.inIdList = true;
	}

	public void exitIdList(com.generator.generators.antlr.parser.ANTLRv4Parser.IdListContext arg) {
		onExit();
		this.inIdList = false;
	}

	protected boolean inAction = false;

	@Override
	public void enterAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		final Node node = model.findOrCreate(Label.label("Action"), "text", arg.getText());
		onEnter(node);
		this.inAction = true;
	}

	public void exitAction(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionContext arg) {
		onExit();
		this.inAction = false;
	}

	protected boolean inActionScopeName = false;

	@Override
	public void enterActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		final Node node = model.findOrCreate(Label.label("ActionScopeName"), "text", arg.getText());
		onEnter(node);
		this.inActionScopeName = true;
	}

	public void exitActionScopeName(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionScopeNameContext arg) {
		onExit();
		this.inActionScopeName = false;
	}

	protected boolean inActionBlock = false;

	@Override
	public void enterActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("ActionBlock"), "text", arg.getText());
		onEnter(node);
		this.inActionBlock = true;
	}

	public void exitActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ActionBlockContext arg) {
		onExit();
		this.inActionBlock = false;
	}

	protected boolean inArgActionBlock = false;

	@Override
	public void enterArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("ArgActionBlock"), "text", arg.getText());
		onEnter(node);
		this.inArgActionBlock = true;
	}

	public void exitArgActionBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.ArgActionBlockContext arg) {
		onExit();
		this.inArgActionBlock = false;
	}

	protected boolean inModeSpec = false;

	@Override
	public void enterModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("ModeSpec"), "text", arg.getText());
		onEnter(node);
		this.inModeSpec = true;
	}

	public void exitModeSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ModeSpecContext arg) {
		onExit();
		this.inModeSpec = false;
	}

	protected boolean inRules = false;

	@Override
	public void enterRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		final Node node = model.findOrCreate(Label.label("Rules"), "text", arg.getText());
		onEnter(node);
		this.inRules = true;
	}

	public void exitRules(com.generator.generators.antlr.parser.ANTLRv4Parser.RulesContext arg) {
		onExit();
		this.inRules = false;
	}

	protected boolean inRuleSpec = false;

	@Override
	public void enterRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("RuleSpec"), "text", arg.getText());
		onEnter(node);
		this.inRuleSpec = true;
	}

	public void exitRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleSpecContext arg) {
		onExit();
		this.inRuleSpec = false;
	}

	protected boolean inParserRuleSpec = false;

	@Override
	public void enterParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("ParserRuleSpec"), "text", arg.getText());
		onEnter(node);
		this.inParserRuleSpec = true;
	}

	public void exitParserRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ParserRuleSpecContext arg) {
		onExit();
		this.inParserRuleSpec = false;
	}

	protected boolean inExceptionGroup = false;

	@Override
	public void enterExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		final Node node = model.findOrCreate(Label.label("ExceptionGroup"), "text", arg.getText());
		onEnter(node);
		this.inExceptionGroup = true;
	}

	public void exitExceptionGroup(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionGroupContext arg) {
		onExit();
		this.inExceptionGroup = false;
	}

	protected boolean inExceptionHandler = false;

	@Override
	public void enterExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		final Node node = model.findOrCreate(Label.label("ExceptionHandler"), "text", arg.getText());
		onEnter(node);
		this.inExceptionHandler = true;
	}

	public void exitExceptionHandler(com.generator.generators.antlr.parser.ANTLRv4Parser.ExceptionHandlerContext arg) {
		onExit();
		this.inExceptionHandler = false;
	}

	protected boolean inFinallyClause = false;

	@Override
	public void enterFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		final Node node = model.findOrCreate(Label.label("FinallyClause"), "text", arg.getText());
		onEnter(node);
		this.inFinallyClause = true;
	}

	public void exitFinallyClause(com.generator.generators.antlr.parser.ANTLRv4Parser.FinallyClauseContext arg) {
		onExit();
		this.inFinallyClause = false;
	}

	protected boolean inRulePrequel = false;

	@Override
	public void enterRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		final Node node = model.findOrCreate(Label.label("RulePrequel"), "text", arg.getText());
		onEnter(node);
		this.inRulePrequel = true;
	}

	public void exitRulePrequel(com.generator.generators.antlr.parser.ANTLRv4Parser.RulePrequelContext arg) {
		onExit();
		this.inRulePrequel = false;
	}

	protected boolean inRuleReturns = false;

	@Override
	public void enterRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		final Node node = model.findOrCreate(Label.label("RuleReturns"), "text", arg.getText());
		onEnter(node);
		this.inRuleReturns = true;
	}

	public void exitRuleReturns(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleReturnsContext arg) {
		onExit();
		this.inRuleReturns = false;
	}

	protected boolean inThrowsSpec = false;

	@Override
	public void enterThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("ThrowsSpec"), "text", arg.getText());
		onEnter(node);
		this.inThrowsSpec = true;
	}

	public void exitThrowsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.ThrowsSpecContext arg) {
		onExit();
		this.inThrowsSpec = false;
	}

	protected boolean inLocalsSpec = false;

	@Override
	public void enterLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("LocalsSpec"), "text", arg.getText());
		onEnter(node);
		this.inLocalsSpec = true;
	}

	public void exitLocalsSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LocalsSpecContext arg) {
		onExit();
		this.inLocalsSpec = false;
	}

	protected boolean inRuleAction = false;

	@Override
	public void enterRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		final Node node = model.findOrCreate(Label.label("RuleAction"), "text", arg.getText());
		onEnter(node);
		this.inRuleAction = true;
	}

	public void exitRuleAction(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleActionContext arg) {
		onExit();
		this.inRuleAction = false;
	}

	protected boolean inRuleModifiers = false;

	@Override
	public void enterRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		final Node node = model.findOrCreate(Label.label("RuleModifiers"), "text", arg.getText());
		onEnter(node);
		this.inRuleModifiers = true;
	}

	public void exitRuleModifiers(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifiersContext arg) {
		onExit();
		this.inRuleModifiers = false;
	}

	protected boolean inRuleModifier = false;

	@Override
	public void enterRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		final Node node = model.findOrCreate(Label.label("RuleModifier"), "text", arg.getText());
		onEnter(node);
		this.inRuleModifier = true;
	}

	public void exitRuleModifier(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleModifierContext arg) {
		onExit();
		this.inRuleModifier = false;
	}

	protected boolean inRuleBlock = false;

	@Override
	public void enterRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("RuleBlock"), "text", arg.getText());
		onEnter(node);
		this.inRuleBlock = true;
	}

	public void exitRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleBlockContext arg) {
		onExit();
		this.inRuleBlock = false;
	}

	protected boolean inRuleAltList = false;

	@Override
	public void enterRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		final Node node = model.findOrCreate(Label.label("RuleAltList"), "text", arg.getText());
		onEnter(node);
		this.inRuleAltList = true;
	}

	public void exitRuleAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.RuleAltListContext arg) {
		onExit();
		this.inRuleAltList = false;
	}

	protected boolean inLabeledAlt = false;

	@Override
	public void enterLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		final Node node = model.findOrCreate(Label.label("LabeledAlt"), "text", arg.getText());
		onEnter(node);
		this.inLabeledAlt = true;
	}

	public void exitLabeledAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledAltContext arg) {
		onExit();
		this.inLabeledAlt = false;
	}

	protected boolean inGrammarSpec = false;

	@Override
	public void enterGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("GrammarSpec"), "text", arg.getText());
		onEnter(node);
		this.inGrammarSpec = true;
	}

	public void exitGrammarSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.GrammarSpecContext arg) {
		onExit();
		this.inGrammarSpec = false;
	}

	protected boolean inLexerRuleSpec = false;

	@Override
	public void enterLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerRuleSpec"), "text", arg.getText());
		onEnter(node);
		this.inLexerRuleSpec = true;
	}

	public void exitLexerRuleSpec(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleSpecContext arg) {
		onExit();
		this.inLexerRuleSpec = false;
	}

	protected boolean inLexerRuleBlock = false;

	@Override
	public void enterLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerRuleBlock"), "text", arg.getText());
		onEnter(node);
		this.inLexerRuleBlock = true;
	}

	public void exitLexerRuleBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerRuleBlockContext arg) {
		onExit();
		this.inLexerRuleBlock = false;
	}

	protected boolean inLexerAltList = false;

	@Override
	public void enterLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerAltList"), "text", arg.getText());
		onEnter(node);
		this.inLexerAltList = true;
	}

	public void exitLexerAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltListContext arg) {
		onExit();
		this.inLexerAltList = false;
	}

	protected boolean inLexerAlt = false;

	@Override
	public void enterLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerAlt"), "text", arg.getText());
		onEnter(node);
		this.inLexerAlt = true;
	}

	public void exitLexerAlt(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAltContext arg) {
		onExit();
		this.inLexerAlt = false;
	}

	protected boolean inLexerElements = false;

	@Override
	public void enterLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerElements"), "text", arg.getText());
		onEnter(node);
		this.inLexerElements = true;
	}

	public void exitLexerElements(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementsContext arg) {
		onExit();
		this.inLexerElements = false;
	}

	protected boolean inLexerElement = false;

	@Override
	public void enterLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerElement"), "text", arg.getText());
		onEnter(node);
		this.inLexerElement = true;
	}

	public void exitLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerElementContext arg) {
		onExit();
		this.inLexerElement = false;
	}

	protected boolean inLabeledLexerElement = false;

	@Override
	public void enterLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		final Node node = model.findOrCreate(Label.label("LabeledLexerElement"), "text", arg.getText());
		onEnter(node);
		this.inLabeledLexerElement = true;
	}

	public void exitLabeledLexerElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledLexerElementContext arg) {
		onExit();
		this.inLabeledLexerElement = false;
	}

	protected boolean inLexerBlock = false;

	@Override
	public void enterLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerBlock"), "text", arg.getText());
		onEnter(node);
		this.inLexerBlock = true;
	}

	public void exitLexerBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerBlockContext arg) {
		onExit();
		this.inLexerBlock = false;
	}

	protected boolean inLexerCommands = false;

	@Override
	public void enterLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerCommands"), "text", arg.getText());
		onEnter(node);
		this.inLexerCommands = true;
	}

	public void exitLexerCommands(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandsContext arg) {
		onExit();
		this.inLexerCommands = false;
	}

	protected boolean inLexerCommand = false;

	@Override
	public void enterLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerCommand"), "text", arg.getText());
		onEnter(node);
		this.inLexerCommand = true;
	}

	public void exitLexerCommand(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandContext arg) {
		onExit();
		this.inLexerCommand = false;
	}

	protected boolean inLexerCommandName = false;

	@Override
	public void enterLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerCommandName"), "text", arg.getText());
		onEnter(node);
		this.inLexerCommandName = true;
	}

	public void exitLexerCommandName(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandNameContext arg) {
		onExit();
		this.inLexerCommandName = false;
	}

	protected boolean inLexerCommandExpr = false;

	@Override
	public void enterLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerCommandExpr"), "text", arg.getText());
		onEnter(node);
		this.inLexerCommandExpr = true;
	}

	public void exitLexerCommandExpr(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerCommandExprContext arg) {
		onExit();
		this.inLexerCommandExpr = false;
	}

	protected boolean inAltList = false;

	@Override
	public void enterAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		final Node node = model.findOrCreate(Label.label("AltList"), "text", arg.getText());
		onEnter(node);
		this.inAltList = true;
	}

	public void exitAltList(com.generator.generators.antlr.parser.ANTLRv4Parser.AltListContext arg) {
		onExit();
		this.inAltList = false;
	}

	protected boolean inAlternative = false;

	@Override
	public void enterAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		final Node node = model.findOrCreate(Label.label("Alternative"), "text", arg.getText());
		onEnter(node);
		this.inAlternative = true;
	}

	public void exitAlternative(com.generator.generators.antlr.parser.ANTLRv4Parser.AlternativeContext arg) {
		onExit();
		this.inAlternative = false;
	}

	protected boolean inElement = false;

	@Override
	public void enterElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		final Node node = model.findOrCreate(Label.label("Element"), "text", arg.getText());
		onEnter(node);
		this.inElement = true;
	}

	public void exitElement(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementContext arg) {
		onExit();
		this.inElement = false;
	}

	protected boolean inLabeledElement = false;

	@Override
	public void enterLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		final Node node = model.findOrCreate(Label.label("LabeledElement"), "text", arg.getText());
		onEnter(node);
		this.inLabeledElement = true;
	}

	public void exitLabeledElement(com.generator.generators.antlr.parser.ANTLRv4Parser.LabeledElementContext arg) {
		onExit();
		this.inLabeledElement = false;
	}

	protected boolean inEbnf = false;

	@Override
	public void enterEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		final Node node = model.findOrCreate(Label.label("Ebnf"), "text", arg.getText());
		onEnter(node);
		this.inEbnf = true;
	}

	public void exitEbnf(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfContext arg) {
		onExit();
		this.inEbnf = false;
	}

	protected boolean inBlockSuffix = false;

	@Override
	public void enterBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		final Node node = model.findOrCreate(Label.label("BlockSuffix"), "text", arg.getText());
		onEnter(node);
		this.inBlockSuffix = true;
	}

	public void exitBlockSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSuffixContext arg) {
		onExit();
		this.inBlockSuffix = false;
	}

	protected boolean inEbnfSuffix = false;

	@Override
	public void enterEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		final Node node = model.findOrCreate(Label.label("EbnfSuffix"), "text", arg.getText());
		onEnter(node);
		this.inEbnfSuffix = true;
	}

	public void exitEbnfSuffix(com.generator.generators.antlr.parser.ANTLRv4Parser.EbnfSuffixContext arg) {
		onExit();
		this.inEbnfSuffix = false;
	}

	protected boolean inLexerAtom = false;

	@Override
	public void enterLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		final Node node = model.findOrCreate(Label.label("LexerAtom"), "text", arg.getText());
		onEnter(node);
		this.inLexerAtom = true;
	}

	public void exitLexerAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.LexerAtomContext arg) {
		onExit();
		this.inLexerAtom = false;
	}

	protected boolean inAtom = false;

	@Override
	public void enterAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		final Node node = model.findOrCreate(Label.label("Atom"), "text", arg.getText());
		onEnter(node);
		this.inAtom = true;
	}

	public void exitAtom(com.generator.generators.antlr.parser.ANTLRv4Parser.AtomContext arg) {
		onExit();
		this.inAtom = false;
	}

	protected boolean inNotSet = false;

	@Override
	public void enterNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		final Node node = model.findOrCreate(Label.label("NotSet"), "text", arg.getText());
		onEnter(node);
		this.inNotSet = true;
	}

	public void exitNotSet(com.generator.generators.antlr.parser.ANTLRv4Parser.NotSetContext arg) {
		onExit();
		this.inNotSet = false;
	}

	protected boolean inBlockSet = false;

	@Override
	public void enterBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		final Node node = model.findOrCreate(Label.label("BlockSet"), "text", arg.getText());
		onEnter(node);
		this.inBlockSet = true;
	}

	public void exitBlockSet(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockSetContext arg) {
		onExit();
		this.inBlockSet = false;
	}

	protected boolean inSetElement = false;

	@Override
	public void enterSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		final Node node = model.findOrCreate(Label.label("SetElement"), "text", arg.getText());
		onEnter(node);
		this.inSetElement = true;
	}

	public void exitSetElement(com.generator.generators.antlr.parser.ANTLRv4Parser.SetElementContext arg) {
		onExit();
		this.inSetElement = false;
	}

	protected boolean inBlock = false;

	@Override
	public void enterBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		final Node node = model.findOrCreate(Label.label("Block"), "text", arg.getText());
		onEnter(node);
		this.inBlock = true;
	}

	public void exitBlock(com.generator.generators.antlr.parser.ANTLRv4Parser.BlockContext arg) {
		onExit();
		this.inBlock = false;
	}

	protected boolean inRuleref = false;

	@Override
	public void enterRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		final Node node = model.findOrCreate(Label.label("Ruleref"), "text", arg.getText());
		onEnter(node);
		this.inRuleref = true;
	}

	public void exitRuleref(com.generator.generators.antlr.parser.ANTLRv4Parser.RulerefContext arg) {
		onExit();
		this.inRuleref = false;
	}

	protected boolean inCharacterRange = false;

	@Override
	public void enterCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		final Node node = model.findOrCreate(Label.label("CharacterRange"), "text", arg.getText());
		onEnter(node);
		this.inCharacterRange = true;
	}

	public void exitCharacterRange(com.generator.generators.antlr.parser.ANTLRv4Parser.CharacterRangeContext arg) {
		onExit();
		this.inCharacterRange = false;
	}

	protected boolean inTerminal = false;

	@Override
	public void enterTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		final Node node = model.findOrCreate(Label.label("Terminal"), "text", arg.getText());
		onEnter(node);
		this.inTerminal = true;
	}

	public void exitTerminal(com.generator.generators.antlr.parser.ANTLRv4Parser.TerminalContext arg) {
		onExit();
		this.inTerminal = false;
	}

	protected boolean inElementOptions = false;

	@Override
	public void enterElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementOptions"), "text", arg.getText());
		onEnter(node);
		this.inElementOptions = true;
	}

	public void exitElementOptions(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionsContext arg) {
		onExit();
		this.inElementOptions = false;
	}

	protected boolean inElementOption = false;

	@Override
	public void enterElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		final Node node = model.findOrCreate(Label.label("ElementOption"), "text", arg.getText());
		onEnter(node);
		this.inElementOption = true;
	}

	public void exitElementOption(com.generator.generators.antlr.parser.ANTLRv4Parser.ElementOptionContext arg) {
		onExit();
		this.inElementOption = false;
	}

	protected boolean inIdentifier = false;

	@Override
	public void enterIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		final Node node = model.findOrCreate(Label.label("Identifier"), "text", arg.getText());
		onEnter(node);
		this.inIdentifier = true;
	}

	public void exitIdentifier(com.generator.generators.antlr.parser.ANTLRv4Parser.IdentifierContext arg) {
		onExit();
		this.inIdentifier = false;
	}

}