package com.generator.generators.clojure;

import clojure.main;
import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.neo.NeoModel;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetClientOptions;
import io.vertx.core.net.NetSocket;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import static com.generator.util.NeoUtil.*;

/**
 * Created 16.10.17.
 * <p>
 * https://kimh.github.io/clojure-by-example
 */
public class ClojurePlugin extends ClojureDomainPlugin {
   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ClojurePlugin.class);
   private main replHandle = null;
   private NetSocket socket;
   private final Vertx vertx;
   private ReplManager delegateHandler;

   public ClojurePlugin(App app) {
      super(app);
      vertx = Vertx.vertx();
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      menu.add(new App.TransactionAction("New Repl", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            startRepl();

            fireNodesLoaded(newRepl());
         }
      });

      menu.add(new App.TransactionAction("Form", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Form", app);
            if (name == null || name.length() == 0) return;

            final Node newNode = newForm(name);
            fireNodesLoaded(newNode);
         }
      });
   }

   @Override
   protected void handleRepl(JPopupMenu pop, NeoNode replNode, Set<NeoNode> selectedNodes) {
      if (replHandle == null) {
         pop.add(new App.TransactionAction("Start", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               startRepl();
            }
         });
      }
   }

   @Override
   protected void handleForm(JPopupMenu pop, NeoNode formNode, Set<NeoNode> selectedNodes) {
      if (replHandle != null) {

         final String form = NeoUtil.getString(formNode.getNode(), AppMotif.Properties.name.name());

         pop.add(new App.TransactionAction("Evaluate", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               evaluate(form, new EvaluationHandler() {
                  @Override
                  public void handle(String buffer) {
                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx1) throws Throwable {
                           final Node existingResult = singleOutgoingEVALUATION(formNode.getNode());
                           if (existingResult != null) {
                              setBufferProperty(existingResult, buffer);
                              fireNodeChanged(existingResult);
                           } else {
                              final Node resultNode = newResult(buffer);
                              relateEVALUATION(formNode.getNode(), resultNode);
                              fireNodesLoaded(resultNode);
                           }
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(app, throwable);
                        }
                     });
                  }
               });
            }
         });
      }
   }

   private void evaluate(String form, EvaluationHandler handler) {
      if (delegateHandler == null) {
         delegateHandler = new ReplManager(form, handler);
      } else {
         delegateHandler.evaluate(form, handler);
      }
   }

   private void startRepl() {
      if (replHandle != null) return;
      System.setProperty("clojure.server.repl", "{:port 5555 :accept clojure.core.server/repl}");
      replHandle = new main();
   }

   private class EvaluationHandler implements Handler<String> {

      boolean done() {
         return true;
      }

      @Override
      public void handle(String buffer) {
         log.info("Neo handler :" + buffer);
      }
   }

   private final class ReplManager {

      final NetClientOptions options = new NetClientOptions().
            setConnectTimeout(10000);

      final Stack<EvaluationHandler> delegates = new Stack<>();

      ReplManager(String form, EvaluationHandler handler) {

         final NetClient client = vertx.createNetClient(options);

         client.connect(5555, "localhost", res -> {
            if (res.succeeded()) {
               socket = res.result();
               log.info("Connected to Repl");

               socket.handler(buffer -> {

                  log.info(buffer.toString());

                  if (!delegates.isEmpty() && !buffer.toString().startsWith("user=>")) {
                     final EvaluationHandler stringHandler = delegates.peek();
                     stringHandler.handle(buffer.toString().replaceAll("\nuser=>", ""));
                     if (stringHandler.done()) delegates.pop();
                  }
               });

               evaluate(form, handler);

            } else {
               log.info("Failed to connect: " + res.cause().getMessage());
            }
         });
      }

      void evaluate(String form, EvaluationHandler handler) {
         if (socket == null) throw new IllegalStateException("socket to Repl-server is closed");
         delegates.push(handler);
         log.info("evaluating " + form);
         socket.write(form + "\r\n");
      }
   }

   @Override
   protected JComponent newFormEditor(NeoNode formNode) {
      return new FormEditor(formNode);
   }

   @Override
   protected JComponent newReplEditor(NeoNode replNode) {
      return new ReplEditor(replNode);
   }

   private final class FormEditor extends JPanel {
      FormEditor(NeoNode node) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);

         final Color uneditedColor = txtEditor.getBackground();
         final Color editedColor = Color.decode("#fc8d59");

         final String text = getString(node.getNode(), AppMotif.Properties.name.name());

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
                        node.getNode().setProperty(AppMotif.Properties.name.name(), newText);
                        fireNodeChanged(node, AppMotif.Properties.name.name(), newText);
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

   private final class ReplEditor extends JPanel {

      private final JList<FormNode> historyList = new JList<>();
      private final Stack<FormNode> formNodeStack = new Stack<>();
      private final Set<FormNode> distinctForms = new LinkedHashSet<>();

      final JTextArea txtEditor = new JTextArea();
      final Color uneditedColor = txtEditor.getBackground();
      final Color editedColor = Color.decode("#fc8d59");

      ReplEditor(NeoNode replNode) {
         super(new BorderLayout());

         outgoingFORM(replNode.getNode(), (replFormRelation, formNode) -> {
            final FormNode form = new FormNode(getNameProperty(formNode));
            formNodeStack.push(form);
            distinctForms.add(form);
         });

         final JTextField txtFormLine = new JTextField("");
         txtFormLine.setFont(com.generator.app.AppMotif.getDefaultFont());
         add(txtFormLine, BorderLayout.NORTH);

         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);

         txtEditor.setText("");
         txtEditor.setCaretPosition(0);

         txtFormLine.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                  final String newText = txtFormLine.getText().trim();
                  evaluateCommandLine(newText, replNode);
               }
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);

         historyList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
               final FormNode node = (FormNode) value;
               return super.getListCellRendererComponent(list, node.form, index, isSelected, cellHasFocus);
            }
         });
         historyList.setModel(new FormHistorListModel(formNodeStack));
         historyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

               final int locationToIndex = historyList.locationToIndex(e.getPoint());
               if (locationToIndex == -1) return;

               final FormNode formNode = historyList.getModel().getElementAt(locationToIndex);
               if (formNode == null) return;
               evaluateCommandLine(formNode.form, replNode);
               txtFormLine.setText(formNode.form);
            }
         });
         add(new JScrollPane(historyList), BorderLayout.WEST);
      }

      public void evaluateCommandLine(String newText, NeoNode replNode) {

         if (replHandle == null) startRepl();

         evaluate(newText, new EvaluationHandler() {
            @Override
            public void handle(String buffer) {

               final String[] lines = buffer.split("\n");
               txtEditor.setBackground(uneditedColor);

               final StringBuilder output = new StringBuilder();
               for (String line : lines) {
                  output.append(line).append("\n");

                  if (line.startsWith("CompilerException")) {
                     txtEditor.setBackground(editedColor);

                  } else if (buffer.startsWith("ClassCastException")) {
                     txtEditor.setBackground(editedColor);

                  } else {

                     if (buffer.startsWith("clojure.lang.Symbol")) {

                        SwingUtilities.invokeLater(() -> getGraph().doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx) throws Throwable {
                              relateSYMBOL(replNode.getNode(), newSymbol(newText));
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showException(txtEditor, throwable);
                           }
                        }));

                     } else if (buffer.startsWith("#'")) {

                        // #'user/a

                        // todo add

                     } else {

                        final FormNode newForm = new FormNode(newText);
                        if (!distinctForms.contains(newForm)) {
                           distinctForms.add(newForm);
                           formNodeStack.push(newForm);
                           ((FormHistorListModel) historyList.getModel()).fireContenChanged();

                           SwingUtilities.invokeLater(() -> getGraph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {
                                 relateFORM(replNode.getNode(), newForm(newText));
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showException(txtEditor, throwable);
                              }
                           }));
                        }
                     }
                  }
               }

               txtEditor.setText(output.toString());
               txtEditor.setCaretPosition(0);
            }
         });
      }

      private final class FormHistorListModel extends AbstractListModel<FormNode> {

         private final Stack<FormNode> formStack;

         FormHistorListModel(Stack<FormNode> formStack) {
            this.formStack = formStack;
         }

         void fireContenChanged() {
            fireContentsChanged(this, 0, formStack.size());
         }

         @Override
         public int getSize() {
            return formStack.size();
         }

         @Override
         public FormNode getElementAt(int index) {
            return formStack.get(index);
         }
      }

      private class FormNode {

         final String form;

         FormNode(String form) {
            this.form = form;
         }

         @Override
         public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FormNode that = (FormNode) o;

            return form.equals(that.form);
         }

         @Override
         public int hashCode() {
            return form.hashCode();
         }
      }
   }
}