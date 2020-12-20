package nextgen.swing;

public class SelectOrAddSTModelValue extends nextgen.swing.BaseEditor<nextgen.model.STValue> {

   private final nextgen.model.STTemplate stTemplate;
   private final javax.swing.JRadioButton radFromTemplate;
   private final javax.swing.JList<ListElement> lstModels;

   public SelectOrAddSTModelValue(nextgen.model.STTemplate stTemplate, java.util.List<nextgen.model.STModel> stModelList) {
      setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

      this.stTemplate = stTemplate;

      radFromTemplate = new javax.swing.JRadioButton("New " + stTemplate.getName(), true);

      lstModels = new javax.swing.JList<>();
      lstModels.setModel(new ListModel(stModelList));
      lstModels.addListSelectionListener(listSelectionEvent -> radFromTemplate.setSelected(false));

      add(radFromTemplate, java.awt.BorderLayout.NORTH);
      add(new javax.swing.JScrollPane(lstModels), java.awt.BorderLayout.CENTER);
   }

   @Override
   public String title() {
      return "Select or add New";
   }

   public nextgen.model.STValue getSTValue() {
      if (radFromTemplate.isSelected())
         return appModel().newSTValue(stTemplate);
      else
         return appModel().newSTValue(lstModels.getSelectedValue().stModel);

   }

   private final class ListElement {

      private final nextgen.model.STModel stModel;
      private final String text;

      public ListElement(nextgen.model.STModel stModel) {
         this.stModel = stModel;
         this.text = appModel().render(stModel, 100);
      }

      @Override
      public String toString() {
         return text;
      }
   }

   private class ListModel extends javax.swing.AbstractListModel<ListElement> {

      private final java.util.List<ListElement> content = new java.util.ArrayList<>();

      public ListModel(java.util.List<nextgen.model.STModel> stModelList) {
         stModelList.forEach(stModel -> content.add(new nextgen.swing.SelectOrAddSTModelValue.ListElement(stModel)));
      }

      @Override
      public int getSize() {
         return content.size();
      }

      @Override
      public nextgen.swing.SelectOrAddSTModelValue.ListElement getElementAt(int i) {
         return content.get(i);
      }
   }
}