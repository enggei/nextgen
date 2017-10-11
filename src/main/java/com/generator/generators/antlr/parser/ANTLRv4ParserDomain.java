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
	public void enterLabeledLexerElement(ANTLRv4Parser.LabeledLexerElementContext arg) {
		super.enterLabeledLexerElement(arg);
		final LabeledLexerElement symbol = newLabeledLexerElement();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLabeledLexerElement(ANTLRv4Parser.LabeledLexerElementContext arg) {
		super.exitLabeledLexerElement(arg);
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
	public void enterLabeledElement(ANTLRv4Parser.LabeledElementContext arg) {
		super.enterLabeledElement(arg);
		final LabeledElement symbol = newLabeledElement();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLabeledElement(ANTLRv4Parser.LabeledElementContext arg) {
		super.exitLabeledElement(arg);
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
	public void enterBlockSet(ANTLRv4Parser.BlockSetContext arg) {
		super.enterBlockSet(arg);
		final BlockSet symbol = newBlockSet();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitBlockSet(ANTLRv4Parser.BlockSetContext arg) {
		super.exitBlockSet(arg);
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
	public void enterElementOptions(ANTLRv4Parser.ElementOptionsContext arg) {
		super.enterElementOptions(arg);
		final ElementOptions symbol = newElementOptions();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitElementOptions(ANTLRv4Parser.ElementOptionsContext arg) {
		super.exitElementOptions(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterElementOption(ANTLRv4Parser.ElementOptionContext arg) {
		super.enterElementOption(arg);
		final ElementOption symbol = newElementOption();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitElementOption(ANTLRv4Parser.ElementOptionContext arg) {
		super.exitElementOption(arg);
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
	public void enterAction(ANTLRv4Parser.ActionContext arg) {
		super.enterAction(arg);
		final Action symbol = newAction();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitAction(ANTLRv4Parser.ActionContext arg) {
		super.exitAction(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterActionScopeName(ANTLRv4Parser.ActionScopeNameContext arg) {
		super.enterActionScopeName(arg);
		final ActionScopeName symbol = newActionScopeName();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitActionScopeName(ANTLRv4Parser.ActionScopeNameContext arg) {
		super.exitActionScopeName(arg);
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
	public void enterArgActionBlock(ANTLRv4Parser.ArgActionBlockContext arg) {
		super.enterArgActionBlock(arg);
		final ArgActionBlock symbol = newArgActionBlock();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitArgActionBlock(ANTLRv4Parser.ArgActionBlockContext arg) {
		super.exitArgActionBlock(arg);
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
	public void enterExceptionHandler(ANTLRv4Parser.ExceptionHandlerContext arg) {
		super.enterExceptionHandler(arg);
		final ExceptionHandler symbol = newExceptionHandler();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitExceptionHandler(ANTLRv4Parser.ExceptionHandlerContext arg) {
		super.exitExceptionHandler(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterFinallyClause(ANTLRv4Parser.FinallyClauseContext arg) {
		super.enterFinallyClause(arg);
		final FinallyClause symbol = newFinallyClause();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitFinallyClause(ANTLRv4Parser.FinallyClauseContext arg) {
		super.exitFinallyClause(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRulePrequel(ANTLRv4Parser.RulePrequelContext arg) {
		super.enterRulePrequel(arg);
		final RulePrequel symbol = newRulePrequel();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRulePrequel(ANTLRv4Parser.RulePrequelContext arg) {
		super.exitRulePrequel(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleReturns(ANTLRv4Parser.RuleReturnsContext arg) {
		super.enterRuleReturns(arg);
		final RuleReturns symbol = newRuleReturns();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRuleReturns(ANTLRv4Parser.RuleReturnsContext arg) {
		super.exitRuleReturns(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterThrowsSpec(ANTLRv4Parser.ThrowsSpecContext arg) {
		super.enterThrowsSpec(arg);
		final ThrowsSpec symbol = newThrowsSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitThrowsSpec(ANTLRv4Parser.ThrowsSpecContext arg) {
		super.exitThrowsSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterLocalsSpec(ANTLRv4Parser.LocalsSpecContext arg) {
		super.enterLocalsSpec(arg);
		final LocalsSpec symbol = newLocalsSpec();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitLocalsSpec(ANTLRv4Parser.LocalsSpecContext arg) {
		super.exitLocalsSpec(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleAction(ANTLRv4Parser.RuleActionContext arg) {
		super.enterRuleAction(arg);
		final RuleAction symbol = newRuleAction();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRuleAction(ANTLRv4Parser.RuleActionContext arg) {
		super.exitRuleAction(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleModifiers(ANTLRv4Parser.RuleModifiersContext arg) {
		super.enterRuleModifiers(arg);
		final RuleModifiers symbol = newRuleModifiers();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRuleModifiers(ANTLRv4Parser.RuleModifiersContext arg) {
		super.exitRuleModifiers(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
	}

	@Override
	public void enterRuleModifier(ANTLRv4Parser.RuleModifierContext arg) {
		super.enterRuleModifier(arg);
		final RuleModifier symbol = newRuleModifier();
      if (!symbolStack.isEmpty()) symbolStack.peek().addChild(symbol);
      symbolStack.push(symbol);
		symbol.name = arg.getStart().getText();
	}

	@Override
	public void exitRuleModifier(ANTLRv4Parser.RuleModifierContext arg) {
		super.exitRuleModifier(arg);
		if (symbolStack.size() > 1) symbolStack.pop();
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
	public LabeledLexerElement newLabeledLexerElement() {
		return new LabeledLexerElement();
	}

	public LabeledLexerElement newLabeledLexerElement(String name) {
		return new LabeledLexerElement(name);
	}

	public class LabeledLexerElement extends Symbol {

		public LabeledLexerElement() {
			this.type = "LabeledLexerElement";
		}

		public LabeledLexerElement(String name) {
			super(name);
			this.type = "LabeledLexerElement";
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
	public LabeledElement newLabeledElement() {
		return new LabeledElement();
	}

	public LabeledElement newLabeledElement(String name) {
		return new LabeledElement(name);
	}

	public class LabeledElement extends Symbol {

		public LabeledElement() {
			this.type = "LabeledElement";
		}

		public LabeledElement(String name) {
			super(name);
			this.type = "LabeledElement";
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
	public BlockSet newBlockSet() {
		return new BlockSet();
	}

	public BlockSet newBlockSet(String name) {
		return new BlockSet(name);
	}

	public class BlockSet extends Symbol {

		public BlockSet() {
			this.type = "BlockSet";
		}

		public BlockSet(String name) {
			super(name);
			this.type = "BlockSet";
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
	public ElementOptions newElementOptions() {
		return new ElementOptions();
	}

	public ElementOptions newElementOptions(String name) {
		return new ElementOptions(name);
	}

	public class ElementOptions extends Symbol {

		public ElementOptions() {
			this.type = "ElementOptions";
		}

		public ElementOptions(String name) {
			super(name);
			this.type = "ElementOptions";
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
	public ElementOption newElementOption() {
		return new ElementOption();
	}

	public ElementOption newElementOption(String name) {
		return new ElementOption(name);
	}

	public class ElementOption extends Symbol {

		public ElementOption() {
			this.type = "ElementOption";
		}

		public ElementOption(String name) {
			super(name);
			this.type = "ElementOption";
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
	public Action newAction() {
		return new Action();
	}

	public Action newAction(String name) {
		return new Action(name);
	}

	public class Action extends Symbol {

		public Action() {
			this.type = "Action";
		}

		public Action(String name) {
			super(name);
			this.type = "Action";
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
	public ActionScopeName newActionScopeName() {
		return new ActionScopeName();
	}

	public ActionScopeName newActionScopeName(String name) {
		return new ActionScopeName(name);
	}

	public class ActionScopeName extends Symbol {

		public ActionScopeName() {
			this.type = "ActionScopeName";
		}

		public ActionScopeName(String name) {
			super(name);
			this.type = "ActionScopeName";
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
	public ArgActionBlock newArgActionBlock() {
		return new ArgActionBlock();
	}

	public ArgActionBlock newArgActionBlock(String name) {
		return new ArgActionBlock(name);
	}

	public class ArgActionBlock extends Symbol {

		public ArgActionBlock() {
			this.type = "ArgActionBlock";
		}

		public ArgActionBlock(String name) {
			super(name);
			this.type = "ArgActionBlock";
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
	public ExceptionHandler newExceptionHandler() {
		return new ExceptionHandler();
	}

	public ExceptionHandler newExceptionHandler(String name) {
		return new ExceptionHandler(name);
	}

	public class ExceptionHandler extends Symbol {

		public ExceptionHandler() {
			this.type = "ExceptionHandler";
		}

		public ExceptionHandler(String name) {
			super(name);
			this.type = "ExceptionHandler";
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
	public FinallyClause newFinallyClause() {
		return new FinallyClause();
	}

	public FinallyClause newFinallyClause(String name) {
		return new FinallyClause(name);
	}

	public class FinallyClause extends Symbol {

		public FinallyClause() {
			this.type = "FinallyClause";
		}

		public FinallyClause(String name) {
			super(name);
			this.type = "FinallyClause";
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
	public RulePrequel newRulePrequel() {
		return new RulePrequel();
	}

	public RulePrequel newRulePrequel(String name) {
		return new RulePrequel(name);
	}

	public class RulePrequel extends Symbol {

		public RulePrequel() {
			this.type = "RulePrequel";
		}

		public RulePrequel(String name) {
			super(name);
			this.type = "RulePrequel";
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
	public RuleReturns newRuleReturns() {
		return new RuleReturns();
	}

	public RuleReturns newRuleReturns(String name) {
		return new RuleReturns(name);
	}

	public class RuleReturns extends Symbol {

		public RuleReturns() {
			this.type = "RuleReturns";
		}

		public RuleReturns(String name) {
			super(name);
			this.type = "RuleReturns";
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
	public ThrowsSpec newThrowsSpec() {
		return new ThrowsSpec();
	}

	public ThrowsSpec newThrowsSpec(String name) {
		return new ThrowsSpec(name);
	}

	public class ThrowsSpec extends Symbol {

		public ThrowsSpec() {
			this.type = "ThrowsSpec";
		}

		public ThrowsSpec(String name) {
			super(name);
			this.type = "ThrowsSpec";
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
	public LocalsSpec newLocalsSpec() {
		return new LocalsSpec();
	}

	public LocalsSpec newLocalsSpec(String name) {
		return new LocalsSpec(name);
	}

	public class LocalsSpec extends Symbol {

		public LocalsSpec() {
			this.type = "LocalsSpec";
		}

		public LocalsSpec(String name) {
			super(name);
			this.type = "LocalsSpec";
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
	public RuleAction newRuleAction() {
		return new RuleAction();
	}

	public RuleAction newRuleAction(String name) {
		return new RuleAction(name);
	}

	public class RuleAction extends Symbol {

		public RuleAction() {
			this.type = "RuleAction";
		}

		public RuleAction(String name) {
			super(name);
			this.type = "RuleAction";
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
	public RuleModifiers newRuleModifiers() {
		return new RuleModifiers();
	}

	public RuleModifiers newRuleModifiers(String name) {
		return new RuleModifiers(name);
	}

	public class RuleModifiers extends Symbol {

		public RuleModifiers() {
			this.type = "RuleModifiers";
		}

		public RuleModifiers(String name) {
			super(name);
			this.type = "RuleModifiers";
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
	public RuleModifier newRuleModifier() {
		return new RuleModifier();
	}

	public RuleModifier newRuleModifier(String name) {
		return new RuleModifier(name);
	}

	public class RuleModifier extends Symbol {

		public RuleModifier() {
			this.type = "RuleModifier";
		}

		public RuleModifier(String name) {
			super(name);
			this.type = "RuleModifier";
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