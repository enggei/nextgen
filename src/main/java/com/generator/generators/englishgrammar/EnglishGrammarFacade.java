package com.generator.generators.englishgrammar;

import com.generator.util.VertxUtil;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetSocket;

/**
 * EnglishGrammar- Facade
 */
public class EnglishGrammarFacade {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EnglishGrammarFacade.class);

   private final String address;
   private final String replyAddress;
   private final NetSocket socket;

   public EnglishGrammarFacade(String address, String replyAddress, NetSocket socket) {
      this.address = address;
      this.replyAddress = replyAddress;
      this.socket = socket;
   }

	public void newAspect() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.Aspect", replyAddress, parameters, socket);
	}

	public void updateAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.Aspect", replyAddress, parameters, socket);
	}

	public void getAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.Aspect", replyAddress, parameters, socket);
	}

	public void listAspects(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.Aspect", replyAddress, parameters, socket);
	}

	public void removeAspect(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.Aspect", replyAddress, parameter, socket);
	}

	public void newSimpleAspect() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.SimpleAspect", replyAddress, parameters, socket);
	}

	public void updateSimpleAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.SimpleAspect", replyAddress, parameters, socket);
	}

	public void getSimpleAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.SimpleAspect", replyAddress, parameters, socket);
	}

	public void listSimpleAspects(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.SimpleAspect", replyAddress, parameters, socket);
	}

	public void removeSimpleAspect(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.SimpleAspect", replyAddress, parameter, socket);
	}

	public void newPerfectAspect() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.PerfectAspect", replyAddress, parameters, socket);
	}

	public void updatePerfectAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.PerfectAspect", replyAddress, parameters, socket);
	}

	public void getPerfectAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.PerfectAspect", replyAddress, parameters, socket);
	}

	public void listPerfectAspects(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.PerfectAspect", replyAddress, parameters, socket);
	}

	public void removePerfectAspect(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.PerfectAspect", replyAddress, parameter, socket);
	}

	public void newProgressiveAspect() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.ProgressiveAspect", replyAddress, parameters, socket);
	}

	public void updateProgressiveAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.ProgressiveAspect", replyAddress, parameters, socket);
	}

	public void getProgressiveAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.ProgressiveAspect", replyAddress, parameters, socket);
	}

	public void listProgressiveAspects(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.ProgressiveAspect", replyAddress, parameters, socket);
	}

	public void removeProgressiveAspect(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.ProgressiveAspect", replyAddress, parameter, socket);
	}

	public void newPerfectProgressiveAspect() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.PerfectProgressiveAspect", replyAddress, parameters, socket);
	}

	public void updatePerfectProgressiveAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.PerfectProgressiveAspect", replyAddress, parameters, socket);
	}

	public void getPerfectProgressiveAspect(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.PerfectProgressiveAspect", replyAddress, parameters, socket);
	}

	public void listPerfectProgressiveAspects(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.PerfectProgressiveAspect", replyAddress, parameters, socket);
	}

	public void removePerfectProgressiveAspect(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.PerfectProgressiveAspect", replyAddress, parameter, socket);
	}

	public void newVerb(String regular) {

	   final JsonObject parameters = new JsonObject().
				put("regular", regular);

	   VertxUtil.sendFrame(log, address + ".new.Verb", replyAddress, parameters, socket);
	}

	public void updateVerb(String uuid, String regular) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid).
				put("regular", regular);

	   VertxUtil.sendFrame(log, address + ".update.Verb", replyAddress, parameters, socket);
	}

	public void getVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.Verb", replyAddress, parameters, socket);
	}

	public void listVerbs(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.Verb", replyAddress, parameters, socket);
	}

	public void removeVerb(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.Verb", replyAddress, parameter, socket);
	}

	public void newTense() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.Tense", replyAddress, parameters, socket);
	}

	public void updateTense(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.Tense", replyAddress, parameters, socket);
	}

	public void getTense(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.Tense", replyAddress, parameters, socket);
	}

	public void listTenses(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.Tense", replyAddress, parameters, socket);
	}

	public void removeTense(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.Tense", replyAddress, parameter, socket);
	}

	public void newPastTense() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.PastTense", replyAddress, parameters, socket);
	}

	public void updatePastTense(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.PastTense", replyAddress, parameters, socket);
	}

	public void getPastTense(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.PastTense", replyAddress, parameters, socket);
	}

	public void listPastTenses(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.PastTense", replyAddress, parameters, socket);
	}

	public void removePastTense(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.PastTense", replyAddress, parameter, socket);
	}

	public void newPresentTense() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.PresentTense", replyAddress, parameters, socket);
	}

	public void updatePresentTense(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.PresentTense", replyAddress, parameters, socket);
	}

	public void getPresentTense(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.PresentTense", replyAddress, parameters, socket);
	}

	public void listPresentTenses(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.PresentTense", replyAddress, parameters, socket);
	}

	public void removePresentTense(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.PresentTense", replyAddress, parameter, socket);
	}

	public void newFutureTense() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.FutureTense", replyAddress, parameters, socket);
	}

	public void updateFutureTense(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.FutureTense", replyAddress, parameters, socket);
	}

	public void getFutureTense(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.FutureTense", replyAddress, parameters, socket);
	}

	public void listFutureTenses(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.FutureTense", replyAddress, parameters, socket);
	}

	public void removeFutureTense(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.FutureTense", replyAddress, parameter, socket);
	}

	public void newActionVerb() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.ActionVerb", replyAddress, parameters, socket);
	}

	public void updateActionVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.ActionVerb", replyAddress, parameters, socket);
	}

	public void getActionVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.ActionVerb", replyAddress, parameters, socket);
	}

	public void listActionVerbs(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.ActionVerb", replyAddress, parameters, socket);
	}

	public void removeActionVerb(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.ActionVerb", replyAddress, parameter, socket);
	}

	public void newStativeVerb() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.StativeVerb", replyAddress, parameters, socket);
	}

	public void updateStativeVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.StativeVerb", replyAddress, parameters, socket);
	}

	public void getStativeVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.StativeVerb", replyAddress, parameters, socket);
	}

	public void listStativeVerbs(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.StativeVerb", replyAddress, parameters, socket);
	}

	public void removeStativeVerb(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.StativeVerb", replyAddress, parameter, socket);
	}

	public void newTransitiveVerb() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.TransitiveVerb", replyAddress, parameters, socket);
	}

	public void updateTransitiveVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.TransitiveVerb", replyAddress, parameters, socket);
	}

	public void getTransitiveVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.TransitiveVerb", replyAddress, parameters, socket);
	}

	public void listTransitiveVerbs(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.TransitiveVerb", replyAddress, parameters, socket);
	}

	public void removeTransitiveVerb(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.TransitiveVerb", replyAddress, parameter, socket);
	}

	public void newIntransitiveVerb() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.IntransitiveVerb", replyAddress, parameters, socket);
	}

	public void updateIntransitiveVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.IntransitiveVerb", replyAddress, parameters, socket);
	}

	public void getIntransitiveVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.IntransitiveVerb", replyAddress, parameters, socket);
	}

	public void listIntransitiveVerbs(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.IntransitiveVerb", replyAddress, parameters, socket);
	}

	public void removeIntransitiveVerb(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.IntransitiveVerb", replyAddress, parameter, socket);
	}

	public void newAuxiliaryVerb() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.AuxiliaryVerb", replyAddress, parameters, socket);
	}

	public void updateAuxiliaryVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.AuxiliaryVerb", replyAddress, parameters, socket);
	}

	public void getAuxiliaryVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.AuxiliaryVerb", replyAddress, parameters, socket);
	}

	public void listAuxiliaryVerbs(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.AuxiliaryVerb", replyAddress, parameters, socket);
	}

	public void removeAuxiliaryVerb(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.AuxiliaryVerb", replyAddress, parameter, socket);
	}

	public void newModalVerb() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.ModalVerb", replyAddress, parameters, socket);
	}

	public void updateModalVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.ModalVerb", replyAddress, parameters, socket);
	}

	public void getModalVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.ModalVerb", replyAddress, parameters, socket);
	}

	public void listModalVerbs(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.ModalVerb", replyAddress, parameters, socket);
	}

	public void removeModalVerb(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.ModalVerb", replyAddress, parameter, socket);
	}

	public void newPhrasalVerb() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.PhrasalVerb", replyAddress, parameters, socket);
	}

	public void updatePhrasalVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.PhrasalVerb", replyAddress, parameters, socket);
	}

	public void getPhrasalVerb(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.PhrasalVerb", replyAddress, parameters, socket);
	}

	public void listPhrasalVerbs(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.PhrasalVerb", replyAddress, parameters, socket);
	}

	public void removePhrasalVerb(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.PhrasalVerb", replyAddress, parameter, socket);
	}

	public void newConjugation() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.Conjugation", replyAddress, parameters, socket);
	}

	public void updateConjugation(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.Conjugation", replyAddress, parameters, socket);
	}

	public void getConjugation(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.Conjugation", replyAddress, parameters, socket);
	}

	public void listConjugations(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.Conjugation", replyAddress, parameters, socket);
	}

	public void removeConjugation(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.Conjugation", replyAddress, parameter, socket);
	}

	public void newSentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.Sentence", replyAddress, parameters, socket);
	}

	public void updateSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.Sentence", replyAddress, parameters, socket);
	}

	public void getSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.Sentence", replyAddress, parameters, socket);
	}

	public void listSentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.Sentence", replyAddress, parameters, socket);
	}

	public void removeSentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.Sentence", replyAddress, parameter, socket);
	}

	public void newDeclarativeSentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.DeclarativeSentence", replyAddress, parameters, socket);
	}

	public void updateDeclarativeSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.DeclarativeSentence", replyAddress, parameters, socket);
	}

	public void getDeclarativeSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.DeclarativeSentence", replyAddress, parameters, socket);
	}

	public void listDeclarativeSentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.DeclarativeSentence", replyAddress, parameters, socket);
	}

	public void removeDeclarativeSentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.DeclarativeSentence", replyAddress, parameter, socket);
	}

	public void newImperativeSentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.ImperativeSentence", replyAddress, parameters, socket);
	}

	public void updateImperativeSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.ImperativeSentence", replyAddress, parameters, socket);
	}

	public void getImperativeSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.ImperativeSentence", replyAddress, parameters, socket);
	}

	public void listImperativeSentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.ImperativeSentence", replyAddress, parameters, socket);
	}

	public void removeImperativeSentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.ImperativeSentence", replyAddress, parameter, socket);
	}

	public void newInterrogativeSentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.InterrogativeSentence", replyAddress, parameters, socket);
	}

	public void updateInterrogativeSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.InterrogativeSentence", replyAddress, parameters, socket);
	}

	public void getInterrogativeSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.InterrogativeSentence", replyAddress, parameters, socket);
	}

	public void listInterrogativeSentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.InterrogativeSentence", replyAddress, parameters, socket);
	}

	public void removeInterrogativeSentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.InterrogativeSentence", replyAddress, parameter, socket);
	}

	public void newExclamatorySentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.ExclamatorySentence", replyAddress, parameters, socket);
	}

	public void updateExclamatorySentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.ExclamatorySentence", replyAddress, parameters, socket);
	}

	public void getExclamatorySentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.ExclamatorySentence", replyAddress, parameters, socket);
	}

	public void listExclamatorySentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.ExclamatorySentence", replyAddress, parameters, socket);
	}

	public void removeExclamatorySentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.ExclamatorySentence", replyAddress, parameter, socket);
	}

	public void newComplexSentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.ComplexSentence", replyAddress, parameters, socket);
	}

	public void updateComplexSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.ComplexSentence", replyAddress, parameters, socket);
	}

	public void getComplexSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.ComplexSentence", replyAddress, parameters, socket);
	}

	public void listComplexSentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.ComplexSentence", replyAddress, parameters, socket);
	}

	public void removeComplexSentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.ComplexSentence", replyAddress, parameter, socket);
	}

	public void newCompoundSentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.CompoundSentence", replyAddress, parameters, socket);
	}

	public void updateCompoundSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.CompoundSentence", replyAddress, parameters, socket);
	}

	public void getCompoundSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.CompoundSentence", replyAddress, parameters, socket);
	}

	public void listCompoundSentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.CompoundSentence", replyAddress, parameters, socket);
	}

	public void removeCompoundSentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.CompoundSentence", replyAddress, parameter, socket);
	}

	public void newSimpleSentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.SimpleSentence", replyAddress, parameters, socket);
	}

	public void updateSimpleSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.SimpleSentence", replyAddress, parameters, socket);
	}

	public void getSimpleSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.SimpleSentence", replyAddress, parameters, socket);
	}

	public void listSimpleSentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.SimpleSentence", replyAddress, parameters, socket);
	}

	public void removeSimpleSentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.SimpleSentence", replyAddress, parameter, socket);
	}

	public void newCompoundComplexSentence() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.CompoundComplexSentence", replyAddress, parameters, socket);
	}

	public void updateCompoundComplexSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.CompoundComplexSentence", replyAddress, parameters, socket);
	}

	public void getCompoundComplexSentence(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.CompoundComplexSentence", replyAddress, parameters, socket);
	}

	public void listCompoundComplexSentences(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.CompoundComplexSentence", replyAddress, parameters, socket);
	}

	public void removeCompoundComplexSentence(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.CompoundComplexSentence", replyAddress, parameter, socket);
	}

	public void newPredicate() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.Predicate", replyAddress, parameters, socket);
	}

	public void updatePredicate(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.Predicate", replyAddress, parameters, socket);
	}

	public void getPredicate(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.Predicate", replyAddress, parameters, socket);
	}

	public void listPredicates(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.Predicate", replyAddress, parameters, socket);
	}

	public void removePredicate(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.Predicate", replyAddress, parameter, socket);
	}

	public void newClause() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.Clause", replyAddress, parameters, socket);
	}

	public void updateClause(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.Clause", replyAddress, parameters, socket);
	}

	public void getClause(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.Clause", replyAddress, parameters, socket);
	}

	public void listClauses(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.Clause", replyAddress, parameters, socket);
	}

	public void removeClause(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.Clause", replyAddress, parameter, socket);
	}

	public void newSubject() {

	   final JsonObject parameters = new JsonObject();

	   VertxUtil.sendFrame(log, address + ".new.Subject", replyAddress, parameters, socket);
	}

	public void updateSubject(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".update.Subject", replyAddress, parameters, socket);
	}

	public void getSubject(String uuid) {

	   final JsonObject parameters = new JsonObject().
	         put("uuid", uuid);

	   VertxUtil.sendFrame(log, address + ".get.Subject", replyAddress, parameters, socket);
	}

	public void listSubjects(String... properties) {

	   final JsonObject parameters = new JsonObject();

	   final JsonArray propertiesParameter = new JsonArray();
	   for (String property : properties) propertiesParameter.add(property);
	   parameters.put("properties", propertiesParameter);

	   VertxUtil.sendFrame(log, address + ".list.Subject", replyAddress, parameters, socket);
	}

	public void removeSubject(String uuid, boolean force, boolean cascade) {
	   final JsonObject parameter = new JsonObject().
	         put("uuid", uuid).
	         put("force", force).
	         put("cascade", cascade);

	   VertxUtil.sendFrame(log, address + ".remove.Subject", replyAddress, parameter, socket);
	}


   public void relateAspect_SIMPLE_SimpleAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Aspect.SIMPLE.SimpleAspect", replyAddress, parameters, socket);
   }

   public void unrelateAspect_SIMPLE_SimpleAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Aspect.SIMPLE.SimpleAspect", replyAddress, parameters, socket);
   }

   public void relateAspect_PERFECT_PerfectAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Aspect.PERFECT.PerfectAspect", replyAddress, parameters, socket);
   }

   public void unrelateAspect_PERFECT_PerfectAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Aspect.PERFECT.PerfectAspect", replyAddress, parameters, socket);
   }

   public void relateAspect_PROGRESSIVE_ProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Aspect.PROGRESSIVE.ProgressiveAspect", replyAddress, parameters, socket);
   }

   public void unrelateAspect_PROGRESSIVE_ProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Aspect.PROGRESSIVE.ProgressiveAspect", replyAddress, parameters, socket);
   }

   public void relateAspect_PERFECTPROGRESSIVE_PerfectProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Aspect.PERFECTPROGRESSIVE.PerfectProgressiveAspect", replyAddress, parameters, socket);
   }

   public void unrelateAspect_PERFECTPROGRESSIVE_PerfectProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Aspect.PERFECTPROGRESSIVE.PerfectProgressiveAspect", replyAddress, parameters, socket);
   }

   public void relateVerb_TENSE_Tense(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.TENSE.Tense", replyAddress, parameters, socket);
   }

   public void unrelateVerb_TENSE_Tense(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.TENSE.Tense", replyAddress, parameters, socket);
   }

   public void relateVerb_ACTION_ActionVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.ACTION.ActionVerb", replyAddress, parameters, socket);
   }

   public void unrelateVerb_ACTION_ActionVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.ACTION.ActionVerb", replyAddress, parameters, socket);
   }

   public void relateVerb_STATIVE_StativeVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.STATIVE.StativeVerb", replyAddress, parameters, socket);
   }

   public void unrelateVerb_STATIVE_StativeVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.STATIVE.StativeVerb", replyAddress, parameters, socket);
   }

   public void relateVerb_TRANSITIVE_TransitiveVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.TRANSITIVE.TransitiveVerb", replyAddress, parameters, socket);
   }

   public void unrelateVerb_TRANSITIVE_TransitiveVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.TRANSITIVE.TransitiveVerb", replyAddress, parameters, socket);
   }

   public void relateVerb_INTRANSITIVE_IntransitiveVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.INTRANSITIVE.IntransitiveVerb", replyAddress, parameters, socket);
   }

   public void unrelateVerb_INTRANSITIVE_IntransitiveVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.INTRANSITIVE.IntransitiveVerb", replyAddress, parameters, socket);
   }

   public void relateVerb_AUXILIARY_AuxiliaryVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.AUXILIARY.AuxiliaryVerb", replyAddress, parameters, socket);
   }

   public void unrelateVerb_AUXILIARY_AuxiliaryVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.AUXILIARY.AuxiliaryVerb", replyAddress, parameters, socket);
   }

   public void relateVerb_MODAL_ModalVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.MODAL.ModalVerb", replyAddress, parameters, socket);
   }

   public void unrelateVerb_MODAL_ModalVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.MODAL.ModalVerb", replyAddress, parameters, socket);
   }

   public void relateVerb_PHRASAL_PhrasalVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.PHRASAL.PhrasalVerb", replyAddress, parameters, socket);
   }

   public void unrelateVerb_PHRASAL_PhrasalVerb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.PHRASAL.PhrasalVerb", replyAddress, parameters, socket);
   }

   public void relateVerb_CONJUGATION_Conjugation(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Verb.CONJUGATION.Conjugation", replyAddress, parameters, socket);
   }

   public void unrelateVerb_CONJUGATION_Conjugation(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Verb.CONJUGATION.Conjugation", replyAddress, parameters, socket);
   }

   public void relateTense_PAST_PastTense(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Tense.PAST.PastTense", replyAddress, parameters, socket);
   }

   public void unrelateTense_PAST_PastTense(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Tense.PAST.PastTense", replyAddress, parameters, socket);
   }

   public void relateTense_PRESENT_PresentTense(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Tense.PRESENT.PresentTense", replyAddress, parameters, socket);
   }

   public void unrelateTense_PRESENT_PresentTense(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Tense.PRESENT.PresentTense", replyAddress, parameters, socket);
   }

   public void relateTense_FUTURE_FutureTense(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Tense.FUTURE.FutureTense", replyAddress, parameters, socket);
   }

   public void unrelateTense_FUTURE_FutureTense(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Tense.FUTURE.FutureTense", replyAddress, parameters, socket);
   }

   public void relatePastTense_SIMPLEPAST_SimpleAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.PastTense.SIMPLEPAST.SimpleAspect", replyAddress, parameters, socket);
   }

   public void unrelatePastTense_SIMPLEPAST_SimpleAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.PastTense.SIMPLEPAST.SimpleAspect", replyAddress, parameters, socket);
   }

   public void relatePastTense_PERFECTPAST_PerfectAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.PastTense.PERFECTPAST.PerfectAspect", replyAddress, parameters, socket);
   }

   public void unrelatePastTense_PERFECTPAST_PerfectAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.PastTense.PERFECTPAST.PerfectAspect", replyAddress, parameters, socket);
   }

   public void relatePastTense_PROGRESSIVEPAST_ProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.PastTense.PROGRESSIVEPAST.ProgressiveAspect", replyAddress, parameters, socket);
   }

   public void unrelatePastTense_PROGRESSIVEPAST_ProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.PastTense.PROGRESSIVEPAST.ProgressiveAspect", replyAddress, parameters, socket);
   }

   public void relatePastTense_PERFECTPROGRESSIVEPAST_PerfectProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.PastTense.PERFECTPROGRESSIVEPAST.PerfectProgressiveAspect", replyAddress, parameters, socket);
   }

   public void unrelatePastTense_PERFECTPROGRESSIVEPAST_PerfectProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.PastTense.PERFECTPROGRESSIVEPAST.PerfectProgressiveAspect", replyAddress, parameters, socket);
   }

   public void relatePresentTense_SIMPLEPRESENT_SimpleAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.PresentTense.SIMPLEPRESENT.SimpleAspect", replyAddress, parameters, socket);
   }

   public void unrelatePresentTense_SIMPLEPRESENT_SimpleAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.PresentTense.SIMPLEPRESENT.SimpleAspect", replyAddress, parameters, socket);
   }

   public void relatePresentTense_PROGRESSIVEPRESENT_ProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.PresentTense.PROGRESSIVEPRESENT.ProgressiveAspect", replyAddress, parameters, socket);
   }

   public void unrelatePresentTense_PROGRESSIVEPRESENT_ProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.PresentTense.PROGRESSIVEPRESENT.ProgressiveAspect", replyAddress, parameters, socket);
   }

   public void relatePresentTense_PERFECTPRESENT_PerfectAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.PresentTense.PERFECTPRESENT.PerfectAspect", replyAddress, parameters, socket);
   }

   public void unrelatePresentTense_PERFECTPRESENT_PerfectAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.PresentTense.PERFECTPRESENT.PerfectAspect", replyAddress, parameters, socket);
   }

   public void relatePresentTense_PERFECTPROGRESSIVEPRESENT_PerfectProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.PresentTense.PERFECTPROGRESSIVEPRESENT.PerfectProgressiveAspect", replyAddress, parameters, socket);
   }

   public void unrelatePresentTense_PERFECTPROGRESSIVEPRESENT_PerfectProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.PresentTense.PERFECTPROGRESSIVEPRESENT.PerfectProgressiveAspect", replyAddress, parameters, socket);
   }

   public void relateFutureTense_SIMPLEFUTURE_SimpleAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.FutureTense.SIMPLEFUTURE.SimpleAspect", replyAddress, parameters, socket);
   }

   public void unrelateFutureTense_SIMPLEFUTURE_SimpleAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.FutureTense.SIMPLEFUTURE.SimpleAspect", replyAddress, parameters, socket);
   }

   public void relateFutureTense_PERFECTFUTURE_PerfectAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.FutureTense.PERFECTFUTURE.PerfectAspect", replyAddress, parameters, socket);
   }

   public void unrelateFutureTense_PERFECTFUTURE_PerfectAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.FutureTense.PERFECTFUTURE.PerfectAspect", replyAddress, parameters, socket);
   }

   public void relateFutureTense_PROGRESSIVEFUTURE_ProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.FutureTense.PROGRESSIVEFUTURE.ProgressiveAspect", replyAddress, parameters, socket);
   }

   public void unrelateFutureTense_PROGRESSIVEFUTURE_ProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.FutureTense.PROGRESSIVEFUTURE.ProgressiveAspect", replyAddress, parameters, socket);
   }

   public void relateFutureTense_PERFECTPROGRESSIVEFUTURE_PerfectProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.FutureTense.PERFECTPROGRESSIVEFUTURE.PerfectProgressiveAspect", replyAddress, parameters, socket);
   }

   public void unrelateFutureTense_PERFECTPROGRESSIVEFUTURE_PerfectProgressiveAspect(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.FutureTense.PERFECTPROGRESSIVEFUTURE.PerfectProgressiveAspect", replyAddress, parameters, socket);
   }

   public void relateSentence_DECLARATIVE_DeclarativeSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.DECLARATIVE.DeclarativeSentence", replyAddress, parameters, socket);
   }

   public void unrelateSentence_DECLARATIVE_DeclarativeSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.DECLARATIVE.DeclarativeSentence", replyAddress, parameters, socket);
   }

   public void relateSentence_IMPERATIVE_ImperativeSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.IMPERATIVE.ImperativeSentence", replyAddress, parameters, socket);
   }

   public void unrelateSentence_IMPERATIVE_ImperativeSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.IMPERATIVE.ImperativeSentence", replyAddress, parameters, socket);
   }

   public void relateSentence_INTERROGATIVE_InterrogativeSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.INTERROGATIVE.InterrogativeSentence", replyAddress, parameters, socket);
   }

   public void unrelateSentence_INTERROGATIVE_InterrogativeSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.INTERROGATIVE.InterrogativeSentence", replyAddress, parameters, socket);
   }

   public void relateSentence_EXCLAMATORY_ExclamatorySentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.EXCLAMATORY.ExclamatorySentence", replyAddress, parameters, socket);
   }

   public void unrelateSentence_EXCLAMATORY_ExclamatorySentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.EXCLAMATORY.ExclamatorySentence", replyAddress, parameters, socket);
   }

   public void relateSentence_COMPLEX_ComplexSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.COMPLEX.ComplexSentence", replyAddress, parameters, socket);
   }

   public void unrelateSentence_COMPLEX_ComplexSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.COMPLEX.ComplexSentence", replyAddress, parameters, socket);
   }

   public void relateSentence_COMPOUND_CompoundSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.COMPOUND.CompoundSentence", replyAddress, parameters, socket);
   }

   public void unrelateSentence_COMPOUND_CompoundSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.COMPOUND.CompoundSentence", replyAddress, parameters, socket);
   }

   public void relateSentence_SIMPLE_SimpleSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.SIMPLE.SimpleSentence", replyAddress, parameters, socket);
   }

   public void unrelateSentence_SIMPLE_SimpleSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.SIMPLE.SimpleSentence", replyAddress, parameters, socket);
   }

   public void relateSentence_COMPOUNDCOMPLEX_CompoundComplexSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.COMPOUNDCOMPLEX.CompoundComplexSentence", replyAddress, parameters, socket);
   }

   public void unrelateSentence_COMPOUNDCOMPLEX_CompoundComplexSentence(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.COMPOUNDCOMPLEX.CompoundComplexSentence", replyAddress, parameters, socket);
   }

   public void relateSentence_PREDICATE_Predicate(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.PREDICATE.Predicate", replyAddress, parameters, socket);
   }

   public void unrelateSentence_PREDICATE_Predicate(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.PREDICATE.Predicate", replyAddress, parameters, socket);
   }

   public void relateSentence_CLAUSE_Clause(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Sentence.CLAUSE.Clause", replyAddress, parameters, socket);
   }

   public void unrelateSentence_CLAUSE_Clause(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Sentence.CLAUSE.Clause", replyAddress, parameters, socket);
   }

   public void relatePredicate_VERB_Verb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Predicate.VERB.Verb", replyAddress, parameters, socket);
   }

   public void unrelatePredicate_VERB_Verb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Predicate.VERB.Verb", replyAddress, parameters, socket);
   }

   public void relateClause_SUBJECT_Subject(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Clause.SUBJECT.Subject", replyAddress, parameters, socket);
   }

   public void unrelateClause_SUBJECT_Subject(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Clause.SUBJECT.Subject", replyAddress, parameters, socket);
   }

   public void relateClause_VERB_Verb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".relate.Clause.VERB.Verb", replyAddress, parameters, socket);
   }

   public void unrelateClause_VERB_Verb(String src, String dst) {

      final JsonObject parameters = new JsonObject().
            put("src", src).
            put("dst", dst);

      VertxUtil.sendFrame(log, address + ".unrelate.Clause.VERB.Verb", replyAddress, parameters, socket);
   }

}