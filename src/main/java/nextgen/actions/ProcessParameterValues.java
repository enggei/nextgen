package nextgen.actions;

public class ProcessParameterValues extends TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final javax.swing.JComponent parent;

   public ProcessParameterValues(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, javax.swing.JComponent parent) {
      super("Process values");
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.parent = parent;

   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("todo");
   }
}