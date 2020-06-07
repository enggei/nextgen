package nextgen.templates;

import com.generator.util.FileUtil;
import nextgen.templates.maven.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.generator.util.FileUtil.tryToCreateDirIfNotExists;
import static com.generator.util.FileUtil.tryToCreateFileIfNotExists;

public class MavenPatterns extends MavenST {

    public static void generate(Project project) {

        tryToCreateDirIfNotExists(newFile(project.getRoot()));

        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/assembly"));

        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/main/java"));
        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/main/resources"));
        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/main/filters"));
        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/main/webapp"));

        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/test/java"));
        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/test/resources"));
        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/test/filters"));

        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/it"));
        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/assembly"));
        tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/site"));

        tryToCreateFileIfNotExists(newFile(project.getRoot(), "LICENSE.txt"));
        tryToCreateFileIfNotExists(newFile(project.getRoot(), "NOTICE.txt"));
        tryToCreateFileIfNotExists(newFile(project.getRoot(), "README.txt"));

        writePom(project.getPom(), project.getRoot());
    }

    private static File newFile(Object path) {
        return new File(path.toString());
    }

    private static File newFile(Object path, String child) {
        return new File(path.toString(), child);
    }

    private static void writePom(Object pom, Object dir) {
        FileUtil.write(pom, new File(dir.toString(), "pom.xml"));
    }

    public static Pom.Pom_Properties setMavenCompilerSource(String version) {
        return newPomProperties("maven.compiler.source", version);
    }

    public static Pom.Pom_Properties setMavenCompilerTarget(String version) {
        return newPomProperties("maven.compiler.target", version);
    }

    public static Pom.Pom_Properties setProjectBuildSourceEncoding(String encoding) {
        return newPomProperties("project.build.sourceEncoding", encoding);
    }

    public static Pom.Pom_Properties setProjectReportingOutputEncoding(String encoding) {
        return newPomProperties("project.reporting.outputEncoding", encoding);
    }

    public static Pom.Pom_Properties newPomProperties(Object name, Object value) {
        return new Pom.Pom_Properties(name, value);
    }

    public static PropertyReference newPropertyReference(String name) {
        return newPropertyReference().setName(name);
    }

    public static Dependency newDependency(Object groupId, Object artifactId, Object version) {
        return newDependency()
                .setGroupId(groupId)
                .setArtifactId(artifactId)
                .setVersion(version);
    }

    public static Dependency newDependency(String xml) {

        final Dependency dependency = newDependency()
                .setArtifactId(parseDependency("artifactId", xml))
                .setGroupId(parseDependency("groupId", xml))
                .setVersion(parseDependency("version", xml));

//        JavaPatterns.generate(fluent(
//                newMethodCallExpression(null, "newDependency"),
//                newMethodCallExpression(null, "setArtifactId", newStringLiteralExpression(dependency.getArtifactId())),
//                newMethodCallExpression(null, "setGroupId", newStringLiteralExpression(dependency.getGroupId())),
//                newMethodCallExpression(null, "setVersion", newStringLiteralExpression(JavaPatterns.generate(dependency.getVersion())))
//        ));

        return dependency;
    }

    public static void addDependencyGroup(Pom pom, DependencyGroup dependencyGroup) {
        final String groupPropertyName = dependencyGroup.getName() + ".version";
        if (pom.streamProperties().anyMatch(pom_Properties -> pom_Properties.getName().equals(groupPropertyName)))
            return;
        pom.addProperties(newPomProperties(groupPropertyName, dependencyGroup.getVersion()));
        dependencyGroup.getArtifacts().forEach(artifact -> pom.addDependencies(newDependency(dependencyGroup.getGroupId(), artifact, newPropertyReference(groupPropertyName))));
    }

    public static Set<Dependency> importDependencies(File pomPath) {

        final Set<Dependency> dependencies = new LinkedHashSet<>();

        try {
            FileUtil.readString(pomPath, new FileUtil.LineHandler() {

                private StringBuilder xml;

                @Override
                public boolean handleLine(String line) {
                    if (line.toLowerCase().contains("<dependency>")) {
                        xml = new StringBuilder();
                    } else if (line.toLowerCase().contains("</dependency>")) {
                        dependencies.add(newDependency(xml.toString().trim()));
                        xml = null;
                    } else if (xml != null) {
                        xml.append(line.trim()).append("\n");
                    }
                    return false;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dependencies;
    }

    private static String parseDependency(String element, String text) {
        final Pattern compile = Pattern.compile("<" + element + ">(.+)</" + element + ">", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = compile.matcher(text.trim().toLowerCase());
        if (matcher.find()) return matcher.group(1);
        return null;
    }
}