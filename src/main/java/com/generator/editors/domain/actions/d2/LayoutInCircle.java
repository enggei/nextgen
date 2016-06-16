package com.generator.editors.domain.actions.d2;

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
public class LayoutInCircle<E extends Enum<E>, R extends Enum<R >, G extends GraphNode2D<E>, D extends GraphEditor2D<E,R,G>> extends GraphEditorAction<E, R, G, D> {

    private final boolean outgoing;
    private final boolean horizontal;

    public LayoutInCircle(boolean outgoing, D editor, boolean horizontal) {
        super("Layout-Circle by " + (outgoing ? "Outgoing" : "Incoming"), editor);
        this.outgoing = outgoing;
        this.horizontal = horizontal;
    }

    @Override
    public void doAction(Transaction tx) {
        circleSelectedNodes();
    }

    public void circleSelectedNodes() {
        final Set<G> selectedNodes = editor.getSelectedGraphNodes();
        if (selectedNodes.isEmpty()) return;

        final Set<G> rendered = new LinkedHashSet<>();
        final double arcLength = 2 * Math.PI;
        final double angle = horizontal ? Math.PI : (Math.PI / 2);
        for (G node : selectedNodes) {
            circleNode(outgoing, rendered, node, node.centerX(), node.centerY(), 100, angle, arcLength, 1, editor);
        }
    }

    protected void circleNode(boolean isOutgoing, Set<G> rendered, G node, int centerX, int centerY, int radius, double startAngle, double arcLength, int level, D editor) {

        if (rendered.contains(node)) return;
        rendered.add(node);

        // todo: currently, this is an expanding-only calculation (skews the arc-size). Its better to go back down, and assign archs after all nodes have been accounted for, like

        final Set<GraphRelation> children = isOutgoing ? node.getOutgoing() : node.getIncoming();
        int totalChildren = 0;
        for (GraphRelation relation : children) {
            final G child = (G) relation.getOther(node);
            totalChildren += rendered.contains(child) ? 0 : ((isOutgoing ? child.getOutgoing() : child.getIncoming()).size() + 1);
        }

        double currentArc = startAngle;
        for (GraphRelation rel : children) {
            final G child = (G) rel.getOther(node);
            if (rendered.contains(child)) continue;

            final double childProportion = (double) ((isOutgoing ? child.getOutgoing() : child.getIncoming()).size() + 1) / (double) totalChildren;
            double childRadians = (arcLength * childProportion);
            final double sin = Math.sin(currentArc + (childRadians / 2));
            final double cos = Math.cos(currentArc + (childRadians / 2));

            child.setCenterX(Math.max(0, Math.min(editor.getWidth(), centerX + (int) (radius * sin))));
            child.setCenterY(Math.max(0, Math.min(editor.getHeight(), centerY + (int) (radius * cos))));

            circleNode(isOutgoing, rendered, child, centerX, centerY, radius + 100, currentArc, childRadians, level + 1, editor);

            currentArc += childRadians;
        }
    }
}