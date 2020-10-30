package nextgen.st;

import nextgen.st.domain.*;
import nextgen.st.model.*;
import nextgen.swing.AppModel;
import nextgen.utils.NeoChronicle;
import nextgen.utils.SwingUtil;
import nextgen.workflow.WorkFlowFacade;
import org.javatuples.Pair;
import org.neo4j.graphdb.*;

import javax.lang.model.SourceVersion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static nextgen.st.STGenerator.toSTGroup;
import static nextgen.utils.STModelUtil.findSTTemplateByName;

public class STAppPresentationModel {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppPresentationModel.class);
   private static final Map<String, ImageIcon> cache = new LinkedHashMap<>();
   public final STRenderer stRenderer;
   public final STModelDB db;

   final Set<STGroupModel> stGroups = new java.util.TreeSet<>((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
   final STGroupModel generatorSTGroup;

   private final NeoChronicle chronicle;
   private STWorkspace stWorkspace;
   private String lastDir;
   private final WorkFlowFacade workFlowFacade;

   public STAppPresentationModel() throws IOException {

      Arrays.stream(Objects.requireNonNull(new File(AppModel.getInstance().getTemplateDir()).listFiles(file -> file.getName().endsWith(".json"))))
            .forEach(file -> {
               try {
                  stGroups.add(new STGroupModel(file));
               } catch (IOException e) {
                  System.out.println("Could not read stgroup file " + file.getAbsolutePath());
               }
            });

      this.generatorSTGroup = new STGroupModel(new File(AppModel.getInstance().getTemplateDir(), "StringTemplate.json"));
      this.stRenderer = new STRenderer(stGroups);
      this.db = new STModelDB(AppModel.getInstance().getDbDir(), stGroups);
      this.workFlowFacade = new WorkFlowFacade(db.getDatabaseService());
      this.chronicle = new NeoChronicle(AppModel.getInstance().getDbDir(), db.getDatabaseService());
   }

   public static Action newAction(String name, Consumer<ActionEvent> consumer) {
      return new AbstractAction(name) {
         @Override
         public void actionPerformed(ActionEvent e) {
            consumer.accept(e);
         }
      };
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


   public static void deleteSTGFile(String name) {
      final File stgFile = new File(AppModel
            .getInstance()
            .getTemplateDir(), name + ".json");
      if (stgFile.exists())
         stgFile.renameTo(new File(AppModel
               .getInstance()
               .getTemplateDir(), name + ".json.deleted"));
   }

   public String cut(String text) {
      return cut(text, 50);
   }

   public String cut(String text, int max) {
      return text == null ? "[EMPTY]" : text.substring(0, Math.min(text.length(), max));
   }

   public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      db.doInTransaction(consumer);
   }

   public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer, java.util.function.Consumer<Throwable> throwableConsumer) {
      db.doInTransaction(consumer, throwableConsumer);
   }

   public void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      SwingUtilities.invokeLater(() -> doInTransaction(consumer));
   }

   public void doLaterInTransaction(PropertyChangeEvent evt, String type, java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
      SwingUtilities.invokeLater(() -> {
         if (type.equals(evt
               .getPropertyName()
               .split("\\.")[0]))
            doInTransaction(consumer);
      });
   }

   public STTemplate findSTTemplateByUuid(String stTemplate) {
      return db.findSTTemplateByUuid(stTemplate);
   }

   public void forEachArgument(STTemplate stTemplate, STModel stModel, java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.domain.STParameter> consumer) {
      stTemplate
            .getParameters()
            .forEach(stParameter -> stModel
                  .getArgumentsSorted()
                  .filter(stArgument -> stArgument
                        .getStParameter()
                        .equals(stParameter.getUuid()))
                  .forEach(stArgument -> consumer.accept(stArgument, stParameter)));
   }

   public void generateSTGroup(STGroupModel stGroupModel, boolean generateNeo) {

      final STGParseResult parseResult = STParser.parse(toSTGroup(stGroupModel));

      if (parseResult.getErrors().count() == 0) {
         final STGenerator stGenerator = new STGenerator(generatorSTGroup);
         stGroups.stream()
               .filter(stGroupModel1 -> stGroupModel1.getUuid().equals(stGroupModel.getUuid()))
               .findFirst()
               .ifPresent(directory -> {
                  stGenerator.generateSTGroup(stGroupModel, AppModel.getInstance().getOutputPackage(), AppModel.getInstance().getOutputPath());
                  if (generateNeo) stGenerator.generateNeoGroup(stGroupModel, AppModel.getInstance().getOutputPackage(), AppModel.getInstance().getOutputPath());
               });
      } else {
         parseResult.getErrors().forEach(stgError -> log.error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError.getLine()));
      }
   }

   public void delete(nextgen.st.domain.STGroupModel stGroup) {
      stGroups.remove(stGroup);
      deleteSTGFile(stGroup.getName());
   }

   public <T> T getInTransaction(java.util.function.Function<org.neo4j.graphdb.Transaction, T> action) {
      return db.getInTransaction(action);
   }

   public Stream<STArgumentKV> getIncomingSTArgumentKVs(STValue stValue) {
      final org.neo4j.graphdb.Node node = stValue.getNode();
      return java.util.stream.StreamSupport
            .stream(node
                  .getRelationships(org.neo4j.graphdb.Direction.INCOMING)
                  .spliterator(), false)
            .map(relationship -> relationship.getOtherNode(node))
            .filter(STModelNeoFactory::isSTArgumentKV)
            .map(db::newSTArgumentKV);
   }

   public Stream<STArgumentKV> getIncomingSTArgumentKVs(STModel stValue) {
      final org.neo4j.graphdb.Node node = stValue.getNode();
      return java.util.stream.StreamSupport
            .stream(node
                  .getRelationships(org.neo4j.graphdb.Direction.INCOMING)
                  .spliterator(), false)
            .map(relationship -> relationship.getOtherNode(node))
            .filter(STModelNeoFactory::isSTArgumentKV)
            .map(db::newSTArgumentKV);
   }

   public Stream<STArgument> getIncomingSTArguments(STValue stValue) {
      final org.neo4j.graphdb.Node node = stValue.getNode();
      return java.util.stream.StreamSupport
            .stream(node
                  .getRelationships(org.neo4j.graphdb.Direction.INCOMING)
                  .spliterator(), false)
            .map(relationship -> relationship.getOtherNode(node))
            .filter(STModelNeoFactory::isSTArgument)
            .map(db::newSTArgument);
   }

   public Stream<STArgument> getIncomingSTArguments(STModel stValue) {
      final org.neo4j.graphdb.Node node = stValue.getNode();
      return java.util.stream.StreamSupport
            .stream(node
                  .getRelationships(org.neo4j.graphdb.Direction.INCOMING)
                  .spliterator(), false)
            .map(relationship -> relationship.getOtherNode(node))
            .filter(STModelNeoFactory::isSTArgument)
            .map(db::newSTArgument);
   }

   public String getLastDir() {
      return lastDir == null ? System.getProperty("user.home") : lastDir;
   }

   public Optional<STModel> getSTModel(STValue stValue) {
      return stValue
            .getType()
            .equals(nextgen.st.model.STValueType.STMODEL) ? Optional.of(stValue.getStModel()) : Optional
            .empty();
   }

   public String getSTModelName(STModel stModel, String defaultName) {
      return db.getSTModelName(stModel, defaultName);
   }

   public String getSTModelPackage(STModel stModel, String defaultName) {
      return db.getSTModelPackage(stModel, defaultName);
   }

   public STWorkspace getWorkspace() {
      if (stWorkspace == null) stWorkspace = new STWorkspace();
      return stWorkspace;
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

   public Pair<STArgument, STValue> newSTArgument(STModel stModel, STParameter stParameter, String value) {
      final nextgen.st.model.STValue stValue = db.newSTValue(value);
      final nextgen.st.model.STArgument stArgument = newSTArgument(stModel, stParameter, stValue);
      return new Pair<>(stArgument, stValue);
   }

   public Pair<STArgument, STValue> newSTArgument(STModel stModel, STParameter stParameter, STModel value) {
      final nextgen.st.model.STValue stValue = db.newSTValue(value);
      final nextgen.st.model.STArgument stArgument = newSTArgument(stModel, stParameter, stValue);
      return new Pair<>(stArgument, stValue);
   }

   public STArgument newSTArgument(STModel stModel, STParameter stParameter, STValue value) {
      final nextgen.st.model.STArgument stArgument = db.newSTArgument(stParameter, value);
      stModel.addArguments(stArgument);
      return stArgument;
   }

   public STArgument newSTArgument(STModel stModel, STParameter stParameter, List<STArgumentKV> kvs) {
      final nextgen.st.model.STArgument stArgument = db.newSTArgument(stParameter, kvs);
      stModel.addArguments(stArgument);
      return stArgument;
   }

   public STArgumentKV newSTArgumentKV(STParameterKey stParameterKey, STValue stValue) {
      return db.newSTArgumentKV(stParameterKey, stValue);
   }

   public STEnum newSTEnum(String name) {
      return STJsonFactory.newSTEnum().setName(name);
   }

   public STFile newSTFile(String name, String type, String path, String packageName) {
      return db.newSTFile(name, type, path, packageName);
   }

   public STFile newSTFile(Node node) {
      return db.newSTFile(node);
   }

   public STGroupModel newSTGroupModel(String name) {
      final nextgen.st.domain.STGroupModel stGroupModel = nextgen.st.domain.STJsonFactory.newSTGroupModel()
            .setName(name)
            .setDelimiter(nextgen.st.STGenerator.DELIMITER);
      stGroups.add(stGroupModel);
      stRenderer.addGroupModel(stGroupModel);
      return stGroupModel;
   }

   public STInterface newSTInterface(String name) {
      return STJsonFactory.newSTInterface().setName(name);
   }

   public STModel newSTModel(Node node) {
      return db.newSTModel(node);
   }

   public nextgen.st.model.STValue newSTValue(Node node) {
      return db.newSTValue(node);
   }

   public STModel newSTModel(STTemplate stTemplate) {
      return newSTModel(findSTGroup(stTemplate), stTemplate);
   }

   public void newSTModel(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STProject project) {
      final nextgen.st.model.STModel stModel = newSTModel(stTemplate);
      project.addModels(stModel);
   }

   public STModel newSTModel(STGroupModel stGroupModel, STTemplate stTemplate) {
      final nextgen.st.model.STModel stModel = db.newSTModel(stGroupModel, stTemplate);
      return stModel;
   }

   public STModel newSTModel(STGroupModel stGroupModel, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STProject stProject) {
      final nextgen.st.model.STModel stModel = db.newSTModel(stGroupModel, stTemplate);
      stProject.addModels(stModel);
      return stModel;
   }

   public nextgen.st.domain.STTemplate newSTTemplate(String name, String text, nextgen.st.domain.STGroupModel parent) {
      final nextgen.st.domain.STTemplate stTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText(text);
      parent.addTemplates(stTemplate);
      return stTemplate;
   }

   public void reconcileValues() {
      final Set<Node> delete = new LinkedHashSet<>();

      db.doInTransaction(transaction ->
            db
                  .findAllSTValue()
                  .filter(stValue -> !delete.contains(stValue.getNode()))
                  .filter(this::isValidPrimitive)
                  .forEach(stValue -> db
                        .findAllSTValueByValue(stValue.getValue())
                        .filter(duplicate -> !duplicate
                              .getUuid()
                              .equals(stValue.getUuid()))
                        .filter(duplicate -> !delete.contains(duplicate.getNode()))
                        .filter(this::isValidPrimitive)
                        .forEach(duplicate -> {

                           log.info("\t duplicate " + duplicate.getValue());

                           final Node duplicateNode = duplicate.getNode();
                           duplicateNode
                                 .getRelationships(Direction.INCOMING)
                                 .forEach(relationship -> {
                                    final Node src = relationship.getOtherNode(duplicateNode);
                                    final Relationship newRelation = src.createRelationshipTo(stValue
                                          .getNode(), relationship
                                          .getType());
                                    relationship
                                          .getPropertyKeys()
                                          .forEach(s -> newRelation.setProperty(s, relationship
                                                .getProperty(s)));
                                 });

                           delete.add(duplicateNode);
                        })));

      db.doInTransaction(transaction -> {
         for (Node node : delete) {
            node
                  .getRelationships()
                  .forEach(Relationship::delete);
         }
      });
   }

   public boolean isValidPrimitive(STValue stValue) {
      return stValue.getType() != null &&
            stValue.getValue() != null &&
            stValue
                  .getType()
                  .equals(STValueType.PRIMITIVE);
   }

   public void removeArgument(STArgument stArgument, STParameterKey stParameterKey) {
      stArgument
            .getKeyValues()
            .filter(stArgumentKV -> stArgumentKV
                  .getStParameterKey()
                  .equals(stParameterKey.getUuid()))
            .forEach(stArgument::removeKeyValues);
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
      return s.substring(0, Math.min(s.length(), maxLength));
   }

   public String render(STArgument stArgument) {
      return render(stArgument.getValue());
   }

   public String render(STArgument kvArgument, STParameter stParameter) {
      final StringBuilder out = new StringBuilder();

      stParameter
            .getKeys()
            .forEach(stParameterKey -> {
               out
                     .append(stParameterKey.getName())
                     .append(":\n");
               kvArgument
                     .getKeyValues()
                     .filter(stArgumentKV1 -> stArgumentKV1
                           .getStParameterKey()
                           .equals(stParameterKey.getUuid()))
                     .forEach(stArgumentKV1 -> out.append(render(stArgumentKV1.getValue())));
               out.append("\n\n");
            });

      return out.toString();
   }

   public boolean sameArgumentValue(STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue model) {
      final java.util.concurrent.atomic.AtomicBoolean exists = new java.util.concurrent.atomic.AtomicBoolean(false);
      stModel.getArguments().filter(existing -> existing.getStParameter().equals(stParameter.getUuid()))
            .forEach(existing -> {
               if (existing.getValue() != null && existing.getValue().getUuid().equals(model.getUuid()))
                  exists.set(true);
            });
      return exists.get();
   }

   public void save(STGroupModel stGroupModel) {
      final STGParseResult parseResult = STParser.parse(toSTGroup(stGroupModel));

      if (parseResult.getErrors().count() == 0) {
         final File file = new File(new File(AppModel.getInstance().getTemplateDir()), stGroupModel.getName() + ".json");
         log.info("saving stGroup " + stGroupModel.getName() + " to " + file.getAbsolutePath());
         STGenerator.write(file, stGroupModel.getJsonObject().encodePrettily());
      } else {
         log.error(stGroupModel.getName() + " has errors: ");
         parseResult.getErrors().forEach(stgError -> log.error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError.getLine()));
      }
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

      final Optional<STArgumentKV> found = set.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(kvNameFound.get().getUuid()))
            .findFirst();
      if (found.isPresent()) {
         final String render = render(found.get().getValue());
         return render == null || render.length() == 0 ? "[EMPTY]" : render;
      }

      return defaultValue.get();
   }

   public String tryToFindArgument(STModel stModel, String parameterName, Supplier<String> defaultValue) {
      final Optional<STParameter> parameter = findSTTemplateByUuid(stModel.getStTemplate())
            .getParameters()
            .filter(stParameter -> stParameter.getName().equals(parameterName))
            .findFirst();
      if (parameter.isPresent()) {
         final Optional<STArgument> argument = stModel
               .getArguments()
               .filter(stArgument -> stArgument.getStParameter().equals(parameter.get().getUuid()))
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

   public STModelEditor getModelEditor(STModel model) {
      return getWorkspace().getModelEditor(db.getSTTemplate(model), model);
   }

   public WorkFlowFacade getWorkspaceFacade() {
      return workFlowFacade;
   }

   public String tooltip(STValue model) {
      return cut(render(model), 300);
   }

   public String tooltip(STModel model) {
      final nextgen.st.domain.STTemplate stTemplate = db.getSTTemplate(model);
      return findSTGroup(stTemplate).getName() + "." + stTemplate.getName();
   }

   public Collection<STGroupModel> getGroupModels() {
      return db.getGroupModels();
   }

   public Stream<STValue> findAllSTValue() {
      return db.findAllSTValue();
   }

   public Stream<STModel> findAllSTModelByStTemplate(String stTemplateUuid) {
      return db.findAllSTModelByStTemplate(stTemplateUuid)
            .sorted((m1, m2) -> {
               final String c1 = tryToFindArgument(m1, "name", m1::getUuid);
               final String c2 = tryToFindArgument(m2, "name", m2::getUuid);
               return c1.compareToIgnoreCase(c2);
            });
   }

   public nextgen.st.domain.STGroupModel findSTGroup(nextgen.st.domain.STTemplate model) {
      return stRenderer.findSTGroupModel(model);
   }

   public java.util.stream.Stream<nextgen.st.model.STProject> getProjects() {
      return db.findAllSTProject().sorted(java.util.Comparator.comparing(nextgen.st.model.STProject::getName));
   }

   public String canvasLabel(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel model) {
      final StringBuilder out = new StringBuilder(stTemplate.getName() + " :\n");
      getArguments(stTemplate, model, (stParameter, stArgument) -> out.append("\n").append(stParameter.getName()));
      return out.toString();
   }

   public void getArguments(nextgen.st.model.STModel model, java.util.function.BiConsumer<nextgen.st.domain.STParameter, nextgen.st.model.STArgument> consumer) {
      db.getSTTemplate(model)
            .getParameters()
            .sorted(java.util.Comparator.comparing(nextgen.st.domain.STParameter::getName))
            .forEach(stParameter -> model.getArguments()
                  .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                  .filter(stArgument -> stArgument.getValue() != null)
                  .forEach(stArgument -> consumer.accept(stParameter, stArgument)));
   }

   public void getArguments(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel model, java.util.function.BiConsumer<nextgen.st.domain.STParameter, nextgen.st.model.STArgument> consumer) {
      stTemplate.getParameters()
            .sorted(java.util.Comparator.comparing(nextgen.st.domain.STParameter::getName))
            .forEach(stParameter -> model.getArguments()
                  .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                  .forEach(stArgument -> consumer.accept(stParameter, stArgument)));
   }

   public nextgen.st.model.STValue newSTValue(String value) {
      return db.newSTValue(value);
   }

   public nextgen.st.model.STValue newSTValue(nextgen.st.model.STModel value) {
      return db.newSTValue(value);
   }

//   public void set(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, String value) {
//      set(stModel, stParameter, db.newSTValue(value));
//   }
//
//   public void set(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel value) {
//      set(stModel, stParameter, db.newSTValue(value));
//   }
//
//   public void set(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue value) {
//
//      stModel.getArguments()
//             .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
//             .findAny()
//             .ifPresent(this::remove);
//
//      final nextgen.st.model.STArgument stArgument = db.newSTArgument(stParameter, value);
//      stModel.addArguments(stArgument);
//   }
//
//   public void add(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel value) {
//      add(stModel, stParameter, db.newSTValue(value));
//   }
//
//   public void add(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, String value) {
//      add(stModel, stParameter, db.newSTValue(value));
//   }
//
//   public void add(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue value) {
//      final nextgen.st.model.STArgument stArgument = db.newSTArgument(stParameter, value);
//      stModel.addArguments(stArgument);
//   }

   public java.util.Optional<nextgen.st.domain.STGroupModel> findSTGroup(String name) {
      return stGroups.stream()
            .filter(groupModel -> groupModel.getName().toLowerCase().equals(name))
            .findAny();
   }

   public java.util.stream.Stream<nextgen.st.domain.STTemplate> aggregateTemplates(nextgen.st.domain.STGroupModel stGroup) {
      final List<STTemplate> templates = new java.util.ArrayList<>();
      stGroup.getTemplates().forEach(stTemplate -> {
         templates.add(stTemplate);
         aggregate(stTemplate, templates);
      });

      return templates.stream().sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()));
   }

   private void aggregate(nextgen.st.domain.STTemplate stTemplate, java.util.List<nextgen.st.domain.STTemplate> templates) {
      stTemplate.getChildren().forEach(templates::add);
   }

   public java.util.stream.Stream<nextgen.st.domain.STGroupModel> getSTGroups() {
      return stGroups.stream().sorted((g1, g2) -> g1.getName().compareToIgnoreCase(g2.getName()));
   }

   public nextgen.st.domain.STGroupModel findSTGroupModel(nextgen.st.domain.STTemplate stTemplate) {
      return stRenderer.findSTGroupModel(stTemplate);
   }

   public nextgen.st.domain.STGroupModel findSTGroupModelByTemplateUuid(String stTemplate) {
      return stRenderer.findSTGroupModelByTemplate(stTemplate);
   }

   public nextgen.st.domain.STTemplate findSTTemplate(nextgen.st.model.STModel model) {
      return findSTTemplateByUuid(model.getStTemplate());
   }

   public boolean isBoolean(nextgen.st.domain.STParameter model) {
      return model.getName().startsWith("is") || model.getName().startsWith("has");
   }

   public String[] getSelectedValues() {


      return new String[0];
   }

   public nextgen.st.domain.STTemplate getSTTemplate(nextgen.st.model.STModel stModel) {
      return findSTTemplateByUuid(stModel.getStTemplate());
   }

   public static final class CompilationResult {

      public final String compilerOutput;
      public final Class<?> aClass;

      public CompilationResult(String compilerOutput, Class<?> aClass) {
         this.compilerOutput = compilerOutput;
         this.aClass = aClass;
      }
   }


   public Set<STTemplate> findSTTemplatesByInterface(String name, STGroupModel stGroupModel) {
      final Set<STTemplate> set = new LinkedHashSet<>();
      aggregateTemplates(stGroupModel)
            .forEach(stTemplate -> stTemplate.getImplements()
                  .filter(name::equals)
                  .findFirst()
                  .ifPresent(s -> set.add(stTemplate)));
      return set;
   }
}