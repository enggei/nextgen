package nextgen.st;

import io.vertx.core.json.JsonObject;
import net.openhft.compiler.CompilerUtils;
import nextgen.st.domain.*;
import nextgen.st.model.*;
import nextgen.st.model.Script;
import nextgen.st.stringtemplate.ScriptRunner;
import nextgen.st.stringtemplate.StringTemplateST;
import nextgen.templates.java.ImportDeclaration;
import nextgen.templates.java.PackageDeclaration;
import nextgen.utils.Neo4JUtil;
import nextgen.utils.SwingUtil;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import javax.lang.model.SourceVersion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.util.List;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextgen.utils.StringUtil.capitalize;
import static nextgen.st.STGenerator.toSTGroup;
import static nextgen.utils.SwingUtil.newTextField;

public class STAppPresentationModel {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppPresentationModel.class);

    private final STAppModel appModel;
    public final STRenderer stRenderer;
    public final STModelDB db;

    final STGDirectory generatorSTGDirectory;
    final STGroupModel generatorSTGroup;
    final Set<STGDirectory> stgDirectories = new LinkedHashSet<>();
    private Font preferredFont;
    private STWorkspace stWorkspace;

    STAppPresentationModel(STAppModel appModel) {

        this.appModel = appModel;

        final File jsonFileDir = new File(appModel.getGeneratorRoot(), STGenerator.packageToPath(appModel.getGeneratorPackage()));
        this.generatorSTGroup = new STGroupModel(new JsonObject(STParser.read(new File(jsonFileDir, appModel.getGeneratorName() + ".json"))));
        this.generatorSTGDirectory = STJsonFactory.newSTGDirectory()
                .setOutputPath(appModel.getGeneratorRoot())
                .setOutputPackage(appModel.getGeneratorPackage())
                .setPath(jsonFileDir.getAbsolutePath())
                .addGroups(generatorSTGroup);

        final Set<STGroupModel> stGroups = new LinkedHashSet<>();
        appModel.getDirectories().forEach(stgDirectory -> {
            stgDirectories.add(stgDirectory);
            stGroups.addAll(stgDirectory.getGroups().collect(Collectors.toSet()));
        });

        this.stRenderer = new STRenderer(stGroups);
        this.db = new STModelDB(appModel.getModelDb("./db"), stGroups);

        final Set<String> fonts = new HashSet<>(Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
        this.preferredFont = Stream
                .of("Hack", "Fira Code", "Source Code Pro", "Monospaced")
                .filter(fonts::contains)
                .findFirst().map(s -> new Font(s, Font.PLAIN, appModel.getEditorFontSize(12)))
                .orElse(null);
    }


    Font getPreferredFont() {
        return preferredFont;
    }

    void generateSTGroup(STGroupModel stGroupModel) {

        final STGParseResult parseResult = STParser.parse(toSTGroup(stGroupModel));

        if (parseResult.getErrors().count() == 0) {

            final Optional<STGroupModel> found = generatorSTGDirectory.getGroups().filter(stGroupModel1 -> stGroupModel1.uuid().equals(stGroupModel.uuid())).findFirst();
            if (found.isPresent()) {
                log.info("generating stGroup " + stGroupModel.getName() + " to " + generatorSTGDirectory.getOutputPath() + " " + generatorSTGDirectory.getOutputPackage());
                new STGenerator(generatorSTGroup).generateSTGroup(stGroupModel, generatorSTGDirectory.getOutputPackage(), generatorSTGDirectory.getOutputPath());
            } else {
                stgDirectories
                        .stream()
                        .filter(directory -> directory.getGroups().anyMatch(stGroupModel1 -> stGroupModel1.uuid().equals(stGroupModel.uuid())))
                        .findFirst()
                        .ifPresent(directory -> {
                            log.info("generating stGroup " + stGroupModel.getName() + " to " + directory.getOutputPath() + " " + directory.getOutputPackage());
                            new STGenerator(generatorSTGroup).generateSTGroup(stGroupModel, directory.getOutputPackage(), directory.getOutputPath());
                        });
            }
        } else {
            log.error(stGroupModel.getName() + " has errors: ");
            parseResult.getErrors().forEach(stgError -> log.error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError.getLine()));
        }
    }

    public void save(STGroupModel stGroupModel) {

        final STGParseResult parseResult = STParser.parse(toSTGroup(stGroupModel));

        if (parseResult.getErrors().count() == 0)
            stgDirectories
                    .stream()
                    .filter(directory -> directory.getGroups().anyMatch(stGroupModel1 -> stGroupModel1.uuid().equals(stGroupModel.uuid())))
                    .findFirst()
                    .ifPresent(directory -> {
                        final File file = new File(new File(directory.getPath()), stGroupModel.getName() + ".json");
                        log.info("saving stGroup " + stGroupModel.getName() + " to " + file.getAbsolutePath());
                        STGenerator.write(file, stGroupModel.getJsonObject().encodePrettily());
                    });
        else {
            log.error(stGroupModel.getName() + " has errors: ");
            parseResult.getErrors().forEach(stgError -> log.error("\t" + stgError.getType() + " " + stgError.getCharPosition() + " at line " + stgError.getLine()));
        }
    }

    public String render(STModel stModel) {
        return stRenderer.render(stModel);
    }

    public String render(STValue stValue) {
        return stRenderer.render(stValue);
    }


    public STValue newSTValue(String s) {
        return db.newSTValue(s);
    }

    public STArgument newSTArgument(STParameter stParameter, STValue stValue) {
        return db.newSTArgument(stParameter, stValue);
    }

    public STValue newSTValue(STModel stModel) {
        return db.newSTValue(stModel);
    }

    public STArgumentKV newSTArgumentKV(STParameterKey stParameterKey, STValue stValue) {
        return db.newSTArgumentKV(stParameterKey, stValue);
    }

    public STArgument newSTArgument(STParameter stParameter, List<STArgumentKV> kvs) {
        return db.newSTArgument(stParameter, kvs);
    }

    public String getSTModelName(STModel stModel, String defaultName) {
        return db.getSTModelName(stModel, defaultName);
    }

    public String getSTModelPackage(STModel stModel, String defaultName) {
        return db.getSTModelPackage(stModel, defaultName);
    }

    public STFile newSTFile(String name, String type, String path, String packageName) {
        return db.newSTFile(name, type, path, packageName);
    }

    public Script newScript(String name) {
        return db.newScript(name);
    }

    public STModel newSTModel(Node node) {
        return db.newSTModel(node);
    }

    public STValue newSTValue(Node node) {
        return db.newSTValue(node);
    }

    public Script newScript(Node node) {
        return db.newScript(node);
    }

    public STFile newSTFile(Node node) {
        return db.newSTFile(node);
    }

    public Project newProject(Node node) {
        return db.newProject(node);
    }

    public Project newProject(String name) {
        return db.newProject(name);
    }

    public STTemplate findSTTemplateByUuid(String stTemplate) {
        return db.findSTTemplateByUuid(stTemplate);
    }

    public CompilationResult generateScriptCode(Script script) {

        final File srcRoot = new File(appModel.getRootDir());

        final nextgen.templates.java.PackageDeclaration packageDeclaration = nextgen.templates.java.JavaST.newPackageDeclaration()
                .setName("tmp");

        final Collection<ImportDeclaration> imports = new ArrayList<>();
        stgDirectories.forEach(directory -> {
            final String outputPackage = directory.getOutputPackage();
            final File templateClassDir = new File(srcRoot, STGenerator.packageToPath(outputPackage));

            directory.getGroups().forEach(stGroupModel -> {
                final String packageName = outputPackage + "." + stGroupModel.getName().toLowerCase();
                if (new File(srcRoot, STGenerator.packageToPath(packageName)).exists()) {
                    imports.add(nextgen.templates.java.JavaST.newImportDeclaration().setName(packageName + "." + capitalize(stGroupModel.getName() + "ST")).setIsAsterisk(true).setIsStatic(true));
                    imports.add(nextgen.templates.java.JavaST.newImportDeclaration().setName(packageName).setIsAsterisk(true));
                }
            });

            Arrays.stream(Objects.requireNonNull(templateClassDir.listFiles()))
                    .filter(file -> file.isFile() && file.getName().endsWith("Patterns.java"))
                    .forEach(file -> imports.add(nextgen.templates.java.JavaST.newImportDeclaration().setName(directory.getOutputPackage() + "." + capitalize(file.getName().substring(0, file.getName().length() - 5))).setIsAsterisk(true).setIsStatic(true)));
        });

        final String className = script.getName().replaceAll("[ ]", "");

        STGenerator.writeJavaFile(getRunner(script, packageDeclaration, imports, className), packageDeclaration.getName(), className, srcRoot);

        final java.io.StringWriter sr = new java.io.StringWriter();
        final java.io.PrintWriter compilerOutput = new java.io.PrintWriter(sr);
        try {
            final String cacheClassname = className + System.currentTimeMillis();
            final Object compilationUnit = getRunner(script, packageDeclaration, imports, cacheClassname);
            final Class<?> aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(getClass().getClassLoader(), packageDeclaration.getName() + "." + cacheClassname, compilationUnit.toString(), compilerOutput);
            return new CompilationResult(sr.toString(), aClass);
        } catch (Throwable t) {
            return new CompilationResult(sr.toString(), null);
        }
    }

    public Object getRunner(Script script, PackageDeclaration packageDeclaration, Collection<ImportDeclaration> imports, String className) {
        final ScriptRunner scriptRunner = StringTemplateST.newScriptRunner();
        scriptRunner.setPackageName(packageDeclaration.getName());
        scriptRunner.setName(className);
        scriptRunner.setTemplatesDir(appModel.getDirectories().findFirst().get().getPath());
        scriptRunner.setDbDir(appModel.getModelDb("./db"));
        scriptRunner.setScript(render(script.getScript()));
        for (Object anImport : imports)
            scriptRunner.addImports(anImport);
        return scriptRunner;
    }

    public STWorkspace getWorkspace() {
        if (stWorkspace == null)
            stWorkspace = new STWorkspace(this);
        return stWorkspace;
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

    public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer) {
        db.doInTransaction(consumer);
    }

    public void doInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer, java.util.function.Consumer<Throwable> throwableConsumer) {
        db.doInTransaction(consumer, throwableConsumer);
    }

    public void writeToFile(STModel stModel) {
        doLaterInTransaction(tx -> stModel.getFiles().forEach(stFile -> {
            if (stFile.getPath() == null) return;
            nextgen.st.STGenerator.writeToFile(render(stModel), stFile.getPackageName().getValue(), stFile.getName().getValue(), stFile.getType().getValue(), new java.io.File(stFile.getPath().getValue()));
        }));
    }

    public String tryToFindArgument(Collection<STArgumentKV> set, STParameter stParameter, String kvName, Supplier<String> defaultValue) {

        final Optional<STParameterKey> kvNameFound = stParameter.getKeys().filter(stParameterKey -> stParameterKey.getName().equals(kvName)).findFirst();
        if (!kvNameFound.isPresent()) return defaultValue.get();

        for (STArgumentKV stArgumentKV : set)
            if (stArgumentKV.getStParameterKey().equals(kvNameFound.get().uuid()))
                return render(stArgumentKV.getValue());

        return defaultValue.get();
    }

    public String tryToFindArgument(STModel stModel, String parameterName, Supplier<String> defaultValue) {
        final Optional<STParameter> parameter = findSTTemplateByUuid(stModel.getStTemplate()).getParameters().filter(stParameter -> stParameter.getName().equals(parameterName)).findFirst();
        if (parameter.isPresent()) {
            final Optional<STArgument> argument = stModel.getArguments().filter(stArgument -> stArgument.getStParameter().equals(parameter.get().uuid())).findFirst();
            return argument.isPresent() ? render(argument.get().getValue()) : defaultValue.get();
        }
        return defaultValue.get();
    }

    public STArgumentConsumer stArgumentConsumer(STParameter stParameter) {
        return new STArgumentConsumer(stParameter);
    }

    public Collection<STArgumentKV> getStArgumentKVS(STParameter stParameter, STArgument stArgument) {
        final Collection<STArgumentKV> kvSet = new LinkedHashSet<>();
        stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues()
                .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))
                .forEach(kvSet::add));
        return kvSet;
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

    public void runScript(JComponent canvas, Script script) {
        doLaterInTransaction(tx -> {
            try {

                final nextgen.st.STAppPresentationModel.CompilationResult compilationResult = generateScriptCode(script);

                if (compilationResult.aClass == null) {
                    JOptionPane.showMessageDialog(canvas, compilationResult.compilerOutput, "Compilation Exception", JOptionPane.ERROR_MESSAGE);
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

    public STGroupModel newSTGroupModel(String name) {
        return STJsonFactory.newSTGroupModel()
                .setName(name)
                .setDelimiter(STGenerator.DELIMITER);
    }

    public STTemplate newSTTemplate(String name) {
        final STTemplate stTemplate = STJsonFactory.newSTTemplate()
                .setName(name)
                .setText("");
        return stTemplate;
    }

    public STEnum newSTEnum(String name) {
        return STJsonFactory.newSTEnum()
                .setName(name);
    }

    public STInterface newSTInterface(String name) {
        return STJsonFactory.newSTInterface()
                .setName(name);
    }

    public void reconcileValues() {
        final Set<Node> delete = new LinkedHashSet<>();

        db.doInTransaction(transaction -> db.findAllSTValue()
                .filter(stValue -> stValue.getType() != null)
                .filter(stValue -> stValue.getValue() != null)
                .filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
                .forEach(stValue -> {
                    db.findAllSTValueByValue(stValue.getValue())
                            .filter(stValue1 -> !stValue1.getUuid().equals(stValue.getUuid()))
                            .filter(stValue1 -> stValue1.getType() != null)
                            .filter(stValue1 -> stValue1.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
                            .forEach(stValue1 -> {
                                log.info("\t duplicate " + stValue1.getValue());

                                final Node node = stValue1.getNode();
                                node.getRelationships(Direction.INCOMING).forEach(relationship -> {
                                    if (relationship.getType().equals(org.neo4j.graphdb.RelationshipType.withName("ref")))
                                        relationship.delete();

                                    final Node src = relationship.getOtherNode(node);
                                    final Relationship newRelation = src.createRelationshipTo(stValue.getNode(), relationship.getType());
                                    relationship.getPropertyKeys().forEach(s -> newRelation.setProperty(s, relationship.getProperty(s)));
                                    relationship.delete();
                                });

                                delete.add(node);
                            });
                }));

        db.doInTransaction(transaction -> {
            for (Node node : delete) {
                if (node.getRelationships().iterator().hasNext()) continue;
                log.info("deleting node ");
                log.info(Neo4JUtil.toString(node));
                node.delete();
            }
        });
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
            if (value == null || value.getType() == null) return;
            switch (stParameter.getType()) {
                case SINGLE:
                    switch (value.getType()) {
                        case STMODEL:
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
                    switch (value.getType()) {
                        case STMODEL:
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
                            .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))
                            .forEach(stArgumentKV -> {
                                final STValue kvValue = stArgumentKV.getValue();
                                switch (kvValue.getType()) {
                                    case STMODEL:
                                        onKVListSTModelConsumer.accept(stArgumentKV, kvValue);
                                        break;
                                    case PRIMITIVE:
                                        onKVListSTValueConsumer.accept(stArgumentKV, kvValue);
                                        break;
                                    case ENUM:
                                        onKVListEnumConsumer.accept(stArgumentKV, kvValue);
                                        break;
                                }
                            }));

                    break;
            }
        }

        public STArgumentConsumer onSingleSTModel(BiConsumer<STArgument, STValue> consumer) {
            this.onSingleSTModelConsumer = consumer;
            return this;
        }

        public STArgumentConsumer onSingleSTValue(BiConsumer<STArgument, STValue> consumer) {
            this.onSingleSTValueConsumer = consumer;
            return this;
        }

        public STArgumentConsumer onSingleEnum(BiConsumer<STArgument, STValue> consumer) {
            this.onSingleEnumConsumer = consumer;
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

        public STArgumentConsumer onListEnum(BiConsumer<STArgument, STValue> consumer) {
            this.onListEnumConsumer = consumer;
            return this;
        }

        public STArgumentConsumer onKVListConsumer(BiConsumer<STArgument, Collection<STArgumentKV>> consumer) {
            this.onKVListConsumer = consumer;
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

        public STArgumentConsumer onKVListEnum(BiConsumer<STArgumentKV, STValue> consumer) {
            this.onKVListEnumConsumer = consumer;
            return this;
        }
    }

    public static final class CompilationResult {

        public final String compilerOutput;
        public final Class<?> aClass;

        public CompilationResult(String compilerOutput, Class<?> aClass) {
            this.compilerOutput = compilerOutput;
            this.aClass = aClass;
        }
    }

    public static Action newAction(String name, Consumer<ActionEvent> consumer) {
        return new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
                consumer.accept(e);
            }
        };
    }

    public Action newTransactionAction(String name, Consumer<ActionEvent> consumer) {
        return new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> doInTransaction(transaction -> consumer.accept(e)));
            }
        };
    }

    public static Optional<String> isValidTemplateName(JComponent parent, STGroupModel stGroupModel, String name) {

        final Optional<STTemplate> existing = stGroupModel.getTemplates().filter(stTemplate -> stTemplate.getName().toLowerCase().equals(name.toLowerCase())).findAny();

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

}