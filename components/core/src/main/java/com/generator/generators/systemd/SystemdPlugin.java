package com.generator.generators.systemd;

import com.generator.app.App;
import com.generator.app.NodeRenderPanel;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.ssh.SSHDomainPlugin;
import com.generator.generators.ssh.SSHPlugin;
import com.generator.neo.NeoModel;
import com.generator.util.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Session;
import net.sf.expectit.Expect;
import net.sf.expectit.ExpectBuilder;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.zeroturnaround.exec.ProcessExecutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static com.generator.util.NeoUtil.other;
import static net.sf.expectit.matcher.Matchers.contains;
import static net.sf.expectit.matcher.Matchers.regexp;

/**
 * Created 16.12.17.
 */
public class SystemdPlugin extends SystemdDomainPlugin {

   private final RelationshipType SERVICE_HOST = RelationshipType.withName("SERVICE_HOST");

   public SystemdPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.service);

      menu.add(new App.TransactionAction("New Service", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Service name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newservice(name));
         }
      });
   }

   @Override
   protected void handleservice(JPopupMenu pop, NeoNode serviceNode, Set<NeoNode> selectedNodes) {

      for (NeoNode selectedNode : selectedNodes) {
         if (SSHPlugin.isHost(selectedNode.getNode())) {

            if (!NeoUtil.isRelated(serviceNode.getNode(), selectedNode.getNode(), SERVICE_HOST)) {
               pop.add(new App.TransactionAction("Add Host " + SSHPlugin.getNameProperty(selectedNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     NeoUtil.relate(serviceNode.getNode(), selectedNode.getNode(), SERVICE_HOST);
                  }
               });
            }
         }
      }

      NeoUtil.outgoing(serviceNode.getNode(), SERVICE_HOST).forEach(relationship -> {

         final Node serviceFileNode = singleOutgoingFILE(serviceNode.getNode());
         if (serviceFileNode == null) return;

         final String content = getContentProperty(serviceFileNode);
         if (content == null || content.length() == 0) return;


         final Node hostNode = other(serviceNode.getNode(), relationship);

         pop.add(new App.TransactionAction("Deploy to " + SSHPlugin.getNameProperty(hostNode), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final File tempFile = File.createTempFile(getNameProperty(serviceNode.getNode()), "service");
               FileUtil.write(content, tempFile);

               final Session session = SSHPlugin.getSession(hostNode);
               final String localFile = tempFile.getAbsolutePath();
               final String remoteFile = "/home/" + SSHPlugin.getUsernameProperty(hostNode) + "/" + getNameProperty(serviceNode.getNode()) + ".service";
               SSHPlugin.upload(session, localFile, remoteFile);


            }
         });
         pop.add(new App.TransactionAction("Run status " + SSHPlugin.getNameProperty(hostNode), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {


               ThreadUtil.runTaskInNeoTransaction(getGraph(), new ThreadUtil.ThreadTask<Throwable>() {
                  @Override
                  public Throwable run() {
                     try {

                        final Session session = SSHPlugin.getSession(hostNode);
                        final Channel channel = session.openChannel("shell");

                        final AtomicBoolean isFirstPrompt = new AtomicBoolean(true);

                        new JschUtil.SSHHandler(channel) {
                           @Override
                           protected void handleInstall(String installCommand) {

                           }

                           @Override
                           protected String getSudoPassword() {
                              final char[] password = SwingUtil.showPasswordDialog(app);
                              if (password.length == 0) return null;
                              return new String(password);
                           }

                           @Override
                           protected void handle(String cache) {
                              app.logWindow.log(cache);
                           }

                           @Override
                           protected void handleException(String cache, Throwable t) {
                              SwingUtil.showException(app, t);
                           }

                           @Override
                           protected String handleContinue(String cache) {
                              return null;
                           }

                           @Override
                           protected void onPromptReady() {
                              if(isFirstPrompt.get())
                                 write("systemctl status vertx", true);
                              isFirstPrompt.set(false);
                           }
                        };

//                        new ProcessExecutor().
//                              directory(directory).
//                                    command("systemctl", "-H " + usernameProperty + "@" + ipProperty, "status", "vertx")
//                              .redirectOutput(app.logWindow.getLogOutputStream()).execute();
                     } catch (Throwable t) {
                        return t;
                     }

                     return null;
                  }

                  @Override
                  public void onComplete(Throwable throwable) {
                     if (throwable != null) SwingUtil.showException(app, throwable);
                  }
               });


            }
         });

         pop.add(new App.TransactionAction("Commands " + SSHPlugin.getNameProperty(hostNode), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final StringBuilder help = new StringBuilder();
               final String serviceName = getNameProperty(serviceNode.getNode()) + ".service";
               final String serviceFile = "/home/" + SSHPlugin.getUsernameProperty(hostNode) + "/" + serviceName;

               help.append("Move to systemd").append("\n\t").append("sudo cp ").append(serviceFile).append(" /etc/systemd/system/");
               help.append("\n\nActivate ").append(serviceName).append(" immediately").append("\n\t").append("systemctl start ").append(serviceName);
               help.append("\n\nDeactivate ").append(serviceName).append(" immediately").append("\n\t").append("systemctl stop ").append(serviceName);
               help.append("\n\nRestart ").append(serviceName).append("\n\t").append("systemctl restart ").append(serviceName);
               help.append("\n\nStatus ").append(serviceName).append("\n\t").append("systemctl status ").append(serviceName);
               help.append("\n\nEnable ").append(serviceName).append(" started on bootup").append("\n\t").append("systemctl enable ").append(serviceName);
               help.append("\n\nNot start ").append(serviceName).append(" on bootup").append("\n\t").append("systemctl disable ").append(serviceName);
               help.append("\n\nReload units ").append("\n\t").append("systemctl daemon-reload");
               help.append("\n\nJournal ").append("\n\t").append("sudo journalctl -b -u ").append(serviceName.substring(0, serviceName.length() - 8));

               SwingUtil.showTextResult("Help", help.toString(), app);

            }
         });


      });
   }

   @Override
   protected JComponent newServiceFileEditor(NeoNode serviceFileNode) {
      return new NodeRenderPanel(serviceFileNode) {

         @Override
         protected void addActionsTo(JTextArea txtEditor, NeoNode neoNode) {

            txtEditor.setEditable(true);

            txtEditor.addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent ke) {

                  if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {

                     final String text = txtEditor.getText().trim();

                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           setContentProperty(neoNode.getNode(), text);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(txtEditor, throwable);
                        }
                     });
                  }
               }
            });
         }

         @Override
         protected String render(Node node) {
            return SystemdDomainPlugin.getContentProperty(node, "");
         }
      };
   }
}