package nextgen.st;

import io.vertx.core.json.JsonObject;
import net.openhft.compiler.CompilerUtils;
import nextgen.st.domain.*;
import nextgen.st.model.*;
import nextgen.st.script.Script;
import nextgen.st.script.ScriptNeoFactory;
import nextgen.st.stringtemplate.ScriptRunner;
import nextgen.st.stringtemplate.StringTemplateST;
import nextgen.templates.java.ImportDeclaration;
import nextgen.templates.java.PackageDeclaration;
import org.neo4j.graphdb.Node;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextgen.utils.StringUtil.capitalize;
import static nextgen.st.STGenerator.toSTGroup;

public class STAppPresentationModel {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppPresentationModel.class);

    private final STAppModel appModel;
    public final STRenderer stRenderer;
    public final STModelDB db;
    public final ScriptNeoFactory scripts;

    final STGDirectory generatorSTGDirectory;
    final STGroupModel generatorSTGroup;
    final Set<STGDirectory> stgDirectories = new LinkedHashSet<>();
    private Font preferredFont;

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
        this.scripts = new ScriptNeoFactory(this.db.getDatabaseService());

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

    public static final class CompilationResult {

        public final String compilerOutput;
        public final Class<?> aClass;

        public CompilationResult(String compilerOutput, Class<?> aClass) {
            this.compilerOutput = compilerOutput;
            this.aClass = aClass;
        }
    }
}