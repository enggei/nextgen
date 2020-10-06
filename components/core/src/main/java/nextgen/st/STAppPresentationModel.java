package nextgen.st;

import net.openhft.compiler.CompilerUtils;
import nextgen.st.domain.*;
import nextgen.st.model.*;
import nextgen.templates.MavenPatterns;
import nextgen.templates.java.BlockStmt;
import nextgen.templates.java.ImportDeclaration;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.maven.TestRunner;
import nextgen.templates.maven.neo.MavenNeo;
import nextgen.templates.maven.neo.ProjectGeneratorModel;
import nextgen.templates.maven.neo.ProjectModel;
import nextgen.templates.stringtemplate.DomainVisitorRunner;
import nextgen.templates.stringtemplate.ScriptRunner;
import nextgen.templates.stringtemplate.StringTemplateST;
import nextgen.utils.DomainUtil;
import nextgen.utils.NeoChronicle;
import nextgen.utils.STModelUtil;
import nextgen.utils.SwingUtil;
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
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextgen.st.STGenerator.toSTGroup;
import static nextgen.st.model.STValueType.PRIMITIVE;
import static nextgen.templates.JavaPatterns.newPackageDeclaration;
import static nextgen.templates.java.JavaST.*;
import static nextgen.utils.StringUtil.capitalize;
import static nextgen.utils.SwingUtil.newComboBox;
import static nextgen.utils.SwingUtil.newTextField;

public class STAppPresentationModel {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppPresentationModel.class);
   private static final Map<String, ImageIcon> cache = new LinkedHashMap<>();
   public final STRenderer stRenderer;
   public final STModelDB db;

   final STGroupModel generatorSTGroup;
   final Set<STGDirectory> stgDirectories = new LinkedHashSet<>();

   private final NeoChronicle chronicle;
   private final STAppModel appModel;
   private Font preferredFont;
   private STWorkspace stWorkspace;
   private String lastDir;
   private final WorkFlowFacade workFlowFacade;

   STAppPresentationModel(STAppModel appModel) throws IOException {

      this.appModel = appModel;

      final Set<STGroupModel> stGroups = new LinkedHashSet<>();
      appModel.getDirectories().forEach(stgDirectory -> {
         stgDirectories.add(stgDirectory);
         stGroups.addAll(stgDirectory.getGroups().collect(Collectors.toSet()));
      });

      this.generatorSTGroup = new STGroupModel(new File("/home/goe/projects/nextgen/components/core/src/main/resources/templates/StringTemplate.json"));

      this.stRenderer = new STRenderer(stGroups);
      this.db = new STModelDB(appModel.getModelDb("./db"), stGroups);
      this.workFlowFacade = new WorkFlowFacade(db.getDatabaseService());
      this.chronicle = new NeoChronicle(appModel.getModelDb("./db"), db.getDatabaseService());

      final Set<String> fonts = new HashSet<>(Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getAvailableFontFamilyNames()));
      this.preferredFont = Stream
            .of("Hack", "Fira Code", "Source Code Pro", "Monospaced")
            .filter(fonts::contains)
            .findFirst().map(s -> new Font(s, Font.PLAIN, appModel.getEditorFontSize(12)))
            .orElse(null);
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

      final Optional<STTemplate> existing = stGroupModel.getTemplates()
            .filter(stTemplate -> stTemplate.getName()
                  .toLowerCase()
                  .equals(name.toLowerCase()))
            .findAny();

      if (existing.isPresent()) {
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

   public static void deleteSTGFile(STGDirectory stgDirectory, String name) {
      final File stgFile = new File(stgDirectory.getPath(), name + ".json");
      if (stgFile.exists())
         stgFile.renameTo(new File(stgDirectory.getPath(), name + ".json.deleted"));
   }


   public void editSTGroupTags(JComponent parent, STGroupModel model) {
      nextgen.utils.SwingUtil.showInputDialog("Tags", parent, model.getTags(""), tags -> {
         model.setTags(tags);
         save(model);
      });
   }

   public void addKVArgument(STModel stModel, STParameter stParameter, Component owner, Consumer<STArgument> stArgumentConsumer) {
      final Map<STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();
      stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(15)));
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
                  kvs.add(newSTArgumentKV(fieldEntry.getKey(), newSTValue(value)));
               }
               final STArgument newSTArgument = newSTArgument(stParameter, kvs);
               stModel.addArguments(newSTArgument);
               stArgumentConsumer.accept(newSTArgument);
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
         if (type.equals(evt.getPropertyName().split(".")[0]))
            doInTransaction(consumer);
      });
   }

//   public void edit(JComponent owner, MetaProperty model, Consumer<MetaProperty> metaPropertyConsumer) {
//      final Map<String, JTextField> fieldMap = new LinkedHashMap<>();
//      fieldMap.put("Name", newTextField(model.getName(""), 15));
//      fieldMap.put("Type", newTextField(model.getType(""), 15));
//      fieldMap.put("Default Value", newTextField(model.getDefaultValue(""), 15));
//      final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
//      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
//      for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
//         inputPanel.add(new JLabel(fieldEntry.getKey()));
//         inputPanel.add(fieldEntry.getValue());
//      }
//      SwingUtil.showDialog(inputPanel, owner, "Edit Property", new SwingUtil.ConfirmAction() {
//         @Override
//         public void verifyAndCommit() throws Exception {
//            doLaterInTransaction(tx -> {
//               final String name = fieldMap.get("Name").getText().trim();
//               final String type = fieldMap.get("Type").getText().trim();
//               final String defaultValue = fieldMap.get("Default Value").getText().trim();
//               metaPropertyConsumer.accept(model.setName(name)
//                     .setType(type)
//                     .setDefaultValue(defaultValue.length() == 0 ? null : defaultValue));
//            });
//         }
//      });
//   }


   public STTemplate findSTTemplateByUuid(String stTemplate) {
      return db.findSTTemplateByUuid(stTemplate);
   }

   public void forEachArgument(STTemplate stTemplate, STModel stModel, java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.domain.STParameter> consumer) {
      stTemplate.getParameters()
            .forEach(stParameter -> stModel.getArgumentsSorted()
                  .filter(stArgument -> stArgument.getStParameter()
                        .equals(stParameter.getUuid()))
                  .forEach(stArgument -> consumer.accept(stArgument, stParameter)));
   }

   void generateSTGroup(STGroupModel stGroupModel, boolean generateNeo) {

      final STGParseResult parseResult = STParser.parse(toSTGroup(stGroupModel));

      if (parseResult.getErrors().count() == 0) {
         final STGenerator stGenerator = new STGenerator(generatorSTGroup);
         stgDirectories
               .stream()
               .filter(directory -> directory.getGroups()
                     .anyMatch(stGroupModel1 -> stGroupModel1.getUuid()
                           .equals(stGroupModel
                                 .getUuid())))
               .findFirst()
               .ifPresent(directory -> {
                  log.info("generating stGroup " + stGroupModel.getName() + " to " + directory
                        .getOutputPath() + " " + directory
                        .getOutputPackage());
                  stGenerator
                        .generateSTGroup(stGroupModel, directory.getOutputPackage(), directory
                              .getOutputPath());
                  if (generateNeo) stGenerator.generateNeoGroup(stGroupModel, directory.getOutputPackage(), directory
                        .getOutputPath());
               });
      } else {
         log.error(stGroupModel.getName() + " has errors: ");
         parseResult.getErrors()
               .forEach(stgError -> log
                     .error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError
                           .getLine()));
      }
   }

   public CompilationResult generateScriptCode(Script script) {

      final File srcRoot = new File(appModel.getRootDir());

      final nextgen.templates.java.PackageDeclaration packageDeclaration = nextgen.templates.java.JavaST
            .newPackageDeclaration()
            .setName("tmp");

      final Collection<ImportDeclaration> imports = new ArrayList<>();
      stgDirectories.forEach(directory -> {
         final String outputPackage = directory.getOutputPackage();
         final File templateClassDir = new File(srcRoot, STGenerator.packageToPath(outputPackage));

         directory.getGroups().forEach(stGroupModel -> {
            final String packageName = outputPackage + "." + stGroupModel.getName().toLowerCase();
            if (new File(srcRoot, STGenerator.packageToPath(packageName)).exists()) {
               imports.add(nextgen.templates.java.JavaST.newImportDeclaration()
                     .setName(packageName + "." + capitalize(stGroupModel
                           .getName() + "ST"))
                     .setIsAsterisk(true)
                     .setIsStatic(true));
               imports.add(nextgen.templates.java.JavaST.newImportDeclaration()
                     .setName(packageName)
                     .setIsAsterisk(true));
            }
         });

         Arrays.stream(Objects.requireNonNull(templateClassDir.listFiles()))
               .filter(file -> file.isFile() && file.getName().endsWith("Patterns.java"))
               .forEach(file -> imports.add(nextgen.templates.java.JavaST.newImportDeclaration()
                     .setName(directory
                           .getOutputPackage() + "." + capitalize(file
                           .getName()
                           .substring(0, file.getName()
                                 .length() - 5)))
                     .setIsAsterisk(true)
                     .setIsStatic(true)));
      });

      final String className = script.getName().replaceAll("[ ]", "");

      STGenerator.writeJavaFile(getScriptRunner(script.getScript(), packageDeclaration, imports, className), packageDeclaration
            .getName(), className, srcRoot);

      final java.io.StringWriter sr = new java.io.StringWriter();
      final java.io.PrintWriter compilerOutput = new java.io.PrintWriter(sr);
      try {
         final String cacheClassname = className + System.currentTimeMillis();
         final Object compilationUnit = getScriptRunner(script.getScript(), packageDeclaration, imports, cacheClassname);
         final Class<?> aClass = CompilerUtils.CACHED_COMPILER
               .loadFromJava(getClass().getClassLoader(), packageDeclaration
                     .getName() + "." + cacheClassname, compilationUnit.toString(), compilerOutput);
         return new CompilationResult(sr.toString(), aClass);
      } catch (Throwable t) {
         return new CompilationResult(sr.toString(), null);
      }
   }


   public <T> T getInTransaction(java.util.function.Function<org.neo4j.graphdb.Transaction, T> action) {
      return db.getInTransaction(action);
   }

   public Stream<STArgumentKV> getIncomingSTArgumentKVs(STValue stValue) {
      final org.neo4j.graphdb.Node node = stValue.getNode();
      return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING)
            .spliterator(), false)
            .map(relationship -> relationship.getOtherNode(node))
            .filter(STModelNeoFactory::isSTArgumentKV)
            .map(db::newSTArgumentKV);
   }

   public Stream<STArgumentKV> getIncomingSTArgumentKVs(STModel stValue) {
      final org.neo4j.graphdb.Node node = stValue.getNode();
      return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING)
            .spliterator(), false)
            .map(relationship -> relationship.getOtherNode(node))
            .filter(STModelNeoFactory::isSTArgumentKV)
            .map(db::newSTArgumentKV);
   }

   public Stream<STArgument> getIncomingSTArguments(STValue stValue) {
      final org.neo4j.graphdb.Node node = stValue.getNode();
      return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING)
            .spliterator(), false)
            .map(relationship -> relationship.getOtherNode(node))
            .filter(STModelNeoFactory::isSTArgument)
            .map(db::newSTArgument);
   }

   public Stream<STArgument> getIncomingSTArguments(STModel stValue) {
      final org.neo4j.graphdb.Node node = stValue.getNode();
      return java.util.stream.StreamSupport.stream(node.getRelationships(org.neo4j.graphdb.Direction.INCOMING)
            .spliterator(), false)
            .map(relationship -> relationship.getOtherNode(node))
            .filter(STModelNeoFactory::isSTArgument)
            .map(db::newSTArgument);
   }

   public String getLastDir() {
      return lastDir == null ? System.getProperty("user.home") : lastDir;
   }

   Font getPreferredFont() {
      return preferredFont;
   }

   public Optional<STModel> getSTModel(STValue stValue) {
      return stValue.getType()
            .equals(nextgen.st.model.STValueType.STMODEL) ? Optional.of(stValue.getStModel()) : Optional
            .empty();
   }

   public String getSTModelName(STModel stModel, String defaultName) {
      return db.getSTModelName(stModel, defaultName);
   }

   public String getSTModelPackage(STModel stModel, String defaultName) {
      return db.getSTModelPackage(stModel, defaultName);
   }

   public Object getScriptRunner(STValue statements, PackageDeclaration packageDeclaration, Collection<ImportDeclaration> imports, String className) {
      final ScriptRunner scriptRunner = StringTemplateST.newScriptRunner();
      scriptRunner.setPackageName(packageDeclaration.getName());
      scriptRunner.setName(className);
      scriptRunner.setTemplatesDir(appModel.getDirectories().findFirst().get().getPath());
      scriptRunner.setDbDir(appModel.getModelDb("./db"));
      scriptRunner.setScript(render(statements));
      for (Object anImport : imports)
         scriptRunner.addImports(anImport);
      return scriptRunner;
   }

   public Collection<STArgumentKV> getStArgumentKVS(STParameter stParameter, STArgument stArgument) {
      final Collection<STArgumentKV> kvSet = new LinkedHashSet<>();
      stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues()
            .filter(stArgumentKV -> stArgumentKV.getStParameterKey()
                  .equals(stParameterKey
                        .getUuid()))
            .forEach(kvSet::add));
      return kvSet;
   }

   public STWorkspace getWorkspace() {
      if (stWorkspace == null)
         stWorkspace = new STWorkspace(this);
      return stWorkspace;
   }

   public <T> Optional<T> isInstanceOf(Object object, Class<T> type) {
      return Optional.ofNullable(object.getClass().isAssignableFrom(type) ? (T) object : null);
   }

   public ImageIcon loadIcon(String iconName) {
      return loadIcon(iconName, "16x16");
   }

   public ImageIcon loadIcon(String iconName, String dimension) {

      if (iconName == null) return null;

      if (cache.containsKey(iconName)) return cache.get(iconName);

      URL resource = getClass().getClassLoader().getResource("icons/" + iconName + dimension + ".png");
      if (resource == null) resource = getClass().getClassLoader().getResource("icons/STGroup16x16.png");

      cache.put(iconName, new ImageIcon(Objects.requireNonNull(resource)));
      return cache.get(iconName);
   }

   public Project newProject(Node node) {
      return db.newProject(node);
   }

   public Project newProject(String name) {
      return db.newProject(name);
   }


   public Pair<STArgument, STValue> newSTArgument(STParameter stParameter, String value) {
      final STValue stValue = newSTValue(value);
      final STArgument stArgument = db.newSTArgument(stParameter, stValue);
      return new Pair<>(stArgument, stValue);
   }

   public STArgument newSTArgument(STParameter stParameter, STValue stValue) {
      return db.newSTArgument(stParameter, stValue);
   }

   public STArgument newSTArgument(STParameter stParameter, List<STArgumentKV> kvs) {
      return db.newSTArgument(stParameter, kvs);
   }

   public STArgumentKV newSTArgumentKV(STParameterKey stParameterKey, STValue stValue) {
      return db.newSTArgumentKV(stParameterKey, stValue);
   }

   public STEnum newSTEnum(String name) {
      return STJsonFactory.newSTEnum()
            .setName(name);
   }

   public STFile newSTFile(String name, String type, String path, String packageName) {
      return db.newSTFile(name, type, path, packageName);
   }

   public STFile newSTFile(Node node) {
      return db.newSTFile(node);
   }

   public STGroupModel newSTGroupModel(String name) {
      return STJsonFactory.newSTGroupModel()
            .setName(name)
            .setDelimiter(STGenerator.DELIMITER);
   }

   public STInterface newSTInterface(String name) {
      return STJsonFactory.newSTInterface()
            .setName(name);
   }

   public STModel newSTModel(Node node) {
      return db.newSTModel(node);
   }

   public STTemplate newSTTemplate(String name) {
      final STTemplate stTemplate = STJsonFactory.newSTTemplate()
            .setName(name)
            .setText("");
      return stTemplate;
   }

   public STValue newSTValue(String s) {
      return db.newSTValue(s);
   }

   public STValue newSTValue(STModel stModel) {
      return db.newSTValue(stModel);
   }

   public STValue newSTValue(STEnumValue stEnum) {
      return db.newSTValue(stEnum);
   }

   public STValue newSTValue(Node node) {
      return db.newSTValue(node);
   }

   public Script newScript(String name) {
      return db.newScript(name);
   }

   public Script newScript(Node node) {
      return db.newScript(node);
   }

   public void reconcileValues() {
      final Set<Node> delete = new LinkedHashSet<>();

      db.doInTransaction(transaction ->
            db.findAllSTValue()
                  .filter(stValue -> !delete.contains(stValue.getNode()))
                  .filter(this::isValidPrimitive)
                  .forEach(stValue -> db.findAllSTValueByValue(stValue.getValue())
                        .filter(duplicate -> !duplicate.getUuid().equals(stValue.getUuid()))
                        .filter(duplicate -> !delete.contains(duplicate.getNode()))
                        .filter(this::isValidPrimitive)
                        .forEach(duplicate -> {

                           log.info("\t duplicate " + duplicate.getValue());

                           final Node duplicateNode = duplicate.getNode();
                           duplicateNode.getRelationships(Direction.INCOMING)
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
            node.getRelationships().forEach(Relationship::delete);
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
      stArgument.getKeyValues()
            .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
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

      stParameter.getKeys().forEach(stParameterKey -> {
         out.append(stParameterKey.getName()).append(":\n");
         kvArgument.getKeyValues()
               .filter(stArgumentKV1 -> stArgumentKV1.getStParameterKey().equals(stParameterKey.getUuid()))
               .forEach(stArgumentKV1 -> out.append(render(stArgumentKV1.getValue())));
         out.append("\n\n");
      });

      return out.toString();
   }

   public void runScript(JComponent canvas, Script script) {
      doLaterInTransaction(tx -> {
         try {

            final nextgen.st.STAppPresentationModel.CompilationResult compilationResult = generateScriptCode(script);

            if (compilationResult.aClass == null) {
               JOptionPane
                     .showMessageDialog(canvas, compilationResult.compilerOutput, "Compilation Exception", JOptionPane.ERROR_MESSAGE);
               return;
            }

            ((Runnable) compilationResult.aClass
                  .getConstructor(nextgen.st.model.STModelDB.class, nextgen.st.STRenderer.class)
                  .newInstance(db, stRenderer))
                  .run();

         } catch (Throwable ex) {
            nextgen.utils.SwingUtil.showException(canvas, ex);
         }
      });
   }

   public boolean sameArgumentValue(STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue model) {
      final java.util.concurrent.atomic.AtomicBoolean exists = new java.util.concurrent.atomic.AtomicBoolean(false);
      stModel.getArguments()
            .filter(existing -> existing.getStParameter().equals(stParameter.uuid()))
            .forEach(existing -> {
               if (existing.getValue() != null && existing.getValue().getUuid().equals(model.getUuid()))
                  exists.set(true);
            });
      return exists.get();
   }

   public void save(STGroupModel stGroupModel) {

      final STGParseResult parseResult = STParser.parse(toSTGroup(stGroupModel));

      if (parseResult.getErrors().count() == 0) {
         stgDirectories
               .stream()
               .filter(directory -> directory.getGroups()
                     .anyMatch(stGroupModel1 -> stGroupModel1.getUuid()
                           .equals(stGroupModel
                                 .getUuid())))
               .findFirst()
               .ifPresent(directory -> {
                  final File file = new File(new File(directory.getPath()), stGroupModel.getName() + ".json");
                  log.info("saving stGroup " + stGroupModel.getName() + " to " + file.getAbsolutePath());
                  STGenerator.write(file, stGroupModel.getJsonObject().encodePrettily());
               });
      } else {
         log.error(stGroupModel.getName() + " has errors: ");
         parseResult.getErrors()
               .forEach(stgError -> log
                     .error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError
                           .getLine()));
      }
   }

   public void setLastDir(File dir) {
      this.lastDir = lastDir;
   }

   public STArgumentConsumer stArgumentConsumer(STParameter stParameter) {
      return new STArgumentConsumer(stParameter);
   }

   public String tryToFindArgument(Stream<STArgumentKV> set, STParameter stParameter, String kvName, Supplier<String> defaultValue) {

      final Optional<STParameterKey> kvNameFound = stParameter.getKeys()
            .filter(stParameterKey -> stParameterKey.getName()
                  .equals(kvName))
            .findFirst();
      if (!kvNameFound.isPresent()) return defaultValue.get();

      final Optional<STArgumentKV> found = set.filter(stArgumentKV -> stArgumentKV.getStParameterKey()
            .equals(kvNameFound.get().getUuid()))
            .findFirst();
      if (found.isPresent()) {
         final String render = render(found.get().getValue());
         return render == null || render.length() == 0 ? "[EMPTY]" : render;
      }

      return defaultValue.get();
   }

   public String tryToFindArgument(STModel stModel, String parameterName, Supplier<String> defaultValue) {
      final Optional<STParameter> parameter = findSTTemplateByUuid(stModel.getStTemplate()).getParameters()
            .filter(stParameter -> stParameter
                  .getName()
                  .equals(parameterName))
            .findFirst();
      if (parameter.isPresent()) {
         final Optional<STArgument> argument = stModel.getArguments()
               .filter(stArgument -> stArgument.getStParameter()
                     .equals(parameter.get()
                           .getUuid()))
               .findFirst();
         return argument.isPresent() ? render(argument.get().getValue()) : defaultValue.get();
      }
      return defaultValue.get();
   }

   public void writeToFile(STModel stModel) {
      doLaterInTransaction(tx -> stModel.getFiles().forEach(stFile -> {
         if (stFile.getPath() == null) return;
         nextgen.st.STGenerator.writeToFile(render(stModel), stFile.getPackageName().getValue(), stFile.getName()
               .getValue(), stFile
               .getType()
               .getValue(), new java.io.File(stFile.getPath().getValue()));
      }));
   }

   public void setMultiple(JComponent owner, STModel model, STTemplate stTemplate, Consumer<STModel> onSuccess) {
      final Map<String, JTextField> fieldMap = new LinkedHashMap<>();
      final Map<String, STParameter> parameterMap = new LinkedHashMap<>();
      final Map<String, STArgument> argumentMap = new LinkedHashMap<>();

      stTemplate.getParameters()
            .filter(stParameter -> stParameter.getType().equals(STParameterType.SINGLE))
            .forEach(stParameter -> {
               final Optional<STArgument> argument = model.getArguments()
                     .filter(stArgument -> stArgument.getStParameter()
                           .equals(stParameter
                                 .getUuid()))
                     .findFirst();
               final String content = argument.isPresent() ? render(argument.get().getValue().getStModel()) : "";
               fieldMap.put(stParameter.getName(), newTextField(content, 15));
               parameterMap.put(stParameter.getName(), stParameter);
               if (argument.isPresent())
                  argumentMap.put(stParameter.getName(), argument.get());
            });

      final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(new JLabel(fieldEntry.getKey()));
         inputPanel.add(fieldEntry.getValue());
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
                        stArgument.setValue(newSTValue(value));
                  } else if (value.length() != 0) {
                     model.addArguments(newSTArgument(stParameter, value).getValue0());
                  }

               }
            });
         }
      });
   }

   public void generateNeoSource(STModel model) {
      generateNeoSources(Collections.singleton(model), "TestNeo");
   }


   public void generateNeoSources(Set<STModel> stModels, String className) {
      doLaterInTransaction(transaction -> {

         final nextgen.templates.java.PackageDeclaration packageDeclaration = nextgen.templates.java.JavaST
               .newPackageDeclaration()
               .setName("tmp");

         final Collection<String> neoFacades = new LinkedHashSet<>();
         final Collection<String> modelStatements = new LinkedHashSet<>();

         stModels.forEach(stModel -> stRenderer.renderNeoCode(stModel, neoFacades, modelStatements));

         final StringBuilder statements = new StringBuilder();
         for (String neoFacade : neoFacades) {
            statements.append("\n").append(neoFacade);
         }

         statements.append("\n");

         for (String modelStatement : modelStatements) {
            statements.append("\n").append(modelStatement);
         }

         final STValue stValue = db.newSTValue()
               .setUuid(UUID.randomUUID().toString())
               .setType(PRIMITIVE)
               .setValue(statements.toString());

         STGenerator.writeJavaFile(getScriptRunner(stValue, packageDeclaration, Collections.emptyList(), className), packageDeclaration
               .getName(), className, new File(appModel.getRootDir()));

         db.remove(stValue);
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

   public void runJUnit(STModel model, STTemplate stTemplate, STModel project) {
      if (stTemplate.getName().equals("ProjectGenerator") || stTemplate.getName().equals("Project")) {
         doInTransaction(transaction -> {

            final MavenNeo mavenDB = new MavenNeo(db);
            final ProjectModel projectModel = mavenDB.newProjectModel(project);
            final ProjectGeneratorModel generatorModel = mavenDB.newProjectGeneratorModel(model);

            final String className = render(projectModel.getName());
            final String packageName = render(projectModel.getPackageName());

            final TestRunner testRunner = MavenPatterns.newTestRunner()
                  .setName(className + System.currentTimeMillis())
                  .setProjectName(className)
                  .setPackageName(packageName);

            projectModel.getGenerators()
                  .map(stValue -> mavenDB.newProjectGeneratorModel(stValue.getStModel()))
                  .forEach(projectGeneratorModel -> testRunner.addGenerators(render(projectGeneratorModel.getName()),
                        !stTemplate.getName().equals("ProjectGenerator") || projectGeneratorModel.getUuid()
                              .equals(generatorModel.getUuid())
                  ));
            try {

               final Class<?> aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(testRunner.getPackageName() + "." + testRunner
                     .getName(), testRunner.toString());

               final Method main = aClass.getDeclaredMethod("main", String[].class);
               String[] params = null;
               main.invoke(null, (Object) params);

            } catch (Throwable t) {
               t.printStackTrace();
            }
         });

      }
   }

   public void undoLast() {
      chronicle.rollbackLast();
      ;
   }

   public Stream<STValue> getSelectedSTValues() {
      return getWorkspace()
            .findCanvas()
            .getSelectedNodes()
            .filter(baseCanvasNode -> baseCanvasNode instanceof STModelCanvas.STValueNode)
            .map(baseCanvasNode -> (STModelCanvas.STValueNode) baseCanvasNode)
            .map(STModelCanvas.BaseCanvasNode::getModel);
   }

   public Stream<STModel> getSelectedSTModels() {
      return getWorkspace()
            .findCanvas()
            .getSelectedNodes()
            .filter(baseCanvasNode -> baseCanvasNode instanceof STModelCanvas.STModelNode)
            .map(baseCanvasNode -> (STModelCanvas.STModelNode) baseCanvasNode)
            .map(STModelCanvas.BaseCanvasNode::getModel);
   }

   public STModelEditor getModelEditor(STModel model) {
      return getWorkspace().getModelEditor(db.getSTTemplate(model), model);
   }

   public WorkFlowFacade getWorkspaceFacade() {
      return workFlowFacade;
   }

   public void importDomain(String s) {
      DomainUtil.importDomain(s, workFlowFacade);
   }


   public static final class CompilationResult {

      public final String compilerOutput;
      public final Class<?> aClass;

      public CompilationResult(String compilerOutput, Class<?> aClass) {
         this.compilerOutput = compilerOutput;
         this.aClass = aClass;
      }
   }

   public final class STArgumentConsumer implements Consumer<STArgument> {

      private final STParameter stParameter;

      private BiConsumer<STArgument, STValue> onSingleSTValueConsumer = (stArgument, stValue) -> {
      };
      private BiConsumer<STArgument, STValue> onSingleSTModelConsumer = (stArgument, stValue) -> {
      };
      private BiConsumer<STArgument, STValue> onSingleEnumConsumer = (stArgument, stValue) -> {
      };

      private BiConsumer<STArgument, STValue> onListSTValueConsumer = (stArgument, stValue) -> {
      };
      private BiConsumer<STArgument, STValue> onListSTModelConsumer = (stArgument, stValue) -> {
      };
      private BiConsumer<STArgument, STValue> onListEnumConsumer = (stArgument, stValue) -> {
      };

      private BiConsumer<STArgument, Collection<STArgumentKV>> onKVListConsumer = (stArgument, stArgumentKVS) -> {
      };
      private BiConsumer<STArgumentKV, STValue> onKVListSTValueConsumer = (stArgumentKV, stValue) -> {

      };
      private BiConsumer<STArgumentKV, STValue> onKVListSTModelConsumer = (stArgumentKV, stValue) -> {

      };
      private BiConsumer<STArgumentKV, STValue> onKVListEnumConsumer = (stArgumentKV, stValue) -> {

      };

      private STArgumentConsumer(STParameter stParameter) {
         this.stParameter = stParameter;
      }

      @Override
      public void accept(STArgument stArgument) {
         final STValue value = stArgument.getValue();
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

               stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues()
                     .filter(stArgumentKV -> stArgumentKV
                           .getStParameterKey()
                           .equals(stParameterKey
                                 .getUuid()))
                     .filter(stArgumentKV -> stArgumentKV
                           .getValue() != null)
                     .forEach(stArgumentKV -> {
                        final STValue kvValue = stArgumentKV
                              .getValue();
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

      public STArgumentConsumer onKVListConsumer(BiConsumer<STArgument, Collection<STArgumentKV>> consumer) {
         this.onKVListConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListEnum(BiConsumer<STArgumentKV, STValue> consumer) {
         this.onKVListEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListSTModel(BiConsumer<STArgumentKV, STValue> consumer) {
         this.onKVListSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onKVListSTValue(BiConsumer<STArgumentKV, STValue> consumer) {
         this.onKVListSTValueConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListEnum(BiConsumer<STArgument, STValue> consumer) {
         this.onListEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListSTModel(BiConsumer<STArgument, STValue> consumer) {
         this.onListSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onListSTValue(BiConsumer<STArgument, STValue> consumer) {
         this.onListSTValueConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleEnum(BiConsumer<STArgument, STValue> consumer) {
         this.onSingleEnumConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleSTModel(BiConsumer<STArgument, STValue> consumer) {
         this.onSingleSTModelConsumer = consumer;
         return this;
      }

      public STArgumentConsumer onSingleSTValue(BiConsumer<STArgument, STValue> consumer) {
         this.onSingleSTValueConsumer = consumer;
         return this;
      }
   }

   public Stream<STArgument> getArguments(STModel stModel, STParameter stParameter) {
      return stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()));
   }

   public void setParameter(STParameter stParameter, STModel stModel, JComponent parent, Consumer<org.javatuples.Pair<STArgument, STValue>> consumer) {
      setParameter(stParameter, stModel, parent, consumer, true);
   }

   public void addList(STParameter stParameter, STModel stModel, JComponent parent, Consumer<org.javatuples.Pair<STArgument, STValue>> consumer) {
      setParameter(stParameter, stModel, parent, consumer, false);
   }

   public void setParameter(STParameter stParameter, STModel stModel, JComponent parent, Consumer<org.javatuples.Pair<STArgument, STValue>> consumer, boolean singleValue) {

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
               final STValue stValue = newSTValue(db.newSTModel(stGroupModel.getUuid(), stTemplate));
               addParameter(stParameter, stModel, consumer, stValue);

            } else {
               SwingUtil.showInputDialog(stParameter.getName(), parent, inputValue ->
                     doLaterInTransaction(transaction2 -> {
                        if (singleValue) removeArgument(stModel, stParameter);
                        addParameter(stParameter, stModel, consumer, inputValue);
                     }));
            }
         } else {
            final STGroupModel stGroupModel = stRenderer.findSTGroupModel(db.getSTTemplate(stModel));
            final STTemplate stTemplate = STModelUtil.findSTemplateByName(argumentType, stGroupModel);
            if (stTemplate != null) {
               if (singleValue) removeArgument(stModel, stParameter);
               final STValue stValue = newSTValue(db.newSTModel(stGroupModel.getUuid(), stTemplate));
               addParameter(stParameter, stModel, consumer, stValue);
            } else {

               final Set<STTemplate> interfaces = STModelUtil.findSTInterfacesByName(argumentType, stGroupModel);
               if (!interfaces.isEmpty()) {

                  if (interfaces.size() == 1) {
                     doLaterInTransaction(transaction2 -> {
                        if (singleValue) removeArgument(stModel, stParameter);
                        final STValue stValue = newSTValue(db.newSTModel(stGroupModel.getUuid(), interfaces.iterator()
                              .next()));
                        addParameter(stParameter, stModel, consumer, stValue);
                     });
                     return;
                  }

                  SwingUtil.showSelectDialog("Select", parent, interfaces, stTemplate1 -> {
                     doLaterInTransaction(transaction2 -> {
                        if (singleValue) removeArgument(stModel, stParameter);
                        final STValue stValue = newSTValue(db.newSTModel(stGroupModel.getUuid(), stTemplate1));
                        addParameter(stParameter, stModel, consumer, stValue);
                     });
                  });

               } else {

                  final STEnum stEnum = STModelUtil.findSTEnumByName(argumentType, stGroupModel);
                  if (stEnum != null) {

                     SwingUtil.showSelectDialog("Select", parent, stEnum.getValues()
                           .collect(Collectors.toSet()), stEnumValue -> {
                        doLaterInTransaction(transaction2 -> {
                           if (singleValue) removeArgument(stModel, stParameter);
                           final STValue stValue = newSTValue(stEnumValue);
                           addParameter(stParameter, stModel, consumer, stValue);
                        });
                     });

                  } else {
                     SwingUtil.showInputDialog(stParameter.getName(), parent, inputValue ->
                           doLaterInTransaction(transaction2 -> {
                              if (singleValue) removeArgument(stModel, stParameter);
                              addParameter(stParameter, stModel, consumer, inputValue);
                           }));
                  }
               }
            }
         }
      });
   }

   public void addParameter(STParameter stParameter, STModel stModel, Consumer<Pair<STArgument, STValue>> consumer, String inputValue) {
      final Pair<STArgument, STValue> newArgument = newSTArgument(stParameter, inputValue);
      stModel.addArguments(newArgument.getValue0());
      consumer.accept(newArgument);
   }

   public void addParameter(STParameter stParameter, STModel stModel, Consumer<Pair<STArgument, STValue>> consumer, STValue stValue) {
      final Pair<STArgument, STValue> newArgument = new Pair<>(newSTArgument(stParameter, stValue), stValue);
      stModel.addArguments(newArgument.getValue0());
      consumer.accept(newArgument);
   }
}