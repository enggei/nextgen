package com.generator.generators.vertx;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.easyFlow.EasyFlowDomain;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.util.Collection;

import static com.generator.editors.BaseDomainVisitor.hasLabel;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.easyFlow.EasyFlowDomain.Entities.Event;

/**
 * Created 28.04.17.
 */
public class VertxDomainImpl extends VertxDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {
      domainMenu.add(editor.newAddNodeAction(Entities.Server, Properties.port.name(),event ));
   }

   @Override
   protected NeoPNode newServerPNode(Node node, NeoEditor editor) {
      return new ServerPNode(node,editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(editor.newAddNodeAction(Entities.Verticle, Properties.name.name(),Relations.VERTICLES, this,event ));
            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {

            final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
            if (selectedNodes.size() != 1) return;

            final Node selectedNode = selectedNodes.iterator().next().node;
            if (!selectedNode.hasLabel(Entities.Verticle)) return;

            pop.add(new NeoEditor.TransactionAction("Add", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Relationship newRelation = node.createRelationshipTo(selectedNode, Relations.VERTICLES);
                  editor.addRelation(newRelation);
                  updateView();
               }
            });
            super.showTargetActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newVerticlePNode(Node node, NeoEditor editor) {
      return new VerticlePNode(node,editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newRouterPNode(Node node, NeoEditor editor) {
      return new RouterPNode(node,editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }
}