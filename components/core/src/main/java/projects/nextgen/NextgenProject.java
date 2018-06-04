package projects.nextgen;

import com.generator.generators.java.JavaGroup;
import com.generator.generators.maven.MavenGroup;
import com.generator.generators.neo4j.Neo4jGroup;
import com.generator.generators.properties.PropertiesGroup;
import com.generator.generators.vertx.VertxGroup;
import com.generator.util.FileUtil;
import com.generator.util.GeneratedFile;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created 24.05.18.
 */
public class NextgenProject extends Nextgen {

   private static final String utilsPackage = "com.generator.util";

   private static final String templatesPackage = "com.nextgen.server.templates";
   private static final String neoDomainPackage = "com.nextgen.server.neoDomain";
   private static final String templateVerticle = "TemplateDomain";

   private static final String mainClass = templatesPackage + "." + templateVerticle + "Impl";

   @Test
   public void createDirectories() {

      FileUtil.tryToCreateDirIfNotExists(new File(config("root")));

      FileUtil.tryToCreateDirIfNotExists(new File(config("swing.main.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("swing.test.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("swing.web.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("swing.test.resources")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("swing.main.resources")));

      FileUtil.tryToCreateDirIfNotExists(new File(config("server.main.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("server.test.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("server.web.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("server.test.resources")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("server.main.resources")));

      FileUtil.tryToCreateDirIfNotExists(new File(config("core.main.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("core.test.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("core.web.src")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("core.test.resources")));
      FileUtil.tryToCreateDirIfNotExists(new File(config("core.main.resources")));
   }

   @Test
   public void mavenProject() throws IOException {

      final MavenGroup.PomST pomST = mavenGroup.newPom().
            setGroupId(groupId).
            setArtifactId(artifactId).
            setName(name).
            setVersion(version).
            setPackaging("pom");

      pomST.addModulesValue("swing");
      pomST.addModulesValue("server");
      pomST.addModulesValue("core");

      pomST.addPropertiesValue("project.build.sourceEncoding", "UTF-8");
      pomST.addPropertiesValue("project.reporting.outputEncoding", "UTF-8");
      pomST.addPropertiesValue("maven.compiler.source", "1.8");
      pomST.addPropertiesValue("maven.compiler.target", "1.8");

      pomST.addDependenciesValue(vertxGroup.newmvn_core());
      pomST.addDependenciesValue(neo4jGroup.newmvn());

//      pomST.setBaseBuild(mavenGroup.newbuild().
//            addPluginValue(vertxGroup.newmvn_fat_jar().
//                  setMainClass(mainClass + "Impl")));

      GeneratedFile.newPlainFile(config("root"), "", "pom.xml").write(pomST);
   }

   @Test
   public void server() throws IOException {

      final MavenGroup.PomST pomST = mavenGroup.newPom().
            setArtifactId("server").
            setName("Nextgen Server").
            setVersion(version);

      pomST.setParentArtifactId(artifactId);
      pomST.setParentGroupId(groupId);
      pomST.setParentVersion(version);


      pomST.addDependenciesValue(vertxGroup.newmvn_unit());
      pomST.addDependenciesValue(vertxGroup.newmvn_eventbus_bridge().setVersion("3.5.1"));
      pomST.addDependenciesValue(vertxGroup.newmvn_web().setVersion("3.5.1"));
//      pomST.addDependenciesValue(vertxGroup.newmvn_webClient().setVersion("3.5.1"));
      pomST.addDependenciesValue(slf4JGroup.newmvn());
      pomST.addDependenciesValue(jUnitGroup.newmvn());
      pomST.addDependenciesValue(antlrGroup.newmvn().setVersion("4.7"));
      pomST.addDependenciesValue(mavenGroup.newdependency().setGroupId(groupId).setArtifactId("core").setVersion(version));

      pomST.setBaseBuild(mavenGroup.newbuild().
            addPluginValue(vertxGroup.newmvn_fat_jar().
                  setMainClass(mainClass + "Impl")));

      GeneratedFile.newPlainFile(config("root"), "server", "pom.xml").write(pomST);
   }

   @Test
   public void swing() throws IOException {

      final MavenGroup.PomST pomST = mavenGroup.newPom().
            setArtifactId("swing").
            setName("Nextgen Swing").
            setVersion(version);

      pomST.setParentArtifactId(artifactId);
      pomST.setParentGroupId(groupId);
      pomST.setParentVersion(version);

      pomST.addDependenciesValue(jUnitGroup.newmvn());

      pomST.addDependenciesValue(jGoodiesGroup.newmvn());
      pomST.addDependenciesValue(piccolo2DGroup.newmvn());

      pomST.addDependenciesValue(mavenGroup.newdependency().setGroupId(groupId).setArtifactId("core").setVersion(version));
      pomST.addDependenciesValue(mavenGroup.newdependency().setGroupId(groupId).setArtifactId("server").setVersion(version));

      GeneratedFile.newPlainFile(config("root"), "swing", "pom.xml").write(pomST);

      // domain classes

//      final String domainPackage = "com.generator.swing.domain";
//      final JavaGroup.PojoST project = javaGroup.newPojo().
//            setPackage(domainPackage).
//            setScope("public").
//            setName("Project").
//            setJson("true").
//            addPropertiesValue(null, "String", "name", null, null, null, null).
//            addPropertiesValue(null, "String", "path", null, null, null, null).
//            addMethodsValue(javaGroup.newconstructor().
//                  setName("Project").
//                  setScope("public").
//                  addFieldsValue("String", "name").
//                  addFieldsValue("String", "path")
//            );
//
//      GeneratedFile.newJavaFile(config("swing.main.src"), domainPackage, "Project").write(project);
   }

   @Test
   public void core() throws IOException {

      final MavenGroup.PomST pomST = mavenGroup.newPom().
            setArtifactId("core").
            setName("Nextgen Core").
            setVersion(version);

      pomST.setParentArtifactId(artifactId);
      pomST.setParentGroupId(groupId);
      pomST.setParentVersion(version);

      pomST.addDependenciesValue(antlrGroup.newmvn());
      pomST.addDependenciesValue(slf4JGroup.newmvn());
      pomST.addDependenciesValue(neo4jGroup.newmvn());

      GeneratedFile.newPlainFile(config("root"), "core", "pom.xml").write(pomST);

      GeneratedFile.newJavaFile(config("core.main.src"), utilsPackage, "ResponseUtil").write(vertxGroup.newResponseUtil().setPackageName(utilsPackage));
      GeneratedFile.newJavaFile(config("core.main.src"), utilsPackage, "VertxUtil").write(vertxGroup.newVertxUtil().setPackageName(utilsPackage));
   }

   @Test
   public void createLogging() throws IOException {

      final String stdLogger = "stdout";

      final PropertiesGroup.log4jPropertiesST textLog4JPropertiesST = propertiesGroup.newlog4jProperties().
            setLogLevel("DEBUG").
            addRootLoggersValue(stdLogger);

      textLog4JPropertiesST.addAppendersValue(propertiesGroup.newconsoleAppender().
            setName(stdLogger).
            setThreshold("DEBUG"));

      GeneratedFile.newPlainFile(config("swing.test.resources"), "", "log4j.properties").write(textLog4JPropertiesST);
      GeneratedFile.newPlainFile(config("server.test.resources"), "", "log4j.properties").write(textLog4JPropertiesST);
      GeneratedFile.newPlainFile(config("core.test.resources"), "", "log4j.properties").write(textLog4JPropertiesST);

      final String fileLogger = "file";
      final PropertiesGroup.log4jPropertiesST liveLog4JPropertiesST = propertiesGroup.newlog4jProperties().
            setLogLevel("INFO").
            addRootLoggersValue(fileLogger);

      liveLog4JPropertiesST.addAppendersValue(propertiesGroup.newfileAppender().
            setName(fileLogger).
            setThreshold("INFO").
            setFilePath("nextgen.log"));

      GeneratedFile.newPlainFile(config("swing.main.resources"), "", "log4j.properties").write(liveLog4JPropertiesST);
      GeneratedFile.newPlainFile(config("server.main.resources"), "", "log4j.properties").write(liveLog4JPropertiesST);
      GeneratedFile.newPlainFile(config("core.main.resources"), "", "log4j.properties").write(liveLog4JPropertiesST);
   }

   @Test
   public void generateServer() throws IOException {

      final String packageName = "com.nextgen.server";
      final String className = "NextgenServer";

      final VertxGroup.ServerST serverST = vertxGroup.newServer().
            setPackage(packageName).
            setName(className).
            setVertxUtilPackage(utilsPackage);


//      GeneratedFile.newJavaFile(config("server.main.src"), packageName, className).write(serverST);
   }

   @Test
   public void templateService() throws IOException {

      final String verticleClass = "TemplateVerticle";
      final String verticlePackage = templatesPackage + ".verticles";

      final Neo4jGroup.DomainVerticleST domainVerticleST = neo4jGroup.newDomainVerticle().
            setPackageName(verticlePackage).
            setName(verticleClass);

      domainVerticleST.addIncomingValue("saveTemplateGroup", null, "save.templateGroup");
      domainVerticleST.addIncomingValue("deleteTemplateGroup", null, "delete.templateGroup");
      domainVerticleST.addIncomingValue("parseTemplateGroup", null, "parse.templateGroup");
      domainVerticleST.addIncomingValue("getAllTemplateGroups", null, "get.all.templateGroups");

      domainVerticleST.addIncomingValue("getTemplateGroupBuilder", null, "get.templateGroup.builder");
      domainVerticleST.addIncomingValue("getTemplateGroupSTG", null, "get.templateGroup.stg");

      domainVerticleST.addIncomingValue("render", null, "render");
      domainVerticleST.addIncomingValue("getRenderParamsBuilder", null, "get.render.params.builder");

      domainVerticleST.addIncomingValue("saveTemplate", null, "save.template");
      domainVerticleST.addIncomingValue("getTemplate", null, "get.template");
      domainVerticleST.addIncomingValue("deleteTemplate", null, "delete.template");
      domainVerticleST.addIncomingValue("getAllTemplates", null, "get.all.templates");

//      GeneratedFile.newJavaFile(config("server.main.src"), verticlePackage, verticleClass).write(domainVerticleST);

//      generateNeoVerticleTest(domainVerticleST, utilsPackage, config("test.src"));
   }

   @Test
   public void neoDomainService() throws IOException {

      final String verticleClass = "NeoDomainVerticle";
      final String verticlePackage = neoDomainPackage + ".verticles";

      final Neo4jGroup.DomainVerticleST verticleST = neo4jGroup.newDomainVerticle().
            setPackageName(verticlePackage).
            setName(verticleClass);

      verticleST.addIncomingValue("newDomain", null, "new.neo.domain");
      verticleST.addIncomingValue("listDomains", null, "list.neo.domains");
      verticleST.addIncomingValue("addDomainEntity", null, "add.domain.entity");
      verticleST.addIncomingValue("getDomainEntities", null, "get.domain.entities");
      verticleST.addIncomingValue("addEntityProperty", null, "add.entity.property");
      verticleST.addIncomingValue("addDomainRelation", null, "add.domain.relation");
      verticleST.addIncomingValue("addRelationProperty", null, "add.relation.property");
      verticleST.addIncomingValue("deleteRelation", null, "del.relation");

      verticleST.addIncomingValue("generateDomain", null, "generate.domain");
      verticleST.addIncomingValue("generateDomainPojos", null, "generate.domain.pojos");
      verticleST.addIncomingValue("generateDomainCypher", null, "generate.domain.cypher");

//      GeneratedFile.newJavaFile(config("server.main.src"), verticlePackage, verticleClass).write(verticleST);

//      generateNeoVerticleTest(verticleST, utilsPackage, config("test.src"));
   }

}