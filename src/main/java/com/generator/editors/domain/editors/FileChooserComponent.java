package com.generator.editors.domain.editors;

import com.generator.util.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * goe on 7/7/15.
 */
public abstract class FileChooserComponent extends JPanel implements EditorComponent {

	protected final JTextField txtPath = new JTextField(30);

	public FileChooserComponent(String file) {
		super(new FlowLayout());

		final boolean emptyFile = file == null || file.length() == 0;
		txtPath.setText(emptyFile ? System.getProperty("user.home") : file);

		add(txtPath);
		add(new JButton(new AbstractAction("...") {
			@Override
			public void actionPerformed(ActionEvent e) {
				final File newPath = SwingUtil.showOpenDir(FileChooserComponent.this, emptyFile ? System.getProperty("user.home") : new File(txtPath.getText()).getParent());
				if (newPath == null) return;
			}
		}));

	}

	@Override
	public JComponent editor() {
		return this;
	}

	@Override
	public void setValue(Object property) {
		txtPath.setText(property == null || "[]".equals(property.toString()) ? "" : property.toString());
	}
}