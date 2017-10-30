package com.generator.generators.csv;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.neo.NeoModel;
import com.generator.util.FileUtil;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.gui.TreeViewer;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.util.NeoUtil.other;
import static com.generator.util.NeoUtil.singleOutgoing;

/**
 * Created 28.10.17.
 */
public class CSVPlugin extends CSVDomainPlugin {

   public CSVPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {
      menu.add(new App.TransactionAction("New CSV", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            final Node newCSV = newCSV(name);
            fireNodesLoaded(newCSV);
         }
      });
   }

   @Override
   protected void handleCSV(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Set Header", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String hdr = SwingUtil.showInputDialog("[column] [column] ...", app);
            if (hdr == null || hdr.length() == 0) return;

            final Node headerNode = newHeader();
            relateHEADER(neoNode.getNode(), headerNode);

            for (String col : hdr.split("[ ]")) {
               final Node column = newColumn(col);
               relateCOLUMN(headerNode, column);
            }

            fireNodesLoaded(headerNode);
         }
      });


      final Relationship headerRelation = singleOutgoing(neoNode.getNode(), Relations.HEADER);
      if (headerRelation != null) {
         pop.add(new App.TransactionAction("Add Row", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Node headerNonde = other(neoNode.getNode(), headerRelation);
               final Map<String, Node> columnMap = new TreeMap<>();
               outgoingCOLUMN(headerNonde, (relationship, columnNode) -> columnMap.put(getName(columnNode), columnNode));

               final Map<String, JTextField> fields = new TreeMap<>();
               final StringBuilder rows = new StringBuilder();
               boolean first = true;
               for (Map.Entry<String, Node> propertyEntry : columnMap.entrySet()) {
                  if (!first) rows.append(",4dlu,");
                  rows.append("pref");
                  fields.put(propertyEntry.getKey(), new JTextField());
                  first = false;
               }

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,75dlu:grow", rows.toString().trim());
               int row = 1;
               for (Map.Entry<String, JTextField> fieldEntry : fields.entrySet()) {
                  editor.addLabel(fieldEntry.getKey(), 1, row);
                  editor.add(fieldEntry.getValue(), 3, row);
                  row += 2;
               }
               editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

               SwingUtil.showDialog(editor.build(), app, "Set Values", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {
                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           final Node newRow = newRow();

                           for (Map.Entry<String, JTextField> fieldEntry : fields.entrySet()) {
                              final Node valueNode = newValue(fieldEntry.getValue().getText().trim());
                              relateVALUE(newRow, valueNode);
                              relateCOLUMN(valueNode, columnMap.get(fieldEntry.getKey()));
                           }

                           relateROW(neoNode.getNode(), newRow);
                           fireNodesLoaded(newRow);
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

         pop.add(new App.TransactionAction("As CSV file", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final File dir = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
               if (dir == null || !dir.exists()) return;

               String filename = SwingUtil.showInputDialog("Filename", app);
               if (filename == null || filename.length() == 0) return;

               filename = filename.toLowerCase().endsWith(".csv") ? filename : (filename + ".csv");

               final File file = FileUtil.tryToCreateFileIfNotExists(new File(dir, filename));

               FileUtil.write(toCSV(neoNode.getNode()), file);
            }
         });

         pop.add(new App.TransactionAction("Add Renderer", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {



               final File dir = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
               if (dir == null || !dir.exists()) return;

               String filename = SwingUtil.showInputDialog("Filename", app);
               if (filename == null || filename.length() == 0) return;

               filename = filename.toLowerCase().endsWith(".csv") ? filename : (filename + ".csv");

               final File file = FileUtil.tryToCreateFileIfNotExists(new File(dir, filename));

               FileUtil.write(toCSV(neoNode.getNode()), file);
            }
         });
      }
   }

   @Override
   protected void handleColumn(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
      pop.add(new App.TransactionAction("Set StringValue", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {




         }
      });
   }

   @Override
   protected JComponent newCSVEditor(NeoNode neoNode) {
      return new CSVEditor(neoNode);
   }

   private final class CSVEditor extends JPanel {
      CSVEditor(NeoNode neoNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);
         txtEditor.setText(toCSV(neoNode.getNode()));

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   public static String toCSV(Node csvNode) {

      final StringBuilder out = new StringBuilder();

      final Relationship headerRelation = singleOutgoing(csvNode, Relations.HEADER);
      if (headerRelation != null) {

         final Node headerNode = other(csvNode, headerRelation);

         final AtomicBoolean first = new AtomicBoolean(true);
         final java.util.List<Node> columns = new ArrayList<>();
         outgoingCOLUMN(headerNode, (relationship, columnNode) -> {
            out.append(first.get() ? "" : ",").append(CSVPlugin.getName(columnNode));
            first.set(false);
            columns.add(columnNode);
         });

         outgoingROW(csvNode, (relationship, rowNode) -> {

            out.append("\n");

            final Map<Node, Node> columnValueMap = new LinkedHashMap<>();
            outgoingVALUE(rowNode, (relationship1, valueNode) -> columnValueMap.put(other(valueNode, NeoUtil.singleOutgoing(valueNode, Relations.COLUMN)), valueNode));

            first.set(true);
            for (Node column : columns) {
               out.append(first.get() ? "" : ",").append(CSVPlugin.getName(columnValueMap.get(column)));
               first.set(false);
            }
         });
      }

      return out.toString();
   }
}