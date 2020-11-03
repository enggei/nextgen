package nextgen.actions;

public class ImportSTTemplate extends TransactionAction {


   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public ImportSTTemplate(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Import from stg-file");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("ImportSTTemplate");
      System.out.println("ImportSTTemplate");
      System.out.println("ImportSTTemplate");
      openFile(owner, file -> {
      	appModel().setLastDir(file.getParentFile());
      	appModel().doLaterInTransaction(t -> {
      		final String fileName = file.getName();
      		final String name = fileName.substring(0, fileName.indexOf("."));
      		final nextgen.st.domain.STTemplate stTemplate = appModel().newSTTemplate(name, nextgen.utils.FileUtil.readIntact(file), stGroup);
      		nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);
      	});
      });
   }
}