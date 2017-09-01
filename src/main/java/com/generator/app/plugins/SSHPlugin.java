package com.generator.app.plugins;

import com.generator.app.App;
import com.generator.app.Plugin;
import com.generator.app.Workspace;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Set;

/**
 * Created 03.08.17.
 */
public class SSHPlugin extends Plugin {

   private enum Entities implements Label {
      HOST
   }

   private enum Relations implements RelationshipType {

   }

   private enum Properties {
      username, password
   }

   public SSHPlugin(App app) {
      super(app,"SSH");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {
      menu.add(new App.TransactionAction("Add Host", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         }
      });
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

   }

   @Override
   public void showEditorFor(Workspace.NodeCanvas.NeoNode neoNode, JTabbedPane tabbedPane) {

   }

   /*
   // todo make fsm
      Session session = null;
      Channel channel = null;
      try {
         JSch jSch = new JSch();
         jSch.addIdentity("/home/sogern/.ssh/id_rsa");
         session = jSch.getSession("sogern", "osiris.itware.no");
         java.util.Properties config = new java.util.Properties();
         config.put("StrictHostKeyChecking", "no");
         session.setConfig(config);
         session.connect();
         channel = session.openChannel("shell");
         channel.connect();

      } catch (Throwable t) {

      } finally {
         if (channel != null)
            channel.disconnect();
         if (session != null)
            session.disconnect();
      }
    */
}
