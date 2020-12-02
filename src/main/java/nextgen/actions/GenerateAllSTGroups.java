package nextgen.actions;

public class GenerateAllSTGroups extends nextgen.actions.TransactionAction {
   private final javax.swing.JComponent owner;

	public GenerateAllSTGroups(javax.swing.JComponent owner) {
		super("Generate all");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().db.findAllSTGroupModel().forEach(stGroupModel -> new GenerateSTGroup(owner, stGroupModel).actionPerformed(actionEvent, transaction));
   }

}