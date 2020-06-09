package com.generator.app;

import com.generator.app.nodes.NeoNode;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.generator.app.AppEvents.NODES_CLOSED;
import static com.generator.app.AppEvents.NODE_CHANGED;
import static com.generator.app.AppEvents.NODE_LOAD;
import static com.generator.util.NeoUtil.getNameAndLabelsFrom;

/**
 * Created 03.08.17.
 */
public abstract class Plugin {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Plugin.class);

   protected final App app;
   protected final String name;

   public Plugin(App app, String name) {
      log.info("Plugin " + name);
      this.app = app;
      this.name = name;
   }

   protected abstract Label[] getLabels();

   protected abstract void addActionsTo(JMenu menu);

   public abstract void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes);

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

   public abstract JComponent getEditorFor(NeoNode neoNode);

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

   protected void fireNodeChanged(NeoNode neoNode, String name, Object newValue) {
      app.events.firePropertyChange(NODE_CHANGED + neoNode.getNode().getId(), name, newValue);
   }

   protected void fireNodeChanged(Node node) {
      app.events.firePropertyChange(NODE_CHANGED + node.getId());
   }

   protected void fireNodeClosed(NeoNode neoNode) {
      app.events.firePropertyChange(NODES_CLOSED , Collections.singleton(neoNode));
   }

   protected void addNodeChangedListener(NeoNode neoNode, AppEvents.TransactionalPropertyChangeListener transactionHandler) {
      log.info("added nodeChange listener " + transactionHandler.parent.getClass());
      app.events.addPropertyChangeListener(NODE_CHANGED + neoNode.id(), transactionHandler);
   }
}