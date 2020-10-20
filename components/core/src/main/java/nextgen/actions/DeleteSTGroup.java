package nextgen.actions;

public class DeleteSTGroup extends TransactionAction {

   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public DeleteSTGroup(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Delete");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.confirm(owner, "Delete").ifPresent(aBoolean -> appModel().doLaterInTransaction(t -> appModel().delete(stGroup)));
   }
}