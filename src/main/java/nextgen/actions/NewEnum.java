package nextgen.actions;

public class NewEnum extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewEnum(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Enum");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Enum", s ->
      		nextgen.utils.STModelUtil.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      			final nextgen.model.STEnum stEnum = appModel().db.newSTEnum().setName(s);
      			stGroup.addEnums(stEnum);
      			nextgen.events.NewSTEnum.post(stGroup, stEnum);
      		}));
   }

}