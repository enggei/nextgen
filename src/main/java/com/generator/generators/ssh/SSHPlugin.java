package com.generator.generators.ssh;

import com.generator.app.App;
import com.generator.app.AppEvents;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.neo.NeoModel;
import com.generator.util.SwingUtil;
import com.jcraft.jsch.*;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
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

import static com.generator.util.NeoUtil.*;

/**
 * Created 03.08.17.
 */
public class SSHPlugin extends Plugin {

   private enum Entities implements Label {
      Host, Session, Channel
   }

   private enum Relations implements RelationshipType {
      SESSIONS, CHANNELS
   }

   private enum Properties {
      username, password, privateKeyPath
   }

   private final Map<UUID, Session> sessions = new LinkedHashMap<>();
   private final Map<UUID, ActiveChannel> channels = new LinkedHashMap<>();

   public SSHPlugin(App app) {
      super(app, "SSH");

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

            final JTextField txtUri = new JTextField();
            final JTextField txtUsername = new JTextField();
            final JPasswordField txtPassword = new JPasswordField();
            final JTextField txtPrivateKeyPath = new JTextField();

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

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref,4dlu,pref,4dlu,pref");
            editor.addLabel("Uri", 3, 1);
            editor.add(txtUri, 5, 1);
            editor.addLabel("Username", 3, 3);
            editor.add(txtUsername, 5, 3);
            editor.add(radUserInfo, 1, 5);
            editor.addLabel("Password", 3, 5);
            editor.add(txtPassword, 5, 5);
            editor.add(radIdentityInfo, 1, 7);
            editor.addLabel("Private key path", 3, 7);
            editor.add(txtPrivateKeyPath, 5, 7);

            SwingUtil.showDialog(editor, app, "Login", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {

                  final String uri = txtUri.getText();
                  if (uri == null || uri.length() == 0) return;

                  if (radUserInfo.isSelected() && (txtUsername.getText().length() == 0 || txtPassword.getPassword().length == 0))
                     return;

                  if (radIdentityInfo.isSelected() && (txtUsername.getText().length() == 0 || txtPrivateKeyPath.getText().length() == 0 || !new File(txtPrivateKeyPath.getText().trim()).exists()))
                     return;

                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        if (radUserInfo.isSelected())
                           fireNodesLoaded(getGraph().newNode(Entities.Host, AppMotif.Properties.name.name(), uri, Properties.username.name(), txtUsername.getText(), Properties.password.name(), new String(txtPassword.getPassword())));
                        else if (radIdentityInfo.isSelected())
                           fireNodesLoaded(getGraph().newNode(Entities.Host, AppMotif.Properties.name.name(), uri, Properties.username.name(), txtUsername.getText(), Properties.privateKeyPath.name(), txtPrivateKeyPath.getText().trim()));
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

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      if (hasLabel(neoNode.getNode(), Entities.Host)) {

         pop.add(new App.TransactionAction("Connect", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               connectToHost(neoNode.getNode());
            }
         });

         if (!sessions.isEmpty()) {

            pop.add(new App.TransactionAction("Close all sessions", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  outgoing(neoNode.getNode(), Relations.SESSIONS).forEach(sessionRelation -> closeSession(other(neoNode.getNode(), sessionRelation)));
               }
            });
         }

      } else if (hasLabel(neoNode.getNode(), Entities.Session)) {

         if (sessions.containsKey(uuidOf(neoNode.getNode()))) {

            pop.add(new App.TransactionAction("Open shell", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Session session = sessions.get(uuidOf(neoNode.getNode()));
                  final Channel channel = session.openChannel("shell");

                  final ActiveChannel activeChannel = new ActiveChannel(channel).connect();

                  final Node newNode = getGraph().newNode(Entities.Channel, AppMotif.Properties.name.name(), "shell");
                  relate(neoNode.getNode(), newNode, Relations.CHANNELS);
                  channels.put(uuidOf(newNode), activeChannel);
                  fireNodesLoaded(newNode);
               }
            });

            pop.add(new App.TransactionAction("Close", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  closeSession(neoNode);
               }
            });
         }

      } else if (hasLabel(neoNode.getNode(), Entities.Channel)) {

         pop.add(new App.TransactionAction("Close", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               closeChannel(neoNode);
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

      final AtomicBoolean active = new AtomicBoolean(true);
      private final StringBuilder cache = new StringBuilder();
      private final Stack<CommandNode> commandStack = new Stack<>();
      private final JTree commandTree;
      private final JList<CommandNode> historyList = new JList<>();

      private char[] sudoPassword = null;
      private String install = null;

      ChannelEditor(Channel channel) throws IOException {
         super(new BorderLayout());

         final JTextField txtCommand = new JTextField(15);
         txtCommand.setFont(new Font("Hack", Font.PLAIN, 10));

         final JTextArea txtOutput = new JTextArea();
         txtOutput.setFont(new Font("Hack", Font.PLAIN, 10));
         txtOutput.setEditable(false);

         final DataInputStream dataIn = new DataInputStream(channel.getInputStream());
         final DataOutputStream dataOut = new DataOutputStream(channel.getOutputStream());

         txtCommand.addActionListener(e -> {

            final String trim = txtCommand.getText().trim();
            if (trim.length() == 0) return;

            runCommand(dataOut, new CommandNode("Run " + trim, trim));
            txtCommand.setText("");
         });

         txtCommand.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

               final String trim = txtCommand.getText().trim();

               if (SwingUtilities.isRightMouseButton(e)) {
                  final JPopupMenu pop = new JPopupMenu();

                  if (trim.length() > 0) {

                     pop.add(new AbstractAction("Run " + trim) {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           runCommand(dataOut, new CommandNode("Run " + trim, trim));
                           //txtCommand.setText("");
                        }
                     });

                     pop.add(new AbstractAction("Run as sudo " + trim) {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           runCommand(dataOut, new CommandNode("Run " + trim, trim), true);
                           //txtCommand.setText("");
                        }
                     });

                     pop.add(new AbstractAction("Clear") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           txtCommand.setText("");
                        }
                     });
                  }

                  if (SwingUtil.fromClipboard() != null) {
                     pop.add(new AbstractAction("Insert from clipboard") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final int caretPosition = txtCommand.getCaretPosition();
                           try {
                              txtCommand.getDocument().insertString(caretPosition, SwingUtil.fromClipboard(), null);
                           } catch (BadLocationException e1) {
                              System.out.println("Could not insert string at caret position " + caretPosition + " : " + e1.getMessage());
                           }
                        }
                     });
                  }

                  SwingUtilities.invokeLater(() -> pop.show(txtCommand, e.getX(), e.getY()));
               }
            }
         });

         txtOutput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (SwingUtilities.isRightMouseButton(e)) {
                  final JPopupMenu pop = new JPopupMenu();

                  if (txtOutput.getSelectedText() != null && txtOutput.getSelectedText().length() > 0) {
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
                  }

                  pop.add(new AbstractAction("Clear") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        txtOutput.setText("");
                        cache.delete(0, cache.length());
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

                     if (s.contains("[sudo] password for ") && sudoPassword == null) {
                        final char[] p = SwingUtil.showPasswordDialog(app);
                        if (p == null) return;
                        this.sudoPassword = p;
                        dataOut.writeBytes(new String(p) + "\n");
                        dataOut.flush();

                     } else if (s.endsWith("Do you want to continue? [Y/n] ")) {

                        final boolean yes = SwingUtil.showConfirmDialog(app, "Do you want to continue ?");
                        dataOut.writeBytes(yes ? "Y\n" : "n\n");
                        dataOut.flush();

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

         commandTree = new JTree(getCommands()) {{

            setRootVisible(true);

            setCellRenderer(new DefaultTreeCellRenderer() {
               @Override
               public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                  final CommandNode nodeEntry = (CommandNode) value;
                  return super.getTreeCellRendererComponent(tree, nodeEntry.label, sel, expanded, leaf, row, hasFocus);
               }
            });

            addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  final TreePath selectionPath = ((JTree) e.getSource()).getSelectionPath();
                  if (selectionPath == null) return;
                  final CommandNode selectedNode = (CommandNode) selectionPath.getLastPathComponent();
                  if (selectedNode == null) return;

                  if (selectedNode.isRunnable()) {

                     // do not run last command if same as last
                     if (commandStack.isEmpty() || !selectedNode.equals(commandStack.peek())) {
                        runCommand(dataOut, selectedNode);

                     } else {

                        // allow to run command by right-click Run...
                        if (SwingUtilities.isRightMouseButton(e)) {
                           final JPopupMenu pop = new JPopupMenu();

                           pop.add(new AbstractAction("Run") {
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                 selectedNode.run(dataOut);
                              }
                           });

                           pop.add(new AbstractAction("Run as sudo") {
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                 selectedNode.run(dataOut, true);
                              }
                           });

                           pop.add(new AbstractAction("Copy to terminal") {
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                 SwingUtilities.invokeLater(() -> txtCommand.setText(selectedNode.command));
                              }
                           });

                           SwingUtilities.invokeLater(() -> pop.show(commandTree, e.getX(), e.getY()));
                        }
                     }
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
               final CommandNode commandNode = historyList.getSelectedValue();
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
         add(txtCommand, BorderLayout.NORTH);
      }

      private void runCommand(DataOutputStream dataOut, CommandNode commandNode) {
         runCommand(dataOut, commandNode, false);
      }

      private void runCommand(DataOutputStream dataOut, CommandNode commandNode, boolean asSudo) {
         commandStack.push(commandNode.run(dataOut, asSudo));
         ((CommandHistorListModel) historyList.getModel()).fireContenChanged();
      }

      @NotNull
      private CommandNode getCommands() {
         final CommandNode commands = new CommandNode("Commands");

         final CommandNode directoryCommands = new CommandNode("Directories");
         directoryCommands.add(new CommandNode("List dir", "ls -ltr"));
         directoryCommands.add(new CommandNode("Show current directory", "pwd"));
         directoryCommands.add(new CommandNode("Go home", "cd ~"));
         commands.add(directoryCommands);

         // todo:
         // https://www.linuxtrainingacademy.com/linux-commands-cheat-sheet/

         final CommandNode system = new CommandNode("System");
         system.add(new CommandNode("Disk usage", "df -h"));
         system.add(new CommandNode("Top", "top"));
         system.add(new CommandNode("Kernel", "uname -a"));
         system.add(new CommandNode("Uptime", "uptime"));
         system.add(new CommandNode("Linux version", "lsb_release -a"));
         system.add(new CommandNode("ifconfig", "ifconfig"));
         system.add(new CommandNode("Wireless", "iwconfig"));
         system.add(new CommandNode("Processes", "ps"));
         system.add(new CommandNode("Show system host name", "hostname"));
         system.add(new CommandNode("Display the IP addresses of the host", "hostname -I"));
         system.add(new CommandNode("Show system reboot history", "last reboot"));
         system.add(new CommandNode("Show the current date and time", "date"));
         system.add(new CommandNode("Show this month's calendar", "cal"));
         system.add(new CommandNode("Display who is online", "w"));
         system.add(new CommandNode("Who you are logged in as", "whoami"));
         system.add(new CommandNode("Reboot now", "reboot now"));
         commands.add(system);

         final CommandNode hardware = new CommandNode("Hardware");
         hardware.add(new CommandNode("Display messages in kernel ring buffer", "dmesg"));
         hardware.add(new CommandNode("Display CPU information", "cat /proc/cpuinfo"));
         hardware.add(new CommandNode("Display memory information", "cat /proc/meminfo"));
         hardware.add(new CommandNode("Display free and used memory ( -h for human readable, -m for MB, -g for GB.)", "free -h"));
         hardware.add(new CommandNode("Display PCI devices", "lspci -tv"));
         hardware.add(new CommandNode("Display USB devices", "lsusb -tv"));
         hardware.add(new CommandNode("Display DMI/SMBIOS (hardware info) from the BIOS", "dmidecode"));
         hardware.add(new CommandNode("Show info about disk sda", "hdparm -i /dev/sda"));
         hardware.add(new CommandNode("Perform a read speed test on disk sda", "hdparm -tT /dev/sda"));
         hardware.add(new CommandNode("Test for unreadable blocks on disk sda", "badblocks -s /dev/sda"));
         system.add(new CommandNode("HAL", "lshal"));
         system.add(new CommandNode("Hardware", "lshw"));
         commands.add(hardware);

         final CommandNode monitoring = new CommandNode("Monitoring");
         monitoring.add(new CommandNode("Display and manage the top processes", "top"));
         monitoring.add(new CommandNode("Interactive process viewer (top alternative)", "htop"));
         monitoring.add(new CommandNode("Display processor related statistics", "mpstat 1"));
         monitoring.add(new CommandNode("Display virtual memory statistics", "vmstat 1"));
         monitoring.add(new CommandNode("Display I/O statistics", "iostat 1"));
         monitoring.add(new CommandNode("Display the last 100 syslog messages", "tail -n 100 /var/log/syslog"));
         monitoring.add(new CommandNode("Capture and display all packets on interface eth0", "tcpdump -i eth0"));
         monitoring.add(new CommandNode("Monitor all traffic on port 80 ( HTTP )", "tcpdump -i eth0 'port 80'"));
         monitoring.add(new CommandNode("List all open files on the system", "lsof"));
         monitoring.add(new CommandNode("List files opened by user", "lsof -u user"));
         monitoring.add(new CommandNode("Execute \"df -h\", showing periodic updates", "watch df -h"));
         commands.add(monitoring);

         final CommandNode aptGet = new CommandNode("Apt-get");
         aptGet.add(new CommandNode("Update", "apt-get update"));
         aptGet.add(new CommandNode("Upgrade", "apt-get upgrade"));


         final CommandNode docker = new CommandNode("Docker");
         docker.add(new CommandNode("Running containers", "sudo docker ps"));
         commands.add(docker);

         return commands;
      }

      private class CommandNode extends DefaultMutableTreeNode {

         private String label = "";
         private final String command;

         CommandNode(String label) {
            this(label, null);
         }

         CommandNode(String label, String command) {
            this.label = label;
            this.command = command;
         }

         boolean isRunnable() {
            return command != null;
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

         CommandNode run(DataOutputStream dataOut) {
            return run(dataOut, false);
         }

         @Override
         public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CommandNode that = (CommandNode) o;

            if (this.command == null && that.command == null) return this.label.equals(that.label);
            return command != null && command.equals(that.command);
         }

         @Override
         public int hashCode() {
            return command != null ? command.hashCode() : label.hashCode();
         }
      }

      private class SignalCommandNode extends CommandNode {

         private final Integer signal;

         SignalCommandNode(String label, Integer signal) {
            super(label);
            this.signal = signal;
         }

         @Override
         boolean isRunnable() {
            return true;
         }

         @Override
         public CommandNode run(DataOutputStream dataOut) {
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

   private void connectToHost(Node hostNode) {
      try {

         final JSch jSch = new JSch();

         final Session session = jSch.getSession(getString(hostNode, Properties.username.name()), getString(hostNode, AppMotif.Properties.name.name()));

         final String privateKeyPath = getString(hostNode, Properties.privateKeyPath.name());
         if (privateKeyPath != null) {
            jSch.addIdentity(privateKeyPath);
         } else {
            session.setUserInfo(new SftpUserInfo(getString(hostNode, Properties.password.name())));
            session.setPassword(getString(hostNode, Properties.password.name()));
         }

         java.util.Properties config = new java.util.Properties();
         config.put("StrictHostKeyChecking", "no");
         session.setConfig(config);

         session.connect();

         final Node sessionNode = getGraph().newNode(Entities.Session);
         relate(hostNode, sessionNode, Relations.SESSIONS);
         fireNodesLoaded(sessionNode);
         sessions.put(uuidOf(sessionNode), session);

      } catch (Throwable t) {
         SwingUtil.showExceptionNoStack(app, t);
      }
   }

   private void closeSession(NeoNode sessionNode) {
      app.events.firePropertyChange(AppEvents.NODES_CLOSED, Collections.singleton(sessionNode));
      closeSession(sessionNode.getNode());
   }

   private void closeSession(Node sessionNode) {

      outgoing(sessionNode, Relations.CHANNELS).forEach(channelRelation -> closeChannel(other(sessionNode, channelRelation)));

      if (sessions.containsKey(uuidOf(sessionNode))) {
         final Session session = sessions.remove(uuidOf(sessionNode));
         if (session.isConnected()) session.disconnect();
      }

      incoming(sessionNode, Relations.SESSIONS).forEach(Relationship::delete);


      app.model.deleteNodes(Collections.singleton(sessionNode));
   }

   private void closeChannel(NeoNode channelNode) {
      app.events.firePropertyChange(AppEvents.NODES_CLOSED, Collections.singleton(channelNode));
      closeChannel(channelNode.getNode());
   }

   private void closeChannel(Node channelNode) {

      if (channels.containsKey(uuidOf(channelNode))) {
         final ActiveChannel channel = channels.remove(uuidOf(channelNode));
         if (!channel.channel.isClosed()) channel.channel.disconnect();
         channel.editor.active.set(false);
      }

      incoming(channelNode, Relations.CHANNELS).forEach(Relationship::delete);

      app.model.deleteNodes(Collections.singleton(channelNode));
   }

   private final class ActiveChannel {

      private final Channel channel;
      private final ChannelEditor editor;

      ActiveChannel(Channel channel) throws IOException {
         this.channel = channel;
         this.editor = new ChannelEditor(channel);
      }

      ActiveChannel connect() {
         try {
            ((ChannelShell)channel).setPtyType("dumb");
            channel.connect();
         } catch (JSchException e) {
            throw new RuntimeException(e);
         }
         return this;
      }
   }

   private final class SftpUserInfo implements UserInfo {

      private final String password;

      private SftpUserInfo(String password) {
         this.password = password;
      }

      @Override
      public String getPassphrase() {
         return null;
      }

      @Override
      public String getPassword() {
         return password;
      }

      @Override
      public boolean promptPassphrase(String message) {
         return false;
      }

      @Override
      public boolean promptPassword(String message) {
         return false;
      }

      @Override
      public boolean promptYesNo(String message) {
         return true;
      }

      @Override
      public void showMessage(String message) {
      }
   }
}