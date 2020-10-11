package nextgen.projects;

import nextgen.templates.MavenPatterns;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.maven.DependencyGroup;
import nextgen.templates.maven.DependencyScope;
import nextgen.templates.maven.DependencyType;
import nextgen.templates.maven.Pom;
import org.junit.Test;

import java.io.File;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.GitPatterns.write;
import static nextgen.templates.JavaPatterns.newPackageDeclaration;
import static nextgen.templates.MavenPatterns.*;
import static nextgen.templates.MavenPatterns.newPomProperties;
import static nextgen.templates.git.GitST.newGitignore;

public class SmartPilotProject {

    private final File root = new File("/home/goe/projects/smartpilot");

    private final File main = new File(root, "src/main");
    private final File mainJava = new File(main, "java");
    private final File mainResources = new File(main, "resources");
    private final File mainWebapp = new File(main, "webapp");

    private final PackageDeclaration corePackage = newPackageDeclaration("com.smartpilot");
    private final PackageDeclaration domainPackage = newPackageDeclaration("com.domain");
    private final PackageDeclaration webPackage = newPackageDeclaration(corePackage, "web");

    private final String mainClass = "App";
    private final String version = "1.0.0";
    private final String name = "SmartPilot";

    @Test
    public void generateDomain() {

        writeNeo(mainJava, domainPackage, newDomain("SmartPilot")
                .addEntities(newEntity("Map")
                        .addRelations(newStringField("name"))));

    }

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
                .setName(name)
                .setGroupId(corePackage.getName())
                .setArtifactId(mainClass)
                .setVersion(version)
                .addProperties(setMavenCompilerSource("1.8"))
                .addProperties(setMavenCompilerTarget("1.8"))
                .addProperties(setProjectBuildSourceEncoding("UTF-8"))
                .addProperties(setProjectReportingOutputEncoding("UTF-8"))
                .addProperties(newPomProperties("lwjgl.version", "3.2.3"))
                .addProperties(newPomProperties("joml.version", "1.9.25"))
                .addProperties(newPomProperties("lwjgl.natives", "natives-linux"))
                .setDependencyManagement(newDependencyManagement()
                        .addDependencies(MavenPatterns.newDependency().setArtifactId("lwjgl-bom").setGroupId("org.lwjgl").setVersion("${lwjgl.version}").setScope(DependencyScope.Import).setType(DependencyType.Pom)))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("neo4j").setGroupId("org.neo4j").setVersion("3.5.8"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("slf4j-log4j12").setGroupId("org.slf4j").setVersion("1.7.20"))
                .addDependencies(MavenPatterns.newDependency().setArtifactId("junit").setGroupId("junit").setVersion("4.12"))
                .setBuild(newBuild()
                        .addPlugin(newShadePlugin()
                                .setClassName(mainClass)
                                .setPackageName(webPackage.getName())));

        // adds more lwjgl-dependencies from xml below, from custom pom at https://www.lwjgl.org/customize
        MavenPatterns.parseDependencies(lwjglDependenciesXml).forEach(projectPom::addDependencies);

        MavenPatterns.addDependencyGroup(projectPom, vertxGroup);

        generate(newProject()
                .setName(name)
                .setRoot(root.getAbsolutePath()), projectPom);

        write(root, newGitignore()
                .addExcludeDirs(".idea")
                .addExcludeDirs("db")
                .addExcludeDirs("node_modules")
                .addExcludeFiles("Monitor.iml")
                .addExcludeDirs("target"));
    }

    private static final String lwjglDependenciesXml = "<dependencies>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-assimp</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-bgfx</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-cuda</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-egl</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-glfw</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-jawt</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-jemalloc</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-libdivide</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-llvm</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-lmdb</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-lz4</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-meow</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-nanovg</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-nfd</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-nuklear</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-odbc</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-openal</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-opencl</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-opengl</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-opengles</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-openvr</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-opus</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-par</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-remotery</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-rpmalloc</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-shaderc</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-sse</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-stb</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-tinyexr</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-tinyfd</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-tootle</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-vma</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-vulkan</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-xxhash</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-yoga</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-zstd</artifactId>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-assimp</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-bgfx</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-glfw</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-jemalloc</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-libdivide</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-llvm</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-lmdb</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-lz4</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-meow</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-nanovg</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-nfd</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-nuklear</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-openal</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-opengl</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-opengles</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-openvr</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-opus</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-par</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-remotery</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-rpmalloc</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-shaderc</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-sse</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-stb</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-tinyexr</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-tinyfd</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-tootle</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-vma</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-xxhash</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-yoga</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.lwjgl</groupId>\n" +
            "\t\t\t<artifactId>lwjgl-zstd</artifactId>\n" +
            "\t\t\t<classifier>${lwjgl.natives}</classifier>\n" +
            "\t\t</dependency>\n" +
            "\t\t<dependency>\n" +
            "\t\t\t<groupId>org.joml</groupId>\n" +
            "\t\t\t<artifactId>joml</artifactId>\n" +
            "\t\t\t<version>${joml.version}</version>\n" +
            "\t\t</dependency>\n" +
            "\t</dependencies>";
}