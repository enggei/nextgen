package com.generator.editors.domain.editors;

import javax.swing.*;
import java.awt.*;

/**
* goe on 6/9/15.
*/
public final class CommandPanel extends JPanel {

    public CommandPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
    }

    public void addCommand(Action action) {
        add(new JButton(action));
    }
}
