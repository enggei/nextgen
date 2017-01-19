package com.generator.editors.canvas.neo;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.BasePNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * goe on 11/16/16.
 */
public abstract class NeoPNode<N extends PNode> extends BasePNode<N> {

   protected final AtomicBoolean isExpanding = new AtomicBoolean(false);

   public final Node node;
   protected final NeoEditor editor;
   final Long neoId;

   protected NeoPNode(Node node, N representation, String type, NeoEditor editor) {
      super(NeoModel.uuidOf(node), representation, type, editor);
      if (node == null) throw new IllegalArgumentException("node cannot be null");
      this.neoId = node.getId();
      this.editor = editor;
      this.node = node;
      System.out.println(" (" + NeoModel.getNameOrLabelFrom(node) + ")");
   }

   public abstract void updateView();

   @Override
   public void renderTo(JTextComponent textArea) {
      editor.doInTransaction(tx -> {
         textArea.setText("LABELS:\n" + BaseDomainVisitor.labelsFor(node) + "\n\nPROPERTIES:\n" + BaseDomainVisitor.printPropertiesFor(node, "\n"));
         textArea.setCaretPosition(0);
      });
   }

   @Override
   public void keyPressed(PInputEvent event) {
      switch (event.getKeyCode()) {

         case KeyEvent.VK_F:
            SwingUtilities.invokeLater(() -> editor.doInTransaction(tx -> {
               select();
               editor.canvas.repaint();
            }));
            break;

         case KeyEvent.VK_R:
            SwingUtilities.invokeLater(() -> editor.doInTransaction(tx -> editor.retain(uuid)));
            break;

         case KeyEvent.VK_C:
            SwingUtilities.invokeLater(() -> editor.doInTransaction(tx -> {
               editor.removeNodeFromCanvas(uuid);
               editor.canvas.repaint();
            }));
            break;

         case KeyEvent.VK_E:

            if (isExpanding.get()) return;
            isExpanding.set(true);

            SwingUtilities.invokeLater(() -> editor.doInTransaction(tx -> {
               expand();
               isExpanding.set(false);
            }));
            break;

         case KeyEvent.VK_D:

            if (isExpanding.get()) return;
            isExpanding.set(true);

            SwingUtilities.invokeLater(() -> editor.doInTransaction(tx -> {
               showDependents();
               isExpanding.set(false);
            }));
            break;

         default:
            super.keyPressed(event);
            break;
      }
   }

   @Override
   public void mouseClicked(PInputEvent event) {

      if (event.isRightMouseButton()) {

         SwingUtilities.invokeLater(() -> editor.doInTransaction(tx -> {
            final JPopupMenu pop = new JPopupMenu();

            // show target-actions if editor.mousePositionNode is active, show specific node-actions if not
            if (editor.isMouseShowing()) {
               showTargetActions(pop, event);
               editor.clearMousePosition();
            } else
               showNodeActions(pop, event);

            pop.show(editor.canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
         }));

      } else if (event.isMiddleMouseButton()) {
         // if a single node is selected, and its not this node. Then apply any actions:
         if (editor.singleNodeSelected(uuid)) {
            SwingUtilities.invokeLater(() -> editor.doInTransaction(tx -> {
               final JPopupMenu pop = new JPopupMenu();
               showTargetActions(pop, event);
               pop.show(editor.canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
            }));
         }

      } else
         super.mouseClicked(event);
   }

   @Override
   public void showNodeActions(JPopupMenu pop, PInputEvent event) {

      final JMenu labelsMenu = new JMenu("Labels ");
      labelsMenu.add(addLabel());

      final JMenu addLabelMenu = new JMenu("Add");
      editor.graph.getGraphDb().getAllLabelsInUse().forEach(label -> {
         if (node.hasLabel(label)) return;
         addLabelMenu.add(addLabelToNode(label));
      });
      if (addLabelMenu.getMenuComponentCount() > 0) labelsMenu.add(addLabelMenu);

      final JMenu removeLabelMenu = new JMenu("Remove");
      node.getLabels().forEach(s -> removeLabelMenu.add(removeLabelFromNode(s)));
      if (removeLabelMenu.getMenuComponentCount() > 0) labelsMenu.add(removeLabelMenu);

      pop.add(labelsMenu);
      pop.addSeparator();

      final JMenu showSameLabelMenu = new JMenu("Get all");
      node.getLabels().forEach(s -> showSameLabelMenu.add(editor.showAllNodesByLabel(s, event)));
      if (showSameLabelMenu.getMenuComponentCount() > 0) pop.add(showSameLabelMenu);

      pop.addSeparator();
      pop.add(hideNode());
      if (editor.hasLayerNodes()) pop.add(retainNode());

      pop.add(deleteNode());
   }

   @Override
   public void showTargetActions(JPopupMenu pop, PInputEvent event) {
   }

   private Action addLabel() {
      return new NeoEditor.TransactionAction("New", editor.graph, editor.canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String label = SwingUtil.showInputDialog("Label", editor.canvas);
            if (label == null) return;

            node.addLabel(Label.label(label));
            updateView();
            editor.canvas.repaint();
         }
      };
   }

   private Action addLabelToNode(final Label label) {
      return new NeoEditor.TransactionAction(label.name(), editor.graph, editor.canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            node.addLabel(label);
            updateView();
            editor.canvas.repaint();
         }
      };
   }

   private Action removeLabelFromNode(final Label lbl) {
      return new NeoEditor.TransactionAction(lbl.name(), editor.graph, editor.canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            node.removeLabel(lbl);
            updateView();
            editor.canvas.repaint();
         }
      };
   }

   protected Action hideNode() {
      return new NeoEditor.TransactionAction("Hide", editor.graph, editor.canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            editor.removeNodeFromCanvas(uuid);
         }
      };
   }

   protected Action retainNode() {
      return new NeoEditor.TransactionAction("Retain", editor.graph, editor.canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            editor.retain(uuid);
         }
      };
   }

   protected Action deleteNode() {
      return new NeoEditor.TransactionAction("Delete", editor.graph, editor.canvas) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            if (SwingUtil.showConfirmDialog(editor.canvas, "Delete " + NeoModel.getNameOrLabelFrom(node) + " ?"))
               editor.deleteNode(node);
         }
      };
   }
}