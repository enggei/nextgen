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
import nextgen.templates.javaneo4jembedded.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.JavaPatterns.newBlockStmt;
import static nextgen.templates.JavaPatterns.newClassOrInterfaceType;
import static nextgen.templates.java.JavaST.newExpressionStmt;
import static nextgen.templates.java.JavaST.newMethodCallExpression;

public class NextgenProject {

   static final File root = new File("/home/goe/projects/nextgen/components/core");

   static final File mainJava = new File(root, "src/main/java");
   static final File mainResources = new File(root, "src/main/resources");
   static final File testJava = new File(root, "src/test/java");
   static final File testResources = new File(root, "src/test/resources");

   static final Map<Object, ClassOrInterfaceType> typesMap = new LinkedHashMap<>();
   static final java.util.Set<Object> events = new java.util.LinkedHashSet<>();
   static final java.util.Set<Object> actions = new java.util.LinkedHashSet<>();

   static final String presentationModelName = "STAppPresentationModel";
   static final String appModelName = "AppModel";
   static final String stringType = "String";
   static final String awtDimensionType = "java.awt.Dimension";
   static final String integerType = "Integer";
   static final String jFrameType = "javax.swing.JFrame";

   // events
   static final String modelNavigatorStProjectTreeNodeClicked = "ModelNavigatorStProjectTreeNodeClicked";
   static final String modelNavigatorModelsTreeNodeClicked = "ModelNavigatorModelsTreeNodeClicked";
   static final String modelNavigatorStGroupTreeNodeClicked = "ModelNavigatorStGroupTreeNodeClicked";
   static final String modelNavigatorStTemplateTreeNodeClicked = "ModelNavigatorStTemplateTreeNodeClicked";
   static final String modelNavigatorStParameterTreeNodeClicked = "ModelNavigatorStParameterTreeNodeClicked";
   static final String modelNavigatorStModelTreeNodeClicked = "ModelNavigatorStModelTreeNodeClicked";
   static final String modelNavigatorStKVArgumentTreeNodeClicked = "ModelNavigatorStKVArgumentTreeNodeClicked";
   static final String modelNavigatorStValueTreeNodeClicked = "ModelNavigatorStValueTreeNodeClicked";

   static final String modelEditorStGroupTreeNodeClicked = "ModelEditorStGroupTreeNodeClicked";
   static final String modelEditorStTemplateTreeNodeClicked = "ModelEditorStTemplateTreeNodeClicked";
   static final String modelEditorStParameterTreeNodeClicked = "ModelEditorStParameterTreeNodeClicked";
   static final String modelEditorStModelTreeNodeClicked = "ModelEditorStModelTreeNodeClicked";
   static final String modelEditorStKVArgumentTreeNodeClicked = "ModelEditorStKVArgumentTreeNodeClicked";
   static final String modelEditorStValueTreeNodeClicked = "ModelEditorStValueTreeNodeClicked";

   static final String templateNavigatorSTGroupTreeNodeClicked = "TemplateNavigatorSTGroupTreeNodeClicked";
   static final String templateNavigatorSTEnumTreeNodeClicked = "TemplateNavigatorSTEnumTreeNodeClicked";
   static final String templateNavigatorSTInterfaceTreeNodeClicked = "TemplateNavigatorSTInterfaceTreeNodeClicked";
   static final String templateNavigatorSTTemplateTreeNodeClicked = "TemplateNavigatorSTTemplateTreeNodeClicked";
   static final String templateNavigatorSTParameterEditorTreeNodeClicked = "TemplateNavigatorSTParameterEditorTreeNodeClicked";

   static final String canvasSTModelClicked = "CanvasSTModelClicked";

   static final String openSTTemplate = "OpenSTTemplate";
   static final String openSTModel = "OpenSTModel";
   static final String stTemplateDeleted = "STTemplateDeleted";
   static final String stGroupDeleted = "STGroupDeleted";
   static final String stEnumDeleted = "STEnumDeleted";
   static final String stInterfaceDeleted = "STInterfaceDeleted";
   static final String kvDeleted = "KVDeleted";
   static final String stArgumentDeleted = "STArgumentDeleted";
   static final String stModelDeleted = "STModelDeleted";
   static final String stValueDeleted = "STValueDeleted";
   static final String stTemplateChildrenAdded = "STTemplateChildrenAdded";
   static final String stTemplateInterfaceRemoved = "STTemplateInterfaceRemoved";
   static final String stTemplateInterfacesChanged = "STTemplateInterfacesChanged";
   static final String stTemplateParameterTypesChanged = "STTemplateParameterTypesChanged";
   static final String stTemplateNameChanged = "STTemplateNameChanged";
   static final String stInterfaceNameChanged = "STInterfaceNameChanged";
   static final String stGroupNameChanged = "STGroupNameChanged";
   static final String stEnumNameChanged = "STEnumNameChanged";
   static final String stGroupTagsChanged = "STGroupTagsChanged";
   static final String stEnumChanged = "STEnumChanged";
   static final String stArgumentChanged = "STArgumentChanged";
   static final String stValueChanged = "STValueChanged";
   static final String newSTGroup = "NewSTGroup";
   static final String newSTProject = "NewSTProject";
   static final String newSTInterface = "NewSTInterface";
   static final String newSTEnum = "NewSTEnum";
   static final String newSTTemplateChild = "NewSTTemplateChild";
   static final String newSTGroupTemplate = "NewSTGroupTemplate";
   static final String newSTProjectSTModel = "NewSTProjectSTModel";
   static final String newSTModel = "NewSTModel";
   static final String newKV = "NewKV";
   static final String newSTKVArgument = "NewSTKVArgument";
   static final String newSTArgument = "NewSTArgument";

   static final PackageDeclaration corePackage = JavaPatterns.newPackageDeclaration("nextgen");
   static final PackageDeclaration stPackage = JavaPatterns.newPackageDeclaration(corePackage, "st");
   static final PackageDeclaration eventsPackage = JavaPatterns.newPackageDeclaration(corePackage, "events");
   static final PackageDeclaration canvasPackage = JavaPatterns.newPackageDeclaration(stPackage, "canvas");
   static final PackageDeclaration canvasLayoutPackage = JavaPatterns.newPackageDeclaration(canvasPackage, "layout");
   static final PackageDeclaration workflowPackage = JavaPatterns.newPackageDeclaration(corePackage, "workflow");
   static final PackageDeclaration swingPackage = JavaPatterns.newPackageDeclaration(corePackage, "swing");
   static final PackageDeclaration swingConfigPackage = JavaPatterns.newPackageDeclaration(swingPackage, "config");
   static final PackageDeclaration actionsPackage = JavaPatterns.newPackageDeclaration(corePackage, "actions");

   static final PackageDeclaration stModelPackage = JavaPatterns.newPackageDeclaration(stPackage, "model");
   static final nextgen.templates.java.ClassOrInterfaceType stArgumentType = newClassOrInterfaceType(stModelPackage, "STArgument");
   static final nextgen.templates.java.ClassOrInterfaceType stArgumentKVType = newClassOrInterfaceType(stModelPackage, "STArgumentKV");
   static final nextgen.templates.java.ClassOrInterfaceType stProjectType = newClassOrInterfaceType(stModelPackage, "STProject");
   static final nextgen.templates.java.ClassOrInterfaceType stModelType = newClassOrInterfaceType(stModelPackage, "STModel");
   static final nextgen.templates.java.ClassOrInterfaceType stValueType = newClassOrInterfaceType(stModelPackage, "STValue");
   static final nextgen.templates.java.ClassOrInterfaceType stFileType = newClassOrInterfaceType(stModelPackage, "STFile");

   static final PackageDeclaration stDomainPackage = JavaPatterns.newPackageDeclaration(stPackage, "domain");
   static final nextgen.templates.java.ClassOrInterfaceType stGroupModelType = newClassOrInterfaceType(stDomainPackage, "STGroupModel");
   static final nextgen.templates.java.ClassOrInterfaceType stTemplateType = newClassOrInterfaceType(stDomainPackage, "STTemplate");
   static final nextgen.templates.java.ClassOrInterfaceType stEnumType = newClassOrInterfaceType(stDomainPackage, "STEnum");
   static final nextgen.templates.java.ClassOrInterfaceType stInterfaceType = newClassOrInterfaceType(stDomainPackage, "STInterface");
   static final nextgen.templates.java.ClassOrInterfaceType stParameterType = newClassOrInterfaceType(stDomainPackage, "STParameter");
   static final nextgen.templates.java.ClassOrInterfaceType stParameterKeyType = newClassOrInterfaceType(stDomainPackage, "STParameterKey");

   static final nextgen.templates.java.ClassOrInterfaceType ownerType = newClassOrInterfaceType("javax.swing", "JComponent");

   static final String addArgumentFromArgumentType = "AddArgumentFromArgumentType";
   static final String addArgumentFromClipboard = "AddArgumentFromClipboard";
   static final String addArgumentFromInput = "AddArgumentFromInput";
   static final String addArgumentFromSTModel = "AddArgumentFromSTModel";
   static final String addArgumentFromSTModelUuid = "AddArgumentFromSTModelUuid";
   static final String addArgumentFromSTTemplate = "AddArgumentFromSTTemplate";
   static final String addArgumentFromSTValue = "AddArgumentFromSTValue";
   static final String addChildToTemplate = "AddChildToTemplate";
   static final String addChildrenToTemplate = "AddChildrenToTemplate";
   static final String addInterface = "AddInterface";
   static final String addKVArgument = "AddKVArgument";
   static final String addModelToProject = "AddModelToProject";
   static final String addMultipleArgumentsFromArgumentType = "AddMultipleArgumentsFromArgumentType";
   static final String addTemplateModelToProject = "AddTemplateModelToProject";
   static final String copyModel = "CopyModel";
   static final String deleteEnum = "DeleteEnum";
   static final String deleteKV = "DeleteKV";
   static final String deleteSTArgument = "DeleteSTArgument";
   static final String deleteSTGroup = "DeleteSTGroup";
   static final String deleteSTInterface = "DeleteSTInterface";
   static final String removeInterfaceFromSTTemplate = "RemoveInterfaceFromSTTemplate";
   static final String deleteSTModel = "DeleteSTModel";
   static final String deleteSTTemplate = "DeleteSTTemplate";
   static final String deleteSTValue = "DeleteSTValue";
   static final String editEnum = "EditEnum";
   static final String editModels = "EditModels";
   static final String editSTGroupTags = "EditSTGroupTags";
   static final String editSTModel = "EditSTModel";
   static final String generateAllProjectModels = "GenerateAllProjectModels";
   static final String generateAllSTGroups = "GenerateAllSTGroups";
   static final String generateSource = "GenerateSource";
   static final String generateSTGroup = "GenerateSTGroup";
   static final String importSTTemplate = "ImportSTTemplate";
   static final String newEnum = "NewEnum";
   static final String newInterface = "NewInterface";
   static final String newProject = "NewProject";
   static final String newSTTemplate = "NewSTTemplate";
   static final String openTemplate = "OpenTemplate";
   static final String renameEnum = "RenameEnum";
   static final String renameSTGroup = "RenameSTGroup";
   static final String renameSTInterface = "RenameSTInterface";
   static final String renameSTTemplate = "RenameSTTemplate";
   static final String setArgumentFromClipboard = "SetArgumentFromClipboard";
   static final String setArgumentFromInput = "SetArgumentFromInput";
   static final String setArgumentFromSTModel = "SetArgumentFromSTModel";
   static final String setArgumentFromSTModelUuid = "SetArgumentFromSTModelUuid";
   static final String setArgumentFromSTTemplate = "SetArgumentFromSTTemplate";
   static final String setArgumentFromSTValue = "SetArgumentFromSTValue";
   static final String setArgumentToTrue = "SetArgumentToTrue";
   static final String setInterfaces = "SetInterfaces";
   static final String setKVArgumentFromClipboard = "SetKVArgumentFromClipboard";
   static final String setKVArgumentFromInput = "SetKVArgumentFromInput";
   static final String setKVArgumentFromSTModel = "SetKVArgumentFromSTModel";
   static final String setKVArgumentFromSTValue = "SetKVArgumentFromSTValue";
   static final String setMultipleFields = "SetMultipleFields";
   static final String setSTValueFromClipboard = "SetSTValueFromClipboard";
   static final String setSTValueFromInput = "SetSTValueFromInput";
   static final String setTemplateParameterTypes = "SetTemplateParameterTypes";
   static final String stValueToClipboard = "STValueToClipboard";
   static final String stModelToClipboard = "STModelToClipboard";
   static final String undoDBTransaction = "UndoDBTransaction";
   static final String writeSTModelToFile = "WriteSTModelToFile";

   private final String workspace = "STWorkspace";
   private final String templateNavigator = "STTemplateNavigator";
   private final String modelNavigator = "STModelNavigator";
   private final String modelEditorNavigatorSTModelTreeNode = "STModelTreeNode";

   @org.junit.BeforeClass
   public static void init() {
      typesMap.put(presentationModelName, JavaPatterns.newClassOrInterfaceType(stPackage, presentationModelName));
      generateActions();
      generateEvents();
   }

   @org.junit.Test
   public void generateWorkspace() {

      final nextgen.templates.nextgen.STWorkspace stWorkspace = nextgen.templates.nextgen.NextgenST.newSTWorkspace()
            .setPackageName(stPackage.getName())
            .setName(workspace)
            .addFields(templateNavigator, "templateNavigator", null)
            .addFields(modelNavigator, "modelNavigator", null)
            .addConstructorParameters("findCanvas();")
            .addConstructorParameters("appModel().doInTransaction(transaction -> {\n" +
                  "	templateNavigator = new STTemplateNavigator(this);\n" +
                  "	modelNavigator = new STModelNavigator(this);\n" +
                  "});")
            .addConstructorParameters(nextgen.templates.GreenRobotPatterns.newRegister())
            .addMethods(newSubscribe(modelNavigatorStModelTreeNodeClicked).addStatements("getModelEditor(event.stTemplate, event.stModel);"))
            //.addMethods(newSubscribe(modelEditorStModelTreeNodeClicked).addStatements("getModelEditor(event.stTemplate, event.stModel);"))
            .addMethods(newSubscribe(templateNavigatorSTGroupTreeNodeClicked).addStatements("getSTEditor(event.stGroup);"))
            .addMethods(newSubscribe(templateNavigatorSTTemplateTreeNodeClicked).addStatements("getSTEditor(event.stGroup).setSTTemplate(event.stTemplate);"))
            .addMethods(newSubscribe(templateNavigatorSTEnumTreeNodeClicked).addStatements("getSTEditor(event.stGroup).setSTEnum(event.stEnum);"))
            .addMethods(newSubscribe(templateNavigatorSTInterfaceTreeNodeClicked).addStatements("getSTEditor(event.stGroup).setSTInterface(event.stInterface);"))
            .addMethods(newSubscribe(stModelDeleted).addStatements("SwingUtilities.invokeLater(() -> removeModelEditor(event.uuid));"))
            .addMethods(newSubscribe(stGroupDeleted).addStatements(""))
            .addMethods(newSubscribe(stEnumDeleted).addStatements(""))
            .addMethods(newSubscribe(stTemplateDeleted).addStatements(""))
            .addMethods(newSubscribe(stInterfaceDeleted).addStatements(""));

      nextgen.st.STGenerator.writeJavaFile(stWorkspace, stPackage, stWorkspace.getName(), mainJava);
   }

   @org.junit.Test
   public void generateSTTemplateNavigator() {

      final nextgen.templates.nextgen.TreeNode rootNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("RootNode")
            .setModelType("String")
            .setLabelExpression("getModel()")
            .addConstructorStatements("appModel().stGroups.forEach(stGroup -> add(new STGroupTreeNode(stGroup)));")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(newSTGroup, "tree")),
                  addToActionsStatement(newAction(generateAllSTGroups))
            });

      final nextgen.templates.nextgen.TreeNode stGroupTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STGroupTreeNode")
            .setModelType(stGroupModelType)
            .setHasUuid(true)
            .setLabelExpression("getModel().getName()")
            .addConstructorStatements("model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));\n" +
                  "model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));\n" +
                  "model.getInterfaces().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stInterface -> add(new STInterfaceTreeNode(stInterface)));")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(editSTGroupTags, "getModel()", "tree")),
                  addToActionsStatement(newAction(importSTTemplate, "getModel()", "tree")),
                  addToActionsStatement(newAction(generateSTGroup, "getModel()")),
                  addToActionsStatement(newAction(newSTTemplate, "getModel()", "tree")),
                  addToActionsStatement(newAction(newEnum, "getModel()", "tree")),
                  addToActionsStatement(newAction(newInterface, "getModel()", "tree")),
                  addToActionsStatement(newAction(renameSTGroup, "getModel()", "tree")),
                  addToActionsStatement(newAction(deleteSTGroup, "getModel()", "tree"))
            })
            .addSelectionStatements(postEvent(templateNavigatorSTGroupTreeNodeClicked, "selectedNode.getModel()"));

      final nextgen.templates.nextgen.TreeNode stEnumTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STEnumTreeNode")
            .setModelType(stEnumType)
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(\"sq-green\")")
            .setLabelExpression("getModel().getName()")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(editEnum, "getModel()", "tree")),
                  getParent(stGroupTreeNode, addToActions(newAction(renameEnum, "getModel()", "parent.getModel()", "tree"))),
                  getParent(stGroupTreeNode, addToActions(newAction(deleteEnum, "getModel()", "parent.getModel()", "tree")))
            })
            .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> { " + postEvent(templateNavigatorSTEnumTreeNodeClicked, "stGroupTreeNode.getModel()", "selectedNode.getModel()") + " });");

      final nextgen.templates.nextgen.TreeNode stTemplateTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STTemplateTreeNode")
            .setModelType(stTemplateType)
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("getModel().getName()")
            .addConstructorStatements("model.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));")
            .addMethods("private java.util.Set<nextgen.st.domain.STTemplate> getSelectedTemplates() {\n" +
                  "\treturn getSelectedSTTemplateTreeNodes()\n" +
                  "\t\t\t.filter(stTemplateTreeNode -> !stTemplateTreeNode.equals(this))\n" +
                  "\t\t\t.map(nextgen.st.STTemplateNavigator.BaseTreeNode::getModel)\n" +
                  "\t\t\t.collect(java.util.stream.Collectors.toSet());\n" +
                  "}")
            .setGetActionsStatements(new Object[]{
                  "final java.util.Set<STTemplate> candidateChildren = getSelectedTemplates();",
                  "final Set<nextgen.st.domain.STTemplate> childTemplates = getModel().getChildren().collect(java.util.stream.Collectors.toSet());",
                  addToActionsStatement(newAction(newSTModel, "getModel()")),
                  getParent(stGroupTreeNode, newBlockStmt(new Object[]{
                        addToActions(newAction(newSTTemplateChild, "getModel()", "parent.getModel()", "tree")),
                        addToActions(newAction(setTemplateParameterTypes, "parent.getModel()", "getModel()", "tree")),
                        "if (!candidateChildren.isEmpty()) " + addToActionsStatement(newAction(addChildrenToTemplate, "\"Add \" + candidateChildren.size() + \" templates as children\"", "parent.getModel()", "getModel()", "candidateChildren", "tree")),
                        "appModel().getProjects().forEach(stProject -> { " + addToActions(newAction(addTemplateModelToProject, "\"Add to \" + stProject.getName()", "getModel()", "stProject")) + " });",
                        "if (!childTemplates.isEmpty()) " + addToActionsStatement(newAction(addInterface, "\"Add interfaces to children\"", "childTemplates", "tree")),
                        addToActionsStatement(newAction(setInterfaces, "parent.getModel()", "getModel()", "tree")),
                        "getModel().getImplements().forEach(implement -> { " + addToActions(newAction(removeInterfaceFromSTTemplate, "\"Remove \" + implement", "parent.getModel()", "getModel()", "implement", "tree")) + " });",
                        addToActionsStatement(newAction(deleteSTTemplate, "getModel()", "parent.getModel()", "tree")),
                  })),
            })
            .addSelectionStatements(getParent("selectedNode", stGroupTreeNode, newBlockStmt(new Object[]{
                  "final nextgen.st.STTemplateNavigator.STTemplateTreeNode stTemplateTreeNode = selectedNode.getParentNode(nextgen.st.STTemplateNavigator.STTemplateTreeNode.class).orElse(null);",
                  "nextgen.events.TemplateNavigatorSTTemplateTreeNodeClicked.post(parent.getModel(), stTemplateTreeNode == null ? null : stTemplateTreeNode.getModel(), selectedNode.getModel());"
            })));

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
            .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> nextgen.events.TemplateNavigatorSTInterfaceTreeNodeClicked.post(stGroupTreeNode.getModel(), selectedNode.getModel()));");

      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
            .setPackageName("nextgen.st")
            .addImports("nextgen.swing.AppModel")
            .addImports("nextgen.st.domain.*")
            .setName(templateNavigator)
            .addFields(workspace, "workspace")
            .setRootNodeExpression("new RootNode(\"Templates\")")
            .setPreferredWidth("600")
            .setPreferredHeight("500")
            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode())
            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
            .addTreeNodes(rootNode)
            .addTreeNodes(stGroupTreeNode)
            .addTreeNodes(stEnumTreeNode)
            .addTreeNodes(stTemplateTreeNode)
            .addTreeNodes(stInterfaceTreeNode)
            .addTreeNodesSelected(stGroupTreeNode.getName())
            .addTreeNodesSelected(stEnumTreeNode.getName())
            .addTreeNodesSelected(stTemplateTreeNode.getName())
            .addTreeNodesSelected(stInterfaceTreeNode.getName())
            .addMethods(newSubscribe(modelNavigatorStModelTreeNodeClicked)
                  .addStatements("findSTTemplateTreeNode(stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(event.stTemplate)).ifPresent(treeModel::select);"))
            .addMethods(newSubscribe(stGroupDeleted)
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addMethods(newSubscribe(stEnumDeleted)
                  .addStatements("findSTEnumTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addMethods(newSubscribe(stTemplateDeleted)
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addMethods(newSubscribe(stInterfaceDeleted)
                  .addStatements("findSTInterfaceTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addMethods(newSubscribe(newSTGroup)
                  .addStatements("treeModel.addNodeInSortedOrderAndSelect((RootNode) treeModel.getRoot(), new nextgen.st.STTemplateNavigator.STGroupTreeNode(event.group));"))
            .addMethods(newSubscribe(newSTGroupTemplate)
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.parent))\n" +
                        "\t\t\t.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));"))
            .addMethods(newSubscribe(newSTTemplateChild)
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.parent))\n" +
                        "\t\t\t.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));"))
            .addMethods(newSubscribe(stGroupNameChanged)
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "\t\t\t.ifPresent(nextgen.st.STTemplateNavigator.STGroupTreeNode::nodeChanged);"))
            .addMethods(newSubscribe(stTemplateNameChanged)
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate))\n" +
                        "\t\t\t.ifPresent(nextgen.st.STTemplateNavigator.STTemplateTreeNode::nodeChanged);"))
            .addMethods(newSubscribe(stInterfaceNameChanged)
                  .addStatements("findSTInterfaceTreeNode(treeNode -> treeNode.getModel().equals(event.stInterface))\n" +
                        "\t\t\t.ifPresent(STTemplateNavigator.STInterfaceTreeNode::nodeChanged);"))
            .addMethods(newSubscribe(stEnumNameChanged)
                  .addStatements("findSTEnumTreeNode(treeNode -> treeNode.getModel().equals(event.stEnum))\n" +
                        "\t\t\t.ifPresent(STTemplateNavigator.STEnumTreeNode::nodeChanged);"));

      nextgen.st.STGenerator.writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
   }

   @org.junit.Test
   public void generateSTModelNavigator() {

      final nextgen.templates.nextgen.TreeNode stProjectTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STProjectTreeNode")
            .setModelType(stProjectType)
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
            .addSelectionStatements("nextgen.events.ModelNavigatorStProjectTreeNodeClicked.post(selectedNode.getModel());");
//            .setGetActionsStatements(new Object[]{
//                  "getSelectedSTModelTreeNodes().forEach(stModelTreeNode -> actions.add(new nextgen.actions.AddModelToProject(\"Add \" + stModelTreeNode.getLabel(), getModel(), stModelTreeNode.getModel())));",
//                  "actions.add(new nextgen.actions.GenerateAllProjectModels(getModel()));"
//            });

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
                  "}")
            .addSelectionStatements("");

      final nextgen.templates.nextgen.TreeNode stValueTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STValueTreeNode")
            .setModelType(stValueType)
            .setHasUuid(true)
            .addFields(stArgumentType, "stArgument")
            .setIcon("appModel().loadIcon(\"sq-orange\")")
            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
            .setTooltipExpression("appModel().tooltip(getModel());")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(stValueToClipboard, "getModel()")),
                  addToActionsStatement(newAction(setSTValueFromClipboard, "getModel()")),
                  addToActionsStatement(newAction(deleteSTValue, "getModel()", "tree"))
            })
            .addSelectionStatements("");

      final nextgen.templates.nextgen.TreeNode rootNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("RootNode")
            .setModelType("String")
            .setLabelExpression("getModel()")
            .addConstructorStatements("appModel().doInTransaction(transaction -> {\n" +
                  "	appModel().getProjects().forEach(stProject -> add(new STProjectTreeNode(stProject)));\n" +
                  "	add(new nextgen.st.STModelNavigator.ModelsTreeNode(\"Models\"));\n" +
                  "});")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(newProject, "tree")),
                  addToActionsStatement(newAction(undoDBTransaction))
            })
            .addSelectionStatements("");

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
                  "}")
            .addSelectionStatements("");

      final nextgen.templates.nextgen.TreeNode stTemplateTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STTemplateTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.domain")
                  .setName("STTemplate"))
            .setHasUuid(true)
            .setLabelExpression("getModel().getName()")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(newSTModel, "getModel()")),
                  addToActionsStatement(newAction(editModels, "getModel()"))
            })
            .addSelectionStatements("");

      final nextgen.templates.nextgen.TreeNode stModelTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STModelTreeNode")
            .setModelType(nextgen.templates.java.JavaST.newJavaType()
                  .setPackageName("nextgen.st.model")
                  .setName("STModel"))
            .setHasUuid(true)
            .addFields("nextgen.st.domain.STTemplate", "stTemplate")
            .addFields(stArgumentType, "stArgument")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> appModel().render(getModel(), 10))")
            .setTooltipExpression("appModel().tooltip(getModel());")
            .addConstructorStatements("stTemplate.getParameters()\n" +
                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(openSTModel, "getModel()")),
                  addToActionsStatement(newAction(generateSource, "getModel()")),
                  addToActionsStatement(newAction(writeSTModelToFile, "getModel()")),
                  addToActionsStatement(newAction(deleteSTModel, "getModel()", "tree"))
            })
            .addSelectionStatements(postEvent(modelNavigatorStModelTreeNodeClicked, "appModel().findSTTemplate(selectedNode.getModel())", "selectedNode.getModel()"));

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
                  "			.onKVListConsumer((stArgument, stKVValues) -> add(new STKVArgumentTreeNode(stArgument, model))));")
            .addSelectionStatements("");

      final nextgen.templates.nextgen.TreeNode stKVArgumentTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STKVArgumentTreeNode")
            .setModelType(stArgumentType)
            .addFields(stParameterType, "stParameter")
            .addSelectionStatements("");

//      final nextgen.templates.nextgen.EventSubscriber stArgumentAdded = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
//            .setEventName("STArgumentAdded")
//            .setEventType(nextgen.templates.java.JavaST.newJavaType()
//                  .setPackageName("nextgen.events")
//                  .setName(newSTArgument))
//            .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel))\n" +
//                  "			.ifPresent(stModelTreeNode -> findSTParameterTreeNode(stModelTreeNode, stParameterTreeNode -> stParameterTreeNode.getModel().getUuid().equals(event.stArgument.getStParameter()))\n" +
//                  "					.ifPresent(stParameterTreeNode -> {\n" +
//                  "						appModel().stArgumentConsumer(event.stParameter)\n" +
//                  "									 .onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STValueTreeNode(stValue, event.stArgument)))\n" +
//                  "									 .onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))\n" +
//                  "									 .onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STValueTreeNode(stValue, event.stArgument)))\n" +
//                  "									 .onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))\n" +
//                  "									 .onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new STKVArgumentTreeNode(event.stArgument, event.stParameter)));\n" +
//                  "						stModelTreeNode.nodeChanged();\n" +
//                  "					}));");

//      final nextgen.templates.greenrobot.Subscribe stProjectSTModel = newSubscribe()
//            .setEventName("STProjectSTModel")
//            .setEventType("nextgen.events.NewSTProjectSTModel")
//            .addStatements("findSTProjectTreeNode(stProjectTreeNode -> stProjectTreeNode.getModel().equals(event.stProject))\n" +
//                  "		.ifPresent(stProjectTreeNode -> {\n" +
//                  "\n" +
//                  "			final nextgen.st.domain.STTemplate stTemplate = appModel().findSTTemplateByUuid(event.stModel.getStTemplate());\n" +
//                  "			final nextgen.st.domain.STGroupModel stGroup = appModel().findSTGroup(stTemplate);\n" +
//                  "\n" +
//                  "			final nextgen.st.STModelNavigator.STGroupModelTreeNode groupModelTreeNode = treeModel\n" +
//                  "					.find(stProjectTreeNode, nextgen.st.STModelNavigator.STGroupModelTreeNode.class, treeNode -> treeNode.getModel().equals(stGroup))\n" +
//                  "					.orElseGet(() -> {\n" +
//                  "						final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroup);\n" +
//                  "						treeModel.addNodeInSortedOrder(stProjectTreeNode, stGroupModelTreeNode);\n" +
//                  "						return stGroupModelTreeNode;\n" +
//                  "					});\n" +
//                  "\n" +
//                  "			final nextgen.st.STModelNavigator.STTemplateTreeNode templateTreeNode = findSTTemplateTreeNode(groupModelTreeNode, stTemplateTreeNode -> stTemplateTreeNode\n" +
//                  "					.getModel().equals(stTemplate))\n" +
//                  "					.orElseGet(() -> {\n" +
//                  "						final nextgen.st.STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);\n" +
//                  "						treeModel.addNodeInSortedOrder(groupModelTreeNode, stTemplateTreeNode);\n" +
//                  "						return stTemplateTreeNode;\n" +
//                  "					});\n" +
//                  "\n" +
//                  "			treeModel.addNodeInSortedOrderAndSelect(templateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.stModel, stTemplate, null));\n" +
//                  "		});");
//
//      final nextgen.templates.greenrobot.Subscribe stModelDeleted = newSubscribe()
//            .setEventName(this.stModelDeleted)
//            .setEventType("nextgen.events.STModelDeleted")
//            .addStatements("findModelsTreeNode(modelsTreeNode -> true)\n" +
//                  "		.flatMap(modelsTreeNode -> findSTModelTreeNode(stModelTreeNode -> stModelTreeNode.uuid.equals(event.uuid))\n" +
//                  "				.filter(treeNode -> treeNode.getParent() != null)).ifPresent(treeModel::removeNodeFromParent);\n" +
//                  "\n" +
//                  "findSTModelTreeNode(stModelTreeNode -> stModelTreeNode.uuid.equals(event.uuid))\n" +
//                  "		.filter(treeNode -> treeNode.getParent() != null)\n" +
//                  "		.ifPresent(treeModel::removeNodeFromParent);");
//
//      final nextgen.templates.nextgen.EventSubscriber stModelCanvasNodeClicked = nextgen.templates.nextgen.NextgenST.newEventSubscriber()
//            .setEventName("STModelCanvasNodeClicked")
//            .setEventType("nextgen.events.CanvasSTModelClicked")
//            .addStatements("SwingUtilities.invokeLater(() -> {\n" +
//                  "	final RootNode rootNode = (RootNode) treeModel.getRoot();\n" +
//                  "	final TreePath path = rootNode.find(baseTreeNode -> isSTModelTreeNode(baseTreeNode) && ((STModelTreeNode) baseTreeNode).getModel().equals(event.model));\n" +
//                  "	if (path != null) {\n" +
//                  "		tree.scrollPathToVisible(path);\n" +
//                  "		tree.setSelectionPath(path);\n" +
//                  "	}\n" +
//                  "});");

      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
            .setPackageName(stPackage.getName())
            .setName(modelNavigator)
            .addFields(workspace, "workspace")
            .setRootNodeExpression("new RootNode(\"Projects\")")
            .setPreferredWidth("600")
            .setPreferredHeight("1200")
//            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode())
            .addTreeNodes(rootNode)
            .addTreeNodes(stProjectTreeNode)
            .addTreeNodes(modelsTreeNode)
            .addTreeNodes(stGroupTreeNode)
            .addTreeNodes(stTemplateTreeNode)
            .addTreeNodes(stParameterTreeNode)
            .addTreeNodes(stModelTreeNode)
            .addTreeNodes(stKVArgumentTreeNode)
            .addTreeNodes(stValueTreeNode)
            .addTreeNodesSelected(rootNode.getName())
            .addTreeNodesSelected(stProjectTreeNode.getName())
            .addTreeNodesSelected(modelsTreeNode.getName())
            .addTreeNodesSelected(stGroupTreeNode.getName())
            .addTreeNodesSelected(stTemplateTreeNode.getName())
            .addTreeNodesSelected(stParameterTreeNode.getName())
            .addTreeNodesSelected(stModelTreeNode.getName())
            .addTreeNodesSelected(stKVArgumentTreeNode.getName())
            .addTreeNodesSelected(stValueTreeNode.getName())
//            .addMethods(newSTProject)
//            .addMethods(stArgumentAdded)
//            .addMethods(stProjectSTModel)
//            .addMethods(stModelDeleted)
//            .addMethods(stModelCanvasNodeClicked)
            ;

      nextgen.st.STGenerator.writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
   }

   @org.junit.Test
   public void generateSTModelEditorNavigator() {

      final nextgen.templates.nextgen.TreeNode stModelTreeNode = getModelEditorNavigatorSTModelTreeNode();
      final nextgen.templates.nextgen.TreeNode stKVArgumentTreeNode = getStKVArgumentTreeNode();
      final nextgen.templates.nextgen.TreeNode stKVTreeNode = getStKVTreeNode();
      final nextgen.templates.nextgen.TreeNode stModelArgumentTreeNode = getStModelArgumentTreeNode();
      final nextgen.templates.nextgen.TreeNode stValueArgumentTreeNode = getStValueArgumentTreeNode();
      final nextgen.templates.nextgen.TreeNode stModelKVArgumentTreeNode = getStModelKVArgumentTreeNode();
      final nextgen.templates.nextgen.TreeNode stValueKVArgumentTreeNode = getStValueKVArgumentTreeNode();
      final nextgen.templates.nextgen.TreeNode stParameterTreeNode = getStParameterTreeNode();

      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
            .setPackageName(stPackage.getName())
            .addImports("nextgen.st.model.*")
            .addImports("nextgen.st.domain.*")
            .setName("STModelEditorNavigator")
            .addFields(stModelType, "model")
            .addFields("STModelEditor", "editor")
            .setRootNodeExpression("new STModelTreeNode(model)")
            .setPreferredWidth("600")
            .setPreferredHeight("600")
            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode())
            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
            .addTreeNodes(stModelTreeNode)
            .addTreeNodes(stKVArgumentTreeNode)
            .addTreeNodes(stKVTreeNode)
            .addTreeNodes(stParameterTreeNode)
            .addTreeNodes(stModelArgumentTreeNode)
            .addTreeNodes(stValueArgumentTreeNode)
            .addTreeNodes(stModelKVArgumentTreeNode)
            .addTreeNodes(stValueKVArgumentTreeNode)

            .addTreeNodesSelected(stModelTreeNode.getName())
            .addTreeNodesSelected(stKVArgumentTreeNode.getName())
            .addTreeNodesSelected(stKVTreeNode.getName())
            .addTreeNodesSelected(stParameterTreeNode.getName())
            .addTreeNodesSelected(stModelArgumentTreeNode.getName())
            .addTreeNodesSelected(stValueArgumentTreeNode.getName())
            .addTreeNodesSelected(stModelKVArgumentTreeNode.getName())
            .addTreeNodesSelected(stValueKVArgumentTreeNode.getName())

            .addEvents(newSubscribe(modelEditorStModelTreeNodeClicked)
                  .addStatements(""))
            .addEvents(newSubscribe(modelEditorStValueTreeNodeClicked)
                  .addStatements(""))
            .addEvents(newSubscribe(kvDeleted)
                  .addStatements("findSTKVTreeNode(stkvTreeNode -> stkvTreeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(stArgumentDeleted)
                  .addStatements("findSTValueArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "findSTModelArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(stValueDeleted)
                  .addStatements("findSTValueArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "findSTValueKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(newSTArgument)
                  .addStatements("findSTParameterTreeNode(stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.parameter))\n" +
                        "      .ifPresent(stParameterTreeNode -> {\n" +
                        "         switch (event.value.getType()) {\n" +
                        "            case STMODEL:\n" +
                        "               treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STModelArgumentTreeNode(event.value.getStModel(), event.argument));\n" +
                        "               break;\n" +
                        "            case PRIMITIVE:\n" +
                        "               treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelEditorNavigator.STValueArgumentTreeNode(event.value, event.argument));\n" +
                        "               break;\n" +
                        "            case ENUM:\n" +
                        "               break;\n" +
                        "         }\n" +
                        "      });"));

      nextgen.st.STGenerator.writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
   }

   public nextgen.templates.nextgen.TreeNode getStParameterTreeNode() {
      return nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STParameterTreeNode")
            .setModelType(stParameterType)
            .setHasUuid(true)
            .addFields("STModel", "stModel")
            .setLabelExpression("getModel().getName()")
            .addConstructorStatements("stModel.getArgumentsSorted()\n" +
                  "	.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))\n" +
                  "	.forEach(appModel().stArgumentConsumer(model)\n" +
                  "			.onSingleSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))\n" +
                  "			.onSingleSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" +
                  "			.onListSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))\n" +
                  "			.onListSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(),  stArgument)))\n" +
                  "			.onKVListConsumer((stArgument, stKVValues) -> addChild(new STKVArgumentTreeNode(stArgument, model))));")
            .setGetActionsStatements(new Object[]{
                  "final String fromClipboard = nextgen.utils.SwingUtil.fromClipboard();",
                  "switch (getModel().getType()) {" +
                        "\n\tcase SINGLE:" +
                        "\n\t\t" + addToActionsStatement(newAction(setArgumentFromInput, "stModel", "getModel()", "tree")) +
                        "\n\t\t" + addToActionsStatement(newAction(setArgumentFromClipboard, "stModel", "getModel()")) +
                        "\n\t\t" + "if (appModel().isBoolean(getModel())) " + addToActionsStatement(newAction(setArgumentToTrue, "stModel", "getModel()")) +
                        "\n\t\tbreak;" +
                        "\n\tcase LIST:" +
                        "\n\t\t" + addToActionsStatement(newAction(addArgumentFromInput, "stModel", "getModel()", "tree")) +
                        "\n\t\t" + addToActionsStatement(newAction(addArgumentFromClipboard, "stModel", "getModel()")) +
                        "\n\t\t" + addToActionsStatement(newAction(addArgumentFromArgumentType, "stModel", "getModel()", "tree")) +
                        "\n\t\tbreak;" +
                        "\n\tcase KVLIST:" +
                        "\n\t\t" + addToActionsStatement(newAction(addKVArgument, "stModel", "getModel()", "tree")) +
                        "\n\t\tbreak;" +
                        "\n}"

            })
//            .setGetActionsStatements(new Object[]{
//                  "appModel().doInTransaction(tx -> {",
//                  "	switch (getModel().getType()) {",
//                  "		case SINGLE:",
//                  "",
//                  "			getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(stValueTreeNode.getModel(), 30), stModel, getModel(), stValueTreeNode.getModel())));",
//                  "			actions.add(new nextgen.actions.SetArgumentFromInput(stModel, getModel(), tree));",
//                  "			appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
//                  "			appModel().getSelectedSTModels().forEach(selectedValue -> actions.add(new nextgen.actions.SetArgumentFromSTModel(\"Set \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
//                  "",
//                  "			if (fromClipboard != null && fromClipboard.startsWith(\"stmodel-\"))",
//                  "				actions.add(new nextgen.actions.SetArgumentFromSTModelUuid(\"Set STModel \" + fromClipboard.substring(8), stModel, getModel(), fromClipboard.substring(8)));",
//                  "			else if (fromClipboard != null && fromClipboard.trim().length() !=0)",
//                  "				actions.add(new nextgen.actions.SetArgumentFromClipboard(stModel, getModel()));",
//                  "",
//                  "			if (getModel().getName().startsWith(\"is\") || getModel().getName().startsWith(\"has\"))",
//                  "				actions.add(new nextgen.actions.SetArgumentToTrue(stModel, getModel()));",
//                  "",
//                  "			break;",
//                  "",
//                  "		case LIST:",
//                  "",
//                  "			getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(stValueTreeNode.getModel(), 30), stModel, getModel(), stValueTreeNode.getModel())));",
//                  "			appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
//                  "			appModel().getSelectedSTModels().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTModel(\"Add \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
//                  "			appModel().getSelectedSTTemplates().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTTemplate(\"Add new \" + selectedValue.getName(), stModel, getModel(), selectedValue)));",
//                  "",
//                  "			if (fromClipboard != null && fromClipboard.startsWith(\"stmodel-\"))",
//                  "				actions.add(new nextgen.actions.AddArgumentFromSTModelUuid(\"Set STModel \" + fromClipboard.substring(8), stModel, getModel(), fromClipboard.substring(8)));",
//                  "			else if (fromClipboard != null && fromClipboard.trim().length() !=0)",
//                  "				actions.add(new nextgen.actions.AddArgumentFromClipboard(stModel, getModel()));",
//                  "",
//                  "			actions.add(new nextgen.actions.AddArgumentFromArgumentType(stModel, getModel(), tree));",
//                  "			actions.add(new nextgen.actions.AddMultipleArgumentsFromArgumentType(\"Add\", stModel, getModel(), tree));",
//                  "",
//                  "			break;",
//                  "",
//                  "		case KVLIST:",
//                  "",
//                  "			actions.add(new nextgen.actions.AddKVArgument(stModel, getModel(), tree));",
//                  "",
//                  "			break;",
//                  "	}",
//                  "});"
//            })
            .addSelectionStatements(getParent("selectedNode", modelEditorNavigatorSTModelTreeNode, postEventExpression(modelEditorStParameterTreeNodeClicked, "selectedNode.getModel()", "treeNode.getModel()")))
            .addSelectionStatements("selectedNode.getParentNode(nextgen.st.STModelEditorNavigator.STModelTreeNode.class)\n" +
                  "		.ifPresent(treeNode -> nextgen.events.ModelEditorStParameterTreeNodeClicked.post(selectedNode.getModel(), treeNode.getModel()));");
   }

   public nextgen.templates.nextgen.TreeNode getStValueArgumentTreeNode() {
      return nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STValueArgumentTreeNode")
            .setModelType(stValueType)
            .addFields(stArgumentType, "stArgument")
            .addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()")
            .setIcon("appModel().loadIcon(\"sq-orange\")")
            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
            .setHasUuid(true)
            .addGetActionsStatements("actions.add(new nextgen.actions.STValueToClipboard(getModel()));\n" +
                  "actions.add(new nextgen.actions.DeleteSTArgument(stArgument, tree));");
   }

   public nextgen.templates.nextgen.TreeNode getStValueKVArgumentTreeNode() {
      return nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STValueKVArgumentTreeNode")
            .setModelType(stValueType)
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .setIcon("appModel().loadIcon(\"sq-orange\")")
            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
            .setHasUuid(true)
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(deleteSTArgument, "stArgument", "tree"))
            });
   }

   public nextgen.templates.nextgen.TreeNode getStModelArgumentTreeNode() {
      return nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STModelArgumentTreeNode")
            .setModelType(stModelType)
            .setHasUuid(true)
            .addFields(stArgumentType, "stArgument")
            .addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()")
            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
            .addSelectionStatements(postEvent(modelEditorStModelTreeNodeClicked, "selectedNode.stTemplate", "selectedNode.getModel()"))
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(deleteSTArgument, "stArgument", "tree"))
            });
   }

   public nextgen.templates.nextgen.TreeNode getStModelKVArgumentTreeNode() {
      return nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STModelKVArgumentTreeNode")
            .setModelType(stModelType)
            .addFields(stArgumentType, "stArgument")
            .addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()")
            .addFields(stParameterKeyType, "stParameterKey")
            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stParameterKey.getName() + \"]\")")
            .addSelectionStatements("nextgen.events.ModelEditorStModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());")
            .setHasUuid(true);
   }

   public nextgen.templates.nextgen.TreeNode getStKVTreeNode() {
      return nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STKVTreeNode")
            .setModelType(stArgumentKVType)
            .setHasUuid(true)
            .addFields("STArgument", "stArgument")
            .addFields("STParameterKey", "stParameterKey")
            .setLabelExpression("stParameterKey.getName()")
            .addConstructorStatements("final STValue stValue = model.getValue();\n" +
                  "if (stValue != null)\n" +
                  "	switch (stValue.getType()) {\n" +
                  "		case STMODEL:\n" +
                  "			add(new STModelKVArgumentTreeNode(stValue.getStModel(), stArgument, stParameterKey));\n" +
                  "			break;\n" +
                  "		case PRIMITIVE:\n" +
                  "			add(new STValueKVArgumentTreeNode(stValue, stArgument, stParameterKey));\n" +
                  "			break;\n" +
                  "		case ENUM:\n" +
                  "			break;\n" +
                  "	}");

      //            .setGetActionsStatements(new Object[]{
//                  "appModel().doInTransaction(transaction -> {",
//                  "	getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.SetKVArgumentFromSTValue(\"Set \" + appModel().render(stValueTreeNode.getModel(), 30), stArgument, stParameterKey, stValueTreeNode.getModel())));",
//                  "	appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.SetKVArgumentFromSTValue(\"Set \" + appModel().render(selectedValue, 30), stArgument, stParameterKey, selectedValue)));",
//                  "	appModel().getSelectedSTModels().forEach(selectedModel -> actions.add(new nextgen.actions.SetKVArgumentFromSTModel(\"Set \" + appModel().render(selectedModel, 30), stArgument, stParameterKey, selectedModel)));",
//                  "	actions.add(new nextgen.actions.SetKVArgumentFromInput(\"Set from input\", stArgument, stParameterKey, tree));",
//                  "	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(\"Set from Clipboard\", stArgument, stParameterKey));",
//                  "});",
//                  "actions.add(new nextgen.actions.DeleteKV(getModel(), tree));"
//            })
   }

   public nextgen.templates.nextgen.TreeNode getStKVArgumentTreeNode() {
      return nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STKVArgumentTreeNode")
            .setModelType(stArgumentType)
            .addFields("STParameter", "stParameter")
            .setLabelExpression("appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, \"name\", stParameter::getName)")
            .addConstructorStatements("stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()\n" +
                  "		.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                  "		.findFirst()\n" +
                  "		.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));");

      //            .setGetActionsStatements(new Object[]{
//                  "appModel().doInTransaction(transaction -> stParameter.getKeys().forEach(stParameterKey -> {",
//                  "	actions.add(new nextgen.actions.SetKVArgumentFromInput(\"Set \" + stParameterKey.getName() + \" from input\", getModel(), stParameterKey, tree));",
//                  "	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(\"Set \" + stParameterKey.getName() + \" from Clipboard\", getModel(), stParameterKey));",
//                  "}));",
//                  "actions.add(new nextgen.actions.DeleteSTArgument(getModel(), tree));"
//            })
   }


   public nextgen.templates.nextgen.TreeNode getModelEditorNavigatorSTModelTreeNode() {
      return nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName(modelEditorNavigatorSTModelTreeNode)
            .setModelType(stModelType)
            .setHasUuid(true)
            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate());")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
            .addSelectionStatements("nextgen.events.ModelEditorStModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());")
            .addConstructorStatements("stTemplate.getParameters()\n" +
                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
            .setGetActionsStatements(new Object[]{
                  "actions.add(new nextgen.actions.CopyModel(getModel()));",
                  "actions.add(new nextgen.actions.OpenSTModel(getModel()));",
                  "actions.add(new nextgen.actions.VisitModel(getModel()));",
                  "actions.add(new nextgen.actions.WriteSTModelToFile(getModel()));",
                  "actions.add(new nextgen.actions.EditSTModel(getModel()));"});
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
            .setModelType(stArgumentType)
            .addFields(stParameterType, "stParameter")
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
                  "			//stValueNodes.forEach(stNode -> stParameterMenu.add(new nextgen.actions.SetKVArgumentFromSTValue(\"Set \" + appModel().render(stNode.getModel(), 30), getModel(), stParameterKey, stNode.getModel())));\n" +
                  "			//stModelNodes.forEach(stNode -> stParameterMenu.add(new nextgen.actions.SetKVArgumentFromSTModel(\"Set \" + appModel().render(stNode.getModel(), 30), getModel(), stParameterKey, stNode.getModel())));\n" +
                  "			//stParameterMenu.add(new nextgen.actions.SetKVArgumentFromInput(\"Set from Input\", getModel(), stParameterKey, thisCanvas()));\n" +
                  "			//stParameterMenu.add(new nextgen.actions.SetKVArgumentFromClipboard(\"Set from Clipboard\", getModel(), stParameterKey));\n" +
                  "			getModel().getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid())).filter(stArgumentKV -> stArgumentKV.getValue() != null).forEach(stArgumentKV -> {\n" +
                  "					//stParameterMenu.add(new nextgen.actions.OpenArgument(event, getModel(), stParameterKey, stArgumentKV));\n" +
                  "					//stParameterMenu.add(new nextgen.actions.DeleteSTArgument(event, getModel(), stArgumentKV));\n" +
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
                  .addFields(stArgumentType, "stArgument")
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
                  .addFields(stArgumentType, "stArgument")
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
                  .addFields(stArgumentType, "stArgument")
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
                  .addFields(stArgumentType, "stArgument")
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
                  "				addstParameterMenu.add(new nextgen.actions.SetArgumentFromInput(getModel(), stParameter, thisCanvas()));\n" +
                  "				addstParameterMenu.add(new nextgen.actions.SetArgumentToTrue(getModel(), stParameter));\n" +
                  "				addstParameterMenu.add(new nextgen.actions.SetArgumentFromClipboard(getModel(), stParameter));\n" +
                  "\n" +
                  "				final JMenu openstParameterMenu = new JMenu(\"Open\");\n" +
                  "				stParameterMenu.add(openstParameterMenu);\n" +
                  "\n" +
                  "				final JMenu removestParameterMenu = new JMenu(\"Remove\");\n" +
                  "				stParameterMenu.add(removestParameterMenu);\n" +
                  "\n" +
                  "				getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {\n" +
                  "					openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));\n" +
                  "					removestParameterMenu.add(new nextgen.actions.DeleteSTArgument(stArgument, thisCanvas()));\n" +
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
                  "				addstParameterMenu.add(new nextgen.actions.AddArgumentFromInput(getModel(), stParameter, thisCanvas()));\n" +
                  "				addstParameterMenu.add(new nextgen.actions.AddArgumentFromClipboard(getModel(), stParameter));\n" +
                  "\n" +
                  "				final JMenu openstParameterMenu = new JMenu(\"Open\");\n" +
                  "				stParameterMenu.add(openstParameterMenu);\n" +
                  "\n" +
                  "				final JMenu removestParameterMenu = new JMenu(\"Remove\");\n" +
                  "				stParameterMenu.add(removestParameterMenu);\n" +
                  "\n" +
                  "				getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {\n" +
                  "					openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));\n" +
                  "					removestParameterMenu.add(new nextgen.actions.DeleteSTArgument(stArgument, thisCanvas()));\n" +
                  "				});\n" +
                  "				break;\n" +
                  "			}\n" +
                  "			case KVLIST: {\n" +
                  "				final JMenu addstParameterMenu = new JMenu(\"Add\");\n" +
                  "				stParameterMenu.add(addstParameterMenu);\n" +
                  "				addstParameterMenu.add(new nextgen.actions.AddKVArgument(getModel(), stParameter, thisCanvas()));\n" +
                  "\n" +
                  "				final JMenu openstParameterMenu = new JMenu(\"Open\");\n" +
                  "				stParameterMenu.add(openstParameterMenu);\n" +
                  "\n" +
                  "				final JMenu removestParameterMenu = new JMenu(\"Remove\");\n" +
                  "				stParameterMenu.add(removestParameterMenu);\n" +
                  "\n" +
                  "				getModel().getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid())).forEach(stArgument -> {\n" +
                  "					openstParameterMenu.add(new OpenArgument(event, true, stParameter, stArgument));\n" +
                  "					removestParameterMenu.add(new nextgen.actions.DeleteSTArgument(stArgument, thisCanvas()));\n" +
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
//            .addRightClickActions("WriteToFile")
            .addLeftClickStatements("appModel().doLaterInTransaction(tx -> setText(stTemplate.getName() + \" : \\n\" + appModel().render(getModel())));\n" +
                  "nextgen.events.CanvasSTModelClicked.post(getModel());")
//            .addKeyPressActions("D", "Delete")
//            .addKeyPressActions("W", "WriteToFile")
//            .addKeyPressActions("I", "OpenIncoming")
            .addKeyPressActions("T", "new nextgen.actions.OpenTemplate(stTemplate).actionPerformed(null);")
//            .addKeyPressActions("E", "OpenAllArguments")
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("AddParameterTypeAction")
                  .addFields(stParameterType, "stParameter")
                  .setTitle("Add")
                  .addStatements("appModel().addList(stParameter, getModel(), thisCanvas());"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("SetParameterTypeAction")
                  .addFields(stParameterType, "stParameter")
                  .setTitle("Set")
                  .addStatements("appModel().setParameter(stParameter, getModel(), thisCanvas());"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("WriteToFile")
//                  .setTitle("Write To File")
//                  .addStatements("appModel().writeToFile(getModel());"))
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
                  .addFields(stParameterType, "stParameter")
                  .addFields(stArgumentType, "stArgument")
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
//                  .setName("DeleteSTArgument")
//                  .addFields(stArgumentType, "stArgument")
//                  .setTitleExpression("appModel().cut(appModel().render(stArgument), 30)")
//                  .addStatements("nextgen.utils.SwingUtil.confirm(thisCanvas(), \"Remove argument ?\")\n" +
//                        "		.ifPresent(confirm -> thisCanvas().appModel().doLaterInTransaction(tx -> {\n" +
//                        "			thisCanvas().removeRelation(stArgument.getUuid());\n" +
//                        "			getModel().removeArguments(stArgument);\n" +
//                        "			setText(thisCanvas().appModel().render(getModel()));\n" +
//                        "		}));"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("OpenAllOf")
//                  .addFields(stParameterType, "stParameter")
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
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterType, "stParameter")
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
            .addFields(stArgumentType, "stArgument")
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
//            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
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
//      STGenerator.writeJavaFile(workFlowFacade, workflowPackage, workFlowFacade.getName(), mainJava);

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

   private static void generateActions() {

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addArgumentFromArgumentType)
            .setTitle("Add")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("final String argumentType = stParameter.getArgumentType();\n" +
                  "\n" +
                  "if (argumentType.equals(\"Object\") || argumentType.equals(\"String\")) {\n" +
                  "\n" +
                  "   final java.util.Optional<nextgen.st.domain.STTemplate> stTemplate = stModel.getArguments()\n" +
                  "         .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "         .map(nextgen.st.model.STArgument::getValue)\n" +
                  "         .filter(nextgen.st.model.STValue::hasType)\n" +
                  "         .filter(stValue -> stValue.getType() == nextgen.st.model.STValueType.STMODEL)\n" +
                  "         .map(stValue -> appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()))\n" +
                  "         .findFirst();\n" +
                  "\n" +
                  "   if (stTemplate.isPresent()) {\n" +
                  "      final nextgen.st.domain.STGroupModel stGroupModel = appModel().findSTGroupModel(stTemplate.get());\n" +
                  "      final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, stTemplate.get());\n" +
                  "      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "      stModel.addArguments(stArgument);\n" +
                  "      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "   } else {\n" +
                  "      input(owner, \"New value\", s -> {\n" +
                  "         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(s);\n" +
                  "         final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "         stModel.addArguments(stArgument);\n" +
                  "         nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "      });\n" +
                  "   }\n" +
                  "\n" +
                  "} else {\n" +
                  "\n" +
                  "   final nextgen.st.domain.STGroupModel stGroupModel = appModel().findSTGroupModelByTemplateUuid(stModel.getStTemplate());\n" +
                  "   final java.util.Optional<nextgen.st.domain.STTemplate> stTemplate = appModel()\n" +
                  "         .aggregateTemplates(stGroupModel)\n" +
                  "         .filter(candidate -> candidate.getName().toLowerCase().equals(argumentType.toLowerCase()))\n" +
                  "         .findAny();\n" +
                  "\n" +
                  "   if (stTemplate.isPresent()) {\n" +
                  "      final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, stTemplate.get());\n" +
                  "      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "      stModel.addArguments(stArgument);\n" +
                  "      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "   } else {\n" +
                  "      final java.util.Set<nextgen.st.domain.STTemplate> interfaces = appModel().findSTTemplatesByInterface(argumentType, stGroupModel);\n" +
                  "      if (!interfaces.isEmpty()) {\n" +
                  "         if (interfaces.size() == 1) {\n" +
                  "            final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, interfaces.iterator().next());\n" +
                  "            final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "            final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "            stModel.addArguments(stArgument);\n" +
                  "            nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "         } else {\n" +
                  "            select(owner, interfaces, value -> {\n" +
                  "               final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, value);\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "               final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "               stModel.addArguments(stArgument);\n" +
                  "               nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "            });   \n" +
                  "         }\n" +
                  "\n" +
                  "      } else {\n" +
                  "         final nextgen.st.domain.STEnum stEnum = nextgen.utils.STModelUtil.findSTEnumByName(argumentType, stGroupModel);\n" +
                  "         if (stEnum != null) {\n" +
                  "            select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> {\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "               final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "               stModel.addArguments(stArgument);\n" +
                  "               nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "            });\n" +
                  "         } else {\n" +
                  "            input(owner, \"New value\", s -> {\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(s);\n" +
                  "               final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "               stModel.addArguments(stArgument);\n" +
                  "               nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "            });\n" +
                  "         }\n" +
                  "      }\n" +
                  "   }\n" +
                  "}"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addArgumentFromClipboard)
            .setTitle("Add from Clipboard")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addArgumentFromInput)
            .setTitle("Add from Input")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, stParameter.getName(), inputValue -> {\n" +
                  "   final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);\n" +
                  "   final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "   stModel.addArguments(stArgument);\n" +
                  "   nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addArgumentFromSTModel)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stModelType, "value")
            .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addArgumentFromSTModelUuid)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields("String", "uuid")
            .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(uuid));\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addArgumentFromSTTemplate)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("final nextgen.st.model.STModel value = appModel().newSTModel(stTemplate);\n" +
                  "nextgen.events.NewSTModel.post(value, stTemplate);\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addArgumentFromSTValue)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stValueType, "value")
            .addStatements("final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, value);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, value);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addChildrenToTemplate)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
            .addFields("java.util.Set<nextgen.st.domain.STTemplate>", "children")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Sure to move\", unused -> {\n" +
                  "   appModel().aggregateTemplates(stGroup).forEach(stGroupTemplate -> {\n" +
                  "      for (nextgen.st.domain.STTemplate child : children) {\n" +
                  "         stGroupTemplate.removeChildren(child);\n" +
                  "      }\n" +
                  "   });\n" +
                  "\n" +
                  "   for (nextgen.st.domain.STTemplate child : children)\n" +
                  "      stTemplate.addChildren(child);\n" +
                  "\n" +
                  "   nextgen.events.STTemplateChildrenAdded.post(stGroup, stTemplate, children);   \n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addInterface)
            .addFields("java.util.Set<nextgen.st.domain.STTemplate>", "children")
            .addFields(ownerType, "owner")
            .addStatements("final javax.swing.JTextField txtImplements = newTextField();\n" +
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 1));\n" +
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" +
                  "contentPanel.add(txtImplements);\n" +
                  "\n" +
                  "showDialog(owner, contentPanel, \"Add interface\", jDialog -> {\n" +
                  "   final String interfaceName = txtImplements.getText().trim();\n" +
                  "   if (interfaceName.length()==0) return;\n" +
                  "   appModel().addInterface(children, interfaceName);\n" +
                  "   close(jDialog);   \n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addKVArgument)
            .setTitle("Add")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("final java.util.Map<nextgen.st.domain.STParameterKey, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();\n" +
                  "stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(40)));\n" +
                  "\n" +
                  "final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));\n" +
                  "inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" +
                  "for (java.util.Map.Entry<nextgen.st.domain.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {\n" +
                  "   inputPanel.add(new javax.swing.JLabel(fieldEntry.getKey().getName()));\n" +
                  "   inputPanel.add(fieldEntry.getValue());\n" +
                  "}\n" +
                  "\n" +
                  "showDialog(owner, inputPanel, stParameter.getName(), jDialog -> {\n" +
                  "   java.util.Collection<nextgen.st.model.STArgumentKV> kvs = new java.util.ArrayList<>();\n" +
                  "   for (java.util.Map.Entry<nextgen.st.domain.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {\n" +
                  "      final String value = fieldEntry.getValue().getText().trim();\n" +
                  "      if (value.length() == 0) continue;\n" +
                  "\n" +
                  "      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "      final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(fieldEntry.getKey(), stValue);\n" +
                  "      kvs.add(stArgumentKV);\n" +
                  "   }\n" +
                  "\n" +
                  "   final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, kvs);\n" +
                  "   nextgen.events.NewSTKVArgument.post(stModel, stParameter, stArgument);\n" +
                  "\n" +
                  "   close(jDialog);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addModelToProject)
            .addFields(stProjectType, "project")
            .addFields(stModelType, "stModel")
            .addStatements("project.addModels(stModel);\n" +
                  "nextgen.events.NewSTProjectSTModel.post(stModel, project);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addMultipleArgumentsFromArgumentType)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements(""));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addTemplateModelToProject)
            .addFields(stTemplateType, "stTemplate")
            .addFields(stProjectType, "project")
            .addStatements("final nextgen.st.model.STModel stModel = appModel().newSTModel(stTemplate);\n" +
                  "project.addModels(stModel);\n" +
                  "nextgen.events.NewSTProjectSTModel.post(stModel, project);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(copyModel)
            .setTitle("Copy Model")
            .addFields(stModelType, "stModel")
            .addStatements("toClipboard(\"stmodel-\" + stModel.getUuid());"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(deleteEnum)
            .setTitle("Delete")
            .addFields(stEnumType, "stEnum")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   stGroup.removeEnums(stEnum);\n" +
                  "   nextgen.events.STEnumDeleted.post(stEnum.getUuid());\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(deleteKV)
            .setTitle("Remove")
            .addFields(stArgumentKVType, "argumentKV")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused ->\n" +
                  "      argumentKV.getIncomingKeyValuesSTArgument().findFirst().ifPresent(stArgument -> {\n" +
                  "         stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {\n" +
                  "            final String uuid = argumentKV.getUuid();\n" +
                  "            stArgument.removeKeyValues(argumentKV);\n" +
                  "            nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "         });\n" +
                  "      }));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(deleteSTArgument)
            .setTitle("Delete")
            .addFields(stArgumentType, "stArgument")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Remove\", unused ->\n" +
                  "      stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      }));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(deleteSTGroup)
            .setTitle("Delete")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   appModel().delete(stGroup);\n" +
                  "   nextgen.events.STGroupDeleted.post(stGroup.getUuid());\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(deleteSTInterface)
            .setTitle("Delete")
            .addFields(stInterfaceType, "stInterface")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   stGroup.removeInterfaces(stInterface);\n" +
                  "   nextgen.events.STInterfaceDeleted.post(stInterface.getUuid());   \n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(removeInterfaceFromSTTemplate)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
            .addFields("String", "interfaceName")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Remove\", unused -> {\n" +
                  "   stTemplate.removeImplements(interfaceName);\n" +
                  "   nextgen.events.STTemplateInterfaceRemoved.post(stGroup, stTemplate, interfaceName);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(deleteSTModel)
            .setTitle("Delete")
            .addFields(stModelType, "stModel")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   final String uuid = stModel.getUuid();\n" +
                  "   final nextgen.st.model.STValue found = appModel().db.findSTValueByUuid(uuid);\n" +
                  "   if (found != null) appModel().db.delete(found.getNode());\n" +
                  "   nextgen.events.STModelDeleted.post(uuid);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(deleteSTTemplate)
            .setTitle("Delete")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   stGroup.removeTemplates(stTemplate);\n" +
                  "   nextgen.events.STTemplateDeleted.post(stTemplate.getUuid());\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(deleteSTValue)
            .setTitle("Delete")
            .addFields(stValueType, "stValue")
            .addFields(ownerType, "owner")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   final String uuid = stValue.getUuid();\n" +
                  "   final nextgen.st.model.STValue found = appModel().db.findSTValueByUuid(uuid);\n" +
                  "   if (found != null) appModel().db.delete(found.getNode());\n" +
                  "   nextgen.events.STValueDeleted.post(uuid);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(editEnum)
            .setTitle("Edit")
            .addFields(stEnumType, "stEnum")
            .addFields(ownerType, "owner")
            .addStatements("final int newFields = 5;\n" +
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout((int) stEnum.getValues().count() + newFields + 1, 2));\n" +
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" +
                  "contentPanel.add(newLabel(\"Name\"));\n" +
                  "contentPanel.add(newLabel(\"Lexical\"));\n" +
                  "\n" +
                  "// existing values:\n" +
                  "final java.util.Map<nextgen.st.domain.STEnumValue, javax.swing.JTextField> txtEnumValuesName = new java.util.LinkedHashMap<>();\n" +
                  "final java.util.Map<nextgen.st.domain.STEnumValue, javax.swing.JTextField> txtEnumLexical = new java.util.LinkedHashMap<>();\n" +
                  "stEnum.getValues().forEach(stEnumValue -> {\n" +
                  "\ttxtEnumValuesName.put(stEnumValue, newTextField(stEnumValue.getName(), 10));\n" +
                  "\ttxtEnumLexical.put(stEnumValue, newTextField(stEnumValue.getLexical(), 10));\n" +
                  "\tcontentPanel.add(txtEnumValuesName.get(stEnumValue));\n" +
                  "\tcontentPanel.add(txtEnumLexical.get(stEnumValue));\n" +
                  "});\n" +
                  "\n" +
                  "// allow adding new values:\n" +
                  "final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumValuesName = new java.util.LinkedHashMap<>();\n" +
                  "final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumLexical = new java.util.LinkedHashMap<>();\n" +
                  "for (int i = 0; i < newFields; i++) {\n" +
                  "\tnewTxtEnumValuesName.put(i, newTextField(\"\", 10));\n" +
                  "\tnewTxtEnumLexical.put(i, newTextField(\"\", 10));\n" +
                  "\tcontentPanel.add(newTxtEnumValuesName.get(i));\n" +
                  "\tcontentPanel.add(newTxtEnumLexical.get(i));\n" +
                  "}\n" +
                  "\n" +
                  "showDialog(owner, contentPanel, \"Edit Enum\", jDialog -> {\n" +
                  "\tfor (nextgen.st.domain.STEnumValue stEnumValue : txtEnumValuesName.keySet()) {\n" +
                  "\t\tfinal String txtEnumValueName = txtEnumValuesName.get(stEnumValue).getText().trim();\n" +
                  "\t\tfinal String txtEnumValueLexical = txtEnumLexical.get(stEnumValue).getText().trim();\n" +
                  "\n" +
                  "\t\tstEnumValue.setName(txtEnumValueName);\n" +
                  "\t\tstEnumValue.setLexical(txtEnumValueLexical.length() == 0 ? null : txtEnumValueLexical);\n" +
                  "\t}\n" +
                  "\n" +
                  "\tfor (int i = 0; i < newFields; i++) {\n" +
                  "\t\tfinal String newEnumValue = newTxtEnumValuesName.get(i).getText().trim();\n" +
                  "\t\tfinal String newEnumLexical = newTxtEnumLexical.get(i).getText().trim();\n" +
                  "\t\tif (newEnumValue.length() == 0) continue;\n" +
                  "\n" +
                  "\t\tstEnum.addValues(nextgen.st.domain.STJsonFactory.newSTEnumValue()\n" +
                  "\t\t\t\t.setName(newEnumValue)\n" +
                  "\t\t\t\t.setLexical(newEnumLexical.length() == 0 ? null : newEnumLexical));\n" +
                  "\t}\n" +
                  "\n" +
                  "\tnextgen.events.STEnumChanged.post(stEnum);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(editModels)
            .setTitle("Edit")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> {\n" +
                  "   final nextgen.st.STModelGrid stModelGrid = appModel().getWorkspace().getModelGrid(stTemplate);\n" +
                  "   appModel().getWorkspace().setSelectedComponent(stModelGrid);\n" +
                  "   stModelGrid.requestFocusInWindow();   \n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(editSTGroupTags)
            .setTitle("Edit tags")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Tags\", stGroup.getTags(\"\"), tags -> {\n" +
                  "   stGroup.setTags(tags);\n" +
                  "   nextgen.events.STGroupTagsChanged.post(stGroup);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(editSTModel)
            .setTitle("Edit")
            .addFields(stModelType, "stModel")
            .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().getWorkspace().setSelectedComponent(appModel().getModelEditor(stModel)));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(generateAllProjectModels)
            .setTitle("Generate all")
            .addFields(stProjectType, "project")
            .addStatements("project.getModels().forEach(stModel ->\n" +
                  "      stModel.getFiles().forEach(stFile -> {\n" +
                  "         final String content = appModel().render(stModel);\n" +
                  "         final String packageDeclaration = stFile.getPackageName().getValue();\n" +
                  "         final String name = stFile.getName().getValue();\n" +
                  "         final String filetype = stFile.getType().getValue();\n" +
                  "         final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" +
                  "         nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" +
                  "      }));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(generateAllSTGroups)
            .setTitle("Generate all")
            .addStatements("appModel().getSTGroups().forEach(stGroupModel -> appModel().generateSTGroup(stGroupModel, false));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(generateSource)
            .setTitle("As builder code")
            .addFields(stModelType, "stModel")
            .addStatements("final java.util.Set<String> imports = new java.util.LinkedHashSet<>();\n" +
                  "\n" +
                  "final String packageName = \"tmp\";\n" +
                  "final String className = appModel().getSTModelName(stModel, \"Tmp\");\n" +
                  "final nextgen.templates.java.MethodCallExpression expression = appModel().stRenderer.renderGeneratorCode(stModel, imports);\n" +
                  "\n" +
                  "nextgen.st.STGenerator.writeJavaFile(nextgen.templates.JavaPatterns.newCompilationUnit()\n" +
                  "      .setPackageDeclaration(nextgen.templates.JavaPatterns.newPackageDeclaration(packageName))\n" +
                  "      .setImportDeclaration(imports.stream().map(s ->\n" +
                  "            nextgen.templates.JavaPatterns.newImportDeclaration().setName(s).setIsAsterisk(true)).collect(java.util.stream.Collectors.toList()))\n" +
                  "      .addTypes(nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()\n" +
                  "            .setName(className)\n" +
                  "            .addMembers(nextgen.templates.JavaPatterns.newMethodDeclaration()\n" +
                  "                  .addModifiers(\"public\")\n" +
                  "                  .addModifiers(\"static\")\n" +
                  "                  .setName(\"main\")\n" +
                  "                  .addParameters(nextgen.templates.JavaPatterns.newParameter()\n" +
                  "                        .setType(nextgen.templates.JavaPatterns.newClassOrInterfaceType()\n" +
                  "                              .addNames(\"String\")\n" +
                  "                              .setIsArrayType(true))\n" +
                  "                        .setName(\"args\"))\n" +
                  "                  .setBlockStmt(nextgen.templates.JavaPatterns.newBlockStmt()\n" +
                  "                        .addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()\n" +
                  "                              .setExpression(expression))))), packageName, className, new java.io.File(\"./components/core/src/main/java\"));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(generateSTGroup)
            .setTitle("Generate")
            .addFields(stGroupModelType, "stGroup")
            .addStatements("appModel().generateSTGroup(stGroup, false);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(importSTTemplate)
            .setTitle("Import from stg-file")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("openFile(owner, file -> {\n" +
                  "\tappModel().setLastDir(file.getParentFile());\n" +
                  "\tappModel().doLaterInTransaction(t -> {\n" +
                  "\t\tfinal String fileName = file.getName();\n" +
                  "\t\tfinal String name = fileName.substring(0, fileName.indexOf(\".\"));\n" +
                  "\t\tappModel().newSTTemplate(name, nextgen.utils.FileUtil.readIntact(file), stGroup);\n" +
                  "\t});\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(newEnum)
            .setTitle("New Enum")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"New Enum\", s ->\n" +
                  "      nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "         final nextgen.st.domain.STEnum stEnum = appModel().newSTEnum(name);\n" +
                  "         stGroup.addEnums(stEnum);\n" +
                  "         nextgen.events.NewSTEnum.post(stGroup, stEnum);\n" +
                  "      }));"));


      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(newInterface)
            .setTitle("New Interface")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"New Interface\", s ->\n" +
                  "      nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "         final nextgen.st.domain.STInterface stInterface = appModel().newSTInterface(name);\n" +
                  "         stGroup.addInterfaces(stInterface);\n" +
                  "         nextgen.events.NewSTInterface.post(stGroup, stInterface);\n" +
                  "      }));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(newProject)
            .setTitle("New Project")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Name\", s -> {\n" +
                  "   final nextgen.st.model.STProject stProject = appModel().db.newSTProject(s);\n" +
                  "   nextgen.events.NewSTProject.post(stProject);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(newSTGroup)
            .setTitle("New STGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Name\", name -> {\n" +
                  "\t\n" +
                  "\tfinal java.util.Optional<nextgen.st.domain.STGroupModel> existing = appModel().findSTGroup(name);\n" +
                  "\tif (existing.isPresent()) {\n" +
                  "\t\tnextgen.utils.SwingUtil.showMessage(name + \" group already exists in this directory\", owner);\n" +
                  "\t\treturn;\n" +
                  "\t}\n" +
                  "\n" +
                  "\tif (!javax.lang.model.SourceVersion.isIdentifier(name)) {\n" +
                  "\t\tnextgen.utils.SwingUtil.showMessage(name + \" is a reserved java keyword\", owner);\n" +
                  "\t\treturn;\n" +
                  "\t}\n" +
                  "\n" +
                  "\tfinal nextgen.st.domain.STGroupModel stGroupModel = appModel().newSTGroupModel(name);\n" +
                  "\tnextgen.events.NewSTGroup.post(stGroupModel);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(newSTModel)
            .setTitle("New instance")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("final nextgen.st.model.STModel stModel = appModel().newSTModel(stTemplate);\n" +
                  "nextgen.events.NewSTModel.post(stModel, stTemplate);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(newSTTemplate)
            .setTitle("New Template")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Name\", s -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "\tfinal nextgen.st.domain.STTemplate stTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText(\"\");\n" +
                  "\tstGroup.addTemplates(stTemplate);\n" +
                  "\tnextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);\n" +
                  "}));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(addChildToTemplate)
            .setTitle("Add Child template")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Name\", s -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s)\n" +
                  "      .ifPresent(name -> {\n" +
                  "         final nextgen.st.domain.STTemplate newTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText(\"\");\n" +
                  "         stTemplate.addChildren(newTemplate);\n" +
                  "         nextgen.events.NewSTTemplateChild.post(newTemplate, stTemplate);\n" +
                  "      }));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(openSTModel)
            .setTitle("Open")
            .addFields(stModelType, "stModel")
            .addStatements("nextgen.events.OpenSTModel.post(stModel);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(openTemplate)
            .setTitle("Open")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("nextgen.events.OpenSTTemplate.post(stTemplate);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(renameEnum)
            .setTitle("Rename")
            .addFields(stEnumType, "stEnum")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Name\", stEnum.getName(), s -> {\n" +
                  "   nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "      stEnum.setName(name);\n" +
                  "      nextgen.events.STEnumNameChanged.post(stGroup, stEnum);\n" +
                  "   });\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(renameSTGroup)
            .setTitle("Rename")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Name\", stGroup.getName(), s -> {\n" +
                  "\tnextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "\t\tstGroup.setName(name);\n" +
                  "\t\tnextgen.events.STGroupNameChanged.post(stGroup);\n" +
                  "\t});\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(renameSTInterface)
            .setTitle("Rename")
            .addFields(stInterfaceType, "stInterface")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Name\", stInterface.getName(), s -> {\n" +
                  "   nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "      stInterface.setName(name);\n" +
                  "      nextgen.events.STInterfaceNameChanged.post(stGroup, stInterface);\n" +
                  "   });\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(renameSTTemplate)
            .setTitle("Rename")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stGroupModelType, "stGroup")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Name\", stTemplate.getName(), s -> {\n" +
                  "   nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "      stTemplate.setName(name);\n" +
                  "      nextgen.events.STTemplateNameChanged.post(stGroup, stTemplate);\n" +
                  "   });\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setArgumentFromClipboard)
            .setTitle("Set from Clipboard")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "      .findAny()\n" +
                  "      .ifPresent(stArgument -> {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setArgumentFromInput)
            .setTitle("Set from Input")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, stParameter.getName(), inputValue -> {\n" +
                  "   stModel.getArguments()\n" +
                  "         .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "         .findAny()\n" +
                  "         .ifPresent(stArgument -> {\n" +
                  "            final String uuid = stArgument.getUuid();\n" +
                  "            stModel.removeArguments(stArgument);\n" +
                  "            stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "            stArgument.delete();\n" +
                  "            nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "         });\n" +
                  "   \n" +
                  "   final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);\n" +
                  "   final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "   stModel.addArguments(stArgument);\n" +
                  "   nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setArgumentFromSTModel)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stModelType, "value")
            .addStatements(" stModel.getArguments()\n" +
                  "            .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "            .findAny()\n" +
                  "            .ifPresent(stArgument -> {\n" +
                  "               final String uuid = stArgument.getUuid();\n" +
                  "               stModel.removeArguments(stArgument);\n" +
                  "               stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "               stArgument.delete();\n" +
                  "               nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "            });\n" +
                  "\n" +
                  "      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "      stModel.addArguments(stArgument);\n" +
                  "      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setArgumentFromSTModelUuid)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields("String", "uuid")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "      .findAny()\n" +
                  "      .ifPresent(stArgument -> {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(uuid));\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setArgumentFromSTTemplate)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stTemplateType, "stTemplate")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "      .findAny()\n" +
                  "      .ifPresent(stArgument -> {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STModel value = appModel().newSTModel(stTemplate);\n" +
                  "nextgen.events.NewSTModel.post(value, stTemplate);\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setArgumentFromSTValue)
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addFields(stValueType, "value")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "      .findAny()\n" +
                  "      .ifPresent(stArgument -> {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, value);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, value);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setArgumentToTrue)
            .setTitle("Set to true")
            .addFields(stModelType, "stModel")
            .addFields(stParameterType, "stParameter")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "      .findAny()\n" +
                  "      .ifPresent(stArgument -> {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(\"true\");\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setInterfaces)
            .setTitle("Set interfaces")
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
            .addFields(ownerType, "owner")
            .addStatements("final java.util.List<javax.swing.JTextField> txtImplements = new java.util.ArrayList<>();\n" +
                  "stTemplate.getImplements().forEach(implement -> {\n" +
                  "   final javax.swing.JTextField textField = newTextField(implement, 15);\n" +
                  "   txtImplements.add(textField);\n" +
                  "});\n" +
                  "txtImplements.add(newTextField(\"\", 15));\n" +
                  "txtImplements.add(newTextField(\"\", 15));\n" +
                  "\n" +
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtImplements.size(), 1));\n" +
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" +
                  "for (javax.swing.JTextField txtImplement : txtImplements)\n" +
                  "   contentPanel.add(txtImplement);\n" +
                  "\n" +
                  "showDialog(owner, contentPanel, \"Edit\", jDialog -> {\n" +
                  "   stTemplate.clearImplements();\n" +
                  "   for (javax.swing.JTextField txtImplement : txtImplements) {\n" +
                  "      final String trim = txtImplement.getText().trim();\n" +
                  "      if (trim.length() == 0) continue;\n" +
                  "      stTemplate.addImplements(trim);\n" +
                  "   }\n" +
                  "\n" +
                  "   nextgen.events.STTemplateInterfacesChanged.post(stGroup, stTemplate);\n" +
                  "   javax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setKVArgumentFromClipboard)
            .addFields(stModelType, "stModel")
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addStatements("stArgument.getKeyValues()\n" +
                  "      .filter(existing -> existing.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                  "      .findFirst()\n" +
                  "      .ifPresent(existing -> {\n" +
                  "         stArgument.removeKeyValues(existing);\n" +
                  "         final String uuid = existing.getUuid();\n" +
                  "         existing.delete();\n" +
                  "         nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(stParameterKey, stValue);\n" +
                  "stArgument.addKeyValues(stArgumentKV);\n" +
                  "\n" +
                  "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setKVArgumentFromInput)
            .addFields(stModelType, "stModel")
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, stParameterKey.getName(), inputValue -> {\n" +
                  "   stArgument.getKeyValues()\n" +
                  "         .filter(existing -> existing.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                  "         .findFirst()\n" +
                  "         .ifPresent(existing -> {\n" +
                  "            stArgument.removeKeyValues(existing);\n" +
                  "            final String uuid = existing.getUuid();\n" +
                  "            existing.delete();\n" +
                  "            nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "         });\n" +
                  "\n" +
                  "   final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);\n" +
                  "   final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(stParameterKey, stValue);\n" +
                  "   stArgument.addKeyValues(stArgumentKV);\n" +
                  "\n" +
                  "   nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stValue);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setKVArgumentFromSTModel)
            .addFields(stModelType, "stModel")
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addFields(stModelType, "value")
            .addStatements("stArgument.getKeyValues()\n" +
                  "      .filter(existing -> existing.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                  "      .findFirst()\n" +
                  "      .ifPresent(existing -> {\n" +
                  "         stArgument.removeKeyValues(existing);\n" +
                  "         final String uuid = existing.getUuid();\n" +
                  "         existing.delete();\n" +
                  "         nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(stParameterKey, stValue);\n" +
                  "stArgument.addKeyValues(stArgumentKV);\n" +
                  "\n" +
                  "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setKVArgumentFromSTValue)
            .addFields(stModelType, "stModel")
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addFields(stValueType, "stValue")
            .addStatements("stArgument.getKeyValues()\n" +
                  "      .filter(existing -> existing.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                  "      .findFirst()\n" +
                  "      .ifPresent(existing -> {\n" +
                  "         stArgument.removeKeyValues(existing);\n" +
                  "         final String uuid = existing.getUuid();\n" +
                  "         existing.delete();\n" +
                  "         nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(stParameterKey, stValue);\n" +
                  "stArgument.addKeyValues(stArgumentKV);\n" +
                  "\n" +
                  "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setMultipleFields)
            .setTitle("Set Fields")
            .addFields(stTemplateType, "stTemplate")
            .addFields(stModelType, "stModel")
            .addFields(ownerType, "owner")
            .addStatements("final java.util.concurrent.atomic.AtomicInteger modelIndex = new java.util.concurrent.atomic.AtomicInteger(0);\n" +
                  "final nextgen.st.model.STModel[] existingSTModels = appModel().db.findAllSTModelByStTemplate(stTemplate.getUuid()).distinct().toArray(nextgen.st.model.STModel[]::new);\n" +
                  "\n" +
                  "final java.util.Map<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();\n" +
                  "final java.util.Map<String, nextgen.st.domain.STParameter> parameterMap = new java.util.LinkedHashMap<>();\n" +
                  "final java.util.Map<String, nextgen.st.model.STArgument> argumentMap = new java.util.LinkedHashMap<>();\n" +
                  "final java.util.Map<String, java.util.List<String>> valuesMap = new java.util.LinkedHashMap<>();\n" +
                  "\n" +
                  "stTemplate\n" +
                  "      .getParameters()\n" +
                  "      .filter(stParameter -> stParameter.getType().equals(nextgen.st.domain.STParameterType.SINGLE))\n" +
                  "      .forEach(stParameter -> {\n" +
                  "\n" +
                  "         final java.util.Optional<nextgen.st.model.STArgument> argument = stModel.getArguments()\n" +
                  "               .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "               .findFirst();\n" +
                  "         final String content = argument.isPresent() ? appModel().render(argument.get()) : \"\";\n" +
                  "         fieldMap.put(stParameter.getName(), newTextField(content, 40));\n" +
                  "         parameterMap.put(stParameter.getName(), stParameter);\n" +
                  "         argument.ifPresent(stArgument -> argumentMap.put(stParameter.getName(), stArgument));\n" +
                  "\n" +
                  "         for (nextgen.st.model.STModel existingSTModel : existingSTModels) {\n" +
                  "            existingSTModel\n" +
                  "                  .getArguments()\n" +
                  "                  .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" +
                  "                  .filter(stArgument -> stArgument.getValue() != null)\n" +
                  "                  .findFirst()\n" +
                  "                  .ifPresent(stArgument -> {\n" +
                  "                     valuesMap.putIfAbsent(stParameter.getName(), new java.util.ArrayList<>());\n" +
                  "                     valuesMap.get(stParameter.getName()).add(appModel().render(stArgument));\n" +
                  "                  });\n" +
                  "         }\n" +
                  "\n" +
                  "      });\n" +
                  "\n" +
                  "final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));\n" +
                  "inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" +
                  "for (java.util.Map.Entry<String, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {\n" +
                  "   inputPanel.add(newLabel(fieldEntry.getKey()));\n" +
                  "   inputPanel.add(fieldEntry.getValue());\n" +
                  "\n" +
                  "   if (!valuesMap.isEmpty())\n" +
                  "      fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {\n" +
                  "         @Override\n" +
                  "         public void mouseClicked(java.awt.event.MouseEvent e) {\n" +
                  "            fieldEntry.getValue().setText(valuesMap.get(fieldEntry.getKey()).get(modelIndex.incrementAndGet() % valuesMap.get(fieldEntry.getKey()).size()));\n" +
                  "         }\n" +
                  "      });\n" +
                  "}\n" +
                  "\n" +
                  "showDialog(owner, inputPanel, \"Set Multiple\", jDialog -> {\n" +
                  "   for (java.util.Map.Entry<String, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {\n" +
                  "\n" +
                  "      final String name = fieldEntry.getKey();\n" +
                  "      final String value = fieldEntry.getValue().getText().trim();\n" +
                  "      final nextgen.st.model.STArgument stArgument = argumentMap.get(name);\n" +
                  "      final nextgen.st.domain.STParameter stParameter = parameterMap.get(name);\n" +
                  "\n" +
                  "      if (value.length() == 0 && stArgument != null) {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      } else if (value.length() != 0 && stArgument != null) {\n" +
                  "         final String existingValue = appModel().render(stArgument.getValue());\n" +
                  "         if (!value.equals(existingValue)) {\n" +
                  "            stArgument.removeValue();\n" +
                  "            stArgument.setValue(appModel().db.newSTValue(value));\n" +
                  "            nextgen.events.STArgumentChanged.post(stModel, stArgument);\n" +
                  "         }\n" +
                  "      } else if (value.length() != 0) {\n" +
                  "         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "         final nextgen.st.model.STArgument newSTArgument = appModel().newSTArgument(stModel, stParameter, stValue);\n" +
                  "         nextgen.events.NewSTArgument.post(newSTArgument, stModel, stParameter, stValue);\n" +
                  "      }\n" +
                  "   }\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setSTValueFromClipboard)
            .setTitle("Set from Clipboard")
            .addFields(stValueType, "stValue")
            .addStatements("stValue.removeStModel();\n" +
                  "stValue.setValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);\n" +
                  "nextgen.events.STValueChanged.post(stValue);"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setSTValueFromInput)
            .setTitle("Set from Input")
            .addFields(stValueType, "stValue")
            .addFields(ownerType, "owner")
            .addStatements("input(owner, \"Set Value\", value -> {\n" +
                  "   stValue.removeStModel();\n" +
                  "   stValue.setValue(value);\n" +
                  "   stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);\n" +
                  "   nextgen.events.STValueChanged.post(stValue);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(setTemplateParameterTypes)
            .setTitle("Set parameter types")
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
            .addFields(ownerType, "owner")
            .addStatements("final java.util.Map<String, javax.swing.JTextField> txtParameterMap = new java.util.TreeMap<>();\n" +
                  "stTemplate.getParameters().forEach(stParameter -> {\n" +
                  "\n" +
                  "\tswitch (stParameter.getType()) {\n" +
                  "\n" +
                  "\t\tcase SINGLE:\n" +
                  "\t\tcase LIST:\n" +
                  "\t\t\tfinal String key = stParameter.getName();\n" +
                  "\t\t\ttxtParameterMap.put(key, newTextField(stParameter.getArgumentType(\"Object\"), 15));\n" +
                  "\t\t\tbreak;\n" +
                  "\n" +
                  "\t\tcase KVLIST:\n" +
                  "\t\t\tstParameter.getKeys().forEach(stParameterKey -> {\n" +
                  "\t\t\t\tfinal String kvListKey = stParameter.getName() + \".\" + stParameterKey.getName();\n" +
                  "\t\t\t\ttxtParameterMap.put(kvListKey, newTextField(stParameterKey.getArgumentType(\"Object\"), 15));\n" +
                  "\t\t\t});\n" +
                  "\t\t\tbreak;\n" +
                  "\t}\n" +
                  "});\n" +
                  "\n" +
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtParameterMap.size(), 2));\n" +
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" +
                  "txtParameterMap.forEach((key, value) -> {\n" +
                  "\tcontentPanel.add(newLabel(key));\n" +
                  "\tcontentPanel.add(value);\n" +
                  "});\n" +
                  "\n" +
                  "showDialog(owner, contentPanel, \"Parameter Types\", jDialog -> {\n" +
                  "\tstTemplate.getParameters().forEach(stParameter -> {\n" +
                  "\n" +
                  "\t\tswitch (stParameter.getType()) {\n" +
                  "\n" +
                  "\t\t\tcase SINGLE:\n" +
                  "\t\t\tcase LIST:\n" +
                  "\t\t\t\tfinal javax.swing.JTextField txtTypes = txtParameterMap.get(stParameter.getName());\n" +
                  "\t\t\t\tfinal String types = txtTypes.getText().trim();\n" +
                  "\t\t\t\tstParameter.setArgumentType(types.length() == 0 ? (stParameter.getName().startsWith(\"is\") ? \"Boolean\" : \"Object\") : types);\n" +
                  "\t\t\t\tbreak;\n" +
                  "\n" +
                  "\t\t\tcase KVLIST:\n" +
                  "\t\t\t\tstParameter.getKeys().forEach(stParameterKey -> {\n" +
                  "\t\t\t\t\tfinal javax.swing.JTextField txtKVTypes = txtParameterMap.get(stParameter.getName() + \".\" + stParameterKey.getName());\n" +
                  "\t\t\t\t\tfinal String kvTypes = txtKVTypes.getText().trim();\n" +
                  "\t\t\t\t\tstParameterKey.setArgumentType(kvTypes.length() == 0 ? (stParameterKey.getName().startsWith(\"is\") ? \"Boolean\" : \"Object\") : kvTypes);\n" +
                  "\t\t\t\t});\n" +
                  "\t\t\t\tbreak;\n" +
                  "\t\t}\n" +
                  "\t});\n" +
                  "\n" +
                  "\tnextgen.events.STTemplateParameterTypesChanged.post(stGroup, stTemplate);\n" +
                  "\tjavax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" +
                  "});"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(stValueToClipboard)
            .setTitle("To Clipboard")
            .addFields(stValueType, "stValue")
            .addStatements("nextgen.utils.SwingUtil.toClipboard(appModel().render(stValue));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(stModelToClipboard)
            .setTitle("To Clipboard")
            .addFields(stModelType, "stModel")
            .addStatements("nextgen.utils.SwingUtil.toClipboard(appModel().render(stModel));"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(undoDBTransaction)
            .setTitle("Undo")
            .addStatements("appModel().undoLast();"));

      write(nextgen.templates.NextgenPatterns.newTransactionAction()
            .setName(writeSTModelToFile)
            .setTitle("Generate")
            .addFields(stModelType, "stModel")
            .addStatements("stModel.getFiles().forEach(stFile -> {\n" +
                  "   final String content = appModel().render(stModel);\n" +
                  "   final String packageDeclaration = stFile.getPackageName().getValue();\n" +
                  "   final String name = stFile.getName().getValue();\n" +
                  "   final String filetype = stFile.getType().getValue();\n" +
                  "   final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" +
                  "   nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" +
                  "});"));
   }

   private static void generateEvents() {

      // New
      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTArgument)
            .addFields(stArgumentType, "argument")
            .addFields(stModelType, "model")
            .addFields(stParameterType, "parameter")
            .addFields(stValueType, "value")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTKVArgument)
            .addFields(stModelType, "model")
            .addFields(stParameterType, "parameter")
            .addFields(stArgumentType, "argument")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newKV)
            .addFields(stModelType, "stModel")
            .addFields(stArgumentType, "argument")
            .addFields(stArgumentKVType, "kv")
            .addFields(stValueType, "value")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTModel)
            .addFields(stModelType, "model")
            .addFields(stTemplateType, "template")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTProjectSTModel)
            .addFields(stModelType, "model")
            .addFields(stProjectType, "project")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTGroupTemplate)
            .addFields(stTemplateType, "template")
            .addFields(stGroupModelType, "parent")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTTemplateChild)
            .addFields(stTemplateType, "template")
            .addFields(stTemplateType, "parent")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTEnum)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stEnumType, "stEnum")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTInterface)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stInterfaceType, "stInterface")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTProject)
            .addFields(stProjectType, "project")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(newSTGroup)
            .addFields(stGroupModelType, "group")
      );

      // Changed
      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stValueChanged)
            .addFields(stValueType, "value")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stArgumentChanged)
            .addFields(stModelType, "stModel")
            .addFields(stArgumentType, "stArgument")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stEnumChanged)
            .addFields(stEnumType, "stEnum")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stGroupTagsChanged)
            .addFields(stGroupModelType, "stGroup")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stEnumNameChanged)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stEnumType, "stEnum")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stGroupNameChanged)
            .addFields(stGroupModelType, "stGroup")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stInterfaceNameChanged)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stInterfaceType, "stInterface")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stTemplateNameChanged)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stTemplateParameterTypesChanged)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stTemplateInterfacesChanged)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stTemplateInterfaceRemoved)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
            .addFields("String", "interfaceName")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stTemplateChildrenAdded)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "stTemplate")
            .addFields("java.util.Set<nextgen.st.domain.STTemplate>", "children")
      );

      // Deleted
      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stValueDeleted)
            .addFields("String", "uuid")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stModelDeleted)
            .addFields("String", "uuid")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stArgumentDeleted)
            .addFields(stModelType, "stModel")
            .addFields("String", "uuid")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(kvDeleted)
            .addFields(stModelType, "stModel")
            .addFields(stArgumentType, "stArgument")
            .addFields("String", "uuid")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stInterfaceDeleted)
            .addFields("String", "uuid")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stEnumDeleted)
            .addFields("String", "uuid")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stGroupDeleted)
            .addFields("String", "uuid")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(stTemplateDeleted)
            .addFields("String", "uuid")
      );

      // Open
      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(openSTModel)
            .addFields(stModelType, "model")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(openSTTemplate)
            .addFields(stTemplateType, "template")
      );

      // Clicked
      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(canvasSTModelClicked)
            .addFields(stModelType, "model")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(templateNavigatorSTParameterEditorTreeNodeClicked)
            .addFields(stParameterType, "parameter")
            .addFields(stModelType, "model")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(templateNavigatorSTGroupTreeNodeClicked)
            .addFields(stGroupModelType, "stGroup")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(templateNavigatorSTTemplateTreeNodeClicked)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stTemplateType, "parentTemplate")
            .addFields(stTemplateType, "stTemplate")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(templateNavigatorSTEnumTreeNodeClicked)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stEnumType, "stEnum")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(templateNavigatorSTInterfaceTreeNodeClicked)
            .addFields(stGroupModelType, "stGroup")
            .addFields(stInterfaceType, "stInterface")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent()
            .setName(modelNavigatorStProjectTreeNodeClicked)
            .addFields(stProjectType, "stProject"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelNavigatorModelsTreeNodeClicked));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelNavigatorStGroupTreeNodeClicked)
            .addFields(stGroupModelType, "stGroup"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelNavigatorStTemplateTreeNodeClicked)
            .addFields(stTemplateType, "stTemplate"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelNavigatorStParameterTreeNodeClicked)
            .addFields(stParameterType, "stParmeter"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelNavigatorStModelTreeNodeClicked)
            .addFields(stTemplateType, "stTemplate")
            .addFields(stModelType, "stModel"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelNavigatorStKVArgumentTreeNodeClicked)
            .addFields(stArgumentKVType, "kv"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelNavigatorStValueTreeNodeClicked)
            .addFields(stValueType, "stValue"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelEditorStGroupTreeNodeClicked)
            .addFields(stGroupModelType, "stGroup"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelEditorStTemplateTreeNodeClicked)
            .addFields(stTemplateType, "stTemplate"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelEditorStParameterTreeNodeClicked)
            .addFields(stParameterType, "stParameter")
            .addFields(stModelType, "stModel")
      );

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelEditorStModelTreeNodeClicked)
            .addFields(stTemplateType, "stTemplate")
            .addFields(stModelType, "stModel"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelEditorStKVArgumentTreeNodeClicked)
            .addFields(stArgumentKVType, "kv"));

      write(nextgen.templates.GreenRobotPatterns.newEvent().setName(modelEditorStValueTreeNodeClicked)
            .addFields(stValueType, "stValue"));

   }

   public static void write(nextgen.templates.greenrobot.Event event) {

      if (events.contains(event.getName())) throw new IllegalStateException("Duplicate event " + event.getName());
      events.add(event.getName());

      typesMap.put(event.getName(), newClassOrInterfaceType(eventsPackage, event.getName()));
      typesMap.put(event.getName(), newClassOrInterfaceType(eventsPackage, event.getName()));
      event.setPackageName(eventsPackage.getName());

      nextgen.st.STGenerator.writeJavaFile(event, eventsPackage, event.getName(), mainJava);
   }

   private static void write(nextgen.templates.nextgen.TransactionAction action) {

      if (actions.contains(action.getName())) throw new IllegalStateException("Duplicate action " + action.getName());
      actions.add(action.getName());

      typesMap.put(action.getName(), newClassOrInterfaceType(actionsPackage, action.getName()));

      STGenerator.writeJavaFile(action, actionsPackage, action.getName().toString(), mainJava);
   }

   private nextgen.templates.greenrobot.Subscribe newSubscribe(String event) {
      return nextgen.templates.greenrobot.GreenRobotST.newSubscribe()
            .setEventName(event)
            .setEventType(typesMap.get(event))
            .addStatements("System.out.println(\"" + event + "\");");
   }

   private nextgen.templates.java.Expression postEventExpression(String eventName, Object... arguments) {
      final nextgen.templates.java.MethodCallExpression expression = newMethodCallExpression()
            .setScope(newClassOrInterfaceType(eventsPackage, eventName))
            .setName("post");
      for (Object argument : arguments)
         expression.addArguments(argument);
      return expression;
   }

   private Object postEvent(String eventName, Object... arguments) {
      return newExpressionStmt().setExpression(postEventExpression(eventName, arguments));
   }

   private nextgen.templates.java.Expression newAction(String actionName, Object... arguments) {
      final nextgen.templates.java.ObjectCreationExpression expression = nextgen.templates.JavaPatterns.newObjectCreationExpression(newClassOrInterfaceType(actionsPackage, actionName));
      for (Object argument : arguments)
         expression.addArguments(argument);
      return expression;
   }

   private nextgen.templates.java.Expression addToActions(Object action) {
      return newMethodCallExpression()
            .setScope("actions")
            .setName("add")
            .addArguments(action);
   }

   private Object addToActionsStatement(nextgen.templates.java.Expression action) {
      return newExpressionStmt()
            .setExpression(action);
   }

   private String getParent(nextgen.templates.nextgen.TreeNode parent, nextgen.templates.java.Expression expression) {
      return getParent(null, parent.getName(), expression);
   }

   private String getParent(String scope, nextgen.templates.nextgen.TreeNode parent, nextgen.templates.java.Expression expression) {
      return getParent(scope, parent.getName(), expression);
   }

   private String getParent(String scope, String parent, nextgen.templates.java.Expression expression) {
      return (scope == null ? "" : (scope + ".")) + "getParentNode(" + parent + ".class).ifPresent(parent -> " + expression + ");";
   }

   private String getParent(nextgen.templates.nextgen.TreeNode parent, nextgen.templates.java.BlockStmt blockStmt) {
      return getParent(null, parent, blockStmt);
   }

   private String getParent(String scope, nextgen.templates.nextgen.TreeNode parent, nextgen.templates.java.BlockStmt blockStmt) {
      return getParent(scope, parent.getName(), blockStmt);
   }

   private String getParent(String scope, String parent, nextgen.templates.java.BlockStmt blockStmt) {
      return (scope == null ? "" : (scope + ".")) + "getParentNode(" + parent + ".class).ifPresent(parent -> " + blockStmt + " );";
   }
}