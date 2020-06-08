package nextgen.projects;

import nextgen.templates.MavenPatterns;
import nextgen.templates.NpmPatterns;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.kotlin.DataClass;
import nextgen.templates.maven.DependencyGroup;
import nextgen.templates.maven.Pom;
import org.junit.Test;

import java.io.File;

import static nextgen.npm.st.NpmFactory.*;
import static nextgen.templates.JavaPatterns.newPackageDeclaration;
import static nextgen.templates.MavenPatterns.*;

public class DemoProject {

    private final File root = new File("/home/goe/projects/demo");
    private final File javaMainSrc = new File(root, "src/main/java");
    private final File javaTestSrc = new File(root, "src/test/java");

    private final PackageDeclaration corePackage = newPackageDeclaration("com.demo");
    private final PackageDeclaration webPackage = newPackageDeclaration(corePackage, "web");

    private final String mainClass = "ServerApp";

    @Test
    public void generateProjectFiles() {

        final DependencyGroup vertxGroup = newDependencyGroup()
                .setName("vertx")
                .setGroupId("io.vertx")
                .setVersion("3.8.3")
                .addArtifacts("vertx-core")
                .addArtifacts("vertx-web")
                .addArtifacts("vertx-auth-jwt")
                .addArtifacts("vertx-unit");

        final Pom projectPom = newPom()
                .setName("Demo")
                .setGroupId("nextgen")
                .setArtifactId("generator")
                .setVersion("1.5")
                .addProperties(setMavenCompilerSource("1.8"))
                .addProperties(setMavenCompilerTarget("1.8"))
                .addProperties(setProjectBuildSourceEncoding("UTF-8"))
                .addProperties(setProjectReportingOutputEncoding("UTF-8"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("cdt-java-client").setGroupId("com.github.kklisura.cdt").setVersion("2.1.0"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("neo4j").setGroupId("org.neo4j").setVersion("3.5.8"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("slf4j-log4j12").setGroupId("org.slf4j").setVersion("1.7.20"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("jsoup").setGroupId("org.jsoup").setVersion("1.12.1"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("junit").setGroupId("junit").setVersion("4.12"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("java-telegram-bot-api").setGroupId("com.github.pengrad").setVersion("4.8.0"))
                .setBuild(newBuild()
                        .addPlugin(newFrontEndMavenPlugin()
                                .setInstallDirectory("target")
                                .setNodeVersion("8.9.0")
                                .setPluginVersion("1.10.0"))
                        .addPlugin(newShadePlugin()
                                .setClassName(mainClass)
                                .setPackageName(webPackage)));

        MavenPatterns.addDependencyGroup(projectPom, vertxGroup);

        generate(newProject()
                .setName("Demo")
                .setRoot(root.getAbsolutePath())
                .setPom(projectPom));

        NpmPatterns.generate(newNpmProject()
                .setRoot(root.getAbsolutePath())
                .setPackageJson(newPackageJson()
                        .setName("demo")
                        .setVersion("1.0.0")
                        .setDescription("Demo Nextgen")
                        .setAuthor("GOE")
                        .setLicense("ISC")
                        .setMain("index.js")
                        .addScripts(newScript().setName("deploy").setCommand("webpack --mode production"))
                        .addScripts(newScript().setName("server").setCommand("webpack-dev-server --open --mode development"))
                        .addScripts(newScript().setName("package").setCommand("webpack --mode development"))
                        .addScripts(newScript().setName("develop").setCommand("webpack --watch --progress --mode development"))
                        .addDependencies(NpmPatterns.newDependency("react", "16.9.0"))
                        .addDependencies(NpmPatterns.newDependency("react-dom", "16.9.0"))
                        .addDependencies(NpmPatterns.newDependency("react-router-dom", "5.0.1"))
                        .addDependencies(NpmPatterns.newDependency("@material-ui/core", "4.4.2"))
                        .addDependencies(NpmPatterns.newDependency("@material-ui/icons", "4.4.2"))
                        .addDependencies(NpmPatterns.newDependency("@material-ui/styles", "4.4.2"))
                        .addDependencies(NpmPatterns.newDependency("material-table", "1.50.0"))
                        .addDependencies(NpmPatterns.newDependency("mobx", "5.13.0"))
                        .addDependencies(NpmPatterns.newDependency("mobx-react", "6.1.3"))
                        .addDependencies(NpmPatterns.newDependency("superagent", "5.1.0"))
                        .addDependencies(NpmPatterns.newDependency("superagent-promise", "1.1.0"))
                        .addDevDependencies(NpmPatterns.newDependency("@babel/core", "7.1.0"))
                        .addDevDependencies(NpmPatterns.newDependency("@babel/plugin-proposal-class-properties", "7.5.5"))
                        .addDevDependencies(NpmPatterns.newDependency("@babel/plugin-proposal-decorators", "7.6.0"))
                        .addDevDependencies(NpmPatterns.newDependency("@babel/preset-env", "7.1.0"))
                        .addDevDependencies(NpmPatterns.newDependency("@babel/preset-react", "7.0.0"))
                        .addDevDependencies(NpmPatterns.newDependency("babel-loader", "8.0.2"))
                        .addDevDependencies(NpmPatterns.newDependency("webpack", "4.19.1"))
                        .addDevDependencies(NpmPatterns.newDependency("webpack-cli", "3.1.0"))
                        .addDevDependencies(NpmPatterns.newDependency("html-webpack-plugin", "3.2.0")))
                .setWebpackConfig(newWebpackConfig()
                        .setMainEntry(new File("./src/main/webapp", "index.js").getPath())
                        .setOutputFilename(new File("./src/main/resources/static", "main.js")))
                .setBabelrc(newBabelrc()));
    }
}