package nextgen.actions;

public abstract class TransactionAction extends javax.swing.AbstractAction {

   protected TransactionAction(String name) {
      super(name);
   }

   @Override
   public void actionPerformed(java.awt.event.ActionEvent e) {
      javax.swing.SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> actionPerformed(e, transaction)));
   }

   protected abstract void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction);

   protected nextgen.st.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }
}