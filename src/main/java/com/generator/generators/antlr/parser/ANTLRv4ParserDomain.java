package com.generator.generators.antlr.parser;

import java.util.ArrayList;
import java.util.List;

public class ANTLRv4ParserDomain {

	public static abstract class ANTLRv4ParserDomainNode {

	}

	public static class GrammarSpec extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public GrammarType _GrammarType;

		// REQUIRED
		public Identifier _Identifier;

		// REQUIRED
		public PrequelConstruct _PrequelConstruct;

		// REQUIRED
		public Rules _Rules;

		// REQUIRED
		public ModeSpec _ModeSpec;


		public void setGrammarType(GrammarType value) { this._GrammarType = value; }

		public void setIdentifier(Identifier value) { this._Identifier = value; }

		public void setPrequelConstruct(PrequelConstruct value) { this._PrequelConstruct = value; }

		public void setRules(Rules value) { this._Rules = value; }

		public void setModeSpec(ModeSpec value) { this._ModeSpec = value; }

	}
	public static class GrammarType extends ANTLRv4ParserDomainNode {


	}
	public static class Identifier extends ANTLRv4ParserDomainNode {


	}
	public static class PrequelConstruct extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public OptionsSpec _OptionsSpec;

		// REQUIRED
		public DelegateGrammars _DelegateGrammars;

		// REQUIRED
		public TokensSpec _TokensSpec;

		// REQUIRED
		public ChannelsSpec _ChannelsSpec;


		public void setOptionsSpec(OptionsSpec value) { this._OptionsSpec = value; }

		public void setDelegateGrammars(DelegateGrammars value) { this._DelegateGrammars = value; }

		public void setTokensSpec(TokensSpec value) { this._TokensSpec = value; }

		public void setChannelsSpec(ChannelsSpec value) { this._ChannelsSpec = value; }

	}
	public static class OptionsSpec extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Option _Option;


		public void setOption(Option value) { this._Option = value; }

	}
	public static class Option extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Identifier _Identifier;

		// REQUIRED
		public OptionValue _OptionValue;


		public void setIdentifier(Identifier value) { this._Identifier = value; }

		public void setOptionValue(OptionValue value) { this._OptionValue = value; }

	}
	public static class OptionValue extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Identifier _Identifier;


		public void setIdentifier(Identifier value) { this._Identifier = value; }

	}
	public static class Rules extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public RuleSpec _RuleSpec;


		public void setRuleSpec(RuleSpec value) { this._RuleSpec = value; }

	}
	public static class RuleSpec extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public ParserRuleSpec _ParserRuleSpec;

		// REQUIRED
		public LexerRuleSpec _LexerRuleSpec;


		public void setParserRuleSpec(ParserRuleSpec value) { this._ParserRuleSpec = value; }

		public void setLexerRuleSpec(LexerRuleSpec value) { this._LexerRuleSpec = value; }

	}
	public static class ParserRuleSpec extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public RuleBlock _RuleBlock;

		// REQUIRED
		public ExceptionGroup _ExceptionGroup;


		public void setRuleBlock(RuleBlock value) { this._RuleBlock = value; }

		public void setExceptionGroup(ExceptionGroup value) { this._ExceptionGroup = value; }

	}
	public static class RuleBlock extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public RuleAltList _RuleAltList;


		public void setRuleAltList(RuleAltList value) { this._RuleAltList = value; }

	}
	public static class RuleAltList extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LabeledAlt _LabeledAlt;


		public void setLabeledAlt(LabeledAlt value) { this._LabeledAlt = value; }

	}
	public static class LabeledAlt extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Alternative _Alternative;


		public void setAlternative(Alternative value) { this._Alternative = value; }

	}
	public static class Alternative extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Element _Element;


		public void setElement(Element value) { this._Element = value; }

	}
	public static class Element extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Atom _Atom;

		// REQUIRED
		public EbnfSuffix _EbnfSuffix;

		// REQUIRED
		public Ebnf _Ebnf;


		public void setAtom(Atom value) { this._Atom = value; }

		public void setEbnfSuffix(EbnfSuffix value) { this._EbnfSuffix = value; }

		public void setEbnf(Ebnf value) { this._Ebnf = value; }

	}
	public static class Atom extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Terminal _Terminal;

		// REQUIRED
		public Ruleref _Ruleref;


		public void setTerminal(Terminal value) { this._Terminal = value; }

		public void setRuleref(Ruleref value) { this._Ruleref = value; }

	}
	public static class Terminal extends ANTLRv4ParserDomainNode {


	}
	public static class EbnfSuffix extends ANTLRv4ParserDomainNode {


	}
	public static class Ruleref extends ANTLRv4ParserDomainNode {


	}
	public static class ExceptionGroup extends ANTLRv4ParserDomainNode {


	}
	public static class Ebnf extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Block _Block;

		// REQUIRED
		public BlockSuffix _BlockSuffix;


		public void setBlock(Block value) { this._Block = value; }

		public void setBlockSuffix(BlockSuffix value) { this._BlockSuffix = value; }

	}
	public static class Block extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public AltList _AltList;


		public void setAltList(AltList value) { this._AltList = value; }

	}
	public static class AltList extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Alternative _Alternative;


		public void setAlternative(Alternative value) { this._Alternative = value; }

	}
	public static class BlockSuffix extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public EbnfSuffix _EbnfSuffix;


		public void setEbnfSuffix(EbnfSuffix value) { this._EbnfSuffix = value; }

	}
	public static class DelegateGrammars extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public DelegateGrammar _DelegateGrammar;


		public void setDelegateGrammar(DelegateGrammar value) { this._DelegateGrammar = value; }

	}
	public static class DelegateGrammar extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Identifier _Identifier;


		public void setIdentifier(Identifier value) { this._Identifier = value; }

	}
	public static class TokensSpec extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public IdList _IdList;


		public void setIdList(IdList value) { this._IdList = value; }

	}
	public static class IdList extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Identifier _Identifier;


		public void setIdentifier(Identifier value) { this._Identifier = value; }

	}
	public static class ChannelsSpec extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public IdList _IdList;


		public void setIdList(IdList value) { this._IdList = value; }

	}
	public static class LexerRuleSpec extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerRuleBlock _LexerRuleBlock;


		public void setLexerRuleBlock(LexerRuleBlock value) { this._LexerRuleBlock = value; }

	}
	public static class LexerRuleBlock extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerAltList _LexerAltList;


		public void setLexerAltList(LexerAltList value) { this._LexerAltList = value; }

	}
	public static class LexerAltList extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerAlt _LexerAlt;


		public void setLexerAlt(LexerAlt value) { this._LexerAlt = value; }

	}
	public static class LexerAlt extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerElements _LexerElements;

		// REQUIRED
		public LexerCommands _LexerCommands;


		public void setLexerElements(LexerElements value) { this._LexerElements = value; }

		public void setLexerCommands(LexerCommands value) { this._LexerCommands = value; }

	}
	public static class LexerElements extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerElement _LexerElement;


		public void setLexerElement(LexerElement value) { this._LexerElement = value; }

	}
	public static class LexerElement extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerAtom _LexerAtom;

		// REQUIRED
		public ActionBlock _ActionBlock;

		// REQUIRED
		public EbnfSuffix _EbnfSuffix;

		// REQUIRED
		public LexerBlock _LexerBlock;


		public void setLexerAtom(LexerAtom value) { this._LexerAtom = value; }

		public void setActionBlock(ActionBlock value) { this._ActionBlock = value; }

		public void setEbnfSuffix(EbnfSuffix value) { this._EbnfSuffix = value; }

		public void setLexerBlock(LexerBlock value) { this._LexerBlock = value; }

	}
	public static class LexerAtom extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Terminal _Terminal;

		// REQUIRED
		public NotSet _NotSet;

		// REQUIRED
		public CharacterRange _CharacterRange;


		public void setTerminal(Terminal value) { this._Terminal = value; }

		public void setNotSet(NotSet value) { this._NotSet = value; }

		public void setCharacterRange(CharacterRange value) { this._CharacterRange = value; }

	}
	public static class LexerCommands extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerCommand _LexerCommand;


		public void setLexerCommand(LexerCommand value) { this._LexerCommand = value; }

	}
	public static class LexerCommand extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerCommandName _LexerCommandName;

		// REQUIRED
		public LexerCommandExpr _LexerCommandExpr;


		public void setLexerCommandName(LexerCommandName value) { this._LexerCommandName = value; }

		public void setLexerCommandExpr(LexerCommandExpr value) { this._LexerCommandExpr = value; }

	}
	public static class LexerCommandName extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Identifier _Identifier;


		public void setIdentifier(Identifier value) { this._Identifier = value; }

	}
	public static class LexerCommandExpr extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Identifier _Identifier;


		public void setIdentifier(Identifier value) { this._Identifier = value; }

	}
	public static class ActionBlock extends ANTLRv4ParserDomainNode {


	}
	public static class ModeSpec extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public Identifier _Identifier;

		// REQUIRED
		public LexerRuleSpec _LexerRuleSpec;


		public void setIdentifier(Identifier value) { this._Identifier = value; }

		public void setLexerRuleSpec(LexerRuleSpec value) { this._LexerRuleSpec = value; }

	}
	public static class LexerBlock extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public LexerAltList _LexerAltList;


		public void setLexerAltList(LexerAltList value) { this._LexerAltList = value; }

	}
	public static class NotSet extends ANTLRv4ParserDomainNode {

		// REQUIRED
		public SetElement _SetElement;


		public void setSetElement(SetElement value) { this._SetElement = value; }

	}
	public static class SetElement extends ANTLRv4ParserDomainNode {


	}
	public static class CharacterRange extends ANTLRv4ParserDomainNode {


	}

}