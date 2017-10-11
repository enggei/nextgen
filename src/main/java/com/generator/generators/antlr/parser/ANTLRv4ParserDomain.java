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
      return symbolStack.isEmpty() ? null : (GrammarSpec) symbolStack.peek();
   }

	@Override
	public void enterGrammarSpec(ANTLRv4Parser.GrammarSpecContext arg) {
		super.enterGrammarSpec(arg);
		final GrammarSpec symbol = newGrammarSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitGrammarSpec(ANTLRv4Parser.GrammarSpecContext arg) {
		super.exitGrammarSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterGrammarType(ANTLRv4Parser.GrammarTypeContext arg) {
		super.enterGrammarType(arg);
		final GrammarType symbol = newGrammarType(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitGrammarType(ANTLRv4Parser.GrammarTypeContext arg) {
		super.exitGrammarType(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterIdentifier(ANTLRv4Parser.IdentifierContext arg) {
		super.enterIdentifier(arg);
		final Identifier symbol = newIdentifier(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitIdentifier(ANTLRv4Parser.IdentifierContext arg) {
		super.exitIdentifier(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterPrequelConstruct(ANTLRv4Parser.PrequelConstructContext arg) {
		super.enterPrequelConstruct(arg);
		final PrequelConstruct symbol = newPrequelConstruct(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitPrequelConstruct(ANTLRv4Parser.PrequelConstructContext arg) {
		super.exitPrequelConstruct(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterOptionsSpec(ANTLRv4Parser.OptionsSpecContext arg) {
		super.enterOptionsSpec(arg);
		final OptionsSpec symbol = newOptionsSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitOptionsSpec(ANTLRv4Parser.OptionsSpecContext arg) {
		super.exitOptionsSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterOption(ANTLRv4Parser.OptionContext arg) {
		super.enterOption(arg);
		final Option symbol = newOption(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitOption(ANTLRv4Parser.OptionContext arg) {
		super.exitOption(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterOptionValue(ANTLRv4Parser.OptionValueContext arg) {
		super.enterOptionValue(arg);
		final OptionValue symbol = newOptionValue(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitOptionValue(ANTLRv4Parser.OptionValueContext arg) {
		super.exitOptionValue(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRules(ANTLRv4Parser.RulesContext arg) {
		super.enterRules(arg);
		final Rules symbol = newRules(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitRules(ANTLRv4Parser.RulesContext arg) {
		super.exitRules(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
		super.enterRuleSpec(arg);
		final RuleSpec symbol = newRuleSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
		super.exitRuleSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
		super.enterParserRuleSpec(arg);
		final ParserRuleSpec symbol = newParserRuleSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
		super.exitParserRuleSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleBlock(ANTLRv4Parser.RuleBlockContext arg) {
		super.enterRuleBlock(arg);
		final RuleBlock symbol = newRuleBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitRuleBlock(ANTLRv4Parser.RuleBlockContext arg) {
		super.exitRuleBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleAltList(ANTLRv4Parser.RuleAltListContext arg) {
		super.enterRuleAltList(arg);
		final RuleAltList symbol = newRuleAltList(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitRuleAltList(ANTLRv4Parser.RuleAltListContext arg) {
		super.exitRuleAltList(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLabeledAlt(ANTLRv4Parser.LabeledAltContext arg) {
		super.enterLabeledAlt(arg);
		final LabeledAlt symbol = newLabeledAlt(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLabeledAlt(ANTLRv4Parser.LabeledAltContext arg) {
		super.exitLabeledAlt(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterAlternative(ANTLRv4Parser.AlternativeContext arg) {
		super.enterAlternative(arg);
		final Alternative symbol = newAlternative(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitAlternative(ANTLRv4Parser.AlternativeContext arg) {
		super.exitAlternative(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterElement(ANTLRv4Parser.ElementContext arg) {
		super.enterElement(arg);
		final Element symbol = newElement(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitElement(ANTLRv4Parser.ElementContext arg) {
		super.exitElement(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterAtom(ANTLRv4Parser.AtomContext arg) {
		super.enterAtom(arg);
		final Atom symbol = newAtom(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitAtom(ANTLRv4Parser.AtomContext arg) {
		super.exitAtom(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterTerminal(ANTLRv4Parser.TerminalContext arg) {
		super.enterTerminal(arg);
		final Terminal symbol = newTerminal(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitTerminal(ANTLRv4Parser.TerminalContext arg) {
		super.exitTerminal(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext arg) {
		super.enterEbnfSuffix(arg);
		final EbnfSuffix symbol = newEbnfSuffix(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext arg) {
		super.exitEbnfSuffix(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleref(ANTLRv4Parser.RulerefContext arg) {
		super.enterRuleref(arg);
		final Ruleref symbol = newRuleref(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitRuleref(ANTLRv4Parser.RulerefContext arg) {
		super.exitRuleref(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterExceptionGroup(ANTLRv4Parser.ExceptionGroupContext arg) {
		super.enterExceptionGroup(arg);
		final ExceptionGroup symbol = newExceptionGroup(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitExceptionGroup(ANTLRv4Parser.ExceptionGroupContext arg) {
		super.exitExceptionGroup(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterEbnf(ANTLRv4Parser.EbnfContext arg) {
		super.enterEbnf(arg);
		final Ebnf symbol = newEbnf(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitEbnf(ANTLRv4Parser.EbnfContext arg) {
		super.exitEbnf(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterBlock(ANTLRv4Parser.BlockContext arg) {
		super.enterBlock(arg);
		final Block symbol = newBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitBlock(ANTLRv4Parser.BlockContext arg) {
		super.exitBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterAltList(ANTLRv4Parser.AltListContext arg) {
		super.enterAltList(arg);
		final AltList symbol = newAltList(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitAltList(ANTLRv4Parser.AltListContext arg) {
		super.exitAltList(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterBlockSuffix(ANTLRv4Parser.BlockSuffixContext arg) {
		super.enterBlockSuffix(arg);
		final BlockSuffix symbol = newBlockSuffix(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitBlockSuffix(ANTLRv4Parser.BlockSuffixContext arg) {
		super.exitBlockSuffix(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext arg) {
		super.enterDelegateGrammars(arg);
		final DelegateGrammars symbol = newDelegateGrammars(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext arg) {
		super.exitDelegateGrammars(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext arg) {
		super.enterDelegateGrammar(arg);
		final DelegateGrammar symbol = newDelegateGrammar(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext arg) {
		super.exitDelegateGrammar(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterTokensSpec(ANTLRv4Parser.TokensSpecContext arg) {
		super.enterTokensSpec(arg);
		final TokensSpec symbol = newTokensSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitTokensSpec(ANTLRv4Parser.TokensSpecContext arg) {
		super.exitTokensSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterIdList(ANTLRv4Parser.IdListContext arg) {
		super.enterIdList(arg);
		final IdList symbol = newIdList(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitIdList(ANTLRv4Parser.IdListContext arg) {
		super.exitIdList(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterChannelsSpec(ANTLRv4Parser.ChannelsSpecContext arg) {
		super.enterChannelsSpec(arg);
		final ChannelsSpec symbol = newChannelsSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitChannelsSpec(ANTLRv4Parser.ChannelsSpecContext arg) {
		super.exitChannelsSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
		super.enterLexerRuleSpec(arg);
		final LexerRuleSpec symbol = newLexerRuleSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
		super.exitLexerRuleSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext arg) {
		super.enterLexerRuleBlock(arg);
		final LexerRuleBlock symbol = newLexerRuleBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext arg) {
		super.exitLexerRuleBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerAltList(ANTLRv4Parser.LexerAltListContext arg) {
		super.enterLexerAltList(arg);
		final LexerAltList symbol = newLexerAltList(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerAltList(ANTLRv4Parser.LexerAltListContext arg) {
		super.exitLexerAltList(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerAlt(ANTLRv4Parser.LexerAltContext arg) {
		super.enterLexerAlt(arg);
		final LexerAlt symbol = newLexerAlt(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerAlt(ANTLRv4Parser.LexerAltContext arg) {
		super.exitLexerAlt(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerElements(ANTLRv4Parser.LexerElementsContext arg) {
		super.enterLexerElements(arg);
		final LexerElements symbol = newLexerElements(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerElements(ANTLRv4Parser.LexerElementsContext arg) {
		super.exitLexerElements(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerElement(ANTLRv4Parser.LexerElementContext arg) {
		super.enterLexerElement(arg);
		final LexerElement symbol = newLexerElement(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerElement(ANTLRv4Parser.LexerElementContext arg) {
		super.exitLexerElement(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerAtom(ANTLRv4Parser.LexerAtomContext arg) {
		super.enterLexerAtom(arg);
		final LexerAtom symbol = newLexerAtom(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerAtom(ANTLRv4Parser.LexerAtomContext arg) {
		super.exitLexerAtom(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerCommands(ANTLRv4Parser.LexerCommandsContext arg) {
		super.enterLexerCommands(arg);
		final LexerCommands symbol = newLexerCommands(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerCommands(ANTLRv4Parser.LexerCommandsContext arg) {
		super.exitLexerCommands(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerCommand(ANTLRv4Parser.LexerCommandContext arg) {
		super.enterLexerCommand(arg);
		final LexerCommand symbol = newLexerCommand(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerCommand(ANTLRv4Parser.LexerCommandContext arg) {
		super.exitLexerCommand(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerCommandName(ANTLRv4Parser.LexerCommandNameContext arg) {
		super.enterLexerCommandName(arg);
		final LexerCommandName symbol = newLexerCommandName(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerCommandName(ANTLRv4Parser.LexerCommandNameContext arg) {
		super.exitLexerCommandName(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext arg) {
		super.enterLexerCommandExpr(arg);
		final LexerCommandExpr symbol = newLexerCommandExpr(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext arg) {
		super.exitLexerCommandExpr(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterActionBlock(ANTLRv4Parser.ActionBlockContext arg) {
		super.enterActionBlock(arg);
		final ActionBlock symbol = newActionBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitActionBlock(ANTLRv4Parser.ActionBlockContext arg) {
		super.exitActionBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterModeSpec(ANTLRv4Parser.ModeSpecContext arg) {
		super.enterModeSpec(arg);
		final ModeSpec symbol = newModeSpec(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitModeSpec(ANTLRv4Parser.ModeSpecContext arg) {
		super.exitModeSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLexerBlock(ANTLRv4Parser.LexerBlockContext arg) {
		super.enterLexerBlock(arg);
		final LexerBlock symbol = newLexerBlock(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitLexerBlock(ANTLRv4Parser.LexerBlockContext arg) {
		super.exitLexerBlock(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterNotSet(ANTLRv4Parser.NotSetContext arg) {
		super.enterNotSet(arg);
		final NotSet symbol = newNotSet(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitNotSet(ANTLRv4Parser.NotSetContext arg) {
		super.exitNotSet(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterSetElement(ANTLRv4Parser.SetElementContext arg) {
		super.enterSetElement(arg);
		final SetElement symbol = newSetElement(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitSetElement(ANTLRv4Parser.SetElementContext arg) {
		super.exitSetElement(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterCharacterRange(ANTLRv4Parser.CharacterRangeContext arg) {
		super.enterCharacterRange(arg);
		final CharacterRange symbol = newCharacterRange(arg.getText(), arg.getStart().getText(), arg.getStop().getText());
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
	}

	@Override
	public void exitCharacterRange(ANTLRv4Parser.CharacterRangeContext arg) {
		super.exitCharacterRange(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}


	public GrammarSpec newGrammarSpec(String text, String startToken, String endToken) {
		return new GrammarSpec(text, startToken, endToken);
	}

	public class GrammarSpec extends Symbol {

		public GrammarSpec(String text, String startToken, String endToken) {
			super("GrammarSpec", startToken, text, startToken, endToken);
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
					final GrammarType child = newGrammarType("", "", "");
					addGrammarType(child);
					modelChangeSupport.firePropertyChange("GrammarType", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add Identifier") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Identifier child = newIdentifier("", "", "");
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add PrequelConstruct") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final PrequelConstruct child = newPrequelConstruct("", "", "");
					addPrequelConstruct(child);
					modelChangeSupport.firePropertyChange("PrequelConstruct", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add Rules") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Rules child = newRules("", "", "");
					addRules(child);
					modelChangeSupport.firePropertyChange("Rules", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add ModeSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ModeSpec child = newModeSpec("", "", "");
					addModeSpec(child);
					modelChangeSupport.firePropertyChange("ModeSpec", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add GrammarSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final GrammarSpec child = newGrammarSpec("", "", "");
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
	public GrammarType newGrammarType(String text, String startToken, String endToken) {
		return new GrammarType(text, startToken, endToken);
	}

	public class GrammarType extends Symbol {

		public GrammarType(String text, String startToken, String endToken) {
			super("GrammarType", startToken, text, startToken, endToken);
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
	public Identifier newIdentifier(String text, String startToken, String endToken) {
		return new Identifier(text, startToken, endToken);
	}

	public class Identifier extends Symbol {

		public Identifier(String text, String startToken, String endToken) {
			super("Identifier", startToken, text, startToken, endToken);
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
	public PrequelConstruct newPrequelConstruct(String text, String startToken, String endToken) {
		return new PrequelConstruct(text, startToken, endToken);
	}

	public class PrequelConstruct extends Symbol {

		public PrequelConstruct(String text, String startToken, String endToken) {
			super("PrequelConstruct", startToken, text, startToken, endToken);
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
					final OptionsSpec child = newOptionsSpec("", "", "");
					addOptionsSpec(child);
					modelChangeSupport.firePropertyChange("OptionsSpec", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add DelegateGrammars") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final DelegateGrammars child = newDelegateGrammars("", "", "");
					addDelegateGrammars(child);
					modelChangeSupport.firePropertyChange("DelegateGrammars", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add TokensSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final TokensSpec child = newTokensSpec("", "", "");
					addTokensSpec(child);
					modelChangeSupport.firePropertyChange("TokensSpec", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add ChannelsSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ChannelsSpec child = newChannelsSpec("", "", "");
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
	public OptionsSpec newOptionsSpec(String text, String startToken, String endToken) {
		return new OptionsSpec(text, startToken, endToken);
	}

	public class OptionsSpec extends Symbol {

		public OptionsSpec(String text, String startToken, String endToken) {
			super("OptionsSpec", startToken, text, startToken, endToken);
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
					final Option child = newOption("", "", "");
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
	public Option newOption(String text, String startToken, String endToken) {
		return new Option(text, startToken, endToken);
	}

	public class Option extends Symbol {

		public Option(String text, String startToken, String endToken) {
			super("Option", startToken, text, startToken, endToken);
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
					final Identifier child = newIdentifier("", "", "");
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add OptionValue") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final OptionValue child = newOptionValue("", "", "");
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
	public OptionValue newOptionValue(String text, String startToken, String endToken) {
		return new OptionValue(text, startToken, endToken);
	}

	public class OptionValue extends Symbol {

		public OptionValue(String text, String startToken, String endToken) {
			super("OptionValue", startToken, text, startToken, endToken);
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
					final Identifier child = newIdentifier("", "", "");
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
	public Rules newRules(String text, String startToken, String endToken) {
		return new Rules(text, startToken, endToken);
	}

	public class Rules extends Symbol {

		public Rules(String text, String startToken, String endToken) {
			super("Rules", startToken, text, startToken, endToken);
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
					final RuleSpec child = newRuleSpec("", "", "");
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
	public RuleSpec newRuleSpec(String text, String startToken, String endToken) {
		return new RuleSpec(text, startToken, endToken);
	}

	public class RuleSpec extends Symbol {

		public RuleSpec(String text, String startToken, String endToken) {
			super("RuleSpec", startToken, text, startToken, endToken);
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
					final ParserRuleSpec child = newParserRuleSpec("", "", "");
					addParserRuleSpec(child);
					modelChangeSupport.firePropertyChange("ParserRuleSpec", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerRuleSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerRuleSpec child = newLexerRuleSpec("", "", "");
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
	public ParserRuleSpec newParserRuleSpec(String text, String startToken, String endToken) {
		return new ParserRuleSpec(text, startToken, endToken);
	}

	public class ParserRuleSpec extends Symbol {

		public ParserRuleSpec(String text, String startToken, String endToken) {
			super("ParserRuleSpec", startToken, text, startToken, endToken);
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
					final RuleBlock child = newRuleBlock("", "", "");
					addRuleBlock(child);
					modelChangeSupport.firePropertyChange("RuleBlock", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add ExceptionGroup") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ExceptionGroup child = newExceptionGroup("", "", "");
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
	public RuleBlock newRuleBlock(String text, String startToken, String endToken) {
		return new RuleBlock(text, startToken, endToken);
	}

	public class RuleBlock extends Symbol {

		public RuleBlock(String text, String startToken, String endToken) {
			super("RuleBlock", startToken, text, startToken, endToken);
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
					final RuleAltList child = newRuleAltList("", "", "");
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
	public RuleAltList newRuleAltList(String text, String startToken, String endToken) {
		return new RuleAltList(text, startToken, endToken);
	}

	public class RuleAltList extends Symbol {

		public RuleAltList(String text, String startToken, String endToken) {
			super("RuleAltList", startToken, text, startToken, endToken);
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
					final LabeledAlt child = newLabeledAlt("", "", "");
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
	public LabeledAlt newLabeledAlt(String text, String startToken, String endToken) {
		return new LabeledAlt(text, startToken, endToken);
	}

	public class LabeledAlt extends Symbol {

		public LabeledAlt(String text, String startToken, String endToken) {
			super("LabeledAlt", startToken, text, startToken, endToken);
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
					final Alternative child = newAlternative("", "", "");
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
	public Alternative newAlternative(String text, String startToken, String endToken) {
		return new Alternative(text, startToken, endToken);
	}

	public class Alternative extends Symbol {

		public Alternative(String text, String startToken, String endToken) {
			super("Alternative", startToken, text, startToken, endToken);
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
					final Element child = newElement("", "", "");
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
	public Element newElement(String text, String startToken, String endToken) {
		return new Element(text, startToken, endToken);
	}

	public class Element extends Symbol {

		public Element(String text, String startToken, String endToken) {
			super("Element", startToken, text, startToken, endToken);
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
					final Atom child = newAtom("", "", "");
					addAtom(child);
					modelChangeSupport.firePropertyChange("Atom", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add EbnfSuffix") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final EbnfSuffix child = newEbnfSuffix("", "", "");
					addEbnfSuffix(child);
					modelChangeSupport.firePropertyChange("EbnfSuffix", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add Ebnf") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Ebnf child = newEbnf("", "", "");
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
	public Atom newAtom(String text, String startToken, String endToken) {
		return new Atom(text, startToken, endToken);
	}

	public class Atom extends Symbol {

		public Atom(String text, String startToken, String endToken) {
			super("Atom", startToken, text, startToken, endToken);
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
					final Terminal child = newTerminal("", "", "");
					addTerminal(child);
					modelChangeSupport.firePropertyChange("Terminal", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add Ruleref") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final Ruleref child = newRuleref("", "", "");
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
	public Terminal newTerminal(String text, String startToken, String endToken) {
		return new Terminal(text, startToken, endToken);
	}

	public class Terminal extends Symbol {

		public Terminal(String text, String startToken, String endToken) {
			super("Terminal", startToken, text, startToken, endToken);
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
	public EbnfSuffix newEbnfSuffix(String text, String startToken, String endToken) {
		return new EbnfSuffix(text, startToken, endToken);
	}

	public class EbnfSuffix extends Symbol {

		public EbnfSuffix(String text, String startToken, String endToken) {
			super("EbnfSuffix", startToken, text, startToken, endToken);
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
	public Ruleref newRuleref(String text, String startToken, String endToken) {
		return new Ruleref(text, startToken, endToken);
	}

	public class Ruleref extends Symbol {

		public Ruleref(String text, String startToken, String endToken) {
			super("Ruleref", startToken, text, startToken, endToken);
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
	public ExceptionGroup newExceptionGroup(String text, String startToken, String endToken) {
		return new ExceptionGroup(text, startToken, endToken);
	}

	public class ExceptionGroup extends Symbol {

		public ExceptionGroup(String text, String startToken, String endToken) {
			super("ExceptionGroup", startToken, text, startToken, endToken);
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
	public Ebnf newEbnf(String text, String startToken, String endToken) {
		return new Ebnf(text, startToken, endToken);
	}

	public class Ebnf extends Symbol {

		public Ebnf(String text, String startToken, String endToken) {
			super("Ebnf", startToken, text, startToken, endToken);
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
					final Block child = newBlock("", "", "");
					addBlock(child);
					modelChangeSupport.firePropertyChange("Block", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add BlockSuffix") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final BlockSuffix child = newBlockSuffix("", "", "");
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
	public Block newBlock(String text, String startToken, String endToken) {
		return new Block(text, startToken, endToken);
	}

	public class Block extends Symbol {

		public Block(String text, String startToken, String endToken) {
			super("Block", startToken, text, startToken, endToken);
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
					final AltList child = newAltList("", "", "");
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
	public AltList newAltList(String text, String startToken, String endToken) {
		return new AltList(text, startToken, endToken);
	}

	public class AltList extends Symbol {

		public AltList(String text, String startToken, String endToken) {
			super("AltList", startToken, text, startToken, endToken);
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
					final Alternative child = newAlternative("", "", "");
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
	public BlockSuffix newBlockSuffix(String text, String startToken, String endToken) {
		return new BlockSuffix(text, startToken, endToken);
	}

	public class BlockSuffix extends Symbol {

		public BlockSuffix(String text, String startToken, String endToken) {
			super("BlockSuffix", startToken, text, startToken, endToken);
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
					final EbnfSuffix child = newEbnfSuffix("", "", "");
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
	public DelegateGrammars newDelegateGrammars(String text, String startToken, String endToken) {
		return new DelegateGrammars(text, startToken, endToken);
	}

	public class DelegateGrammars extends Symbol {

		public DelegateGrammars(String text, String startToken, String endToken) {
			super("DelegateGrammars", startToken, text, startToken, endToken);
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
					final DelegateGrammar child = newDelegateGrammar("", "", "");
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
	public DelegateGrammar newDelegateGrammar(String text, String startToken, String endToken) {
		return new DelegateGrammar(text, startToken, endToken);
	}

	public class DelegateGrammar extends Symbol {

		public DelegateGrammar(String text, String startToken, String endToken) {
			super("DelegateGrammar", startToken, text, startToken, endToken);
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
					final Identifier child = newIdentifier("", "", "");
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
	public TokensSpec newTokensSpec(String text, String startToken, String endToken) {
		return new TokensSpec(text, startToken, endToken);
	}

	public class TokensSpec extends Symbol {

		public TokensSpec(String text, String startToken, String endToken) {
			super("TokensSpec", startToken, text, startToken, endToken);
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
					final IdList child = newIdList("", "", "");
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
	public IdList newIdList(String text, String startToken, String endToken) {
		return new IdList(text, startToken, endToken);
	}

	public class IdList extends Symbol {

		public IdList(String text, String startToken, String endToken) {
			super("IdList", startToken, text, startToken, endToken);
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
					final Identifier child = newIdentifier("", "", "");
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
	public ChannelsSpec newChannelsSpec(String text, String startToken, String endToken) {
		return new ChannelsSpec(text, startToken, endToken);
	}

	public class ChannelsSpec extends Symbol {

		public ChannelsSpec(String text, String startToken, String endToken) {
			super("ChannelsSpec", startToken, text, startToken, endToken);
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
					final IdList child = newIdList("", "", "");
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
	public LexerRuleSpec newLexerRuleSpec(String text, String startToken, String endToken) {
		return new LexerRuleSpec(text, startToken, endToken);
	}

	public class LexerRuleSpec extends Symbol {

		public LexerRuleSpec(String text, String startToken, String endToken) {
			super("LexerRuleSpec", startToken, text, startToken, endToken);
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
					final LexerRuleBlock child = newLexerRuleBlock("", "", "");
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
	public LexerRuleBlock newLexerRuleBlock(String text, String startToken, String endToken) {
		return new LexerRuleBlock(text, startToken, endToken);
	}

	public class LexerRuleBlock extends Symbol {

		public LexerRuleBlock(String text, String startToken, String endToken) {
			super("LexerRuleBlock", startToken, text, startToken, endToken);
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
					final LexerAltList child = newLexerAltList("", "", "");
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
	public LexerAltList newLexerAltList(String text, String startToken, String endToken) {
		return new LexerAltList(text, startToken, endToken);
	}

	public class LexerAltList extends Symbol {

		public LexerAltList(String text, String startToken, String endToken) {
			super("LexerAltList", startToken, text, startToken, endToken);
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
					final LexerAlt child = newLexerAlt("", "", "");
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
	public LexerAlt newLexerAlt(String text, String startToken, String endToken) {
		return new LexerAlt(text, startToken, endToken);
	}

	public class LexerAlt extends Symbol {

		public LexerAlt(String text, String startToken, String endToken) {
			super("LexerAlt", startToken, text, startToken, endToken);
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
					final LexerElements child = newLexerElements("", "", "");
					addLexerElements(child);
					modelChangeSupport.firePropertyChange("LexerElements", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerCommands") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerCommands child = newLexerCommands("", "", "");
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
	public LexerElements newLexerElements(String text, String startToken, String endToken) {
		return new LexerElements(text, startToken, endToken);
	}

	public class LexerElements extends Symbol {

		public LexerElements(String text, String startToken, String endToken) {
			super("LexerElements", startToken, text, startToken, endToken);
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
					final LexerElement child = newLexerElement("", "", "");
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
	public LexerElement newLexerElement(String text, String startToken, String endToken) {
		return new LexerElement(text, startToken, endToken);
	}

	public class LexerElement extends Symbol {

		public LexerElement(String text, String startToken, String endToken) {
			super("LexerElement", startToken, text, startToken, endToken);
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
					final LexerAtom child = newLexerAtom("", "", "");
					addLexerAtom(child);
					modelChangeSupport.firePropertyChange("LexerAtom", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add ActionBlock") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final ActionBlock child = newActionBlock("", "", "");
					addActionBlock(child);
					modelChangeSupport.firePropertyChange("ActionBlock", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add EbnfSuffix") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final EbnfSuffix child = newEbnfSuffix("", "", "");
					addEbnfSuffix(child);
					modelChangeSupport.firePropertyChange("EbnfSuffix", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerBlock") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerBlock child = newLexerBlock("", "", "");
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
	public LexerAtom newLexerAtom(String text, String startToken, String endToken) {
		return new LexerAtom(text, startToken, endToken);
	}

	public class LexerAtom extends Symbol {

		public LexerAtom(String text, String startToken, String endToken) {
			super("LexerAtom", startToken, text, startToken, endToken);
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
					final Terminal child = newTerminal("", "", "");
					addTerminal(child);
					modelChangeSupport.firePropertyChange("Terminal", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add NotSet") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final NotSet child = newNotSet("", "", "");
					addNotSet(child);
					modelChangeSupport.firePropertyChange("NotSet", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add CharacterRange") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final CharacterRange child = newCharacterRange("", "", "");
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
	public LexerCommands newLexerCommands(String text, String startToken, String endToken) {
		return new LexerCommands(text, startToken, endToken);
	}

	public class LexerCommands extends Symbol {

		public LexerCommands(String text, String startToken, String endToken) {
			super("LexerCommands", startToken, text, startToken, endToken);
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
					final LexerCommand child = newLexerCommand("", "", "");
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
	public LexerCommand newLexerCommand(String text, String startToken, String endToken) {
		return new LexerCommand(text, startToken, endToken);
	}

	public class LexerCommand extends Symbol {

		public LexerCommand(String text, String startToken, String endToken) {
			super("LexerCommand", startToken, text, startToken, endToken);
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
					final LexerCommandName child = newLexerCommandName("", "", "");
					addLexerCommandName(child);
					modelChangeSupport.firePropertyChange("LexerCommandName", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerCommandExpr") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerCommandExpr child = newLexerCommandExpr("", "", "");
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
	public LexerCommandName newLexerCommandName(String text, String startToken, String endToken) {
		return new LexerCommandName(text, startToken, endToken);
	}

	public class LexerCommandName extends Symbol {

		public LexerCommandName(String text, String startToken, String endToken) {
			super("LexerCommandName", startToken, text, startToken, endToken);
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
					final Identifier child = newIdentifier("", "", "");
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
	public LexerCommandExpr newLexerCommandExpr(String text, String startToken, String endToken) {
		return new LexerCommandExpr(text, startToken, endToken);
	}

	public class LexerCommandExpr extends Symbol {

		public LexerCommandExpr(String text, String startToken, String endToken) {
			super("LexerCommandExpr", startToken, text, startToken, endToken);
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
					final Identifier child = newIdentifier("", "", "");
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
	public ActionBlock newActionBlock(String text, String startToken, String endToken) {
		return new ActionBlock(text, startToken, endToken);
	}

	public class ActionBlock extends Symbol {

		public ActionBlock(String text, String startToken, String endToken) {
			super("ActionBlock", startToken, text, startToken, endToken);
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
	public ModeSpec newModeSpec(String text, String startToken, String endToken) {
		return new ModeSpec(text, startToken, endToken);
	}

	public class ModeSpec extends Symbol {

		public ModeSpec(String text, String startToken, String endToken) {
			super("ModeSpec", startToken, text, startToken, endToken);
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
					final Identifier child = newIdentifier("", "", "");
					addIdentifier(child);
					modelChangeSupport.firePropertyChange("Identifier", "Add", child);
				}
			});

			menu.add(new AbstractAction("Add LexerRuleSpec") {
				@Override
				public void actionPerformed(ActionEvent e) {
					final LexerRuleSpec child = newLexerRuleSpec("", "", "");
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
	public LexerBlock newLexerBlock(String text, String startToken, String endToken) {
		return new LexerBlock(text, startToken, endToken);
	}

	public class LexerBlock extends Symbol {

		public LexerBlock(String text, String startToken, String endToken) {
			super("LexerBlock", startToken, text, startToken, endToken);
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
					final LexerAltList child = newLexerAltList("", "", "");
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
	public NotSet newNotSet(String text, String startToken, String endToken) {
		return new NotSet(text, startToken, endToken);
	}

	public class NotSet extends Symbol {

		public NotSet(String text, String startToken, String endToken) {
			super("NotSet", startToken, text, startToken, endToken);
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
					final SetElement child = newSetElement("", "", "");
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
	public SetElement newSetElement(String text, String startToken, String endToken) {
		return new SetElement(text, startToken, endToken);
	}

	public class SetElement extends Symbol {

		public SetElement(String text, String startToken, String endToken) {
			super("SetElement", startToken, text, startToken, endToken);
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
	public CharacterRange newCharacterRange(String text, String startToken, String endToken) {
		return new CharacterRange(text, startToken, endToken);
	}

	public class CharacterRange extends Symbol {

		public CharacterRange(String text, String startToken, String endToken) {
			super("CharacterRange", startToken, text, startToken, endToken);
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