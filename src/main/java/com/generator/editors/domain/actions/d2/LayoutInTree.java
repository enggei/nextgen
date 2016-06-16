package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphRelation;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Transaction;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * goe on 3/4/15.
 */
public class LayoutInTree<E extends Enum<E>, R extends Enum<R>, G extends GraphNode2D<E>, D extends GraphEditor2D<E, R, G>> extends GraphEditorAction<E, R, G, D> {

    private final boolean outgoing;

    public LayoutInTree(boolean outgoing, D editor) {
        super("Layout-Tree by " + (outgoing ? "Outgoing" : "Incoming"), editor);
        this.outgoing = outgoing;
    }

    @Override
    public void doAction(Transaction tx) {
        treeLayoutNodes(outgoing, editor);
    }

    protected void treeLayoutNodes(boolean outgoing, GraphEditor<E, R, G> editor) {
        final Set<G> selectedNodes = editor.getSelectedGraphNodes();
        if (selectedNodes.isEmpty()) return;

        final Set<G> rendered = new LinkedHashSet<>();
        final G node = selectedNodes.iterator().next();
        treeLayoutNode(outgoing, rendered, node, node.centerX(), node.centerY(), editor.getWidth() - node.centerX(), editor);
    }

    protected void treeLayoutNode(boolean isOutgoing, Set<G> rendered, G node, double startX, int startY, double halfWidth, GraphEditor<E, R, G> editor) {

        if (rendered.contains(node)) return;
        rendered.add(node);

        node.setCenterX((int) Math.max(0, Math.min(editor.getWidth(), startX)));
        node.setCenterY(Math.max(0, Math.min(editor.getHeight(), startY)));

        final Set<GraphRelation> children = isOutgoing ? node.getOutgoing() : node.getIncoming();
        int totalChildren = 0;
        for (GraphRelation relation : children) {
            final G child = (G) relation.getOther(node);
            totalChildren += rendered.contains(child) ? 0 : ((isOutgoing ? child.getOutgoing() : child.getIncoming()).size() + 1);
        }

        double x = Math.max(0, startX - halfWidth);
        for (GraphRelation rel : children) {
            final G child = (G) rel.getOther(node);
            if (rendered.contains(child)) continue;

            final int count = (isOutgoing ? child.getOutgoing() : child.getIncoming()).size() + 1;
            final double childProportion = (double) count / (double) totalChildren;
            double childWidth = Math.max(halfWidth * 2 * childProportion, count * 60);
            treeLayoutNode(isOutgoing, rendered, child, x, startY + 100, childWidth / 2d, editor);
            x += childWidth;
        }
    }
}
