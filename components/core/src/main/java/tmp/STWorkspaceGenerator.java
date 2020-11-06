package tmp;

import nextgen.templates.nextgen.*;
import nextgen.templates.greenrobot.*;

public class STWorkspaceGenerator {

   public static STWorkspace generate() {
      return NextgenST.newSTWorkspace()
            .setPackageName("nextgen.st")
            .setName("STWorkspace")
            .addFields("STTemplateNavigator", "templateNavigator", null)
            .addFields("STModelNavigator", "modelNavigator", null)
            .addConstructorParameters("findCanvas();")
            .addConstructorParameters("appModel().doInTransaction(transaction -> {\n" +
                  "			templateNavigator = new STTemplateNavigator(this);\n" +
                  "			modelNavigator = new STModelNavigator(this);\n" +
                  "		});")
            .addConstructorParameters("org.greenrobot.eventbus.EventBus.getDefault().register(this);")
            .addMethods(GreenRobotST.newSubscribe()
                  .setEventName("ModelNavigatorSTModelTreeNodeClicked")
                  .setEventType("nextgen.events.ModelNavigatorSTModelTreeNodeClicked")
                  .addStatements("getModelEditor(event.stTemplate, event.stModel);"))
            .addMethods(GreenRobotST.newSubscribe()
                  .setEventName("TemplateNavigatorSTGroupTreeNodeClicked")
                  .setEventType("nextgen.events.TemplateNavigatorSTGroupTreeNodeClicked")
                  .addStatements("getSTEditor(event.stGroup);"))
            .addMethods(GreenRobotST.newSubscribe()
                  .setEventName("TemplateNavigatorSTTemplateTreeNodeClicked")
                  .setEventType("nextgen.events.TemplateNavigatorSTTemplateTreeNodeClicked")
                  .addStatements("getSTEditor(event.stGroup).setSTTemplate(event.stTemplate);"))
            .addMethods(GreenRobotST.newSubscribe()
                  .setEventName("TemplateNavigatorSTEnumTreeNodeClicked")
                  .setEventType("nextgen.events.TemplateNavigatorSTEnumTreeNodeClicked")
                  .addStatements("getSTEditor(event.stGroup).setSTEnum(event.stEnum);"))
            .addMethods(GreenRobotST.newSubscribe()
                  .setEventName("TemplateNavigatorSTInterfaceTreeNodeClicked")
                  .setEventType("nextgen.events.TemplateNavigatorSTInterfaceTreeNodeClicked")
                  .addStatements("getSTEditor(event.stGroup).setSTInterface(event.stInterface);"))
            .addMethods(GreenRobotST.newSubscribe()
                  .setEventName("STModelDeleted")
                  .setEventType("nextgen.events.STModelDeleted")
                  .addStatements("SwingUtilities.invokeLater(() -> removeModelEditor(event.uuid));"));
   }
}