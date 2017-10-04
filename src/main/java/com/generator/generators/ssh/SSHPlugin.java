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

      private String password = null;

      ChannelEditor(Channel channel) throws IOException {
         super(new BorderLayout());

         final JTextField txtCommand = new JTextField(15);
         txtCommand.setFont(new Font("Hack", Font.PLAIN, 10));

         final JTextArea txtOutput = new JTextArea();
         txtOutput.setFont(new Font("Hack", Font.PLAIN, 10));

         final DataInputStream dataIn = new DataInputStream(channel.getInputStream());
         final DataOutputStream dataOut = new DataOutputStream(channel.getOutputStream());

         txtCommand.addActionListener(e -> {

            final String trim = txtCommand.getText().trim();
            if (trim.length() == 0) return;

            try {
               dataOut.writeBytes(trim + "\n");
               dataOut.flush();
               txtCommand.setText("");
            } catch (Throwable e1) {
               txtOutput.setText(SwingUtil.printStackTrace(e1.getCause()));
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
                           commandStack.push(new CommandNode("Run " + txtOutput.getSelectedText(), txtOutput.getSelectedText()).run(dataOut));
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

                  pop.add(new AbstractAction("Run Ctrl+C") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        commandStack.push(new SignalCommandNode("Ctrl+C", 3).run(dataOut));
                     }
                  });

                  SwingUtilities.invokeLater(() -> pop.show(txtOutput, e.getX(), e.getY()));
               }
            }
         });

         new Thread(() -> {
            try {

               byte[] bytes = new byte[1024];
               while (active.get()) {
                  if (dataIn.available() > 0) {
                     final int read = dataIn.read(bytes);
                     cache.append(new String(bytes, 0, read));
                     SwingUtilities.invokeLater(() -> txtOutput.setText(cache.toString()));

                     //todo: use expect ?

                     if (cache.toString().contains("[sudo] password for ") && password == null) {
                        final String s = JOptionPane.showInputDialog("Sudo password");
                        if (s == null || s.length() == 0) return;
                        this.password = s;
                        dataOut.writeBytes(s + "\n");
                        dataOut.flush();
                     }

                  }
                  Thread.sleep(500L);
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
                        commandStack.push(selectedNode);
                        selectedNode.run(dataOut);
                     } else {

                        if (SwingUtilities.isRightMouseButton(e)) {
                           final JPopupMenu pop = new JPopupMenu();

                           pop.add(new AbstractAction("Run " + selectedNode.label) {
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                 selectedNode.run(dataOut);
                              }
                           });

                           SwingUtilities.invokeLater(() -> pop.show(commandTree, e.getX(), e.getY()));
                        }
                     }
                  }
               }
            });
         }};

         final JScrollPane newLeftComponent = new JScrollPane(commandTree);
         newLeftComponent.getViewport().setPreferredSize(new Dimension(250, 1024));
         newLeftComponent.getViewport().setSize(new Dimension(250, 1024));

         final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, newLeftComponent, new JScrollPane(txtOutput));
         add(splitPane, BorderLayout.CENTER);
         add(txtCommand, BorderLayout.NORTH);
      }

      @NotNull
      private CommandNode getCommands() {
         final CommandNode commands = new CommandNode("Commands");

         final CommandNode directoryCommands = new CommandNode("Directories");
         directoryCommands.add(new CommandNode("List dir", "ls -ltr"));
         directoryCommands.add(new CommandNode("Show current directory", "pwd"));
         directoryCommands.add(new CommandNode("Go home", "cd ~"));
         commands.add(directoryCommands);

//         final CommandNode context = new CommandNode("Context");
//         commands.add(context);
         final CommandNode system = new CommandNode("System");
         system.add(new CommandNode("Disk usage", "df -h"));
         system.add(new CommandNode("Memory usage", "free -m"));
         system.add(new CommandNode("Top", "top"));
         system.add(new CommandNode("Kernel", "uname -a"));
         system.add(new CommandNode("Linux version", "lsb_release -a"));
         system.add(new CommandNode("Network", "ifconfig"));
         system.add(new CommandNode("Wireless", "iwconfig"));
         system.add(new CommandNode("Processes", "ps"));
         system.add(new CommandNode("PCI buses", "lspci"));
         system.add(new CommandNode("USB buses", "lsusb"));
         system.add(new CommandNode("HAL", "lshal"));
         system.add(new CommandNode("Hardware", "lshw"));
         commands.add(system);

         final CommandNode search = new CommandNode("Search");
         search.add(new CommandNode("Grep", "grep"));
         search.add(new CommandNode("Sed", "sed"));
         commands.add(search);

         final CommandNode history = new CommandNode("History");
         commands.add(history);

         final CommandNode docker = new CommandNode("Docker");
         docker.add(new CommandNode("Running containers", "sudo docker ps"));
         commands.add(docker);

         final CommandNode signalCommands = new CommandNode("Signals");
         signalCommands.add(new SignalCommandNode("Ctrl+C", 3));
         commands.add(signalCommands);

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

         CommandNode run(DataOutputStream dataOut) {
            try {
               dataOut.writeBytes(command + "\n");
               dataOut.flush();
            } catch (Exception e1) {
               e1.printStackTrace();
            }
            return this;
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
         SwingUtil.showException(app, t);
      }
   }

   private void closeSession(NeoNode sessionNode) {
      app.events.firePropertyChange(AppEvents.NODES_CLOSED, sessionNode);
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
      app.events.firePropertyChange(AppEvents.NODES_CLOSED, channelNode);
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