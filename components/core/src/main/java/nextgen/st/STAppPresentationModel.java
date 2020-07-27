package nextgen.st;

import io.vertx.core.json.JsonObject;
import nextgen.st.domain.*;
import nextgen.st.model.*;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextgen.st.STGenerator.toSTGroup;

public class STAppPresentationModel {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppPresentationModel.class);

    public final STRenderer stRenderer;
    public final STModelDB db;

    final STGDirectory generatorSTGDirectory;
    final STGroupModel generatorSTGroup;
    final Set<STGDirectory> stgDirectories = new LinkedHashSet<>();
    private Font preferredFont;

    STAppPresentationModel(STAppModel appModel) {

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

        this.db = new STModelDB(appModel.getModelDb("./db"), stGroups);
        this.stRenderer = new STRenderer(stGroups);

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

        if (parseResult.getErrors().count() == 0)
            stgDirectories
                    .stream()
                    .filter(directory -> directory.getGroups().anyMatch(stGroupModel1 -> stGroupModel1.uuid().equals(stGroupModel.uuid())))
                    .findFirst()
                    .ifPresent(directory -> {
                        log.info("generating stGroup " + stGroupModel.getName() + " to " + directory.getOutputPath() + " " + directory.getOutputPackage());
                        new STGenerator(generatorSTGroup).generateSTGroup(stGroupModel, directory.getOutputPackage(), directory.getOutputPath());
                    });
        else {
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
}