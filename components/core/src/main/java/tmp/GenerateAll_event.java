package tmp;

import nextgen.templates.greenrobot.*;

public class GenerateAll_event {

   public static java.util.List<Event> generate() {
      final java.util.List<Event> list = new java.util.ArrayList<>();
      final Event ModelNavigatorSTFileTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorSTFileTreeNodeClicked")
            .addFields("nextgen.st.model.STFile", "stFile")
            .setPackageName("nextgen.events");
      final Event STFileChanged = GreenRobotST.newEvent()
            .setName("STFileChanged")
            .addFields("nextgen.st.model.STFile", "stFile")
            .setPackageName("nextgen.events");
      final Event NewSTArgument = GreenRobotST.newEvent()
            .setName("NewSTArgument")
            .addFields("nextgen.st.model.STArgument", "argument")
            .addFields("nextgen.st.model.STModel", "model")
            .addFields("nextgen.st.model.STParameter", "parameter")
            .addFields("nextgen.st.model.STValue", "value")
            .setPackageName("nextgen.events");
      final Event NewSTKVArgument = GreenRobotST.newEvent()
            .setName("NewSTKVArgument")
            .addFields("nextgen.st.model.STModel", "model")
            .addFields("nextgen.st.model.STParameter", "stParameter")
            .addFields("nextgen.st.model.STArgument", "argument")
            .addFields("java.util.Collection<nextgen.st.model.STArgumentKV>", "kvs")
            .setPackageName("nextgen.events");
      final Event NewKV = GreenRobotST.newEvent()
            .setName("NewKV")
            .addFields("nextgen.st.model.STModel", "stModel")
            .addFields("nextgen.st.model.STArgument", "argument")
            .addFields("nextgen.st.model.STArgumentKV", "kv")
            .addFields("nextgen.st.model.STParameterKey", "stParameterKey")
            .addFields("nextgen.st.model.STValue", "value")
            .setPackageName("nextgen.events");
      final Event NewSTModel = GreenRobotST.newEvent()
            .setName("NewSTModel")
            .addFields("nextgen.st.model.STModel", "model")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STTemplate", "template")
            .setPackageName("nextgen.events");
      final Event STModelChanged = GreenRobotST.newEvent()
            .setName("STModelChanged")
            .addFields("nextgen.st.model.STModel", "model")
            .setPackageName("nextgen.events");
      final Event NewSTProjectSTModel = GreenRobotST.newEvent()
            .setName("NewSTProjectSTModel")
            .addFields("nextgen.st.model.STModel", "model")
            .addFields("nextgen.st.model.STProject", "project")
            .addFields("nextgen.st.model.STTemplate", "template")
            .setPackageName("nextgen.events");
      final Event NewSTProjectSTValue = GreenRobotST.newEvent()
            .setName("NewSTProjectSTValue")
            .addFields("nextgen.st.model.STValue", "value")
            .addFields("nextgen.st.model.STProject", "project")
            .setPackageName("nextgen.events");
      final Event NewFileSink = GreenRobotST.newEvent()
            .setName("NewFileSink")
            .addFields("nextgen.st.model.STModel", "stModel")
            .addFields("nextgen.st.model.STFile", "stFile")
            .setPackageName("nextgen.events");
      final Event NewSTGroupTemplate = GreenRobotST.newEvent()
            .setName("NewSTGroupTemplate")
            .addFields("nextgen.st.model.STTemplate", "template")
            .addFields("nextgen.st.model.STGroupModel", "parent")
            .setPackageName("nextgen.events");
      final Event NewSTTemplateChild = GreenRobotST.newEvent()
            .setName("NewSTTemplateChild")
            .addFields("nextgen.st.model.STTemplate", "template")
            .addFields("nextgen.st.model.STTemplate", "parent")
            .setPackageName("nextgen.events");
      final Event NewSTEnum = GreenRobotST.newEvent()
            .setName("NewSTEnum")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STEnum", "stEnum")
            .setPackageName("nextgen.events");
      final Event NewSTInterface = GreenRobotST.newEvent()
            .setName("NewSTInterface")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STInterface", "stInterface")
            .setPackageName("nextgen.events");
      final Event NewSTProject = GreenRobotST.newEvent()
            .setName("NewSTProject")
            .addFields("nextgen.st.model.STProject", "project")
            .setPackageName("nextgen.events");
      final Event NewSTGroup = GreenRobotST.newEvent()
            .setName("NewSTGroup")
            .addFields("nextgen.st.model.STGroupModel", "group")
            .setPackageName("nextgen.events");
      final Event STValueChanged = GreenRobotST.newEvent()
            .setName("STValueChanged")
            .addFields("nextgen.st.model.STValue", "value")
            .setPackageName("nextgen.events");
      final Event STArgumentChanged = GreenRobotST.newEvent()
            .setName("STArgumentChanged")
            .addFields("nextgen.st.model.STModel", "stModel")
            .addFields("nextgen.st.model.STArgument", "stArgument")
            .setPackageName("nextgen.events");
      final Event STEnumChanged = GreenRobotST.newEvent()
            .setName("STEnumChanged")
            .addFields("nextgen.st.model.STEnum", "stEnum")
            .setPackageName("nextgen.events");
      final Event STGroupTagsChanged = GreenRobotST.newEvent()
            .setName("STGroupTagsChanged")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .setPackageName("nextgen.events");
      final Event STEnumNameChanged = GreenRobotST.newEvent()
            .setName("STEnumNameChanged")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STEnum", "stEnum")
            .setPackageName("nextgen.events");
      final Event STGroupNameChanged = GreenRobotST.newEvent()
            .setName("STGroupNameChanged")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .setPackageName("nextgen.events");
      final Event STInterfaceNameChanged = GreenRobotST.newEvent()
            .setName("STInterfaceNameChanged")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STInterface", "stInterface")
            .setPackageName("nextgen.events");
      final Event STTemplateNameChanged = GreenRobotST.newEvent()
            .setName("STTemplateNameChanged")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STTemplate", "stTemplate")
            .setPackageName("nextgen.events");
      final Event STTemplateParameterTypesChanged = GreenRobotST.newEvent()
            .setName("STTemplateParameterTypesChanged")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STTemplate", "stTemplate")
            .setPackageName("nextgen.events");
      final Event STTemplateInterfacesChanged = GreenRobotST.newEvent()
            .setName("STTemplateInterfacesChanged")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STTemplate", "stTemplate")
            .setPackageName("nextgen.events");
      final Event STTemplateInterfaceRemoved = GreenRobotST.newEvent()
            .setName("STTemplateInterfaceRemoved")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STTemplate", "stTemplate")
            .addFields("String", "interfaceName")
            .setPackageName("nextgen.events");
      final Event STTemplateChildrenAdded = GreenRobotST.newEvent()
            .setName("STTemplateChildrenAdded")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STTemplate", "stTemplate")
            .addFields("java.util.Set<nextgen.st.model.STTemplate>", "children")
            .setPackageName("nextgen.events");
      final Event STValueDeleted = GreenRobotST.newEvent()
            .setName("STValueDeleted")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event STModelDeleted = GreenRobotST.newEvent()
            .setName("STModelDeleted")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event STArgumentDeleted = GreenRobotST.newEvent()
            .setName("STArgumentDeleted")
            .addFields("nextgen.st.model.STModel", "stModel")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event STFileDeleted = GreenRobotST.newEvent()
            .setName("STFileDeleted")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event KVDeleted = GreenRobotST.newEvent()
            .setName("KVDeleted")
            .addFields("nextgen.st.model.STModel", "stModel")
            .addFields("nextgen.st.model.STArgument", "stArgument")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event STInterfaceDeleted = GreenRobotST.newEvent()
            .setName("STInterfaceDeleted")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event STEnumDeleted = GreenRobotST.newEvent()
            .setName("STEnumDeleted")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event STGroupDeleted = GreenRobotST.newEvent()
            .setName("STGroupDeleted")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event STTemplateDeleted = GreenRobotST.newEvent()
            .setName("STTemplateDeleted")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event OpenSTModel = GreenRobotST.newEvent()
            .setName("OpenSTModel")
            .addFields("nextgen.st.model.STModel", "model")
            .setPackageName("nextgen.events");
      final Event OpenSTTemplate = GreenRobotST.newEvent()
            .setName("OpenSTTemplate")
            .addFields("nextgen.st.model.STTemplate", "template")
            .setPackageName("nextgen.events");
      final Event TemplateNavigatorSTParameterTreeNodeClicked = GreenRobotST.newEvent()
            .setName("TemplateNavigatorSTParameterTreeNodeClicked")
            .addFields("nextgen.st.model.STParameter", "parameter")
            .addFields("nextgen.st.model.STModel", "model")
            .setPackageName("nextgen.events");
      final Event TemplateNavigatorSTGroupTreeNodeClicked = GreenRobotST.newEvent()
            .setName("TemplateNavigatorSTGroupTreeNodeClicked")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .setPackageName("nextgen.events");
      final Event TemplateNavigatorSTTemplateTreeNodeClicked = GreenRobotST.newEvent()
            .setName("TemplateNavigatorSTTemplateTreeNodeClicked")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STTemplate", "parentTemplate")
            .addFields("nextgen.st.model.STTemplate", "stTemplate")
            .setPackageName("nextgen.events");
      final Event TemplateNavigatorSTEnumTreeNodeClicked = GreenRobotST.newEvent()
            .setName("TemplateNavigatorSTEnumTreeNodeClicked")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STEnum", "stEnum")
            .setPackageName("nextgen.events");
      final Event TemplateNavigatorSTInterfaceTreeNodeClicked = GreenRobotST.newEvent()
            .setName("TemplateNavigatorSTInterfaceTreeNodeClicked")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .addFields("nextgen.st.model.STInterface", "stInterface")
            .setPackageName("nextgen.events");
      final Event ModelNavigatorSTProjectTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorSTProjectTreeNodeClicked")
            .addFields("nextgen.st.model.STProject", "stProject")
            .setPackageName("nextgen.events");
      final Event ModelNavigatorModelsTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorModelsTreeNodeClicked")
            .setPackageName("nextgen.events");
      final Event ModelNavigatorSTGroupTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorSTGroupTreeNodeClicked")
            .addFields("nextgen.st.model.STGroupModel", "stGroup")
            .setPackageName("nextgen.events");
      final Event ModelNavigatorSTTemplateTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorSTTemplateTreeNodeClicked")
            .addFields("nextgen.st.model.STTemplate", "stTemplate")
            .setPackageName("nextgen.events");
      final Event ModelNavigatorSTParameterTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorSTParameterTreeNodeClicked")
            .addFields("nextgen.st.model.STParameter", "stParameter")
            .setPackageName("nextgen.events");
      final Event ModelNavigatorSTModelTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorSTModelTreeNodeClicked")
            .addFields("nextgen.st.model.STTemplate", "stTemplate")
            .addFields("nextgen.st.model.STModel", "stModel")
            .setPackageName("nextgen.events");
      final Event ModelNavigatorSTKVArgumentTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorSTKVArgumentTreeNodeClicked")
            .addFields("nextgen.st.model.STArgumentKV", "kv")
            .setPackageName("nextgen.events");
      final Event ModelNavigatorSTValueTreeNodeClicked = GreenRobotST.newEvent()
            .setName("ModelNavigatorSTValueTreeNodeClicked")
            .addFields("nextgen.st.model.STValue", "stValue")
            .setPackageName("nextgen.events");
      final Event NewSTGroupFile = GreenRobotST.newEvent()
            .setName("NewSTGroupFile")
            .addFields("nextgen.st.model.STGroupModel", "stGroupModel")
            .addFields("nextgen.st.model.STGroupFile", "stGroupFile")
            .setPackageName("nextgen.events");
      final Event STGroupFileDeleted = GreenRobotST.newEvent()
            .setName("STGroupFileDeleted")
            .addFields("String", "uuid")
            .setPackageName("nextgen.events");
      final Event STGroupFileChanged = GreenRobotST.newEvent()
            .setName("STGroupFileChanged")
            .addFields("nextgen.st.model.STGroupFile", "stGroupFile")
            .setPackageName("nextgen.events");
      final Event TemplateNavigatorSTGroupFileClicked = GreenRobotST.newEvent()
            .setName("TemplateNavigatorSTGroupFileClicked")
            .addFields("nextgen.st.model.STGroupFile", "stGroupFile")
            .setPackageName("nextgen.events");
      list.add(ModelNavigatorSTFileTreeNodeClicked);
      list.add(STFileChanged);
      list.add(NewSTArgument);
      list.add(NewSTKVArgument);
      list.add(NewKV);
      list.add(NewSTModel);
      list.add(STModelChanged);
      list.add(NewSTProjectSTModel);
      list.add(NewSTProjectSTValue);
      list.add(NewFileSink);
      list.add(NewSTGroupTemplate);
      list.add(NewSTTemplateChild);
      list.add(NewSTEnum);
      list.add(NewSTInterface);
      list.add(NewSTProject);
      list.add(NewSTGroup);
      list.add(STValueChanged);
      list.add(STArgumentChanged);
      list.add(STEnumChanged);
      list.add(STGroupTagsChanged);
      list.add(STEnumNameChanged);
      list.add(STGroupNameChanged);
      list.add(STInterfaceNameChanged);
      list.add(STTemplateNameChanged);
      list.add(STTemplateParameterTypesChanged);
      list.add(STTemplateInterfacesChanged);
      list.add(STTemplateInterfaceRemoved);
      list.add(STTemplateChildrenAdded);
      list.add(STValueDeleted);
      list.add(STModelDeleted);
      list.add(STArgumentDeleted);
      list.add(STFileDeleted);
      list.add(KVDeleted);
      list.add(STInterfaceDeleted);
      list.add(STEnumDeleted);
      list.add(STGroupDeleted);
      list.add(STTemplateDeleted);
      list.add(OpenSTModel);
      list.add(OpenSTTemplate);
      list.add(TemplateNavigatorSTParameterTreeNodeClicked);
      list.add(TemplateNavigatorSTGroupTreeNodeClicked);
      list.add(TemplateNavigatorSTTemplateTreeNodeClicked);
      list.add(TemplateNavigatorSTEnumTreeNodeClicked);
      list.add(TemplateNavigatorSTInterfaceTreeNodeClicked);
      list.add(ModelNavigatorSTProjectTreeNodeClicked);
      list.add(ModelNavigatorModelsTreeNodeClicked);
      list.add(ModelNavigatorSTGroupTreeNodeClicked);
      list.add(ModelNavigatorSTTemplateTreeNodeClicked);
      list.add(ModelNavigatorSTParameterTreeNodeClicked);
      list.add(ModelNavigatorSTModelTreeNodeClicked);
      list.add(ModelNavigatorSTKVArgumentTreeNodeClicked);
      list.add(ModelNavigatorSTValueTreeNodeClicked);
      list.add(NewSTGroupFile);
      list.add(STGroupFileDeleted);
      list.add(STGroupFileChanged);
      list.add(TemplateNavigatorSTGroupFileClicked);
      return list;
   }
}