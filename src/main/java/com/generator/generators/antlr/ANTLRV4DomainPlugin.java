package com.generator.generators.antlr;

import com.generator.app.App;
import com.generator.app.DomainMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain ANTLRV4DomainPlugin
 */
public abstract class ANTLRV4DomainPlugin extends Plugin {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ANTLRV4DomainPlugin.class);

	public enum Entities implements Label {
      GrammarSpec, GrammarType, Identifier, PrequelConstruct, OptionsSpec, Option, OptionValue, DelegateGrammars, DelegateGrammar, TokensSpec, IdList, ChannelsSpec, Rules, RuleSpec, LexerRuleSpec, LexerRuleBlock, LexerAltList, LexerAlt, LexerElements, LexerElement, LexerAtom, Terminal, LexerCommands, LexerCommand, LexerCommandName, LexerCommandExpr, ActionBlock, EbnfSuffix, ModeSpec, LexerBlock, NotSet, SetElement, ParserRuleSpec, RuleBlock, RuleAltList, LabeledAlt, Alternative, Element, Atom, Ruleref, ExceptionGroup, Ebnf, Block, AltList, BlockSuffix, CharacterRange
   }

   public enum Relations implements RelationshipType {
      GRAMMARTYPE, IDENTIFIER, PREQUELCONSTRUCT, RULES, RULESPEC, MODESPEC, LEXERRULESPEC, EXCEPTIONGROUP, ELEMENT, EBNFSUFFIX, OPTIONSSPEC, DELEGATEGRAMMARS, TOKENSSPEC, CHANNELSSPEC, OPTION, OPTIONVALUE, DELEGATEGRAMMAR, IDLIST, PARSERRULESPEC, LABELEDALT, LEXERRULEBLOCK, LEXERALTLIST, LEXERALT, LEXERCOMMANDS, LEXERELEMENTS, LEXERELEMENT, LEXERATOM, ACTIONBLOCK, LEXERBLOCK, TERMINAL, NOTSET, CHARACTERRANGE, LEXERCOMMAND, LEXERCOMMANDNAME, LEXERCOMMANDEXPR, SETELEMENT, RULEBLOCK, RULEALTLIST, ALTERNATIVE, BLOCKSUFFIX, ATOM, EBNF, RULEREF, BLOCK, ALTLIST
   }

   public enum Properties {
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   ANTLRV4DomainPlugin(App app) {
      super(app, "ANTLR");

		domainNode = DomainMotif.newDomainNode(getGraph(), "ANTLR");
		entitiesNodeMap.put(Entities.GrammarSpec, DomainMotif.newDomainEntity(getGraph(), Entities.GrammarSpec, domainNode));
		entitiesNodeMap.put(Entities.GrammarType, DomainMotif.newDomainEntity(getGraph(), Entities.GrammarType, domainNode));
		entitiesNodeMap.put(Entities.Identifier, DomainMotif.newDomainEntity(getGraph(), Entities.Identifier, domainNode));
		entitiesNodeMap.put(Entities.PrequelConstruct, DomainMotif.newDomainEntity(getGraph(), Entities.PrequelConstruct, domainNode));
		entitiesNodeMap.put(Entities.OptionsSpec, DomainMotif.newDomainEntity(getGraph(), Entities.OptionsSpec, domainNode));
		entitiesNodeMap.put(Entities.Option, DomainMotif.newDomainEntity(getGraph(), Entities.Option, domainNode));
		entitiesNodeMap.put(Entities.OptionValue, DomainMotif.newDomainEntity(getGraph(), Entities.OptionValue, domainNode));
		entitiesNodeMap.put(Entities.DelegateGrammars, DomainMotif.newDomainEntity(getGraph(), Entities.DelegateGrammars, domainNode));
		entitiesNodeMap.put(Entities.DelegateGrammar, DomainMotif.newDomainEntity(getGraph(), Entities.DelegateGrammar, domainNode));
		entitiesNodeMap.put(Entities.TokensSpec, DomainMotif.newDomainEntity(getGraph(), Entities.TokensSpec, domainNode));
		entitiesNodeMap.put(Entities.IdList, DomainMotif.newDomainEntity(getGraph(), Entities.IdList, domainNode));
		entitiesNodeMap.put(Entities.ChannelsSpec, DomainMotif.newDomainEntity(getGraph(), Entities.ChannelsSpec, domainNode));
		entitiesNodeMap.put(Entities.Rules, DomainMotif.newDomainEntity(getGraph(), Entities.Rules, domainNode));
		entitiesNodeMap.put(Entities.RuleSpec, DomainMotif.newDomainEntity(getGraph(), Entities.RuleSpec, domainNode));
		entitiesNodeMap.put(Entities.LexerRuleSpec, DomainMotif.newDomainEntity(getGraph(), Entities.LexerRuleSpec, domainNode));
		entitiesNodeMap.put(Entities.LexerRuleBlock, DomainMotif.newDomainEntity(getGraph(), Entities.LexerRuleBlock, domainNode));
		entitiesNodeMap.put(Entities.LexerAltList, DomainMotif.newDomainEntity(getGraph(), Entities.LexerAltList, domainNode));
		entitiesNodeMap.put(Entities.LexerAlt, DomainMotif.newDomainEntity(getGraph(), Entities.LexerAlt, domainNode));
		entitiesNodeMap.put(Entities.LexerElements, DomainMotif.newDomainEntity(getGraph(), Entities.LexerElements, domainNode));
		entitiesNodeMap.put(Entities.LexerElement, DomainMotif.newDomainEntity(getGraph(), Entities.LexerElement, domainNode));
		entitiesNodeMap.put(Entities.LexerAtom, DomainMotif.newDomainEntity(getGraph(), Entities.LexerAtom, domainNode));
		entitiesNodeMap.put(Entities.Terminal, DomainMotif.newDomainEntity(getGraph(), Entities.Terminal, domainNode));
		entitiesNodeMap.put(Entities.LexerCommands, DomainMotif.newDomainEntity(getGraph(), Entities.LexerCommands, domainNode));
		entitiesNodeMap.put(Entities.LexerCommand, DomainMotif.newDomainEntity(getGraph(), Entities.LexerCommand, domainNode));
		entitiesNodeMap.put(Entities.LexerCommandName, DomainMotif.newDomainEntity(getGraph(), Entities.LexerCommandName, domainNode));
		entitiesNodeMap.put(Entities.LexerCommandExpr, DomainMotif.newDomainEntity(getGraph(), Entities.LexerCommandExpr, domainNode));
		entitiesNodeMap.put(Entities.ActionBlock, DomainMotif.newDomainEntity(getGraph(), Entities.ActionBlock, domainNode));
		entitiesNodeMap.put(Entities.EbnfSuffix, DomainMotif.newDomainEntity(getGraph(), Entities.EbnfSuffix, domainNode));
		entitiesNodeMap.put(Entities.ModeSpec, DomainMotif.newDomainEntity(getGraph(), Entities.ModeSpec, domainNode));
		entitiesNodeMap.put(Entities.LexerBlock, DomainMotif.newDomainEntity(getGraph(), Entities.LexerBlock, domainNode));
		entitiesNodeMap.put(Entities.NotSet, DomainMotif.newDomainEntity(getGraph(), Entities.NotSet, domainNode));
		entitiesNodeMap.put(Entities.SetElement, DomainMotif.newDomainEntity(getGraph(), Entities.SetElement, domainNode));
		entitiesNodeMap.put(Entities.ParserRuleSpec, DomainMotif.newDomainEntity(getGraph(), Entities.ParserRuleSpec, domainNode));
		entitiesNodeMap.put(Entities.RuleBlock, DomainMotif.newDomainEntity(getGraph(), Entities.RuleBlock, domainNode));
		entitiesNodeMap.put(Entities.RuleAltList, DomainMotif.newDomainEntity(getGraph(), Entities.RuleAltList, domainNode));
		entitiesNodeMap.put(Entities.LabeledAlt, DomainMotif.newDomainEntity(getGraph(), Entities.LabeledAlt, domainNode));
		entitiesNodeMap.put(Entities.Alternative, DomainMotif.newDomainEntity(getGraph(), Entities.Alternative, domainNode));
		entitiesNodeMap.put(Entities.Element, DomainMotif.newDomainEntity(getGraph(), Entities.Element, domainNode));
		entitiesNodeMap.put(Entities.Atom, DomainMotif.newDomainEntity(getGraph(), Entities.Atom, domainNode));
		entitiesNodeMap.put(Entities.Ruleref, DomainMotif.newDomainEntity(getGraph(), Entities.Ruleref, domainNode));
		entitiesNodeMap.put(Entities.ExceptionGroup, DomainMotif.newDomainEntity(getGraph(), Entities.ExceptionGroup, domainNode));
		entitiesNodeMap.put(Entities.Ebnf, DomainMotif.newDomainEntity(getGraph(), Entities.Ebnf, domainNode));
		entitiesNodeMap.put(Entities.Block, DomainMotif.newDomainEntity(getGraph(), Entities.Block, domainNode));
		entitiesNodeMap.put(Entities.AltList, DomainMotif.newDomainEntity(getGraph(), Entities.AltList, domainNode));
		entitiesNodeMap.put(Entities.BlockSuffix, DomainMotif.newDomainEntity(getGraph(), Entities.BlockSuffix, domainNode));
		entitiesNodeMap.put(Entities.CharacterRange, DomainMotif.newDomainEntity(getGraph(), Entities.CharacterRange, domainNode));


		relate(domainNode, entitiesNodeMap.get(Entities.GrammarSpec), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.GRAMMARTYPE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.GrammarType));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.IDENTIFIER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Identifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.PREQUELCONSTRUCT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PrequelConstruct));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.RULES.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Rules));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.RULESPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.RuleSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.MODESPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ModeSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.LEXERRULESPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerRuleSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.EXCEPTIONGROUP.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ExceptionGroup));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.GrammarSpec), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PrequelConstruct), Relations.OPTIONSSPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.OptionsSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PrequelConstruct), Relations.DELEGATEGRAMMARS.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.DelegateGrammars));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PrequelConstruct), Relations.TOKENSSPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TokensSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PrequelConstruct), Relations.CHANNELSSPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ChannelsSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.OptionsSpec), Relations.OPTION.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Option));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Option), Relations.IDENTIFIER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Identifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Option), Relations.OPTIONVALUE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.OptionValue));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.OptionValue), Relations.IDENTIFIER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Identifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.DelegateGrammars), Relations.DELEGATEGRAMMAR.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.DelegateGrammar));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.DelegateGrammar), Relations.IDENTIFIER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Identifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TokensSpec), Relations.IDLIST.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.IdList));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.IdList), Relations.IDENTIFIER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Identifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ChannelsSpec), Relations.IDLIST.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.IdList));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Rules), Relations.RULESPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.RuleSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleSpec), Relations.LEXERRULESPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerRuleSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleSpec), Relations.PARSERRULESPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ParserRuleSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleSpec), Relations.EXCEPTIONGROUP.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ExceptionGroup));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleSpec), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleSpec), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleSpec), Relations.LABELEDALT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LabeledAlt));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerRuleSpec), Relations.LEXERRULEBLOCK.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerRuleBlock));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerRuleBlock), Relations.LEXERALTLIST.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerAltList));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerRuleBlock), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAltList), Relations.LEXERALT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerAlt));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAltList), Relations.LEXERCOMMANDS.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerCommands));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAltList), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAlt), Relations.LEXERELEMENTS.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerElements));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAlt), Relations.LEXERCOMMANDS.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerCommands));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAlt), Relations.LEXERELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerElement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAlt), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerElements), Relations.LEXERELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerElement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerElements), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerElement), Relations.LEXERATOM.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerAtom));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerElement), Relations.ACTIONBLOCK.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ActionBlock));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerElement), Relations.LEXERBLOCK.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerBlock));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAtom), Relations.TERMINAL.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Terminal));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAtom), Relations.NOTSET.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.NotSet));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerAtom), Relations.CHARACTERRANGE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.CharacterRange));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerCommands), Relations.LEXERCOMMAND.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerCommand));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerCommand), Relations.LEXERCOMMANDNAME.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerCommandName));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerCommand), Relations.LEXERCOMMANDEXPR.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerCommandExpr));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerCommandName), Relations.IDENTIFIER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Identifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerCommandExpr), Relations.IDENTIFIER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Identifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ModeSpec), Relations.IDENTIFIER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Identifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ModeSpec), Relations.LEXERRULESPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerRuleSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LexerBlock), Relations.LEXERALTLIST.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LexerAltList));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NotSet), Relations.SETELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.SetElement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ParserRuleSpec), Relations.RULEBLOCK.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.RuleBlock));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ParserRuleSpec), Relations.EXCEPTIONGROUP.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ExceptionGroup));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ParserRuleSpec), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ParserRuleSpec), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.ParserRuleSpec), Relations.LABELEDALT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LabeledAlt));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleBlock), Relations.RULEALTLIST.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.RuleAltList));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleBlock), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleBlock), Relations.LABELEDALT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LabeledAlt));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleBlock), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleAltList), Relations.LABELEDALT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LabeledAlt));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleAltList), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.RuleAltList), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LabeledAlt), Relations.ALTERNATIVE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Alternative));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LabeledAlt), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LabeledAlt), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Alternative), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Alternative), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Alternative), Relations.BLOCKSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.BlockSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Element), Relations.ATOM.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Atom));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Element), Relations.EBNF.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Ebnf));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Atom), Relations.TERMINAL.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Terminal));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Atom), Relations.RULEREF.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Ruleref));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Ebnf), Relations.BLOCK.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Block));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Ebnf), Relations.BLOCKSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.BlockSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Ebnf), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Block), Relations.ALTLIST.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.AltList));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Block), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.AltList), Relations.ALTERNATIVE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Alternative));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.AltList), Relations.ELEMENT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Element));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.AltList), Relations.EBNFSUFFIX.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.EbnfSuffix));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isGrammarSpec(neoNode.getNode())) handleGrammarSpec(pop, neoNode, selectedNodes);
		if (isGrammarType(neoNode.getNode())) handleGrammarType(pop, neoNode, selectedNodes);
		if (isIdentifier(neoNode.getNode())) handleIdentifier(pop, neoNode, selectedNodes);
		if (isPrequelConstruct(neoNode.getNode())) handlePrequelConstruct(pop, neoNode, selectedNodes);
		if (isOptionsSpec(neoNode.getNode())) handleOptionsSpec(pop, neoNode, selectedNodes);
		if (isOption(neoNode.getNode())) handleOption(pop, neoNode, selectedNodes);
		if (isOptionValue(neoNode.getNode())) handleOptionValue(pop, neoNode, selectedNodes);
		if (isDelegateGrammars(neoNode.getNode())) handleDelegateGrammars(pop, neoNode, selectedNodes);
		if (isDelegateGrammar(neoNode.getNode())) handleDelegateGrammar(pop, neoNode, selectedNodes);
		if (isTokensSpec(neoNode.getNode())) handleTokensSpec(pop, neoNode, selectedNodes);
		if (isIdList(neoNode.getNode())) handleIdList(pop, neoNode, selectedNodes);
		if (isChannelsSpec(neoNode.getNode())) handleChannelsSpec(pop, neoNode, selectedNodes);
		if (isRules(neoNode.getNode())) handleRules(pop, neoNode, selectedNodes);
		if (isRuleSpec(neoNode.getNode())) handleRuleSpec(pop, neoNode, selectedNodes);
		if (isLexerRuleSpec(neoNode.getNode())) handleLexerRuleSpec(pop, neoNode, selectedNodes);
		if (isLexerRuleBlock(neoNode.getNode())) handleLexerRuleBlock(pop, neoNode, selectedNodes);
		if (isLexerAltList(neoNode.getNode())) handleLexerAltList(pop, neoNode, selectedNodes);
		if (isLexerAlt(neoNode.getNode())) handleLexerAlt(pop, neoNode, selectedNodes);
		if (isLexerElements(neoNode.getNode())) handleLexerElements(pop, neoNode, selectedNodes);
		if (isLexerElement(neoNode.getNode())) handleLexerElement(pop, neoNode, selectedNodes);
		if (isLexerAtom(neoNode.getNode())) handleLexerAtom(pop, neoNode, selectedNodes);
		if (isTerminal(neoNode.getNode())) handleTerminal(pop, neoNode, selectedNodes);
		if (isLexerCommands(neoNode.getNode())) handleLexerCommands(pop, neoNode, selectedNodes);
		if (isLexerCommand(neoNode.getNode())) handleLexerCommand(pop, neoNode, selectedNodes);
		if (isLexerCommandName(neoNode.getNode())) handleLexerCommandName(pop, neoNode, selectedNodes);
		if (isLexerCommandExpr(neoNode.getNode())) handleLexerCommandExpr(pop, neoNode, selectedNodes);
		if (isActionBlock(neoNode.getNode())) handleActionBlock(pop, neoNode, selectedNodes);
		if (isEbnfSuffix(neoNode.getNode())) handleEbnfSuffix(pop, neoNode, selectedNodes);
		if (isModeSpec(neoNode.getNode())) handleModeSpec(pop, neoNode, selectedNodes);
		if (isLexerBlock(neoNode.getNode())) handleLexerBlock(pop, neoNode, selectedNodes);
		if (isNotSet(neoNode.getNode())) handleNotSet(pop, neoNode, selectedNodes);
		if (isSetElement(neoNode.getNode())) handleSetElement(pop, neoNode, selectedNodes);
		if (isParserRuleSpec(neoNode.getNode())) handleParserRuleSpec(pop, neoNode, selectedNodes);
		if (isRuleBlock(neoNode.getNode())) handleRuleBlock(pop, neoNode, selectedNodes);
		if (isRuleAltList(neoNode.getNode())) handleRuleAltList(pop, neoNode, selectedNodes);
		if (isLabeledAlt(neoNode.getNode())) handleLabeledAlt(pop, neoNode, selectedNodes);
		if (isAlternative(neoNode.getNode())) handleAlternative(pop, neoNode, selectedNodes);
		if (isElement(neoNode.getNode())) handleElement(pop, neoNode, selectedNodes);
		if (isAtom(neoNode.getNode())) handleAtom(pop, neoNode, selectedNodes);
		if (isRuleref(neoNode.getNode())) handleRuleref(pop, neoNode, selectedNodes);
		if (isExceptionGroup(neoNode.getNode())) handleExceptionGroup(pop, neoNode, selectedNodes);
		if (isEbnf(neoNode.getNode())) handleEbnf(pop, neoNode, selectedNodes);
		if (isBlock(neoNode.getNode())) handleBlock(pop, neoNode, selectedNodes);
		if (isAltList(neoNode.getNode())) handleAltList(pop, neoNode, selectedNodes);
		if (isBlockSuffix(neoNode.getNode())) handleBlockSuffix(pop, neoNode, selectedNodes);
		if (isCharacterRange(neoNode.getNode())) handleCharacterRange(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isGrammarSpec(neoNode.getNode())) return newGrammarSpecEditor(neoNode);
		if (isGrammarType(neoNode.getNode())) return newGrammarTypeEditor(neoNode);
		if (isIdentifier(neoNode.getNode())) return newIdentifierEditor(neoNode);
		if (isPrequelConstruct(neoNode.getNode())) return newPrequelConstructEditor(neoNode);
		if (isOptionsSpec(neoNode.getNode())) return newOptionsSpecEditor(neoNode);
		if (isOption(neoNode.getNode())) return newOptionEditor(neoNode);
		if (isOptionValue(neoNode.getNode())) return newOptionValueEditor(neoNode);
		if (isDelegateGrammars(neoNode.getNode())) return newDelegateGrammarsEditor(neoNode);
		if (isDelegateGrammar(neoNode.getNode())) return newDelegateGrammarEditor(neoNode);
		if (isTokensSpec(neoNode.getNode())) return newTokensSpecEditor(neoNode);
		if (isIdList(neoNode.getNode())) return newIdListEditor(neoNode);
		if (isChannelsSpec(neoNode.getNode())) return newChannelsSpecEditor(neoNode);
		if (isRules(neoNode.getNode())) return newRulesEditor(neoNode);
		if (isRuleSpec(neoNode.getNode())) return newRuleSpecEditor(neoNode);
		if (isLexerRuleSpec(neoNode.getNode())) return newLexerRuleSpecEditor(neoNode);
		if (isLexerRuleBlock(neoNode.getNode())) return newLexerRuleBlockEditor(neoNode);
		if (isLexerAltList(neoNode.getNode())) return newLexerAltListEditor(neoNode);
		if (isLexerAlt(neoNode.getNode())) return newLexerAltEditor(neoNode);
		if (isLexerElements(neoNode.getNode())) return newLexerElementsEditor(neoNode);
		if (isLexerElement(neoNode.getNode())) return newLexerElementEditor(neoNode);
		if (isLexerAtom(neoNode.getNode())) return newLexerAtomEditor(neoNode);
		if (isTerminal(neoNode.getNode())) return newTerminalEditor(neoNode);
		if (isLexerCommands(neoNode.getNode())) return newLexerCommandsEditor(neoNode);
		if (isLexerCommand(neoNode.getNode())) return newLexerCommandEditor(neoNode);
		if (isLexerCommandName(neoNode.getNode())) return newLexerCommandNameEditor(neoNode);
		if (isLexerCommandExpr(neoNode.getNode())) return newLexerCommandExprEditor(neoNode);
		if (isActionBlock(neoNode.getNode())) return newActionBlockEditor(neoNode);
		if (isEbnfSuffix(neoNode.getNode())) return newEbnfSuffixEditor(neoNode);
		if (isModeSpec(neoNode.getNode())) return newModeSpecEditor(neoNode);
		if (isLexerBlock(neoNode.getNode())) return newLexerBlockEditor(neoNode);
		if (isNotSet(neoNode.getNode())) return newNotSetEditor(neoNode);
		if (isSetElement(neoNode.getNode())) return newSetElementEditor(neoNode);
		if (isParserRuleSpec(neoNode.getNode())) return newParserRuleSpecEditor(neoNode);
		if (isRuleBlock(neoNode.getNode())) return newRuleBlockEditor(neoNode);
		if (isRuleAltList(neoNode.getNode())) return newRuleAltListEditor(neoNode);
		if (isLabeledAlt(neoNode.getNode())) return newLabeledAltEditor(neoNode);
		if (isAlternative(neoNode.getNode())) return newAlternativeEditor(neoNode);
		if (isElement(neoNode.getNode())) return newElementEditor(neoNode);
		if (isAtom(neoNode.getNode())) return newAtomEditor(neoNode);
		if (isRuleref(neoNode.getNode())) return newRulerefEditor(neoNode);
		if (isExceptionGroup(neoNode.getNode())) return newExceptionGroupEditor(neoNode);
		if (isEbnf(neoNode.getNode())) return newEbnfEditor(neoNode);
		if (isBlock(neoNode.getNode())) return newBlockEditor(neoNode);
		if (isAltList(neoNode.getNode())) return newAltListEditor(neoNode);
		if (isBlockSuffix(neoNode.getNode())) return newBlockSuffixEditor(neoNode);
		if (isCharacterRange(neoNode.getNode())) return newCharacterRangeEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleGrammarSpec(JPopupMenu pop, NeoNode grammarSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleGrammarType(JPopupMenu pop, NeoNode grammarTypeNode, Set<NeoNode> selectedNodes) { }
	protected void handleIdentifier(JPopupMenu pop, NeoNode identifierNode, Set<NeoNode> selectedNodes) { }
	protected void handlePrequelConstruct(JPopupMenu pop, NeoNode prequelConstructNode, Set<NeoNode> selectedNodes) { }
	protected void handleOptionsSpec(JPopupMenu pop, NeoNode optionsSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleOption(JPopupMenu pop, NeoNode optionNode, Set<NeoNode> selectedNodes) { }
	protected void handleOptionValue(JPopupMenu pop, NeoNode optionValueNode, Set<NeoNode> selectedNodes) { }
	protected void handleDelegateGrammars(JPopupMenu pop, NeoNode delegateGrammarsNode, Set<NeoNode> selectedNodes) { }
	protected void handleDelegateGrammar(JPopupMenu pop, NeoNode delegateGrammarNode, Set<NeoNode> selectedNodes) { }
	protected void handleTokensSpec(JPopupMenu pop, NeoNode tokensSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleIdList(JPopupMenu pop, NeoNode idListNode, Set<NeoNode> selectedNodes) { }
	protected void handleChannelsSpec(JPopupMenu pop, NeoNode channelsSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleRules(JPopupMenu pop, NeoNode rulesNode, Set<NeoNode> selectedNodes) { }
	protected void handleRuleSpec(JPopupMenu pop, NeoNode ruleSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerRuleSpec(JPopupMenu pop, NeoNode lexerRuleSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerRuleBlock(JPopupMenu pop, NeoNode lexerRuleBlockNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerAltList(JPopupMenu pop, NeoNode lexerAltListNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerAlt(JPopupMenu pop, NeoNode lexerAltNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerElements(JPopupMenu pop, NeoNode lexerElementsNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerElement(JPopupMenu pop, NeoNode lexerElementNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerAtom(JPopupMenu pop, NeoNode lexerAtomNode, Set<NeoNode> selectedNodes) { }
	protected void handleTerminal(JPopupMenu pop, NeoNode terminalNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerCommands(JPopupMenu pop, NeoNode lexerCommandsNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerCommand(JPopupMenu pop, NeoNode lexerCommandNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerCommandName(JPopupMenu pop, NeoNode lexerCommandNameNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerCommandExpr(JPopupMenu pop, NeoNode lexerCommandExprNode, Set<NeoNode> selectedNodes) { }
	protected void handleActionBlock(JPopupMenu pop, NeoNode actionBlockNode, Set<NeoNode> selectedNodes) { }
	protected void handleEbnfSuffix(JPopupMenu pop, NeoNode ebnfSuffixNode, Set<NeoNode> selectedNodes) { }
	protected void handleModeSpec(JPopupMenu pop, NeoNode modeSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleLexerBlock(JPopupMenu pop, NeoNode lexerBlockNode, Set<NeoNode> selectedNodes) { }
	protected void handleNotSet(JPopupMenu pop, NeoNode notSetNode, Set<NeoNode> selectedNodes) { }
	protected void handleSetElement(JPopupMenu pop, NeoNode setElementNode, Set<NeoNode> selectedNodes) { }
	protected void handleParserRuleSpec(JPopupMenu pop, NeoNode parserRuleSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleRuleBlock(JPopupMenu pop, NeoNode ruleBlockNode, Set<NeoNode> selectedNodes) { }
	protected void handleRuleAltList(JPopupMenu pop, NeoNode ruleAltListNode, Set<NeoNode> selectedNodes) { }
	protected void handleLabeledAlt(JPopupMenu pop, NeoNode labeledAltNode, Set<NeoNode> selectedNodes) { }
	protected void handleAlternative(JPopupMenu pop, NeoNode alternativeNode, Set<NeoNode> selectedNodes) { }
	protected void handleElement(JPopupMenu pop, NeoNode elementNode, Set<NeoNode> selectedNodes) { }
	protected void handleAtom(JPopupMenu pop, NeoNode atomNode, Set<NeoNode> selectedNodes) { }
	protected void handleRuleref(JPopupMenu pop, NeoNode rulerefNode, Set<NeoNode> selectedNodes) { }
	protected void handleExceptionGroup(JPopupMenu pop, NeoNode exceptionGroupNode, Set<NeoNode> selectedNodes) { }
	protected void handleEbnf(JPopupMenu pop, NeoNode ebnfNode, Set<NeoNode> selectedNodes) { }
	protected void handleBlock(JPopupMenu pop, NeoNode blockNode, Set<NeoNode> selectedNodes) { }
	protected void handleAltList(JPopupMenu pop, NeoNode altListNode, Set<NeoNode> selectedNodes) { }
	protected void handleBlockSuffix(JPopupMenu pop, NeoNode blockSuffixNode, Set<NeoNode> selectedNodes) { }
	protected void handleCharacterRange(JPopupMenu pop, NeoNode characterRangeNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newGrammarSpecEditor(NeoNode grammarSpecNode) { return null; }
	protected JComponent newGrammarTypeEditor(NeoNode grammarTypeNode) { return null; }
	protected JComponent newIdentifierEditor(NeoNode identifierNode) { return null; }
	protected JComponent newPrequelConstructEditor(NeoNode prequelConstructNode) { return null; }
	protected JComponent newOptionsSpecEditor(NeoNode optionsSpecNode) { return null; }
	protected JComponent newOptionEditor(NeoNode optionNode) { return null; }
	protected JComponent newOptionValueEditor(NeoNode optionValueNode) { return null; }
	protected JComponent newDelegateGrammarsEditor(NeoNode delegateGrammarsNode) { return null; }
	protected JComponent newDelegateGrammarEditor(NeoNode delegateGrammarNode) { return null; }
	protected JComponent newTokensSpecEditor(NeoNode tokensSpecNode) { return null; }
	protected JComponent newIdListEditor(NeoNode idListNode) { return null; }
	protected JComponent newChannelsSpecEditor(NeoNode channelsSpecNode) { return null; }
	protected JComponent newRulesEditor(NeoNode rulesNode) { return null; }
	protected JComponent newRuleSpecEditor(NeoNode ruleSpecNode) { return null; }
	protected JComponent newLexerRuleSpecEditor(NeoNode lexerRuleSpecNode) { return null; }
	protected JComponent newLexerRuleBlockEditor(NeoNode lexerRuleBlockNode) { return null; }
	protected JComponent newLexerAltListEditor(NeoNode lexerAltListNode) { return null; }
	protected JComponent newLexerAltEditor(NeoNode lexerAltNode) { return null; }
	protected JComponent newLexerElementsEditor(NeoNode lexerElementsNode) { return null; }
	protected JComponent newLexerElementEditor(NeoNode lexerElementNode) { return null; }
	protected JComponent newLexerAtomEditor(NeoNode lexerAtomNode) { return null; }
	protected JComponent newTerminalEditor(NeoNode terminalNode) { return null; }
	protected JComponent newLexerCommandsEditor(NeoNode lexerCommandsNode) { return null; }
	protected JComponent newLexerCommandEditor(NeoNode lexerCommandNode) { return null; }
	protected JComponent newLexerCommandNameEditor(NeoNode lexerCommandNameNode) { return null; }
	protected JComponent newLexerCommandExprEditor(NeoNode lexerCommandExprNode) { return null; }
	protected JComponent newActionBlockEditor(NeoNode actionBlockNode) { return null; }
	protected JComponent newEbnfSuffixEditor(NeoNode ebnfSuffixNode) { return null; }
	protected JComponent newModeSpecEditor(NeoNode modeSpecNode) { return null; }
	protected JComponent newLexerBlockEditor(NeoNode lexerBlockNode) { return null; }
	protected JComponent newNotSetEditor(NeoNode notSetNode) { return null; }
	protected JComponent newSetElementEditor(NeoNode setElementNode) { return null; }
	protected JComponent newParserRuleSpecEditor(NeoNode parserRuleSpecNode) { return null; }
	protected JComponent newRuleBlockEditor(NeoNode ruleBlockNode) { return null; }
	protected JComponent newRuleAltListEditor(NeoNode ruleAltListNode) { return null; }
	protected JComponent newLabeledAltEditor(NeoNode labeledAltNode) { return null; }
	protected JComponent newAlternativeEditor(NeoNode alternativeNode) { return null; }
	protected JComponent newElementEditor(NeoNode elementNode) { return null; }
	protected JComponent newAtomEditor(NeoNode atomNode) { return null; }
	protected JComponent newRulerefEditor(NeoNode rulerefNode) { return null; }
	protected JComponent newExceptionGroupEditor(NeoNode exceptionGroupNode) { return null; }
	protected JComponent newEbnfEditor(NeoNode ebnfNode) { return null; }
	protected JComponent newBlockEditor(NeoNode blockNode) { return null; }
	protected JComponent newAltListEditor(NeoNode altListNode) { return null; }
	protected JComponent newBlockSuffixEditor(NeoNode blockSuffixNode) { return null; }
	protected JComponent newCharacterRangeEditor(NeoNode characterRangeNode) { return null; }

	public static boolean isGrammarSpec(Node node) { return hasLabel(node, Entities.GrammarSpec); }
	public static boolean isGrammarType(Node node) { return hasLabel(node, Entities.GrammarType); }
	public static boolean isIdentifier(Node node) { return hasLabel(node, Entities.Identifier); }
	public static boolean isPrequelConstruct(Node node) { return hasLabel(node, Entities.PrequelConstruct); }
	public static boolean isOptionsSpec(Node node) { return hasLabel(node, Entities.OptionsSpec); }
	public static boolean isOption(Node node) { return hasLabel(node, Entities.Option); }
	public static boolean isOptionValue(Node node) { return hasLabel(node, Entities.OptionValue); }
	public static boolean isDelegateGrammars(Node node) { return hasLabel(node, Entities.DelegateGrammars); }
	public static boolean isDelegateGrammar(Node node) { return hasLabel(node, Entities.DelegateGrammar); }
	public static boolean isTokensSpec(Node node) { return hasLabel(node, Entities.TokensSpec); }
	public static boolean isIdList(Node node) { return hasLabel(node, Entities.IdList); }
	public static boolean isChannelsSpec(Node node) { return hasLabel(node, Entities.ChannelsSpec); }
	public static boolean isRules(Node node) { return hasLabel(node, Entities.Rules); }
	public static boolean isRuleSpec(Node node) { return hasLabel(node, Entities.RuleSpec); }
	public static boolean isLexerRuleSpec(Node node) { return hasLabel(node, Entities.LexerRuleSpec); }
	public static boolean isLexerRuleBlock(Node node) { return hasLabel(node, Entities.LexerRuleBlock); }
	public static boolean isLexerAltList(Node node) { return hasLabel(node, Entities.LexerAltList); }
	public static boolean isLexerAlt(Node node) { return hasLabel(node, Entities.LexerAlt); }
	public static boolean isLexerElements(Node node) { return hasLabel(node, Entities.LexerElements); }
	public static boolean isLexerElement(Node node) { return hasLabel(node, Entities.LexerElement); }
	public static boolean isLexerAtom(Node node) { return hasLabel(node, Entities.LexerAtom); }
	public static boolean isTerminal(Node node) { return hasLabel(node, Entities.Terminal); }
	public static boolean isLexerCommands(Node node) { return hasLabel(node, Entities.LexerCommands); }
	public static boolean isLexerCommand(Node node) { return hasLabel(node, Entities.LexerCommand); }
	public static boolean isLexerCommandName(Node node) { return hasLabel(node, Entities.LexerCommandName); }
	public static boolean isLexerCommandExpr(Node node) { return hasLabel(node, Entities.LexerCommandExpr); }
	public static boolean isActionBlock(Node node) { return hasLabel(node, Entities.ActionBlock); }
	public static boolean isEbnfSuffix(Node node) { return hasLabel(node, Entities.EbnfSuffix); }
	public static boolean isModeSpec(Node node) { return hasLabel(node, Entities.ModeSpec); }
	public static boolean isLexerBlock(Node node) { return hasLabel(node, Entities.LexerBlock); }
	public static boolean isNotSet(Node node) { return hasLabel(node, Entities.NotSet); }
	public static boolean isSetElement(Node node) { return hasLabel(node, Entities.SetElement); }
	public static boolean isParserRuleSpec(Node node) { return hasLabel(node, Entities.ParserRuleSpec); }
	public static boolean isRuleBlock(Node node) { return hasLabel(node, Entities.RuleBlock); }
	public static boolean isRuleAltList(Node node) { return hasLabel(node, Entities.RuleAltList); }
	public static boolean isLabeledAlt(Node node) { return hasLabel(node, Entities.LabeledAlt); }
	public static boolean isAlternative(Node node) { return hasLabel(node, Entities.Alternative); }
	public static boolean isElement(Node node) { return hasLabel(node, Entities.Element); }
	public static boolean isAtom(Node node) { return hasLabel(node, Entities.Atom); }
	public static boolean isRuleref(Node node) { return hasLabel(node, Entities.Ruleref); }
	public static boolean isExceptionGroup(Node node) { return hasLabel(node, Entities.ExceptionGroup); }
	public static boolean isEbnf(Node node) { return hasLabel(node, Entities.Ebnf); }
	public static boolean isBlock(Node node) { return hasLabel(node, Entities.Block); }
	public static boolean isAltList(Node node) { return hasLabel(node, Entities.AltList); }
	public static boolean isBlockSuffix(Node node) { return hasLabel(node, Entities.BlockSuffix); }
	public static boolean isCharacterRange(Node node) { return hasLabel(node, Entities.CharacterRange); }

	protected Node newGrammarSpec() { return newGrammarSpec(getGraph()); }
	public static Node newGrammarSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.GrammarSpec)); }

	protected Node newGrammarType() { return newGrammarType(getGraph()); }
	public static Node newGrammarType(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.GrammarType)); }

	protected Node newIdentifier() { return newIdentifier(getGraph()); }
	public static Node newIdentifier(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Identifier)); }

	protected Node newPrequelConstruct() { return newPrequelConstruct(getGraph()); }
	public static Node newPrequelConstruct(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.PrequelConstruct)); }

	protected Node newOptionsSpec() { return newOptionsSpec(getGraph()); }
	public static Node newOptionsSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.OptionsSpec)); }

	protected Node newOption() { return newOption(getGraph()); }
	public static Node newOption(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Option)); }

	protected Node newOptionValue() { return newOptionValue(getGraph()); }
	public static Node newOptionValue(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.OptionValue)); }

	protected Node newDelegateGrammars() { return newDelegateGrammars(getGraph()); }
	public static Node newDelegateGrammars(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.DelegateGrammars)); }

	protected Node newDelegateGrammar() { return newDelegateGrammar(getGraph()); }
	public static Node newDelegateGrammar(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.DelegateGrammar)); }

	protected Node newTokensSpec() { return newTokensSpec(getGraph()); }
	public static Node newTokensSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TokensSpec)); }

	protected Node newIdList() { return newIdList(getGraph()); }
	public static Node newIdList(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.IdList)); }

	protected Node newChannelsSpec() { return newChannelsSpec(getGraph()); }
	public static Node newChannelsSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ChannelsSpec)); }

	protected Node newRules() { return newRules(getGraph()); }
	public static Node newRules(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Rules)); }

	protected Node newRuleSpec() { return newRuleSpec(getGraph()); }
	public static Node newRuleSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.RuleSpec)); }

	protected Node newLexerRuleSpec() { return newLexerRuleSpec(getGraph()); }
	public static Node newLexerRuleSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerRuleSpec)); }

	protected Node newLexerRuleBlock() { return newLexerRuleBlock(getGraph()); }
	public static Node newLexerRuleBlock(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerRuleBlock)); }

	protected Node newLexerAltList() { return newLexerAltList(getGraph()); }
	public static Node newLexerAltList(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerAltList)); }

	protected Node newLexerAlt() { return newLexerAlt(getGraph()); }
	public static Node newLexerAlt(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerAlt)); }

	protected Node newLexerElements() { return newLexerElements(getGraph()); }
	public static Node newLexerElements(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerElements)); }

	protected Node newLexerElement() { return newLexerElement(getGraph()); }
	public static Node newLexerElement(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerElement)); }

	protected Node newLexerAtom() { return newLexerAtom(getGraph()); }
	public static Node newLexerAtom(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerAtom)); }

	protected Node newTerminal() { return newTerminal(getGraph()); }
	public static Node newTerminal(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Terminal)); }

	protected Node newLexerCommands() { return newLexerCommands(getGraph()); }
	public static Node newLexerCommands(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerCommands)); }

	protected Node newLexerCommand() { return newLexerCommand(getGraph()); }
	public static Node newLexerCommand(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerCommand)); }

	protected Node newLexerCommandName() { return newLexerCommandName(getGraph()); }
	public static Node newLexerCommandName(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerCommandName)); }

	protected Node newLexerCommandExpr() { return newLexerCommandExpr(getGraph()); }
	public static Node newLexerCommandExpr(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerCommandExpr)); }

	protected Node newActionBlock() { return newActionBlock(getGraph()); }
	public static Node newActionBlock(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ActionBlock)); }

	protected Node newEbnfSuffix() { return newEbnfSuffix(getGraph()); }
	public static Node newEbnfSuffix(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.EbnfSuffix)); }

	protected Node newModeSpec() { return newModeSpec(getGraph()); }
	public static Node newModeSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ModeSpec)); }

	protected Node newLexerBlock() { return newLexerBlock(getGraph()); }
	public static Node newLexerBlock(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LexerBlock)); }

	protected Node newNotSet() { return newNotSet(getGraph()); }
	public static Node newNotSet(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.NotSet)); }

	protected Node newSetElement() { return newSetElement(getGraph()); }
	public static Node newSetElement(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.SetElement)); }

	protected Node newParserRuleSpec() { return newParserRuleSpec(getGraph()); }
	public static Node newParserRuleSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ParserRuleSpec)); }

	protected Node newRuleBlock() { return newRuleBlock(getGraph()); }
	public static Node newRuleBlock(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.RuleBlock)); }

	protected Node newRuleAltList() { return newRuleAltList(getGraph()); }
	public static Node newRuleAltList(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.RuleAltList)); }

	protected Node newLabeledAlt() { return newLabeledAlt(getGraph()); }
	public static Node newLabeledAlt(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LabeledAlt)); }

	protected Node newAlternative() { return newAlternative(getGraph()); }
	public static Node newAlternative(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Alternative)); }

	protected Node newElement() { return newElement(getGraph()); }
	public static Node newElement(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Element)); }

	protected Node newAtom() { return newAtom(getGraph()); }
	public static Node newAtom(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Atom)); }

	protected Node newRuleref() { return newRuleref(getGraph()); }
	public static Node newRuleref(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Ruleref)); }

	protected Node newExceptionGroup() { return newExceptionGroup(getGraph()); }
	public static Node newExceptionGroup(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ExceptionGroup)); }

	protected Node newEbnf() { return newEbnf(getGraph()); }
	public static Node newEbnf(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Ebnf)); }

	protected Node newBlock() { return newBlock(getGraph()); }
	public static Node newBlock(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Block)); }

	protected Node newAltList() { return newAltList(getGraph()); }
	public static Node newAltList(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.AltList)); }

	protected Node newBlockSuffix() { return newBlockSuffix(getGraph()); }
	public static Node newBlockSuffix(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.BlockSuffix)); }

	protected Node newCharacterRange() { return newCharacterRange(getGraph()); }
	public static Node newCharacterRange(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.CharacterRange)); }


	public static void outgoingGRAMMARTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.GRAMMARTYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingGRAMMARTYPE(Node src) { return other(src, singleOutgoing(src, Relations.GRAMMARTYPE)); }
	public static void incomingGRAMMARTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.GRAMMARTYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingGRAMMARTYPE(Node src) { return other(src, singleIncoming(src, Relations.GRAMMARTYPE)); }

	public static void outgoingIDENTIFIER(Node src, RelationConsumer consumer) { outgoing(src, Relations.IDENTIFIER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingIDENTIFIER(Node src) { return other(src, singleOutgoing(src, Relations.IDENTIFIER)); }
	public static void incomingIDENTIFIER(Node src, RelationConsumer consumer) { incoming(src, Relations.IDENTIFIER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingIDENTIFIER(Node src) { return other(src, singleIncoming(src, Relations.IDENTIFIER)); }

	public static void outgoingPREQUELCONSTRUCT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PREQUELCONSTRUCT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPREQUELCONSTRUCT(Node src) { return other(src, singleOutgoing(src, Relations.PREQUELCONSTRUCT)); }
	public static void incomingPREQUELCONSTRUCT(Node src, RelationConsumer consumer) { incoming(src, Relations.PREQUELCONSTRUCT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPREQUELCONSTRUCT(Node src) { return other(src, singleIncoming(src, Relations.PREQUELCONSTRUCT)); }

	public static void outgoingRULES(Node src, RelationConsumer consumer) { outgoing(src, Relations.RULES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRULES(Node src) { return other(src, singleOutgoing(src, Relations.RULES)); }
	public static void incomingRULES(Node src, RelationConsumer consumer) { incoming(src, Relations.RULES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRULES(Node src) { return other(src, singleIncoming(src, Relations.RULES)); }

	public static void outgoingRULESPEC(Node src, RelationConsumer consumer) { outgoing(src, Relations.RULESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRULESPEC(Node src) { return other(src, singleOutgoing(src, Relations.RULESPEC)); }
	public static void incomingRULESPEC(Node src, RelationConsumer consumer) { incoming(src, Relations.RULESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRULESPEC(Node src) { return other(src, singleIncoming(src, Relations.RULESPEC)); }

	public static void outgoingMODESPEC(Node src, RelationConsumer consumer) { outgoing(src, Relations.MODESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMODESPEC(Node src) { return other(src, singleOutgoing(src, Relations.MODESPEC)); }
	public static void incomingMODESPEC(Node src, RelationConsumer consumer) { incoming(src, Relations.MODESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMODESPEC(Node src) { return other(src, singleIncoming(src, Relations.MODESPEC)); }

	public static void outgoingLEXERRULESPEC(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERRULESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERRULESPEC(Node src) { return other(src, singleOutgoing(src, Relations.LEXERRULESPEC)); }
	public static void incomingLEXERRULESPEC(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERRULESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERRULESPEC(Node src) { return other(src, singleIncoming(src, Relations.LEXERRULESPEC)); }

	public static void outgoingEXCEPTIONGROUP(Node src, RelationConsumer consumer) { outgoing(src, Relations.EXCEPTIONGROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEXCEPTIONGROUP(Node src) { return other(src, singleOutgoing(src, Relations.EXCEPTIONGROUP)); }
	public static void incomingEXCEPTIONGROUP(Node src, RelationConsumer consumer) { incoming(src, Relations.EXCEPTIONGROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEXCEPTIONGROUP(Node src) { return other(src, singleIncoming(src, Relations.EXCEPTIONGROUP)); }

	public static void outgoingELEMENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.ELEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingELEMENT(Node src) { return other(src, singleOutgoing(src, Relations.ELEMENT)); }
	public static void incomingELEMENT(Node src, RelationConsumer consumer) { incoming(src, Relations.ELEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingELEMENT(Node src) { return other(src, singleIncoming(src, Relations.ELEMENT)); }

	public static void outgoingEBNFSUFFIX(Node src, RelationConsumer consumer) { outgoing(src, Relations.EBNFSUFFIX).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEBNFSUFFIX(Node src) { return other(src, singleOutgoing(src, Relations.EBNFSUFFIX)); }
	public static void incomingEBNFSUFFIX(Node src, RelationConsumer consumer) { incoming(src, Relations.EBNFSUFFIX).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEBNFSUFFIX(Node src) { return other(src, singleIncoming(src, Relations.EBNFSUFFIX)); }

	public static void outgoingOPTIONSSPEC(Node src, RelationConsumer consumer) { outgoing(src, Relations.OPTIONSSPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingOPTIONSSPEC(Node src) { return other(src, singleOutgoing(src, Relations.OPTIONSSPEC)); }
	public static void incomingOPTIONSSPEC(Node src, RelationConsumer consumer) { incoming(src, Relations.OPTIONSSPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingOPTIONSSPEC(Node src) { return other(src, singleIncoming(src, Relations.OPTIONSSPEC)); }

	public static void outgoingDELEGATEGRAMMARS(Node src, RelationConsumer consumer) { outgoing(src, Relations.DELEGATEGRAMMARS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDELEGATEGRAMMARS(Node src) { return other(src, singleOutgoing(src, Relations.DELEGATEGRAMMARS)); }
	public static void incomingDELEGATEGRAMMARS(Node src, RelationConsumer consumer) { incoming(src, Relations.DELEGATEGRAMMARS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDELEGATEGRAMMARS(Node src) { return other(src, singleIncoming(src, Relations.DELEGATEGRAMMARS)); }

	public static void outgoingTOKENSSPEC(Node src, RelationConsumer consumer) { outgoing(src, Relations.TOKENSSPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTOKENSSPEC(Node src) { return other(src, singleOutgoing(src, Relations.TOKENSSPEC)); }
	public static void incomingTOKENSSPEC(Node src, RelationConsumer consumer) { incoming(src, Relations.TOKENSSPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTOKENSSPEC(Node src) { return other(src, singleIncoming(src, Relations.TOKENSSPEC)); }

	public static void outgoingCHANNELSSPEC(Node src, RelationConsumer consumer) { outgoing(src, Relations.CHANNELSSPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCHANNELSSPEC(Node src) { return other(src, singleOutgoing(src, Relations.CHANNELSSPEC)); }
	public static void incomingCHANNELSSPEC(Node src, RelationConsumer consumer) { incoming(src, Relations.CHANNELSSPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCHANNELSSPEC(Node src) { return other(src, singleIncoming(src, Relations.CHANNELSSPEC)); }

	public static void outgoingOPTION(Node src, RelationConsumer consumer) { outgoing(src, Relations.OPTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingOPTION(Node src) { return other(src, singleOutgoing(src, Relations.OPTION)); }
	public static void incomingOPTION(Node src, RelationConsumer consumer) { incoming(src, Relations.OPTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingOPTION(Node src) { return other(src, singleIncoming(src, Relations.OPTION)); }

	public static void outgoingOPTIONVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.OPTIONVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingOPTIONVALUE(Node src) { return other(src, singleOutgoing(src, Relations.OPTIONVALUE)); }
	public static void incomingOPTIONVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.OPTIONVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingOPTIONVALUE(Node src) { return other(src, singleIncoming(src, Relations.OPTIONVALUE)); }

	public static void outgoingDELEGATEGRAMMAR(Node src, RelationConsumer consumer) { outgoing(src, Relations.DELEGATEGRAMMAR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDELEGATEGRAMMAR(Node src) { return other(src, singleOutgoing(src, Relations.DELEGATEGRAMMAR)); }
	public static void incomingDELEGATEGRAMMAR(Node src, RelationConsumer consumer) { incoming(src, Relations.DELEGATEGRAMMAR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDELEGATEGRAMMAR(Node src) { return other(src, singleIncoming(src, Relations.DELEGATEGRAMMAR)); }

	public static void outgoingIDLIST(Node src, RelationConsumer consumer) { outgoing(src, Relations.IDLIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingIDLIST(Node src) { return other(src, singleOutgoing(src, Relations.IDLIST)); }
	public static void incomingIDLIST(Node src, RelationConsumer consumer) { incoming(src, Relations.IDLIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingIDLIST(Node src) { return other(src, singleIncoming(src, Relations.IDLIST)); }

	public static void outgoingPARSERRULESPEC(Node src, RelationConsumer consumer) { outgoing(src, Relations.PARSERRULESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPARSERRULESPEC(Node src) { return other(src, singleOutgoing(src, Relations.PARSERRULESPEC)); }
	public static void incomingPARSERRULESPEC(Node src, RelationConsumer consumer) { incoming(src, Relations.PARSERRULESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPARSERRULESPEC(Node src) { return other(src, singleIncoming(src, Relations.PARSERRULESPEC)); }

	public static void outgoingLABELEDALT(Node src, RelationConsumer consumer) { outgoing(src, Relations.LABELEDALT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLABELEDALT(Node src) { return other(src, singleOutgoing(src, Relations.LABELEDALT)); }
	public static void incomingLABELEDALT(Node src, RelationConsumer consumer) { incoming(src, Relations.LABELEDALT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLABELEDALT(Node src) { return other(src, singleIncoming(src, Relations.LABELEDALT)); }

	public static void outgoingLEXERRULEBLOCK(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERRULEBLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERRULEBLOCK(Node src) { return other(src, singleOutgoing(src, Relations.LEXERRULEBLOCK)); }
	public static void incomingLEXERRULEBLOCK(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERRULEBLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERRULEBLOCK(Node src) { return other(src, singleIncoming(src, Relations.LEXERRULEBLOCK)); }

	public static void outgoingLEXERALTLIST(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERALTLIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERALTLIST(Node src) { return other(src, singleOutgoing(src, Relations.LEXERALTLIST)); }
	public static void incomingLEXERALTLIST(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERALTLIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERALTLIST(Node src) { return other(src, singleIncoming(src, Relations.LEXERALTLIST)); }

	public static void outgoingLEXERALT(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERALT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERALT(Node src) { return other(src, singleOutgoing(src, Relations.LEXERALT)); }
	public static void incomingLEXERALT(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERALT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERALT(Node src) { return other(src, singleIncoming(src, Relations.LEXERALT)); }

	public static void outgoingLEXERCOMMANDS(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERCOMMANDS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERCOMMANDS(Node src) { return other(src, singleOutgoing(src, Relations.LEXERCOMMANDS)); }
	public static void incomingLEXERCOMMANDS(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERCOMMANDS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERCOMMANDS(Node src) { return other(src, singleIncoming(src, Relations.LEXERCOMMANDS)); }

	public static void outgoingLEXERELEMENTS(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERELEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERELEMENTS(Node src) { return other(src, singleOutgoing(src, Relations.LEXERELEMENTS)); }
	public static void incomingLEXERELEMENTS(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERELEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERELEMENTS(Node src) { return other(src, singleIncoming(src, Relations.LEXERELEMENTS)); }

	public static void outgoingLEXERELEMENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERELEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERELEMENT(Node src) { return other(src, singleOutgoing(src, Relations.LEXERELEMENT)); }
	public static void incomingLEXERELEMENT(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERELEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERELEMENT(Node src) { return other(src, singleIncoming(src, Relations.LEXERELEMENT)); }

	public static void outgoingLEXERATOM(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERATOM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERATOM(Node src) { return other(src, singleOutgoing(src, Relations.LEXERATOM)); }
	public static void incomingLEXERATOM(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERATOM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERATOM(Node src) { return other(src, singleIncoming(src, Relations.LEXERATOM)); }

	public static void outgoingACTIONBLOCK(Node src, RelationConsumer consumer) { outgoing(src, Relations.ACTIONBLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingACTIONBLOCK(Node src) { return other(src, singleOutgoing(src, Relations.ACTIONBLOCK)); }
	public static void incomingACTIONBLOCK(Node src, RelationConsumer consumer) { incoming(src, Relations.ACTIONBLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingACTIONBLOCK(Node src) { return other(src, singleIncoming(src, Relations.ACTIONBLOCK)); }

	public static void outgoingLEXERBLOCK(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERBLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERBLOCK(Node src) { return other(src, singleOutgoing(src, Relations.LEXERBLOCK)); }
	public static void incomingLEXERBLOCK(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERBLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERBLOCK(Node src) { return other(src, singleIncoming(src, Relations.LEXERBLOCK)); }

	public static void outgoingTERMINAL(Node src, RelationConsumer consumer) { outgoing(src, Relations.TERMINAL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTERMINAL(Node src) { return other(src, singleOutgoing(src, Relations.TERMINAL)); }
	public static void incomingTERMINAL(Node src, RelationConsumer consumer) { incoming(src, Relations.TERMINAL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTERMINAL(Node src) { return other(src, singleIncoming(src, Relations.TERMINAL)); }

	public static void outgoingNOTSET(Node src, RelationConsumer consumer) { outgoing(src, Relations.NOTSET).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNOTSET(Node src) { return other(src, singleOutgoing(src, Relations.NOTSET)); }
	public static void incomingNOTSET(Node src, RelationConsumer consumer) { incoming(src, Relations.NOTSET).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNOTSET(Node src) { return other(src, singleIncoming(src, Relations.NOTSET)); }

	public static void outgoingCHARACTERRANGE(Node src, RelationConsumer consumer) { outgoing(src, Relations.CHARACTERRANGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCHARACTERRANGE(Node src) { return other(src, singleOutgoing(src, Relations.CHARACTERRANGE)); }
	public static void incomingCHARACTERRANGE(Node src, RelationConsumer consumer) { incoming(src, Relations.CHARACTERRANGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCHARACTERRANGE(Node src) { return other(src, singleIncoming(src, Relations.CHARACTERRANGE)); }

	public static void outgoingLEXERCOMMAND(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERCOMMAND).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERCOMMAND(Node src) { return other(src, singleOutgoing(src, Relations.LEXERCOMMAND)); }
	public static void incomingLEXERCOMMAND(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERCOMMAND).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERCOMMAND(Node src) { return other(src, singleIncoming(src, Relations.LEXERCOMMAND)); }

	public static void outgoingLEXERCOMMANDNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERCOMMANDNAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERCOMMANDNAME(Node src) { return other(src, singleOutgoing(src, Relations.LEXERCOMMANDNAME)); }
	public static void incomingLEXERCOMMANDNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERCOMMANDNAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERCOMMANDNAME(Node src) { return other(src, singleIncoming(src, Relations.LEXERCOMMANDNAME)); }

	public static void outgoingLEXERCOMMANDEXPR(Node src, RelationConsumer consumer) { outgoing(src, Relations.LEXERCOMMANDEXPR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLEXERCOMMANDEXPR(Node src) { return other(src, singleOutgoing(src, Relations.LEXERCOMMANDEXPR)); }
	public static void incomingLEXERCOMMANDEXPR(Node src, RelationConsumer consumer) { incoming(src, Relations.LEXERCOMMANDEXPR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLEXERCOMMANDEXPR(Node src) { return other(src, singleIncoming(src, Relations.LEXERCOMMANDEXPR)); }

	public static void outgoingSETELEMENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.SETELEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSETELEMENT(Node src) { return other(src, singleOutgoing(src, Relations.SETELEMENT)); }
	public static void incomingSETELEMENT(Node src, RelationConsumer consumer) { incoming(src, Relations.SETELEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSETELEMENT(Node src) { return other(src, singleIncoming(src, Relations.SETELEMENT)); }

	public static void outgoingRULEBLOCK(Node src, RelationConsumer consumer) { outgoing(src, Relations.RULEBLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRULEBLOCK(Node src) { return other(src, singleOutgoing(src, Relations.RULEBLOCK)); }
	public static void incomingRULEBLOCK(Node src, RelationConsumer consumer) { incoming(src, Relations.RULEBLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRULEBLOCK(Node src) { return other(src, singleIncoming(src, Relations.RULEBLOCK)); }

	public static void outgoingRULEALTLIST(Node src, RelationConsumer consumer) { outgoing(src, Relations.RULEALTLIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRULEALTLIST(Node src) { return other(src, singleOutgoing(src, Relations.RULEALTLIST)); }
	public static void incomingRULEALTLIST(Node src, RelationConsumer consumer) { incoming(src, Relations.RULEALTLIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRULEALTLIST(Node src) { return other(src, singleIncoming(src, Relations.RULEALTLIST)); }

	public static void outgoingALTERNATIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.ALTERNATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingALTERNATIVE(Node src) { return other(src, singleOutgoing(src, Relations.ALTERNATIVE)); }
	public static void incomingALTERNATIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.ALTERNATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingALTERNATIVE(Node src) { return other(src, singleIncoming(src, Relations.ALTERNATIVE)); }

	public static void outgoingBLOCKSUFFIX(Node src, RelationConsumer consumer) { outgoing(src, Relations.BLOCKSUFFIX).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingBLOCKSUFFIX(Node src) { return other(src, singleOutgoing(src, Relations.BLOCKSUFFIX)); }
	public static void incomingBLOCKSUFFIX(Node src, RelationConsumer consumer) { incoming(src, Relations.BLOCKSUFFIX).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingBLOCKSUFFIX(Node src) { return other(src, singleIncoming(src, Relations.BLOCKSUFFIX)); }

	public static void outgoingATOM(Node src, RelationConsumer consumer) { outgoing(src, Relations.ATOM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingATOM(Node src) { return other(src, singleOutgoing(src, Relations.ATOM)); }
	public static void incomingATOM(Node src, RelationConsumer consumer) { incoming(src, Relations.ATOM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingATOM(Node src) { return other(src, singleIncoming(src, Relations.ATOM)); }

	public static void outgoingEBNF(Node src, RelationConsumer consumer) { outgoing(src, Relations.EBNF).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEBNF(Node src) { return other(src, singleOutgoing(src, Relations.EBNF)); }
	public static void incomingEBNF(Node src, RelationConsumer consumer) { incoming(src, Relations.EBNF).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEBNF(Node src) { return other(src, singleIncoming(src, Relations.EBNF)); }

	public static void outgoingRULEREF(Node src, RelationConsumer consumer) { outgoing(src, Relations.RULEREF).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRULEREF(Node src) { return other(src, singleOutgoing(src, Relations.RULEREF)); }
	public static void incomingRULEREF(Node src, RelationConsumer consumer) { incoming(src, Relations.RULEREF).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRULEREF(Node src) { return other(src, singleIncoming(src, Relations.RULEREF)); }

	public static void outgoingBLOCK(Node src, RelationConsumer consumer) { outgoing(src, Relations.BLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingBLOCK(Node src) { return other(src, singleOutgoing(src, Relations.BLOCK)); }
	public static void incomingBLOCK(Node src, RelationConsumer consumer) { incoming(src, Relations.BLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingBLOCK(Node src) { return other(src, singleIncoming(src, Relations.BLOCK)); }

	public static void outgoingALTLIST(Node src, RelationConsumer consumer) { outgoing(src, Relations.ALTLIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingALTLIST(Node src) { return other(src, singleOutgoing(src, Relations.ALTLIST)); }
	public static void incomingALTLIST(Node src, RelationConsumer consumer) { incoming(src, Relations.ALTLIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingALTLIST(Node src) { return other(src, singleIncoming(src, Relations.ALTLIST)); }


	public static Relationship relateGRAMMARTYPE(Node src, Node dst) { return relate(src, dst, Relations.GRAMMARTYPE); }
	public static Relationship relateIDENTIFIER(Node src, Node dst) { return relate(src, dst, Relations.IDENTIFIER); }
	public static Relationship relatePREQUELCONSTRUCT(Node src, Node dst) { return relate(src, dst, Relations.PREQUELCONSTRUCT); }
	public static Relationship relateRULES(Node src, Node dst) { return relate(src, dst, Relations.RULES); }
	public static Relationship relateRULESPEC(Node src, Node dst) { return relate(src, dst, Relations.RULESPEC); }
	public static Relationship relateMODESPEC(Node src, Node dst) { return relate(src, dst, Relations.MODESPEC); }
	public static Relationship relateLEXERRULESPEC(Node src, Node dst) { return relate(src, dst, Relations.LEXERRULESPEC); }
	public static Relationship relateEXCEPTIONGROUP(Node src, Node dst) { return relate(src, dst, Relations.EXCEPTIONGROUP); }
	public static Relationship relateELEMENT(Node src, Node dst) { return relate(src, dst, Relations.ELEMENT); }
	public static Relationship relateEBNFSUFFIX(Node src, Node dst) { return relate(src, dst, Relations.EBNFSUFFIX); }
	public static Relationship relateOPTIONSSPEC(Node src, Node dst) { return relate(src, dst, Relations.OPTIONSSPEC); }
	public static Relationship relateDELEGATEGRAMMARS(Node src, Node dst) { return relate(src, dst, Relations.DELEGATEGRAMMARS); }
	public static Relationship relateTOKENSSPEC(Node src, Node dst) { return relate(src, dst, Relations.TOKENSSPEC); }
	public static Relationship relateCHANNELSSPEC(Node src, Node dst) { return relate(src, dst, Relations.CHANNELSSPEC); }
	public static Relationship relateOPTION(Node src, Node dst) { return relate(src, dst, Relations.OPTION); }
	public static Relationship relateOPTIONVALUE(Node src, Node dst) { return relate(src, dst, Relations.OPTIONVALUE); }
	public static Relationship relateDELEGATEGRAMMAR(Node src, Node dst) { return relate(src, dst, Relations.DELEGATEGRAMMAR); }
	public static Relationship relateIDLIST(Node src, Node dst) { return relate(src, dst, Relations.IDLIST); }
	public static Relationship relatePARSERRULESPEC(Node src, Node dst) { return relate(src, dst, Relations.PARSERRULESPEC); }
	public static Relationship relateLABELEDALT(Node src, Node dst) { return relate(src, dst, Relations.LABELEDALT); }
	public static Relationship relateLEXERRULEBLOCK(Node src, Node dst) { return relate(src, dst, Relations.LEXERRULEBLOCK); }
	public static Relationship relateLEXERALTLIST(Node src, Node dst) { return relate(src, dst, Relations.LEXERALTLIST); }
	public static Relationship relateLEXERALT(Node src, Node dst) { return relate(src, dst, Relations.LEXERALT); }
	public static Relationship relateLEXERCOMMANDS(Node src, Node dst) { return relate(src, dst, Relations.LEXERCOMMANDS); }
	public static Relationship relateLEXERELEMENTS(Node src, Node dst) { return relate(src, dst, Relations.LEXERELEMENTS); }
	public static Relationship relateLEXERELEMENT(Node src, Node dst) { return relate(src, dst, Relations.LEXERELEMENT); }
	public static Relationship relateLEXERATOM(Node src, Node dst) { return relate(src, dst, Relations.LEXERATOM); }
	public static Relationship relateACTIONBLOCK(Node src, Node dst) { return relate(src, dst, Relations.ACTIONBLOCK); }
	public static Relationship relateLEXERBLOCK(Node src, Node dst) { return relate(src, dst, Relations.LEXERBLOCK); }
	public static Relationship relateTERMINAL(Node src, Node dst) { return relate(src, dst, Relations.TERMINAL); }
	public static Relationship relateNOTSET(Node src, Node dst) { return relate(src, dst, Relations.NOTSET); }
	public static Relationship relateCHARACTERRANGE(Node src, Node dst) { return relate(src, dst, Relations.CHARACTERRANGE); }
	public static Relationship relateLEXERCOMMAND(Node src, Node dst) { return relate(src, dst, Relations.LEXERCOMMAND); }
	public static Relationship relateLEXERCOMMANDNAME(Node src, Node dst) { return relate(src, dst, Relations.LEXERCOMMANDNAME); }
	public static Relationship relateLEXERCOMMANDEXPR(Node src, Node dst) { return relate(src, dst, Relations.LEXERCOMMANDEXPR); }
	public static Relationship relateSETELEMENT(Node src, Node dst) { return relate(src, dst, Relations.SETELEMENT); }
	public static Relationship relateRULEBLOCK(Node src, Node dst) { return relate(src, dst, Relations.RULEBLOCK); }
	public static Relationship relateRULEALTLIST(Node src, Node dst) { return relate(src, dst, Relations.RULEALTLIST); }
	public static Relationship relateALTERNATIVE(Node src, Node dst) { return relate(src, dst, Relations.ALTERNATIVE); }
	public static Relationship relateBLOCKSUFFIX(Node src, Node dst) { return relate(src, dst, Relations.BLOCKSUFFIX); }
	public static Relationship relateATOM(Node src, Node dst) { return relate(src, dst, Relations.ATOM); }
	public static Relationship relateEBNF(Node src, Node dst) { return relate(src, dst, Relations.EBNF); }
	public static Relationship relateRULEREF(Node src, Node dst) { return relate(src, dst, Relations.RULEREF); }
	public static Relationship relateBLOCK(Node src, Node dst) { return relate(src, dst, Relations.BLOCK); }
	public static Relationship relateALTLIST(Node src, Node dst) { return relate(src, dst, Relations.ALTLIST); }

}