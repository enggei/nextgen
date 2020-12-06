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

         final java.util.Set<nextgen.model.STModel> delete = new java.util.LinkedHashSet<>();

         doInTransaction(transaction -> db.findAllSTTemplate().forEach(stTemplate -> {

            final java.util.Map<String, nextgen.model.STModel> modelMap = new java.util.LinkedHashMap<>();
            stTemplate.getIncomingStTemplateSTModel().forEach(stModel -> {
               final String render = render(stModel);
               if (modelMap.containsKey(render)) {
                  System.out.println("\nfound duplicate:");
                  System.out.println(render);

                  final nextgen.model.STModel keep = modelMap.get(render);

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
            for (nextgen.model.STModel stModel : delete) {
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
      provider.addCompletion(new org.fife.ui.autocomplete.ShorthandCompletion(provider, "sysout","System.out.println();", "System.out.println("));

      org.fife.ui.rsyntaxtextarea.CodeTemplateManager ctm = org.fife.ui.rsyntaxtextarea.RSyntaxTextArea.getCodeTemplateManager();
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("fb", "for (int i=0; i<", "; i++) {\n\t\n}\n"));
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("nt", "final nextgen.model.STTemplate stTemplate = appModel().db.findSTTemplateByUuid(\"", "\");"));
      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("nm", "final nextgen.model.STModel stModel = appModel().db.newSTModel().setStTemplate(stTemplate);", ""));


      return provider;
   }
}