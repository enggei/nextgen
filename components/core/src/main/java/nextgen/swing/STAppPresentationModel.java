package nextgen.swing;

import nextgen.st.model.*;
import nextgen.utils.NeoChronicle;
import nextgen.utils.SwingUtil;
import org.neo4j.graphdb.*;

import javax.lang.model.SourceVersion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static nextgen.st.STGenerator.toSTGroup;
import static nextgen.utils.STModelUtil.findSTTemplateByName;

public class STAppPresentationModel {

   private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppPresentationModel.class);

   private static final Map<String, ImageIcon> cache = new LinkedHashMap<>();

   public final STModelDB db;
   private final NeoChronicle chronicle;
   private final STGroupModel generatorSTGroup;

   private String lastDir;
   public nextgen.st.STRenderer stRenderer;

   public STAppPresentationModel() {
      this.db = new STModelDB(AppModel.getInstance().getDbDir());
      this.chronicle = new NeoChronicle(AppModel.getInstance().getDbDir(), db.getDatabaseService());
      this.stRenderer = new nextgen.st.STRenderer();
      this.generatorSTGroup = db.getInTransaction(transaction -> db.findSTGroupModelByName("StringTemplate"));
   }

   public Action newTransactionAction(String name, Consumer<Transaction> consumer) {
      return new AbstractAction(name) {
         @Override
         public void actionPerformed(ActionEvent e) {
            doLaterInTransaction(consumer);
         }
      };
   }

   public static Optional<String> isValidTemplateName(JComponent parent, STGroupModel stGroupModel, String name) {

      if (findSTTemplateByName(stGroupModel, name).isPresent()) {
         SwingUtil.showMessage(name + " already in use in this group", parent);
         return Optional.empty();
      }

      if (name.toLowerCase().equals("eom") || name.toLowerCase().equals("gt")) {
         SwingUtil.showMessage(name + " is a reserved name", parent);
         return Optional.empty();
      }

      if (!SourceVersion.isIdentifier(name)) {
         SwingUtil.showMessage(name + " is a reserved java keyword", parent);
         return Optional.empty();
      }

      return Optional.of(name);
   }

   public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      db.doInTransaction(consumer);
   }

   public void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      SwingUtilities.invokeLater(() -> doInTransaction(consumer));
   }

   public void generateSTGroup(STGroupModel stGroupModel, boolean generateNeo) {

      final nextgen.st.parser.ParseResult parseResult = nextgen.st.STParser.parse(toSTGroup(stGroupModel));

      if (parseResult.getErrors().isEmpty()) {
         final nextgen.st.STGenerator stGenerator = new nextgen.st.STGenerator(generatorSTGroup);
         stGenerator.generateSTGroup(stGroupModel, AppModel.getInstance().getOutputPackage(), AppModel.getInstance().getOutputPath());
         if (generateNeo) stGenerator.generateNeoGroup(stGroupModel, AppModel.getInstance().getOutputPackage(), AppModel.getInstance().getOutputPath());
      } else {
         parseResult.getErrors().forEach(stgError -> log.error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError.getLine()));
      }
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

      URL resource = getClass()
            .getClassLoader()
            .getResource("icons/" + iconName + dimension + ".png");
      if (resource == null) return null;

      cache.put(iconName, new ImageIcon(Objects.requireNonNull(resource)));
      return cache.get(iconName);
   }

   public void reconcileValues() {
      final Set<Node> delete = new LinkedHashSet<>();

      db.doInTransaction(transaction ->
            db.findAllSTValue()
                  .filter(stValue -> !delete.contains(stValue.getNode()))
                  .filter(this::isValidPrimitive)
                  .forEach(stValue -> db
                        .findAllSTValueByValue(stValue.getValue())
                        .filter(duplicate -> !duplicate.getUuid().equals(stValue.getUuid()))
                        .filter(duplicate -> !delete.contains(duplicate.getNode()))
                        .filter(this::isValidPrimitive)
                        .forEach(duplicate -> {

                           log.info("\t duplicate " + duplicate.getValue());

                           final Node duplicateNode = duplicate.getNode();
                           duplicateNode.getRelationships(Direction.INCOMING)
                                 .forEach(relationship -> {
                                    final Node src = relationship.getOtherNode(duplicateNode);
                                    final Relationship newRelation = src.createRelationshipTo(stValue.getNode(), relationship.getType());
                                    relationship.getPropertyKeys().forEach(s -> newRelation.setProperty(s, relationship.getProperty(s)));
                                 });

                           delete.add(duplicateNode);
                        })));

      db.doInTransaction(transaction -> {
         for (Node node : delete) {
            node.getRelationships().forEach(Relationship::delete);
         }
      });
   }

   public boolean isValidPrimitive(STValue stValue) {
      return stValue.getType() != null &&
            stValue.getValue() != null &&
            stValue.getType().equals(STValueType.PRIMITIVE);
   }


   public String render(STModel stModel) {
      return stRenderer.render(stModel);
   }

   public String render(STModel stModel, int maxLength) {
      String s = render(stModel);
      return s.substring(0, Math.min(s.length(), maxLength));
   }

   public String render(STValue stValue) {
      return stRenderer.render(stValue);
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


   public void undoLast() {
      chronicle.rollbackLast();
   }

   public Collection<STGroupModel> getGroupModels() {
      return db.findAllSTGroupModel().collect(java.util.stream.Collectors.toList());
   }

   public Stream<STValue> findAllSTValue() {
      return db.findAllSTValue();
   }

   public nextgen.st.model.STGroupModel findSTGroup(nextgen.st.model.STTemplate model) {
      return stRenderer.findSTGroupModel(model);
   }

   public java.util.stream.Stream<nextgen.st.model.STProject> getProjects() {
      return db.findAllSTProject().sorted(java.util.Comparator.comparing(nextgen.st.model.STProject::getName));
   }

   public nextgen.st.model.STValue newSTValue(String value) {
      return db.newSTValue(value);
   }

   public java.util.Optional<nextgen.st.model.STGroupModel> findSTGroup(String name) {
      return Optional.ofNullable(db.findSTGroupModelByName(name));
   }

   public java.util.stream.Stream<nextgen.st.model.STGroupModel> getSTGroups() {
      return db.findAllSTGroupModel().sorted((g1, g2) -> g1.getName().compareToIgnoreCase(g2.getName()));
   }

   public boolean isBoolean(nextgen.st.model.STParameter model) {
      return model.getName().startsWith("is") || model.getName().startsWith("has");
   }

   public String[] getSelectedValues() {
      return new String[0];
   }

   public nextgen.st.model.STTemplate getSTTemplate(nextgen.st.model.STModel stModel) {
      return stModel.getStTemplate();
   }

   public String getOutputPath() {
      return "./components/core/src/main/java";
   }

   public String getSourceOutputPackage() {
      return "tmp";
   }

   public nextgen.st.model.STEnumValue newSTEnumValue() {
      return db.newSTEnumValue();
   }

   public nextgen.st.STGenerator getSTGenerator() {
      return new nextgen.st.STGenerator(generatorSTGroup);
   }
}