package com.generator.generators.math;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.util.NeoUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Set;

/**
 * Created 15.10.17.
 */
public class MathPlugin extends Plugin {

   public MathPlugin(App app) {
      super(app, "Math");
   }

   enum Entities implements Label {
      Value, Operator, Evaluator
   }

   enum Relations implements RelationshipType {
      Expression
   }

   enum Properties {

   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      menu.add(new App.TransactionAction("New Value", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            final Node newNode = getGraph().newNode(Entities.Value, AppMotif.Properties.name.name(), name);
            fireNodesLoaded(newNode);
         }
      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      if (NeoUtil.hasLabel(neoNode.getNode(), Entities.Value)) {
         pop.add(new App.TransactionAction("Add Operator", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", app);
               if (name == null || name.length() == 0) return;

               final Node newNode = getGraph().newNode(Entities.Operator, AppMotif.Properties.name.name(), name);
               NeoUtil.relate(neoNode.getNode(), newNode, Relations.Expression);
               fireNodesLoaded(newNode);
            }
         });
      }
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      return null;
   }
}