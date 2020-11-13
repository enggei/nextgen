package tmp;

import nextgen.templates.nextgen.*;

public class STModelNavigatorGenerator {

	public static TreeNavigator generate(){ 
		return NextgenST.newTreeNavigator().setPackageName("nextgen.st").setName("STModelNavigator").addFields("STWorkspace", "workspace").setRootNodeExpression("new RootNode(\"Projects\")").setPreferredWidth("800").setPreferredHeight("600").addConstructorStatements("org.greenrobot.eventbus.EventBus.getDefault().register(this);").addTreeNodesSelected("RootNode").addTreeNodesSelected("STProjectTreeNode").addTreeNodesSelected("ModelsTreeNode").addTreeNodesSelected("STGroupModelTreeNode").addTreeNodesSelected("STTemplateTreeNode").addTreeNodesSelected("STModelTreeNode").addTreeNodesSelected("STFileSinkTreeNode").addTreeNodesSelected("STParameterTreeNode").addTreeNodesSelected("STModelArgumentTreeNode").addTreeNodesSelected("STValueTreeNode").addTreeNodesSelected("STValueArgumentTreeNode").addTreeNodesSelected("STKVArgumentTreeNode").addTreeNodesSelected("STKVTreeNode").addTreeNodesSelected("STModelKVArgumentTreeNode").addTreeNodesSelected("STValueKVArgumentTreeNode").addEvents(NextgenST.newEventSubscription().setEventName("NewSTProject").addStatements("findRootNode().ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STProjectTreeNode(event.project)));")).addEvents(NextgenST.newEventSubscription().setEventName("NewFileSink").addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel)).ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STFileSinkTreeNode(event.stFile)));")).addEvents(NextgenST.newEventSubscription().setEventName("NewSTArgument").addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model))\n" + 
					"		.flatMap(treeNode -> findSTParameterTreeNode(treeNode, stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.parameter)))\n" + 
					"		.ifPresent(stParameterTreeNode -> appModel().stArgumentConsumer(event.parameter)\n" + 
					"				.onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STValueArgumentTreeNode(stValue, stArgument)))\n" + 
					"				.onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" + 
					"				.onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STValueArgumentTreeNode(stValue, stArgument)))\n" + 
					"				.onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" + 
					"				.onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STKVArgumentTreeNode(stArgument, event.parameter)))\n" + 
					"				.accept(event.argument));")).addEvents(NextgenST.newEventSubscription().setEventName("NewSTKVArgument").addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model))\n" + 
					"		.flatMap(treeNode -> findSTParameterTreeNode(treeNode, stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.stParameter)))\n" + 
					"		.ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new nextgen.st.STModelNavigator.STKVArgumentTreeNode(event.argument, event.stParameter)));")).addEvents(NextgenST.newEventSubscription().setEventName("NewKV").addStatements("findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.argument.getUuid()))\n" + 
					"		.ifPresent(treeNode -> {\n" + 
					"			treeModel.addNodeInSortedOrderAndSelect(treeNode, new nextgen.st.STModelNavigator.STKVTreeNode(event.kv, treeNode.getModel(), event.stParameterKey));\n" + 
					"		});")).addEvents(NextgenST.newEventSubscription().setEventName("NewSTModel").addStatements("findModelsTreeNode()\n" + 
					"		.flatMap(modelsTreeNode -> findSTGroupModelTreeNode(modelsTreeNode, treeNode -> treeNode.getModel().equals(event.stGroup))\n" + 
					"				.flatMap(treeNode -> findSTTemplateTreeNode(treeNode, stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(event.template))))\n" + 
					"		.ifPresent(stTemplateTreeNode -> treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template)));")).addEvents(NextgenST.newEventSubscription().setEventName("NewSTProjectSTModel").addStatements("findSTProjectTreeNode(stProjectTreeNode -> stProjectTreeNode.getModel().equals(event.project))\n" + 
					"		.ifPresent(stProjectTreeNode -> {\n" + 
					"			final nextgen.st.model.STGroupModel stGroup = appModel().findSTGroup(event.template);\n" +
					"			final java.util.Optional<nextgen.st.STModelNavigator.STGroupModelTreeNode> groupModelTreeNode = findSTGroupModelTreeNode(stProjectTreeNode, stGroupModelTreeNode -> stGroupModelTreeNode.getModel().equals(stGroup));\n" + 
					"			if (groupModelTreeNode.isPresent()) {\n" + 
					"				final java.util.Optional<nextgen.st.STModelNavigator.STTemplateTreeNode> stTemplateTreeNode = findSTTemplateTreeNode(groupModelTreeNode.get(), stTemplateTreeNode1 -> stTemplateTreeNode1.getModel().equals(event.template));\n" + 
					"				if (stTemplateTreeNode.isPresent()) {\n" + 
					"					treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode.get(), new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template));\n" + 
					"				} else {\n" + 
					"					final nextgen.st.STModelNavigator.STTemplateTreeNode newSTTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(event.template);\n" + 
					"					treeModel.addNodeInSortedOrder(groupModelTreeNode.get(), newSTTemplateTreeNode);\n" + 
					"					treeModel.addNodeInSortedOrderAndSelect(newSTTemplateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template));\n" + 
					"				}\n" + 
					"\n" + 
					"			} else {\n" + 
					"				final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroup);\n" + 
					"				treeModel.addNodeInSortedOrder(stProjectTreeNode, stGroupModelTreeNode);\n" + 
					"				final nextgen.st.STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(event.template);\n" + 
					"				treeModel.addNodeInSortedOrder(stGroupModelTreeNode, stTemplateTreeNode);\n" + 
					"				treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template));\n" + 
					"			}\n" + 
					"		});")).addEvents(NextgenST.newEventSubscription().setEventName("NewSTProjectSTValue").addStatements("findSTProjectTreeNode(treeNode -> treeNode.getModel().equals(event.project))\n" + 
					"		.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new nextgen.st.STModelNavigator.STValueTreeNode(event.value)));")).addEvents(NextgenST.newEventSubscription().setEventName("STValueChanged").addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.value)).ifPresent(nextgen.st.STModelNavigator.BaseTreeNode::nodeChanged);")).addEvents(NextgenST.newEventSubscription().setEventName("STArgumentChanged").addStatements("findSTModelArgumentTreeNode(stModelArgumentTreeNode -> stModelArgumentTreeNode.stArgument.equals(event.stArgument)).ifPresent(treeModel::nodeChanged);\n" + 
					"findSTValueArgumentTreeNode(stModelArgumentTreeNode -> stModelArgumentTreeNode.stArgument.equals(event.stArgument)).ifPresent(treeModel::nodeChanged);")).addEvents(NextgenST.newEventSubscription().setEventName("STModelChanged").addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model)).ifPresent(nextgen.st.STModelNavigator.BaseTreeNode::nodeChanged);")).addEvents(NextgenST.newEventSubscription().setEventName("STModelDeleted").addStatements("SwingUtilities.invokeLater(() -> findSTModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));")).addEvents(NextgenST.newEventSubscription().setEventName("STValueDeleted").addStatements("SwingUtilities.invokeLater(() -> {\n" + 
					"	findSTValueTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" + 
					"	findSTValueArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" + 
					"	findSTValueKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" + 
					"});")).addEvents(NextgenST.newEventSubscription().setEventName("STGroupDeleted").addStatements("SwingUtilities.invokeLater(() -> findSTGroupModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));")).addEvents(NextgenST.newEventSubscription().setEventName("STFileDeleted").addStatements("findSTFileSinkTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);")).addEvents(NextgenST.newEventSubscription().setEventName("KVDeleted").addStatements("findSTKVTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);")).addEvents(NextgenST.newEventSubscription().setEventName("STArgumentDeleted").addStatements("findSTValueArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" + 
					"findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" + 
					"findSTModelArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" + 
					"findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);")).setBaseTreeNode(NextgenST.newBaseTreeNode()).addTreeNodes(NextgenST.newTreeNode().setName("RootNode").setModelType("String").setLabelExpression("getModel()").addConstructorStatements("appModel().doInTransaction(transaction -> {\n" + 
					"	appModel().getProjects().forEach(stProject -> add(new STProjectTreeNode(stProject)));\n" + 
					"	add(new ModelsTreeNode(\"Models\"));\n" + 
					"});").addActions("new nextgen.actions.NewProject(tree)").addActions("new nextgen.actions.UndoDBTransaction()")).addTreeNodes(NextgenST.newTreeNode().setName("STProjectTreeNode").setModelType("nextgen.st.model.STProject").setIcon("appModel().loadIcon(\"sq-white\")").setLabelExpression("getModel().getName()").addConstructorStatements("final Map<nextgen.st.model.STGroupModel, STModelNavigator.STGroupModelTreeNode> stGroupTreeNodeMap = new java.util.LinkedHashMap<>();\n" +
					"final Map<nextgen.st.model.STTemplate, STModelNavigator.STTemplateTreeNode> stTemplateTreeNodeMap = new java.util.LinkedHashMap<>();\n" +
					"model.getModelsSorted().forEach(stModel -> {\n" + 
					"\n" + 
					"	final nextgen.st.model.STTemplate stTemplate = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
					"	final nextgen.st.model.STGroupModel stGroup = appModel().findSTGroup(stTemplate);\n" +
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
					"	stTemplateTreeNodeMap.get(stTemplate).add(new nextgen.st.STModelNavigator.STModelTreeNode(stModel, stTemplate));\n" + 
					"});\n" + 
					"\n" + 
					"model.getValuesSorted().forEach(stValue -> add(new nextgen.st.STModelNavigator.STValueTreeNode(stValue)));").addActions("new nextgen.actions.AddValueToProjectFromInput(getModel(), tree)").addActions("new nextgen.actions.AddMultipleValuesToProject(getModel(), tree)").addActions("new nextgen.actions.GenerateAllProjectModels(getModel())").addSelectionStatements("nextgen.events.ModelNavigatorSTProjectTreeNodeClicked.post(selectedNode.getModel());")).addTreeNodes(NextgenST.newTreeNode().setName("ModelsTreeNode").setModelType("String").setIcon("appModel().loadIcon(\"sq-teal\")").setLabelExpression("getModel()").addConstructorStatements("appModel().doInTransaction(transaction -> {\n" + 
					"	appModel().getGroupModels().forEach(stGroupModel -> {\n" + 
					"		final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroupModel);\n" + 
					"		add(stGroupModelTreeNode);\n" + 
					"		stGroupModel.getTemplates().forEach(stTemplate -> addSTTemplateChild(stTemplate, stGroupModelTreeNode));\n" + 
					"	});\n" + 
					"});").addMethods("private void addSTTemplateChild(nextgen.st.model.STTemplate stTemplate, BaseTreeNode<?> parent) {\n" +
					"	final nextgen.st.STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);\n" + 
					"	parent.add(stTemplateTreeNode);\n" + 
					"\n" + 
					"	appModel().db.findAllSTModelByStTemplate(stTemplate.getUuid()).forEach(stModel -> stTemplateTreeNode.add(new STModelTreeNode(stModel, stTemplate)));\n" + 
					"	stTemplate.getChildren().forEach(stTemplateChild -> addSTTemplateChild(stTemplateChild, stTemplateTreeNode));\n" + 
					"}")).addTreeNodes(NextgenST.newTreeNode().setName("STGroupModelTreeNode").setModelType("nextgen.st.model.STGroupModel").setHasUuid(true).setLabelExpression("getModel().getName()")).addTreeNodes(NextgenST.newTreeNode().setName("STTemplateTreeNode").setModelType("nextgen.st.model.STTemplate").setHasUuid(true).setLabelExpression("getModel().getName()").addGetActionsStatements("final java.util.List<nextgen.st.model.STModel> stModels = getChildren(nextgen.st.STModelNavigator.STModelTreeNode.class)\n" +
					"								.map(nextgen.st.STModelNavigator.BaseTreeNode::getModel)\n" + 
					"								.collect(java.util.stream.Collectors.toList());").addGetActionsStatements("getParentNode(STProjectTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.AddTemplateModelToProject(\"New instance\", getModel(), parent.getModel())));").addGetActionsStatements("getParentNode(ModelsTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.NewSTModelAction(getModel())));").addActions("new nextgen.actions.EditModels(getModel())").addActions("new nextgen.actions.WriteAllSTModelsToFile(stModels)").addActions("new nextgen.actions.GenerateSources(getModel(), stModels)").addActions("new nextgen.actions.AddFileSinkToSTModels(getModel(), stModels, tree)").addActions("new nextgen.actions.DeleteSTFileFromSTModels(stModels, tree)")).addTreeNodes(NextgenST.newTreeNode().setName("STModelTreeNode").setModelType("nextgen.st.model.STModel").setHasUuid(true).addFields("nextgen.st.model.STTemplate", "stTemplate").setIcon("appModel().loadIcon(\"sq-teal\")").setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")").addConstructorStatements("getModel().getFiles()\n" +
					"		.forEach(stFile -> add(new STFileSinkTreeNode(stFile)));\n" + 
					"stTemplate.getParameters()\n" + 
					"		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" + 
					"		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));").addActions("new nextgen.actions.WriteSTModelToFile(getModel())").addActions("new nextgen.actions.AddFileSink(getModel(), tree)").addActions("new nextgen.actions.CopyModel(getModel())").addActions("new nextgen.actions.GenerateSource(getModel())").addActions("new nextgen.actions.OpenSTModelAction(getModel())").addActions("new nextgen.actions.VisitSTModel(getModel())").addActions("new nextgen.actions.EditSTModel(getModel())").addActions("new nextgen.actions.DeleteSTModel(getModel(), tree)")).addTreeNodes(NextgenST.newTreeNode().setName("STFileSinkTreeNode").setModelType("nextgen.st.model.STFile").setHasUuid(true).setIcon("appModel().loadIcon(\"sq-white\")").setLabelExpression("appModel().render(getModel().getPath())").addActions("new nextgen.actions.DeleteSTFile(getModel(), tree)")).addTreeNodes(NextgenST.newTreeNode().setName("STParameterTreeNode").setModelType("nextgen.st.model.STParameter").setHasUuid(true).addFields("nextgen.st.model.STModel", "stModel").setLabelExpression("getModel().getName()").addConstructorStatements("stModel.getArgumentsSorted()\n" +
					"	.filter(stArgument -> stArgument.getStParameter().equals(model))\n" +
					"	.forEach(appModel().stArgumentConsumer(model)\n" + 
					"			.onSingleSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))\n" + 
					"			.onSingleSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" + 
					"			.onListSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))\n" + 
					"			.onListSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(),  stArgument)))\n" + 
					"			.onKVListConsumer((stArgument, stKVValues) -> addChild(new STKVArgumentTreeNode(stArgument, model))));").addGetActionsStatements("final java.util.Optional<nextgen.st.STModelNavigator.STModelTreeNode> parentNode = getParentNode(nextgen.st.STModelNavigator.STModelTreeNode.class);").addGetActionsStatements("final java.util.List<nextgen.st.model.STModel> selectedSTModels = getSelectedSTModels()\n" + 
					"						.filter(stModel1 -> parentNode.isPresent())\n" + 
					"						.filter(stModel1 -> !stModel1.equals(parentNode.get().getModel()))\n" + 
					"						.collect(java.util.stream.Collectors.toList());").addGetActionsStatements("final java.util.List<nextgen.st.model.STValue> selectedSTValues = getSelectedSTValues().collect(java.util.stream.Collectors.toList());").addGetActionsStatements("switch (getModel().getType()) {\n" + 
					"	case SINGLE:\n" + 
					"		selectedSTModels.forEach(stNode -> actions.add(new nextgen.actions.SetArgumentFromSTModel(\"Set \" + appModel().getSTModelName(stNode, appModel().render(stNode, 30)), stModel, getModel(), stNode)));\n" + 
					"		selectedSTValues.forEach(stNode -> actions.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(stNode, 30), stModel, getModel(), stNode)));\n" + 
					"		actions.add(new nextgen.actions.SetArgumentFromInput(stModel, getModel(), tree));\n" + 
					"		actions.add(new nextgen.actions.SetArgumentFromClipboard(stModel, getModel()));\n" + 
					"		if (appModel().isBoolean(getModel())) actions.add(new nextgen.actions.SetArgumentToTrue(stModel, getModel()));\n" + 
					"		break;\n" + 
					"	case LIST:\n" + 
					"		selectedSTModels.forEach(stNode -> actions.add(new nextgen.actions.AddArgumentFromSTModel(\"Add \" + appModel().getSTModelName(stNode, appModel().render(stNode, 30)), stModel, getModel(), stNode)));\n" + 
					"		selectedSTValues.forEach(stNode -> actions.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(stNode, 30), stModel, getModel(), stNode)));\n" + 
					"		actions.add(new nextgen.actions.AddArgumentFromInput(stModel, getModel(), tree));\n" + 
					"		actions.add(new nextgen.actions.AddArgumentFromClipboard(stModel, getModel()));\n" + 
					"		actions.add(new nextgen.actions.AddArgumentFromArgumentType(stModel, getModel(), tree));\n" + 
					"		break;\n" + 
					"	case KVLIST:\n" + 
					"		actions.add(new nextgen.actions.AddKVArgument(stModel, getModel(), tree));\n" + 
					"		break;\n" + 
					"}").addSelectionStatements("nextgen.events.ModelNavigatorSTParameterTreeNodeClicked.post(selectedNode.getModel());")).addTreeNodes(NextgenST.newTreeNode().setName("STModelArgumentTreeNode").setModelType("nextgen.st.model.STModel").setHasUuid(true).addFields("nextgen.st.model.STArgument", "stArgument").addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()").addPrivateFields("nextgen.st.model.STTemplate", "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())").setIcon("appModel().loadIcon(\"sq-teal\")").setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")").addConstructorStatements("stTemplate.getParameters()\n" +
					"		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" + 
					"		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));").addActions("new nextgen.actions.GenerateSource(getModel())").addActions("new nextgen.actions.CopyModel(getModel())").addActions("new nextgen.actions.DeleteSTArgument(stArgument, tree)").addSelectionStatements("nextgen.events.ModelNavigatorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());")).addTreeNodes(NextgenST.newTreeNode().setName("STValueTreeNode").setModelType("nextgen.st.model.STValue").setHasUuid(true).setIcon("appModel().loadIcon(\"sq-orange\")").setLabelExpression("appModel().render(getModel(), 30)").addActions("new nextgen.actions.SetSTValueFromInput(getModel(), tree)").addActions("new nextgen.actions.SetSTValueFromClipboard(getModel())").addActions("new nextgen.actions.STValueToClipboard(getModel())").addActions("new nextgen.actions.DeleteSTValue(getModel(), tree)").addSelectionStatements("nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());")).addTreeNodes(NextgenST.newTreeNode().setName("STValueArgumentTreeNode").setModelType("nextgen.st.model.STValue").setHasUuid(true).addFields("nextgen.st.model.STArgument", "stArgument").addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()").setIcon("appModel().loadIcon(\"sq-orange\")").setLabelExpression("appModel().render(getModel(), 30)").addActions("new nextgen.actions.STValueToClipboard(getModel())").addActions("new nextgen.actions.DeleteSTArgument(stArgument, tree)").addSelectionStatements("nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());")).addTreeNodes(NextgenST.newTreeNode().setName("STKVArgumentTreeNode").setModelType("nextgen.st.model.STArgument").setHasUuid(true).addFields("nextgen.st.model.STParameter", "stParameter").setIcon("appModel().loadIcon(\"sq-yellow\")").setLabelExpression("appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, \"name\", stParameter::getName)").addConstructorStatements("stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()\n" +
					"		.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))\n" +
					"		.findFirst()\n" + 
					"		.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));").addGetActionsStatements("getParentNode(STModelTreeNode.class).ifPresent(parent -> {\n" + 
					"	stParameter.getKeys().forEach(stParameterKey -> {\n" + 
					"	actions.add(new nextgen.actions.SetKVArgumentFromInput(parent.getModel(), getModel(), stParameterKey, tree));\n" + 
					"	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(parent.getModel(), getModel(), stParameterKey));\n" + 
					"	});\n" + 
					"} );").addActions("new nextgen.actions.DeleteSTArgument(getModel(), tree)")).addTreeNodes(NextgenST.newTreeNode().setName("STKVTreeNode").setModelType("nextgen.st.model.STArgumentKV").setHasUuid(true).addFields("nextgen.st.model.STArgument", "stArgument").addFields("nextgen.st.model.STParameterKey", "stParameterKey").setLabelExpression("stParameterKey.getName()").addConstructorStatements("final nextgen.st.model.STValue stValue = model.getValue();\n" +
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
					"	}").addGetActionsStatements("getParentNode(STModelTreeNode.class).ifPresent(parent -> {\n" + 
					"	actions.add(new nextgen.actions.SetKVArgumentFromInput(parent.getModel(), stArgument, stParameterKey, tree));\n" + 
					"	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(parent.getModel(), stArgument, stParameterKey));\n" + 
					"} );").addActions("new nextgen.actions.DeleteKV(getModel(), tree)")).addTreeNodes(NextgenST.newTreeNode().setName("STModelKVArgumentTreeNode").setModelType("nextgen.st.model.STModel").setHasUuid(true).addFields("nextgen.st.model.STArgument", "stArgument").addFields("nextgen.st.model.STParameterKey", "stParameterKey").addPrivateFields("String", "stArgumentUuid", "stArgument.getUuid()").addPrivateFields("nextgen.st.model.STTemplate", "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())").setIcon("appModel().loadIcon(\"sq-teal\")").setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stParameterKey.getName() + \"]\")").addGetActionsStatements("getParentNode(STKVTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteKV(parent.getModel(), tree)));").addSelectionStatements("nextgen.events.ModelNavigatorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());")).addTreeNodes(NextgenST.newTreeNode().setName("STValueKVArgumentTreeNode").setModelType("nextgen.st.model.STValue").setHasUuid(true).addFields("nextgen.st.model.STArgument", "stArgument").addFields("nextgen.st.model.STParameterKey", "stParameterKey").setIcon("appModel().loadIcon(\"sq-orange\")").setLabelExpression("appModel().render(getModel(), 30)").addGetActionsStatements("getParentNode(STKVTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteKV(parent.getModel(), tree)));").addSelectionStatements("nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());")).addMethods("public java.util.stream.Stream<nextgen.st.model.STModel> getSelectedSTModels() {\n" +
					"		return getSelectedNodes()\n" + 
					"				.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STModel)\n" + 
					"				.map(baseTreeNode -> (nextgen.st.model.STModel) baseTreeNode.getModel());\n" + 
					"	}").addMethods("public java.util.stream.Stream<nextgen.st.model.STValue> getSelectedSTValues() {\n" + 
					"		return getSelectedNodes()\n" + 
					"				.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STValue)\n" + 
					"				.map(baseTreeNode -> (nextgen.st.model.STValue) baseTreeNode.getModel());\n" + 
					"	}");
	}
}