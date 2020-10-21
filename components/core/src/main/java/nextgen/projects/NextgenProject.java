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
import nextgen.utils.StringUtil;
import org.junit.Before;
import nextgen.templates.javaneo4jembedded.*;

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

   final String presentationModelName = "STAppPresentationModel";
   final String appModelName = "AppModel";
   final String stringType = "String";
   final String awtDimensionType = "java.awt.Dimension";
   final String integerType = "Integer";
   final String jFrameType = "javax.swing.JFrame";


   final PackageDeclaration corePackage = JavaPatterns.newPackageDeclaration("nextgen");
   final PackageDeclaration stPackage = JavaPatterns.newPackageDeclaration(corePackage, "st");
   final PackageDeclaration eventsPackage = JavaPatterns.newPackageDeclaration(corePackage, "events");
   final PackageDeclaration canvasPackage = JavaPatterns.newPackageDeclaration(stPackage, "canvas");
   final PackageDeclaration canvasLayoutPackage = JavaPatterns.newPackageDeclaration(canvasPackage, "layout");
   final PackageDeclaration workflowPackage = JavaPatterns.newPackageDeclaration(corePackage, "workflow");
   final PackageDeclaration swingPackage = JavaPatterns.newPackageDeclaration(corePackage, "swing");
   final PackageDeclaration swingConfigPackage = JavaPatterns.newPackageDeclaration(swingPackage, "config");
   final PackageDeclaration actionsPackage = JavaPatterns.newPackageDeclaration(corePackage, "actions");

   final PackageDeclaration stModelPackage = JavaPatterns.newPackageDeclaration(stPackage, "model");
   final nextgen.templates.java.ClassOrInterfaceType stArgumentType = newClassOrInterfaceType(stModelPackage, "STArgument");
   final nextgen.templates.java.ClassOrInterfaceType stProjectType = newClassOrInterfaceType(stModelPackage, "STProject");
   final nextgen.templates.java.ClassOrInterfaceType stModelType = newClassOrInterfaceType(stModelPackage, "STModel");
   final nextgen.templates.java.ClassOrInterfaceType stValueType = newClassOrInterfaceType(stModelPackage, "STValue");
   final nextgen.templates.java.ClassOrInterfaceType stFileType = newClassOrInterfaceType(stModelPackage, "STFile");

   final PackageDeclaration stDomainPackage = JavaPatterns.newPackageDeclaration(stPackage, "domain");
   final nextgen.templates.java.ClassOrInterfaceType stGroupModelType = newClassOrInterfaceType(stDomainPackage, "STGroupModel");
   final nextgen.templates.java.ClassOrInterfaceType stTemplateType = newClassOrInterfaceType(stDomainPackage, "STTemplate");
   final nextgen.templates.java.ClassOrInterfaceType stEnumType = newClassOrInterfaceType(stDomainPackage, "STEnum");
   final nextgen.templates.java.ClassOrInterfaceType stInterfaceType = newClassOrInterfaceType(stDomainPackage, "STInterface");
   final nextgen.templates.java.ClassOrInterfaceType stParameterType = newClassOrInterfaceType(stDomainPackage, "STParameter");
   final nextgen.templates.java.ClassOrInterfaceType stParameterKeyType = newClassOrInterfaceType(stDomainPackage, "STParameterKey");

   final nextgen.templates.java.ClassOrInterfaceType ownerType = newClassOrInterfaceType("javax.swing", "JComponent");


   @Before
   public void init() {
      typesMap.put(presentationModelName, JavaPatterns.newClassOrInterfaceType(stPackage, presentationModelName));
   }

   @org.junit.Test
   public void generateWorkspace() {


      final nextgen.templates.nextgen.STWorkspace stWorkspace = nextgen.templates.nextgen.NextgenST.newSTWorkspace()
            .setPackageName(stPackage.getName())
            .setName("STWorkspace")
            .addFields("STTemplateNavigator", "templateNavigator", null)
            .addFields("STModelNavigator", "modelNavigator", null)
            .addConstructorParameters(nextgen.templates.GreenRobotPatterns.newRegister())
            .addConstructorParameters("findCanvas();")
            .addConstructorParameters("appModel().doInTransaction(transaction -> {\n" +
                  "	templateNavigator = new STTemplateNavigator(this);\n" +
                  "	modelNavigator = new STModelNavigator(this);\n" +
                  "});")
//            .addMethods(nextgen.templates.nextgen.NextgenST.newEventSubscriber()
//                  .setEventName("STModelCanvasNodeClicked")
//                  .setEventType("nextgen.events.STModelTreeNodeClicked")
//                  .addStatements("setSelectedComponent(findModelEditor(event.model, () -> appModel().findSTTemplateByUuid(event.model.getStTemplate())));"))
//            .addMethods(newSubscribe()
//                  .setEventName("STModelDeleted")
//                  .setEventType(nextgen.templates.java.JavaST.newJavaType()
//                        .setPackageName("nextgen.events")
//                        .setName("STModelDeleted"))
//                  .addStatements("SwingUtilities.invokeLater(() -> removeModelEditor(event.uuid));"))
            ;

      nextgen.st.STGenerator.writeJavaFile(stWorkspace, stPackage, stWorkspace.getName(), mainJava);
   }

   @org.junit.Test
   public void generateActions() {

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("CopyModel")
            .setTitle("Copy Model")
            .addFields(stModelType, "stModel")
            .addStatements("nextgen.utils.SwingUtil.toClipboard(\"stmodel-\" + stModel.getUuid());"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetMultipleFields")
            .setTitle("Set Fields")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stModelType, "stModel")
            .addFields(ownerType, "owner")
            .addStatements("appModel().doLaterInTransaction(t -> appModel().setMultiple(owner, stModel, stTemplate));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("OpenModel")
            .setTitle("Open")
            .addFields(stModelType, "stModel")
            .addStatements("nextgen.events.OpenSTModel.post(stModel);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("OpenTemplate")
            .setTitle("Open")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("appModel().doLaterInTransaction(transaction -> nextgen.events.OpenSTTemplate.post(stTemplate));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("OpenTemplate")
            .setTitle("Open")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("nextgen.events.OpenSTTemplate.post(stTemplate);"));


      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("WriteSTModelToFile")
            .setTitle("Visit")
            .addFields(stModelType, "stModel")
            .addStatements("appModel().writeToFile(stModel);"));


      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("NewProject")
            .setTitle("New Project")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name -> appModel().doLaterInTransaction(t -> appModel().newSTProject(name)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("NewSTModel")
            .setTitle("New instance")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("appModel().newSTModel(stTemplate);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("EditModels")
            .setTitle("Edit")
            .addFields(stTemplateType, "stTemplate")
            .setStatements(new Object[]{
                  "final nextgen.st.STModelGrid stModelGrid = appModel().getWorkspace().getModelGrid(stTemplate);",
                  "appModel().getWorkspace().setSelectedComponent(stModelGrid);",
                  "stModelGrid.requestFocusInWindow();"
            }));

      // STModel actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("OpenSTModel")
            .setTitle("Open")
            .addFields(stModelType, "stModel")
            .addStatements("nextgen.events.OpenSTModel.post(stModel);"));


      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("GenerateSource")
            .setTitle("As builder code")
            .addFields(stModelType, "stModel")
            .addStatements("appModel().generateSource(stModel);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("WriteToFile")
            .setTitle("Generate")
            .addFields(stModelType, "stModel")
            .addStatements("appModel().writeToFile(stModel);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("DeleteSTModel")
            .setTitle("Delete")
            .addFields(stModelType, "stModel")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "         final String uuid = stModel.getUuid();\n" +
                  "         final nextgen.st.model.STValue found = appModel().db.findSTValueByUuid(uuid);\n" +
                  "         if (found != null) appModel().db.delete(found.getNode());\n" +
                  "         nextgen.events.STModelDeleted.post(uuid);\n" +
                  "      });"));


      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("UndoDBTransaction")
            .setTitle("Undo")
            .addStatements("appModel().undoLast();"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("RemoveArgument")
            .setTitle("Remove")
            .addFields("Object", "argument")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "nextgen.utils.SwingUtil.confirm(owner, \"Remove\")",
                  "							.ifPresent(aBoolean ->",
                  "									appModel().doLaterInTransaction(t -> {",
                  "										if (argument instanceof nextgen.st.model.STArgument)",
                  "											appModel().remove((nextgen.st.model.STArgument) argument);",
                  "										else if (argument instanceof nextgen.st.model.STArgumentKV)",
                  "											appModel().remove((nextgen.st.model.STArgumentKV) argument);",
                  "									}));"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("EditSTModel")
            .setTitle("Edit")
            .addFields(stModelType, "stModel")
            .addStatements("javax.swing.SwingUtilities.invokeLater(() -> appModel().doInTransaction(t -> appModel().getWorkspace().setSelectedComponent(appModel().getModelEditor(stModel))));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("STValueToClipboard")
            .setTitle("To Clipboard")
            .addFields(stValueType, "stValue")
            .addStatements("appModel().doLaterInTransaction(t -> nextgen.utils.SwingUtil.toClipboard(appModel().render(stValue)));"));

      // STKVArgument actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetKVArgumentFromInput")
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.showInputDialog(stParameterKey.getName(), owner, inputValue -> appModel().doLaterInTransaction(transaction1 -> appModel().set(stArgument, stParameterKey, inputValue)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetKVArgumentFromClipboard")
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stArgument, stParameterKey, nextgen.utils.SwingUtil.fromClipboard()));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetKVArgumentFromSTValue")
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addFields(stValueType, "value")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stArgument, stParameterKey, value));"));

      // STArgument actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetArgumentFromInput")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.showInputDialog(stParameter.getName(), owner, inputValue -> appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, inputValue)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddArgumentFromInput")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.showInputDialog(stParameter.getName(), owner, inputValue -> appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, inputValue)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetArgumentToTrue")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, \"TRUE\"));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetArgumentFromClipboard")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, nextgen.utils.SwingUtil.fromClipboard()));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetSTValueFromClipboard")
            .setTitle("Set from Clipboard")
            .addFields(stValueType, "stValue")
            .addStatements("appModel().set(stValue, nextgen.utils.SwingUtil.fromClipboard());"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("DeleteSTValue")
            .setTitle("Delete")
            .addFields(stValueType, "stValue")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.confirm(owner, \"Delete\").ifPresent(aBoolean -> appModel().doLaterInTransaction(t -> appModel().delete(stValue)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddArgumentFromClipboard")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addStatements("      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "      stModel.addArguments(stArgument);\n" +
                  "      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetArgumentFromSTValue")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stValueType, "value")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, value));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddArgumentFromSTValue")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stValueType, "value")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, value));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetArgumentFromSTModel")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stModelType, "value")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, value));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddArgumentFromSTModel")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stModelType, "value")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, value));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddArgumentFromArgumentType")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("appModel().addList(stParameter, stModel, owner);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddMultipleArgumentsFromArgumentType")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("appModel().addMultiple(owner, stModel, stParameter);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddKVArgument")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("appModel().addKVArgument(stModel, stParameter, owner);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetArgumentFromSTTemplate")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stTemplateType, "value")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, appModel().newSTModel(value)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddArgumentFromSTTemplate")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stTemplateType, "value")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, appModel().newSTModel(value)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetArgumentFromSTModelUuid")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields("String", "uuid")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, appModel().db.cloneSTModel(uuid)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddArgumentFromSTModelUuid")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields("String", "uuid")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, appModel().db.cloneSTModel(uuid)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetKVArgumentFromSTModel")
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addFields(stModelType, "stModel")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().set(stArgument, stParameterKey, stModel));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("RemoveKVArgument")
            .setTitle("Remove")
            .addFields(stArgumentType, "argument")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.confirm(owner, \"Delete ?\").ifPresent(aBoolean -> appModel().remove(argument));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("RemoveKV")
            .setTitle("Remove")
            .addFields("nextgen.st.model.STArgumentKV", "argumentKV")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.confirm(owner, \"Delete ?\").ifPresent(aBoolean -> appModel().remove(argumentKV));"));


      // STProject actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddModelToProject")
            .addFields(stProjectType, "project")
            .addFields(stModelType, "stModel")
            .addStatements("appModel().addToProject(project, stModel);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("GenerateAllProjectModels")
            .setTitle("Generate all")
            .addFields(stProjectType, "project")
            .addStatements("appModel().writeToFile(project);"));


      // Template Navigator actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("NewSTGroup")
            .setTitle("New STGroup")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name -> {",
                  "",
                  "	final java.util.Optional<nextgen.st.domain.STGroupModel> existing = appModel().findSTGroup(name);",
                  "	if (existing.isPresent()) {",
                  "		nextgen.utils.SwingUtil.showMessage(name + \" group already exists in this directory\", owner);",
                  "		return;",
                  "	}",
                  "",
                  "	if (!javax.lang.model.SourceVersion.isIdentifier(name)) {",
                  "		nextgen.utils.SwingUtil.showMessage(name + \" is a reserved java keyword\", owner);",
                  "		return;",
                  "	}",
                  "",
                  "	appModel().newSTGroupModel(name);",
                  "});"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("GenerateAllSTGroups")
            .setTitle("Generate all")
            .addStatements("appModel().generateAllGroups();"));

      // STGroup actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("EditSTGroupTags")
            .setTitle("Edit tags")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("appModel().editSTGroupTags(owner, stGroup);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("ImportSTTemplate")
            .setTitle("Import from stg-file")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "nextgen.utils.SwingUtil.showOpenFile(owner, appModel().getLastDir())",
                  "				.ifPresent(file -> {",
                  "					appModel().setLastDir(file.getParentFile());",
                  "					appModel().doLaterInTransaction(t -> {",
                  "						final String fileName = file.getName();",
                  "						final String name = fileName.substring(0, fileName.indexOf(\".\"));",
                  "						appModel().newSTTemplate(name, nextgen.utils.FileUtil.readIntact(file), stGroup);",
                  "					});",
                  "				});"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("GenerateSTGroup")
            .setTitle("Generate")
            .addFields(stGroupModelType, "stGroup")
            .addStatements("appModel().generateSTGroup(stGroup, false);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("NewTemplate")
            .setTitle("New Template")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->",
                  "				nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> {",
                  "					appModel().newSTTemplate(name, stGroup);",
                  "				}));"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("NewEnum")
            .setTitle("New Enum")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->",
                  "				nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> {",
                  "					appModel().addEnum(stGroup, name);",
                  "				}));"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("NewInterface")
            .setTitle("New Interface")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->",
                  "				nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> {",
                  "					appModel().addInterface(stGroup, name);",
                  "				}));"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("DeleteSTGroup")
            .setTitle("Delete")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.confirm(owner, \"Delete\").ifPresent(aBoolean -> appModel().doLaterInTransaction(t -> appModel().delete(stGroup)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("RenameSTGroup")
            .setTitle("Rename")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->",
                  "				nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> {",
                  "					appModel().setName(stGroup, name);",
                  "				}));"
            }));

      // STENum Node actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("EditEnum")
            .setTitle("Edit")
            .addFields(stEnumType, "stEnum")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "final int newFields = 5;",
                  "",
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout((int) stEnum.getValues().count() + newFields + 1, 2));",
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));",
                  "contentPanel.add(new javax.swing.JLabel(\"Name\"));",
                  "contentPanel.add(new javax.swing.JLabel(\"Lexical\"));",
                  "",
                  "// existing values:",
                  "final java.util.Map<nextgen.st.domain.STEnumValue, javax.swing.JTextField> txtEnumValuesName = new java.util.LinkedHashMap<>();",
                  "final java.util.Map<nextgen.st.domain.STEnumValue, javax.swing.JTextField> txtEnumLexical = new java.util.LinkedHashMap<>();",
                  "stEnum.getValues().forEach(stEnumValue -> {",
                  "	txtEnumValuesName.put(stEnumValue, nextgen.utils.SwingUtil.newTextField(stEnumValue.getName(), 10));",
                  "	txtEnumLexical.put(stEnumValue, nextgen.utils.SwingUtil.newTextField(stEnumValue.getLexical(), 10));",
                  "	contentPanel.add(txtEnumValuesName.get(stEnumValue));",
                  "	contentPanel.add(txtEnumLexical.get(stEnumValue));",
                  "});",
                  "",
                  "// allow adding new values:",
                  "final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumValuesName = new java.util.LinkedHashMap<>();",
                  "final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumLexical = new java.util.LinkedHashMap<>();",
                  "for (int i = 0; i < newFields; i++) {",
                  "	newTxtEnumValuesName.put(i, nextgen.utils.SwingUtil.newTextField(\"\", 10));",
                  "	newTxtEnumLexical.put(i, nextgen.utils.SwingUtil.newTextField(\"\", 10));",
                  "",
                  "	contentPanel.add(newTxtEnumValuesName.get(i));",
                  "	contentPanel.add(newTxtEnumLexical.get(i));",
                  "}",
                  "",
                  "final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities.getAncestorOfClass(javax.swing.JFrame.class, owner), \"Edit Enum\", true);",
                  "dialog.add(contentPanel, java.awt.BorderLayout.CENTER);",
                  "",
                  "final javax.swing.JButton btnSave = new javax.swing.JButton(nextgen.st.STAppPresentationModel.newAction(\"Save\", actionEvent1 -> {",
                  "",
                  "	for (nextgen.st.domain.STEnumValue stEnumValue : txtEnumValuesName.keySet()) {",
                  "		final String txtEnumValueName = txtEnumValuesName.get(stEnumValue).getText().trim();",
                  "		final String txtEnumValueLexical = txtEnumLexical.get(stEnumValue).getText().trim();",
                  "",
                  "		stEnumValue.setName(txtEnumValueName);",
                  "		stEnumValue.setLexical(txtEnumValueLexical.length() == 0 ? null : txtEnumValueLexical);",
                  "	}",
                  "",
                  "	for (int i = 0; i < newFields; i++) {",
                  "		final String newEnumValue = newTxtEnumValuesName.get(i).getText().trim();",
                  "		final String newEnumLexical = newTxtEnumLexical.get(i).getText().trim();",
                  "		if (newEnumValue.length() == 0) continue;",
                  "",
                  "		stEnum.addValues(nextgen.st.domain.STJsonFactory.newSTEnumValue()",
                  "																			.setName(newEnumValue)",
                  "																			.setLexical(newEnumLexical.length() == 0 ? null : newEnumLexical));",
                  "	}",
                  "",
                  "	appModel().update(stEnum);",
                  "	javax.swing.SwingUtilities.invokeLater(dialog::dispose);",
                  "}));",
                  "",
                  "nextgen.utils.SwingUtil.showDialog(owner, dialog, btnSave);"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("RenameEnum")
            .setTitle("Rename")
            .addFields(stEnumType, "stEnum")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->\n" +
                  "            nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> appModel().setName(stEnum, name)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("DeleteEnum")
            .setTitle("Delete")
            .addFields(stEnumType, "stEnum")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("appModel().delete(stEnum, stGroup);"));

      // STTemplate actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddChildrenToTemplate")
            .addFields(stTemplateType, "stTemplate")
            .addFields("java.util.Set<nextgen.st.domain.STTemplate>", "children")
            .addFields(ownerType, "owner")
            .addStatements("if (!nextgen.utils.SwingUtil.showConfirmDialog(owner, \"Sure to move ?\")) return;\n" +
                  "      javax.swing.SwingUtilities.invokeLater(() -> appModel().setParent(stTemplate, children));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddTemplateModelToProject")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stProjectType, "project")
            .addFields(ownerType, "owner")
            .addStatements("appModel().newSTModel(stTemplate, project);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("RemoveInterface")
            .addFields("String", "interfaceName")
            .addFields(stTemplateType, "stTemplate")
            .addFields(ownerType, "owner")
            .addStatements("appModel().removeInterface(stTemplate, interfaceName);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("NewInstance")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("appModel().newSTModel(stTemplate);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("NewTemplateChild")
            .setTitle("Add Child template")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\")\n" +
                  "                             .ifPresent(candidateName -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, candidateName)\n" +
                  "                                                                                          .ifPresent(name -> appModel().newSTTemplate(candidateName, stTemplate)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetTemplateParameterTypes")
            .setTitle("Set parameter types")
            .addFields(stTemplateType, "stTemplate")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "final java.util.Map<String, javax.swing.JTextField> txtParameterMap = new java.util.TreeMap<>();",
                  "stTemplate.getParameters().forEach(stParameter -> {",
                  "",
                  "	switch (stParameter.getType()) {",
                  "",
                  "		case SINGLE:",
                  "		case LIST:",
                  "			final String key = stParameter.getName();",
                  "			txtParameterMap.put(key, nextgen.utils.SwingUtil.newTextField(stParameter.getArgumentType(\"Object\"), 15));",
                  "",
                  "			break;",
                  "		case KVLIST:",
                  "			stParameter.getKeys().forEach(stParameterKey -> {",
                  "				final String kvListKey = stParameter.getName() + \".\" + stParameterKey.getName();",
                  "				txtParameterMap.put(kvListKey, nextgen.utils.SwingUtil.newTextField(stParameterKey.getArgumentType(\"Object\"), 15));",
                  "			});",
                  "			break;",
                  "	}",
                  "});",
                  "",
                  "final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities",
                  "		.getAncestorOfClass(javax.swing.JFrame.class, owner), \"Set Parameter types\", true);",
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtParameterMap.size(), 2));",
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));",
                  "txtParameterMap.forEach((key, value) -> {",
                  "	contentPanel.add(new javax.swing.JLabel(key));",
                  "	contentPanel.add(value);",
                  "});",
                  "dialog.add(contentPanel, java.awt.BorderLayout.CENTER);",
                  "",
                  "final javax.swing.JButton btnSave = new javax.swing.JButton(nextgen.st.STAppPresentationModel.newAction(\"Save\", actionEvent1 -> {",
                  "	stTemplate.getParameters().forEach(stParameter -> {",
                  "",
                  "		switch (stParameter.getType()) {",
                  "",
                  "			case SINGLE:",
                  "			case LIST:",
                  "				final javax.swing.JTextField txtTypes = txtParameterMap.get(stParameter.getName());",
                  "				final String types = txtTypes.getText().trim();",
                  "				stParameter.setArgumentType(types.length() == 0 ? (stParameter.getName().startsWith(\"is\") ? \"Boolean\" : \"Object\") : types);",
                  "				break;",
                  "",
                  "			case KVLIST:",
                  "				stParameter.getKeys().forEach(stParameterKey -> {",
                  "					final javax.swing.JTextField txtKVTypes = txtParameterMap.get(stParameter.getName() + \".\" + stParameterKey.getName());",
                  "					final String kvTypes = txtKVTypes.getText().trim();",
                  "					stParameterKey.setArgumentType(kvTypes.length() == 0 ? (stParameterKey.getName().startsWith(\"is\") ? \"Boolean\" : \"Object\") : kvTypes);",
                  "				});",
                  "				break;",
                  "		}",
                  "	});",
                  "",
                  "	appModel().setParameterTypes(stTemplate);",
                  "",
                  "	javax.swing.SwingUtilities.invokeLater(dialog::dispose);",
                  "}));",
                  "",
                  "nextgen.utils.SwingUtil.showDialog(owner, dialog, btnSave);"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("SetInterfaces")
            .setTitle("Set interfaces")
            .addFields(stTemplateType, "stTemplate")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "final java.util.List<javax.swing.JTextField> txtImplements = new java.util.ArrayList<>();",
                  "stTemplate.getImplements().forEach(implement -> {",
                  "	final javax.swing.JTextField textField = nextgen.utils.SwingUtil.newTextField(implement, 15);",
                  "	txtImplements.add(textField);",
                  "});",
                  "txtImplements.add(nextgen.utils.SwingUtil.newTextField(\"\", 15));",
                  "txtImplements.add(nextgen.utils.SwingUtil.newTextField(\"\", 15));",
                  "",
                  "final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities",
                  "		.getAncestorOfClass(javax.swing.JFrame.class, owner), \"Edit interfaces\", true);",
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtImplements.size(), 1));",
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));",
                  "for (javax.swing.JTextField txtImplement : txtImplements) {",
                  "	contentPanel.add(txtImplement);",
                  "}",
                  "dialog.add(contentPanel, java.awt.BorderLayout.CENTER);",
                  "",
                  "final javax.swing.JButton btnSave = new javax.swing.JButton(nextgen.st.STAppPresentationModel.newAction(\"Save\", actionEvent1 -> {",
                  "",
                  "	stTemplate.clearImplements();",
                  "	for (javax.swing.JTextField txtImplement : txtImplements) {",
                  "		final String trim = txtImplement.getText().trim();",
                  "		if (trim.length() == 0) continue;",
                  "		stTemplate.addImplements(trim);",
                  "	}",
                  "	appModel().setInterfaces(stTemplate);",
                  "",
                  "	javax.swing.SwingUtilities.invokeLater(dialog::dispose);",
                  "}));",
                  "",
                  "nextgen.utils.SwingUtil.showDialog(owner, dialog, btnSave);"
            }));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("RenameSTTemplate")
            .setTitle("Rename")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->\n" +
                  "            nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> appModel().setName(stTemplate, name)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("DeleteSTTemplate")
            .setTitle("Delete")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("appModel().delete(stTemplate, stGroup);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("AddInterface")
            .addFields("java.util.Set<nextgen.st.domain.STTemplate>", "children")
            .addFields(ownerType, "owner")
            .setStatements(new Object[]{
                  "final javax.swing.JTextField txtImplements = new javax.swing.JTextField(\"\", 15);",
                  "",
                  "final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities",
                  "		.getAncestorOfClass(javax.swing.JFrame.class, owner), \"Edit interfaces\", true);",
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 1));",
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));",
                  "contentPanel.add(txtImplements);",
                  "dialog.add(contentPanel, java.awt.BorderLayout.CENTER);",
                  "",
                  "final javax.swing.JButton btnSave = new javax.swing.JButton(nextgen.st.STAppPresentationModel.newAction(\"Save\", actionEvent1 -> {",
                  "	final String interfaceName = txtImplements.getText().trim();",
                  "	appModel().addInterface(children, interfaceName);",
                  "	javax.swing.SwingUtilities.invokeLater(dialog::dispose);",
                  "}));",
                  "",
                  "nextgen.utils.SwingUtil.showDialog(owner, dialog, btnSave);"
            }));

      // STInterface actions
      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("RenameSTInterface")
            .setTitle("Rename")
            .addFields(stInterfaceType, "stInterface")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->\n" +
                  "            nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> appModel().setName(stInterface, name)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName("DeleteSTInterface")
            .setTitle("Delete")
            .addFields(stInterfaceType, "stInterface")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "         stGroup.removeInterfaces(stInterface);\n" +
                  "         nextgen.events.STInterfaceDeleted.post(stInterface.getUuid());   \n" +
                  "      });"));

   }

   @org.junit.Test
   public void generateEvents() {

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("NewSTArgument")
            .addFields(stArgumentType, "argument")
            .addFields(stModelType, "model")
            .addFields(stParameterType, "parameter")
            .addFields(stValueType, "value")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("NewSTModel")
            .addFields(stModelType, "model")
            .addFields(stTemplateType, "template")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("NewSTProjectSTModel")
            .addFields(stModelType, "model")
            .addFields(stProjectType, "project")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("NewSTTemplate")
            .addFields(stTemplateType, "template")
            .addFields("Object", "parent")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("NewSTProject")
            .addFields(stProjectType, "project")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("STValueChanged")
            .addFields(stValueType, "value")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("STValueDeleted")
            .addFields("String", "uuid")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("STModelDeleted")
            .addFields("String", "uuid")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("STInterfaceDeleted")
            .addFields("String", "uuid")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("STModelEditorTreeNodeClicked")
            .addFields(stModelType, "model")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("OpenSTModel")
            .addFields(stModelType, "model")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("OpenSTTemplate")
            .addFields(stTemplateType, "template")
            .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName("CanvasSTModelClicked")
            .addFields(stModelType, "model")
            .setPackageName(eventsPackage.getName()));

   }

   @org.junit.Test
   public void generateSTModelNavigator() {

      final nextgen.templates.nextgen.TreeNode stProjectTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STProjectTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.model")
                  .setName("STProject"))
            .setIcon("appModel().loadIcon(\"sq-white\")")
            .setLabelExpression("getModel().getName()")
            .setTooltipExpression("getModel().getName();")
            .addConstructorStatements("final Map<nextgen.st.domain.STGroupModel, STModelNavigator.STGroupModelTreeNode> stGroupTreeNodeMap = new java.util.LinkedHashMap<>();\n" +
                  "final Map<nextgen.st.domain.STTemplate, STModelNavigator.STTemplateTreeNode> stTemplateTreeNodeMap = new java.util.LinkedHashMap<>();\n" +
                  "model.getModelsSorted().forEach(stModel -> {\n" +
                  "\n" +
                  "	final nextgen.st.domain.STTemplate stTemplate = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
                  "	final nextgen.st.domain.STGroupModel stGroup = appModel().findSTGroup(stTemplate);\n" +
                  "\n" +
                  "	if (!stGroupTreeNodeMap.containsKey(stGroup)) {\n" +
                  "		final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroup);\n" +
                  "		add(stGroupModelTreeNode);\n" +
                  "		stGroupTreeNodeMap.put(stGroup, stGroupModelTreeNode);\n" +
                  "	}\n" +
                  "\n" +
                  "	if (!stTemplateTreeNodeMap.containsKey(stTemplate)) {\n" +
                  "		final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);\n" +
                  "		stGroupTreeNodeMap.get(stGroup).add(stTemplateTreeNode);\n" +
                  "		stTemplateTreeNodeMap.put(stTemplate, stTemplateTreeNode);\n" +
                  "	}\n" +
                  "\n" +
                  "	stTemplateTreeNodeMap.get(stTemplate).add(new nextgen.st.STModelNavigator.STModelTreeNode(stModel, stTemplate, null));\n" +
                  "});")
            .setGetActionsStatements(new Object[]{
                  "getSelectedSTModelTreeNodes().forEach(stModelTreeNode -> actions.add(new nextgen.actions.AddModelToProject(\"Add \" + stModelTreeNode.getLabel(), getModel(), stModelTreeNode.getModel())));",
                  "actions.add(new nextgen.actions.GenerateAllProjectModels(getModel()));"
            });
      final nextgen.templates.nextgen.TreeNode modelsTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("ModelsTreeNode")
            .setModelType("String")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .addConstructorStatements("appModel().doInTransaction(transaction -> {\n" +
                  "	appModel().getGroupModels().forEach(stGroupModel -> {\n" +
                  "		final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroupModel);\n" +
                  "		add(stGroupModelTreeNode);\n" +
                  "		stGroupModel.getTemplates().forEach(stTemplate -> addSTTemplateChild(stTemplate, stGroupModelTreeNode));\n" +
                  "	});\n" +
                  "});")
            .addMethods("private void addSTTemplateChild(nextgen.st.domain.STTemplate stTemplate, BaseTreeNode<?> parent) {\n" +
                  "	final nextgen.st.STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);\n" +
                  "	parent.add(stTemplateTreeNode);\n" +
                  "\n" +
                  "	appModel().db.findAllSTModelByStTemplate(stTemplate.getUuid()).forEach(stModel -> stTemplateTreeNode.add(new STModelTreeNode(stModel, stTemplate, null)));\n" +
                  "	stTemplate.getChildren().forEach(stTemplateChild -> addSTTemplateChild(stTemplateChild, stTemplateTreeNode));\n" +
                  "}");

      final nextgen.templates.nextgen.TreeNode stValueTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STValueTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.model")
                  .setName("STValue"))
            .setHasUuid(true)
            .addFields("nextgen.st.model.STArgument", "stArgument")
            .setIcon("appModel().loadIcon(\"sq-orange\")")
            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
            .setTooltipExpression("appModel().tooltip(getModel());")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.STValueToClipboard(getModel()));",
                  "actions.add(new nextgen.actions.SetSTValueFromClipboard(getModel()));",
                  "actions.add(new nextgen.actions.DeleteSTValue(getModel(), tree));"
            });

      final nextgen.templates.nextgen.TreeNode rootNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("RootNode")
            .setModelType("String")
            .setLabelExpression("getModel()")
            .addConstructorStatements("appModel().doInTransaction(transaction -> {\n" +
                  "	appModel().getProjects().forEach(stProject -> add(new STProjectTreeNode(stProject)));\n" +
                  "	add(new nextgen.st.STModelNavigator.ModelsTreeNode(\"Models\"));\n" +
                  "});")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.NewProject(tree));",
                  "actions.add(new nextgen.actions.UndoDBTransaction());"
            });

      final nextgen.templates.nextgen.TreeNode stGroupTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STGroupModelTreeNode")
            .setModelType(stGroupModelType)
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(model.getIcon())")
            .setLabelExpression("getModel().getName()")
            .addMethods("private boolean countChildren(nextgen.st.domain.STTemplate stTemplate) {\n" +
                  "	long count = appModel().findAllSTModelByStTemplate(stTemplate.getUuid()).count();\n" +
                  "	if (count != 0L) return true;\n" +
                  "	Iterator<nextgen.st.domain.STTemplate> iterator = stTemplate.getChildren().iterator();\n" +
                  "	while (iterator.hasNext())\n" +
                  "		if (countChildren(iterator.next())) return true;\n" +
                  "	return false;\n" +
                  "}");

      final nextgen.templates.nextgen.TreeNode stTemplateTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STTemplateTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.domain")
                  .setName("STTemplate"))
            .setHasUuid(true)
            .setLabelExpression("getModel().getName()")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.NewSTModel(getModel()));",
                  "actions.add(new nextgen.actions.EditModels(getModel()));"
            });

      final nextgen.templates.nextgen.TreeNode stModelTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STModelTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.model")
                  .setName("STModel"))
            .setHasUuid(true)
            .addFields("nextgen.st.domain.STTemplate", "stTemplate")
            .addFields("nextgen.st.model.STArgument", "stArgument")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> appModel().render(getModel(), 10))")
            .setTooltipExpression("appModel().tooltip(getModel());")
            .addConstructorStatements("stTemplate.getParameters()\n" +
                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.OpenModel(getModel()));",
                  "actions.add(new nextgen.actions.GenerateSource(getModel()));",
                  "actions.add(new nextgen.actions.WriteSTModelToFile(getModel()));",
                  "actions.add(new nextgen.actions.DeleteSTModel(getModel(), tree));"
            })
            .addSelectionStatements("appModel().doLaterInTransaction(transaction -> nextgen.events.STModelTreeNodeClicked.post(selectedNode.getModel()));");

      final nextgen.templates.nextgen.TreeNode stParameterTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STParameterTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.domain")
                  .setName("STParameter"))
            .addFields("nextgen.st.model.STModel", "stModel")
            .setLabelExpression("getModel().getName()")
            .addConstructorStatements("stModel.getArgumentsSorted()\n" +
                  "	.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))\n" +
                  "	.forEach(appModel().stArgumentConsumer(model)\n" +
                  "			.onSingleSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue, stArgument)))\n" +
                  "			.onSingleSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))\n" +
                  "			.onListSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue, stArgument)))\n" +
                  "			.onListSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))\n" +
                  "			.onKVListConsumer((stArgument, stKVValues) -> add(new STKVArgumentTreeNode(stArgument, model))));");

      final nextgen.templates.nextgen.TreeNode stKVArgumentTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STKVArgumentTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.model")
                  .setName("STArgument"))
            .addFields("nextgen.st.domain.STParameter", "stParameter");
      final nextgen.templates.greenrobot.Subscribe newSTProject = newSubscribe()
            .setEventName("NewSTProject")
            .setEventType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.events")
                  .setName("NewSTProject"))
            .addStatements("treeModel\n" +
                  "		.find(RootNode.class)\n" +
                  "		.ifPresent(rootNode -> treeModel.addNodeInSortedOrder(rootNode, new nextgen.st.STModelNavigator.STProjectTreeNode(event.model)));");

      final nextgen.templates.nextgen.EventSubscriber stArgumentAdded = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
            .setEventName("STArgumentAdded")
            .setEventType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.events")
                  .setName("NewSTArgument"))
            .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel))\n" +
                  "			.ifPresent(stModelTreeNode -> findSTParameterTreeNode(stModelTreeNode, stParameterTreeNode -> stParameterTreeNode.getModel().getUuid().equals(event.stArgument.getStParameter()))\n" +
                  "					.ifPresent(stParameterTreeNode -> {\n" +
                  "						appModel().stArgumentConsumer(event.stParameter)\n" +
                  "									 .onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STValueTreeNode(stValue, event.stArgument)))\n" +
                  "									 .onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))\n" +
                  "									 .onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STValueTreeNode(stValue, event.stArgument)))\n" +
                  "									 .onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))\n" +
                  "									 .onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STKVArgumentTreeNode(event.stArgument, event.stParameter)));\n" +
                  "						stModelTreeNode.nodeChanged();\n" +
                  "					}));");
      final nextgen.templates.greenrobot.Subscribe stProjectSTModel = newSubscribe()
            .setEventName("STProjectSTModel")
            .setEventType("nextgen.events.NewSTProjectSTModel")
            .addStatements("findSTProjectTreeNode(stProjectTreeNode -> stProjectTreeNode.getModel().equals(event.stProject))\n" +
                  "		.ifPresent(stProjectTreeNode -> {\n" +
                  "\n" +
                  "			final nextgen.st.domain.STTemplate stTemplate = appModel().findSTTemplateByUuid(event.stModel.getStTemplate());\n" +
                  "			final nextgen.st.domain.STGroupModel stGroup = appModel().findSTGroup(stTemplate);\n" +
                  "\n" +
                  "			final nextgen.st.STModelNavigator.STGroupModelTreeNode groupModelTreeNode = treeModel\n" +
                  "					.find(stProjectTreeNode, nextgen.st.STModelNavigator.STGroupModelTreeNode.class, treeNode -> treeNode.getModel().equals(stGroup))\n" +
                  "					.orElseGet(() -> {\n" +
                  "						final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroup);\n" +
                  "						treeModel.addNodeInSortedOrder(stProjectTreeNode, stGroupModelTreeNode);\n" +
                  "						return stGroupModelTreeNode;\n" +
                  "					});\n" +
                  "\n" +
                  "			final nextgen.st.STModelNavigator.STTemplateTreeNode templateTreeNode = findSTTemplateTreeNode(groupModelTreeNode, stTemplateTreeNode -> stTemplateTreeNode\n" +
                  "					.getModel().equals(stTemplate))\n" +
                  "					.orElseGet(() -> {\n" +
                  "						final nextgen.st.STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);\n" +
                  "						treeModel.addNodeInSortedOrder(groupModelTreeNode, stTemplateTreeNode);\n" +
                  "						return stTemplateTreeNode;\n" +
                  "					});\n" +
                  "\n" +
                  "			treeModel.addNodeInSortedOrderAndSelect(templateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.stModel, stTemplate, null));\n" +
                  "		});");

      final nextgen.templates.greenrobot.Subscribe stModelDeleted = newSubscribe()
            .setEventName("STModelDeleted")
            .setEventType("nextgen.events.STModelDeleted")
            .addStatements("findModelsTreeNode(modelsTreeNode -> true)\n" +
                  "		.flatMap(modelsTreeNode -> findSTModelTreeNode(stModelTreeNode -> stModelTreeNode.uuid.equals(event.uuid))\n" +
                  "				.filter(treeNode -> treeNode.getParent() != null)).ifPresent(treeModel::removeNodeFromParent);\n" +
                  "\n" +
                  "findSTModelTreeNode(stModelTreeNode -> stModelTreeNode.uuid.equals(event.uuid))\n" +
                  "		.filter(treeNode -> treeNode.getParent() != null)\n" +
                  "		.ifPresent(treeModel::removeNodeFromParent);");

      final nextgen.templates.nextgen.EventSubscriber stModelCanvasNodeClicked = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
            .setEventName("STModelCanvasNodeClicked")
            .setEventType("nextgen.events.CanvasSTModelClicked")
            .addStatements("SwingUtilities.invokeLater(() -> {\n" +
                  "	final RootNode rootNode = (RootNode) treeModel.getRoot();\n" +
                  "	final TreePath path = rootNode.find(baseTreeNode -> isSTModelTreeNode(baseTreeNode) && ((STModelTreeNode) baseTreeNode).getModel().equals(event.model));\n" +
                  "	if (path != null) {\n" +
                  "		tree.scrollPathToVisible(path);\n" +
                  "		tree.setSelectionPath(path);\n" +
                  "	}\n" +
                  "});");

      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
            .setPackageName(stPackage.getName())
            .setName("STModelNavigator")
            .addFields("STWorkspace", "workspace")
            .setRootNodeExpression("new RootNode(\"Projects\")")
            .setPreferredWidth("600")
            .setPreferredHeight("1200")
            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode())
            .addTreeNodesSelected(stKVArgumentTreeNode.getName())
            .addTreeNodesSelected(stParameterTreeNode.getName())
            .addTreeNodesSelected(stModelTreeNode.getName())
            .addTreeNodesSelected(stTemplateTreeNode.getName())
            .addTreeNodesSelected(stGroupTreeNode.getName())
            .addTreeNodesSelected(rootNode.getName())
            .addTreeNodesSelected(stValueTreeNode.getName())
            .addTreeNodesSelected(modelsTreeNode.getName())
            .addTreeNodesSelected(stProjectTreeNode.getName())
            .addTreeNodes(stProjectTreeNode)
            .addTreeNodes(modelsTreeNode)
            .addTreeNodes(stValueTreeNode)
            .addTreeNodes(rootNode)
            .addTreeNodes(stGroupTreeNode)
            .addTreeNodes(stTemplateTreeNode)
            .addTreeNodes(stModelTreeNode)
            .addTreeNodes(stParameterTreeNode)
            .addTreeNodes(stKVArgumentTreeNode)
//            .addMethods(newSTProject)
//            .addMethods(stArgumentAdded)
//            .addMethods(stProjectSTModel)
//            .addMethods(stModelDeleted)
//            .addMethods(stModelCanvasNodeClicked)
            ;

      nextgen.st.STGenerator.writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
   }

   @org.junit.Test
   public void generateSTTemplateNavigator() {

      final nextgen.templates.nextgen.TreeNode rootNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("RootNode")
            .setModelType("String")
            .setLabelExpression("getModel()")
            .addConstructorStatements("appModel().stGroups.forEach(stGroup -> add(new STGroupTreeNode(stGroup)));")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.NewSTGroup(tree));",
                  "actions.add(new nextgen.actions.GenerateAllSTGroups());"
            });

      final nextgen.templates.nextgen.TreeNode stGroupTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STGroupTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.domain")
                  .setName("STGroupModel"))
            .setHasUuid(true)
            .setLabelExpression("getModel().getName()")
            .addConstructorStatements("model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));\n" +
                  "model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));\n" +
                  "model.getInterfaces().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stInterface -> add(new STInterfaceTreeNode(stInterface)));")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.EditSTGroupTags(getModel(), tree));",
                  "actions.add(new nextgen.actions.ImportSTTemplate(getModel(), tree));",
                  "actions.add(new nextgen.actions.GenerateSTGroup(getModel()));",
                  "actions.add(new nextgen.actions.NewTemplate(getModel(), tree));",
                  "actions.add(new nextgen.actions.NewEnum(getModel(), tree));",
                  "actions.add(new nextgen.actions.NewInterface(getModel(), tree));",
                  "actions.add(new nextgen.actions.RenameSTGroup(getModel(), tree));",
                  "actions.add(new nextgen.actions.DeleteSTGroup(getModel(), tree));"
            })
            .addSelectionStatements("workspace.getSTEditor(selectedNode.getModel());");

      final nextgen.templates.nextgen.TreeNode stEnumTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STEnumTreeNode")
            .setModelType(stEnumType)
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(\"sq-green\")")
            .setLabelExpression("getModel().getName()")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.EditEnum(getModel(), tree));",
                  "getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> actions.add(new nextgen.actions.RenameEnum(getModel(), stGroupTreeNode.getModel(), tree)));",
                  "getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> actions.add(new nextgen.actions.DeleteEnum(getModel(), stGroupTreeNode.getModel(), tree)));"
            })
            .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> workspace.getSTEditor(stGroupTreeNode.getModel()).setSTEnum(selectedNode.getModel()));");

      final nextgen.templates.nextgen.TreeNode stTemplateTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STTemplateTreeNode")
            .setModelType(stTemplateType)
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("getModel().getName()")
            .addConstructorStatements("model.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));")
            .setGetActionsStatements(new Object[]{
                  "final java.util.Set<STTemplate> candidateChildren = getSelectedSTTemplateTreeNodes()",
                  "		.filter(stTemplateTreeNode -> !stTemplateTreeNode.equals(this))",
                  "		.map(nextgen.st.STTemplateNavigator.BaseTreeNode::getModel)",
                  "		.collect(java.util.stream.Collectors.toSet());",
                  "",
                  "final Set<nextgen.st.domain.STTemplate> childTemplates = getModel().getChildren().collect(java.util.stream.Collectors.toSet());",
                  "",
                  "actions.add(new nextgen.actions.NewInstance(\"New Instance\", getModel()));",
                  "",
                  "if (!candidateChildren.isEmpty())",
                  "	actions.add(new nextgen.actions.AddChildrenToTemplate(\"Add \" + candidateChildren",
                  "			.size() + \" templates as children\", getModel(), candidateChildren, tree));",
                  "",
                  "if (!childTemplates.isEmpty())",
                  "	actions.add(new nextgen.actions.AddInterface(\"Add interfaces to children\", childTemplates, tree));",
                  "",
                  "getModel().getImplements()",
                  "			.forEach(implement -> actions.add(new nextgen.actions.RemoveInterface(\"Remove interface \" + implement, implement, getModel(), tree)));",
                  "",
                  "appModel().doInTransaction(transaction ->",
                  "		appModel().getProjects().forEach(stProject -> actions",
                  "				.add(new nextgen.actions.AddTemplateModelToProject(\"Add to \" + stProject.getName(), getModel(), stProject, tree))));",
                  "",
                  "getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> actions.add(new nextgen.actions.NewTemplateChild(getModel(), stGroupTreeNode.getModel(), tree)));",
                  "actions.add(new nextgen.actions.SetTemplateParameterTypes(getModel(), tree));",
                  "actions.add(new nextgen.actions.SetInterfaces(getModel(), tree));",
                  "getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> actions.add(new nextgen.actions.DeleteSTTemplate(getModel(), stGroupTreeNode.getModel(), tree)));"
            })
            .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> workspace.getSTEditor(stGroupTreeNode.getModel()).setSTTemplate(selectedNode.getModel()));");

      final nextgen.templates.nextgen.TreeNode stInterfaceTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STInterfaceTreeNode")
            .setModelType("nextgen.st.domain.STInterface")
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(\"sq-red\")")
            .setLabelExpression("getModel().getName()")
            .setGetActionsStatements(new Object[]{
                  "getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> actions.add(new nextgen.actions.RenameSTInterface(getModel(), stGroupTreeNode.getModel(), tree)));",
                  "getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> actions.add(new nextgen.actions.DeleteSTInterface(getModel(), stGroupTreeNode.getModel(), tree)));"
            })
            .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> workspace.getSTEditor(stGroupTreeNode.getModel()).setSTInterface(selectedNode.getModel()));");

      final nextgen.templates.nextgen.EventSubscriber onNewSTTemplate = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
            .setEventName("NewSTTemplate")
            .setEventType("nextgen.events.NewSTTemplate")
            .addStatements("if(event.parent instanceof STGroupModel) {\n" +
                  "			findSTGroupTreeNode(stGroupTreeNode -> stGroupTreeNode.getModel().equals(event.parent))\n" +
                  "					.ifPresent(stGroupTreeNode -> stGroupTreeNode.addAndSelectChild(new nextgen.st.STTemplateNavigator.STTemplateTreeNode(event.model)));\n" +
                  "		} else if(event.parent instanceof STTemplate) {\n" +
                  "			findSTTemplateTreeNode(stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(event.parent))\n" +
                  "					.ifPresent(stTemplateTreeNode -> stTemplateTreeNode.addAndSelectChild(new nextgen.st.STTemplateNavigator.STTemplateTreeNode(event.model)));\n" +
                  "		}");

      final nextgen.templates.nextgen.EventSubscriber stModelEditorTreeNodeClicked = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
            .setEventName("STModelEditorTreeNodeClicked")
            .setEventType("nextgen.events.STModelEditorTreeNodeClicked")
            .addStatements("final STTemplate stTemplate = appModel().findSTTemplateByUuid(event.model.getStTemplate());\n" +
                  "final RootNode rootNode = (RootNode) treeModel.getRoot();\n" +
                  "final TreePath path = rootNode.find(baseTreeNode -> (baseTreeNode instanceof STTemplateTreeNode) && ((STTemplateTreeNode) baseTreeNode).getModel().equals(stTemplate));\n" +
                  "if (path != null) {\n" +
                  "	tree.scrollPathToVisible(path);\n" +
                  "	tree.setSelectionPath(path);\n" +
                  "}");

      final nextgen.templates.nextgen.EventSubscriber openTemplate = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
            .setEventName("OpenTemplate")
            .setEventType("nextgen.events.OpenSTTemplate")
            .addStatements("SwingUtilities.invokeLater(() -> {\n" +
                  "	final RootNode rootNode = (RootNode) treeModel.getRoot();\n" +
                  "	final TreePath path = rootNode.find(baseTreeNode -> isSTTemplateTreeNode(baseTreeNode) && ((STTemplateTreeNode) baseTreeNode).getModel().equals(event.model));\n" +
                  "	if (path != null) {\n" +
                  "		tree.scrollPathToVisible(path);\n" +
                  "		tree.setSelectionPath(path);\n" +
                  "	}\n" +
                  "});");

      final nextgen.templates.nextgen.EventSubscriber canvasSTModelClicked = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
            .setEventName("CanvasSTModelClicked")
            .setEventType("nextgen.events.CanvasSTModelClicked")
            .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                  "	final STTemplate stTemplate = appModel().findSTTemplateByUuid(event.model.getStTemplate());\n" +
                  "	final RootNode rootNode = (RootNode) treeModel.getRoot();\n" +
                  "	final TreePath path = rootNode.find(baseTreeNode -> isSTTemplateTreeNode(baseTreeNode) && ((STTemplateTreeNode) baseTreeNode).getModel().equals(stTemplate));\n" +
                  "	if (path != null) {\n" +
                  "		tree.scrollPathToVisible(path);\n" +
                  "		tree.setSelectionPath(path);\n" +
                  "	}\n" +
                  "});");

      final nextgen.templates.nextgen.EventSubscriber stModelCanvasNodeClicked = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
            .setEventName("STModelCanvasNodeClicked")
            .setEventType("nextgen.events.STModelTreeNodeClicked")
            .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                  "	final STTemplate stTemplate = appModel().findSTTemplateByUuid(event.model.getStTemplate());\n" +
                  "	final RootNode rootNode = (RootNode) treeModel.getRoot();\n" +
                  "	final TreePath path = rootNode.find(baseTreeNode -> isSTTemplateTreeNode(baseTreeNode) && ((STTemplateTreeNode) baseTreeNode).getModel().equals(stTemplate));\n" +
                  "	if (path != null) {\n" +
                  "		tree.scrollPathToVisible(path);\n" +
                  "		tree.setSelectionPath(path);\n" +
                  "	}\n" +
                  "});");

      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
            .setPackageName("nextgen.st")
            .addImports("nextgen.swing.AppModel")
            .addImports("nextgen.st.domain.*")
            .setName("STTemplateNavigator")
            .addFields("STWorkspace", "workspace")
            .setRootNodeExpression("new RootNode(\"Templates\")")
            .setPreferredWidth("600")
            .setPreferredHeight("500")
            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
            .addTreeNodesSelected(rootNode.getName())
            .addTreeNodesSelected(stInterfaceTreeNode.getName())
            .addTreeNodesSelected(stTemplateTreeNode.getName())
            .addTreeNodesSelected(stEnumTreeNode.getName())
            .addTreeNodesSelected(stGroupTreeNode.getName())
            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode())
            .addTreeNodes(rootNode)
            .addTreeNodes(stGroupTreeNode)
            .addTreeNodes(stEnumTreeNode)
            .addTreeNodes(stTemplateTreeNode)
            .addTreeNodes(stInterfaceTreeNode)
//            .addMethods(onNewSTTemplate)
//            .addMethods(stModelEditorTreeNodeClicked)
//            .addMethods(openTemplate)
//            .addMethods(canvasSTModelClicked)
//            .addMethods(stModelCanvasNodeClicked)
            ;

      nextgen.st.STGenerator.writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
   }

   @org.junit.Test
   public void generateSTModelEditorNavigator() {

      final nextgen.templates.nextgen.TreeNode stModelTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STModelTreeNode")
            .setModelType(stModelType)
            .setHasUuid(true)
            .addFields(stTemplateType, "stTemplate")
            .addFields("Object", "stArgument")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
            .addSelectionStatements("nextgen.events.STModelEditorTreeNodeClicked.post(selectedNode.getModel());")
            .addConstructorStatements("stTemplate.getParameters()\n" +
                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.CopyModel(getModel()));",
                  "actions.add(new nextgen.actions.OpenModel(getModel()));",
                  "actions.add(new nextgen.actions.VisitModel(getModel()));",
                  "actions.add(new nextgen.actions.WriteSTModelToFile(getModel()));",
                  "actions.add(new nextgen.actions.RemoveArgument(stArgument, tree));",
                  "actions.add(new nextgen.actions.EditSTModel(getModel()));"});

      final nextgen.templates.nextgen.TreeNode stValueTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STValueTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.model")
                  .setName("STValue"))
            .setHasUuid(true)
            .addFields("Object", "stArgument")
            .setIcon("appModel().loadIcon(\"sq-orange\")")
            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.STValueToClipboard(getModel()));",
                  "actions.add(new nextgen.actions.RemoveArgument(stArgument, tree));"
            });

      final nextgen.templates.nextgen.TreeNode stKVArgumentTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STKVArgumentTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.model")
                  .setName("STArgument"))
            .addFields("STParameter", "stParameter")
            .setLabelExpression("appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, \"name\", stParameter::getName)")
            .addConstructorStatements("stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()\n" +
                  "		.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                  "		.findFirst()\n" +
                  "		.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));")
            .setGetActionsStatements(new Object[]{
                  "appModel().doInTransaction(transaction -> stParameter.getKeys().forEach(stParameterKey -> {",
                  "	actions.add(new nextgen.actions.SetKVArgumentFromInput(\"Set \" + stParameterKey.getName() + \" from input\", getModel(), stParameterKey, tree));",
                  "	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(\"Set \" + stParameterKey.getName() + \" from Clipboard\", getModel(), stParameterKey));",
                  "}));",
                  "actions.add(new nextgen.actions.RemoveKVArgument(getModel(), tree));"
            });

      final nextgen.templates.nextgen.TreeNode stKVTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STKVTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.model")
                  .setName("STArgumentKV"))
            .setHasUuid(true)
            .addFields("STArgument", "stArgument")
            .addFields("STParameterKey", "stParameterKey")
            .setLabelExpression("stParameterKey.getName()")
            .addConstructorStatements("final STValue stValue = model.getValue();\n" +
                  "if (stValue != null)\n" +
                  "	switch (stValue.getType()) {\n" +
                  "		case STMODEL:\n" +
                  "			add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), model));\n" +
                  "			break;\n" +
                  "		case PRIMITIVE:\n" +
                  "			add(new STValueTreeNode(stValue, model));\n" +
                  "			break;\n" +
                  "		case ENUM:\n" +
                  "			break;\n" +
                  "	}")
            .setGetActionsStatements(new Object[]{
                  "appModel().doInTransaction(transaction -> {",
                  "	getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.SetKVArgumentFromSTValue(\"Set \" + appModel().render(stValueTreeNode.getModel(), 30), stArgument, stParameterKey, stValueTreeNode.getModel())));",
                  "	appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.SetKVArgumentFromSTValue(\"Set \" + appModel().render(selectedValue, 30), stArgument, stParameterKey, selectedValue)));",
                  "	appModel().getSelectedSTModels().forEach(selectedModel -> actions.add(new nextgen.actions.SetKVArgumentFromSTModel(\"Set \" + appModel().render(selectedModel, 30), stArgument, stParameterKey, selectedModel)));",
                  "	actions.add(new nextgen.actions.SetKVArgumentFromInput(\"Set from input\", stArgument, stParameterKey, tree));",
                  "	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(\"Set from Clipboard\", stArgument, stParameterKey));",
                  "});",
                  "actions.add(new nextgen.actions.RemoveKV(getModel(), tree));"
            });

      final nextgen.templates.nextgen.TreeNode stParameterTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STParameterTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.domain")
                  .setName("STParameter"))
            .setHasUuid(true)
            .addFields("STModel", "stModel")
            .setLabelExpression("getModel().getName()")
            .addConstructorStatements("stModel.getArgumentsSorted()\n" +
                  "	.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))\n" +
                  "	.forEach(appModel().stArgumentConsumer(model)\n" +
                  "			.onSingleSTValue((stArgument, stValue) -> addChild(new STValueTreeNode(stValue, stArgument)))\n" +
                  "			.onSingleSTModel((stArgument, stValue) -> addChild(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))\n" +
                  "			.onListSTValue((stArgument, stValue) -> addChild(new STValueTreeNode(stValue, stArgument)))\n" +
                  "			.onListSTModel((stArgument, stValue) -> addChild(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))\n" +
                  "			.onKVListConsumer((stArgument, stKVValues) -> addChild(new STKVArgumentTreeNode(stArgument, model))));")
            .setGetActionsStatements(new Object[]{
                  "appModel().doInTransaction(tx -> {",
                  "",
                  "	final String fromClipboard = nextgen.utils.SwingUtil.fromClipboard();",
                  "",
                  "	switch (getModel().getType()) {",
                  "		case SINGLE:",
                  "",
                  "			getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(stValueTreeNode.getModel(), 30), stModel, getModel(), stValueTreeNode.getModel())));",
                  "			actions.add(new nextgen.actions.SetArgumentFromInput(\"Set from Input\", stModel, getModel(), tree));",
                  "			appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
                  "			appModel().getSelectedSTModels().forEach(selectedValue -> actions.add(new nextgen.actions.SetArgumentFromSTModel(\"Set \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
                  "",
                  "			if (fromClipboard != null && fromClipboard.startsWith(\"stmodel-\"))",
                  "				actions.add(new nextgen.actions.SetArgumentFromSTModelUuid(\"Set STModel \" + fromClipboard.substring(8), stModel, getModel(), fromClipboard.substring(8)));",
                  "			else if (fromClipboard != null && fromClipboard.trim().length() !=0)",
                  "				actions.add(new nextgen.actions.SetArgumentFromClipboard(\"Set from Clipboard\", stModel, getModel()));",
                  "",
                  "			if (getModel().getName().startsWith(\"is\") || getModel().getName().startsWith(\"has\"))",
                  "				actions.add(new nextgen.actions.SetArgumentToTrue(\"Set to TRUE\", stModel, getModel()));",
                  "",
                  "			break;",
                  "",
                  "		case LIST:",
                  "",
                  "			getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(stValueTreeNode.getModel(), 30), stModel, getModel(), stValueTreeNode.getModel())));",
                  "			appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
                  "			appModel().getSelectedSTModels().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTModel(\"Add \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
                  "			appModel().getSelectedSTTemplates().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTTemplate(\"Add new \" + selectedValue.getName(), stModel, getModel(), selectedValue)));",
                  "",
                  "			if (fromClipboard != null && fromClipboard.startsWith(\"stmodel-\"))",
                  "				actions.add(new nextgen.actions.AddArgumentFromSTModelUuid(\"Set STModel \" + fromClipboard.substring(8), stModel, getModel(), fromClipboard.substring(8)));",
                  "			else if (fromClipboard != null && fromClipboard.trim().length() !=0)",
                  "				actions.add(new nextgen.actions.AddArgumentFromClipboard(\"Set from Clipboard\", stModel, getModel(), tree));",
                  "",
                  "			actions.add(new nextgen.actions.AddArgumentFromArgumentType(\"Add\", stModel, getModel(), tree));",
                  "			actions.add(new nextgen.actions.AddMultipleArgumentsFromArgumentType(\"Add\", stModel, getModel(), tree));",
                  "",
                  "			break;",
                  "",
                  "		case KVLIST:",
                  "",
                  "			actions.add(new nextgen.actions.AddKVArgument(\"Add\", stModel, getModel(), tree));",
                  "",
                  "			break;",
                  "	}",
                  "});"
            })
            .addSelectionStatements("selectedNode.getParentNode(nextgen.st.STModelEditorNavigator.STModelTreeNode.class)\n" +
                  "		.ifPresent(treeNode -> nextgen.events.STParameterEditorTreeNodeClicked.post(selectedNode.getModel(), treeNode.getModel()));");

      final nextgen.templates.greenrobot.Subscribe onSTModelDeleted = newSubscribe()
            .setEventName("STModelDeleted")
            .setEventType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.events")
                  .setName("STModelDeleted"))
            .addStatements("findSTModelTreeNode(stModelTreeNode -> stModelTreeNode.uuid.equals(event.uuid))\n" +
                  "		.filter(treeNode -> treeNode.getParent() != null)\n" +
                  "		.ifPresent(treeModel::removeNodeFromParent);");

      final nextgen.templates.greenrobot.Subscribe onSTArgumentAdded = newSubscribe()
            .setEventName("STArgumentAdded")
            .setEventType("nextgen.events.NewSTArgument")
            .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel))\n" +
                  "			.ifPresent(stModelTreeNode -> findSTParameterTreeNode(stModelTreeNode, stParameterTreeNode -> stParameterTreeNode.getModel().getUuid().equals(event.stArgument.getStParameter()))\n" +
                  "					.ifPresent(stParameterTreeNode -> {\n" +
                  "						appModel().stArgumentConsumer(event.stParameter)\n" +
                  "									 .onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STValueTreeNode(stValue, event.stArgument)))\n" +
                  "									 .onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))\n" +
                  "									 .onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STValueTreeNode(stValue, event.stArgument)))\n" +
                  "									 .onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))\n" +
                  "									 .onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STKVArgumentTreeNode(event.stArgument, event.stParameter)));\n" +
                  "						stModelTreeNode.nodeChanged();\n" +
                  "					}));");

      final nextgen.templates.greenrobot.Subscribe onNewSTModel = newSubscribe()
            .setEventName("NewSTModel")
            .setEventType("nextgen.events.NewSTModel")
            .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel))\n" +
                  "			.ifPresent(stModelTreeNode -> findSTParameterTreeNode(stModelTreeNode, stParameterTreeNode -> stParameterTreeNode.getModel().getUuid().equals(event.stArgument.getStParameter()))\n" +
                  "					.ifPresent(stParameterTreeNode -> {\n" +
                  "						appModel().stArgumentConsumer(event.stParameter)\n" +
                  "									 .onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STValueTreeNode(stValue, event.stArgument)))\n" +
                  "									 .onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))\n" +
                  "									 .onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STValueTreeNode(stValue, event.stArgument)))\n" +
                  "									 .onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))\n" +
                  "									 .onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STKVArgumentTreeNode(event.stArgument, event.stParameter)));\n" +
                  "						stModelTreeNode.nodeChanged();\n" +
                  "					}));");

      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
            .setPackageName(stPackage.getName())
            .addImports("nextgen.st.model.*")
            .addImports("nextgen.st.domain.*")
            .setName("STModelEditorNavigator")
            .addFields(stModelType, "model")
            .addFields("STModelEditor", "editor")
            .setRootNodeExpression("new STModelTreeNode(model, appModel().findSTTemplateByUuid(model.getStTemplate()), null)")
            .setPreferredWidth("600")
            .setPreferredHeight("600")
            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
            .addTreeNodesSelected(stModelTreeNode.getName())
            .addTreeNodesSelected(stValueTreeNode.getName())
            .addTreeNodesSelected(stKVArgumentTreeNode.getName())
            .addTreeNodesSelected(stKVTreeNode.getName())
            .addTreeNodesSelected(stParameterTreeNode.getName())
            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode())
            .addTreeNodes(stModelTreeNode)
            .addTreeNodes(stValueTreeNode)
            .addTreeNodes(stKVArgumentTreeNode)
            .addTreeNodes(stKVTreeNode)
            .addTreeNodes(stParameterTreeNode)
//            .addMethods(onSTModelDeleted)
//            .addMethods(onSTArgumentAdded)
            ;

      nextgen.st.STGenerator.writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
   }

   @org.jetbrains.annotations.NotNull
   public nextgen.templates.greenrobot.Subscribe newSubscribe() {
      return nextgen.templates.greenrobot.GreenRobotST.newSubscribe();
   }

   @org.junit.Test
   public void generateCanvas() {

      final nextgen.templates.nextgen.CanvasNode stFileNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("STFileNode")
            .setModelType(stFileType)
            .addFields(stModelType, "stModel")
            .setUuidExpression("model.getUuid()")
            .setLabelExpression("model.getPath().getValue()")
            .addAddedToCanvasStatements("thisCanvas().getAllNodes()\n" +
                  "		.filter(stNode -> stNode instanceof STModelNode)\n" +
                  "		.map(stNode -> (STModelNode) stNode)\n" +
                  "		.filter(stModelNode -> stModelNode.getModel().getUuid().equals(getUuid().toString()))\n" +
                  "		.findAny()\n" +
                  "		.ifPresent(stModelNode -> thisCanvas().addRelation(getUuid(), () -> new STSinkRelation(stModelNode, STFileNode.this)));")
            .addRightClickStatements("final java.util.List<STModelNode> stModelNodes = thisCanvas().getSelectedNodes()\n" +
                  "				.filter(stNode -> stNode instanceof STModelNode)\n" +
                  "				.filter(stNode -> !stNode.getUuid().equals(getUuid()))\n" +
                  "				.map(stNode -> (STModelNode) stNode)\n" +
                  "				.collect(java.util.stream.Collectors.toList());\n" +
                  "		final java.util.List<STValueNode> stValueNodes = thisCanvas().getSelectedNodes()\n" +
                  "				.filter(stNode -> stNode instanceof STValueNode)\n" +
                  "				.filter(stNode -> !stNode.getUuid().equals(getUuid()))\n" +
                  "				.map(stNode -> (STValueNode) stNode)\n" +
                  "				.collect(java.util.stream.Collectors.toList());")
            .addRightClickStatements("appModel().doInTransaction(tx -> {\n" +
                  "		final JMenu sourceMenu = new JMenu(\"STModels\");\n" +
                  "		stModelNodes.forEach(stModelNode -> {\n" +
                  "			final int end = Math.min(stModelNode.getText().length(), 50);\n" +
                  "			sourceMenu.add(new SetSource(event, stModelNode));\n" +
                  "		});\n" +
                  "		if (!stModelNodes.isEmpty())\n" +
                  "			pop.add(sourceMenu);\n" +
                  "\n" +
                  "		final JMenu setNameMenu = new JMenu(\"Set Name\");\n" +
                  "		final JMenu setPathMenu = new JMenu(\"Set Path\");\n" +
                  "		final JMenu setTypeMenu = new JMenu(\"Set Type\");\n" +
                  "		final JMenu setPackageName = new JMenu(\"Set Package name\");\n" +
                  "		stValueNodes.stream().filter(stNode -> stNode.getModel().getType().equals(nextgen.st.model.STValueType.PRIMITIVE)).forEach(stValueNode -> {\n" +
                  "			setPathMenu.add(new SetPathTo(event, stValueNode.getModel()));\n" +
                  "			setNameMenu.add(new SetNameTo(event, stValueNode.getModel()));\n" +
                  "			setPackageName.add(new SetPackageNameTo(event, stValueNode.getModel()));\n" +
                  "			setTypeMenu.add(new SetTypeTo(event, stValueNode.getModel()));\n" +
                  "		});\n" +
                  "		if (setNameMenu.getMenuComponentCount() != 0) {\n" +
                  "			pop.add(setNameMenu);\n" +
                  "			pop.add(setPathMenu);\n" +
                  "			pop.add(setTypeMenu);\n" +
                  "			pop.add(setPackageName);\n" +
                  "		}\n" +
                  "	});")
            .addRightClickActions("EditFileSink")
            .addRightClickActions("OpenFile")
            .addLeftClickStatements("thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
                  "		if (getModel() == null || getModel().getPath() == null) return;\n" +
                  "		nextgen.st.STGenerator.writeToFile(thisCanvas().appModel().render(stModel), getModel().getPackageName().getValue(), getModel().getName().getValue(), getModel().getType().getValue(), new java.io.File(getModel().getPath().getValue()));\n" +
                  "	});")
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("EditFileSink")
                  .setTitle("Edit File Sink")
                  .addStatements("appModel().doInTransaction(tx -> {\n" +
                        "\n" +
                        "		final String[] fileTypes = new String[]{\"html\", \"java\", \"js\", \"xml\"};\n" +
                        "\n" +
                        "		final String[] pathTypes = thisCanvas().appModel().db.findAllSTFile()\n" +
                        "																		.filter(stFile -> stFile.getPath() != null)\n" +
                        "																		.filter(stFile -> stFile.getPath().getValue() != null)\n" +
                        "																		.map(stFile -> stFile.getPath().getValue())\n" +
                        "																		.distinct()\n" +
                        "																		.toArray(String[]::new);\n" +
                        "\n" +
                        "		final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();\n" +
                        "		fieldMap.put(\"name\", SwingUtil.newTextField(getModel().getName() == null ? \"\" : getModel().getName().getValue(), 15));\n" +
                        "		fieldMap.put(\"type\", SwingUtil.newTextField(getModel().getType() == null ? \"\" : getModel().getType().getValue(), 15));\n" +
                        "		fieldMap.put(\"path\", SwingUtil.newTextField(getModel().getPath() == null ? \"\" : getModel().getPath().getValue(), 15));\n" +
                        "		fieldMap.put(\"package\", SwingUtil.newTextField(getModel().getPackageName() == null ? \"\" : getModel().getPackageName().getValue(), 15));\n" +
                        "		final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));\n" +
                        "		inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" +
                        "		for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {\n" +
                        "				inputPanel.add(new JLabel(fieldEntry.getKey()));\n" +
                        "				inputPanel.add(fieldEntry.getValue());\n" +
                        "\n" +
                        "			if (fieldEntry.getKey().equals(\"type\")) {\n" +
                        "				fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {\n" +
                        "					@Override\n" +
                        "					public void mouseClicked(java.awt.event.MouseEvent e) {\n" +
                        "						fieldEntry.getValue().setText(fileTypes[fileTypeIndex.incrementAndGet() % fileTypes.length]);\n" +
                        "					}\n" +
                        "				});\n" +
                        "			} else if (fieldEntry.getKey().equals(\"path\")) {\n" +
                        "				fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {\n" +
                        "					@Override\n" +
                        "					public void mouseClicked(java.awt.event.MouseEvent e) {\n" +
                        "						fieldEntry.getValue().setText(pathTypes[pathIndex.incrementAndGet() % pathTypes.length]);\n" +
                        "					}\n" +
                        "				});\n" +
                        "			}\n" +
                        "		}\n" +
                        "		nextgen.utils.SwingUtil.showDialog(inputPanel, thisCanvas(), \"Edit\", new nextgen.utils.SwingUtil.ConfirmAction() {\n" +
                        "				@Override\n" +
                        "				public void verifyAndCommit() throws Exception {\n" +
                        "					final String name = fieldMap.get(\"name\").getText().trim();\n" +
                        "					final String type = fieldMap.get(\"type\").getText().trim();\n" +
                        "					final String path = fieldMap.get(\"path\").getText().trim();\n" +
                        "					final String packageName = fieldMap.get(\"package\").getText().trim();\n" +
                        "					thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
                        "\n" +
                        "						if (getModel().getName() == null || (getModel().getName().getValue() == null || !getModel().getName().getValue().equals(name)))\n" +
                        "							getModel().setName(thisCanvas().appModel().newSTValue(name));\n" +
                        "\n" +
                        "						if (getModel().getType() == null || (getModel().getType().getValue() == null || !getModel().getType().getValue().equals(type)))\n" +
                        "							getModel().setType(thisCanvas().appModel().newSTValue(type));\n" +
                        "\n" +
                        "						if (getModel().getPath() == null || (getModel().getPath().getValue() == null || !getModel().getPath().getValue().equals(path)))\n" +
                        "							getModel().setPath(thisCanvas().appModel().newSTValue(path));\n" +
                        "\n" +
                        "						if (getModel().getPackageName() == null || (getModel().getPackageName().getValue() == null || !getModel().getPackageName().getValue().equals(packageName)))\n" +
                        "							getModel().setPackageName(thisCanvas().appModel().newSTValue(packageName));\n" +
                        "\n" +
                        "						setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());\n" +
                        "					});\n" +
                        "				}\n" +
                        "		});\n" +
                        "	});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenFile")
                  .setTitle("Open File")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "		try {\n" +
                        "			java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(getModel()));\n" +
                        "		} catch (Exception ex) {\n" +
                        "			nextgen.utils.SwingUtil.showException(thisCanvas(), ex);\n" +
                        "		}\n" +
                        "	});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetSource")
                  .addFields("STModelNode", "stModelNode")
                  .setTitle("Set Source")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "		if (stModel != null) thisCanvas().removeRelation(getUuid());\n" +
                        "		stModel = stModelNode.getModel();\n" +
                        "		stModel.addFiles(getModel());\n" +
                        "		thisCanvas().addRelation(getUuid(), () -> new STSinkRelation(stModelNode, thisNode()));\n" +
                        "		setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());\n" +
                        "	});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetPathTo")
                  .addFields("nextgen.st.model.STValue", "model")
                  .setTitleExpression("model.getValue()")
                  .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                        "		getModel().setPath(model);\n" +
                        "		setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());\n" +
                        "	});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetNameTo")
                  .addFields("nextgen.st.model.STValue", "model")
                  .setTitleExpression("model.getValue()")
                  .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                        "		getModel().setName(model);\n" +
                        "		setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());\n" +
                        "	});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetTypeTo")
                  .addFields("nextgen.st.model.STValue", "model")
                  .setTitleExpression("model.getValue()")
                  .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                        "		getModel().setType(model);\n" +
                        "		setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());\n" +
                        "	});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetPackageNameTo")
                  .addFields("nextgen.st.model.STValue", "model")
                  .setTitleExpression("model.getValue()")
                  .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                        "		getModel().setPackageName(model);\n" +
                        "		setText(nextgen.st.STGenerator.asFile(getModel()).getAbsolutePath());\n" +
                        "	});"));

      final nextgen.templates.nextgen.CanvasNode stkvNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("STKVNode")
            .setModelType("nextgen.st.model.STArgument")
            .addFields("nextgen.st.domain.STParameter", "stParameter")
            .setUuidExpression("model.getUuid()")
            .setLabelExpression("stParameter.getName()")
            .addAddedToCanvasStatements("thisCanvas().getAllNodes().forEach(this::newNodeAdded);")
            .addNewNodeAddedStatements("stParameter.getKeys()\n" +
                  "	.forEach(stParameterKey -> getModel().getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))\n" +
                  "			.filter(stArgumentKV -> stArgumentKV.getValue() != null)\n" +
                  "			.forEach(stArgumentKV -> {\n" +
                  "				final nextgen.st.model.STValue value = stArgumentKV.getValue();\n" +
                  "				switch (value.getType()) {\n" +
                  "					case STMODEL:\n" +
                  "						if (getUuid().equals(value.getStModel().getUuid()))\n" +
                  "							thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), node, getModel(), stParameterKey, stArgumentKV));\n" +
                  "						break;\n" +
                  "					case PRIMITIVE:\n" +
                  "						if (getUuid().equals(value.getUuid()))\n" +
                  "							thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), node, getModel(), stParameterKey, stArgumentKV));\n" +
                  "						break;\n" +
                  "					case ENUM:\n" +
                  "						if (getUuid().equals(value.getUuid()))\n" +
                  "							thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), node, getModel(), stParameterKey, stArgumentKV));\n" +
                  "						break;\n" +
                  "				}\n" +
                  "			}));")
            .addRightClickStatements("final java.util.List<STValueNode> stValueNodes = thisCanvas().getSelectedNodes()\n" +
                  "				.filter(stNode -> stNode instanceof STValueNode)\n" +
                  "				.filter(stNode -> !stNode.getUuid().equals(getUuid()))\n" +
                  "				.map(stNode -> (STValueNode) stNode)\n" +
                  "				.collect(java.util.stream.Collectors.toList());\n" +
                  "		final java.util.List<STModelNode> stModelNodes = thisCanvas().getSelectedNodes()\n" +
                  "				.filter(stNode -> stNode instanceof STModelNode)\n" +
                  "				.filter(stNode -> !stNode.getUuid().equals(getUuid()))\n" +
                  "				.map(stNode -> (STModelNode) stNode)\n" +
                  "				.collect(java.util.stream.Collectors.toList());")
            .addRightClickStatements("appModel().doInTransaction(tx -> {\n" +
                  "		stParameter.getKeys().forEach(stParameterKey -> {\n" +
                  "			final JMenu stParameterMenu = new JMenu(stParameterKey.getName());\n" +
                  "			stValueNodes.forEach(stNode -> stParameterMenu.add(new nextgen.actions.SetKVArgumentFromSTValue(\"Set \" + appModel().render(stNode.getModel(), 30), getModel(), stParameterKey, stNode.getModel())));\n" +
                  "			stModelNodes.forEach(stNode -> stParameterMenu.add(new nextgen.actions.SetKVArgumentFromSTModel(\"Set \" + appModel().render(stNode.getModel(), 30), getModel(), stParameterKey, stNode.getModel())));\n" +
                  "			stParameterMenu.add(new nextgen.actions.SetKVArgumentFromInput(\"Set from Input\", getModel(), stParameterKey, thisCanvas()));\n" +
                  "			stParameterMenu.add(new nextgen.actions.SetKVArgumentFromClipboard(\"Set from Clipboard\", getModel(), stParameterKey));\n" +
                  "			getModel().getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid())).filter(stArgumentKV -> stArgumentKV.getValue() != null).forEach(stArgumentKV -> {\n" +
                  "					stParameterMenu.add(new OpenArgument(event, getModel(), stParameterKey, stArgumentKV));\n" +
                  "					stParameterMenu.add(new RemoveArgument(event, getModel(), stArgumentKV));\n" +
                  "			});\n" +
                  "			if (stParameterMenu.getMenuComponentCount() != 0) pop.add(stParameterMenu);\n" +
                  "		});\n" +
                  "		if (pop.getComponents().length != 0) pop.addSeparator();\n" +
                  "	});")
            .addRightClickActions("OpenAllArguments")
            //.addKeyPressActions("E", "OpenAllArguments")
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenAllArguments")
                  .setTitle("Open All")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "		stParameter.getKeys()\n" +
                        "				.forEach(stParameterKey -> getModel().getKeyValues()\n" +
                        "						.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                        "						.filter(stArgumentKV -> stArgumentKV.getValue() != null)\n" +
                        "						.findFirst()\n" +
                        "						.ifPresent(stArgumentKV -> new OpenArgument(event, getModel(), stParameterKey, stArgumentKV).actionPerformed(null)));\n" +
                        "		new LayoutTreeAction(thisNode(), event).actionPerformed(null);\n" +
                        "	});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetInputValueArgumentAction")
                  .addFields("nextgen.st.domain.STParameterKey", "stParameterKey")
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .setTitle("From input")
                  .addStatements("nextgen.utils.SwingUtil.showInputDialog(stParameterKey.getName(), thisCanvas(), s -> {\n" +
                        "			thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
                        "				final nextgen.st.model.STValue stValue = thisCanvas().appModel().db.newSTValue(s);\n" +
                        "				appModel().removeArgument(getModel(), stParameterKey);\n" +
                        "				final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().appModel().db.newSTArgumentKV(stParameterKey, stValue);\n" +
                        "				stArgument.addKeyValues(stArgumentKV);\n" +
                        "				thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue)), stArgument, stParameterKey, stArgumentKV));\n" +
                        "			});\n" +
                        "		});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetSTModelArgumentAction")
                  .addFields("nextgen.st.domain.STParameterKey", "stParameterKey")
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .addFields("STModelNode", "stModelNode")
                  .setTitleExpression("appModel().cut(stModelNode.getText(), 30)")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "			appModel().removeArgument(getModel(), stParameterKey);\n" +
                        "			final nextgen.st.model.STValue stValue = thisCanvas().appModel().db.newSTValue(stModelNode.getModel());\n" +
                        "			final nextgen.st.model.STArgumentKV stArgumentKV = thisCanvas().appModel().db.newSTArgumentKV(stParameterKey, stValue);\n" +
                        "			stArgument.addKeyValues(stArgumentKV);\n" +
                        "			thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), stModelNode, stArgument, stParameterKey, stArgumentKV));\n" +
                        "		});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenArgument")
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .addFields("nextgen.st.domain.STParameterKey", "stParameterKey")
                  .addFields("nextgen.st.model.STArgumentKV", "stArgumentKV")
                  .setTitleExpression("appModel().cut(thisCanvas().appModel().render(stArgument.getValue()))")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "			final nextgen.st.model.STValue stValue = stArgumentKV.getValue();\n" +
                        "			switch (stValue.getType()) {\n" +
                        "				case STMODEL:\n" +
                        "					thisCanvas().addNode(stValue.getStModel().getUuid(), () -> new STModelNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate())));\n" +
                        "					thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().getNode(stValue.getStModel().getUuid()), stArgument, stParameterKey, stArgumentKV));\n" +
                        "					break;\n" +
                        "				case PRIMITIVE:\n" +
                        "					thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));\n" +
                        "					thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().getNode(stValue.getUuid()), stArgument, stParameterKey, stArgumentKV));\n" +
                        "					break;\n" +
                        "				case ENUM:\n" +
                        "					thisCanvas().addNode(stValue.getUuid(), () -> new STValueNode(stValue));\n" +
                        "					thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(thisNode(), thisCanvas().getNode(stValue.getUuid()), stArgument, stParameterKey, stArgumentKV));\n" +
                        "					break;\n" +
                        "			}\n" +
                        "			new LayoutTreeAction(thisNode(), event).actionPerformed(null);\n" +
                        "		});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("RemoveArgument")
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .addFields("nextgen.st.model.STArgumentKV", "stArgumentKV")
                  .setTitleExpression("appModel().cut(thisCanvas().appModel().render(stArgument.getValue()))")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "		stArgument.removeKeyValues(stArgumentKV);\n" +
                        "		thisCanvas().removeRelation(stArgumentKV.getUuid());\n" +
                        "	});"));

      final nextgen.templates.nextgen.CanvasNode stModelNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("STModelNode")
            .setModelType("nextgen.st.model.STModel")
            .addFields("nextgen.st.domain.STTemplate", "stTemplate")
            .setUuidExpression("model.getUuid()")
            .setLabelExpression("appModel().canvasLabel(stTemplate, model)")
            .addAddedToCanvasStatements("thisCanvas().getAllNodes().forEach(this::newNodeAdded);")
            .addNewNodeAddedStatements("appModel().forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> {\n" +
                  "	if (refersTo(stArgument, stParameter, node))\n" +
                  "		addRelation(stArgument.getUuid(), () -> new STArgumentRelation(STModelNode.this, node, stArgument, stParameter));\n" +
                  "});")
            .addRightClickStatements("final java.util.List<STValueNode> stValueNodes = thisCanvas().getSelectedNodes()\n" +
                  "		.filter(stNode -> stNode instanceof STValueNode)\n" +
                  "		.filter(stNode -> !stNode.getUuid().equals(getUuid()))\n" +
                  "		.map(stNode -> (STValueNode) stNode)\n" +
                  "		.collect(java.util.stream.Collectors.toList());\n" +
                  "final java.util.List<STModelNode> stModelNodes = thisCanvas().getSelectedNodes()\n" +
                  "		.filter(stNode -> stNode instanceof STModelNode)\n" +
                  "		.filter(stNode -> !stNode.getUuid().equals(getUuid()))\n" +
                  "		.map(stNode -> (STModelNode) stNode)\n" +
                  "		.collect(java.util.stream.Collectors.toList());\n" +
                  "final java.util.List<STModelNode> sameModelNodes = thisCanvas().getSelectedNodes()\n" +
                  "		.filter(stNode -> stNode instanceof STModelNode)\n" +
                  "		.filter(stNode -> !stNode.getUuid().equals(getUuid()))\n" +
                  "		.map(stNode -> (STModelNode) stNode)\n" +
                  "		.filter(stModelNode -> stModelNode.stTemplate.equals(STModelNode.this.stTemplate))\n" +
                  "		.collect(java.util.stream.Collectors.toList());")
            .addRightClickStatements("thisCanvas().appModel().doInTransaction(tx -> {\n" +
                  "\n" +
                  "	final String clipboardValue = appModel().cut(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "	\n" +
                  "	final JMenu parametersMenu = new JMenu(\"Parameters\");\n" +
                  "	pop.add(parametersMenu);\n" +
                  "	final Map<String, nextgen.st.model.STValue> existingSelections = new LinkedHashMap<>();\n" +
                  "\n" +
                  "	stTemplate.getParameters().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stParameter -> {\n" +
                  "\n" +
                  "		final JMenu stParameterMenu = new JMenu(stParameter.getName());\n" +
                  "		parametersMenu.add(stParameterMenu);\n" +
                  "\n" +
                  "		switch (stParameter.getType()) {\n" +
                  "			case SINGLE: {\n" +
                  "				final JMenu addstParameterMenu = new JMenu(\"Set\");\n" +
                  "				stParameterMenu.add(addstParameterMenu);\n" +
                  "				stValueNodes.forEach(stNode -> addstParameterMenu.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(stNode.getModel(), 30), getModel(), stParameter, stNode.getModel())));\n" +
                  "				stModelNodes.forEach(stNode -> addstParameterMenu.add(new nextgen.actions.SetArgumentFromSTModel(\"Set \" + appModel().render(stNode.getModel(), 30), getModel(), stParameter, stNode.getModel())));\n" +
                  "				addstParameterMenu.add(new SetParameterTypeAction(event, stParameter));\n" +
                  "				addstParameterMenu.add(new nextgen.actions.SetArgumentFromInput(\"Set from Input\", getModel(), stParameter, thisCanvas()));\n" +
                  "				addstParameterMenu.add(new nextgen.actions.SetArgumentToTrue(\"Set true\", getModel(), stParameter));\n" +
                  "				addstParameterMenu.add(new nextgen.actions.SetArgumentFromClipboard(\"Set from Clipboard\", getModel(), stParameter));\n" +
                  "\n" +
                  "				final JMenu openstParameterMenu = new JMenu(\"Open\");\n" +
                  "				stParameterMenu.add(openstParameterMenu);\n" +
                  "\n" +
                  "				final JMenu removestParameterMenu = new JMenu(\"Remove\");\n" +
                  "				stParameterMenu.add(removestParameterMenu);\n" +
                  "\n" +
                  "				getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {\n" +
                  "					openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));\n" +
                  "					removestParameterMenu.add(new nextgen.actions.RemoveArgument(stArgument, thisCanvas()));\n" +
                  "					existingSelections.put(stParameter.getUuid(), stArgument.getValue());\n" +
                  "				});\n" +
                  "\n" +
                  "				\n" +
                  "				break;\n" +
                  "			}\n" +
                  "			case LIST: {\n" +
                  "				final JMenu addstParameterMenu = new JMenu(\"Add\");\n" +
                  "				stParameterMenu.add(addstParameterMenu);\n" +
                  "				stValueNodes.forEach(stNode -> addstParameterMenu.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(stNode.getModel(), 30), getModel(), stParameter, stNode.getModel())));\n" +
                  "				stModelNodes.forEach(stNode -> addstParameterMenu.add(new nextgen.actions.AddArgumentFromSTModel(\"Add \" + appModel().render(stNode.getModel(), 30), getModel(), stParameter, stNode.getModel())));\n" +
                  "				addstParameterMenu.add(new AddParameterTypeAction(event, stParameter));\n" +
                  "				addstParameterMenu.add(new nextgen.actions.AddArgumentFromInput(\"Add from Input\", getModel(), stParameter, thisCanvas()));\n" +
                  "				addstParameterMenu.add(new nextgen.actions.AddArgumentFromClipboard(\"Add from Clipboard\", getModel(), stParameter));\n" +
                  "\n" +
                  "				final JMenu openstParameterMenu = new JMenu(\"Open\");\n" +
                  "				stParameterMenu.add(openstParameterMenu);\n" +
                  "\n" +
                  "				final JMenu removestParameterMenu = new JMenu(\"Remove\");\n" +
                  "				stParameterMenu.add(removestParameterMenu);\n" +
                  "\n" +
                  "				getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {\n" +
                  "					openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));\n" +
                  "					removestParameterMenu.add(new nextgen.actions.RemoveArgument(stArgument, thisCanvas()));\n" +
                  "				});\n" +
                  "				break;\n" +
                  "			}\n" +
                  "			case KVLIST: {\n" +
                  "				final JMenu addstParameterMenu = new JMenu(\"Add\");\n" +
                  "				stParameterMenu.add(addstParameterMenu);\n" +
                  "				addstParameterMenu.add(new nextgen.actions.AddKVArgument(\"Add\", getModel(), stParameter, thisCanvas()));\n" +
                  "\n" +
                  "				final JMenu openstParameterMenu = new JMenu(\"Open\");\n" +
                  "				stParameterMenu.add(openstParameterMenu);\n" +
                  "\n" +
                  "				final JMenu removestParameterMenu = new JMenu(\"Remove\");\n" +
                  "				stParameterMenu.add(removestParameterMenu);\n" +
                  "\n" +
                  "				getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {\n" +
                  "					openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));\n" +
                  "					removestParameterMenu.add(new nextgen.actions.RemoveArgument(stArgument, thisCanvas()));\n" +
                  "				});\n" +
                  "				break;\n" +
                  "			}\n" +
                  "		}\n" +
                  "	});\n" +
                  "\n" +
                  "	pop.add(new nextgen.actions.SetMultipleFields(stTemplate, getModel(), thisCanvas()));\n" +
                  "\n" +
                  "});\n" +
                  "\n" +
                  "\npop.add(new nextgen.actions.OpenTemplate(stTemplate));" +
                  "\npop.add(new nextgen.actions.EditSTModel(getModel()));"
            )
            .addRightClickActions("ToClipboard")
            .addRightClickActions("Delete")
            .addRightClickActions("Clone")
            .addRightClickActions("AddFileSink")
            .addRightClickActions("OpenFileSink")
            .addRightClickActions("WriteToFile")
            .addLeftClickStatements("appModel().doLaterInTransaction(tx -> setText(stTemplate.getName() + \" : \\n\" + appModel().render(getModel())));\n" +
                  "nextgen.events.CanvasSTModelClicked.post(getModel());")
//            .addKeyPressActions("D", "Delete")
//            .addKeyPressActions("W", "WriteToFile")
//            .addKeyPressActions("I", "OpenIncoming")
            .addKeyPressActions("T", "new nextgen.actions.OpenTemplate(stTemplate).actionPerformed(null);")
//            .addKeyPressActions("E", "OpenAllArguments")
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("AddParameterTypeAction")
                  .addFields("nextgen.st.domain.STParameter", "stParameter")
                  .setTitle("Add")
                  .addStatements("appModel().addList(stParameter, getModel(), thisCanvas());"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetParameterTypeAction")
                  .addFields("nextgen.st.domain.STParameter", "stParameter")
                  .setTitle("Set")
                  .addStatements("appModel().setParameter(stParameter, getModel(), thisCanvas());"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("WriteToFile")
                  .setTitle("Write To File")
                  .addStatements("appModel().writeToFile(getModel());"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenIncoming")
                  .setTitle("Open Incoming")
                  .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                        "\n" +
                        "	appModel().getIncomingSTArguments(getModel())\n" +
                        "			.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel()\n" +
                        "					.forEach(stModel -> {\n" +
                        "						final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
                        "						if (stTemplateByUuid == null) return;\n" +
                        "						stTemplateByUuid.getParameters()\n" +
                        "								.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))\n" +
                        "								.findFirst()\n" +
                        "								.ifPresent(stParameter -> {\n" +
                        "									final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));\n" +
                        "									thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, thisNode(), stArgument, stParameter));\n" +
                        "								});\n" +
                        "					}));\n" +
                        "\n" +
                        "	appModel().getIncomingSTArgumentKVs(getModel())\n" +
                        "			.forEach(stArgumentKV -> {\n" +
                        "				stArgumentKV.getIncomingKeyValuesSTArgument()\n" +
                        "						.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel().forEach(stModel -> {\n" +
                        "							final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
                        "							if (stTemplateByUuid == null) return;\n" +
                        "							stTemplateByUuid.getParameters()\n" +
                        "									.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))\n" +
                        "									.findFirst()\n" +
                        "									.ifPresent(stParameter -> stParameter.getKeys()\n" +
                        "											.filter(stParameterKey -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                        "											.findFirst()\n" +
                        "											.ifPresent(stParameterKey -> {\n" +
                        "												final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));\n" +
                        "												final STKVNode stkvNode = thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter));\n" +
                        "												thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, stkvNode, stArgument, stParameter));\n" +
                        "												thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(stkvNode, thisNode(), stArgument, stParameterKey, stArgumentKV));\n" +
                        "											}));\n" +
                        "						}));\n" +
                        "			});\n" +
                        "});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenAllArguments")
                  .setTitle("Open All")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "	appModel().forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> new OpenArgument(event, false, stParameter, stArgument).actionPerformed(null));\n" +
                        "	new LayoutTreeAction(thisNode(), event).actionPerformed(null);\n" +
                        "});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("ToClipboard")
                  .setTitle("To Clipboard")
                  .addStatements("appModel().doLaterInTransaction(tx -> nextgen.utils.SwingUtil.toClipboard(thisCanvas().appModel().render(getModel())));"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("Delete")
                  .setTitle("Delete")
                  .addStatements("nextgen.utils.SwingUtil.confirm(thisCanvas(), \"Delete model ?\")\n" +
                        "		.ifPresent(confirm -> thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
                        "			close();\n" +
                        "			thisCanvas().appModel().db.remove(getModel());\n" +
                        "		}));"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("Clone")
                  .setTitle("Clone")
                  .addStatements("appModel().doLaterInTransaction(tx -> thisCanvas().addNode(new STModelNode(thisCanvas().appModel().db.clone(getModel()), stTemplate)));"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("AddFileSink")
                  .setTitle("Add File Sink")
                  .addStatements("thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
                        "\n" +
                        "	final String[] fileTypes = new String[]{\"html\", \"java\", \"js\", \"xml\"};\n" +
                        "\n" +
                        "	final String[] pathTypes = thisCanvas().appModel().db.findAllSTFile()\n" +
                        "				.filter(stFile -> stFile.getPath() != null)\n" +
                        "				.filter(stFile -> stFile.getPath().getValue() != null)\n" +
                        "				.map(stFile -> stFile.getPath().getValue())\n" +
                        "				.distinct()\n" +
                        "				.toArray(String[]::new);\n" +
                        "\n" +
                        "	final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();\n" +
                        "	fieldMap.put(\"name\", SwingUtil.newTextField(thisCanvas().appModel().getSTModelName(getModel(), \"\"), 15));\n" +
                        "	fieldMap.put(\"type\", SwingUtil.newTextField(15));\n" +
                        "	fieldMap.put(\"path\", SwingUtil.newTextField(15));\n" +
                        "	fieldMap.put(\"package\", SwingUtil.newTextField(thisCanvas().appModel().getSTModelPackage(getModel(), \"\"), 15));\n" +
                        "	final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));\n" +
                        "	inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" +
                        "	for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {\n" +
                        "			inputPanel.add(new JLabel(fieldEntry.getKey()));\n" +
                        "			inputPanel.add(fieldEntry.getValue());\n" +
                        "\n" +
                        "			if (fieldEntry.getKey().equals(\"type\")) {\n" +
                        "				fieldEntry.getValue().setText(fileTypes[fileTypeIndex.get() % fileTypes.length]);\n" +
                        "				fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {\n" +
                        "					@Override\n" +
                        "					public void mouseClicked(java.awt.event.MouseEvent e) {\n" +
                        "							fieldEntry.getValue().setText(fileTypes[fileTypeIndex.incrementAndGet() % fileTypes.length]);\n" +
                        "					}\n" +
                        "				});\n" +
                        "			} else if (fieldEntry.getKey().equals(\"path\")) {\n" +
                        "				fieldEntry.getValue().setText(pathTypes[pathIndex.get() % pathTypes.length]);\n" +
                        "				fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {\n" +
                        "					@Override\n" +
                        "					public void mouseClicked(java.awt.event.MouseEvent e) {\n" +
                        "							fieldEntry.getValue().setText(pathTypes[pathIndex.incrementAndGet() % pathTypes.length]);\n" +
                        "					}\n" +
                        "				});\n" +
                        "			}\n" +
                        "	}\n" +
                        "\n" +
                        "	nextgen.utils.SwingUtil.showDialog(inputPanel, thisCanvas(), \"New File sink\", new nextgen.utils.SwingUtil.ConfirmAction() {\n" +
                        "			@Override\n" +
                        "			public void verifyAndCommit() throws Exception {\n" +
                        "				final String name = fieldMap.get(\"name\").getText().trim();\n" +
                        "				final String type = fieldMap.get(\"type\").getText().trim();\n" +
                        "				final String path = fieldMap.get(\"path\").getText().trim();\n" +
                        "				final String packageName = fieldMap.get(\"package\").getText().trim();\n" +
                        "				thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
                        "					final nextgen.st.model.STFile stFile = thisCanvas().appModel().newSTFile(name, type, path, packageName);\n" +
                        "					getModel().addFiles(stFile);\n" +
                        "					final STFileNode dstNode = thisCanvas().addNode(new STFileNode(stFile, getModel()));\n" +
                        "					thisCanvas().addRelation(dstNode.getUuid(), () -> new STSinkRelation(thisNode(), dstNode));\n" +
                        "				});\n" +
                        "			}\n" +
                        "	});\n" +
                        "});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenFileSink")
                  .setTitle("Open File Sink")
                  .addStatements("thisCanvas().appModel().doLaterInTransaction(tx ->\n" +
                        "			getModel().getFiles().forEach(stFile -> {\n" +
                        "				final STFileNode dstNode = thisCanvas().addNode(stFile.getUuid(), () -> new STFileNode(stFile, getModel()));\n" +
                        "				thisCanvas().addRelation(dstNode.getUuid(), () -> new STSinkRelation(thisNode(), dstNode));\n" +
                        "				new LayoutTreeAction(thisNode(), event).actionPerformed(null);\n" +
                        "			})\n" +
                        ");"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenArgument")
                  .addFields("boolean", "layoutAfter")
                  .addFields("nextgen.st.domain.STParameter", "stParameter")
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .setTitleExpression("appModel().cut(appModel().render(stArgument), 30)")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "	if (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST)) {\n" +
                        "		addSTKVNode(stArgument, stParameter);\n" +
                        "	} else {\n" +
                        "		final nextgen.st.model.STValue stValue = stArgument.getValue();\n" +
                        "		switch (stValue.getType()) {\n" +
                        "			case STMODEL: {\n" +
                        "				final nextgen.st.model.STModel stModel = stValue.getStModel();\n" +
                        "				addSTModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate()));\n" +
                        "				break;\n" +
                        "			}\n" +
                        "			case PRIMITIVE: {\n" +
                        "				addSTValueNode(stValue);\n" +
                        "				break;\n" +
                        "			}\n" +
                        "			case ENUM: {\n" +
                        "				addSTValueNode(stValue);\n" +
                        "				break;\n" +
                        "			}\n" +
                        "		}\n" +
                        "	}\n" +
                        "\n" +
                        "	if (layoutAfter)\n" +
                        "		new LayoutTreeAction(thisNode(), event).actionPerformed(null);\n" +
                        "});"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("RemoveArgument")
//                  .addFields("nextgen.st.model.STArgument", "stArgument")
//                  .setTitleExpression("appModel().cut(appModel().render(stArgument), 30)")
//                  .addStatements("nextgen.utils.SwingUtil.confirm(thisCanvas(), \"Remove argument ?\")\n" +
//                        "		.ifPresent(confirm -> thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
//                        "			thisCanvas().removeRelation(stArgument.getUuid());\n" +
//                        "			getModel().removeArguments(stArgument);\n" +
//                        "			setText(thisCanvas().appModel().render(getModel()));\n" +
//                        "		}));"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("OpenAllOf")
//                  .addFields("nextgen.st.domain.STParameter", "stParameter")
//                  .setTitle("Open All")
//                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
//                        "		appModel().forEachArgument(stTemplate, getModel(), (stArgument, stParameter) -> {\n" +
//                        "				if (this.stParameter.equals(stParameter))\n" +
//                        "					new OpenArgument(event, false, stParameter, stArgument).actionPerformed(null);\n" +
//                        "		});\n" +
//                        "		new LayoutTreeAction(thisNode(), event).actionPerformed(null);\n" +
//                        "	});"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("SetMultipleFields")
//                  .setTitle("Set Multiple")
//                  .addStatements("appModel().doLaterInTransaction(transaction -> appModel().setMultiple(thisCanvas(), getModel(), stTemplate));"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("OpenTemplate")
//                  .setTitle("Open Template")
//                  .addStatements("appModel().doLaterInTransaction(transaction -> nextgen.events.OpenSTTemplate.post(stTemplate));"))
            .addMethods("@Override\n" +
                  "public void setText(String text) {\n" +
                  "	super.setText(text.substring(0, Math.min(text.length(), 2000)));\n" +
                  "}")
            .addMethods("public boolean refersTo(nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter, BaseCanvasNode<?> node) {\n" +
                  "	if (stArgument == null || stParameter == null || node == null) return false;\n" +
                  "	switch (stParameter.getType()) {\n" +
                  "		case SINGLE: {\n" +
                  "			final nextgen.st.model.STValue value = stArgument.getValue();\n" +
                  "			if (value != null)\n" +
                  "				return value.getUuid().equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && value.getStModel().getUuid().equals(node.getUuid()));\n" +
                  "			break;\n" +
                  "		}\n" +
                  "		case LIST: {\n" +
                  "			final nextgen.st.model.STValue value = stArgument.getValue();\n" +
                  "			if (value != null)\n" +
                  "				return value.getUuid().equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && value.getStModel().getUuid().equals(node.getUuid()));\n" +
                  "			break;\n" +
                  "		}\n" +
                  "		case KVLIST: {\n" +
                  "			if (stArgument.getUuid().equals(node.getUuid())) return true;\n" +
                  "			break;\n" +
                  "		}\n" +
                  "	}\n" +
                  "	return false;\n" +
                  "}");

      final nextgen.templates.nextgen.CanvasNode stValueNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("STValueNode")
            .setModelType("nextgen.st.model.STValue")
            .setUuidExpression("model.getUuid()")
            .setLabelExpression("appModel().render(model)")
            .addAddedToCanvasStatements("appModel().getSTModel(getModel())\n" +
                  "		.filter(stModel -> thisCanvas().getNode(stModel.getUuid()) != null)\n" +
                  "		.map(stModel -> (STModelNode) thisCanvas().getNode(stModel.getUuid()))\n" +
                  "		.ifPresent(stModelNode -> thisCanvas().addRelation(stModelNode.getUuid(), () -> new STValueModelRelation(STValueNode.this, stModelNode)));")
            .addNewNodeAddedStatements("appModel().getSTModel(getModel())\n" +
                  "		.map(stModel -> stModel.getUuid())\n" +
                  "		.filter(uuid -> uuid.equals(node.getUuid()))\n" +
                  "		.ifPresent(uuid -> thisCanvas().addRelation(node.getUuid(), () -> new STValueModelRelation(STValueNode.this, node)));")
            .addRightClickActions("EditSTValue")
            .addRightClickActions("ToClipboard")
            .addRightClickActions("Delete")
            .addRightClickActions("OpenIncoming")
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("EditSTValue")
                  .setTitle("Edit")
                  .addStatements("nextgen.utils.SwingUtil.showInputDialog(\"Edit\", thisCanvas(), thisCanvas().appModel().db.get(() -> getModel().getValue()), s -> thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
                        "		getModel().setValue(s);\n" +
                        "		setText(getModel().getValue());\n" +
                        "	}));"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("ToClipboard")
                  .setTitle("To Clipboard")
                  .addStatements("appModel().doInTransaction(tx -> nextgen.utils.SwingUtil.toClipboard(appModel().render(getModel())));"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("Delete")
                  .setTitle("Delete")
                  .addStatements("nextgen.utils.SwingUtil.confirm(thisCanvas(), \"Delete value ?\")\n" +
                        "		.ifPresent(confirm -> thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
                        "			close();\n" +
                        "			appModel().db.remove(getModel());\n" +
                        "		}));"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenIncoming")
                  .setTitle("Open Incoming")
                  .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                        "\n" +
                        "	appModel().getIncomingSTArguments(getModel())\n" +
                        "			.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel()\n" +
                        "					.forEach(stModel -> {\n" +
                        "						final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
                        "						if (stTemplateByUuid == null) return;\n" +
                        "						stTemplateByUuid.getParameters()\n" +
                        "								.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))\n" +
                        "								.findFirst()\n" +
                        "								.ifPresent(stParameter -> {\n" +
                        "									final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));\n" +
                        "									thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, thisNode(), stArgument, stParameter));\n" +
                        "								});\n" +
                        "					}));\n" +
                        "\n" +
                        "	appModel().getIncomingSTArgumentKVs(getModel())\n" +
                        "			.forEach(stArgumentKV -> {\n" +
                        "				stArgumentKV.getIncomingKeyValuesSTArgument()\n" +
                        "						.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel().forEach(stModel -> {\n" +
                        "							final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
                        "							if (stTemplateByUuid == null) return;\n" +
                        "							stTemplateByUuid.getParameters()\n" +
                        "									.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))\n" +
                        "									.findFirst()\n" +
                        "									.ifPresent(stParameter -> stParameter.getKeys()\n" +
                        "											.filter(stParameterKey -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                        "											.findFirst()\n" +
                        "											.ifPresent(stParameterKey -> {\n" +
                        "												final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));\n" +
                        "												final STKVNode stkvNode = thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter));\n" +
                        "												thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, stkvNode, stArgument, stParameter));\n" +
                        "												thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(stkvNode, thisNode(), stArgument, stParameterKey, stArgumentKV));\n" +
                        "											}));\n" +
                        "						}));\n" +
                        "			});\n" +
                        "});"));

      final nextgen.templates.nextgen.CanvasNode sequentialFlowNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("SequentialFlowNode")
            .setModelType("nextgen.workflow.SequentialFlow");

      final nextgen.templates.nextgen.CanvasNode workNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("WorkNode")
            .setModelType("nextgen.workflow.Work")
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("RunWork")
                  .setTitle("Run"));

      final nextgen.templates.nextgen.CanvasNode sequentialFlow = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("SequentialFlow")
            .setModelType("nextgen.workflow.SequentialFlow");

      final nextgen.templates.nextgen.CanvasNode parallelFlowNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("ParallelFlowNode")
            .setModelType("nextgen.workflow.ParallelFlow");

      final nextgen.templates.nextgen.CanvasNode conditionalFlowNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("ConditionalFlowNode")
            .setModelType("nextgen.workflow.ConditionalFlow");

      final nextgen.templates.nextgen.CanvasNode repeatFlowNode = nextgen.templates.nextgen.NextgenST.newCanvasNode()
            .setName("RepeatFlowNode")
            .setModelType("nextgen.workflow.RepeatFlow");

      final nextgen.templates.nextgen.CanvasRelation scriptRelation = nextgen.templates.nextgen.NextgenST.newCanvasRelation()
            .setName("ScriptRelation")
            .setUuidExpression("src.getUuid()")
            .setLabelExpression("\"SCRIPT\"");

      final nextgen.templates.nextgen.CanvasRelation stArgumentRelation = nextgen.templates.nextgen.NextgenST.newCanvasRelation()
            .setName("STArgumentRelation")
            .setUuidExpression("stArgument.getUuid()")
            .setLabelExpression("stParameter.getName()")
            .addFields("nextgen.st.model.STArgument", "stArgument")
            .addFields("nextgen.st.domain.STParameter", "stParameter")
            .addRightClickActions("Delete")
            .addKeyPressActions("D", "Delete")
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasRelationAction()
                  .setName("Delete")
                  .setTitle("Delete")
                  .addStatements("nextgen.utils.SwingUtil.confirm(thisCanvas(), \"Delete \" + stParameter.getName() + \" ?\")\n" +
                        "		.ifPresent(confirm -> appModel().doLaterInTransaction(tx -> {\n" +
                        "			final STModelNode src = (STModelNode) getSrc();\n" +
                        "			src.getModel().removeArguments(stArgument);\n" +
                        "			removeRelation(getUuid());\n" +
                        "		}));"));

      final nextgen.templates.nextgen.CanvasRelation stkvArgumentRelation = nextgen.templates.nextgen.NextgenST.newCanvasRelation()
            .setName("STKVArgumentRelation")
            .setUuidExpression("stArgumentKV.getUuid()")
            .setLabelExpression("stParameterKey.getName()")
            .addFields("nextgen.st.model.STArgument", "stArgument")
            .addFields("nextgen.st.domain.STParameterKey", "stParameterKey")
            .addFields("nextgen.st.model.STArgumentKV", "stArgumentKV");

      final nextgen.templates.nextgen.CanvasRelation sinkRelation = nextgen.templates.nextgen.NextgenST.newCanvasRelation()
            .setName("STSinkRelation")
            .setUuidExpression("dst.getUuid()")
            .setLabelExpression("\"SINK\"");

      final nextgen.templates.nextgen.CanvasRelation stValueModelRelation = nextgen.templates.nextgen.NextgenST.newCanvasRelation()
            .setName("STValueModelRelation")
            .setUuidExpression("dst.getUuid()")
            .setLabelExpression("\"Value\"");

      final nextgen.templates.nextgen.Canvas canvas = nextgen.templates.nextgen.NextgenST.newCanvas()
            .setPackageName("nextgen.st")
            .addImports("import nextgen.utils.SwingUtil;")
            .setName("STModelCanvas")
            .addFinalFields("java.util.concurrent.atomic.AtomicInteger", "fileTypeIndex", "new java.util.concurrent.atomic.AtomicInteger(0)")
            .addFinalFields("java.util.concurrent.atomic.AtomicInteger", "pathIndex", "new java.util.concurrent.atomic.AtomicInteger(0)")
            .addConstructorStatements("org.greenrobot.eventbus.EventBus.getDefault().register(this);")
            .addConstructorStatements("javax.swing.SwingUtilities.invokeLater(() -> new LoadLastLayoutAction(null).actionPerformed(null));")
            .addMethods("private STAppPresentationModel appModel() {\n" +
                  "	return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();\n" +
                  "}")
//            .addMethods("@org.greenrobot.eventbus.Subscribe()\n" +
//                  "public void onNewSTModel(nextgen.events.NewSTModel event) {\n" +
//                  "	addSTModelNode(event.model, appModel().findSTTemplateByUuid(event.model.getStTemplate()));\n" +
//                  "}")
//            .addMethods("@org.greenrobot.eventbus.Subscribe()\n" +
//                  "public void onOpenSTModel(nextgen.events.OpenSTModel event) {\n" +
//                  "	addSTModelNode(event.model, appModel().findSTTemplateByUuid(event.model.getStTemplate()));\n" +
//                  "	appModel().getWorkspace().showCanvas();\n" +
//                  "}")
            .addRightClickActions("Debug")
            .addRightClickActions("SaveLastLayoutAction")
            .addRightClickActions("LoadLastLayoutAction")
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasAction()
                  .setName("Debug")
                  .setTitle("Debug")
                  .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
                        "	System.out.println(\"Node layer\");\n" +
                        "	nodeLayer.getAllNodes().stream().forEach(o -> System.out.println(o));\n" +
                        "\n" +
                        "	System.out.println(\"Relation layer\");\n" +
                        "	relationLayer.getAllNodes().forEach(o -> System.out.println(o));\n" +
                        "\n" +
                        "	System.out.println(\"All nodes\");\n" +
                        "	getAllNodes().forEach(baseCanvasNode -> System.out.println(baseCanvasNode));\n" +
                        "\n" +
                        "	System.out.println(\"All relations\");\n" +
                        "	getAllRelations().forEach(baseCanvasRelation -> System.out.println(baseCanvasRelation));\n" +
                        "\n" +
                        "	int nodeLayerSize = nodeLayer.getAllNodes().size();\n" +
                        "	int relationLayerSize = relationLayer.getAllNodes().size();\n" +
                        "	long allNodesSize = getAllNodes().count();\n" +
                        "	long allRelationsSize = getAllRelations().count();\n" +
                        "\n" +
                        "	System.out.println(\"nodeLayerSize \" + nodeLayerSize);\n" +
                        "	System.out.println(\"relationLayerSize \" + relationLayerSize);\n" +
                        "	System.out.println(\"allNodesSize \" + allNodesSize);\n" +
                        "	System.out.println(\"allRelationsSize \" + allRelationsSize);\n" +
                        "\n" +
                        "});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasAction()
                  .setName("AddSequentialFlow")
                  .setTitle("Add Sequential Flow"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasAction()
                  .setName("AddWork")
                  .setTitle("Add Work"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasAction()
                  .setName("SaveLastLayoutAction")
                  .setTitle("Save last layout")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "		final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(appModel().db.getDatabaseService());\n" +
                        "		final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findOrCreateLayoutByName(\"last\");\n" +
                        "\n" +
                        "		last.getNodes().forEach(layoutNode -> {\n" +
                        "			layoutNode.getNode().getRelationships().forEach(org.neo4j.graphdb.Relationship::delete);\n" +
                        "			layoutNode.getNode().delete();\n" +
                        "		});\n" +
                        "\n" +
                        "		getAllNodes().forEach(stNode -> {\n" +
                        "			final nextgen.st.canvas.layout.LayoutNode layoutNode = layoutNeoFactory.newLayoutNode();\n" +
                        "			layoutNode.setX(stNode.getOffset().getX());\n" +
                        "			layoutNode.setY(stNode.getOffset().getY());\n" +
                        "			if (stNode instanceof STModelNode) {\n" +
                        "				final org.neo4j.graphdb.Node node = ((STModelNode) stNode).getModel().getNode();\n" +
                        "				layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName(\"ref\"));\n" +
                        "			} else if (stNode instanceof STValueNode) {\n" +
                        "				final org.neo4j.graphdb.Node node = ((STValueNode) stNode).getModel().getNode();\n" +
                        "				layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName(\"ref\"));\n" +
                        "			} else if (stNode instanceof STFileNode) {\n" +
                        "				final org.neo4j.graphdb.Node node = ((STFileNode) stNode).getModel().getNode();\n" +
                        "				layoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName(\"ref\"));\n" +
                        "			} \n" +
                        "			last.addNodes(layoutNode);\n" +
                        "		});\n" +
                        "	});"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasAction()
                  .setName("LoadLastLayoutAction")
                  .setTitle("Load last layout")
                  .addStatements("appModel().doLaterInTransaction(tx -> {\n" +
                        "\n" +
                        "	final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(appModel().db.getDatabaseService());\n" +
                        "	final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findLayoutByName(\"last\");\n" +
                        "	if (last == null) return;\n" +
                        "\n" +
                        "	final java.util.concurrent.atomic.AtomicReference<BaseCanvasNode<?>> centerNodeRef = new java.util.concurrent.atomic.AtomicReference<>();\n" +
                        "	last.getNodesSorted().forEach(layoutNode -> {\n" +
                        "		final org.neo4j.graphdb.Node node = layoutNode.getNode();\n" +
                        "		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"ref\")).forEach(relationship -> {\n" +
                        "				final org.neo4j.graphdb.Node stNode = relationship.getOtherNode(node);\n" +
                        "				if (nextgen.st.model.STModelNeoFactory.isSTModel(stNode)) {\n" +
                        "					final nextgen.st.model.STModel stModel = appModel().newSTModel(stNode);\n" +
                        "					addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));\n" +
                        "					getNode(stModel.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());\n" +
                        "					if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stModel.getUuid()));\n" +
                        "				} else if (nextgen.st.model.STModelNeoFactory.isSTValue(stNode)) {\n" +
                        "					final nextgen.st.model.STValue stValue = appModel().newSTValue(stNode);\n" +
                        "					addNode(stValue.getUuid(), () -> new STValueNode(stValue));\n" +
                        "					getNode(stValue.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());\n" +
                        "					if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stValue.getUuid()));\n" +
                        "				} else if (nextgen.st.model.STModelNeoFactory.isSTFile(stNode)) {\n" +
                        "					final nextgen.st.model.STFile stFile = appModel().newSTFile(stNode);\n" +
                        "					stFile.getIncomingFilesSTModel().findFirst().ifPresent(stModel -> {\n" +
                        "						addNode(stFile.getUuid(), () -> new STFileNode(stFile, stModel));\n" +
                        "						getNode(stFile.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());\n" +
                        "						if (centerNodeRef.get() == null) centerNodeRef.set(getNode(stFile.getUuid()));\n" +
                        "					});\n" +
                        "				} \n" +
                        "		});\n" +
                        "	});\n" +
                        "\n" +
                        "	if (centerNodeRef.get() != null) centerNode(centerNodeRef.get());\n" +
                        "});"))
            .addCanvasNodes(sequentialFlowNode)
            .addCanvasNodes(workNode)
            .addCanvasNodes(sequentialFlow)
            .addCanvasNodes(parallelFlowNode)
            .addCanvasNodes(conditionalFlowNode)
            .addCanvasNodes(repeatFlowNode)
            .addCanvasNodes(stFileNode)
            .addCanvasNodes(stkvNode)
            .addCanvasNodes(stModelNode)
            .addCanvasNodes(stValueNode)
            .addCanvasRelations(scriptRelation)
            .addCanvasRelations(stArgumentRelation)
            .addCanvasRelations(stkvArgumentRelation)
            .addCanvasRelations(sinkRelation)
            .addCanvasRelations(stValueModelRelation);

      STGenerator.writeJavaFile(canvas, canvas.getPackageName()
            .toString(), canvas.getName()
            .toString(), mainJava);
   }

   @org.junit.Test
   public void generateSwing() {

      final Singleton appModel = JavaPatterns
            .newSingleton(appModelName, swingPackage)
            .addFields(stringType, "title", null)
            .addFields(awtDimensionType, "appSize", null)
            .addFields(awtDimensionType, "navigatorSize", null)
            .addFields(awtDimensionType, "workspaceSize", null)
            .addFields(stringType, "rootDir", null)
            .addFields(stringType, "dbDir", null)
            .addFields(stringType, "outputPackage", null)
            .addFields(stringType, "outputPath", null)
            .addFields(stringType, "templateDir", null)
            .addFields(stringType, "stDelimiter", null)
            .addFields(integerType, "fontSize", null)
            .addFields(stringType, "fontName", null)
            .addFields(jFrameType, "frame", null)
            .addFields(typesMap.get(presentationModelName), StringUtil.lowFirst(presentationModelName), null);

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

      final Entity stParameterKey = DomainPatterns
            .newEntity("STParameterKey")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newStringField("argumentType"));

      final Entity stParameter = DomainPatterns
            .newEntity("STParameter")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newEnumField("type", stParameterType))
            .addRelations(DomainPatterns.newOneToMany("keys", stParameterKey))
            .addRelations(DomainPatterns.newStringField("argumentType"));

      final Entity stInterface = DomainPatterns
            .newEntity("STInterface")
            .addRelations(DomainPatterns.newStringField("name"));

      final Entity stEnumValue = DomainPatterns
            .newEntity("STEnumValue")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("lexical"));

      final Entity stEnum = DomainPatterns
            .newEntity("STEnum")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newOneToMany("values", stEnumValue));

//      final Entity stTemplateAction = DomainPatterns.newEntity("STTemplateAction")
//            .addRelations(DomainPatterns.newStringField("name", true))
//            .addRelations(DomainPatterns.newOneToManyString("statements"));

      final Entity stTemplate = DomainPatterns
            .newEntity("STTemplate")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("text"))
            .addRelations(DomainPatterns.newOneToManyString("implements"))
            .addRelations(DomainPatterns.newOneToMany("parameters", stParameter))
            .addRelations(DomainPatterns.newOneToManySelf("children"))
//            .addRelations(DomainPatterns.newOneToMany("actions", stTemplateAction))
            ;

      final Entity stGroupModel = DomainPatterns
            .newEntity("STGroupModel")
            .addRelations(DomainPatterns.newStringField("name", true))
            .addRelations(DomainPatterns.newStringField("delimiter"))
            .addRelations(DomainPatterns.newStringField("icon"))
            .addRelations(DomainPatterns.newStringField("tags"))
            .addRelations(DomainPatterns.newOneToMany("templates", stTemplate))
            .addRelations(DomainPatterns.newOneToMany("interfaces", stInterface))
            .addRelations(DomainPatterns.newOneToMany("enums", stEnum));

      final Entity stgErrorType = DomainPatterns.newEnum("STGErrorType", "COMPILE,RUNTIME,IO,INTERNAL");

      final Entity stgError = DomainPatterns
            .newEntity("STGError")
            .addRelations(DomainPatterns.newEnumField("type", stgErrorType))
            .addRelations(DomainPatterns.newStringField("message"))
            .addRelations(DomainPatterns.newIntegerField("line"))
            .addRelations(DomainPatterns.newIntegerField("charPosition"));

      final Entity stgDirectory = DomainPatterns
            .newEntity("STGDirectory")
            .addRelations(DomainPatterns.newStringField("path"))
            .addRelations(DomainPatterns.newStringField("outputPackage"))
            .addRelations(DomainPatterns.newStringField("outputPath"))
            .addRelations(DomainPatterns.newOneToMany("groups", stGroupModel));

      final Entity stAppModel = DomainPatterns
            .newEntity("STAppModel")
            .addRelations(DomainPatterns.newStringField("modelDb"))
            .addRelations(DomainPatterns.newStringField("rootDir"))
            .addRelations(DomainPatterns.newIntegerField("editorFontSize"))
            .addRelations(DomainPatterns.newOneToMany("directories", stgDirectory));

      final Entity stgParseResult = DomainPatterns
            .newEntity("STGParseResult")
            .addRelations(DomainPatterns.newOneToOne("parsed", stGroupModel))
            .addRelations(DomainPatterns.newOneToMany("errors", stgError));

      final Domain domain = DomainPatterns
            .newDomain("ST")
            .addEntities(stAppModel)
            .addEntities(stgParseResult);

      DomainPatterns.writeJsonWrapper(mainJava, stDomainPackage, domain);
   }

   /**
    * generateSTModelDomain
    */
   @org.junit.Test
   public void generateSTModelDomain() {

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

      final Entity stArgumentKV = DomainPatterns
            .newEntityWithUuid("STArgumentKV")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("stParameterKey"))
            .addRelations(DomainPatterns.newOneToOne("value", stValue));

      final Entity stArgument = DomainPatterns
            .newEntityWithUuid("STArgument")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("stParameter"))
            .addRelations(DomainPatterns.newOneToOne("value", stValue))
            .addRelations(DomainPatterns.newOneToMany("keyValues", stArgumentKV));

      final Entity stModel = DomainPatterns
            .newEntityWithUuid("STModel")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("stTemplate"))
            .addRelations(DomainPatterns.newStringField("stGroup"))
            .addRelations(DomainPatterns.newOneToMany("files", stFile))
            .addRelations(DomainPatterns.newOneToMany("arguments", stArgument));

      stValue.addRelations(DomainPatterns.newOneToOne("stModel", stModel));

      final Entity stProject = DomainPatterns
            .newEntityWithUuid("STProject")
            .setEqha("uuid")
            .addRelations(DomainPatterns.newStringField("name"))
            .addRelations(DomainPatterns.newOneToMany("models", stModel))
            .addRelations(DomainPatterns.newOneToMany("values", stValue));

      final Domain domain = DomainPatterns
            .newDomain("STModel")
            .addEntities(stModel)
            .addEntities(stProject);

      final org.javatuples.Pair<NeoFactory, java.util.Map<nextgen.templates.domain.Entity, NodeWrapper>> neo = transform(stModelPackage, domain);

      final NeoFactory neoFactory = neo.getValue0();
      final java.util.Map<nextgen.templates.domain.Entity, NodeWrapper> nodeWrapperMap = neo.getValue1();

      for (NodeWrapper nodeWrapper : nodeWrapperMap.values()) {
         STGenerator.writeJavaFile(nodeWrapper, stModelPackage, nodeWrapper.getName(), mainJava);
      }

      STGenerator.writeJavaFile(neoFactory, stModelPackage, neoFactory.getName(), mainJava);
   }

   /**
    * generateCanvasLayoutDomain
    */
   @org.junit.Test
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

   /**
    * generateCanvasLayoutDomain
    */
   @org.junit.Test
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
      STGenerator.writeJavaFile(workFlowFacade, workflowPackage, workFlowFacade.getName(), mainJava);

      DomainPatterns.writeGreenrobotEvents(mainJava, workflowPackage, workflowPackage, domain);
   }


   /**
    * generateProjectFiles
    */
   @org.junit.Test
   public void generateProjectFiles() {
      Pom projectPom = MavenST
            .newPom()
            .setParent("<parent>\n" +
                  "	<artifactId>components</artifactId>\n" +
                  "	<groupId>com.nextgen</groupId>\n" +
                  "	<version>1.0</version>\n" +
                  "</parent>")
            .setName("Core")
            .setArtifactId("core")
            .addProperties(MavenPatterns
                  .newMavenCompilerSource()
                  .setValue("9"))
            .addProperties(MavenPatterns
                  .newMavenCompilerTarget()
                  .setValue("9"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("com.fifesoft")
                  .setArtifactId("rsyntaxtextarea")
                  .setVersion("3.0.3"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("com.formdev")
                  .setArtifactId("flatlaf")
                  .setVersion("0.40"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("org.neo4j")
                  .setArtifactId("neo4j")
                  .setVersion("${neo4j.version}"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("org.antlr")
                  .setArtifactId("antlr4")
                  .setVersion("${antlr.version}"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("com.jgoodies")
                  .setArtifactId("jgoodies-forms")
                  .setVersion("${jgoodies.version}"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("org.jeasy")
                  .setArtifactId("easy-flows")
                  .setVersion("0.2"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("org.piccolo2d")
                  .setArtifactId("piccolo2d-core")
                  .setVersion("${piccolo2d.version}"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("org.piccolo2d")
                  .setArtifactId("piccolo2d-extras")
                  .setVersion("${piccolo2d.version}"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("org.abego.treelayout")
                  .setArtifactId("org.abego.treelayout.core")
                  .setVersion("1.0.3"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("io.vertx")
                  .setArtifactId("vertx-core")
                  .setVersion("${vertx.version}"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("org.jsoup")
                  .setArtifactId("jsoup")
                  .setVersion("1.12.1"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("com.github.kklisura.cdt")
                  .setArtifactId("cdt-java-client")
                  .setVersion("2.1.0"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("net.openhft")
                  .setArtifactId("compiler")
                  .setVersion("2.3.1"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("junit")
                  .setArtifactId("junit")
                  .setVersion("${junit.version}"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("org.javatuples")
                  .setArtifactId("javatuples")
                  .setVersion("1.2"))
            .addDependencies(nextgen.templates.MavenPatterns
                  .newDependency()
                  .setGroupId("com.github.javaparser")
                  .setArtifactId("javaparser-symbol-solver-core")
                  .setVersion("3.16.1"));

      MavenPatterns.generate(MavenPatterns
            .newProject()
            .setName("Nextgen")
            .setRoot(root.getAbsolutePath()), projectPom);
   }

   public void write(nextgen.templates.greenrobot.Event event) {
      nextgen.st.STGenerator.writeJavaFile(event, eventsPackage, event.getName(), mainJava);
   }

   private void write(nextgen.templates.nextgen.TransactionAction action) {
      STGenerator.writeJavaFile(action, actionsPackage, action.getName()
            .toString(), mainJava);
   }
}