package com.generator.editors.domain.editors;

import javax.swing.*;

/**
* goe on 6/9/15.
*/
public interface EditorComponent {

    JComponent editor();

    void setValue(Object value);

    void commit();
}
