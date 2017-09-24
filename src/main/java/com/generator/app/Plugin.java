package com.generator.app;

import com.generator.neo.NeoModel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.generator.app.AppEvents.NODE_CHANGED;
import static com.generator.app.AppEvents.NODE_LOAD;
import static com.generator.util.NeoUtil.getNameAndLabelsFrom;

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

   protected void addShowMenu(JMenu menu, Label label) {
      final JMenu showMenu = new JMenu(label.name());
      getGraph().findNodes(label).forEachRemaining(node -> showMenu.add(new App.TransactionAction("Show " + getNameAndLabelsFrom(node), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            fireNodesLoaded(true, node);
         }
      }));
      menu.add(showMenu);
   }

   public abstract void showEditorFor(Workspace.NodeCanvas.NeoNode neoNode, JTabbedPane tabbedPane);

   public NeoModel getGraph() {
      return app.model.graph();
   }

   protected void fireNodesLoaded(Node... nodes) {
      fireNodesLoaded(false, nodes);
   }

   private void fireNodesLoaded(boolean scrollTo, Node... nodes) {
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
      app.events.firePropertyChange(NODE_CHANGED + node.getId());
   }

   protected void addNodeChangedListener(Workspace.NodeCanvas.NeoNode neoNode, AppEvents.TransactionalPropertyChangeListener transactionHandler) {
      System.out.println("added nodeChange listener " + transactionHandler.parent.getClass());
      app.events.addPropertyChangeListener(NODE_CHANGED + neoNode.id(), transactionHandler);
   }
}