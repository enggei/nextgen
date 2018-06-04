package com.generator.generators.npm;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.util.SwingUtil;
import com.generator.util.ThreadUtil;
import org.neo4j.graphdb.Transaction;
import org.zeroturnaround.exec.ProcessExecutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Set;

/**
 * Created 24.05.18.
 */
public class npmPlugin extends npmDomainPlugin {

   public npmPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.npmProject);

      menu.add(new App.TransactionAction("New Npm project", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File dir = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
            if (dir == null || !dir.exists()) return;

            fireNodesLoaded(newnpmProject(dir.getName(), dir.getAbsolutePath()));
         }
      });
   }

   @Override
   protected void handlenpmProject(JPopupMenu pop, NeoNode npmProjectNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("run install", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File dir = new File(getPathProperty(npmProjectNode.getNode()).toString());

            ThreadUtil.runTask(new ThreadUtil.ThreadTask<Throwable>() {
               @Override
               public Throwable run() {
                  try {
                     new ProcessExecutor().
                           directory(dir).
                           command("npm", "install")
                           .redirectOutput(app.logWindow.getLogOutputStream()).execute();
                  } catch (Throwable t) {
                     return t;
                  }

                  return null;
               }

               @Override
               public void onComplete(Throwable throwable) {
                  if (throwable != null) {
                     SwingUtil.showException(app, throwable);
                     return;
                  }
               }
            });
         }
      });
   }
}