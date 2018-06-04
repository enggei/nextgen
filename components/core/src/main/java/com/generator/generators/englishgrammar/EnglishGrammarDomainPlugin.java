package com.generator.generators.englishgrammar;

import com.generator.app.App;
import com.generator.app.DomainMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainDomainPlugin;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.app.DomainMotif.*;
import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain EnglishGrammarDomainPlugin
 */
public abstract class EnglishGrammarDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Aspect, SimpleAspect, PerfectAspect, ProgressiveAspect, PerfectProgressiveAspect, Verb, Tense, PastTense, PresentTense, FutureTense, ActionVerb, StativeVerb, TransitiveVerb, IntransitiveVerb, AuxiliaryVerb, ModalVerb, PhrasalVerb, Conjugation, Sentence, DeclarativeSentence, ImperativeSentence, InterrogativeSentence, ExclamatorySentence, ComplexSentence, CompoundSentence, SimpleSentence, CompoundComplexSentence, Predicate, Clause, Subject
   }

   public enum Relations implements RelationshipType {
      ASPECT, VERB, SENTENCE, SIMPLE, PERFECT, PROGRESSIVE, PERFECTPROGRESSIVE, TENSE, PAST, SIMPLEPAST, PERFECTPAST, PROGRESSIVEPAST, PERFECTPROGRESSIVEPAST, PRESENT, SIMPLEPRESENT, PROGRESSIVEPRESENT, PERFECTPRESENT, PERFECTPROGRESSIVEPRESENT, FUTURE, SIMPLEFUTURE, PERFECTFUTURE, PROGRESSIVEFUTURE, PERFECTPROGRESSIVEFUTURE, ACTION, STATIVE, TRANSITIVE, INTRANSITIVE, AUXILIARY, MODAL, PHRASAL, CONJUGATION, DECLARATIVE, IMPERATIVE, INTERROGATIVE, EXCLAMATORY, COMPLEX, COMPOUND, COMPOUNDCOMPLEX, PREDICATE, CLAUSE, SUBJECT
   }

   public enum Properties {
      regular
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   EnglishGrammarDomainPlugin(App app) {
      super(app, "EnglishGrammar");

		domainNode = DomainMotif.newDomainNode(getGraph(), "EnglishGrammar");
		entitiesNodeMap.put(Entities.Aspect, newDomainEntity(getGraph(), Entities.Aspect, domainNode));
		entitiesNodeMap.put(Entities.SimpleAspect, newDomainEntity(getGraph(), Entities.SimpleAspect, domainNode));
		entitiesNodeMap.put(Entities.PerfectAspect, newDomainEntity(getGraph(), Entities.PerfectAspect, domainNode));
		entitiesNodeMap.put(Entities.ProgressiveAspect, newDomainEntity(getGraph(), Entities.ProgressiveAspect, domainNode));
		entitiesNodeMap.put(Entities.PerfectProgressiveAspect, newDomainEntity(getGraph(), Entities.PerfectProgressiveAspect, domainNode));
		entitiesNodeMap.put(Entities.Verb, newDomainEntity(getGraph(), Entities.Verb, domainNode));
		entitiesNodeMap.put(Entities.Tense, newDomainEntity(getGraph(), Entities.Tense, domainNode));
		entitiesNodeMap.put(Entities.PastTense, newDomainEntity(getGraph(), Entities.PastTense, domainNode));
		entitiesNodeMap.put(Entities.PresentTense, newDomainEntity(getGraph(), Entities.PresentTense, domainNode));
		entitiesNodeMap.put(Entities.FutureTense, newDomainEntity(getGraph(), Entities.FutureTense, domainNode));
		entitiesNodeMap.put(Entities.ActionVerb, newDomainEntity(getGraph(), Entities.ActionVerb, domainNode));
		entitiesNodeMap.put(Entities.StativeVerb, newDomainEntity(getGraph(), Entities.StativeVerb, domainNode));
		entitiesNodeMap.put(Entities.TransitiveVerb, newDomainEntity(getGraph(), Entities.TransitiveVerb, domainNode));
		entitiesNodeMap.put(Entities.IntransitiveVerb, newDomainEntity(getGraph(), Entities.IntransitiveVerb, domainNode));
		entitiesNodeMap.put(Entities.AuxiliaryVerb, newDomainEntity(getGraph(), Entities.AuxiliaryVerb, domainNode));
		entitiesNodeMap.put(Entities.ModalVerb, newDomainEntity(getGraph(), Entities.ModalVerb, domainNode));
		entitiesNodeMap.put(Entities.PhrasalVerb, newDomainEntity(getGraph(), Entities.PhrasalVerb, domainNode));
		entitiesNodeMap.put(Entities.Conjugation, newDomainEntity(getGraph(), Entities.Conjugation, domainNode));
		entitiesNodeMap.put(Entities.Sentence, newDomainEntity(getGraph(), Entities.Sentence, domainNode));
		entitiesNodeMap.put(Entities.DeclarativeSentence, newDomainEntity(getGraph(), Entities.DeclarativeSentence, domainNode));
		entitiesNodeMap.put(Entities.ImperativeSentence, newDomainEntity(getGraph(), Entities.ImperativeSentence, domainNode));
		entitiesNodeMap.put(Entities.InterrogativeSentence, newDomainEntity(getGraph(), Entities.InterrogativeSentence, domainNode));
		entitiesNodeMap.put(Entities.ExclamatorySentence, newDomainEntity(getGraph(), Entities.ExclamatorySentence, domainNode));
		entitiesNodeMap.put(Entities.ComplexSentence, newDomainEntity(getGraph(), Entities.ComplexSentence, domainNode));
		entitiesNodeMap.put(Entities.CompoundSentence, newDomainEntity(getGraph(), Entities.CompoundSentence, domainNode));
		entitiesNodeMap.put(Entities.SimpleSentence, newDomainEntity(getGraph(), Entities.SimpleSentence, domainNode));
		entitiesNodeMap.put(Entities.CompoundComplexSentence, newDomainEntity(getGraph(), Entities.CompoundComplexSentence, domainNode));
		entitiesNodeMap.put(Entities.Predicate, newDomainEntity(getGraph(), Entities.Predicate, domainNode));
		entitiesNodeMap.put(Entities.Clause, newDomainEntity(getGraph(), Entities.Clause, domainNode));
		entitiesNodeMap.put(Entities.Subject, newDomainEntity(getGraph(), Entities.Subject, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Verb), Properties.regular.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Aspect), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Verb), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Sentence), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Aspect), Relations.SIMPLE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.SimpleAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Aspect), Relations.PERFECT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PerfectAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Aspect), Relations.PROGRESSIVE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ProgressiveAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Aspect), Relations.PERFECTPROGRESSIVE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PerfectProgressiveAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.TENSE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Tense));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.ACTION.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ActionVerb));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.STATIVE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.StativeVerb));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.TRANSITIVE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TransitiveVerb));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.INTRANSITIVE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.IntransitiveVerb));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.AUXILIARY.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.AuxiliaryVerb));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.MODAL.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ModalVerb));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.PHRASAL.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PhrasalVerb));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Verb), Relations.CONJUGATION.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Conjugation));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Tense), Relations.PAST.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PastTense));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Tense), Relations.PRESENT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PresentTense));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Tense), Relations.FUTURE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.FutureTense));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PastTense), Relations.SIMPLEPAST.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.SimpleAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PastTense), Relations.PERFECTPAST.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PerfectAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PastTense), Relations.PROGRESSIVEPAST.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ProgressiveAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PastTense), Relations.PERFECTPROGRESSIVEPAST.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PerfectProgressiveAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PresentTense), Relations.SIMPLEPRESENT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.SimpleAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PresentTense), Relations.PROGRESSIVEPRESENT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ProgressiveAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PresentTense), Relations.PERFECTPRESENT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PerfectAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.PresentTense), Relations.PERFECTPROGRESSIVEPRESENT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PerfectProgressiveAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.FutureTense), Relations.SIMPLEFUTURE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.SimpleAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.FutureTense), Relations.PERFECTFUTURE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PerfectAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.FutureTense), Relations.PROGRESSIVEFUTURE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ProgressiveAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.FutureTense), Relations.PERFECTPROGRESSIVEFUTURE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.PerfectProgressiveAspect));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.DECLARATIVE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.DeclarativeSentence));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.IMPERATIVE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ImperativeSentence));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.INTERROGATIVE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.InterrogativeSentence));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.EXCLAMATORY.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ExclamatorySentence));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.COMPLEX.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ComplexSentence));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.COMPOUND.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.CompoundSentence));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.SIMPLE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.SimpleSentence));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.COMPOUNDCOMPLEX.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.CompoundComplexSentence));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.PREDICATE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Predicate));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Sentence), Relations.CLAUSE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Clause));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Predicate), Relations.VERB.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Verb));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Clause), Relations.SUBJECT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Subject));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Clause), Relations.VERB.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Verb));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isAspect(neoNode.getNode())) handleAspect(pop, neoNode, selectedNodes);
		if (isSimpleAspect(neoNode.getNode())) handleSimpleAspect(pop, neoNode, selectedNodes);
		if (isPerfectAspect(neoNode.getNode())) handlePerfectAspect(pop, neoNode, selectedNodes);
		if (isProgressiveAspect(neoNode.getNode())) handleProgressiveAspect(pop, neoNode, selectedNodes);
		if (isPerfectProgressiveAspect(neoNode.getNode())) handlePerfectProgressiveAspect(pop, neoNode, selectedNodes);
		if (isVerb(neoNode.getNode())) handleVerb(pop, neoNode, selectedNodes);
		if (isTense(neoNode.getNode())) handleTense(pop, neoNode, selectedNodes);
		if (isPastTense(neoNode.getNode())) handlePastTense(pop, neoNode, selectedNodes);
		if (isPresentTense(neoNode.getNode())) handlePresentTense(pop, neoNode, selectedNodes);
		if (isFutureTense(neoNode.getNode())) handleFutureTense(pop, neoNode, selectedNodes);
		if (isActionVerb(neoNode.getNode())) handleActionVerb(pop, neoNode, selectedNodes);
		if (isStativeVerb(neoNode.getNode())) handleStativeVerb(pop, neoNode, selectedNodes);
		if (isTransitiveVerb(neoNode.getNode())) handleTransitiveVerb(pop, neoNode, selectedNodes);
		if (isIntransitiveVerb(neoNode.getNode())) handleIntransitiveVerb(pop, neoNode, selectedNodes);
		if (isAuxiliaryVerb(neoNode.getNode())) handleAuxiliaryVerb(pop, neoNode, selectedNodes);
		if (isModalVerb(neoNode.getNode())) handleModalVerb(pop, neoNode, selectedNodes);
		if (isPhrasalVerb(neoNode.getNode())) handlePhrasalVerb(pop, neoNode, selectedNodes);
		if (isConjugation(neoNode.getNode())) handleConjugation(pop, neoNode, selectedNodes);
		if (isSentence(neoNode.getNode())) handleSentence(pop, neoNode, selectedNodes);
		if (isDeclarativeSentence(neoNode.getNode())) handleDeclarativeSentence(pop, neoNode, selectedNodes);
		if (isImperativeSentence(neoNode.getNode())) handleImperativeSentence(pop, neoNode, selectedNodes);
		if (isInterrogativeSentence(neoNode.getNode())) handleInterrogativeSentence(pop, neoNode, selectedNodes);
		if (isExclamatorySentence(neoNode.getNode())) handleExclamatorySentence(pop, neoNode, selectedNodes);
		if (isComplexSentence(neoNode.getNode())) handleComplexSentence(pop, neoNode, selectedNodes);
		if (isCompoundSentence(neoNode.getNode())) handleCompoundSentence(pop, neoNode, selectedNodes);
		if (isSimpleSentence(neoNode.getNode())) handleSimpleSentence(pop, neoNode, selectedNodes);
		if (isCompoundComplexSentence(neoNode.getNode())) handleCompoundComplexSentence(pop, neoNode, selectedNodes);
		if (isPredicate(neoNode.getNode())) handlePredicate(pop, neoNode, selectedNodes);
		if (isClause(neoNode.getNode())) handleClause(pop, neoNode, selectedNodes);
		if (isSubject(neoNode.getNode())) handleSubject(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isAspect(neoNode.getNode())) return newAspectEditor(neoNode);
		if (isSimpleAspect(neoNode.getNode())) return newSimpleAspectEditor(neoNode);
		if (isPerfectAspect(neoNode.getNode())) return newPerfectAspectEditor(neoNode);
		if (isProgressiveAspect(neoNode.getNode())) return newProgressiveAspectEditor(neoNode);
		if (isPerfectProgressiveAspect(neoNode.getNode())) return newPerfectProgressiveAspectEditor(neoNode);
		if (isVerb(neoNode.getNode())) return newVerbEditor(neoNode);
		if (isTense(neoNode.getNode())) return newTenseEditor(neoNode);
		if (isPastTense(neoNode.getNode())) return newPastTenseEditor(neoNode);
		if (isPresentTense(neoNode.getNode())) return newPresentTenseEditor(neoNode);
		if (isFutureTense(neoNode.getNode())) return newFutureTenseEditor(neoNode);
		if (isActionVerb(neoNode.getNode())) return newActionVerbEditor(neoNode);
		if (isStativeVerb(neoNode.getNode())) return newStativeVerbEditor(neoNode);
		if (isTransitiveVerb(neoNode.getNode())) return newTransitiveVerbEditor(neoNode);
		if (isIntransitiveVerb(neoNode.getNode())) return newIntransitiveVerbEditor(neoNode);
		if (isAuxiliaryVerb(neoNode.getNode())) return newAuxiliaryVerbEditor(neoNode);
		if (isModalVerb(neoNode.getNode())) return newModalVerbEditor(neoNode);
		if (isPhrasalVerb(neoNode.getNode())) return newPhrasalVerbEditor(neoNode);
		if (isConjugation(neoNode.getNode())) return newConjugationEditor(neoNode);
		if (isSentence(neoNode.getNode())) return newSentenceEditor(neoNode);
		if (isDeclarativeSentence(neoNode.getNode())) return newDeclarativeSentenceEditor(neoNode);
		if (isImperativeSentence(neoNode.getNode())) return newImperativeSentenceEditor(neoNode);
		if (isInterrogativeSentence(neoNode.getNode())) return newInterrogativeSentenceEditor(neoNode);
		if (isExclamatorySentence(neoNode.getNode())) return newExclamatorySentenceEditor(neoNode);
		if (isComplexSentence(neoNode.getNode())) return newComplexSentenceEditor(neoNode);
		if (isCompoundSentence(neoNode.getNode())) return newCompoundSentenceEditor(neoNode);
		if (isSimpleSentence(neoNode.getNode())) return newSimpleSentenceEditor(neoNode);
		if (isCompoundComplexSentence(neoNode.getNode())) return newCompoundComplexSentenceEditor(neoNode);
		if (isPredicate(neoNode.getNode())) return newPredicateEditor(neoNode);
		if (isClause(neoNode.getNode())) return newClauseEditor(neoNode);
		if (isSubject(neoNode.getNode())) return newSubjectEditor(neoNode);
      return null;
   }

	protected Node getDomainNode() { return domainNode; }

	protected void handleAspect(JPopupMenu pop, NeoNode aspectNode, Set<NeoNode> selectedNodes) { }
	protected void handleSimpleAspect(JPopupMenu pop, NeoNode simpleAspectNode, Set<NeoNode> selectedNodes) { }
	protected void handlePerfectAspect(JPopupMenu pop, NeoNode perfectAspectNode, Set<NeoNode> selectedNodes) { }
	protected void handleProgressiveAspect(JPopupMenu pop, NeoNode progressiveAspectNode, Set<NeoNode> selectedNodes) { }
	protected void handlePerfectProgressiveAspect(JPopupMenu pop, NeoNode perfectProgressiveAspectNode, Set<NeoNode> selectedNodes) { }
	protected void handleVerb(JPopupMenu pop, NeoNode verbNode, Set<NeoNode> selectedNodes) { }
	protected void handleTense(JPopupMenu pop, NeoNode tenseNode, Set<NeoNode> selectedNodes) { }
	protected void handlePastTense(JPopupMenu pop, NeoNode pastTenseNode, Set<NeoNode> selectedNodes) { }
	protected void handlePresentTense(JPopupMenu pop, NeoNode presentTenseNode, Set<NeoNode> selectedNodes) { }
	protected void handleFutureTense(JPopupMenu pop, NeoNode futureTenseNode, Set<NeoNode> selectedNodes) { }
	protected void handleActionVerb(JPopupMenu pop, NeoNode actionVerbNode, Set<NeoNode> selectedNodes) { }
	protected void handleStativeVerb(JPopupMenu pop, NeoNode stativeVerbNode, Set<NeoNode> selectedNodes) { }
	protected void handleTransitiveVerb(JPopupMenu pop, NeoNode transitiveVerbNode, Set<NeoNode> selectedNodes) { }
	protected void handleIntransitiveVerb(JPopupMenu pop, NeoNode intransitiveVerbNode, Set<NeoNode> selectedNodes) { }
	protected void handleAuxiliaryVerb(JPopupMenu pop, NeoNode auxiliaryVerbNode, Set<NeoNode> selectedNodes) { }
	protected void handleModalVerb(JPopupMenu pop, NeoNode modalVerbNode, Set<NeoNode> selectedNodes) { }
	protected void handlePhrasalVerb(JPopupMenu pop, NeoNode phrasalVerbNode, Set<NeoNode> selectedNodes) { }
	protected void handleConjugation(JPopupMenu pop, NeoNode conjugationNode, Set<NeoNode> selectedNodes) { }
	protected void handleSentence(JPopupMenu pop, NeoNode sentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handleDeclarativeSentence(JPopupMenu pop, NeoNode declarativeSentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handleImperativeSentence(JPopupMenu pop, NeoNode imperativeSentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handleInterrogativeSentence(JPopupMenu pop, NeoNode interrogativeSentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handleExclamatorySentence(JPopupMenu pop, NeoNode exclamatorySentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handleComplexSentence(JPopupMenu pop, NeoNode complexSentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handleCompoundSentence(JPopupMenu pop, NeoNode compoundSentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handleSimpleSentence(JPopupMenu pop, NeoNode simpleSentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handleCompoundComplexSentence(JPopupMenu pop, NeoNode compoundComplexSentenceNode, Set<NeoNode> selectedNodes) { }
	protected void handlePredicate(JPopupMenu pop, NeoNode predicateNode, Set<NeoNode> selectedNodes) { }
	protected void handleClause(JPopupMenu pop, NeoNode clauseNode, Set<NeoNode> selectedNodes) { }
	protected void handleSubject(JPopupMenu pop, NeoNode subjectNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newAspectEditor(NeoNode aspectNode) { return null; }
	protected JComponent newSimpleAspectEditor(NeoNode simpleAspectNode) { return null; }
	protected JComponent newPerfectAspectEditor(NeoNode perfectAspectNode) { return null; }
	protected JComponent newProgressiveAspectEditor(NeoNode progressiveAspectNode) { return null; }
	protected JComponent newPerfectProgressiveAspectEditor(NeoNode perfectProgressiveAspectNode) { return null; }
	protected JComponent newVerbEditor(NeoNode verbNode) { return null; }
	protected JComponent newTenseEditor(NeoNode tenseNode) { return null; }
	protected JComponent newPastTenseEditor(NeoNode pastTenseNode) { return null; }
	protected JComponent newPresentTenseEditor(NeoNode presentTenseNode) { return null; }
	protected JComponent newFutureTenseEditor(NeoNode futureTenseNode) { return null; }
	protected JComponent newActionVerbEditor(NeoNode actionVerbNode) { return null; }
	protected JComponent newStativeVerbEditor(NeoNode stativeVerbNode) { return null; }
	protected JComponent newTransitiveVerbEditor(NeoNode transitiveVerbNode) { return null; }
	protected JComponent newIntransitiveVerbEditor(NeoNode intransitiveVerbNode) { return null; }
	protected JComponent newAuxiliaryVerbEditor(NeoNode auxiliaryVerbNode) { return null; }
	protected JComponent newModalVerbEditor(NeoNode modalVerbNode) { return null; }
	protected JComponent newPhrasalVerbEditor(NeoNode phrasalVerbNode) { return null; }
	protected JComponent newConjugationEditor(NeoNode conjugationNode) { return null; }
	protected JComponent newSentenceEditor(NeoNode sentenceNode) { return null; }
	protected JComponent newDeclarativeSentenceEditor(NeoNode declarativeSentenceNode) { return null; }
	protected JComponent newImperativeSentenceEditor(NeoNode imperativeSentenceNode) { return null; }
	protected JComponent newInterrogativeSentenceEditor(NeoNode interrogativeSentenceNode) { return null; }
	protected JComponent newExclamatorySentenceEditor(NeoNode exclamatorySentenceNode) { return null; }
	protected JComponent newComplexSentenceEditor(NeoNode complexSentenceNode) { return null; }
	protected JComponent newCompoundSentenceEditor(NeoNode compoundSentenceNode) { return null; }
	protected JComponent newSimpleSentenceEditor(NeoNode simpleSentenceNode) { return null; }
	protected JComponent newCompoundComplexSentenceEditor(NeoNode compoundComplexSentenceNode) { return null; }
	protected JComponent newPredicateEditor(NeoNode predicateNode) { return null; }
	protected JComponent newClauseEditor(NeoNode clauseNode) { return null; }
	protected JComponent newSubjectEditor(NeoNode subjectNode) { return null; }

	public static boolean isAspect(Node node) { return hasLabel(node, Entities.Aspect); }
	public static boolean isSimpleAspect(Node node) { return hasLabel(node, Entities.SimpleAspect); }
	public static boolean isPerfectAspect(Node node) { return hasLabel(node, Entities.PerfectAspect); }
	public static boolean isProgressiveAspect(Node node) { return hasLabel(node, Entities.ProgressiveAspect); }
	public static boolean isPerfectProgressiveAspect(Node node) { return hasLabel(node, Entities.PerfectProgressiveAspect); }
	public static boolean isVerb(Node node) { return hasLabel(node, Entities.Verb); }
	public static boolean isTense(Node node) { return hasLabel(node, Entities.Tense); }
	public static boolean isPastTense(Node node) { return hasLabel(node, Entities.PastTense); }
	public static boolean isPresentTense(Node node) { return hasLabel(node, Entities.PresentTense); }
	public static boolean isFutureTense(Node node) { return hasLabel(node, Entities.FutureTense); }
	public static boolean isActionVerb(Node node) { return hasLabel(node, Entities.ActionVerb); }
	public static boolean isStativeVerb(Node node) { return hasLabel(node, Entities.StativeVerb); }
	public static boolean isTransitiveVerb(Node node) { return hasLabel(node, Entities.TransitiveVerb); }
	public static boolean isIntransitiveVerb(Node node) { return hasLabel(node, Entities.IntransitiveVerb); }
	public static boolean isAuxiliaryVerb(Node node) { return hasLabel(node, Entities.AuxiliaryVerb); }
	public static boolean isModalVerb(Node node) { return hasLabel(node, Entities.ModalVerb); }
	public static boolean isPhrasalVerb(Node node) { return hasLabel(node, Entities.PhrasalVerb); }
	public static boolean isConjugation(Node node) { return hasLabel(node, Entities.Conjugation); }
	public static boolean isSentence(Node node) { return hasLabel(node, Entities.Sentence); }
	public static boolean isDeclarativeSentence(Node node) { return hasLabel(node, Entities.DeclarativeSentence); }
	public static boolean isImperativeSentence(Node node) { return hasLabel(node, Entities.ImperativeSentence); }
	public static boolean isInterrogativeSentence(Node node) { return hasLabel(node, Entities.InterrogativeSentence); }
	public static boolean isExclamatorySentence(Node node) { return hasLabel(node, Entities.ExclamatorySentence); }
	public static boolean isComplexSentence(Node node) { return hasLabel(node, Entities.ComplexSentence); }
	public static boolean isCompoundSentence(Node node) { return hasLabel(node, Entities.CompoundSentence); }
	public static boolean isSimpleSentence(Node node) { return hasLabel(node, Entities.SimpleSentence); }
	public static boolean isCompoundComplexSentence(Node node) { return hasLabel(node, Entities.CompoundComplexSentence); }
	public static boolean isPredicate(Node node) { return hasLabel(node, Entities.Predicate); }
	public static boolean isClause(Node node) { return hasLabel(node, Entities.Clause); }
	public static boolean isSubject(Node node) { return hasLabel(node, Entities.Subject); }

	protected Node newAspect() { return newAspect(getGraph()); }
	public static Node newAspect(NeoModel graph) { return newInstanceNode(graph, Entities.Aspect.name(), entitiesNodeMap.get(Entities.Aspect)); }

	protected Node newSimpleAspect() { return newSimpleAspect(getGraph()); }
	public static Node newSimpleAspect(NeoModel graph) { return newInstanceNode(graph, Entities.SimpleAspect.name(), entitiesNodeMap.get(Entities.SimpleAspect)); }

	protected Node newPerfectAspect() { return newPerfectAspect(getGraph()); }
	public static Node newPerfectAspect(NeoModel graph) { return newInstanceNode(graph, Entities.PerfectAspect.name(), entitiesNodeMap.get(Entities.PerfectAspect)); }

	protected Node newProgressiveAspect() { return newProgressiveAspect(getGraph()); }
	public static Node newProgressiveAspect(NeoModel graph) { return newInstanceNode(graph, Entities.ProgressiveAspect.name(), entitiesNodeMap.get(Entities.ProgressiveAspect)); }

	protected Node newPerfectProgressiveAspect() { return newPerfectProgressiveAspect(getGraph()); }
	public static Node newPerfectProgressiveAspect(NeoModel graph) { return newInstanceNode(graph, Entities.PerfectProgressiveAspect.name(), entitiesNodeMap.get(Entities.PerfectProgressiveAspect)); }

	protected Node newVerb() { return newVerb(getGraph()); } 
	protected Node newVerb(Object regular) { return newVerb(getGraph(), regular); } 

	public static Node newVerb(NeoModel graph) { return newInstanceNode(graph, Entities.Verb.name(), entitiesNodeMap.get(Entities.Verb)); } 
	public static Node newVerb(NeoModel graph, Object regular) {  	
		final Node newNode = newVerb(graph); 	
		if (regular != null) relate(newNode, newValueNode(graph, regular), RelationshipType.withName(Properties.regular.name())); 	
		return newNode; 
	}

	protected Node newTense() { return newTense(getGraph()); }
	public static Node newTense(NeoModel graph) { return newInstanceNode(graph, Entities.Tense.name(), entitiesNodeMap.get(Entities.Tense)); }

	protected Node newPastTense() { return newPastTense(getGraph()); }
	public static Node newPastTense(NeoModel graph) { return newInstanceNode(graph, Entities.PastTense.name(), entitiesNodeMap.get(Entities.PastTense)); }

	protected Node newPresentTense() { return newPresentTense(getGraph()); }
	public static Node newPresentTense(NeoModel graph) { return newInstanceNode(graph, Entities.PresentTense.name(), entitiesNodeMap.get(Entities.PresentTense)); }

	protected Node newFutureTense() { return newFutureTense(getGraph()); }
	public static Node newFutureTense(NeoModel graph) { return newInstanceNode(graph, Entities.FutureTense.name(), entitiesNodeMap.get(Entities.FutureTense)); }

	protected Node newActionVerb() { return newActionVerb(getGraph()); }
	public static Node newActionVerb(NeoModel graph) { return newInstanceNode(graph, Entities.ActionVerb.name(), entitiesNodeMap.get(Entities.ActionVerb)); }

	protected Node newStativeVerb() { return newStativeVerb(getGraph()); }
	public static Node newStativeVerb(NeoModel graph) { return newInstanceNode(graph, Entities.StativeVerb.name(), entitiesNodeMap.get(Entities.StativeVerb)); }

	protected Node newTransitiveVerb() { return newTransitiveVerb(getGraph()); }
	public static Node newTransitiveVerb(NeoModel graph) { return newInstanceNode(graph, Entities.TransitiveVerb.name(), entitiesNodeMap.get(Entities.TransitiveVerb)); }

	protected Node newIntransitiveVerb() { return newIntransitiveVerb(getGraph()); }
	public static Node newIntransitiveVerb(NeoModel graph) { return newInstanceNode(graph, Entities.IntransitiveVerb.name(), entitiesNodeMap.get(Entities.IntransitiveVerb)); }

	protected Node newAuxiliaryVerb() { return newAuxiliaryVerb(getGraph()); }
	public static Node newAuxiliaryVerb(NeoModel graph) { return newInstanceNode(graph, Entities.AuxiliaryVerb.name(), entitiesNodeMap.get(Entities.AuxiliaryVerb)); }

	protected Node newModalVerb() { return newModalVerb(getGraph()); }
	public static Node newModalVerb(NeoModel graph) { return newInstanceNode(graph, Entities.ModalVerb.name(), entitiesNodeMap.get(Entities.ModalVerb)); }

	protected Node newPhrasalVerb() { return newPhrasalVerb(getGraph()); }
	public static Node newPhrasalVerb(NeoModel graph) { return newInstanceNode(graph, Entities.PhrasalVerb.name(), entitiesNodeMap.get(Entities.PhrasalVerb)); }

	protected Node newConjugation() { return newConjugation(getGraph()); }
	public static Node newConjugation(NeoModel graph) { return newInstanceNode(graph, Entities.Conjugation.name(), entitiesNodeMap.get(Entities.Conjugation)); }

	protected Node newSentence() { return newSentence(getGraph()); }
	public static Node newSentence(NeoModel graph) { return newInstanceNode(graph, Entities.Sentence.name(), entitiesNodeMap.get(Entities.Sentence)); }

	protected Node newDeclarativeSentence() { return newDeclarativeSentence(getGraph()); }
	public static Node newDeclarativeSentence(NeoModel graph) { return newInstanceNode(graph, Entities.DeclarativeSentence.name(), entitiesNodeMap.get(Entities.DeclarativeSentence)); }

	protected Node newImperativeSentence() { return newImperativeSentence(getGraph()); }
	public static Node newImperativeSentence(NeoModel graph) { return newInstanceNode(graph, Entities.ImperativeSentence.name(), entitiesNodeMap.get(Entities.ImperativeSentence)); }

	protected Node newInterrogativeSentence() { return newInterrogativeSentence(getGraph()); }
	public static Node newInterrogativeSentence(NeoModel graph) { return newInstanceNode(graph, Entities.InterrogativeSentence.name(), entitiesNodeMap.get(Entities.InterrogativeSentence)); }

	protected Node newExclamatorySentence() { return newExclamatorySentence(getGraph()); }
	public static Node newExclamatorySentence(NeoModel graph) { return newInstanceNode(graph, Entities.ExclamatorySentence.name(), entitiesNodeMap.get(Entities.ExclamatorySentence)); }

	protected Node newComplexSentence() { return newComplexSentence(getGraph()); }
	public static Node newComplexSentence(NeoModel graph) { return newInstanceNode(graph, Entities.ComplexSentence.name(), entitiesNodeMap.get(Entities.ComplexSentence)); }

	protected Node newCompoundSentence() { return newCompoundSentence(getGraph()); }
	public static Node newCompoundSentence(NeoModel graph) { return newInstanceNode(graph, Entities.CompoundSentence.name(), entitiesNodeMap.get(Entities.CompoundSentence)); }

	protected Node newSimpleSentence() { return newSimpleSentence(getGraph()); }
	public static Node newSimpleSentence(NeoModel graph) { return newInstanceNode(graph, Entities.SimpleSentence.name(), entitiesNodeMap.get(Entities.SimpleSentence)); }

	protected Node newCompoundComplexSentence() { return newCompoundComplexSentence(getGraph()); }
	public static Node newCompoundComplexSentence(NeoModel graph) { return newInstanceNode(graph, Entities.CompoundComplexSentence.name(), entitiesNodeMap.get(Entities.CompoundComplexSentence)); }

	protected Node newPredicate() { return newPredicate(getGraph()); }
	public static Node newPredicate(NeoModel graph) { return newInstanceNode(graph, Entities.Predicate.name(), entitiesNodeMap.get(Entities.Predicate)); }

	protected Node newClause() { return newClause(getGraph()); }
	public static Node newClause(NeoModel graph) { return newInstanceNode(graph, Entities.Clause.name(), entitiesNodeMap.get(Entities.Clause)); }

	protected Node newSubject() { return newSubject(getGraph()); }
	public static Node newSubject(NeoModel graph) { return newInstanceNode(graph, Entities.Subject.name(), entitiesNodeMap.get(Entities.Subject)); }


	public static void outgoingASPECT(Node src, RelationConsumer consumer) { outgoing(src, Relations.ASPECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingASPECT(Node src) { return other(src, singleOutgoing(src, Relations.ASPECT)); }
	public static void incomingASPECT(Node src, RelationConsumer consumer) { incoming(src, Relations.ASPECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingASPECT(Node src) { return other(src, singleIncoming(src, Relations.ASPECT)); }

	public static void outgoingVERB(Node src, RelationConsumer consumer) { outgoing(src, Relations.VERB).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVERB(Node src) { return other(src, singleOutgoing(src, Relations.VERB)); }
	public static void incomingVERB(Node src, RelationConsumer consumer) { incoming(src, Relations.VERB).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVERB(Node src) { return other(src, singleIncoming(src, Relations.VERB)); }

	public static void outgoingSENTENCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.SENTENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSENTENCE(Node src) { return other(src, singleOutgoing(src, Relations.SENTENCE)); }
	public static void incomingSENTENCE(Node src, RelationConsumer consumer) { incoming(src, Relations.SENTENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSENTENCE(Node src) { return other(src, singleIncoming(src, Relations.SENTENCE)); }

	public static void outgoingSIMPLE(Node src, RelationConsumer consumer) { outgoing(src, Relations.SIMPLE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSIMPLE(Node src) { return other(src, singleOutgoing(src, Relations.SIMPLE)); }
	public static void incomingSIMPLE(Node src, RelationConsumer consumer) { incoming(src, Relations.SIMPLE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSIMPLE(Node src) { return other(src, singleIncoming(src, Relations.SIMPLE)); }

	public static void outgoingPERFECT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERFECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERFECT(Node src) { return other(src, singleOutgoing(src, Relations.PERFECT)); }
	public static void incomingPERFECT(Node src, RelationConsumer consumer) { incoming(src, Relations.PERFECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERFECT(Node src) { return other(src, singleIncoming(src, Relations.PERFECT)); }

	public static void outgoingPROGRESSIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROGRESSIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROGRESSIVE(Node src) { return other(src, singleOutgoing(src, Relations.PROGRESSIVE)); }
	public static void incomingPROGRESSIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.PROGRESSIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROGRESSIVE(Node src) { return other(src, singleIncoming(src, Relations.PROGRESSIVE)); }

	public static void outgoingPERFECTPROGRESSIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERFECTPROGRESSIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERFECTPROGRESSIVE(Node src) { return other(src, singleOutgoing(src, Relations.PERFECTPROGRESSIVE)); }
	public static void incomingPERFECTPROGRESSIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.PERFECTPROGRESSIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERFECTPROGRESSIVE(Node src) { return other(src, singleIncoming(src, Relations.PERFECTPROGRESSIVE)); }

	public static void outgoingTENSE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TENSE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTENSE(Node src) { return other(src, singleOutgoing(src, Relations.TENSE)); }
	public static void incomingTENSE(Node src, RelationConsumer consumer) { incoming(src, Relations.TENSE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTENSE(Node src) { return other(src, singleIncoming(src, Relations.TENSE)); }

	public static void outgoingPAST(Node src, RelationConsumer consumer) { outgoing(src, Relations.PAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPAST(Node src) { return other(src, singleOutgoing(src, Relations.PAST)); }
	public static void incomingPAST(Node src, RelationConsumer consumer) { incoming(src, Relations.PAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPAST(Node src) { return other(src, singleIncoming(src, Relations.PAST)); }

	public static void outgoingSIMPLEPAST(Node src, RelationConsumer consumer) { outgoing(src, Relations.SIMPLEPAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSIMPLEPAST(Node src) { return other(src, singleOutgoing(src, Relations.SIMPLEPAST)); }
	public static void incomingSIMPLEPAST(Node src, RelationConsumer consumer) { incoming(src, Relations.SIMPLEPAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSIMPLEPAST(Node src) { return other(src, singleIncoming(src, Relations.SIMPLEPAST)); }

	public static void outgoingPERFECTPAST(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERFECTPAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERFECTPAST(Node src) { return other(src, singleOutgoing(src, Relations.PERFECTPAST)); }
	public static void incomingPERFECTPAST(Node src, RelationConsumer consumer) { incoming(src, Relations.PERFECTPAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERFECTPAST(Node src) { return other(src, singleIncoming(src, Relations.PERFECTPAST)); }

	public static void outgoingPROGRESSIVEPAST(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROGRESSIVEPAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROGRESSIVEPAST(Node src) { return other(src, singleOutgoing(src, Relations.PROGRESSIVEPAST)); }
	public static void incomingPROGRESSIVEPAST(Node src, RelationConsumer consumer) { incoming(src, Relations.PROGRESSIVEPAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROGRESSIVEPAST(Node src) { return other(src, singleIncoming(src, Relations.PROGRESSIVEPAST)); }

	public static void outgoingPERFECTPROGRESSIVEPAST(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERFECTPROGRESSIVEPAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERFECTPROGRESSIVEPAST(Node src) { return other(src, singleOutgoing(src, Relations.PERFECTPROGRESSIVEPAST)); }
	public static void incomingPERFECTPROGRESSIVEPAST(Node src, RelationConsumer consumer) { incoming(src, Relations.PERFECTPROGRESSIVEPAST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERFECTPROGRESSIVEPAST(Node src) { return other(src, singleIncoming(src, Relations.PERFECTPROGRESSIVEPAST)); }

	public static void outgoingPRESENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPRESENT(Node src) { return other(src, singleOutgoing(src, Relations.PRESENT)); }
	public static void incomingPRESENT(Node src, RelationConsumer consumer) { incoming(src, Relations.PRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPRESENT(Node src) { return other(src, singleIncoming(src, Relations.PRESENT)); }

	public static void outgoingSIMPLEPRESENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.SIMPLEPRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSIMPLEPRESENT(Node src) { return other(src, singleOutgoing(src, Relations.SIMPLEPRESENT)); }
	public static void incomingSIMPLEPRESENT(Node src, RelationConsumer consumer) { incoming(src, Relations.SIMPLEPRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSIMPLEPRESENT(Node src) { return other(src, singleIncoming(src, Relations.SIMPLEPRESENT)); }

	public static void outgoingPROGRESSIVEPRESENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROGRESSIVEPRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROGRESSIVEPRESENT(Node src) { return other(src, singleOutgoing(src, Relations.PROGRESSIVEPRESENT)); }
	public static void incomingPROGRESSIVEPRESENT(Node src, RelationConsumer consumer) { incoming(src, Relations.PROGRESSIVEPRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROGRESSIVEPRESENT(Node src) { return other(src, singleIncoming(src, Relations.PROGRESSIVEPRESENT)); }

	public static void outgoingPERFECTPRESENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERFECTPRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERFECTPRESENT(Node src) { return other(src, singleOutgoing(src, Relations.PERFECTPRESENT)); }
	public static void incomingPERFECTPRESENT(Node src, RelationConsumer consumer) { incoming(src, Relations.PERFECTPRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERFECTPRESENT(Node src) { return other(src, singleIncoming(src, Relations.PERFECTPRESENT)); }

	public static void outgoingPERFECTPROGRESSIVEPRESENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERFECTPROGRESSIVEPRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERFECTPROGRESSIVEPRESENT(Node src) { return other(src, singleOutgoing(src, Relations.PERFECTPROGRESSIVEPRESENT)); }
	public static void incomingPERFECTPROGRESSIVEPRESENT(Node src, RelationConsumer consumer) { incoming(src, Relations.PERFECTPROGRESSIVEPRESENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERFECTPROGRESSIVEPRESENT(Node src) { return other(src, singleIncoming(src, Relations.PERFECTPROGRESSIVEPRESENT)); }

	public static void outgoingFUTURE(Node src, RelationConsumer consumer) { outgoing(src, Relations.FUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFUTURE(Node src) { return other(src, singleOutgoing(src, Relations.FUTURE)); }
	public static void incomingFUTURE(Node src, RelationConsumer consumer) { incoming(src, Relations.FUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFUTURE(Node src) { return other(src, singleIncoming(src, Relations.FUTURE)); }

	public static void outgoingSIMPLEFUTURE(Node src, RelationConsumer consumer) { outgoing(src, Relations.SIMPLEFUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSIMPLEFUTURE(Node src) { return other(src, singleOutgoing(src, Relations.SIMPLEFUTURE)); }
	public static void incomingSIMPLEFUTURE(Node src, RelationConsumer consumer) { incoming(src, Relations.SIMPLEFUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSIMPLEFUTURE(Node src) { return other(src, singleIncoming(src, Relations.SIMPLEFUTURE)); }

	public static void outgoingPERFECTFUTURE(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERFECTFUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERFECTFUTURE(Node src) { return other(src, singleOutgoing(src, Relations.PERFECTFUTURE)); }
	public static void incomingPERFECTFUTURE(Node src, RelationConsumer consumer) { incoming(src, Relations.PERFECTFUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERFECTFUTURE(Node src) { return other(src, singleIncoming(src, Relations.PERFECTFUTURE)); }

	public static void outgoingPROGRESSIVEFUTURE(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROGRESSIVEFUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROGRESSIVEFUTURE(Node src) { return other(src, singleOutgoing(src, Relations.PROGRESSIVEFUTURE)); }
	public static void incomingPROGRESSIVEFUTURE(Node src, RelationConsumer consumer) { incoming(src, Relations.PROGRESSIVEFUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROGRESSIVEFUTURE(Node src) { return other(src, singleIncoming(src, Relations.PROGRESSIVEFUTURE)); }

	public static void outgoingPERFECTPROGRESSIVEFUTURE(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERFECTPROGRESSIVEFUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERFECTPROGRESSIVEFUTURE(Node src) { return other(src, singleOutgoing(src, Relations.PERFECTPROGRESSIVEFUTURE)); }
	public static void incomingPERFECTPROGRESSIVEFUTURE(Node src, RelationConsumer consumer) { incoming(src, Relations.PERFECTPROGRESSIVEFUTURE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERFECTPROGRESSIVEFUTURE(Node src) { return other(src, singleIncoming(src, Relations.PERFECTPROGRESSIVEFUTURE)); }

	public static void outgoingACTION(Node src, RelationConsumer consumer) { outgoing(src, Relations.ACTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingACTION(Node src) { return other(src, singleOutgoing(src, Relations.ACTION)); }
	public static void incomingACTION(Node src, RelationConsumer consumer) { incoming(src, Relations.ACTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingACTION(Node src) { return other(src, singleIncoming(src, Relations.ACTION)); }

	public static void outgoingSTATIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.STATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTATIVE(Node src) { return other(src, singleOutgoing(src, Relations.STATIVE)); }
	public static void incomingSTATIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.STATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTATIVE(Node src) { return other(src, singleIncoming(src, Relations.STATIVE)); }

	public static void outgoingTRANSITIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TRANSITIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTRANSITIVE(Node src) { return other(src, singleOutgoing(src, Relations.TRANSITIVE)); }
	public static void incomingTRANSITIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.TRANSITIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTRANSITIVE(Node src) { return other(src, singleIncoming(src, Relations.TRANSITIVE)); }

	public static void outgoingINTRANSITIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.INTRANSITIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINTRANSITIVE(Node src) { return other(src, singleOutgoing(src, Relations.INTRANSITIVE)); }
	public static void incomingINTRANSITIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.INTRANSITIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINTRANSITIVE(Node src) { return other(src, singleIncoming(src, Relations.INTRANSITIVE)); }

	public static void outgoingAUXILIARY(Node src, RelationConsumer consumer) { outgoing(src, Relations.AUXILIARY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingAUXILIARY(Node src) { return other(src, singleOutgoing(src, Relations.AUXILIARY)); }
	public static void incomingAUXILIARY(Node src, RelationConsumer consumer) { incoming(src, Relations.AUXILIARY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingAUXILIARY(Node src) { return other(src, singleIncoming(src, Relations.AUXILIARY)); }

	public static void outgoingMODAL(Node src, RelationConsumer consumer) { outgoing(src, Relations.MODAL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMODAL(Node src) { return other(src, singleOutgoing(src, Relations.MODAL)); }
	public static void incomingMODAL(Node src, RelationConsumer consumer) { incoming(src, Relations.MODAL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMODAL(Node src) { return other(src, singleIncoming(src, Relations.MODAL)); }

	public static void outgoingPHRASAL(Node src, RelationConsumer consumer) { outgoing(src, Relations.PHRASAL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPHRASAL(Node src) { return other(src, singleOutgoing(src, Relations.PHRASAL)); }
	public static void incomingPHRASAL(Node src, RelationConsumer consumer) { incoming(src, Relations.PHRASAL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPHRASAL(Node src) { return other(src, singleIncoming(src, Relations.PHRASAL)); }

	public static void outgoingCONJUGATION(Node src, RelationConsumer consumer) { outgoing(src, Relations.CONJUGATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCONJUGATION(Node src) { return other(src, singleOutgoing(src, Relations.CONJUGATION)); }
	public static void incomingCONJUGATION(Node src, RelationConsumer consumer) { incoming(src, Relations.CONJUGATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCONJUGATION(Node src) { return other(src, singleIncoming(src, Relations.CONJUGATION)); }

	public static void outgoingDECLARATIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.DECLARATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDECLARATIVE(Node src) { return other(src, singleOutgoing(src, Relations.DECLARATIVE)); }
	public static void incomingDECLARATIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.DECLARATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDECLARATIVE(Node src) { return other(src, singleIncoming(src, Relations.DECLARATIVE)); }

	public static void outgoingIMPERATIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.IMPERATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingIMPERATIVE(Node src) { return other(src, singleOutgoing(src, Relations.IMPERATIVE)); }
	public static void incomingIMPERATIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.IMPERATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingIMPERATIVE(Node src) { return other(src, singleIncoming(src, Relations.IMPERATIVE)); }

	public static void outgoingINTERROGATIVE(Node src, RelationConsumer consumer) { outgoing(src, Relations.INTERROGATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINTERROGATIVE(Node src) { return other(src, singleOutgoing(src, Relations.INTERROGATIVE)); }
	public static void incomingINTERROGATIVE(Node src, RelationConsumer consumer) { incoming(src, Relations.INTERROGATIVE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINTERROGATIVE(Node src) { return other(src, singleIncoming(src, Relations.INTERROGATIVE)); }

	public static void outgoingEXCLAMATORY(Node src, RelationConsumer consumer) { outgoing(src, Relations.EXCLAMATORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEXCLAMATORY(Node src) { return other(src, singleOutgoing(src, Relations.EXCLAMATORY)); }
	public static void incomingEXCLAMATORY(Node src, RelationConsumer consumer) { incoming(src, Relations.EXCLAMATORY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEXCLAMATORY(Node src) { return other(src, singleIncoming(src, Relations.EXCLAMATORY)); }

	public static void outgoingCOMPLEX(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMPLEX).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOMPLEX(Node src) { return other(src, singleOutgoing(src, Relations.COMPLEX)); }
	public static void incomingCOMPLEX(Node src, RelationConsumer consumer) { incoming(src, Relations.COMPLEX).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOMPLEX(Node src) { return other(src, singleIncoming(src, Relations.COMPLEX)); }

	public static void outgoingCOMPOUND(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMPOUND).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOMPOUND(Node src) { return other(src, singleOutgoing(src, Relations.COMPOUND)); }
	public static void incomingCOMPOUND(Node src, RelationConsumer consumer) { incoming(src, Relations.COMPOUND).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOMPOUND(Node src) { return other(src, singleIncoming(src, Relations.COMPOUND)); }

	public static void outgoingCOMPOUNDCOMPLEX(Node src, RelationConsumer consumer) { outgoing(src, Relations.COMPOUNDCOMPLEX).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCOMPOUNDCOMPLEX(Node src) { return other(src, singleOutgoing(src, Relations.COMPOUNDCOMPLEX)); }
	public static void incomingCOMPOUNDCOMPLEX(Node src, RelationConsumer consumer) { incoming(src, Relations.COMPOUNDCOMPLEX).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCOMPOUNDCOMPLEX(Node src) { return other(src, singleIncoming(src, Relations.COMPOUNDCOMPLEX)); }

	public static void outgoingPREDICATE(Node src, RelationConsumer consumer) { outgoing(src, Relations.PREDICATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPREDICATE(Node src) { return other(src, singleOutgoing(src, Relations.PREDICATE)); }
	public static void incomingPREDICATE(Node src, RelationConsumer consumer) { incoming(src, Relations.PREDICATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPREDICATE(Node src) { return other(src, singleIncoming(src, Relations.PREDICATE)); }

	public static void outgoingCLAUSE(Node src, RelationConsumer consumer) { outgoing(src, Relations.CLAUSE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCLAUSE(Node src) { return other(src, singleOutgoing(src, Relations.CLAUSE)); }
	public static void incomingCLAUSE(Node src, RelationConsumer consumer) { incoming(src, Relations.CLAUSE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCLAUSE(Node src) { return other(src, singleIncoming(src, Relations.CLAUSE)); }

	public static void outgoingSUBJECT(Node src, RelationConsumer consumer) { outgoing(src, Relations.SUBJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSUBJECT(Node src) { return other(src, singleOutgoing(src, Relations.SUBJECT)); }
	public static void incomingSUBJECT(Node src, RelationConsumer consumer) { incoming(src, Relations.SUBJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSUBJECT(Node src) { return other(src, singleIncoming(src, Relations.SUBJECT)); }


	public static Relationship relateASPECT(Node src, Node dst) { return relate(src, dst, Relations.ASPECT); }
	public static Relationship relateVERB(Node src, Node dst) { return relate(src, dst, Relations.VERB); }
	public static Relationship relateSENTENCE(Node src, Node dst) { return relate(src, dst, Relations.SENTENCE); }
	public static Relationship relateSIMPLE(Node src, Node dst) { return relate(src, dst, Relations.SIMPLE); }
	public static Relationship relatePERFECT(Node src, Node dst) { return relate(src, dst, Relations.PERFECT); }
	public static Relationship relatePROGRESSIVE(Node src, Node dst) { return relate(src, dst, Relations.PROGRESSIVE); }
	public static Relationship relatePERFECTPROGRESSIVE(Node src, Node dst) { return relate(src, dst, Relations.PERFECTPROGRESSIVE); }
	public static Relationship relateTENSE(Node src, Node dst) { return relate(src, dst, Relations.TENSE); }
	public static Relationship relatePAST(Node src, Node dst) { return relate(src, dst, Relations.PAST); }
	public static Relationship relateSIMPLEPAST(Node src, Node dst) { return relate(src, dst, Relations.SIMPLEPAST); }
	public static Relationship relatePERFECTPAST(Node src, Node dst) { return relate(src, dst, Relations.PERFECTPAST); }
	public static Relationship relatePROGRESSIVEPAST(Node src, Node dst) { return relate(src, dst, Relations.PROGRESSIVEPAST); }
	public static Relationship relatePERFECTPROGRESSIVEPAST(Node src, Node dst) { return relate(src, dst, Relations.PERFECTPROGRESSIVEPAST); }
	public static Relationship relatePRESENT(Node src, Node dst) { return relate(src, dst, Relations.PRESENT); }
	public static Relationship relateSIMPLEPRESENT(Node src, Node dst) { return relate(src, dst, Relations.SIMPLEPRESENT); }
	public static Relationship relatePROGRESSIVEPRESENT(Node src, Node dst) { return relate(src, dst, Relations.PROGRESSIVEPRESENT); }
	public static Relationship relatePERFECTPRESENT(Node src, Node dst) { return relate(src, dst, Relations.PERFECTPRESENT); }
	public static Relationship relatePERFECTPROGRESSIVEPRESENT(Node src, Node dst) { return relate(src, dst, Relations.PERFECTPROGRESSIVEPRESENT); }
	public static Relationship relateFUTURE(Node src, Node dst) { return relate(src, dst, Relations.FUTURE); }
	public static Relationship relateSIMPLEFUTURE(Node src, Node dst) { return relate(src, dst, Relations.SIMPLEFUTURE); }
	public static Relationship relatePERFECTFUTURE(Node src, Node dst) { return relate(src, dst, Relations.PERFECTFUTURE); }
	public static Relationship relatePROGRESSIVEFUTURE(Node src, Node dst) { return relate(src, dst, Relations.PROGRESSIVEFUTURE); }
	public static Relationship relatePERFECTPROGRESSIVEFUTURE(Node src, Node dst) { return relate(src, dst, Relations.PERFECTPROGRESSIVEFUTURE); }
	public static Relationship relateACTION(Node src, Node dst) { return relate(src, dst, Relations.ACTION); }
	public static Relationship relateSTATIVE(Node src, Node dst) { return relate(src, dst, Relations.STATIVE); }
	public static Relationship relateTRANSITIVE(Node src, Node dst) { return relate(src, dst, Relations.TRANSITIVE); }
	public static Relationship relateINTRANSITIVE(Node src, Node dst) { return relate(src, dst, Relations.INTRANSITIVE); }
	public static Relationship relateAUXILIARY(Node src, Node dst) { return relate(src, dst, Relations.AUXILIARY); }
	public static Relationship relateMODAL(Node src, Node dst) { return relate(src, dst, Relations.MODAL); }
	public static Relationship relatePHRASAL(Node src, Node dst) { return relate(src, dst, Relations.PHRASAL); }
	public static Relationship relateCONJUGATION(Node src, Node dst) { return relate(src, dst, Relations.CONJUGATION); }
	public static Relationship relateDECLARATIVE(Node src, Node dst) { return relate(src, dst, Relations.DECLARATIVE); }
	public static Relationship relateIMPERATIVE(Node src, Node dst) { return relate(src, dst, Relations.IMPERATIVE); }
	public static Relationship relateINTERROGATIVE(Node src, Node dst) { return relate(src, dst, Relations.INTERROGATIVE); }
	public static Relationship relateEXCLAMATORY(Node src, Node dst) { return relate(src, dst, Relations.EXCLAMATORY); }
	public static Relationship relateCOMPLEX(Node src, Node dst) { return relate(src, dst, Relations.COMPLEX); }
	public static Relationship relateCOMPOUND(Node src, Node dst) { return relate(src, dst, Relations.COMPOUND); }
	public static Relationship relateCOMPOUNDCOMPLEX(Node src, Node dst) { return relate(src, dst, Relations.COMPOUNDCOMPLEX); }
	public static Relationship relatePREDICATE(Node src, Node dst) { return relate(src, dst, Relations.PREDICATE); }
	public static Relationship relateCLAUSE(Node src, Node dst) { return relate(src, dst, Relations.CLAUSE); }
	public static Relationship relateSUBJECT(Node src, Node dst) { return relate(src, dst, Relations.SUBJECT); }

	// regular
	public static <T> T getRegularProperty(PropertyContainer container) { return getEntityProperty(container, Properties.regular.name()); }
	public static <T> T getRegularProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.regular.name(), defaultValue); }
	public static boolean hasRegularProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.regular.name()); }
	public static <T extends PropertyContainer> T setRegularProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.regular.name(), value); return container; }
	public static <T extends PropertyContainer> T removeRegularProperty(T container) { removeEntityProperty(container, Properties.regular.name()); return container; }

	protected <T extends PropertyContainer> T setRegularProperty(T container, Object value) { setRegularProperty(getGraph(), container, value); return container; }

}