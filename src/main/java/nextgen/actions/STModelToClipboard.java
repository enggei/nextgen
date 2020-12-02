package nextgen.actions;

public class STModelToClipboard extends nextgen.actions.TransactionAction {
   private final nextgen.model.STModel stModel;

	public STModelToClipboard(nextgen.model.STModel stModel) {
		super("To Clipboard");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.toClipboard(appModel().render(stModel));
   }

}