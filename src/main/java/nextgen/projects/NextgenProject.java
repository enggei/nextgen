package nextgen.projects;

import nextgen.templates.domain.DomainPatterns;
import nextgen.templates.javaeasyflows.JavaEasyFlowsPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.javaeasyflows.WorkFlowFacade;
import nextgen.templates.javaneo4jembedded.*;

import java.io.File;

import static nextgen.st.STGenerator.writeJavaFile;
import static nextgen.templates.domain.DomainPatterns.*;
import static nextgen.templates.java.JavaPatterns.*;

public class NextgenProject {

   static final File root = new File("/home/goe/projects/nextgen");
   static final File mainJava = new File(root, "src/main/java");

   static final PackageDeclaration corePackage = newPackageDeclaration("nextgen");
   static final PackageDeclaration stPackage = newPackageDeclaration(corePackage, "st");
   static final PackageDeclaration parsePackage = newPackageDeclaration(stPackage, "parser");
   static final PackageDeclaration canvasPackage = newPackageDeclaration(stPackage, "canvas");
   static final PackageDeclaration canvasLayoutPackage = newPackageDeclaration(canvasPackage, "layout");
   static final PackageDeclaration workflowPackage = newPackageDeclaration(corePackage, "workflow");
   static final PackageDeclaration stModelPackage = newPackageDeclaration(corePackage, "model");

   @org.junit.Test
   public void generateDomain() {

      final Entity stParameterType = DomainPatterns.newEnum("STParameterType", "SINGLE,LIST,KVLIST");

      final Entity stParameterKey = DomainPatterns
            .newEntityWithUuid("STParameterKey")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("argumentType"));

      final Entity stParameter = DomainPatterns
            .newEntityWithUuid("STParameter")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newEnumField("type", stParameterType))
            .addRelations(DomainPatterns.newOneToMany("keys", stParameterKey))
            .addRelations(DomainPatterns.newStringField("argumentType"));

      final Entity stInterface = DomainPatterns
            .newEntityWithUuid("STInterface")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name"));

      final Entity stEnumValue = DomainPatterns
            .newEntityWithUuid("STEnumValue")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("lexical"));

      final Entity stEnum = DomainPatterns
            .newEntityWithUuid("STEnum")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newOneToMany("values", stEnumValue));

      final Entity stTemplate = DomainPatterns
            .newEntityWithUuid("STTemplate")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("text"))
            .addRelations(DomainPatterns.newOneToManyString("implements"))
            .addRelations(DomainPatterns.newOneToMany("parameters", stParameter))
            .addRelations(DomainPatterns.newOneToOne("labelParameter", stParameter))
            .addRelations(DomainPatterns.newOneToManySelf("children"));

      final Entity stValue = DomainPatterns
            .newEntityWithUuid("STValue")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("value"))
            .addRelations(DomainPatterns.newEnumField("type", DomainPatterns.newEnum("STValueType", "STMODEL,PRIMITIVE,ENUM")));

      final Entity stFile = DomainPatterns
            .newEntityWithUuid("STFile")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newOneToOne("name", stValue, true))
            .addRelations(DomainPatterns.newOneToOne("type", stValue))
            .addRelations(DomainPatterns.newOneToOne("packageName", stValue))
            .addRelations(DomainPatterns.newOneToOne("path", stValue));

      final Entity stGroupFile = DomainPatterns
            .newEntityWithUuid("STGroupFile")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newOneToOne("packageName", stValue))
            .addRelations(DomainPatterns.newOneToOne("path", stValue));

      final Entity stGroupAction = DomainPatterns
            .newEntityWithUuid("STGroupAction")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newOneToOne("statements", stValue))
            .addRelations(DomainPatterns.newOneToOne("methods", stValue));

      final Entity stGroupModel = DomainPatterns
            .newEntityWithUuid("STGroupModel")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("delimiter"))
            .addRelations(DomainPatterns.newStringField("icon"))
            .addRelations(DomainPatterns.newStringField("tags"))
            .addRelations(DomainPatterns.newOneToMany("files", stGroupFile))
            .addRelations(DomainPatterns.newOneToMany("templates", stTemplate))
            .addRelations(DomainPatterns.newOneToMany("interfaces", stInterface))
            .addRelations(DomainPatterns.newOneToMany("enums", stEnum))
            .addRelations(DomainPatterns.newOneToMany("actions", stGroupAction));

      final Entity stArgumentKV = DomainPatterns
            .newEntityWithUuid("STArgumentKV")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newOneToOne("stParameterKey", stParameterKey))
            .addRelations(DomainPatterns.newOneToOne("value", stValue));

      final Entity stArgument = DomainPatterns
            .newEntityWithUuid("STArgument")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newOneToOne("stParameter", stParameter))
            .addRelations(DomainPatterns.newOneToOne("value", stValue))
            .addRelations(DomainPatterns.newOneToMany("keyValues", stArgumentKV));

      final Entity stModel = DomainPatterns
            .newEntityWithUuid("STModel")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newOneToOne("stTemplate", stTemplate))
            .addRelations(DomainPatterns.newOneToMany("files", stFile))
            .addRelations(DomainPatterns.newOneToMany("arguments", stArgument));

      stValue.addRelations(DomainPatterns.newOneToOne("stModel", stModel));
      stValue.addRelations(DomainPatterns.newOneToOne("stEnumValue", stEnumValue));

      final Entity stProject = DomainPatterns
            .newEntityWithUuid("STProject")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("models", stModel))
            .addRelations(DomainPatterns.newOneToMany("values", stValue));

      final Domain domain = DomainPatterns
            .newDomain("STModel")
            .addEntities(stGroupModel)
            .addEntities(stParameterType)
            .addEntities(stModel)
            .addEntities(stProject);

      final org.javatuples.Pair<NeoFactory, java.util.Map<nextgen.templates.domain.Entity, NodeWrapper>> neo = transform(stModelPackage, domain);

      final NeoFactory neoFactory = neo.getValue0();
      final java.util.Map<nextgen.templates.domain.Entity, NodeWrapper> nodeWrapperMap = neo.getValue1();

      for (NodeWrapper nodeWrapper : nodeWrapperMap.values())
         writeJavaFile(nodeWrapper, stModelPackage, nodeWrapper.getName(), mainJava);

      writeJavaFile(neoFactory, stModelPackage, neoFactory.getName(), mainJava);

      final Entity astNode = newEntity("AstNode")
            .addRelations(newOneToOneExternal("ast", "org.antlr.runtime.tree.Tree"))
            .addRelations(newOneToManySelf("children"))
            .addRelations(newEnumField("type", "AstNodeType", "ST, Expression, Name, Prop, Args, If, Else, ElseIf, Assign, Include, Subtemplate"));
      astNode.addRelations(newOneToOne("parent", astNode));

      final Entity parsedSTParameterKey = DomainPatterns
            .newEntity("ParsedSTParameterKey")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("argumentType"));

      final Entity parsedSTParameter = DomainPatterns
            .newEntity("ParsedSTParameter")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newExternalRef("type", newClassOrInterfaceType(stModelPackage, stParameterType.getName())))
            .addRelations(DomainPatterns.newOneToMany("keys", parsedSTParameterKey))
            .addRelations(DomainPatterns.newStringField("argumentType"));

      final Entity parsedSTTemplate = DomainPatterns
            .newEntity("ParsedSTTemplate")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("text"))
            .addRelations(DomainPatterns.newOneToMany("parameters", parsedSTParameter));

      final Entity parsedSTGroupModel = DomainPatterns
            .newEntity("ParsedSTGroupModel")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("delimiter"))
            .addRelations(DomainPatterns.newOneToMany("templates", parsedSTTemplate));

      final Entity parserErrorType = DomainPatterns.newEnum("ParserErrorType", "COMPILE,RUNTIME,IO,INTERNAL");

      final Entity parserError = DomainPatterns
            .newEntity("ParserError")
            .addRelations(DomainPatterns.newEnumField("type", parserErrorType))
            .addRelations(DomainPatterns.newStringField("message"))
            .addRelations(DomainPatterns.newIntegerField("line"))
            .addRelations(DomainPatterns.newIntegerField("charPosition"));

      final Entity parseResult = DomainPatterns
            .newEntity("ParseResult")
            .addRelations(DomainPatterns.newOneToOne("parsed", parsedSTGroupModel))
            .addRelations(DomainPatterns.newOneToMany("errors", parserError));

      DomainPatterns.writePojo(mainJava, parsePackage, DomainPatterns
            .newDomain("STParser")
            .addEntities(astNode)
            .addEntities(parseResult));
   }

   public void generateCanvasLayoutDomain() {
      final Entity layoutDomain = DomainPatterns
            .newEntityWithUuid("Layout")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("nodes", DomainPatterns
                  .newEntityWithUuid("LayoutNode")
                  .addRelations(DomainPatterns.newDoubleField("x"))
                  .addRelations(DomainPatterns.newDoubleField("y"))));

      final Domain domain = DomainPatterns
            .newDomain("Layout")
            .addEntities(layoutDomain);
      DomainPatterns.writeNeo(mainJava, canvasLayoutPackage, domain);
   }

   public void generateWorkflowsDomain() {

      // Workflows
      final Entity workInput = DomainPatterns
            .newEntityWithUuid("WorkInput")
            .addRelations(DomainPatterns.newStringField("type"))
            .addRelations(DomainPatterns.newStringField("name"));

      final Entity workStatement = DomainPatterns
            .newEntityWithUuid("WorkStatement")
            .addRelations(DomainPatterns.newStringField("statement"));

      final Entity workInstance = DomainPatterns
            .newEntityWithUuid("WorkInstance")
            .addRelations(DomainPatterns.newEnumField("type", "WorkType", "WORK,CONDITIONAL,SEQUENTIAL,PARALLEL,REPEAT"));

      final Entity work = DomainPatterns
            .newEntityWithUuid("Work")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("package"))
            .addRelations(DomainPatterns.newOneToMany("inputs", workInput))
            .addRelations(DomainPatterns.newOneToMany("statements", workStatement));
      workInstance.addRelations(DomainPatterns.newOneToOne("work", work));

      final Entity conditionalFlow = DomainPatterns
            .newEntityWithUuid("ConditionalFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("execute", workInstance))
            .addRelations(DomainPatterns.newOneToOne("then", workInstance))
            .addRelations(DomainPatterns.newOneToOne("otherwise", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("conditional", conditionalFlow));

      final Entity sequentialFlow = DomainPatterns
            .newEntityWithUuid("SequentialFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("execute", workInstance))
            .addRelations(DomainPatterns.newOneToMany("then", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("sequential", sequentialFlow));

      final Entity parallelFlow = DomainPatterns
            .newEntityWithUuid("ParallelFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("execute", workInstance));
      workInstance.addRelations(DomainPatterns.newOneToOne("parallel", parallelFlow));

      final Entity repeatFlow = DomainPatterns
            .newEntityWithUuid("RepeatFlow")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToOne("repeat", workInstance))
            .addRelations(DomainPatterns.newIntegerField("times"))
            .addRelations(DomainPatterns.newEnumField("until", "UntilPredicate", "ALWAYS_TRUE,ALWAYS_FALSE,COMPLETED,FAILED"));
      workInstance.addRelations(DomainPatterns.newOneToOne("repeat", repeatFlow));

      final Domain domain = DomainPatterns
            .newDomain("WorkFlow")
            .addEntities(work)
            .addEntities(workInstance);

      DomainPatterns.writeNeo(mainJava, workflowPackage, domain);
      final WorkFlowFacade workFlowFacade = JavaEasyFlowsPatterns
            .newWorkFlowFacade()
            .setName("WorkFlowFacade")
            .setPackageName(workflowPackage.getName());
      writeJavaFile(workFlowFacade, workflowPackage, workFlowFacade.getName(), mainJava);

      DomainPatterns.writeGreenrobotEvents(mainJava, workflowPackage, workflowPackage, domain);
   }
}