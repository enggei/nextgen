package com.generator.editors.canvas;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static com.generator.editors.canvas.BasePNode.*;

/**
 * goe on 12/29/16.
 */
public class NeoPNodeRenderPanel extends JPanel implements PropertyChangeListener {

   private BasePNode currentBaseNode;

   public final JTextArea txtEditor = new JTextArea(25, 85);
   final JTabbedPane editors = new JTabbedPane();

   public NeoPNodeRenderPanel() {
      super(new BorderLayout());

      txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
      txtEditor.setTabSize(3);
      txtEditor.setEditable(false);

      add(editors, BorderLayout.CENTER);
      editors.add("Default", new JScrollPane(txtEditor));

      txtEditor.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (!SwingUtilities.isRightMouseButton(e)) return;

            SwingUtilities.invokeLater(() -> {
               final JPopupMenu pop = new JPopupMenu();
               pop.add(new AbstractAction("Add to Clipboard") {
                  @Override
                  public void actionPerformed(ActionEvent e1) {
                     SwingUtil.toClipboard(txtEditor.getText().trim());
                  }
               });

               if (currentBaseNode instanceof NeoPNode) {
                  final NeoPNode neoPNode = (NeoPNode) NeoPNodeRenderPanel.this.currentBaseNode;
                  final NeoEditor editor = neoPNode.getEditor();
                  editor.doInTransaction(tx -> {

                     for (String key : neoPNode.node.getPropertyKeys()) {
                        if (NeoModel.TAG_UUID.equals(key)) continue;
                        pop.add((new NeoEditor.TransactionAction("Remove " + key, editor) {
                           @Override
                           public void actionPerformed(ActionEvent e12, Transaction tx) throws Exception {
                              neoPNode.node.removeProperty(key);
                              neoPNode.renderTo(txtEditor);
                              neoPNode.updateView();
                           }
                        }));
                     }

                     for (Relationship outgoing : neoPNode.node.getRelationships(Direction.OUTGOING)) {
                        pop.add((new NeoEditor.TransactionAction("Remove " + outgoing.getType() + " -> " + NeoModel.uuidOf(BaseDomainVisitor.other(neoPNode.node, outgoing)), editor) {
                           @Override
                           public void actionPerformed(ActionEvent e12, Transaction tx) throws Exception {

                              if (!SwingUtil.showConfirmDialog(editor.getCanvas(), "Remove relation\n" + "-> (" + outgoing.getType() + ") -> " + NeoModel.debugNode(BaseDomainVisitor.other(neoPNode.node, outgoing))))
                                 return;
                              outgoing.delete();
                              neoPNode.renderTo(txtEditor);
                              neoPNode.updateView();
                           }
                        }));
                     }
                  });
               }

               pop.show(txtEditor, e.getX(), e.getY());
            });
         }
      });

   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {

      switch (evt.getPropertyName()) {
         case BasePNode.NODE_HIGHLIGHTED: {
            currentBaseNode = (BasePNode) evt.getNewValue();
            currentBaseNode.renderTo(this);
            break;
         }

         case BasePNode.NODE_UNHIGHLIGHTED: {
            //System.out.println(NODE_UNHIGHLIGHTED + " : " + currentBaseNode.getNodeType());
            break;
         }

         case NODE_SELECTED: {
            //System.out.println(NODE_SELECTED + " : " + currentBaseNode.getNodeType());
            break;
         }

         case NODE_UNSELECTED: {
            //System.out.println(NODE_UNSELECTED + " : " + currentBaseNode.getNodeType());
            break;
         }

         case NODE_ADDED: {
            //System.out.println(NODE_ADDED + " : " + currentBaseNode.getNodeType());
            break;
         }

         case NODE_REMOVED: {
            //System.out.println(NODE_REMOVED + " : " + currentBaseNode.getNodeType());
            break;
         }
      }
   }
}