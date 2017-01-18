package com.generator.editors.canvas;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static com.generator.editors.canvas.BasePNode.*;

/**
 * goe on 12/29/16.
 */
public class BaseNodeRenderPanel extends JPanel implements PropertyChangeListener {

   private final JTextArea txtEditor = new JTextArea(25, 85);

   public BaseNodeRenderPanel() {
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
            final BasePNode basePNode = (BasePNode) evt.getNewValue();
            basePNode.renderTo(txtEditor);
            break;
         }

         case BasePNode.NODE_UNHIGHLIGHTED: {
            //System.out.println(NODE_UNHIGHLIGHTED + " : " + basePNode.getNodeType());
            break;
         }

         case NODE_SELECTED: {
            //System.out.println(NODE_SELECTED + " : " + basePNode.getNodeType());
            break;
         }

         case NODE_UNSELECTED: {
            //System.out.println(NODE_UNSELECTED + " : " + basePNode.getNodeType());
            break;
         }

         case NODE_ADDED: {
            //System.out.println(NODE_ADDED + " : " + basePNode.getNodeType());
            break;
         }

         case NODE_REMOVED: {
            //System.out.println(NODE_REMOVED + " : " + basePNode.getNodeType());
            break;
         }
      }
   }
}