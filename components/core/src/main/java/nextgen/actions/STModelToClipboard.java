package nextgen.actions;

public class STModelToClipboard extends TransactionAction {


   private final nextgen.st.model.STModel stModel;

	public STModelToClipboard(nextgen.st.model.STModel stModel) {
		super("To Clipboard");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("STModelToClipboard");
      nextgen.utils.SwingUtil.toClipboard(appModel().render(stModel));
   }
}