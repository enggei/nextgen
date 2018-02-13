package com.generator.generators.git;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.project.ProjectPlugin;
import com.generator.neo.NeoModel;
import com.generator.util.SwingUtil;
import com.generator.util.ThreadUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.zeroturnaround.exec.ProcessExecutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created 04.12.17.
 */
public class GitPlugin extends GitDomainPlugin {

   public GitPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {
      addShowMenu(menu, Entities.Git);

      menu.add(new App.TransactionAction("Clone with https", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String url = SwingUtil.showInputDialog("Url", app, SwingUtil.fromClipboard());
            if (url.length() == 0) return;

            final File dir = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
            if (dir == null || !dir.exists()) return;

            ThreadUtil.runTask(new ThreadUtil.ThreadTask<Throwable>() {
               @Override
               public Throwable run() {
                  try {
                     new ProcessExecutor().
                           directory(dir).
                           command("git", "clone", url)
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
                  final Set<Node> nodes = new LinkedHashSet<>();
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        final File[] files = dir.listFiles();
                        if (files != null) {

                           final String projectName = url.substring(url.lastIndexOf("/") + 1, url.length() - 4);

                           for (File file : files) {
                              if (file.getName().equals(projectName)) {
                                 final Node gitNode = newGit(url, projectName);
                                 final Node directoryNode = ProjectPlugin.newDirectory(getGraph(), projectName, file.getPath());
                                 ProjectPlugin.relateRENDERER(directoryNode, gitNode);
                                 nodes.add(gitNode);
                                 nodes.add(directoryNode);
                                 return;
                              }
                           }
                        }
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showException(app, throwable);
                     }
                  });

                  fireNodesLoaded(nodes);
               }
            });
         }
      });
   }

   @Override
   protected void handleGit(JPopupMenu pop, NeoNode gitNode, Set<NeoNode> selectedNodes) {

      final File dir = ProjectPlugin.getFile(ProjectPlugin.singleIncomingRENDERER(gitNode.getNode()));
      if (dir != null && dir.exists()) {
         pop.add(new App.TransactionAction("Show status", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               new ProcessExecutor().directory(dir).command("git", "status").redirectOutput(app.logWindow.getLogOutputStream()).execute();
            }
         });
      }
   }
}