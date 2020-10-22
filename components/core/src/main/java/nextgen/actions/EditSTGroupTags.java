package nextgen.actions;

public class EditSTGroupTags extends TransactionAction {

   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public EditSTGroupTags(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
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