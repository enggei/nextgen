package projects.nextgen;

import com.generator.util.GeneratedFile;
import com.generator.generators.vertx.VertxGroup;
import com.generator.util.FileUtil;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/**
 *
 */
public class Nextgen {

    protected final String name = "Nextgen";
    protected final String version = "0.0.1";
    protected final String groupId = "nextgen";
    protected final String artifactId = "nextgen-server";
    protected final String description = "";

    protected static final com.generator.generators.maven.MavenGroup mavenGroup = new com.generator.generators.maven.MavenGroup();
    protected static final com.generator.generators.antlr.AntlrGroup antlrGroup = new com.generator.generators.antlr.AntlrGroup();
    protected static final com.generator.generators.java.JavaGroup javaGroup = new com.generator.generators.java.JavaGroup();
    protected static final com.generator.generators.vertx.VertxGroup vertxGroup = new com.generator.generators.vertx.VertxGroup();
    protected static final com.generator.generators.properties.PropertiesGroup propertiesGroup = new com.generator.generators.properties.PropertiesGroup();
    protected static final com.generator.generators.slf4j.Slf4JGroup slf4JGroup = new com.generator.generators.slf4j.Slf4JGroup();
    protected static final com.generator.generators.neo4j.Neo4jGroup neo4jGroup = new com.generator.generators.neo4j.Neo4jGroup();
    protected static final com.generator.generators.junit.JUnitGroup jUnitGroup = new com.generator.generators.junit.JUnitGroup();
    protected static final com.generator.generators.jgoodies.JGoodiesGroup jGoodiesGroup = new com.generator.generators.jgoodies.JGoodiesGroup();
	protected static final com.generator.generators.piccolo2d.Piccolo2DGroup piccolo2DGroup = new com.generator.generators.piccolo2d.Piccolo2DGroup();

    private static final io.vertx.core.json.JsonObject config = new io.vertx.core.json.JsonObject(FileUtil.read(new File("/home/goe/projects/nextgen/components/core/src/main/java/projects/nextgen/Nextgen.json")));

    protected static String config(String key) {
        return config.getString(key);
    }

    protected String dir(String name) {
        return new File(config("root"), config(name)).getAbsolutePath();
    }

    protected String asString(String s) {
        return "\"" + s + "\"";
    }

    protected static void execute(String key, String... command) throws InterruptedException, TimeoutException, IOException {
        new ProcessExecutor().
                directory(new File(config(key))).
                command(command).
                redirectOutput(Slf4jStream.ofCaller().asInfo()).execute();
    }

    protected void generateVerticleTest(VertxGroup.VerticleST verticleST, String utilsPackage, String testRoot) throws IOException {

        final String name = verticleST.getName();
        final String verticleSTPackage = verticleST.getPackage();
        final Set<Map<String, Object>> verticleSTIncoming = verticleST.getIncoming();
        final Set<Map<String, Object>> verticleSTOutgoing = verticleST.getOutgoing();

        final String testName = "Base" + name + "Test";
        final VertxGroup.VerticleTestST verticleTestST = vertxGroup.newVerticleTest().
                setPackageName(verticleSTPackage).
                setName(testName).
                setVerticle(name + "Impl").
                setVertxUtilPackage(utilsPackage);

        for (Map<String, Object> map : verticleSTOutgoing)
            verticleTestST.addIncomingValue(map.get("address"), map.get("name"));

        for (Map<String, Object> map : verticleSTIncoming)
            verticleTestST.addOutgoingValue(map.get("address"), map.get("name"));

        GeneratedFile.newJavaFile(testRoot, verticleSTPackage, testName).write(verticleTestST);

        final GeneratedFile testImplementation = GeneratedFile.newJavaFile(testRoot, verticleSTPackage, name + "Test");
        if (!testImplementation.exists())
            testImplementation.write(javaGroup.newClass().
                    setPackage(verticleSTPackage).
                    setScope("public").
                    setName(name + "Test").
                    setExtends(testName));
    }

    protected void generateNeoVerticleTest(com.generator.generators.neo4j.Neo4jGroup.DomainVerticleST verticleST, String utilsPackage, String testRoot) throws IOException {

        final String name = verticleST.getName();
        final String verticleSTPackage = verticleST.getPackageName();
        final Set<Map<String, Object>> actions = verticleST.getIncoming();

        final String testName = "Base" + name + "Test";
        final VertxGroup.VerticleTestST verticleTestST = vertxGroup.newVerticleTest().
                setPackageName(verticleSTPackage).
                setName(testName).
                setVerticle(name + "Impl").
                setVertxUtilPackage(utilsPackage);

        for (Map<String, Object> map : actions)
            verticleTestST.addOutgoingValue(map.get("address"), map.get("name"));

        GeneratedFile.newJavaFile(testRoot, verticleSTPackage, testName).write(verticleTestST);

        final GeneratedFile testImplementation = GeneratedFile.newJavaFile(testRoot, verticleSTPackage, name + "Test");
        if (!testImplementation.exists())
            testImplementation.write(javaGroup.newClass().
                    addImportsValue(utilsPackage + ".ResponseUtil").
                    addImportsValue(utilsPackage + ".VertxUtil").
                    addImportsValue("io.vertx.core.eventbus.Message").
                    addImportsValue("io.vertx.core.json.JsonObject").
                    addImportsValue("io.vertx.ext.unit.Async").
                    addImportsValue("io.vertx.ext.unit.TestContext").
                    addImportsValue("org.junit.Test").
                    setPackage(verticleSTPackage).
                    setScope("public").
                    setName(name + "Test").
                    setExtends(testName).
                    addMethodsValue(javaGroup.newmethod().
                            addAnnotationsValue("Test").
                            setName("test").
                            setScope("public").
                            addParametersValue("context", "TestContext")));
    }

    protected void generateNeoVerticleTest(VertxGroup.NeoVerticleST verticleST, String utilsPackage, String testRoot) throws IOException {

        final String name = verticleST.getName();
        final String verticleSTPackage = verticleST.getPackageName();
        final Set<Map<String, Object>> actions = verticleST.getActions();

        final String testName = "Base" + name + "Test";
        final VertxGroup.VerticleTestST verticleTestST = vertxGroup.newVerticleTest().
                setPackageName(verticleSTPackage).
                setName(testName).
                setVerticle(name + "Impl").
                setVertxUtilPackage(utilsPackage);

        for (Map<String, Object> map : actions)
            verticleTestST.addOutgoingValue(map.get("address"), map.get("name"));

        GeneratedFile.newJavaFile(testRoot, verticleSTPackage, testName).write(verticleTestST);

        final GeneratedFile testImplementation = GeneratedFile.newJavaFile(testRoot, verticleSTPackage, name + "Test");
        if (!testImplementation.exists())
            testImplementation.write(javaGroup.newClass().
                    addImportsValue(utilsPackage + ".ResponseUtil").
                    addImportsValue(utilsPackage + ".VertxUtil").
                    addImportsValue("io.vertx.core.eventbus.Message").
                    addImportsValue("io.vertx.core.json.JsonObject").
                    addImportsValue("io.vertx.ext.unit.Async").
                    addImportsValue("io.vertx.ext.unit.TestContext").
                    addImportsValue("org.junit.Test").
                    setPackage(verticleSTPackage).
                    setScope("public").
                    setName(name + "Test").
                    setExtends(testName).
                    addMethodsValue(javaGroup.newmethod().
                            addAnnotationsValue("Test").
                            setName("test").
                            setScope("public").
                            addParametersValue("context", "TestContext")));
    }
}