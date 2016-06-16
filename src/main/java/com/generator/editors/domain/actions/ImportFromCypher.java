package com.generator.editors.domain.actions;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.GraphNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;

/**
 * goe on 5/14/15.
 */
public class ImportFromCypher<E extends Enum<E>, R extends Enum<R >, G extends GraphNode<E>, D extends GraphEditor<E,R,G>> extends GraphEditorAction<E, R, G, D>  {

    public ImportFromCypher(D editor) {
        super("Import", editor);
    }

    @Override
    public void doAction(Transaction tx) {

        final JTextArea textArea = new JTextArea("");

        SwingUtil.showTextInput("Cypher-import", textArea, editor, new SwingUtil.OnSave() {
            @Override
            public void verifyAndSave() throws Exception {
                final String query = textArea.getText().trim();
                if (query.length() == 0) return;
                editor.getModel().query(query);
            }
        });
    }
}