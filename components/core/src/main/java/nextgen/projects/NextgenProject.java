package nextgen.projects;

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
import nextgen.templates.nextgen.TransactionAction;
import nextgen.utils.StringUtil;
import nextgen.templates.javaneo4jembedded.*;

import java.io.File;

import static nextgen.st.STGenerator.writeJavaFile;
import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.JavaPatterns.*;
import static nextgen.templates.java.JavaST.newExpressionStmt;
import static nextgen.templates.java.JavaST.newMethodCallExpression;
import static nextgen.templates.nextgen.NextgenST.newTransactionAction;

public class NextgenProject {

   static nextgen.st.model.STModelDB db;

   static final File root = new File("/home/goe/projects/nextgen/components/core");
   static final File mainJava = new File(root, "src/main/java");

   static final String presentationModelName = "STAppPresentationModel";
   static final String appModelName = "AppModel";
   static final String workspace = "STWorkspace";
   static final String templateNavigator = "STTemplateNavigator";
   static final String modelNavigator = "STModelNavigator";

   static final PackageDeclaration corePackage = newPackageDeclaration("nextgen");
   static final PackageDeclaration stPackage = newPackageDeclaration(corePackage, "st");
   static final PackageDeclaration eventsPackage = newPackageDeclaration(corePackage, "events");
   static final PackageDeclaration canvasPackage = newPackageDeclaration(stPackage, "canvas");
   static final PackageDeclaration canvasLayoutPackage = newPackageDeclaration(canvasPackage, "layout");
   static final PackageDeclaration workflowPackage = newPackageDeclaration(corePackage, "workflow");
   static final PackageDeclaration swingPackage = newPackageDeclaration(corePackage, "swing");
   static final PackageDeclaration swingConfigPackage = newPackageDeclaration(swingPackage, "config");
   static final PackageDeclaration actionsPackage = newPackageDeclaration(corePackage, "actions");

   static final PackageDeclaration stModelPackage = newPackageDeclaration(stPackage, "model");
   static final ClassOrInterfaceType stArgumentType = newClassOrInterfaceType(stModelPackage, "STArgument");
   static final ClassOrInterfaceType stArgumentKVType = newClassOrInterfaceType(stModelPackage, "STArgumentKV");
   static final ClassOrInterfaceType stProjectType = newClassOrInterfaceType(stModelPackage, "STProject");
   static final ClassOrInterfaceType stModelType = newClassOrInterfaceType(stModelPackage, "STModel");
   static final ClassOrInterfaceType stValueType = newClassOrInterfaceType(stModelPackage, "STValue");
   static final ClassOrInterfaceType stFileType = newClassOrInterfaceType(stModelPackage, "STFile");

   static final PackageDeclaration stDomainPackage = newPackageDeclaration(stPackage, "domain");
   static final ClassOrInterfaceType stGroupModelType = newClassOrInterfaceType(stDomainPackage, "STGroupModel");
   static final ClassOrInterfaceType stTemplateType = newClassOrInterfaceType(stDomainPackage, "STTemplate");
   static final ClassOrInterfaceType stEnumType = newClassOrInterfaceType(stDomainPackage, "STEnum");
   static final ClassOrInterfaceType stInterfaceType = newClassOrInterfaceType(stDomainPackage, "STInterface");
   static final ClassOrInterfaceType stParameterType = newClassOrInterfaceType(stDomainPackage, "STParameter");
   static final ClassOrInterfaceType stParameterKeyType = newClassOrInterfaceType(stDomainPackage, "STParameterKey");

   static final ClassOrInterfaceType stringType = newClassOrInterfaceType().addNames("String");
   static final ClassOrInterfaceType integerType = newClassOrInterfaceType().addNames("Integer");
   static final ClassOrInterfaceType dimensionType = newClassOrInterfaceType("java.awt", "Dimension");
   static final ClassOrInterfaceType jFrameType = newClassOrInterfaceType("javax.swing", "JFrame");
   static final ClassOrInterfaceType ownerType = newClassOrInterfaceType("javax.swing", "JComponent");
   private static nextgen.st.model.STProject stProject;

   // events

   final nextgen.templates.greenrobot.Event NewSTArgument = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTArgument")
         .addFields("nextgen.st.model.STArgument", "argument")
         .addFields("nextgen.st.model.STModel", "model")
         .addFields("nextgen.st.domain.STParameter", "parameter")
         .addFields("nextgen.st.model.STValue", "value");
   final nextgen.templates.greenrobot.Event NewSTKVArgument = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTKVArgument")
         .addFields("nextgen.st.model.STModel", "model")
         .addFields("nextgen.st.domain.STParameter", "stParameter")
         .addFields("nextgen.st.model.STArgument", "argument")
         .addFields("java.util.Collection<nextgen.st.model.STArgumentKV>", "kvs");
   final nextgen.templates.greenrobot.Event NewKV = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewKV")
         .addFields("nextgen.st.model.STModel", "stModel")
         .addFields("nextgen.st.model.STArgument", "argument")
         .addFields("nextgen.st.model.STArgumentKV", "kv")
         .addFields("nextgen.st.domain.STParameterKey", "stParameterKey")
         .addFields("nextgen.st.model.STValue", "value");
   final nextgen.templates.greenrobot.Event NewSTModel = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTModel")
         .addFields("nextgen.st.model.STModel", "model")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STTemplate", "template");
   final nextgen.templates.greenrobot.Event STModelChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STModelChanged")
         .addFields("nextgen.st.model.STModel", "model");
   final nextgen.templates.greenrobot.Event NewSTProjectSTModel = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTProjectSTModel")
         .addFields("nextgen.st.model.STModel", "model")
         .addFields("nextgen.st.model.STProject", "project")
         .addFields("nextgen.st.domain.STTemplate", "template");
   final nextgen.templates.greenrobot.Event NewSTProjectSTValue = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTProjectSTValue")
         .addFields("nextgen.st.model.STValue", "value")
         .addFields("nextgen.st.model.STProject", "project");
   final nextgen.templates.greenrobot.Event NewFileSink = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewFileSink")
         .addFields("nextgen.st.model.STModel", "stModel")
         .addFields("nextgen.st.model.STFile", "stFile");
   final nextgen.templates.greenrobot.Event NewSTGroupTemplate = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTGroupTemplate")
         .addFields("nextgen.st.domain.STTemplate", "template")
         .addFields("nextgen.st.domain.STGroupModel", "parent");
   final nextgen.templates.greenrobot.Event NewSTTemplateChild = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTTemplateChild")
         .addFields("nextgen.st.domain.STTemplate", "template")
         .addFields("nextgen.st.domain.STTemplate", "parent");
   final nextgen.templates.greenrobot.Event NewSTEnum = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTEnum")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STEnum", "stEnum");
   final nextgen.templates.greenrobot.Event NewSTInterface = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTInterface")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STInterface", "stInterface");
   final nextgen.templates.greenrobot.Event NewSTProject = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTProject")
         .addFields("nextgen.st.model.STProject", "project");
   final nextgen.templates.greenrobot.Event NewSTGroup = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("NewSTGroup")
         .addFields("nextgen.st.domain.STGroupModel", "group");
   final nextgen.templates.greenrobot.Event STValueChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STValueChanged")
         .addFields("nextgen.st.model.STValue", "value");
   final nextgen.templates.greenrobot.Event STArgumentChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STArgumentChanged")
         .addFields("nextgen.st.model.STModel", "stModel")
         .addFields("nextgen.st.model.STArgument", "stArgument");
   final nextgen.templates.greenrobot.Event STEnumChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STEnumChanged")
         .addFields("nextgen.st.domain.STEnum", "stEnum");
   final nextgen.templates.greenrobot.Event STGroupTagsChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STGroupTagsChanged")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup");
   final nextgen.templates.greenrobot.Event STEnumNameChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STEnumNameChanged")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STEnum", "stEnum");
   final nextgen.templates.greenrobot.Event STGroupNameChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STGroupNameChanged")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup");
   final nextgen.templates.greenrobot.Event STInterfaceNameChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STInterfaceNameChanged")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STInterface", "stInterface");
   final nextgen.templates.greenrobot.Event STTemplateNameChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STTemplateNameChanged")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STTemplate", "stTemplate");
   final nextgen.templates.greenrobot.Event STTemplateParameterTypesChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STTemplateParameterTypesChanged")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STTemplate", "stTemplate");
   final nextgen.templates.greenrobot.Event STTemplateInterfacesChanged = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STTemplateInterfacesChanged")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STTemplate", "stTemplate");
   final nextgen.templates.greenrobot.Event STTemplateInterfaceRemoved = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STTemplateInterfaceRemoved")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STTemplate", "stTemplate")
         .addFields("String", "interfaceName");
   final nextgen.templates.greenrobot.Event STTemplateChildrenAdded = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STTemplateChildrenAdded")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STTemplate", "stTemplate")
         .addFields("java.util.Set<nextgen.st.domain.STTemplate>", "children");
   final nextgen.templates.greenrobot.Event STValueDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STValueDeleted")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event STModelDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STModelDeleted")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event STArgumentDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STArgumentDeleted")
         .addFields("nextgen.st.model.STModel", "stModel")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event STFileDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STFileDeleted")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event KVDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("KVDeleted")
         .addFields("nextgen.st.model.STModel", "stModel")
         .addFields("nextgen.st.model.STArgument", "stArgument")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event STInterfaceDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STInterfaceDeleted")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event STEnumDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STEnumDeleted")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event STGroupDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STGroupDeleted")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event STTemplateDeleted = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("STTemplateDeleted")
         .addFields("String", "uuid");
   final nextgen.templates.greenrobot.Event OpenSTModel = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("OpenSTModel")
         .addFields("nextgen.st.model.STModel", "model");
   final nextgen.templates.greenrobot.Event OpenSTTemplate = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("OpenSTTemplate")
         .addFields("nextgen.st.domain.STTemplate", "template");
   final nextgen.templates.greenrobot.Event TemplateNavigatorSTParameterTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("TemplateNavigatorSTParameterTreeNodeClicked")
         .addFields("nextgen.st.domain.STParameter", "parameter")
         .addFields("nextgen.st.model.STModel", "model");
   final nextgen.templates.greenrobot.Event TemplateNavigatorSTGroupTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("TemplateNavigatorSTGroupTreeNodeClicked")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup");
   final nextgen.templates.greenrobot.Event TemplateNavigatorSTTemplateTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("TemplateNavigatorSTTemplateTreeNodeClicked")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STTemplate", "parentTemplate")
         .addFields("nextgen.st.domain.STTemplate", "stTemplate");
   final nextgen.templates.greenrobot.Event TemplateNavigatorSTEnumTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("TemplateNavigatorSTEnumTreeNodeClicked")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STEnum", "stEnum");
   final nextgen.templates.greenrobot.Event TemplateNavigatorSTInterfaceTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("TemplateNavigatorSTInterfaceTreeNodeClicked")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup")
         .addFields("nextgen.st.domain.STInterface", "stInterface");
   final nextgen.templates.greenrobot.Event ModelNavigatorSTProjectTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("ModelNavigatorSTProjectTreeNodeClicked")
         .addFields("nextgen.st.model.STProject", "stProject");
   final nextgen.templates.greenrobot.Event ModelNavigatorModelsTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("ModelNavigatorModelsTreeNodeClicked");
   final nextgen.templates.greenrobot.Event ModelNavigatorSTGroupTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("ModelNavigatorSTGroupTreeNodeClicked")
         .addFields("nextgen.st.domain.STGroupModel", "stGroup");
   final nextgen.templates.greenrobot.Event ModelNavigatorSTTemplateTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("ModelNavigatorSTTemplateTreeNodeClicked")
         .addFields("nextgen.st.domain.STTemplate", "stTemplate");
   final nextgen.templates.greenrobot.Event ModelNavigatorSTParameterTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("ModelNavigatorSTParameterTreeNodeClicked")
         .addFields("nextgen.st.domain.STParameter", "stParmeter");
   final nextgen.templates.greenrobot.Event ModelNavigatorSTModelTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("ModelNavigatorSTModelTreeNodeClicked")
         .addFields("nextgen.st.domain.STTemplate", "stTemplate")
         .addFields("nextgen.st.model.STModel", "stModel");
   final nextgen.templates.greenrobot.Event ModelNavigatorSTKVArgumentTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("ModelNavigatorSTKVArgumentTreeNodeClicked")
         .addFields("nextgen.st.model.STArgumentKV", "kv");
   final nextgen.templates.greenrobot.Event ModelNavigatorSTValueTreeNodeClicked = nextgen.templates.greenrobot.GreenRobotST.newEvent()
         .setPackageName("nextgen.events")
         .setName("ModelNavigatorSTValueTreeNodeClicked")
         .addFields("nextgen.st.model.STValue", "stValue");

   // actions
   final TransactionAction addArgumentFromArgumentType = write(newTransactionAction()
         .setName("AddArgumentFromArgumentType")
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

   final TransactionAction addArgumentFromClipboard = write(newTransactionAction()
         .setName("AddArgumentFromClipboard")
         .setTitle("Add from Clipboard")
         .addFields(stModelType, "stModel")
         .addFields(stParameterType, "stParameter")
         .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
               "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
               "stModel.addArguments(stArgument);\n" +
               "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

   final TransactionAction addArgumentFromInput = write(newTransactionAction()
         .setName("AddArgumentFromInput")
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

   final TransactionAction addArgumentFromSTModel = write(newTransactionAction()
         .setName("AddArgumentFromSTModel")
         .addFields(stModelType, "stModel")
         .addFields(stParameterType, "stParameter")
         .addFields(stModelType, "value")
         .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
               "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
               "stModel.addArguments(stArgument);\n" +
               "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

   final TransactionAction addArgumentFromSTModelUuid = write(newTransactionAction()
         .setName("AddArgumentFromSTModelUuid")
         .addFields(stModelType, "stModel")
         .addFields(stParameterType, "stParameter")
         .addFields("String", "uuid")
         .addStatements("final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(uuid));\n" +
               "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
               "stModel.addArguments(stArgument);\n" +
               "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

   final TransactionAction addArgumentFromSTTemplate = write(newTransactionAction()
         .setName("AddArgumentFromSTTemplate")
         .addFields(stModelType, "stModel")
         .addFields(stParameterType, "stParameter")
         .addFields(stTemplateType, "stTemplate")
         .addStatements("final nextgen.st.model.STModel value = appModel().newSTModel(stTemplate);\n" +
               "\n" +
               "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
               "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
               "stModel.addArguments(stArgument);\n" +
               "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n"));

   final TransactionAction addArgumentFromSTValue = write(newTransactionAction()
         .setName("AddArgumentFromSTValue")
         .addFields(stModelType, "stModel")
         .addFields(stParameterType, "stParameter")
         .addFields(stValueType, "stValue")
         .addStatements("final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
               "stModel.addArguments(stArgument);\n" +
               "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

   final TransactionAction addChildrenToTemplate = write(newTransactionAction()
         .setName("AddChildrenToTemplate")
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

   final TransactionAction addFileSink = write(newTransactionAction()
         .setName("AddFileSink")
         .setTitle("Add File Sink")
         .addStaticFields("java.util.concurrent.atomic.AtomicInteger", "fileTypeIndex", "new java.util.concurrent.atomic.AtomicInteger(0)")
         .addStaticFields("java.util.concurrent.atomic.AtomicInteger", "pathIndex", "new java.util.concurrent.atomic.AtomicInteger(0)")
         .addFields(stModelType, "stModel")
         .addFields(ownerType, "owner")
         .addStatements("final String[] fileTypes = new String[]{\"html\", \"java\", \"js\", \"xml\"};\n" +
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
               "});"));

   final TransactionAction addFileSinkToSTModels = write(newTransactionAction()
         .setName("AddFileSinkToSTModels")
         .setTitle("Add File Sink")
         .addFields(stTemplateType, "stTemplate")
         .addFields("java.util.List<nextgen.st.model.STModel>", "stModels")
         .addFields(ownerType, "owner")
         .addStaticFields("java.util.concurrent.atomic.AtomicInteger", "fileTypeIndex", "new java.util.concurrent.atomic.AtomicInteger(0)")
         .addStaticFields("java.util.concurrent.atomic.AtomicInteger", "pathIndex", "new java.util.concurrent.atomic.AtomicInteger(0)")
         .addStatements("final String[] fileTypes = new String[]{\"html\", \"java\", \"js\", \"xml\"};\n" +
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
               "});"));

   final TransactionAction addInterface = write(newTransactionAction()
         .setName("AddInterface")
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
               "   for (nextgen.st.domain.STTemplate child : children) {\n" +
               "      final java.util.Optional<String> optional = child.getImplements().filter(s -> s.toLowerCase().equals(interfaceName.toLowerCase())).findAny();\n" +
               "      if(optional.isPresent()) continue;\n" +
               "      child.addImplements(interfaceName);\n" +
               "   }\n" +
               "   close(jDialog);   \n" +
               "});"));

   final TransactionAction addKVArgument = write(newTransactionAction()
         .setName("AddKVArgument")
         .setTitle("Add")
         .addFields(stModelType, "stModel")
         .addFields(stParameterType, "stParameter")
         .addFields(ownerType, "owner")
         .addStatements("final String[] selectedValues = appModel().getSelectedValues();\n" +
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
               "});"));

   final TransactionAction addModelToProject = write(newTransactionAction()
         .setName("AddModelToProject")
         .setTitle("Add to Project")
         .addFields(stProjectType, "project")
         .addFields(stModelType, "stModel")
         .addStatements("project.addModels(stModel);\n" +
               "nextgen.events.NewSTProjectSTModel.post(stModel, project, appModel().getSTTemplate(stModel));"));

   final TransactionAction addValueToProject = write(newTransactionAction()
         .setName("AddValueToProject")
         .setTitle("Add to Project")
         .addFields(stProjectType, "project")
         .addFields(stValueType, "stValue")
         .addStatements("project.addValues(stValue);\n" +
               "nextgen.events.NewSTProjectSTValue.post(stValue, project);"));

   final TransactionAction addValueToProjectFromInput = write(newTransactionAction()
         .setName("AddValueToProjectFromInput")
         .setTitle("Add New Value to Project")
         .addFields(stProjectType, "project")
         .addFields(ownerType, "owner")
         .addStatements("input(owner, \"New Value\", value -> {\n" +
               "   final nextgen.st.model.STValue stValue = appModel().newSTValue(value);\n" +
               "   project.addValues(stValue);\n" +
               "   nextgen.events.NewSTProjectSTValue.post(stValue, project);\n" +
               "});"));

   final TransactionAction addMultipleArgumentsFromArgumentType = write(newTransactionAction()
         .setName("AddMultipleArgumentsFromArgumentType")
         .addFields(stModelType, "stModel")
         .addFields(stParameterType, "stParameter")
         .addFields(ownerType, "owner")
         .addStatements(""));

   final TransactionAction addTemplateModelToProject = write(newTransactionAction()
         .setName("AddTemplateModelToProject")
         .addFields(stTemplateType, "stTemplate")
         .addFields(stProjectType, "project")
         .addStatements("final nextgen.st.model.STModel stModel = appModel().newSTModel(stTemplate);\n" +
               "project.addModels(stModel);\n" +
               "nextgen.events.NewSTProjectSTModel.post(stModel, project, stTemplate);"));

   final TransactionAction copyModel = write(newTransactionAction()
         .setName("CopyModel")
         .setTitle("Copy Model")
         .addFields(stModelType, "stModel")
         .addStatements("toClipboard(\"stmodel-\" + stModel.getUuid());"));

   final TransactionAction deleteEnum = write(newTransactionAction()
         .setName("DeleteEnum")
         .setTitle("Delete")
         .addFields(stEnumType, "stEnum")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
               "   stGroup.removeEnums(stEnum);\n" +
               "   nextgen.events.STEnumDeleted.post(stEnum.getUuid());\n" +
               "});"));

   final TransactionAction deleteKV = write(newTransactionAction()
         .setName("DeleteKV")
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

   final TransactionAction deleteSTArgument = write(newTransactionAction()
         .setName("DeleteSTArgument")
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

   final TransactionAction deleteSTGroup = write(newTransactionAction()
         .setName("DeleteSTGroup")
         .setTitle("Delete")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
               "   appModel().delete(stGroup);\n" +
               "   nextgen.events.STGroupDeleted.post(stGroup.getUuid());\n" +
               "});"));

   final TransactionAction deleteSTFile = write(newTransactionAction()
         .setName("DeleteSTFile")
         .setTitle("Delete")
         .addFields(stFileType, "stFile")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
               "   final String uuid = stFile.getUuid();\n" +
               "   final nextgen.st.model.STFile found = appModel().db.findSTFileByUuid(uuid);\n" +
               "   if (found != null) appModel().db.delete(found.getNode());\n" +
               "   nextgen.events.STFileDeleted.post(uuid);\n" +
               "});"));

   final TransactionAction deleteSTFileFromSTModels = write(newTransactionAction()
         .setName("DeleteSTFileFromSTModels")
         .setTitle("Delete Filesinks")
         .addFields("java.util.List<nextgen.st.model.STModel>", "stModels")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
               "   for (nextgen.st.model.STModel stModel : stModels) {\n" +
               "      stModel.getFiles().forEach(stFile -> {\n" +
               "         final String uuid = stFile.getUuid();\n" +
               "         final nextgen.st.model.STFile found = appModel().db.findSTFileByUuid(uuid);\n" +
               "         if (found != null) appModel().db.delete(found.getNode());\n" +
               "         nextgen.events.STFileDeleted.post(uuid);      \n" +
               "      });\n" +
               "   }\n" +
               "});"));

   final TransactionAction deleteSTInterface = write(newTransactionAction()
         .setName("DeleteSTInterface")
         .setTitle("Delete")
         .addFields(stInterfaceType, "stInterface")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
               "   stGroup.removeInterfaces(stInterface);\n" +
               "   nextgen.events.STInterfaceDeleted.post(stInterface.getUuid());   \n" +
               "});"));

   final TransactionAction removeInterfaceFromSTTemplate = write(newTransactionAction()
         .setName("RemoveInterfaceFromSTTemplate")
         .addFields(stGroupModelType, "stGroup")
         .addFields(stTemplateType, "stTemplate")
         .addFields("String", "interfaceName")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Remove\", unused -> {\n" +
               "   stTemplate.removeImplements(interfaceName);\n" +
               "   nextgen.events.STTemplateInterfaceRemoved.post(stGroup, stTemplate, interfaceName);\n" +
               "});"));

   final TransactionAction deleteSTModel = write(newTransactionAction()
         .setName("DeleteSTModel")
         .setTitle("Delete")
         .addFields(stModelType, "stModel")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
               "   final String uuid = stModel.getUuid();\n" +
               "   final nextgen.st.model.STModel found = appModel().db.findSTModelByUuid(uuid);\n" +
               "   if (found != null) appModel().db.delete(found.getNode());\n" +
               "   nextgen.events.STModelDeleted.post(uuid);\n" +
               "});"));

   final TransactionAction deleteSTTemplate = write(newTransactionAction()
         .setName("DeleteSTTemplate")
         .setTitle("Delete")
         .addFields(stTemplateType, "stTemplate")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
               "   stGroup.removeTemplates(stTemplate);\n" +
               "   nextgen.events.STTemplateDeleted.post(stTemplate.getUuid());\n" +
               "});"));

   final TransactionAction deleteSTValue = write(newTransactionAction()
         .setName("DeleteSTValue")
         .setTitle("Delete")
         .addFields(stValueType, "stValue")
         .addFields(ownerType, "owner")
         .addStatements("confirm(owner, \"Delete\", unused -> {\n" +
               "   final String uuid = stValue.getUuid();\n" +
               "   final nextgen.st.model.STValue found = appModel().db.findSTValueByUuid(uuid);\n" +
               "   if (found != null) appModel().db.delete(found.getNode());\n" +
               "   nextgen.events.STValueDeleted.post(uuid);\n" +
               "});"));

   final TransactionAction editEnum = write(newTransactionAction()
         .setName("EditEnum")
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

   final TransactionAction editModels = write(newTransactionAction()
         .setName("EditModels")
         .setTitle("Edit")
         .addFields(stTemplateType, "stTemplate")
         .addStatements("appModel().doLaterInTransaction(transaction1 -> {\n" +
               "   final nextgen.st.STModelGrid stModelGrid = appModel().getWorkspace().getModelGrid(stTemplate);\n" +
               "   appModel().getWorkspace().setSelectedComponent(stModelGrid);\n" +
               "   stModelGrid.requestFocusInWindow();   \n" +
               "});"));

   final TransactionAction editSTGroupTags = write(newTransactionAction()
         .setName("EditSTGroupTags")
         .setTitle("Edit tags")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("input(owner, \"Tags\", stGroup.getTags(\"\"), tags -> {\n" +
               "   stGroup.setTags(tags);\n" +
               "   nextgen.events.STGroupTagsChanged.post(stGroup);\n" +
               "});"));

   final TransactionAction editSTModel = write(newTransactionAction()
         .setName("EditSTModel")
         .setTitle("Edit")
         .addFields(stModelType, "stModel")
         .addStatements("appModel().doLaterInTransaction(transaction1 -> appModel().getWorkspace().setSelectedComponent(appModel().getModelEditor(stModel)));"));

   final TransactionAction generateAllProjectModels = write(newTransactionAction()
         .setName("GenerateAllProjectModels")
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

   final TransactionAction generateAllSTGroups = write(newTransactionAction()
         .setName("GenerateAllSTGroups")
         .setTitle("Generate all")
         .addStatements("appModel().getSTGroups().forEach(stGroupModel -> appModel().generateSTGroup(stGroupModel, false));"));

   final TransactionAction generateSource = write(newTransactionAction()
         .setName("GenerateSource")
         .setTitle("As builder code")
         .addFields(stModelType, "stModel")
         .addStatements("final java.util.Set<String> imports = new java.util.LinkedHashSet<>();\n" +
               "\n" +
               "final String packageName = appModel().getSourceOutputPackage();\n" +
               "final String templateName = appModel().getSTTemplate(stModel).getName();\n" +
               "final String className = appModel().getSTModelName(stModel, templateName);\n" +
               "final String variableName = nextgen.utils.StringUtil.lowFirst(templateName);\n" +
               "\n" +
               "final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.JavaPatterns.newBlockStmt();\n" +
               "final nextgen.templates.java.VariableDeclarationExpression variableDeclarationExpression = nextgen.templates.JavaPatterns\n" +
               "      .newFinalVariableDeclarationExpression(templateName, variableName, appModel().stRenderer.renderGeneratorCode(stModel, imports));\n" +
               "blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt().setExpression(variableDeclarationExpression));\n" +
               "\n" +
               "final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()\n" +
               "      .setName(className)\n" +
               "      .addMembers(nextgen.templates.JavaPatterns.newMainMethod().setBlockStmt(blockStmt));\n" +
               "\n" +
               "final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.JavaPatterns.newCompilationUnit(packageName, classOrInterfaceDeclaration)\n" +
               "      .setImportDeclaration(imports.stream().map(s -> nextgen.templates.JavaPatterns.newImportDeclaration().setName(s).setIsAsterisk(true)).collect(java.util.stream.Collectors.toList()));\n" +
               "\n" +
               "nextgen.utils.SwingUtil.toClipboard(blockStmt.toString());\n" +
               "\n" +
               "nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(appModel().getOutputPath()));"));

   final TransactionAction generateAllSources = write(newTransactionAction()
         .setName("GenerateSources")
         .setTitle("As builder code")
         .addFields(stTemplateType, "stTemplate")
         .addFields("java.util.List<nextgen.st.model.STModel>", "stModels")
         .addStatements("final java.util.Set<String> imports = new java.util.LinkedHashSet<>();\n" +
               "\n" +
               "final String packageName = appModel().getSourceOutputPackage();\n" +
               "final String className = \"GenerateAll_\" + stTemplate.getName();\n" +
               "\n" +
               "final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.JavaPatterns.newBlockStmt();\n" +
               "final java.util.concurrent.atomic.AtomicInteger variableCount = new java.util.concurrent.atomic.AtomicInteger();\n" +
               "for (nextgen.st.model.STModel stModel : stModels) {\n" +
               "\n" +
               "   final String stModelName = appModel().getSTModelName(stModel, \"var_\" + variableCount.incrementAndGet());\n" +
               "   final String type = nextgen.utils.StringUtil.capitalize(stTemplate.getName());\n" +
               "\n" +
               "   final nextgen.templates.java.VariableDeclarationExpression variableDeclarationExpression = nextgen.templates.JavaPatterns\n" +
               "         .newFinalVariableDeclarationExpression(type, stModelName, appModel().stRenderer.renderGeneratorCode(stModel, imports));\n" +
               "\n" +
               "   blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt().setExpression(variableDeclarationExpression));\n" +
               "}\n" +
               "\n" +
               "final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()\n" +
               "      .setName(className)\n" +
               "      .addMembers(nextgen.templates.JavaPatterns.newMainMethod().setBlockStmt(blockStmt));\n" +
               "\n" +
               "final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.JavaPatterns.newCompilationUnit(packageName, classOrInterfaceDeclaration)\n" +
               "      .setImportDeclaration(imports.stream().map(s -> nextgen.templates.JavaPatterns.newImportDeclaration().setName(s).setIsAsterisk(true)).collect(java.util.stream.Collectors.toList()));\n" +
               "\n" +
               "nextgen.utils.SwingUtil.toClipboard(blockStmt.toString());\n" +
               "\n" +
               "nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(appModel().getOutputPath()));"));

   final TransactionAction generateSTGroup = write(newTransactionAction()
         .setName("GenerateSTGroup")
         .setTitle("Generate STGroup")
         .addFields(stGroupModelType, "stGroup")
         .addStatements("appModel().generateSTGroup(stGroup, false);"));

   final TransactionAction generateSTGroupAndNeo = write(newTransactionAction()
         .setName("GenerateSTGroupAndNeo")
         .setTitle("Generate STGroup and Neo")
         .addFields(stGroupModelType, "stGroup")
         .addStatements("appModel().generateSTGroup(stGroup, true);"));

   final TransactionAction importSTTemplate = write(newTransactionAction()
         .setName("ImportSTTemplate")
         .setTitle("Import from stg-file")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("openFile(owner, file -> {\n" +
               "\tappModel().setLastDir(file.getParentFile());\n" +
               "\tappModel().doLaterInTransaction(t -> {\n" +
               "\t\tfinal String fileName = file.getName();\n" +
               "\t\tfinal String name = fileName.substring(0, fileName.indexOf(\".\"));\n" +
               "\t\tfinal nextgen.st.domain.STTemplate stTemplate = appModel().newSTTemplate(name, nextgen.utils.FileUtil.readIntact(file), stGroup);\n" +
               "\t\tnextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);\n" +
               "\t});\n" +
               "});"));

   final TransactionAction newEnum = write(newTransactionAction()
         .setName("NewEnum")
         .setTitle("New Enum")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("input(owner, \"New Enum\", s ->\n" +
               "      nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
               "         final nextgen.st.domain.STEnum stEnum = appModel().newSTEnum(name);\n" +
               "         stGroup.addEnums(stEnum);\n" +
               "         nextgen.events.NewSTEnum.post(stGroup, stEnum);\n" +
               "      }));"));


   final TransactionAction newInterface = write(newTransactionAction()
         .setName("NewInterface")
         .setTitle("New Interface")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("input(owner, \"New Interface\", s ->\n" +
               "      nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
               "         final nextgen.st.domain.STInterface stInterface = appModel().newSTInterface(name);\n" +
               "         stGroup.addInterfaces(stInterface);\n" +
               "         nextgen.events.NewSTInterface.post(stGroup, stInterface);\n" +
               "      }));"));

   final TransactionAction newProject = write(newTransactionAction()
         .setName("NewProject")
         .setTitle("New Project")
         .addFields(ownerType, "owner")
         .addStatements("input(owner, \"Name\", s -> {\n" +
               "   final nextgen.st.model.STProject stProject = appModel().db.newSTProject(s);\n" +
               "   nextgen.events.NewSTProject.post(stProject);\n" +
               "});"));

   final TransactionAction newSTGroupAction = write(newTransactionAction()
         .setName("NewSTGroup")
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

   final TransactionAction newSTModelAction = write(newTransactionAction()
         .setName("NewSTModel")
         .setTitle("New instance")
         .addFields(stTemplateType, "stTemplate")
         .addStatements("final nextgen.st.model.STModel stModel = appModel().newSTModel(stTemplate);\n" +
               "nextgen.events.NewSTModel.post(stModel, appModel().findSTGroup(stTemplate), stTemplate);"));

   final TransactionAction newSTTemplate = write(newTransactionAction()
         .setName("NewSTTemplate")
         .setTitle("New Template")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("input(owner, \"Name\", s -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
               "\tfinal nextgen.st.domain.STTemplate stTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText(\"\");\n" +
               "\tstGroup.addTemplates(stTemplate);\n" +
               "\tnextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);\n" +
               "}));"));

   final TransactionAction addChildToTemplate = write(newTransactionAction()
         .setName("AddChildToTemplate")
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

   final TransactionAction openSTModelAction = write(newTransactionAction()
         .setName("OpenSTModel")
         .setTitle("Open")
         .addFields(stModelType, "stModel")
         .addStatements("nextgen.events.OpenSTModel.post(stModel);"));

   final TransactionAction openTemplateAction = write(newTransactionAction()
         .setName("OpenTemplate")
         .setTitle("Open")
         .addFields(stTemplateType, "stTemplate")
         .addStatements("nextgen.events.OpenSTTemplate.post(stTemplate);"));

   final TransactionAction renameEnum = write(newTransactionAction()
         .setName("RenameEnum")
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

   final TransactionAction renameSTGroup = write(newTransactionAction()
         .setName("RenameSTGroup")
         .setTitle("Rename")
         .addFields(stGroupModelType, "stGroup")
         .addFields(ownerType, "owner")
         .addStatements("input(owner, \"Name\", stGroup.getName(), s -> {\n" +
               "\tnextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {\n" +
               "\t\tstGroup.setName(name);\n" +
               "\t\tnextgen.events.STGroupNameChanged.post(stGroup);\n" +
               "\t});\n" +
               "});"));

   final TransactionAction renameSTInterface = write(newTransactionAction()
         .setName("RenameSTInterface")
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

   final TransactionAction renameSTTemplate = write(newTransactionAction()
         .setName("RenameSTTemplate")
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

   final TransactionAction setArgumentFromClipboard = write(newTransactionAction()
         .setName("SetArgumentFromClipboard")
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

   final TransactionAction setArgumentFromInput = write(newTransactionAction()
         .setName("SetArgumentFromInput")
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

   final TransactionAction setArgumentFromSTModel = write(newTransactionAction()
         .setName("SetArgumentFromSTModel")
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

   final TransactionAction setArgumentFromSTModelUuid = write(newTransactionAction()
         .setName("SetArgumentFromSTModelUuid")
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

   final TransactionAction setArgumentFromSTTemplate = write(newTransactionAction()
         .setName("SetArgumentFromSTTemplate")
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
               "\n" +
               "final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);\n" +
               "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
               "stModel.addArguments(stArgument);\n" +
               "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

   final TransactionAction setArgumentFromSTValue = write(newTransactionAction()
         .setName("SetArgumentFromSTValue")
         .addFields(stModelType, "stModel")
         .addFields(stParameterType, "stParameter")
         .addFields(stValueType, "stValue")
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
               "final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);\n" +
               "stModel.addArguments(stArgument);\n" +
               "nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);"));

   final TransactionAction setArgumentToTrue = write(newTransactionAction()
         .setName("SetArgumentToTrue")
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

   final TransactionAction setInterfaces = write(newTransactionAction()
         .setName("SetInterfaces")
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

   final TransactionAction setKVArgumentFromClipboard = write(newTransactionAction()
         .setName("SetKVArgumentFromClipboard")
         .setTitleExpression("\"Set \" + stParameterKey.getName() + \" from Clipboard\"")
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
               "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);"));

   final TransactionAction setKVArgumentFromInput = write(newTransactionAction()
         .setName("SetKVArgumentFromInput")
         .setTitleExpression("\"Set \" + stParameterKey.getName() + \" from Input\"")
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
               "   nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);" +
               "});"));

   final TransactionAction setKVArgumentFromSTModel = write(newTransactionAction()
         .setName("SetKVArgumentFromSTModel")
         .setTitleExpression("\"Set \" + stParameterKey.getName() + \" from STModel\"")
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
               "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);"));

   final TransactionAction setKVArgumentFromSTValue = write(newTransactionAction()
         .setName("SetKVArgumentFromSTValue")
         .setTitleExpression("\"Set \" + stParameterKey.getName() + \" from STValue\"")
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
               "nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);"));

   final TransactionAction setMultipleFields = write(newTransactionAction()
         .setName("SetMultipleFields")
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
               "         nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);\n" +
               "      }\n" +
               "   }\n" +
               "});"));

   final TransactionAction setSTValueFromClipboard = write(newTransactionAction()
         .setName("SetSTValueFromClipboard")
         .setTitle("Set from Clipboard")
         .addFields(stValueType, "stValue")
         .addStatements("stValue.removeStModel();\n" +
               "stValue.setValue(nextgen.utils.SwingUtil.fromClipboard());\n" +
               "stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);\n" +
               "nextgen.events.STValueChanged.post(stValue);"));

   final TransactionAction setSTValueFromInput = write(newTransactionAction()
         .setName("SetSTValueFromInput")
         .setTitle("Set from Input")
         .addFields(stValueType, "stValue")
         .addFields(ownerType, "owner")
         .addStatements("input(owner, \"Set Value\", value -> {\n" +
               "   stValue.removeStModel();\n" +
               "   stValue.setValue(value);\n" +
               "   stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);\n" +
               "   nextgen.events.STValueChanged.post(stValue);\n" +
               "});"));

   final TransactionAction setTemplateParameterTypes = write(newTransactionAction()
         .setName("SetTemplateParameterTypes")
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
               "\tappModel().save(stGroup);\n" +
               "\tnextgen.events.STTemplateParameterTypesChanged.post(stGroup, stTemplate);\n" +
               "\tjavax.swing.SwingUtilities.invokeLater(jDialog::dispose);\n" +
               "});"));

   final TransactionAction stValueToClipboard = write(newTransactionAction()
         .setName("STValueToClipboard")
         .setTitle("To Clipboard")
         .addFields(stValueType, "stValue")
         .addStatements("nextgen.utils.SwingUtil.toClipboard(appModel().render(stValue));"));

   final TransactionAction stModelToClipboard = write(newTransactionAction()
         .setName("STModelToClipboard")
         .setTitle("To Clipboard")
         .addFields(stModelType, "stModel")
         .addStatements("nextgen.utils.SwingUtil.toClipboard(appModel().render(stModel));"));

   final TransactionAction undoDBTransaction = write(newTransactionAction()
         .setName("UndoDBTransaction")
         .setTitle("Undo")
         .addStatements("appModel().undoLast();"));

   final TransactionAction visitSTModel = write(newTransactionAction()
         .setName("VisitSTModel")
         .setTitle("VisitSTModel")
         .addFields(stModelType, "stModel")
         .addStatements("new nextgen.st.STVisitorTest(appModel()).visit(stModel);"));

   final TransactionAction writeSTModelToFile = write(newTransactionAction()
         .setName("WriteSTModelToFile")
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

   final TransactionAction writeAllSTModelsToFile = write(newTransactionAction()
         .setName("WriteAllSTModelsToFile")
         .setTitle("Generate All")
         .addFields("java.util.List<nextgen.st.model.STModel>", "stModels")
         .addStatements("for (nextgen.st.model.STModel stModel : stModels) {\n" +
               "   stModel.getFiles().forEach(stFile -> {\n" +
               "      final String content = appModel().render(stModel);\n" +
               "      final String packageDeclaration = stFile.getPackageName().getValue();\n" +
               "      final String name = stFile.getName().getValue();\n" +
               "      final String filetype = stFile.getType().getValue();\n" +
               "      final java.io.File root = new java.io.File(stFile.getPath().getValue());\n" +
               "      nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);\n" +
               "   });\n" +
               "}"));

   @org.junit.BeforeClass
   public static void init() {
      db = new nextgen.st.model.STModelDB("/home/goe/projects/nextgen/db", "src/main/resources/templates");
      db.doInTransaction(transaction -> {
         db.getDatabaseService().getAllRelationships().forEach(org.neo4j.graphdb.Relationship::delete);
         db.getDatabaseService().getAllNodes().forEach(org.neo4j.graphdb.Node::delete);

         stProject = db.newSTProject("Nextgen");
      });
   }

   @org.junit.Test
   public void test() {

      db.doInTransaction(transaction -> {
         db.findAllSTProject().forEach(stProject1 -> {
            System.out.println(stProject1.getName());

            stProject1.getModels().forEach(stModel -> {
               System.out.println(stModel.getUuid());
            });
         });
      });

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
            .addMethods(newSubscribe(ModelNavigatorSTModelTreeNodeClicked).addStatements("getModelEditor(event.stTemplate, event.stModel);"))
            .addMethods(newSubscribe(TemplateNavigatorSTGroupTreeNodeClicked).addStatements("getSTEditor(event.stGroup);"))
            .addMethods(newSubscribe(TemplateNavigatorSTTemplateTreeNodeClicked).addStatements("getSTEditor(event.stGroup).setSTTemplate(event.stTemplate);"))
            .addMethods(newSubscribe(TemplateNavigatorSTEnumTreeNodeClicked).addStatements("getSTEditor(event.stGroup).setSTEnum(event.stEnum);"))
            .addMethods(newSubscribe(TemplateNavigatorSTInterfaceTreeNodeClicked).addStatements("getSTEditor(event.stGroup).setSTInterface(event.stInterface);"))
            .addMethods(newSubscribe(STModelDeleted).addStatements("SwingUtilities.invokeLater(() -> removeModelEditor(event.uuid));"))
            .addMethods(newSubscribe(STGroupDeleted).addStatements(""))
            .addMethods(newSubscribe(STEnumDeleted).addStatements(""))
            .addMethods(newSubscribe(STTemplateDeleted).addStatements(""))
            .addMethods(newSubscribe(STInterfaceDeleted).addStatements(""));

      writeJavaFile(stWorkspace, stPackage, stWorkspace.getName(), mainJava);
   }

   @org.junit.Test
   public void generateSTTemplateNavigator() {

      final nextgen.templates.nextgen.TreeNode rootNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("RootNode")
            .setModelType(stringType)
            .setLabelExpression("getModel()")
            .addConstructorStatements("appModel().stGroups.forEach(stGroup -> add(new STGroupTreeNode(stGroup)));")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(newSTGroupAction, "tree")),
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
                  addToActionsStatement(newAction(generateSTGroupAndNeo, "getModel()")),
                  addToActionsStatement(newAction(newSTTemplate, "getModel()", "tree")),
                  addToActionsStatement(newAction(newEnum, "getModel()", "tree")),
                  addToActionsStatement(newAction(newInterface, "getModel()", "tree")),
                  addToActionsStatement(newAction(renameSTGroup, "getModel()", "tree")),
                  addToActionsStatement(newAction(deleteSTGroup, "getModel()", "tree"))
            })
            .addSelectionStatements(postEventStatement(TemplateNavigatorSTGroupTreeNodeClicked, "selectedNode.getModel()"));

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
            .addSelectionStatements("selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> { " + postEventStatement(TemplateNavigatorSTEnumTreeNodeClicked, "stGroupTreeNode.getModel()", "selectedNode.getModel()") + " });");

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
                  addToActionsStatement(newAction(newSTModelAction, "getModel()")),
                  getParent(stGroupTreeNode, newBlockStmt(new Object[]{
                        addToActionsStatement(newAction(addChildToTemplate, "getModel()", "parent.getModel()", "tree")),
                        addToActionsStatement(newAction(setTemplateParameterTypes, "parent.getModel()", "getModel()", "tree")),
                        "if (!candidateChildren.isEmpty()) " + addToActionsStatement(newAction(addChildrenToTemplate, "\"Add \" + candidateChildren.size() + \" templates as children\"", "parent.getModel()", "getModel()", "candidateChildren", "tree")),
                        "appModel().getProjects().forEach(stProject -> " + addToActions(newAction(addTemplateModelToProject, "\"Add to \" + stProject.getName()", "getModel()", "stProject")) + ");",
                        "if (!childTemplates.isEmpty()) " + addToActionsStatement(newAction(addInterface, "\"Add interfaces to children\"", "childTemplates", "tree")),
                        addToActionsStatement(newAction(setInterfaces, "parent.getModel()", "getModel()", "tree")),
                        "getModel().getImplements().forEach(implement -> " + addToActions(newAction(removeInterfaceFromSTTemplate, "\"Remove \" + implement", "parent.getModel()", "getModel()", "implement", "tree")) + ");",
                        addToActionsStatement(newAction(deleteSTTemplate, "getModel()", "parent.getModel()", "tree")),
                  })),
            })
            .addSelectionStatements(getParent("selectedNode", stGroupTreeNode, newBlockStmt(new Object[]{
                  "final nextgen.st.STTemplateNavigator.STTemplateTreeNode stTemplateTreeNode = selectedNode.getParentNode(nextgen.st.STTemplateNavigator.STTemplateTreeNode.class).orElse(null);",
                  "nextgen.events.TemplateNavigatorSTTemplateTreeNodeClicked.post(parent.getModel(), stTemplateTreeNode == null ? null : stTemplateTreeNode.getModel(), selectedNode.getModel());"
            })));

      final nextgen.templates.nextgen.TreeNode stInterfaceTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName("STInterfaceTreeNode")
            .setModelType(stInterfaceType)
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(\"sq-red\")")
            .setLabelExpression("getModel().getName()")
            .setGetActionsStatements(new Object[]{
                  getParent(stGroupTreeNode, addToActions(newAction(renameSTInterface, "getModel()", "parent.getModel()", "tree"))),
                  getParent(stGroupTreeNode, addToActions(newAction(deleteSTInterface, "getModel()", "parent.getModel()", "tree")))
            })
            .addSelectionStatements(getParent("selectedNode", stGroupTreeNode, postEventExpression(TemplateNavigatorSTInterfaceTreeNodeClicked, "parent.getModel()", "selectedNode.getModel()")));

      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
            .setPackageName(stPackage.getName())
            .addImports(newImportDeclaration(swingPackage, appModelName))
            .addImports(newImportDeclaration(stDomainPackage))
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
            .addEvents(newSubscribe(ModelNavigatorSTModelTreeNodeClicked)
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate)).ifPresent(treeModel::select);"))
            .addEvents(newSubscribe(STGroupDeleted)
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(STEnumDeleted)
                  .addStatements("findSTEnumTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(STTemplateDeleted)
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(STInterfaceDeleted)
                  .addStatements("findSTInterfaceTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(NewSTGroup)
                  .addStatements("treeModel.addNodeInSortedOrderAndSelect((RootNode) treeModel.getRoot(), new nextgen.st.STTemplateNavigator.STGroupTreeNode(event.group));"))
            .addEvents(newSubscribe(NewSTEnum)
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "\t\t\t.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STEnumTreeNode(event.stEnum)));"))
            .addEvents(newSubscribe(NewSTInterface)
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "\t\t\t.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STInterfaceTreeNode(event.stInterface)));"))
            .addEvents(newSubscribe(NewSTGroupTemplate)
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.parent))\n" +
                        "\t\t\t.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));"))
            .addEvents(newSubscribe(NewSTTemplateChild)
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.parent))\n" +
                        "\t\t\t.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));"))
            .addEvents(newSubscribe(STGroupNameChanged)
                  .addStatements("findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "\t\t\t.ifPresent(nextgen.st.STTemplateNavigator.STGroupTreeNode::nodeChanged);"))
            .addEvents(newSubscribe(STTemplateNameChanged)
                  .addStatements("findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate))\n" +
                        "\t\t\t.ifPresent(nextgen.st.STTemplateNavigator.STTemplateTreeNode::nodeChanged);"))
            .addEvents(newSubscribe(STInterfaceNameChanged)
                  .addStatements("findSTInterfaceTreeNode(treeNode -> treeNode.getModel().equals(event.stInterface))\n" +
                        "\t\t\t.ifPresent(STTemplateNavigator.STInterfaceTreeNode::nodeChanged);"))
            .addEvents(newSubscribe(STEnumNameChanged)
                  .addStatements("findSTEnumTreeNode(treeNode -> treeNode.getModel().equals(event.stEnum))\n" +
                        "\t\t\t.ifPresent(STTemplateNavigator.STEnumTreeNode::nodeChanged);"));

      writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
   }

   @org.junit.Test
   public void generateSTModelNavigator() {

      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
            .setPackageName(stPackage.getName())
            .setName(modelNavigator)
            .addFields(workspace, "workspace")
            .setRootNodeExpression("new RootNode(\"Projects\")")
            .setPreferredWidth("600")
            .setPreferredHeight("1200")
            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode());

      newTreeNode(treeNavigator, "RootNode", stringType)
            .setLabelExpression("getModel()")
            .addConstructorStatements("appModel().doInTransaction(transaction -> {\n" +
                  "	appModel().getProjects().forEach(stProject -> add(new STProjectTreeNode(stProject)));\n" +
                  "	add(new ModelsTreeNode(\"Models\"));\n" +
                  "});")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(newProject, "tree")),
                  addToActionsStatement(newAction(undoDBTransaction))
            });

      final nextgen.templates.nextgen.TreeNode stProjectTreeNode = newTreeNode(treeNavigator, "STProjectTreeNode", stProjectType)
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
                  "	stTemplateTreeNodeMap.get(stTemplate).add(new nextgen.st.STModelNavigator.STModelTreeNode(stModel, stTemplate));\n" +
                  "});")
            .addSelectionStatements(postEventStatement(ModelNavigatorSTProjectTreeNodeClicked, "selectedNode.getModel()"))
            .addGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(addValueToProjectFromInput, "getModel()", "tree")),
//                  addToActionsStatement(newAction(addModelToProject, "getModel()")),
//                  addToActionsStatement(newAction(addValueToProject, "getModel()")),
                  addToActionsStatement(newAction(generateAllProjectModels, "getModel()")),
            });

      final nextgen.templates.nextgen.TreeNode modelsTreeNode = newTreeNode(treeNavigator, "ModelsTreeNode", stringType)
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
                  "	appModel().db.findAllSTModelByStTemplate(stTemplate.getUuid()).forEach(stModel -> stTemplateTreeNode.add(new STModelTreeNode(stModel, stTemplate)));\n" +
                  "	stTemplate.getChildren().forEach(stTemplateChild -> addSTTemplateChild(stTemplateChild, stTemplateTreeNode));\n" +
                  "}");

      newTreeNode(treeNavigator, "STGroupModelTreeNode", stGroupModelType)
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
            .addSelectionStatements(postEventStatement(ModelNavigatorSTGroupTreeNodeClicked, "selectedNode.getModel()"));

      newTreeNode(treeNavigator, "STTemplateTreeNode", stTemplateType)
            .setHasUuid(true)
            .setLabelExpression("getModel().getName()")
            .setGetActionsStatements(new Object[]{
                  getParent(stProjectTreeNode, addToActions(newAction(addTemplateModelToProject, "\"New instance\"", "getModel()", "parent.getModel()"))),
                  getParent(modelsTreeNode, addToActions(newAction(newSTModelAction, "getModel()"))),
                  addToActionsStatement(newAction(editModels, "getModel()")),
                  "final java.util.List<nextgen.st.model.STModel> stModels = getChildren(nextgen.st.STModelNavigator.STModelTreeNode.class)\n" +
                        "\t\t\t\t\t\t.map(nextgen.st.STModelNavigator.BaseTreeNode::getModel)\n" +
                        "\t\t\t\t\t\t.collect(java.util.stream.Collectors.toList());",
                  addToActionsStatement(newAction(writeAllSTModelsToFile, "stModels")),
                  addToActionsStatement(newAction(generateAllSources, "getModel()", "stModels")),
                  addToActionsStatement(newAction(addFileSinkToSTModels, "getModel()", "stModels", "tree")),
                  addToActionsStatement(newAction(deleteSTFileFromSTModels, "stModels", "tree")),
            })
            .addSelectionStatements(postEventStatement(ModelNavigatorSTTemplateTreeNodeClicked, "selectedNode.getModel()"));

      final nextgen.templates.nextgen.TreeNode stModelTreeNode = newTreeNode(treeNavigator, "STModelTreeNode", stModelType)
            .setHasUuid(true)
            .addFields(stTemplateType, "stTemplate")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
            .addConstructorStatements("getModel().getFiles()\n" +
                  "\t\t.forEach(stFile -> add(new STFileSinkTreeNode(stFile)));")
            .addConstructorStatements("stTemplate.getParameters()\n" +
                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
            .addSelectionStatements(postEventStatement(ModelNavigatorSTModelTreeNodeClicked, "selectedNode.stTemplate", "selectedNode.getModel()"))
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(addFileSink, "getModel()", "tree")),
                  addToActionsStatement(newAction(generateSource, "getModel()")),
                  addToActionsStatement(newAction(copyModel, "getModel()")),
                  addToActionsStatement(newAction(openSTModelAction, "getModel()")),
                  addToActionsStatement(newAction(visitSTModel, "getModel()")),
                  addToActionsStatement(newAction(writeSTModelToFile, "getModel()")),
                  addToActionsStatement(newAction(editSTModel, "getModel()")),
                  addToActionsStatement(newAction(deleteSTModel, "getModel()", "tree"))
            });

      newTreeNode(treeNavigator, "STFileSinkTreeNode", stFileType)
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(\"sq-white\")")
            .setLabelExpression("appModel().render(getModel().getPath())")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(deleteSTFile, "getModel()", "tree")),
            });

      newTreeNode(treeNavigator, "STParameterTreeNode", stParameterType)
            .setHasUuid(true)
            .addFields(stModelType, "stModel")
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
            .addSelectionStatements(postEventStatement(ModelNavigatorSTParameterTreeNodeClicked, "selectedNode.getModel()"));

      newTreeNode(treeNavigator, "STModelArgumentTreeNode", stModelType)
            .setHasUuid(true)
            .addFields(stArgumentType, "stArgument")
            .addPrivateFields(stringType, "stArgumentUuid", "stArgument.getUuid()")
            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
            .addConstructorStatements("stTemplate.getParameters()\n" +
                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
            .addSelectionStatements(postEventStatement(ModelNavigatorSTModelTreeNodeClicked, "selectedNode.stTemplate", "selectedNode.getModel()"))
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(generateSource, "getModel()")),
                  addToActionsStatement(newAction(copyModel, "getModel()")),
                  addToActionsStatement(newAction(deleteSTArgument, "stArgument", "tree"))
            });

      newTreeNode(treeNavigator, "STValueTreeNode", stValueType)
            .setHasUuid(true)
            .setIcon("appModel().loadIcon(\"sq-orange\")")
            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(stValueToClipboard, "getModel()")),
            })
            .addSelectionStatements(postEventStatement(ModelNavigatorSTValueTreeNodeClicked, "selectedNode.getModel()"));

      newTreeNode(treeNavigator, "STValueArgumentTreeNode", stValueType)
            .setHasUuid(true)
            .addFields(stArgumentType, "stArgument")
            .addPrivateFields(stringType, "stArgumentUuid", "stArgument.getUuid()")
            .setIcon("appModel().loadIcon(\"sq-orange\")")
            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(stValueToClipboard, "getModel()")),
                  addToActionsStatement(newAction(deleteSTArgument, "stArgument", "tree")),
            })
            .addSelectionStatements(postEventStatement(ModelNavigatorSTValueTreeNodeClicked, "selectedNode.getModel()"));

      newTreeNode(treeNavigator, "STKVArgumentTreeNode", stArgumentType)
            .setHasUuid(true)
            .addFields(stParameterType, "stParameter")
            .setLabelExpression("appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, \"name\", stParameter::getName)")
            .addConstructorStatements("stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()\n" +
                  "		.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
                  "		.findFirst()\n" +
                  "		.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));")
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(deleteSTArgument, "getModel()", "tree")),
                  getParent(stModelTreeNode, newBlockStmt()
                        .addStatements("stParameter.getKeys().forEach(stParameterKey -> {\n" +
                              addToActionsStatement(newAction(setKVArgumentFromInput, "parent.getModel()", "getModel()", "stParameterKey", "tree")) + "\n" +
                              addToActionsStatement(newAction(setKVArgumentFromClipboard, "parent.getModel()", "getModel()", "stParameterKey")) + "\n" +
                              "});"))
            });

      final nextgen.templates.nextgen.TreeNode stKVTreeNode = newTreeNode(treeNavigator, "STKVTreeNode", stArgumentKVType)
            .setHasUuid(true)
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .setLabelExpression("stParameterKey.getName()")
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
            .setGetActionsStatements(new Object[]{
                  addToActionsStatement(newAction(deleteKV, "getModel()", "tree")),
                  getParent(stModelTreeNode, newBlockStmt()
                        .addStatements(addToActionsStatement(newAction(setKVArgumentFromInput, "parent.getModel()", "stArgument", "stParameterKey", "tree")))
                        .addStatements(addToActionsStatement(newAction(setKVArgumentFromClipboard, "parent.getModel()", "stArgument", "stParameterKey"))))
            });

      newTreeNode(treeNavigator, "STModelKVArgumentTreeNode", stModelType)
            .setHasUuid(true)
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .addPrivateFields(stringType, "stArgumentUuid", "stArgument.getUuid()")
            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())")
            .setIcon("appModel().loadIcon(\"sq-teal\")")
            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stParameterKey.getName() + \"]\")")
            .addSelectionStatements(postEventStatement(ModelNavigatorSTModelTreeNodeClicked, "selectedNode.stTemplate", "selectedNode.getModel()"))
            .setGetActionsStatements(new Object[]{
                  getParent(stKVTreeNode, addToActions(newAction(deleteKV, "parent.getModel()", "tree")))
            });

      newTreeNode(treeNavigator, "STValueKVArgumentTreeNode", stValueType)
            .setHasUuid(true)
            .addFields(stArgumentType, "stArgument")
            .addFields(stParameterKeyType, "stParameterKey")
            .setIcon("appModel().loadIcon(\"sq-orange\")")
            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
            .addSelectionStatements(postEventStatement(ModelNavigatorSTValueTreeNodeClicked, "selectedNode.getModel()"))
            .setGetActionsStatements(new Object[]{
                  getParent(stKVTreeNode, addToActions(newAction(deleteKV, "parent.getModel()", "tree")))
            });

      treeNavigator
            .addMethods("public java.util.stream.Stream<nextgen.st.model.STModel> getSelectedSTModels() {\n" +
                  "\treturn getSelectedNodes()\n" +
                  "\t\t\t.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STModel)\n" +
                  "\t\t\t.map(baseTreeNode -> (nextgen.st.model.STModel) baseTreeNode.getModel());\n" +
                  "}")
            .addMethods("public java.util.stream.Stream<nextgen.st.model.STValue> getSelectedSTValues() {\n" +
                  "\treturn getSelectedNodes()\n" +
                  "\t\t\t.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STValue)\n" +
                  "\t\t\t.map(baseTreeNode -> (nextgen.st.model.STValue) baseTreeNode.getModel());\n" +
                  "}")
            .addEvents(newSubscribe(NewSTProject)
                  .addStatements("findRootNode().ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STProjectTreeNode(event.project)));"))
            .addEvents(newSubscribe(NewFileSink)
                  .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel)).ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STFileSinkTreeNode(event.stFile)));"))
            .addEvents(newSubscribe(NewSTArgument)
                  .addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model))\n" +
                        "      .flatMap(treeNode -> findSTParameterTreeNode(treeNode, stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.parameter)))\n" +
                        "      .ifPresent(stParameterTreeNode -> appModel().stArgumentConsumer(event.parameter)\n" +
                        "            .onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STValueArgumentTreeNode(stValue, stArgument)))\n" +
                        "            .onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" +
                        "            .onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STValueArgumentTreeNode(stValue, stArgument)))\n" +
                        "            .onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" +
                        "            .onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelNavigator.STKVArgumentTreeNode(stArgument, event.parameter)))\n" +
                        "            .accept(event.argument));"))
            .addEvents(newSubscribe(NewSTKVArgument)
                  .addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model))\n" +
                        "\t\t.flatMap(treeNode -> findSTParameterTreeNode(treeNode, stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.stParameter)))\n" +
                        "\t\t.ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new nextgen.st.STModelNavigator.STKVArgumentTreeNode(event.argument, event.stParameter)));"))
            .addEvents(newSubscribe(NewKV)
                  .addStatements("findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.argument.getUuid()))\n" +
                        "      .ifPresent(treeNode -> {\n" +
                        "         treeModel.addNodeInSortedOrderAndSelect(treeNode, new nextgen.st.STModelNavigator.STKVTreeNode(event.kv, treeNode.getModel(), event.stParameterKey));\n" +
                        "      });"))
            .addEvents(newSubscribe(NewSTModel)
                  .addStatements("findModelsTreeNode()\n" +
                        "      .flatMap(modelsTreeNode -> findSTGroupModelTreeNode(modelsTreeNode, treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
                        "            .flatMap(treeNode -> findSTTemplateTreeNode(treeNode, stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(event.template))))\n" +
                        "      .ifPresent(stTemplateTreeNode -> treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template)));"))
            .addEvents(newSubscribe(NewSTProjectSTModel)
                  .addStatements("findSTProjectTreeNode(stProjectTreeNode -> stProjectTreeNode.getModel().equals(event.project))\n" +
                        "      .ifPresent(stProjectTreeNode -> {\n" +
                        "         final nextgen.st.domain.STGroupModel stGroup = appModel().findSTGroup(event.template);\n" +
                        "         final java.util.Optional<nextgen.st.STModelNavigator.STGroupModelTreeNode> groupModelTreeNode = findSTGroupModelTreeNode(stProjectTreeNode, stGroupModelTreeNode -> stGroupModelTreeNode.getModel().equals(stGroup));\n" +
                        "         if (groupModelTreeNode.isPresent()) {\n" +
                        "            final java.util.Optional<nextgen.st.STModelNavigator.STTemplateTreeNode> stTemplateTreeNode = findSTTemplateTreeNode(groupModelTreeNode.get(), stTemplateTreeNode1 -> stTemplateTreeNode1.getModel().equals(event.template));\n" +
                        "            if (stTemplateTreeNode.isPresent()) {\n" +
                        "               treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode.get(), new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template));\n" +
                        "            } else {\n" +
                        "               final nextgen.st.STModelNavigator.STTemplateTreeNode newSTTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(event.template);\n" +
                        "               treeModel.addNodeInSortedOrder(groupModelTreeNode.get(), newSTTemplateTreeNode);\n" +
                        "               treeModel.addNodeInSortedOrderAndSelect(newSTTemplateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template));\n" +
                        "            }\n" +
                        "\n" +
                        "         } else {\n" +
                        "            final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroup);\n" +
                        "            treeModel.addNodeInSortedOrder(stProjectTreeNode, stGroupModelTreeNode);\n" +
                        "            final nextgen.st.STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(event.template);\n" +
                        "            treeModel.addNodeInSortedOrder(stGroupModelTreeNode, stTemplateTreeNode);\n" +
                        "            treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template));\n" +
                        "         }\n" +
                        "      });"))
            .addEvents(newSubscribe(NewSTProjectSTValue)
                  .addStatements("findSTProjectTreeNode(treeNode -> treeNode.getModel().equals(event.project))\n" +
                        "\t\t.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new nextgen.st.STModelNavigator.STValueTreeNode(event.value)));"))
            .addEvents(newSubscribe(STValueChanged)
                  .addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.value)).ifPresent(nextgen.st.STModelNavigator.BaseTreeNode::nodeChanged);"))
            .addEvents(newSubscribe(STArgumentChanged)
                  .addStatements("findSTModelArgumentTreeNode(stModelArgumentTreeNode -> stModelArgumentTreeNode.stArgument.equals(event.stArgument)).ifPresent(treeModel::nodeChanged);\n" +
                        "findSTValueArgumentTreeNode(stModelArgumentTreeNode -> stModelArgumentTreeNode.stArgument.equals(event.stArgument)).ifPresent(treeModel::nodeChanged);"))
            .addEvents(newSubscribe(STModelChanged)
                  .addStatements("treeModel.find(treeNode -> treeNode.getModel().equals(event.model)).ifPresent(nextgen.st.STModelNavigator.BaseTreeNode::nodeChanged);"))
            .addEvents(newSubscribe(STModelDeleted)
                  .addStatements("SwingUtilities.invokeLater(() -> findSTModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));"))
            .addEvents(newSubscribe(STValueDeleted)
                  .addStatements("SwingUtilities.invokeLater(() -> {\n" +
                        "\tfindSTValueArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "\tfindSTValueKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                        "});"))
            .addEvents(newSubscribe(STGroupDeleted)
                  .addStatements("SwingUtilities.invokeLater(() -> findSTGroupModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));"))
            .addEvents(newSubscribe(STFileDeleted)
                  .addStatements("findSTFileSinkTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(KVDeleted)
                  .addStatements("findSTKVTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
            .addEvents(newSubscribe(STArgumentDeleted)
                  .addStatements(
                        "findSTValueArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                              "findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                              "findSTModelArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
                              "findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"));

      writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
   }

//   @org.junit.Test
//   public void generateSTModelNavigator() {
//
//      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
//            .setPackageName(stPackage.getName())
//            .setName(modelNavigator)
//            .addFields(workspace, "workspace")
//            .setRootNodeExpression("new RootNode(\"Projects\")")
//            .setPreferredWidth("600")
//            .setPreferredHeight("1200")
//            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
//            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode());
//
//      final nextgen.templates.nextgen.TreeNode rootNode = newTreeNode(treeNavigator, "RootNode", stringType)
//            .setLabelExpression("getModel()")
//            .addConstructorStatements("appModel().doInTransaction(transaction -> {\n" +
//                  "	appModel().getProjects().forEach(stProject -> add(new STProjectTreeNode(stProject)));\n" +
//                  "	add(new ModelsTreeNode(\"Models\"));\n" +
//                  "});")
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(newProject, "tree")),
//                  addToActionsStatement(newAction(undoDBTransaction))
//            });
//
//
//      final nextgen.templates.nextgen.TreeNode stProjectTreeNode = newTreeNode(treeNavigator, "STProjectTreeNode", stProjectType)
//            .setIcon("appModel().loadIcon(\"sq-white\")")
//            .setLabelExpression("getModel().getName()")
//            .setTooltipExpression("getModel().getName();")
//            .addConstructorStatements("final Map<nextgen.st.domain.STGroupModel, STModelNavigator.STGroupModelTreeNode> stGroupTreeNodeMap = new java.util.LinkedHashMap<>();\n" +
//                  "final Map<nextgen.st.domain.STTemplate, STModelNavigator.STTemplateTreeNode> stTemplateTreeNodeMap = new java.util.LinkedHashMap<>();\n" +
//                  "model.getModelsSorted().forEach(stModel -> {\n" +
//                  "\n" +
//                  "	final nextgen.st.domain.STTemplate stTemplate = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
//                  "	final nextgen.st.domain.STGroupModel stGroup = appModel().findSTGroup(stTemplate);\n" +
//                  "\n" +
//                  "	if (!stGroupTreeNodeMap.containsKey(stGroup)) {\n" +
//                  "		final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroup);\n" +
//                  "		add(stGroupModelTreeNode);\n" +
//                  "		stGroupTreeNodeMap.put(stGroup, stGroupModelTreeNode);\n" +
//                  "	}\n" +
//                  "\n" +
//                  "	if (!stTemplateTreeNodeMap.containsKey(stTemplate)) {\n" +
//                  "		final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);\n" +
//                  "		stGroupTreeNodeMap.get(stGroup).add(stTemplateTreeNode);\n" +
//                  "		stTemplateTreeNodeMap.put(stTemplate, stTemplateTreeNode);\n" +
//                  "	}\n" +
//                  "\n" +
//                  "	stTemplateTreeNodeMap.get(stTemplate).add(new nextgen.st.STModelNavigator.STModelTreeNode(stModel, stTemplate));\n" +
//                  "});")
//            .addSelectionStatements(postEventStatement(modelNavigatorSTProjectTreeNodeClicked, "selectedNode.getModel()"));
////            .setGetActionsStatements(new Object[]{
////                  "getSelectedSTModelTreeNodes().forEach(stModelTreeNode -> actions.add(new nextgen.actions.AddModelToProject(\"Add \" + stModelTreeNode.getLabel(), getModel(), stModelTreeNode.getModel())));",
////                  "actions.add(new nextgen.actions.GenerateAllProjectModels(getModel()));"
////            });
//
//      final nextgen.templates.nextgen.TreeNode modelsTreeNode = newTreeNode(treeNavigator, "ModelsTreeNode", stringType)
//            .setIcon("appModel().loadIcon(\"sq-teal\")")
//            .addConstructorStatements("appModel().doInTransaction(transaction -> {\n" +
//                  "	appModel().getGroupModels().forEach(stGroupModel -> {\n" +
//                  "		final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroupModel);\n" +
//                  "		add(stGroupModelTreeNode);\n" +
//                  "		stGroupModel.getTemplates().forEach(stTemplate -> addSTTemplateChild(stTemplate, stGroupModelTreeNode));\n" +
//                  "	});\n" +
//                  "});")
//            .addMethods("private void addSTTemplateChild(nextgen.st.domain.STTemplate stTemplate, BaseTreeNode<?> parent) {\n" +
//                  "	final nextgen.st.STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);\n" +
//                  "	parent.add(stTemplateTreeNode);\n" +
//                  "\n" +
//                  "	appModel().db.findAllSTModelByStTemplate(stTemplate.getUuid()).forEach(stModel -> stTemplateTreeNode.add(new STModelTreeNode(stModel, stTemplate)));\n" +
//                  "	stTemplate.getChildren().forEach(stTemplateChild -> addSTTemplateChild(stTemplateChild, stTemplateTreeNode));\n" +
//                  "}");
//
//      final nextgen.templates.nextgen.TreeNode stValueTreeNode = newTreeNode(treeNavigator, "STValueTreeNode", stValueType)
//            .setHasUuid(true)
//            .setIcon("appModel().loadIcon(\"sq-orange\")")
//            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
//            .setTooltipExpression("appModel().tooltip(getModel());")
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(stValueToClipboard, "getModel()")),
//                  addToActionsStatement(newAction(setSTValueFromClipboard, "getModel()")),
//                  addToActionsStatement(newAction(deleteSTValue, "getModel()", "tree"))
//            });
//
//      final nextgen.templates.nextgen.TreeNode stFileSinkTreeNode = newTreeNode(treeNavigator, "STFileSinkTreeNode", stFileType)
//            .setHasUuid(true)
//            .setIcon("appModel().loadIcon(\"sq-white\")")
//            .setLabelExpression("appModel().render(getModel().getPath())")
//            .addSelectionStatements(postEventStatement(modelEditorSTFileTreeNodeClicked, "selectedNode.getModel()"))
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(deleteSTFile, "getModel()", "tree")),
//            });
//
//      final nextgen.templates.nextgen.TreeNode stGroupTreeNode = newTreeNode(treeNavigator, "STGroupModelTreeNode", stGroupModelType)
//            .setHasUuid(true)
//            .setIcon("appModel().loadIcon(model.getIcon())")
//            .setLabelExpression("getModel().getName()")
//            .addMethods("private boolean countChildren(nextgen.st.domain.STTemplate stTemplate) {\n" +
//                  "	long count = appModel().findAllSTModelByStTemplate(stTemplate.getUuid()).count();\n" +
//                  "	if (count != 0L) return true;\n" +
//                  "	Iterator<nextgen.st.domain.STTemplate> iterator = stTemplate.getChildren().iterator();\n" +
//                  "	while (iterator.hasNext())\n" +
//                  "		if (countChildren(iterator.next())) return true;\n" +
//                  "	return false;\n" +
//                  "}");
//
//      final nextgen.templates.nextgen.TreeNode stTemplateTreeNode = newTreeNode(treeNavigator, "STTemplateTreeNode", stTemplateType)
//            .setHasUuid(true)
//            .setLabelExpression("getModel().getName()")
//            .setGetActionsStatements(new Object[]{
//                  getParent(stProjectTreeNode, addToActions(newAction(addTemplateModelToProject, "\"New instance\"", "getModel()", "parent.getModel()"))),
//                  getParent(modelsTreeNode, addToActions(newAction(newSTModelAction, "getModel()"))),
//                  addToActionsStatement(newAction(editModels, "getModel()"))
//            });
//
//      final nextgen.templates.nextgen.TreeNode stModelTreeNode = newTreeNode(treeNavigator, "STModelTreeNode", stModelType)
//            .setHasUuid(true)
//            .addFields(stTemplateType, "stTemplate")
//            .setIcon("appModel().loadIcon(\"sq-teal\")")
//            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
//            .addSelectionStatements("nextgen.events.ModelEditorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());")
//            .addConstructorStatements("getModel().getFiles()\n" +
//                  "\t\t.forEach(stFile -> add(new STFileSinkTreeNode(stFile)));")
//            .addConstructorStatements("stTemplate.getParameters()\n" +
//                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
//                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(addFileSink, "getModel()", "tree")),
//                  addToActionsStatement(newAction(generateSource, "getModel()")),
//                  addToActionsStatement(newAction(copyModel, "getModel()")),
//                  addToActionsStatement(newAction(openSTModelAction, "getModel()")),
//                  addToActionsStatement(newAction(visitSTModel, "getModel()")),
//                  addToActionsStatement(newAction(writeSTModelToFile, "getModel()")),
//                  addToActionsStatement(newAction(editSTModel, "getModel()")),
//                  addToActionsStatement(newAction(deleteSTModel, "getModel()", "tree"))
//            });
//
//
//      final nextgen.templates.nextgen.TreeNode stParameterTreeNode = newTreeNode(treeNavigator, "STParameterTreeNode", stParameterType)
//            .setHasUuid(true)
//            .addFields(stModelType, "stModel")
//            .setLabelExpression("getModel().getName()")
//            .addConstructorStatements("stModel.getArgumentsSorted()\n" +
//                  "	.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))\n" +
//                  "	.forEach(appModel().stArgumentConsumer(model)\n" +
//                  "			.onSingleSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue)))\n" +
//                  "			.onSingleSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()))))\n" +
//                  "			.onListSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue)))\n" +
//                  "			.onListSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()))))\n" +
//                  "			.onKVListConsumer((stArgument, stKVValues) -> add(new STKVArgumentTreeNode(stArgument, model))));");
//
//      final nextgen.templates.nextgen.TreeNode stKVArgumentTreeNode = newTreeNode(treeNavigator, "STKVArgumentTreeNode", stArgumentType)
//            .setHasUuid(true)
//            .addFields(stParameterType, "stParameter")
//            .addConstructorStatements("stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()\n" +
//                  "		.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
//                  "		.findFirst()\n" +
//                  "		.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));");
//
//      final nextgen.templates.nextgen.TreeNode stKVTreeNode = newTreeNode(treeNavigator, "STKVTreeNode", stArgumentKVType)
//            .setHasUuid(true)
//            .addFields(stArgumentType, "stArgument")
//            .addFields(stParameterKeyType, "stParameterKey")
//            .setLabelExpression("stParameterKey.getName()")
//            .addConstructorStatements("final nextgen.st.model.STValue stValue = model.getValue();\n" +
//                  "if (stValue != null)\n" +
//                  "	switch (stValue.getType()) {\n" +
//                  "		case STMODEL:\n" +
//                  "			add(new STModelKVArgumentTreeNode(stValue.getStModel(), stArgument, stParameterKey));\n" +
//                  "			break;\n" +
//                  "		case PRIMITIVE:\n" +
//                  "			add(new STValueKVArgumentTreeNode(stValue, stArgument, stParameterKey));\n" +
//                  "			break;\n" +
//                  "		case ENUM:\n" +
//                  "			break;\n" +
//                  "	}")
//            .setGetActionsStatements(new Object[]{
//                  getParent("STModelTreeNode", newBlockStmt()
//                        .addStatements(addToActionsStatement(newAction(setKVArgumentFromInput, "parent.getModel()", "stArgument", "stParameterKey", "tree"))))
//            });
//
//      final nextgen.templates.nextgen.TreeNode stModelKVArgumentTreeNode = newTreeNode(treeNavigator, "STModelKVArgumentTreeNode", stModelType)
//            .addFields(stArgumentType, "stArgument")
//            .addPrivateFields(stringType, "stArgumentUuid", "stArgument.getUuid()")
//            .addFields(stParameterKeyType, "stParameterKey")
//            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())")
//            .setIcon("appModel().loadIcon(\"sq-teal\")")
//            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stParameterKey.getName() + \"]\")")
//            .addSelectionStatements("nextgen.events.ModelEditorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());")
//            .setHasUuid(true);
//
//      final nextgen.templates.nextgen.TreeNode stValueKVArgumentTreeNode = newTreeNode(treeNavigator, "STValueKVArgumentTreeNode", stValueType)
//            .setHasUuid(true)
//            .addFields(stArgumentType, "stArgument")
//            .addFields(stParameterKeyType, "stParameterKey")
//            .setIcon("appModel().loadIcon(\"sq-orange\")")
//            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(deleteSTArgument, "stArgument", "tree"))
//            });
//
//      treeNavigator
//            .addEvents(newSubscribe(newSTModel)
//                  .addStatements("findSTGroupModelTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))\n" +
//                        "      .flatMap(treeNode -> findSTTemplateTreeNode(treeNode, stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(event.template)))\n" +
//                        "      .ifPresent(stTemplateTreeNode -> treeModel.addNodeInSortedOrder(stTemplateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template)));"))
//            .addEvents(newSubscribe(newSTProjectSTModel)
//                  .addStatements("findSTProjectTreeNode(treeNode -> treeNode.getModel().equals(event.project))\n" +
//                        "      .flatMap(treeNode -> findSTTemplateTreeNode(treeNode, stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(event.template)))\n" +
//                        "      .ifPresent(stTemplateTreeNode -> treeModel.addNodeInSortedOrder(stTemplateTreeNode, new nextgen.st.STModelNavigator.STModelTreeNode(event.model, event.template)));"))
//            .addEvents(newSubscribe(stModelChanged)
//                  .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.model))\n" +
//                        "\t\t.ifPresent(treeNode -> {\n" +
//                        "\t\t\ttreeNode.removeAllChildren();\n" +
//                        "\t\t\ttreeNode.stTemplate.getParameters()\n" +
//                        "\t\t\t\t\t.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
//                        "\t\t\t\t\t.forEach(stParameter -> treeNode.add(new STParameterTreeNode(stParameter, event.model)));\n" +
//                        "\t\t\ttreeModel.nodeStructureChanged(treeNode);\n" +
//                        "\t\t});"))
//            .addEvents(newSubscribe(stModelDeleted)
//                  .addStatements("SwingUtilities.invokeLater(() -> findSTModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));"))
//            .addEvents(newSubscribe(stValueDeleted)
//                  .addStatements("SwingUtilities.invokeLater(() -> findSTValueTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));"))
//            .addEvents(newSubscribe(stGroupDeleted)
//                  .addStatements("SwingUtilities.invokeLater(() -> findSTGroupModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));"));
//
//      writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
//   }

//   @org.junit.Test
//   public void generateSTModelEditorNavigator() {
//
//      final nextgen.templates.nextgen.TreeNode stModelTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STModelTreeNode")
//            .setModelType(stModelType)
//            .setHasUuid(true)
//            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate());")
//            .setIcon("appModel().loadIcon(\"sq-teal\")")
//            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
//            .addSelectionStatements("nextgen.events.ModelEditorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());")
//            .addConstructorStatements("getModel().getFiles()\n" +
//                  "\t\t.forEach(stFile -> add(new STFileSinkTreeNode(stFile)));")
//            .addConstructorStatements("stTemplate.getParameters()\n" +
//                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
//                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(addFileSink, "getModel()", "tree")),
//                  addToActionsStatement(newAction(copyModel, "getModel()")),
//                  addToActionsStatement(newAction(openSTModelAction, "getModel()")),
//                  addToActionsStatement(newAction(visitSTModel, "getModel()")),
//                  addToActionsStatement(newAction(writeSTModelToFile, "getModel()")),
//                  addToActionsStatement(newAction(editSTModel, "getModel()")),
//            });
//
//      final nextgen.templates.nextgen.TreeNode stFileSinkTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STFileSinkTreeNode")
//            .setModelType(stFileType)
//            .setHasUuid(true)
//            .setIcon("appModel().loadIcon(\"sq-white\")")
//            .setLabelExpression("appModel().render(getModel().getPath())")
//            .addSelectionStatements(postEventStatement(modelEditorSTFileTreeNodeClicked, "selectedNode.getModel()"))
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(deleteSTFile, "getModel()", "tree")),
//            });
//
//      final nextgen.templates.nextgen.TreeNode stKVArgumentTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STKVArgumentTreeNode")
//            .setModelType(stArgumentType)
//            .addFields(stParameterType, "stParameter")
//            .setLabelExpression("appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, \"name\", stParameter::getName)")
//            .addConstructorStatements("stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()\n" +
//                  "		.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
//                  "		.findFirst()\n" +
//                  "		.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));");
//
//      //            .setGetActionsStatements(new Object[]{
////                  "appModel().doInTransaction(transaction -> stParameter.getKeys().forEach(stParameterKey -> {",
////                  "	actions.add(new nextgen.actions.SetKVArgumentFromInput(\"Set \" + stParameterKey.getName() + \" from input\", getModel(), stParameterKey, tree));",
////                  "	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(\"Set \" + stParameterKey.getName() + \" from Clipboard\", getModel(), stParameterKey));",
////                  "}));",
////                  "actions.add(new nextgen.actions.DeleteSTArgument(getModel(), tree));"
////            });
//
//      final nextgen.templates.nextgen.TreeNode stKVTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STKVTreeNode")
//            .setModelType(stArgumentKVType)
//            .setHasUuid(true)
//            .addFields(stArgumentType, "stArgument")
//            .addFields(stParameterKeyType, "stParameterKey")
//            .setLabelExpression("stParameterKey.getName()")
//            .addConstructorStatements("final STValue stValue = model.getValue();\n" +
//                  "if (stValue != null)\n" +
//                  "	switch (stValue.getType()) {\n" +
//                  "		case STMODEL:\n" +
//                  "			add(new STModelKVArgumentTreeNode(stValue.getStModel(), stArgument, stParameterKey));\n" +
//                  "			break;\n" +
//                  "		case PRIMITIVE:\n" +
//                  "			add(new STValueKVArgumentTreeNode(stValue, stArgument, stParameterKey));\n" +
//                  "			break;\n" +
//                  "		case ENUM:\n" +
//                  "			break;\n" +
//                  "	}")
//            .setGetActionsStatements(new Object[]{
//                  getParent("STModelTreeNode", newBlockStmt()
//                        .addStatements(addToActionsStatement(newAction(setKVArgumentFromInput, "parent.getModel()", "stArgument", "stParameterKey", "tree"))))
//            });
//
//      //            .setGetActionsStatements(new Object[]{
////                  "appModel().doInTransaction(transaction -> {",
////                  "	getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.SetKVArgumentFromSTValue(\"Set \" + appModel().render(stValueTreeNode.getModel(), 30), stArgument, stParameterKey, stValueTreeNode.getModel())));",
////                  "	appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.SetKVArgumentFromSTValue(\"Set \" + appModel().render(selectedValue, 30), stArgument, stParameterKey, selectedValue)));",
////                  "	appModel().getSelectedSTModels().forEach(selectedModel -> actions.add(new nextgen.actions.SetKVArgumentFromSTModel(\"Set \" + appModel().render(selectedModel, 30), stArgument, stParameterKey, selectedModel)));",
////                  "	actions.add(new nextgen.actions.SetKVArgumentFromInput(\"Set from input\", stArgument, stParameterKey, tree));",
////                  "	actions.add(new nextgen.actions.SetKVArgumentFromClipboard(\"Set from Clipboard\", stArgument, stParameterKey));",
////                  "});",
////                  "actions.add(new nextgen.actions.DeleteKV(getModel(), tree));"
////            });
//
//      final nextgen.templates.nextgen.TreeNode stModelArgumentTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STModelArgumentTreeNode")
//            .setModelType(stModelType)
//            .setHasUuid(true)
//            .addFields(stArgumentType, "stArgument")
//            .addPrivateFields(stringType, "stArgumentUuid", "stArgument.getUuid()")
//            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())")
//            .setIcon("appModel().loadIcon(\"sq-teal\")")
//            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stTemplate.getName() + \"]\")")
//            .addConstructorStatements("stTemplate.getParameters()\n" +
//                  "		.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
//                  "		.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));")
//            .addSelectionStatements(postEventStatement(modelEditorSTModelTreeNodeClicked, "selectedNode.stTemplate", "selectedNode.getModel()"))
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(deleteSTArgument, "stArgument", "tree"))
//            });
//
//      final nextgen.templates.nextgen.TreeNode stValueArgumentTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STValueArgumentTreeNode")
//            .setModelType(stValueType)
//            .addFields(stArgumentType, "stArgument")
//            .addPrivateFields(stringType, "stArgumentUuid", "stArgument.getUuid()")
//            .setIcon("appModel().loadIcon(\"sq-orange\")")
//            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
//            .setHasUuid(true)
//            .addSelectionStatements(postEventStatement(modelEditorSTValueTreeNodeClicked, "selectedNode.getModel()"))
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(stValueToClipboard, "getModel()")),
//                  addToActionsStatement(newAction(deleteSTArgument, "stArgument", "tree")),
//            });
//
//      final nextgen.templates.nextgen.TreeNode stModelKVArgumentTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STModelKVArgumentTreeNode")
//            .setModelType(stModelType)
//            .addFields(stArgumentType, "stArgument")
//            .addPrivateFields(stringType, "stArgumentUuid", "stArgument.getUuid()")
//            .addFields(stParameterKeyType, "stParameterKey")
//            .addPrivateFields(stTemplateType, "stTemplate", "appModel().findSTTemplateByUuid(model.getStTemplate())")
//            .setIcon("appModel().loadIcon(\"sq-teal\")")
//            .setLabelExpression("appModel().tryToFindArgument(getModel(), \"name\", () -> \"[\" + stParameterKey.getName() + \"]\")")
//            .addSelectionStatements("nextgen.events.ModelEditorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());")
//            .setHasUuid(true);
//
//      final nextgen.templates.nextgen.TreeNode stValueKVArgumentTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STValueKVArgumentTreeNode")
//            .setModelType(stValueType)
//            .setHasUuid(true)
//            .addFields(stArgumentType, "stArgument")
//            .addFields(stParameterKeyType, "stParameterKey")
//            .setIcon("appModel().loadIcon(\"sq-orange\")")
//            .setLabelExpression("getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? \"[EMPTY]\" : getModel().getValue()")
//            .setGetActionsStatements(new Object[]{
//                  addToActionsStatement(newAction(deleteSTArgument, "stArgument", "tree"))
//            });
//
//      final nextgen.templates.nextgen.TreeNode stParameterTreeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
//            .setName("STParameterTreeNode")
//            .setModelType(stParameterType)
//            .setHasUuid(true)
//            .addFields(stModelType, "stModel")
//            .setLabelExpression("getModel().getName()")
//            .addConstructorStatements("stModel.getArgumentsSorted()\n" +
//                  "	.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))\n" +
//                  "	.forEach(appModel().stArgumentConsumer(model)\n" +
//                  "			.onSingleSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))\n" +
//                  "			.onSingleSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(), stArgument)))\n" +
//                  "			.onListSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))\n" +
//                  "			.onListSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(),  stArgument)))\n" +
//                  "			.onKVListConsumer((stArgument, stKVValues) -> addChild(new STKVArgumentTreeNode(stArgument, model))));")
//            .setGetActionsStatements(new Object[]{
//                  "final String fromClipboard = nextgen.utils.SwingUtil.fromClipboard();",
//                  "switch (getModel().getType()) {" +
//                        "\n\tcase SINGLE:" +
//                        "\n\t\t" + addToActionsStatement(newAction(setArgumentFromInput, "stModel", "getModel()", "tree")) +
//                        "\n\t\t" + addToActionsStatement(newAction(setArgumentFromClipboard, "stModel", "getModel()")) +
//                        "\n\t\t" + "if (appModel().isBoolean(getModel())) " + addToActionsStatement(newAction(setArgumentToTrue, "stModel", "getModel()")) +
//                        "\n\t\tbreak;" +
//                        "\n\tcase LIST:" +
//                        "\n\t\t" + addToActionsStatement(newAction(addArgumentFromInput, "stModel", "getModel()", "tree")) +
//                        "\n\t\t" + addToActionsStatement(newAction(addArgumentFromClipboard, "stModel", "getModel()")) +
//                        "\n\t\t" + addToActionsStatement(newAction(addArgumentFromArgumentType, "stModel", "getModel()", "tree")) +
//                        "\n\t\tbreak;" +
//                        "\n\tcase KVLIST:" +
//                        "\n\t\t" + addToActionsStatement(newAction(addKVArgument, "stModel", "getModel()", "tree")) +
//                        "\n\t\tbreak;" +
//                        "\n}"
//            })
////            .setGetActionsStatements(new Object[]{
////                  "appModel().doInTransaction(tx -> {",
////                  "	switch (getModel().getType()) {",
////                  "		case SINGLE:",
////                  "",
////                  "			getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(stValueTreeNode.getModel(), 30), stModel, getModel(), stValueTreeNode.getModel())));",
////                  "			actions.add(new nextgen.actions.SetArgumentFromInput(stModel, getModel(), tree));",
////                  "			appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.SetArgumentFromSTValue(\"Set \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
////                  "			appModel().getSelectedSTModels().forEach(selectedValue -> actions.add(new nextgen.actions.SetArgumentFromSTModel(\"Set \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
////                  "",
////                  "			if (fromClipboard != null && fromClipboard.startsWith(\"stmodel-\"))",
////                  "				actions.add(new nextgen.actions.SetArgumentFromSTModelUuid(\"Set STModel \" + fromClipboard.substring(8), stModel, getModel(), fromClipboard.substring(8)));",
////                  "			else if (fromClipboard != null && fromClipboard.trim().length() !=0)",
////                  "				actions.add(new nextgen.actions.SetArgumentFromClipboard(stModel, getModel()));",
////                  "",
////                  "			if (getModel().getName().startsWith(\"is\") || getModel().getName().startsWith(\"has\"))",
////                  "				actions.add(new nextgen.actions.SetArgumentToTrue(stModel, getModel()));",
////                  "",
////                  "			break;",
////                  "",
////                  "		case LIST:",
////                  "",
////                  "			getSelectedSTValueTreeNodes().forEach(stValueTreeNode -> actions.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(stValueTreeNode.getModel(), 30), stModel, getModel(), stValueTreeNode.getModel())));",
////                  "			appModel().getSelectedSTValues().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTValue(\"Add \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
////                  "			appModel().getSelectedSTModels().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTModel(\"Add \" + appModel().render(selectedValue, 30), stModel, getModel(), selectedValue)));",
////                  "			appModel().getSelectedSTTemplates().forEach(selectedValue -> actions.add(new nextgen.actions.AddArgumentFromSTTemplate(\"Add new \" + selectedValue.getName(), stModel, getModel(), selectedValue)));",
////                  "",
////                  "			if (fromClipboard != null && fromClipboard.startsWith(\"stmodel-\"))",
////                  "				actions.add(new nextgen.actions.AddArgumentFromSTModelUuid(\"Set STModel \" + fromClipboard.substring(8), stModel, getModel(), fromClipboard.substring(8)));",
////                  "			else if (fromClipboard != null && fromClipboard.trim().length() !=0)",
////                  "				actions.add(new nextgen.actions.AddArgumentFromClipboard(stModel, getModel()));",
////                  "",
////                  "			actions.add(new nextgen.actions.AddArgumentFromArgumentType(stModel, getModel(), tree));",
////                  "			actions.add(new nextgen.actions.AddMultipleArgumentsFromArgumentType(\"Add\", stModel, getModel(), tree));",
////                  "",
////                  "			break;",
////                  "",
////                  "		case KVLIST:",
////                  "",
////                  "			actions.add(new nextgen.actions.AddKVArgument(stModel, getModel(), tree));",
////                  "",
////                  "			break;",
////                  "	}",
////                  "});"
////            })
//            .addSelectionStatements(getParent("selectedNode", stModelTreeNode.getName(), postEventExpression(modelEditorSTParameterTreeNodeClicked, "selectedNode.getModel()", "parent.getModel()")));
//
//      final nextgen.templates.nextgen.TreeNavigator treeNavigator = nextgen.templates.nextgen.NextgenST.newTreeNavigator()
//            .setPackageName(stPackage.getName())
//            .addImports(newImportDeclaration(stModelPackage))
//            .addImports(newImportDeclaration(stDomainPackage))
//            .setName("STModelEditorNavigator")
//            .addFields(stModelType, "model")
//            .addFields("STModelEditor", "editor")
//            .setRootNodeExpression(newInstance(stModelTreeNode.getName(), "model"))
//            .setPreferredWidth("600")
//            .setPreferredHeight("600")
//            .setBaseTreeNode(nextgen.templates.nextgen.NextgenST.newBaseTreeNode())
//            .addConstructorStatements(nextgen.templates.GreenRobotPatterns.newRegister())
//            .addTreeNodes(stModelTreeNode)
//            .addTreeNodes(stFileSinkTreeNode)
//            .addTreeNodes(stKVArgumentTreeNode)
//            .addTreeNodes(stKVTreeNode)
//            .addTreeNodes(stParameterTreeNode)
//            .addTreeNodes(stModelArgumentTreeNode)
//            .addTreeNodes(stValueArgumentTreeNode)
//            .addTreeNodes(stModelKVArgumentTreeNode)
//            .addTreeNodes(stValueKVArgumentTreeNode)
//
//            .addTreeNodesSelected(stModelTreeNode.getName())
//            .addTreeNodesSelected(stFileSinkTreeNode.getName())
//            .addTreeNodesSelected(stKVArgumentTreeNode.getName())
//            .addTreeNodesSelected(stKVTreeNode.getName())
//            .addTreeNodesSelected(stParameterTreeNode.getName())
//            .addTreeNodesSelected(stModelArgumentTreeNode.getName())
//            .addTreeNodesSelected(stValueArgumentTreeNode.getName())
//            .addTreeNodesSelected(stModelKVArgumentTreeNode.getName())
//            .addTreeNodesSelected(stValueKVArgumentTreeNode.getName())
//
//            .addEvents(newSubscribe(modelEditorSTModelTreeNodeClicked)
//                  .addStatements(""))
//            .addEvents(newSubscribe(modelEditorSTValueTreeNodeClicked)
//                  .addStatements(""))
//            .addEvents(newSubscribe(stFileDeleted)
//                  .addStatements("findSTFileSinkTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
//            .addEvents(newSubscribe(newSTFile)
//                  .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel)).ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STFileSinkTreeNode(event.stFile)));"))
//            .addEvents(newSubscribe(kvDeleted)
//                  .addStatements("findSTKVTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
//            .addEvents(newSubscribe(stArgumentDeleted)
//                  .addStatements("findSTValueArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
//                        "findSTModelArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
//            .addEvents(newSubscribe(stValueDeleted)
//                  .addStatements("findSTValueArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);\n" +
//                        "findSTValueKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);"))
//            .addEvents(newSubscribe(stModelChanged)
//                  .addStatements("findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.model))\n" +
//                        "\t\t.ifPresent(treeNode -> {\n" +
//                        "\t\t\ttreeNode.removeAllChildren();\n" +
//                        "\t\t\ttreeNode.stTemplate.getParameters()\n" +
//                        "\t\t\t\t\t.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))\n" +
//                        "\t\t\t\t\t.forEach(stParameter -> treeNode.add(new STParameterTreeNode(stParameter, event.model)));\n" +
//                        "\t\t\ttreeModel.nodeStructureChanged(treeNode);\n" +
//                        "\t\t});"));
//
//      writeJavaFile(treeNavigator, stPackage, treeNavigator.getName(), mainJava);
//   }




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
            .setModelType(stModelType)
            .addFields(stTemplateType, "stTemplate")
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
                  "				//addstParameterMenu.add(new SetParameterTypeAction(event, stParameter));\n" +
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
                  "				//addstParameterMenu.add(new AddParameterTypeAction(event, stParameter));\n" +
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
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("AddParameterTypeAction")
//                  .addFields(stParameterType, "stParameter")
//                  .setTitle("Add")
//                  .addStatements("appModel().addList(stParameter, getModel(), thisCanvas());"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("SetParameterTypeAction")
//                  .addFields(stParameterType, "stParameter")
//                  .setTitle("Set")
//                  .addStatements("appModel().setParameter(stParameter, getModel(), thisCanvas());"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
//                  .setName("WriteToFile")
//                  .setTitle("Write To File")
//                  .addStatements("appModel().writeToFile(getModel());"))
            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
                  .setName("OpenIncoming")
                  .setTitle("Open Incoming")
//                  .addStatements("appModel().doLaterInTransaction(transaction -> {\n" +
//                        "\n" +
//                        "	appModel().getIncomingSTArguments(getModel())\n" +
//                        "			.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel()\n" +
//                        "					.forEach(stModel -> {\n" +
//                        "						final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
//                        "						if (stTemplateByUuid == null) return;\n" +
//                        "						stTemplateByUuid.getParameters()\n" +
//                        "								.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))\n" +
//                        "								.findFirst()\n" +
//                        "								.ifPresent(stParameter -> {\n" +
//                        "									final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));\n" +
//                        "									thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, thisNode(), stArgument, stParameter));\n" +
//                        "								});\n" +
//                        "					}));\n" +
//                        "\n" +
//                        "	appModel().getIncomingSTArgumentKVs(getModel())\n" +
//                        "			.forEach(stArgumentKV -> {\n" +
//                        "				stArgumentKV.getIncomingKeyValuesSTArgument()\n" +
//                        "						.forEach(stArgument -> stArgument.getIncomingArgumentsSTModel().forEach(stModel -> {\n" +
//                        "							final nextgen.st.domain.STTemplate stTemplateByUuid = appModel().findSTTemplateByUuid(stModel.getStTemplate());\n" +
//                        "							if (stTemplateByUuid == null) return;\n" +
//                        "							stTemplateByUuid.getParameters()\n" +
//                        "									.filter(stParameter -> stParameter.getUuid().equals(stArgument.getStParameter()))\n" +
//                        "									.findFirst()\n" +
//                        "									.ifPresent(stParameter -> stParameter.getKeys()\n" +
//                        "											.filter(stParameterKey -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))\n" +
//                        "											.findFirst()\n" +
//                        "											.ifPresent(stParameterKey -> {\n" +
//                        "												final STModelNode stModelNode = thisCanvas().addNode(stModel.getUuid(), () -> new STModelNode(stModel, appModel().findSTTemplateByUuid(stModel.getStTemplate())));\n" +
//                        "												final STKVNode stkvNode = thisCanvas().addNode(stArgument.getUuid(), () -> new STKVNode(stArgument, stParameter));\n" +
//                        "												thisCanvas().addRelation(stArgument.getUuid(), () -> new STArgumentRelation(stModelNode, stkvNode, stArgument, stParameter));\n" +
//                        "												thisCanvas().addRelation(stArgumentKV.getUuid(), () -> new STKVArgumentRelation(stkvNode, thisNode(), stArgument, stParameterKey, stArgumentKV));\n" +
//                        "											}));\n" +
//                        "						}));\n" +
//                        "			});\n" +
//                        "});"))
//            .addActions(nextgen.templates.nextgen.NextgenST.newCanvasNodeAction()
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

      writeJavaFile(canvas, canvas.getPackageName()
            .toString(), canvas.getName()
            .toString(), mainJava);
   }

   @org.junit.Test
   public void generateSwing() {

      final Singleton appModel = JavaPatterns
            .newSingleton(appModelName, swingPackage)
            .addFields(stringType, "title", null)
            .addFields(dimensionType, "appSize", null)
            .addFields(dimensionType, "navigatorSize", null)
            .addFields(dimensionType, "workspaceSize", null)
            .addFields(stringType, "rootDir", null)
            .addFields(stringType, "dbDir", null)
            .addFields(stringType, "outputPackage", null)
            .addFields(stringType, "outputPath", null)
            .addFields(stringType, "templateDir", null)
            .addFields(stringType, "stDelimiter", null)
            .addFields(integerType, "fontSize", null)
            .addFields(stringType, "fontName", null)
            .addFields(jFrameType, "frame", null)
            .addFields(newClassOrInterfaceType(stPackage, presentationModelName), StringUtil.lowFirst(presentationModelName), null);

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

      writeJavaFile(appModel, appModel.getPackageName(), appModel.getName(), mainJava);
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
         writeJavaFile(nodeWrapper, stModelPackage, nodeWrapper.getName(), mainJava);
      }

      writeJavaFile(neoFactory, stModelPackage, neoFactory.getName(), mainJava);
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
      writeJavaFile(workFlowFacade, workflowPackage, workFlowFacade.getName(), mainJava);

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

   private nextgen.templates.nextgen.TreeNode newTreeNode(nextgen.templates.nextgen.TreeNavigator treeNavigator, String name, ClassOrInterfaceType modelType) {
      final nextgen.templates.nextgen.TreeNode treeNode = nextgen.templates.nextgen.NextgenST.newTreeNode()
            .setName(name)
            .setModelType(modelType);
      treeNavigator.addTreeNodes(treeNode);
      treeNavigator.addTreeNodesSelected(treeNode.getName());
      return treeNode;
   }

   public static nextgen.templates.greenrobot.Event write(nextgen.templates.greenrobot.Event event) {

      event.setPackageName(eventsPackage.getName());

      writeJavaFile(event, eventsPackage, event.getName(), mainJava);

      db.doInTransaction(transaction -> {

         final nextgen.st.domain.STTemplate stTemplate = db.findSTTemplateByUuid("56afaa61-e68a-4ded-9563-4e9c38e6320d");
         final nextgen.st.model.STModel stModel = db.newSTModel("fd17be4e-a3b6-4b52-a001-b0b3257b6f21", stTemplate);
         stProject.addModels(stModel);

         stTemplate.getParameters().forEach(stParameter -> {

            if (stParameter.getName().toLowerCase().equals("name")) {
               stModel.addArguments(db.newSTArgument(stParameter, db.newSTValue(event.getName())));
            } else if (stParameter.getName().toLowerCase().equals("packagename")) {
               stModel.addArguments(db.newSTArgument(stParameter, db.newSTValue(event.getPackageName().toString())));
            } else if (stParameter.getName().toLowerCase().equals("fields")) {
               event.streamFields().forEach(event_fields -> {
                  final java.util.Collection<nextgen.st.model.STArgumentKV> kvs = new java.util.ArrayList<>();
                  stParameter.getKeys().forEach(stParameterKey -> {
                     if (stParameterKey.getName().equals("name")) {
                        kvs.add(db.newSTArgumentKV(stParameterKey, db.newSTValue(event_fields.getName().toString())));
                     } else if (stParameterKey.getName().equals("type")) {
                        kvs.add(db.newSTArgumentKV(stParameterKey, db.newSTValue(event_fields.getType().toString())));
                     } else {
                        System.out.println("error");
                     }
                  });
                  stModel.addArguments(db.newSTArgument(stParameter, kvs));
               });
            } else {
               System.out.println("error");
            }
         });


      }, throwable -> {
         throwable.printStackTrace();
         System.out.println(throwable.getMessage());
      });


      return event;
   }

   private static TransactionAction write(TransactionAction action) {

      writeJavaFile(action, actionsPackage, action.getName().toString(), mainJava);

      db.doInTransaction(transaction -> {

         final nextgen.st.domain.STTemplate stTemplate = db.findSTTemplateByUuid("54b49221-8a58-44a5-9ba6-2a75cbe9357f");
         final nextgen.st.model.STModel stModel = db.newSTModel("483489b9-c91a-41c8-ad49-1dc7f9f1469f", stTemplate);
         stProject.addModels(stModel);

         stTemplate.getParameters().forEach(stParameter -> {

            if (stParameter.getName().toLowerCase().equals("name")) {
               stModel.addArguments(db.newSTArgument(stParameter, db.newSTValue(action.getName().toString())));
            } else if (stParameter.getName().toLowerCase().equals("title") && action.getTitle() != null) {
               stModel.addArguments(db.newSTArgument(stParameter, db.newSTValue(action.getTitle().toString())));
            } else if (stParameter.getName().toLowerCase().equals("titleexpression") && action.getTitleExpression() != null) {
               stModel.addArguments(db.newSTArgument(stParameter, db.newSTValue(action.getTitleExpression().toString())));
            } else if (stParameter.getName().toLowerCase().equals("fields")) {
               action.streamFields().forEach(event_fields -> {
                  final java.util.Collection<nextgen.st.model.STArgumentKV> kvs = new java.util.ArrayList<>();
                  stParameter.getKeys().forEach(stParameterKey -> {
                     if (stParameterKey.getName().equals("name")) {
                        kvs.add(db.newSTArgumentKV(stParameterKey, db.newSTValue(event_fields.getName().toString())));
                     } else if (stParameterKey.getName().equals("type")) {
                        kvs.add(db.newSTArgumentKV(stParameterKey, db.newSTValue(event_fields.getType().toString())));
                     } else {
                        System.out.println("error");
                     }
                  });
                  stModel.addArguments(db.newSTArgument(stParameter, kvs));
               });
            } else if (stParameter.getName().toLowerCase().equals("staticfields")) {
               action.streamStaticFields().forEach(event_fields -> {
                  final java.util.Collection<nextgen.st.model.STArgumentKV> kvs = new java.util.ArrayList<>();
                  stParameter.getKeys().forEach(stParameterKey -> {
                     if (stParameterKey.getName().equals("name")) {
                        kvs.add(db.newSTArgumentKV(stParameterKey, db.newSTValue(event_fields.getName().toString())));
                     } else if (stParameterKey.getName().equals("type")) {
                        kvs.add(db.newSTArgumentKV(stParameterKey, db.newSTValue(event_fields.getType().toString())));
                     } else if (stParameterKey.getName().equals("init")) {
                        kvs.add(db.newSTArgumentKV(stParameterKey, db.newSTValue(event_fields.getInit().toString())));
                     } else {
                        System.out.println("error");
                     }
                  });
                  stModel.addArguments(db.newSTArgument(stParameter, kvs));
               });
            } else if (stParameter.getName().toLowerCase().equals("statements")) {
               stModel.addArguments(db.newSTArgument(stParameter, db.newSTValue("System.out.println(\"" + action.getName() + "\");")));
               action.getStatements().forEach(o -> stModel.addArguments(db.newSTArgument(stParameter, db.newSTValue(o.toString()))));
            } else {
               System.out.println(stParameter.getName());
            }
         });


      }, throwable -> {
         throwable.printStackTrace();
         System.out.println("");
      });

      return action;
   }

   private nextgen.templates.greenrobot.Subscribe newSubscribe(nextgen.templates.greenrobot.Event event) {
      return nextgen.templates.greenrobot.GreenRobotST.newSubscribe()
            .setEventName(event.getName())
            .setEventType(newClassOrInterfaceType(eventsPackage, event.getName()))
            .addStatements("System.out.println(\"" + event.getName() + "\");");
   }

   private nextgen.templates.java.Expression postEventExpression(nextgen.templates.greenrobot.Event event, Object... arguments) {
      return postEventExpression(event.getName(), arguments);
   }

   private nextgen.templates.java.Expression postEventExpression(String eventName, Object... arguments) {
      final nextgen.templates.java.MethodCallExpression expression = newMethodCallExpression()
            .setScope(newClassOrInterfaceType(eventsPackage, eventName))
            .setName("post");
      for (Object argument : arguments)
         expression.addArguments(argument);
      return expression;
   }

   private nextgen.templates.java.Statement postEventStatement(nextgen.templates.greenrobot.Event event, Object... arguments) {
      return newExpressionStmt().setExpression(postEventExpression(event.getName(), arguments));
   }

   private nextgen.templates.java.ObjectCreationExpression newAction(TransactionAction action, Object... arguments) {
      final nextgen.templates.java.ObjectCreationExpression expression = nextgen.templates.JavaPatterns.newObjectCreationExpression(newClassOrInterfaceType(actionsPackage, action.getName()));
      for (Object argument : arguments)
         expression.addArguments(argument);
      return expression;
   }

   private nextgen.templates.java.Expression addToActions(nextgen.templates.java.ObjectCreationExpression action) {
      return newMethodCallExpression()
            .setScope("actions")
            .setName("add")
            .addArguments(action);
   }

   private Object addToActionsStatement(nextgen.templates.java.ObjectCreationExpression action) {
      return newExpressionStmt()
            .setExpression(addToActions(action));
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

   private String getParent(String parent, nextgen.templates.java.Expression expression) {
      return getParent(null, parent, expression);
   }

   private String getParent(String parent, nextgen.templates.java.BlockStmt blockStmt) {
      return getParent(null, parent, blockStmt);
   }

   private String getParent(String scope, nextgen.templates.nextgen.TreeNode parent, nextgen.templates.java.BlockStmt blockStmt) {
      return getParent(scope, parent.getName(), blockStmt);
   }

   private String getParent(String scope, String parent, nextgen.templates.java.BlockStmt blockStmt) {
      return (scope == null ? "" : (scope + ".")) + "getParentNode(" + parent + ".class).ifPresent(parent -> " + blockStmt + " );";
   }

   private Object newInstance(String type, String... arguments) {
      final nextgen.templates.java.ObjectCreationExpression objectCreationExpression = newObjectCreationExpression(type);
      for (String argument : arguments)
         objectCreationExpression.addArguments(argument);
      return objectCreationExpression;
   }
}