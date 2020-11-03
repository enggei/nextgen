package nextgen.actions;

public class UndoDBTransaction extends TransactionAction {



	public UndoDBTransaction() {
		super("Undo");
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("UndoDBTransaction");
      System.out.println("UndoDBTransaction");
      System.out.println("UndoDBTransaction");
      appModel().undoLast();
   }
}