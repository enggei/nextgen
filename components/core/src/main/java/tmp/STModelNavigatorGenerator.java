package tmp;

import nextgen.templates.nextgen.*;

public class STModelNavigatorGenerator {

   public static TreeNavigator generate() {
      return NextgenST.newTreeNavigator()
            .addMethods("public java.util.stream.Stream<nextgen.st.model.STModel> getSelectedSTModels() {\n" +
                  "	return getSelectedNodes()\n" +
                  "			.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STModel)\n" +
                  "			.map(baseTreeNode -> (nextgen.st.model.STModel) baseTreeNode.getModel());\n" +
                  "}")
            .addMethods("public java.util.stream.Stream<nextgen.st.model.STValue> getSelectedSTValues() {\n" +
                  "		return getSelectedNodes()\n" +
                  "				.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STValue)\n" +
                  "				.map(baseTreeNode -> (nextgen.st.model.STValue) baseTreeNode.getModel());\n" +
                  "	}")
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("String")
                  .setName("RootNode")
                  .addConstructorStatements("appModel().doInTransaction(transaction -> {\n" +
                        "	appModel().getProjects().forEach(stProject -> add(new STProjectTreeNode(stProject)));\n" +
                        "	add(new ModelsTreeNode(\"Models\"));\n" +
                        "});")
                  .addActions("new nextgen.actions.NewProject(tree)")
                  .addActions("new nextgen.actions.UndoDBTransaction()")
                  .setLabelExpression("getModel()"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STProject")
                  .setName("STProjectTreeNode")
                  .addGetActionsStatements("final java.util.Set<nextgen.st.model.STModel> selectedSTModels = getSelectedSTModels().collect(java.util.stream.Collectors.toSet());\n" +
                        "final java.util.Set<nextgen.st.model.STModel> projectSTModels = nextgen.utils.STModelUtil.aggregateModels(getModel());\n" +
                        "selectedSTModels.removeAll(projectSTModels);\n" +
                        "\n" +
                        "final java.util.Set<nextgen.st.model.STValue> selectedSTValues = getSelectedSTValues().collect(java.util.stream.Collectors.toSet());\n" +
                        "final java.util.Set<nextgen.st.model.STValue> projectSTValues = getModel().getValues().collect(java.util.stream.Collectors.toSet());\n" +
                        "selectedSTValues.removeAll(projectSTValues);\n" +
                        "\n" +
                        "final java.util.List<nextgen.st.model.STTemplate> stTemplates = nextgen.swing.AppModel.getInstance().getWorkspace().getSelectedSTTemplates().collect(java.util.stream.Collectors.toList());\n" +
                        "\n" +
                        "stTemplates.forEach(stNode -> actions.add(new nextgen.actions.AddTemplateModelToProject(\"Add New \" + stNode.getName(), stNode, getModel())));\n" +
                        "\n" +
                        "for (nextgen.st.model.STModel selected : selectedSTModels) \n" +
                        "	actions.add(new nextgen.actions.AddModelToProject(getModel(), selected));\n" +
                        "\n" +
                        "for (nextgen.st.model.STValue selected : selectedSTValues) \n" +
                        "	actions.add(new nextgen.actions.AddValueToProject(getModel(), selected));")
                  .addConstructorStatements("final Map<nextgen.st.model.STGroupModel, STModelNavigator.STGroupModelTreeNode> stGroupTreeNodeMap = new java.util.LinkedHashMap<>();\n" +
                        "final Map<nextgen.st.model.STTemplate, STModelNavigator.STTemplateTreeNode> stTemplateTreeNodeMap = new java.util.LinkedHashMap<>();\n" +
                        "model.getModelsSorted().forEach(stModel -> {\n" +
                        "\n" +
                        "	final nextgen.st.model.STTemplate stTemplate = stModel.getStTemplate();\n" +
                        "	final nextgen.st.model.STGroupModel stGroup = appModel().findSTGroup(stTemplate);\n" +
                        "\n" +
                        "	if (!stGroupTreeNodeMap.containsKey(stGroup)) {\n" +
                        "		final STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new STModelNavigator.STGroupModelTreeNode(stGroup);\n" +
                        "		add(stGroupModelTreeNode);\n" +
                        "		stGroupTreeNodeMap.put(stGroup, stGroupModelTreeNode);\n" +
                        "	}\n" +
                        "\n" +
                        "	if (!stTemplateTreeNodeMap.containsKey(stTemplate)) {\n" +
                        "		final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new STModelNavigator.STTemplateTreeNode(stTemplate);\n" +
                        "		stGroupTreeNodeMap.get(stGroup).add(stTemplateTreeNode);\n" +
                        "		stTemplateTreeNodeMap.put(stTemplate, stTemplateTreeNode);\n" +
                        "	}\n" +
                        "\n" +
                        "	stTemplateTreeNodeMap.get(stTemplate).add(new STModelNavigator.STModelTreeNode(stModel, stTemplate));\n" +
                        "});\n" +
                        "\n" +
                        "model.getValuesSorted().forEach(stValue -> add(new STModelNavigator.STValueTreeNode(stValue)));")
                  .addActions("new nextgen.actions.AddValueToProjectFromInput(getModel(), tree)")
                  .addActions("new nextgen.actions.AddMultipleValuesToProject(getModel(), tree)")
                  .addActions("new nextgen.actions.GenerateAllProjectModels(getModel())")
                  .setIcon("appModel().loadIcon(\"sq-white\")")
                  .setLabelExpression("getModel().getName()")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTProjectTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("String")
                  .setName("ModelsTreeNode")
                  .addConstructorStatements("appModel().doInTransaction(transaction -> {\n" +
                        "	appModel().getGroupModels().forEach(stGroupModel -> {\n" +
                        "		final STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new STModelNavigator.STGroupModelTreeNode(stGroupModel);\n" +
                        "		add(stGroupModelTreeNode);\n" +
                        "		stGroupModel.getTemplates().forEach(stTemplate -> addSTTemplateChild(stTemplate, stGroupModelTreeNode));\n" +
                        "	});\n" +
                        "});")
                  .addMethods("private void addSTTemplateChild(nextgen.st.model.STTemplate stTemplate, BaseTreeNode<?> parent) {\n" +
                        "	final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new STModelNavigator.STTemplateTreeNode(stTemplate);\n" +
                        "	parent.add(stTemplateTreeNode);\n" +
                        "\n" +
                        "	stTemplate.getIncomingStTemplateSTModel().forEach(stModel -> stTemplateTreeNode.add(new STModelTreeNode(stModel, stTemplate)));\n" +
                        "	stTemplate.getChildren().forEach(stTemplateChild -> addSTTemplateChild(stTemplateChild, stTemplateTreeNode));\n" +
                        "}")
                  .setIcon("appModel().loadIcon(\"sq-teal\")")
                  .setLabelExpression("getModel()"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STGroupModel")
                  .setName("STGroupModelTreeNode")
                  .setHasUuid(true)
                  .setLabelExpression("getModel().getName()")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTGroupTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STTemplate")
                  .setName("STTemplateTreeNode")
                  .setHasUuid(true)
                  .addGetActionsStatements("final java.util.List<nextgen.st.model.STModel> stModels = getChildren(STModelNavigator.STModelTreeNode.class)\n" +
                        "								.map(STModelNavigator.BaseTreeNode::getModel)\n" +
                        "								.collect(java.util.stream.Collectors.toList());")
                  .addGetActionsStatements("getParentNode(STProjectTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.AddTemplateModelToProject(\"New instance\", getModel(), parent.getModel())));")
                  .addGetActionsStatements("getParentNode(ModelsTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.NewSTModelAction(getModel())));")
                  .addActions("new nextgen.actions.WriteAllSTModelsToFile(stModels)")
                  .addActions("new nextgen.actions.GenerateSources(getModel(), stModels)")
                  .addActions("new nextgen.actions.AddFileSinkToSTModels(getModel(), stModels, tree)")
                  .addActions("new nextgen.actions.DeleteSTFileFromSTModels(stModels, tree)")
                  .setLabelExpression("getModel().getName()")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTTemplateTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STModel")
                  .setName("STModelTreeNode")
                  .setHasUuid(true)
                  .addFields("nextgen.st.model.STTemplate", "stTemplate")
                  .addConstructorStatements("getModel().getFiles()\n" +
                        "		.forEach(stFile -> add(new STFileSinkTreeNode(stFile)));\n" +
                        "stTemplate.getParameters()\n" +
                        "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                        "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
                  .addActions("new nextgen.actions.STModelToClipboard(getModel())")
                  .addActions("new nextgen.actions.WriteSTModelToFile(getModel())")
                  .addActions("new nextgen.actions.AddFileSink(getModel())")
                  .addActions("new nextgen.actions.CopyModel(getModel())")
                  .addActions("new nextgen.actions.GenerateSource(getModel())")
                  .addActions("new nextgen.actions.DeleteSTModel(getModel(), tree)")
                  .setIcon("appModel().loadIcon(\"sq-teal\")")
                  .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STFile")
                  .setName("STFileSinkTreeNode")
                  .setHasUuid(true)
                  .addActions("new nextgen.actions.DeleteSTFile(getModel(), tree)")
                  .setIcon("appModel().loadIcon(\"sq-white\")")
                  .setLabelExpression("appModel().render(getModel().getPath())")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTFileTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STParameter")
                  .setName("STParameterTreeNode")
                  .setHasUuid(true)
                  .addFields("nextgen.st.model.STModel", "stModel")
                  .addGetActionsStatements("final java.util.Optional<STModelNavigator.STModelTreeNode> parentNode = getParentNode(STModelNavigator.STModelTreeNode.class);\n" +
                        "\n" +
                        "final String clipboard = nextgen.utils.SwingUtil.fromClipboard();\n" +
                        "final String stModelUuid = clipboard.startsWith(\"stmodel-\") ? clipboard.replaceAll(\"stmodel-\",\"\").trim() : null;\n" +
                        "\n" +
                        "final java.util.List<nextgen.st.model.STValue> selectedSTValues = getSelectedSTValues().collect(java.util.stream.Collectors.toList());\n" +
                        "\n" +
                        "final java.util.List<nextgen.st.model.STModel> selectedSTModels = getSelectedSTModels()\n" +
                        "						.filter(stModel1 -> parentNode.isPresent())\n" +
                        "						.filter(stModel1 -> !stModel1.equals(parentNode.get().getModel()))\n" +
                        "						.collect(java.util.stream.Collectors.toList());\n" +
                        "\n" +
                        "final java.util.List<nextgen.st.model.STTemplate> stTemplates = nextgen.swing.AppModel.getInstance().getWorkspace().getSelectedSTTemplates().collect(java.util.stream.Collectors.toList());\n" +
                        "\n" +
                        "switch (getModel().getType()) {\n" +
                        "	case SINGLE:\n" +
                        "		if (stModelUuid != null) actions.add(new nextgen.actions.SetArgumentFromSTModelUuid(\"Set \" + stModelUuid, stModel, getModel(), stModelUuid));\n" +
                        "		selectedSTModels.forEach(stNode -> actions.add(new nextgen.actions.SetArgumentFromSTModel(\"Set \" + nextgen.utils.STModelUtil.getSTModelName(stNode, appModel().render(stNode, 30)), stModel, getModel(), stNode)));\n" +
                        "		selectedSTValues.forEach(stNode -> actions.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(stNode, 30), stModel, getModel(), stNode)));\n" +
                        "		stTemplates.forEach(stNode -> actions.add(new nextgen.actions.SetArgumentFromSTTemplate(\"Set New \" + stNode.getName(), stModel, getModel(), stNode)));\n" +
                        "		actions.add(new nextgen.actions.SetArgumentFromArgumentType(stModel, getModel(), tree));\n" +
                        "		actions.add(new nextgen.actions.SetArgumentFromInput(stModel, getModel(), tree));\n" +
                        "		actions.add(new nextgen.actions.SetArgumentFromClipboard(stModel, getModel()));\n" +
                        "		if (appModel().isBoolean(getModel())) actions.add(new nextgen.actions.SetArgumentToTrue(stModel, getModel()));\n" +
                        "		break;\n" +
                        "	case LIST:\n" +
                        "		if (stModelUuid != null) actions.add(new nextgen.actions.AddArgumentFromSTModelUuid(\"Add \" + stModelUuid, stModel, getModel(), stModelUuid));\n" +
                        "		selectedSTModels.forEach(stNode -> actions.add(new nextgen.actions.AddArgumentFromSTModel(\"Add \" + nextgen.utils.STModelUtil.getSTModelName(stNode, appModel().render(stNode, 30)), stModel, getModel(), stNode)));\n" +
                        "		selectedSTValues.forEach(stNode -> actions.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(stNode, 30), stModel, getModel(), stNode)));\n" +
                        "		stTemplates.forEach(stNode -> actions.add(new nextgen.actions.AddArgumentFromSTTemplate(\"Add New \" + stNode.getName(), stModel, getModel(), stNode)));\n" +
                        "		actions.add(new nextgen.actions.AddArgumentFromInput(stModel, getModel(), tree));\n" +
                        "		actions.add(new nextgen.actions.AddArgumentFromClipboard(stModel, getModel()));\n" +
                        "		actions.add(new nextgen.actions.AddArgumentFromArgumentType(stModel, getModel(), tree));\n" +
                        "		break;\n" +
                        "	case KVLIST:\n" +
                        "		actions.add(new nextgen.actions.AddKVArgument(stModel, getModel(), tree));\n" +
                        "		break;\n" +
                        "}")
                  .addConstructorStatements("stModel.getArgumentsSorted()\n" +
                        "	.filter(stArgument -> stArgument.getStParameter().equals(model))\n" +
                        "	.forEach(appModel().stArgumentConsumer(model)\n" +
                        "			.onSingleSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))\n" +
                        "			.onSingleSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" +
                        "			.onListSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))\n" +
                        "			.onListSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(),  stArgument)))\n" +
                        "			.onKVListConsumer((stArgument, stKVValues) -> addChild(new STKVArgumentTreeNode(stArgument, model))));")
                  .setLabelExpression("getModel().getName()")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTParameterTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STModel")
                  .setName("STModelArgumentTreeNode")
                  .setHasUuid(true)
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()")
                  .addPrivateFields("nextgen.st.model.STTemplate", "stTemplate", "model.getStTemplate()")
                  .addConstructorStatements("stTemplate.getParameters()\n" +
                        "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                        "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
                  .addActions("new nextgen.actions.GenerateSource(getModel())")
                  .addActions("new nextgen.actions.CopyModel(getModel())")
                  .addActions("new nextgen.actions.DeleteSTArgument(stArgument, tree)")
                  .setIcon("appModel().loadIcon(\"sq-teal\")")
                  .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STValue")
                  .setName("STValueTreeNode")
                  .setHasUuid(true)
                  .addActions("new nextgen.actions.SetSTValueFromInput(getModel(), tree)")
                  .addActions("new nextgen.actions.SetSTValueFromClipboard(getModel())")
                  .addActions("new nextgen.actions.STValueToClipboard(getModel())")
                  .addActions("new nextgen.actions.DeleteSTValue(getModel(), tree)")
                  .setIcon("appModel().loadIcon(\"sq-orange\")")
                  .setLabelExpression("appModel().render(getModel(), 30) + \"...\"")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STValue")
                  .setName("STValueArgumentTreeNode")
                  .setHasUuid(true)
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()")
                  .addActions("new nextgen.actions.STValueToClipboard(getModel())")
                  .addActions("new nextgen.actions.DeleteSTArgument(stArgument, tree)")
                  .setIcon("appModel().loadIcon(\"sq-orange\")")
                  .setLabelExpression("appModel().render(getModel(), 30) + \"...\"")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STArgument")
                  .setName("STKVArgumentTreeNode")
                  .setHasUuid(true)
                  .addFields("nextgen.st.model.STParameter", "stParameter")
                  .addGetActionsStatements("getParentNode(STModelTreeNode.class).ifPresent(parent -> {\n" +
                        "	stParameter.getKeys().forEach(stParameterKey -> {\n" +
                        "	actions.add(new nextgen.actions.SetKVArgumentFromArgumentType(parent.getModel(), getModel(), stParameterKey, tree));\n" +
                        "	actions.add(new nextgen.actions.SetKVArgumentFromInput(parent.getModel(), getModel(), stParameterKey, tree));\n" +
                        "	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(parent.getModel(), getModel(), stParameterKey));\n" +
                        "	});\n" +
                        "} );")
                  .addConstructorStatements("stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()\n" +
                        "		.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))\n" +
                        "		.findFirst()\n" +
                        "		.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));")
                  .addActions("new nextgen.actions.DeleteSTArgument(getModel(), tree)")
                  .setIcon("appModel().loadIcon(\"sq-yellow\")")
                  .setLabelExpression("appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, \"name\", stParameter::getName)"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STArgumentKV")
                  .setName("STKVTreeNode")
                  .setHasUuid(true)
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .addFields("nextgen.st.model.STParameterKey", "stParameterKey")
                  .addGetActionsStatements("getParentNode(STModelTreeNode.class).ifPresent(parent -> {\n" +
                        "	getSelectedSTModels().forEach(stModel -> actions.add(new nextgen.actions.SetKVArgumentFromSTModel(parent.getModel(), stArgument, stParameterKey, stModel)));\n" +
                        "	getSelectedSTValues().forEach(stValue -> actions.add(new nextgen.actions.SetKVArgumentFromSTValue(parent.getModel(), stArgument, stParameterKey, stValue)));\n" +
                        "	actions.add(new nextgen.actions.SetKVArgumentFromInput(parent.getModel(), stArgument, stParameterKey, tree));\n" +
                        "	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(parent.getModel(), stArgument, stParameterKey));\n" +
                        "});")
                  .addConstructorStatements("final nextgen.st.model.STValue stValue = model.getValue();\n" +
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
                        "	}")
                  .addActions("new nextgen.actions.DeleteKV(getModel(), tree)")
                  .setLabelExpression("stParameterKey.getName()"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STModel")
                  .setName("STModelKVArgumentTreeNode")
                  .setHasUuid(true)
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .addFields("nextgen.st.model.STParameterKey", "stParameterKey")
                  .addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()")
                  .addPrivateFields("nextgen.st.model.STTemplate", "stTemplate", "model.getStTemplate()")
                  .addGetActionsStatements("getParentNode(STKVTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteKV(parent.getModel(), tree)));")
                  .addConstructorStatements("stTemplate.getParameters()\n" +
                        "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                        "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
                  .setIcon("appModel().loadIcon(\"sq-teal\")")
                  .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stParameterKey.getName() + \"]\")")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());"))
            .addTreeNodes(NextgenST.newTreeNode()
                  .setModelType("nextgen.st.model.STValue")
                  .setName("STValueKVArgumentTreeNode")
                  .setHasUuid(true)
                  .addFields("nextgen.st.model.STArgument", "stArgument")
                  .addFields("nextgen.st.model.STParameterKey", "stParameterKey")
                  .addGetActionsStatements("getParentNode(STKVTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteKV(parent.getModel(), tree)));")
                  .setIcon("appModel().loadIcon(\"sq-orange\")")
                  .setLabelExpression("appModel().render(getModel(), 30)")
                  .addSelectionStatements("nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());"))
            .setBaseTreeNode(NextgenST.newBaseTreeNode())
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTFileSinkTreeNode(treeNode -> treeNode.getModel().equals(event.stFile))\n" +
                        "		.ifPresent(STModelNavigator.STFileSinkTreeNode::nodeChanged);")
                  .setEventName("STFileChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findRootNode().ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STProjectTreeNode(event.project)));")
                  .setEventName("NewSTProject"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel))\n" +
                        "		.ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STFileSinkTreeNode(event.stFile)));")
                  .setEventName("NewFileSink"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model))\n" +
                        "		.flatMap(treeNode -> findSTParameterTreeNode(treeNode, stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.parameter)))\n" +
                        "		.ifPresent(stParameterTreeNode -> appModel().stArgumentConsumer(event.parameter)\n" +
                        "				.onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STValueArgumentTreeNode(stValue, stArgument)))\n" +
                        "				.onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" +
                        "				.onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STValueArgumentTreeNode(stValue, stArgument)))\n" +
                        "				.onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" +
                        "				.onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STKVArgumentTreeNode(stArgument, event.parameter)))\n" +
                        "				.accept(event.argument));")
                  .setEventName("NewSTArgument"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model))\n" +
                        "		.flatMap(treeNode -> findSTParameterTreeNode(treeNode, stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.stParameter)))\n" +
                        "		.ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STModelNavigator.STKVArgumentTreeNode(event.argument, event.stParameter)));")
                  .setEventName("NewSTKVArgument"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.argument.getUuid())).ifPresent(treeNode -> {\n" +
                        "	treeModel.addNodeInSortedOrderAndSelect(treeNode, new STModelNavigator.STKVTreeNode(event.kv, treeNode.getModel(), event.stParameterKey));\n" +
                        "	treeNode.nodeChanged();\n" +
                        "});")
                  .setEventName("NewKV"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findModelsTreeNode()\n" +
                        "		.flatMap(modelsTreeNode -> findSTGroupModelTreeNode(modelsTreeNode, treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "				.flatMap(treeNode -> findSTTemplateTreeNode(treeNode, stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(event.template))))\n" +
                        "		.ifPresent(stTemplateTreeNode -> treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode, new STModelNavigator.STModelTreeNode(event.model, event.template)));")
                  .setEventName("NewSTModel"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTProjectTreeNode(stProjectTreeNode -> stProjectTreeNode.getModel().equals(event.project))\n" +
                        "		.ifPresent(stProjectTreeNode -> {\n" +
                        "			final nextgen.st.model.STGroupModel stGroup = appModel().findSTGroup(event.template);\n" +
                        "			final java.util.Optional<STModelNavigator.STGroupModelTreeNode> groupModelTreeNode = findSTGroupModelTreeNode(stProjectTreeNode, stGroupModelTreeNode -> stGroupModelTreeNode.getModel().equals(stGroup));\n" +
                        "			if (groupModelTreeNode.isPresent()) {\n" +
                        "				final java.util.Optional<STModelNavigator.STTemplateTreeNode> stTemplateTreeNode = findSTTemplateTreeNode(groupModelTreeNode.get(), stTemplateTreeNode1 -> stTemplateTreeNode1.getModel().equals(event.template));\n" +
                        "				if (stTemplateTreeNode.isPresent()) {\n" +
                        "					treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode.get(), new STModelNavigator.STModelTreeNode(event.model, event.template));\n" +
                        "				} else {\n" +
                        "					final STModelNavigator.STTemplateTreeNode newSTTemplateTreeNode = new STModelNavigator.STTemplateTreeNode(event.template);\n" +
                        "					treeModel.addNodeInSortedOrder(groupModelTreeNode.get(), newSTTemplateTreeNode);\n" +
                        "					treeModel.addNodeInSortedOrderAndSelect(newSTTemplateTreeNode, new STModelNavigator.STModelTreeNode(event.model, event.template));\n" +
                        "				}\n" +
                        "\n" +
                        "			} else {\n" +
                        "				final STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new STModelNavigator.STGroupModelTreeNode(stGroup);\n" +
                        "				treeModel.addNodeInSortedOrder(stProjectTreeNode, stGroupModelTreeNode);\n" +
                        "				final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new STModelNavigator.STTemplateTreeNode(event.template);\n" +
                        "				treeModel.addNodeInSortedOrder(stGroupModelTreeNode, stTemplateTreeNode);\n" +
                        "				treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode, new STModelNavigator.STModelTreeNode(event.model, event.template));\n" +
                        "			}\n" +
                        "		});")
                  .setEventName("NewSTProjectSTModel"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTProjectTreeNode(treeNode -> treeNode.getModel().equals(event.project))\n" +
                        "		.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STModelNavigator.STValueTreeNode(event.value)));")
                  .setEventName("NewSTProjectSTValue"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.value))\n" +
                        "		.ifPresent(STModelNavigator.BaseTreeNode::nodeChanged);")
                  .setEventName("STValueChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTModelArgumentTreeNode(stModelArgumentTreeNode -> stModelArgumentTreeNode.stArgument.equals(event.stArgument)).ifPresent(treeModel::nodeChanged);\n" +
                        "findSTValueArgumentTreeNode(stModelArgumentTreeNode -> stModelArgumentTreeNode.stArgument.equals(event.stArgument)).ifPresent(treeModel::nodeChanged);")
                  .setEventName("STArgumentChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model))\n" +
                        "		.ifPresent(STModelNavigator.BaseTreeNode::nodeChanged);")
                  .setEventName("STModelChanged"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("SwingUtilities.invokeLater(() -> findSTModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))\n" +
                        "		.ifPresent(treeModel::removeNodeFromParent));")
                  .setEventName("STModelDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("SwingUtilities.invokeLater(() -> {\n" +
                        "	findSTValueTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "	findSTValueArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "	findSTValueKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "});")
                  .setEventName("STValueDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("SwingUtilities.invokeLater(() -> findSTGroupModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))\n" +
                        "		.ifPresent(treeModel::removeNodeFromParent));")
                  .setEventName("STGroupDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTFileSinkTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))\n" +
                        "		.ifPresent(treeModel::removeNodeFromParent);")
                  .setEventName("STFileDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTKVTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))\n" +
                        "		.ifPresent(treeModel::removeNodeFromParent);")
                  .setEventName("KVDeleted"))
            .addEvents(NextgenST.newEventSubscription()
                  .addStatements("findSTValueArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "findSTModelArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);")
                  .setEventName("STArgumentDeleted"))
            .setPackageName("nextgen.swing")
            .setName("STModelNavigator")
            .addFields("STWorkspace", "workspace")
            .setPreferredHeight("600")
            .addConstructorStatements("org.greenrobot.eventbus.EventBus.getDefault().register(this);")
            .addTreeNodesSelected("RootNode")
            .addTreeNodesSelected("STProjectTreeNode")
            .addTreeNodesSelected("ModelsTreeNode")
            .addTreeNodesSelected("STGroupModelTreeNode")
            .addTreeNodesSelected("STTemplateTreeNode")
            .addTreeNodesSelected("STModelTreeNode")
            .addTreeNodesSelected("STFileSinkTreeNode")
            .addTreeNodesSelected("STParameterTreeNode")
            .addTreeNodesSelected("STModelArgumentTreeNode")
            .addTreeNodesSelected("STValueTreeNode")
            .addTreeNodesSelected("STValueArgumentTreeNode")
            .addTreeNodesSelected("STKVArgumentTreeNode")
            .addTreeNodesSelected("STKVTreeNode")
            .addTreeNodesSelected("STModelKVArgumentTreeNode")
            .addTreeNodesSelected("STValueKVArgumentTreeNode")
            .setRootNodeExpression("new RootNode(\"Projects\")")
            .setPreferredWidth("800");
   }
}