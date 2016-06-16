package com.generator.editors.domain.editors;

import com.generator.editors.graph.GraphEditor;
import com.generator.util.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * goe on 6/9/15.
 */
public class NodeEditor<E extends Enum<E>> extends JDialog {

	public NodeEditor(final GraphEditor editor, E label, final NodePropertiesEditorPanel editorPanel) {
		super(SwingUtil.getFrame(editor), "Edit " + label, true);

		add(editorPanel, BorderLayout.CENTER);

		getRootPane().registerKeyboardAction(e -> {
				dispose();
				editor.requestRepaint();
				editor.enableKeyEvents();
			},
			KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
			JComponent.WHEN_IN_FOCUSED_WINDOW);

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
					SwingUtil.showException(NodeEditor.this, e1);
				}

				editor.enableKeyEvents();
			}
		}));
		commandPanel.add(new JButton(new AbstractAction("Cancel") {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				editor.requestRepaint();
				editor.enableKeyEvents();
			}
		}));
		getRootPane().setDefaultButton(defaultButton);
		add(commandPanel, BorderLayout.SOUTH);

		editor.disableKeyEvents();
	}
}