package com.generator.editors.domain.actions.d2;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.domain.MetaDomain;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * goe on 3/4/15.
 */
public class RelationMatrix<E extends Enum<E>, R extends Enum<R>, G extends GraphNode2D<E>, D extends GraphEditor2D<E, R, G>> extends GraphEditorAction<E, R, G, D> {

    private final Set<Node> nodes;

    public RelationMatrix(D editor) {
        super("Show Relation Matrix", editor);
        this.nodes = editor.getSelectedNodes();
    }

    @Override
    public void doAction(Transaction tx) {
        final RelationEditor dialog = new RelationEditor(editor.getDomain(), nodes);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dialog.pack();
                dialog.setLocationRelativeTo(editor);
                dialog.setVisible(true);
            }
        });
    }

    private class RelationEditor extends JDialog {

        private final RelationsEditorPanel editorPanel;

        public RelationEditor(MetaDomain<E, R> domain, Set<Node> nodes) {
            super(SwingUtil.getFrame(editor), "Relations", true);

            editorPanel = new RelationsEditorPanel(domain, nodes);

            add(editorPanel, BorderLayout.CENTER);

            final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton defaultButton;
            commandPanel.add(defaultButton = new JButton(new AbstractAction("Confirm") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        editorPanel.commit();
                        dispose();
                        editor.requestRepaint();
                    } catch (Exception e1) {
                        SwingUtil.showException(RelationEditor.this, e1);
                    }
                }
            }));
            commandPanel.add(new JButton(new AbstractAction("Cancel") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    editor.requestRepaint();
                }
            }));
            getRootPane().setDefaultButton(defaultButton);
            add(commandPanel, BorderLayout.SOUTH);
        }

        protected class RelationsEditorPanel extends GraphEditor2D<E, R, G> {

            private final Map<UUID, Node> nodeMap = new LinkedHashMap<>();

            public RelationsEditorPanel(MetaDomain<E, R> domain, Set<Node> nodes) {
                super(domain);

                int r = 35;
                int c = 35;
                for (Node node : nodes) {
                    nodeMap.put(BaseDomainVisitor.uuidOf(node), node);
                    getOrAdd(node).setCenterX(c).setCenterY(r);
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                final Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(getBackground());
                g2.fillRect(0, 0, getWidth(), getHeight());



            }

            public void commit() {

            }
        }
    }
}