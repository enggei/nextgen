package com.generator.app;

import com.generator.neo.NeoModel;
import com.generator.util.FormatUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created 15.07.17.
 */
public final class AppEvents {

   static final String GRAPH_NEW = "graph.new";

   static final String NODE_LOAD = "nodes.load";
   static final String NODE_HIGHLIGHTED = "node.highlighted";
   static final String NODES_CLOSED = "nodes.closed";
   static final String NODES_SELECTED = "nodes.selected";
   static final String NODES_DELETED = "nodes.deleted";
   static final String NODES_ADDED = "nodes.added";
   static final String NODE_COLOR_CHANGED = "nodes.color";
   static final String NODE_CHANGED = "node.";

   static final String LABELS_ASSIGNED = "labels.assigned";

   static final String RELATION_HIGHLIGHTED = "relation.highlighted";
   static final String RELATION_COLOR_CHANGED = "relations.color";
   static final String RELATIONS_CLOSED = "relation.closed";
   static final String RELATIONS_SELECTED = "relations.selected";
   static final String RELATIONS_DELETED = "relations.deleted";
   static final String RELATIONS_ADDED = "relations.added";

   static final String RELATION_PAINTSTRATEGY_CHANGED = "graph.relationPaintStrategy";
   static final String RELATION_PATHSTRATEGY_CHANGED = "graph.relationPathStrategy";
   static final String NODE_PAINTSTRATEGY_CHANGED = "graph.nodePaintStrategy";

   static final String UNDO_LAST_DELETE = "undo.delete";

   private final PropertyChangeSupport appChangeSupport;

   AppEvents(PropertyChangeSupport appChangeSupport) {
      this.appChangeSupport = appChangeSupport;
   }

   public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
      this.appChangeSupport.addPropertyChangeListener(property, listener);
   }

   public void removePropertyChangeListener(String property, PropertyChangeListener listener) {
      this.appChangeSupport.removePropertyChangeListener(property, listener);
   }

   public void firePropertyChange(String property) {
      this.appChangeSupport.firePropertyChange(property, false, true);
   }

   public void firePropertyChange(String property, Object value) {
      this.appChangeSupport.firePropertyChange(property, null, value);
   }

   public void firePropertyChange(String property, Object oldValue, Object value) {
      this.appChangeSupport.firePropertyChange(property, oldValue, value);
   }

   public static abstract class TransactionalPropertyChangeListener<O, N> implements PropertyChangeListener {

      protected final Component parent;
      private final App app;
      private final Class owner;

      TransactionalPropertyChangeListener(App app) {
         this(app.getClass(), app, app);
      }

      protected TransactionalPropertyChangeListener(Class owner, Component parent, App app) {
         this.parent = parent;
         this.app = app;
         this.owner = owner;
      }

      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         SwingUtilities.invokeLater(() -> {
            app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final long start = System.currentTimeMillis();
            System.out.println(owner.getSimpleName());
            app.model.graph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  propertyChange((O) evt.getOldValue(), (N) evt.getNewValue());
               }

               @Override
               public void exception(Throwable throwable) {
                  parent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  SwingUtil.showException(parent, throwable);
               }
            });
            System.out.println("\t " + (owner == null ? "?" : owner.getSimpleName()) + " " + evt.getPropertyName() + " " + FormatUtil.formatTime(System.currentTimeMillis() - start));
            app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

         });
      }

      protected abstract void propertyChange(O oldValue, N newValue);
   }

   static final class NodeLoadEvent {
      final Node node;
      final Point2D position;
      boolean centerOnScreen;

      NodeLoadEvent(Node node, Point2D position, boolean centerOnScreen) {
         this.node = node;
         this.position = position;
         this.centerOnScreen = centerOnScreen;
      }

      NodeLoadEvent(Node node, Point2D position) {
         this(node, position, false);
      }

      NodeLoadEvent(Node node, boolean centerOnScreen) {
         this(node, null, centerOnScreen);
      }

      NodeLoadEvent(Node node) {
         this(node, null, false);
      }
   }
}