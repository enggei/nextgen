package tmp;

import nextgen.templates.nextgen.*;

public class GenerateAll_TransactionAction {

   public static java.util.List<TransactionAction> generate() {
      final java.util.List<TransactionAction> list = new java.util.ArrayList<>();
      final TransactionAction GenerateSTGroupFromFile = NextgenST.newTransactionAction()
            .setName("GenerateSTGroupFromFile")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("stGroupFile", "nextgen.st.model.STGroupFile")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Generate")
            .addStatements("final nextgen.st.parser.ParseResult parseResult = nextgen.st.STParser.parse(nextgen.st.STGenerator.toSTGroup(stGroup));\n" +
                  "\n" +
                  "if (parseResult.getErrors().isEmpty()) {\n" +
                  "	stGroupFile.getIncomingFilesSTGroupModel().forEach(stGroupModel -> {\n" +
                  "		final String packageName = stGroupFile.getPackageName();\n" +
                  "		final String path = stGroupFile.getPath();\n" +
                  "		appModel().getSTGenerator().generateSTGroup(stGroupModel, packageName, path);\n" +
                  "	});\n" +
                  "} else {\n" +
                  "	final StringBuilder errors = new StringBuilder();\n" +
                  "	parseResult.getErrors().forEach(stgError -> errors.append(\"\\n\").append(stgError.getType()).append(\" \").append(stgError.getCharPosition()).append(\" at line \").append(stgError.getLine()));\n" +
                  "	showError(owner, errors.toString());\n" +
                  "}");
      final TransactionAction SetKVArgumentFromArgumentType = NextgenST.newTransactionAction()
            .setName("SetKVArgumentFromArgumentType")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stArgument", "nextgen.st.model.STArgument")
            .addFields("stParameterKey", "nextgen.st.model.STParameterKey")
            .addFields("owner", "javax.swing.JComponent")
            .setTitleExpression("\"Set \" + stParameterKey.getName()")
            .addMethods("private void addValue(nextgen.st.model.STValue stValue) {\n" +
                  "   final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stValue);\n" +
                  "   stArgument.addKeyValues(stArgumentKV);\n" +
                  "   nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);\n" +
                  "}")
            .addMethods("private void removeExisting() {\n" +
                  "   stArgument.getKeyValues()\n" +
                  "         .filter(existing -> existing.getStParameterKey().equals(stParameterKey))\n" +
                  "         .findFirst()\n" +
                  "         .ifPresent(existing -> {\n" +
                  "            stArgument.removeKeyValues(existing);\n" +
                  "            final String uuid = existing.getUuid();\n" +
                  "            existing.delete();\n" +
                  "            nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "         });\n" +
                  "}")
            .addStatements("final String argumentType = stParameterKey.getArgumentType();\n" +
                  "final nextgen.st.model.STParameter stParameter = stArgument.getStParameter();\n" +
                  "\n" +
                  "if (argumentType.equals(\"Object\") || argumentType.equals(\"String\")) {\n" +
                  "\n" +
                  "   final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = stModel.getArguments()\n" +
                  "         .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
                  "         .map(nextgen.st.model.STArgument::getValue)\n" +
                  "         .filter(nextgen.st.model.STValue::hasType)\n" +
                  "         .filter(stValue -> stValue.getType() == nextgen.st.model.STValueType.STMODEL)\n" +
                  "         .map(stValue -> stValue.getStModel().getStTemplate())\n" +
                  "         .findFirst();\n" +
                  "\n" +
                  "   if (stTemplate.isPresent()) {\n" +
                  "      removeExisting();\n" +
                  "      final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());\n" +
                  "      addValue(appModel().db.newSTValue(stTemplateModel));\n" +
                  "   } else {\n" +
                  "      input(owner, \"New value\", s -> {\n" +
                  "         removeExisting();\n" +
                  "         addValue(appModel().db.newSTValue(s));\n" +
                  "      });\n" +
                  "   }\n" +
                  "\n" +
                  "} else {\n" +
                  "\n" +
                  "   final nextgen.st.model.STGroupModel stGroupModel = appModel().findSTGroup(stModel.getStTemplate());\n" +
                  "   final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = nextgen.utils.STModelUtil\n" +
                  "         .aggregateTemplates(stGroupModel)\n" +
                  "         .filter(candidate -> candidate.getName().toLowerCase().equals(argumentType.toLowerCase()))\n" +
                  "         .findAny();\n" +
                  "\n" +
                  "   if (stTemplate.isPresent()) {\n" +
                  "\n" +
                  "      final java.util.List<nextgen.st.model.STModel> stModelList = stTemplate.get().getIncomingStTemplateSTModel().collect(java.util.stream.Collectors.toList());\n" +
                  "      if (!stModelList.isEmpty()) {\n" +
                  "\n" +
                  "         final nextgen.swing.SelectOrAddNewModelPanel input = new nextgen.swing.SelectOrAddNewModelPanel(stModelList, stTemplate.get());\n" +
                  "         showDialog(owner, input, \"Add\", jDialog -> {\n" +
                  "            removeExisting();\n" +
                  "            final nextgen.st.model.STValue stValue = input.getSTValue();\n" +
                  "            addValue(stValue);\n" +
                  "            jDialog.dispose();\n" +
                  "         });\n" +
                  "\n" +
                  "      } else {\n" +
                  "         removeExisting();\n" +
                  "         final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());\n" +
                  "         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "         addValue(stValue);\n" +
                  "      }\n" +
                  "\n" +
                  "   } else {\n" +
                  "      final java.util.Set<nextgen.st.model.STTemplate> interfaces = nextgen.utils.STModelUtil.findSTTemplatesByInterface(argumentType, stGroupModel);\n" +
                  "      if (!interfaces.isEmpty()) {\n" +
                  "         if (interfaces.size() == 1) {\n" +
                  "            removeExisting();\n" +
                  "            final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(interfaces.iterator().next());\n" +
                  "            addValue(appModel().db.newSTValue(stTemplateModel));\n" +
                  "         } else {\n" +
                  "            select(owner, interfaces, value -> {\n" +
                  "               removeExisting();\n" +
                  "               final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(value);\n" +
                  "               addValue(appModel().db.newSTValue(stTemplateModel));\n" +
                  "            });\n" +
                  "         }\n" +
                  "\n" +
                  "      } else {\n" +
                  "         final nextgen.st.model.STEnum stEnum = nextgen.utils.STModelUtil.findSTEnumByName(argumentType, stGroupModel);\n" +
                  "         if (stEnum != null) {\n" +
                  "            select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> {\n" +
                  "               removeExisting();\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue()\n" +
                  "                     .setType(nextgen.st.model.STValueType.ENUM)\n" +
                  "                     .setValue(value.getLexical() == null || value.getLexical().trim().length() == 0 ? value.getName() : value.getLexical());\n" +
                  "               addValue(stValue);\n" +
                  "            });\n" +
                  "         } else {\n" +
                  "            input(owner, \"New value\", s -> {\n" +
                  "               removeExisting();\n" +
                  "               addValue(appModel().db.newSTValue(s));\n" +
                  "            });\n" +
                  "         }\n" +
                  "      }\n" +
                  "   }\n" +
                  "}");
      final TransactionAction SetArgumentFromArgumentType = NextgenST.newTransactionAction()
            .setName("SetArgumentFromArgumentType")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("owner", "javax.swing.JComponent")
            .setTitleExpression("Set")
            .setTitle("Set")
            .addMethods("private void removeExisting() {\n" +
                  "   stModel.getArguments()\n" +
                  "         .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
                  "         .findAny()\n" +
                  "         .ifPresent(stArgument -> {\n" +
                  "            final String uuid = stArgument.getUuid();\n" +
                  "            stModel.removeArguments(stArgument);\n" +
                  "            stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "            stArgument.delete();\n" +
                  "            nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "         });\n" +
                  "}")
            .addMethods("private void addValue(nextgen.st.model.STValue stValue) {\n" +
                  "   final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "   stModel.addArguments(stArgument);\n" +
                  "   nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "}")
            .addStatements("final String argumentType = stParameter.getArgumentType();\n" +
                  "\n" +
                  "if (argumentType.equals(\"Object\") || argumentType.equals(\"String\")) {\n" +
                  "\n" +
                  "   final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = stModel.getArguments()\n" +
                  "         .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
                  "         .map(nextgen.st.model.STArgument::getValue)\n" +
                  "         .filter(nextgen.st.model.STValue::hasType)\n" +
                  "         .filter(stValue -> stValue.getType() == nextgen.st.model.STValueType.STMODEL)\n" +
                  "         .map(stValue -> stValue.getStModel().getStTemplate())\n" +
                  "         .findFirst();\n" +
                  "\n" +
                  "   if (stTemplate.isPresent()) {\n" +
                  "      removeExisting();\n" +
                  "      final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());\n" +
                  "      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "      addValue(stValue);\n" +
                  "   } else {\n" +
                  "      input(owner, \"New value\", s -> {\n" +
                  "         removeExisting();\n" +
                  "         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(s);\n" +
                  "         addValue(stValue);\n" +
                  "      });\n" +
                  "   }\n" +
                  "\n" +
                  "} else {\n" +
                  "\n" +
                  "   final nextgen.st.model.STGroupModel stGroupModel = appModel().findSTGroup(stModel.getStTemplate());\n" +
                  "   final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = nextgen.utils.STModelUtil\n" +
                  "         .aggregateTemplates(stGroupModel)\n" +
                  "         .filter(candidate -> candidate.getName().toLowerCase().equals(argumentType.toLowerCase()))\n" +
                  "         .findAny();\n" +
                  "\n" +
                  "   if (stTemplate.isPresent()) {\n" +
                  "\n" +
                  "      final java.util.List<nextgen.st.model.STModel> stModelList = stTemplate.get().getIncomingStTemplateSTModel().collect(java.util.stream.Collectors.toList());\n" +
                  "      if (!stModelList.isEmpty()) {\n" +
                  "\n" +
                  "         final nextgen.swing.SelectOrAddNewModelPanel input = new nextgen.swing.SelectOrAddNewModelPanel(stModelList, stTemplate.get());\n" +
                  "         showDialog(owner, input, \"Add\", jDialog -> {\n" +
                  "            removeExisting();\n" +
                  "            final nextgen.st.model.STValue stValue = input.getSTValue();\n" +
                  "            addValue(stValue);\n" +
                  "            jDialog.dispose();\n" +
                  "         });\n" +
                  "\n" +
                  "      } else {\n" +
                  "         removeExisting();\n" +
                  "         final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());\n" +
                  "         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "         addValue(stValue);\n" +
                  "      }\n" +
                  "\n" +
                  "   } else {\n" +
                  "      final java.util.Set<nextgen.st.model.STTemplate> interfaces = nextgen.utils.STModelUtil.findSTTemplatesByInterface(argumentType, stGroupModel);\n" +
                  "      if (!interfaces.isEmpty()) {\n" +
                  "         if (interfaces.size() == 1) {\n" +
                  "            removeExisting();\n" +
                  "            final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(interfaces.iterator().next());\n" +
                  "            final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "            addValue(stValue);\n" +
                  "         } else {\n" +
                  "            select(owner, interfaces, value -> {\n" +
                  "               removeExisting();\n" +
                  "               final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(value);\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "               addValue(stValue);\n" +
                  "            });\n" +
                  "         }\n" +
                  "\n" +
                  "      } else {\n" +
                  "         final nextgen.st.model.STEnum stEnum = nextgen.utils.STModelUtil.findSTEnumByName(argumentType, stGroupModel);\n" +
                  "         if (stEnum != null) {\n" +
                  "            select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> {\n" +
                  "               removeExisting();\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue()\n" +
                  "                     .setType(nextgen.st.model.STValueType.ENUM)\n" +
                  "                     .setValue(value.getLexical() == null || value.getLexical().trim().length() == 0 ? value.getName() : value.getLexical());\n" +
                  "               addValue(stValue);\n" +
                  "            });\n" +
                  "         } else {\n" +
                  "            input(owner, \"New value\", s -> {\n" +
                  "               removeExisting();\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(s);\n" +
                  "               addValue(stValue);\n" +
                  "            });\n" +
                  "         }\n" +
                  "      }\n" +
                  "   }\n" +
                  "}");
      final TransactionAction AddArgumentFromArgumentType = NextgenST.newTransactionAction()
            .setName("AddArgumentFromArgumentType")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Add")
            .addMethods("private void addValue(nextgen.st.model.STValue stValue) {\n" +
                  "   final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "   stModel.addArguments(stArgument);\n" +
                  "   nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "}")
            .addStatements("final String argumentType = stParameter.getArgumentType();\n" +
                  "\n" +
                  "if (argumentType.equals(\"Object\") || argumentType.equals(\"String\")) {\n" +
                  "\n" +
                  "   final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = stModel.getArguments()\n" +
                  "         .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
                  "         .map(nextgen.st.model.STArgument::getValue)\n" +
                  "         .filter(nextgen.st.model.STValue::hasType)\n" +
                  "         .filter(stValue -> stValue.getType() == nextgen.st.model.STValueType.STMODEL)\n" +
                  "         .map(stValue -> stValue.getStModel().getStTemplate())\n" +
                  "         .findFirst();\n" +
                  "\n" +
                  "   if (stTemplate.isPresent()) {\n" +
                  "      final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());\n" +
                  "      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "      addValue(stValue);\n" +
                  "   } else {\n" +
                  "      input(owner, \"New value\", s -> {\n" +
                  "         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(s);\n" +
                  "         addValue(stValue);\n" +
                  "      });\n" +
                  "   }\n" +
                  "\n" +
                  "} else {\n" +
                  "\n" +
                  "   final nextgen.st.model.STGroupModel stGroupModel = appModel().findSTGroup(stModel.getStTemplate());\n" +
                  "   final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = nextgen.utils.STModelUtil\n" +
                  "         .aggregateTemplates(stGroupModel)\n" +
                  "         .filter(candidate -> candidate.getName().toLowerCase().equals(argumentType.toLowerCase()))\n" +
                  "         .findAny();\n" +
                  "\n" +
                  "   if (stTemplate.isPresent()) {\n" +
                  "\n" +
                  "      final java.util.List<nextgen.st.model.STModel> stModelList = stTemplate.get().getIncomingStTemplateSTModel().collect(java.util.stream.Collectors.toList());\n" +
                  "      if (!stModelList.isEmpty()) {\n" +
                  "\n" +
                  "         final nextgen.swing.SelectOrAddNewModelPanel input = new nextgen.swing.SelectOrAddNewModelPanel(stModelList, stTemplate.get());\n" +
                  "         showDialog(owner, input, \"Add\", jDialog -> {\n" +
                  "            final nextgen.st.model.STValue stValue = input.getSTValue();\n" +
                  "            addValue(stValue);\n" +
                  "            jDialog.dispose();\n" +
                  "         });\n" +
                  "\n" +
                  "      } else {\n" +
                  "\n" +
                  "         final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());\n" +
                  "         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "         addValue(stValue);\n" +
                  "      }\n" +
                  "\n" +
                  "   } else {\n" +
                  "      final java.util.Set<nextgen.st.model.STTemplate> interfaces = nextgen.utils.STModelUtil.findSTTemplatesByInterface(argumentType, stGroupModel);\n" +
                  "      if (!interfaces.isEmpty()) {\n" +
                  "         if (interfaces.size() == 1) {\n" +
                  "            final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(interfaces.iterator().next());\n" +
                  "            final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "            addValue(stValue);\n" +
                  "         } else {\n" +
                  "            select(owner, interfaces, value -> {\n" +
                  "               final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(value);\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);\n" +
                  "               addValue(stValue);\n" +
                  "            });\n" +
                  "         }\n" +
                  "\n" +
                  "      } else {\n" +
                  "         final nextgen.st.model.STEnum stEnum = nextgen.utils.STModelUtil.findSTEnumByName(argumentType, stGroupModel);\n" +
                  "         if (stEnum != null) {\n" +
                  "            select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> {\n" +
                  "\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue()\n" +
                  "                     .setType(nextgen.st.model.STValueType.ENUM)\n" +
                  "                     .setValue(value.getLexical() == null || value.getLexical().trim().length() == 0 ? value.getName() : value.getLexical());\n" +
                  "               addValue(stValue);\n" +
                  "            });\n" +
                  "         } else {\n" +
                  "            input(owner, \"New value\", s -> {\n" +
                  "               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(s);\n" +
                  "               addValue(stValue);\n" +
                  "            });\n" +
                  "         }\n" +
                  "      }\n" +
                  "   }\n" +
                  "}");
      final TransactionAction AddArgumentFromClipboard = NextgenST.newTransactionAction()
            .setName("AddArgumentFromClipboard")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .setTitle("Add from Clipboard")
            .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
      final TransactionAction AddArgumentFromInput = NextgenST.newTransactionAction()
            .setName("AddArgumentFromInput")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Add from Input")
            .addStatements("input(owner, stParameter.getName(), inputValue -> {\n" +
                  "   final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);\n" +
                  "   final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "   stModel.addArguments(stArgument);\n" +
                  "   nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "});");
      final TransactionAction AddArgumentFromSTModel = NextgenST.newTransactionAction()
            .setName("AddArgumentFromSTModel")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("value", "nextgen.st.model.STModel")
            .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(value.getUuid()));\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
      final TransactionAction AddArgumentFromSTModelUuid = NextgenST.newTransactionAction()
            .setName("AddArgumentFromSTModelUuid")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("uuid", "String")
            .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(uuid));\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
      final TransactionAction AddArgumentFromSTTemplate = NextgenST.newTransactionAction()
            .setName("AddArgumentFromSTTemplate")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addStatements("final nextgen.st.model.STModel value = appModel().db.newSTModel().setStTemplate(stTemplate);\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
      final TransactionAction AddArgumentFromSTValue = NextgenST.newTransactionAction()
            .setName("AddArgumentFromSTValue")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("stValue", "nextgen.st.model.STValue")
            .addStatements("final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
      final TransactionAction AddChildrenToTemplate = NextgenST.newTransactionAction()
            .setName("AddChildrenToTemplate")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("children", "java.util.Set<nextgen.st.model.STTemplate>")
            .addFields("owner", "javax.swing.JComponent")
            .addStatements("confirm(owner, \"Sure to move\", unused -> {\n" +
                  "   nextgen.utils.STModelUtil.aggregateTemplates(stGroup).forEach(stGroupTemplate -> {\n" +
                  "      for (nextgen.st.model.STTemplate child : children) {\n" +
                  "         stGroupTemplate.removeChildren(child);\n" +
                  "      }\n" +
                  "   });\n" +
                  "\n" +
                  "   for (nextgen.st.model.STTemplate child : children)\n" +
                  "      stTemplate.addChildren(child);\n" +
                  "\n" +
                  "   nextgen.events.STTemplateChildrenAdded.post(stGroup, stTemplate, children);   \n" +
                  "});");
      final TransactionAction AddFileSink = NextgenST.newTransactionAction()
            .setName("AddFileSink")
            .addFields("stModel", "nextgen.st.model.STModel")
            .setTitle("Add File Sink")
            .addStatements("final String name = nextgen.utils.STModelUtil.getSTModelName(stModel, \"\");\n" +
                  "final String packageName = nextgen.utils.STModelUtil.getSTModelPackage(stModel, \"\");\n" +
                  "final nextgen.st.model.STFile stFile = appModel().db.newSTFile()\n" +
                  "            .setName(appModel().newSTValue(name))\n" +
                  "            .setType(appModel().db.findOrCreateSTValueByValue(\"java\"))\n" +
                  "            .setPath(appModel().newSTValue(\"\"))\n" +
                  "            .setPackageName(appModel().newSTValue(packageName));\n" +
                  "stModel.addFiles(stFile);\n" +
                  "nextgen.events.NewFileSink.post(stModel, stFile);");
      final TransactionAction AddFileSinkToSTModels = NextgenST.newTransactionAction()
            .setName("AddFileSinkToSTModels")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("stModels", "java.util.List<nextgen.st.model.STModel>")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Add File Sink")
            .addStatements("final String[] fileTypes = new String[]{\"html\", \"java\", \"js\", \"xml\"};\n" +
                  "\n" +
                  "final String[] pathTypes = appModel().db.findAllSTFile()\n" +
                  "      .filter(stFile -> stFile.getPath() != null)\n" +
                  "      .filter(stFile -> stFile.getPath().getValue() != null)\n" +
                  "      .map(stFile -> stFile.getPath().getValue())\n" +
                  "      .distinct()\n" +
                  "      .toArray(String[]::new);\n" +
                  "\n" +
                  "final java.util.Map<String, nextgen.st.model.STParameter> parameterMap = new java.util.LinkedHashMap<>();\n" +
                  "final java.util.List<String> nameOptions = stTemplate.getParameters()\n" +
                  "      .filter(stParameter -> stParameter.getType().equals(nextgen.st.model.STParameterType.SINGLE))\n" +
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
                  "   final nextgen.st.model.STParameter stParameter = parameterMap.get(fieldMap.get(\"name\").getText().trim());\n" +
                  "   final String type = fieldMap.get(\"type\").getText().trim();\n" +
                  "   final String path = fieldMap.get(\"path\").getText().trim();\n" +
                  "   final String packageName = fieldMap.get(\"package\").getText().trim();\n" +
                  "\n" +
                  "   for (nextgen.st.model.STModel stModel : stModels) {\n" +
                  "      stModel.getArguments()\n" +
                  "            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
                  "            .findFirst()\n" +
                  "            .ifPresent(stArgument -> {\n" +
                  "               final nextgen.st.model.STFile stFile = appModel().db.newSTFile()\n" +
                  "                     .setName(appModel().newSTValue(appModel().render(stArgument)))\n" +
                  "                     .setType(appModel().db.findOrCreateSTValueByValue(type))\n" +
                  "                     .setPath(appModel().newSTValue(path))\n" +
                  "                     .setPackageName(appModel().newSTValue(packageName));\n" +
                  "               stModel.addFiles(stFile);\n" +
                  "               nextgen.events.NewFileSink.post(stModel, stFile);\n" +
                  "            });\n" +
                  "   }\n" +
                  "   javax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" +
                  "});");
      final TransactionAction AddInterface = NextgenST.newTransactionAction()
            .setName("AddInterface")
            .addFields("children", "java.util.Set<nextgen.st.model.STTemplate>")
            .addFields("owner", "javax.swing.JComponent")
            .addStatements("final javax.swing.JTextField txtImplements = newTextField();\n" +
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 1));\n" +
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" +
                  "contentPanel.add(txtImplements);\n" +
                  "\n" +
                  "showDialog(owner, contentPanel, \"Add interface\", jDialog -> {\n" +
                  "   final String interfaceName = txtImplements.getText().trim();\n" +
                  "   if (interfaceName.length()==0) return;\n" +
                  "   for (nextgen.st.model.STTemplate child : children) {\n" +
                  "      final java.util.Optional<String> optional = child.getImplements().filter(s -> s.toLowerCase().equals(interfaceName.toLowerCase())).findAny();\n" +
                  "      if(optional.isPresent()) continue;\n" +
                  "      child.addImplements(interfaceName);\n" +
                  "   }\n" +
                  "   close(jDialog);   \n" +
                  "});");
      final TransactionAction AddKVArgument = NextgenST.newTransactionAction()
            .setName("AddKVArgument")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Add")
            .addStatements("final String[] selectedValues = appModel().getSelectedValues();\n" +
                  "final java.util.Map<nextgen.st.model.STParameterKey, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();\n" +
                  "stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(40, selectedValues)));\n" +
                  "\n" +
                  "final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));\n" +
                  "inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" +
                  "for (java.util.Map.Entry<nextgen.st.model.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {\n" +
                  "	inputPanel.add(new javax.swing.JLabel(fieldEntry.getKey().getName()));\n" +
                  "	inputPanel.add(fieldEntry.getValue());\n" +
                  "}\n" +
                  "\n" +
                  "showDialog(owner, inputPanel, stParameter.getName(), jDialog -> {\n" +
                  "	java.util.Collection<nextgen.st.model.STArgumentKV> kvs = new java.util.ArrayList<>();\n" +
                  "	for (java.util.Map.Entry<nextgen.st.model.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {\n" +
                  "		final String value = fieldEntry.getValue().getText().trim();\n" +
                  "		if (value.length() == 0) continue;\n" +
                  "\n" +
                  "		final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "		final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(fieldEntry.getKey()).setValue(stValue);\n" +
                  "		kvs.add(stArgumentKV);\n" +
                  "	}\n" +
                  "\n" +
                  "	final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument().setStParameter(stParameter);\n" +
                  "	for (nextgen.st.model.STArgumentKV kv : kvs) stArgument.addKeyValues(kv);\n" +
                  "	stModel.addArguments(stArgument);\n" +
                  "	nextgen.events.NewSTKVArgument.post(stModel, stParameter, stArgument, kvs);\n" +
                  "\n" +
                  "	close(jDialog);\n" +
                  "});");
      final TransactionAction AddModelToProject = NextgenST.newTransactionAction()
            .setName("AddModelToProject")
            .addFields("project", "nextgen.st.model.STProject")
            .addFields("stModel", "nextgen.st.model.STModel")
            .setTitle("Add to Project")
            .addStatements("project.addModels(stModel);\n" +
                  "nextgen.events.NewSTProjectSTModel.post(stModel, project, appModel().getSTTemplate(stModel));");
      final TransactionAction AddValueToProject = NextgenST.newTransactionAction()
            .setName("AddValueToProject")
            .addFields("project", "nextgen.st.model.STProject")
            .addFields("stValue", "nextgen.st.model.STValue")
            .setTitle("Add to Project")
            .addStatements("project.addValues(stValue);\n" +
                  "nextgen.events.NewSTProjectSTValue.post(stValue, project);");
      final TransactionAction AddValueToProjectFromInput = NextgenST.newTransactionAction()
            .setName("AddValueToProjectFromInput")
            .addFields("project", "nextgen.st.model.STProject")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Add New Value to Project")
            .addStatements("input(owner, \"New Value\", value -> {\n" +
                  "   final nextgen.st.model.STValue stValue = appModel().newSTValue(value);\n" +
                  "   project.addValues(stValue);\n" +
                  "   nextgen.events.NewSTProjectSTValue.post(stValue, project);\n" +
                  "});");
      final TransactionAction AddTemplateModelToProject = NextgenST.newTransactionAction()
            .setName("AddTemplateModelToProject")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("project", "nextgen.st.model.STProject")
            .addStatements("final nextgen.st.model.STModel stModel = appModel().db.newSTModel().setStTemplate(stTemplate);\n" +
                  "project.addModels(stModel);\n" +
                  "nextgen.events.NewSTProjectSTModel.post(stModel, project, stTemplate);");
      final TransactionAction CopyModel = NextgenST.newTransactionAction()
            .setName("CopyModel")
            .addFields("stModel", "nextgen.st.model.STModel")
            .setTitle("Copy Model")
            .addStatements("toClipboard(\"stmodel-\" + stModel.getUuid());");
      final TransactionAction DeleteEnum = NextgenST.newTransactionAction()
            .setName("DeleteEnum")
            .addFields("stEnum", "nextgen.st.model.STEnum")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   stGroup.removeEnums(stEnum);\n" +
                  "   nextgen.events.STEnumDeleted.post(stEnum.getUuid());\n" +
                  "});");
      final TransactionAction DeleteKV = NextgenST.newTransactionAction()
            .setName("DeleteKV")
            .addFields("argumentKV", "nextgen.st.model.STArgumentKV")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Remove")
            .addStatements("confirm(owner, \"Delete\", unused ->\n" +
                  "      argumentKV.getIncomingKeyValuesSTArgument()\n" +
                  "            .findFirst()\n" +
                  "            .ifPresent(stArgument -> stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {\n" +
                  "               final String uuid = argumentKV.getUuid();\n" +
                  "               stArgument.removeKeyValues(argumentKV);\n" +
                  "               nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "            })));");
      final TransactionAction DeleteSTArgument = NextgenST.newTransactionAction()
            .setName("DeleteSTArgument")
            .addFields("stArgument", "nextgen.st.model.STArgument")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Remove\", unused ->\n" +
                  "      stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      }));");
      final TransactionAction DeleteSTGroup = NextgenST.newTransactionAction()
            .setName("DeleteSTGroup")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   final String uuid = stGroup.getUuid();\n" +
                  "   stGroup.delete();\n" +
                  "   nextgen.events.STGroupDeleted.post(uuid);\n" +
                  "});");
      final TransactionAction DeleteSTFile = NextgenST.newTransactionAction()
            .setName("DeleteSTFile")
            .addFields("stFile", "nextgen.st.model.STFile")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   final String uuid = stFile.getUuid();\n" +
                  "   final nextgen.st.model.STFile found = appModel().db.findSTFileByUuid(uuid);\n" +
                  "   if (found != null) appModel().db.delete(found.getNode());\n" +
                  "   nextgen.events.STFileDeleted.post(uuid);\n" +
                  "});");
      final TransactionAction DeleteSTFileFromSTModels = NextgenST.newTransactionAction()
            .setName("DeleteSTFileFromSTModels")
            .addFields("stModels", "java.util.List<nextgen.st.model.STModel>")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete Filesinks")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   for (nextgen.st.model.STModel stModel : stModels) {\n" +
                  "      stModel.getFiles().forEach(stFile -> {\n" +
                  "         final String uuid = stFile.getUuid();\n" +
                  "         final nextgen.st.model.STFile found = appModel().db.findSTFileByUuid(uuid);\n" +
                  "         if (found != null) appModel().db.delete(found.getNode());\n" +
                  "         nextgen.events.STFileDeleted.post(uuid);      \n" +
                  "      });\n" +
                  "   }\n" +
                  "});");
      final TransactionAction DeleteSTInterface = NextgenST.newTransactionAction()
            .setName("DeleteSTInterface")
            .addFields("stInterface", "nextgen.st.model.STInterface")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   stGroup.removeInterfaces(stInterface);\n" +
                  "   nextgen.events.STInterfaceDeleted.post(stInterface.getUuid());   \n" +
                  "});");
      final TransactionAction RemoveInterfaceFromSTTemplate = NextgenST.newTransactionAction()
            .setName("RemoveInterfaceFromSTTemplate")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("interfaceName", "String")
            .addFields("owner", "javax.swing.JComponent")
            .addStatements("confirm(owner, \"Remove\", unused -> {\n" +
                  "   stTemplate.removeImplements(interfaceName);\n" +
                  "   nextgen.events.STTemplateInterfaceRemoved.post(stGroup, stTemplate, interfaceName);\n" +
                  "});");
      final TransactionAction DeleteSTModel = NextgenST.newTransactionAction()
            .setName("DeleteSTModel")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   final String uuid = stModel.getUuid();\n" +
                  "   final nextgen.st.model.STModel found = appModel().db.findSTModelByUuid(uuid);\n" +
                  "   if (found != null) appModel().db.delete(found.getNode());\n" +
                  "   nextgen.events.STModelDeleted.post(uuid);\n" +
                  "});");
      final TransactionAction DeleteSTTemplate = NextgenST.newTransactionAction()
            .setName("DeleteSTTemplate")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "	final String uuid = stTemplate.getUuid();\n" +
                  "	stTemplate.delete();\n" +
                  "	nextgen.events.STTemplateDeleted.post(uuid);\n" +
                  "});");
      final TransactionAction DeleteSTValue = NextgenST.newTransactionAction()
            .setName("DeleteSTValue")
            .addFields("stValue", "nextgen.st.model.STValue")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "   final String uuid = stValue.getUuid();\n" +
                  "   final nextgen.st.model.STValue found = appModel().db.findSTValueByUuid(uuid);\n" +
                  "   if (found != null) appModel().db.delete(found.getNode());\n" +
                  "   nextgen.events.STValueDeleted.post(uuid);\n" +
                  "});");
      final TransactionAction EditEnum = NextgenST.newTransactionAction()
            .setName("EditEnum")
            .addFields("stEnum", "nextgen.st.model.STEnum")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Edit")
            .addStatements("final int newFields = 5;\n" +
                  "final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout((int) stEnum.getValues().count() + newFields + 1, 2));\n" +
                  "contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));\n" +
                  "contentPanel.add(newLabel(\"Name\"));\n" +
                  "contentPanel.add(newLabel(\"Lexical\"));\n" +
                  "\n" +
                  "// existing values:\n" +
                  "final java.util.Map<nextgen.st.model.STEnumValue, javax.swing.JTextField> txtEnumValuesName = new java.util.LinkedHashMap<>();\n" +
                  "final java.util.Map<nextgen.st.model.STEnumValue, javax.swing.JTextField> txtEnumLexical = new java.util.LinkedHashMap<>();\n" +
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
                  "	for (nextgen.st.model.STEnumValue stEnumValue : txtEnumValuesName.keySet()) {\n" +
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
                  "		stEnum.addValues(appModel().newSTEnumValue()\n" +
                  "				.setName(newEnumValue)\n" +
                  "				.setLexical(newEnumLexical.length() == 0 ? null : newEnumLexical));\n" +
                  "	}\n" +
                  "\n" +
                  "	nextgen.events.STEnumChanged.post(stEnum);\n" +
                  "});");
      final TransactionAction EditSTGroupTags = NextgenST.newTransactionAction()
            .setName("EditSTGroupTags")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Edit tags")
            .addStatements("input(owner, \"Tags\", stGroup.getTags(\"\"), tags -> {\n" +
                  "   stGroup.setTags(tags);\n" +
                  "   nextgen.events.STGroupTagsChanged.post(stGroup);\n" +
                  "});");
      final TransactionAction GenerateAllProjectModels = NextgenST.newTransactionAction()
            .setName("GenerateAllProjectModels")
            .addFields("project", "nextgen.st.model.STProject")
            .setTitle("Generate all")
            .addStatements("project.getModels().forEach(stModel ->\n" +
                  "      stModel.getFiles().forEach(stFile -> {\n" +
                  "         final String content = appModel().render(stModel);\n" +
                  "         final String packageDeclaration = stFile.getPackageName().getValue();\n" +
                  "         final String name = stFile.getName().getValue();\n" +
                  "         final String filetype = stFile.getType().getValue();\n" +
                  "         final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" +
                  "         nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" +
                  "      }));");
      final TransactionAction GenerateAllSTGroups = NextgenST.newTransactionAction()
            .setName("GenerateAllSTGroups")
            .setTitle("Generate all")
            .addStatements("appModel().getSTGroups().forEach(stGroupModel -> appModel().generateSTGroup(stGroupModel, false));");
      final TransactionAction GenerateSource = NextgenST.newTransactionAction()
            .setName("GenerateSource")
            .addFields("stModel", "nextgen.st.model.STModel")
            .setTitle("As builder code")
            .addStatements("final java.util.Set<String> imports = new java.util.LinkedHashSet<>();\n" +
                  "\n" +
                  "final String packageName = appModel().getSourceOutputPackage();\n" +
                  "final String templateName = appModel().getSTTemplate(stModel).getName();\n" +
                  "final String className = nextgen.utils.STModelUtil.getSTModelName(stModel, templateName) + \"Generator\";\n" +
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
      final TransactionAction GenerateSources = NextgenST.newTransactionAction()
            .setName("GenerateSources")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("stModels", "java.util.List<nextgen.st.model.STModel>")
            .setTitle("As builder code")
            .addStatements("final java.util.Set<String> imports = new java.util.LinkedHashSet<>();\n" +
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
                  "   final String stModelName = nextgen.utils.STModelUtil.getSTModelName(stModel, \"var_\" + variableCount.incrementAndGet());\n" +
                  "   final nextgen.templates.java.VariableDeclarationExpression variableDeclarationExpression = nextgen.templates.JavaPatterns\n" +
                  "         .newFinalVariableDeclarationExpression(type, stModelName, appModel().stRenderer.renderGeneratorCode(stModel, imports));\n" +
                  "   blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()\n" +
                  "         .setExpression(variableDeclarationExpression));\n" +
                  "}\n" +
                  "\n" +
                  "variableCount = new java.util.concurrent.atomic.AtomicInteger();\n" +
                  "for (nextgen.st.model.STModel stModel : stModels) {\n" +
                  "   final String stModelName = nextgen.utils.STModelUtil.getSTModelName(stModel, \"var_\" + variableCount.incrementAndGet());\n" +
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
      final TransactionAction GenerateSTGroup = NextgenST.newTransactionAction()
            .setName("GenerateSTGroup")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .setTitle("Generate STGroup")
            .addStatements("appModel().generateSTGroup(stGroup, false);");
      final TransactionAction GenerateSTGroupAndNeo = NextgenST.newTransactionAction()
            .setName("GenerateSTGroupAndNeo")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .setTitle("Generate STGroup and Neo")
            .addStatements("appModel().generateSTGroup(stGroup, true);");
      final TransactionAction ImportSTTemplate = NextgenST.newTransactionAction()
            .setName("ImportSTTemplate")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Import from stg-file")
            .addStatements("openFile(owner, file -> {\n" +
                  "	appModel().setLastDir(file.getParentFile());\n" +
                  "	appModel().doLaterInTransaction(t -> {\n" +
                  "		final String fileName = file.getName();\n" +
                  "		final String name = fileName.substring(0, fileName.indexOf(\".\"));\n" +
                  "		final nextgen.st.model.STTemplate stTemplate = appModel().db.newSTTemplate()\n" +
                  "            .setName(name)\n" +
                  "            .setText(nextgen.utils.FileUtil.readIntact(file));\n" +
                  "      stGroup.addTemplates(stTemplate);\n" +
                  "		nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);\n" +
                  "	});\n" +
                  "});");
      final TransactionAction NewEnum = NextgenST.newTransactionAction()
            .setName("NewEnum")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("New Enum")
            .addStatements("input(owner, \"New Enum\", s ->\n" +
                  "		nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "			final nextgen.st.model.STEnum stEnum = appModel().db.newSTEnum().setName(s);\n" +
                  "			stGroup.addEnums(stEnum);\n" +
                  "			nextgen.events.NewSTEnum.post(stGroup, stEnum);\n" +
                  "		}));");
      final TransactionAction NewInterface = NextgenST.newTransactionAction()
            .setName("NewInterface")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("New Interface")
            .addStatements("input(owner, \"New Interface\", s ->\n" +
                  "		nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "			final nextgen.st.model.STInterface stInterface = appModel().db.newSTInterface().setName(s);\n" +
                  "			stGroup.addInterfaces(stInterface);\n" +
                  "			nextgen.events.NewSTInterface.post(stGroup, stInterface);\n" +
                  "		}));");
      final TransactionAction NewProject = NextgenST.newTransactionAction()
            .setName("NewProject")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("New Project")
            .addStatements("input(owner, \"Name\", s -> {\n" +
                  "   final nextgen.st.model.STProject stProject = appModel().db.newSTProject().setName(s);\n" +
                  "   nextgen.events.NewSTProject.post(stProject);\n" +
                  "});");
      final TransactionAction NewSTGroupAction = NextgenST.newTransactionAction()
            .setName("NewSTGroupAction")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("New STGroup")
            .addStatements("input(owner, \"Name\", name -> {\n" +
                  "	\n" +
                  "	final java.util.Optional<nextgen.st.model.STGroupModel> existing = appModel().findSTGroup(name);\n" +
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
                  "	final nextgen.st.model.STGroupModel stGroupModel = appModel().db.newSTGroupModel()\n" +
                  "			.setName(name)\n" +
                  "			.setDelimiter(nextgen.st.STGenerator.DELIMITER);\n" +
                  "	nextgen.events.NewSTGroup.post(stGroupModel);\n" +
                  "});");
      final TransactionAction NewSTModelAction = NextgenST.newTransactionAction()
            .setName("NewSTModelAction")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .setTitle("New instance")
            .addStatements("final nextgen.st.model.STModel stModel = appModel().db.newSTModel().setStTemplate(stTemplate);\n" +
                  "nextgen.events.NewSTModel.post(stModel, appModel().findSTGroup(stTemplate), stTemplate);");
      final TransactionAction NewSTTemplate = NextgenST.newTransactionAction()
            .setName("NewSTTemplate")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("New Template")
            .addStatements("input(owner, \"Name\", s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "	final nextgen.st.model.STTemplate stTemplate = appModel().db.newSTTemplate().setName(name).setText(\"\");\n" +
                  "	stGroup.addTemplates(stTemplate);\n" +
                  "	nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);\n" +
                  "}));");
      final TransactionAction AddChildToTemplate = NextgenST.newTransactionAction()
            .setName("AddChildToTemplate")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Add Child template")
            .addStatements("input(owner, \"Name\", s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s)\n" +
                  "		.ifPresent(name -> {\n" +
                  "			final nextgen.st.model.STTemplate newTemplate = appModel().db.newSTTemplate().setName(name).setText(\"\");\n" +
                  "			stTemplate.addChildren(newTemplate);\n" +
                  "			nextgen.events.NewSTTemplateChild.post(newTemplate, stTemplate);\n" +
                  "		}));");
      final TransactionAction RenameEnum = NextgenST.newTransactionAction()
            .setName("RenameEnum")
            .addFields("stEnum", "nextgen.st.model.STEnum")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Rename")
            .addStatements("input(owner, \"Name\", stEnum.getName(), s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "	stEnum.setName(name);\n" +
                  "	nextgen.events.STEnumNameChanged.post(stGroup, stEnum);\n" +
                  "}));");
      final TransactionAction RenameSTGroup = NextgenST.newTransactionAction()
            .setName("RenameSTGroup")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Rename")
            .addStatements("input(owner, \"Name\", stGroup.getName(), s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "   stGroup.setName(name);\n" +
                  "   nextgen.events.STGroupNameChanged.post(stGroup);\n" +
                  "}));");
      final TransactionAction RenameSTInterface = NextgenST.newTransactionAction()
            .setName("RenameSTInterface")
            .addFields("stInterface", "nextgen.st.model.STInterface")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Rename")
            .addStatements("input(owner, \"Name\", stInterface.getName(), s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "   stInterface.setName(name);\n" +
                  "   nextgen.events.STInterfaceNameChanged.post(stGroup, stInterface);\n" +
                  "}));");
      final TransactionAction RenameSTTemplate = NextgenST.newTransactionAction()
            .setName("RenameSTTemplate")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Rename")
            .addStatements("input(owner, \"Name\", stTemplate.getName(), s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
                  "   stTemplate.setName(name);\n" +
                  "   nextgen.events.STTemplateNameChanged.post(stGroup, stTemplate);\n" +
                  "}));");
      final TransactionAction SetArgumentFromClipboard = NextgenST.newTransactionAction()
            .setName("SetArgumentFromClipboard")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .setTitle("Set from Clipboard")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
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
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "\n" +
                  "if (\"name\".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);");
      final TransactionAction SetArgumentFromInput = NextgenST.newTransactionAction()
            .setName("SetArgumentFromInput")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Set from Input")
            .addStatements("input(owner, stParameter.getName(), inputValue -> {\n" +
                  "   stModel.getArguments()\n" +
                  "         .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
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
                  "   if (\"name\".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);\n" +
                  "});");
      final TransactionAction SetArgumentFromSTModel = NextgenST.newTransactionAction()
            .setName("SetArgumentFromSTModel")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("value", "nextgen.st.model.STModel")
            .addStatements("stModel.getArguments()\n" +
                  "            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
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
      final TransactionAction SetArgumentFromSTModelUuid = NextgenST.newTransactionAction()
            .setName("SetArgumentFromSTModelUuid")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("uuid", "String")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
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
      final TransactionAction SetArgumentFromSTTemplate = NextgenST.newTransactionAction()
            .setName("SetArgumentFromSTTemplate")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
                  "      .findAny()\n" +
                  "      .ifPresent(stArgument -> {\n" +
                  "         final String uuid = stArgument.getUuid();\n" +
                  "         stModel.removeArguments(stArgument);\n" +
                  "         stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);\n" +
                  "         stArgument.delete();\n" +
                  "         nextgen.events.STArgumentDeleted.post(stModel, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STModel value = appModel().db.newSTModel().setStTemplate(stTemplate);\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
                  "stModel.addArguments(stArgument);\n" +
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);");
      final TransactionAction SetArgumentFromSTValue = NextgenST.newTransactionAction()
            .setName("SetArgumentFromSTValue")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .addFields("stValue", "nextgen.st.model.STValue")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
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
                  "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
                  "\n" +
                  "if (\"name\".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);");
      final TransactionAction SetArgumentToTrue = NextgenST.newTransactionAction()
            .setName("SetArgumentToTrue")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stParameter", "nextgen.st.model.STParameter")
            .setTitle("Set to true")
            .addStatements("stModel.getArguments()\n" +
                  "      .filter(stArgument -> stArgument.getStParameter().equals(stParameter))\n" +
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
      final TransactionAction SetInterfaces = NextgenST.newTransactionAction()
            .setName("SetInterfaces")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Set interfaces")
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
                  "   stTemplate.removeAllImplements();\n" +
                  "   for (javax.swing.JTextField txtImplement : txtImplements) {\n" +
                  "      final String trim = txtImplement.getText().trim();\n" +
                  "      if (trim.length() == 0) continue;\n" +
                  "      stTemplate.addImplements(trim);\n" +
                  "   }\n" +
                  "\n" +
                  "   nextgen.events.STTemplateInterfacesChanged.post(stGroup, stTemplate);\n" +
                  "   javax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" +
                  "});");
      final TransactionAction SetKVArgumentFromClipboard = NextgenST.newTransactionAction()
            .setName("SetKVArgumentFromClipboard")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stArgument", "nextgen.st.model.STArgument")
            .addFields("stParameterKey", "nextgen.st.model.STParameterKey")
            .setTitleExpression("\"Set \" + stParameterKey.getName() + \" from Clipboard\"")
            .addStatements("stArgument.getKeyValues()\n" +
                  "      .filter(existing -> existing.getStParameterKey().equals(stParameterKey))\n" +
                  "      .findFirst()\n" +
                  "      .ifPresent(existing -> {\n" +
                  "         stArgument.removeKeyValues(existing);\n" +
                  "         final String uuid = existing.getUuid();\n" +
                  "         existing.delete();\n" +
                  "         nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stValue);\n" +
                  "stArgument.addKeyValues(stArgumentKV);\n" +
                  "\n" +
                  "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);");
      final TransactionAction SetKVArgumentFromInput = NextgenST.newTransactionAction()
            .setName("SetKVArgumentFromInput")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stArgument", "nextgen.st.model.STArgument")
            .addFields("stParameterKey", "nextgen.st.model.STParameterKey")
            .addFields("owner", "javax.swing.JComponent")
            .setTitleExpression("\"Set \" + stParameterKey.getName() + \" from Input\"")
            .addStatements("input(owner, stParameterKey.getName(), inputValue -> {\n" +
                  "	stArgument.getKeyValues()\n" +
                  "			.filter(existing -> existing.getStParameterKey().equals(stParameterKey))\n" +
                  "			.findFirst()\n" +
                  "			.ifPresent(existing -> {\n" +
                  "				stArgument.removeKeyValues(existing);\n" +
                  "				final String uuid = existing.getUuid();\n" +
                  "				existing.delete();\n" +
                  "				nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "			});\n" +
                  "\n" +
                  "	final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);\n" +
                  "	final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stValue);\n" +
                  "	stArgument.addKeyValues(stArgumentKV);\n" +
                  "\n" +
                  "	nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);\n" +
                  "});");
      final TransactionAction SetKVArgumentFromSTModel = NextgenST.newTransactionAction()
            .setName("SetKVArgumentFromSTModel")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stArgument", "nextgen.st.model.STArgument")
            .addFields("stParameterKey", "nextgen.st.model.STParameterKey")
            .addFields("value", "nextgen.st.model.STModel")
            .setTitleExpression("\"Set \" + stParameterKey.getName() + \" from STModel\"")
            .addStatements("stArgument.getKeyValues()\n" +
                  "      .filter(existing -> existing.getStParameterKey().equals(stParameterKey))\n" +
                  "      .findFirst()\n" +
                  "      .ifPresent(existing -> {\n" +
                  "         stArgument.removeKeyValues(existing);\n" +
                  "         final String uuid = existing.getUuid();\n" +
                  "         existing.delete();\n" +
                  "         nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
                  "final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stValue);\n" +
                  "stArgument.addKeyValues(stArgumentKV);\n" +
                  "\n" +
                  "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);");
      final TransactionAction SetKVArgumentFromSTValue = NextgenST.newTransactionAction()
            .setName("SetKVArgumentFromSTValue")
            .addFields("stModel", "nextgen.st.model.STModel")
            .addFields("stArgument", "nextgen.st.model.STArgument")
            .addFields("stParameterKey", "nextgen.st.model.STParameterKey")
            .addFields("stValue", "nextgen.st.model.STValue")
            .setTitleExpression("\"Set \" + stParameterKey.getName() + \" from STValue\"")
            .addStatements("stArgument.getKeyValues()\n" +
                  "      .filter(existing -> existing.getStParameterKey().equals(stParameterKey))\n" +
                  "      .findFirst()\n" +
                  "      .ifPresent(existing -> {\n" +
                  "         stArgument.removeKeyValues(existing);\n" +
                  "         final String uuid = existing.getUuid();\n" +
                  "         existing.delete();\n" +
                  "         nextgen.events.KVDeleted.post(stModel, stArgument, uuid);\n" +
                  "      });\n" +
                  "\n" +
                  "final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stValue);\n" +
                  "stArgument.addKeyValues(stArgumentKV);\n" +
                  "\n" +
                  "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);");
      final TransactionAction SetSTValueFromClipboard = NextgenST.newTransactionAction()
            .setName("SetSTValueFromClipboard")
            .addFields("stValue", "nextgen.st.model.STValue")
            .setTitle("Set from Clipboard")
            .addStatements("stValue.removeStModel();\n" +
                  "stValue.setValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
                  "stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);\n" +
                  "nextgen.events.STValueChanged.post(stValue);");
      final TransactionAction SetSTValueFromInput = NextgenST.newTransactionAction()
            .setName("SetSTValueFromInput")
            .addFields("stValue", "nextgen.st.model.STValue")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Set from Input")
            .addStatements("input(owner, \"Set Value\", value -> {\n" +
                  "   stValue.removeStModel();\n" +
                  "   stValue.setValue(value);\n" +
                  "   stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);\n" +
                  "   nextgen.events.STValueChanged.post(stValue);\n" +
                  "});");
      final TransactionAction SetTemplateParameterTypes = NextgenST.newTransactionAction()
            .setName("SetTemplateParameterTypes")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .addFields("stTemplate", "nextgen.st.model.STTemplate")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Set parameter types")
            .addStatements("final java.util.Map<String, javax.swing.JTextField> txtParameterMap = new java.util.TreeMap<>();\n" +
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
                  "	nextgen.events.STTemplateParameterTypesChanged.post(stGroup, stTemplate);\n" +
                  "	javax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" +
                  "});");
      final TransactionAction STValueToClipboard = NextgenST.newTransactionAction()
            .setName("STValueToClipboard")
            .addFields("stValue", "nextgen.st.model.STValue")
            .setTitle("To Clipboard")
            .addStatements("nextgen.utils.SwingUtil.toClipboard(appModel().render(stValue));");
      final TransactionAction STModelToClipboard = NextgenST.newTransactionAction()
            .setName("STModelToClipboard")
            .addFields("stModel", "nextgen.st.model.STModel")
            .setTitle("To Clipboard")
            .addStatements("nextgen.utils.SwingUtil.toClipboard(appModel().render(stModel));");
      final TransactionAction UndoDBTransaction = NextgenST.newTransactionAction()
            .setName("UndoDBTransaction")
            .setTitle("Undo")
            .addStatements("appModel().undoLast();");
      final TransactionAction WriteSTModelToFile = NextgenST.newTransactionAction()
            .setName("WriteSTModelToFile")
            .addFields("stModel", "nextgen.st.model.STModel")
            .setTitle("Generate")
            .addStatements("stModel.getFiles().forEach(stFile -> {\n" +
                  "   final String content = appModel().render(stModel);\n" +
                  "   final String packageDeclaration = stFile.getPackageName().getValue();\n" +
                  "   final String name = stFile.getName().getValue();\n" +
                  "   final String filetype = stFile.getType().getValue();\n" +
                  "   final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" +
                  "   nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" +
                  "});");
      final TransactionAction WriteAllSTModelsToFile = NextgenST.newTransactionAction()
            .setName("WriteAllSTModelsToFile")
            .addFields("stModels", "java.util.List<nextgen.st.model.STModel>")
            .setTitle("Generate All")
            .addStatements("for (nextgen.st.model.STModel stModel : stModels) {\n" +
                  "   stModel.getFiles().forEach(stFile -> {\n" +
                  "      final String content = appModel().render(stModel);\n" +
                  "      final String packageDeclaration = stFile.getPackageName().getValue();\n" +
                  "      final String name = stFile.getName().getValue();\n" +
                  "      final String filetype = stFile.getType().getValue();\n" +
                  "      final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" +
                  "      nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" +
                  "   });\n" +
                  "}");
      final TransactionAction AddMultipleValuesToProject = NextgenST.newTransactionAction()
            .setName("AddMultipleValuesToProject")
            .addFields("project", "nextgen.st.model.STProject")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Add Multiple Values")
            .addStatements("final java.util.List<javax.swing.JTextField> fields = new java.util.ArrayList<>();\n" +
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
      final TransactionAction AddFileSinkToGroup = NextgenST.newTransactionAction()
            .setName("AddFileSinkToGroup")
            .addFields("stGroup", "nextgen.st.model.STGroupModel")
            .setTitle("Add File")
            .addStatements("final nextgen.st.model.STGroupFile stGroupFile = appModel().db.newSTGroupFile();\n" +
                  "stGroup.addFiles(stGroupFile);\n" +
                  "nextgen.events.NewSTGroupFile.post(stGroup, stGroupFile);");
      final TransactionAction DeleteSTGroupFile = NextgenST.newTransactionAction()
            .setName("DeleteSTGroupFile")
            .addFields("stgroupFile", "nextgen.st.model.STGroupFile")
            .addFields("owner", "javax.swing.JComponent")
            .setTitle("Delete")
            .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
                  "	final String uuid = stgroupFile.getUuid();\n" +
                  "	stgroupFile.delete();\n" +
                  "	nextgen.events.STGroupFileDeleted.post(uuid);\n" +
                  "});");
      list.add(GenerateSTGroupFromFile);
      list.add(SetKVArgumentFromArgumentType);
      list.add(SetArgumentFromArgumentType);
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
      list.add(EditSTGroupTags);
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
      list.add(SetSTValueFromClipboard);
      list.add(SetSTValueFromInput);
      list.add(SetTemplateParameterTypes);
      list.add(STValueToClipboard);
      list.add(STModelToClipboard);
      list.add(UndoDBTransaction);
      list.add(WriteSTModelToFile);
      list.add(WriteAllSTModelsToFile);
      list.add(AddMultipleValuesToProject);
      list.add(AddFileSinkToGroup);
      list.add(DeleteSTGroupFile);
      return list;
   }
}