package nextgen.st;

import nextgen.st.domain.*;
import nextgen.st.model.*;
import nextgen.swing.AppModel;
import nextgen.templates.java.BlockStmt;
import nextgen.utils.*;
import nextgen.workflow.WorkFlowFacade;
import org.javatuples.Pair;
import org.neo4j.graphdb.*;

import javax.lang.model.SourceVersion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextgen.st.STGenerator.toSTGroup;
import static nextgen.templates.JavaPatterns.newPackageDeclaration;
import static nextgen.templates.java.JavaST.*;
import static nextgen.utils.STModelUtil.findSTTemplateByName;
import static nextgen.utils.SwingUtil.newTextField;

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


   public void editSTGroupTags(JComponent parent, STGroupModel model) {
      nextgen.utils.SwingUtil.showInputDialog("Tags", parent, model.getTags(""), tags -> {
         model.setTags(tags);
         save(model);
      });
   }

   public void addKVArgument(STModel stModel, STParameter stParameter, Component owner, Consumer<STArgument> stArgumentConsumer) {

      final Map<STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();
      stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(40)));

      final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(new JLabel(fieldEntry.getKey().getName()));
         inputPanel.add(fieldEntry.getValue());
      }
      SwingUtil.showDialog(inputPanel, owner, stParameter.getName(), new SwingUtil.ConfirmAction() {
         @Override
         public void verifyAndCommit() throws Exception {
            doLaterInTransaction(tx -> {
               final List<STArgumentKV> kvs = new ArrayList<>();
               for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
                  final String value = fieldEntry.getValue().getText().trim();
                  if (value.length() == 0) continue;
                  kvs.add(newSTArgumentKV(fieldEntry.getKey(), db.newSTValue(value)));
               }
               stArgumentConsumer.accept(newSTArgument(stModel, stParameter, kvs));
            });
         }
      });
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

      if (parseResult
            .getErrors()
            .count() == 0) {
         final STGenerator stGenerator = new STGenerator(generatorSTGroup);
         stGroups
               .stream()
               .filter(stGroupModel1 -> stGroupModel1
                     .getUuid()
                     .equals(stGroupModel.getUuid()))
               .findFirst()
               .ifPresent(directory -> {
                  log.info("generating stGroup " + stGroupModel.getName() + " to " +
                        AppModel
                              .getInstance()
                              .getOutputPath() + " " +
                        AppModel
                              .getInstance()
                              .getOutputPackage());
                  stGenerator
                        .generateSTGroup(stGroupModel, AppModel
                              .getInstance()
                              .getOutputPackage(), AppModel
                              .getInstance()
                              .getOutputPath());
                  if (generateNeo) stGenerator.generateNeoGroup(stGroupModel, AppModel
                        .getInstance()
                        .getOutputPackage(), AppModel
                        .getInstance()
                        .getOutputPath());
               });
      } else {
         log.error(stGroupModel.getName() + " has errors: ");
         parseResult
               .getErrors()
               .forEach(stgError -> log
                     .error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError
                           .getLine()));
      }
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
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter);
      return stArgument;
   }

   public STArgument newSTArgument(STModel stModel, STParameter stParameter, List<STArgumentKV> kvs) {
      final nextgen.st.model.STArgument stArgument = db.newSTArgument(stParameter, kvs);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter);
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
      final nextgen.st.model.STModel stModel = db.newSTModel(findSTGroup(stTemplate).getUuid(), stTemplate);
      nextgen.events.NewSTModel.post(stModel);
      return stModel;
   }

   public STModel newSTModel(String stGroupModel, STTemplate stTemplate) {
      final nextgen.st.model.STModel stModel = db.newSTModel(stGroupModel, stTemplate);
      nextgen.events.NewSTModel.post(stModel);
      return stModel;
   }

   public STModel newSTModel(String stGroupModel, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STProject stProject) {
      final nextgen.st.model.STModel stModel = db.newSTModel(stGroupModel, stTemplate);
      stProject.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, stProject);
      return stModel;
   }

   public nextgen.st.domain.STTemplate newSTTemplate(String name, String text, nextgen.st.domain.STGroupModel parent) {
      final nextgen.st.domain.STTemplate stTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText(text);
      parent.addTemplates(stTemplate);
      nextgen.events.NewSTTemplate.post(stTemplate, parent);
      return stTemplate;
   }

   public nextgen.st.domain.STTemplate newSTTemplate(String name, nextgen.st.domain.STGroupModel parent) {
      final nextgen.st.domain.STTemplate stTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText("");
      parent.addTemplates(stTemplate);
      nextgen.events.NewSTTemplate.post(stTemplate, parent);
      return stTemplate;
   }

   public nextgen.st.domain.STTemplate newSTTemplate(String name, nextgen.st.domain.STTemplate parent) {
      final nextgen.st.domain.STTemplate stTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText("");
      parent.addChildren(stTemplate);
      nextgen.events.NewSTTemplate.post(stTemplate, parent);
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

   public void removeArgument(STModel stModel, STParameter stParameter) {
      getArguments(stModel, stParameter).forEach(stModel::removeArguments);
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
      stModel
            .getArguments()
            .filter(existing -> existing
                  .getStParameter()
                  .equals(stParameter.getUuid()))
            .forEach(existing -> {
               if (existing.getValue() != null && existing
                     .getValue()
                     .getUuid()
                     .equals(model.getUuid()))
                  exists.set(true);
            });
      return exists.get();
   }

   public void save(STGroupModel stGroupModel) {
      final STGParseResult parseResult = STParser.parse(toSTGroup(stGroupModel));

      if (parseResult
            .getErrors()
            .count() == 0) {
         final File file = new File(new File(AppModel
               .getInstance()
               .getTemplateDir()), stGroupModel.getName() + ".json");
         log.info("saving stGroup " + stGroupModel.getName() + " to " + file.getAbsolutePath());
         STGenerator.write(file, stGroupModel
               .getJsonObject()
               .encodePrettily());
      } else {
         log.error(stGroupModel.getName() + " has errors: ");
         parseResult
               .getErrors()
               .forEach(stgError -> log
                     .error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError
                           .getLine()));
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

   public void writeToFile(STModel stModel) {
      doLaterInTransaction(tx -> stModel.getFiles().forEach(stFile -> {
         if (stFile.getPath() == null) return;
         nextgen.st.STGenerator.writeToFile(render(stModel), stFile.getPackageName().getValue(), stFile.getName().getValue(), stFile.getType()
                                                                                                                                    .getValue(), new java.io.File(stFile
               .getPath().getValue()));
      }));
   }

   public void writeToFile(nextgen.st.model.STProject project) {
      project.getModels().forEach(stModel -> stModel.getFiles().
            forEach(stFile -> nextgen.st.STGenerator
                  .writeToFile(render(stModel), stFile.getPackageName().getValue(), stFile.getName().getValue(), stFile.getType()
                                                                                                                       .getValue(), new java.io.File(stFile
                        .getPath().getValue()))));
   }


   public void addMultiple(JComponent owner, STModel stModel, STParameter stParameter) {

      final String parameterName = stParameter.getName();
      final String argumentType = stParameter.getArgumentType();


   }

   public void setMultiple(JComponent owner, STModel model, STTemplate stTemplate) {

      final java.util.concurrent.atomic.AtomicInteger modelIndex = new java.util.concurrent.atomic.AtomicInteger(0);
      final STModel[] existingSTModels = db
            .findAllSTModelByStTemplate(stTemplate.getUuid())
            .distinct()
            .toArray(STModel[]::new);

      final Map<String, JTextField> fieldMap = new LinkedHashMap<>();
      final Map<String, STParameter> parameterMap = new LinkedHashMap<>();
      final Map<String, STArgument> argumentMap = new LinkedHashMap<>();
      final Map<String, List<String>> valuesMap = new LinkedHashMap<>();

      stTemplate
            .getParameters()
            .filter(stParameter -> stParameter.getType().equals(STParameterType.SINGLE))
            .forEach(stParameter -> {
               final Optional<STArgument> argument = model.getArguments().filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                                                          .findFirst();
               final String content = argument.isPresent() ? render(argument.get()) : "";
               fieldMap.put(stParameter.getName(), newTextField(content, 40));
               parameterMap.put(stParameter.getName(), stParameter);
               argument.ifPresent(stArgument -> argumentMap.put(stParameter.getName(), stArgument));


               for (nextgen.st.model.STModel existingSTModel : existingSTModels) {
                  existingSTModel
                        .getArguments()
                        .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                        .filter(stArgument -> stArgument.getValue() != null)
                        .findFirst()
                        .ifPresent(stArgument -> {
                           valuesMap.putIfAbsent(stParameter.getName(), new java.util.ArrayList<>());
                           valuesMap
                                 .get(stParameter.getName())
                                 .add(render(stArgument));
                        });
               }

            });

      final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(new JLabel(fieldEntry.getKey()));
         inputPanel.add(fieldEntry.getValue());

         if (!valuesMap.isEmpty())
            fieldEntry
                  .getValue()
                  .addMouseListener(new java.awt.event.MouseAdapter() {
                     @Override
                     public void mouseClicked(java.awt.event.MouseEvent e) {
                        fieldEntry
                              .getValue()
                              .setText(valuesMap
                                    .get(fieldEntry.getKey())
                                    .get(modelIndex.incrementAndGet() % valuesMap
                                          .get(fieldEntry.getKey())
                                          .size()));
                     }
                  });
      }
      SwingUtil.showDialog(inputPanel, owner, "Set Multiple", new SwingUtil.ConfirmAction() {
         @Override
         public void verifyAndCommit() throws Exception {
            doLaterInTransaction(tx -> {
               for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {

                  final String name = fieldEntry.getKey();
                  final String value = fieldEntry.getValue().getText().trim();
                  final STArgument stArgument = argumentMap.get(name);
                  final STParameter stParameter = parameterMap.get(name);

                  if (value.length() == 0 && stArgument != null) {
                     model.removeArguments(stArgument);
                  } else if (value.length() != 0 && stArgument != null) {
                     final String existingValue = render(stArgument.getValue());
                     if (!value.equals(existingValue))
                        stArgument.setValue(db.newSTValue(value));
                  } else if (value.length() != 0) {
                     newSTArgument(model, stParameter, value);
                  }
               }
            });
         }
      });
   }

   public void generateSource(STModel model) {
      generateSources(Collections.singleton(model), "Test");
   }

   public void generateSources(Set<STModel> stModels, String className) {
      doLaterInTransaction(transaction -> {

         final Set<String> imports = new LinkedHashSet<>();
         final BlockStmt blockStmt = newBlockStmt();

         for (STModel stModel : stModels)
            blockStmt.addStatements(newExpressionStmt()
                  .setExpression(newMethodCallExpression()
                        .setScope("System.out")
                        .setName("println")
                        .addArguments(stRenderer.renderGeneratorCode(stModel, imports))));

         STGenerator.writeJavaFile(newCompilationUnit()
                     .setPackageDeclaration(newPackageDeclaration("tmp"))
                     .setImportDeclaration(imports
                           .stream()
                           .map(s -> newImportDeclaration()
                                 .setName(s)
                                 .setIsAsterisk(true))
                           .collect(Collectors.toList()))
                     .addTypes(newClassOrInterfaceDeclaration()
                           .setName(className)
                           .addMembers(newMethodDeclaration()
                                 .addModifiers("public")
                                 .addModifiers("static")
                                 .setName("main")
                                 .addParameters(newParameter()
                                       .setType(newClassOrInterfaceType()
                                             .addNames("String")
                                             .setIsArrayType(true))
                                       .setName("args"))
                                 .setBlockStmt(blockStmt)))
               , "tmp", className, new File("./components/core/src/main/java"));
      });
   }

   public void undoLast() {
      chronicle.rollbackLast();
   }

   public Stream<STTemplate> getSelectedSTTemplates() {
      return getWorkspace()
            .getTemplateNavigator()
            .getSelectedNodes(STTemplateNavigator.STTemplateTreeNode.class)
            .map(STTemplateNavigator.STTemplateTreeNode::getModel);
   }

   public Stream<STValue> getSelectedSTValues() {
      return getWorkspace()
            .getModelNavigator()
            .getSelectedNodes()
            .filter(treeNode -> treeNode instanceof STModelNavigator.STValueTreeNode)
            .map(treeNode -> (STModelNavigator.STValueTreeNode) treeNode)
            .map(STModelNavigator.STValueTreeNode::getModel);
   }

   public Stream<STModel> getSelectedSTModels() {
      return getWorkspace()
            .getModelNavigator()
            .getSelectedNodes()
            .filter(treeNode -> treeNode instanceof STModelNavigator.STModelTreeNode)
            .map(treeNode -> (STModelNavigator.STModelTreeNode) treeNode)
            .map(STModelNavigator.STModelTreeNode::getModel);
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

   public void remove(STValue model) {
      db.remove(model);
   }

   public Collection<STGroupModel> getGroupModels() {
      return db.getGroupModels();
   }

   public Stream<STValue> findAllSTValue() {
      return db.findAllSTValue();
   }

   public Stream<STModel> findAllSTModelByStTemplate(String stTemplateUuid) {
      final java.util.stream.Stream<nextgen.st.model.STModel> modelStream = db.findAllSTModelByStTemplate(stTemplateUuid)
                                                                              .sorted((m1, m2) -> {
                                                                                 final String c1 = tryToFindArgument(m1, "name", m1::getUuid);
                                                                                 final String c2 = tryToFindArgument(m2, "name", m2::getUuid);
                                                                                 return c1.compareToIgnoreCase(c2);
                                                                              });
      return modelStream;
   }

   public nextgen.st.domain.STGroupModel findSTGroup(nextgen.st.domain.STTemplate model) {
      return stRenderer.findSTGroupModel(model);
   }

   public java.util.stream.Stream<nextgen.st.model.STProject> getProjects() {
      return db.findAllSTProject().sorted(java.util.Comparator.comparing(nextgen.st.model.STProject::getName));
   }

   public nextgen.st.model.STProject newSTProject(String name) {
      final nextgen.st.model.STProject stProject = db.newSTProject(name);
      nextgen.events.NewSTProject.post(stProject);
      return stProject;
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

   public void addToProject(nextgen.st.model.STProject project, nextgen.st.model.STModel model) {
      project.addModels(model);
      nextgen.events.ModelAddedToProject.post(model, project);
   }

   public void remove(nextgen.st.model.STArgumentKV value) {
      value.getIncomingKeyValuesSTArgument().findFirst().ifPresent(stArgument -> stArgument.removeKeyValues(value));
   }

   public void remove(nextgen.st.model.STArgument value) {
      value.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> stModel.removeArguments(value));
   }

   public nextgen.st.model.STValue newSTValue(String value) {
      return db.newSTValue(value);
   }

   public nextgen.st.model.STValue newSTValue(nextgen.st.model.STModel value) {
      return db.newSTValue(value);
   }

   public void set(nextgen.st.model.STArgument model, nextgen.st.domain.STParameterKey stParameterKey, STModel stModel) {
      set(model, stParameterKey, newSTArgumentKV(stParameterKey, newSTValue(stModel)));
   }

   public void set(nextgen.st.model.STArgument model, nextgen.st.domain.STParameterKey stParameterKey, STValue stValue) {
      set(model, stParameterKey, newSTArgumentKV(stParameterKey, stValue));
   }

   public void set(nextgen.st.model.STArgument model, nextgen.st.domain.STParameterKey stParameterKey, String inputValue) {
      set(model, stParameterKey, newSTArgumentKV(stParameterKey, newSTValue(inputValue)));
   }

   public void set(nextgen.st.model.STArgument model, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV) {
      model.getKeyValues()
           .filter(existing -> existing.getStParameterKey().equals(stParameterKey.getUuid()))
           .findFirst()
           .ifPresent(existing -> remove(model, existing));

      model.addKeyValues(stArgumentKV);
   }

   private void remove(nextgen.st.model.STArgument stArgument, nextgen.st.model.STArgumentKV stArgumentKV) {
      stArgument.removeKeyValues(stArgumentKV);
   }

   public void set(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, String value) {
      set(stModel, stParameter, db.newSTValue(value));
   }

   public void set(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel value) {
      set(stModel, stParameter, db.newSTValue(value));
   }

   public void set(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue value) {

      stModel.getArguments()
             .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
             .findAny()
             .ifPresent(this::remove);

      final nextgen.st.model.STArgument stArgument = db.newSTArgument(stParameter, value);
      stModel.addArguments(stArgument);
      nextgen.events.STArgumentAdded.post(stModel, stArgument, stParameter, value);
   }

   public void add(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel value) {
      add(stModel, stParameter, db.newSTValue(value));
   }

   public void add(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, String value) {
      add(stModel, stParameter, db.newSTValue(value));
   }

   public void add(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue value) {
      final nextgen.st.model.STArgument stArgument = db.newSTArgument(stParameter, value);
      stModel.addArguments(stArgument);
      nextgen.events.STArgumentAdded.post(stModel, stArgument, stParameter, value);
   }

   public void set(nextgen.st.model.STValue stValue, String value) {
      stValue.removeStModel();
      stValue.setValue(value);
      stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);
      nextgen.events.STValueChanged.post(stValue);
   }

   public void delete(nextgen.st.model.STValue stValue) {
      final String uuid = stValue.getUuid();
      final STValue found = db.findSTValueByUuid(uuid);
      if (found != null) db.delete(found.getNode());
      nextgen.events.STValueDeleted.post(uuid);
   }

   public void delete(nextgen.st.model.STModel stModel) {
      final String uuid = stModel.getUuid();
      final STValue found = db.findSTValueByUuid(uuid);
      if (found != null) db.delete(found.getNode());
      nextgen.events.STModelDeleted.post(uuid);
   }

   public java.util.Optional<nextgen.st.domain.STGroupModel> findSTGroup(String name) {
      return stGroups.stream()
                     .filter(groupModel -> groupModel.getName().toLowerCase().equals(name))
                     .findAny();
   }

   public void generateAllGroups() {
      stGroups.stream().forEach(stGroupModel -> generateSTGroup(stGroupModel, false));
   }

   public void addEnum(nextgen.st.domain.STGroupModel stGroup, String name) {
      final nextgen.st.domain.STEnum stEnum = newSTEnum(name);
      stGroup.addEnums(stEnum);
   }

   public void addInterface(nextgen.st.domain.STGroupModel stGroup, String name) {
      final nextgen.st.domain.STInterface stInterface = newSTInterface(name);
      stGroup.addInterfaces(stInterface);
   }

   public void addInterface(java.util.Set<nextgen.st.domain.STTemplate> templates, String interfaceName) {

   }

   public void setName(nextgen.st.domain.STGroupModel stGroup, String name) {
      stGroup.setName(name);
   }

   public void setName(nextgen.st.domain.STEnum stEnum, String name) {
      stEnum.setName(name);
   }

   public void setName(nextgen.st.domain.STInterface stInterface, String name) {
      stInterface.setName(name);
   }

   public void delete(nextgen.st.domain.STGroupModel stGroup) {

   }

   public void update(nextgen.st.domain.STEnum stEnum) {

   }

   public void delete(nextgen.st.domain.STEnum stEnum, nextgen.st.domain.STGroupModel stGroup) {
      stGroup.removeEnums(stEnum);
   }

   public void delete(nextgen.st.domain.STTemplate stTemplate, nextgen.st.domain.STGroupModel stGroup) {
      stGroup.removeTemplates(stTemplate);
   }

   public void setParent(nextgen.st.domain.STTemplate stTemplate, java.util.Set<nextgen.st.domain.STTemplate> children) {

   }

   public void newSTModel(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STProject project) {
      final nextgen.st.model.STModel stModel = newSTModel(stTemplate);
      project.addModels(stModel);
   }

   public void removeInterface(nextgen.st.domain.STTemplate stTemplate, String interfaceName) {
      stTemplate.removeImplements(interfaceName);
   }

   public void setParameterTypes(nextgen.st.domain.STTemplate stTemplate) {

   }

   public void setInterfaces(nextgen.st.domain.STTemplate stTemplate) {

   }

   public void setName(nextgen.st.domain.STTemplate stTemplate, String name) {
      stTemplate.setName(name);
   }

   public void delete(nextgen.st.domain.STInterface stInterface, nextgen.st.domain.STGroupModel stGroup) {
      stGroup.removeInterfaces(stInterface);
   }

   public static final class CompilationResult {

      public final String compilerOutput;
      public final Class<?> aClass;

      public CompilationResult(String compilerOutput, Class<?> aClass) {
         this.compilerOutput = compilerOutput;
         this.aClass = aClass;
      }
   }


   public Stream<STArgument> getArguments(STModel stModel, STParameter stParameter) {
      return stModel
            .getArguments()
            .filter(stArgument -> stArgument
                  .getStParameter()
                  .equals(stParameter.getUuid()));
   }

   public void setParameter(STParameter stParameter, STModel stModel, JComponent parent) {
      setParameter(stParameter, stModel, parent, true);
   }

   public void addList(STParameter stParameter, STModel stModel, JComponent parent) {
      setParameter(stParameter, stModel, parent, false);
   }

   public void setParameter(STParameter stParameter, STModel stModel, JComponent parent, boolean singleValue) {

      doInTransaction(transaction -> {

         final String argumentType = stParameter.getArgumentType();
         if (argumentType.equals("Object") || argumentType.equals("String")) {
            final Set<STTemplate> stTemplateSet = getArguments(stModel, stParameter)
                  .map(STArgument::getValue)
                  .filter(STValue::hasType)
                  .filter(stValue -> stValue.getType() == STValueType.STMODEL)
                  .map(stValue -> db.findSTTemplateByUuid(stValue.getStModel().getStTemplate()))
                  .collect(Collectors.toSet());

            if (!stTemplateSet.isEmpty()) {
               if (singleValue) removeArgument(stModel, stParameter);
               final STTemplate stTemplate = stTemplateSet.iterator().next();
               final STGroupModel stGroupModel = stRenderer.findSTGroupModel(stTemplate);
               final STValue stValue = db.newSTValue(db.newSTModel(stGroupModel.getUuid(), stTemplate));
               newSTArgument(stModel, stParameter, stValue);

            } else {
               SwingUtil.showInputDialog(stParameter.getName(), parent, inputValue ->
                     doLaterInTransaction(transaction2 -> {
                        if (singleValue) removeArgument(stModel, stParameter);
                        newSTArgument(stModel, stParameter, inputValue);
                     }));
            }
         } else {
            final STGroupModel stGroupModel = stRenderer.findSTGroupModel(db.getSTTemplate(stModel));
            final java.util.Optional<nextgen.st.domain.STTemplate> stTemplate = findSTTemplateByName(stGroupModel, argumentType);
            if (stTemplate.isPresent()) {
               if (singleValue) removeArgument(stModel, stParameter);
               final STValue stValue = db.newSTValue(db.newSTModel(stGroupModel.getUuid(), stTemplate.get()));
               newSTArgument(stModel, stParameter, stValue);
            } else {

               final Set<STTemplate> interfaces = STModelUtil.findSTInterfacesByName(argumentType, stGroupModel);
               if (!interfaces.isEmpty()) {

                  if (interfaces.size() == 1) {
                     doLaterInTransaction(transaction2 -> {
                        if (singleValue) removeArgument(stModel, stParameter);
                        final STValue stValue = db.newSTValue(db.newSTModel(stGroupModel.getUuid(), interfaces.iterator().next()));
                        newSTArgument(stModel, stParameter, stValue);
                     });
                     return;
                  }

                  SwingUtil.showSelectDialog("Select", parent, interfaces, stTemplate1 -> doLaterInTransaction(transaction2 -> {
                     if (singleValue) removeArgument(stModel, stParameter);
                     final STValue stValue = db.newSTValue(db.newSTModel(stGroupModel.getUuid(), stTemplate1));
                     newSTArgument(stModel, stParameter, stValue);
                  }));

               } else {

                  final STEnum stEnum = STModelUtil.findSTEnumByName(argumentType, stGroupModel);
                  if (stEnum != null) {

                     SwingUtil.showSelectDialog("Select", parent, stEnum
                           .getValues()
                           .collect(Collectors.toSet()), stEnumValue -> doLaterInTransaction(transaction2 -> {
                        if (singleValue) removeArgument(stModel, stParameter);
                        final STValue stValue = db.newSTValue(stEnumValue);
                        newSTArgument(stModel, stParameter, stValue);
                     }));

                  } else {
                     SwingUtil.showInputDialog(stParameter.getName(), parent, inputValue ->
                           doLaterInTransaction(transaction2 -> {
                              if (singleValue) removeArgument(stModel, stParameter);
                              newSTArgument(stModel, stParameter, inputValue);
                           }));
                  }
               }
            }
         }
      });
   }
}