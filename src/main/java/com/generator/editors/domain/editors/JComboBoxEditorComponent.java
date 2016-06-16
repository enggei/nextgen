package com.generator.editors.domain.editors;

import javax.swing.*;
import java.util.Set;
import java.util.Vector;

/**
* goe on 6/9/15.
*/
public abstract class JComboBoxEditorComponent implements EditorComponent {

    final JComboBox<String> delegate;

    protected JComboBoxEditorComponent(String name, Set<String> legalValues) {
        this.delegate = new JComboBox<>(new Vector<>(legalValues));
        this.delegate.setName(name);
    }

    @Override
    public JComponent editor() {
        return delegate;
    }

    @Override
    public void setValue(Object property) {
        final String s = property == null || "[]".equals(property.toString()) ? null : property.toString();
        delegate.getModel().setSelectedItem(s);
    }
}
