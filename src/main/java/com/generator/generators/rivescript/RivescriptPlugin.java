package com.generator.generators.rivescript;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.neo.NeoModel;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import com.rivescript.ConcatMode;
import com.rivescript.Config;
import com.rivescript.RiveScript;
import com.rivescript.session.ConcurrentHashMapSessionManager;
import com.rivescript.session.SessionManager;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeSupport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static com.generator.util.NeoUtil.*;

/**
 * Created 21.10.17.
 */
public class RivescriptPlugin extends Plugin {

   public enum Entities implements Label {
      Bot, Script
   }

   public enum Relations implements RelationshipType {
      SCRIPTS
   }

   public enum Properties {
      script
   }

   private final Map<UUID, Bot> sessions = new LinkedHashMap<>();
   private PropertyChangeSupport botListener = new PropertyChangeSupport(this);

   public RivescriptPlugin(App app) {
      super(app, "Rivescript");

      final Node generatorBot = getGraph().findOrCreate(Entities.Bot, AppMotif.Properties.name.name(), "GeneratorBot");
      final Node generatorScript = getGraph().findOrCreate(Entities.Script, AppMotif.Properties.name.name(), "GeneratorScript");

//      getGraph().newNode(Label.label(""));


   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Script);

      menu.add(new App.TransactionAction("New Bot", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            final Node scriptNode = getGraph().newNode(Entities.Bot, AppMotif.Properties.name.name(), name);
            fireNodesLoaded(scriptNode);
         }
      });

      menu.add(new App.TransactionAction("New Script", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            final Node scriptNode = getGraph().newNode(Entities.Script, AppMotif.Properties.name.name(), name);
            fireNodesLoaded(scriptNode);
         }
      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      if (hasLabel(neoNode.getNode(), Entities.Bot)) {

         if (sessions.containsKey(uuidOf(neoNode.getNode()))) {
            pop.add(new App.TransactionAction("Restart", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  refreshBot(neoNode.getNode());
               }
            });
         }

         for (NeoNode selectedNode : selectedNodes) {
            if (hasLabel(selectedNode.getNode(), Entities.Script)) {
               if (NeoUtil.isRelated(neoNode.getNode(), selectedNode.getNode(), Relations.SCRIPTS)) continue;

               pop.add(new App.TransactionAction("Add Script to Bot", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     relate(neoNode.getNode(), selectedNode.getNode(), Relations.SCRIPTS);
                     refreshBot(neoNode.getNode());
                  }
               });
            }
         }
      }
   }

   private void refreshBot(Node botNode) {
      if (sessions.containsKey(uuidOf(botNode)))
         sessions.put(uuidOf(botNode), new Bot(botNode));
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      if (hasLabel(neoNode.getNode(), Entities.Script)) {
         return new ScriptEditor(neoNode);
      } else if (hasLabel(neoNode.getNode(), Entities.Bot)) {
         sessions.computeIfAbsent(uuidOf(neoNode.getNode()), k -> new Bot(neoNode.getNode()));
         return new BotEditor(neoNode);
      }
      return null;
   }


   private final class Bot {

      private final RiveScript bot;
      private final StringBuilder currentConversation = new StringBuilder("");
      private final UUID uuid;

      private Bot(Node botNode) {

         this.uuid = uuidOf(botNode);

         final Set<File> scriptFiles = new LinkedHashSet<>();
         outgoing(botNode, Relations.SCRIPTS).forEach(scriptRelation -> {

            final Node scriptNode = other(botNode, scriptRelation);

            try {
               File temp = File.createTempFile(getString(scriptNode, AppMotif.Properties.name.name()), ".rive");
               temp.deleteOnExit();
               BufferedWriter out = new BufferedWriter(new FileWriter(temp));
               out.write(getString(scriptNode, Properties.script.name()));
               out.close();

               scriptFiles.add(temp);

            } catch (IOException e1) {
               e1.printStackTrace();
            }
         });

         final SessionManager sessionManager = new ConcurrentHashMapSessionManager();

         final Map<String, String> errors = new LinkedHashMap<>();

         this.bot = new RiveScript(Config.newBuilder()
               .throwExceptions(false)          // Whether exception throwing is enabled
               .strict(true)                    // Whether strict syntax checking is enabled
               .utf8(false)                     // Whether UTF-8 mode is enabled
               .unicodePunctuation("[.,!?;:]")  // The unicode punctuation pattern
               .forceCase(false)                // Whether forcing triggers to lowercase is enabled
               .concat(ConcatMode.NONE)         // The concat mode
               .depth(50)                       // The recursion depth limit
               .sessionManager(sessionManager)  // The session manager for user variables
               .errorMessages(errors)           // Map of custom error messages
               .build());

         for (File scriptFile : scriptFiles)
            bot.loadFile(scriptFile);

         // Sort the replies after loading them!
         bot.sortReplies();
      }

      void chat(String message) {
         currentConversation.append("\n").append(message);
         String reply = bot.reply("user", message);
         currentConversation.append("\n").append(reply);
         botListener.firePropertyChange(uuid.toString(), message, reply);
      }

      String getConversation() {
         return currentConversation.toString();
      }
   }

   private final class ScriptEditor extends JPanel {
      ScriptEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);

         final String text = getString(node.getNode(), Properties.script.name());

         final Color uneditedColor = txtEditor.getBackground();
         final Color editedColor = Color.decode("#fc8d59");

         txtEditor.setText(text);
         txtEditor.setCaretPosition(0);
         txtEditor.addKeyListener(new KeyAdapter() {

            String startText = text;

            public void keyPressed(KeyEvent ke) {

               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  final int oldCaret = txtEditor.getCaretPosition();
                  final String newText = txtEditor.getText().trim();

                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        node.getNode().setProperty(Properties.script.name(), newText);
                        incoming(node.getNode(), Relations.SCRIPTS).forEach(scriptRelation -> {
                           refreshBot(other(node.getNode(), scriptRelation));
                        });
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showException(txtEditor, throwable);
                     }
                  });

                  txtEditor.setCaretPosition(Math.min(newText.length(), Math.max(0, oldCaret)));
                  startText = txtEditor.getText().trim();
                  txtEditor.setBackground(uneditedColor);

               } else {
                  SwingUtilities.invokeLater(() -> txtEditor.setBackground(startText.equals(txtEditor.getText().trim()) ? uneditedColor : editedColor));
               }
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   private final class BotEditor extends JPanel {
      BotEditor(NeoNode botNode) {
         super(new BorderLayout());

         final UUID botUUID = uuidOf(botNode.getNode());

         final JTextField txtInput = new JTextField(30);
         txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                  sessions.get(botUUID).chat(txtInput.getText().trim());
                  txtInput.setText("");
               }
            }
         });

         add(txtInput, BorderLayout.NORTH);

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);
         txtEditor.setText(sessions.get(botUUID).getConversation());

         botListener.addPropertyChangeListener(botEvent -> {
            if (botUUID.toString().equals(botEvent.getPropertyName())) {
               txtEditor.setText(sessions.get(botUUID).getConversation());
               txtEditor.setCaretPosition(txtEditor.getText().length());
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }
}