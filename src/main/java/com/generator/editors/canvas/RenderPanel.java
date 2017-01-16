package com.generator.editors.canvas;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * goe on 12/29/16.
 */
public class RenderPanel extends JPanel implements PropertyChangeListener {

   private final JTextArea txtEditor = new JTextArea(25, 85);

   public RenderPanel() {
      super(new BorderLayout());

      txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
      txtEditor.setTabSize(3);
      txtEditor.setEditable(false);
      add(new JScrollPane(txtEditor), BorderLayout.CENTER);
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      switch (evt.getPropertyName()) {

         case BasePNode.NODE_HIGHLIGHTED: {
            ((BasePNode) evt.getNewValue()).renderTo(txtEditor);
         }
      }
   }
}