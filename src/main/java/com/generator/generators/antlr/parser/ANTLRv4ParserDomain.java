package com.generator.generators.antlr.parser;

import com.generator.generators.antlr.AntlrGroup;
import com.generator.generators.antlr.bnf.Symbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeSupport;
import java.util.Stack;

public class ANTLRv4ParserDomain extends ANTLRv4ParserNodeListener {

	protected final Stack<Symbol> symbolStack = new Stack<>();

	public ANTLRv4ParserDomain() {
	}

	public ANTLRv4ParserDomain(boolean debug) {
		super(debug);
	}

	public GrammarSpec getGrammarSpec() {
      return (GrammarSpec) symbolStack.peek();
   }

	@Override
	public void enterGrammarSpec(ANTLRv4Parser.GrammarSpecContext arg) {
		super.enterGrammarSpec(arg);
		final GrammarSpec symbol = newGrammarSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitGrammarSpec(ANTLRv4Parser.GrammarSpecContext arg) {
		super.exitGrammarSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterGrammarType(ANTLRv4Parser.GrammarTypeContext arg) {
		super.enterGrammarType(arg);
		final GrammarType symbol = newGrammarType();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitGrammarType(ANTLRv4Parser.GrammarTypeContext arg) {
		super.exitGrammarType(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterIdentifier(ANTLRv4Parser.IdentifierContext arg) {
		super.enterIdentifier(arg);
		final Identifier symbol = newIdentifier();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitIdentifier(ANTLRv4Parser.IdentifierContext arg) {
		super.exitIdentifier(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterPrequelConstruct(ANTLRv4Parser.PrequelConstructContext arg) {
		super.enterPrequelConstruct(arg);
		final PrequelConstruct symbol = newPrequelConstruct();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitPrequelConstruct(ANTLRv4Parser.PrequelConstructContext arg) {
		super.exitPrequelConstruct(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterOptionsSpec(ANTLRv4Parser.OptionsSpecContext arg) {
		super.enterOptionsSpec(arg);
		final OptionsSpec symbol = newOptionsSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitOptionsSpec(ANTLRv4Parser.OptionsSpecContext arg) {
		super.exitOptionsSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterOption(ANTLRv4Parser.OptionContext arg) {
		super.enterOption(arg);
		final Option symbol = newOption();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitOption(ANTLRv4Parser.OptionContext arg) {
		super.exitOption(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterOptionValue(ANTLRv4Parser.OptionValueContext arg) {
		super.enterOptionValue(arg);
		final OptionValue symbol = newOptionValue();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitOptionValue(ANTLRv4Parser.OptionValueContext arg) {
		super.exitOptionValue(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRules(ANTLRv4Parser.RulesContext arg) {
		super.enterRules(arg);
		final Rules symbol = newRules();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRules(ANTLRv4Parser.RulesContext arg) {
		super.exitRules(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
		super.enterRuleSpec(arg);
		final RuleSpec symbol = newRuleSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
		super.exitRuleSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
		super.enterParserRuleSpec(arg);
		final ParserRuleSpec symbol = newParserRuleSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
		super.exitParserRuleSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleBlock(ANTLRv4Parser.RuleBlockContext arg) {
		super.enterRuleBlock(arg);
		final RuleBlock symbol = newRuleBlock();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRuleBlock(ANTLRv4Parser.RuleBlockContext arg) {
		super.exitRuleBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleAltList(ANTLRv4Parser.RuleAltListContext arg) {
		super.enterRuleAltList(arg);
		final RuleAltList symbol = newRuleAltList();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRuleAltList(ANTLRv4Parser.RuleAltListContext arg) {
		super.exitRuleAltList(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLabeledAlt(ANTLRv4Parser.LabeledAltContext arg) {
		super.enterLabeledAlt(arg);
		final LabeledAlt symbol = newLabeledAlt();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLabeledAlt(ANTLRv4Parser.LabeledAltContext arg) {
		super.exitLabeledAlt(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterAlternative(ANTLRv4Parser.AlternativeContext arg) {
		super.enterAlternative(arg);
		final Alternative symbol = newAlternative();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitAlternative(ANTLRv4Parser.AlternativeContext arg) {
		super.exitAlternative(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterElement(ANTLRv4Parser.ElementContext arg) {
		super.enterElement(arg);
		final Element symbol = newElement();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitElement(ANTLRv4Parser.ElementContext arg) {
		super.exitElement(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterAtom(ANTLRv4Parser.AtomContext arg) {
		super.enterAtom(arg);
		final Atom symbol = newAtom();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitAtom(ANTLRv4Parser.AtomContext arg) {
		super.exitAtom(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterTerminal(ANTLRv4Parser.TerminalContext arg) {
		super.enterTerminal(arg);
		final Terminal symbol = newTerminal();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitTerminal(ANTLRv4Parser.TerminalContext arg) {
		super.exitTerminal(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext arg) {
		super.enterEbnfSuffix(arg);
		final EbnfSuffix symbol = newEbnfSuffix();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext arg) {
		super.exitEbnfSuffix(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleref(ANTLRv4Parser.RulerefContext arg) {
		super.enterRuleref(arg);
		final Ruleref symbol = newRuleref();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRuleref(ANTLRv4Parser.RulerefContext arg) {
		super.exitRuleref(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterExceptionGroup(ANTLRv4Parser.ExceptionGroupContext arg) {
		super.enterExceptionGroup(arg);
		final ExceptionGroup symbol = newExceptionGroup();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitExceptionGroup(ANTLRv4Parser.ExceptionGroupContext arg) {
		super.exitExceptionGroup(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterEbnf(ANTLRv4Parser.EbnfContext arg) {
		super.enterEbnf(arg);
		final Ebnf symbol = newEbnf();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitEbnf(ANTLRv4Parser.EbnfContext arg) {
		super.exitEbnf(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterBlock(ANTLRv4Parser.BlockContext arg) {
		super.enterBlock(arg);
		final Block symbol = newBlock();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitBlock(ANTLRv4Parser.BlockContext arg) {
		super.exitBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterAltList(ANTLRv4Parser.AltListContext arg) {
		super.enterAltList(arg);
		final AltList symbol = newAltList();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitAltList(ANTLRv4Parser.AltListContext arg) {
		super.exitAltList(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterBlockSuffix(ANTLRv4Parser.BlockSuffixContext arg) {
		super.enterBlockSuffix(arg);
		final BlockSuffix symbol = newBlockSuffix();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitBlockSuffix(ANTLRv4Parser.BlockSuffixContext arg) {
		super.exitBlockSuffix(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext arg) {
		super.enterDelegateGrammars(arg);
		final DelegateGrammars symbol = newDelegateGrammars();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext arg) {
		super.exitDelegateGrammars(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext arg) {
		super.enterDelegateGrammar(arg);
		final DelegateGrammar symbol = newDelegateGrammar();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext arg) {
		super.exitDelegateGrammar(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterTokensSpec(ANTLRv4Parser.TokensSpecContext arg) {
		super.enterTokensSpec(arg);
		final TokensSpec symbol = newTokensSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitTokensSpec(ANTLRv4Parser.TokensSpecContext arg) {
		super.exitTokensSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterIdList(ANTLRv4Parser.IdListContext arg) {
		super.enterIdList(arg);
		final IdList symbol = newIdList();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitIdList(ANTLRv4Parser.IdListContext arg) {
		super.exitIdList(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterChannelsSpec(ANTLRv4Parser.ChannelsSpecContext arg) {
		super.enterChannelsSpec(arg);
		final ChannelsSpec symbol = newChannelsSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitChannelsSpec(ANTLRv4Parser.ChannelsSpecContext arg) {
		super.exitChannelsSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
		super.enterLexerRuleSpec(arg);
		final LexerRuleSpec symbol = newLexerRuleSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
		super.exitLexerRuleSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext arg) {
		super.enterLexerRuleBlock(arg);
		final LexerRuleBlock symbol = newLexerRuleBlock();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext arg) {
		super.exitLexerRuleBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerAltList(ANTLRv4Parser.LexerAltListContext arg) {
		super.enterLexerAltList(arg);
		final LexerAltList symbol = newLexerAltList();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerAltList(ANTLRv4Parser.LexerAltListContext arg) {
		super.exitLexerAltList(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerAlt(ANTLRv4Parser.LexerAltContext arg) {
		super.enterLexerAlt(arg);
		final LexerAlt symbol = newLexerAlt();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerAlt(ANTLRv4Parser.LexerAltContext arg) {
		super.exitLexerAlt(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerElements(ANTLRv4Parser.LexerElementsContext arg) {
		super.enterLexerElements(arg);
		final LexerElements symbol = newLexerElements();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerElements(ANTLRv4Parser.LexerElementsContext arg) {
		super.exitLexerElements(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerElement(ANTLRv4Parser.LexerElementContext arg) {
		super.enterLexerElement(arg);
		final LexerElement symbol = newLexerElement();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerElement(ANTLRv4Parser.LexerElementContext arg) {
		super.exitLexerElement(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerAtom(ANTLRv4Parser.LexerAtomContext arg) {
		super.enterLexerAtom(arg);
		final LexerAtom symbol = newLexerAtom();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerAtom(ANTLRv4Parser.LexerAtomContext arg) {
		super.exitLexerAtom(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerCommands(ANTLRv4Parser.LexerCommandsContext arg) {
		super.enterLexerCommands(arg);
		final LexerCommands symbol = newLexerCommands();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerCommands(ANTLRv4Parser.LexerCommandsContext arg) {
		super.exitLexerCommands(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerCommand(ANTLRv4Parser.LexerCommandContext arg) {
		super.enterLexerCommand(arg);
		final LexerCommand symbol = newLexerCommand();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerCommand(ANTLRv4Parser.LexerCommandContext arg) {
		super.exitLexerCommand(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerCommandName(ANTLRv4Parser.LexerCommandNameContext arg) {
		super.enterLexerCommandName(arg);
		final LexerCommandName symbol = newLexerCommandName();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerCommandName(ANTLRv4Parser.LexerCommandNameContext arg) {
		super.exitLexerCommandName(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext arg) {
		super.enterLexerCommandExpr(arg);
		final LexerCommandExpr symbol = newLexerCommandExpr();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext arg) {
		super.exitLexerCommandExpr(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterActionBlock(ANTLRv4Parser.ActionBlockContext arg) {
		super.enterActionBlock(arg);
		final ActionBlock symbol = newActionBlock();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitActionBlock(ANTLRv4Parser.ActionBlockContext arg) {
		super.exitActionBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterModeSpec(ANTLRv4Parser.ModeSpecContext arg) {
		super.enterModeSpec(arg);
		final ModeSpec symbol = newModeSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitModeSpec(ANTLRv4Parser.ModeSpecContext arg) {
		super.exitModeSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerBlock(ANTLRv4Parser.LexerBlockContext arg) {
		super.enterLexerBlock(arg);
		final LexerBlock symbol = newLexerBlock();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLexerBlock(ANTLRv4Parser.LexerBlockContext arg) {
		super.exitLexerBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterNotSet(ANTLRv4Parser.NotSetContext arg) {
		super.enterNotSet(arg);
		final NotSet symbol = newNotSet();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitNotSet(ANTLRv4Parser.NotSetContext arg) {
		super.exitNotSet(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterSetElement(ANTLRv4Parser.SetElementContext arg) {
		super.enterSetElement(arg);
		final SetElement symbol = newSetElement();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitSetElement(ANTLRv4Parser.SetElementContext arg) {
		super.exitSetElement(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterCharacterRange(ANTLRv4Parser.CharacterRangeContext arg) {
		super.enterCharacterRange(arg);
		final CharacterRange symbol = newCharacterRange();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitCharacterRange(ANTLRv4Parser.CharacterRangeContext arg) {
		super.exitCharacterRange(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}


	public GrammarSpec newGrammarSpec() {
		return new GrammarSpec();
	}

	public GrammarSpec newGrammarSpec(String name) {
		return new GrammarSpec(name);
	}

	public class GrammarSpec extends Symbol {

		public GrammarSpec() {
			this.type = "GrammarSpec";
		}

		public GrammarSpec(String name) {
			super(name);
			this.type = "GrammarSpec";
		}

		public Symbol addGrammarType(GrammarType child) { return super.addChild(child); }
		public Symbol setGrammarType(GrammarType child) { return super.setChild(child); }

		public Symbol addIdentifier(Identifier child) { return super.addChild(child); }
		public Symbol setIdentifier(Identifier child) { return super.setChild(child); }

		public Symbol addPrequelConstruct(PrequelConstruct child) { return super.addChild(child); }
		public Symbol setPrequelConstruct(PrequelConstruct child) { return super.setChild(child); }

		public Symbol addRules(Rules child) { return super.addChild(child); }
		public Symbol setRules(Rules child) { return super.setChild(child); }

		public Symbol addModeSpec(ModeSpec child) { return super.addChild(child); }
		public Symbol setModeSpec(ModeSpec child) { return super.setChild(child); }

		public Symbol addGrammarSpec(GrammarSpec child) { return super.addChild(child); }
		public Symbol setGrammarSpec(GrammarSpec child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add GrammarType") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final GrammarType child = newGrammarType();
					addGrammarType(child);
					modelChangeSupport.firePropertyChange("GrammarType", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier();
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add PrequelConstruct") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final PrequelConstruct child = newPrequelConstruct();
					addPrequelConstruct(child);
					modelChangeSupport.firePropertyChange("PrequelConstruct", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add Rules") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Rules child = newRules();
					addRules(child);
					modelChangeSupport.firePropertyChange("Rules", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add ModeSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ModeSpec child = newModeSpec();
					addModeSpec(child);
					modelChangeSupport.firePropertyChange("ModeSpec", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add GrammarSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final GrammarSpec child = newGrammarSpec();
					addGrammarSpec(child);
					modelChangeSupport.firePropertyChange("GrammarSpec", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public GrammarType newGrammarType() {
		return new GrammarType();
	}

	public GrammarType newGrammarType(String name) {
		return new GrammarType(name);
	}

	public class GrammarType extends Symbol {

		public GrammarType() {
			this.type = "GrammarType";
		}

		public GrammarType(String name) {
			super(name);
			this.type = "GrammarType";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Identifier newIdentifier() {
		return new Identifier();
	}

	public Identifier newIdentifier(String name) {
		return new Identifier(name);
	}

	public class Identifier extends Symbol {

		public Identifier() {
			this.type = "Identifier";
		}

		public Identifier(String name) {
			super(name);
			this.type = "Identifier";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public PrequelConstruct newPrequelConstruct() {
		return new PrequelConstruct();
	}

	public PrequelConstruct newPrequelConstruct(String name) {
		return new PrequelConstruct(name);
	}

	public class PrequelConstruct extends Symbol {

		public PrequelConstruct() {
			this.type = "PrequelConstruct";
		}

		public PrequelConstruct(String name) {
			super(name);
			this.type = "PrequelConstruct";
		}

		public Symbol addOptionsSpec(OptionsSpec child) { return super.addChild(child); }
		public Symbol setOptionsSpec(OptionsSpec child) { return super.setChild(child); }

		public Symbol addDelegateGrammars(DelegateGrammars child) { return super.addChild(child); }
		public Symbol setDelegateGrammars(DelegateGrammars child) { return super.setChild(child); }

		public Symbol addTokensSpec(TokensSpec child) { return super.addChild(child); }
		public Symbol setTokensSpec(TokensSpec child) { return super.setChild(child); }

		public Symbol addChannelsSpec(ChannelsSpec child) { return super.addChild(child); }
		public Symbol setChannelsSpec(ChannelsSpec child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add OptionsSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final OptionsSpec child = newOptionsSpec();
					addOptionsSpec(child);
					modelChangeSupport.firePropertyChange("OptionsSpec", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add DelegateGrammars") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final DelegateGrammars child = newDelegateGrammars();
					addDelegateGrammars(child);
					modelChangeSupport.firePropertyChange("DelegateGrammars", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add TokensSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final TokensSpec child = newTokensSpec();
					addTokensSpec(child);
					modelChangeSupport.firePropertyChange("TokensSpec", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add ChannelsSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ChannelsSpec child = newChannelsSpec();
					addChannelsSpec(child);
					modelChangeSupport.firePropertyChange("ChannelsSpec", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public OptionsSpec newOptionsSpec() {
		return new OptionsSpec();
	}

	public OptionsSpec newOptionsSpec(String name) {
		return new OptionsSpec(name);
	}

	public class OptionsSpec extends Symbol {

		public OptionsSpec() {
			this.type = "OptionsSpec";
		}

		public OptionsSpec(String name) {
			super(name);
			this.type = "OptionsSpec";
		}

		public Symbol addOption(Option child) { return super.addChild(child); }
		public Symbol setOption(Option child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Option") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Option child = newOption();
					addOption(child);
					modelChangeSupport.firePropertyChange("Option", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Option newOption() {
		return new Option();
	}

	public Option newOption(String name) {
		return new Option(name);
	}

	public class Option extends Symbol {

		public Option() {
			this.type = "Option";
		}

		public Option(String name) {
			super(name);
			this.type = "Option";
		}

		public Symbol addIdentifier(Identifier child) { return super.addChild(child); }
		public Symbol setIdentifier(Identifier child) { return super.setChild(child); }

		public Symbol addOptionValue(OptionValue child) { return super.addChild(child); }
		public Symbol setOptionValue(OptionValue child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier();
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add OptionValue") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final OptionValue child = newOptionValue();
					addOptionValue(child);
					modelChangeSupport.firePropertyChange("OptionValue", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public OptionValue newOptionValue() {
		return new OptionValue();
	}

	public OptionValue newOptionValue(String name) {
		return new OptionValue(name);
	}

	public class OptionValue extends Symbol {

		public OptionValue() {
			this.type = "OptionValue";
		}

		public OptionValue(String name) {
			super(name);
			this.type = "OptionValue";
		}

		public Symbol addIdentifier(Identifier child) { return super.addChild(child); }
		public Symbol setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier();
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Rules newRules() {
		return new Rules();
	}

	public Rules newRules(String name) {
		return new Rules(name);
	}

	public class Rules extends Symbol {

		public Rules() {
			this.type = "Rules";
		}

		public Rules(String name) {
			super(name);
			this.type = "Rules";
		}

		public Symbol addRuleSpec(RuleSpec child) { return super.addChild(child); }
		public Symbol setRuleSpec(RuleSpec child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add RuleSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final RuleSpec child = newRuleSpec();
					addRuleSpec(child);
					modelChangeSupport.firePropertyChange("RuleSpec", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public RuleSpec newRuleSpec() {
		return new RuleSpec();
	}

	public RuleSpec newRuleSpec(String name) {
		return new RuleSpec(name);
	}

	public class RuleSpec extends Symbol {

		public RuleSpec() {
			this.type = "RuleSpec";
		}

		public RuleSpec(String name) {
			super(name);
			this.type = "RuleSpec";
		}

		public Symbol addParserRuleSpec(ParserRuleSpec child) { return super.addChild(child); }
		public Symbol setParserRuleSpec(ParserRuleSpec child) { return super.setChild(child); }

		public Symbol addLexerRuleSpec(LexerRuleSpec child) { return super.addChild(child); }
		public Symbol setLexerRuleSpec(LexerRuleSpec child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add ParserRuleSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ParserRuleSpec child = newParserRuleSpec();
					addParserRuleSpec(child);
					modelChangeSupport.firePropertyChange("ParserRuleSpec", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerRuleSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerRuleSpec child = newLexerRuleSpec();
					addLexerRuleSpec(child);
					modelChangeSupport.firePropertyChange("LexerRuleSpec", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public ParserRuleSpec newParserRuleSpec() {
		return new ParserRuleSpec();
	}

	public ParserRuleSpec newParserRuleSpec(String name) {
		return new ParserRuleSpec(name);
	}

	public class ParserRuleSpec extends Symbol {

		public ParserRuleSpec() {
			this.type = "ParserRuleSpec";
		}

		public ParserRuleSpec(String name) {
			super(name);
			this.type = "ParserRuleSpec";
		}

		public Symbol addRuleBlock(RuleBlock child) { return super.addChild(child); }
		public Symbol setRuleBlock(RuleBlock child) { return super.setChild(child); }

		public Symbol addExceptionGroup(ExceptionGroup child) { return super.addChild(child); }
		public Symbol setExceptionGroup(ExceptionGroup child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add RuleBlock") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final RuleBlock child = newRuleBlock();
					addRuleBlock(child);
					modelChangeSupport.firePropertyChange("RuleBlock", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add ExceptionGroup") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ExceptionGroup child = newExceptionGroup();
					addExceptionGroup(child);
					modelChangeSupport.firePropertyChange("ExceptionGroup", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public RuleBlock newRuleBlock() {
		return new RuleBlock();
	}

	public RuleBlock newRuleBlock(String name) {
		return new RuleBlock(name);
	}

	public class RuleBlock extends Symbol {

		public RuleBlock() {
			this.type = "RuleBlock";
		}

		public RuleBlock(String name) {
			super(name);
			this.type = "RuleBlock";
		}

		public Symbol addRuleAltList(RuleAltList child) { return super.addChild(child); }
		public Symbol setRuleAltList(RuleAltList child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add RuleAltList") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final RuleAltList child = newRuleAltList();
					addRuleAltList(child);
					modelChangeSupport.firePropertyChange("RuleAltList", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public RuleAltList newRuleAltList() {
		return new RuleAltList();
	}

	public RuleAltList newRuleAltList(String name) {
		return new RuleAltList(name);
	}

	public class RuleAltList extends Symbol {

		public RuleAltList() {
			this.type = "RuleAltList";
		}

		public RuleAltList(String name) {
			super(name);
			this.type = "RuleAltList";
		}

		public Symbol addLabeledAlt(LabeledAlt child) { return super.addChild(child); }
		public Symbol setLabeledAlt(LabeledAlt child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LabeledAlt") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LabeledAlt child = newLabeledAlt();
					addLabeledAlt(child);
					modelChangeSupport.firePropertyChange("LabeledAlt", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LabeledAlt newLabeledAlt() {
		return new LabeledAlt();
	}

	public LabeledAlt newLabeledAlt(String name) {
		return new LabeledAlt(name);
	}

	public class LabeledAlt extends Symbol {

		public LabeledAlt() {
			this.type = "LabeledAlt";
		}

		public LabeledAlt(String name) {
			super(name);
			this.type = "LabeledAlt";
		}

		public Symbol addAlternative(Alternative child) { return super.addChild(child); }
		public Symbol setAlternative(Alternative child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Alternative") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Alternative child = newAlternative();
					addAlternative(child);
					modelChangeSupport.firePropertyChange("Alternative", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Alternative newAlternative() {
		return new Alternative();
	}

	public Alternative newAlternative(String name) {
		return new Alternative(name);
	}

	public class Alternative extends Symbol {

		public Alternative() {
			this.type = "Alternative";
		}

		public Alternative(String name) {
			super(name);
			this.type = "Alternative";
		}

		public Symbol addElement(Element child) { return super.addChild(child); }
		public Symbol setElement(Element child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Element") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Element child = newElement();
					addElement(child);
					modelChangeSupport.firePropertyChange("Element", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Element newElement() {
		return new Element();
	}

	public Element newElement(String name) {
		return new Element(name);
	}

	public class Element extends Symbol {

		public Element() {
			this.type = "Element";
		}

		public Element(String name) {
			super(name);
			this.type = "Element";
		}

		public Symbol addAtom(Atom child) { return super.addChild(child); }
		public Symbol setAtom(Atom child) { return super.setChild(child); }

		public Symbol addEbnfSuffix(EbnfSuffix child) { return super.addChild(child); }
		public Symbol setEbnfSuffix(EbnfSuffix child) { return super.setChild(child); }

		public Symbol addEbnf(Ebnf child) { return super.addChild(child); }
		public Symbol setEbnf(Ebnf child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Atom") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Atom child = newAtom();
					addAtom(child);
					modelChangeSupport.firePropertyChange("Atom", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add EbnfSuffix") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final EbnfSuffix child = newEbnfSuffix();
					addEbnfSuffix(child);
					modelChangeSupport.firePropertyChange("EbnfSuffix", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add Ebnf") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Ebnf child = newEbnf();
					addEbnf(child);
					modelChangeSupport.firePropertyChange("Ebnf", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Atom newAtom() {
		return new Atom();
	}

	public Atom newAtom(String name) {
		return new Atom(name);
	}

	public class Atom extends Symbol {

		public Atom() {
			this.type = "Atom";
		}

		public Atom(String name) {
			super(name);
			this.type = "Atom";
		}

		public Symbol addTerminal(Terminal child) { return super.addChild(child); }
		public Symbol setTerminal(Terminal child) { return super.setChild(child); }

		public Symbol addRuleref(Ruleref child) { return super.addChild(child); }
		public Symbol setRuleref(Ruleref child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Terminal") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Terminal child = newTerminal();
					addTerminal(child);
					modelChangeSupport.firePropertyChange("Terminal", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add Ruleref") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Ruleref child = newRuleref();
					addRuleref(child);
					modelChangeSupport.firePropertyChange("Ruleref", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Terminal newTerminal() {
		return new Terminal();
	}

	public Terminal newTerminal(String name) {
		return new Terminal(name);
	}

	public class Terminal extends Symbol {

		public Terminal() {
			this.type = "Terminal";
		}

		public Terminal(String name) {
			super(name);
			this.type = "Terminal";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public EbnfSuffix newEbnfSuffix() {
		return new EbnfSuffix();
	}

	public EbnfSuffix newEbnfSuffix(String name) {
		return new EbnfSuffix(name);
	}

	public class EbnfSuffix extends Symbol {

		public EbnfSuffix() {
			this.type = "EbnfSuffix";
		}

		public EbnfSuffix(String name) {
			super(name);
			this.type = "EbnfSuffix";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Ruleref newRuleref() {
		return new Ruleref();
	}

	public Ruleref newRuleref(String name) {
		return new Ruleref(name);
	}

	public class Ruleref extends Symbol {

		public Ruleref() {
			this.type = "Ruleref";
		}

		public Ruleref(String name) {
			super(name);
			this.type = "Ruleref";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public ExceptionGroup newExceptionGroup() {
		return new ExceptionGroup();
	}

	public ExceptionGroup newExceptionGroup(String name) {
		return new ExceptionGroup(name);
	}

	public class ExceptionGroup extends Symbol {

		public ExceptionGroup() {
			this.type = "ExceptionGroup";
		}

		public ExceptionGroup(String name) {
			super(name);
			this.type = "ExceptionGroup";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Ebnf newEbnf() {
		return new Ebnf();
	}

	public Ebnf newEbnf(String name) {
		return new Ebnf(name);
	}

	public class Ebnf extends Symbol {

		public Ebnf() {
			this.type = "Ebnf";
		}

		public Ebnf(String name) {
			super(name);
			this.type = "Ebnf";
		}

		public Symbol addBlock(Block child) { return super.addChild(child); }
		public Symbol setBlock(Block child) { return super.setChild(child); }

		public Symbol addBlockSuffix(BlockSuffix child) { return super.addChild(child); }
		public Symbol setBlockSuffix(BlockSuffix child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Block") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Block child = newBlock();
					addBlock(child);
					modelChangeSupport.firePropertyChange("Block", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add BlockSuffix") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final BlockSuffix child = newBlockSuffix();
					addBlockSuffix(child);
					modelChangeSupport.firePropertyChange("BlockSuffix", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public Block newBlock() {
		return new Block();
	}

	public Block newBlock(String name) {
		return new Block(name);
	}

	public class Block extends Symbol {

		public Block() {
			this.type = "Block";
		}

		public Block(String name) {
			super(name);
			this.type = "Block";
		}

		public Symbol addAltList(AltList child) { return super.addChild(child); }
		public Symbol setAltList(AltList child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add AltList") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final AltList child = newAltList();
					addAltList(child);
					modelChangeSupport.firePropertyChange("AltList", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public AltList newAltList() {
		return new AltList();
	}

	public AltList newAltList(String name) {
		return new AltList(name);
	}

	public class AltList extends Symbol {

		public AltList() {
			this.type = "AltList";
		}

		public AltList(String name) {
			super(name);
			this.type = "AltList";
		}

		public Symbol addAlternative(Alternative child) { return super.addChild(child); }
		public Symbol setAlternative(Alternative child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Alternative") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Alternative child = newAlternative();
					addAlternative(child);
					modelChangeSupport.firePropertyChange("Alternative", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public BlockSuffix newBlockSuffix() {
		return new BlockSuffix();
	}

	public BlockSuffix newBlockSuffix(String name) {
		return new BlockSuffix(name);
	}

	public class BlockSuffix extends Symbol {

		public BlockSuffix() {
			this.type = "BlockSuffix";
		}

		public BlockSuffix(String name) {
			super(name);
			this.type = "BlockSuffix";
		}

		public Symbol addEbnfSuffix(EbnfSuffix child) { return super.addChild(child); }
		public Symbol setEbnfSuffix(EbnfSuffix child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add EbnfSuffix") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final EbnfSuffix child = newEbnfSuffix();
					addEbnfSuffix(child);
					modelChangeSupport.firePropertyChange("EbnfSuffix", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public DelegateGrammars newDelegateGrammars() {
		return new DelegateGrammars();
	}

	public DelegateGrammars newDelegateGrammars(String name) {
		return new DelegateGrammars(name);
	}

	public class DelegateGrammars extends Symbol {

		public DelegateGrammars() {
			this.type = "DelegateGrammars";
		}

		public DelegateGrammars(String name) {
			super(name);
			this.type = "DelegateGrammars";
		}

		public Symbol addDelegateGrammar(DelegateGrammar child) { return super.addChild(child); }
		public Symbol setDelegateGrammar(DelegateGrammar child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add DelegateGrammar") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final DelegateGrammar child = newDelegateGrammar();
					addDelegateGrammar(child);
					modelChangeSupport.firePropertyChange("DelegateGrammar", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public DelegateGrammar newDelegateGrammar() {
		return new DelegateGrammar();
	}

	public DelegateGrammar newDelegateGrammar(String name) {
		return new DelegateGrammar(name);
	}

	public class DelegateGrammar extends Symbol {

		public DelegateGrammar() {
			this.type = "DelegateGrammar";
		}

		public DelegateGrammar(String name) {
			super(name);
			this.type = "DelegateGrammar";
		}

		public Symbol addIdentifier(Identifier child) { return super.addChild(child); }
		public Symbol setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier();
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public TokensSpec newTokensSpec() {
		return new TokensSpec();
	}

	public TokensSpec newTokensSpec(String name) {
		return new TokensSpec(name);
	}

	public class TokensSpec extends Symbol {

		public TokensSpec() {
			this.type = "TokensSpec";
		}

		public TokensSpec(String name) {
			super(name);
			this.type = "TokensSpec";
		}

		public Symbol addIdList(IdList child) { return super.addChild(child); }
		public Symbol setIdList(IdList child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add IdList") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final IdList child = newIdList();
					addIdList(child);
					modelChangeSupport.firePropertyChange("IdList", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public IdList newIdList() {
		return new IdList();
	}

	public IdList newIdList(String name) {
		return new IdList(name);
	}

	public class IdList extends Symbol {

		public IdList() {
			this.type = "IdList";
		}

		public IdList(String name) {
			super(name);
			this.type = "IdList";
		}

		public Symbol addIdentifier(Identifier child) { return super.addChild(child); }
		public Symbol setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier();
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public ChannelsSpec newChannelsSpec() {
		return new ChannelsSpec();
	}

	public ChannelsSpec newChannelsSpec(String name) {
		return new ChannelsSpec(name);
	}

	public class ChannelsSpec extends Symbol {

		public ChannelsSpec() {
			this.type = "ChannelsSpec";
		}

		public ChannelsSpec(String name) {
			super(name);
			this.type = "ChannelsSpec";
		}

		public Symbol addIdList(IdList child) { return super.addChild(child); }
		public Symbol setIdList(IdList child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add IdList") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final IdList child = newIdList();
					addIdList(child);
					modelChangeSupport.firePropertyChange("IdList", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerRuleSpec newLexerRuleSpec() {
		return new LexerRuleSpec();
	}

	public LexerRuleSpec newLexerRuleSpec(String name) {
		return new LexerRuleSpec(name);
	}

	public class LexerRuleSpec extends Symbol {

		public LexerRuleSpec() {
			this.type = "LexerRuleSpec";
		}

		public LexerRuleSpec(String name) {
			super(name);
			this.type = "LexerRuleSpec";
		}

		public Symbol addLexerRuleBlock(LexerRuleBlock child) { return super.addChild(child); }
		public Symbol setLexerRuleBlock(LexerRuleBlock child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerRuleBlock") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerRuleBlock child = newLexerRuleBlock();
					addLexerRuleBlock(child);
					modelChangeSupport.firePropertyChange("LexerRuleBlock", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerRuleBlock newLexerRuleBlock() {
		return new LexerRuleBlock();
	}

	public LexerRuleBlock newLexerRuleBlock(String name) {
		return new LexerRuleBlock(name);
	}

	public class LexerRuleBlock extends Symbol {

		public LexerRuleBlock() {
			this.type = "LexerRuleBlock";
		}

		public LexerRuleBlock(String name) {
			super(name);
			this.type = "LexerRuleBlock";
		}

		public Symbol addLexerAltList(LexerAltList child) { return super.addChild(child); }
		public Symbol setLexerAltList(LexerAltList child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerAltList") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerAltList child = newLexerAltList();
					addLexerAltList(child);
					modelChangeSupport.firePropertyChange("LexerAltList", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerAltList newLexerAltList() {
		return new LexerAltList();
	}

	public LexerAltList newLexerAltList(String name) {
		return new LexerAltList(name);
	}

	public class LexerAltList extends Symbol {

		public LexerAltList() {
			this.type = "LexerAltList";
		}

		public LexerAltList(String name) {
			super(name);
			this.type = "LexerAltList";
		}

		public Symbol addLexerAlt(LexerAlt child) { return super.addChild(child); }
		public Symbol setLexerAlt(LexerAlt child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerAlt") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerAlt child = newLexerAlt();
					addLexerAlt(child);
					modelChangeSupport.firePropertyChange("LexerAlt", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerAlt newLexerAlt() {
		return new LexerAlt();
	}

	public LexerAlt newLexerAlt(String name) {
		return new LexerAlt(name);
	}

	public class LexerAlt extends Symbol {

		public LexerAlt() {
			this.type = "LexerAlt";
		}

		public LexerAlt(String name) {
			super(name);
			this.type = "LexerAlt";
		}

		public Symbol addLexerElements(LexerElements child) { return super.addChild(child); }
		public Symbol setLexerElements(LexerElements child) { return super.setChild(child); }

		public Symbol addLexerCommands(LexerCommands child) { return super.addChild(child); }
		public Symbol setLexerCommands(LexerCommands child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerElements") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerElements child = newLexerElements();
					addLexerElements(child);
					modelChangeSupport.firePropertyChange("LexerElements", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerCommands") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerCommands child = newLexerCommands();
					addLexerCommands(child);
					modelChangeSupport.firePropertyChange("LexerCommands", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerElements newLexerElements() {
		return new LexerElements();
	}

	public LexerElements newLexerElements(String name) {
		return new LexerElements(name);
	}

	public class LexerElements extends Symbol {

		public LexerElements() {
			this.type = "LexerElements";
		}

		public LexerElements(String name) {
			super(name);
			this.type = "LexerElements";
		}

		public Symbol addLexerElement(LexerElement child) { return super.addChild(child); }
		public Symbol setLexerElement(LexerElement child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerElement") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerElement child = newLexerElement();
					addLexerElement(child);
					modelChangeSupport.firePropertyChange("LexerElement", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerElement newLexerElement() {
		return new LexerElement();
	}

	public LexerElement newLexerElement(String name) {
		return new LexerElement(name);
	}

	public class LexerElement extends Symbol {

		public LexerElement() {
			this.type = "LexerElement";
		}

		public LexerElement(String name) {
			super(name);
			this.type = "LexerElement";
		}

		public Symbol addLexerAtom(LexerAtom child) { return super.addChild(child); }
		public Symbol setLexerAtom(LexerAtom child) { return super.setChild(child); }

		public Symbol addActionBlock(ActionBlock child) { return super.addChild(child); }
		public Symbol setActionBlock(ActionBlock child) { return super.setChild(child); }

		public Symbol addEbnfSuffix(EbnfSuffix child) { return super.addChild(child); }
		public Symbol setEbnfSuffix(EbnfSuffix child) { return super.setChild(child); }

		public Symbol addLexerBlock(LexerBlock child) { return super.addChild(child); }
		public Symbol setLexerBlock(LexerBlock child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerAtom") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerAtom child = newLexerAtom();
					addLexerAtom(child);
					modelChangeSupport.firePropertyChange("LexerAtom", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add ActionBlock") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ActionBlock child = newActionBlock();
					addActionBlock(child);
					modelChangeSupport.firePropertyChange("ActionBlock", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add EbnfSuffix") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final EbnfSuffix child = newEbnfSuffix();
					addEbnfSuffix(child);
					modelChangeSupport.firePropertyChange("EbnfSuffix", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerBlock") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerBlock child = newLexerBlock();
					addLexerBlock(child);
					modelChangeSupport.firePropertyChange("LexerBlock", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerAtom newLexerAtom() {
		return new LexerAtom();
	}

	public LexerAtom newLexerAtom(String name) {
		return new LexerAtom(name);
	}

	public class LexerAtom extends Symbol {

		public LexerAtom() {
			this.type = "LexerAtom";
		}

		public LexerAtom(String name) {
			super(name);
			this.type = "LexerAtom";
		}

		public Symbol addTerminal(Terminal child) { return super.addChild(child); }
		public Symbol setTerminal(Terminal child) { return super.setChild(child); }

		public Symbol addNotSet(NotSet child) { return super.addChild(child); }
		public Symbol setNotSet(NotSet child) { return super.setChild(child); }

		public Symbol addCharacterRange(CharacterRange child) { return super.addChild(child); }
		public Symbol setCharacterRange(CharacterRange child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Terminal") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Terminal child = newTerminal();
					addTerminal(child);
					modelChangeSupport.firePropertyChange("Terminal", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add NotSet") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final NotSet child = newNotSet();
					addNotSet(child);
					modelChangeSupport.firePropertyChange("NotSet", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add CharacterRange") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final CharacterRange child = newCharacterRange();
					addCharacterRange(child);
					modelChangeSupport.firePropertyChange("CharacterRange", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerCommands newLexerCommands() {
		return new LexerCommands();
	}

	public LexerCommands newLexerCommands(String name) {
		return new LexerCommands(name);
	}

	public class LexerCommands extends Symbol {

		public LexerCommands() {
			this.type = "LexerCommands";
		}

		public LexerCommands(String name) {
			super(name);
			this.type = "LexerCommands";
		}

		public Symbol addLexerCommand(LexerCommand child) { return super.addChild(child); }
		public Symbol setLexerCommand(LexerCommand child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerCommand") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerCommand child = newLexerCommand();
					addLexerCommand(child);
					modelChangeSupport.firePropertyChange("LexerCommand", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerCommand newLexerCommand() {
		return new LexerCommand();
	}

	public LexerCommand newLexerCommand(String name) {
		return new LexerCommand(name);
	}

	public class LexerCommand extends Symbol {

		public LexerCommand() {
			this.type = "LexerCommand";
		}

		public LexerCommand(String name) {
			super(name);
			this.type = "LexerCommand";
		}

		public Symbol addLexerCommandName(LexerCommandName child) { return super.addChild(child); }
		public Symbol setLexerCommandName(LexerCommandName child) { return super.setChild(child); }

		public Symbol addLexerCommandExpr(LexerCommandExpr child) { return super.addChild(child); }
		public Symbol setLexerCommandExpr(LexerCommandExpr child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerCommandName") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerCommandName child = newLexerCommandName();
					addLexerCommandName(child);
					modelChangeSupport.firePropertyChange("LexerCommandName", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerCommandExpr") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerCommandExpr child = newLexerCommandExpr();
					addLexerCommandExpr(child);
					modelChangeSupport.firePropertyChange("LexerCommandExpr", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerCommandName newLexerCommandName() {
		return new LexerCommandName();
	}

	public LexerCommandName newLexerCommandName(String name) {
		return new LexerCommandName(name);
	}

	public class LexerCommandName extends Symbol {

		public LexerCommandName() {
			this.type = "LexerCommandName";
		}

		public LexerCommandName(String name) {
			super(name);
			this.type = "LexerCommandName";
		}

		public Symbol addIdentifier(Identifier child) { return super.addChild(child); }
		public Symbol setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier();
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerCommandExpr newLexerCommandExpr() {
		return new LexerCommandExpr();
	}

	public LexerCommandExpr newLexerCommandExpr(String name) {
		return new LexerCommandExpr(name);
	}

	public class LexerCommandExpr extends Symbol {

		public LexerCommandExpr() {
			this.type = "LexerCommandExpr";
		}

		public LexerCommandExpr(String name) {
			super(name);
			this.type = "LexerCommandExpr";
		}

		public Symbol addIdentifier(Identifier child) { return super.addChild(child); }
		public Symbol setIdentifier(Identifier child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier();
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public ActionBlock newActionBlock() {
		return new ActionBlock();
	}

	public ActionBlock newActionBlock(String name) {
		return new ActionBlock(name);
	}

	public class ActionBlock extends Symbol {

		public ActionBlock() {
			this.type = "ActionBlock";
		}

		public ActionBlock(String name) {
			super(name);
			this.type = "ActionBlock";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public ModeSpec newModeSpec() {
		return new ModeSpec();
	}

	public ModeSpec newModeSpec(String name) {
		return new ModeSpec(name);
	}

	public class ModeSpec extends Symbol {

		public ModeSpec() {
			this.type = "ModeSpec";
		}

		public ModeSpec(String name) {
			super(name);
			this.type = "ModeSpec";
		}

		public Symbol addIdentifier(Identifier child) { return super.addChild(child); }
		public Symbol setIdentifier(Identifier child) { return super.setChild(child); }

		public Symbol addLexerRuleSpec(LexerRuleSpec child) { return super.addChild(child); }
		public Symbol setLexerRuleSpec(LexerRuleSpec child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier();
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerRuleSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerRuleSpec child = newLexerRuleSpec();
					addLexerRuleSpec(child);
					modelChangeSupport.firePropertyChange("LexerRuleSpec", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public LexerBlock newLexerBlock() {
		return new LexerBlock();
	}

	public LexerBlock newLexerBlock(String name) {
		return new LexerBlock(name);
	}

	public class LexerBlock extends Symbol {

		public LexerBlock() {
			this.type = "LexerBlock";
		}

		public LexerBlock(String name) {
			super(name);
			this.type = "LexerBlock";
		}

		public Symbol addLexerAltList(LexerAltList child) { return super.addChild(child); }
		public Symbol setLexerAltList(LexerAltList child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add LexerAltList") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerAltList child = newLexerAltList();
					addLexerAltList(child);
					modelChangeSupport.firePropertyChange("LexerAltList", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public NotSet newNotSet() {
		return new NotSet();
	}

	public NotSet newNotSet(String name) {
		return new NotSet(name);
	}

	public class NotSet extends Symbol {

		public NotSet() {
			this.type = "NotSet";
		}

		public NotSet(String name) {
			super(name);
			this.type = "NotSet";
		}

		public Symbol addSetElement(SetElement child) { return super.addChild(child); }
		public Symbol setSetElement(SetElement child) { return super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {

			menu.add(new AbstractAction("Add SetElement") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final SetElement child = newSetElement();
					addSetElement(child);
					modelChangeSupport.firePropertyChange("SetElement", "Add", child);
				}
			});


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public SetElement newSetElement() {
		return new SetElement();
	}

	public SetElement newSetElement(String name) {
		return new SetElement(name);
	}

	public class SetElement extends Symbol {

		public SetElement() {
			this.type = "SetElement";
		}

		public SetElement(String name) {
			super(name);
			this.type = "SetElement";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}
	public CharacterRange newCharacterRange() {
		return new CharacterRange();
	}

	public CharacterRange newCharacterRange(String name) {
		return new CharacterRange(name);
	}

	public class CharacterRange extends Symbol {

		public CharacterRange() {
			this.type = "CharacterRange";
		}

		public CharacterRange(String name) {
			super(name);
			this.type = "CharacterRange";
		}


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<Symbol, java.awt.geom.Rectangle2D> shapeMap) {
	   	return super.paint(startX, startY, g, shapeMap);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {


			super.addActionsTo(menu, modelChangeSupport);
		}

		@Override
		public Object toGrammar(AntlrGroup antlrGroup) {
			return super.toGrammar(antlrGroup);
		}
	}

}