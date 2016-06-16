package com.generator.generators.templates.editors;

import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * goe on 1/7/16.
 */
public class TemplateRenderer extends JPanel {

    private final JLabel lblName = new JLabel();
    private final JTextArea txtEditor = new JTextArea();

    private TemplateStatement currentStatement;

    public TemplateRenderer() {
        super(new BorderLayout());

        lblName.setHorizontalAlignment(JLabel.CENTER);

        txtEditor.setFont(new Font("Courier New", Font.PLAIN, 10));
        txtEditor.setTabSize(3);
        txtEditor.setEditable(false);
        txtEditor.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
//                if (currentStatement == null) return;
//                if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
//                    tryToSaveStatement();
//                }
            }
        });


        final JScrollPane editorScroller = new JScrollPane(txtEditor);

        add(lblName, BorderLayout.NORTH);
        add(editorScroller, BorderLayout.CENTER);
    }

    public void setStatement(TemplateStatement statement) {
        SwingUtilities.invokeLater(() -> {

            currentStatement = statement;

			  if(statement==null) return;

            final String statementName = statement.getName();
            final Set<String> parameterNames = statement.getParameterNames();

            final JPanel inputPanel = new JPanel(new FlowLayout());
            for (String parameterName : parameterNames) {
                final TemplateParameter templateParameter = statement.getParameter(parameterName);

            }

            lblName.setText(statementName);


        });
    }
}