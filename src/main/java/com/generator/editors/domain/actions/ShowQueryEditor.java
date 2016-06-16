package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.editors.graph.QueryEditor;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;

/**
 * goe on 5/14/15.
 */
public class ShowQueryEditor<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E, R, G>> extends GraphEditorAction<E, R, G, D> {

	public ShowQueryEditor(D editor) {
		super("Show Query", editor);
	}

	@Override
	public void doAction(Transaction tx) {
		final QueryEditor<E, R> dialog = new QueryEditor<>(editor);
		SwingUtilities.invokeLater(() -> {
			dialog.pack();
			dialog.setLocationRelativeTo(editor);
			dialog.setVisible(true);
		});
	}
}
