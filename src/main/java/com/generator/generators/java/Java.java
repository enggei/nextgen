package com.generator.generators.java;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * goe on 4/6/15.
 */
public class Java {

    public static JavaDomainEditor newJavaDomainEditor(JavaDomain domain) {
        return new JavaDomainEditor(domain) {
            @Override
            public void rightClickNoSelect(MouseEvent e, JPopupMenu popupMenu) {
                super.rightClickNoSelect(e, popupMenu);
                popupMenu.add(new ParseJavaFileAction(this));
            }
        };
    }
}
