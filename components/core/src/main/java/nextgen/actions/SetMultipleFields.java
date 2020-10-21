package nextgen.actions;

public class SetMultipleFields extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;
   private final nextgen.st.model.STModel stModel;
   private final javax.swing.JComponent owner;

	public SetMultipleFields(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel, javax.swing.JComponent owner) {
		super("Set Fields");
		this.stTemplate = stTemplate;
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(t -> appModel().setMultiple(owner, stModel, stTemplate));
   }
}