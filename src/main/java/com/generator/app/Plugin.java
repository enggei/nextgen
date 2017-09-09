package com.generator.app;

import com.generator.NeoModel;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.generator.app.AppEvents.*;

/**
 * Created 03.08.17.
 */
public abstract class Plugin {

   protected final App app;
   protected final String name;

   public Plugin(App app, String name) {
      this.app = app;
      this.name = name;
   }

   protected abstract Label[] getLabels();

   protected abstract void addActionsTo(JMenu menu);

   protected abstract void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes);

   public abstract void showEditorFor(Workspace.NodeCanvas.NeoNode neoNode, JTabbedPane tabbedPane);

   protected String getAppProperty(String property) {
      return app.model.getAppStringProperty(property);
   }

   public NeoModel getGraph() {
      return app.model.graph();
   }

   protected void fireNodesLoaded(Node... nodes) {
      fireNodesLoaded(false, nodes);
   }

   protected void fireNodesLoaded(ResourceIterator<Node> nodes) {
      final Set<Node> nodeSet = new LinkedHashSet<>();
      while (nodes.hasNext()) nodeSet.add(nodes.next());
      fireNodesLoaded(nodeSet);
   }

   protected void fireNodesLoaded(boolean scrollTo, Node... nodes) {
      final Set<AppEvents.NodeLoadEvent> nodeEvents = new LinkedHashSet<>();
      boolean scrollable = true;
      for (Node node : nodes) {
         nodeEvents.add(new AppEvents.NodeLoadEvent(node, scrollable && scrollTo));
         scrollable = false;
      }
      app.events.firePropertyChange(NODE_LOAD, nodeEvents);
   }

   protected void fireNodesLoaded(Set<Node> nodes) {
      final Set<AppEvents.NodeLoadEvent> nodeEvents = new LinkedHashSet<>();
      for (Node node : nodes) nodeEvents.add(new AppEvents.NodeLoadEvent(node));
      app.events.firePropertyChange(NODE_LOAD, nodeEvents);
   }

   protected void fireNodeChanged(Workspace.NodeCanvas.NeoNode neoNode, String name, Object newValue) {
      app.events.firePropertyChange(NODE_CHANGED + neoNode.getNode().getId(), name, newValue);
   }

   protected void fireNodeChanged(Node node) {
      app.events.firePropertyChange(NODE_CHANGED + node, node.getId());
   }

   protected void addNodeChangedListener(Workspace.NodeCanvas.NeoNode neoNode, AppEvents.TransactionalPropertyChangeListener transactionHandler) {
      app.events.addPropertyChangeListener(NODE_CHANGED + neoNode.id(), transactionHandler);
   }

   protected void showException(Throwable throwable) {
      SwingUtil.showExceptionNoStack(app, throwable);
   }
}