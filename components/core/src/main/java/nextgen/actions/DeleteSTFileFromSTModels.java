package nextgen.actions;

public class DeleteSTFileFromSTModels extends TransactionAction {


   private final java.util.List<nextgen.st.model.STModel> stModels;
   private final javax.swing.JComponent owner;

	public DeleteSTFileFromSTModels(java.util.List<nextgen.st.model.STModel> stModels, javax.swing.JComponent owner) {
		super("Delete Filesinks");
		this.stModels = stModels;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("DeleteSTFileFromSTModels");
      System.out.println("DeleteSTFileFromSTModels");
      System.out.println("DeleteSTFileFromSTModels");
      confirm(owner, "Delete", unused -> {
         for (nextgen.st.model.STModel stModel : stModels) {
            stModel.getFiles().forEach(stFile -> {
               final String uuid = stFile.getUuid();
               final nextgen.st.model.STFile found = appModel().db.findSTFileByUuid(uuid);
               if (found != null) appModel().db.delete(found.getNode());
               nextgen.events.STFileDeleted.post(uuid);      
            });
         }
      });
   }
}