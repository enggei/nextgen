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

import static com.generator.util.NeoUtil.*;

/**
 * Created 03.08.17.
 */
public class SSHPlugin extends Plugin {

   private enum Entities implements Label {
      Host, Session, Channel, Command, CommandRoot, CommandCategory
   }

   private enum Relations implements RelationshipType {
      SESSIONS, CHANNELS, COMMANDS, CATEGORIES
   }

   private enum Properties {
      ip, username, password, port, privateKeyPath, cmdCommand, cmdCategory
   }

   private final Map<UUID, Session> sessions = new LinkedHashMap<>();
   private final Map<UUID, ActiveChannel> channels = new LinkedHashMap<>();

   public SSHPlugin(App app) {
      super(app, "SSH");

      // add command-root-node
      getGraph().findOrCreate(Entities.CommandRoot, AppMotif.Properties.name.name(), Entities.CommandRoot.name());

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

                  int port = parsePort(txtPort.getText());

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

               private int parsePort(final String input) {
                  int port = 22;

                  try {
                     port = Integer.parseInt(input);
                     if (port < 1 || port > 65535) port = 22;
                  } catch (NumberFormatException e) {
                     System.err.println("port is not an integer! Got: " + input);
                  }

                  return port;
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

                  // passing in session-node to retrieve host and host-commands:
                  final ActiveChannel activeChannel = new ActiveChannel(channel, neoNode).connect();

                  final Node newNode = getGraph().newNode(Entities.Channel, Properties.ip.name(), "shell");
                  relate(neoNode.getNode(), newNode, Relations.CHANNELS);
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

      } else if (hasLabel(neoNode.getNode(), Entities.Channel)) {

         if (channels.containsKey(uuidOf(neoNode.getNode()))) {
            pop.add(new App.TransactionAction("Close Channel", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  closeChannel(neoNode.getNode());
               }
            });
         }

      } else if (hasLabel(neoNode.getNode(), Entities.CommandRoot)) {

         pop.add(new App.TransactionAction("Add Command", app) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final JTextField txtName = new JTextField();
               final JTextField txtCommand = new JTextField();
               final JTextField txtCategory = new JTextField();

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref,4dlu,pref,4dlu,pref");
               editor.addLabel("Name", 3, 1);
               editor.add(txtName, 5, 1);
               editor.addLabel("Command", 3, 3);
               editor.add(txtCommand, 5, 3);
               editor.addLabel("Category", 3, 5);
               editor.add(txtCategory, 5, 5);

               SwingUtil.showDialog(editor, app, "Add Command", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {

                     final String name = txtName.getText();
                     final String command = txtCommand.getText();
                     if (name.length() == 0 || command.length() == 0) return;

                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           final Set<Node> nodesToLoad = new LinkedHashSet<>();
                           final Node commandCategoryNode = getGraph().findOrCreate(Entities.CommandCategory, AppMotif.Properties.name.name(), txtCategory.getText().trim());
                           nodesToLoad.add(commandCategoryNode);
                           relate(neoNode.getNode(), commandCategoryNode, Relations.CATEGORIES);

                           final Node commandNode = getGraph().findOrCreate(Entities.Command, AppMotif.Properties.name.name(), txtName.getText(), Properties.cmdCommand.name(), txtCommand.getText());
                           nodesToLoad.add(commandNode);
                           relate(commandCategoryNode, commandCategoryNode, Relations.COMMANDS);

                           fireNodesLoaded(nodesToLoad);
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

         txtTerminal.setFont(new Font("Hack", Font.PLAIN, 10));

         txtOutput.setFont(new Font("Hack", Font.PLAIN, 10));
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
                           //txtTerminal.setText("");
                        }
                     });

                     final Set<LabelNode> categoryNodes = getCategories((LabelNode) commandTree.getModel().getRoot());
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
                                          relate(categoryNode.node, newNode, Relations.COMMANDS);

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


            private Set<LabelNode> getCategories(LabelNode root) {
               final Set<LabelNode> set = new TreeSet<>();
               for (int i = 0; i < root.getChildCount(); i++)
                  set.add((LabelNode) root.getChildAt(i));
               return set;
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

                     // todo use ExpectIt here ?
                     if (s.contains("[sudo] password for ") && sudoPassword == null) {
                        final char[] p = SwingUtil.showPasswordDialog(app);
                        if (p == null) return;
                        this.sudoPassword = p;
                        runCommand(dataOut, new CommandNode("passwd", new String(p)));

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

         commandTree = new JTree(getCommands(sessionNode)) {{

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
            if (selectedText!=null && selectedText.length() > 0) {
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
      private LabelNode getCommands(NeoNode sessionNode) {

         final LabelNode commands = new LabelNode("Commands");

         // commands for host:
         final Node hostNode = other(sessionNode.getNode(), singleIncoming(sessionNode.getNode(), Relations.SESSIONS));
         final LabelNode hostCommands = new LabelNode("Host", hostNode);
         outgoing(hostNode, Relations.COMMANDS).forEach(commandRelation -> {
            final Node commandNode = other(hostNode, commandRelation);
            hostCommands.add(new CommandNode(getString(commandNode, AppMotif.Properties.name.name()), getString(commandNode, Properties.cmdCommand.name())));
         });
         commands.add(hostCommands);

         // all general-commands:
         final Node commandRootNode = getGraph().findNode(Entities.CommandRoot, AppMotif.Properties.name.name(), Entities.CommandRoot.name());
         outgoing(commandRootNode, Relations.CATEGORIES).forEach(categoryRelation -> {

            final Node categoryNode = other(commandRootNode, categoryRelation);
            final String categoryName = getString(categoryNode, AppMotif.Properties.name.name());
            final LabelNode labelNode = new LabelNode(categoryName, categoryNode);
            commands.add(labelNode);

            outgoing(categoryNode, Relations.COMMANDS).forEach(commandRelation -> {
               final Node commandNode = other(categoryNode, commandRelation);
               labelNode.add(new CommandNode(getString(commandNode, AppMotif.Properties.name.name()), getString(commandNode, Properties.cmdCommand.name())));
            });
         });

//         final LabelNode directoryCommands = new LabelNode("Directories");
//         directoryCommands.add(new CommandNode("List dir", "ls -ltr"));
//         directoryCommands.add(new CommandNode("Show current directory", "pwd"));
//         directoryCommands.add(new CommandNode("Go home", "cd ~"));
//         commands.add(directoryCommands);
// todo:
//https://www.linuxtrainingacademy.com/linux-commands-cheat-sheet/
//         final LabelNode system = new LabelNode("System");
//         system.add(new CommandNode("Disk usage", "df -h"));
//         system.add(new CommandNode("Top", "top"));
//         system.add(new CommandNode("Kernel", "uname -a"));
//         system.add(new CommandNode("Uptime", "uptime"));
//         system.add(new CommandNode("Linux version", "lsb_release -a"));
//         system.add(new CommandNode("ifconfig", "ifconfig"));
//         system.add(new CommandNode("Wireless", "iwconfig"));
//         system.add(new CommandNode("Processes", "ps"));
//         system.add(new CommandNode("Show system host name", "hostname"));
//         system.add(new CommandNode("Display the IP addresses of the host", "hostname -I"));
//         system.add(new CommandNode("Show system reboot history", "last reboot"));
//         system.add(new CommandNode("Show the current date and time", "date"));
//         system.add(new CommandNode("Show this month's calendar", "cal"));
//         system.add(new CommandNode("Display who is online", "w"));
//         system.add(new CommandNode("Who you are logged in as", "whoami"));
//         system.add(new CommandNode("Reboot now", "reboot now"));
//         commands.add(system);

//         final LabelNode hardware = new LabelNode("Hardware");
//         hardware.add(new CommandNode("Display messages in kernel ring buffer", "dmesg"));
//         hardware.add(new CommandNode("Display CPU information", "cat /proc/cpuinfo"));
//         hardware.add(new CommandNode("Display memory information", "cat /proc/meminfo"));
//         hardware.add(new CommandNode("Display free and used memory ( -h for human readable, -m for MB, -g for GB.)", "free -h"));
//         hardware.add(new CommandNode("Display PCI devices", "lspci -tv"));
//         hardware.add(new CommandNode("Display USB devices", "lsusb -tv"));
//         hardware.add(new CommandNode("Display DMI/SMBIOS (hardware info) from the BIOS", "dmidecode"));
//         hardware.add(new CommandNode("Show info about disk sda", "hdparm -i /dev/sda"));
//         hardware.add(new CommandNode("Perform a read speed test on disk sda", "hdparm -tT /dev/sda"));
//         hardware.add(new CommandNode("Test for unreadable blocks on disk sda", "badblocks -s /dev/sda"));
//         system.add(new CommandNode("HAL", "lshal"));
//         system.add(new CommandNode("Hardware", "lshw"));
//         commands.add(hardware);

//         final LabelNode monitoring = new LabelNode("Monitoring");
//         monitoring.add(new CommandNode("Display and manage the top processes", "top"));
//         monitoring.add(new CommandNode("Interactive process viewer (top alternative)", "htop"));
//         monitoring.add(new CommandNode("Display processor related statistics", "mpstat 1"));
//         monitoring.add(new CommandNode("Display virtual memory statistics", "vmstat 1"));
//         monitoring.add(new CommandNode("Display I/O statistics", "iostat 1"));
//         monitoring.add(new CommandNode("Display the last 100 syslog messages", "tail -n 100 /var/log/syslog"));
//         monitoring.add(new CommandNode("Capture and display all packets on interface eth0", "tcpdump -i eth0"));
//         monitoring.add(new CommandNode("Monitor all traffic on port 80 ( HTTP )", "tcpdump -i eth0 'port 80'"));
//         monitoring.add(new CommandNode("List all open files on the system", "lsof"));
//         monitoring.add(new CommandNode("List files opened by user", "lsof -u user"));
//         monitoring.add(new CommandNode("Execute \"df -h\", showing periodic updates", "watch df -h"));
//         commands.add(monitoring);

//         final LabelNode aptGet = new LabelNode("Apt-get");
//         aptGet.add(new CommandNode("Update", "apt-get update"));
//         aptGet.add(new CommandNode("Upgrade", "apt-get upgrade"));


//         final LabelNode docker = new LabelNode("Docker");
//         docker.add(new CommandNode("Running containers", "sudo docker ps"));
//         commands.add(docker);

         return commands;
      }

      private class LabelNode extends DefaultMutableTreeNode implements Comparable<LabelNode> {

         final String label;
         private final Node node;

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

            if (isRoot()) {

               pop.add(new AbstractAction("Add Category") {
                  @Override
                  public void actionPerformed(ActionEvent e) {

                     final JTextField txtName = new JTextField();

                     final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("10dlu,4dlu,75dlu,4dlu,100dlu", "pref");
                     editor.addLabel("Name", 3, 1);
                     editor.add(txtName, 5, 1);

                     SwingUtil.showDialog(editor, app, "Add command", new SwingUtil.ConfirmAction() {
                        @Override
                        public void verifyAndCommit() throws Exception {

                           final String name = txtName.getText();
                           if (name.length() == 0) return;

                           getGraph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {

                                 final Node newNode = getGraph().findOrCreate(Entities.CommandCategory, AppMotif.Properties.name.name(), txtName.getText());
                                 relate(getGraph().findOrCreate(Entities.CommandRoot, AppMotif.Properties.name.name(), Entities.CommandRoot.name()), newNode, Relations.CATEGORIES);

                                 SwingUtilities.invokeLater(() -> addChildNode(new LabelNode(name, newNode), LabelNode.this, commandTree));
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

            } else {
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
                                 relate(node, newNode, Relations.COMMANDS);

                                 SwingUtilities.invokeLater(() -> addChildNode(commandNode, LabelNode.this, commandTree));
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

         CommandNode run(DataOutputStream dataOut) {
            run(dataOut, false);
            return this;
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

   private void connectToHost(Node hostNode) {
      try {

         final JSch jSch = new JSch();

         final Session session = jSch.getSession(
               getString(hostNode, Properties.username.name()),
               getString(hostNode, Properties.ip.name()),
               hostNode.hasProperty(Properties.port.name()) ? (int) hostNode.getProperty(Properties.port.name()) : 22);

         final String privateKeyPath = getString(hostNode, Properties.privateKeyPath.name());
         if (privateKeyPath != null) {
            jSch.addIdentity(privateKeyPath);
         } else {
            session.setUserInfo(new ChannelUserInfo(getString(hostNode, Properties.password.name())));
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

      incoming(channelNode, Relations.CHANNELS).forEach(Relationship::delete);

      final NeoNode neoNode = app.workspace.layerNodes.get(channelNode.getId());
      if (neoNode != null) fireNodeClosed(neoNode);

      app.model.deleteNodes(Collections.singleton(channelNode));
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

   private final class ChannelUserInfo implements UserInfo {

      private final String password;

      private ChannelUserInfo(String password) {
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