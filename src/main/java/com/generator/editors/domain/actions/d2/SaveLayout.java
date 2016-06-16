package com.generator.editors.domain.actions.d2;

import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

/**
 * goe on 3/4/15.
 */
public class SaveLayout<E extends Enum<E>, R extends Enum<R>, G extends GraphNode2D<E>, D extends GraphEditor2D<E, R, G>> extends GraphEditorAction<E, R, G, D> {

    private final String name;

    public SaveLayout(D editor) {
        super("Save ...", editor);
        this.name = null;
    }

    public SaveLayout(D editor, String name) {
        super("Save " + name, editor);
        this.name = name;
    }

    @Override
    public void doAction(Transaction tx) {

        System.out.println(getClass().getName() + " : testing editor.disableKeyEvents()");

        editor.clearButtonsPressed();
        editor.disableKeyEvents();

        final String name = this.name == null ? SwingUtil.showInputDialog("Layout name", editor) : this.name;
        editor.enableKeyEvents();

        if (name == null || name.length() == 0) return;

        final Node node = editor.getDomain().saveLayoutWithName(name);

        for (Relationship relationship : node.getRelationships()) relationship.delete();
        for (GraphNode2D<E> graphNode : editor.visibleNodes()) {
            final Relationship relationship = node.createRelationshipTo(graphNode.node(), editor.getDomain().type("POSITION"));
            relationship.setProperty("x", graphNode.centerX());
            relationship.setProperty("y", graphNode.centerY());
        }
    }
}