package nextgen.swing;

import nextgen.model.*;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class STAppPresentationModel {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppPresentationModel.class);

   public final STModelDB db;

   private static final Map<String, ImageIcon> cache = new LinkedHashMap<>();

   public final nextgen.utils.NeoChronicle chronicle;
   private final STGroupModel generatorSTGroup;

   private String lastDir;
   public nextgen.st.STRenderer stRenderer;

   public STAppPresentationModel() {
      this.db = new STModelDB(AppModel.getInstance().getDbDir());
      this.chronicle = new nextgen.utils.NeoChronicle(AppModel.getInstance().getDbDir(), db.getDatabaseService());
      this.stRenderer = new nextgen.st.STRenderer();
      this.generatorSTGroup = db.getInTransaction(transaction -> db.findSTGroupModelByName("StringTemplate"));
   }

   public void addSTParameter(nextgen.model.STTemplate model, nextgen.model.parser.ParsedSTParameter parsedSTParameter) {
      final nextgen.model.STParameter stParameter = db.newSTParameter()
            .setName(parsedSTParameter.getName())
            .setArgumentType(parsedSTParameter.getArgumentType())
            .setType(parsedSTParameter.getType());

      parsedSTParameter.getKeys().forEach(stParameterKey -> stParameter.addKeys(db.newSTParameterKey()
            .setName(stParameterKey.getName())
            .setArgumentType(stParameterKey.getArgumentType())));

      model.addParameters(stParameter);
      nextgen.events.NewSTParameter.post(stParameter, model);
   }

   public void notifyIfLabel(STValue stValue) {
      stValue.getIncomingValueSTArgument().forEach(stArgument -> stArgument.getIncomingArgumentsSTModel().forEach(stModel -> notifyIfLabel(stModel, stArgument)));
   }

   public void notifyIfLabel(STModel stModel, STArgument stArgument) {
      notifyIfLabel(stModel, stArgument.getStParameter());
   }

   public void notifyIfLabel(STModel stModel, STArgumentKV stArgument) {
      notifyIfLabel(stModel, stArgument.getStParameterKey());
   }

   public void notifyIfLabel(STModel stModel, STParameterKey stParameterKey) {
      stParameterKey.getIncomingKeysSTParameter().findFirst().ifPresent(parameter -> notifyIfLabel(stModel, parameter));
   }

   public void notifyIfLabel(STModel stModel, STParameter stParameter) {
      final Optional<STTemplate> stTemplate = stParameter.getIncomingParametersSTTemplate().findFirst();
      if (stTemplate.isPresent()) {
         if (stTemplate.get().getLabelParameter() != null && stTemplate.get().getLabelParameter().equals(stParameter)) nextgen.events.STModelChanged.post(stModel);
         else if (stTemplate.get().getLabelParameter() == null && "name".equalsIgnoreCase(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
      }
   }

   public void addArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument value) {
      final nextgen.model.STValue stValue = newSTValue(value.getValue());
      final nextgen.model.STArgument stArgument = db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);

      notifyIfLabel(stModel, stParameter);
   }

   public void addArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, java.util.Collection<nextgen.model.STArgumentKV> kvs) {
      final nextgen.model.STArgument stArgument = db.newSTArgument().setStParameter(stParameter);
      for (nextgen.model.STArgumentKV kv : kvs) stArgument.addKeyValues(kv);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTKVArgument.post(stModel, stParameter, stArgument, kvs);

      notifyIfLabel(stModel, stParameter);
   }

   public void addArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STModel value) {
      addArgument(stModel, stParameter, newSTValue(value));
   }

   public void addArgument(STModel stModel, STParameter stParameter, String value) {
      addArgument(stModel, stParameter, newSTValue(value));
   }

   public void addArgument(STModel stModel, STParameter stParameter, STEnumValue stEnumValue) {
      addArgument(stModel, stParameter, newSTValue(stEnumValue));
   }

   public void addArgument(STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STTemplate value) {
      addArgument(stModel, stParameter, newSTValue(value));
   }

   public void addArgument(STModel stModel, STParameter stParameter, nextgen.model.STValue value) {
      final nextgen.model.STArgument stArgument = db.newSTArgument(stParameter, value);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, value);

      notifyIfLabel(stModel, stParameter);
   }

   public void addSTModel(nextgen.model.STProject stProject, nextgen.model.STModel stModel) {
      stProject.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, stProject, stModel.getStTemplate());
   }

   public void addSTModel(nextgen.model.STProject stProject, nextgen.model.STTemplate stTemplate) {
      final nextgen.model.STModel stModel = newSTModel(stTemplate);
      stProject.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, stProject, stModel.getStTemplate());
   }

   public void addSTFile(nextgen.model.STModel thisModel, nextgen.model.STFile otherFile) {

      final String thisName = getSTModelName(thisModel, null);

      final nextgen.model.STFile thisFile = db.newSTFile()
            .setName(newSTValue(thisName == null ? otherFile.getName() : newSTValue(thisName)))
            .setType(db.findOrCreateSTValueByValue(otherFile.getType().getValue()))
            .setPath(newSTValue(otherFile.getPath()))
            .setPackageName(newSTValue(otherFile.getPackageName()));

      thisModel.addFiles(thisFile);
      nextgen.events.NewFileSink.post(thisModel, thisFile);
   }

   public void addChild(nextgen.model.STTemplate stTemplate, String name) {
      final nextgen.model.STTemplate child = newSTTemplate(name, "");
      stTemplate.addChildren(child);
      nextgen.events.NewSTTemplateChild.post(child, stTemplate);
   }

   public void addFile(nextgen.model.STModel stModel, nextgen.model.STFile stFile) {
      stModel.addFiles(stFile);
      nextgen.events.NewFileSink.post(stModel, stFile);
   }

   public void addSTGroupFile(nextgen.model.STGroupModel stGroup) {
      final nextgen.model.STGroupFile stGroupFile = db.newSTGroupFile();
      stGroup.addFiles(stGroupFile);
      nextgen.events.NewSTGroupFile.post(stGroup, stGroupFile);
   }

   public void addSTValue(nextgen.model.STProject project, String value) {
      final nextgen.model.STValue stValue = newSTValue(value);
      project.addValues(stValue);
      nextgen.events.NewSTProjectSTValue.post(stValue, project);
   }

   public void addSTAction(nextgen.model.STGroupModel stGroup, String actionName) {
      final nextgen.model.STGroupAction stGroupAction = newSTGroupAction(actionName);
      stGroup.addActions(stGroupAction);
      nextgen.events.NewSTAction.post(stGroupAction, stGroup);
   }

   public void addSTEnum(nextgen.model.STGroupModel stGroup, String name) {
      final nextgen.model.STEnum stEnum = newSTEnum(name);
      stGroup.addEnums(stEnum);
      nextgen.events.NewSTEnum.post(stGroup, stEnum);
   }

   public void addInterface(STGroupModel stGroup, String interfaceName) {
      final nextgen.model.STInterface stInterface = newSTInterface(interfaceName);
      stGroup.addInterfaces(stInterface);
      nextgen.events.NewSTInterface.post(stGroup, stInterface);
   }

   public void addTemplate(nextgen.model.STGroupModel stGroup, String name, String text) {
      final nextgen.model.STTemplate stTemplate = newSTTemplate(name, text);
      stGroup.addTemplates(stTemplate);
      nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);
   }

   public static java.util.stream.Stream<nextgen.model.STTemplate> aggregateTemplates(nextgen.model.STGroupModel stGroup) {
      final List<STTemplate> templates = new java.util.ArrayList<>();
      stGroup.getTemplates().forEach(stTemplate -> aggregate(stTemplate, templates));
      return templates.stream().sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()));
   }

   public static void aggregate(nextgen.model.STTemplate parentTemplate, java.util.List<nextgen.model.STTemplate> templates) {
      templates.add(parentTemplate);
      parentTemplate.getChildren().forEach(childTemplate -> aggregate(childTemplate, templates));
   }

   public java.util.Set<nextgen.model.STModel> aggregateModels(nextgen.model.STProject stProject) {
      java.util.Set<nextgen.model.STModel> models = new java.util.LinkedHashSet<>();

      stProject.getModels().forEach(stModel -> {
         models.add(stModel);
         models.addAll(aggregateModels(stModel));
      });

      return models;
   }

   public java.util.Set<nextgen.model.STModel> aggregateModels(nextgen.model.STModel stModel) {
      java.util.Set<nextgen.model.STModel> models = new java.util.LinkedHashSet<>();

      stModel.getArguments().forEach(stArgument -> {
         final nextgen.model.STValue value = stArgument.getValue();
         if (value == null) return;

         if (nextgen.model.STValueType.STMODEL.equals(value.getType())) {
            final nextgen.model.STModel valueSTModel = value.getStModel();
            models.add(valueSTModel);
            models.addAll(aggregateModels(valueSTModel));
         }
      });

      return models;
   }

   public void copyInto(nextgen.model.STModel thisModel, nextgen.model.STModel otherModel) {
      final java.util.List<nextgen.model.STParameter> thisSTParameters = thisModel.getStTemplate().getParametersSorted().collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STParameter> otherSTParameters = otherModel.getStTemplate().getParametersSorted().collect(java.util.stream.Collectors.toList());

      for (nextgen.model.STParameter otherSTParameter : otherSTParameters) {
         for (nextgen.model.STParameter thisSTParameter : thisSTParameters) {
            final boolean sameParameterType = thisSTParameter.getType().equals(otherSTParameter.getType());
            final boolean sameParameterName = thisSTParameter.getName().equals(otherSTParameter.getName());
            if (sameParameterType && sameParameterName) {
               switch (otherSTParameter.getType()) {
                  case SINGLE:
                     addSTArgumentIfNotExists(otherModel, otherSTParameter, thisModel, thisSTParameter);
                     break;
                  case LIST:
                     addSTArgumentsNotAlreadyInList(otherModel, otherSTParameter, thisModel, thisSTParameter);
                     break;
                  case KVLIST:
                     addSTArgumentKVNotAlreadyInList(otherModel, otherSTParameter, thisModel, thisSTParameter);
                     break;
               }
            }
         }
      }

      final java.util.List<nextgen.model.STFile> otherModelFiles = otherModel.getFiles().collect(java.util.stream.Collectors.toList());
      final java.util.List<nextgen.model.STFile> thisFiles = thisModel.getFiles().collect(java.util.stream.Collectors.toList());

      if (thisFiles.isEmpty()) for (nextgen.model.STFile otherModelFile : otherModelFiles) addSTFile(thisModel, otherModelFile);

      nextgen.events.STModelChanged.post(thisModel);
   }

   public nextgen.model.STModel copy(nextgen.model.STModel stModel) {

      final nextgen.model.STModel copy = newSTModel(stModel.getStTemplate());

      copyInto(copy, stModel);

      final java.util.Optional<nextgen.model.STProject> stProject = findFirstSTProject(stModel);
      if (stProject.isPresent()) {
         addSTModel(stProject.get(), copy);

      } else
         nextgen.events.NewSTModel.post(copy, getSTGroup(stModel.getStTemplate()), stModel.getStTemplate());

      return copy;
   }

   public org.fife.ui.autocomplete.CompletionProvider createCompletionProvider(nextgen.model.STGroupAction stGroupAction) {
      return createCompletionProvider(stGroupAction.getIncomingActionsSTGroupModel().findFirst().get());
   }

   public org.fife.ui.autocomplete.CompletionProvider createCompletionProvider(nextgen.model.STGroupModel stGroupModel) {

      org.fife.ui.autocomplete.DefaultCompletionProvider provider = new org.fife.ui.autocomplete.DefaultCompletionProvider();

      // Add completions for all Java keywords. A BasicCompletion is just a straightforward word completion.
      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "abstract"));

      // Add a couple of "shorthand" completions. These completions don't require the input text to be the same thing as the replacement text.
      provider.addCompletion(new org.fife.ui.autocomplete.ShorthandCompletion(provider, "sysout", "log.info();", "log.info("));

      org.fife.ui.rsyntaxtextarea.CodeTemplateManager ctm = org.fife.ui.rsyntaxtextarea.RSyntaxTextArea.getCodeTemplateManager();
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("fb", "for (int i=0; i<", "; i++) {\n\t\n}\n"));
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("nt", "final nextgen.model.STTemplate stTemplate = db.findSTTemplateByUuid(\"", "\");"));
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("nm", "final nextgen.model.STModel stModel = db.newSTModel().setStTemplate(stTemplate);", ""));


      return provider;
   }

   public void deleteSTFilesFrom(java.util.List<nextgen.model.STModel> stModels) {
      for (nextgen.model.STModel stModel : stModels) {
         stModel.getFiles().forEach(stFile -> {
            final String uuid = stFile.getUuid();
            final nextgen.model.STFile found = db.findSTFileByUuid(uuid);
            if (found != null) db.delete(found.getNode());
            nextgen.events.STFileDeleted.post(uuid);
         });
      }
   }

   public void delete(nextgen.model.STEnum stEnum) {
      final String uuid = stEnum.getUuid();
      stEnum.delete();
      nextgen.events.STEnumDeleted.post(uuid);
   }

   public void delete(nextgen.model.STGroupModel stGroup) {
      final String uuid = stGroup.getUuid();
      stGroup.delete();
      nextgen.events.STGroupDeleted.post(uuid);
   }

   public void delete(nextgen.model.STGroupAction stAction) {
      final String uuid = stAction.getUuid();
      stAction.delete();
      nextgen.events.STGroupActionDeleted.post(uuid);
   }

   public void delete(nextgen.model.STFile stFile) {
      final String uuid = stFile.getUuid();
      stFile.delete();
      nextgen.events.STFileDeleted.post(uuid);
   }

   public void delete(nextgen.model.STGroupFile stgroupFile) {
      final String uuid = stgroupFile.getUuid();
      stgroupFile.delete();
      nextgen.events.STGroupFileDeleted.post(uuid);
   }

   public static void delete(nextgen.model.STArgument stArgument) {
      stArgument.getKeyValues().forEach(nextgen.model.STArgumentKV::delete);
      stArgument.delete();
   }

   public static void delete(nextgen.model.STModel stModel) {
      final String uuid = stModel.getUuid();
      stModel.delete();
      nextgen.events.STModelDeleted.post(uuid);
   }

   public static void delete(nextgen.model.STTemplate stTemplate) {
      final String uuid = stTemplate.getUuid();
      stTemplate.delete();
      nextgen.events.STTemplateDeleted.post(uuid);
   }

   public static void delete(nextgen.model.STValue stValue) {
      final String uuid = stValue.getUuid();
      stValue.delete();
      nextgen.events.STValueDeleted.post(uuid);
   }

   public static void detach(nextgen.model.STInterface stInterface, nextgen.model.STGroupModel stGroup) {
      stGroup.removeInterfaces(stInterface);
      nextgen.events.STInterfaceDeleted.post(stInterface.getUuid());
   }

   public static void detach(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument) {
      stModel.removeArguments(stArgument);
      final String uuid = stArgument.getUuid();
      delete(stArgument);
      nextgen.events.STArgumentDeleted.post(stModel, uuid);
   }

   public static void detach(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
      findAllSTArgument(stModel, stParameter).forEach(argument -> detach(stModel, argument));
   }

   private static void detach(nextgen.model.STModel stModel, STArgument stArgument, STParameterKey stParameterKey) {
      final Optional<STArgumentKV> existing = stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey)).findAny();
      if (existing.isPresent()) {
         final String uuid = existing.get().getUuid();
         stArgument.removeKeyValues(existing.get());
         existing.get().delete();
         nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
      }
   }

   public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      db.doInTransaction(consumer);
   }

   public void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      SwingUtilities.invokeLater(() -> doInTransaction(consumer));
   }

   public static java.util.Optional<nextgen.model.STParameterKey> findSTParameterKey(nextgen.model.STParameter stParameter, String kvName) {
      return stParameter
            .getKeys()
            .filter(stParameterKey -> stParameterKey.getName().equals(kvName))
            .findFirst();
   }

   public String findArgumentValue(STModel stModel, String parameterName, Supplier<String> defaultValue) {
      final Optional<STParameter> parameter = stModel.getStTemplate()
            .getParameters()
            .filter(stParameter -> stParameter.getName().equals(parameterName))
            .findFirst();
      if (parameter.isPresent()) {
         final Optional<STArgument> argument = stModel
               .getArguments()
               .filter(stArgument -> stArgument.getStParameter().equals(parameter.get()))
               .findFirst();
         if (argument.isPresent()) {
            final String render = render(argument.get().getValue());
            return render == null ? defaultValue.get() : render;
         } else {
            return defaultValue.get();
         }
      }
      return defaultValue.get();
   }

   public String findKVArgumentValue(STArgument stArgument, STParameter stParameter, String kvName, Supplier<String> defaultValue) {

      final Optional<STParameterKey> kvNameFound = findSTParameterKey(stParameter, kvName);
      if (kvNameFound.isEmpty()) return defaultValue.get();

      final Optional<STArgumentKV> found = stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(kvNameFound.get())).findFirst();
      if (found.isPresent()) {
         final String render = render(found.get().getValue());
         return render == null || render.length() == 0 ? "[EMPTY]" : render;
      }

      return defaultValue.get();
   }

   public static java.util.Optional<nextgen.model.STProject> findSTProjectFor(nextgen.model.STModel stModel) {
      final java.util.List<nextgen.model.STProject> collect = stModel.getIncomingModelsSTProject().collect(java.util.stream.Collectors.toList());
      return Optional.ofNullable(collect.size() == 0 ? null : collect.get(0));
   }

   public static java.util.Set<nextgen.model.STTemplate> findSTTemplatesWithInterface(String name, nextgen.model.STGroupModel stGroupModel) {
      final Set<STTemplate> set = new LinkedHashSet<>();
      aggregateTemplates(stGroupModel)
            .forEach(stTemplate -> stTemplate.getImplements()
                  .filter(name::equals)
                  .findFirst()
                  .ifPresent(s -> set.add(stTemplate)));
      return set;
   }

   public static nextgen.model.STEnum findSTEnumByName(String enumName, nextgen.model.STGroupModel stGroupModel) {
      return stGroupModel.getEnums().filter(stEnum -> stEnum.getName().equals(enumName)).findFirst().orElse(null);
   }

   public static java.util.Optional<nextgen.model.STTemplate> findFirstTemplateInArguments(STModel stModel, nextgen.model.STParameter stParameter) {
      return stModel.getArgumentsSorted()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .map(STArgument::getValue)
            .filter(Objects::nonNull)
            .filter(nextgen.model.STValue::hasType)
            .filter(stValue -> stValue.getType() == nextgen.model.STValueType.STMODEL)
            .map(stValue -> stValue.getStModel().getStTemplate())
            .findFirst();
   }

   public static java.util.Optional<nextgen.model.STTemplate> findSTTemplateFromArgumentType(String argumentType, nextgen.model.STGroupModel stGroupModel) {
      return aggregateTemplates(stGroupModel)
            .filter(candidate -> candidate.getName().equalsIgnoreCase(argumentType))
            .findAny();
   }

   public nextgen.model.STGroupModel findSTGroupModelByName(String name) {
      return db.findSTGroupModelByName(name);
   }

   public static java.util.Optional<nextgen.model.STArgumentKV> findSTArgumentKV(nextgen.model.STArgument otherModelArgument, nextgen.model.STParameterKey otherModelKey) {
      return otherModelArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(otherModelKey)).findAny();
   }

   public static java.util.Optional<nextgen.model.STArgument> findFirstSTArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
      return stModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(stParameter)).findFirst();
   }

   public static java.util.List<nextgen.model.STArgument> findAllSTArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
      return stModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(stParameter)).collect(java.util.stream.Collectors.toList());
   }

   private java.util.Optional<nextgen.model.STProject> findFirstSTProject(nextgen.model.STModel stModel) {

      final java.util.Optional<nextgen.model.STProject> stProject = stModel.getIncomingModelsSTProject().findAny();
      if (stProject.isPresent())
         return stProject;

      final java.util.Optional<nextgen.model.STValue> stValue = stModel.getIncomingStModelSTValue().findFirst();
      if (stValue.isPresent()) {
         final java.util.Optional<nextgen.model.STArgument> stArgument = stValue.get().getIncomingValueSTArgument().findFirst();
         if (stArgument.isPresent()) {
            final java.util.Optional<nextgen.model.STModel> parentSTModel = stArgument.get().getIncomingArgumentsSTModel().findFirst();
            if (parentSTModel.isPresent()) {
               return findFirstSTProject(parentSTModel.get());
            } else
               return Optional.empty();
         } else
            return Optional.empty();
      } else
         return Optional.empty();
   }

   public String getLastDir() {
      return lastDir == null ? System.getProperty("user.home") : lastDir;
   }

   public String getLabel(STModel stModel) {
      return getLabel(stModel, () -> "[" + stModel.getStTemplate().getName() + "]");
   }

   public String getLabel(STModel stModel, Supplier<String> defaultValue) {
      final nextgen.model.STParameter labelParameter = stModel.getStTemplate().getLabelParameter();
      return findArgumentValue(stModel, labelParameter == null ? "name" : labelParameter.getName(), defaultValue);
   }

   public String[] getFileTypes() {
      return new String[]{"html", "java", "js", "xml"};
   }

   public java.util.stream.Stream<nextgen.model.STGroupModel> getAllSTGroups() {
      return db.findAllSTGroupModel();
   }

   public String[] getAllPathTypes() {
      return db
            .findAllSTFile()
            .filter(stFile -> stFile.getPath() != null)
            .filter(stFile -> stFile.getPath().getValue() != null)
            .map(stFile -> stFile.getPath().getValue())
            .distinct()
            .toArray(String[]::new);
   }

   public java.util.List<nextgen.model.STParameterKey> getKeys(nextgen.model.STParameter stParameter) {
      return stParameter.getKeysSorted().collect(java.util.stream.Collectors.toList());
   }

   public String getSourceOutputPackage() {
      return "tmp";
   }

   public java.util.Collection<String> getLanguageTypes() {
      return Arrays.asList("text/plain",
            "text/actionscript",
            "text/asm",
            "text/bbcode",
            "text/c",
            "text/clojure",
            "text/cpp",
            "text/cs",
            "text/css",
            "text/csv",
            "text/d",
            "text/dockerfile",
            "text/dart",
            "text/delphi",
            "text/dtd",
            "text/fortran",
            "text/groovy",
            "text/hosts",
            "text/htaccess",
            "text/html",
            "text/ini",
            "text/java",
            "text/javascript",
            "text/json",
            "text/jshintrc",
            "text/jsp",
            "text/latex",
            "text/less",
            "text/lisp",
            "text/lua",
            "text/makefile",
            "text/mxml",
            "text/nsis",
            "text/perl",
            "text/php",
            "text/properties",
            "text/python",
            "text/ruby",
            "text/sas",
            "text/scala",
            "text/sql",
            "text/tcl",
            "text/typescript",
            "text/unix",
            "text/vb",
            "text/bat",
            "text/xml",
            "text/yaml");
   }

   public nextgen.model.STGroupModel getGeneratorSTGroup() {
      return generatorSTGroup;
   }

   public nextgen.model.STGroupModel getSTGroup(STModel stModel) {
      return getSTGroup(stModel.getStTemplate());
   }

   public java.util.List<nextgen.model.STModel> getModelsFor(nextgen.model.STTemplate stTemplate) {
      return stTemplate.getIncomingStTemplateSTModel().collect(java.util.stream.Collectors.toList());
   }

   public static String getSTModelName(nextgen.model.STModel stModel) {
      return getSTModelValue(stModel, "name", () -> stModel.getStTemplate().getName());
   }

   public static String getSTModelName(nextgen.model.STModel stModel, String defaultValue) {

      final nextgen.model.STTemplate stTemplate = stModel.getStTemplate();
      final boolean hasLabelParameter = stTemplate.getLabelParameter() != null;

      final java.util.Optional<nextgen.model.STParameter> foundParameter = stTemplate
            .getParameters()
            .filter(stParameter -> (hasLabelParameter && stTemplate.getLabelParameter().equals(stParameter)))
            .findAny();
      if (foundParameter.isEmpty()) return getSTModelValue(stModel, "name", defaultValue);

      return stModel
            .getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(foundParameter.get()))
            .filter(stArgument -> stArgument.getValue() != null)
            .map(stArgument -> stArgument.getValue().getValue())
            .findFirst()
            .orElse(defaultValue);
   }

   public static String getSTModelPackage(nextgen.model.STModel stModel) {
      return getSTModelPackage(stModel, "");
   }

   public static String getSTModelPackage(nextgen.model.STModel stModel, String defaultValue) {
      final String found = getSTModelValue(stModel, "package", () -> null);
      if (found != null) return found;
      return getSTModelValue(stModel, "packageName", defaultValue);
   }

   public static String getSTModelValue(nextgen.model.STModel stModel, String parameterName, Supplier<String> defaultValueSupplier) {
      final nextgen.model.STTemplate stTemplate = stModel.getStTemplate();

      final java.util.Optional<nextgen.model.STParameter> foundParameter = stTemplate
            .getParameters()
            .filter(stParameter -> stParameter.getName().equals(parameterName))
            .findAny();
      if (foundParameter.isEmpty()) return defaultValueSupplier.get();

      return stModel
            .getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(foundParameter.get()))
            .filter(stArgument -> stArgument.getValue() != null)
            .filter(stArgument -> stArgument.getValue().getValue() != null)
            .map(stArgument -> stArgument.getValue().getValue())
            .findFirst()
            .orElse(defaultValueSupplier.get());
   }

   public static String getSTModelValue(nextgen.model.STModel stModel, String parameterName, String defaultValue) {
      final nextgen.model.STTemplate stTemplate = stModel.getStTemplate();

      final java.util.Optional<nextgen.model.STParameter> foundParameter = stTemplate
            .getParameters()
            .filter(stParameter -> stParameter.getName().equals(parameterName))
            .findAny();
      if (foundParameter.isEmpty()) return defaultValue;

      return stModel
            .getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(foundParameter.get()))
            .map(stArgument -> stArgument.getValue().getValue())
            .findFirst()
            .orElse(defaultValue);
   }

   public static nextgen.model.STGroupModel getSTGroup(nextgen.model.STTemplate stTemplate) {
      final java.util.Optional<nextgen.model.STGroupModel> stGroupModel = stTemplate.getIncomingTemplatesSTGroupModel().findAny();
      if (stGroupModel.isPresent()) return stGroupModel.get();

      final java.util.Optional<nextgen.model.STTemplate> parent = stTemplate.getIncomingChildrenSTTemplate().findAny();
      return parent.map(STAppPresentationModel::getSTGroup).orElse(null);
   }

   public static boolean isBoolean(nextgen.model.STParameter stParameter) {
      return stParameter.getName().startsWith("is") || stParameter.getName().startsWith("has");
   }

   public static boolean isBoolean(nextgen.model.STParameterKey stParameterKey) {
      return stParameterKey.getName().startsWith("is") || stParameterKey.getName().startsWith("has");
   }

   public java.util.Optional<String> isValidTemplateName(javax.swing.JComponent parent, nextgen.model.STGroupModel stGroup, String name) {
      if (findSTTemplateByName(stGroup, name).isPresent()) {
         nextgen.utils.SwingUtil.showMessage(name + " already in use in this group", parent);
         return Optional.empty();
      }

      if (name.equalsIgnoreCase("eom") || name.equalsIgnoreCase("gt")) {
         nextgen.utils.SwingUtil.showMessage(name + " is a reserved name", parent);
         return Optional.empty();
      }

      if (!javax.lang.model.SourceVersion.isIdentifier(name)) {
         nextgen.utils.SwingUtil.showMessage(name + " is a reserved java keyword", parent);
         return Optional.empty();
      }

      return Optional.of(name);
   }

   private java.util.Optional<nextgen.model.STTemplate> findSTTemplateByName(nextgen.model.STGroupModel stGroup, String name) {
      return aggregateTemplates(stGroup).filter(stTemplate -> stTemplate.getName().equalsIgnoreCase(name)).findAny();
   }

   public ImageIcon loadIcon(String iconName) {
      return loadIcon(iconName, "16x16");
   }

   public ImageIcon loadIcon(String iconName, String dimension) {
      if (iconName == null) return null;
      if (cache.containsKey(iconName)) return cache.get(iconName);
      final URL resource = getClass().getClassLoader().getResource("icons/" + iconName + dimension + ".png");
      if (resource == null) return null;
      cache.put(iconName, new ImageIcon(Objects.requireNonNull(resource)));
      return cache.get(iconName);
   }

   public Action newTransactionAction(String name, Consumer<org.neo4j.graphdb.Transaction> consumer) {
      return new AbstractAction(name) {
         @Override
         public void actionPerformed(ActionEvent e) {
            doLaterInTransaction(consumer);
         }
      };
   }

   public STModel newSTModel(nextgen.model.STTemplate stTemplate) {
      return db.newSTModel().setStTemplate(stTemplate);
   }

   public nextgen.model.STValue newSTValue(STValue stValue) {
      switch (stValue.getType()) {
         case STMODEL:
            return db.newSTValue(copy(stValue.getStModel()));
         case PRIMITIVE:
            return db.newSTValue(stValue.getValue());
         case ENUM:
            return db.newSTValue(stValue.getStEnumValue());
      }
      return null;
   }

   public nextgen.model.STValue newSTValue(STModel stModel) {
      return db.newSTValue(stModel);
   }

   public nextgen.model.STValue newSTValue(nextgen.model.STEnumValue stEnumValue) {
      return db.newSTValue(stEnumValue);
   }

   public nextgen.model.STValue newSTValue(nextgen.model.STTemplate template) {
      return newSTValue(newSTModel(template));
   }

   public nextgen.model.STValue newSTValue(String value) {
      return db.newSTValue(value);
   }

   public nextgen.model.STValue newSTValue(int value) {
      return newSTValue(Integer.toString(value));
   }

   public nextgen.model.STValue newSTValue(float value) {
      return newSTValue(Float.toString(value));
   }

   public nextgen.model.STValue newSTValue(long value) {
      return newSTValue(Long.toString(value));
   }

   public nextgen.model.STValue newSTValue(byte value) {
      return newSTValue(Byte.toString(value));
   }

   public nextgen.model.STValue newSTValue(char value) {
      return newSTValue(Character.toString(value));
   }

   public nextgen.model.STValue newSTValue(boolean value) {
      return newSTValue(Boolean.toString(value));
   }

   public nextgen.model.STEnumValue newSTEnumValue(String name, String lexical) {
      return db
            .newSTEnumValue()
            .setName(name)
            .setLexical(lexical.length() == 0 ? null : lexical);
   }

   public nextgen.model.STGroupAction newSTGroupAction(String name, nextgen.model.STValue imports, nextgen.model.STValue methods, nextgen.model.STValue statements) {
      return db
            .newSTGroupAction()
            .setName(name)
            .setImports(imports)
            .setMethods(methods)
            .setStatements(statements);
   }

   public nextgen.model.STGroupAction newSTGroupAction(String name) {
      return newSTGroupAction(name, newSTValue(""), newSTValue(""), newSTValue(""));
   }

   public nextgen.model.STEnum newSTEnum(String name) {
      return db
            .newSTEnum()
            .setName(name);
   }

   private nextgen.model.STInterface newSTInterface(String name) {
      return db
            .newSTInterface()
            .setName(name);
   }

   public nextgen.model.STProject newSTProject(String name) {
      final nextgen.model.STProject stProject = db.newSTProject()
            .setName(name);
      nextgen.events.NewSTProject.post(stProject);
      return stProject;
   }

   public void newSTGroupModel(String name) {
      final nextgen.model.STGroupModel stGroupModel = db.newSTGroupModel()
            .setName(name)
            .setDelimiter(nextgen.st.STGenerator.DELIMITER);
      nextgen.events.NewSTGroup.post(stGroupModel);
   }

   public nextgen.model.STTemplate newSTTemplate(String name, String text) {
      return db.newSTTemplate().setName(name).setText(text);
   }

   public nextgen.model.STFile newSTFile(String name, String packageName, String path, String filetype) {
      return db.newSTFile()
            .setName(newSTValue(name))
            .setType(db.findOrCreateSTValueByValue(filetype))
            .setPath(newSTValue(path))
            .setPackageName(newSTValue(packageName));
   }

   public nextgen.model.STArgumentKV newSTArgumentKV(nextgen.model.STParameterKey key, nextgen.model.STValue value) {
      return db
            .newSTArgumentKV()
            .setStParameterKey(key)
            .setValue(value);
   }


   public boolean noMatch(java.util.List<nextgen.model.STArgument> stArgumentList, nextgen.model.STArgument stArgument) {
      return stArgumentList.stream().noneMatch(thisArgument -> thisArgument.getValue().equals(stArgument.getValue()));
   }

   public void reconcileDuplicateModels() {

      SwingUtilities.invokeLater(() -> {

         final java.util.Set<STModel> delete = new java.util.LinkedHashSet<>();

         doInTransaction(transaction -> db.findAllSTTemplate().forEach(stTemplate -> {

            final java.util.Map<String, STModel> modelMap = new java.util.LinkedHashMap<>();
            stTemplate.getIncomingStTemplateSTModel().forEach(stModel -> {
               final String render = render(stModel);
               if (modelMap.containsKey(render)) {
                  log.info("\nfound duplicate:");
                  log.info(render);

                  final STModel keep = modelMap.get(render);

                  stModel.getIncomingStModelSTValue()
                        .forEach(stValue -> stValue.setStModel(keep));

                  stModel.getIncomingModelsSTProject()
                        .forEach(stProject -> {
                           stProject.removeModels(stModel);
                           stProject.addModels(keep);
                        });

                  delete.add(stModel);
               } else
                  modelMap.put(render, stModel);
            });
         }));

         doInTransaction(transaction -> {
            for (STModel stModel : delete) {
               final String uuid = stModel.getUuid();
               stModel.delete();
               nextgen.events.STModelDeleted.post(uuid);
            }
         });
      });
   }

   public String render(STModel stModel) {
      return stRenderer.render(stModel);
   }

   public String render(STValue stValue) {
      return stRenderer.render(stValue);
   }

   public String render(STModel stModel, int maxLength) {
      final String s = render(stModel);
      return s.substring(0, Math.min(s.length(), maxLength));
   }

   public String render(STValue stValue, String defaultValue) {
      final String render = render(stValue);
      return render == null ? defaultValue : render;
   }

   public String render(STValue stValue, int maxLength) {
      String s = render(stValue);
      return s == null ? null : s.substring(0, Math.min(s.length(), maxLength));
   }

   public String render(STArgument stArgument) {
      return stArgument == null ? "" : render(stArgument.getValue());
   }

   public String render(STArgument stArgument, int maxLength) {
      return stArgument == null ? "" : render(stArgument.getValue(), maxLength);
   }

   public String render(STArgument stArgument, String defaultValue) {
      return stArgument == null ? defaultValue : render(stArgument.getValue(), defaultValue);
   }

   public String render(STArgumentKV stArgument) {
      return stArgument == null ? "" : render(stArgument.getValue());
   }

   public String render(STArgumentKV stArgument, int maxLength) {
      return stArgument == null ? "" : render(stArgument.getValue(), maxLength);
   }

   public String render(STArgumentKV stArgument, String defaultValue) {
      return stArgument == null ? defaultValue : render(stArgument.getValue(), defaultValue);
   }


   public void setAllModelPaths(nextgen.model.STProject stProject, String path) {
      final nextgen.model.STValue newPath = newSTValue(path);
      aggregateModels(stProject).forEach(stModel -> stModel.getFiles().forEach(stFile -> {
         stFile.setPath(newPath);
         nextgen.events.STFileChanged.post(stFile);
      }));
   }

   public void setLastDir(File dir) {
      this.lastDir = dir.getAbsolutePath();
   }

   public void setValue(nextgen.model.STValue stValue, String value) {
      stValue.removeStModel();
      stValue.setValue(value);
      stValue.setType(nextgen.model.STValueType.PRIMITIVE);
      nextgen.events.STValueChanged.post(stValue);

      stValue.getIncomingValueSTArgument().forEach(stArgument -> stArgument.getIncomingArgumentsSTModel().forEach(nextgen.events.STModelChanged::post));
   }

   public STAppPresentationModel.STArgumentConsumer stArgumentConsumer(STParameter stParameter) {
      return new STAppPresentationModel.STArgumentConsumer(stParameter);
   }

   public void setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STValue value) {
      detach(stModel, stParameter);
      addArgument(stModel, stParameter, value);
   }

   public void setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, String value) {
      if (isSameArgument(stModel, stParameter, value)) return;
      detach(stModel, stParameter);
      addArgument(stModel, stParameter, value);
   }

   public boolean isSameArgument(STModel stModel, STParameter stParameter, String value) {
      return getSTParameters(stModel)
            .filter(parameterArguments -> parameterArguments.parameter().equals(stParameter))
            .map(parameterArguments -> parameterArguments.arguments().stream().findAny())
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(STArgument::getValue)
            .filter(Objects::nonNull)
            .filter(stValue -> stValue.getType().equals(STValueType.PRIMITIVE))
            .anyMatch(stValue -> stValue.getValue().equals(value));
   }

   public void setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STEnumValue value) {
      detach(stModel, stParameter);
      addArgument(stModel, stParameter, value);
   }

   public void setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STTemplate value) {
      detach(stModel, stParameter);
      addArgument(stModel, stParameter, value);
   }

   public void setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STModel value) {
      detach(stModel, stParameter);
      addArgument(stModel, stParameter, newSTValue(value));
   }

   public void setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, boolean value) {
      detach(stModel, stParameter);
      addArgument(stModel, stParameter, Boolean.toString(value));
   }

   public void setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STValue value) {
      detach(stModel, stArgument, stParameterKey);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, value);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, value);
      notifyIfLabel(stModel, stParameterKey);
   }

   public void setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, String value) {
      detach(stModel, stArgument, stParameterKey);
      final nextgen.model.STValue stValue = newSTValue(value);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      notifyIfLabel(stModel, stParameterKey);
   }

   public void setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STEnumValue value) {
      detach(stModel, stArgument, stParameterKey);
      final nextgen.model.STValue stValue = newSTValue(value);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      notifyIfLabel(stModel, stParameterKey);
   }

   public void setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STTemplate value) {
      detach(stModel, stArgument, stParameterKey);
      final nextgen.model.STValue stValue = newSTValue(value);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      notifyIfLabel(stModel, stParameterKey);
   }

   public void setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STModel value) {
      detach(stModel, stArgument, stParameterKey);
      final nextgen.model.STValue stValue = newSTValue(value);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      notifyIfLabel(stModel, stParameterKey);
   }

   public void updateSTArgument(STModel stModel, STArgument stArgument, String value) {
      final STValue stArgumentValue = stArgument.getValue();
      if (stArgumentValue == null) {
         stArgument.setValue(newSTValue(value));
         nextgen.events.STArgumentChanged.post(stModel, stArgument);
      } else {
         switch (stArgumentValue.getType()) {
            case STMODEL:
               stArgument.setValue(newSTValue(value));
               nextgen.events.STArgumentChanged.post(stModel, stArgument);
               break;
            case PRIMITIVE:
               if (render(stArgument, "").equals(value)) return;
               stArgument.setValue(newSTValue(value));
               nextgen.events.STArgumentChanged.post(stModel, stArgument);
               notifyIfLabel(stModel, stArgument);
               break;
            case ENUM:
               stArgument.setValue(newSTValue(value));
               nextgen.events.STArgumentChanged.post(stModel, stArgument);
               break;
         }
      }
   }

   public void updateSTArgument(STModel stModel, STArgumentKV stArgument, String value) {
      final STValue stArgumentValue = stArgument.getValue();
      if (stArgumentValue == null) {
         stArgument.setValue(newSTValue(value));
         nextgen.events.STKVArgumentChanged.post(stArgument, stModel);
      } else {
         switch (stArgumentValue.getType()) {
            case STMODEL:
               stArgument.setValue(newSTValue(value));
               nextgen.events.STKVArgumentChanged.post(stArgument, stModel);
               break;
            case PRIMITIVE:
               if (render(stArgument, "").equals(value)) return;
               stArgument.setValue(newSTValue(value));
               nextgen.events.STKVArgumentChanged.post(stArgument, stModel);
               notifyIfLabel(stModel, stArgument);
               break;
            case ENUM:
               stArgument.setValue(newSTValue(value));
               nextgen.events.STKVArgumentChanged.post(stArgument, stModel);
               break;
         }
      }
   }


   private void addSTArgumentIfNotExists(STModel otherModel, nextgen.model.STParameter otherSTParameter, STModel thisModel, nextgen.model.STParameter thisSTParameter) {

      final java.util.Optional<nextgen.model.STArgument> otherSTArgument = findFirstSTArgument(otherModel, otherSTParameter);
      final java.util.Optional<nextgen.model.STArgument> thisSTArgument = findFirstSTArgument(thisModel, thisSTParameter);

      if (otherSTArgument.isPresent() && thisSTArgument.isEmpty())
         addArgument(thisModel, thisSTParameter, otherSTArgument.get());
   }

   private void addSTArgumentsNotAlreadyInList(STModel otherModel, nextgen.model.STParameter otherSTParameter, STModel thisModel, nextgen.model.STParameter thisSTParameter) {

      final java.util.List<nextgen.model.STArgument> otherSTArguments = findAllSTArgument(otherModel, otherSTParameter);
      final java.util.List<nextgen.model.STArgument> thisSTArguments = findAllSTArgument(thisModel, thisSTParameter);

      for (nextgen.model.STArgument otherModelArgument : otherSTArguments)
         if (noMatch(thisSTArguments, otherModelArgument))
            addArgument(thisModel, thisSTParameter, otherModelArgument);
   }

   private void addSTArgumentKVNotAlreadyInList(STModel otherModel, nextgen.model.STParameter otherSTParameter, STModel thisModel, nextgen.model.STParameter thisSTParameter) {

      final java.util.List<nextgen.model.STArgument> otherSTArguments = findAllSTArgument(otherModel, otherSTParameter);
      final java.util.List<nextgen.model.STArgument> thisSTArguments = findAllSTArgument(thisModel, thisSTParameter);

      for (nextgen.model.STArgument otherModelArgument : otherSTArguments) {
         if (noMatch(thisSTArguments, otherModelArgument)) {

            java.util.Collection<nextgen.model.STArgumentKV> thisKVs = new java.util.ArrayList<>();
            final java.util.List<nextgen.model.STParameterKey> otherModelKeys = getKeys(otherSTParameter);
            final java.util.List<nextgen.model.STParameterKey> thisKeys = getKeys(thisSTParameter);

            for (nextgen.model.STParameterKey otherModelKey : otherModelKeys) {
               for (nextgen.model.STParameterKey thisKey : thisKeys) {
                  final boolean sameKeyName = otherModelKey.getName().equals(thisKey.getName());
                  final boolean otherKeyTypeNull = otherModelKey.getArgumentType() == null;
                  final boolean thisKeyTypeNull = thisKey.getArgumentType() == null;
                  final boolean sameKeyType = (otherKeyTypeNull || thisKeyTypeNull) || otherModelKey.getArgumentType().equals(thisKey.getArgumentType());
                  if (sameKeyName && sameKeyType)
                     findSTArgumentKV(otherModelArgument, otherModelKey).ifPresent(stArgumentKV -> thisKVs.add(newSTArgumentKV(thisKey, newSTValue(stArgumentKV.getValue()))));
               }
            }

            if (!thisKVs.isEmpty()) addArgument(thisModel, thisSTParameter, thisKVs);
         }
      }
   }

   public nextgen.model.STArgument getArgument(nextgen.model.STParameter stParameter, nextgen.model.STModel model) {
      return model.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .findFirst()
            .orElse(null);
   }

   public void generateSTModel(nextgen.model.STModel stModel) {
      stModel.getFiles().forEach(stFile -> {
         final String content = render(stModel);
         final String packageDeclaration = stFile.getPackageName() == null ? null : stFile.getPackageName().getValue();
         final String name = stFile.getName().getValue();
         final String filetype = stFile.getType().getValue();
         final java.io.File root = new java.io.File(stFile.getPath().getValue());
         nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);
      });
   }

   public nextgen.model.STEnum getSTEnum(nextgen.model.STEnumValue stEnumValue) {
      return stEnumValue.getIncomingValuesSTEnum().findFirst().get();
   }

   public java.util.Collection<nextgen.model.STEnumValue> asCollection(nextgen.model.STEnum stEnum) {
      return stEnum.getValuesSorted().collect(java.util.stream.Collectors.toList());
   }

   public java.util.Collection<nextgen.model.STEnumValue> asCollection(nextgen.model.STEnumValue stEnumValue) {
      return asCollection(getSTEnum(stEnumValue));
   }

   public static Stream<ParameterArguments> getSTParameters(STModel model) {

      final List<ParameterArguments> result = new ArrayList<>();
      model.getStTemplate().getParametersSorted().forEach(stParameter -> {
         final ParameterArguments stModelArguments = new ParameterArguments();
         stModelArguments.setParameter(stParameter);
         model.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(stParameter)).forEach(stArgument -> stModelArguments.arguments().add(stArgument));
         result.add(stModelArguments);
      });

      return result.stream();
   }

   public void reorder(STModel model, STArgument one, STArgument two) {

      doLaterInTransaction(tx -> {

         Relationship first = null;
         Relationship second = null;
         for (Relationship relationship : model.getNode().getRelationships(Direction.OUTGOING, STModel._arguments)) {
            if (relationship.getEndNode().equals(one.getNode())) first = relationship;
            else if (relationship.getEndNode().equals(two.getNode())) second = relationship;
         }

         if (first != null && second != null && (first.hasProperty("_t") && second.hasProperty("_t"))) {
            final long firstT = (long) first.getProperty("_t");
            final long secondT = (long) second.getProperty("_t");

            second.setProperty("_t", firstT);
            first.setProperty("_t", secondT);

            nextgen.events.STModelChanged.post(model);
         }

      });
   }

   public static Comparator<STModel> grouptemplateNameComparator() {
      return (m1, m2) -> {

         final STTemplate t1 = m1.getStTemplate();
         final STTemplate t2 = m2.getStTemplate();

         final STGroupModel g1 = getSTGroup(t1);
         final STGroupModel g2 = getSTGroup(t2);

         final int groupCompare = g1.getName().compareToIgnoreCase(g2.getName());
         if (groupCompare != 0) return groupCompare;

         final int templateCompare = t1.getName().compareToIgnoreCase(m2.getStTemplate().getName());
         if (templateCompare != 0) return templateCompare;

         final String n1 = STAppPresentationModel.getSTModelName(m1, "[no name]");
         final String n2 = STAppPresentationModel.getSTModelName(m2, "[no name]");
         return n1.compareToIgnoreCase(n2);
      };
   }

   public static final class STArgumentConsumer implements java.util.function.Consumer<nextgen.model.STArgument> {

      private final nextgen.model.STParameter stParameter;

      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onSingleSTValueConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onSingleSTModelConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onSingleEnumConsumer = (stArgument, stValue) -> {
      };

      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onListSTValueConsumer = (stArgument, stValue) -> {
      };
      private java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onListSTModelConsumer = (stArgument, stValue) -> {
      };
      private final java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> onListEnumConsumer = (stArgument, stValue) -> {
      };

      private java.util.function.BiConsumer<nextgen.model.STArgument, java.util.Collection<nextgen.model.STArgumentKV>> onKVListConsumer = (stArgument, stArgumentKVS) -> {
      };
      private final java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> onKVListSTValueConsumer = (stArgumentKV, stValue) -> {

      };
      private final java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> onKVListSTModelConsumer = (stArgumentKV, stValue) -> {

      };
      private final java.util.function.BiConsumer<nextgen.model.STArgumentKV, nextgen.model.STValue> onKVListEnumConsumer = (stArgumentKV, stValue) -> {

      };

      public STArgumentConsumer(nextgen.model.STParameter stParameter) {
         this.stParameter = stParameter;
      }

      @Override
      public void accept(nextgen.model.STArgument stArgument) {
         final nextgen.model.STValue value = stArgument.getValue();
         switch (stParameter.getType()) {
            case SINGLE:
               if (value == null || value.getType() == null)
                  break;
               switch (value.getType()) {
                  case STMODEL:
                     if (value.getStModel() != null)
                        onSingleSTModelConsumer.accept(stArgument, value);
                     break;
                  case PRIMITIVE:
                     onSingleSTValueConsumer.accept(stArgument, value);
                     break;
                  case ENUM:
                     onSingleEnumConsumer.accept(stArgument, value);
                     break;
               }
               break;
            case LIST:
               if (value == null || value.getType() == null)
                  break;
               switch (value.getType()) {
                  case STMODEL:
                     if (value.getStModel() != null)
                        onListSTModelConsumer.accept(stArgument, value);
                     break;
                  case PRIMITIVE:
                     onListSTValueConsumer.accept(stArgument, value);
                     break;
                  case ENUM:
                     onListEnumConsumer.accept(stArgument, value);
                     break;
               }
               break;
            case KVLIST:

               onKVListConsumer.accept(stArgument, getStArgumentKVS(stParameter, stArgument));

               stParameter
                     .getKeys()
                     .forEach(stParameterKey -> stArgument
                           .getKeyValues()
                           .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
                           .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                           .forEach(stArgumentKV -> {
                              final nextgen.model.STValue kvValue = stArgumentKV.getValue();
                              switch (kvValue.getType()) {
                                 case STMODEL:
                                    if (kvValue.getStModel() != null)
                                       onKVListSTModelConsumer
                                             .accept(stArgumentKV, kvValue);
                                    break;
                                 case PRIMITIVE:
                                    onKVListSTValueConsumer
                                          .accept(stArgumentKV, kvValue);
                                    break;
                                 case ENUM:
                                    onKVListEnumConsumer
                                          .accept(stArgumentKV, kvValue);
                                    break;
                              }
                           }));

               break;
         }
      }

      public STArgumentConsumer onKVListConsumer(java.util.function.BiConsumer<nextgen.model.STArgument, java.util.Collection<nextgen.model.STArgumentKV>> consumer) {
         this.onKVListConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListSTModel(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onListSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListSTValue(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onListSTValueConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleSTModel(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onSingleSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleSTValue(java.util.function.BiConsumer<nextgen.model.STArgument, nextgen.model.STValue> consumer) {
         this.onSingleSTValueConsumer = consumer;
         return this;
      }

      public java.util.Collection<nextgen.model.STArgumentKV> getStArgumentKVS(nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument) {
         final java.util.Collection<nextgen.model.STArgumentKV> kvSet = new LinkedHashSet<>();
         stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey)).forEach(kvSet::add));
         return kvSet;
      }
   }
}