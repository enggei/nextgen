package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.templates.DomainPatterns;
import nextgen.templates.JavaEasyFlowsPatterns;
import nextgen.templates.JavaPatterns;
import nextgen.templates.MavenPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.ClassOrInterfaceType;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.java.Singleton;
import nextgen.templates.javaeasyflows.WorkFlowFacade;
import nextgen.templates.maven.MavenST;
import nextgen.templates.maven.Pom;
import nextgen.templates.nextgen.AppEvents;
import nextgen.templates.nextgen.NextgenST;
import nextgen.utils.StringUtil;
import org.junit.Before;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.JavaPatterns.newClassOrInterfaceType;

public class NextgenProject {

   final File root = new File("/home/goe/projects/nextgen/components/core");

   final File mainJava = new File(root, "src/main/java");
   final File mainResources = new File(root, "src/main/resources");
   final File testJava = new File(root, "src/test/java");
   final File testResources = new File(root, "src/test/resources");

   final Map<Object, ClassOrInterfaceType> typesMap = new LinkedHashMap<>();

   final String swingPackageName = "swing";
   final String swingConfigPackageName = "config";

   final String presentationModelName = "STAppPresentationModel";
   final String appModelName = "AppModel";
   final String stringType = "String";
   final String awtDimensionType = "java.awt.Dimension";
   final String integerType = "Integer";
   final String jFrameType = "javax.swing.JFrame";

   final PackageDeclaration corePackage = JavaPatterns.newPackageDeclaration("nextgen");
   final PackageDeclaration stPackage = JavaPatterns.newPackageDeclaration(corePackage, "st");
   final PackageDeclaration metaDomainPackage = JavaPatterns.newPackageDeclaration(corePackage, "domains.meta");
   final PackageDeclaration stDomainPackage = JavaPatterns.newPackageDeclaration(corePackage, "st.domain");
   final PackageDeclaration stModelPackage = JavaPatterns.newPackageDeclaration(corePackage, "st.model");
   final PackageDeclaration canvasLayoutPackage = JavaPatterns.newPackageDeclaration(corePackage, "st.canvas.layout");
   final PackageDeclaration beansPackage = JavaPatterns.newPackageDeclaration(corePackage, "st.beans");
   final PackageDeclaration snippetsPackage = JavaPatterns.newPackageDeclaration(corePackage, "snippets");
   final PackageDeclaration workflowPackage = JavaPatterns.newPackageDeclaration(corePackage, "workflow");
   final PackageDeclaration swingPackage = JavaPatterns.newPackageDeclaration(corePackage, swingPackageName);
   final PackageDeclaration swingConfigPackage = JavaPatterns.newPackageDeclaration(swingPackage, swingConfigPackageName);

   final AppEvents appEvents = NextgenST.newAppEvents()
         .setPackageName(stPackage.getName())
         .setName("STAppEvents");

   @Before
   public void init() {
      typesMap.put(presentationModelName, JavaPatterns.newClassOrInterfaceType(stPackage, presentationModelName));
   }

   @org.junit.Test
   public void generateSwing() {

      final Singleton appModel = JavaPatterns.newSingleton(appModelName, swingPackage)
            .addFields(stringType, "title", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "title", appModelName))
            .addFields(awtDimensionType, "appSize", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(awtDimensionType, "appSize", appModelName))
            .addFields(awtDimensionType, "navigatorSize", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(awtDimensionType, "navigatorSize", appModelName))
            .addFields(awtDimensionType, "workspaceSize", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(awtDimensionType, "workspaceSize", appModelName))
            .addFields(stringType, "rootDir", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "rootDir", appModelName))
            .addFields(stringType, "dbDir", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "dbDir", appModelName))
            .addFields(stringType, "outputPackage", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "outputPackage", appModelName))
            .addFields(stringType, "outputPath", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "outputPath", appModelName))
            .addFields(stringType, "templateDir", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "templateDir", appModelName))
            .addFields(stringType, "stDelimiter", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "stDelimiter", appModelName))
            .addFields(integerType, "fontSize", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(integerType, "fontSize", appModelName))
            .addFields(stringType, "fontName", null)
            .addAccessors(JavaPatterns.newPrimitiveAccessors(stringType, "fontName", appModelName))
            .addFields(jFrameType, "frame", null)
            .addAccessors(JavaPatterns.newReferenceAccessors(jFrameType, "frame", appModelName))
            .addFields(typesMap.get(presentationModelName), StringUtil.lowFirst(presentationModelName), null)
            .addAccessors(JavaPatterns.newReferenceAccessors(typesMap.get(presentationModelName), StringUtil.lowFirst(presentationModelName), appModelName));

      final Entity config = newEntity("AppConfig")
            .addRelations(newStringField("title"))
            .addRelations(newIntegerField("appWidth"))
            .addRelations(newIntegerField("appHeight"))
            .addRelations(newIntegerField("navigatorWidth"))
            .addRelations(newIntegerField("navigatorHeight"))
            .addRelations(newIntegerField("workspaceWidth"))
            .addRelations(newIntegerField("workspaceHeight"))
            .addRelations(newIntegerField("editorWidth"))
            .addRelations(newIntegerField("editorHeight"))
            .addRelations(newStringField("rootDir"))
            .addRelations(newStringField("dbDir"))
            .addRelations(newStringField("outputPackage"))
            .addRelations(newStringField("outputPath"))
            .addRelations(newStringField("templateDir"))
            .addRelations(newIntegerField("fontSize"))
            .addRelations(newStringField("fontName"));
      typesMap.put(config, newClassOrInterfaceType(swingConfigPackage, config.getName()));

      STGenerator.writeJavaFile(appModel, appModel.getPackageName(), appModel.getName(), mainJava);
      writeJsonWrapper(mainJava, swingConfigPackage, newDomain(config.getName()).addEntities(config));
   }

   /**
    * generateSTTemplateDomain
    */
   @org.junit.Test
   public void generateSTTemplateDomain() {

      final Entity stParameterType = DomainPatterns.newEnum("STParameterType", "SINGLE,LIST,KVLIST");

      final Entity stParameterKey = DomainPatterns.newEntity("STParameterKey")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("argumentType"));

      final Entity stParameter = DomainPatterns.newEntity("STParameter")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newEnumField("type", stParameterType))
            .addRelations(DomainPatterns.newOneToMany("keys", stParameterKey))
            .addRelations(DomainPatterns.newStringField("argumentType"));

      final Entity stInterface = DomainPatterns.newEntity("STInterface")
            .addRelations(DomainPatterns.newStringField("name"));

      final Entity stEnumValue = DomainPatterns.newEntity("STEnumValue")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("lexical"));

      final Entity stEnum = DomainPatterns.newEntity("STEnum")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newOneToMany("values", stEnumValue));

//      final Entity stTemplateAction = DomainPatterns.newEntity("STTemplateAction")
//            .addRelations(DomainPatterns.newStringField("name", true))
//            .addRelations(DomainPatterns.newOneToManyString("statements"));

      final Entity stTemplate = DomainPatterns.newEntity("STTemplate")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("text"))
            .addRelations(DomainPatterns.newOneToManyString("implements"))
            .addRelations(DomainPatterns.newOneToMany("parameters", stParameter))
            .addRelations(DomainPatterns.newOneToManySelf("children"))
//            .addRelations(DomainPatterns.newOneToMany("actions", stTemplateAction))
            ;

      final Entity stGroupModel = DomainPatterns.newEntity("STGroupModel")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("delimiter"))
            .addRelations(DomainPatterns.newStringField("icon"))
            .addRelations(DomainPatterns.newStringField("tags"))
            .addRelations(DomainPatterns.newOneToMany("templates", stTemplate))
            .addRelations(DomainPatterns.newOneToMany("interfaces", stInterface))
            .addRelations(DomainPatterns.newOneToMany("enums", stEnum));

      final Entity stgErrorType = DomainPatterns.newEnum("STGErrorType", "COMPILE,RUNTIME,IO,INTERNAL");

      final Entity stgError = DomainPatterns.newEntity("STGError")
            .addRelations(DomainPatterns.newEnumField("type", stgErrorType))
            .addRelations(DomainPatterns.newStringField("message"))
            .addRelations(DomainPatterns.newIntegerField("line"))
            .addRelations(DomainPatterns.newIntegerField("charPosition"));

      final Entity stgDirectory = DomainPatterns.newEntity("STGDirectory")
            .addRelations(DomainPatterns.newStringField("path"))
            .addRelations(DomainPatterns.newStringField("outputPackage"))
            .addRelations(DomainPatterns.newStringField("outputPath"))
            .addRelations(DomainPatterns.newOneToMany("groups", stGroupModel));

      final Entity stAppModel = DomainPatterns.newEntity("STAppModel")
            .addRelations(DomainPatterns.newStringField("modelDb"))
            .addRelations(DomainPatterns.newStringField("rootDir"))
            .addRelations(DomainPatterns.newIntegerField("editorFontSize"))
            .addRelations(DomainPatterns.newOneToMany("directories", stgDirectory));

      final Entity stgParseResult = DomainPatterns.newEntity("STGParseResult")
            .addRelations(DomainPatterns.newOneToOne("parsed", stGroupModel))
            .addRelations(DomainPatterns.newOneToMany("errors", stgError));

      final Domain domain = DomainPatterns.newDomain("ST")
            .addEntities(stAppModel)
            .addEntities(stgParseResult);

      DomainPatterns.writeJsonWrapper(mainJava, stDomainPackage, domain);
   }

   /**
    * generateSTModelDomain
    */
   @org.junit.Test
   public void generateSTModelDomain() {

      final Entity stValue = DomainPatterns.newEntityWithUuid("STValue")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("value"))
            .addRelations(DomainPatterns.newEnumField("type", DomainPatterns.newEnum("STValueType", "STMODEL,PRIMITIVE,ENUM")));

      final Entity stFile = DomainPatterns.newEntityWithUuid("STFile")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newOneToOne("name", stValue, true))
            .addRelations(DomainPatterns.newOneToOne("type", stValue))
            .addRelations(DomainPatterns.newOneToOne("packageName", stValue))
            .addRelations(DomainPatterns.newOneToOne("path", stValue));

      final Entity stArgumentKV = DomainPatterns.newEntityWithUuid("STArgumentKV")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("stParameterKey"))
            .addRelations(DomainPatterns.newOneToOne("value", stValue));

      final Entity stArgument = DomainPatterns.newEntityWithUuid("STArgument")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("stParameter"))
            .addRelations(DomainPatterns.newOneToOne("value", stValue))
            .addRelations(DomainPatterns.newOneToMany("keyValues", stArgumentKV));

      final Entity stModel = DomainPatterns.newEntityWithUuid("STModel")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("stTemplate"))
            .addRelations(DomainPatterns.newStringField("stGroup"))
            .addRelations(DomainPatterns.newOneToMany("files", stFile))
            .addRelations(DomainPatterns.newOneToMany("arguments", stArgument));

      stValue.addRelations(DomainPatterns.newOneToOne("stModel", stModel));

      final Domain domain = DomainPatterns.newDomain("STModel")
            .addEntities(stModel);

      DomainPatterns.writeNeo(mainJava, stModelPackage, domain);
   }

   /**
    * generateCanvasLayoutDomain
    */
   @org.junit.Test
   public void generateCanvasLayoutDomain() {
      final Entity layoutDomain = DomainPatterns.newEntityWithUuid("Layout")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("nodes", DomainPatterns.newEntityWithUuid("LayoutNode")
                  .addRelations(DomainPatterns.newDoubleField("x"))
                  .addRelations(DomainPatterns.newDoubleField("y"))));

      final Domain domain = DomainPatterns.newDomain("Layout")
            .addEntities(layoutDomain);
      DomainPatterns.writeNeo(mainJava, canvasLayoutPackage, domain);
   }

   /**
    * generateCanvasLayoutDomain
    */
   @org.junit.Test
   public void generateWorkflowsDomain() {

      // Workflows
      final Entity workInput = DomainPatterns.newEntityWithUuid("WorkInput")
            .addRelations(DomainPatterns.newStringField("type"))
            .addRelations(DomainPatterns.newStringField("name"));

      final Entity workStatement = DomainPatterns.newEntityWithUuid("WorkStatement")
            .addRelations(DomainPatterns.newStringField("statement"));

      final Entity workInstance = DomainPatterns.newEntityWithUuid("WorkInstance")
            .addRelations(DomainPatterns.newEnumField("type", "WorkType", "WORK,CONDITIONAL,SEQUENTIAL,PARALLEL,REPEAT"));

      final Entity work = DomainPatterns.newEntityWithUuid("Work")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("package"))
            .addRelations(DomainPatterns.newOneToMany("inputs", workInput))
            .addRelations(DomainPatterns.newOneToMany("statements", workStatement));
      workInstance.addRelations(DomainPatterns.newOneToOne("work", work));

      final Entity conditionalFlow = DomainPatterns.newEntityWithUuid("ConditionalFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("execute", workInstance))
            .addRelations(DomainPatterns.newOneToOne("then", workInstance))
            .addRelations(DomainPatterns.newOneToOne("otherwise", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("conditional", conditionalFlow));

      final Entity sequentialFlow = DomainPatterns.newEntityWithUuid("SequentialFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("execute", workInstance))
            .addRelations(DomainPatterns.newOneToMany("then", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("sequential", sequentialFlow));

      final Entity parallelFlow = DomainPatterns.newEntityWithUuid("ParallelFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("execute", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("parallel", parallelFlow));

      final Entity repeatFlow = DomainPatterns.newEntityWithUuid("RepeatFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("repeat", workInstance))
            .addRelations(DomainPatterns.newIntegerField("times"))
            .addRelations(DomainPatterns.newEnumField("until", "UntilPredicate", "ALWAYS_TRUE,ALWAYS_FALSE,COMPLETED,FAILED"));
      workInstance.addRelations(DomainPatterns.newOneToOne("repeat", repeatFlow));

      final Domain domain = DomainPatterns.newDomain("WorkFlow")
            .addEntities(work)
            .addEntities(workInstance);

      DomainPatterns.writeNeo(mainJava, workflowPackage, domain);
      final WorkFlowFacade workFlowFacade = JavaEasyFlowsPatterns.newWorkFlowFacade()
            .setName("WorkFlowFacade")
            .setPackageName(workflowPackage.getName());
      STGenerator.writeJavaFile(workFlowFacade, workflowPackage, workFlowFacade.getName(), mainJava);

      DomainPatterns.writeGreenrobotEvents(mainJava, workflowPackage, workflowPackage, domain);
   }



   /**
    * generateProjectFiles
    */
   @org.junit.Test
   public void generateProjectFiles() {
      Pom projectPom = MavenST.newPom()
            .setParent("<parent>\n" +
                  "	<artifactId>components</artifactId>\n" +
                  "	<groupId>com.nextgen</groupId>\n" +
                  "	<version>1.0</version>\n" +
                  "</parent>")
            .setName("Core")
            .setArtifactId("core")
            .addProperties(MavenPatterns.newMavenCompilerSource().setValue("9"))
            .addProperties(MavenPatterns.newMavenCompilerTarget().setValue("9"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("com.fifesoft")
                  .setArtifactId("rsyntaxtextarea")
                  .setVersion("3.0.3"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("com.formdev")
                  .setArtifactId("flatlaf")
                  .setVersion("0.40"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.neo4j")
                  .setArtifactId("neo4j")
                  .setVersion("${neo4j.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.antlr")
                  .setArtifactId("antlr4")
                  .setVersion("${antlr.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("com.jgoodies")
                  .setArtifactId("jgoodies-forms")
                  .setVersion("${jgoodies.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.jeasy")
                  .setArtifactId("easy-flows")
                  .setVersion("0.2"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.piccolo2d")
                  .setArtifactId("piccolo2d-core")
                  .setVersion("${piccolo2d.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.piccolo2d")
                  .setArtifactId("piccolo2d-extras")
                  .setVersion("${piccolo2d.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.abego.treelayout")
                  .setArtifactId("org.abego.treelayout.core")
                  .setVersion("1.0.3"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("io.vertx")
                  .setArtifactId("vertx-core")
                  .setVersion("${vertx.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.jsoup")
                  .setArtifactId("jsoup")
                  .setVersion("1.12.1"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("com.github.kklisura.cdt")
                  .setArtifactId("cdt-java-client")
                  .setVersion("2.1.0"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("net.openhft")
                  .setArtifactId("compiler")
                  .setVersion("2.3.1"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("junit")
                  .setArtifactId("junit")
                  .setVersion("${junit.version}"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("org.javatuples")
                  .setArtifactId("javatuples")
                  .setVersion("1.2"))
            .addDependencies(nextgen.templates.MavenPatterns.newDependency()
                  .setGroupId("com.github.javaparser")
                  .setArtifactId("javaparser-symbol-solver-core")
                  .setVersion("3.16.1"));

      MavenPatterns.generate(MavenPatterns.newProject()
            .setName("Nextgen")
            .setRoot(root.getAbsolutePath()), projectPom);
   }
}