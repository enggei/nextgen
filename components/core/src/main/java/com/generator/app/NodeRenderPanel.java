package com.generator.app;

import com.generator.app.nodes.NeoNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created 04.12.17.
 */
public abstract class NodeRenderPanel extends JPanel {

   protected final JTextArea txtEditor = new JTextArea();

   public NodeRenderPanel(NeoNode neoNode) {
      super(new BorderLayout());

      txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
      txtEditor.setTabSize(3);
      txtEditor.setEditable(false);
      txtEditor.setText(render(neoNode.getNode()));
      txtEditor.setCaretPosition(0);


      addActionsTo(txtEditor, neoNode);

      add(new JScrollPane(txtEditor), BorderLayout.CENTER);
   }

   protected void addActionsTo(JTextArea txtEditor, NeoNode neoNode) {

      txtEditor.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
               JPopupMenu pop = new JPopupMenu();

               pop.add(new AbstractAction("Add to Clipboard") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     SwingUtil.toClipboard(txtEditor.getText());
                  }
               });

               pop.show(txtEditor, e.getX(), e.getY());
            }
         }
      });
   }

   protected abstract String render(Node node);
}