package com.generator.editors.canvas;

import org.piccolo2d.PNode;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * goe on 11/16/16.
 */
public abstract class BasePNode<N extends PNode> extends PDragSequenceEventHandler implements PropertyChangeListener {

   public final UUID uuid;
   public final N pNode;
   protected final String type;

   private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

   static final String NODE_SELECTED = "nodeSelected";
   static final String NODE_UNSELECTED = "nodeUnSelected";
   public final AtomicBoolean selected = new AtomicBoolean(false);

   static final String NODE_HIGHLIGHTED = "nodeHighlighted";
   static final String NODE_UNHIGHLIGHTED = "nodeUnHighlighted";
   private final AtomicBoolean highlighted = new AtomicBoolean(false);

   static final String NODE_ADDED = "nodeAdded";
   static final String NODE_REMOVED = "nodeRemoved";

   private final BaseEditor<?, ?> editor;

   private static final Random random = new Random(System.currentTimeMillis());

   public BasePNode(UUID uuid, N pNode, String type, BaseEditor editor) {
      this.uuid = uuid;
      this.pNode = pNode;
      this.type = type;
      System.out.print("new.node(" + type + ").uuid = " + uuid);

      this.editor = editor;

      getEventFilter().setMarksAcceptedEventsAsHandled(true);

      pNode.addInputEventListener(this);
      pNode.addPropertyChangeListener(this);
   }

   public abstract void onSelect();

   public abstract void onUnselect();

   public abstract void onStartHighlight();

   public abstract void onEndHighlight();

   public abstract void showNodeActions(JPopupMenu pop, PInputEvent event);

   public abstract void showTargetActions(JPopupMenu pop, PInputEvent event);

   public abstract void expand();

   public abstract void showDependents();

   public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
      changeSupport.addPropertyChangeListener(propertyChangeListener);
   }

   final void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
      changeSupport.removePropertyChangeListener(propertyChangeListener);
   }

   public String getNodeType() {
      return type;
   }

   protected Point2D getCenterPosition() {
      return pNode.getFullBoundsReference().getCenter2D();
   }

   protected Point2D getRandomPosition() {
      final Point2D centerPosition = getCenterPosition();
      final double randomX = centerPosition.getX() + ((random.nextBoolean() ? 1 : -1) * random.nextInt(50));
      final double randomY = centerPosition.getY() + ((random.nextBoolean() ? 1 : -1) * random.nextInt(50));
      final Point2D.Double randomPosition = new Point2D.Double(randomX, randomY);
      System.out.println(getCenterPosition() + " vs " + randomPosition);
      return randomPosition;
   }

   public final BasePNode setOffset(Point2D point) {
      pNode.setOffset(point);
      return this;
   }

   public final void setOffset(PInputEvent event) {
      pNode.setOffset(event.getCanvasPosition());
   }

   public void renderTo(JTextComponent textArea) {
      textArea.setText(uuid + " " + type);
      textArea.setCaretPosition(0);
   }

   public final void select() {
      if (selected.get()) {
         editor.selectOutgoing(this);
         return;
      }
      selected.set(true);
      onSelect();
      changeSupport.firePropertyChange(NODE_SELECTED, false, true);
   }

   public final void unselect() {
      if (!selected.get()) return;
      selected.set(false);
      onUnselect();
      changeSupport.firePropertyChange(NODE_UNSELECTED, true, false);
   }

   @Override
   public final void mouseEntered(PInputEvent event) {
      highlighted.set(true);

      event.getInputManager().setKeyboardFocus(this);

      onStartHighlight();
      changeSupport.firePropertyChange(NODE_HIGHLIGHTED, false, true);
   }

   @Override
   public final void mouseExited(PInputEvent event) {
      highlighted.set(false);

      onEndHighlight();
      event.getInputManager().setKeyboardFocus(this);
      changeSupport.firePropertyChange(NODE_UNHIGHLIGHTED, true, false);
   }

   @Override
   public void mouseClicked(PInputEvent event) {

      if (event.isLeftMouseButton()) {

         if (selected.get())
            unselect();
         else
            select();

         event.getInputManager().setKeyboardFocus(this);

      } else if (event.isRightMouseButton()) {

         final JPopupMenu pop = new JPopupMenu();

         // show target-actions if editor.mousePositionNode is active, show specific node-actions if not
         if (editor.mousePositionNode.isShowing.get()) {
            showTargetActions(pop, event);
            editor.clearMousePosition();
         } else
            showNodeActions(pop, event);

         pop.show(editor.canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
      }
   }

   @Override
   public final void mouseMoved(PInputEvent event) {
   }

   @Override
   protected final void startDrag(PInputEvent event) {
      super.startDrag(event);
   }

   @Override
   protected final void drag(PInputEvent event) {
      super.drag(event);
      pNode.translate(event.getDelta().width, event.getDelta().height);
   }

   @Override
   protected final void endDrag(PInputEvent event) {
      super.endDrag(event);
   }

   @Override
   protected final boolean shouldStartDragInteraction(PInputEvent event) {
      return super.shouldStartDragInteraction(event);
   }

   @Override
   protected final void dragActivityFirstStep(PInputEvent event) {

   }

   @Override
   protected final void dragActivityStep(PInputEvent event) {

   }

   @Override
   protected final void dragActivityFinalStep(PInputEvent event) {

   }

   @Override
   public final void keyboardFocusGained(PInputEvent event) {
   }

   @Override
   public final void keyboardFocusLost(PInputEvent event) {
   }

   @Override
   public final void propertyChange(PropertyChangeEvent evt) {

      switch (evt.getPropertyName()) {

         case PNode.PROPERTY_PARENT: {
            SwingUtilities.invokeLater(() -> {
               if (evt.getOldValue() != null) {   // pnode removed
                  pNode.removePropertyChangeListener(BasePNode.this);
                  changeSupport.firePropertyChange(NODE_REMOVED, true, false);
               } else {   // pnode added
                  changeSupport.firePropertyChange(NODE_ADDED, false, true);
               }
            });
            break;
         }

         case PNode.PROPERTY_FULL_BOUNDS:
            editor.nodeMoved(uuid);
            break;

         case PNode.PROPERTY_TRANSFORM:
            break;

         default:
//					System.out.println(uuid + " = " + evt.getPropertyName());
            break;
      }
   }

   @Override
   protected final void finalize() throws Throwable {
      System.out.println("gc.node.uuid = " + uuid);
      super.finalize();
   }

   @Override
   public String toString() {
      return type;
   }
}