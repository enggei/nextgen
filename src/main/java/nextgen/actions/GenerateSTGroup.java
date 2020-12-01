package nextgen.actions;

public class GenerateSTGroup extends nextgen.actions.TransactionAction {


   private final javax.swing.JComponent owner;
   private final nextgen.model.STGroupModel stGroup;

	public GenerateSTGroup(javax.swing.JComponent owner, nextgen.model.STGroupModel stGroup) {
		super("Generate STGroup");
		this.owner = owner;
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.model.parser.ParseResult parseResult = nextgen.st.STParser.parse(nextgen.st.STGenerator.toSTGroup(stGroup));

      if (parseResult.getErrors().isEmpty()) {
         final nextgen.st.STGenerator stGenerator = new nextgen.st.STGenerator(appModel().getGeneratorSTGroup());
         stGroup.getFiles().forEach(stGroupFile -> {
            final String packageName = stGroupFile.getPackageName().getValue();
            final String path = stGroupFile.getPath().getValue();
            stGenerator.generateSTGroup(stGroup, packageName, path);
         });

      } else {
         final StringBuilder errors = new StringBuilder();
         parseResult.getErrors().forEach(stgError -> errors.append("\n").append(stgError.getType()).append(" ").append(stgError.getCharPosition()).append(" at line ").append(stgError.getLine()));
         showError(owner, errors.toString());
      }
   }

}