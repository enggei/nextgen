package nextgen.st;

import nextgen.st.model.STModel;

import javax.swing.*;
import java.awt.*;

public class STModelEditor extends JPanel {

   private final STModelEditorText txtEditor = new nextgen.st.STModelEditorText();
   private final STModelEditorGrid editorGrid = new STModelEditorGrid();
   private final STModelEditorForm formComponent = new STModelEditorForm();
   private final STModel stModel;
   private final String uuid;

   public STModelEditor(STModel stModel) {
      super(new BorderLayout());

      this.stModel = stModel;
      this.uuid = stModel.getUuid();
      setBackground(UIManager.getColor("Panel.background"));

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

   public String getUuid() {
      return uuid;
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onModelNavigatorSTModelTreeNodeClicked(nextgen.events.ModelNavigatorSTModelTreeNodeClicked event) {
      txtEditor.setStModel(event.stModel);
      formComponent.setModel(event.stModel);
      editorGrid.setModel(event.stModel);
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onModelNavigatorSTValueTreeNodeClicked(nextgen.events.ModelNavigatorSTValueTreeNodeClicked event) {
      txtEditor.setSTValue(event.stValue);
      formComponent.reset();
      editorGrid.reset();
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onSTModelChanged(nextgen.events.STModelChanged event) {
      if(stModel.equals(event.model)) {
         txtEditor.setStModel(stModel);
         formComponent.setModel(stModel);
         editorGrid.setModel(stModel);
      }
   }

   public STModel getModel() {
      return stModel;
   }
}