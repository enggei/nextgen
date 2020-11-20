package nextgen.st;

import nextgen.st.model.STModel;

import java.awt.*;

public class STModelEditor extends AbstractEditor {

   private final STModelEditorText txtEditor = new nextgen.st.STModelEditorText();
   private final STModelEditorGrid editorGrid = new STModelEditorGrid();
   private final STModelEditorForm formComponent = new STModelEditorForm();
   private final STModel stModel;
   private final String uuid;

   public STModelEditor(STModel stModel) {

      this.stModel = stModel;
      this.uuid = stModel.getUuid();

      final javax.swing.JTabbedPane editors = new javax.swing.JTabbedPane();
      editors.add("Editor", txtEditor);
      editors.add("Values", editorGrid);
      editors.add("Form", formComponent);
      add(editors, BorderLayout.CENTER);

      txtEditor.setStModel(stModel);
      formComponent.setModel(stModel);
      editorGrid.setModel(stModel);
      org.greenrobot.eventbus.EventBus.getDefault().register(this);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      nextgen.st.STModelEditor that = (nextgen.st.STModelEditor) o;
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
      if(stModel.equals(event.stModel)) {
         txtEditor.setStModel(event.stModel);
         formComponent.setModel(event.stModel);
         editorGrid.setModel(event.stModel);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onSTModelChanged(nextgen.events.STModelChanged event) {
      if(stModel.equals(event.model)) {
         txtEditor.setStModel(stModel);
         formComponent.setModel(stModel);
         editorGrid.setModel(stModel);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onNewSTArgument(nextgen.events.NewSTArgument event) {
      if(stModel.equals(event.model)) {
         txtEditor.setStModel(stModel);
         formComponent.setModel(stModel);
         editorGrid.setModel(stModel);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onSTArgumentChanged(nextgen.events.STArgumentChanged event) {
      if(stModel.equals(event.stModel)) {
         txtEditor.setStModel(stModel);
         formComponent.setModel(stModel);
         editorGrid.setModel(stModel);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onSTArgumentDeleted(nextgen.events.STArgumentDeleted event) {
      if(stModel.equals(event.stModel)) {
         txtEditor.setStModel(stModel);
         formComponent.setModel(stModel);
         editorGrid.setModel(stModel);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onNewSTKVArgument(nextgen.events.NewSTKVArgument event) {
      if(stModel.equals(event.model)) {
         txtEditor.setStModel(stModel);
         formComponent.setModel(stModel);
         editorGrid.setModel(stModel);
      }
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onKVDeleted(nextgen.events.KVDeleted event) {
      if(stModel.equals(event.stModel)) {
         txtEditor.setStModel(stModel);
         formComponent.setModel(stModel);
         editorGrid.setModel(stModel);
      }
   }

   public STModel getModel() {
      return stModel;
   }
}