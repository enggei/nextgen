package tmp;

import nextgen.templates.nextgen.*;
import nextgen.templates.greenrobot.*;

public class STWorkspaceGenerator {

   public static STWorkspace generate() {
      return NextgenST.newSTWorkspace()
            .addComponentMethods(NextgenST.newFindEditor().setModelType("nextgen.st.model.STTemplate").setTitleExpression("model.getName() + \"-Models\"").setComponentType("STModelGrid").setComponentName("ModelGrid"))
            .addComponentMethods(NextgenST.newFindSingletonComponent().setComponentType("STModelCanvas").setNewInstanceExpression("new STModelCanvas(UIManager.getColor(\"Panel.background\"), new Dimension(800, 600))")
                  .setNameExpression("\"Canvas\"").setName("Canvas"))
            .addComponentMethods(NextgenST.newFindEditor().setModelType("nextgen.st.model.STModel").setTitleExpression("appModel().tryToFindArgument(model, \"name\", () -> model.getStTemplate().getName() + \"Model\")")
                  .setComponentType("nextgen.swing.STModelEditor").setComponentName("ModelEditor"))
            .addComponentMethods(NextgenST.newFindEditor().setModelType("nextgen.st.model.STGroupModel").setTitleExpression("model.getName()").setComponentType("STEditor").setComponentName("STEditor"))
            .addComponentMethods(NextgenST.newFindEditor().setModelType("nextgen.st.model.STFile").setTitleExpression("\"FileSink\"").setComponentType("nextgen.swing.STFileEditor").setComponentName("STFileEditor"))
            .addComponentMethods(NextgenST.newFindSingletonComponent().setComponentType("STValueEditor").setNewInstanceExpression("new STValueEditor()").setNameExpression("\"STValue\"").setName("STValueEditor"))
            .addComponentMethods(NextgenST.newFindEditor().setModelType("nextgen.st.model.STGroupFile").setTitleExpression("\"GroupFile\"").setComponentType("nextgen.swing.STGroupFileEditor").setComponentName("STGroupFileEditor"))
            .addComponentMethods(NextgenST.newFindSingletonComponent().setComponentType("STValueGrid").setNewInstanceExpression("new STValueGrid()").setNameExpression("\"ValueGrid\"").setName("ValueGrid")).setPackageName("nextgen.swing")
            .addConstructorParameters("getCanvas();").addConstructorParameters("appModel().doInTransaction(transaction -> {\n" +
                  "	templateNavigator = new STTemplateNavigator(this);\n" +
                  "	modelNavigator = new STModelNavigator(this);\n" +
                  "});").addConstructorParameters("org.greenrobot.eventbus.EventBus.getDefault().register(this);").setName("STWorkspace").addFields("templateNavigator", null, "STTemplateNavigator")
            .addFields("modelNavigator", null, "STModelNavigator")
            .addMethods(GreenRobotST.newSubscribe().setEventName("EditSTModels").setEventType("nextgen.events.EditSTModels").addStatements("getModelGrid(event.stModel).requestFocusInWindow();"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("ModelNavigatorSTFileTreeNodeClicked").setEventType("nextgen.events.ModelNavigatorSTFileTreeNodeClicked").addStatements("getSTFileEditor(event.stFile);"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("ModelNavigatorSTModelTreeNodeClicked").setEventType("nextgen.events.ModelNavigatorSTModelTreeNodeClicked").addStatements("getModelEditor(event.stModel);"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("TemplateNavigatorSTGroupTreeNodeClicked").setEventType("nextgen.events.TemplateNavigatorSTGroupTreeNodeClicked").addStatements("getSTEditor(event.stGroup);"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("TemplateNavigatorSTTemplateTreeNodeClicked").setEventType("nextgen.events.TemplateNavigatorSTTemplateTreeNodeClicked")
                  .addStatements("getSTEditor(event.stGroup).setSTTemplate(event.stTemplate);"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("TemplateNavigatorSTEnumTreeNodeClicked").setEventType("nextgen.events.TemplateNavigatorSTEnumTreeNodeClicked")
                  .addStatements("getSTEditor(event.stGroup).setSTEnum(event.stEnum);"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("TemplateNavigatorSTInterfaceTreeNodeClicked").setEventType("nextgen.events.TemplateNavigatorSTInterfaceTreeNodeClicked")
                  .addStatements("getSTEditor(event.stGroup).setSTInterface(event.stInterface);"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("STModelDeleted").setEventType("nextgen.events.STModelDeleted").addStatements("removeModelEditor(event.uuid);"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("ModelNavigatorSTValueTreeNodeClicked").setEventType("nextgen.events.ModelNavigatorSTValueTreeNodeClicked")
                  .addStatements("final nextgen.swing.STValueEditor stValueEditor = getSTValueEditor();\n" +
                        "stValueEditor.setSTValue(event.stValue);\n" +
                        "SwingUtilities.invokeLater(() -> setSelectedComponent(stValueEditor));"))
            .addMethods(GreenRobotST.newSubscribe().setEventName("TemplateNavigatorSTGroupFileClicked").setEventType("nextgen.events.TemplateNavigatorSTGroupFileClicked").addStatements("getSTGroupFileEditor(event.stGroupFile);"));
   }
}