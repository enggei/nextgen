package com.generator.editors.domain.editors;

import javax.swing.*;

/**
* goe on 6/9/15.
*/
public abstract class TextEditorComponent implements EditorComponent {

    final JTextField delegate = new JTextField(30);

    @Override
    public JComponent editor() {
        return delegate;
    }

    @Override
    public void setValue(Object property) {
        delegate.setText(property == null || "[]".equals(property.toString()) ? "" : property.toString());
    }
}
