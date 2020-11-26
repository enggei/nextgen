package nextgen.swing;

public class SelectOrAddNewModelPanel extends AbstractEditor {

   private final nextgen.st.model.STTemplate stTemplate;
   private final javax.swing.JRadioButton radFromTemplate;
   private final javax.swing.JList<ListElement> lstModels;

   public SelectOrAddNewModelPanel(java.util.List<nextgen.st.model.STModel> stModelList, nextgen.st.model.STTemplate stTemplate) {
      setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

      this.stTemplate = stTemplate;

      radFromTemplate = new javax.swing.JRadioButton("New " + stTemplate.getName(), true);

      lstModels = new javax.swing.JList<>();
      lstModels.setModel(new ListModel(stModelList));
      lstModels.addListSelectionListener(listSelectionEvent -> radFromTemplate.setSelected(false));

      add(radFromTemplate, java.awt.BorderLayout.NORTH);
      add(new javax.swing.JScrollPane(lstModels), java.awt.BorderLayout.CENTER);
   }

   public nextgen.st.model.STValue getSTValue() {
      if (radFromTemplate.isSelected()) {
         return appModel().db.newSTValue(appModel().db.newSTModel().setStTemplate(stTemplate));
      } else {
         return appModel().db.newSTValue(lstModels.getSelectedValue().stModel);
      }
   }

   private final class ListElement {

      private final nextgen.st.model.STModel stModel;
      private final String text;

      public ListElement(nextgen.st.model.STModel stModel) {
         this.stModel = stModel;
         this.text = appModel().render(stModel);
      }

      @Override
      public String toString() {
         return text;
      }
   }

   private class ListModel extends javax.swing.AbstractListModel<ListElement> {

      private final java.util.List<ListElement> content = new java.util.ArrayList<>();

      public ListModel(java.util.List<nextgen.st.model.STModel> stModelList) {
         stModelList.forEach(stModel -> content.add(new nextgen.swing.SelectOrAddNewModelPanel.ListElement(stModel)));
      }

      @Override
      public int getSize() {
         return content.size();
      }

      @Override
      public nextgen.swing.SelectOrAddNewModelPanel.ListElement getElementAt(int i) {
         return content.get(i);
      }
   }
}