package com.generator.app;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.util.FormatUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.event.LabelEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.Set;

/**
 * Created 15.07.17.
 */
final class AppEvents {

   private static final String GRAPH_NEW = "graph.new";

   private static final String NODE_LOAD = "nodes.load";
   private static final String NODE_HIGHLIGHTED = "node.highlighted";
   private static final String NODES_CLOSED = "nodes.closed";
   private static final String NODES_SELECTED = "nodes.selected";
   private static final String NODES_DELETED = "nodes.deleted";
   private static final String NODES_ADDED = "nodes.added";
   private static final String NODE_COLOR_CHANGED = "nodes.color";
   private static final String NODE_CHANGED = "node.";

   private static final String LABELS_ASSIGNED = "labels.assigned";

   private static final String RELATION_HIGHLIGHTED = "relation.highlighted";
   private static final String RELATIONS_CLOSED = "relation.closed";
   private static final String RELATIONS_SELECTED = "relations.selected";
   private static final String RELATIONS_DELETED = "relations.deleted";
   private static final String RELATIONS_ADDED = "relations.added";

   private static final String RELATION_PAINTSTRATEGY_CHANGED = "graph.relationPaintStrategy";
   private static final String RELATION_PATHSTRATEGY_CHANGED = "graph.relationPathStrategy";
   private static final String NODE_PAINTSTRATEGY_CHANGED = "graph.nodePaintStrategy";

   private final PropertyChangeSupport appChangeSupport;

   AppEvents(PropertyChangeSupport appChangeSupport) {
      this.appChangeSupport = appChangeSupport;
   }

   void fireGraphNew(String dir, NeoModel graph) {
      appChangeSupport.firePropertyChange(GRAPH_NEW, dir, graph);
   }

   void fireNodeLoad(AppEvents.NodeLoadEvent node) {
      System.out.println("fireNodeLoad " + NeoModel.getNameOrLabelFrom(node.node));
      appChangeSupport.firePropertyChange(NODE_LOAD, null, Collections.singleton(node));
   }

   void fireNodeLoad(Set<AppEvents.NodeLoadEvent> nodes) {
      for (NodeLoadEvent node : nodes) {
         System.out.println("\tfireNodeLoad " + NeoModel.getNameOrLabelFrom(node.node));
      }
      appChangeSupport.firePropertyChange(NODE_LOAD, null, nodes);
   }

   void fireNodeHighlighted(Workspace.NodeCanvas.NeoNode neoNode) {
      appChangeSupport.firePropertyChange(NODE_HIGHLIGHTED, null, neoNode);
   }

   void fireNodesClosed(Set<Workspace.NodeCanvas.NeoNode> neoNodes) {
      appChangeSupport.firePropertyChange(NODES_CLOSED, null, neoNodes);
   }

   void addNodesClosedListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(NODES_CLOSED, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, NODES_CLOSED);
      }));
   }

   void addNodesClosedListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(NODES_CLOSED, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }

   void fireRelationsClosed(Set<Workspace.NodeCanvas.NeoRelationship> neoRelationships) {
      appChangeSupport.firePropertyChange(RELATIONS_CLOSED, null, neoRelationships);
   }

   void addRelationsClosedListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(RELATIONS_CLOSED, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }

   void fireNodeColorChanged(String label, Color color) {
      appChangeSupport.firePropertyChange(NODE_COLOR_CHANGED, label, color);
   }

   void fireRelationsSelected(Set<Workspace.NodeCanvas.NeoRelationship> neoRelationships) {
      appChangeSupport.firePropertyChange(RELATIONS_SELECTED, null, neoRelationships);
   }

   void firePaintStrategyChanged(AppMotif.RelationPaintStrategy old, AppMotif.RelationPaintStrategy relationPaintStrategy) {
      appChangeSupport.firePropertyChange(RELATION_PAINTSTRATEGY_CHANGED, old, relationPaintStrategy);
   }

   void addRelationPaintStrategyChangedListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(RELATION_PAINTSTRATEGY_CHANGED, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }

   void fireRelationHighlighted(Workspace.NodeCanvas.NeoRelationship neoRelationship) {
      appChangeSupport.firePropertyChange(RELATION_HIGHLIGHTED, null, neoRelationship);
   }

   void fireNodesDeleted(Set<Long> nodes) {
      appChangeSupport.firePropertyChange(NODES_DELETED, null, nodes);
   }

   void fireRelationsDeleted(Set<Long> relations) {
      appChangeSupport.firePropertyChange(RELATIONS_DELETED, null, relations);
   }

   void fireNodesAdded(Set<Node> nodes) {
      appChangeSupport.firePropertyChange(NODES_ADDED, null, nodes);
   }

   void addNodesAddedListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(NODES_ADDED, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, NODES_ADDED);
      }));
   }

   void fireRelationsAdded(Set<Relationship> relations) {
      appChangeSupport.firePropertyChange(RELATIONS_ADDED, null, relations);
   }

   void addRelationsAddedListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(RELATIONS_ADDED, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, RELATIONS_ADDED);
      }));
   }

   void fireLabelsAssigned(Set<LabelEntry> values) {
      appChangeSupport.firePropertyChange(LABELS_ASSIGNED, null, values);
   }

   void addLabelsAssignedListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(LABELS_ASSIGNED, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, LABELS_ASSIGNED);
      }));
   }

   void addGraphNewListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(GRAPH_NEW, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }

   void addNodesLoadListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(NODE_LOAD, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, NODE_LOAD);
      }));
   }


   void addNodeHighlightedListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(NODE_HIGHLIGHTED, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }

   void addNodesDeletedListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(NODES_DELETED, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }


   void addNodesSelectedListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(NODES_SELECTED, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, NODES_SELECTED);
      }));
   }

   void fireNodesSelected(Set<Workspace.NodeCanvas.NeoNode> neoNodes) {
      appChangeSupport.firePropertyChange(NODES_SELECTED, null, neoNodes);
   }

   void addRelationsSelectedListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(RELATIONS_SELECTED, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, RELATIONS_SELECTED);
      }));
   }

   void fireNodeChanged(Long node) {
      appChangeSupport.firePropertyChange(NODE_CHANGED + node, null, node);
   }

   void fireNodeChanged(Long node, String property, Object value) {
      appChangeSupport.firePropertyChange(NODE_CHANGED + node, property, value);
   }

   void addNodeChangedListener(Long node, EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(NODE_CHANGED + node, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, NODE_CHANGED);
      }));
   }

   void addRelationsHighlightedListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(RELATION_HIGHLIGHTED, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }

   void addRelationsDeletedListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(RELATIONS_DELETED, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }



   void addRelationPathStrategyChangedListener(PropertyChangeListener changeListener) {
      appChangeSupport.addPropertyChangeListener(RELATION_PATHSTRATEGY_CHANGED, evt -> SwingUtilities.invokeLater(() -> changeListener.propertyChange(evt)));
   }

   void fireRelationPathStrategyChanged(AppMotif.RelationPathStrategy old, AppMotif.RelationPathStrategy relationPathStrategy) {
      appChangeSupport.firePropertyChange(RELATION_PATHSTRATEGY_CHANGED, old, relationPathStrategy);
   }

   void addNodeColorChangedListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(NODE_COLOR_CHANGED, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, NODE_COLOR_CHANGED);
      }));
   }

   void fireNodePaintStrategyChanged(AppMotif.NodePaintStrategy old, AppMotif.NodePaintStrategy nodePaintStrategy) {
      appChangeSupport.firePropertyChange(NODE_PAINTSTRATEGY_CHANGED, old, nodePaintStrategy);
   }

   void addNodePaintStrategyChangedListener(EventsTransactionHandler transactionHandler) {
      appChangeSupport.addPropertyChangeListener(NODE_PAINTSTRATEGY_CHANGED, evt -> SwingUtilities.invokeLater(() -> {
         handle(transactionHandler, evt, NODE_PAINTSTRATEGY_CHANGED);
      }));
   }

   private static void handle(EventsTransactionHandler transactionHandler, PropertyChangeEvent evt, String event) {
      transactionHandler.parent.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      transactionHandler.evt = evt;
      final long start = System.currentTimeMillis();
      transactionHandler.appModel.graph().doInTransaction(transactionHandler);
      System.out.println("\t " + (transactionHandler.owner == null ? "?" : transactionHandler.owner.getSimpleName()) + " " + event + " " + FormatUtil.formatTime(System.currentTimeMillis() - start));
      transactionHandler.parent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
   }

   static abstract class EventsTransactionHandler<T> implements NeoModel.Committer {

      private final App.AppModel appModel;
      protected final Component parent;
      protected final Class owner;

      PropertyChangeEvent evt;

      EventsTransactionHandler(Component parent, App.AppModel appModel) {
         this.parent = parent;
         this.appModel = appModel;
         this.owner = null;
      }

      EventsTransactionHandler(Class owner, Component parent, App.AppModel appModel) {
         this.parent = parent;
         this.appModel = appModel;
         this.owner = owner;
      }

      protected T getValue() {
         return (T) evt.getNewValue();
      }

      @Override
      public void exception(Throwable throwable) {
         parent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
         SwingUtil.showException(parent, throwable);
      }
   }

   static final class NodeLoadEvent {
      final Node node;
      final Point2D position;

      NodeLoadEvent(Node node, Point2D position) {
         this.node = node;
         this.position = position;
      }

      NodeLoadEvent(Node node) {
         this.node = node;
         this.position = null;
      }
   }
}