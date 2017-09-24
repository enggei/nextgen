package com.generator.generators.docker;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.DomainMotif;
import com.generator.app.Workspace;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.generator.util.NeoUtil.*;
import static com.generator.util.NeoUtil.relate;

/**
 * Created 16.09.17.
 */
public class DockerPlugin extends DomainPlugin {

   public enum Entities implements Label {
      Dockerfile
   }

   public enum Relations implements RelationshipType {
      BUILD
   }

   public enum Properties {
   }

   public DockerPlugin(App app) {
      super(app, "Docker");
   }

   @Override
   protected void addActionsTo(JMenu menu) {
      addShowMenu(menu, Entities.Dockerfile);
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

      if (hasLabel(neoNode.getNode(), Entities.Dockerfile)) {

         for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {
            if (hasLabel(selectedNode.getNode(), ProjectPlugin.Entities.Directory)) {
               if (isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.BUILD)) continue;
               pop.add(new App.TransactionAction("Add Build-directory " + DomainMotif.getPropertyValue(selectedNode.getNode(), AppMotif.Properties.name.name()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     relate(neoNode.getNode(), selectedNode.getNode(), Relations.BUILD);
                  }
               });
            }
         }

         outgoing(neoNode.getNode(), Relations.BUILD).forEach(relationship -> {
            final Node buildDirectory = other(neoNode.getNode(), relationship);
            final File directory = ProjectPlugin.getFile(buildDirectory);
            if (directory != null && directory.exists()) {

               // get path from build-directory to Renderer-directory
               final Set<Node> renderDirectories = new LinkedHashSet<>();
               incoming(neoNode.getNode(), ProjectPlugin.Relations.RENDERER).forEach(rendererRelation -> renderDirectories.add(other(neoNode.getNode(), rendererRelation)));

               for (Node renderDirectory : renderDirectories) {
                  final String path = findPath(buildDirectory, renderDirectory);
                  if (path == null) continue;

                  pop.add(new App.TransactionAction("Build in " + DomainMotif.getPropertyValue(buildDirectory, AppMotif.Properties.name.name()), app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        // make editor for parameters
                        final JCheckBox chkSudo = new JCheckBox("Use Sudo");
                        final JPasswordField txtPassword = new JPasswordField();

                        final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,100dlu", "pref,4dlu,pref");
                        editor.add(chkSudo, 1, 1);
                        editor.add(txtPassword, 3, 1);
                        editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                        SwingUtil.showDialog(editor, app, "Build", () -> {

                           final StringBuilder result = new StringBuilder();
                           final LogOutputStream logOutputStream = new LogOutputStream() {
                              @Override
                              protected void processLine(String line) {
                                 result.append(line).append("\n");
                                 System.out.println(line);
                              }
                           };

                           if (chkSudo.isSelected()) {
                              final InputStream stream = new ByteArrayInputStream((new String(txtPassword.getPassword()) + "\n").getBytes(StandardCharsets.UTF_8.name()));
                              new ProcessExecutor().
                                    directory(directory).
                                    command("sudo", "-S", "docker", "build", "-f", path + File.separatorChar + "Dockerfile", ".").
                                    redirectError(logOutputStream).
                                    redirectOutput(logOutputStream).
                                    redirectInput(stream).
                                    execute();

                              SwingUtil.showTextResult("Result", result.toString().trim(), editor);

                           } else {
                              new ProcessExecutor().
                                    directory(directory).
                                    command("docker", "build", "-f", "Dockerfile", ".").
                                    redirectError(logOutputStream).
                                    redirectOutput(logOutputStream).
                                    execute();


                              SwingUtil.showTextResult("Result", result.toString().trim(), editor, new Dimension(400, 200), true);
                           }
                        });
                     }
                  });
               }
            }
         });
      }
   }

   private static String findPath(Node targetNode, Node renderDirectory) {
      if (targetNode.getId() == renderDirectory.getId()) {
         final File rootDir = ProjectPlugin.getFile(targetNode);
         final File childDir = ProjectPlugin.getFile(renderDirectory);
         return childDir.getPath().substring(rootDir.getPath().length() + 1);
      } else {
         final Iterable<Relationship> childRelations = incoming(renderDirectory, ProjectPlugin.Relations.CHILD);
         for (Relationship childRelation : childRelations) {
            final Node other = other(renderDirectory, childRelation);
            if (targetNode.getId() == other.getId()) {
               final File rootDir = ProjectPlugin.getFile(targetNode);
               final File childDir = ProjectPlugin.getFile(renderDirectory);
               return childDir.getPath().substring(rootDir.getPath().length() + 1);
            } else {
               final String path = findPath(targetNode, other);
               if (path != null) return path;
            }
         }
      }
      return null;
   }
}