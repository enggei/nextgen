package com.generator.generators.mobx;

import com.generator.app.App;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import org.neo4j.graphdb.Label;

import javax.swing.*;
import java.util.Set;

/**
 * Created 20.09.17.
 */
public class MobXPlugin extends Plugin {

   public MobXPlugin(App app) {
      super(app, "MobX");
   }

   @Override
   protected Label[] getLabels() {
      return new Label[0];
   }

   @Override
   protected void addActionsTo(JMenu menu) {

   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

   }

   @Override
   public void showEditorFor(NeoNode neoNode, JTabbedPane tabbedPane) {

   }
}