package com.generator.generators.englishgrammar;

import com.generator.util.VertxUtil;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

// Domain: EnglishGrammar
public class EnglishGrammarDomainVerticle extends AbstractVerticle {

   protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(EnglishGrammarDomainVerticle.class);

	private String neoAddress;

   @Override
   public void start(Future<Void> startFuture) throws Exception {
      log.info("Starting EnglishGrammarDomainVerticle");

		neoAddress = config().getString("neo.instance");

		VertxUtil.executeBlocking(vertx, log, new VertxUtil.Executor<JsonObject, JsonObject>() {
			@Override
			public JsonObject execute() throws Throwable {
				return onStart();
			}

			@Override
			public void onSuccess(JsonObject result) {
				log.info("EnglishGrammarDomainVerticle started : " + result.toString());
				vertx.eventBus().consumer(deploymentID(), (Handler<Message<JsonObject>>) message -> handleInstanceMessage(message));

				vertx.eventBus().consumer(deploymentID() + ".new.Aspect", (Handler<Message<JsonObject>>) message -> newAspect(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Aspect", (Handler<Message<JsonObject>>) message -> updateAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Aspect", (Handler<Message<JsonObject>>) message -> getAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Aspect", (Handler<Message<JsonObject>>) message -> listAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Aspect", (Handler<Message<JsonObject>>) message -> removeAspect(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.SimpleAspect", (Handler<Message<JsonObject>>) message -> newSimpleAspect(message));
				vertx.eventBus().consumer(deploymentID() + ".update.SimpleAspect", (Handler<Message<JsonObject>>) message -> updateSimpleAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.SimpleAspect", (Handler<Message<JsonObject>>) message -> getSimpleAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.SimpleAspect", (Handler<Message<JsonObject>>) message -> listSimpleAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.SimpleAspect", (Handler<Message<JsonObject>>) message -> removeSimpleAspect(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.PerfectAspect", (Handler<Message<JsonObject>>) message -> newPerfectAspect(message));
				vertx.eventBus().consumer(deploymentID() + ".update.PerfectAspect", (Handler<Message<JsonObject>>) message -> updatePerfectAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.PerfectAspect", (Handler<Message<JsonObject>>) message -> getPerfectAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.PerfectAspect", (Handler<Message<JsonObject>>) message -> listPerfectAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.PerfectAspect", (Handler<Message<JsonObject>>) message -> removePerfectAspect(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> newProgressiveAspect(message));
				vertx.eventBus().consumer(deploymentID() + ".update.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> updateProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> getProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> listProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> removeProgressiveAspect(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> newPerfectProgressiveAspect(message));
				vertx.eventBus().consumer(deploymentID() + ".update.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> updatePerfectProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> getPerfectProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> listPerfectProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> removePerfectProgressiveAspect(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.Verb", (Handler<Message<JsonObject>>) message -> newVerb(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Verb", (Handler<Message<JsonObject>>) message -> updateVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Verb", (Handler<Message<JsonObject>>) message -> getVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Verb", (Handler<Message<JsonObject>>) message -> listVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Verb", (Handler<Message<JsonObject>>) message -> removeVerb(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.Tense", (Handler<Message<JsonObject>>) message -> newTense(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Tense", (Handler<Message<JsonObject>>) message -> updateTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Tense", (Handler<Message<JsonObject>>) message -> getTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Tense", (Handler<Message<JsonObject>>) message -> listTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Tense", (Handler<Message<JsonObject>>) message -> removeTense(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.PastTense", (Handler<Message<JsonObject>>) message -> newPastTense(message));
				vertx.eventBus().consumer(deploymentID() + ".update.PastTense", (Handler<Message<JsonObject>>) message -> updatePastTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.PastTense", (Handler<Message<JsonObject>>) message -> getPastTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.PastTense", (Handler<Message<JsonObject>>) message -> listPastTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.PastTense", (Handler<Message<JsonObject>>) message -> removePastTense(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.PresentTense", (Handler<Message<JsonObject>>) message -> newPresentTense(message));
				vertx.eventBus().consumer(deploymentID() + ".update.PresentTense", (Handler<Message<JsonObject>>) message -> updatePresentTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.PresentTense", (Handler<Message<JsonObject>>) message -> getPresentTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.PresentTense", (Handler<Message<JsonObject>>) message -> listPresentTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.PresentTense", (Handler<Message<JsonObject>>) message -> removePresentTense(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.FutureTense", (Handler<Message<JsonObject>>) message -> newFutureTense(message));
				vertx.eventBus().consumer(deploymentID() + ".update.FutureTense", (Handler<Message<JsonObject>>) message -> updateFutureTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.FutureTense", (Handler<Message<JsonObject>>) message -> getFutureTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.FutureTense", (Handler<Message<JsonObject>>) message -> listFutureTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.FutureTense", (Handler<Message<JsonObject>>) message -> removeFutureTense(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.ActionVerb", (Handler<Message<JsonObject>>) message -> newActionVerb(message));
				vertx.eventBus().consumer(deploymentID() + ".update.ActionVerb", (Handler<Message<JsonObject>>) message -> updateActionVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.ActionVerb", (Handler<Message<JsonObject>>) message -> getActionVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.ActionVerb", (Handler<Message<JsonObject>>) message -> listActionVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.ActionVerb", (Handler<Message<JsonObject>>) message -> removeActionVerb(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.StativeVerb", (Handler<Message<JsonObject>>) message -> newStativeVerb(message));
				vertx.eventBus().consumer(deploymentID() + ".update.StativeVerb", (Handler<Message<JsonObject>>) message -> updateStativeVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.StativeVerb", (Handler<Message<JsonObject>>) message -> getStativeVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.StativeVerb", (Handler<Message<JsonObject>>) message -> listStativeVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.StativeVerb", (Handler<Message<JsonObject>>) message -> removeStativeVerb(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.TransitiveVerb", (Handler<Message<JsonObject>>) message -> newTransitiveVerb(message));
				vertx.eventBus().consumer(deploymentID() + ".update.TransitiveVerb", (Handler<Message<JsonObject>>) message -> updateTransitiveVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.TransitiveVerb", (Handler<Message<JsonObject>>) message -> getTransitiveVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.TransitiveVerb", (Handler<Message<JsonObject>>) message -> listTransitiveVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.TransitiveVerb", (Handler<Message<JsonObject>>) message -> removeTransitiveVerb(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.IntransitiveVerb", (Handler<Message<JsonObject>>) message -> newIntransitiveVerb(message));
				vertx.eventBus().consumer(deploymentID() + ".update.IntransitiveVerb", (Handler<Message<JsonObject>>) message -> updateIntransitiveVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.IntransitiveVerb", (Handler<Message<JsonObject>>) message -> getIntransitiveVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.IntransitiveVerb", (Handler<Message<JsonObject>>) message -> listIntransitiveVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.IntransitiveVerb", (Handler<Message<JsonObject>>) message -> removeIntransitiveVerb(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.AuxiliaryVerb", (Handler<Message<JsonObject>>) message -> newAuxiliaryVerb(message));
				vertx.eventBus().consumer(deploymentID() + ".update.AuxiliaryVerb", (Handler<Message<JsonObject>>) message -> updateAuxiliaryVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.AuxiliaryVerb", (Handler<Message<JsonObject>>) message -> getAuxiliaryVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.AuxiliaryVerb", (Handler<Message<JsonObject>>) message -> listAuxiliaryVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.AuxiliaryVerb", (Handler<Message<JsonObject>>) message -> removeAuxiliaryVerb(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.ModalVerb", (Handler<Message<JsonObject>>) message -> newModalVerb(message));
				vertx.eventBus().consumer(deploymentID() + ".update.ModalVerb", (Handler<Message<JsonObject>>) message -> updateModalVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.ModalVerb", (Handler<Message<JsonObject>>) message -> getModalVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.ModalVerb", (Handler<Message<JsonObject>>) message -> listModalVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.ModalVerb", (Handler<Message<JsonObject>>) message -> removeModalVerb(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.PhrasalVerb", (Handler<Message<JsonObject>>) message -> newPhrasalVerb(message));
				vertx.eventBus().consumer(deploymentID() + ".update.PhrasalVerb", (Handler<Message<JsonObject>>) message -> updatePhrasalVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.PhrasalVerb", (Handler<Message<JsonObject>>) message -> getPhrasalVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.PhrasalVerb", (Handler<Message<JsonObject>>) message -> listPhrasalVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.PhrasalVerb", (Handler<Message<JsonObject>>) message -> removePhrasalVerb(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.Conjugation", (Handler<Message<JsonObject>>) message -> newConjugation(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Conjugation", (Handler<Message<JsonObject>>) message -> updateConjugation(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Conjugation", (Handler<Message<JsonObject>>) message -> getConjugation(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Conjugation", (Handler<Message<JsonObject>>) message -> listConjugation(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Conjugation", (Handler<Message<JsonObject>>) message -> removeConjugation(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.Sentence", (Handler<Message<JsonObject>>) message -> newSentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Sentence", (Handler<Message<JsonObject>>) message -> updateSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Sentence", (Handler<Message<JsonObject>>) message -> getSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Sentence", (Handler<Message<JsonObject>>) message -> listSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Sentence", (Handler<Message<JsonObject>>) message -> removeSentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.DeclarativeSentence", (Handler<Message<JsonObject>>) message -> newDeclarativeSentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.DeclarativeSentence", (Handler<Message<JsonObject>>) message -> updateDeclarativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.DeclarativeSentence", (Handler<Message<JsonObject>>) message -> getDeclarativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.DeclarativeSentence", (Handler<Message<JsonObject>>) message -> listDeclarativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.DeclarativeSentence", (Handler<Message<JsonObject>>) message -> removeDeclarativeSentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.ImperativeSentence", (Handler<Message<JsonObject>>) message -> newImperativeSentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.ImperativeSentence", (Handler<Message<JsonObject>>) message -> updateImperativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.ImperativeSentence", (Handler<Message<JsonObject>>) message -> getImperativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.ImperativeSentence", (Handler<Message<JsonObject>>) message -> listImperativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.ImperativeSentence", (Handler<Message<JsonObject>>) message -> removeImperativeSentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.InterrogativeSentence", (Handler<Message<JsonObject>>) message -> newInterrogativeSentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.InterrogativeSentence", (Handler<Message<JsonObject>>) message -> updateInterrogativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.InterrogativeSentence", (Handler<Message<JsonObject>>) message -> getInterrogativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.InterrogativeSentence", (Handler<Message<JsonObject>>) message -> listInterrogativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.InterrogativeSentence", (Handler<Message<JsonObject>>) message -> removeInterrogativeSentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.ExclamatorySentence", (Handler<Message<JsonObject>>) message -> newExclamatorySentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.ExclamatorySentence", (Handler<Message<JsonObject>>) message -> updateExclamatorySentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.ExclamatorySentence", (Handler<Message<JsonObject>>) message -> getExclamatorySentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.ExclamatorySentence", (Handler<Message<JsonObject>>) message -> listExclamatorySentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.ExclamatorySentence", (Handler<Message<JsonObject>>) message -> removeExclamatorySentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.ComplexSentence", (Handler<Message<JsonObject>>) message -> newComplexSentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.ComplexSentence", (Handler<Message<JsonObject>>) message -> updateComplexSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.ComplexSentence", (Handler<Message<JsonObject>>) message -> getComplexSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.ComplexSentence", (Handler<Message<JsonObject>>) message -> listComplexSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.ComplexSentence", (Handler<Message<JsonObject>>) message -> removeComplexSentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.CompoundSentence", (Handler<Message<JsonObject>>) message -> newCompoundSentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.CompoundSentence", (Handler<Message<JsonObject>>) message -> updateCompoundSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.CompoundSentence", (Handler<Message<JsonObject>>) message -> getCompoundSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.CompoundSentence", (Handler<Message<JsonObject>>) message -> listCompoundSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.CompoundSentence", (Handler<Message<JsonObject>>) message -> removeCompoundSentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.SimpleSentence", (Handler<Message<JsonObject>>) message -> newSimpleSentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.SimpleSentence", (Handler<Message<JsonObject>>) message -> updateSimpleSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.SimpleSentence", (Handler<Message<JsonObject>>) message -> getSimpleSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.SimpleSentence", (Handler<Message<JsonObject>>) message -> listSimpleSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.SimpleSentence", (Handler<Message<JsonObject>>) message -> removeSimpleSentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.CompoundComplexSentence", (Handler<Message<JsonObject>>) message -> newCompoundComplexSentence(message));
				vertx.eventBus().consumer(deploymentID() + ".update.CompoundComplexSentence", (Handler<Message<JsonObject>>) message -> updateCompoundComplexSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.CompoundComplexSentence", (Handler<Message<JsonObject>>) message -> getCompoundComplexSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.CompoundComplexSentence", (Handler<Message<JsonObject>>) message -> listCompoundComplexSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.CompoundComplexSentence", (Handler<Message<JsonObject>>) message -> removeCompoundComplexSentence(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.Predicate", (Handler<Message<JsonObject>>) message -> newPredicate(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Predicate", (Handler<Message<JsonObject>>) message -> updatePredicate(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Predicate", (Handler<Message<JsonObject>>) message -> getPredicate(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Predicate", (Handler<Message<JsonObject>>) message -> listPredicate(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Predicate", (Handler<Message<JsonObject>>) message -> removePredicate(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.Clause", (Handler<Message<JsonObject>>) message -> newClause(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Clause", (Handler<Message<JsonObject>>) message -> updateClause(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Clause", (Handler<Message<JsonObject>>) message -> getClause(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Clause", (Handler<Message<JsonObject>>) message -> listClause(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Clause", (Handler<Message<JsonObject>>) message -> removeClause(message)); 

				vertx.eventBus().consumer(deploymentID() + ".new.Subject", (Handler<Message<JsonObject>>) message -> newSubject(message));
				vertx.eventBus().consumer(deploymentID() + ".update.Subject", (Handler<Message<JsonObject>>) message -> updateSubject(message)); 
				vertx.eventBus().consumer(deploymentID() + ".get.Subject", (Handler<Message<JsonObject>>) message -> getSubject(message)); 
				vertx.eventBus().consumer(deploymentID() + ".list.Subject", (Handler<Message<JsonObject>>) message -> listSubject(message)); 
				vertx.eventBus().consumer(deploymentID() + ".remove.Subject", (Handler<Message<JsonObject>>) message -> removeSubject(message)); 

				vertx.eventBus().consumer(deploymentID() + ".relate.Aspect.SIMPLE.SimpleAspect", (Handler<Message<JsonObject>>) message -> relateAspect_SIMPLE_SimpleAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Aspect.SIMPLE.SimpleAspect", (Handler<Message<JsonObject>>) message -> unrelateAspect_SIMPLE_SimpleAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Aspect.PERFECT.PerfectAspect", (Handler<Message<JsonObject>>) message -> relateAspect_PERFECT_PerfectAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Aspect.PERFECT.PerfectAspect", (Handler<Message<JsonObject>>) message -> unrelateAspect_PERFECT_PerfectAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Aspect.PROGRESSIVE.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> relateAspect_PROGRESSIVE_ProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Aspect.PROGRESSIVE.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> unrelateAspect_PROGRESSIVE_ProgressiveAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Aspect.PERFECTPROGRESSIVE.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> relateAspect_PERFECTPROGRESSIVE_PerfectProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Aspect.PERFECTPROGRESSIVE.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> unrelateAspect_PERFECTPROGRESSIVE_PerfectProgressiveAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.TENSE.Tense", (Handler<Message<JsonObject>>) message -> relateVerb_TENSE_Tense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.TENSE.Tense", (Handler<Message<JsonObject>>) message -> unrelateVerb_TENSE_Tense(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.ACTION.ActionVerb", (Handler<Message<JsonObject>>) message -> relateVerb_ACTION_ActionVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.ACTION.ActionVerb", (Handler<Message<JsonObject>>) message -> unrelateVerb_ACTION_ActionVerb(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.STATIVE.StativeVerb", (Handler<Message<JsonObject>>) message -> relateVerb_STATIVE_StativeVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.STATIVE.StativeVerb", (Handler<Message<JsonObject>>) message -> unrelateVerb_STATIVE_StativeVerb(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.TRANSITIVE.TransitiveVerb", (Handler<Message<JsonObject>>) message -> relateVerb_TRANSITIVE_TransitiveVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.TRANSITIVE.TransitiveVerb", (Handler<Message<JsonObject>>) message -> unrelateVerb_TRANSITIVE_TransitiveVerb(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.INTRANSITIVE.IntransitiveVerb", (Handler<Message<JsonObject>>) message -> relateVerb_INTRANSITIVE_IntransitiveVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.INTRANSITIVE.IntransitiveVerb", (Handler<Message<JsonObject>>) message -> unrelateVerb_INTRANSITIVE_IntransitiveVerb(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.AUXILIARY.AuxiliaryVerb", (Handler<Message<JsonObject>>) message -> relateVerb_AUXILIARY_AuxiliaryVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.AUXILIARY.AuxiliaryVerb", (Handler<Message<JsonObject>>) message -> unrelateVerb_AUXILIARY_AuxiliaryVerb(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.MODAL.ModalVerb", (Handler<Message<JsonObject>>) message -> relateVerb_MODAL_ModalVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.MODAL.ModalVerb", (Handler<Message<JsonObject>>) message -> unrelateVerb_MODAL_ModalVerb(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.PHRASAL.PhrasalVerb", (Handler<Message<JsonObject>>) message -> relateVerb_PHRASAL_PhrasalVerb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.PHRASAL.PhrasalVerb", (Handler<Message<JsonObject>>) message -> unrelateVerb_PHRASAL_PhrasalVerb(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Verb.CONJUGATION.Conjugation", (Handler<Message<JsonObject>>) message -> relateVerb_CONJUGATION_Conjugation(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Verb.CONJUGATION.Conjugation", (Handler<Message<JsonObject>>) message -> unrelateVerb_CONJUGATION_Conjugation(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Tense.PAST.PastTense", (Handler<Message<JsonObject>>) message -> relateTense_PAST_PastTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Tense.PAST.PastTense", (Handler<Message<JsonObject>>) message -> unrelateTense_PAST_PastTense(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Tense.PRESENT.PresentTense", (Handler<Message<JsonObject>>) message -> relateTense_PRESENT_PresentTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Tense.PRESENT.PresentTense", (Handler<Message<JsonObject>>) message -> unrelateTense_PRESENT_PresentTense(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Tense.FUTURE.FutureTense", (Handler<Message<JsonObject>>) message -> relateTense_FUTURE_FutureTense(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Tense.FUTURE.FutureTense", (Handler<Message<JsonObject>>) message -> unrelateTense_FUTURE_FutureTense(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.PastTense.SIMPLEPAST.SimpleAspect", (Handler<Message<JsonObject>>) message -> relatePastTense_SIMPLEPAST_SimpleAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.PastTense.SIMPLEPAST.SimpleAspect", (Handler<Message<JsonObject>>) message -> unrelatePastTense_SIMPLEPAST_SimpleAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.PastTense.PERFECTPAST.PerfectAspect", (Handler<Message<JsonObject>>) message -> relatePastTense_PERFECTPAST_PerfectAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.PastTense.PERFECTPAST.PerfectAspect", (Handler<Message<JsonObject>>) message -> unrelatePastTense_PERFECTPAST_PerfectAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.PastTense.PROGRESSIVEPAST.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> relatePastTense_PROGRESSIVEPAST_ProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.PastTense.PROGRESSIVEPAST.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> unrelatePastTense_PROGRESSIVEPAST_ProgressiveAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.PastTense.PERFECTPROGRESSIVEPAST.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> relatePastTense_PERFECTPROGRESSIVEPAST_PerfectProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.PastTense.PERFECTPROGRESSIVEPAST.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> unrelatePastTense_PERFECTPROGRESSIVEPAST_PerfectProgressiveAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.PresentTense.SIMPLEPRESENT.SimpleAspect", (Handler<Message<JsonObject>>) message -> relatePresentTense_SIMPLEPRESENT_SimpleAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.PresentTense.SIMPLEPRESENT.SimpleAspect", (Handler<Message<JsonObject>>) message -> unrelatePresentTense_SIMPLEPRESENT_SimpleAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.PresentTense.PROGRESSIVEPRESENT.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> relatePresentTense_PROGRESSIVEPRESENT_ProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.PresentTense.PROGRESSIVEPRESENT.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> unrelatePresentTense_PROGRESSIVEPRESENT_ProgressiveAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.PresentTense.PERFECTPRESENT.PerfectAspect", (Handler<Message<JsonObject>>) message -> relatePresentTense_PERFECTPRESENT_PerfectAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.PresentTense.PERFECTPRESENT.PerfectAspect", (Handler<Message<JsonObject>>) message -> unrelatePresentTense_PERFECTPRESENT_PerfectAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.PresentTense.PERFECTPROGRESSIVEPRESENT.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> relatePresentTense_PERFECTPROGRESSIVEPRESENT_PerfectProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.PresentTense.PERFECTPROGRESSIVEPRESENT.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> unrelatePresentTense_PERFECTPROGRESSIVEPRESENT_PerfectProgressiveAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.FutureTense.SIMPLEFUTURE.SimpleAspect", (Handler<Message<JsonObject>>) message -> relateFutureTense_SIMPLEFUTURE_SimpleAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.FutureTense.SIMPLEFUTURE.SimpleAspect", (Handler<Message<JsonObject>>) message -> unrelateFutureTense_SIMPLEFUTURE_SimpleAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.FutureTense.PERFECTFUTURE.PerfectAspect", (Handler<Message<JsonObject>>) message -> relateFutureTense_PERFECTFUTURE_PerfectAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.FutureTense.PERFECTFUTURE.PerfectAspect", (Handler<Message<JsonObject>>) message -> unrelateFutureTense_PERFECTFUTURE_PerfectAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.FutureTense.PROGRESSIVEFUTURE.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> relateFutureTense_PROGRESSIVEFUTURE_ProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.FutureTense.PROGRESSIVEFUTURE.ProgressiveAspect", (Handler<Message<JsonObject>>) message -> unrelateFutureTense_PROGRESSIVEFUTURE_ProgressiveAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.FutureTense.PERFECTPROGRESSIVEFUTURE.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> relateFutureTense_PERFECTPROGRESSIVEFUTURE_PerfectProgressiveAspect(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.FutureTense.PERFECTPROGRESSIVEFUTURE.PerfectProgressiveAspect", (Handler<Message<JsonObject>>) message -> unrelateFutureTense_PERFECTPROGRESSIVEFUTURE_PerfectProgressiveAspect(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.DECLARATIVE.DeclarativeSentence", (Handler<Message<JsonObject>>) message -> relateSentence_DECLARATIVE_DeclarativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.DECLARATIVE.DeclarativeSentence", (Handler<Message<JsonObject>>) message -> unrelateSentence_DECLARATIVE_DeclarativeSentence(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.IMPERATIVE.ImperativeSentence", (Handler<Message<JsonObject>>) message -> relateSentence_IMPERATIVE_ImperativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.IMPERATIVE.ImperativeSentence", (Handler<Message<JsonObject>>) message -> unrelateSentence_IMPERATIVE_ImperativeSentence(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.INTERROGATIVE.InterrogativeSentence", (Handler<Message<JsonObject>>) message -> relateSentence_INTERROGATIVE_InterrogativeSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.INTERROGATIVE.InterrogativeSentence", (Handler<Message<JsonObject>>) message -> unrelateSentence_INTERROGATIVE_InterrogativeSentence(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.EXCLAMATORY.ExclamatorySentence", (Handler<Message<JsonObject>>) message -> relateSentence_EXCLAMATORY_ExclamatorySentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.EXCLAMATORY.ExclamatorySentence", (Handler<Message<JsonObject>>) message -> unrelateSentence_EXCLAMATORY_ExclamatorySentence(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.COMPLEX.ComplexSentence", (Handler<Message<JsonObject>>) message -> relateSentence_COMPLEX_ComplexSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.COMPLEX.ComplexSentence", (Handler<Message<JsonObject>>) message -> unrelateSentence_COMPLEX_ComplexSentence(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.COMPOUND.CompoundSentence", (Handler<Message<JsonObject>>) message -> relateSentence_COMPOUND_CompoundSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.COMPOUND.CompoundSentence", (Handler<Message<JsonObject>>) message -> unrelateSentence_COMPOUND_CompoundSentence(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.SIMPLE.SimpleSentence", (Handler<Message<JsonObject>>) message -> relateSentence_SIMPLE_SimpleSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.SIMPLE.SimpleSentence", (Handler<Message<JsonObject>>) message -> unrelateSentence_SIMPLE_SimpleSentence(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.COMPOUNDCOMPLEX.CompoundComplexSentence", (Handler<Message<JsonObject>>) message -> relateSentence_COMPOUNDCOMPLEX_CompoundComplexSentence(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.COMPOUNDCOMPLEX.CompoundComplexSentence", (Handler<Message<JsonObject>>) message -> unrelateSentence_COMPOUNDCOMPLEX_CompoundComplexSentence(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.PREDICATE.Predicate", (Handler<Message<JsonObject>>) message -> relateSentence_PREDICATE_Predicate(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.PREDICATE.Predicate", (Handler<Message<JsonObject>>) message -> unrelateSentence_PREDICATE_Predicate(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Sentence.CLAUSE.Clause", (Handler<Message<JsonObject>>) message -> relateSentence_CLAUSE_Clause(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Sentence.CLAUSE.Clause", (Handler<Message<JsonObject>>) message -> unrelateSentence_CLAUSE_Clause(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Predicate.VERB.Verb", (Handler<Message<JsonObject>>) message -> relatePredicate_VERB_Verb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Predicate.VERB.Verb", (Handler<Message<JsonObject>>) message -> unrelatePredicate_VERB_Verb(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Clause.SUBJECT.Subject", (Handler<Message<JsonObject>>) message -> relateClause_SUBJECT_Subject(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Clause.SUBJECT.Subject", (Handler<Message<JsonObject>>) message -> unrelateClause_SUBJECT_Subject(message));

				vertx.eventBus().consumer(deploymentID() + ".relate.Clause.VERB.Verb", (Handler<Message<JsonObject>>) message -> relateClause_VERB_Verb(message)); 
				vertx.eventBus().consumer(deploymentID() + ".unrelate.Clause.VERB.Verb", (Handler<Message<JsonObject>>) message -> unrelateClause_VERB_Verb(message));

				startFuture.complete();
			}

			@Override
			public void onFail(Throwable t) {
				log.error("EnglishGrammarDomainVerticle failed to start : ", t);
				startFuture.fail(t);
			}
		});
	}

	protected JsonObject onStart() throws Exception { return new JsonObject(); } 

	private void newAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.Aspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Aspect");

	   // todo add constraints - which properties are required for new Aspect

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.Aspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.Aspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.Aspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Aspect");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.Aspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newSimpleAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.SimpleAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "SimpleAspect");

	   // todo add constraints - which properties are required for new SimpleAspect

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateSimpleAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.SimpleAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getSimpleAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.SimpleAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listSimpleAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.SimpleAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "SimpleAspect");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeSimpleAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.SimpleAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newPerfectAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.PerfectAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "PerfectAspect");

	   // todo add constraints - which properties are required for new PerfectAspect

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updatePerfectAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.PerfectAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getPerfectAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.PerfectAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listPerfectAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.PerfectAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "PerfectAspect");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removePerfectAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.PerfectAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.ProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "ProgressiveAspect");

	   // todo add constraints - which properties are required for new ProgressiveAspect

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.ProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.ProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.ProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "ProgressiveAspect");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.ProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newPerfectProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.PerfectProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "PerfectProgressiveAspect");

	   // todo add constraints - which properties are required for new PerfectProgressiveAspect

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updatePerfectProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.PerfectProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getPerfectProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.PerfectProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listPerfectProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.PerfectProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "PerfectProgressiveAspect");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removePerfectProgressiveAspect(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.PerfectProgressiveAspect -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.Verb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Verb");

	   // todo add constraints - which properties are required for new Verb

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("regular") != null) properties.add(new JsonObject().put("name", "regular").put("value", message.body().getString("regular")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.Verb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
		if (message.body().getString("regular") != null) properties.add(new JsonObject().put("name", "regular").put("value", message.body().getString("regular")));
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.Verb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.Verb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Verb");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.Verb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.Tense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Tense");

	   // todo add constraints - which properties are required for new Tense

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.Tense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.Tense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.Tense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Tense");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.Tense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newPastTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.PastTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "PastTense");

	   // todo add constraints - which properties are required for new PastTense

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updatePastTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.PastTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getPastTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.PastTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listPastTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.PastTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "PastTense");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removePastTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.PastTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newPresentTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.PresentTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "PresentTense");

	   // todo add constraints - which properties are required for new PresentTense

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updatePresentTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.PresentTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getPresentTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.PresentTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listPresentTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.PresentTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "PresentTense");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removePresentTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.PresentTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newFutureTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.FutureTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "FutureTense");

	   // todo add constraints - which properties are required for new FutureTense

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateFutureTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.FutureTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getFutureTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.FutureTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listFutureTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.FutureTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "FutureTense");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeFutureTense(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.FutureTense -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newActionVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.ActionVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "ActionVerb");

	   // todo add constraints - which properties are required for new ActionVerb

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateActionVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.ActionVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getActionVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.ActionVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listActionVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.ActionVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "ActionVerb");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeActionVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.ActionVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newStativeVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.StativeVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "StativeVerb");

	   // todo add constraints - which properties are required for new StativeVerb

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateStativeVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.StativeVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getStativeVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.StativeVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listStativeVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.StativeVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "StativeVerb");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeStativeVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.StativeVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newTransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.TransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "TransitiveVerb");

	   // todo add constraints - which properties are required for new TransitiveVerb

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateTransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.TransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getTransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.TransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listTransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.TransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "TransitiveVerb");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeTransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.TransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newIntransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.IntransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "IntransitiveVerb");

	   // todo add constraints - which properties are required for new IntransitiveVerb

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateIntransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.IntransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getIntransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.IntransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listIntransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.IntransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "IntransitiveVerb");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeIntransitiveVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.IntransitiveVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newAuxiliaryVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.AuxiliaryVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "AuxiliaryVerb");

	   // todo add constraints - which properties are required for new AuxiliaryVerb

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateAuxiliaryVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.AuxiliaryVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getAuxiliaryVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.AuxiliaryVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listAuxiliaryVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.AuxiliaryVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "AuxiliaryVerb");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeAuxiliaryVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.AuxiliaryVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newModalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.ModalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "ModalVerb");

	   // todo add constraints - which properties are required for new ModalVerb

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateModalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.ModalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getModalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.ModalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listModalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.ModalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "ModalVerb");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeModalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.ModalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newPhrasalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.PhrasalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "PhrasalVerb");

	   // todo add constraints - which properties are required for new PhrasalVerb

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updatePhrasalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.PhrasalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getPhrasalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.PhrasalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listPhrasalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.PhrasalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "PhrasalVerb");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removePhrasalVerb(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.PhrasalVerb -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newConjugation(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.Conjugation -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Conjugation");

	   // todo add constraints - which properties are required for new Conjugation

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateConjugation(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.Conjugation -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getConjugation(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.Conjugation -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listConjugation(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.Conjugation -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Conjugation");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeConjugation(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.Conjugation -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.Sentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Sentence");

	   // todo add constraints - which properties are required for new Sentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.Sentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.Sentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.Sentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Sentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.Sentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newDeclarativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.DeclarativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "DeclarativeSentence");

	   // todo add constraints - which properties are required for new DeclarativeSentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateDeclarativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.DeclarativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getDeclarativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.DeclarativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listDeclarativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.DeclarativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "DeclarativeSentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeDeclarativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.DeclarativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newImperativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.ImperativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "ImperativeSentence");

	   // todo add constraints - which properties are required for new ImperativeSentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateImperativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.ImperativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getImperativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.ImperativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listImperativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.ImperativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "ImperativeSentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeImperativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.ImperativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newInterrogativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.InterrogativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "InterrogativeSentence");

	   // todo add constraints - which properties are required for new InterrogativeSentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateInterrogativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.InterrogativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getInterrogativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.InterrogativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listInterrogativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.InterrogativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "InterrogativeSentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeInterrogativeSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.InterrogativeSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newExclamatorySentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.ExclamatorySentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "ExclamatorySentence");

	   // todo add constraints - which properties are required for new ExclamatorySentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateExclamatorySentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.ExclamatorySentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getExclamatorySentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.ExclamatorySentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listExclamatorySentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.ExclamatorySentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "ExclamatorySentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeExclamatorySentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.ExclamatorySentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.ComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "ComplexSentence");

	   // todo add constraints - which properties are required for new ComplexSentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.ComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.ComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.ComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "ComplexSentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.ComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newCompoundSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.CompoundSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "CompoundSentence");

	   // todo add constraints - which properties are required for new CompoundSentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateCompoundSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.CompoundSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getCompoundSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.CompoundSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listCompoundSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.CompoundSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "CompoundSentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeCompoundSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.CompoundSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newSimpleSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.SimpleSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "SimpleSentence");

	   // todo add constraints - which properties are required for new SimpleSentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateSimpleSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.SimpleSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getSimpleSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.SimpleSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listSimpleSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.SimpleSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "SimpleSentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeSimpleSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.SimpleSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newCompoundComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.CompoundComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "CompoundComplexSentence");

	   // todo add constraints - which properties are required for new CompoundComplexSentence

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateCompoundComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.CompoundComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getCompoundComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.CompoundComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listCompoundComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.CompoundComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "CompoundComplexSentence");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeCompoundComplexSentence(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.CompoundComplexSentence -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newPredicate(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.Predicate -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Predicate");

	   // todo add constraints - which properties are required for new Predicate

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updatePredicate(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.Predicate -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getPredicate(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.Predicate -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listPredicate(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.Predicate -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Predicate");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removePredicate(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.Predicate -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newClause(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.Clause -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Clause");

	   // todo add constraints - which properties are required for new Clause

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateClause(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.Clause -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getClause(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.Clause -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listClause(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.Clause -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Clause");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeClause(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.Clause -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}

	private void newSubject(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> new.Subject -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "createNode");
	   request.put("label", "Subject");

	   // todo add constraints - which properties are required for new Subject

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void updateSubject(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> update.Subject -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "updateNode");
	   request.put("uuid", message.body().getString("uuid"));

	   final JsonArray properties = new JsonArray();
	   request.put("properties", properties);

	   sendNeoMessage(message, request);
	}

	private void getSubject(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> get.Subject -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "inspectNode");
	   request.put("uuid", message.body().getString("uuid"));

	   sendNeoMessage(message, request);
	}

	private void listSubject(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> list.Subject -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "listNodesByLabel");
	   request.put("label", "Subject");
	   request.put("properties", message.body().getJsonArray("properties"));

	   sendNeoMessage(message, request);
	}

	private void removeSubject(Message<JsonObject> message) {
	   log.info(deploymentID() + " -> remove.Subject -> " + message.body().toString());

	   final JsonObject request = new JsonObject();
	   request.put("action", "removeNode");
	   request.put("uuid", message.body().getString("uuid"));
	   request.put("force", message.body().getBoolean("force"));
	   request.put("cascade", message.body().getBoolean("cascade"));

	   sendNeoMessage(message, request);
	}


	protected void relateAspect_SIMPLE_SimpleAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Aspect.SIMPLE.SimpleAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLE");

		sendNeoMessage(message, request);
	}

	protected void unrelateAspect_SIMPLE_SimpleAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Aspect.SIMPLE.SimpleAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLE");

		sendNeoMessage(message, request);
	}

	protected void relateAspect_PERFECT_PerfectAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Aspect.PERFECT.PerfectAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECT");

		sendNeoMessage(message, request);
	}

	protected void unrelateAspect_PERFECT_PerfectAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Aspect.PERFECT.PerfectAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECT");

		sendNeoMessage(message, request);
	}

	protected void relateAspect_PROGRESSIVE_ProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Aspect.PROGRESSIVE.ProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PROGRESSIVE");

		sendNeoMessage(message, request);
	}

	protected void unrelateAspect_PROGRESSIVE_ProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Aspect.PROGRESSIVE.ProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PROGRESSIVE");

		sendNeoMessage(message, request);
	}

	protected void relateAspect_PERFECTPROGRESSIVE_PerfectProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Aspect.PERFECTPROGRESSIVE.PerfectProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPROGRESSIVE");

		sendNeoMessage(message, request);
	}

	protected void unrelateAspect_PERFECTPROGRESSIVE_PerfectProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Aspect.PERFECTPROGRESSIVE.PerfectProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPROGRESSIVE");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_TENSE_Tense(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.TENSE.Tense -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "TENSE");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_TENSE_Tense(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.TENSE.Tense -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "TENSE");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_ACTION_ActionVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.ACTION.ActionVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "ACTION");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_ACTION_ActionVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.ACTION.ActionVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "ACTION");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_STATIVE_StativeVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.STATIVE.StativeVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "STATIVE");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_STATIVE_StativeVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.STATIVE.StativeVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "STATIVE");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_TRANSITIVE_TransitiveVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.TRANSITIVE.TransitiveVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "TRANSITIVE");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_TRANSITIVE_TransitiveVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.TRANSITIVE.TransitiveVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "TRANSITIVE");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_INTRANSITIVE_IntransitiveVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.INTRANSITIVE.IntransitiveVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "INTRANSITIVE");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_INTRANSITIVE_IntransitiveVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.INTRANSITIVE.IntransitiveVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "INTRANSITIVE");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_AUXILIARY_AuxiliaryVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.AUXILIARY.AuxiliaryVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "AUXILIARY");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_AUXILIARY_AuxiliaryVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.AUXILIARY.AuxiliaryVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "AUXILIARY");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_MODAL_ModalVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.MODAL.ModalVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "MODAL");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_MODAL_ModalVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.MODAL.ModalVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "MODAL");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_PHRASAL_PhrasalVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.PHRASAL.PhrasalVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PHRASAL");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_PHRASAL_PhrasalVerb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.PHRASAL.PhrasalVerb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PHRASAL");

		sendNeoMessage(message, request);
	}

	protected void relateVerb_CONJUGATION_Conjugation(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Verb.CONJUGATION.Conjugation -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "CONJUGATION");

		sendNeoMessage(message, request);
	}

	protected void unrelateVerb_CONJUGATION_Conjugation(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Verb.CONJUGATION.Conjugation -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "CONJUGATION");

		sendNeoMessage(message, request);
	}

	protected void relateTense_PAST_PastTense(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Tense.PAST.PastTense -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PAST");

		sendNeoMessage(message, request);
	}

	protected void unrelateTense_PAST_PastTense(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Tense.PAST.PastTense -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PAST");

		sendNeoMessage(message, request);
	}

	protected void relateTense_PRESENT_PresentTense(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Tense.PRESENT.PresentTense -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PRESENT");

		sendNeoMessage(message, request);
	}

	protected void unrelateTense_PRESENT_PresentTense(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Tense.PRESENT.PresentTense -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PRESENT");

		sendNeoMessage(message, request);
	}

	protected void relateTense_FUTURE_FutureTense(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Tense.FUTURE.FutureTense -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "FUTURE");

		sendNeoMessage(message, request);
	}

	protected void unrelateTense_FUTURE_FutureTense(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Tense.FUTURE.FutureTense -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "FUTURE");

		sendNeoMessage(message, request);
	}

	protected void relatePastTense_SIMPLEPAST_SimpleAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.PastTense.SIMPLEPAST.SimpleAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLEPAST");

		sendNeoMessage(message, request);
	}

	protected void unrelatePastTense_SIMPLEPAST_SimpleAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.PastTense.SIMPLEPAST.SimpleAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLEPAST");

		sendNeoMessage(message, request);
	}

	protected void relatePastTense_PERFECTPAST_PerfectAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.PastTense.PERFECTPAST.PerfectAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPAST");

		sendNeoMessage(message, request);
	}

	protected void unrelatePastTense_PERFECTPAST_PerfectAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.PastTense.PERFECTPAST.PerfectAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPAST");

		sendNeoMessage(message, request);
	}

	protected void relatePastTense_PROGRESSIVEPAST_ProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.PastTense.PROGRESSIVEPAST.ProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PROGRESSIVEPAST");

		sendNeoMessage(message, request);
	}

	protected void unrelatePastTense_PROGRESSIVEPAST_ProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.PastTense.PROGRESSIVEPAST.ProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PROGRESSIVEPAST");

		sendNeoMessage(message, request);
	}

	protected void relatePastTense_PERFECTPROGRESSIVEPAST_PerfectProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.PastTense.PERFECTPROGRESSIVEPAST.PerfectProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPROGRESSIVEPAST");

		sendNeoMessage(message, request);
	}

	protected void unrelatePastTense_PERFECTPROGRESSIVEPAST_PerfectProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.PastTense.PERFECTPROGRESSIVEPAST.PerfectProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPROGRESSIVEPAST");

		sendNeoMessage(message, request);
	}

	protected void relatePresentTense_SIMPLEPRESENT_SimpleAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.PresentTense.SIMPLEPRESENT.SimpleAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLEPRESENT");

		sendNeoMessage(message, request);
	}

	protected void unrelatePresentTense_SIMPLEPRESENT_SimpleAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.PresentTense.SIMPLEPRESENT.SimpleAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLEPRESENT");

		sendNeoMessage(message, request);
	}

	protected void relatePresentTense_PROGRESSIVEPRESENT_ProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.PresentTense.PROGRESSIVEPRESENT.ProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PROGRESSIVEPRESENT");

		sendNeoMessage(message, request);
	}

	protected void unrelatePresentTense_PROGRESSIVEPRESENT_ProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.PresentTense.PROGRESSIVEPRESENT.ProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PROGRESSIVEPRESENT");

		sendNeoMessage(message, request);
	}

	protected void relatePresentTense_PERFECTPRESENT_PerfectAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.PresentTense.PERFECTPRESENT.PerfectAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPRESENT");

		sendNeoMessage(message, request);
	}

	protected void unrelatePresentTense_PERFECTPRESENT_PerfectAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.PresentTense.PERFECTPRESENT.PerfectAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPRESENT");

		sendNeoMessage(message, request);
	}

	protected void relatePresentTense_PERFECTPROGRESSIVEPRESENT_PerfectProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.PresentTense.PERFECTPROGRESSIVEPRESENT.PerfectProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPROGRESSIVEPRESENT");

		sendNeoMessage(message, request);
	}

	protected void unrelatePresentTense_PERFECTPROGRESSIVEPRESENT_PerfectProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.PresentTense.PERFECTPROGRESSIVEPRESENT.PerfectProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPROGRESSIVEPRESENT");

		sendNeoMessage(message, request);
	}

	protected void relateFutureTense_SIMPLEFUTURE_SimpleAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.FutureTense.SIMPLEFUTURE.SimpleAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLEFUTURE");

		sendNeoMessage(message, request);
	}

	protected void unrelateFutureTense_SIMPLEFUTURE_SimpleAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.FutureTense.SIMPLEFUTURE.SimpleAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLEFUTURE");

		sendNeoMessage(message, request);
	}

	protected void relateFutureTense_PERFECTFUTURE_PerfectAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.FutureTense.PERFECTFUTURE.PerfectAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTFUTURE");

		sendNeoMessage(message, request);
	}

	protected void unrelateFutureTense_PERFECTFUTURE_PerfectAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.FutureTense.PERFECTFUTURE.PerfectAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTFUTURE");

		sendNeoMessage(message, request);
	}

	protected void relateFutureTense_PROGRESSIVEFUTURE_ProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.FutureTense.PROGRESSIVEFUTURE.ProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PROGRESSIVEFUTURE");

		sendNeoMessage(message, request);
	}

	protected void unrelateFutureTense_PROGRESSIVEFUTURE_ProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.FutureTense.PROGRESSIVEFUTURE.ProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PROGRESSIVEFUTURE");

		sendNeoMessage(message, request);
	}

	protected void relateFutureTense_PERFECTPROGRESSIVEFUTURE_PerfectProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.FutureTense.PERFECTPROGRESSIVEFUTURE.PerfectProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPROGRESSIVEFUTURE");

		sendNeoMessage(message, request);
	}

	protected void unrelateFutureTense_PERFECTPROGRESSIVEFUTURE_PerfectProgressiveAspect(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.FutureTense.PERFECTPROGRESSIVEFUTURE.PerfectProgressiveAspect -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PERFECTPROGRESSIVEFUTURE");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_DECLARATIVE_DeclarativeSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.DECLARATIVE.DeclarativeSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "DECLARATIVE");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_DECLARATIVE_DeclarativeSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.DECLARATIVE.DeclarativeSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "DECLARATIVE");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_IMPERATIVE_ImperativeSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.IMPERATIVE.ImperativeSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "IMPERATIVE");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_IMPERATIVE_ImperativeSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.IMPERATIVE.ImperativeSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "IMPERATIVE");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_INTERROGATIVE_InterrogativeSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.INTERROGATIVE.InterrogativeSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "INTERROGATIVE");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_INTERROGATIVE_InterrogativeSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.INTERROGATIVE.InterrogativeSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "INTERROGATIVE");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_EXCLAMATORY_ExclamatorySentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.EXCLAMATORY.ExclamatorySentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "EXCLAMATORY");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_EXCLAMATORY_ExclamatorySentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.EXCLAMATORY.ExclamatorySentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "EXCLAMATORY");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_COMPLEX_ComplexSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.COMPLEX.ComplexSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "COMPLEX");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_COMPLEX_ComplexSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.COMPLEX.ComplexSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "COMPLEX");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_COMPOUND_CompoundSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.COMPOUND.CompoundSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "COMPOUND");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_COMPOUND_CompoundSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.COMPOUND.CompoundSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "COMPOUND");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_SIMPLE_SimpleSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.SIMPLE.SimpleSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLE");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_SIMPLE_SimpleSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.SIMPLE.SimpleSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SIMPLE");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_COMPOUNDCOMPLEX_CompoundComplexSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.COMPOUNDCOMPLEX.CompoundComplexSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "COMPOUNDCOMPLEX");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_COMPOUNDCOMPLEX_CompoundComplexSentence(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.COMPOUNDCOMPLEX.CompoundComplexSentence -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "COMPOUNDCOMPLEX");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_PREDICATE_Predicate(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.PREDICATE.Predicate -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PREDICATE");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_PREDICATE_Predicate(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.PREDICATE.Predicate -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "PREDICATE");

		sendNeoMessage(message, request);
	}

	protected void relateSentence_CLAUSE_Clause(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Sentence.CLAUSE.Clause -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "CLAUSE");

		sendNeoMessage(message, request);
	}

	protected void unrelateSentence_CLAUSE_Clause(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Sentence.CLAUSE.Clause -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "CLAUSE");

		sendNeoMessage(message, request);
	}

	protected void relatePredicate_VERB_Verb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Predicate.VERB.Verb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "VERB");

		sendNeoMessage(message, request);
	}

	protected void unrelatePredicate_VERB_Verb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Predicate.VERB.Verb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "VERB");

		sendNeoMessage(message, request);
	}

	protected void relateClause_SUBJECT_Subject(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Clause.SUBJECT.Subject -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SUBJECT");

		sendNeoMessage(message, request);
	}

	protected void unrelateClause_SUBJECT_Subject(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Clause.SUBJECT.Subject -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "SUBJECT");

		sendNeoMessage(message, request);
	}

	protected void relateClause_VERB_Verb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> relate.Clause.VERB.Verb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "relateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "VERB");

		sendNeoMessage(message, request);
	}

	protected void unrelateClause_VERB_Verb(Message<JsonObject> message) { 
		log.info(deploymentID() + " -> unrelate.Clause.VERB.Verb -> " + message.body().toString());

		final JsonObject request = new JsonObject();
	   request.put("action", "unrelateNodes");
	   request.put("src", message.body().getString("src"));
	   request.put("dst", message.body().getString("dst"));
	   request.put("relationshipType", "VERB");

		sendNeoMessage(message, request);
	}


	protected void handleInstanceMessage(Message<JsonObject> message) { log.info("instance message " + deploymentID() + " -> " + message.body().toString()); }

	protected void sendNeoMessage(Message<JsonObject> message, JsonObject request) {
		VertxUtil.sendMessage(vertx, neoAddress, request, log, new VertxUtil.SuccessHandler<Message<JsonObject>>() {
			@Override
			public void onSuccess(Message<JsonObject> result) {
				message.reply(result.body());
			}

			@Override
			public void onFail(Throwable t) {
				message.reply(VertxUtil.newFail(t.getMessage()));
			}
		});
	}
}