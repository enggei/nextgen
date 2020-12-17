package nextgen.actions;

public class SetSTGroupLanguage extends nextgen.actions.TransactionAction {

   private final javax.swing.JComponent owner;
   private final nextgen.model.STGroupModel stGroup;

	public SetSTGroupLanguage(javax.swing.JComponent owner, nextgen.model.STGroupModel stGroup) {
		super("Set Language");
		this.owner = owner;
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("SetSTGroupLanguage" + " owner" + " stGroup");

      select(owner, appModel().getLanguageTypes(), stGroup::setLanguage);
   }

}