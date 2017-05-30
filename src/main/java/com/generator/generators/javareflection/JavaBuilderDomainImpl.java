package com.generator.generators.javareflection;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created 23.05.17.
 */
public class JavaBuilderDomainImpl extends JavaBuilderDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {

   }

   @Override
   protected NeoPNode newCLASSPNode(Node node, NeoEditor editor) {
      return new CLASSPNode(node,editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            //

            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newPACKAGEPNode(Node node, NeoEditor editor) {
      return super.newPACKAGEPNode(node, editor);
   }

   @Override
   protected NeoPNode newMETHODPNode(Node node, NeoEditor editor) {
      return super.newMETHODPNode(node, editor);
   }

   @Override
   protected NeoPNode newINSTANCEPNode(Node node, NeoEditor editor) {
      return new INSTANCEPNode(node,editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("New instance", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {




               }
            });

            super.showNodeActions(pop, event);
         }
      };
   }
}