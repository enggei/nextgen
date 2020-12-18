package nextgen.swing;

import nextgen.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class STAppPresentationModel {

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

   public Action newTransactionAction(String name, Consumer<org.neo4j.graphdb.Transaction> consumer) {
      return new AbstractAction(name) {
         @Override
         public void actionPerformed(ActionEvent e) {
            doLaterInTransaction(consumer);
         }
      };
   }

   public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      db.doInTransaction(consumer);
   }

   public void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      SwingUtilities.invokeLater(() -> doInTransaction(consumer));
   }

   public String getLastDir() {
      return lastDir == null ? System.getProperty("user.home") : lastDir;
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
      return render(stArgument.getValue());
   }

   public void setLastDir(File dir) {
      this.lastDir = dir.getAbsolutePath();
   }

   public nextgen.utils.STModelUtil.STArgumentConsumer stArgumentConsumer(STParameter stParameter) {
      return new nextgen.utils.STModelUtil.STArgumentConsumer(stParameter);
   }

   public String tryToFindArgument(Stream<STArgumentKV> set, STParameter stParameter, String kvName, Supplier<String> defaultValue) {

      final Optional<STParameterKey> kvNameFound = stParameter
            .getKeys()
            .filter(stParameterKey -> stParameterKey.getName().equals(kvName))
            .findFirst();
      if (!kvNameFound.isPresent()) return defaultValue.get();

      final Optional<STArgumentKV> found = set.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(kvNameFound.get())).findFirst();
      if (found.isPresent()) {
         final String render = render(found.get().getValue());
         return render == null || render.length() == 0 ? "[EMPTY]" : render;
      }

      return defaultValue.get();
   }

   public String getLabel(STModel stModel) {
      return getLabel(stModel, () -> "[" + stModel.getStTemplate().getName() + "]");
   }

   public String getLabel(STModel stModel, Supplier<String> defaultValue) {
      final nextgen.model.STParameter labelParameter = stModel.getStTemplate().getLabelParameter();
      return tryToFindArgument(stModel, labelParameter == null ? "name" : labelParameter.getName(), defaultValue);
   }

   public String tryToFindArgument(STModel stModel, String parameterName, Supplier<String> defaultValue) {
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

   public String getSourceOutputPackage() {
      return "tmp";
   }

   public nextgen.model.STGroupModel getGeneratorSTGroup() {
      return generatorSTGroup;
   }

   public void reconcileDuplicateModels() {

      SwingUtilities.invokeLater(() -> {

         final java.util.Set<STModel> delete = new java.util.LinkedHashSet<>();

         doInTransaction(transaction -> db.findAllSTTemplate().forEach(stTemplate -> {

            final java.util.Map<String, STModel> modelMap = new java.util.LinkedHashMap<>();
            stTemplate.getIncomingStTemplateSTModel().forEach(stModel -> {
               final String render = render(stModel);
               if (modelMap.containsKey(render)) {
                  System.out.println("\nfound duplicate:");
                  System.out.println(render);

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

   public org.fife.ui.autocomplete.CompletionProvider createCompletionProvider(nextgen.model.STGroupAction stGroupAction) {
      return createCompletionProvider(stGroupAction.getIncomingActionsSTGroupModel().findFirst().get());
   }

   private org.fife.ui.autocomplete.CompletionProvider createCompletionProvider(nextgen.model.STGroupModel stGroupModel) {

      org.fife.ui.autocomplete.DefaultCompletionProvider provider = new org.fife.ui.autocomplete.DefaultCompletionProvider();

      // Add completions for all Java keywords. A BasicCompletion is just a straightforward word completion.
      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "abstract"));

      // Add a couple of "shorthand" completions. These completions don't require the input text to be the same thing as the replacement text.
      provider.addCompletion(new org.fife.ui.autocomplete.ShorthandCompletion(provider, "sysout", "System.out.println();", "System.out.println("));

      org.fife.ui.rsyntaxtextarea.CodeTemplateManager ctm = org.fife.ui.rsyntaxtextarea.RSyntaxTextArea.getCodeTemplateManager();
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("fb", "for (int i=0; i<", "; i++) {\n\t\n}\n"));
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("nt", "final nextgen.model.STTemplate stTemplate = db.findSTTemplateByUuid(\"", "\");"));
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("nm", "final nextgen.model.STModel stModel = db.newSTModel().setStTemplate(stTemplate);", ""));


      return provider;
   }

   public void delete(nextgen.model.STFile stFile) {
      final String uuid = stFile.getUuid();
      final nextgen.model.STFile found = db.findSTFileByUuid(uuid);
      if (found != null) db.delete(found.getNode());
      nextgen.events.STFileDeleted.post(uuid);
   }

   public nextgen.swing.STAppPresentationModel addArgument(STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STTemplate value) {
      return addArgument(stModel, stParameter, newSTValue(value));
   }

   public STAppPresentationModel addArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STModel value) {
      return addArgument(stModel, stParameter, newSTValue(value));
   }

   public STAppPresentationModel addArgument(STModel stModel, STParameter stParameter, String value) {
      return addArgument(stModel, stParameter, newSTValue(value));
   }

   public STAppPresentationModel addArgument(STModel stModel, STParameter stParameter, STEnumValue stEnumValue) {
      return addArgument(stModel, stParameter, newSTValue(stEnumValue));
   }

   public STAppPresentationModel addArgument(STModel stModel, STParameter stParameter, nextgen.model.STValue value) {
      final nextgen.model.STArgument stArgument = db.newSTArgument(stParameter, value);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, value);
      return this;
   }

   public java.util.Optional<nextgen.model.STTemplate> findFirstTemplateInArguments(STModel stModel, nextgen.model.STParameter stParameter) {
      return stModel.getArgumentsSorted()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .map(nextgen.model.STArgument::getValue)
            .filter(nextgen.model.STValue::hasType)
            .filter(stValue -> stValue.getType() == nextgen.model.STValueType.STMODEL)
            .map(stValue -> stValue.getStModel().getStTemplate())
            .findFirst();
   }

   public STModel newSTModel(nextgen.model.STTemplate stTemplate) {
      return db.newSTModel().setStTemplate(stTemplate);
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

   public java.util.Optional<nextgen.model.STTemplate> findSTTemplateFromArgumentType(String argumentType, nextgen.model.STGroupModel stGroupModel) {
      return nextgen.utils.STModelUtil
            .aggregateTemplates(stGroupModel)
            .filter(candidate -> candidate.getName().equalsIgnoreCase(argumentType))
            .findAny();
   }

   public nextgen.model.STGroupModel getSTGroup(STModel stModel) {
      return nextgen.utils.STModelUtil.getSTGroup(stModel);
   }

   public java.util.List<nextgen.model.STModel> getModelsFor(nextgen.model.STTemplate stTemplate) {
      return stTemplate.getIncomingStTemplateSTModel().collect(java.util.stream.Collectors.toList());
   }

   public java.util.Set<nextgen.model.STTemplate> findSTTemplatesWithInterface(String interfaceName, nextgen.model.STGroupModel stGroupModel) {
      return  nextgen.utils.STModelUtil.findSTTemplatesByInterface(interfaceName, stGroupModel);
   }

   public nextgen.model.STEnum findSTEnumByName(String enumName, nextgen.model.STGroupModel stGroupModel) {
      return stGroupModel.getEnums().filter(stEnum -> stEnum.getName().equals(enumName)).findFirst().orElse(null);
   }

   public java.util.Optional<String> isValidTemplateName(javax.swing.JComponent owner, nextgen.model.STGroupModel stGroup, String name) {
      return nextgen.utils.STModelUtil.isValidTemplateName(owner, stGroup, name);
   }

   public nextgen.swing.STAppPresentationModel addChild(nextgen.model.STTemplate stTemplate, String name) {
      final nextgen.model.STTemplate child = newSTTemplate(name, "");
      stTemplate.addChildren(child);
      nextgen.events.NewSTTemplateChild.post(child, stTemplate);
      return this;
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

   public nextgen.swing.STAppPresentationModel addFile(nextgen.model.STModel stModel, String name, String packageName, String path, String filetype) {
      final nextgen.model.STFile stFile = newSTFile(name, packageName, path, filetype);
      stModel.addFiles(stFile);
      nextgen.events.NewFileSink.post(stModel, stFile);
      return this;
   }

   public nextgen.swing.STAppPresentationModel addGroupFileTo(nextgen.model.STGroupModel stGroup) {
      final nextgen.model.STGroupFile stGroupFile = db.newSTGroupFile();
      stGroup.addFiles(stGroupFile);
      nextgen.events.NewSTGroupFile.post(stGroup, stGroupFile);
      return this;
   }

   public String[] getFileTypes() {
      return new String[]{"html", "java", "js", "xml"};
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

   public nextgen.model.STArgumentKV newSTArgumentKV(nextgen.model.STParameterKey key, nextgen.model.STValue value) {
      return db
            .newSTArgumentKV()
            .setStParameterKey(key)
            .setValue(value);
   }

   public STAppPresentationModel addArgument(java.util.Collection<nextgen.model.STArgumentKV> kvs, STParameterKey stParameterKey, String value) {
      kvs.add(newSTArgumentKV(stParameterKey, newSTValue(value)));
      return this;
   }

   public STAppPresentationModel addArgument(java.util.Collection<nextgen.model.STArgumentKV> kvs, STParameterKey stParameterKey, STValue value) {
      kvs.add(newSTArgumentKV(stParameterKey, value));
      return this;
   }

   public STAppPresentationModel addArgument(java.util.Collection<nextgen.model.STArgumentKV> kvs, STParameterKey stParameterKey, STArgumentKV value) {
      return addArgument(kvs, stParameterKey, db.newSTValue(value.getValue()));
   }

   public nextgen.swing.STAppPresentationModel addArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument value) {
      final nextgen.model.STValue stValue = db.newSTValue(value.getValue());
      final nextgen.model.STArgument stArgument = db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
      return this;
   }

   public nextgen.swing.STAppPresentationModel addArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, java.util.Collection<nextgen.model.STArgumentKV> kvs) {
      final nextgen.model.STArgument stArgument = db.newSTArgument().setStParameter(stParameter);
      for (nextgen.model.STArgumentKV kv : kvs) stArgument.addKeyValues(kv);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTKVArgument.post(stModel, stParameter, stArgument, kvs);
      return this;
   }

   public void addModel(nextgen.model.STProject project, nextgen.model.STTemplate stTemplate) {
      final nextgen.model.STModel stModel = newSTModel(stTemplate);
      project.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, project, stTemplate);
   }

   public nextgen.swing.STAppPresentationModel addSTFile(nextgen.model.STModel thisModel, nextgen.model.STFile sourceFile) {
      final nextgen.model.STFile thisFile = db.newSTFile(sourceFile);
      final String thisName = nextgen.utils.STModelUtil.getSTModelName(thisModel, null);
      if (thisName != null) thisFile.setName(newSTValue(thisName));
      thisModel.addFiles(thisFile);
      nextgen.events.NewFileSink.post(thisModel, thisFile);
      return this;
   }

   public java.util.Optional<nextgen.model.STArgument> findFirstSTArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
      return stModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(stParameter)).findFirst();
   }

   public java.util.List<nextgen.model.STArgument> findAllSTArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
      return stModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(stParameter)).collect(java.util.stream.Collectors.toList());
   }

   public boolean noMatch(java.util.List<nextgen.model.STArgument> stArgumentList, nextgen.model.STArgument stArgument) {
      return stArgumentList.stream().noneMatch(thisArgument -> thisArgument.getValue().equals(stArgument.getValue()));
   }

   public java.util.List<nextgen.model.STParameterKey> getKeys(nextgen.model.STParameter stParameter) {
      return stParameter.getKeysSorted().collect(java.util.stream.Collectors.toList());
   }

   public java.util.Optional<nextgen.model.STArgumentKV> findSTArgumentKV(nextgen.model.STArgument otherModelArgument, nextgen.model.STParameterKey otherModelKey) {
      return otherModelArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(otherModelKey)).findAny();
   }

   public void addSTArgumentIfNotExists(STModel otherModel, nextgen.model.STParameter otherSTParameter, STModel thisModel, nextgen.model.STParameter thisSTParameter) {

      final java.util.Optional<nextgen.model.STArgument> otherSTArgument = findFirstSTArgument(otherModel, otherSTParameter);
      final java.util.Optional<nextgen.model.STArgument> thisSTArgument = findFirstSTArgument(thisModel, thisSTParameter);

      if (otherSTArgument.isPresent() && !thisSTArgument.isPresent())
         addArgument(thisModel, thisSTParameter, otherSTArgument.get());
   }

   public void addSTArgumentsNotAlreadyInList(STModel otherModel, nextgen.model.STParameter otherSTParameter, STModel thisModel, nextgen.model.STParameter thisSTParameter) {

      final java.util.List<nextgen.model.STArgument> otherSTArguments = findAllSTArgument(otherModel, otherSTParameter);
      final java.util.List<nextgen.model.STArgument> thisSTArguments = findAllSTArgument(thisModel, thisSTParameter);

      for (nextgen.model.STArgument otherModelArgument : otherSTArguments)
         if (noMatch(thisSTArguments, otherModelArgument))
            addArgument(thisModel, thisSTParameter, otherModelArgument);
   }

   public void addSTArgumentKVNotAlreadyInList(STModel otherModel, nextgen.model.STParameter otherSTParameter, STModel thisModel, nextgen.model.STParameter thisSTParameter) {

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
                  final boolean sameKeyType = otherModelKey.getArgumentType().equals(thisKey.getArgumentType());
                  if (sameKeyName && sameKeyType)
                     findSTArgumentKV(otherModelArgument, otherModelKey).ifPresent(stArgumentKV -> addArgument(thisKVs, thisKey, stArgumentKV));
               }
            }

            if (!thisKVs.isEmpty()) addArgument(thisModel, thisSTParameter, thisKVs);
         }
      }
   }

   public nextgen.swing.STAppPresentationModel copyInto(nextgen.model.STModel thisModel, nextgen.model.STModel otherModel) {
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
      return this;
   }

   public nextgen.swing.STAppPresentationModel copy(nextgen.model.STModel stModel) {

      final nextgen.model.STModel copy = newSTModel(stModel.getStTemplate());

      copyInto(copy, stModel);

      final java.util.Optional<nextgen.model.STProject> stProject = findFirstSTProject(stModel);
      if (stProject.isPresent()) {
         addSTModel(stProject.get(), copy);

      } else
         nextgen.events.NewSTModel.post(copy, nextgen.utils.STModelUtil.getSTGroup(stModel.getStTemplate()), stModel.getStTemplate());
      return this;
   }

   private nextgen.swing.STAppPresentationModel addSTModel(nextgen.model.STProject stProject, nextgen.model.STModel stModel) {
      stProject.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, stProject, stModel.getStTemplate());
      return this;
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

   public nextgen.swing.STAppPresentationModel deleteSTFilesFrom(java.util.List<nextgen.model.STModel> stModels) {
      for (nextgen.model.STModel stModel : stModels) {
         stModel.getFiles().forEach(stFile -> {
            final String uuid = stFile.getUuid();
            final nextgen.model.STFile found = db.findSTFileByUuid(uuid);
            if (found != null) db.delete(found.getNode());
            nextgen.events.STFileDeleted.post(uuid);
         });
      }
      return this;
   }

   public nextgen.swing.STAppPresentationModel delete(nextgen.model.STGroupModel stGroup) {
      final String uuid = stGroup.getUuid();
      stGroup.delete();
      nextgen.events.STGroupDeleted.post(uuid);
      return this;
   }

   public nextgen.swing.STAppPresentationModel delete(nextgen.model.STGroupFile stgroupFile) {
      final String uuid = stgroupFile.getUuid();
      stgroupFile.delete();
      nextgen.events.STGroupFileDeleted.post(uuid);
      return this;
   }

   public nextgen.swing.STAppPresentationModel delete(nextgen.model.STArgument stArgument) {
      stArgument.getKeyValues().forEach(nextgen.model.STArgumentKV::delete);
      stArgument.delete();
      return this;
   }

   public nextgen.swing.STAppPresentationModel delete(nextgen.model.STModel stModel) {
      final String uuid = stModel.getUuid();
      stModel.delete();
      nextgen.events.STModelDeleted.post(uuid);
      return this;
   }

   public nextgen.swing.STAppPresentationModel delete(nextgen.model.STTemplate stTemplate) {
      final String uuid = stTemplate.getUuid();
      stTemplate.delete();
      nextgen.events.STTemplateDeleted.post(uuid);
      return this;
   }

   public nextgen.swing.STAppPresentationModel delete(nextgen.model.STValue stValue) {
      final String uuid = stValue.getUuid();
      stValue.delete();
      nextgen.events.STValueDeleted.post(uuid);
      return this;
   }

   public nextgen.model.STEnumValue newSTEnumValue(String name, String lexical) {
      return db
            .newSTEnumValue()
            .setName(name)
            .setLexical(lexical.length() == 0 ? null : lexical);
   }

   public nextgen.swing.STAppPresentationModel generateAll(nextgen.model.STProject project) {
      project.getModels().forEach(stModel ->
            stModel.getFiles().forEach(stFile -> {
               final String content = render(stModel);
               final String packageDeclaration = stFile.getPackageName().getValue();
               final String name = stFile.getName().getValue();
               final String filetype = stFile.getType().getValue();
               final java.io.File root = new java.io.File(stFile.getPath().getValue());
               nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);
            }));
      return this;
   }

   public java.util.stream.Stream<nextgen.model.STGroupModel> getAllSTGroups() {
      return db.findAllSTGroupModel();
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

   public nextgen.swing.STAppPresentationModel addAction(nextgen.model.STGroupModel stGroup, String actionName) {
      final nextgen.model.STGroupAction stGroupAction = newSTGroupAction(actionName);
      stGroup.addActions(stGroupAction);
      nextgen.events.NewSTAction.post(stGroupAction, stGroup);
      return this;
   }

   public nextgen.swing.STAppPresentationModel addEnum(STGroupModel stGroup, String name) {
      final nextgen.model.STEnum stEnum = newSTEnum(name);
      stGroup.addEnums(stEnum);
      nextgen.events.NewSTEnum.post(stGroup, stEnum);
      return this;
   }

   public nextgen.swing.STAppPresentationModel addInterface(STGroupModel stGroup, String interfaceName) {
      final nextgen.model.STInterface stInterface = newSTInterface(interfaceName);
      stGroup.addInterfaces(stInterface);
      nextgen.events.NewSTInterface.post(stGroup, stInterface);
      return this;
   }

   public nextgen.swing.STAppPresentationModel addTemplate(nextgen.model.STGroupModel stGroup, String name, String text) {
      final nextgen.model.STTemplate stTemplate = newSTTemplate(name, "");
      stGroup.addTemplates(stTemplate);
      nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);
      return this;
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

   public nextgen.swing.STAppPresentationModel newSTGroupModel(String name) {
      final nextgen.model.STGroupModel stGroupModel = db.newSTGroupModel()
            .setName(name)
            .setDelimiter(nextgen.st.STGenerator.DELIMITER);
      nextgen.events.NewSTGroup.post(stGroupModel);
      return this;
   }

   public nextgen.model.STGroupModel findSTGroupModelByName(String name) {
      return db.findSTGroupModelByName(name);
   }

   public void removeExisting(STModel stModel, STParameter stParameter) {
      findFirstSTArgument(stModel, stParameter).ifPresent(stArgument -> detach(stModel, stArgument));
   }

   public nextgen.swing.STAppPresentationModel detach(nextgen.model.STInterface stInterface, nextgen.model.STGroupModel stGroup) {
      stGroup.removeInterfaces(stInterface);
      nextgen.events.STInterfaceDeleted.post(stInterface.getUuid());
      return this;
   }

   public nextgen.swing.STAppPresentationModel detach(STModel stModel, nextgen.model.STArgument stArgument) {
      stModel.removeArguments(stArgument);
      final String uuid = stArgument.getUuid();
      delete(stArgument);
      nextgen.events.STArgumentDeleted.post(stModel, uuid);
      return this;
   }


   public nextgen.swing.STAppPresentationModel detach(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
      findAllSTArgument(stModel, stParameter).forEach(argument -> detach(stModel, argument));
      return this;
   }

   public nextgen.swing.STAppPresentationModel setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STValue value) {
      detach(stModel, stParameter);
      addArgument(stModel, stParameter, value);
      return this;
   }

   public nextgen.swing.STAppPresentationModel setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, String value) {
      detach(stModel, stParameter);
      return addArgument(stModel, stParameter, value);
   }

   public nextgen.swing.STAppPresentationModel setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STEnumValue value) {
      detach(stModel, stParameter);
      return addArgument(stModel, stParameter, value);
   }

   public nextgen.swing.STAppPresentationModel setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STTemplate value) {
      detach(stModel, stParameter);
      return addArgument(stModel, stParameter, value);
   }

   public nextgen.swing.STAppPresentationModel setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STModel value) {
      detach(stModel, stParameter);
      return addArgument(stModel, stParameter, newSTValue(value));
   }

   public nextgen.swing.STAppPresentationModel setArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, boolean value) {
      detach(stModel, stParameter);
      return addArgument(stModel, stParameter, Boolean.toString(value));
   }

   public nextgen.swing.STAppPresentationModel setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STValue value) {
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, value);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, value);
      if ("name".equals(stParameterKey.getName())) nextgen.events.STModelChanged.post(stModel);
      return this;
   }

   public nextgen.swing.STAppPresentationModel setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, String value) {
      final nextgen.model.STValue stValue = newSTValue(value);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      if ("name".equals(stParameterKey.getName())) nextgen.events.STModelChanged.post(stModel);
      return this;
   }

   public nextgen.swing.STAppPresentationModel setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STEnumValue value) {
      final nextgen.model.STValue stValue = newSTValue(value);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      if ("name".equals(stParameterKey.getName())) nextgen.events.STModelChanged.post(stModel);
      return null;
   }

   public nextgen.swing.STAppPresentationModel setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STTemplate value) {
      final nextgen.model.STValue stValue = newSTValue(value);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      if ("name".equals(stParameterKey.getName())) nextgen.events.STModelChanged.post(stModel);
      return null;
   }

   public nextgen.swing.STAppPresentationModel setArgumentKV(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STModel value) {
      final nextgen.model.STValue stValue = newSTValue(value);
      final nextgen.model.STArgumentKV stArgumentKV = newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      if ("name".equals(stParameterKey.getName())) nextgen.events.STModelChanged.post(stModel);
      return null;
   }

   public java.util.stream.Stream<nextgen.model.STTemplate> aggregateTemplates(nextgen.model.STGroupModel stGroup) {
      return nextgen.utils.STModelUtil.aggregateTemplates(stGroup);
   }

   public java.util.Optional<nextgen.model.STProject> findSTProjectFor(nextgen.model.STModel stModel) {
      return nextgen.utils.STModelUtil.findSTProjectFor(stModel);
   }

   public String getSTModelName(nextgen.model.STModel stModel, String defaultValue) {
      return nextgen.utils.STModelUtil.getSTModelName(stModel, defaultValue);
   }

   public String getSTModelPackage(nextgen.model.STModel stModel, String defaultValue) {
      return nextgen.utils.STModelUtil.getSTModelPackage(stModel, defaultValue);
   }

   public nextgen.model.STGroupModel getSTGroup(nextgen.model.STTemplate stTemplate) {
      return nextgen.utils.STModelUtil.getSTGroup(stTemplate);
   }

   public java.util.Set<nextgen.model.STModel> aggregateModels(nextgen.model.STProject stProject) {
      return nextgen.utils.STModelUtil.aggregateModels(stProject);
   }

   public boolean isBoolean(nextgen.model.STParameter stParameter) {
      return nextgen.utils.STModelUtil.isBoolean(stParameter);
   }

   public nextgen.swing.STAppPresentationModel setValue(nextgen.model.STValue stValue, String value) {
      stValue.removeStModel();
      stValue.setValue(nextgen.utils.SwingUtil.fromClipboard());
      stValue.setType(nextgen.model.STValueType.PRIMITIVE);
      nextgen.events.STValueChanged.post(stValue);

      stValue.getIncomingValueSTArgument().forEach(stArgument -> stArgument.getIncomingArgumentsSTModel().forEach(nextgen.events.STModelChanged::post));
      return this;
   }
}