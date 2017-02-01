package com.generator.generators.project;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.domain.DomainPNode;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created 10.01.17.
 */
class ProjectDomainPNode extends DomainPNode<PText> {

   ProjectDomainPNode(Node node, ProjectDomain.LABELS nodeType, String property, String[] defaultColor, NeoEditor editor) {
      super(node, new PText(node.getProperty(property).toString()), nodeType, defaultColor, editor);
   }

   @Override
   public void showNodeActions(JPopupMenu pop, PInputEvent event) {

      pop.add(new NeoEditor.TransactionAction("Render ", editor.getGraph(), editor.canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         }
      });

      super.showNodeActions(pop, event);
   }
}