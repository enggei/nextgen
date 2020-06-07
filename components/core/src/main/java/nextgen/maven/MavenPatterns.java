package nextgen.maven;

import com.generator.util.FileUtil;
import nextgen.java.JavaPatterns;
import nextgen.maven.st.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.generator.util.FileUtil.tryToCreateDirIfNotExists;
import static com.generator.util.FileUtil.tryToCreateFileIfNotExists;
import static nextgen.java.JavaPatterns.*;

@Deprecated
public class MavenPatterns extends MavenFactory {

    private static final MavenGenerator mavenGenerator = new MavenGenerator();

    public static void generate(Project project) {

        tryToCreateDirIfNotExists(new File(project.getRoot()));

        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/assembly"));

        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/main/java"));
        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/main/resources"));
        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/main/filters"));
        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/main/webapp"));

        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/test/java"));
        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/test/resources"));
        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/test/filters"));

        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/it"));
        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/assembly"));
        tryToCreateDirIfNotExists(new File(project.getRoot(), "src/site"));

        tryToCreateFileIfNotExists(new File(project.getRoot(), "LICENSE.txt"));
        tryToCreateFileIfNotExists(new File(project.getRoot(), "NOTICE.txt"));
        tryToCreateFileIfNotExists(new File(project.getRoot(), "README.txt"));

        writePom(project.getPom(), project.getRoot());
    }

    private static void writePom(pom pom, String dir) {
        FileUtil.write(mavenGenerator.generate(pom), new File(dir, "pom.xml"));
    }

    public static pomProperties setMavenCompilerSource(String version) {
        return newPomProperties("maven.compiler.source", version);
    }

    public static pomProperties setMavenCompilerTarget(String version) {
        return newPomProperties("maven.compiler.target", version);
    }

    public static pomProperties setProjectBuildSourceEncoding(String encoding) {
        return newPomProperties("project.build.sourceEncoding", encoding);
    }

    public static pomProperties setProjectReportingOutputEncoding(String encoding) {
        return newPomProperties("project.reporting.outputEncoding", encoding);
    }

    public static pomProperties newPomProperties(String name, String value) {
        return newPomProperties().setName(name).setValue(value);
    }

    public static propertyReference newPropertyReference(String name) {
        return newPropertyReference().setName(name);
    }

    public static dependency newDependency(String groupId, String artifactId, Object version) {
        return newDependency()
                .setGroupId(groupId)
                .setArtifactId(artifactId)
                .setVersion(version);
    }

    public static dependency newDependency(String xml) {

        final dependency dependency = newDependency()
                .setArtifactId(parseDependency("artifactId", xml))
                .setGroupId(parseDependency("groupId", xml))
                .setVersion(parseDependency("version", xml));

        JavaPatterns.generate(fluent(
                newMethodCallExpression(null, "newDependency"),
                newMethodCallExpression(null, "setArtifactId", newStringLiteralExpression(dependency.getArtifactId())),
                newMethodCallExpression(null, "setGroupId", newStringLiteralExpression(dependency.getGroupId())),
                newMethodCallExpression(null, "setVersion", newStringLiteralExpression(JavaPatterns.generate(dependency.getVersion())))
        ));

        return dependency;
    }

    public static void addDependencyGroup(pom pom, DependencyGroup dependencyGroup) {
        final String groupPropertyName = dependencyGroup.getName() + ".version";
        if (pom.getProperties().stream().anyMatch(pomProperties -> pomProperties.getName().equals(groupPropertyName)))
            return;
        pom.addProperties(newPomProperties(groupPropertyName, dependencyGroup.getVersion()));
        dependencyGroup.getArtifacts().forEach(artifact -> pom.addDependencies(newDependency(dependencyGroup.getGroupId(), artifact, newPropertyReference(groupPropertyName))));
    }

    public static Set<dependency> importDependencies(File pomPath) {

        final Set<dependency> dependencies = new LinkedHashSet<>();

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

    public static void printDependenciesAsFluent(File file) {
        importDependencies(file)
                .forEach(dependency -> System.out.println(JavaPatterns.generate(newMethodCallExpression("", "addDependencies", newMethodCallExpression(null, "newDependency")
                        .addArguments(newStringLiteralExpression(dependency.getGroupId()))
                        .addArguments(newStringLiteralExpression(dependency.getArtifactId()))
                        .addArguments(newStringLiteralExpression(JavaPatterns.generate(dependency.getVersion())))
                ))));
    }

    private static String parseDependency(String element, String text) {
        final Pattern compile = Pattern.compile("<" + element + ">(.+)</" + element + ">", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = compile.matcher(text.trim().toLowerCase());
        if (matcher.find()) return matcher.group(1);
        return null;
    }
}