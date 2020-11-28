package nextgen.actions;

public class GenerateSTGroupFromFile extends TransactionAction {


   private final nextgen.model.STGroupModel stGroup;
   private final nextgen.model.STGroupFile stGroupFile;
   private final javax.swing.JComponent owner;

	public GenerateSTGroupFromFile(nextgen.model.STGroupModel stGroup, nextgen.model.STGroupFile stGroupFile, javax.swing.JComponent owner) {
		super("Generate");
		this.stGroup = stGroup;
		this.stGroupFile = stGroupFile;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.st.parser.ParseResult parseResult = nextgen.st.STParser.parse(nextgen.st.STGenerator.toSTGroup(stGroup));

      if (parseResult.getErrors().isEmpty()) {
      	stGroupFile.getIncomingFilesSTGroupModel().forEach(stGroupModel -> {
      		final String packageName = stGroupFile.getPackageName();
      		final String path = stGroupFile.getPath();
      		appModel().getSTGenerator().generateSTGroup(stGroupModel, packageName, path);
      	});
      } else {
      	final StringBuilder errors = new StringBuilder();
      	parseResult.getErrors().forEach(stgError -> errors.append("\n").append(stgError.getType()).append(" ").append(stgError.getCharPosition()).append(" at line ").append(stgError.getLine()));
      	showError(owner, errors.toString());
      }
   }

}