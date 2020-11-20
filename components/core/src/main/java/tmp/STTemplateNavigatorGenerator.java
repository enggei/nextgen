package tmp;

import nextgen.templates.nextgen.*;

public class STTemplateNavigatorGenerator {

   public static TreeNavigator generate() {
      return NextgenST.newTreeNavigator()
            .setPackageName("nextgen.st")
            .setName("STTemplateNavigator")
            .addFields("STWorkspace", "workspace")
            .setRootNodeExpression("new RootNode(\"Templates\")")
            .setPreferredWidth("600")
            .setPreferredHeight("500")
            .addConstructorStatements("org.greenrobot.eventbus.EventBus.getDefault().register(this);")
            .addTreeNodesSelected("STGroupTreeNode")
            .addTreeNodesSelected("STEnumTreeNode")
            .addTreeNodesSelected("STTemplateTreeNode")
            .addTreeNodesSelected("STInterfaceTreeNode")
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("ModelNavigatorSTModelTreeNodeClicked")
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate)).ifPresent(treeModel::select);"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("STGroupDeleted")
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("STEnumDeleted")
                  .addStatements("findSTEnumTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("STTemplateDeleted")
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("STInterfaceDeleted")
                  .addStatements("findSTInterfaceTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("NewSTGroup")
                  .addStatements("treeModel.addNodeInSortedOrderAndSelect((RootNode) treeModel.getRoot(), new nextgen.swing.STTemplateNavigator.STGroupTreeNode(event.group));"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("NewSTEnum")
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "					.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STEnumTreeNode(event.stEnum)));"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("NewSTInterface")
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "					.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STInterfaceTreeNode(event.stInterface)));"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("NewSTGroupTemplate")
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.parent))\n" +
                        "					.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("NewSTTemplateChild")
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.parent))\n" +
                        "					.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("STGroupNameChanged")
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "					.ifPresent(nextgen.swing.STTemplateNavigator.STGroupTreeNode::nodeChanged);"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("STTemplateNameChanged")
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate))\n" +
                        "					.ifPresent(nextgen.swing.STTemplateNavigator.STTemplateTreeNode::nodeChanged);"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("STInterfaceNameChanged")
                  .addStatements("findSTInterfaceTreeNode(treeNode -> treeNode.getModel().equals(event.stInterface))\n" +
                        "					.ifPresent(STTemplateNavigator.STInterfaceTreeNode::nodeChanged);"))
            .addEvents(NextgenST.newEventSubscription()
                  .setEventName("STEnumNameChanged")
                  .addStatements("findSTEnumTreeNode(treeNode -> treeNode.getModel().equals(event.stEnum))\n" +
                        "					.ifPresent(STTemplateNavigator.STEnumTreeNode::nodeChanged);"))
            .setBaseTreeNode(NextgenST.newBaseTreeNode())
            .addTreeNodes(NextgenST.newTreeNode()
                  .setName("RootNode")
                  .setModelType("String")
                  .setLabelExpression("getModel()")
                  .addConstructorStatements("appModel().stGroups.forEach(stGroup -> add(new STGroupTreeNode(stGroup)));")
                  .addActions("new nextgen.actions.NewSTGroupAction(tree)")
                  .addActions("new nextgen.actions.GenerateAllSTGroups()"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setName("STGroupTreeNode")
                  .setModelType("nextgen.st.model.STGroupModel")
                  .setHasUuid(true)
                  .setLabelExpression("getModel().getName()")
                  .addConstructorStatements("model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));\n" +
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
                  .addSelectionStatements("nextgen.events.TemplateNavigatorSTGroupTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setName("STEnumTreeNode")
                  .setModelType("nextgen.st.model.STEnum")
                  .setHasUuid(true)
                  .setIcon("appModel().loadIcon(\"sq-green\")")
                  .setLabelExpression("getModel().getName()")
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.RenameEnum(getModel(), parent.getModel(), tree)));")
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteEnum(getModel(), parent.getModel(), tree)));")
                  .addActions("new nextgen.actions.EditEnum(getModel(), tree)")
                  .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> { nextgen.events.TemplateNavigatorSTEnumTreeNodeClicked.post(stGroupTreeNode.getModel(), selectedNode.getModel()); });"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setName("STTemplateTreeNode")
                  .setModelType("nextgen.st.model.STTemplate")
                  .setHasUuid(true)
                  .setIcon("appModel().loadIcon(\"sq-teal\")")
                  .setLabelExpression("getModel().getName()")
                  .addConstructorStatements("model.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));")
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
                        "	actions.add(new nextgen.actions.DeleteSTTemplate(getModel(), parent.getModel(), tree));\n" +
                        "});")
                  .addMethods("private java.util.Set<nextgen.st.model.STTemplate> getSelectedTemplates() {\n" +
                        "			return getSelectedSTTemplateTreeNodes()\n" +
                        "					.filter(stTemplateTreeNode -> !stTemplateTreeNode.equals(this))\n" +
                        "					.map(nextgen.swing.STTemplateNavigator.BaseTreeNode::getModel)\n" +
                        "					.collect(java.util.stream.Collectors.toSet());\n" +
                        "		}")
                  .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(parent -> { \n" +
                        "	final nextgen.swing.STTemplateNavigator.STTemplateTreeNode stTemplateTreeNode = selectedNode.getParentNode(nextgen.swing.STTemplateNavigator.STTemplateTreeNode.class).orElse(null);\n" +
                        "	nextgen.events.TemplateNavigatorSTTemplateTreeNodeClicked.post(parent.getModel(), stTemplateTreeNode == null ? null : stTemplateTreeNode.getModel(), selectedNode.getModel());\n" +
                        "});"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setName("STInterfaceTreeNode")
                  .setModelType("nextgen.st.model.STInterface")
                  .setHasUuid(true)
                  .setIcon("appModel().loadIcon(\"sq-red\")")
                  .setLabelExpression("getModel().getName()")
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.RenameSTInterface(getModel(), parent.getModel(), tree)));")
                  .addGetActionsStatements("getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteSTInterface(getModel(), parent.getModel(), tree)));"));
   }
}