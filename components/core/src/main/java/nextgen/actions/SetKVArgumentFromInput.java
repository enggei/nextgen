package nextgen.actions;

public class SetKVArgumentFromInput extends TransactionAction {

   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.domain.STParameterKey stParameterKey;
   private final javax.swing.JComponent owner;

	public SetKVArgumentFromInput(String name, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, javax.swing.JComponent owner) {
      super(name);
      this.stArgument = stArgument;
      this.stParameterKey = stParameterKey;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.showInputDialog(stParameterKey.getName(), owner, inputValue -> appModel().doLaterInTransaction(transaction1 -> appModel().set(stArgument, stParameterKey, inputValue)));
   }
}