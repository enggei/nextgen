package nextgen.actions;

public class CopyTemplate extends nextgen.actions.TransactionAction {


   private final nextgen.model.STTemplate stTemplate;

	public CopyTemplate(nextgen.model.STTemplate stTemplate) {
		super("Copy");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.toClipboard(stTemplate.getText());
   }

}