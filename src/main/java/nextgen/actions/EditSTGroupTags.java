package nextgen.actions;

public class EditSTGroupTags extends nextgen.actions.TransactionAction {
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public EditSTGroupTags(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Edit tags");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Tags", stGroup.getTags(""), tags -> {
         stGroup.setTags(tags);
         nextgen.events.STGroupTagsChanged.post(stGroup);
      });
   }

}