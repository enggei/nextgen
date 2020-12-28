package nextgen.swing;

import nextgen.events.STModelChanged;
import nextgen.model.*;
import nextgen.swing.forms.builder.*;

import java.awt.*;
import java.util.*;

import static nextgen.swing.STAppPresentationModel.*;

public class STModelEditor extends BaseEditor<STModel> {

   private final STModelEditorText txtEditor = new nextgen.swing.STModelEditorText();
   private final STModelEditorForm formComponent = new STModelEditorForm();
   private final STModelEditorForm2 formComponent2 = new STModelEditorForm2();
   private final String uuid;

   public STModelEditor(STModel stModel) {
      super(stModel);
      this.uuid = stModel.getUuid();

      final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
      editors.add("Editor", txtEditor);
      editors.add("Values", new STModelEditorGrid(stModel));
      editors.add("Form", formComponent);
      editors.add("New Form", formComponent2);
      if (stModel.getStTemplate().getUuid().equals("c69858b9-e9aa-4022-98e5-bd6b3bfe0e8b"))
         editors.add("FormBuilder", newFormEditor(stModel).onMakePanel(this::saveModel));
      add(editors, BorderLayout.CENTER);

      txtEditor.setStModel(stModel);
      formComponent.setModel(stModel);
      formComponent2.setModel(stModel);
      org.greenrobot.eventbus.EventBus.getDefault().register(this);
   }

   private FormEditor newFormEditor(STModel stModel) {
      final String model = getSTModelValue(stModel, "model", "");
      final String modelName = getSTModelName(stModel);
      final String modelPackage = getSTModelPackage(stModel);
      return new FormEditor(modelName, modelPackage, model);
   }

   private void saveModel(FormEditor formEditor) {

      appModel().doLaterInTransaction((tx) -> {
         appModel().getSTParameters(getModel()).forEach(parameterArguments -> {
            switch (parameterArguments.parameter().getName()) {
               case "model":
                  appModel().setArgument(getModel(), parameterArguments.parameter(), formEditor.debug());
                  break;
               case "name":
                  appModel().setArgument(getModel(), parameterArguments.parameter(), formEditor.getModelName());
                  getModel().getFiles().filter(stFile -> stFile.getName()==null || !stFile.getName().getValue().equals(formEditor.model().name())).forEach(stFile -> stFile.setName(appModel().newSTValue(formEditor.model().name())));
                  break;
               case "package":
                  appModel().setArgument(getModel(), parameterArguments.parameter(), formEditor.getModelPackage());
                  getModel().getFiles().filter(stFile -> stFile.getPackageName()==null || !stFile.getPackageName().getValue().equals(formEditor.model().packageName())).forEach(stFile -> stFile.setPackageName(appModel().newSTValue(formEditor.model().packageName())));
                  break;
               case "extending":
                  appModel().setArgument(getModel(), parameterArguments.parameter(), appModel().db.findOrCreateSTValueByValue("JPanel"));
                  break;
               case "colSpec":
                  appModel().setArgument(getModel(), parameterArguments.parameter(), formEditor.getColumnSpecs().toString());
                  break;
               case "rowSpec":
                  appModel().setArgument(getModel(), parameterArguments.parameter(), formEditor.getRowSpecs().toString());
                  break;
               case "columns":
                  appModel().setArgument(getModel(), parameterArguments.parameter(), Integer.toString(formEditor.model().columns().size()));
                  break;
               case "rows":
                  appModel().setArgument(getModel(), parameterArguments.parameter(), Integer.toString(formEditor.model().rows().size()));
                  break;
               case "components":
                  appModel().detach(getModel(), parameterArguments.parameter());

                  final Map<FormModel.Cell, Collection<STArgumentKV>> map = new LinkedHashMap<>();
                  parameterArguments.parameter().getKeysSorted().forEach(stParameterKey -> {
                     formEditor.getComponentCells().forEach(cell -> {
                        map.putIfAbsent(cell, new ArrayList<>());
                        switch (stParameterKey.getName()) {
                           case "name":
                              map.get(cell).add(appModel().newSTArgumentKV(stParameterKey, appModel().newSTValue(formEditor.getCellName(cell))));
                              break;
                           case "type":
                              map.get(cell).add(appModel().newSTArgumentKV(stParameterKey, appModel().newSTValue(formEditor.getCellType(cell))));
                              break;
                           case "w":
                              map.get(cell).add(appModel().newSTArgumentKV(stParameterKey, appModel().newSTValue(Integer.toString(cell.width()))));
                              break;
                           case "h":
                              map.get(cell).add(appModel().newSTArgumentKV(stParameterKey, appModel().newSTValue(Integer.toString(cell.height()))));
                              break;
                           case "hAlign":
                              map.get(cell).add(appModel().newSTArgumentKV(stParameterKey, appModel().newSTValue(cell.hAlign().name())));
                              break;
                           case "vAlign":
                              map.get(cell).add(appModel().newSTArgumentKV(stParameterKey, appModel().newSTValue(cell.vAlign().name())));
                              break;
                           case "x":
                              map.get(cell).add(appModel().newSTArgumentKV(stParameterKey, appModel().newSTValue(formEditor.getCellX(cell))));
                              break;
                           case "y":
                              map.get(cell).add(appModel().newSTArgumentKV(stParameterKey, appModel().newSTValue(formEditor.getCellY(cell))));
                              break;
                        }
                     });
                  });

                  map.values().forEach(kvs -> appModel().addArgument(getModel(), parameterArguments.parameter(), kvs));
                  break;
            }
         });

         appModel().generateSTModel(getModel());

         STModelChanged.post(getModel());
      });
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      nextgen.swing.STModelEditor that = (nextgen.swing.STModelEditor) o;
      return uuid.equals(that.uuid);
   }

   @Override
   public int hashCode() {
      return java.util.Objects.hash(uuid);
   }

   @Override
   public String toString() {
      return uuid;
   }

   public String getUuid() {
      return uuid;
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onModelNavigatorSTModelTreeNodeClicked(nextgen.events.ModelNavigatorSTModelTreeNodeClicked event) {
      if (model.equals(event.stModel)) {
         txtEditor.setStModel(event.stModel);
         formComponent.setModel(event.stModel);
         formComponent2.setModel(event.stModel);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onSTModelChanged(nextgen.events.STModelChanged event) {
      if (model.equals(event.model)) {
         txtEditor.setStModel(model);
         formComponent.setModel(model);
         formComponent2.setModel(model);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onNewSTArgument(nextgen.events.NewSTArgument event) {
      if (model.equals(event.model)) {
         txtEditor.setStModel(model);
         formComponent.setModel(model);
         formComponent2.setModel(model);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onSTArgumentChanged(nextgen.events.STArgumentChanged event) {
      if (model.equals(event.stModel)) {
         txtEditor.setStModel(model);
         formComponent.setModel(model);
         formComponent2.setModel(model);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onSTArgumentDeleted(nextgen.events.STArgumentDeleted event) {
      if (model.equals(event.stModel)) {
         txtEditor.setStModel(model);
         formComponent.setModel(model);
         formComponent2.setModel(model);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onNewSTKVArgument(nextgen.events.NewSTKVArgument event) {
      if (model.equals(event.model)) {
         txtEditor.setStModel(model);
         formComponent.setModel(model);
         formComponent2.setModel(model);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onKVDeleted(nextgen.events.KVDeleted event) {
      if (model.equals(event.stModel)) {
         txtEditor.setStModel(model);
         formComponent.setModel(model);
         formComponent2.setModel(model);
      }
   }
}