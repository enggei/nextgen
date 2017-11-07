package com.generator.generators.ssh;

import com.generator.app.App;
import com.generator.app.AppEvents;
import com.generator.app.AppMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.project.ProjectPlugin;
import com.generator.neo.NeoModel;
import com.generator.util.JschUtil;
import com.generator.util.SwingUtil;
import com.generator.util.TextProcessingPanel;
import com.jcraft.jsch.*;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.generators.project.ProjectPlugin.getFile;
import static com.generator.util.NeoUtil.*;

/**
 * Created 03.08.17.
 */
public class SSHPlugin extends SSHDomainPlugin {

   public static void cleanupPreviousSessions(NeoModel graph) {
      graph.findNodes(Entities.Host).forEachRemaining(hostNode -> outgoing(hostNode, Relations.SESSIONS).forEach(sessionRelation -> {
         final Node sessionNode = other(hostNode, sessionRelation);
         outgoing(sessionNode, Relations.CHANNELS).forEach(channelRelation -> {
            final Node channelNode = other(sessionNode, channelRelation);
            channelRelation.delete();
            incoming(channelNode, AppMotif.Relations._LAYOUT_MEMBER).forEach(Relationship::delete);
            channelNode.delete();
         });

         incoming(sessionNode, AppMotif.Relations._LAYOUT_MEMBER).forEach(Relationship::delete);
         sessionRelation.delete();
         sessionNode.delete();
      }));
   }

   private final Map<UUID, Session> sessions = new LinkedHashMap<>();
   private final Map<UUID, ActiveChannel> channels = new LinkedHashMap<>();

   public SSHPlugin(App app) {
      super(app);

      // add command-root-node
      final Node commandRoot = getGraph().findOrCreate(Entities.CommandRoot, AppMotif.Properties.name.name(), Entities.CommandRoot.name());

      //https://www.linuxtrainingacademy.com/linux-commands-cheat-sheet/
      // add default linux-commands
      final Node linuxCategory = getGraph().findOrCreate(Entities.CommandCategory, AppMotif.Properties.name.name(), "Linux");
      relate(commandRoot, linuxCategory, Relations.CATEGORIES);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "List dir", Properties.cmdCommand.name(), "ls -ltr"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Go home", Properties.cmdCommand.name(), "cd ~"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Disk usage", Properties.cmdCommand.name(), "df -h"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Top", Properties.cmdCommand.name(), "top"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Kernel", Properties.cmdCommand.name(), "uname -a"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Uptime", Properties.cmdCommand.name(), "uptime"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Linux version", Properties.cmdCommand.name(), "lsb_release -a"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "ifconfig", Properties.cmdCommand.name(), "ifconfig"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Wireless", Properties.cmdCommand.name(), "iwconfig"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Processes", Properties.cmdCommand.name(), "ps"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Host name", Properties.cmdCommand.name(), "hostname"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "IP address", Properties.cmdCommand.name(), "hostname -I"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Reboot history", Properties.cmdCommand.name(), "last reboot"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Datetime", Properties.cmdCommand.name(), "date"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Calendar", Properties.cmdCommand.name(), "cal"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Who is online", Properties.cmdCommand.name(), "w"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Whoami", Properties.cmdCommand.name(), "whoami"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Reboot now", Properties.cmdCommand.name(), "reboot now"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Shutdown now", Properties.cmdCommand.name(), "shutdown now"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Shutdown now", Properties.cmdCommand.name(), "shutdown now"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display messages in kernel ring buffer", Properties.cmdCommand.name(), "dmesg"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display CPU information", Properties.cmdCommand.name(), "cat /proc/cpuinfo"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display memory information", Properties.cmdCommand.name(), "cat /proc/meminfo"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display free and used memory ( -h for human readable, -m for MB, -g for GB.)", Properties.cmdCommand.name(), "free -h"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display PCI devices", Properties.cmdCommand.name(), "lspci -tv"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display USB devices", Properties.cmdCommand.name(), "lsusb -tv"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display DMI/SMBIOS (hardware info) from the BIOS", Properties.cmdCommand.name(), "dmidecode"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Show info about disk sda", Properties.cmdCommand.name(), "hdparm -i /dev/sda"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Perform a read speed test on disk sda", Properties.cmdCommand.name(), "hdparm -tT /dev/sda"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Test for unreadable blocks on disk sda", Properties.cmdCommand.name(), "badblocks -s /dev/sda"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "HAL", Properties.cmdCommand.name(), "lshal"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Hardware", Properties.cmdCommand.name(), "lshw"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display and manage the top processes", Properties.cmdCommand.name(), "top"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Interactive process viewer (top alternative)", Properties.cmdCommand.name(), "htop"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display processor related statistics", Properties.cmdCommand.name(), "mpstat 1"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display virtual memory statistics", Properties.cmdCommand.name(), "vmstat 1"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display I/O statistics", Properties.cmdCommand.name(), "iostat 1"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Display the last 100 syslog messages", Properties.cmdCommand.name(), "tail -n 100 /var/log/syslog"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Capture and display all packets on interface eth0", Properties.cmdCommand.name(), "tcpdump -i eth0"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Monitor all traffic on port 80 ( HTTP )", Properties.cmdCommand.name(), "tcpdump -i eth0 'port 80'"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "List all open files on the system", Properties.cmdCommand.name(), "lsof"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "List files opened by user", Properties.cmdCommand.name(), "lsof -u user"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Apt-get update", Properties.cmdCommand.name(), "apt-get update"), Relations.COMMANDS);
      relate(linuxCategory, getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), "Apt-get upgrade", Properties.cmdCommand.name(), "apt-get upgrade"), Relations.COMMANDS);

      JSch.setLogger(new Logger() {
         @Override
         public boolean isEnabled(int i) {
            return true;
         }

         @Override
         public void log(int i, String s) {
            System.out.println("SSH " + i + " : " + s);
         }
      });

      Runtime.getRuntime().addShutdownHook(new Thread(this::close));
   }

   private void close() {

      for (Map.Entry<UUID, ActiveChannel> channelEntry : channels.entrySet()) {
         System.out.println("closing channel " + channelEntry.getKey());
         channelEntry.getValue().channel.disconnect();
      }

      for (Map.Entry<UUID, Session> sessionEntry : sessions.entrySet()) {
         System.out.println("disconnecting ssh session " + sessionEntry.getKey());
         sessionEntry.getValue().disconnect();
      }
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Host);

      menu.add(new App.TransactionAction("Add Host", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextField txtName = new JTextField();
            final JTextField txtUri = new JTextField();
            final JTextField txtUsername = new JTextField();
            final JPasswordField txtPassword = new JPasswordField();
            final JTextField txtPrivateKeyPath = new JTextField();
            final JTextField txtPort = new JTextField();
            txtPort.setText("22");

            final JRadioButton radUserInfo = new JRadioButton();
            final JRadioButton radIdentityInfo = new JRadioButton();
            final ButtonGroup authenticationGroup = new ButtonGroup();
            authenticationGroup.add(radUserInfo);
            authenticationGroup.add(radIdentityInfo);

            radUserInfo.setSelected(true);
            txtPrivateKeyPath.setEnabled(false);

            radUserInfo.addActionListener(e1 -> {
               txtPassword.setEnabled(true);
               txtPrivateKeyPath.setEnabled(false);
            });

            radIdentityInfo.addActionListener(e1 -> {
               txtPassword.setEnabled(false);
               txtPrivateKeyPath.setEnabled(true);
            });

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref");
            editor.addLabel("Name", 3, 1);
            editor.add(txtName, 5, 1);
            editor.addLabel("Uri", 3, 3);
            editor.add(txtUri, 5, 3);
            editor.addLabel("Port", 3, 5);
            editor.add(txtPort, 5, 5);
            editor.addLabel("Username", 3, 7);
            editor.add(txtUsername, 5, 7);
            editor.add(radUserInfo, 1, 9);
            editor.addLabel("Password", 3, 9);
            editor.add(txtPassword, 5, 9);
            editor.add(radIdentityInfo, 1, 11);
            editor.addLabel("Private key path", 3, 11);
            editor.add(txtPrivateKeyPath, 5, 11);

            SwingUtil.showDialog(editor, app, "Login", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {

                  final String uri = txtUri.getText();
                  if (uri.length() == 0) return;

                  final int port = Integer.parseInt(txtPort.getText().trim());
                  if (port < 1 || port > 65535)
                     throw new IllegalArgumentException("Illegal port. Must be between 1 and 65535.");

                  if (radUserInfo.isSelected() && (txtUsername.getText().length() == 0 || txtPassword.getPassword().length == 0))
                     return;

                  if (radIdentityInfo.isSelected() && (txtUsername.getText().length() == 0 || txtPrivateKeyPath.getText().length() == 0 || !new File(txtPrivateKeyPath.getText().trim()).exists()))
                     return;

                  final String name = txtName.getText().trim().length() == 0 ? uri : txtName.getText().trim();
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        if (radUserInfo.isSelected())
                           fireNodesLoaded(getGraph().newNode(Entities.Host,
                                 AppMotif.Properties.name.name(), name,
                                 Properties.ip.name(), uri,
                                 Properties.username.name(), txtUsername.getText(),
                                 Properties.password.name(), new String(txtPassword.getPassword()),
                                 Properties.port.name(), port));

                        else if (radIdentityInfo.isSelected())
                           fireNodesLoaded(getGraph().newNode(Entities.Host,
                                 AppMotif.Properties.name.name(), name,
                                 Properties.ip.name(), uri,
                                 Properties.username.name(), txtUsername.getText(),
                                 Properties.privateKeyPath.name(), txtPrivateKeyPath.getText().trim(),
                                 Properties.port.name(), port));
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });

      menu.add(new App.TransactionAction("Show Commands", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            fireNodesLoaded(getGraph().findNode(Entities.CommandRoot, AppMotif.Properties.name.name(), Entities.CommandRoot.name()));
         }
      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      if (isHost(neoNode.getNode())) {

         pop.add(new App.TransactionAction("Connect", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               connectToHost(neoNode.getNode());
            }
         });

         pop.add(new App.TransactionAction("Open Shell", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Node sessionNode = connectToHost(neoNode.getNode());

               final Session session = sessions.get(uuidOf(sessionNode));
               final Channel channel = session.openChannel("shell");

               // passing in session-node to retrieve host and host-commands:
               final ActiveChannel activeChannel = new ActiveChannel(channel, neoNode).connect();

               final Node newNode = getGraph().newNode(Entities.Channel, Properties.ip.name(), "shell");
               relateCHANNELS(sessionNode, newNode);
               channels.put(uuidOf(newNode), activeChannel);
               fireNodesLoaded(newNode);
            }
         });

         pop.add(new App.TransactionAction("Upload file to host", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final File file = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
               if (file == null) return;

               final String target = SwingUtil.showInputDialog("Target", app);
               if (target == null || target.length() == 0) return;

               final Session session = getSession(neoNode.getNode());
               upload(session, file.getAbsolutePath(), target);

            }
         });

         pop.add(new App.TransactionAction("Download from host", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String target = SwingUtil.showInputDialog("Path on host", app);
               if (target == null || target.length() == 0) return;

               final File file = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
               if (file == null) return;

               download(getSession(neoNode.getNode()), file.getAbsolutePath(), target);
            }
         });

         pop.add(new AbstractAction("Add Command") {
            @Override
            public void actionPerformed(ActionEvent e) {

               final JTextField txtName = new JTextField();
               final JTextField txtCommand = new JTextField();

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref");
               editor.addLabel("Name", 3, 1);
               editor.add(txtName, 5, 1);
               editor.addLabel("Command", 3, 3);
               editor.add(txtCommand, 5, 3);

               SwingUtil.showDialog(editor, app, "Add command", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {

                     final String name = txtName.getText();
                     final String command = txtCommand.getText();
                     if (name.length() == 0 || command.length() == 0) return;

                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Node newNode = getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), txtName.getText(), Properties.cmdCommand.name(), txtCommand.getText());
                           relate(neoNode.getNode(), newNode, Relations.COMMANDS);
                           fireNodesLoaded(newNode);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showExceptionNoStack(app, throwable);
                        }
                     });
                  }
               });
            }
         });

         pop.add(new App.TransactionAction("Add Path", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String path = SwingUtil.showInputDialog("Path", app);
               if (path == null || path.length() == 0) return;

               final Node pathNode = newPath(path);
               relatePATHS(neoNode.getNode(), pathNode);
               fireNodesLoaded(pathNode);
            }
         });

         if (!sessions.isEmpty()) {
            pop.add(new App.TransactionAction("Close all sessions", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  outgoingSESSIONS(neoNode.getNode(), (relationship, sessionNode) -> closeSession(sessionNode));
               }
            });
         }

      } else if (isSession(neoNode.getNode())) {

         if (sessions.containsKey(uuidOf(neoNode.getNode()))) {

            pop.add(new App.TransactionAction("Open shell", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Session session = sessions.get(uuidOf(neoNode.getNode()));
                  final Channel channel = session.openChannel("shell");

                  // passing in session-node to retrieve host and host-commands:
                  final ActiveChannel activeChannel = new ActiveChannel(channel, neoNode).connect();

                  final Node newNode = getGraph().newNode(Entities.Channel, Properties.ip.name(), "shell");
                  relateCHANNELS(neoNode.getNode(), newNode);
                  channels.put(uuidOf(newNode), activeChannel);
                  fireNodesLoaded(newNode);
               }
            });

            pop.add(new App.TransactionAction("Close Session", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  closeSession(neoNode);
               }
            });
         }

      } else if (isChannel(neoNode.getNode())) {

         if (channels.containsKey(uuidOf(neoNode.getNode()))) {
            pop.add(new App.TransactionAction("Close Channel", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  closeChannel(neoNode.getNode());
               }
            });
         }

      } else if (isPath(neoNode.getNode())) {

         final Set<File> fileSet = new LinkedHashSet<>();
         for (NeoNode selectedNode : selectedNodes) {
            if (hasLabel(selectedNode.getNode(), ProjectPlugin.Entities.File)) {

               final Node directoryNode = other(selectedNode.getNode(), singleIncoming(selectedNode.getNode(), ProjectPlugin.Relations.FILE));
               final File getDir = getFile(directoryNode);
               final File file = new File(getDir, getString(selectedNode.getNode(), AppMotif.Properties.name.name()) + "" + getString(selectedNode.getNode(), ProjectPlugin.Properties.extension.name()));
               if (!file.exists()) return;

               fileSet.add(file);
            }
         }

         if (fileSet.isEmpty()) {
            pop.add(new App.TransactionAction("Upload file here", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final File file = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
                  if (file == null) return;

                  final Node hostNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.PATHS));
                  upload(getSession(hostNode), file.getAbsolutePath(), getPathProperty(neoNode.getNode()));
               }
            });

         } else if (fileSet.size() == 1) {

            final File file = fileSet.iterator().next();

            pop.add(new App.TransactionAction("Upload " + file.getName(), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  final Node hostNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.PATHS));
                  upload(getSession(hostNode), file.getAbsolutePath(), getPathProperty(neoNode.getNode()));
               }
            });

         } else if (fileSet.size() > 1) {

            final JMenu fileuploadMenu = new JMenu("Upload...");
            for (File file : fileSet) {
               fileuploadMenu.add(new App.TransactionAction(file.getName(), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     final Node hostNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.PATHS));
                     upload(getSession(hostNode), file.getAbsolutePath(), getPathProperty(neoNode.getNode()));
                  }
               });
            }
            pop.add(fileuploadMenu);

//            pop.add(new App.TransactionAction("Upload " + fileSet.size() + " files", app) {
//               @Override
//               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//                  final Node hostNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.PATHS));
//
//                  final Session session = getSession(hostNode);
//                  for (File file : fileSet)
//                     upload(session, file.getAbsolutePath(), getName(neoNode));
//                  session.disconnect();
//
//                  SwingUtil.showMessage(fileSet.size() + " files uploaded", app);
//               }
//            });
         }


      } else if (isCommandRoot(neoNode.getNode())) {

         pop.add(new App.TransactionAction("Add Category", app) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final JTextField txtName = new JTextField();

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref");
               editor.addLabel("Name", 3, 1);
               editor.add(txtName, 5, 1);

               SwingUtil.showDialog(editor, app, "Add category", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {

                     final String name = txtName.getText();
                     if (name.length() == 0) return;

                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Node newNode = getGraph().findOrCreate(Entities.CommandCategory, AppMotif.Properties.name.name(), txtName.getText());
                           relateCATEGORIES(neoNode.getNode(), newNode);
                           fireNodesLoaded(newNode);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showExceptionNoStack(app, throwable);
                        }
                     });
                  }
               });
            }
         });

      } else if (isCommandCategory(neoNode.getNode())) {

         pop.add(new AbstractAction("Add Command") {
            @Override
            public void actionPerformed(ActionEvent e) {

               final JTextField txtName = new JTextField();
               final JTextField txtCommand = new JTextField();

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref");
               editor.addLabel("Name", 3, 1);
               editor.add(txtName, 5, 1);
               editor.addLabel("Command", 3, 3);
               editor.add(txtCommand, 5, 3);

               SwingUtil.showDialog(editor, app, "Add command", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {

                     final String name = txtName.getText();
                     final String command = txtCommand.getText();
                     if (name.length() == 0 || command.length() == 0) return;

                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Node newNode = getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), txtName.getText(), Properties.cmdCommand.name(), txtCommand.getText());
                           relateCOMMANDS(neoNode.getNode(), newNode);
                           fireNodesLoaded(newNode);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showExceptionNoStack(app, throwable);
                        }
                     });
                  }
               });
            }
         });
      }
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      if (hasLabel(neoNode.getNode(), Entities.Channel) && channels.containsKey(uuidOf(neoNode.getNode())))
         return channels.get(uuidOf(neoNode.getNode())).editor;
      return null;
   }

   private final class ChannelEditor extends JPanel {

      final JTextField txtTerminal = new JTextField(15);
      final JTextArea txtOutput = new JTextArea();

      final AtomicBoolean active = new AtomicBoolean(true);
      private final StringBuilder cache = new StringBuilder();
      private final Stack<CommandNode> commandStack = new Stack<>();
      private final JTree commandTree;
      private final JList<CommandNode> historyList = new JList<>();

      private char[] sudoPassword = null;
      private String install = null;

      ChannelEditor(Channel channel, NeoNode sessionNode) throws IOException {
         super(new BorderLayout());

         txtTerminal.setFont(com.generator.app.AppMotif.getDefaultFont());

         txtOutput.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtOutput.setEditable(false);

         final DataInputStream dataIn = new DataInputStream(channel.getInputStream());
         final DataOutputStream dataOut = new DataOutputStream(channel.getOutputStream());

         txtTerminal.addActionListener(e -> {

            final String trim = txtTerminal.getText().trim();
            if (trim.length() == 0) return;

            runCommand(dataOut, new CommandNode("Run " + trim, trim));
            txtTerminal.setText("");
         });

         txtTerminal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

               final String trim = txtTerminal.getText().trim();

               if (SwingUtilities.isRightMouseButton(e)) {
                  final JPopupMenu pop = new JPopupMenu();

                  if (trim.length() > 0) {

                     pop.add(new AbstractAction("Run " + trim) {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           runCommand(dataOut, new CommandNode("Run " + trim, trim));
                        }
                     });

                     pop.add(new AbstractAction("Run as sudo " + trim) {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           runCommand(dataOut, new CommandNode("Run " + trim, trim), true);
                        }
                     });

                     final Set<CommandCategoryNode> categoryNodes = getCategories((TreeNode) commandTree.getModel().getRoot());
                     final JMenu addCategoryMenu = new JMenu("Add to ");
                     pop.add(addCategoryMenu);

                     for (LabelNode categoryNode : categoryNodes) {
                        addCategoryMenu.add(new App.TransactionAction(categoryNode.label, app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              final JTextField txtName = new JTextField(txtTerminal.getText());
                              final JTextField txtCommand = new JTextField(txtTerminal.getText());

                              final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref");
                              editor.addLabel("Name", 3, 1);
                              editor.add(txtName, 5, 1);
                              editor.addLabel("Command", 3, 3);
                              editor.add(txtCommand, 5, 3);

                              SwingUtil.showDialog(editor, app, "Add command", new SwingUtil.ConfirmAction() {
                                 @Override
                                 public void verifyAndCommit() throws Exception {

                                    final String name = txtName.getText();
                                    final String command = txtCommand.getText();
                                    if (name.length() == 0 || command.length() == 0) return;

                                    getGraph().doInTransaction(new NeoModel.Committer() {
                                       @Override
                                       public void doAction(Transaction tx) throws Throwable {

                                          final CommandNode commandNode = new CommandNode(txtName.getText(), txtCommand.getText());
                                          final Node newNode = getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), txtName.getText(), Properties.cmdCommand.name(), txtCommand.getText());
                                          relateCOMMANDS(categoryNode.node, newNode);
                                          SwingUtilities.invokeLater(() -> categoryNode.addChildNode(commandNode, categoryNode, commandTree));
                                       }

                                       @Override
                                       public void exception(Throwable throwable) {
                                          SwingUtil.showExceptionNoStack(app, throwable);
                                       }
                                    });
                                 }
                              });
                           }
                        });
                     }

                     pop.add(new AbstractAction("Clear") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           txtTerminal.setText("");
                        }
                     });
                  }

                  if (SwingUtil.fromClipboard() != null) {
                     pop.add(new AbstractAction("Insert from clipboard") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           insertInTerminal(SwingUtil.fromClipboard());
                        }
                     });

                     pop.add(new AbstractAction("Insert from clipboard and Run") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           insertInTerminal(SwingUtil.fromClipboard());
                           runCommand(dataOut, new CommandNode("Run " + trim, trim));
                        }
                     });

                     pop.add(new AbstractAction("Insert from clipboard and Run as Sudo") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           insertInTerminal(SwingUtil.fromClipboard());
                           runCommand(dataOut, new CommandNode("Run " + trim, trim), true);
                        }
                     });
                  }

                  SwingUtilities.invokeLater(() -> pop.show(txtTerminal, e.getX(), e.getY()));
               }
            }


            private Set<CommandCategoryNode> getCategories(TreeNode root) {
               final Set<CommandCategoryNode> set = new TreeSet<>();
               for (int i = 0; i < root.getChildCount(); i++)
                  visit(root.getChildAt(i), set);
               return set;
            }

            private void visit(TreeNode treeNode, Set<CommandCategoryNode> set) {
               if (treeNode instanceof CommandCategoryNode) {
                  set.add((CommandCategoryNode) treeNode);
               } else {
                  for (int i = 0; i < treeNode.getChildCount(); i++)
                     visit(treeNode.getChildAt(i), set);
               }
            }
         });

         txtOutput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isRightMouseButton(e)) {
                  final JPopupMenu pop = new JPopupMenu();

                  if (txtOutput.getSelectedText() != null && txtOutput.getSelectedText().length() > 0) {

                     pop.add(new AbstractAction("Insert into terminal") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           insertInTerminal(txtOutput.getSelectedText());
                        }
                     });

                     pop.add(new AbstractAction("Insert into terminal and Run") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           insertInTerminal(txtOutput.getSelectedText());
                           runCommand(dataOut, new CommandNode("Run " + txtTerminal.getText().trim(), txtTerminal.getText().trim()));
                        }
                     });

                     pop.add(new AbstractAction("cd " + txtOutput.getSelectedText()) {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           runCommand(dataOut, new CommandNode("cd " + txtOutput.getSelectedText(), "cd " + txtOutput.getSelectedText()));
                        }
                     });

                     pop.add(new AbstractAction("Run " + txtOutput.getSelectedText()) {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           runCommand(dataOut, new CommandNode("Run " + txtOutput.getSelectedText(), txtOutput.getSelectedText()));
                        }
                     });

                     pop.add(new AbstractAction("Copy to clipboard ") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           SwingUtil.toClipboard(txtOutput.getSelectedText().trim());
                        }
                     });

                     pop.add(new AbstractAction("Try to download (if file)") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final String filename = txtOutput.getSelectedText().trim();
                           runCommand(dataOut, new CommandNode("pwd", "pwd"));
                        }
                     });
                  }

                  pop.add(new AbstractAction("Clear") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        txtOutput.setText("");
                        cache.delete(0, cache.length());
                     }
                  });

                  pop.add(new AbstractAction("Process Text") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        final TextProcessingPanel processingPanel = new TextProcessingPanel(txtOutput.getText(), Collections.emptySet());
                        SwingUtil.showDialog(processingPanel, app, "Process Text", new SwingUtil.ConfirmAction() {
                           @Override
                           public void verifyAndCommit() throws Exception {
                              final String outputText = processingPanel.getOutputText();
                              if (outputText.trim().length() == 0) return;
                              SwingUtil.toClipboard(outputText.trim());
                           }
                        });
                     }
                  });

                  if (install != null && !commandStack.contains(new CommandNode("Install " + install, install))) {
                     pop.add(new AbstractAction("Install " + install) {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           runCommand(dataOut, new CommandNode("Install " + install, install));
                        }
                     });
                  }

                  pop.add(new AbstractAction("Run Ctrl+C") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        new SignalCommandNode("Ctrl+C", 3).run(dataOut);
                     }
                  });

                  SwingUtilities.invokeLater(() -> pop.show(txtOutput, e.getX(), e.getY()));
               }
            }


         });

         new Thread(() -> {
            try {

               byte[] bytes = new byte[2048];
               while (active.get()) {
                  if (dataIn.available() > 0) {
                     final int read = dataIn.read(bytes);
                     cache.append(new String(bytes, 0, read, "UTF-8"));

                     final String s = cache.toString();
                     SwingUtilities.invokeLater(() -> {
                        txtOutput.setText(s);
                        try {
                           txtOutput.setCaretPosition(txtOutput.getLineStartOffset(txtOutput.getLineCount() - 1));
                        } catch (BadLocationException e) {
                           System.out.println("Ignoring caret position because of " + e.getMessage());
                        }
                     });

                     // todo use ExpectIt here ?
                     if (s.contains("[sudo] password for ") && sudoPassword == null) {

                        final char[] p = SwingUtil.showPasswordDialog(txtOutput);
                        if (p == null) return;
                        this.sudoPassword = p;

                        runCommand(dataOut, new CommandNode("passwd", new String(sudoPassword)));

                     } else if (s.endsWith("Do you want to continue? [Y/n] ")) {
                        runCommand(dataOut, new CommandNode("continue", (SwingUtil.showConfirmDialog(app, "Do you want to continue ?")) ? "Y\n" : "n\n"));

                     } else {

                        final String installTxt = "You can install it by typing:\r\n";
                        if (s.contains(installTxt)) {
                           final int beginIndex = s.indexOf(installTxt) + installTxt.length();
                           install = s.substring(beginIndex, s.indexOf("\r\n", beginIndex));
                        }
                     }
                  }

                  Thread.sleep(100L);
               }
            } catch (Throwable t) {
               txtOutput.setText(SwingUtil.printStackTrace(t.getCause()));
            }
         }).start();

         commandTree = new JTree(loadCommandTree(sessionNode)) {{

            setRootVisible(true);

            setCellRenderer(new DefaultTreeCellRenderer() {
               @Override
               public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                  final LabelNode nodeEntry = (LabelNode) value;
                  return super.getTreeCellRendererComponent(tree, nodeEntry.label, sel, expanded, leaf, row, hasFocus);
               }
            });

            addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {

                  final TreePath selectionPath = ((JTree) e.getSource()).getPathForLocation(e.getX(), e.getY());
                  if (selectionPath == null) return;
                  final LabelNode selectedNode = (LabelNode) selectionPath.getLastPathComponent();
                  if (selectedNode == null) return;

                  if (SwingUtilities.isLeftMouseButton(e) && (selectedNode instanceof CommandNode)) {
                     // do not run last command if same as last
                     if (commandStack.isEmpty() || !selectedNode.equals(commandStack.peek()))
                        runCommand(dataOut, (CommandNode) selectedNode);

                  } else if (SwingUtilities.isRightMouseButton(e)) {

                     final JPopupMenu pop = new JPopupMenu();
                     selectedNode.addRightClickActions(pop, selectionPath, ((JTree) e.getSource()), dataOut);
                     SwingUtilities.invokeLater(() -> pop.show(commandTree, e.getX(), e.getY()));
                  }
               }
            });
         }};

         historyList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
               final CommandNode node = (CommandNode) value;
               return super.getListCellRendererComponent(list, node.label, index, isSelected, cellHasFocus);
            }
         });
         historyList.setModel(new CommandHistorListModel(commandStack));
         historyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

               final int locationToIndex = historyList.locationToIndex(e.getPoint());
               if (locationToIndex == -1) return;

               final CommandNode commandNode = historyList.getModel().getElementAt(locationToIndex);
               if (commandNode == null) return;
               commandNode.run(dataOut);
            }
         });

         final JPanel commandPanel = new JPanel(new BorderLayout());
         commandPanel.add(new JScrollPane(commandTree), BorderLayout.CENTER);
         commandPanel.add(new JScrollPane(historyList), BorderLayout.SOUTH);

         final JScrollPane newLeftComponent = new JScrollPane(commandPanel);
         newLeftComponent.getViewport().setPreferredSize(new Dimension(250, 1024));
         newLeftComponent.getViewport().setSize(new Dimension(250, 1024));

         final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, newLeftComponent, new JScrollPane(txtOutput));
         add(splitPane, BorderLayout.CENTER);
         add(txtTerminal, BorderLayout.NORTH);
      }

      private void insertInTerminal(String str) {
         try {
            final String selectedText = txtTerminal.getSelectedText();
            if (selectedText != null && selectedText.length() > 0) {
               txtTerminal.setText(txtTerminal.getText().replaceFirst(selectedText, str));
            } else {
               final int caretPosition = txtTerminal.getCaretPosition();
               txtTerminal.getDocument().insertString(caretPosition, str, null);
            }
         } catch (BadLocationException e1) {
            System.out.println("Could not insert string at caret position: " + e1.getMessage());
         }
      }

      private void runCommand(DataOutputStream dataOut, CommandNode commandNode) {
         runCommand(dataOut, commandNode, false);
      }

      private void runCommand(DataOutputStream dataOut, CommandNode commandNode, boolean asSudo) {
         commandStack.push(commandNode.run(dataOut, asSudo));
         ((CommandHistorListModel) historyList.getModel()).fireContenChanged();
      }

      @NotNull
      private LabelNode loadCommandTree(NeoNode sessionNode) {

         final LabelNode root = new LabelNode("Shell");

         final LabelNode commands = new LabelNode("Commands") {

            private final LabelNode thisLabel = this;

            @Override
            public void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree jTree, DataOutputStream dataOut) {
               pop.add(new AbstractAction("Add Category") {
                  @Override
                  public void actionPerformed(ActionEvent e) {

                     final JTextField txtName = new JTextField();

                     final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref");
                     editor.addLabel("Name", 3, 1);
                     editor.add(txtName, 5, 1);

                     SwingUtil.showDialog(editor, app, "Add Category", new SwingUtil.ConfirmAction() {
                        @Override
                        public void verifyAndCommit() throws Exception {

                           final String name = txtName.getText();
                           if (name.length() == 0) return;

                           getGraph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {

                                 final Node commandCategoryNode = getGraph().findOrCreate(Entities.CommandCategory, AppMotif.Properties.name.name(), txtName.getText());
                                 final Node commandRootNode = getGraph().findOrCreate(Entities.CommandRoot, AppMotif.Properties.name.name(), Entities.CommandRoot.name());
                                 relateCATEGORIES(commandRootNode, commandCategoryNode);
                                 SwingUtilities.invokeLater(() -> addChildNode(new CommandCategoryNode(name, commandCategoryNode), thisLabel, commandTree));
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showExceptionNoStack(app, throwable);
                              }
                           });
                        }
                     });
                  }
               });
            }
         };
         root.add(commands);

         // commands for host:
         final Node hostNode = other(sessionNode.getNode(), singleIncoming(sessionNode.getNode(), Relations.SESSIONS));
         final CommandCategoryNode hostCommands = new CommandCategoryNode("Host", hostNode);
         outgoingCOMMANDS(hostNode, (commandRelation, commandNode) -> hostCommands.add(new CommandNode(getNameProperty(commandNode), getCmdCommandProperty(commandNode))));
         commands.add(hostCommands);

         // all general-commands:
         final Node commandRootNode = getGraph().findNode(Entities.CommandRoot, AppMotif.Properties.name.name(), Entities.CommandRoot.name());
         outgoingCATEGORIES(commandRootNode, (categoryRelation, categoryNode) -> {
            final String categoryName = getString(categoryNode, AppMotif.Properties.name.name());
            final CommandCategoryNode labelNode = new CommandCategoryNode(categoryName, categoryNode);
            commands.add(labelNode);
            outgoingCOMMANDS(categoryNode, (commandRelation, commandNode) -> labelNode.add(new CommandNode(getNameProperty(commandNode), getCmdCommandProperty(commandNode))));
         });

         // paths for host:
         final PathsNode hostPaths = new PathsNode("Paths", hostNode);
         outgoing(hostNode, Relations.PATHS).forEach(pathRelation -> {
            final Node pathNode = other(hostNode, pathRelation);
            hostPaths.add(new PathNode(pathNode));
         });
         root.add(hostPaths);


         return root;
      }

      private class LabelNode extends DefaultMutableTreeNode implements Comparable<LabelNode> {

         final String label;
         protected final Node node;

         private LabelNode(String label) {
            this(label, null);
         }

         private LabelNode(String label, Node node) {
            this.label = label;
            this.node = node;
         }

         @Override
         public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LabelNode labelNode = (LabelNode) o;

            return label.equals(labelNode.label);
         }

         @Override
         public int hashCode() {
            return label.hashCode();
         }

         @Override
         public int compareTo(@NotNull LabelNode o) {
            return this.label.compareTo(o.label);
         }

         void addChildNode(LabelNode treeNode, MutableTreeNode currentNode, JTree source) {
            final DefaultTreeModel dm = (DefaultTreeModel) source.getModel();
            dm.insertNodeInto(treeNode, currentNode, currentNode.getChildCount());
            source.expandPath(new TreePath(dm.getPathToRoot(treeNode.getParent())));
         }

         public void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree jTree, DataOutputStream dataOut) {


         }
      }

      private class PathsNode extends LabelNode {

         PathsNode(String label, Node hostNode) {
            super(label, hostNode);
         }

         @Override
         public void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree jTree, DataOutputStream dataOut) {
            pop.add(new AbstractAction("Add Path") {
               @Override
               public void actionPerformed(ActionEvent e) {

                  final JTextField txtName = new JTextField();

                  final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref");
                  editor.addLabel("Name", 3, 1);
                  editor.add(txtName, 5, 1);

                  SwingUtil.showDialog(editor, app, "Add path", new SwingUtil.ConfirmAction() {
                     @Override
                     public void verifyAndCommit() throws Exception {

                        final String name = txtName.getText();
                        if (name.length() == 0) return;

                        getGraph().doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx) throws Throwable {

                              final Node newNode = newPath(txtName.getText());
                              relatePATHS(node, newNode);
                              final PathNode pathNode = new PathNode(newNode);
                              SwingUtilities.invokeLater(() -> addChildNode(pathNode, PathsNode.this, commandTree));
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showExceptionNoStack(app, throwable);
                           }
                        });
                     }
                  });
               }
            });
         }
      }

      private class CommandCategoryNode extends LabelNode {

         CommandCategoryNode(String label, Node node) {
            super(label, node);
         }

         @Override
         public void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree jTree, DataOutputStream dataOut) {
            pop.add(new AbstractAction("Add Command") {
               @Override
               public void actionPerformed(ActionEvent e) {

                  final JTextField txtName = new JTextField();
                  final JTextField txtCommand = new JTextField(txtTerminal.getText());

                  final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref");
                  editor.addLabel("Name", 3, 1);
                  editor.add(txtName, 5, 1);
                  editor.addLabel("Command", 3, 3);
                  editor.add(txtCommand, 5, 3);

                  SwingUtil.showDialog(editor, app, "Add command", new SwingUtil.ConfirmAction() {
                     @Override
                     public void verifyAndCommit() throws Exception {

                        final String name = txtName.getText();
                        final String command = txtCommand.getText();
                        if (name.length() == 0 || command.length() == 0) return;

                        getGraph().doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx) throws Throwable {

                              final CommandNode commandNode = new CommandNode(txtName.getText(), txtCommand.getText());
                              final Node newNode = getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), txtName.getText(), Properties.cmdCommand.name(), txtCommand.getText());
                              relateCOMMANDS(node, newNode);
                              SwingUtilities.invokeLater(() -> addChildNode(commandNode, CommandCategoryNode.this, commandTree));
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showExceptionNoStack(app, throwable);
                           }
                        });
                     }
                  });
               }
            });
         }
      }

      private class PathNode extends LabelNode {

         PathNode(Node pathNode) {
            super(getString(pathNode, AppMotif.Properties.name.name()), pathNode);
         }

         @Override
         public void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree jTree, DataOutputStream dataOut) {
            pop.add(new AbstractAction("cd to " + label) {
               @Override
               public void actionPerformed(ActionEvent e) {
                  runCommand(dataOut, new CommandNode(null, "cd " + label));
               }
            });

            pop.add(new AbstractAction("list " + label) {
               @Override
               public void actionPerformed(ActionEvent e) {
                  runCommand(dataOut, new CommandNode(null, "ls -la " + label));
               }
            });

            pop.add(new App.TransactionAction("Upload file here", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final File file = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
                  if (file == null) return;

                  final Node hostNode = other(node, singleIncoming(node, Relations.PATHS));
                  upload(getSession(hostNode), file.getAbsolutePath(), label);
               }
            });

            pop.add(new AbstractAction("Copy to terminal") {
               @Override
               public void actionPerformed(ActionEvent e) {
                  insertInTerminal(label);
               }
            });
         }
      }

      private class CommandNode extends LabelNode {

         final String command;

         CommandNode(String label, String command) {
            super(label);
            this.command = command;
         }

         @Override
         public void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree jTree, DataOutputStream dataOut) {
            pop.add(new AbstractAction("Run") {
               @Override
               public void actionPerformed(ActionEvent e) {
                  run(dataOut);
               }
            });

            pop.add(new AbstractAction("Run as sudo") {
               @Override
               public void actionPerformed(ActionEvent e) {
                  run(dataOut, true);
               }
            });

            pop.add(new AbstractAction("Copy to terminal") {
               @Override
               public void actionPerformed(ActionEvent e) {
                  SwingUtilities.invokeLater(() -> txtTerminal.setText(command));
               }
            });
         }

         void run(DataOutputStream dataOut) {
            run(dataOut, false);
         }

         CommandNode run(DataOutputStream dataOut, boolean asSudo) {
            try {
               dataOut.writeBytes((asSudo ? "sudo " : "") + command + "\n");
               dataOut.flush();
            } catch (Exception e1) {
               e1.printStackTrace();
            }
            return this;
         }
      }

      private class SignalCommandNode extends LabelNode {

         private final Integer signal;

         SignalCommandNode(String label, Integer signal) {
            super(label);
            this.signal = signal;
         }

         public SignalCommandNode run(DataOutputStream dataOut) {
            try {
               dataOut.write(signal);
               dataOut.flush();
            } catch (Exception e1) {
               e1.printStackTrace();
            }
            return this;
         }
      }
   }

   private final class CommandHistorListModel extends AbstractListModel<ChannelEditor.CommandNode> {

      private final Stack<ChannelEditor.CommandNode> commandStack;

      CommandHistorListModel(Stack<ChannelEditor.CommandNode> commandStack) {
         this.commandStack = commandStack;
      }

      void fireContenChanged() {
         fireContentsChanged(this, 0, commandStack.size());
      }

      @Override
      public int getSize() {
         return commandStack.size();
      }

      @Override
      public ChannelEditor.CommandNode getElementAt(int index) {
         return commandStack.get(index);
      }
   }

   private Node connectToHost(Node hostNode) {
      try {
         final Session session = getSession(hostNode);
         final Node sessionNode = newSession();
         sessions.put(uuidOf(sessionNode), session);
         relateSESSIONS(hostNode, sessionNode);
         fireNodesLoaded(sessionNode);

         return sessionNode;

      } catch (Throwable t) {
         SwingUtil.showExceptionNoStack(app, t);
      }
      return null;
   }

   @NotNull
   public static Session getSession(Node hostNode) throws JSchException {

      final String username = getUsernameProperty(hostNode);
      final String host = getIpProperty(hostNode);
      final int port = getPortProperty(hostNode, 22);

      final String keyPath = getPrivateKeyPathProperty(hostNode);
      final String password = getPasswordProperty(hostNode);
      return keyPath == null ? JschUtil.getSessionUsingPassword(username, host, port, password) : JschUtil.getSessionUsingPrivateKey(username, host, port, keyPath);
   }

   private void closeSession(NeoNode sessionNode) {
      app.events.firePropertyChange(AppEvents.NODES_CLOSED, Collections.singleton(sessionNode));
      closeSession(sessionNode.getNode());
   }

   private void closeSession(Node sessionNode) {

      outgoingCHANNELS(sessionNode, (relationship, other) -> closeChannel(other));

      if (sessions.containsKey(uuidOf(sessionNode))) {
         final Session session = sessions.remove(uuidOf(sessionNode));
         if (session.isConnected()) session.disconnect();
      }

      incomingSESSIONS(sessionNode, (relationship, other) -> relationship.delete());

      final NeoNode neoNode = app.workspace.layerNodes.get(sessionNode.getId());
      if (neoNode != null) fireNodeClosed(neoNode);

      app.model.deleteNodes(Collections.singleton(sessionNode));
   }

   private void closeChannel(Node channelNode) {

      if (channels.containsKey(uuidOf(channelNode))) {
         final ActiveChannel channel = channels.remove(uuidOf(channelNode));
         if (!channel.channel.isClosed()) channel.channel.disconnect();
         channel.editor.active.set(false);
      }

      incomingCHANNELS(channelNode, (relationship, other) -> relationship.delete());

      final NeoNode neoNode = app.workspace.layerNodes.get(channelNode.getId());
      if (neoNode != null) fireNodeClosed(neoNode);

      app.model.deleteNodes(Collections.singleton(channelNode));
   }

   private static void upload(Session session, String lfile, String rfile) throws Exception {
      upload(session, lfile, rfile, JschUtil.defaultIOListener(true));
   }

   private static void upload(Session session, String lfile, String rfile, JschUtil.IOListener uploadListener) throws Exception {
      JschUtil.upload(session, lfile, rfile, uploadListener);
   }

   public static void download(Session session, String lfile, String rfile) throws Exception {
      JschUtil.download(session, lfile, rfile, JschUtil.defaultIOListener(true));
   }

   private final class ActiveChannel {

      private final Channel channel;
      private final ChannelEditor editor;

      ActiveChannel(Channel channel, NeoNode sessionNode) throws IOException {
         this.channel = channel;
         this.editor = new ChannelEditor(channel, sessionNode);
      }

      ActiveChannel connect() {
         try {
            ((ChannelShell) channel).setPtyType("dumb");
            channel.connect();
         } catch (JSchException e) {
            throw new RuntimeException(e);
         }
         return this;
      }
   }
}