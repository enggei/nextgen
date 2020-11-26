package tmp;

import nextgen.templates.nextgen.*;

public class STTemplateNavigatorGenerator {

   public static TreeNavigator generate() {
      return NextgenST.newTreeNavigator()
            .addMethods("public java.util.stream.Stream<nextgen.st.model.STTemplate> getSelectedSTTemplates() {\n" +
                  "	return getSelectedNodes()\n" +
                  "			.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STTemplate)\n" +
                  "			.map(baseTreeNode -> (nextgen.st.model.STTemplate) baseTreeNode.getModel());\n" +
                  "}")
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("String")
                  .setName("RootNode")
                  .addConstructorStatements("appModel().db.findAllSTGroupModel().sorted((g1,g2) -> g1.getName().compareToIgnoreCase(g2.getName())).forEach(stGroup -> add(new STGroupTreeNode(stGroup)));")
                  .addActions("new nextgen.actions.NewSTGroupAction(tree)")
                  .addActions("new nextgen.actions.GenerateAllSTGroups()")
                  .setLabelExpression("getModel()"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STGroupModel")
                  .setName("STGroupTreeNode")
                  .setHasUuid(true)
                  .addConstructorStatements("model.getFilesSorted().forEach(file -> add(new STGroupFileTreeNode(file)));\n" +
                        "model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));\n" +
                        "model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));\n" +
                        "model.getInterfaces().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stInterface -> add(new STInterfaceTreeNode(stInterface)));")
                  .addActions("new nextgen.actions.EditSTGroupTags(getModel(), tree)")
                  .addActions("new nextgen.actions.ImportSTTemplate(getModel(), tree)")
                  .addActions("new nextgen.actions.GenerateSTGroup(getModel())")
                  .addActions("new nextgen.actions.GenerateSTGroupAndNeo(getModel())")
                  .addActions("new nextgen.actions.NewSTTemplate(getModel(), tree)")
                  .addActions("new nextgen.actions.NewEnum(getModel(), tree)")
                  .addActions("new nextgen.actions.NewInterface(getModel(), tree)")
                  .addActions("new nextgen.actions.RenameSTGroup(getModel(), tree)")
                  .addActions("new nextgen.actions.DeleteSTGroup(getModel(), tree)")
                  .addActions("new nextgen.actions.AddFileSinkToGroup(getModel())")
                  .setLabelExpression("getModel().getName()")
                  .addSelectionStatements("nextgen.events.TemplateNavigatorSTGroupTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STEnum")
                  .setName("STEnumTreeNode")
                  .setHasUuid(true)
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.RenameEnum(getModel(), parent.getModel(), tree)));")
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteEnum(getModel(), parent.getModel(), tree)));")
                  .addActions("new nextgen.actions.EditEnum(getModel(), tree)")
                  .setIcon("appModel().loadIcon(\"sq-green\")")
                  .setLabelExpression("getModel().getName()")
                  .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> { nextgen.events.TemplateNavigatorSTEnumTreeNodeClicked.post(stGroupTreeNode.getModel(), selectedNode.getModel()); });"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STTemplate")
                  .setName("STTemplateTreeNode")
                  .setHasUuid(true)
                  .addGetActionsStatements("final java.util.Set<nextgen.st.model.STTemplate> candidateChildren = getSelectedTemplates();")
                  .addGetActionsStatements("final Set<nextgen.st.model.STTemplate> childTemplates = getModel().getChildren().collect(java.util.stream.Collectors.toSet());")
                  .addGetActionsStatements("actions.add(new nextgen.actions.NewSTModelAction(getModel()));")
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> { \n" +
                        "	actions.add(new nextgen.actions.AddChildToTemplate(getModel(), parent.getModel(), tree));\n" +
                        "	actions.add(new nextgen.actions.SetTemplateParameterTypes(parent.getModel(), getModel(), tree));\n" +
                        "	if (!candidateChildren.isEmpty()) actions.add(new nextgen.actions.AddChildrenToTemplate(\"Add \" + candidateChildren.size() + \" templates as children\", parent.getModel(), getModel(), candidateChildren, tree));\n" +
                        "	appModel().getProjects().forEach(stProject -> actions.add(new nextgen.actions.AddTemplateModelToProject(\"Add to \" + stProject.getName(), getModel(), stProject)));\n" +
                        "	if (!childTemplates.isEmpty()) actions.add(new nextgen.actions.AddInterface(\"Add interfaces to children\", childTemplates, tree));\n" +
                        "	actions.add(new nextgen.actions.SetInterfaces(parent.getModel(), getModel(), tree));\n" +
                        "	getModel().getImplements().forEach(implement -> actions.add(new nextgen.actions.RemoveInterfaceFromSTTemplate(\"Remove \" + implement, parent.getModel(), getModel(), implement, tree)));\n" +
                        "	actions.add(new nextgen.actions.RenameSTTemplate(getModel(), parent.getModel(), tree));\n" +
                        "});\n" +
                        "actions.add(new nextgen.actions.DeleteSTTemplate(getModel(), tree));")
                  .addConstructorStatements("model.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));")
                  .addMethods("private java.util.Set<nextgen.st.model.STTemplate> getSelectedTemplates() {\n" +
                        "			return getSelectedSTTemplateTreeNodes()\n" +
                        "					.filter(stTemplateTreeNode -> !stTemplateTreeNode.equals(this))\n" +
                        "					.map(STTemplateNavigator.BaseTreeNode::getModel)\n" +
                        "					.collect(java.util.stream.Collectors.toSet());\n" +
                        "		}")
                  .setIcon("appModel().loadIcon(\"sq-teal\")")
                  .setLabelExpression("getModel().getName()")
                  .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(parent -> { \n" +
                        "	final STTemplateNavigator.STTemplateTreeNode stTemplateTreeNode = selectedNode.getParentNode(STTemplateNavigator.STTemplateTreeNode.class).orElse(null);\n" +
                        "	nextgen.events.TemplateNavigatorSTTemplateTreeNodeClicked.post(parent.getModel(), stTemplateTreeNode == null ? null : stTemplateTreeNode.getModel(), selectedNode.getModel());\n" +
                        "});"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STInterface")
                  .setName("STInterfaceTreeNode")
                  .setHasUuid(true)
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.RenameSTInterface(getModel(), parent.getModel(), tree)));")
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteSTInterface(getModel(), parent.getModel(), tree)));")
                  .setIcon("appModel().loadIcon(\"sq-purple\")")
                  .setLabelExpression("getModel().getName()"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STGroupFile")
                  .setName("STGroupFileTreeNode")
                  .setHasUuid(true)
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.GenerateSTGroupFromFile(parent.getModel(), getModel(), tree)));")
                  .addActions("new nextgen.actions.DeleteSTGroupFile(getModel(), tree)")
                  .setLabelExpression("getModel().getPath()")
                  .addSelectionStatements("nextgen.events.TemplateNavigatorSTGroupFileClicked.post(selectedNode.getModel());"))
            .setBaseTreeNode(NextgenST.newBaseTreeNode())
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTGroupFileTreeNode(treeNode -> treeNode.getModel().equals(event.stGroupFile))\n" +
                        "		.ifPresent(STTemplateNavigator.STGroupFileTreeNode::nodeChanged);")
                  .setEventName("STGroupFileChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate))\n" +
                        "		.ifPresent(treeModel::select);")
                  .setEventName("ModelNavigatorSTModelTreeNodeClicked"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))\n" +
                        "		.ifPresent(treeModel::removeNodeFromParent);")
                  .setEventName("STGroupDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTEnumTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))\n" +
                        "		.ifPresent(treeModel::removeNodeFromParent);")
                  .setEventName("STEnumDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))\n" +
                        "		.ifPresent(treeModel::removeNodeFromParent);")
                  .setEventName("STTemplateDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTInterfaceTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))\n" +
                        "		.ifPresent(treeModel::removeNodeFromParent);")
                  .setEventName("STInterfaceDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("treeModel.addNodeInSortedOrderAndSelect((RootNode) treeModel.getRoot(), new STTemplateNavigator.STGroupTreeNode(event.group));")
                  .setEventName("NewSTGroup"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "					.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STEnumTreeNode(event.stEnum)));")
                  .setEventName("NewSTEnum"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "					.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STInterfaceTreeNode(event.stInterface)));")
                  .setEventName("NewSTInterface"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.parent))\n" +
                        "					.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));")
                  .setEventName("NewSTGroupTemplate"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.parent))\n" +
                        "					.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));")
                  .setEventName("NewSTTemplateChild"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "					.ifPresent(STTemplateNavigator.STGroupTreeNode::nodeChanged);")
                  .setEventName("STGroupNameChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate))\n" +
                        "					.ifPresent(STTemplateNavigator.STTemplateTreeNode::nodeChanged);")
                  .setEventName("STTemplateNameChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTInterfaceTreeNode(treeNode -> treeNode.getModel().equals(event.stInterface))\n" +
                        "					.ifPresent(STTemplateNavigator.STInterfaceTreeNode::nodeChanged);")
                  .setEventName("STInterfaceNameChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTEnumTreeNode(treeNode -> treeNode.getModel().equals(event.stEnum))\n" +
                        "					.ifPresent(STTemplateNavigator.STEnumTreeNode::nodeChanged);")
                  .setEventName("STEnumNameChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTGroupTreeNode(stGroupTreeNode -> stGroupTreeNode.getModel().equals(event.stGroupModel))\n" +
                        "		.ifPresent(stGroupTreeNode -> treeModel.addNodeInSortedOrderAndSelect(stGroupTreeNode, new STTemplateNavigator.STGroupFileTreeNode(event.stGroupFile)));")
                  .setEventName("NewSTGroupFile"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTGroupFileTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);")
                  .setEventName("STGroupFileDeleted"))
            .setPackageName("nextgen.swing")
            .setName("STTemplateNavigator")
            .addFields("STWorkspace", "workspace")
            .setPreferredHeight("500")
            .addConstructorStatements("org.greenrobot.eventbus.EventBus.getDefault().register(this);")
            .addTreeNodesSelected("STGroupTreeNode")
            .addTreeNodesSelected("STEnumTreeNode")
            .addTreeNodesSelected("STTemplateTreeNode")
            .addTreeNodesSelected("STInterfaceTreeNode")
            .addTreeNodesSelected("STGroupFileTreeNode")
            .setRootNodeExpression("new RootNode(\"Templates\")")
            .setPreferredWidth("600");
   }
}