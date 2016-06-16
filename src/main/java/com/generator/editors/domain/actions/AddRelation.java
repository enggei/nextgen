package com.generator.editors.domain.actions;

import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.MetaRelation;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Transaction;

import java.util.Collections;
import java.util.Set;

/**
 * goe on 3/4/15.
 */
public class AddRelation<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D> {

    private final Set<G> sourceNodes;
    private final G targetNode;

    public AddRelation(Set<G> sourceNodes, G targetNode, D editor) {
        super("New Relation", editor);
        this.sourceNodes = sourceNodes;
        this.targetNode = targetNode;
    }

    @Override
    public void doAction(Transaction tx) {

        final Set<MetaNode<E>> sourceMetaNodes = editor.getMetaNodes(sourceNodes);
        final Set<MetaNode<E>> targetMetaNodes = editor.getDomain().getMetaNodes(Collections.singleton(targetNode.node()));
        final Set<MetaRelation<E, R>> relations = editor.getDomain().getMetaRelations(sourceMetaNodes, targetMetaNodes);

        editor.clearButtonsPressed();

        if (relations.size() == 0) {
            SwingUtil.showMessage("No relations allowed for this coupling", editor);
            return;
        }

        final MetaRelation<E, R> metaRelation = (relations.size() == 1) ? relations.iterator().next() : SwingUtil.showSelectDialog(editor, "Multiple Options", "Multiple Relations", relations, getRenderer());
        if (metaRelation == null) return;

        for (G sourceNode : sourceNodes) {
            editor.getDomain().relate(metaRelation.getName(), sourceNode.node(), targetNode.node());
            editor.updateRelationships(sourceNode);

        }
    }

    private SwingUtil.SelectRenderer<MetaRelation<E, R>> getRenderer() {
        return new SwingUtil.SelectRenderer<MetaRelation<E, R>>() {
            @Override
            public String render(MetaRelation<E, R> value) {
                return value.getName().name();
            }
        };
    }
}
