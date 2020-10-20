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
   final PackageDeclaration eventsPackage = JavaPatterns.newPackageDeclaration(corePackage, "events");
   final PackageDeclaration metaDomainPackage = JavaPatterns.newPackageDeclaration(corePackage, "domains.meta");
   final PackageDeclaration stDomainPackage = JavaPatterns.newPackageDeclaration(corePackage, "st.domain");
   final PackageDeclaration stModelPackage = JavaPatterns.newPackageDeclaration(corePackage, "st.model");
   final PackageDeclaration canvasLayoutPackage = JavaPatterns.newPackageDeclaration(corePackage, "st.canvas.layout");
   final PackageDeclaration beansPackage = JavaPatterns.newPackageDeclaration(corePackage, "st.beans");
   final PackageDeclaration snippetsPackage = JavaPatterns.newPackageDeclaration(corePackage, "snippets");
   final PackageDeclaration workflowPackage = JavaPatterns.newPackageDeclaration(corePackage, "workflow");
   final PackageDeclaration swingPackage = JavaPatterns.newPackageDeclaration(corePackage, swingPackageName);
   final PackageDeclaration swingConfigPackage = JavaPatterns.newPackageDeclaration(swingPackage, swingConfigPackageName);
   final PackageDeclaration actionsPackage = JavaPatterns.newPackageDeclaration(corePackage, "actions");


   @Before
   public void init() {
      typesMap.put(presentationModelName, JavaPatterns.newClassOrInterfaceType(stPackage, presentationModelName));
   }

   @org.junit.Test
   public void generateActions() {

      final String stArgumentType = "nextgen.st.model.STArgument";
      final String projectType = "nextgen.st.model.STProject";
      final String stModelType = "nextgen.st.model.STModel";
      final String stValueType = "nextgen.st.model.STValue";

      final String stGroupType = "nextgen.st.domain.STGroupModel";
      final String stTemplateType = "nextgen.st.domain.STTemplate";
      final String stEnumType = "nextgen.st.domain.STEnum";
      final String stInterfaceType = "nextgen.st.domain.STInterface";
      final String stParameterType = "nextgen.st.domain.STParameter";
      final String stParameterKeyType = "nextgen.st.domain.STParameterKey";

      final String ownerType = "javax.swing.JComponent";

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("CopyModel")
                                             .setTitle("Copy Model")
                                             .addFields(stModelType, "stModel")
                                             .addStatements("nextgen.utils.SwingUtil.toClipboard(\"stmodel-\" + stModel.getUuid());"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("OpenModel")
                                             .setTitle("Open")
                                             .addFields(stModelType, "stModel")
                                             .addStatements("nextgen.events.OpenSTModel.post(stModel);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("VisitModel")
                                             .setTitle("Visit")
                                             .addFields(stModelType, "stModel")
                                             .addStatements("new nextgen.st.STVisitorTest(appModel()).visit(stModel);"));

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
                                             .addStatements("nextgen.utils.SwingUtil.confirm(owner, \"Delete\").ifPresent(aBoolean -> appModel().doLaterInTransaction(t -> appModel().delete(stModel)));"));


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
                                             .addFields(ownerType, "owner")
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
                                             .addFields(ownerType, "owner")
                                             .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, nextgen.utils.SwingUtil.fromClipboard()));"));

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
                                             .addStatements("appModel().addList(stParameter, stModel, owner, newArgument -> {});"));

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
                                             .addStatements("appModel().addKVArgument(stModel, stParameter, owner, stArgument -> {});"));

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
                                             .addFields(projectType, "project")
                                             .addFields(stModelType, "stModel")
                                             .addStatements("appModel().addToProject(project, stModel);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("GenerateAllProjectModels")
                                             .setTitle("Generate all")
                                             .addFields(projectType, "project")
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
                                             .addFields(stGroupType, "stGroup")
                                             .addFields(ownerType, "owner")
                                             .addStatements("appModel().editSTGroupTags(owner, stGroup);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("ImportSTTemplate")
                                             .setTitle("Import from stg-file")
                                             .addFields(stGroupType, "stGroup")
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
                                             .addFields(stGroupType, "stGroup")
                                             .addStatements("appModel().generateSTGroup(stGroup, false);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("NewTemplate")
                                             .setTitle("New Template")
                                             .addFields(stGroupType, "stGroup")
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
                                             .addFields(stGroupType, "stGroup")
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
                                             .addFields(stGroupType, "stGroup")
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
                                             .addFields(stGroupType, "stGroup")
                                             .addFields(ownerType, "owner")
                                             .addStatements("nextgen.utils.SwingUtil.confirm(owner, \"Delete\").ifPresent(aBoolean -> appModel().doLaterInTransaction(t -> appModel().delete(stGroup)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("RenameSTGroup")
                                             .setTitle("Rename")
                                             .addFields(stGroupType, "stGroup")
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
                                             .addFields(stGroupType, "stGroup")
                                             .addFields(ownerType, "owner")
                                             .addStatements("nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->\n" +
                                                   "            nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> appModel().setName(stEnum, name)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("DeleteEnum")
                                             .setTitle("Delete")
                                             .addFields(stEnumType, "stEnum")
                                             .addFields(stGroupType, "stGroup")
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
                                             .addFields(projectType, "project")
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
                                             .addFields(stGroupType, "stGroup")
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
                                             .addFields(stGroupType, "stGroup")
                                             .addFields(ownerType, "owner")
                                             .addStatements("nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->\n" +
                                                   "            nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> appModel().setName(stTemplate, name)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("DeleteSTTemplate")
                                             .setTitle("Delete")
                                             .addFields(stTemplateType, "stTemplate")
                                             .addFields(stGroupType, "stGroup")
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
                                             .addFields(stGroupType, "stGroup")
                                             .addFields(ownerType, "owner")
                                             .addStatements("nextgen.utils.SwingUtil.getInputFromUser(owner, \"Name\").ifPresent(name ->\n" +
                                                   "            nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> appModel().setName(stInterface, name)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
                                             .setName("DeleteSTInterface")
                                             .setTitle("Delete")
                                             .addFields(stInterfaceType, "stInterface")
                                             .addFields(stGroupType, "stGroup")
                                             .addFields(ownerType, "owner")
                                             .addStatements("appModel().delete(stInterface, stGroup);"));

      // events
      write(nextgen.templates.GreenRobotPatterns.newEvent()
                                                .setName("KVArgumentRemoved")
                                                .addFields(stArgumentType, "argument")
                                                .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
                                                .setName("ArgumentAdded")
                                                .addFields(stModelType, "stModel")
                                                .addFields(stArgumentType, "stArgument")
                                                .addFields(stParameterType, "stParameter")
                                                .addFields(stValueType, "stValue")
                                                .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
                                                .setName("ModelAddedToProject")
                                                .addFields(stModelType, "stModel")
                                                .addFields(projectType, "project")
                                                .setPackageName(eventsPackage.getName()));

      write(nextgen.templates.GreenRobotPatterns.newEvent()
                                                .setName("STValueChanged")
                                                .addFields(stValueType, "stValue")
                                                .setPackageName(eventsPackage.getName()));

   }

   public void write(nextgen.templates.greenrobot.Event event) {
      nextgen.st.STGenerator.writeJavaFile(event, eventsPackage, event.getName(), mainJava);
   }

   private void write(nextgen.templates.nextgen.TransactionAction action) {
      STGenerator.writeJavaFile(action, actionsPackage, action.getName().toString(), mainJava);
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

      //DomainPatterns.writeNeo(mainJava, stModelPackage, domain);

      final org.javatuples.Pair<NeoFactory, java.util.Map<nextgen.templates.domain.Entity, NodeWrapper>> neo = transform(stModelPackage, domain);

      final NeoFactory neoFactory = neo.getValue0();
      final java.util.Map<nextgen.templates.domain.Entity, NodeWrapper> nodeWrapperMap = neo.getValue1();

      for (NodeWrapper nodeWrapper : nodeWrapperMap.values()) {

         final Object className = nodeWrapper.getName();
         final String updateStatement = eventsPackage.getName() + "." + className + "Updated.post(this);";

         nodeWrapper.getMethods().stream()
                    .filter(o -> o instanceof DeleteNode)
                    .map(o -> (DeleteNode) o)
                    .findFirst()
                    .ifPresent(deleteNode -> deleteNode.addDeleteStatements(eventsPackage.getName() + "." + className + "Deleted.post(uuid);"));

         nodeWrapper.getAccessors().forEach(o -> {

//            if (o instanceof PrimitiveAccessors) {
//               PrimitiveAccessors accessors = (PrimitiveAccessors) o;
//               accessors.addSetStatements(updateStatement);
//               accessors.addRemoveStatements(updateStatement);
//            } else if (o instanceof ReferenceAccessors) {
//               ReferenceAccessors accessors = (ReferenceAccessors) o;
//               accessors.addSetStatements(updateStatement);
//               accessors.addRemoveStatements(updateStatement);
//            } else if (o instanceof ListReferenceAccessors) {
//               ListReferenceAccessors accessors = (ListReferenceAccessors) o;
//               accessors.addSetStatements(updateStatement);
//               accessors.addRemoveStatements(updateStatement);
//            } else if (o instanceof ListPrimitiveAccessors) {
//               ListPrimitiveAccessors accessors = (ListPrimitiveAccessors) o;
//               accessors.addSetStatements(updateStatement);
//               accessors.addRemoveStatements(updateStatement);
//            } else if (o instanceof ExternalAccessors) {
//               ExternalAccessors accessors = (ExternalAccessors) o;
//               accessors.addSetStatements(updateStatement);
////               accessors.addRemoveStatements(updateStatement);
//            } else if (o instanceof EnumListAccessors) {
//               EnumListAccessors accessors = (EnumListAccessors) o;
//               accessors.addSetStatements(updateStatement);
//               accessors.addRemoveStatements(updateStatement);
//            } else if (o instanceof EnumAccessors) {
//               EnumAccessors accessors = (EnumAccessors) o;
//               accessors.addSetStatements(updateStatement);
//               accessors.addRemoveStatements(updateStatement);
//            }
         });

         final nextgen.templates.greenrobot.Event updatedEvent = nextgen.templates.GreenRobotPatterns.newEvent()
                                                                                                     .setName(className + "Updated")
                                                                                                     .setPackageName(eventsPackage.getName())
                                                                                                     .addFields(newClassOrInterfaceType(stModelPackage, className
                                                                                                           .toString()), "model");
         write(updatedEvent);

         final nextgen.templates.greenrobot.Event deletedEvent = nextgen.templates.GreenRobotPatterns.newEvent()
                                                                                                     .setName(className + "Deleted")
                                                                                                     .setPackageName(eventsPackage.getName())
                                                                                                     .addFields("String", "uuid");
         write(deletedEvent);
      }

      for (NodeWrapper nodeWrapper : nodeWrapperMap.values()) {
         STGenerator.writeJavaFile(nodeWrapper, stModelPackage, nodeWrapper.getName(), mainJava);
      }

//      neoFactory.getAccessors().stream()
//                .filter(o -> o instanceof NeoFactoryAccessors)
//                .map(o -> (NeoFactoryAccessors) o)
//                .forEach(neoFactoryAccessors -> neoFactoryAccessors
//                      .addNewInstanceStatements(eventsPackage.getName() + ".New" + neoFactoryAccessors.getName() + ".post(newInstance);"));

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
}