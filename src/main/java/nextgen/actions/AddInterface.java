package nextgen.actions;

public class AddInterface extends nextgen.actions.TransactionAction {


   private final java.util.Set<nextgen.model.STTemplate> children;
   private final javax.swing.JComponent owner;

	public AddInterface(String name, java.util.Set<nextgen.model.STTemplate> children, javax.swing.JComponent owner) {
      super(name);
      this.children = children;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final javax.swing.JTextField txtImplements = newTextField();
      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 1));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      contentPanel.add(txtImplements);

      showDialog(owner, contentPanel, "Add interface", jDialog -> {
         final String interfaceName = txtImplements.getText().trim();
         if (interfaceName.length()==0) return;
         for (nextgen.model.STTemplate child : children) {
            final java.util.Optional<String> optional = child.getImplements().filter(s -> s.toLowerCase().equals(interfaceName.toLowerCase())).findAny();
            if(optional.isPresent()) continue;
            child.addImplements(interfaceName);
         }
         close(jDialog);   
      });
   }

}