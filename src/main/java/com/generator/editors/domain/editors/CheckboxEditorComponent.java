package com.generator.editors.domain.editors;

import javax.swing.*;

/**
* goe on 6/9/15.
*/
public abstract class CheckboxEditorComponent implements EditorComponent {

    final JCheckBox delegate = new JCheckBox();

    protected CheckboxEditorComponent(String name) {
        this.delegate.setText(name);
    }

    @Override
    public JComponent editor() {
        return delegate;
    }

    @Override
    public void setValue(Object property) {
        final String s = (property == null || "[]".equals(property.toString())) ? "" : property.toString().toLowerCase();
        delegate.setSelected(Boolean.valueOf(s));
    }
}
