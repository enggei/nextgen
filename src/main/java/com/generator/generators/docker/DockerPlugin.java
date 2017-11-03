package com.generator.generators.docker;

import com.generator.app.App;
import com.generator.app.App.TransactionAction;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Transaction;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/**
 * Created 16.09.17.
 */
public class DockerPlugin extends DockerDomainPlugin {

   public DockerPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {
      addShowMenu(menu, Entities.DockerFile);
      addShowMenu(menu, Entities.DockerComposeFile);

      menu.add(new TransactionAction("New DockerFile", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newDockerFile(name));
         }
      });

      menu.add(new TransactionAction("New DockerComposeFile", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newDockerComposeFile(name));
         }
      });
   }

   @Override
   protected void handleDockerFile(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
      selectedNodes.stream()
            .filter(selectedNode -> isDirectory(selectedNode.getNode()))
            .forEach(selectedNode -> {
               final String directoryPath = ProjectPlugin.getPath(selectedNode.getNode());
               pop.add(new App.TransactionAction("Add " + directoryPath, app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     relateBUILD(neoNode.getNode(), selectedNode.getNode());
                  }
               });
            });

      outgoingBUILD(neoNode.getNode(), (relationship, other) -> {

         final File path = new File((String) ProjectPlugin.getPath(other));

         if (!path.exists()) return;

         pop.add(new TransactionAction("Build " + path.toString(), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               showEditor("Build", path, app,
                     "docker", "build", "-f", "Dockerfile", ".");
            }
         });
      });
   }

   @Override
   protected void handleDockerComposeFile(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
      selectedNodes.stream()
            .filter(selectedNode -> isDirectory(selectedNode.getNode()))
            .forEach(selectedNode -> {
               final String directoryPath = ProjectPlugin.getPath(selectedNode.getNode());
               pop.add(new App.TransactionAction("Add " + directoryPath, app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     relateCOMPOSE(neoNode.getNode(), selectedNode.getNode());
                  }
               });
            });

      outgoingCOMPOSE(neoNode.getNode(), (relationship, other) -> {

         final File path = new File((String) ProjectPlugin.getPath(other));

         pop.add(new TransactionAction("Compose " + path.toString(), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               if (!path.exists()) return;

               showEditor("Compose", path, app,
                     "docker-compose", "-f", "docker-compose.yml", "-f", "docker-compose.override.yml", "build");
            }
         });
      });
   }

   private static void showEditor(final String title, File directory, App app, final String... command) throws IOException, InterruptedException, TimeoutException {
      // make editor for parameters
      final JCheckBox chkSudo = new JCheckBox("Use Sudo");
      final JPasswordField txtPassword = new JPasswordField();

      final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,100dlu", "pref,4dlu,pref");
      editor.add(chkSudo, 1, 1);
      editor.add(txtPassword, 3, 1);
      editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

      SwingUtil.showDialog(editor, app, title, new SwingUtil.ConfirmAction() {
         @Override
         public void verifyAndCommit() throws Exception {
            final StringBuilder result = new StringBuilder();
            final LogOutputStream logOutputStream = new LogOutputStream() {
               @Override
               protected void processLine(String line) {
                  result.append(line).append("\n");
                  System.out.println(line);
               }
            };

            if (chkSudo.isSelected()) {

               String[] sudoCommand = new String[command.length + 2];
               sudoCommand[0] = "sudo";
               sudoCommand[1] = "-S";
               System.arraycopy(command, 0, sudoCommand, 2, command.length);

               final InputStream stream = new ByteArrayInputStream((new String(txtPassword.getPassword()) + "\n").getBytes(StandardCharsets.UTF_8.name()));
               new ProcessExecutor().
                     directory(directory).
                     command(sudoCommand).
                     redirectError(logOutputStream).
                     redirectOutput(logOutputStream).
                     redirectInput(stream).
                     execute();

               SwingUtil.showTextResult("Result", result.toString().trim(), editor);

            } else {
               new ProcessExecutor().
                     directory(directory).
                     command(command).
                     redirectError(logOutputStream).
                     redirectOutput(logOutputStream).
                     execute();

               SwingUtil.showTextResult("Result", result.toString().trim(), editor, new Dimension(400, 200), true);
            }
         }
      });
   }
}