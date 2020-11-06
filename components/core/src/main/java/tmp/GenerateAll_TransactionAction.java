package tmp;

import nextgen.templates.nextgen.*;

public class GenerateAll_TransactionAction {

	public static java.util.List<TransactionAction> generate(){ 
		final java.util.List<TransactionAction> list = new java.util.ArrayList<>();
		final TransactionAction AddArgumentFromArgumentType = NextgenST.newTransactionAction().setName("AddArgumentFromArgumentType").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("javax.swing.JComponent", "owner").setTitle("Add").addStatements("final String argumentType = stParameter.getArgumentType();\n" + 
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
					"}");
		final TransactionAction AddArgumentFromClipboard = NextgenST.newTransactionAction().setName("AddArgumentFromClipboard").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").setTitle("Add from Clipboard").addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());\n" + 
					"final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" + 
					"stModel.addArguments(stArgument);\n" + 
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction AddArgumentFromInput = NextgenST.newTransactionAction().setName("AddArgumentFromInput").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("javax.swing.JComponent", "owner").setTitle("Add from Input").addStatements("input(owner, stParameter.getName(), inputValue -> {\n" + 
					"   final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);\n" + 
					"   final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" + 
					"   stModel.addArguments(stArgument);\n" + 
					"   nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" + 
					"});");
		final TransactionAction AddArgumentFromSTModel = NextgenST.newTransactionAction().setName("AddArgumentFromSTModel").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("nextgen.st.model.STModel", "value").addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" + 
					"final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" + 
					"stModel.addArguments(stArgument);\n" + 
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction AddArgumentFromSTModelUuid = NextgenST.newTransactionAction().setName("AddArgumentFromSTModelUuid").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("String", "uuid").addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(uuid));\n" + 
					"final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" + 
					"stModel.addArguments(stArgument);\n" + 
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction AddArgumentFromSTTemplate = NextgenST.newTransactionAction().setName("AddArgumentFromSTTemplate").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("nextgen.st.domain.STTemplate", "stTemplate").addStatements("final nextgen.st.model.STModel value = appModel().newSTModel(stTemplate);\n" + 
					"\n" + 
					"final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" + 
					"final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" + 
					"stModel.addArguments(stArgument);\n" + 
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction AddArgumentFromSTValue = NextgenST.newTransactionAction().setName("AddArgumentFromSTValue").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("nextgen.st.model.STValue", "stValue").addStatements("final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" + 
					"stModel.addArguments(stArgument);\n" + 
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction AddChildrenToTemplate = NextgenST.newTransactionAction().setName("AddChildrenToTemplate").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("java.util.Set<nextgen.st.domain.STTemplate>", "children").addFields("javax.swing.JComponent", "owner").addStatements("confirm(owner, \"Sure to move\", unused -> {\n" + 
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
					"});");
		final TransactionAction AddFileSink = NextgenST.newTransactionAction().setName("AddFileSink").addStaticFields("java.util.concurrent.atomic.AtomicInteger", "fileTypeIndex", "new java.util.concurrent.atomic.AtomicInteger(0)").addStaticFields("java.util.concurrent.atomic.AtomicInteger", "pathIndex", "new java.util.concurrent.atomic.AtomicInteger(0)").addFields("nextgen.st.model.STModel", "stModel").addFields("javax.swing.JComponent", "owner").setTitle("Add File Sink").addStatements("final String[] fileTypes = new String[]{\"html\", \"java\", \"js\", \"xml\"};\n" + 
					"\n" + 
					"final String[] pathTypes = appModel().db.findAllSTFile()\n" + 
					"      .filter(stFile -> stFile.getPath() != null)\n" + 
					"      .filter(stFile -> stFile.getPath().getValue() != null)\n" + 
					"      .map(stFile -> stFile.getPath().getValue())\n" + 
					"      .distinct()\n" + 
					"      .toArray(String[]::new);\n" + 
					"\n" + 
					"final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();\n" + 
					"fieldMap.put(\"name\", newTextField(appModel().getSTModelName(stModel, \"\"), 15));\n" + 
					"fieldMap.put(\"type\", newTextField(15, fileTypes));\n" + 
					"fieldMap.put(\"path\", newTextField(15, pathTypes));\n" + 
					"fieldMap.put(\"package\", newTextField(appModel().getSTModelPackage(stModel, \"\"), 15));\n" + 
					"\n" + 
					"final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));\n" + 
					"inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" + 
					"\n" + 
					"for (java.util.Map.Entry<String, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {\n" + 
					"   inputPanel.add(newLabel(fieldEntry.getKey()));\n" + 
					"   inputPanel.add(fieldEntry.getValue());\n" + 
					"}\n" + 
					"\n" + 
					"showDialog(owner, inputPanel, \"New FileSink\", jDialog -> {\n" + 
					"   final String name = fieldMap.get(\"name\").getText().trim();\n" + 
					"   final String type = fieldMap.get(\"type\").getText().trim();\n" + 
					"   final String path = fieldMap.get(\"path\").getText().trim();\n" + 
					"   final String packageName = fieldMap.get(\"package\").getText().trim();\n" + 
					"   final nextgen.st.model.STFile stFile = appModel().newSTFile(name, type, path, packageName);\n" + 
					"   stModel.addFiles(stFile);\n" + 
					"   nextgen.events.NewFileSink.post(stModel, stFile);\n" + 
					"   javax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" + 
					"});");
		final TransactionAction AddFileSinkToSTModels = NextgenST.newTransactionAction().setName("AddFileSinkToSTModels").addStaticFields("java.util.concurrent.atomic.AtomicInteger", "fileTypeIndex", "new java.util.concurrent.atomic.AtomicInteger(0)").addStaticFields("java.util.concurrent.atomic.AtomicInteger", "pathIndex", "new java.util.concurrent.atomic.AtomicInteger(0)").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("java.util.List<nextgen.st.model.STModel>", "stModels").addFields("javax.swing.JComponent", "owner").setTitle("Add File Sink").addStatements("final String[] fileTypes = new String[]{\"html\", \"java\", \"js\", \"xml\"};\n" + 
					"\n" + 
					"final String[] pathTypes = appModel().db.findAllSTFile()\n" + 
					"      .filter(stFile -> stFile.getPath() != null)\n" + 
					"      .filter(stFile -> stFile.getPath().getValue() != null)\n" + 
					"      .map(stFile -> stFile.getPath().getValue())\n" + 
					"      .distinct()\n" + 
					"      .toArray(String[]::new);\n" + 
					"\n" + 
					"final java.util.Map<String, nextgen.st.domain.STParameter> parameterMap = new java.util.LinkedHashMap<>();\n" + 
					"final java.util.List<String> nameOptions = stTemplate.getParameters()\n" + 
					"      .filter(stParameter -> stParameter.getType().equals(nextgen.st.domain.STParameterType.SINGLE))\n" + 
					"      .map(stParameter -> {\n" + 
					"         parameterMap.put(stParameter.getName(), stParameter);\n" + 
					"         return stParameter.getName();\n" + 
					"      })\n" + 
					"      .sorted(String::compareToIgnoreCase)\n" + 
					"      .collect(java.util.stream.Collectors.toList());\n" + 
					"\n" + 
					"final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();\n" + 
					"fieldMap.put(\"name\", newTextField(\"\", 15, nameOptions, 0));\n" + 
					"fieldMap.put(\"type\", newTextField(15, fileTypes));\n" + 
					"fieldMap.put(\"path\", newTextField(15, pathTypes));\n" + 
					"fieldMap.put(\"package\", newTextField(\"\", 15));\n" + 
					"\n" + 
					"final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));\n" + 
					"inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" + 
					"\n" + 
					"for (java.util.Map.Entry<String, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {\n" + 
					"   inputPanel.add(newLabel(fieldEntry.getKey()));\n" + 
					"   inputPanel.add(fieldEntry.getValue());\n" + 
					"}\n" + 
					"\n" + 
					"showDialog(owner, inputPanel, \"New FileSink\", jDialog -> {\n" + 
					"   final nextgen.st.domain.STParameter stParameter = parameterMap.get(fieldMap.get(\"name\").getText().trim());\n" + 
					"   final String type = fieldMap.get(\"type\").getText().trim();\n" + 
					"   final String path = fieldMap.get(\"path\").getText().trim();\n" + 
					"   final String packageName = fieldMap.get(\"package\").getText().trim();\n" + 
					"\n" + 
					"   for (nextgen.st.model.STModel stModel : stModels) {\n" + 
					"      stModel.getArguments()\n" + 
					"            .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))\n" + 
					"            .findFirst()\n" + 
					"            .ifPresent(stArgument -> {\n" + 
					"               final nextgen.st.model.STFile stFile = appModel().newSTFile(appModel().render(stArgument), type, path, packageName);\n" + 
					"               stModel.addFiles(stFile);\n" + 
					"               nextgen.events.NewFileSink.post(stModel, stFile);\n" + 
					"            });\n" + 
					"   }\n" + 
					"   javax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" + 
					"});");
		final TransactionAction AddInterface = NextgenST.newTransactionAction().setName("AddInterface").addFields("java.util.Set<nextgen.st.domain.STTemplate>", "children").addFields("javax.swing.JComponent", "owner").addStatements("final javax.swing.JTextField txtImplements = newTextField();\n" + 
					"final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 1));\n" + 
					"contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" + 
					"contentPanel.add(txtImplements);\n" + 
					"\n" + 
					"showDialog(owner, contentPanel, \"Add interface\", jDialog -> {\n" + 
					"   final String interfaceName = txtImplements.getText().trim();\n" + 
					"   if (interfaceName.length()==0) return;\n" + 
					"   for (nextgen.st.domain.STTemplate child : children) {\n" + 
					"      final java.util.Optional<String> optional = child.getImplements().filter(s -> s.toLowerCase().equals(interfaceName.toLowerCase())).findAny();\n" + 
					"      if(optional.isPresent()) continue;\n" + 
					"      child.addImplements(interfaceName);\n" + 
					"   }\n" + 
					"   close(jDialog);   \n" + 
					"});");
		final TransactionAction AddKVArgument = NextgenST.newTransactionAction().setName("AddKVArgument").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("javax.swing.JComponent", "owner").setTitle("Add").addStatements("final String[] selectedValues = appModel().getSelectedValues();\n" + 
					"final java.util.Map<nextgen.st.domain.STParameterKey, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();\n" + 
					"stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(40, selectedValues)));\n" + 
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
					"   stModel.addArguments(stArgument);\n" + 
					"   nextgen.events.NewSTKVArgument.post(stModel, stParameter, stArgument, kvs);\n" + 
					"\n" + 
					"   close(jDialog);\n" + 
					"});");
		final TransactionAction AddModelToProject = NextgenST.newTransactionAction().setName("AddModelToProject").addFields("nextgen.st.model.STProject", "project").addFields("nextgen.st.model.STModel", "stModel").setTitle("Add to Project").addStatements("project.addModels(stModel);\n" + 
					"nextgen.events.NewSTProjectSTModel.post(stModel, project, appModel().getSTTemplate(stModel));");
		final TransactionAction AddValueToProject = NextgenST.newTransactionAction().setName("AddValueToProject").addFields("nextgen.st.model.STProject", "project").addFields("nextgen.st.model.STValue", "stValue").setTitle("Add to Project").addStatements("project.addValues(stValue);\n" + 
					"nextgen.events.NewSTProjectSTValue.post(stValue, project);");
		final TransactionAction AddValueToProjectFromInput = NextgenST.newTransactionAction().setName("AddValueToProjectFromInput").addFields("nextgen.st.model.STProject", "project").addFields("javax.swing.JComponent", "owner").setTitle("Add New Value to Project").addStatements("input(owner, \"New Value\", value -> {\n" + 
					"   final nextgen.st.model.STValue stValue = appModel().newSTValue(value);\n" + 
					"   project.addValues(stValue);\n" + 
					"   nextgen.events.NewSTProjectSTValue.post(stValue, project);\n" + 
					"});");
		final TransactionAction AddMultipleArgumentsFromArgumentType = NextgenST.newTransactionAction().setName("AddMultipleArgumentsFromArgumentType").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("javax.swing.JComponent", "owner");
		final TransactionAction AddTemplateModelToProject = NextgenST.newTransactionAction().setName("AddTemplateModelToProject").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("nextgen.st.model.STProject", "project").addStatements("final nextgen.st.model.STModel stModel = appModel().newSTModel(stTemplate);\n" + 
					"project.addModels(stModel);\n" + 
					"nextgen.events.NewSTProjectSTModel.post(stModel, project, stTemplate);");
		final TransactionAction CopyModel = NextgenST.newTransactionAction().setName("CopyModel").addFields("nextgen.st.model.STModel", "stModel").setTitle("Copy Model").addStatements("toClipboard(\"stmodel-\" + stModel.getUuid());");
		final TransactionAction DeleteEnum = NextgenST.newTransactionAction().setName("DeleteEnum").addFields("nextgen.st.domain.STEnum", "stEnum").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Delete").addStatements("confirm(owner, \"Delete\", unused -> {\n" + 
					"   stGroup.removeEnums(stEnum);\n" + 
					"   nextgen.events.STEnumDeleted.post(stEnum.getUuid());\n" + 
					"});");
		final TransactionAction DeleteKV = NextgenST.newTransactionAction().setName("DeleteKV").addFields("nextgen.st.model.STArgumentKV", "argumentKV").addFields("javax.swing.JComponent", "owner").setTitle("Remove").addStatements("confirm(owner, \"Delete\", unused ->\n" + 
					"      argumentKV.getIncomingKeyValuesSTArgument().findFirst().ifPresent(stArgument -> {\n" + 
					"         stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {\n" + 
					"            final String uuid = argumentKV.getUuid();\n" + 
					"            stArgument.removeKeyValues(argumentKV);\n" + 
					"            nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" + 
					"         });\n" + 
					"      }));");
		final TransactionAction DeleteSTArgument = NextgenST.newTransactionAction().setName("DeleteSTArgument").addFields("nextgen.st.model.STArgument", "stArgument").addFields("javax.swing.JComponent", "owner").setTitle("Delete").addStatements("confirm(owner, \"Remove\", unused ->\n" + 
					"      stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {\n" + 
					"         final String uuid = stArgument.getUuid();\n" + 
					"         stModel.removeArguments(stArgument);\n" + 
					"         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" + 
					"         stArgument.delete();\n" + 
					"         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" + 
					"      }));");
		final TransactionAction DeleteSTGroup = NextgenST.newTransactionAction().setName("DeleteSTGroup").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Delete").addStatements("confirm(owner, \"Delete\", unused -> {\n" + 
					"   appModel().delete(stGroup);\n" + 
					"   nextgen.events.STGroupDeleted.post(stGroup.getUuid());\n" + 
					"});");
		final TransactionAction DeleteSTFile = NextgenST.newTransactionAction().setName("DeleteSTFile").addFields("nextgen.st.model.STFile", "stFile").addFields("javax.swing.JComponent", "owner").setTitle("Delete").addStatements("confirm(owner, \"Delete\", unused -> {\n" + 
					"   final String uuid = stFile.getUuid();\n" + 
					"   final nextgen.st.model.STFile found = appModel().db.findSTFileByUuid(uuid);\n" + 
					"   if (found != null) appModel().db.delete(found.getNode());\n" + 
					"   nextgen.events.STFileDeleted.post(uuid);\n" + 
					"});");
		final TransactionAction DeleteSTFileFromSTModels = NextgenST.newTransactionAction().setName("DeleteSTFileFromSTModels").addFields("java.util.List<nextgen.st.model.STModel>", "stModels").addFields("javax.swing.JComponent", "owner").setTitle("Delete Filesinks").addStatements("confirm(owner, \"Delete\", unused -> {\n" + 
					"   for (nextgen.st.model.STModel stModel : stModels) {\n" + 
					"      stModel.getFiles().forEach(stFile -> {\n" + 
					"         final String uuid = stFile.getUuid();\n" + 
					"         final nextgen.st.model.STFile found = appModel().db.findSTFileByUuid(uuid);\n" + 
					"         if (found != null) appModel().db.delete(found.getNode());\n" + 
					"         nextgen.events.STFileDeleted.post(uuid);      \n" + 
					"      });\n" + 
					"   }\n" + 
					"});");
		final TransactionAction DeleteSTInterface = NextgenST.newTransactionAction().setName("DeleteSTInterface").addFields("nextgen.st.domain.STInterface", "stInterface").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Delete").addStatements("confirm(owner, \"Delete\", unused -> {\n" + 
					"   stGroup.removeInterfaces(stInterface);\n" + 
					"   nextgen.events.STInterfaceDeleted.post(stInterface.getUuid());   \n" + 
					"});");
		final TransactionAction RemoveInterfaceFromSTTemplate = NextgenST.newTransactionAction().setName("RemoveInterfaceFromSTTemplate").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("String", "interfaceName").addFields("javax.swing.JComponent", "owner").addStatements("confirm(owner, \"Remove\", unused -> {\n" + 
					"   stTemplate.removeImplements(interfaceName);\n" + 
					"   nextgen.events.STTemplateInterfaceRemoved.post(stGroup, stTemplate, interfaceName);\n" + 
					"});");
		final TransactionAction DeleteSTModel = NextgenST.newTransactionAction().setName("DeleteSTModel").addFields("nextgen.st.model.STModel", "stModel").addFields("javax.swing.JComponent", "owner").setTitle("Delete").addStatements("confirm(owner, \"Delete\", unused -> {\n" + 
					"   final String uuid = stModel.getUuid();\n" + 
					"   final nextgen.st.model.STModel found = appModel().db.findSTModelByUuid(uuid);\n" + 
					"   if (found != null) appModel().db.delete(found.getNode());\n" + 
					"   nextgen.events.STModelDeleted.post(uuid);\n" + 
					"});");
		final TransactionAction DeleteSTTemplate = NextgenST.newTransactionAction().setName("DeleteSTTemplate").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Delete").addStatements("confirm(owner, \"Delete\", unused -> {\n" + 
					"   stGroup.removeTemplates(stTemplate);\n" + 
					"   nextgen.events.STTemplateDeleted.post(stTemplate.getUuid());\n" + 
					"});");
		final TransactionAction DeleteSTValue = NextgenST.newTransactionAction().setName("DeleteSTValue").addFields("nextgen.st.model.STValue", "stValue").addFields("javax.swing.JComponent", "owner").setTitle("Delete").addStatements("confirm(owner, \"Delete\", unused -> {\n" + 
					"   final String uuid = stValue.getUuid();\n" + 
					"   final nextgen.st.model.STValue found = appModel().db.findSTValueByUuid(uuid);\n" + 
					"   if (found != null) appModel().db.delete(found.getNode());\n" + 
					"   nextgen.events.STValueDeleted.post(uuid);\n" + 
					"});");
		final TransactionAction EditEnum = NextgenST.newTransactionAction().setName("EditEnum").addFields("nextgen.st.domain.STEnum", "stEnum").addFields("javax.swing.JComponent", "owner").setTitle("Edit").addStatements("final int newFields = 5;\n" + 
					"final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout((int) stEnum.getValues().count() + newFields + 1, 2));\n" + 
					"contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" + 
					"contentPanel.add(newLabel(\"Name\"));\n" + 
					"contentPanel.add(newLabel(\"Lexical\"));\n" + 
					"\n" + 
					"// existing values:\n" + 
					"final java.util.Map<nextgen.st.domain.STEnumValue, javax.swing.JTextField> txtEnumValuesName = new java.util.LinkedHashMap<>();\n" + 
					"final java.util.Map<nextgen.st.domain.STEnumValue, javax.swing.JTextField> txtEnumLexical = new java.util.LinkedHashMap<>();\n" + 
					"stEnum.getValues().forEach(stEnumValue -> {\n" + 
					"	txtEnumValuesName.put(stEnumValue, newTextField(stEnumValue.getName(), 10));\n" + 
					"	txtEnumLexical.put(stEnumValue, newTextField(stEnumValue.getLexical(), 10));\n" + 
					"	contentPanel.add(txtEnumValuesName.get(stEnumValue));\n" + 
					"	contentPanel.add(txtEnumLexical.get(stEnumValue));\n" + 
					"});\n" + 
					"\n" + 
					"// allow adding new values:\n" + 
					"final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumValuesName = new java.util.LinkedHashMap<>();\n" + 
					"final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumLexical = new java.util.LinkedHashMap<>();\n" + 
					"for (int i = 0; i < newFields; i++) {\n" + 
					"	newTxtEnumValuesName.put(i, newTextField(\"\", 10));\n" + 
					"	newTxtEnumLexical.put(i, newTextField(\"\", 10));\n" + 
					"	contentPanel.add(newTxtEnumValuesName.get(i));\n" + 
					"	contentPanel.add(newTxtEnumLexical.get(i));\n" + 
					"}\n" + 
					"\n" + 
					"showDialog(owner, contentPanel, \"Edit Enum\", jDialog -> {\n" + 
					"	for (nextgen.st.domain.STEnumValue stEnumValue : txtEnumValuesName.keySet()) {\n" + 
					"		final String txtEnumValueName = txtEnumValuesName.get(stEnumValue).getText().trim();\n" + 
					"		final String txtEnumValueLexical = txtEnumLexical.get(stEnumValue).getText().trim();\n" + 
					"\n" + 
					"		stEnumValue.setName(txtEnumValueName);\n" + 
					"		stEnumValue.setLexical(txtEnumValueLexical.length() == 0 ? null : txtEnumValueLexical);\n" + 
					"	}\n" + 
					"\n" + 
					"	for (int i = 0; i < newFields; i++) {\n" + 
					"		final String newEnumValue = newTxtEnumValuesName.get(i).getText().trim();\n" + 
					"		final String newEnumLexical = newTxtEnumLexical.get(i).getText().trim();\n" + 
					"		if (newEnumValue.length() == 0) continue;\n" + 
					"\n" + 
					"		stEnum.addValues(nextgen.st.domain.STJsonFactory.newSTEnumValue()\n" + 
					"				.setName(newEnumValue)\n" + 
					"				.setLexical(newEnumLexical.length() == 0 ? null : newEnumLexical));\n" + 
					"	}\n" + 
					"\n" + 
					"	nextgen.events.STEnumChanged.post(stEnum);\n" + 
					"});");
		final TransactionAction EditModels = NextgenST.newTransactionAction().setName("EditModels").addFields("nextgen.st.domain.STTemplate", "stTemplate").setTitle("Edit").addStatements("appModel().doLaterInTransaction(transaction1 -> {\n" + 
					"   final nextgen.st.STModelGrid stModelGrid = appModel().getWorkspace().getModelGrid(stTemplate);\n" + 
					"   appModel().getWorkspace().setSelectedComponent(stModelGrid);\n" + 
					"   stModelGrid.requestFocusInWindow();   \n" + 
					"});");
		final TransactionAction EditSTGroupTags = NextgenST.newTransactionAction().setName("EditSTGroupTags").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Edit tags").addStatements("input(owner, \"Tags\", stGroup.getTags(\"\"), tags -> {\n" + 
					"   stGroup.setTags(tags);\n" + 
					"   nextgen.events.STGroupTagsChanged.post(stGroup);\n" + 
					"});");
		final TransactionAction EditSTModel = NextgenST.newTransactionAction().setName("EditSTModel").addFields("nextgen.st.model.STModel", "stModel").setTitle("Edit").addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().getWorkspace().setSelectedComponent(appModel().getModelEditor(stModel)));");
		final TransactionAction GenerateAllProjectModels = NextgenST.newTransactionAction().setName("GenerateAllProjectModels").addFields("nextgen.st.model.STProject", "project").setTitle("Generate all").addStatements("project.getModels().forEach(stModel ->\n" + 
					"      stModel.getFiles().forEach(stFile -> {\n" + 
					"         final String content = appModel().render(stModel);\n" + 
					"         final String packageDeclaration = stFile.getPackageName().getValue();\n" + 
					"         final String name = stFile.getName().getValue();\n" + 
					"         final String filetype = stFile.getType().getValue();\n" + 
					"         final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" + 
					"         nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" + 
					"      }));");
		final TransactionAction GenerateAllSTGroups = NextgenST.newTransactionAction().setName("GenerateAllSTGroups").setTitle("Generate all").addStatements("appModel().getSTGroups().forEach(stGroupModel -> appModel().generateSTGroup(stGroupModel, false));");
		final TransactionAction GenerateSource = NextgenST.newTransactionAction().setName("GenerateSource").addFields("nextgen.st.model.STModel", "stModel").setTitle("As builder code").addStatements("final java.util.Set<String> imports = new java.util.LinkedHashSet<>();\n" + 
					"\n" + 
					"final String packageName = appModel().getSourceOutputPackage();\n" + 
					"final String templateName = appModel().getSTTemplate(stModel).getName();\n" + 
					"final String className = appModel().getSTModelName(stModel, templateName);\n" + 
					"\n" + 
					"final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.JavaPatterns.newBlockStmt()\n" + 
					"      .addStatements(nextgen.templates.JavaPatterns.newReturnStmt().setExpression(appModel().stRenderer.renderGeneratorCode(stModel, imports)));\n" + 
					"\n" + 
					"final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()\n" + 
					"      .setName(className)\n" + 
					"      .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)\n" + 
					"      .addMembers(nextgen.templates.JavaPatterns.newMethodDeclaration()\n" + 
					"            .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)\n" + 
					"            .addModifiers(nextgen.templates.java.Modifiers.STATIC)\n" + 
					"            .setName(\"generate\")\n" + 
					"            .setType(templateName)\n" + 
					"            .setBlockStmt(blockStmt));\n" + 
					"\n" + 
					"final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.JavaPatterns.newCompilationUnit(packageName, classOrInterfaceDeclaration)\n" + 
					"      .setImportDeclaration(imports.stream()\n" + 
					"            .map(s -> nextgen.templates.JavaPatterns.newImportDeclaration()\n" + 
					"                  .setName(s)\n" + 
					"                  .setIsAsterisk(true))\n" + 
					"            .collect(java.util.stream.Collectors.toList()));\n" + 
					"\n" + 
					"nextgen.utils.SwingUtil.toClipboard(blockStmt.toString());\n" + 
					"\n" + 
					"nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(appModel().getOutputPath()));");
		final TransactionAction GenerateSources = NextgenST.newTransactionAction().setName("GenerateSources").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("java.util.List<nextgen.st.model.STModel>", "stModels").setTitle("As builder code").addStatements("final java.util.Set<String> imports = new java.util.LinkedHashSet<>();\n" + 
					"\n" + 
					"final String packageName = appModel().getSourceOutputPackage();\n" + 
					"final String className = \"GenerateAll_\" + stTemplate.getName();\n" + 
					"final String type = nextgen.utils.StringUtil.capitalize(stTemplate.getName());\n" + 
					"final nextgen.templates.java.ClassOrInterfaceType returnType = nextgen.templates.JavaPatterns.newClassOrInterfaceType(\"java.util\", \"List\")\n" + 
					"      .addTypeArguments(type);\n" + 
					"\n" + 
					"final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.JavaPatterns.newBlockStmt();\n" + 
					"final nextgen.templates.java.VariableDeclarationExpression listVariable = nextgen.templates.JavaPatterns\n" + 
					"      .newFinalVariableDeclarationExpression(returnType, \"list\", \"new java.util.ArrayList<>()\");\n" + 
					"\n" + 
					"blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()\n" + 
					"      .setExpression(listVariable));\n" + 
					"\n" + 
					"java.util.concurrent.atomic.AtomicInteger variableCount = new java.util.concurrent.atomic.AtomicInteger();\n" + 
					"for (nextgen.st.model.STModel stModel : stModels) {\n" + 
					"   final String stModelName = appModel().getSTModelName(stModel, \"var_\" + variableCount.incrementAndGet());\n" + 
					"   final nextgen.templates.java.VariableDeclarationExpression variableDeclarationExpression = nextgen.templates.JavaPatterns\n" + 
					"         .newFinalVariableDeclarationExpression(type, stModelName, appModel().stRenderer.renderGeneratorCode(stModel, imports));\n" + 
					"   blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()\n" + 
					"         .setExpression(variableDeclarationExpression));\n" + 
					"}\n" + 
					"\n" + 
					"variableCount = new java.util.concurrent.atomic.AtomicInteger();\n" + 
					"for (nextgen.st.model.STModel stModel : stModels) {\n" + 
					"   final String stModelName = appModel().getSTModelName(stModel, \"var_\" + variableCount.incrementAndGet());\n" + 
					"   blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()\n" + 
					"         .setExpression(nextgen.templates.JavaPatterns.newMethodCallExpression()\n" + 
					"               .setScope(\"list\")\n" + 
					"               .setName(\"add\")\n" + 
					"               .addArguments(stModelName)));\n" + 
					"}\n" + 
					"\n" + 
					"blockStmt.addStatements(nextgen.templates.JavaPatterns.newReturnStmt().setExpression(\"list\"));\n" + 
					"\n" + 
					"final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()\n" + 
					"      .setName(className)\n" + 
					"      .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)\n" + 
					"      .addMembers(nextgen.templates.JavaPatterns.newMethodDeclaration()\n" + 
					"            .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)\n" + 
					"            .addModifiers(nextgen.templates.java.Modifiers.STATIC)\n" + 
					"            .setName(\"generate\")\n" + 
					"            .setType(returnType)\n" + 
					"            .setBlockStmt(blockStmt));\n" + 
					"\n" + 
					"final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.JavaPatterns.newCompilationUnit(packageName, classOrInterfaceDeclaration)\n" + 
					"      .setImportDeclaration(imports.stream()\n" + 
					"            .map(s -> nextgen.templates.JavaPatterns.newImportDeclaration()\n" + 
					"                  .setName(s)\n" + 
					"                  .setIsAsterisk(true))\n" + 
					"            .collect(java.util.stream.Collectors.toList()));\n" + 
					"\n" + 
					"nextgen.utils.SwingUtil.toClipboard(blockStmt.toString());\n" + 
					"\n" + 
					"nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(appModel().getOutputPath()));");
		final TransactionAction GenerateSTGroup = NextgenST.newTransactionAction().setName("GenerateSTGroup").addFields("nextgen.st.domain.STGroupModel", "stGroup").setTitle("Generate STGroup").addStatements("appModel().generateSTGroup(stGroup, false);");
		final TransactionAction GenerateSTGroupAndNeo = NextgenST.newTransactionAction().setName("GenerateSTGroupAndNeo").addFields("nextgen.st.domain.STGroupModel", "stGroup").setTitle("Generate STGroup and Neo").addStatements("appModel().generateSTGroup(stGroup, true);");
		final TransactionAction ImportSTTemplate = NextgenST.newTransactionAction().setName("ImportSTTemplate").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Import from stg-file").addStatements("openFile(owner, file -> {\n" + 
					"	appModel().setLastDir(file.getParentFile());\n" + 
					"	appModel().doLaterInTransaction(t -> {\n" + 
					"		final String fileName = file.getName();\n" + 
					"		final String name = fileName.substring(0, fileName.indexOf(\".\"));\n" + 
					"		final nextgen.st.domain.STTemplate stTemplate = appModel().newSTTemplate(name, nextgen.utils.FileUtil.readIntact(file), stGroup);\n" + 
					"		nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);\n" + 
					"	});\n" + 
					"});");
		final TransactionAction NewEnum = NextgenST.newTransactionAction().setName("NewEnum").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("New Enum").addStatements("input(owner, \"New Enum\", s ->\n" + 
					"      nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" + 
					"         final nextgen.st.domain.STEnum stEnum = appModel().newSTEnum(name);\n" + 
					"         stGroup.addEnums(stEnum);\n" + 
					"         nextgen.events.NewSTEnum.post(stGroup, stEnum);\n" + 
					"      }));");
		final TransactionAction NewInterface = NextgenST.newTransactionAction().setName("NewInterface").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("New Interface").addStatements("input(owner, \"New Interface\", s ->\n" + 
					"      nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" + 
					"         final nextgen.st.domain.STInterface stInterface = appModel().newSTInterface(name);\n" + 
					"         stGroup.addInterfaces(stInterface);\n" + 
					"         nextgen.events.NewSTInterface.post(stGroup, stInterface);\n" + 
					"      }));");
		final TransactionAction NewProject = NextgenST.newTransactionAction().setName("NewProject").addFields("javax.swing.JComponent", "owner").setTitle("New Project").addStatements("input(owner, \"Name\", s -> {\n" + 
					"   final nextgen.st.model.STProject stProject = appModel().db.newSTProject(s);\n" + 
					"   nextgen.events.NewSTProject.post(stProject);\n" + 
					"});");
		final TransactionAction NewSTGroupAction = NextgenST.newTransactionAction().setName("NewSTGroupAction").addFields("javax.swing.JComponent", "owner").setTitle("New STGroup").addStatements("input(owner, \"Name\", name -> {\n" + 
					"	\n" + 
					"	final java.util.Optional<nextgen.st.domain.STGroupModel> existing = appModel().findSTGroup(name);\n" + 
					"	if (existing.isPresent()) {\n" + 
					"		nextgen.utils.SwingUtil.showMessage(name + \" group already exists in this directory\", owner);\n" + 
					"		return;\n" + 
					"	}\n" + 
					"\n" + 
					"	if (!javax.lang.model.SourceVersion.isIdentifier(name)) {\n" + 
					"		nextgen.utils.SwingUtil.showMessage(name + \" is a reserved java keyword\", owner);\n" + 
					"		return;\n" + 
					"	}\n" + 
					"\n" + 
					"	final nextgen.st.domain.STGroupModel stGroupModel = appModel().newSTGroupModel(name);\n" + 
					"	nextgen.events.NewSTGroup.post(stGroupModel);\n" + 
					"});");
		final TransactionAction NewSTModelAction = NextgenST.newTransactionAction().setName("NewSTModelAction").addFields("nextgen.st.domain.STTemplate", "stTemplate").setTitle("New instance").addStatements("final nextgen.st.model.STModel stModel = appModel().newSTModel(stTemplate);\n" + 
					"nextgen.events.NewSTModel.post(stModel, appModel().findSTGroup(stTemplate), stTemplate);");
		final TransactionAction NewSTTemplate = NextgenST.newTransactionAction().setName("NewSTTemplate").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("New Template").addStatements("input(owner, \"Name\", s -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" + 
					"	final nextgen.st.domain.STTemplate stTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText(\"\");\n" + 
					"	stGroup.addTemplates(stTemplate);\n" + 
					"	nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);\n" + 
					"}));");
		final TransactionAction AddChildToTemplate = NextgenST.newTransactionAction().setName("AddChildToTemplate").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Add Child template").addStatements("input(owner, \"Name\", s -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s)\n" + 
					"      .ifPresent(name -> {\n" + 
					"         final nextgen.st.domain.STTemplate newTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText(\"\");\n" + 
					"         stTemplate.addChildren(newTemplate);\n" + 
					"         nextgen.events.NewSTTemplateChild.post(newTemplate, stTemplate);\n" + 
					"      }));");
		final TransactionAction OpenSTModelAction = NextgenST.newTransactionAction().setName("OpenSTModelAction").addFields("nextgen.st.model.STModel", "stModel").setTitle("Open").addStatements("nextgen.events.OpenSTModel.post(stModel);");
		final TransactionAction OpenTemplate = NextgenST.newTransactionAction().setName("OpenTemplate").addFields("nextgen.st.domain.STTemplate", "stTemplate").setTitle("Open").addStatements("nextgen.events.OpenSTTemplate.post(stTemplate);");
		final TransactionAction RenameEnum = NextgenST.newTransactionAction().setName("RenameEnum").addFields("nextgen.st.domain.STEnum", "stEnum").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Rename").addStatements("input(owner, \"Name\", stEnum.getName(), s -> {\n" + 
					"   nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" + 
					"      stEnum.setName(name);\n" + 
					"      nextgen.events.STEnumNameChanged.post(stGroup, stEnum);\n" + 
					"   });\n" + 
					"});");
		final TransactionAction RenameSTGroup = NextgenST.newTransactionAction().setName("RenameSTGroup").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Rename").addStatements("input(owner, \"Name\", stGroup.getName(), s -> {\n" + 
					"	nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" + 
					"		stGroup.setName(name);\n" + 
					"		nextgen.events.STGroupNameChanged.post(stGroup);\n" + 
					"	});\n" + 
					"});");
		final TransactionAction RenameSTInterface = NextgenST.newTransactionAction().setName("RenameSTInterface").addFields("nextgen.st.domain.STInterface", "stInterface").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Rename").addStatements("input(owner, \"Name\", stInterface.getName(), s -> {\n" + 
					"   nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" + 
					"      stInterface.setName(name);\n" + 
					"      nextgen.events.STInterfaceNameChanged.post(stGroup, stInterface);\n" + 
					"   });\n" + 
					"});");
		final TransactionAction RenameSTTemplate = NextgenST.newTransactionAction().setName("RenameSTTemplate").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("javax.swing.JComponent", "owner").setTitle("Rename").addStatements("input(owner, \"Name\", stTemplate.getName(), s -> {\n" + 
					"   nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" + 
					"      stTemplate.setName(name);\n" + 
					"      nextgen.events.STTemplateNameChanged.post(stGroup, stTemplate);\n" + 
					"   });\n" + 
					"});");
		final TransactionAction SetArgumentFromClipboard = NextgenST.newTransactionAction().setName("SetArgumentFromClipboard").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").setTitle("Set from Clipboard").addStatements("stModel.getArguments()\n" + 
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
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction SetArgumentFromInput = NextgenST.newTransactionAction().setName("SetArgumentFromInput").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("javax.swing.JComponent", "owner").setTitle("Set from Input").addStatements("input(owner, stParameter.getName(), inputValue -> {\n" + 
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
					"});");
		final TransactionAction SetArgumentFromSTModel = NextgenST.newTransactionAction().setName("SetArgumentFromSTModel").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("nextgen.st.model.STModel", "value").addStatements("stModel.getArguments()\n" + 
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
					"      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction SetArgumentFromSTModelUuid = NextgenST.newTransactionAction().setName("SetArgumentFromSTModelUuid").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("String", "uuid").addStatements("stModel.getArguments()\n" + 
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
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction SetArgumentFromSTTemplate = NextgenST.newTransactionAction().setName("SetArgumentFromSTTemplate").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("nextgen.st.domain.STTemplate", "stTemplate").addStatements("stModel.getArguments()\n" + 
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
					"\n" + 
					"final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" + 
					"final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" + 
					"stModel.addArguments(stArgument);\n" + 
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction SetArgumentFromSTValue = NextgenST.newTransactionAction().setName("SetArgumentFromSTValue").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").addFields("nextgen.st.model.STValue", "stValue").addStatements("stModel.getArguments()\n" + 
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
					"final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" + 
					"stModel.addArguments(stArgument);\n" + 
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction SetArgumentToTrue = NextgenST.newTransactionAction().setName("SetArgumentToTrue").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.domain.STParameter", "stParameter").setTitle("Set to true").addStatements("stModel.getArguments()\n" + 
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
					"nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
		final TransactionAction SetInterfaces = NextgenST.newTransactionAction().setName("SetInterfaces").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("javax.swing.JComponent", "owner").setTitle("Set interfaces").addStatements("final java.util.List<javax.swing.JTextField> txtImplements = new java.util.ArrayList<>();\n" + 
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
					"});");
		final TransactionAction SetKVArgumentFromClipboard = NextgenST.newTransactionAction().setName("SetKVArgumentFromClipboard").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.model.STArgument", "stArgument").addFields("nextgen.st.domain.STParameterKey", "stParameterKey").setTitleExpression("\"Set \" + stParameterKey.getName() + \" from Clipboard\"").addStatements("stArgument.getKeyValues()\n" + 
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
					"nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);");
		final TransactionAction SetKVArgumentFromInput = NextgenST.newTransactionAction().setName("SetKVArgumentFromInput").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.model.STArgument", "stArgument").addFields("nextgen.st.domain.STParameterKey", "stParameterKey").addFields("javax.swing.JComponent", "owner").setTitleExpression("\"Set \" + stParameterKey.getName() + \" from Input\"").addStatements("input(owner, stParameterKey.getName(), inputValue -> {\n" + 
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
					"   nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);});");
		final TransactionAction SetKVArgumentFromSTModel = NextgenST.newTransactionAction().setName("SetKVArgumentFromSTModel").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.model.STArgument", "stArgument").addFields("nextgen.st.domain.STParameterKey", "stParameterKey").addFields("nextgen.st.model.STModel", "value").setTitleExpression("\"Set \" + stParameterKey.getName() + \" from STModel\"").addStatements("stArgument.getKeyValues()\n" + 
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
					"nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);");
		final TransactionAction SetKVArgumentFromSTValue = NextgenST.newTransactionAction().setName("SetKVArgumentFromSTValue").addFields("nextgen.st.model.STModel", "stModel").addFields("nextgen.st.model.STArgument", "stArgument").addFields("nextgen.st.domain.STParameterKey", "stParameterKey").addFields("nextgen.st.model.STValue", "stValue").setTitleExpression("\"Set \" + stParameterKey.getName() + \" from STValue\"").addStatements("stArgument.getKeyValues()\n" + 
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
					"nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);");
		final TransactionAction SetMultipleFields = NextgenST.newTransactionAction().setName("SetMultipleFields").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("nextgen.st.model.STModel", "stModel").addFields("javax.swing.JComponent", "owner").setTitle("Set Fields").addStatements("final java.util.concurrent.atomic.AtomicInteger modelIndex = new java.util.concurrent.atomic.AtomicInteger(0);\n" + 
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
					"         nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" + 
					"      }\n" + 
					"   }\n" + 
					"});");
		final TransactionAction SetSTValueFromClipboard = NextgenST.newTransactionAction().setName("SetSTValueFromClipboard").addFields("nextgen.st.model.STValue", "stValue").setTitle("Set from Clipboard").addStatements("stValue.removeStModel();\n" + 
					"stValue.setValue(nextgen.utils.SwingUtil.fromClipboard());\n" + 
					"stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);\n" + 
					"nextgen.events.STValueChanged.post(stValue);");
		final TransactionAction SetSTValueFromInput = NextgenST.newTransactionAction().setName("SetSTValueFromInput").addFields("nextgen.st.model.STValue", "stValue").addFields("javax.swing.JComponent", "owner").setTitle("Set from Input").addStatements("input(owner, \"Set Value\", value -> {\n" + 
					"   stValue.removeStModel();\n" + 
					"   stValue.setValue(value);\n" + 
					"   stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);\n" + 
					"   nextgen.events.STValueChanged.post(stValue);\n" + 
					"});");
		final TransactionAction SetTemplateParameterTypes = NextgenST.newTransactionAction().setName("SetTemplateParameterTypes").addFields("nextgen.st.domain.STGroupModel", "stGroup").addFields("nextgen.st.domain.STTemplate", "stTemplate").addFields("javax.swing.JComponent", "owner").setTitle("Set parameter types").addStatements("final java.util.Map<String, javax.swing.JTextField> txtParameterMap = new java.util.TreeMap<>();\n" + 
					"stTemplate.getParameters().forEach(stParameter -> {\n" + 
					"\n" + 
					"	switch (stParameter.getType()) {\n" + 
					"\n" + 
					"		case SINGLE:\n" + 
					"		case LIST:\n" + 
					"			final String key = stParameter.getName();\n" + 
					"			txtParameterMap.put(key, newTextField(stParameter.getArgumentType(\"Object\"), 15));\n" + 
					"			break;\n" + 
					"\n" + 
					"		case KVLIST:\n" + 
					"			stParameter.getKeys().forEach(stParameterKey -> {\n" + 
					"				final String kvListKey = stParameter.getName() + \".\" + stParameterKey.getName();\n" + 
					"				txtParameterMap.put(kvListKey, newTextField(stParameterKey.getArgumentType(\"Object\"), 15));\n" + 
					"			});\n" + 
					"			break;\n" + 
					"	}\n" + 
					"});\n" + 
					"\n" + 
					"final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtParameterMap.size(), 2));\n" + 
					"contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" + 
					"txtParameterMap.forEach((key, value) -> {\n" + 
					"	contentPanel.add(newLabel(key));\n" + 
					"	contentPanel.add(value);\n" + 
					"});\n" + 
					"\n" + 
					"showDialog(owner, contentPanel, \"Parameter Types\", jDialog -> {\n" + 
					"	stTemplate.getParameters().forEach(stParameter -> {\n" + 
					"\n" + 
					"		switch (stParameter.getType()) {\n" + 
					"\n" + 
					"			case SINGLE:\n" + 
					"			case LIST:\n" + 
					"				final javax.swing.JTextField txtTypes = txtParameterMap.get(stParameter.getName());\n" + 
					"				final String types = txtTypes.getText().trim();\n" + 
					"				stParameter.setArgumentType(types.length() == 0 ? (stParameter.getName().startsWith(\"is\") ? \"Boolean\" : \"Object\") : types);\n" + 
					"				break;\n" + 
					"\n" + 
					"			case KVLIST:\n" + 
					"				stParameter.getKeys().forEach(stParameterKey -> {\n" + 
					"					final javax.swing.JTextField txtKVTypes = txtParameterMap.get(stParameter.getName() + \".\" + stParameterKey.getName());\n" + 
					"					final String kvTypes = txtKVTypes.getText().trim();\n" + 
					"					stParameterKey.setArgumentType(kvTypes.length() == 0 ? (stParameterKey.getName().startsWith(\"is\") ? \"Boolean\" : \"Object\") : kvTypes);\n" + 
					"				});\n" + 
					"				break;\n" + 
					"		}\n" + 
					"	});\n" + 
					"\n" + 
					"	appModel().save(stGroup);\n" + 
					"	nextgen.events.STTemplateParameterTypesChanged.post(stGroup, stTemplate);\n" + 
					"	javax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" + 
					"});");
		final TransactionAction STValueToClipboard = NextgenST.newTransactionAction().setName("STValueToClipboard").addFields("nextgen.st.model.STValue", "stValue").setTitle("To Clipboard").addStatements("nextgen.utils.SwingUtil.toClipboard(appModel().render(stValue));");
		final TransactionAction STModelToClipboard = NextgenST.newTransactionAction().setName("STModelToClipboard").addFields("nextgen.st.model.STModel", "stModel").setTitle("To Clipboard").addStatements("nextgen.utils.SwingUtil.toClipboard(appModel().render(stModel));");
		final TransactionAction UndoDBTransaction = NextgenST.newTransactionAction().setName("UndoDBTransaction").setTitle("Undo").addStatements("appModel().undoLast();");
		final TransactionAction VisitSTModel = NextgenST.newTransactionAction().setName("VisitSTModel").addFields("nextgen.st.model.STModel", "stModel").setTitle("VisitSTModel").addStatements("new nextgen.st.STVisitorTest(appModel()).visit(stModel);");
		final TransactionAction WriteSTModelToFile = NextgenST.newTransactionAction().setName("WriteSTModelToFile").addFields("nextgen.st.model.STModel", "stModel").setTitle("Generate").addStatements("stModel.getFiles().forEach(stFile -> {\n" + 
					"   final String content = appModel().render(stModel);\n" + 
					"   final String packageDeclaration = stFile.getPackageName().getValue();\n" + 
					"   final String name = stFile.getName().getValue();\n" + 
					"   final String filetype = stFile.getType().getValue();\n" + 
					"   final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" + 
					"   nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" + 
					"});");
		final TransactionAction WriteAllSTModelsToFile = NextgenST.newTransactionAction().setName("WriteAllSTModelsToFile").addFields("java.util.List<nextgen.st.model.STModel>", "stModels").setTitle("Generate All").addStatements("for (nextgen.st.model.STModel stModel : stModels) {\n" + 
					"   stModel.getFiles().forEach(stFile -> {\n" + 
					"      final String content = appModel().render(stModel);\n" + 
					"      final String packageDeclaration = stFile.getPackageName().getValue();\n" + 
					"      final String name = stFile.getName().getValue();\n" + 
					"      final String filetype = stFile.getType().getValue();\n" + 
					"      final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" + 
					"      nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" + 
					"   });\n" + 
					"}");
		final TransactionAction AddMultipleValuesToProject = NextgenST.newTransactionAction().setName("AddMultipleValuesToProject").addFields("nextgen.st.model.STProject", "project").addFields("javax.swing.JComponent", "owner").setTitle("Add Multiple Values").addStatements("final java.util.List<javax.swing.JTextField> fields = new java.util.ArrayList<>();\n" + 
					"for (int i = 0; i < 10; i++) {\n" + 
					"   fields.add(newTextField(30));\n" + 
					"}\n" + 
					"\n" + 
					"final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fields.size(), 1));\n" + 
					"inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" + 
					"for (javax.swing.JTextField field : fields) {\n" + 
					"   inputPanel.add(field);\n" + 
					"}\n" + 
					"\n" + 
					"showDialog(owner, inputPanel, \"Values\", jDialog -> {\n" + 
					"\n" + 
					"   for (javax.swing.JTextField field : fields) {\n" + 
					"      final String value = field.getText().trim();\n" + 
					"      if(value.length()==0) continue;\n" + 
					"      final nextgen.st.model.STValue stValue = appModel().newSTValue(value);\n" + 
					"      project.addValues(stValue);\n" + 
					"      nextgen.events.NewSTProjectSTValue.post(stValue, project);   \n" + 
					"   }\n" + 
					"\n" + 
					"   close(jDialog);\n" + 
					"});");
		list.add(AddArgumentFromArgumentType);
		list.add(AddArgumentFromClipboard);
		list.add(AddArgumentFromInput);
		list.add(AddArgumentFromSTModel);
		list.add(AddArgumentFromSTModelUuid);
		list.add(AddArgumentFromSTTemplate);
		list.add(AddArgumentFromSTValue);
		list.add(AddChildrenToTemplate);
		list.add(AddFileSink);
		list.add(AddFileSinkToSTModels);
		list.add(AddInterface);
		list.add(AddKVArgument);
		list.add(AddModelToProject);
		list.add(AddValueToProject);
		list.add(AddValueToProjectFromInput);
		list.add(AddMultipleArgumentsFromArgumentType);
		list.add(AddTemplateModelToProject);
		list.add(CopyModel);
		list.add(DeleteEnum);
		list.add(DeleteKV);
		list.add(DeleteSTArgument);
		list.add(DeleteSTGroup);
		list.add(DeleteSTFile);
		list.add(DeleteSTFileFromSTModels);
		list.add(DeleteSTInterface);
		list.add(RemoveInterfaceFromSTTemplate);
		list.add(DeleteSTModel);
		list.add(DeleteSTTemplate);
		list.add(DeleteSTValue);
		list.add(EditEnum);
		list.add(EditModels);
		list.add(EditSTGroupTags);
		list.add(EditSTModel);
		list.add(GenerateAllProjectModels);
		list.add(GenerateAllSTGroups);
		list.add(GenerateSource);
		list.add(GenerateSources);
		list.add(GenerateSTGroup);
		list.add(GenerateSTGroupAndNeo);
		list.add(ImportSTTemplate);
		list.add(NewEnum);
		list.add(NewInterface);
		list.add(NewProject);
		list.add(NewSTGroupAction);
		list.add(NewSTModelAction);
		list.add(NewSTTemplate);
		list.add(AddChildToTemplate);
		list.add(OpenSTModelAction);
		list.add(OpenTemplate);
		list.add(RenameEnum);
		list.add(RenameSTGroup);
		list.add(RenameSTInterface);
		list.add(RenameSTTemplate);
		list.add(SetArgumentFromClipboard);
		list.add(SetArgumentFromInput);
		list.add(SetArgumentFromSTModel);
		list.add(SetArgumentFromSTModelUuid);
		list.add(SetArgumentFromSTTemplate);
		list.add(SetArgumentFromSTValue);
		list.add(SetArgumentToTrue);
		list.add(SetInterfaces);
		list.add(SetKVArgumentFromClipboard);
		list.add(SetKVArgumentFromInput);
		list.add(SetKVArgumentFromSTModel);
		list.add(SetKVArgumentFromSTValue);
		list.add(SetMultipleFields);
		list.add(SetSTValueFromClipboard);
		list.add(SetSTValueFromInput);
		list.add(SetTemplateParameterTypes);
		list.add(STValueToClipboard);
		list.add(STModelToClipboard);
		list.add(UndoDBTransaction);
		list.add(VisitSTModel);
		list.add(WriteSTModelToFile);
		list.add(WriteAllSTModelsToFile);
		list.add(AddMultipleValuesToProject);
		return list;
	}
}