package nextgen.swing;

public class STValueEditorForm extends BaseEditor<nextgen.model.STValue> {

   public STValueEditorForm() {
      super(null);
      setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
   }

   @Override
   public void setModel(nextgen.model.STValue model) {
      super.setModel(model);

      clearEditor();
      if (model == null) return;

      final ColumnPanel center = new ColumnPanel();
      model.getNode().getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> {
         final org.neo4j.graphdb.Node startNode = relationship.getStartNode();
         if(nextgen.model.STModelNeoFactory.isSTFile(startNode)) center.append(new nextgen.swing.model.STFilePanel(new nextgen.model.STFile(startNode)));
      });

      add(nextgen.swing.ComponentFactory.newJScrollPane(center), java.awt.BorderLayout.CENTER);

      editorUpdated();
   }
}