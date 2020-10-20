package nextgen.actions;

public class AddChildrenToTemplate extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;
   private final java.util.Set<nextgen.st.domain.STTemplate> children;
   private final javax.swing.JComponent owner;

	public AddChildrenToTemplate(String name, nextgen.st.domain.STTemplate stTemplate, java.util.Set<nextgen.st.domain.STTemplate> children, javax.swing.JComponent owner) {
      super(name);
      this.stTemplate = stTemplate;
      this.children = children;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      if (!nextgen.utils.SwingUtil.showConfirmDialog(owner, "Sure to move ?")) return;
            javax.swing.SwingUtilities.invokeLater(() -> appModel().setParent(stTemplate, children));
   }
}