package com.generator.editors.graph;

import com.generator.editors.domain.MetaDomain;
import com.generator.util.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * goe on 10/10/14.
 */
public abstract class GraphEditorAction<E extends Enum<E>, R extends Enum<R>, G extends GraphNode<E>, D extends GraphEditor<E, R, G>> extends AbstractAction implements MetaDomain.Committer {

    protected final D editor;

    protected GraphEditorAction(String name, D editor) {
        super(name);
        this.editor = editor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
				editor.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				editor.getDomain().commit(GraphEditorAction.this);
				editor.requestRepaint();
				editor.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		  });
    }

    @Override
    public void exception(Throwable throwable) {
        SwingUtil.showException(throwable, editor);
    }
}