package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.templates.DomainPatterns;
import nextgen.templates.JavaEasyFlowsPatterns;
import nextgen.templates.MavenPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import nextgen.templates.javaeasyflows.WorkFlowFacade;
import nextgen.templates.maven.MavenST;
import nextgen.templates.maven.Pom;
import nextgen.templates.nextgen.AppEvents;
import nextgen.templates.nextgen.NextgenST;

import java.io.File;

public class NextgenProject {

   final File root = new File("/home/goe/projects/nextgen/components/core");

   final File mainJava = new File(root, "src/main/java");
   final File mainResources = new File(root, "src/main/resources");
   final File testJava = new File(root, "src/test/java");
   final File testResources = new File(root, "src/test/resources");


   private final nextgen.templates.java.PackageDeclaration corePackage = nextgen.templates.JavaPatterns.newPackageDeclaration("nextgen");
   private final nextgen.templates.java.PackageDeclaration stPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage, "st");
   private final nextgen.templates.java.PackageDeclaration metaDomainPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage, "domains.meta");
   private final nextgen.templates.java.PackageDeclaration stDomainPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage, "st.domain");
   private final nextgen.templates.java.PackageDeclaration stModelPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage, "st.model");
   private final nextgen.templates.java.PackageDeclaration canvasLayoutPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage, "st.canvas.layout");
   private final nextgen.templates.java.PackageDeclaration beansPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage, "st.beans");
   private final nextgen.templates.java.PackageDeclaration snippetsPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage, "snippets");
   private final nextgen.templates.java.PackageDeclaration workflowPackage = nextgen.templates.JavaPatterns.newPackageDeclaration(corePackage, "workflow");

   final AppEvents appEvents = NextgenST.newAppEvents()
         .setPackageName(stPackage.getName())
         .setName("STAppEvents");


   @org.junit.Test
   public void generateSnippetsDomain() {

      final Entity snippet = DomainPatterns.newEntity("ShellSnippet")
            .addRelations(DomainPatterns.newStringField("id"))
            .addRelations(DomainPatterns.newStringField("source"));
//                  .addRelations(DomainPatterns.newEnumField("kind", DomainPatterns.newEnum("SnippetKind", "ERRONEOUS", "EXPRESSION", "IMPORT", "METHOD", "STATEMENT", "TYPE_DECL", "VAR")))
//                  .addRelations(DomainPatterns.newEnumField("subKind", DomainPatterns.newEnum("SnippetSubKind", "ANNOTATION", "ASSIGNMENT", "CLASS", "ENUM", "INTERFACE", "METHOD", "OTHER_EXPRESSION", "SINGLE_STATIC_IMPORT", "SINGLE_TYPE_IMPORT", "STATEMENT", "STATIC_IMPORT_ON_DEMAND", "TEMP_VAR", "TYPE_IMPORT_ON_DEMAND", "UNKNOWN", "VAR_DECLARATION", "VAR_VALUE")))
//                  .addRelations(DomainPatterns.newStringField("expressionName"))
//                  .addRelations(DomainPatterns.newStringField("expressionTypeName"))
//                  .addRelations(DomainPatterns.newStringField("persistentName"))

      final Entity script = DomainPatterns.newEntity("ShellScript")
            .addRelations(DomainPatterns.newStringField("uuid"))
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("snippets", snippet));

      DomainPatterns.writeNeo(mainJava, snippetsPackage, DomainPatterns.newDomain("JShell")
            .addEntities(script));

     generateAppEvents();
   }

   /**
    * generateMetaDomain
    */
   @org.junit.Test
   public void generateMetaDomain() {
      // meta
      final Entity metaProperty = DomainPatterns.newEntity("MetaProperty")
            .addRelations(DomainPatterns.newStringField("uuid"))
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("type"))
            .addRelations(DomainPatterns.newStringField("defaultValue"));

      final Entity metaEntity = DomainPatterns.newEntity("MetaEntity")
            .addRelations(DomainPatterns.newStringField("uuid"))
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("properties", metaProperty));

      final Entity metaRelation = DomainPatterns.newEntity("MetaRelation")
            .addRelations(DomainPatterns.newStringField("uuid"))
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newEnumField("cardinality", "Cardinality", "ONE_TO_ONE,ONE_TO_MANY"))
            .addRelations(DomainPatterns.newOneToMany("dst", metaEntity))
            .addRelations(DomainPatterns.newOneToMany("properties", metaProperty));

      metaEntity.addRelations(DomainPatterns.newOneToMany("relations", metaRelation));

      final Entity domainVisitor = DomainPatterns.newEntity("DomainVisitor")
            .addRelations(DomainPatterns.newStringField("uuid"))
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("initStatements"))
            .addRelations(DomainPatterns.newStringField("endStatements"))
            .addRelations(DomainPatterns.newOneToMany("fields", DomainPatterns.newEntity("VisitorField")
                  .addRelations(DomainPatterns.newStringField("uuid"))
                  .addRelations(DomainPatterns.newStringField("name"))
                  .addRelations(DomainPatterns.newStringField("type"))))
            .addRelations(DomainPatterns.newOneToMany("entityVisitors", DomainPatterns.newEntity("EntityVisitorMethod")
                  .addRelations(DomainPatterns.newStringField("uuid"))
                  .addRelations(DomainPatterns.newRef("_meta", metaEntity))
                  .addRelations(DomainPatterns.newStringField("statements"))))
            .addRelations(DomainPatterns.newOneToMany("relationVisitors", DomainPatterns.newEntity("RelationVisitorMethod")
                  .addRelations(DomainPatterns.newStringField("uuid"))
                  .addRelations(DomainPatterns.newRef("_meta", metaRelation))
                  .addRelations(DomainPatterns.newStringField("statements"))));

      final Entity metaDomain = DomainPatterns.newEntity("MetaDomain")
            .addRelations(DomainPatterns.newStringField("uuid"))
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("roots", metaEntity))
            .addRelations(DomainPatterns.newOneToMany("properties", metaProperty))
            .addRelations(DomainPatterns.newOneToMany("visitors", domainVisitor));

      // models
      final Entity domainEntity = DomainPatterns.newEntity("DomainEntity")
            .addRelations(DomainPatterns.newStringField("uuid"))
            .addRelations(DomainPatterns.newRef("_meta", metaEntity));

      final Domain domain = DomainPatterns.newDomain("MetaDomain")
            .addEntities(metaDomain)
            .addEntities(domainEntity)
            .addEntities(domainVisitor);
      DomainPatterns.writeNeo(mainJava, metaDomainPackage, domain);
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
    * generateAppEvents
    */
   @org.junit.Test
   public void generateAppEvents() {
      appEvents
            .addEvents(NextgenST.newAppEvent()
                  .setName("NewMetaDomain")
                  .addFields("nextgen.domains.meta.MetaDomain", "metaDomain"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("NewMetaEntity")
                  .addFields("nextgen.domains.meta.MetaEntity", "metaEntity"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("NewMetaProperty")
                  .addFields("nextgen.domains.meta.MetaProperty", "metaProperty"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("NewMetaRelation")
                  .addFields("nextgen.domains.meta.MetaRelation", "metaRelation"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("CanvasSTModelClicked")
                  .addFields("nextgen.st.model.STModel", "stModel"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("STModelUpdated")
                  .addFields("nextgen.st.model.STModel", "stModel"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("NewDomainEntity")
                  .addFields("nextgen.domains.meta.DomainEntity", "domainEntity"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("OpenMetaDomain")
                  .addFields("nextgen.domains.meta.MetaDomain", "metaDomain"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("OpenMetaEntity")
                  .addFields("nextgen.domains.meta.MetaEntity", "metaEntity"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("OpenMetaProperty")
                  .addFields("nextgen.domains.meta.MetaProperty", "metaProperty"))
            .addEvents(NextgenST.newAppEvent()
                  .setName("OpenMetaRelation")
                  .addFields("nextgen.domains.meta.MetaRelation", "metaRelation"))
             .addEvents(NextgenST.newAppEvent()
                  .setName("STModelTreeNodeClicked")
                  .addFields("nextgen.st.model.STModel", "stModel"));

      STGenerator.writeJavaFile(appEvents, appEvents.getPackageName().toString(), appEvents.getName()
            .toString(), mainJava);
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

   /**
    * test2
    */
   @org.junit.Test
   public void test2() {
   }


   protected static void log(Object log) {
      System.out.println(log);
   }

   class JavaType {

      final nextgen.templates.java.ClassOrInterfaceType type;

      JavaType(String packageDeclaration, String name) {
         this.type = nextgen.templates.java.JavaST.newClassOrInterfaceType()
               .setScope(packageDeclaration)
               .addNames(name);
      }

      JavaType(nextgen.templates.java.PackageDeclaration packageDeclaration, String name) {
         this(packageDeclaration.getName(), name);
      }
   }
}