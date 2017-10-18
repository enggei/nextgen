package com.generator.generators.antlr.bnf;

import com.generator.generators.antlr.AntlrGroup;
import com.generator.generators.antlr.parser.ANTLRv4ParserDomain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeSupport;
import java.util.Stack;

public class ANTLRv4ParserRenderer extends ANTLRv4ParserDomain.ANTLRv4Visitor { 

	protected final Stack<AntlrGrammarSymbol> symbolStack = new Stack<>();

		@Override
		public void visitGrammarSpec(ANTLRv4ParserDomain.GrammarSpec node) {
			final GrammarSpecSymbol symbol = newGrammarSpecSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitGrammarSpec(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitGrammarType(ANTLRv4ParserDomain.GrammarType node) {
			final GrammarTypeSymbol symbol = newGrammarTypeSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitGrammarType(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitIdentifier(ANTLRv4ParserDomain.Identifier node) {
			final IdentifierSymbol symbol = newIdentifierSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitIdentifier(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitPrequelConstruct(ANTLRv4ParserDomain.PrequelConstruct node) {
			final PrequelConstructSymbol symbol = newPrequelConstructSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitPrequelConstruct(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitOptionsSpec(ANTLRv4ParserDomain.OptionsSpec node) {
			final OptionsSpecSymbol symbol = newOptionsSpecSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitOptionsSpec(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitOption(ANTLRv4ParserDomain.Option node) {
			final OptionSymbol symbol = newOptionSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitOption(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitOptionValue(ANTLRv4ParserDomain.OptionValue node) {
			final OptionValueSymbol symbol = newOptionValueSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitOptionValue(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitRules(ANTLRv4ParserDomain.Rules node) {
			final RulesSymbol symbol = newRulesSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitRules(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitRuleSpec(ANTLRv4ParserDomain.RuleSpec node) {
			final RuleSpecSymbol symbol = newRuleSpecSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitRuleSpec(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitParserRuleSpec(ANTLRv4ParserDomain.ParserRuleSpec node) {
			final ParserRuleSpecSymbol symbol = newParserRuleSpecSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitParserRuleSpec(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitRuleBlock(ANTLRv4ParserDomain.RuleBlock node) {
			final RuleBlockSymbol symbol = newRuleBlockSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitRuleBlock(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitRuleAltList(ANTLRv4ParserDomain.RuleAltList node) {
			final RuleAltListSymbol symbol = newRuleAltListSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitRuleAltList(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLabeledAlt(ANTLRv4ParserDomain.LabeledAlt node) {
			final LabeledAltSymbol symbol = newLabeledAltSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLabeledAlt(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitAlternative(ANTLRv4ParserDomain.Alternative node) {
			final AlternativeSymbol symbol = newAlternativeSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitAlternative(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitElement(ANTLRv4ParserDomain.Element node) {
			final ElementSymbol symbol = newElementSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitElement(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitAtom(ANTLRv4ParserDomain.Atom node) {
			final AtomSymbol symbol = newAtomSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitAtom(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitTerminal(ANTLRv4ParserDomain.Terminal node) {
			final TerminalSymbol symbol = newTerminalSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitTerminal(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitEbnfSuffix(ANTLRv4ParserDomain.EbnfSuffix node) {
			final EbnfSuffixSymbol symbol = newEbnfSuffixSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitEbnfSuffix(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitRuleref(ANTLRv4ParserDomain.Ruleref node) {
			final RulerefSymbol symbol = newRulerefSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitRuleref(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitExceptionGroup(ANTLRv4ParserDomain.ExceptionGroup node) {
			final ExceptionGroupSymbol symbol = newExceptionGroupSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitExceptionGroup(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitEbnf(ANTLRv4ParserDomain.Ebnf node) {
			final EbnfSymbol symbol = newEbnfSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitEbnf(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitBlock(ANTLRv4ParserDomain.Block node) {
			final BlockSymbol symbol = newBlockSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitBlock(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitAltList(ANTLRv4ParserDomain.AltList node) {
			final AltListSymbol symbol = newAltListSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitAltList(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitBlockSuffix(ANTLRv4ParserDomain.BlockSuffix node) {
			final BlockSuffixSymbol symbol = newBlockSuffixSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitBlockSuffix(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitDelegateGrammars(ANTLRv4ParserDomain.DelegateGrammars node) {
			final DelegateGrammarsSymbol symbol = newDelegateGrammarsSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitDelegateGrammars(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitDelegateGrammar(ANTLRv4ParserDomain.DelegateGrammar node) {
			final DelegateGrammarSymbol symbol = newDelegateGrammarSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitDelegateGrammar(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitTokensSpec(ANTLRv4ParserDomain.TokensSpec node) {
			final TokensSpecSymbol symbol = newTokensSpecSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitTokensSpec(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitIdList(ANTLRv4ParserDomain.IdList node) {
			final IdListSymbol symbol = newIdListSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitIdList(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitChannelsSpec(ANTLRv4ParserDomain.ChannelsSpec node) {
			final ChannelsSpecSymbol symbol = newChannelsSpecSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitChannelsSpec(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerRuleSpec(ANTLRv4ParserDomain.LexerRuleSpec node) {
			final LexerRuleSpecSymbol symbol = newLexerRuleSpecSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerRuleSpec(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerRuleBlock(ANTLRv4ParserDomain.LexerRuleBlock node) {
			final LexerRuleBlockSymbol symbol = newLexerRuleBlockSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerRuleBlock(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerAltList(ANTLRv4ParserDomain.LexerAltList node) {
			final LexerAltListSymbol symbol = newLexerAltListSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerAltList(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerAlt(ANTLRv4ParserDomain.LexerAlt node) {
			final LexerAltSymbol symbol = newLexerAltSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerAlt(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerElements(ANTLRv4ParserDomain.LexerElements node) {
			final LexerElementsSymbol symbol = newLexerElementsSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerElements(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerElement(ANTLRv4ParserDomain.LexerElement node) {
			final LexerElementSymbol symbol = newLexerElementSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerElement(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerAtom(ANTLRv4ParserDomain.LexerAtom node) {
			final LexerAtomSymbol symbol = newLexerAtomSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerAtom(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerCommands(ANTLRv4ParserDomain.LexerCommands node) {
			final LexerCommandsSymbol symbol = newLexerCommandsSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerCommands(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerCommand(ANTLRv4ParserDomain.LexerCommand node) {
			final LexerCommandSymbol symbol = newLexerCommandSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerCommand(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerCommandName(ANTLRv4ParserDomain.LexerCommandName node) {
			final LexerCommandNameSymbol symbol = newLexerCommandNameSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerCommandName(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerCommandExpr(ANTLRv4ParserDomain.LexerCommandExpr node) {
			final LexerCommandExprSymbol symbol = newLexerCommandExprSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerCommandExpr(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitActionBlock(ANTLRv4ParserDomain.ActionBlock node) {
			final ActionBlockSymbol symbol = newActionBlockSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitActionBlock(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitModeSpec(ANTLRv4ParserDomain.ModeSpec node) {
			final ModeSpecSymbol symbol = newModeSpecSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitModeSpec(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitLexerBlock(ANTLRv4ParserDomain.LexerBlock node) {
			final LexerBlockSymbol symbol = newLexerBlockSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitLexerBlock(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitNotSet(ANTLRv4ParserDomain.NotSet node) {
			final NotSetSymbol symbol = newNotSetSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitNotSet(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitSetElement(ANTLRv4ParserDomain.SetElement node) {
			final SetElementSymbol symbol = newSetElementSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitSetElement(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}

		@Override
		public void visitCharacterRange(ANTLRv4ParserDomain.CharacterRange node) {
			final CharacterRangeSymbol symbol = newCharacterRangeSymbol(node);
			if (symbolStack.isEmpty()) symbolStack.peek().children.add(symbol);
			symbolStack.push(symbol);
			super.visitCharacterRange(node);
			if (symbolStack.size() > 1) symbolStack.pop();
		}


	public GrammarSpecSymbol newGrammarSpecSymbol(ANTLRv4ParserDomain.GrammarSpec node) {
		return new GrammarSpecSymbol(node);
	}

	public class GrammarSpecSymbol extends AntlrGrammarSymbol {

		public GrammarSpecSymbol(ANTLRv4ParserDomain.GrammarSpec node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addGrammarType(GrammarTypeSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setGrammarType(GrammarTypeSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addPrequelConstruct(PrequelConstructSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setPrequelConstruct(PrequelConstructSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addRules(RulesSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setRules(RulesSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addModeSpec(ModeSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setModeSpec(ModeSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addGrammarSpec(GrammarSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setGrammarSpec(GrammarSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public GrammarTypeSymbol newGrammarTypeSymbol(ANTLRv4ParserDomain.GrammarType node) {
		return new GrammarTypeSymbol(node);
	}

	public class GrammarTypeSymbol extends AntlrGrammarSymbol {

		public GrammarTypeSymbol(ANTLRv4ParserDomain.GrammarType node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public IdentifierSymbol newIdentifierSymbol(ANTLRv4ParserDomain.Identifier node) {
		return new IdentifierSymbol(node);
	}

	public class IdentifierSymbol extends AntlrGrammarSymbol {

		public IdentifierSymbol(ANTLRv4ParserDomain.Identifier node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public PrequelConstructSymbol newPrequelConstructSymbol(ANTLRv4ParserDomain.PrequelConstruct node) {
		return new PrequelConstructSymbol(node);
	}

	public class PrequelConstructSymbol extends AntlrGrammarSymbol {

		public PrequelConstructSymbol(ANTLRv4ParserDomain.PrequelConstruct node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addOptionsSpec(OptionsSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setOptionsSpec(OptionsSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addDelegateGrammars(DelegateGrammarsSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setDelegateGrammars(DelegateGrammarsSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addTokensSpec(TokensSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setTokensSpec(TokensSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addChannelsSpec(ChannelsSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setChannelsSpec(ChannelsSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public OptionsSpecSymbol newOptionsSpecSymbol(ANTLRv4ParserDomain.OptionsSpec node) {
		return new OptionsSpecSymbol(node);
	}

	public class OptionsSpecSymbol extends AntlrGrammarSymbol {

		public OptionsSpecSymbol(ANTLRv4ParserDomain.OptionsSpec node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addOption(OptionSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setOption(OptionSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public OptionSymbol newOptionSymbol(ANTLRv4ParserDomain.Option node) {
		return new OptionSymbol(node);
	}

	public class OptionSymbol extends AntlrGrammarSymbol {

		public OptionSymbol(ANTLRv4ParserDomain.Option node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addOptionValue(OptionValueSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setOptionValue(OptionValueSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public OptionValueSymbol newOptionValueSymbol(ANTLRv4ParserDomain.OptionValue node) {
		return new OptionValueSymbol(node);
	}

	public class OptionValueSymbol extends AntlrGrammarSymbol {

		public OptionValueSymbol(ANTLRv4ParserDomain.OptionValue node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public RulesSymbol newRulesSymbol(ANTLRv4ParserDomain.Rules node) {
		return new RulesSymbol(node);
	}

	public class RulesSymbol extends AntlrGrammarSymbol {

		public RulesSymbol(ANTLRv4ParserDomain.Rules node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addRuleSpec(RuleSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setRuleSpec(RuleSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public RuleSpecSymbol newRuleSpecSymbol(ANTLRv4ParserDomain.RuleSpec node) {
		return new RuleSpecSymbol(node);
	}

	public class RuleSpecSymbol extends AntlrGrammarSymbol {

		public RuleSpecSymbol(ANTLRv4ParserDomain.RuleSpec node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addParserRuleSpec(ParserRuleSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setParserRuleSpec(ParserRuleSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addLexerRuleSpec(LexerRuleSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerRuleSpec(LexerRuleSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public ParserRuleSpecSymbol newParserRuleSpecSymbol(ANTLRv4ParserDomain.ParserRuleSpec node) {
		return new ParserRuleSpecSymbol(node);
	}

	public class ParserRuleSpecSymbol extends AntlrGrammarSymbol {

		public ParserRuleSpecSymbol(ANTLRv4ParserDomain.ParserRuleSpec node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addRuleBlock(RuleBlockSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setRuleBlock(RuleBlockSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addExceptionGroup(ExceptionGroupSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setExceptionGroup(ExceptionGroupSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public RuleBlockSymbol newRuleBlockSymbol(ANTLRv4ParserDomain.RuleBlock node) {
		return new RuleBlockSymbol(node);
	}

	public class RuleBlockSymbol extends AntlrGrammarSymbol {

		public RuleBlockSymbol(ANTLRv4ParserDomain.RuleBlock node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addRuleAltList(RuleAltListSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setRuleAltList(RuleAltListSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public RuleAltListSymbol newRuleAltListSymbol(ANTLRv4ParserDomain.RuleAltList node) {
		return new RuleAltListSymbol(node);
	}

	public class RuleAltListSymbol extends AntlrGrammarSymbol {

		public RuleAltListSymbol(ANTLRv4ParserDomain.RuleAltList node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLabeledAlt(LabeledAltSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLabeledAlt(LabeledAltSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LabeledAltSymbol newLabeledAltSymbol(ANTLRv4ParserDomain.LabeledAlt node) {
		return new LabeledAltSymbol(node);
	}

	public class LabeledAltSymbol extends AntlrGrammarSymbol {

		public LabeledAltSymbol(ANTLRv4ParserDomain.LabeledAlt node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addAlternative(AlternativeSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setAlternative(AlternativeSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public AlternativeSymbol newAlternativeSymbol(ANTLRv4ParserDomain.Alternative node) {
		return new AlternativeSymbol(node);
	}

	public class AlternativeSymbol extends AntlrGrammarSymbol {

		public AlternativeSymbol(ANTLRv4ParserDomain.Alternative node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addElement(ElementSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setElement(ElementSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public ElementSymbol newElementSymbol(ANTLRv4ParserDomain.Element node) {
		return new ElementSymbol(node);
	}

	public class ElementSymbol extends AntlrGrammarSymbol {

		public ElementSymbol(ANTLRv4ParserDomain.Element node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addAtom(AtomSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setAtom(AtomSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addEbnfSuffix(EbnfSuffixSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setEbnfSuffix(EbnfSuffixSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addEbnf(EbnfSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setEbnf(EbnfSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public AtomSymbol newAtomSymbol(ANTLRv4ParserDomain.Atom node) {
		return new AtomSymbol(node);
	}

	public class AtomSymbol extends AntlrGrammarSymbol {

		public AtomSymbol(ANTLRv4ParserDomain.Atom node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addTerminal(TerminalSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setTerminal(TerminalSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addRuleref(RulerefSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setRuleref(RulerefSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public TerminalSymbol newTerminalSymbol(ANTLRv4ParserDomain.Terminal node) {
		return new TerminalSymbol(node);
	}

	public class TerminalSymbol extends AntlrGrammarSymbol {

		public TerminalSymbol(ANTLRv4ParserDomain.Terminal node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public EbnfSuffixSymbol newEbnfSuffixSymbol(ANTLRv4ParserDomain.EbnfSuffix node) {
		return new EbnfSuffixSymbol(node);
	}

	public class EbnfSuffixSymbol extends AntlrGrammarSymbol {

		public EbnfSuffixSymbol(ANTLRv4ParserDomain.EbnfSuffix node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public RulerefSymbol newRulerefSymbol(ANTLRv4ParserDomain.Ruleref node) {
		return new RulerefSymbol(node);
	}

	public class RulerefSymbol extends AntlrGrammarSymbol {

		public RulerefSymbol(ANTLRv4ParserDomain.Ruleref node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public ExceptionGroupSymbol newExceptionGroupSymbol(ANTLRv4ParserDomain.ExceptionGroup node) {
		return new ExceptionGroupSymbol(node);
	}

	public class ExceptionGroupSymbol extends AntlrGrammarSymbol {

		public ExceptionGroupSymbol(ANTLRv4ParserDomain.ExceptionGroup node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public EbnfSymbol newEbnfSymbol(ANTLRv4ParserDomain.Ebnf node) {
		return new EbnfSymbol(node);
	}

	public class EbnfSymbol extends AntlrGrammarSymbol {

		public EbnfSymbol(ANTLRv4ParserDomain.Ebnf node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addBlock(BlockSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setBlock(BlockSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addBlockSuffix(BlockSuffixSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setBlockSuffix(BlockSuffixSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public BlockSymbol newBlockSymbol(ANTLRv4ParserDomain.Block node) {
		return new BlockSymbol(node);
	}

	public class BlockSymbol extends AntlrGrammarSymbol {

		public BlockSymbol(ANTLRv4ParserDomain.Block node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addAltList(AltListSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setAltList(AltListSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public AltListSymbol newAltListSymbol(ANTLRv4ParserDomain.AltList node) {
		return new AltListSymbol(node);
	}

	public class AltListSymbol extends AntlrGrammarSymbol {

		public AltListSymbol(ANTLRv4ParserDomain.AltList node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addAlternative(AlternativeSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setAlternative(AlternativeSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public BlockSuffixSymbol newBlockSuffixSymbol(ANTLRv4ParserDomain.BlockSuffix node) {
		return new BlockSuffixSymbol(node);
	}

	public class BlockSuffixSymbol extends AntlrGrammarSymbol {

		public BlockSuffixSymbol(ANTLRv4ParserDomain.BlockSuffix node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addEbnfSuffix(EbnfSuffixSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setEbnfSuffix(EbnfSuffixSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public DelegateGrammarsSymbol newDelegateGrammarsSymbol(ANTLRv4ParserDomain.DelegateGrammars node) {
		return new DelegateGrammarsSymbol(node);
	}

	public class DelegateGrammarsSymbol extends AntlrGrammarSymbol {

		public DelegateGrammarsSymbol(ANTLRv4ParserDomain.DelegateGrammars node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addDelegateGrammar(DelegateGrammarSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setDelegateGrammar(DelegateGrammarSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public DelegateGrammarSymbol newDelegateGrammarSymbol(ANTLRv4ParserDomain.DelegateGrammar node) {
		return new DelegateGrammarSymbol(node);
	}

	public class DelegateGrammarSymbol extends AntlrGrammarSymbol {

		public DelegateGrammarSymbol(ANTLRv4ParserDomain.DelegateGrammar node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public TokensSpecSymbol newTokensSpecSymbol(ANTLRv4ParserDomain.TokensSpec node) {
		return new TokensSpecSymbol(node);
	}

	public class TokensSpecSymbol extends AntlrGrammarSymbol {

		public TokensSpecSymbol(ANTLRv4ParserDomain.TokensSpec node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdList(IdListSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdList(IdListSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public IdListSymbol newIdListSymbol(ANTLRv4ParserDomain.IdList node) {
		return new IdListSymbol(node);
	}

	public class IdListSymbol extends AntlrGrammarSymbol {

		public IdListSymbol(ANTLRv4ParserDomain.IdList node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public ChannelsSpecSymbol newChannelsSpecSymbol(ANTLRv4ParserDomain.ChannelsSpec node) {
		return new ChannelsSpecSymbol(node);
	}

	public class ChannelsSpecSymbol extends AntlrGrammarSymbol {

		public ChannelsSpecSymbol(ANTLRv4ParserDomain.ChannelsSpec node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdList(IdListSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdList(IdListSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerRuleSpecSymbol newLexerRuleSpecSymbol(ANTLRv4ParserDomain.LexerRuleSpec node) {
		return new LexerRuleSpecSymbol(node);
	}

	public class LexerRuleSpecSymbol extends AntlrGrammarSymbol {

		public LexerRuleSpecSymbol(ANTLRv4ParserDomain.LexerRuleSpec node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerRuleBlock(LexerRuleBlockSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerRuleBlock(LexerRuleBlockSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerRuleBlockSymbol newLexerRuleBlockSymbol(ANTLRv4ParserDomain.LexerRuleBlock node) {
		return new LexerRuleBlockSymbol(node);
	}

	public class LexerRuleBlockSymbol extends AntlrGrammarSymbol {

		public LexerRuleBlockSymbol(ANTLRv4ParserDomain.LexerRuleBlock node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerAltList(LexerAltListSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerAltList(LexerAltListSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerAltListSymbol newLexerAltListSymbol(ANTLRv4ParserDomain.LexerAltList node) {
		return new LexerAltListSymbol(node);
	}

	public class LexerAltListSymbol extends AntlrGrammarSymbol {

		public LexerAltListSymbol(ANTLRv4ParserDomain.LexerAltList node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerAlt(LexerAltSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerAlt(LexerAltSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerAltSymbol newLexerAltSymbol(ANTLRv4ParserDomain.LexerAlt node) {
		return new LexerAltSymbol(node);
	}

	public class LexerAltSymbol extends AntlrGrammarSymbol {

		public LexerAltSymbol(ANTLRv4ParserDomain.LexerAlt node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerElements(LexerElementsSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerElements(LexerElementsSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addLexerCommands(LexerCommandsSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerCommands(LexerCommandsSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerElementsSymbol newLexerElementsSymbol(ANTLRv4ParserDomain.LexerElements node) {
		return new LexerElementsSymbol(node);
	}

	public class LexerElementsSymbol extends AntlrGrammarSymbol {

		public LexerElementsSymbol(ANTLRv4ParserDomain.LexerElements node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerElement(LexerElementSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerElement(LexerElementSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerElementSymbol newLexerElementSymbol(ANTLRv4ParserDomain.LexerElement node) {
		return new LexerElementSymbol(node);
	}

	public class LexerElementSymbol extends AntlrGrammarSymbol {

		public LexerElementSymbol(ANTLRv4ParserDomain.LexerElement node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerAtom(LexerAtomSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerAtom(LexerAtomSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addActionBlock(ActionBlockSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setActionBlock(ActionBlockSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addEbnfSuffix(EbnfSuffixSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setEbnfSuffix(EbnfSuffixSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addLexerBlock(LexerBlockSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerBlock(LexerBlockSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerAtomSymbol newLexerAtomSymbol(ANTLRv4ParserDomain.LexerAtom node) {
		return new LexerAtomSymbol(node);
	}

	public class LexerAtomSymbol extends AntlrGrammarSymbol {

		public LexerAtomSymbol(ANTLRv4ParserDomain.LexerAtom node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addTerminal(TerminalSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setTerminal(TerminalSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addNotSet(NotSetSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setNotSet(NotSetSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addCharacterRange(CharacterRangeSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setCharacterRange(CharacterRangeSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerCommandsSymbol newLexerCommandsSymbol(ANTLRv4ParserDomain.LexerCommands node) {
		return new LexerCommandsSymbol(node);
	}

	public class LexerCommandsSymbol extends AntlrGrammarSymbol {

		public LexerCommandsSymbol(ANTLRv4ParserDomain.LexerCommands node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerCommand(LexerCommandSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerCommand(LexerCommandSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerCommandSymbol newLexerCommandSymbol(ANTLRv4ParserDomain.LexerCommand node) {
		return new LexerCommandSymbol(node);
	}

	public class LexerCommandSymbol extends AntlrGrammarSymbol {

		public LexerCommandSymbol(ANTLRv4ParserDomain.LexerCommand node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerCommandName(LexerCommandNameSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerCommandName(LexerCommandNameSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addLexerCommandExpr(LexerCommandExprSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerCommandExpr(LexerCommandExprSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerCommandNameSymbol newLexerCommandNameSymbol(ANTLRv4ParserDomain.LexerCommandName node) {
		return new LexerCommandNameSymbol(node);
	}

	public class LexerCommandNameSymbol extends AntlrGrammarSymbol {

		public LexerCommandNameSymbol(ANTLRv4ParserDomain.LexerCommandName node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerCommandExprSymbol newLexerCommandExprSymbol(ANTLRv4ParserDomain.LexerCommandExpr node) {
		return new LexerCommandExprSymbol(node);
	}

	public class LexerCommandExprSymbol extends AntlrGrammarSymbol {

		public LexerCommandExprSymbol(ANTLRv4ParserDomain.LexerCommandExpr node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public ActionBlockSymbol newActionBlockSymbol(ANTLRv4ParserDomain.ActionBlock node) {
		return new ActionBlockSymbol(node);
	}

	public class ActionBlockSymbol extends AntlrGrammarSymbol {

		public ActionBlockSymbol(ANTLRv4ParserDomain.ActionBlock node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public ModeSpecSymbol newModeSpecSymbol(ANTLRv4ParserDomain.ModeSpec node) {
		return new ModeSpecSymbol(node);
	}

	public class ModeSpecSymbol extends AntlrGrammarSymbol {

		public ModeSpecSymbol(ANTLRv4ParserDomain.ModeSpec node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setIdentifier(IdentifierSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }

	//	public AntlrGrammarSymbol addLexerRuleSpec(LexerRuleSpecSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerRuleSpec(LexerRuleSpecSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public LexerBlockSymbol newLexerBlockSymbol(ANTLRv4ParserDomain.LexerBlock node) {
		return new LexerBlockSymbol(node);
	}

	public class LexerBlockSymbol extends AntlrGrammarSymbol {

		public LexerBlockSymbol(ANTLRv4ParserDomain.LexerBlock node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addLexerAltList(LexerAltListSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setLexerAltList(LexerAltListSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public NotSetSymbol newNotSetSymbol(ANTLRv4ParserDomain.NotSet node) {
		return new NotSetSymbol(node);
	}

	public class NotSetSymbol extends AntlrGrammarSymbol {

		public NotSetSymbol(ANTLRv4ParserDomain.NotSet node) {
			super(node);
		}
	//	public AntlrGrammarSymbol addSetElement(SetElementSymbol child) { return (AntlrGrammarSymbol) super.addChild(child); }
	//	public AntlrGrammarSymbol setSetElement(SetElementSymbol child) { return (AntlrGrammarSymbol) super.setChild(child); }


		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public SetElementSymbol newSetElementSymbol(ANTLRv4ParserDomain.SetElement node) {
		return new SetElementSymbol(node);
	}

	public class SetElementSymbol extends AntlrGrammarSymbol {

		public SetElementSymbol(ANTLRv4ParserDomain.SetElement node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}

	public CharacterRangeSymbol newCharacterRangeSymbol(ANTLRv4ParserDomain.CharacterRange node) {
		return new CharacterRangeSymbol(node);
	}

	public class CharacterRangeSymbol extends AntlrGrammarSymbol {

		public CharacterRangeSymbol(ANTLRv4ParserDomain.CharacterRange node) {
			super(node);
		}

		@Override
		public Rectangle.Double paint(double startX, double startY, Graphics2D g, java.util.Map<AntlrGrammarSymbol, java.awt.geom.Rectangle2D> shapeMap, int level) {
	   	return super.paint(startX, startY, g, shapeMap, level);
		}

		@Override
		public void addActionsTo(JMenu menu, PropertyChangeSupport modelChangeSupport) {
			super.addActionsTo(menu, modelChangeSupport);
		}
	}
}