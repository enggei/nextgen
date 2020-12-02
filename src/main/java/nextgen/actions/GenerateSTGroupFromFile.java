package nextgen.actions;

public class GenerateSTGroupFromFile extends nextgen.actions.TransactionAction {
   private final nextgen.model.STGroupFile stGroupFile;
   private final javax.swing.JComponent owner;

	public GenerateSTGroupFromFile(nextgen.model.STGroupFile stGroupFile, javax.swing.JComponent owner) {
		super("Generate");
		this.stGroupFile = stGroupFile;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      stGroupFile.getIncomingFilesSTGroupModel().findFirst().ifPresent(stGroupModel -> {
      	final nextgen.model.parser.ParseResult parseResult = nextgen.st.STParser.parse(nextgen.st.STGenerator.toSTGroup(stGroupModel));

      	if (parseResult.getErrors().isEmpty()) {
      		final String packageName = stGroupFile.getPackageName().getValue();
      		final String path = stGroupFile.getPath().getValue();
      		new nextgen.st.STGenerator(appModel().getGeneratorSTGroup()).generateSTGroup(stGroupModel, packageName, path);

      	} else {
      		final StringBuilder errors = new StringBuilder();
      		parseResult.getErrors().forEach(stgError -> errors.append("\n").append(stgError.getType()).append(" ").append(stgError.getCharPosition()).append(" at line ").append(stgError.getLine()));
      		showError(owner, errors.toString());
      	}	
      });
   }

}