package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Transaction;

import java.awt.event.MouseEvent;
import java.util.Collection;

/**
 * goe on 3/4/15.
 */
public class LayoutInGrid<E extends Enum<E>, R extends Enum<R>, G extends GraphNode2D<E>, D extends GraphEditor2D<E, R, G>> extends GraphEditorAction<E, R, G, D> {

    private final MouseEvent last;
    private final boolean horizontal;

    public LayoutInGrid(D editor, MouseEvent last, boolean horizontal) {
        super("Grid", editor);
        this.last = last;
        this.horizontal = horizontal;
    }

    @Override
    public void doAction(Transaction tx) {

        final int width = editor.getWidth();
        final int height = editor.getHeight();
        final Collection<G> selectedNodes = editor.getSelectedGraphNodes().isEmpty() ? editor.visibleNodes() : editor.getSelectedGraphNodes();

        final int hMargin = 10;
        final int vMargin = 10;

        int x = last == null ? 10 : last.getX();
        int y = last == null ? 10 : last.getY();
        for (G node : selectedNodes) {

            node.setCenterX(x);
            node.setCenterY(y);

            if (horizontal) {
                int cellWidth = node.width();
                x += cellWidth + hMargin;
                if ((x + cellWidth) >= width) {
                    x = last == null ? 10 : last.getX();
                    y += cellWidth + vMargin;
                }

            } else {
                int cellHeight = node.height();

                y += cellHeight + vMargin;
                if ((y + cellHeight) >= height) {
                    y = last == null ? 10 : last.getY();
                    x += cellHeight + hMargin;
                }
            }
        }
    }
}
